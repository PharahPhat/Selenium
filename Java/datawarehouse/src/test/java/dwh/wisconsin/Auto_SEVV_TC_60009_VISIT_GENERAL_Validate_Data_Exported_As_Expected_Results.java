package dwh.wisconsin;

import generic.VisitGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60009_VISIT_GENERAL_Validate_Data_Exported_As_Expected_Results extends VisitGenericTest {
    @Test
    public void Auto_SEVV_TC_38675_VISIT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("VISITGENERAL");
        validateHeaderAsExpectedResults("headerVisitGeneral");
    }
}
