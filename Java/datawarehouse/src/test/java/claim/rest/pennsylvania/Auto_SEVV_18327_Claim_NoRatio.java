/**
 * account: PAOpenEVV
 */
package claim.rest.pennsylvania;

import com.interop.data.claim.ClaimDataRecord;
import com.interop.models.claim.ModelVersion;
import com.sandata.qtest.QTest;
import org.testng.annotations.Test;
import claim.rest.ClaimBaseTest;

public class Auto_SEVV_18327_Claim_NoRatio extends ClaimBaseTest {

    public String getClaimDataFileName(){
        return "SEVV_18327_Claim_NoRatio";
    }

    @Test(priority = 2, groups = {"pennsylvania", "restclaim","smoke","high"}, dataProvider = "claimCases")
    @QTest(keys = {"TC-21432"})
    public void TC_PA_Claim_Model2(ClaimDataRecord record) {
       super.testClaimValidation(ModelVersion.MODEL2, record);
    }

    @Test(priority = 2, groups = {"pennsylvania", "restclaim","smoke","high"}, dataProvider = "claimCases")
    @QTest(keys = {"TC-21548"})
    public void TC_PA_Claim_Model3(ClaimDataRecord record) {
        super.testClaimValidation(ModelVersion.MODEL3, record);
    }
}
