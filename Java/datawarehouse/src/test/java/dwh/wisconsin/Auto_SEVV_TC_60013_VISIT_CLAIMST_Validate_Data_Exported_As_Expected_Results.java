package dwh.wisconsin;

import generic.VisitClaimstGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60013_VISIT_CLAIMST_Validate_Data_Exported_As_Expected_Results extends VisitClaimstGenericTest {

    @Test
    public void Auto_SEVV_TC_38679_VISIT_CLAIMST_Validate_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("VISIT_CLAIMST");
        validateHeaderAsExpectedResults("headerVisitClaimst");
    }
}
