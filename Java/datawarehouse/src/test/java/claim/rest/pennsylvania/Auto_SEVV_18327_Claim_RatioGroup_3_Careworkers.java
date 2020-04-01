package claim.rest.pennsylvania;

import com.interop.data.claim.ClaimDataRecord;
import com.interop.models.claim.ModelVersion;
import com.sandata.qtest.QTest;
import org.testng.annotations.Test;
import claim.rest.ClaimBaseTest;

public class Auto_SEVV_18327_Claim_RatioGroup_3_Careworkers extends ClaimBaseTest {

    public String getClaimDataFileName(){
        return "SEVV_18327_Claim_RatioGroup_3_Careworkers";
    }


    @Test(priority = 2, groups = {"pennsylvania", "restclaim", "onlyDev"}, dataProvider = "claimCases")
    public void TC_PA_Claim_Model2(ClaimDataRecord record) {
       super.testClaimValidation(ModelVersion.MODEL2, record);
    }

    @Test(priority = 2, groups = {"pennsylvania", "restclaim", "onlyDev"}, dataProvider = "claimCases")
    @QTest(keys = {"TC-21446","TC-21447","TC-21448","TC-21449","TC-21452","TC-21450"})
    public void TC_PA_Claim_Model3(ClaimDataRecord record) {
        super.testClaimValidation(ModelVersion.MODEL3, record);
    }
}
