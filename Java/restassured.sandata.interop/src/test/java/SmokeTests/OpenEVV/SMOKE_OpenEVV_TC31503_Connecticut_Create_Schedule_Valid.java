package SmokeTests.OpenEVV;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.GetStateConfig;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.testng.annotations.Test;

public class SMOKE_OpenEVV_TC31503_Connecticut_Create_Schedule_Valid extends BaseTest {
    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();
    @Test(groups = {"OpenEVV_Connecticut_Schedule", "Smoke"})
    public void SMOKE_OpenEVV_TC31503_Connecticut_Create_Schedule_Valid() throws Exception {
        state = "Connecticut";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArr = generateUniqueParam.Scheduling_Openevv();

        CommonMethods.verifyPostResponse(jsonArr,
                CommonMethods.propertyfileReader(globalVariables.openevv_schedule),
                CommonMethods.propertyfileReader(globalVariables.openevv_schedule_get));
    }
}
