package SmokeTests.AltEVV_Molina;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.GetStateConfig;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SMOKE_AltEVV_TC30923_Molina_Create_Client_Valid extends BaseTest {
    private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"AltEVV_Molina_Client", "Smoke"})
    public void SMOKE_AltEVV_TC30923_Molina_Create_Client_Valid() throws InterruptedException, IOException, ParseException
    {
        state = "Molina";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);

        CommonMethods.verifyPostResponse(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients),
                CommonMethods.propertyfileReader(globalVariables.altevvMolinaClientsGet));
    }
}