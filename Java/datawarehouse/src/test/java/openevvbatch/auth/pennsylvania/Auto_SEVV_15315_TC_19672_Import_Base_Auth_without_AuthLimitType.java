package openevvbatch.auth.pennsylvania;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.common.constants.utils.TriggerUtils;
import com.interop.models.openevv.TransformerModelAuthorization;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class Auto_SEVV_15315_TC_19672_Import_Base_Auth_without_AuthLimitType extends ImportBaseTest {
    ImportAuthService importAuthService;
    String queueName = "QAAutomation";


    @Test(groups = {"regression"})
    @QTest(keys = {"TC-19672"})
    public void Import_Auth_without_AuthLimitType() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException {
        importAuthService = new ImportAuthService();
        String clientOtherID = String.valueOf(baseObj.intRandom(9));

        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
        authInfo.setClientIdentifier(clientOtherID);
        authInfo.setAuthorizationReferenceNumber(importAuthService.generateAuthRefNumber());
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare test data");
        List<String> modifiedHeader = importAuthService.getCsvHeaders();
        modifiedHeader.remove("authorizationLimitType");
        importAuthService.setCsvHeaders(modifiedHeader);
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        RabbitMQUtils.purseMessage(queueName);
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_AUTH);

        baseObj.info("Step 3: Check is the message store on RabbitMQ");
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);

        baseObj.info("Step 4: Verify message on queue with import file");
        OpenEvvAuthorization bodyOnRabbitMQ = OpenEvvAuthorization.builder().build();
        bodyOnRabbitMQ = RabbitMQUtils.parseSpecificMessageOnQueueToModel(listMessages, bodyOnRabbitMQ.getClass(), clientOtherID);
        OpenEvvAuthorization bodyInImportedFile = new TransformerModelAuthorization().convertFromModelCSVToAPI((AuthorizationCSVModel) importAuthService.getRecords().get(0));
        Assert.assertTrue(bodyInImportedFile.equals(bodyOnRabbitMQ));
    }
}
