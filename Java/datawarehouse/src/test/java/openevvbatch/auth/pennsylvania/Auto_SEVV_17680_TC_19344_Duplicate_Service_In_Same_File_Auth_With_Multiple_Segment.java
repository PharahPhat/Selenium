package openevvbatch.auth.pennsylvania;

import com.interop.common.constants.utils.RabbitMQUtils;
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
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;

public class Auto_SEVV_17680_TC_19344_Duplicate_Service_In_Same_File_Auth_With_Multiple_Segment extends ImportBaseTest {
    final String queueName = "QAAutomation";
    ImportAuthService importAuthService;
    STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(stateAccount, 10).get(0);

    @Test(groups = {"non-regression"})
    @QTest(keys = {"TC-19344"})
    public void TC_19344_Duplicate_Service_In_Same_File_Auth_With_Multiple_Segment() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException, SQLException {
        importAuthService = new ImportAuthService();
        String authRefNum = importAuthService.generateAuthRefNumber();

        final List<String> servicesIDLst = new ArrayList<>();//Add list valid services ID for PA state
        servicesIDLst.add("W1725");
        servicesIDLst.add("W1725");
        servicesIDLst.add("W1726");
        servicesIDLst.add("W7058");
        servicesIDLst.add("W7059");

        importAuthService.generateFileWithMultipleLine(5);
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        String isPrimary = "N";
        for (int i = 0; i < importAuthService.getRecords().size(); i++) {
            AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
            authInfo.setClientIdentifier(clientInfo.getMEDICAID_ID().substring(0, 9));
            authInfo.setAuthorizationReferenceNumber(authRefNum);
            authInfo.setProviderID(clientInfo.getPROVIDER_ID());
            authInfo.setClientDiagnosisCode(baseObj.generateRandomNumberObsolete(5));
            authInfo.setAuthorizationServiceID(servicesIDLst.get(i));
            authInfo.setSegmentName("AuthorizationLimit");
            if (i == 4) {
                isPrimary = "Y";
            }
            authInfo.setClientDiagnosisCodeIsPrimary(isPrimary);
            lstAuthInfo.add(authInfo);
        }

        baseObj.info("Step 1: Prepare data to import");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        RabbitMQUtils.purseMessage(queueName);
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3.1: Verify is the file processed successfully");
        runTriggerForSpecificService(EVV_IMPORT_AUTH);//Run trigger to make the service import auth run first

        baseObj.info("Step 3.2: Get all message on rabbitMQ");
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);

        baseObj.info("Step 4: Verify message on rabbitMQ");
        OpenEvvAuthorization bodyOnRabbitMQ = RabbitMQUtils.parseSpecificMessageOnQueueToModel(listMessages, OpenEvvAuthorization.class, authRefNum);

        baseObj.info("Step 5: Verify number element of diagnostic code on rabbitMQ");
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getDiagnosisCode().size(), 0); //Update If segment name = AuthLimit ==> No upload diagnosis code
        Assert.assertEquals(Objects.requireNonNull(bodyOnRabbitMQ).getAuthorizationLimit().size(), importAuthService.getRecords().size() - 1);
    }
}
