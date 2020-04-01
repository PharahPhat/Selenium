package dwh.wisconsin;

import generic.VisitClaimstGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60015_CLIENT_DESIGNEE_Validate_Data_Exported_As_Expected_Results extends VisitClaimstGenericTest {

    @Test
    public void Auto_SEVV_TC_40014_CLIENT_AUTH_Validate_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("CLIENT_DESIGNEE");
        validateHeaderAsExpectedResults("headerClientDesignee");
    }
}
