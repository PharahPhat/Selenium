package altevv.pennsylvania.visit;


import claim.rest.ClaimBaseTest;
import com.interop.data.claim.ClaimDataRecord;
import com.interop.models.altevv.visit.AltEvvVisit;
import com.interop.models.db.stx.STXVisit_Claim;
import com.interop.common.StateAccount;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Auto_SEVV_19270_MCOBillingUnits extends ClaimBaseTest {
    private List<AltEvvVisit> visitModelList = new ArrayList<>();

    @Test
    public void TC_PA_Claim_Model2() {
        visitModelList = super.prepareTestDataIfNeeded();
    }

    public String getClaimDataFileName() {
        return "Claim/SEVV_6962_ClaimData";
    }

    @Test(priority = 2, groups = {"pennsylvania", "restclaim"}, dataProvider = "getVisitRows", dependsOnMethods = "TC_PA_Claim_Model2")
    public void TC_19270_MCOBillingUnits(ClaimDataRecord record) {
        List<STXVisit_Claim> stxVisitClaims = STXVisit_Claim.getSTXVisitClaim
                (StateAccount.loadStateAccount().getAccountID(), record.getPayer(), visitModelList.get(0).getSequenceID());
        baseObj.info("Verify Bill Units");
        baseObj.validateActualAndExpectedText(stxVisitClaims.get(0).getBILL_UNITS().toString(), record.getUnits());
        visitModelList.remove(0);
    }
}
