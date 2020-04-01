package performance.batchclaim;

import com.interop.models.db.stx.STXProviderCredential;
import com.interop.models.db.stx.STXVisit_Claim;
import com.interop.models.openevv.batch.BatchClaimCSVModel;
import com.interop.services.base.ImportBaseTest;
import com.interop.services.openevv.batch.ImportClaimServices;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.utils.db.ProviderDBUtils.getProviderCredential;
import static com.interop.services.openevv.batch.ImportClaimServices.getDistinctVisitWithSpecificStatusOnAccount;
import static com.interop.common.constants.FieldConstants.ModelType.MODEL3;
import static com.interop.common.constants.FieldConstants.VisitStatus.PROCESSED;
import static com.sandata.utilities.sftp.utils.SftpUtils.SFTP_CONFIG;
import static com.sandata.utilities.sftp.utils.SftpUtils.sftpSendFile;

public class Auto_SEVV_19433_TC_10001_Upload_100k_records_with_10visits extends ImportBaseTest {
    List<STXVisit_Claim> listClaimVisit = getDistinctVisitWithSpecificStatusOnAccount("10011", PROCESSED.getStatus());
    List<STXProviderCredential> providerCredentials = getProviderCredential("10011");

    @Test(groups = {"regression"})
    public void Verify_Case_Exclude_And_Equal() throws Exception {
        ImportClaimServices importClaimServices = new ImportClaimServices();
        //Generate unique batchID
        String batchID = new ImportClaimServices().generateBatchID();
        importClaimServices.generateFileWithMultipleLine(100000);
        int dlnValue = 1232161231;

        baseObj.info("Get the existing verified visit ind DB");
        baseObj.info("Prepare file name with specific BatchID");
        List<BatchClaimCSVModel> listClaimRequests = new ArrayList<>();
        for (int i = 0; i < importClaimServices.getRecords().size(); i++) {
            BatchClaimCSVModel request = new BatchClaimCSVModel();
            if (i < 2000) {
                request.setBusinessEntityMedicaidIdentifier((String) providerCredentials.get(0).getPROVIDER_ID());
                request.setProviderID((String) providerCredentials.get(0).getPROVIDER_ID());
                request.setBatchID(batchID);
                request.setRequestType(MODEL3.getModel());
                request.setPayer((String) listClaimVisit.get(0).getPAYOR_ID());
                request.setTransactionID(String.valueOf(dlnValue));
                request.setICN(String.valueOf(dlnValue));
                request.setProcedureCode((String) listClaimVisit.get(0).getSERVICE());
                request.setPatientID((String) listClaimVisit.get(0).getMEDICAID_ID());
                request.setServiceStartDate((String) listClaimVisit.get(0).getVISIT_DATE());
                request.setServiceEndDate((String) listClaimVisit.get(0).getVISIT_EDATE());
                request.setUnits((DecimalFormat.getInstance().format(listClaimVisit.get(0).getBILL_UNITS())) + ".0");
            }

            if (i >= 2000 && i < 4000) {
                request.setBusinessEntityMedicaidIdentifier((String) providerCredentials.get(0).getPROVIDER_ID());
                request.setProviderID((String) providerCredentials.get(0).getPROVIDER_ID());
                request.setBatchID(batchID);
                request.setRequestType(MODEL3.getModel());
                request.setPayer((String) listClaimVisit.get(1).getPAYOR_ID());
                request.setTransactionID(String.valueOf(dlnValue));
                request.setICN(String.valueOf(dlnValue));
                request.setProcedureCode((String) listClaimVisit.get(1).getSERVICE());
                request.setPatientID((String) listClaimVisit.get(1).getMEDICAID_ID());
                request.setServiceStartDate((String) listClaimVisit.get(1).getVISIT_DATE());
                request.setServiceEndDate((String) listClaimVisit.get(1).getVISIT_EDATE());
                request.setUnits((DecimalFormat.getInstance().format(listClaimVisit.get(1).getBILL_UNITS())) + ".0");
            }

            if (i >= 4000 && i < 6000) {
                request.setBusinessEntityMedicaidIdentifier((String) providerCredentials.get(0).getPROVIDER_ID());
                request.setProviderID((String) providerCredentials.get(0).getPROVIDER_ID());
                request.setBatchID(batchID);
                request.setRequestType(MODEL3.getModel());
                request.setPayer((String) listClaimVisit.get(2).getPAYOR_ID());
                request.setTransactionID(String.valueOf(dlnValue));
                request.setICN(String.valueOf(dlnValue));
                request.setProcedureCode((String) listClaimVisit.get(2).getSERVICE());
                request.setPatientID((String) listClaimVisit.get(2).getMEDICAID_ID());
                request.setServiceStartDate((String) listClaimVisit.get(2).getVISIT_DATE());
                request.setServiceEndDate((String) listClaimVisit.get(2).getVISIT_EDATE());
                request.setUnits((DecimalFormat.getInstance().format(listClaimVisit.get(2).getBILL_UNITS())) + ".0");
            }

            if (i >= 6000 && i < 8000) {
                request.setBusinessEntityMedicaidIdentifier((String) providerCredentials.get(0).getPROVIDER_ID());
                request.setProviderID((String) providerCredentials.get(0).getPROVIDER_ID());
                request.setBatchID(batchID);
                request.setRequestType(MODEL3.getModel());
                request.setPayer((String) listClaimVisit.get(2).getPAYOR_ID());
                request.setTransactionID(String.valueOf(dlnValue));
                request.setICN(String.valueOf(dlnValue));
                request.setProcedureCode((String) listClaimVisit.get(2).getSERVICE());
                request.setPatientID((String) listClaimVisit.get(2).getMEDICAID_ID());
                request.setServiceStartDate((String) listClaimVisit.get(2).getVISIT_DATE());
                request.setServiceEndDate((String) listClaimVisit.get(2).getVISIT_EDATE());
                request.setUnits((DecimalFormat.getInstance().format(listClaimVisit.get(2).getBILL_UNITS())) + ".0");
            }
            if (i >= 8000) {
                request.setBusinessEntityMedicaidIdentifier((String) providerCredentials.get(0).getPROVIDER_ID());
                request.setProviderID((String) providerCredentials.get(0).getPROVIDER_ID());
                request.setBatchID(batchID);
                request.setRequestType(MODEL3.getModel());
                request.setPayer((String) listClaimVisit.get(3).getPAYOR_ID());
                request.setTransactionID(String.valueOf(dlnValue));
                request.setICN(String.valueOf(dlnValue));
                request.setProcedureCode((String) listClaimVisit.get(3).getSERVICE());
                request.setPatientID((String) listClaimVisit.get(3).getMEDICAID_ID());
                request.setServiceStartDate((String) listClaimVisit.get(3).getVISIT_DATE());
                request.setServiceEndDate((String) listClaimVisit.get(3).getVISIT_EDATE());
                request.setUnits((DecimalFormat.getInstance().format(listClaimVisit.get(3).getBILL_UNITS())) + ".0");
            }
            dlnValue++;
            listClaimRequests.add(request);
        }


        baseObj.info("Step 1: Prepare file request and outbound file");
        importClaimServices.initTestDataImportClaim(listClaimRequests);

        baseObj.info("Step 2: Upload file to SFTP");
        List<String> listFileNameUploaded = new ArrayList<>();
        for (File file : importClaimServices.getListFileCSV()) {
            sftpSendFile(file.getPath(), getDstPath());
            listFileNameUploaded.add(file.getName());
        }

        baseObj.info("Clean Up Data");
        SftpUtils.deleteFiles(SFTP_CONFIG, getDstPath(), listFileNameUploaded);
    }
}
