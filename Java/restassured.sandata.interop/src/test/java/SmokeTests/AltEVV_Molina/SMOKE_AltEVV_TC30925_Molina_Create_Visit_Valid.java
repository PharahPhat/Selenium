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

public class SMOKE_AltEVV_TC30925_Molina_Create_Visit_Valid extends BaseTest {
    private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"AltEVV_Molina_Visit", "Smoke"})
    public void SMOKE_AltEVV_TC30925_Molina_Create_Visit_Valid() throws InterruptedException, IOException,
            ParseException {
        state = "Molina";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV_Molina();

        CommonMethods.verifyPostResponse(jsonArrayVisit,
                CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit),
                CommonMethods.propertyfileReader(globalVariables.altevv_Molina_visit_get));
    }
}