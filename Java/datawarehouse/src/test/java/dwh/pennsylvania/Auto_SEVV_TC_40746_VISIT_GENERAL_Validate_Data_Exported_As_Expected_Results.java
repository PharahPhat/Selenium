package dwh.pennsylvania;

import com.sandata.qtest.QTest;
import generic.VisitGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40746_VISIT_GENERAL_Validate_Data_Exported_As_Expected_Results extends VisitGenericTest {

    @Test
    @QTest(keys = {"TC-18735"})
    public void Auto_SEVV_TC_18788_VISIT_GENERAL_Validate_Data_Exported_As_Expected_Header_Results(){
        initStateInfo();
        GetPreconditionData("TC_0006");
        fileName  = preconditionData.get("VISITGENERAL");
        validateHeaderAsExpectedResults("headerVisitGeneral");
    }
}
