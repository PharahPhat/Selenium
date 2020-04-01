package openevvbatch.auth.pennsylvania;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.inbox.InboxAuthorization;
import com.interop.models.db.staging.StagingAuth;
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

public class Auto_SEVV_15937_TC_20968_Import_Base_Multiple_With_One_Primary_Diagnosis_Code extends ImportBaseTest {
    ImportAuthService importAuthService;
    String queueName = "QAAutomation";
    STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 10).get(0);

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-20968"})
    public void TC_20968_Import_Multiple_With_One_Primary_Diagnosis_Code() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        importAuthService = new ImportAuthService();
        String authRefNum = importAuthService.generateAuthRefNumber();

        final List<String> servicesIDLst = new ArrayList<>();//Add list valid services ID for PA state
        servicesIDLst.add("W7058");
        servicesIDLst.add("W7059");
        servicesIDLst.add("W7061");

        importAuthService.generateFileWithMultipleLine(3);
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        for (int i = 0; i < importAuthService.getRecords().size(); i++) {
            AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
            authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID().substring(0, 9));
            authInfo.setAuthorizationReferenceNumber(authRefNum);
            authInfo.setProviderID(clientInfo.getPROVIDER_ID());
            authInfo.setClientDiagnosisCode(baseObj.generateRandomNumberObsolete(5));
            authInfo.setAuthorizationServiceID(servicesIDLst.get(i));
            if (i == 1 || i == 0)
                authInfo.setClientDiagnosisCodeIsPrimary("N");
            lstAuthInfo.add(authInfo);
        }
        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        RabbitMQUtils.purseMessage(queueName);//Purse the message on rabbitMQ to avoid trash data
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Get all message on rabbitMQ");
        runTriggerForSpecificService(EVV_IMPORT_AUTH);//Run trigger to make the service import auth run first
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);

        baseObj.info("Step 4: Verify in staging DB");
        runTriggerForSpecificService(MATCHING_SERVICE);//Run trigger to make the service import auth run first
        List<StagingAuth> authRecordsStaging = getStagingAuthorization(authRefNum);

        baseObj.info("Step 4.1: Verify in staging DB Auth");
        for (StagingAuth authRecordStaging : authRecordsStaging) {
            AuthorizationCSVModel line = (AuthorizationCSVModel) importAuthService.getRecords().get(2);
            Assert.assertEquals(authRecordStaging.getDx_code(), importAuthService.convertInputtedDXCodeToICD10Standard(line.getClientDiagnosisCode(), 3));
            Assert.assertEquals(authRecordStaging.getDx_code_prmy_ind(), line.getClientDiagnosisCodeIsPrimary());
        }

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
            AuthorizationCSVModel line = (AuthorizationCSVModel) importAuthService.getRecords().get(2);
            Assert.assertEquals(record.getDIAGNOSIS_CODE().toString(), importAuthService.convertInputtedDXCodeToICD10Standard(line.getClientDiagnosisCode(), 3));
        }
    }
}
