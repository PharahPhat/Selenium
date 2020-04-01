package claim.batch.arizona;

import com.interop.models.openevv.batch.BatchClaimCSVModel;
import com.interop.models.openevv.batch.ErrorAndRespCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportClaimServices;
import com.interop.services.openevv.batch.ImportCustomFiles;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.qtest.QTest;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.Constant.DOWNLOADED_FILES;
import static com.interop.common.constants.FieldConstants.EXPECTED_ERROR;
import static com.interop.common.constants.FieldConstants.MAX_TIME_ATTEMPT;
import static com.interop.services.openevv.batch.ImportClaimServices.indexFileInListFileGenerated.ERROR;
import static com.sandata.utilities.sftp.utils.SftpUtils.*;

public class Auto_SEVV_6962_TC_22855_Validation_Fields_with_invalid_data_for_each_field extends ImportBaseTest {
    ImportCustomFiles importCustomFiles;

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-22855"})
    public void Validation_Fields_with_invalid_data_for_each_field() throws Exception {
        //Prepare Environment
        String pathFileTemplate = "/TestData/SEVV/test_data_sevv_4799_validation_rule.csv";
        importCustomFiles = new ImportCustomFiles<>(BatchClaimCSVModel.class, pathFileTemplate);
        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_Pickup_Claim"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_Upload_folder_DropOff_Claim"));
        //Generate unique batchID
        String batchID = new ImportClaimServices().generateBatchID();

        baseObj.info("Prepare file name with specific BatchID");
        List<BatchClaimCSVModel> listClaimRequests = new ArrayList<>();
        for (int i = 0; i < importCustomFiles.getRecords().size(); i++) {
            BatchClaimCSVModel request = new BatchClaimCSVModel();
            request.setTransactionID(importCustomFiles.generateDistinct13CharsValue());
            request.setBatchID(batchID);
            listClaimRequests.add(request);
        }

        baseObj.info("Update BatchID and Transaction ID for all request");
        importCustomFiles.removeColumn(EXPECTED_ERROR);

        baseObj.info("Step 1: Prepare file request and outbound file");
        importCustomFiles.initTestDataImportClaim(listClaimRequests, batchID);

        baseObj.info("Step 2: Upload file to SFTP");
        List<String> listFileNameUploaded = new ArrayList<>();
        for (File file : importCustomFiles.getListFileCSV()) {
            sftpSendFile(file.getPath(), getDstPath());
            listFileNameUploaded.add(file.getName());
        }
        List<String> listFileResponse = importCustomFiles.generateAllResponseFilesForClaim(importCustomFiles.getListFileCSV());

        baseObj.info("Step 3: Download error File");
        boolean isFileResponseDisplayed = isSftpFileExisted(getToInboxPath() + listFileResponse.get(ERROR.getIndex()), MAX_TIME_ATTEMPT);
        Assert.assertTrue(isFileResponseDisplayed);
        List<ErrorAndRespCSVModel> lineRecordsErrorFile = new ArrayList<>();
        for (String fileName : listFileResponse) {
            getFile(getToInboxPath(), FileType.CSV, fileName, DOWNLOADED_FILES);
            if (fileName.contains("Error")) {
                lineRecordsErrorFile = importCustomFiles.parseLineFileErrorOrRespToModel(fileName);
            }
        }

        baseObj.info("Step 4: Compare error Msg In Error File with expectation message");
        List<BatchClaimCSVModel> lineInFileImported = importCustomFiles.getRecords();
        importCustomFiles.verifyErrorMessageInFileErrorWithListMsgInBatchClaim(lineInFileImported, lineRecordsErrorFile);

        baseObj.info("Clean Up Data");
        SftpUtils.deleteFiles(SFTP_CONFIG, getDstPath(), listFileNameUploaded);
    }
}
