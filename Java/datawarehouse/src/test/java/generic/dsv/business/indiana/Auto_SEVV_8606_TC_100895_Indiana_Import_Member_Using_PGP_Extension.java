package generic.dsv.business.indiana;

import com.sandata.common.Constant;
import generic.import_feature.indiana.ImportIndianaMemberGenericTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Auto_SEVV_8606_TC_100895_Indiana_Import_Member_Using_PGP_Extension extends ImportIndianaMemberGenericTest {
    @Test(enabled = true, groups = {"All"})
    public void Auto_SEVV_8606_TC_100895_Indiana_Import_Member_Using_PGP_Extension() throws IOException {
        logStepInfo("Step 1: Create member, only inactive auth, outbound control files then upload to SFTP folder");
        createAndImportMemberWithActiveAuth(Constant.EXTENSION.pgp);

        logStepInfo("Step 2: Verify client inserted in DB");
        verifyClientExistInDBForIndiana();
    }
}
