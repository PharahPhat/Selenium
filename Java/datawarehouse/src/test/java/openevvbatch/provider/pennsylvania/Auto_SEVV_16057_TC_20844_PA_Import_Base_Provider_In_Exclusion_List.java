package openevvbatch.provider.pennsylvania;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.staging.ExclusionProviderId;
import com.interop.models.openevv.provider.OpenEvvProviderModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportProviderService;
import com.interop.services.openevv.batch.ImportServices;
import com.jcraft.jsch.SftpException;
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

import static com.interop.common.constants.utils.db.ProviderDBUtils.getExclusionProviderID;
import static com.interop.common.constants.utils.db.ProviderDBUtils.isProviderStoredToINBOXWithoutError;

public class Auto_SEVV_16057_TC_20844_PA_Import_Base_Provider_In_Exclusion_List extends ImportBaseTest {
    ImportProviderService importProviderService;
    String queueName = "QAAutomation";

    @Test(groups = {"non-regression"})
    public void Import_Provider_In_Exclusion_List() throws InterruptedException, SftpException, IOException, SQLException, InvocationTargetException, IllegalAccessException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, InstantiationException, TimeoutException, NoSuchFieldException {
        importProviderService = new ImportProviderService();

        baseObj.info("Prepare data before starting");
        List<ExclusionProviderId> providerID = getExclusionProviderID();

        List<OpenEvvProviderModel> listProviderInfo = new ArrayList<>();
        OpenEvvProviderModel providerInfo = new OpenEvvProviderModel();
        providerInfo.setProviderID(providerID.get(0).getProviderId());
        listProviderInfo.add(providerInfo);

        baseObj.info("Step 1: Prepare test data");
        importProviderService.initFileImportProviderAndOutboundWithCustomData(listProviderInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        //TODO CLEAR RABBIT MQ BEFORE UPLOAD FILE
        RabbitMQUtils.purseMessage(queueName);
        importProviderService.uploadFileToServer(importProviderService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Verify is Provider Passed OPEN EVV DB table INBOX");
        isProviderStoredToINBOXWithoutError(Objects.requireNonNull(providerID.get(0).getProviderId()).substring(0, 9));

        baseObj.info("Step 4: Check is the message store on RabbitMQ");
        List<String> listMessages = RabbitMQUtils.getMessagesFromQueue(queueName);
        Assert.assertFalse(listMessages.contains(providerID), "The message is pushed to rabbitMQ");
    }
}
