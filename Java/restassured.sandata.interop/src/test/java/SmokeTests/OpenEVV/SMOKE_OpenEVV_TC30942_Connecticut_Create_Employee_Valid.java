package SmokeTests.OpenEVV;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.GetStateConfig;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.testng.annotations.Test;

public class SMOKE_OpenEVV_TC30942_Connecticut_Create_Employee_Valid extends BaseTest {
    private com.globalMethods.core.GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"OpenEVV_Connecticut_Employee", "Smoke"})
    public void SMOKE_OpenEVV_TC30942_Connecticut_Create_Employee_Valid() throws Exception {
        state = "Connecticut";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray = generateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

        CommonMethods.verifyPostResponse(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.openevv_emp_url),
                CommonMethods.propertyfileReader(globalVariables.Emp_get_url));
    }
}
