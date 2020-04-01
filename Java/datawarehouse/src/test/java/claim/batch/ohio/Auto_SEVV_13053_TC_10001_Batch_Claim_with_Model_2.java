package claim.batch.ohio;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.interop.common.constants.Constant.DOWNLOADED_FILES;
import static com.interop.common.constants.FieldConstants.MAX_TIME_ATTEMPT;
import static com.interop.common.constants.FieldConstants.MatchingRule.EQUAL_OR_GREATER_THAN;
import static com.interop.common.constants.FieldConstants.MatchingRule.EXACT_MATCH;
import static com.interop.common.constants.FieldConstants.VisitFoundValue.TRUE;
import static com.interop.services.openevv.batch.ImportClaimServices.getVisitByVisitKey;
import static com.interop.services.openevv.batch.ImportClaimServices.indexFileInListFileGenerated.RESPONSE;
import static com.sandata.utilities.sftp.utils.SftpUtils.*;

public class Auto_SEVV_13053_TC_10001_Batch_Claim_with_Model_2 extends ImportBaseTest {
    public int totalUnits;
    private Set<String> listVisitKeys = new HashSet<>();

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-515", "TC-516", "TC-509", "TC-517", "TC-526"})
    public void Verify_Case_Exclude_And_Equal() throws Exception {
        //Prepare Environment
        ImportClaimServices importClaimServices = new ImportClaimServices();
        importClaimServices.setBatchClaimFileData("Auto_SEVV_TC_14450_Test_Rest_Claim_Validation");
        importClaimServices.setModelVersion(ModelVersion.MODEL2);

        List<ClaimModel> claimModelList = importClaimServices.getVisitDataFromTestData(importClaimServices.getModelVersion(), importClaimServices.getBatchClaimFileData());
        ClaimModel visitInfo = claimModelList.get(0);

        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_Pickup_Claim"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_Upload_folder_DropOff_Claim"));

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
        request.setMatchingRule(EQUAL_OR_GREATER_THAN.getGetMatchingRuleValue());
        listClaimRequests.add(request);

        baseObj.info("Step 1: Prepare file request and outbound file");
        importClaimServices.initTestDataImportClaim(listClaimRequests);

        baseObj.info("Step 2: Upload file to SFTP");
        List<String> listFileNameUploaded = new ArrayList<>();
        for (File file : importClaimServices.getListFileCSV()) {
            sftpSendFile(file.getPath(), getDstPath());
            listFileNameUploaded.add(file.getName());
        }
        List<String> listFileResponse = importClaimServices.generateAllResponseFilesForClaim(importClaimServices.getListFileCSV());

        baseObj.info("Step 3: Download Resp File");
        boolean isFileResponseDisplayed = isSftpFileExisted(getToInboxPath() + listFileResponse.get(RESPONSE.getIndex()), MAX_TIME_ATTEMPT);
        Assert.assertTrue(isFileResponseDisplayed);
        List<ErrorAndRespCSVModel> lineRecordInRespFile = new ArrayList<>();
        for (String fileName : listFileResponse) {
            getFile(getToInboxPath(), FileType.CSV, fileName, DOWNLOADED_FILES);
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
            listVisitKeys.add(line.getVisitKey());
        }

        for (String visitKey : listVisitKeys) {
            Object valueUnit = getVisitByVisitKey(visitKey).getBILL_UNITS();
            totalUnits += Integer.parseInt(String.valueOf(valueUnit));
        }

        Verify_Case_Exact_Match();

        baseObj.info("Clean Up Data");
        SftpUtils.deleteFiles(SFTP_CONFIG, getDstPath(), listFileNameUploaded);
    }

    @QTest(keys = {"TC-508", "TC-510"})
    public void Verify_Case_Exact_Match() throws Exception {
        //Prepare Environment
        ImportClaimServices importClaimServices = new ImportClaimServices();
        importClaimServices.setBatchClaimFileData("Auto_SEVV_TC_14450_Test_Rest_Claim_Validation");
        importClaimServices.setModelVersion(ModelVersion.MODEL2);

        List<ClaimModel> claimModelList = importClaimServices.getVisitDataFromTestData(importClaimServices.getModelVersion(), importClaimServices.getBatchClaimFileData());
        ClaimModel visitInfo = claimModelList.get(0);

        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_Pickup_Claim"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_Upload_folder_DropOff_Claim"));

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
        request.setMatchingRule(EXACT_MATCH.getGetMatchingRuleValue());
        listClaimRequests.add(request);

        baseObj.info("Step 1: Prepare file request and outbound file");
        importClaimServices.initTestDataImportClaim(listClaimRequests);

        baseObj.info("Step 2: Upload file to SFTP");
        List<String> listFileNameUploaded = new ArrayList<>();
        for (File file : importClaimServices.getListFileCSV()) {
            sftpSendFile(file.getPath(), getDstPath());
            listFileNameUploaded.add(file.getName());
        }
        List<String> listFileResponse = importClaimServices.generateAllResponseFilesForClaim(importClaimServices.getListFileCSV());

        baseObj.info("Step 3: Download Resp File");
        boolean isFileResponseDisplayed = isSftpFileExisted(getToInboxPath() + listFileResponse.get(RESPONSE.getIndex()), MAX_TIME_ATTEMPT);
        Assert.assertTrue(isFileResponseDisplayed);
        List<ErrorAndRespCSVModel> lineRecordInRespFile = new ArrayList<>();
        for (String fileName : listFileResponse) {
            getFile(getToInboxPath(), SftpUtils.FileType.CSV, fileName, DOWNLOADED_FILES);
            if (fileName.contains("Resp")) {
                lineRecordInRespFile = importClaimServices.parseLineFileErrorOrRespToModel(fileName);
            }
        }

        baseObj.info("Step 4: Verify visit found status in Resp file");
        for (ErrorAndRespCSVModel line : lineRecordInRespFile) {
            Assert.assertEquals(line.getVisitFound(), TRUE.getValueVisitFound());
            Assert.assertEquals(line.getDetailsReason(), "");
            Assert.assertEquals(line.getRecordsFound(), "1");
            Assert.assertEquals(line.getServiceStartDate(), request.getServiceStartDate());
            Assert.assertEquals(line.getServiceEndDate(), request.getServiceEndDate());
            Assert.assertEquals(line.getUnits(), getVisitByVisitKey(line.getVisitKey()).getBILL_UNITS() + ".0");
        }

        baseObj.info("Clean Up Data");
        SftpUtils.deleteFiles(SFTP_CONFIG, getDstPath(), listFileNameUploaded);
    }
}
