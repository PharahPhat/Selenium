package dwh.hawaii;

import com.sandata.qtest.QTest;
import generic.VisitTasksGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_50011_VISIT_TASKS_Validate_Data_Exported_As_Expected_Results extends VisitTasksGenericTest {

    @Test
    @QTest(keys = {"TC-18738"})
    public void Auto_SEVV_TC_50011_VISIT_TASKS_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0012");
        fileName  = preconditionData.get("VISIT_TASKS");
        validateHeaderAsExpectedResults("headerVisitTasks");

    }
}
