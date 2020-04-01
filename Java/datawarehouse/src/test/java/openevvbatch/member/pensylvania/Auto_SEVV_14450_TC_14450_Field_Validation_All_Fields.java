package openevvbatch.member.pensylvania;

import com.interop.common.StateAccount;
import com.interop.common.constants.utils.TriggerUtils;
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

public class Auto_SEVV_14450_TC_14450_Field_Validation_All_Fields extends ImportBaseTest {
    ImportCustomFiles importFile;

    @Test(groups = {"regression", "pa"})
    @QTest()
    public void TC_14450_Field_Validation_All_Fields() throws Exception {
        String pathFileTemplate = "/TestData/" + StateAccount.loadStateAccount().getStateName() + "/File_Data_Test_Validation_OpenEVV_ELT_Member.csv";

        importFile = new ImportCustomFiles(MemberCSVModel.class, pathFileTemplate);
        List<MemberCSVModel> listBatch = Collections.emptyList();

        importFile.removeColumn("Error Description");

        baseObj.info("Step 1: Prepare Test Data");
        importFile.prepareFileImportCustomAndOutboundFile(listBatch, ImportServices.ImportType.MEMBER);

        //TODO GENERATE FILE ERROR NAME BASED ON THE INPUT FILE
        baseObj.info("Step 2: Upload file to SFTP server");
        importFile.uploadFileToServer(importFile.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_MEMBER);

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

