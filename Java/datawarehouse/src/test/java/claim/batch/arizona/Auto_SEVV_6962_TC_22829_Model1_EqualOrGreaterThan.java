package claim.batch.arizona;

import com.interop.common.constants.utils.TriggerUtils;
import com.interop.models.claim.ClaimModel;
import com.interop.models.claim.ModelVersion;
import com.interop.models.openevv.batch.BatchClaimCSVModel;
import com.interop.models.openevv.batch.ErrorAndRespCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportClaimServices;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.qtest.QTest;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.Constant.DOWNLOADED_FILES;
import static com.interop.common.constants.FieldConstants.MAX_TIME_ATTEMPT;
import static com.interop.common.constants.FieldConstants.MatchingRule.EQUAL_OR_GREATER_THAN;
import static com.interop.common.constants.FieldConstants.VisitFoundValue.TRUE;
import static com.interop.services.openevv.batch.ImportClaimServices.getVisitByVisitKey;
import static com.interop.services.openevv.batch.ImportClaimServices.indexFileInListFileGenerated.RESPONSE;
import static com.sandata.utilities.sftp.utils.SftpUtils.*;

public class Auto_SEVV_6962_TC_22829_Model1_EqualOrGreaterThan extends ImportBaseTest {

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-22829"})
    public void Model1_EqualOrGreaterThan() throws Exception {
        //Prepare Environment
        ImportClaimServices importClaimServices = new ImportClaimServices();
        importClaimServices.setBatchClaimFileData("Claim/SEVV_6962_ClaimData");
        importClaimServices.setModelVersion(ModelVersion.MODEL1);

        List<ClaimModel> listVisitInfo = importClaimServices.getVisitDataFromTestData(importClaimServices.getModelVersion(), importClaimServices.getBatchClaimFileData());
        ClaimModel visitInfo = listVisitInfo.get(0);

        baseObj.info("Prepare file name with specific BatchID");

        List<BatchClaimCSVModel> listClaimRequests = new ArrayList<>();
        BatchClaimCSVModel request = new BatchClaimCSVModel();
        request.setBusinessEntityMedicaidIdentifier(visitInfo.getBusinessEntityMedicaidIdentifier());
        request.setProviderID(visitInfo.getProviderID());
        request.setBatchID(visitInfo.getBatchID());
        request.setRequestType(importClaimServices.getModelVersion().getValue());
        request.setPayer(visitInfo.getPayer());
        request.setTransactionID(visitInfo.getTransactionID());
        request.setICN(visitInfo.getIcn());
        request.setProcedureCode(visitInfo.getProcedureCode());
        request.setPatientID(visitInfo.getPatientID());
        request.setServiceStartDate(visitInfo.getServiceStartDate());
        request.setServiceEndDate(visitInfo.getServiceEndDate());
        request.setUnits((DecimalFormat.getInstance().format(visitInfo.getUnits() / 2)) + ".0");
        request.setMatchingRule(EQUAL_OR_GREATER_THAN.getGetMatchingRuleValue());
        listClaimRequests.add(request);

        baseObj.info("Step 1: Prepare file request and outbound file");
        importClaimServices.initTestDataImportClaim(listClaimRequests);

        baseObj.info("Step 2: Upload file to SFTP");
        List<String> listFileNameUploaded = new ArrayList<>();
        for (File file : importClaimServices.getListFileCSV()) {
            sftpSendFile(file.getPath(), ImportServices.config.getEnvironment("Default_Upload_folder_Pickup_Claim"));
            listFileNameUploaded.add(file.getName());
        }

        TriggerUtils.runTriggerForSpecificService(TriggerUtils.servicesNeedToTrigger.EVV_CLAIM_VALIDATION_V2);
        List<String> listFileResponse = importClaimServices.generateAllResponseFilesForClaim(importClaimServices.getListFileCSV());

        baseObj.info("Step 3: Download Resp File");
        String default_upload_folder_dropOff_claim = ImportServices.config.getEnvironment("Default_Upload_folder_DropOff_Claim");
        boolean isFileResponseDisplayed = isSftpFileExisted(default_upload_folder_dropOff_claim + listFileResponse.get(RESPONSE.getIndex()), MAX_TIME_ATTEMPT);
        Assert.assertTrue(isFileResponseDisplayed);
        List<ErrorAndRespCSVModel> lineRecordInRespFile = new ArrayList<>();
        for (String fileName : listFileResponse) {
            getFile(default_upload_folder_dropOff_claim, FileType.CSV, fileName, DOWNLOADED_FILES);
            if (fileName.contains("Resp")) {
                lineRecordInRespFile = importClaimServices.parseLineFileErrorOrRespToModel(fileName);
            }
        }

        baseObj.info("Step 4: Verify visit found status in Resp file");
        for (ErrorAndRespCSVModel line : lineRecordInRespFile) {
            Assert.assertEquals(line.getVisitFound(), TRUE.getValueVisitFound());
            Assert.assertEquals(line.getDetailsReason(), "");
            Assert.assertEquals(line.getRecordsFound().trim(), "1");
            Assert.assertEquals(line.getUnits(), getVisitByVisitKey(line.getVisitKey()).getBILL_UNITS() + ".0");
            Assert.assertEquals(line.getServiceStartDate(), listClaimRequests.get(0).getServiceStartDate());
            Assert.assertEquals(line.getServiceEndDate(), listClaimRequests.get(0).getServiceEndDate());
        }

        baseObj.info("Clean Up Data");
        SftpUtils.deleteFiles(SFTP_CONFIG, getDstPath(), listFileNameUploaded);
    }
}