package openevvbatch.provider.pennsylvania;

import com.interop.common.constants.utils.db.ProviderDBUtils;
import com.interop.models.db.inbox.InboxProvider;
import com.interop.models.db.stx.STXAppUser;
import com.interop.models.openevv.provider.OpenEvvProviderModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportProviderService;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.utils.TriggerUtils.runTriggerForSpecificService;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_PROVIDER;
import static com.interop.common.constants.utils.db.ProviderDBUtils.getRecordJVAdminOfSpecificState;
import static com.interop.common.constants.utils.db.ProviderDBUtils.getRecordProviderInbox;

public class Auto_SEVV_16902_TC_20743_DuplicateEmail_Different_DataScopeID_Different_State_Fail_to_import_Base_and_Error_messages_displays extends ImportBaseTest {
    ImportProviderService importProviderService;
    STXAppUser existedJVAdmin = getRecordJVAdminOfSpecificState(ProviderDBUtils.AccountTemplate.MOLINA).get(0);

    @Test(groups = {"non-regression"})
    public void DuplicateEmail_Different_DataScopeID_Different_State_Fail_to_import_and_Error_messages_displays() throws Exception {
        importProviderService = new ImportProviderService();
        String providerID = importProviderService.generateProviderID();
        baseObj.info("Prepare test data");
        importProviderService = new ImportProviderService();

        baseObj.info("Prepare data before starting");
        List<OpenEvvProviderModel> listProviderInfo = new ArrayList<>();
        OpenEvvProviderModel providerInfo = new OpenEvvProviderModel();
        providerInfo.setProviderID(providerID);
        providerInfo.setAgencyEmail((String) existedJVAdmin.getUSERNAME());
        listProviderInfo.add(providerInfo);

        baseObj.info("Step 1: Prepare test data");
        importProviderService.initFileImportProviderAndOutboundWithCustomData(listProviderInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        importProviderService.uploadFileToServer(importProviderService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Download Error file");
        String errorFile = importProviderService.generateErrorFileName(ImportServices.ImportType.PROVIDER.getFileType(), importProviderService.getListFileUpload());
        runTriggerForSpecificService(EVV_IMPORT_PROVIDER);
        importProviderService.downloadSpecificFileFromSFTPForOpenEVV(errorFile, SftpUtils.FileType.ZIP);

        baseObj.info("Step 5: Verify Error Code in file error with the expectation");
        ImportServices.verifyErrorMessageForTheSingleRecord("Error user exists for different Aggregator", errorFile);

        baseObj.info("Step 6: Verify is Provider Passed OPEN EVV DB table INBOX");
        List<InboxProvider> dataDBInbox = getRecordProviderInbox(providerID.substring(0, 9));
        Assert.assertEquals("-1812 Error user exists for different Aggregator", dataDBInbox.get(0).getERROR_CODE().toString());
    }
}
