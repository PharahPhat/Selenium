package dwh.wisconsin;

import generic.VisitCallGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60006_VISIT_CALLS_Validate_Data_Exported_As_Expected_Results extends VisitCallGenericTest {
    @Test
    public void Auto_SEVV_TC_38672_VISIT_CALLS_Validate_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("VISITCALLS");
        validateHeaderAsExpectedResults("headerVisitCall");
    }
}
