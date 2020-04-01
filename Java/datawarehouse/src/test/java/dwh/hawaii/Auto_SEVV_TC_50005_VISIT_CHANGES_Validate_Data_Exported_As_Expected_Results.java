package dwh.hawaii;

import com.sandata.qtest.QTest;
import generic.VisitChangesGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_50005_VISIT_CHANGES_Validate_Data_Exported_As_Expected_Results extends VisitChangesGenericTest {
    @Test
    @QTest(keys = {"TC-18727"})
    public void Auto_SEVV_TC_50005_VISIT_CHANGES_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0012");
        fileName  = preconditionData.get("VISITCHANGES");
        validateHeaderAsExpectedResults("headerVisitChange");
    }
}
