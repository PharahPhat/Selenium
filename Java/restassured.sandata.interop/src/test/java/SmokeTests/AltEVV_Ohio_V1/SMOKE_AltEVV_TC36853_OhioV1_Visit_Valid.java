package SmokeTests.AltEVV_Ohio_V1;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.GetStateConfig;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SMOKE_AltEVV_TC36853_OhioV1_Visit_Valid extends BaseTest {
    private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"AltEVV_Ohio_V1_Visit", "Smoke"})
    public void SMOKE_AltEVV_TC36853_OhioV1_Visit_Valid() throws InterruptedException, IOException, ParseException {
        state = "Ohio";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray = generateUniqueParam.visit_Ohio(globalVariables.visits_v1);

        CommonMethods.verifyPostResponseOhio(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.ohio_visit_v1),
                CommonMethods.propertyfileReader(globalVariables.ohio_visit_get_v1));
    }
}
