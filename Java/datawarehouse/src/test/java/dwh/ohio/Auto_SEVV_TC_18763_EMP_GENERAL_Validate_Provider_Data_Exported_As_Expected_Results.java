package dwh.ohio;

import generic.EmployeeGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18763_EMP_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results extends EmployeeGeneralGenericTest {
    @Test
    public void Auto_SEVV_TC_18763_EMP_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_99999");
        ohioExportedFileName  = preconditionData.get("exportFile");
        validateOhioStaffHeaderFromJsonData();
    }
}
