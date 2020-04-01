package dwh.ohio;

import generic.VisitCallGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18768_VISIT_CALLS_Validate_Provider_Data_Exported_As_Expected_Results extends VisitCallGenericTest {
    @Test
    public void Auto_SEVV_TC_18751_VISIT_CALLS_Validate_Provider_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_99999");
        ohioExportedFileName  = preconditionData.get("exportFile");
        validateOhioVisitCallFromJsonData();
    }
}
