package openevvbatch.auth.pennsylvania;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.inbox.InboxAuthorization;
import com.interop.models.db.staging.StagingAuth;
import com.interop.models.db.staging.StagingAuthLimit;
import com.interop.models.db.stx.STXAuthorization;
import com.interop.models.db.stx.STXClientAuth;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportAuthService;
import com.interop.services.openevv.batch.ImportServices;
import com.jcraft.jsch.SftpException;
import com.interop.models.openevv.authorization.OpenEvvAuthorization;
import com.sandata.qtest.QTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

import static com.interop.common.constants.utils.TriggerUtils.runTriggerForSpecificService;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_AUTH;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.MATCHING_SERVICE;
import static com.interop.common.constants.utils.db.AuthDBUtils.*;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;

public class Auto_SEVV_15937_TC_20967_20974_Import_Single_Primary_Diagnosis_Code extends ImportBaseTest {
    ImportAuthService importAuthService;
    String queueName = "QAAutomation";
    STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 10).get(0);

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-20967", "TC-20974"})
    public void TC_20967_20974_Import_Single_Primary_Diagnosis_Code() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        importAuthService = new ImportAuthService();

        String authRefNum = importAuthService.generateAuthRefNumber();

        String diagnosisCode = baseObj.generateRandomNumberObsolete(5);
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
        authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID().substring(0, 9));
        authInfo.setAuthorizationReferenceNumber(authRefNum);
        authInfo.setProviderID(clientInfo.getPROVIDER_ID());
        authInfo.setClientDiagnosisCode(diagnosisCode);
        authInfo.setClientDiagnosisCodeIsPrimary("Y");
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        RabbitMQUtils.purseMessage(queueName);//Purse the message on rabbitMQ to avoid trash data
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Get File on RabbitMQ");
        runTriggerForSpecificService(EVV_IMPORT_AUTH);//Run trigger to make the service import auth run first
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);

        baseObj.info("Step 4: Verify in staging DB");
        runTriggerForSpecificService(MATCHING_SERVICE);//Run trigger to make the service import auth run first
        List<StagingAuth> authRecordsStaging = getStagingAuthorization(authRefNum);

        baseObj.info("Step 4.1: Verify in staging DB Auth");
        String tranGUID = null;
        for (StagingAuth authRecordStaging : authRecordsStaging) {
            tranGUID = authRecordStaging.getAccount_intf_trans_guid().toString();
            Assert.assertEquals(importAuthService.convertInputtedDXCodeToICD10Standard(authInfo.getClientDiagnosisCode(), 3), authRecordStaging.getDx_code());
            Assert.assertEquals(authInfo.getClientDiagnosisCodeIsPrimary(), authRecordStaging.getDx_code_prmy_ind());
        }

        baseObj.info("Step 4.2: Verify in staging DB Auth Limit");
        List<StagingAuthLimit> authLimitRecords = getStagingAuthLimit(tranGUID);
        int numberRecordsInDB = 0;
        for (StagingAuthLimit authLimitRecord : authLimitRecords) {
            for (Object csvLine : importAuthService.getRecords()) {
                AuthorizationCSVModel line = (AuthorizationCSVModel) csvLine;
                if (line.getAuthorizationServiceID().equalsIgnoreCase(authLimitRecord.getService().toString())) {
                    numberRecordsInDB++;
                }
            }
        }
        Assert.assertEquals(numberRecordsInDB, importAuthService.getRecords().size());

        baseObj.info("Step 5: Verify ERROR CODE in INBOX EVV");
        List<InboxAuthorization> authRecords = getInboxAuthorization(authRefNum);
        for (InboxAuthorization record : authRecords) {
            Assert.assertEquals(record.getERROR_CODE(), "0 Operation success");
        }

        baseObj.info("Step 6: Verify message on rabbitMQ");
        OpenEvvAuthorization bodyOnRabbitMQ = RabbitMQUtils.parseSpecificMessageOnQueueToModel(listMessages, OpenEvvAuthorization.class, authRefNum);

        baseObj.info("Step 7: Verify number element of diagnostic code on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getDiagnosisCode().size(), importAuthService.getRecords().size());

        baseObj.info("Step 8: Verify ERROR CODE in STX EVV");
        List<STXAuthorization> authSTXRecords = getSTXAuthorization(authRefNum);
        for (STXAuthorization record : authSTXRecords) {
            Assert.assertEquals(record.getDIAGNOSIS_CODE().toString(), importAuthService.convertInputtedDXCodeToICD10Standard(diagnosisCode, 3));
        }
    }
}
