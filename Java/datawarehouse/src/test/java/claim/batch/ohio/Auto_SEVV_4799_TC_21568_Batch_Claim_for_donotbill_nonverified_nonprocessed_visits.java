package claim.batch.ohio;

import com.interop.models.db.stx.STXProviderCredential;
import com.interop.models.db.stx.STXVisit_Claim;
import com.interop.models.openevv.batch.BatchClaimCSVModel;
import com.interop.models.openevv.batch.ErrorAndRespCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportClaimServices;
import com.interop.services.openevv.batch.ImportServices;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.Constant.DOWNLOADED_FILES;
import static com.interop.common.constants.utils.db.ProviderDBUtils.getProviderCredential;
import static com.interop.services.openevv.batch.ImportClaimServices.indexFileInListFileGenerated.RESPONSE;
import static com.interop.services.openevv.batch.ImportClaimServices.listVisitOmitOrInComplete;
import static com.interop.common.constants.FieldConstants.MAX_TIME_ATTEMPT;
import static com.interop.common.constants.FieldConstants.MatchingRule.EXACT_MATCH;
import static com.interop.common.constants.FieldConstants.VisitFoundValue.FALSE;
import static com.sandata.utilities.sftp.utils.SftpUtils.*;

public class Auto_SEVV_4799_TC_21568_Batch_Claim_for_donotbill_nonverified_nonprocessed_visits extends ImportBaseTest {
    ImportClaimServices importClaimServices;

    @Test(groups = {"regression"})
    public void TC_21568_Batch_Claim_for_donotbill_nonverified_nonprocessed_visits() throws Exception {
        //Prepare Environment
        importClaimServices = new ImportClaimServices();
        setDstPath(ImportServices.config.getEnvironment("Default_Upload_folder_Pickup_Claim"));
        setToInboxPath(ImportServices.config.getEnvironment("Default_Upload_folder_DropOff_Claim"));
        //Generate unique batchID
        String batchID = new ImportClaimServices().generateBatchID();

        baseObj.info("Get the existing verified visit ind DB");
        List<STXVisit_Claim> listClaimVisit = listVisitOmitOrInComplete("10011");
        List<STXProviderCredential> providerCredentials = getProviderCredential("10011");

        baseObj.info("Prepare file name with specific BatchID");
        List<BatchClaimCSVModel> listClaimRequests = new ArrayList<>();
        BatchClaimCSVModel request = new BatchClaimCSVModel();
        request.setBusinessEntityMedicaidIdentifier((String) providerCredentials.get(0).getPROVIDER_ID());
        request.setProviderID((String) providerCredentials.get(0).getPROVIDER_ID());
        request.setBatchID(batchID);
        request.setPayer((String) listClaimVisit.get(0).getPAYOR_ID());
        request.setTransactionID(importClaimServices.generateDistinct13CharsValue());
        request.setICN(importClaimServices.generateDistinct13CharsValue());
        request.setProcedureCode((String) listClaimVisit.get(0).getSERVICE());
        request.setPatientID((String) listClaimVisit.get(0).getMEDICAID_ID());
        request.setServiceStartDate((String) listClaimVisit.get(0).getVISIT_DATE());
        request.setServiceEndDate((String) listClaimVisit.get(0).getVISIT_EDATE());
        request.setMatchingRule(EXACT_MATCH.getGetMatchingRuleValue());
        request.setUnits(DecimalFormat.getInstance().format(listClaimVisit.get(0).getBILL_UNITS()));
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
            Assert.assertEquals(line.getVisitFound(), FALSE.getValueVisitFound());
            Assert.assertEquals(line.getDetailsReason(), "No Visit Found");
            Assert.assertEquals(line.getProcedureCode(), request.getProcedureCode());
        }

        baseObj.info("Clean Up Data");
        SftpUtils.deleteFiles(SFTP_CONFIG, getDstPath(), listFileNameUploaded);
    }
}
