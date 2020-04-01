package dwh.colorado;

import com.sandata.qtest.QTest;
import generic.VisitChangesGenericTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18784_VISIT_CHANGES_Validate_Data_Exported_As_Expected_Results extends VisitChangesGenericTest {

    @BeforeMethod
    public void precondition(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("VISITCHANGES");
    }

    @Test
    @QTest(keys = {"TC-18727"})
    public void Auto_SEVV_TC_18784_VISIT_CHANGES_Validate_Data_Exported_As_Expected_Header_Results(){
        validateHeaderAsExpectedResults("headerVisitChanges");
    }
}
