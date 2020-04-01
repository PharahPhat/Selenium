package dwh.pennsylvania;

import com.sandata.qtest.QTest;
import generic.VisitChangesGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40742_VISIT_CHANGES_Validate_Data_Exported_As_Expected_Results extends VisitChangesGenericTest {

    @Test
    @QTest(keys = {"TC-18727"})
    public void Auto_SEVV_TC_18784_VISIT_CHANGES_Validate_Data_Exported_As_Expected_Header_Results(){
        initStateInfo();
        GetPreconditionData("TC_0006");
        fileName  = preconditionData.get("VISITCHANGES");
        validateHeaderAsExpectedResults("headerVisitChanges");
    }

}
