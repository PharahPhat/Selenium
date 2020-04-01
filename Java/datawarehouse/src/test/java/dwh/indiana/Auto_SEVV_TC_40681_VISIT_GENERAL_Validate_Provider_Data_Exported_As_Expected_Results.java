package dwh.indiana;

import com.sandata.qtest.QTest;
import generic.VisitGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40681_VISIT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results extends VisitGenericTest {
    @Test
    @QTest(keys = {"TC-18735"})
    public void Auto_SEVV_TC_40681_VISIT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0007");
        fileName  = preconditionData.get("VISITGENERAL");
        validateHeaderAsExpectedResults("headerVisitGeneral");
    }
}
