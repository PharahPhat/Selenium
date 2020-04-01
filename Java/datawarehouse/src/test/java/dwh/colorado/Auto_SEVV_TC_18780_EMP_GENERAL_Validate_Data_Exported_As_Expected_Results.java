package dwh.colorado;

import com.sandata.qtest.QTest;
import generic.EmployeeGeneralGenericTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18780_EMP_GENERAL_Validate_Data_Exported_As_Expected_Results extends EmployeeGeneralGenericTest{

    @BeforeMethod
    public void precondition(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("EMPGENERAL");
    }

    @Test
    @QTest(keys = {"TC-18722"})
    public void Auto_SEVV_TC_18780_EMP_GENERAL_Validate_Data_Exported_As_Expected_Header_Results(){
        validateHeaderAsExpectedResults("headerEmployeeGeneral");
    }
}
