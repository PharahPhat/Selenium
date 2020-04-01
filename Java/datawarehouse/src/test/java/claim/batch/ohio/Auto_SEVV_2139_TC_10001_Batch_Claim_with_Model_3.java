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
import java.util.List;

import static com.interop.common.constants.Constant.DOWNLOADED_FILES;
import static com.interop.common.constants.FieldConstants.MAX_TIME_ATTEMPT;
import static com.interop.common.constants.FieldConstants.MatchingRule.EQUAL_OR_GREATER_THAN;
import static com.interop.common.constants.FieldConstants.MatchingRule.EXACT_MATCH;
import static com.interop.common.constants.FieldConstants.VisitFoundValue.TRUE;
import static com.interop.services.openevv.batch.ImportClaimServices.getVisitByVisitKey;
import static com.interop.services.openevv.batch.ImportClaimServices.indexFileInListFileGenerated.RESPONSE;
import static com.sandata.utilities.sftp.utils.SftpUtils.*;

public class Auto_SEVV_2139_TC_10001_Batch_Claim_with_Model_3 extends ImportBaseTest {
    private String[] listVisitKeys;
    private String totalUnits;

    @Test(groups = {"regression"})
    @QTest(keys = {"TC-553", "TC-21670", "TC-544", "TC-545", "TC-546"})
    public void Verify_Case_Exclude_And_Equal() throws Exception {
        //Prepare Environment
        ImportClaimServices importClaimServices = new ImportClaimServices();
        importClaimServices.setBatchClaimFileData("Auto_SEVV_TC_14450_Test_Rest_Claim_Validation");
        importClaimServices.setModelVersion(ModelVersion.MODEL3);

        List<ClaimModel> claimModelList = importClaimServices.getVisitDataFromTestData(importClaimServices.getModelVersion(), importClaimServices.getBatchClaimFileData());
        ClaimModel visitInfo = claimModelList.get(0);

        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_Pickup_Claim"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_Upload_folder_DropOff_Claim"));

        baseObj.info("Get Data from file");

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
            if (!line.getRecordsFound().equalsIgnoreCase("1"))
                listVisitKeys = line.getVisitKey().split("\\s+|,\\s*|\\.\\s*");
            Assert.assertEquals(line.getRecordsFound(), String.valueOf(listVisitKeys.length));
            Assert.assertEquals(line.getServiceStartDate(), listClaimRequests.get(0).getServiceStartDate());
            Assert.assertEquals(line.getServiceEndDate(), listClaimRequests.get(0).getServiceEndDate());
            totalUnits = line.getUnits();
        }

        Verify_Case_Exact_Match();

        baseObj.info("Clean Up Data");
        SftpUtils.deleteFiles(SFTP_CONFIG, getDstPath(), listFileNameUploaded);
    }

    public void Verify_Case_Exact_Match() throws Exception {
        //Prepare Environment
        ImportClaimServices importClaimServices = new ImportClaimServices();
        importClaimServices.setBatchClaimFileData("Auto_SEVV_TC_14450_Test_Rest_Claim_Validation");
        importClaimServices.setModelVersion(ModelVersion.MODEL3);

        List<ClaimModel> claimModelList = importClaimServices.getVisitDataFromTestData(importClaimServices.getModelVersion(), importClaimServices.getBatchClaimFileData());
        ClaimModel visitInfo = claimModelList.get(0);

        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_Pickup_Claim"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_Upload_folder_DropOff_Claim"));
        //Generate unique batchID
        String batchID = new ImportClaimServices().generateBatchID();

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
        int totalUnitVisitInDB = 0;
        for (ErrorAndRespCSVModel line : lineRecordInRespFile) {
            Assert.assertEquals(line.getVisitFound(), TRUE.getValueVisitFound());
            Assert.assertEquals(line.getDetailsReason(), "");
            Assert.assertEquals(line.getRecordsFound(), String.valueOf(listVisitKeys.length));
            for (String visitKey : listVisitKeys) {
                Assert.assertTrue(line.getVisitKey().contains(visitKey));
                Object valueUnit = getVisitByVisitKey(visitKey).getBILL_UNITS();
                totalUnitVisitInDB += Integer.parseInt(String.valueOf(valueUnit));
            }
            Assert.assertEquals(totalUnitVisitInDB + ".0", line.getUnits());
            Assert.assertEquals(line.getServiceStartDate(), request.getServiceStartDate());
            Assert.assertEquals(line.getServiceEndDate(), request.getServiceEndDate());
        }

        baseObj.info("Clean Up Data");
        SftpUtils.deleteFiles(SFTP_CONFIG, getDstPath(), listFileNameUploaded);
    }
}
