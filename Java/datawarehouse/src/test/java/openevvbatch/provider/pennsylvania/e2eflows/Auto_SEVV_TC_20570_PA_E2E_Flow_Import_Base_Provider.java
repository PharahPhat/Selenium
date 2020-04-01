package openevvbatch.provider.pennsylvania.e2eflows;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.stx.STXProvider;
import com.interop.models.openevv.provider.OpenEvvProviderModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportProviderService;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static com.interop.common.constants.utils.db.ProviderDBUtils.*;

public class Auto_SEVV_TC_20570_PA_E2E_Flow_Import_Base_Provider extends ImportBaseTest {
    ImportProviderService importProviderService;


    @Test(groups = {"regression"})
    @QTest(keys = {"TC-20582"})
    public void End_To_End_Flow_Import_Provider_For_PA() throws InterruptedException, SftpException, IOException, SQLException, InvocationTargetException, IllegalAccessException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, InstantiationException, TimeoutException, NoSuchFieldException {
        importProviderService = new ImportProviderService();

        baseObj.info("Prepare data before starting");
        String providerID = importProviderService.generateProviderID();
        final String queueName = "QAAutomation";

        List<OpenEvvProviderModel> listProviderInfo = new ArrayList<>();
        OpenEvvProviderModel providerInfo = new OpenEvvProviderModel();
        providerInfo.setProviderID(providerID);
        providerInfo.setAgencyEmail(providerID + "@mailinator.com");
        listProviderInfo.add(providerInfo);

        baseObj.info("Step 1: Prepare test data");
        importProviderService.initFileImportProviderAndOutboundWithCustomData(listProviderInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        //Clean up queue before upload file
        RabbitMQUtils.purseMessage("QAAutomation");
        importProviderService.uploadFileToServer(importProviderService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Verify is Provider Passed OPEN EVV DB table INBOX");
        isProviderStoredToINBOXWithoutError(providerID.substring(0, 9));
        List<STXProvider> providerInfoInSTX = getRecordProviderSTX(providerID.substring(0, 9));
        Assert.assertEquals(providerID.substring(0, 9), providerInfoInSTX.get(0).getPROVIDER_ID());

        baseObj.info("Step 4: Check is the message store on RabbitMQ");
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);
        OpenEvvProviderModel bodyOnRabbitMQ = new OpenEvvProviderModel();
        bodyOnRabbitMQ = RabbitMQUtils.parseSpecificMessageOnQueueToModel(listMessages, bodyOnRabbitMQ.getClass(), providerID);
        OpenEvvProviderModel bodyInImportedFile = (OpenEvvProviderModel) importProviderService.getRecords().get(0);
        Assert.assertTrue(bodyInImportedFile.equals(bodyOnRabbitMQ));

        baseObj.info("Step 5: Verify is Provider Passed AMP DB");
        String agencyID = getAgencyIDInAMPDB(providerID);
        String ampDB = getAgencyDBInAMPDB(agencyID);
        baseObj.info("Step 6: Verify basic AMP configuration for new provider");
        verifyBasicAMPConfiguration(ampDB);

        baseObj.info("Step 7: Verify configuration of AMP and OPEN EVV for new provider");
        verifyOpenAndSantraxConfiguration(ampDB);

        baseObj.info("Step 8: Verify telephony configuration for new provider");
        verifyTelephonyConfiguration(ampDB);
    }

}
