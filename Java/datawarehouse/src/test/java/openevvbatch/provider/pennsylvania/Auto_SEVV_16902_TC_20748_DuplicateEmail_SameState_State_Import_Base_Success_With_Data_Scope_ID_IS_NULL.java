package openevvbatch.provider.pennsylvania;

import com.interop.models.db.inbox.InboxProvider;
import com.interop.models.db.stx.STXAppUser;
import com.interop.models.openevv.provider.OpenEvvProviderModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportProviderService;
import com.interop.services.openevv.batch.ImportServices;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.utils.TriggerUtils.runTriggerForSpecificService;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_PROVIDER;
import static com.interop.common.constants.utils.db.ProviderDBUtils.*;


public class Auto_SEVV_16902_TC_20748_DuplicateEmail_SameState_State_Import_Base_Success_With_Data_Scope_ID_IS_NULL extends ImportBaseTest {
    ImportProviderService importProviderService;

    @Test(groups = {"non-regression"})
    public void DuplicateEmail_SameState_State_Import_Success_With_Data_Scope_ID_IS_NULL() throws Exception {
        STXAppUser existedJVAdmin = getRecordJVAdminOfSpecificState(AccountTemplate.PENNSYLVANIA).get(0);
        String username = existedJVAdmin.getUSERNAME().toString();

        importProviderService = new ImportProviderService();
        String providerID = importProviderService.generateProviderID();
        baseObj.info("Prepare test data");
        importProviderService = new ImportProviderService();
        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_folder_Get_Error_SFTP"));

        baseObj.info("Prepare data before starting");
        List<OpenEvvProviderModel> listProviderInfo = new ArrayList<>();
        OpenEvvProviderModel providerInfo = new OpenEvvProviderModel();
        providerInfo.setProviderID(providerID);
        providerInfo.setAgencyEmail(username);
        listProviderInfo.add(providerInfo);

        baseObj.info("Step 1: Prepare test data");
        importProviderService.initFileImportProviderAndOutboundWithCustomData(listProviderInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        importProviderService.uploadFileToServer(importProviderService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Verify is Provider Passed OPEN EVV DB table INBOX");
        runTriggerForSpecificService(EVV_IMPORT_PROVIDER);
        List<InboxProvider> providerInInbox = getRecordProviderInbox(providerID.substring(0, 9));
        Assert.assertEquals("0 Operation success", providerInInbox.get(0).getERROR_CODE());

        baseObj.info("Step 4: Verify app user data");
        List<STXAppUser> stxAppUserList = getSTXAppUser(username, String.valueOf(providerInInbox.get(0).getACCOUNT()));
        for (STXAppUser record : stxAppUserList) {
            if (record.getUSERNAME().toString().equalsIgnoreCase(username))
                Assert.assertNull(record.getDATA_SCOPE_ID());
        }
    }
}
