/**
 * account: PAOpenEVV
 */
package claim.rest.pennsylvania;

import claim.rest.ClaimBaseTest;
import com.interop.data.claim.ClaimDataRecord;
import com.interop.models.claim.ModelVersion;
import org.testng.annotations.Test;

public class Auto_SEVV_18327_Claim_RatioGroup_2_Careworkers extends ClaimBaseTest {

    public String getClaimDataFileName(){
        return "SEVV_18327_Claim_RatioGroup_2_Careworkers";
    }

    @Test(priority = 2, groups = {"pennsylvania", "restclaim","ignore"}, dataProvider = "claimCases")
    public void TC_PA_Claim_Model2(ClaimDataRecord record) {
       super.testClaimValidation(ModelVersion.MODEL2, record);
    }

    @Test(priority = 2, groups = {"pennsylvania", "restclaim","ignore"}, dataProvider = "claimCases")
    public void TC_PA_Claim_Model3(ClaimDataRecord record) {
        super.testClaimValidation(ModelVersion.MODEL3, record);
    }
}
