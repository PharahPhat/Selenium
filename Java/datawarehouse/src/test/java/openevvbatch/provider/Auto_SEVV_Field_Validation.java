package openevvbatch.provider;

import com.interop.common.StateAccount;
import com.interop.common.constants.utils.TriggerUtils;
import com.interop.models.openevv.provider.OpenEvvProviderModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportCustomFiles;
import com.interop.services.openevv.batch.ImportProviderService;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.qtest.QTest;
import com.sandata.utilities.CsvAnnotationMapper;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static com.interop.common.constants.Constant.DEFAULT_DELIMITER;
import static com.interop.common.constants.Constant.DOWNLOADED_FILES;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_PROVIDER;

public class Auto_SEVV_Field_Validation extends ImportBaseTest {
    private final String FIELD_VALIDATION = "/TestData/" + StateAccount.loadStateAccount().getStateName() + "/Openevvbatch/import_provider_validation.csv";
    ImportCustomFiles importFile;

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-23305","TC-23306","TC-23307","TC-23308","TC-23309","TC-23310"})
    //   @QTest(keys = {"TC-23305","TC-23306","TC-23307","TC-23308","TC-23309","TC-23310"}) Wisconsin tcs
    public void TC_21888_Field_Validation_All_Fields() throws Exception {
        importFile = new ImportCustomFiles(OpenEvvProviderModel.class, FIELD_VALIDATION);
        List<OpenEvvProviderModel> listBatch = Collections.emptyList();
        importFile.removeColumn("Error Description");

        baseObj.info("Step 1: Prepare Test Data");
        importFile.prepareFileImportCustomAndOutboundFile(listBatch, ImportServices.ImportType.PROVIDER);

        //TODO GENERATE FILE ERROR NAME BASED ON THE INPUT FILE
        baseObj.info("Step 2: Upload file to SFTP server");
        importFile.uploadFileToServer(importFile.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        baseObj.info("Step 3: Download file error from SFTP");
        String errorFileName = importFile.generateErrorFileName(ImportServices.ImportType.PROVIDER.getFileType(), importFile.getListFileUpload());
        TriggerUtils.runTriggerForSpecificService(EVV_IMPORT_PROVIDER);
        importFile.downloadSpecificFileFromSFTPForOpenEVV(errorFileName, SftpUtils.FileType.ZIP);

        baseObj.info("Step 4: Verify list Expect Error with The message in file error");
        String fullPath = DOWNLOADED_FILES + errorFileName.subSequence(0, errorFileName.length() - 4);
        List<OpenEvvProviderModel> listObject = importFile.getRecords();
        List<OpenEvvProviderModel> fileErrorObject = CsvAnnotationMapper.mapDataToModel(OpenEvvProviderModel.class, new File(fullPath), DEFAULT_DELIMITER);
        new ImportProviderService().validationFieldForImportProvider(listObject, fileErrorObject);
    }
}

