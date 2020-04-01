package openevvbatch.auth.pennsylvania;

import com.interop.models.db.staging.StagingAuth;
import com.interop.models.db.stx.STXPayorID;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportAuthService;
import com.interop.services.openevv.batch.ImportServices;
import com.interop.common.TestDataHelper;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.utils.TriggerUtils.runTriggerForSpecificService;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.EVV_IMPORT_AUTH;
import static com.interop.common.constants.utils.TriggerUtils.servicesNeedToTrigger.MATCHING_SERVICE;
import static com.interop.common.constants.utils.db.AuthDBUtils.getStagingAuthorization;

public class Auto_SEVV_17993_TC_20998_Import_Base_Auth_PA_With_Valid_Combination_Authorization_ServiceID extends ImportBaseTest {
    ImportAuthService importAuth;
    String pathFileTemplate = "/TestData/SEVV/Valid_File_SEVV_177793.csv";

    @Test(groups = {"non-regression"})
    public void Import_Auth_PA_With_Valid_Combination_Authorization_ServiceID() throws Exception {
        importAuth = new ImportAuthService();

        List<STXPayorID>listCombinationService = TestDataHelper.getListAuthorizationServicesIDCombination();
        baseObj.info("Step 1: Prepare data");
        importAuth.generateFileWithMultipleLine(listCombinationService.size());
        List<AuthorizationCSVModel> lstAuthInfo = new ArrayList<>();
        for (int i = 0; i < listCombinationService.size(); i++) {
            baseObj.info(String.format("Prepare Data for line %s", i));
            AuthorizationCSVModel auth = new AuthorizationCSVModel();
            auth.setAuthorizationReferenceNumber("Auto" + importAuth.generateDistinct13CharsValue());
            auth.setAuthorizationStartDate("07/23/2019");
            auth.setAuthorizationEndDate("07/23/2030");
            auth.setPayerID(listCombinationService.get(i).PAYOR_ID);
            auth.setAuthorizationServiceID(listCombinationService.get(i).PROC_CODE);
            auth.setPayerProgram(listCombinationService.get(i).PROGRAM);
            lstAuthInfo.add(auth);
        }
        baseObj.info("Step 1: Prepare data to import");
        importAuth.initFileImportAuthAndOutboundWithCustomData(lstAuthInfo);

        baseObj.info("Step 2: Upload file to SFTP");
        importAuth.uploadFileToServer(importAuth.getListFileUpload(), ImportServices.config.getEnvironment("Default_Upload_folder_SFTP"));

        String errorFile = importAuth.generateErrorFileName(ImportServices.ImportType.AUTHORIZATION.getFileType(), importAuth.getListFileUpload());
        baseObj.info("Step 3: Download Error file");
        runTriggerForSpecificService(EVV_IMPORT_AUTH);
        importAuth.downloadSpecificFileFromSFTPForOpenEVV(errorFile, SftpUtils.FileType.ZIP);

        baseObj.info("Step 4: Verify in staging DB");
        runTriggerForSpecificService(MATCHING_SERVICE);//Run trigger to make the service import auth run first
        List<StagingAuth> authRecordsStaging = new ArrayList<>();
        for (AuthorizationCSVModel auth : lstAuthInfo) {
            List record = getStagingAuthorization(auth.getAuthorizationReferenceNumber());
            authRecordsStaging.addAll(record);
        }

        baseObj.info("Step 4.1: Verify in staging DB Auth");
        for (int i = 0; i < importAuth.getRecords().size(); i++) {
            AuthorizationCSVModel line = (AuthorizationCSVModel) importAuth.getRecords().get(i);
            baseObj.info(String.format("Verify data of autRefNum = %s", line.getAuthorizationReferenceNumber()));
            Assert.assertEquals(authRecordsStaging.get(i).getService(), line.getAuthorizationServiceID());
            Assert.assertEquals(authRecordsStaging.get(i).getPayor_id(), line.getPayerID());
            Assert.assertEquals(authRecordsStaging.get(i).getProgram(), line.getPayerProgram());
            Assert.assertEquals(authRecordsStaging.get(i).getModifier1(), line.getModifier1());
            Assert.assertEquals(authRecordsStaging.get(i).getModifier2(), line.getModifier2());
            Assert.assertEquals(authRecordsStaging.get(i).getModifier3(), line.getModifier3());
            Assert.assertEquals(authRecordsStaging.get(i).getModifier4(), line.getModifier4());
        }
    }
}
