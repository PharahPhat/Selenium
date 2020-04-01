package openevvbatch.auth.pennsylvania;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.openevv.TransformerModelAuthorization;
import com.interop.models.openevv.authorization.OpenEvvAuthorization;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportAuthService;
import com.interop.services.openevv.batch.ImportServices;
import com.jcraft.jsch.SftpException;
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

import static com.interop.common.constants.utils.TriggerUtils.runTriggerForSpecificService;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_AUTH;

public class Auto_SEVV_15315_TC_19673_Import_Base_Auth_with_AuthLimitType_is_N extends ImportBaseTest {
    ImportAuthService importAuthService;
    String queueName = "QAAutomation";

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-19673"})
    public void Import_Auth_with_AuthLimitType_is_N() throws IOException, InterruptedException, SftpException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, TimeoutException, NoSuchFieldException {
        importAuthService = new ImportAuthService();
        String clientOtherID = String.valueOf(baseObj.intRandom(9));

        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        AuthorizationCSVModel authInfo = new AuthorizationCSVModel();
        authInfo.setClientIdentifier(clientOtherID);
        authInfo.setAuthorizationReferenceNumber(importAuthService.generateAuthRefNumber());
        lstAuthInfo.add(authInfo);

        baseObj.info("Step 1: Prepare test data");
        importAuthService.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);
        RabbitMQUtils.purseMessage(queueName);

        baseObj.info("Step 2: Upload file to SFTP server");
        importAuthService.uploadFileToServer(importAuthService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Check is the message store on RabbitMQ");
        runTriggerForSpecificService(EVV_IMPORT_AUTH);
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);

        baseObj.info("Step 4: Verify message on queue with import file");
        OpenEvvAuthorization bodyOnRabbitMQ = OpenEvvAuthorization.builder().build();
        bodyOnRabbitMQ = RabbitMQUtils.parseSpecificMessageOnQueueToModel(listMessages, bodyOnRabbitMQ.getClass(), clientOtherID);
        OpenEvvAuthorization bodyInImportedFile = new TransformerModelAuthorization().convertFromModelCSVToAPI((AuthorizationCSVModel) importAuthService.getRecords().get(0));
        Assert.assertTrue(bodyInImportedFile.equals(bodyOnRabbitMQ));
    }
}
