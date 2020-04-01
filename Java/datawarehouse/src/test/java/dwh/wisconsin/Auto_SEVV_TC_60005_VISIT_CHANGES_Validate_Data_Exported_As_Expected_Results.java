package dwh.wisconsin;

import generic.VisitChangesGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60005_VISIT_CHANGES_Validate_Data_Exported_As_Expected_Results extends VisitChangesGenericTest {
    @Test
    public void Auto_SEVV_TC_38671_VISIT_CHANGES_Validate_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("VISITCHANGES");
        validateHeaderAsExpectedResults("headerVisitChange");
    }
}
