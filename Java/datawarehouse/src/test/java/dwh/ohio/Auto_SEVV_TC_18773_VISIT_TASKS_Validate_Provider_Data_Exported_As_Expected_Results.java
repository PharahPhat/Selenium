package dwh.ohio;

import generic.VisitTasksGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18773_VISIT_TASKS_Validate_Provider_Data_Exported_As_Expected_Results extends VisitTasksGenericTest {

    @Test
    public void Auto_SEVV_TC_18756_VISIT_TASKS_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0009");
        fileName  = preconditionData.get("VISITTASKS");
        //validateProviderGeneralIsGeneratedAsExpectedResults();
    }
}
