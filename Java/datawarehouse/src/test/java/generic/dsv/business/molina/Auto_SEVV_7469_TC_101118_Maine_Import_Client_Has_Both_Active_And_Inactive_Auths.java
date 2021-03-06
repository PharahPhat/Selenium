package generic.dsv.business.molina;

import generic.import_feature.molina.ImportMolinaGenericTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sandata.common.Constant.EXTENSION.gpg;

public class Auto_SEVV_7469_TC_101118_Maine_Import_Client_Has_Both_Active_And_Inactive_Auths extends ImportMolinaGenericTest {

    @Test(enabled = true, groups = {"All"})
    public void Auto_SEVV_7469_TC_101118_Maine_Import_Client_Has_Both_Active_And_Inactive_Auths() throws IOException {
        initStateInfo();
        logStepInfo("Step 1: Create member, both active & inactive auth, outbound control files then upload to SFTP folder");
        createAndImportMolinaMemberWithActiveAndInActiveAuth();

        waitETLJobToProcess(3);

        checkSplunkLogForImportingNumberOfMember(gpg, 1);

        logStepInfo("Step 2: Verify client inserted in DB");
        verifyClientExistInDB();
    }
}
