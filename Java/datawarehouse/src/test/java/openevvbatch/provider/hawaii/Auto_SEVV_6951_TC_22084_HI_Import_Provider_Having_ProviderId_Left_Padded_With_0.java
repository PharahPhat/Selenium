package openevvbatch.provider.hawaii;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.common.constants.utils.TriggerUtils;
import com.interop.models.db.stx.STXAppUser;
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

public class Auto_SEVV_6951_TC_22084_HI_Import_Provider_Having_ProviderId_Left_Padded_With_0 extends ImportBaseTest {
    ImportProviderService importProviderService;

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-22084"})
    public void TC_HI_Import_Provider_Having_ProviderId_Left_Padded_With_0() throws InterruptedException, SftpException, IOException, SQLException, InvocationTargetException, IllegalAccessException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, InstantiationException, TimeoutException, NoSuchFieldException {
        importProviderService = new ImportProviderService();

        baseObj.info("Prepare data before starting");
        String providerID = "00" + commons.generateRandomNumberOfFixLength(4);
        final String queueName = "QAAutomation";

        List<OpenEvvProviderModel> listProviderInfo = new ArrayList<>();
        OpenEvvProviderModel providerInfo = new OpenEvvProviderModel();
        providerInfo.setProviderID(providerID);
        providerInfo.setProviderName("KMS AUTO" + providerID);
        providerInfo.setAddressState("HI");
        providerInfo.setCounty("08 Molokai");
        providerInfo.setPayerID("PDASD");
        providerInfo.setProviderRequireAuth("1");
        providerInfo.setAgencyEmail(commons.generateEmailAddress(providerID));
        listProviderInfo.add(providerInfo);

        baseObj.info("Step 1: Prepare test data");
        importProviderService.initFileImportProviderAndOutboundWithCustomData(listProviderInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        RabbitMQUtils.purseMessage(queueName);        //Clean up queue before upload file
        importProviderService.uploadFileToServer(importProviderService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_PROVIDER);

        baseObj.info("Step 3: Verify is Provider Passed OPEN EVV DB table INBOX");
        isProviderStoredToINBOXWithoutError(providerID);
        List<STXProvider> providerInfoInSTX = getRecordProviderSTX(providerID);
        Assert.assertEquals(providerID, providerInfoInSTX.get(0).getPROVIDER_ID());

        baseObj.info("Step 4: Check is the message store on RabbitMQ");
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);
        OpenEvvProviderModel bodyOnRabbitMQ = new OpenEvvProviderModel();
        bodyOnRabbitMQ = RabbitMQUtils.parseSpecificMessageOnQueueToModel(listMessages, bodyOnRabbitMQ.getClass(), providerID);
        OpenEvvProviderModel bodyInImportedFile = (OpenEvvProviderModel) importProviderService.getRecords().get(0);
        Assert.assertEquals(bodyOnRabbitMQ, bodyInImportedFile);

        baseObj.info("Step 5: Verify STX App user");
        List<STXAppUser> listAppUser = getSTXAppUser(providerInfo.getAgencyEmail(), String.valueOf(providerInfoInSTX.get(0).getACCOUNT()));
        listAppUser.addAll(getSTXAppUser(providerInfo.getAgencyEmail(), "9999"));
        Assert.assertEquals(listAppUser.size(), 2);
        baseObj.info(String.valueOf(listAppUser));
    }
}
