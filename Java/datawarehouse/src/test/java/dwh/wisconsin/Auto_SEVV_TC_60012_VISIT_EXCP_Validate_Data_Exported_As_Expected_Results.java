package dwh.wisconsin;

import generic.VisitExceptionGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60012_VISIT_EXCP_Validate_Data_Exported_As_Expected_Results extends VisitExceptionGenericTest {

    @Test
    public void Auto_SEVV_TC_38678_VISIT_EXCP_Validate_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("VISIT_EXCP");
        validateHeaderAsExpectedResults("headerVisitExcp");

    }

}
