package dwh.hawaii;

import com.sandata.qtest.QTest;
import generic.EmployeeGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_50001_EMP_GENERAL_Validate_Data_Exported_As_Expected_Results extends EmployeeGeneralGenericTest{
    @Test
    @QTest(keys = {"TC-18722"})
    public void Auto_SEVV_TC_50001_EMP_GENERAL_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0012");
        fileName  = preconditionData.get("EMPGENERAL");
        validateHeaderAsExpectedResults("headerEmpGeneral");
    }
}
