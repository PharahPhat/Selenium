package dwh.connecticut;

import com.sandata.qtest.QTest;
import generic.VisitChangesGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18727_VISIT_CHANGES_Validate_Provider_Data_Exported_As_Expected_Results extends VisitChangesGenericTest {
    @Test
    @QTest(keys = {"TC-18727"})
    public void Auto_SEVV_TC_18727_VISIT_CHANGES_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0003");
        fileName  = preconditionData.get("VISITCHANGES");
        validateHeaderAsExpectedResults("headerVisitChange");
    }
}
