package dwh.connecticut;

import com.sandata.qtest.QTest;
import generic.VisitCallGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18732_VISIT_CALLS_Validate_Provider_Data_Exported_As_Expected_Results extends VisitCallGenericTest {
    @Test
    @QTest(keys = {"TC-18732"})
    public void Auto_SEVV_TC_18732_VISIT_CALLS_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0003");
        fileName  = preconditionData.get("VISITCALLS");
        validateHeaderAsExpectedResults("headerVisitCall");
    }
}
