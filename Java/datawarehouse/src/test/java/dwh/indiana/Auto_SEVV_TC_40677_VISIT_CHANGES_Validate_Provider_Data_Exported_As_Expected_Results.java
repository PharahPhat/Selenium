package dwh.indiana;

import com.sandata.qtest.QTest;
import generic.VisitChangesGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40677_VISIT_CHANGES_Validate_Provider_Data_Exported_As_Expected_Results extends VisitChangesGenericTest {
    @Test
    @QTest(keys = {"TC-18727"})
    public void Auto_SEVV_TC_40677_VISIT_CHANGES_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0007");
        fileName  = preconditionData.get("VISITCHANGES");
        validateHeaderAsExpectedResults("headerVisitChange");
    }
}
