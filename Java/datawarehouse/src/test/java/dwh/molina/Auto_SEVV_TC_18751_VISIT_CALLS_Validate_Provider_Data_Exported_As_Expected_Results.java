package dwh.molina;

import com.sandata.qtest.QTest;
import generic.VisitCallGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18751_VISIT_CALLS_Validate_Provider_Data_Exported_As_Expected_Results extends VisitCallGenericTest {
    @Test
    @QTest(keys = {"TC-18732"})
    public void Auto_SEVV_TC_18751_VISIT_CALLS_Validate_Provider_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName = preconditionData.get("VISITCALLS");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 19, "Columns are not expected results");
    }
}