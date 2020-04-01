package claim.batch.arizona;

import com.interop.common.constants.utils.TriggerUtils;
import com.interop.models.claim.ClaimModel;
import com.interop.models.claim.ModelVersion;
import com.interop.models.openevv.batch.BatchClaimCSVModel;
import com.interop.models.openevv.batch.ErrorAndRespCSVModel;
import com.interop.models.openevv.batch.InboundCSVModel;
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
import static com.interop.common.constants.FieldConstants.MatchingRule.EXCLUDE_UNITS;
import static com.interop.common.constants.FieldConstants.VisitFoundValue.FALSE;
import static com.interop.services.openevv.batch.ImportClaimServices.indexFileInListFileGenerated.INBOUND;
import static com.interop.services.openevv.batch.ImportClaimServices.indexFileInListFileGenerated.RESPONSE;
import static com.sandata.utilities.sftp.utils.SftpUtils.*;

public class Auto_SEVV_6962_TC_22985_22851_Model2_IdenticalVisit extends ImportBaseTest {

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-22985", "TC-22851"})
    public void IdenticalVisit() throws Exception {
        //Prepare Environment
        ImportClaimServices importClaimServices = new ImportClaimServices();
        importClaimServices.setBatchClaimFileData("Claim/SEVV_6962_ClaimData");
        importClaimServices.setModelVersion(ModelVersion.MODEL2);

        List<ClaimModel> listVisitInfo = importClaimServices.getVisitDataFromTestData(importClaimServices.getModelVersion(), importClaimServices.getBatchClaimFileData());
        ClaimModel visitInfo = listVisitInfo.get(1);
        baseObj.info("Get the existing verified visit in DB");
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
        request.setUnits((DecimalFormat.getInstance().format(visitInfo.getUnits())) + ".0");
        request.setMatchingRule(EXCLUDE_UNITS.getGetMatchingRuleValue());
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
            Assert.assertEquals(line.getVisitFound(), FALSE.getValueVisitFound());
        }

        baseObj.info("Step 5: Verify file Inbound");
        boolean isFileInboundExisted = isSftpFileExisted(default_upload_folder_dropOff_claim + listFileResponse.get(INBOUND.getIndex()), MAX_TIME_ATTEMPT);
        Assert.assertTrue(isFileInboundExisted);
        List<InboundCSVModel> lineInFileInbound = new ArrayList<>();
        for (String fileName : listFileResponse) {
            getFile(default_upload_folder_dropOff_claim, FileType.CSV, fileName, DOWNLOADED_FILES);
            if (fileName.contains("Inbound")) {
                lineInFileInbound = importClaimServices.parseLineFileInboundToModel(fileName);
            }
        }
        for (InboundCSVModel line : lineInFileInbound) {
            baseObj.validateActualAndExpectedText(line.getSuccessCount(), "1");
            baseObj.validateActualAndExpectedText(line.getFailedCount(), "0");
        }

        baseObj.info("Clean Up Data");
        SftpUtils.deleteFiles(SFTP_CONFIG, getDstPath(), listFileNameUploaded);
    }
}
