package dwh.colorado;

import com.sandata.qtest.QTest;
import generic.VisitCallGenericTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18785_VISIT_CALLS_Validate_Data_Exported_As_Expected_Results extends VisitCallGenericTest {

    @BeforeMethod
    public void precondition(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("VISITCALLS");
    }

    @Test
    @QTest(keys = {"TC-18732"})
    public void Auto_SEVV_TC_18785_VISIT_CALLS_Validate_Data_Exported_As_Expected_Header_Results(){
        validateHeaderAsExpectedResults("headerVisitCalls");
    }
}
