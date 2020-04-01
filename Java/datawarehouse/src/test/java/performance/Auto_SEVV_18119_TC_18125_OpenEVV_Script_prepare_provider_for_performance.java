package performance;

import com.interop.common.constants.utils.RabbitMQUtils;
import com.interop.models.db.staging.ExclusionProviderId;
import com.interop.models.openevv.provider.OpenEvvProviderModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportProviderService;
import com.interop.services.openevv.batch.ImportServices;
import com.jcraft.jsch.SftpException;
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

import static com.interop.common.constants.utils.db.ProviderDBUtils.getExclusionProviderID;

public class Auto_SEVV_18119_TC_18125_OpenEVV_Script_prepare_provider_for_performance extends ImportBaseTest {
    ImportProviderService importProviderService;
    String queueName = "QAAutomation";

    @Test(groups = {"non-regression"})
    public void Import_Provider_In_Exclusion_List() throws InterruptedException, SftpException, IOException, SQLException, InvocationTargetException, IllegalAccessException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, InstantiationException, TimeoutException, NoSuchFieldException {
        importProviderService = new ImportProviderService();

        baseObj.info("Prepare data before starting");
        List<ExclusionProviderId> listExclusionProviderID = getExclusionProviderID();
        importProviderService.generateFileWithMultipleLine(listExclusionProviderID.size());

        List<OpenEvvProviderModel> listProviderInfo = new ArrayList<>();
        for (ExclusionProviderId record : listExclusionProviderID) {
            OpenEvvProviderModel providerInfo = new OpenEvvProviderModel();
            providerInfo.setProviderID(record.getProviderId());
            providerInfo.setProviderName(commons.generateUniqueNumber());
            providerInfo.setAgencyEmail(commons.generateEmailAddress(commons.generateUniqueNumber()));
            listProviderInfo.add(providerInfo);
        }

        baseObj.info("Step 1: Prepare test data");
        importProviderService.initFileImportProviderAndOutboundWithCustomData(listProviderInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        //TODO CLEAR RABBIT MQ BEFORE UPLOAD FILE
        RabbitMQUtils.purseMessage(queueName);
        importProviderService.uploadFileToServer(importProviderService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Verify is Provider Passed OPEN EVV DB table INBOX");
        for (OpenEvvProviderModel line : listProviderInfo) {
            baseObj.info(line.getProviderID());
        }
    }
}
