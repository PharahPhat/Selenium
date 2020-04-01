package SmokeTests.OpenEVV;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.GetStateConfig;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class SMOKE_OpenEVV_TC30943_Connecticut_Create_Xref_Valid extends BaseTest {
    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();

    @Test(groups = {"OpenEVV_Connecticut_Xref", "Smoke"})
    public void SMOKE_OpenEVV_TC30943_Connecticut_Create_Xref_Valid() throws Exception {
        state = "Connecticut";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray= generateUniqueParam.XrefParams(globalVariables.xref_json);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        jsonObject.put(globalVariables.ClientIDQualifier, "ClientOtherID");
        CommonMethods.verifyPostResponse(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.openevv_xref_url),
                CommonMethods.propertyfileReader(globalVariables.openevv_xref_get));
    }
}
