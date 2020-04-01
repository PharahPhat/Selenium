package claim.rest.ohio;

import claim.rest.ClaimBaseTest;
import com.interop.data.claim.ClaimDataRecord;
import com.interop.models.claim.ModelVersion;
import com.sandata.qtest.QTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_14450_Test_Rest_Claim_Validation extends ClaimBaseTest {

    public String getClaimDataFileName() {
        return "Auto_SEVV_TC_14450_Test_Rest_Claim_Validation";
    }

    @Test(priority = 2, groups = {"ohio", "restclaim","smoke","high"}, dataProvider = "claimCases")
    @QTest(keys = {"TC-6159","TC-608","TC-607","TC-606","TC-604","TC-603"})
    public void TC_PA_Claim_Model2(ClaimDataRecord record) {
        super.testClaimValidation(ModelVersion.MODEL2, record);
    }

    @Test(priority = 2, groups = {"ohio", "restclaim","smoke","high"}, dataProvider = "claimCases")
    @QTest(keys = {"TC-5406","TC-19912","TC-19913","TC-19914"})
    public void TC_PA_Claim_Model3(ClaimDataRecord record) {
        super.testClaimValidation(ModelVersion.MODEL3, record);
    }

    @Test(priority = 2, groups = {"ohio", "restclaim","non-regression"}, dataProvider = "claimCases")
    @QTest(keys = {"TC-6160 ","TC-5402"})
    public void TC_PA_Claim_Model1(ClaimDataRecord record) {
        super.testClaimValidation(ModelVersion.MODEL1, record);
    }
}
