package openevvbatch.provider.regression;

import com.interop.common.constants.utils.PGPUtils;
import com.interop.models.db.stx.STXAppUser;
import com.interop.models.db.stx.STXProvider;
import com.interop.models.openevv.provider.OpenEvvProviderModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportProviderService;
import com.interop.services.openevv.batch.ImportServices;
import com.jcraft.jsch.SftpException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.Constant.PATH_PUBLIC_KEY;
import static com.interop.common.constants.utils.db.ProviderDBUtils.*;

public class Auto_SEVV_TC_29000_Import_Base_Provider_For_Indiana extends ImportBaseTest {
    ImportProviderService importProviderService;

    @Test(groups = {"non-regression"})
    public void Import_Provider_For_Indiana() throws InterruptedException, SftpException, IOException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        importProviderService = new ImportProviderService();

        baseObj.info("Prepare data before starting");
        String providerID = importProviderService.generateProviderID();
        String email = baseObj.generateRandomNumberObsolete(10) + "@mailinator.com";

        List<OpenEvvProviderModel> listProviderInfo = new ArrayList<>();
        OpenEvvProviderModel providerInfo = new OpenEvvProviderModel();
        providerInfo.setProviderID(providerID);
        providerInfo.setPayerID(ImportServices.config.getEnvironment("defaultPayerID"));
        providerInfo.setProviderName("Automation" + providerID);
        providerInfo.setAgencyEmail(email);
        listProviderInfo.add(providerInfo);

        baseObj.info("Step 1: Prepare test data");
        importProviderService.initFileImportProviderAndOutboundWithCustomData(listProviderInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        //Clean up queue before upload file
        List<File> uploadFile = new ArrayList<>();
        for (File file : importProviderService.getListFileCSV()) {
            PGPUtils.encryptFile(file.getPath() + ".gpg", file.getPath(), PATH_PUBLIC_KEY, false, false, 2);
            uploadFile.add(new File(file.getPath() + ".gpg"));
        }

        importProviderService.uploadFileToServer(uploadFile, ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Verify is Provider Passed OPEN EVV DB table INBOX");
        isProviderStoredToINBOXWithoutError(providerID);

        baseObj.info("Step 4: Verify data in STX table");
        List<STXProvider> providerInfoInSTX = getRecordProviderSTX(providerID);
        Assert.assertEquals(providerInfoInSTX.get(0).getPROVIDER_ID(), providerID);

        baseObj.info("Step 5: Verify data in STX APP user");
        List<STXAppUser> appUsers = getSTXAppUser(email, String.valueOf(providerInfoInSTX.get(0).getACCOUNT()));
        Assert.assertEquals(email, appUsers.get(0).getUSERNAME());
    }
}
