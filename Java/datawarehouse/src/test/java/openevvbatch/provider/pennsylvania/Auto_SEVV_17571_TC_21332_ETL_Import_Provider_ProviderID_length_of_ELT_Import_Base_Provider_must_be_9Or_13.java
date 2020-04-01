package openevvbatch.provider.pennsylvania;

import com.interop.models.db.inbox.InboxProvider;
import com.interop.models.openevv.provider.OpenEvvProviderModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportProviderService;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.utilities.CSVReader;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.Constant.DOWNLOADED_FILES;
import static com.interop.common.constants.utils.TriggerUtils.runTriggerForSpecificService;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_PROVIDER;
import static com.interop.common.constants.utils.db.ProviderDBUtils.getRecordProviderInbox;
import static com.sandata.utilities.CSVReader.defaultQuote;
import static com.sandata.utilities.sftp.utils.SftpUtils.*;

public class Auto_SEVV_17571_TC_21332_ETL_Import_Provider_ProviderID_length_of_ELT_Import_Base_Provider_must_be_9Or_13 extends ImportBaseTest {
    ImportProviderService importProviderService;

    @Test(groups = {"non-regression"})
    public void ETL_Import_Provider_ProviderID_length_of_ELT_Import_Provider_must_be_9or_13() throws Exception {
        importProviderService = new ImportProviderService();
        importProviderService.generateFileWithMultipleLine(4);
        baseObj.info("Prepare data before starting");
        List<OpenEvvProviderModel> listProviderInfo = new ArrayList<>();
        for (int i = 0; i < importProviderService.getRecords().size(); i++) {
            String providerID = importProviderService.generateDistinct13CharsValue();
            OpenEvvProviderModel providerInfo = new OpenEvvProviderModel();
            String finalValue = providerID;

            if (i == 1) {
                finalValue = providerID.substring(0, 9);
            }

            if (i == 2) {
                finalValue = providerID.substring(0, 11);
            }

            if (i == 3) {
                finalValue = providerID.substring(0, 8);
            }
            providerInfo.setProviderID(finalValue);
            providerInfo.setAgencyEmail(finalValue + "@mailinator.com");
            listProviderInfo.add(providerInfo);
        }


        baseObj.info("Step 1: Prepare test data");
        importProviderService.initFileImportProviderAndOutboundWithCustomData(listProviderInfo);

        baseObj.info("Step 2: Upload file to SFTP server");
        importProviderService.uploadFileToServer(importProviderService.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        String inboundFileName = importProviderService.generateInboundFileName(ImportServices.ImportType.OUTBOUND.getFileType(), importProviderService.getListFileCSV());
        String errorFileName = importProviderService.generateErrorFileName(ImportServices.ImportType.PROVIDER.getFileType(), importProviderService.getListFileCSV());
        runTriggerForSpecificService(EVV_IMPORT_PROVIDER);//Run trigger to make the service import auth run first

        baseObj.info("Step 3: Download And Verify File Inbound");
        boolean isFileInboundGenerated = isSftpFileExisted(getToInboxPath() + inboundFileName, 25);
        Assert.assertTrue(isFileInboundGenerated);
        importProviderService.downloadSpecificFileFromSFTPForOpenEVV(errorFileName, SftpUtils.FileType.ZIP);

        getFile(getToInboxPath(), FileType.CSV, inboundFileName, DOWNLOADED_FILES);

        this.verifyInboundCountRecords("2", "2", inboundFileName);
        String expectedError = "ERROR: The ProviderID format is incorrect. The record should satisfy this regular expression ['^(.{9}|.{13})$'].";
        ImportServices.verifyErrorMessageForTheSingleRecord(expectedError, errorFileName + FileType.ZIP.getExtension());

        baseObj.info("Step 3: Verify is Provider in INBOX");
        List<InboxProvider> listData = new ArrayList<>();
        for (Object object : importProviderService.getRecords()) {
            OpenEvvProviderModel providerInfo = (OpenEvvProviderModel) object;
            List<InboxProvider> data = getRecordProviderInbox(providerInfo.providerID);
            listData.addAll(data);
        }

    }

    private void verifyInboundCountRecords(String successCount, String failedCount, String inboundFileName) {
        CSVReader.defaultDelimiter = "|";
        defaultQuote = '"';
        CSVReader reader = CSVReader.readCSVFile(DOWNLOADED_FILES + inboundFileName);
        List rows = reader.getDataRows();
        baseObj.info("Value of success count is :" + ((ArrayList) rows.get(0)).get(5));
        baseObj.info("Value of failed count is :" + ((ArrayList) rows.get(0)).get(6));
        Assert.assertEquals(((ArrayList) rows.get(0)).get(5), successCount);
        Assert.assertEquals(((ArrayList) rows.get(0)).get(6), failedCount);
    }
}
