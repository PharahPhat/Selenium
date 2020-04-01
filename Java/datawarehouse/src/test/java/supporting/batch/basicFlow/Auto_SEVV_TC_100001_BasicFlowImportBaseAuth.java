package supporting.batch.basicFlow;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.inbox.InboxAuthorization;
import com.interop.models.db.staging.StagingAuth;
import com.interop.models.db.staging.StagingAuthLimit;
import com.interop.models.db.stx.STXClientAuth;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportAuthService;
import com.interop.services.openevv.batch.ImportServices;
import com.jcraft.jsch.SftpException;
import com.sandata.batch.models.api.authorization.AuthorizationModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.TimeoutException;

import static com.interop.common.constants.utils.TriggerUtils.runTriggerForSpecificService;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_AUTH;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.MATCHING_SERVICE;
import static com.interop.common.constants.utils.db.AuthDBUtils.*;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;
import static com.interop.common.constants.FieldConstants.*;
import static com.sandata.utilities.sftp.utils.SftpUtils.sftpSendFile;

public class Auto_SEVV_TC_100001_BasicFlowImportBaseAuth extends ImportBaseTest {
    ImportAuthService importAuthService;

    @Test(groups = {"non-regression"})
    public void BasicFlowImportAuth() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        importAuthService = new ImportAuthService();
        final String queueName = "QAAutomation";

        String authRefNum = importAuthService.generateAuthRefNumber();
        STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 10).get(0);
        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_folder_Get_Error_SFTP"));

        final List<String> servicesIDLst = new ArrayList<>();//Add list valid services ID for PA state
        servicesIDLst.add("W1725");
        servicesIDLst.add("W1724");
        servicesIDLst.add("W1726");
        servicesIDLst.add("W7058");
        servicesIDLst.add("W7059");

        importAuthService.generateFileWithMultipleLine(5);
        List<Map<Field, String>> lstAuthInfo = new ArrayList<>();
        for (int i = 0; i < importAuthService.getRecords().size(); i++) {
            Map<Field, String> authInfo = new HashMap<>();
            authInfo.put(AuthorizationCSVModel.class.getField(CLIENT_IDENTIFIER), clientInfo.getMEDICAID_ID().substring(0, 9));
            authInfo.put(AuthorizationCSVModel.class.getField(AUTHORIZATION_REFERENCE_NUMBER), authRefNum);
            authInfo.put(AuthorizationCSVModel.class.getField(PROVIDER_ID), clientInfo.getPROVIDER_ID());
            authInfo.put(AuthorizationCSVModel.class.getField(CLIENT_DIAGNOSIS_CODE), baseObj.generateRandomNumberObsolete(10));
            authInfo.put(AuthorizationCSVModel.class.getField(AUTHORIZATION_SERVICE_ID), servicesIDLst.get(i));
            lstAuthInfo.add(authInfo);
        }
        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        RabbitMQUtils.purseMessage(queueName);//Purse the message on rabbitMQ to avoid trash data
        String fileNameAuth = null;
        for (File file : importAuthService.getListFileUpload()) {
            sftpSendFile(file.getPath(), getDstPath());
            if (file.getName().contains("DXCPA_EVV_PriorAuth"))
                fileNameAuth = file.getName();
        }

        baseObj.info("Step 3.1: Verify is the file processed successfully");
        runTriggerForSpecificService(EVV_IMPORT_AUTH);//Run trigger to make the service import auth run first
        boolean isFileProcessed = importAuthService.isTheFileImportProcessed(fileNameAuth);
        Assert.assertTrue(isFileProcessed, "The file does not processed successfully");

        baseObj.info("Step 3.2: Get all message on rabbitMQ");
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);

        baseObj.info("Step 4: Verify in staging DB");
        runTriggerForSpecificService(MATCHING_SERVICE);//Run trigger to make the service import auth run first
        List<StagingAuth> authRecordsStaging = getStagingAuthorization(authRefNum);

        baseObj.info("Step 4.1: Verify in staging DB Auth");
        String tranGUID = null;
        for (StagingAuth authRecordStaging : authRecordsStaging) {
            tranGUID = authRecordStaging.getAccount_intf_trans_guid().toString();
            AuthorizationCSVModel line = (AuthorizationCSVModel) importAuthService.getRecords().get(0);
            Assert.assertEquals(line.getClientDiagnosisCode(), authRecordStaging.getDx_code());
            Assert.assertEquals(line.getClientDiagnosisCodeIsPrimary(), authRecordStaging.getDx_code_prmy_ind());
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
        Assert.assertEquals(numberRecordsInDB, 5);

        baseObj.info("Step 5: Verify ERROR CODE in INBOX EVV");
        List<InboxAuthorization> authRecords = getInboxAuthorization(authRefNum);
        for (InboxAuthorization record : authRecords) {
            Assert.assertEquals(record.getERROR_CODE(), "0 Operation success");
        }

        baseObj.info("Step 6: Verify message on rabbitMQ");
        AuthorizationModel bodyOnRabbitMQ = RabbitMQUtils.parseSpecificMessageOnQueueToModel(listMessages, AuthorizationModel.class, authRefNum);

        baseObj.info("Step 7: Verify number element of diagnostic code on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getDiagnosisCode().size(), importAuthService.getRecords().size());
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getAuthorizationLimit().size(), importAuthService.getRecords().size());
    }
}
