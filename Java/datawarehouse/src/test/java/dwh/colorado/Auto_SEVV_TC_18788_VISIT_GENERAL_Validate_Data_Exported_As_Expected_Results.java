package dwh.colorado;

import com.sandata.qtest.QTest;
import generic.VisitGenericTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18788_VISIT_GENERAL_Validate_Data_Exported_As_Expected_Results extends VisitGenericTest {

    @BeforeMethod
    public void precondition(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("VISITGENERAL");
    }

    @Test
    @QTest(keys = {"TC-18735"})
    public void Auto_SEVV_TC_18788_VISIT_GENERAL_Validate_Data_Exported_As_Expected_Header_Results(){
        validateHeaderAsExpectedResults("headerVisitGeneral");
    }
}
