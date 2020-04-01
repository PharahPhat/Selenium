package SmokeTests.OpenEVV;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.GetStateConfig;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.testng.annotations.Test;

/**
 * Client hasn't used yet
 */
public class SMOKE_OpenEVV_TC31508_PA_Create_Auth_Valid extends BaseTest {
    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();

    @Test(groups = {"OpenEVV_PA_Authorization", "Smoke", "Bug"})
    public void SMOKE_OpenEVV_TC31508_PA_Create_Auth_Valid() throws Exception {
        state = "PA";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray = generateUniqueParam.OpenEVV_auth(globalVariables.Auth_json);

        CommonMethods.verifyPostResponse(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.openEVV_auth),
                CommonMethods.propertyfileReader(globalVariables.openEVV_auth_get));
    }
}
