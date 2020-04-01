package SmokeTests.OpenEVV;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.GetStateConfig;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/**
 * Client hasn't used yet
 */
public class SMOKE_OpenEVV_TC31502_PA_Create_Member_Valid extends BaseTest {
    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();
    @Test(groups = {"OpenEVV_PA_Member", "Smoke"}, enabled = false)
    public void SMOKE_OpenEVV_TC31502_PA_Create_Member_Valid() throws Exception {
        state = "PA";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray = generateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);

        CommonMethods.verifyPostResponse(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.member_post_url),
                CommonMethods.propertyfileReader(globalVariables.member_get_url));
    }
}
