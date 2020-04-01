package dwh.pennsylvania;

import com.sandata.qtest.QTest;
import generic.EmployeeGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40738_EMP_GENERAL_Validate_Data_Exported_As_Expected_Results extends EmployeeGeneralGenericTest{

    @Test
    @QTest(keys = {"TC-18722"})
    public void Auto_SEVV_TC_18780_EMP_GENERAL_Validate_Data_Exported_As_Expected_Header_Results(){
        initStateInfo();
        GetPreconditionData("TC_0006");
        fileName  = preconditionData.get("EMPGENERAL");
        validateHeaderAsExpectedResults("headerEmployeeGeneral");
    }

    @Test
    public void Auto_SEVV_TC_18746_EMP_GENERAL_Validate_Data_Exported_As_Expected_Format(){
        initStateInfo();
        GetPreconditionData("TC_0006");
        fileName  = preconditionData.get("EMPGENERAL");
        //validateEmployeeGeneralFileIsGeneratedAsExprectedFormat();
        validateEmployeeGeneralDataAsExpectedResult(true,22);
    }
}
