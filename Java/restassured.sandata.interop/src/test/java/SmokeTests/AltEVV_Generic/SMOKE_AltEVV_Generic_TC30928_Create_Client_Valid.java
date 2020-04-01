package SmokeTests.AltEVV_Generic;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.GetStateConfig;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SMOKE_AltEVV_Generic_TC30928_Create_Client_Valid extends BaseTest {
    private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"AltEVV_Generic_Client", "Smoke"})
    public void SMOKE_AltEVV_Generic_TC30928_Create_Client_Valid() throws InterruptedException, IOException, ParseException
    {
        state = "Indiana";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);

        CommonMethods.verifyPostResponse(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.altevv_clients),
                CommonMethods.propertyfileReader(globalVariables.altevv_client_get));
    }
}
