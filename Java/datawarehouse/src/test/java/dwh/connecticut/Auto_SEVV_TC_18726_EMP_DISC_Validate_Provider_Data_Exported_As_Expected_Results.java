package dwh.connecticut;

import com.sandata.qtest.QTest;
import generic.EmployeeDisciplineTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18726_EMP_DISC_Validate_Provider_Data_Exported_As_Expected_Results extends EmployeeDisciplineTest {
    @Test
    @QTest(keys = {"TC-18726"})
    public void Auto_SEVV_TC_18726_EMP_DISC_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0003");
        fileName  = preconditionData.get("EMPDISC");
        validateHeaderAsExpectedResults("headerEmpDisc");
    }
}
