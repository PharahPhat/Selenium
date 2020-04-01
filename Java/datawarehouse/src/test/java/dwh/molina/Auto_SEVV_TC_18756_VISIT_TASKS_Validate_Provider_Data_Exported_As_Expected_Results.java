package dwh.molina;

import com.sandata.qtest.QTest;
import generic.VisitTasksGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18756_VISIT_TASKS_Validate_Provider_Data_Exported_As_Expected_Results extends VisitTasksGenericTest {

    @Test
    @QTest(keys = {"TC-18738"})
    public void Auto_SEVV_TC_18756_VISIT_TASKS_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("VISITTASKS");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 8, "Columns are not expected results");
    }
}
