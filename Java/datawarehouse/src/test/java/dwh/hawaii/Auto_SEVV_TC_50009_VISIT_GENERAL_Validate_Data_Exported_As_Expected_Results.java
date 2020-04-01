package dwh.hawaii;

import com.sandata.qtest.QTest;
import generic.VisitGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_50009_VISIT_GENERAL_Validate_Data_Exported_As_Expected_Results extends VisitGenericTest {
    @Test
    @QTest(keys = {"TC-18735"})
    public void Auto_SEVV_TC_50009_VISIT_GENERAL_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0012");
        fileName  = preconditionData.get("VISITGENERAL");
        validateHeaderAsExpectedResults("headerVisitGeneral");
    }
}
