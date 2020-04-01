package generic.dsv.business.molina;

import generic.import_feature.molina.ImportMolinaGenericTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Auto_SEVV_9466_TC_101509_Maine_Import_Client_Auth_Matching_Aggregate_Multiple_Files extends ImportMolinaGenericTest {
    @Test(enabled = true, groups = {"All"})
    public void Auto_SEVV_9466_TC_101509_Maine_Import_Client_Auth_Matching_Aggregate_Multiple_Files() throws IOException {
        initStateInfo();
        logStepInfo("Step 1: Import multiple Molina member files & outbound control files then upload to SFTP folder");
        createAndImportMolinaMemberWithMultipleFileAndMultipleMember(3);

        logStepInfo("Step 2: Verify all members along with auth(s) inserted in DB");
        verifyAllClientsExistInDB();
    }
}
