package claim.batch.ohio;

import com.interop.models.claim.ClaimModel;
import com.interop.models.claim.ModelVersion;
import com.interop.models.openevv.batch.BatchClaimCSVModel;
import com.interop.models.openevv.batch.ErrorAndRespCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportClaimServices;
import com.interop.services.openevv.batch.ImportCustomFiles;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.Constant.DOWNLOADED_FILES;
import static com.interop.common.constants.FieldConstants.MAX_TIME_ATTEMPT;
import static com.interop.common.constants.FieldConstants.MatchingRule.EXACT_MATCH;
import static com.interop.common.constants.FieldConstants.VisitFoundValue.TRUE;
import static com.interop.services.openevv.batch.ImportClaimServices.indexFileInListFileGenerated.RESPONSE;
import static com.sandata.utilities.sftp.utils.SftpUtils.*;

public class Auto_SEVV_4799_TC_21565_Business_Logics_Claims_V2_Model_1 extends ImportBaseTest {
    ImportCustomFiles importCustomFiles;

    @Test(groups = {"regression"})
    public void TC_21565_Business_Logics_Claims_V2_Model_1() throws Exception {

        //Prepare Environment
        ImportClaimServices importClaimServices = new ImportClaimServices();
        importClaimServices.setBatchClaimFileData("Auto_SEVV_TC_14450_Test_Rest_Claim_Validation");
        importClaimServices.setModelVersion(ModelVersion.MODEL1);

        List<ClaimModel> claimModelList = importClaimServices.getVisitDataFromTestData(importClaimServices.getModelVersion(), importClaimServices.getBatchClaimFileData());
        ClaimModel visitInfo = claimModelList.get(0);

        String pathFileTemplate = "/TestData/SEVV/test_data_sevv_4799_business_rule.csv";
        importCustomFiles = new ImportCustomFiles<>(BatchClaimCSVModel.class, pathFileTemplate);
        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_Pickup_Claim"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_Upload_folder_DropOff_Claim"));

        baseObj.info("Get the existing verified visit ind DB");

        baseObj.info("Prepare file name with specific BatchID");
        List<BatchClaimCSVModel> listClaimRequests = new ArrayList<>();
        for (int i = 0; i < importCustomFiles.getRecords().size(); i++) {
            BatchClaimCSVModel request = new BatchClaimCSVModel();
            request.setBusinessEntityMedicaidIdentifier(visitInfo.getBusinessEntityMedicaidIdentifier());
            request.setProviderID(visitInfo.getProviderID());
            request.setBatchID(visitInfo.getBatchID());
            request.setRequestType(importClaimServices.getModelVersion().getValue());
            request.setPayer(visitInfo.getPayer());
            request.setTransactionID(importCustomFiles.generateDistinct13CharsValue());
            request.setICN(importCustomFiles.generateDistinct13CharsValue());
            request.setProcedureCode(visitInfo.getProcedureCode());
            request.setPatientID(visitInfo.getPatientID());
            request.setServiceStartDate(visitInfo.getServiceStartDate());
            request.setServiceEndDate(visitInfo.getServiceEndDate());
            request.setMatchingRule(EXACT_MATCH.getGetMatchingRuleValue());
            request.setUnits((DecimalFormat.getInstance().format(visitInfo.getUnits() / 2)) + ".0");//(DecimalFormat.getInstance().format(visitInfo.getUnits())) + ".0"
            listClaimRequests.add(request);
        }

        baseObj.info("Step 1: Prepare file request and outbound file");
        importCustomFiles.initTestDataImportClaim(listClaimRequests, visitInfo.getBatchID());

        baseObj.info("Step 2: Upload file to SFTP");
        List<String> listFileNameUploaded = new ArrayList<>();
        for (File file : importCustomFiles.getListFileCSV()) {
            sftpSendFile(file.getPath(), getDstPath());
            listFileNameUploaded.add(file.getName());
        }
        List<String> listFileResponse = importCustomFiles.generateAllResponseFilesForClaim(importCustomFiles.getListFileCSV());

        baseObj.info("Step 3: Download Resp File");
        boolean isFileResponseDisplayed = isSftpFileExisted(getToInboxPath() + listFileResponse.get(RESPONSE.getIndex()), MAX_TIME_ATTEMPT);
        Assert.assertTrue(isFileResponseDisplayed);
        List<ErrorAndRespCSVModel> lineRecordInRespFile = new ArrayList<>();
        for (String fileName : listFileResponse) {
            getFile(getToInboxPath(), FileType.CSV, fileName, DOWNLOADED_FILES);
            if (fileName.contains("Resp")) {
                lineRecordInRespFile = importCustomFiles.parseLineFileErrorOrRespToModel(fileName);
            }
        }

        baseObj.info("Step 4: Verify visit found status in Resp file");
        for (ErrorAndRespCSVModel line : lineRecordInRespFile) {
            Assert.assertEquals(line.getVisitFound(), TRUE.getValueVisitFound());
            Assert.assertEquals(line.getDetailsReason(), "");
        }

        baseObj.info("Clean Up Data");
        SftpUtils.deleteFiles(SFTP_CONFIG, getDstPath(), listFileNameUploaded);
    }
}
