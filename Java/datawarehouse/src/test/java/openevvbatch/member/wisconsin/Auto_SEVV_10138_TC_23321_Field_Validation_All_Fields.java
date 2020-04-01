package openevvbatch.member.wisconsin;

import com.interop.common.StateAccount;
import com.interop.models.openevv.batch.MemberCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportCustomFiles;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.qtest.QTest;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Auto_SEVV_10138_TC_23321_Field_Validation_All_Fields extends ImportBaseTest {
    @Test(groups = {"regression"})
    @QTest(keys = {"TC-23321"})
    public void TC_23321_Validate_Wisconsin() throws Exception {
        ImportCustomFiles importFile;
        String pathFileTemplate = "/TestData/" + StateAccount.loadStateAccount().getStateName() + "/File_Data_Test_Validation_OpenEVV_ELT_Member.csv";

        importFile = new ImportCustomFiles(MemberCSVModel.class, pathFileTemplate);
        List<MemberCSVModel> listBatch = Collections.emptyList();

        importFile.removeColumn("Error Description");

        baseObj.info("Step 1: Prepare Test Data");
        importFile.prepareFileImportCustomAndOutboundFile(listBatch, ImportServices.ImportType.MEMBER);

        //TODO GENERATE FILE ERROR NAME BASED ON THE INPUT FILE
        baseObj.info("Step 2: Upload file to SFTP server");
        importFile.uploadFileToServer(importFile.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Download file error from SFTP");
        String fileNameFileError = importFile.generateErrorFileName(ImportServices.ImportType.MEMBER.getFileType(), importFile.getListFileUpload());
        importFile.downloadSpecificFileFromSFTPForOpenEVV(fileNameFileError, SftpUtils.FileType.ZIP);

        baseObj.info("Step 4: Verify list Expect Error with The message in file error");
        List<MemberCSVModel> listObject = importFile.getRecords();
        List<String> listErrorMessageInFileImport = new ArrayList();
        for (MemberCSVModel line : listObject) {
            listErrorMessageInFileImport.add(line.getErrorDescription());
        }
        importFile.verifyErrorMessageInFileErrorWithListMsgInFleError(listErrorMessageInFileImport, fileNameFileError);
    }
}

