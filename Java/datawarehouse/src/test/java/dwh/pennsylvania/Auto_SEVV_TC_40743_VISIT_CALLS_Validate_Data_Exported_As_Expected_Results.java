package dwh.pennsylvania;

import com.sandata.qtest.QTest;
import generic.VisitCallGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40743_VISIT_CALLS_Validate_Data_Exported_As_Expected_Results extends VisitCallGenericTest {

    @Test
    @QTest(keys = {"TC-18732"})
    public void Auto_SEVV_TC_18785_VISIT_CALLS_Validate_Data_Exported_As_Expected_Header_Results(){
        initStateInfo();
        GetPreconditionData("TC_0006");
        fileName  = preconditionData.get("VISITCALLS");
        validateHeaderAsExpectedResults("headerVisitCalls");
    }

}
