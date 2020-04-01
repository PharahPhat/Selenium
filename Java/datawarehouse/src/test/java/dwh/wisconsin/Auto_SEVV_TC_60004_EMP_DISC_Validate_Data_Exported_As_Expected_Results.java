package dwh.wisconsin;

import generic.EmployeeDisciplineTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60004_EMP_DISC_Validate_Data_Exported_As_Expected_Results extends EmployeeDisciplineTest {
    @Test
    public void Auto_SEVV_TC_38670_EMP_DISC_Validate_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("EMPDISC");
        validateHeaderAsExpectedResults("headerEmpDisc");
    }
}
