package dwh.ohio;

import generic.EmployeeDisciplineTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18766_EMP_DISC_Validate_Provider_Data_Exported_As_Expected_Results extends EmployeeDisciplineTest {

    @Test
    public void Auto_SEVV_TC_18749_EMP_DISC_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_99999");
        ohioExportedFileName  = preconditionData.get("exportFile");
        validateEmployeeDisciplineAsExpectedResults();
    }

}
