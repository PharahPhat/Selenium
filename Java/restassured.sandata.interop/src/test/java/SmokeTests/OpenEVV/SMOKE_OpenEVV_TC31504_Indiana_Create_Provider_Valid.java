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
public class SMOKE_OpenEVV_TC31504_Indiana_Create_Provider_Valid extends BaseTest {
    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();

    @Test(groups = {"OpenEVV_Provider"}, enabled = false)
    public void SMOKE_OpenEVV_TC31504_Indiana_Create_Provider_Valid() throws Exception {
        state = "Indiana";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray = generateUniqueParam.ProviderParams_OpenEVV(globalVariables.openevv_provider_json);

        CommonMethods.verifyPostResponseIndiana_Provider(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.provider_post_url),
                CommonMethods.propertyfileReader(globalVariables.provider_get_url));
    }
}
