package generic.dsv.business.molina;

import generic.import_feature.molina.ImportMolinaGenericTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sandata.common.Constant.EXTENSION.gpg;

public class Auto_SEVV_7469_TC_101113_Maine_Import_Client_Only_Has_Inactive_Auths extends ImportMolinaGenericTest {
    @Test(enabled = true, groups = {"All"})
    public void Auto_SEVV_7469_TC_101113_Maine_Import_Client_Only_Has_Inactive_Auths() throws IOException {
        initStateInfo();
        logStepInfo("Step 1: Create member, only inactive auth, outbound control files then upload to SFTP folder");
        createAndImportMolinaMemberWithInActiveAuth();

        waitETLJobToProcess(3);

        checkSplunkLogForImportingNumberOfMember(gpg, 0);

        logStepInfo("Step 2: Verify client not inserted in DB");
        verifyClientNotExistInDB();
    }
}
