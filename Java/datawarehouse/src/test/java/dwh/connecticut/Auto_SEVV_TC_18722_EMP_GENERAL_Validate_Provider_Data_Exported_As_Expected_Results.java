package dwh.connecticut;

import com.sandata.qtest.QTest;
import generic.EmployeeGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18722_EMP_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results extends EmployeeGeneralGenericTest{
    @Test
    @QTest(keys = {"TC-18722"})
    public void Auto_SEVV_TC_18722_EMP_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0003");
        fileName  = preconditionData.get("EMPGENERAL");
        validateHeaderAsExpectedResults("headerEmpGeneral");
    }
}
