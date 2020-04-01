package openevvbatch.provider.arizona;

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

public class Auto_SEVV_6950_TC_21888_Field_Validation_All_Fields_Arizona extends ImportBaseTest {
    private final String FIELD_VALIDATION_AZ = "/TestData/SEVV/SEVV_6950_Field_Validation_Invalid.csv";
    ImportCustomFiles importFile;

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-21916", "TC-21917", "TC-21918", "TC-21919", "TC-21920", "TC-21921", "TC-21922", "TC-21923", "TC-21924", "TC-21925", "TC-21926", "TC-21927", "TC-21928", "TC-21929", "TC-21930", "TC-21931", "TC-21932", "TC-21933", "TC-21934", "TC-21935", "TC-21936", "TC-21937", "TC-21938", "TC-21939"})
    public void TC_21888_Field_Validation_All_Fields() throws Exception {
        importFile = new ImportCustomFiles(OpenEvvProviderModel.class, FIELD_VALIDATION_AZ);
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

