package generic.dsv.business.molina;

import generic.import_feature.molina.ImportMolinaGenericTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Auto_SEVV_9466_TC_101508_Maine_Import_Client_Auth_Matching_Aggregate_Single_File extends ImportMolinaGenericTest {
    @Test(enabled = true, groups = {"All"})
    public void Auto_SEVV_9466_TC_101508_Maine_Import_Client_Auth_Matching_Aggregate_Single_File() throws IOException {
        initStateInfo();
        logStepInfo("Step 1: Import multiple Molina members & outbound control files then upload to SFTP folder");
        createAndImportMolinaMemberWithMultipleMember(3);

        logStepInfo("Step 2: Verify all members along with auth(s) inserted in DB");
        verifyAllClientsExistInDB();
    }
}
