package openevvbatch.provider.pennsylvania;

import com.interop.models.openevv.provider.OpenEvvProviderModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportProviderService;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Auto_SEVV_17459_TC_39299_Import_Base_multi_valid_providers_that_shared_first_9Digit extends ImportBaseTest {
    ImportProviderService importProviderService;

    @Test(groups = {"non-regression"})
    public void TC_39299_Import_multi_valid_providers_that_shared_first_9digit() throws Exception {
        String providerID = baseObj.generateRandomNumberObsolete(9);
        importProviderService = new ImportProviderService();
        importProviderService.generateFileWithMultipleLine(2);

        baseObj.info("Prepare data before starting");
        List<OpenEvvProviderModel> listProviderInfo = new ArrayList<>();

        OpenEvvProviderModel providerInfo1 = new OpenEvvProviderModel();
        providerInfo1.setProviderID(providerID);

        OpenEvvProviderModel providerInfo2 = new OpenEvvProviderModel();
        providerInfo2.setProviderID(providerID + baseObj.generateRandomNumberObsolete(4));

        listProviderInfo.add(providerInfo1);
        listProviderInfo.add(providerInfo2);

        baseObj.info("Step 1: Prepare test data");
        importProviderService.initFileImportProviderAndOutboundWithCustomData(listProviderInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        //Clean up queue before upload file
        importProviderService.uploadFileToServer(importProviderService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        String inboundFileName = importProviderService.generateInboundFileName(ImportServices.ImportType.OUTBOUND.getFileType(), importProviderService.getListFileCSV());

        baseObj.info("Step 3: Download Inbound file");
        importProviderService.downloadSpecificFileFromSFTPForOpenEVV(inboundFileName, SftpUtils.FileType.CSV);

        baseObj.info("Step 4: Verify failed record count");
        importProviderService.verifyRecordCountInboundFile("2", "0", inboundFileName);
    }
}


