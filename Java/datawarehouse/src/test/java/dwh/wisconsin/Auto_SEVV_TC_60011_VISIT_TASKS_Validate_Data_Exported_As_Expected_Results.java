package dwh.wisconsin;

import generic.VisitTasksGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60011_VISIT_TASKS_Validate_Data_Exported_As_Expected_Results extends VisitTasksGenericTest {

    @Test
    public void Auto_SEVV_TC_38677_VISIT_TASKS_Validate_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("VISIT_TASKS");
        validateHeaderAsExpectedResults("headerVisitTasks");

    }
}
