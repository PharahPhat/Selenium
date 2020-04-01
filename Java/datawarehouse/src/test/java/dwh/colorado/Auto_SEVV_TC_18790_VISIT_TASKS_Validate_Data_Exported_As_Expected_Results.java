package dwh.colorado;

import com.sandata.qtest.QTest;
import generic.VisitTasksGenericTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18790_VISIT_TASKS_Validate_Data_Exported_As_Expected_Results extends VisitTasksGenericTest {

    @BeforeMethod
    public void precondition(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("VISIT_TASKS");
    }

    @Test
    @QTest(keys = {"TC-18738"})
    public void Auto_SEVV_TC_18790_VISIT_TASKS_Validate_Data_Exported_As_Expected_Header_Results(){
        validateHeaderAsExpectedResults("headerVisitTasks");
    }
}