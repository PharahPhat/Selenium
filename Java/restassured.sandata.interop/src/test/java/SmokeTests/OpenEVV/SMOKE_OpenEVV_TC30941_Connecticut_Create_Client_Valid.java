package SmokeTests.OpenEVV;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.GetStateConfig;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SMOKE_OpenEVV_TC30941_Connecticut_Create_Client_Valid extends BaseTest {
    private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"OpenEVV_Connecticut_Client", "Smoke"})
    public void SMOKE_OpenEVV_TC30941_Connecticut_Create_Client_Valid() throws Exception {
        state = "Connecticut";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray =generateUniqueParam.ClientParams_OpenEVV("client");
        CommonMethods.verifyPostResponse(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.openevv_client_url),
                CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
    }
}
