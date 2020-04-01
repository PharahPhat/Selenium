/**
 * account
 * dev: WI_AMP
 */
package openevvbatch.auth;

import com.interop.common.constants.utils.TriggerUtils;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportCustomFiles;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.qtest.QTest;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Auto_SEVV_14449_TC_20397_Field_Validation_Import_Base_OpenEVV_Auth extends ImportBaseTest {
    ImportCustomFiles importFile;

//    @Test(groups = {"non-regression"})
    private void TC_20397_Field_Validation_Import_OpenEVV_Auth(String stateName) throws Exception {

        String pathFileTemplate = "/TestData/"+stateName+"/File_Data_Test_Validation_OpenEVV_ELT_Auth.csv";

        importFile = new ImportCustomFiles(AuthorizationCSVModel.class, pathFileTemplate);
        List<AuthorizationCSVModel> listAuthData = Collections.emptyList();

        importFile.removeColumn("Error Description");

        baseObj.info("Step 1: Prepare Test Data");
        importFile.prepareFileImportCustomAndOutboundFile(listAuthData, ImportServices.ImportType.AUTHORIZATION);

        //TODO GENERATE FILE ERROR NAME BASED ON THE INPUT FILE
        baseObj.info("Step 2: Upload file to SFTP server");
        importFile.uploadFileToServer(importFile.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));
        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_AUTH);

        baseObj.info("Step 3: Download file error from SFTP");
        String fileNameFileError = importFile.generateErrorFileName(ImportServices.ImportType.AUTHORIZATION.getFileType(), importFile.getListFileUpload());
        importFile.downloadSpecificFileFromSFTPForOpenEVV(fileNameFileError, SftpUtils.FileType.ZIP);

        baseObj.info("Step 4: Verify list Expect Error with The message in file error");
        List<AuthorizationCSVModel> listObject = importFile.getRecords();
        List<String> listErrorMessageInFileImport = new ArrayList();
        for (AuthorizationCSVModel line : listObject) {
            listErrorMessageInFileImport.add(line.getErrorDescription());
        }
       importFile.verifyErrorMessageAuthFile(listObject,fileNameFileError);
    }
    @Test(groups = {"regression","hawaii"})
    @QTest(keys = {"TC-22066", "TC-22067", "TC-22068"})
    public void TC_Validate_Hawaii() throws Exception {
        TC_20397_Field_Validation_Import_OpenEVV_Auth("Hawaii");
    }

    @Test(groups = {"regression","arizona"})
    @QTest(keys = {"TC-22039", "TC-22040", "TC-22041","TC-22042","TC-22043","TC-22044","TC-22045","TC-22047"})
    public void TC_Validate_Arizona() throws Exception {
        TC_20397_Field_Validation_Import_OpenEVV_Auth("Arizona");
    }
    @Test(groups = {"regression", "pa"})
    @QTest()
    public void TC_Validate_PA() throws Exception {
        TC_20397_Field_Validation_Import_OpenEVV_Auth("Pennsylvania");
    }

    @Test(groups = {"regression", "wisconsin"})
    @QTest(keys = {"TC-23350","TC-23351","TC-23352","TC-23353","TC-23354","TC-23355","TC-23356","TC-23357"})
    public void TC_Validate_WI() throws Exception {
        TC_20397_Field_Validation_Import_OpenEVV_Auth("Wisconsin");
    }

}
