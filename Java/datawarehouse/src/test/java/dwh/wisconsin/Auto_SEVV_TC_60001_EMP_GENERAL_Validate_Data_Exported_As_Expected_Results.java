package dwh.wisconsin;

import generic.EmployeeGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60001_EMP_GENERAL_Validate_Data_Exported_As_Expected_Results extends EmployeeGeneralGenericTest {
    @Test
    public void Auto_SEVV_TC_38667_EMP_GENERAL_Validate_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("EMPGENERAL");
        validateHeaderAsExpectedResults("headerEmpGeneral");
    }
}
