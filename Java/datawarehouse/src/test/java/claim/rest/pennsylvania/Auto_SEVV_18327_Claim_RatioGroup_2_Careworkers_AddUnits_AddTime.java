package claim.rest.pennsylvania;

import com.interop.data.claim.ClaimDataRecord;
import com.interop.models.claim.ModelVersion;
import com.sandata.qtest.QTest;
import org.testng.annotations.Test;
import claim.rest.ClaimBaseTest;

public class Auto_SEVV_18327_Claim_RatioGroup_2_Careworkers_AddUnits_AddTime extends ClaimBaseTest {

    public String getClaimDataFileName(){
        return "SEVV_18327_Claim_RatioGroup_2_Careworkers_AddUnits_AddTime";
    }

    @Test(priority = 2, groups = {"pennsylvania", "restclaim","smoke","high"}, dataProvider = "claimCases")
    @QTest(keys = {"TC-4693","TC-4679","TC-4677","TC-21433","TC-21434","TC-21435","TC-21436","TC-21437","TC-21438","TC-21439","TC-21440","TC-21441","TC-21442","TC-21443","TC-21444","TC-21445","TC-21559"})
    public void TC_PA_Claim_Model2(ClaimDataRecord record) {
       super.testClaimValidation(ModelVersion.MODEL2, record);
    }

    @Test(priority = 2, groups = {"pennsylvania", "restclaim","smoke","high"}, dataProvider = "claimCases")
    @QTest(keys = {"TC-5364"})
    public void TC_PA_Claim_Model3(ClaimDataRecord record) {
        super.testClaimValidation(ModelVersion.MODEL3, record);
    }
}
