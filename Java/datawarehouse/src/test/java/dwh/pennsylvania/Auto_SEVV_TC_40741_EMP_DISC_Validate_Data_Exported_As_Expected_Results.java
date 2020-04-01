package dwh.pennsylvania;

import com.sandata.qtest.QTest;
import generic.EmployeeDisciplineTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40741_EMP_DISC_Validate_Data_Exported_As_Expected_Results extends EmployeeDisciplineTest {

    @Test
    @QTest(keys = {"TC-18726"})
    public void Auto_SEVV_TC_18783_EMP_DISC_Validate_Data_Exported_As_Expected_Header_Results(){
        initStateInfo();
        GetPreconditionData("TC_0006");
        fileName  = preconditionData.get("EMPDISC");
        validateHeaderAsExpectedResults("headerEmpDisc");
    }
}
