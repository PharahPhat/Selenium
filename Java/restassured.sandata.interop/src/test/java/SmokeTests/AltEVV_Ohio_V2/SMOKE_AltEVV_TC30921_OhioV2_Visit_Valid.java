package SmokeTests.AltEVV_Ohio_V2;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.ohio.intake.VisitV2.GlobalVariable_Ohio_Visit_v2;
import com.ohio.intake.VisitV2.UniqueJsonGenerator_Ohio_Visit_v2;
import com.ohio.intake.staff.v1.GlobalVariable_staff_v1;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SMOKE_AltEVV_TC30921_OhioV2_Visit_Valid extends BaseTest{
    private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"AltEVV_Ohio_V2_Visit", "Smoke"})
    public void SMOKE_AltEVV_TC30921_OhioV2_Visit_Valid() throws InterruptedException, IOException, ParseException {
        state = "Ohio";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray = generateUniqueParam.visit_Ohio(globalVariables.Ohio_visit_v2_json);

        CommonMethods.verifyPostResponseOhio(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.ohio_visit_v2),
                CommonMethods.propertyfileReader(globalVariables.ohio_visit_get_v2));
    }
}
