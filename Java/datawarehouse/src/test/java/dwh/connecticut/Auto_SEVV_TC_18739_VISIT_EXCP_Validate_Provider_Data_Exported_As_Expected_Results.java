package dwh.connecticut;

import com.sandata.qtest.QTest;
import generic.VisitExceptionGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18739_VISIT_EXCP_Validate_Provider_Data_Exported_As_Expected_Results extends VisitExceptionGenericTest {

    @Test
    @QTest(keys = {"TC-18739"})
    public void Auto_SEVV_TC_18739_VISIT_EXCP_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0003");
        fileName  = preconditionData.get("VISIT_EXCP");
        validateHeaderAsExpectedResults("headerVisitExcp");

    }

}
