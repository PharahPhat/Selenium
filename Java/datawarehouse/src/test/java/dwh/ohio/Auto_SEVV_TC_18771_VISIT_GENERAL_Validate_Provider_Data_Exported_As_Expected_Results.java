package dwh.ohio;

import generic.VisitGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18771_VISIT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results extends VisitGenericTest {
    @Test
    public void Auto_SEVV_TC_18754_VISIT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_99999");
        ohioExportedFileName  = preconditionData.get("exportFile");
        validateOhioVisitFromJsonData();
    }
}
