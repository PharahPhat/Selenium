package dwh.colorado;

import com.sandata.qtest.QTest;
import generic.VisitExceptionGenericTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18791_VISIT_EXCP_Validate_Data_Exported_As_Expected_Results extends VisitExceptionGenericTest {

    @BeforeMethod
    public void precondition(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("VISIT_EXCP");
    }

    @Test
    @QTest(keys = {"TC-18739"})
    public void Auto_SEVV_TC_18791_VISIT_EXCP_Validate_Data_Exported_As_Expected_Header_Results(){
        validateHeaderAsExpectedResults("headerVisitExcp");
    }
}
