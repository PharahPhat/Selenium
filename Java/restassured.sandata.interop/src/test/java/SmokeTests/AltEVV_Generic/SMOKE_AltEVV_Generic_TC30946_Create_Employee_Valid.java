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

public class SMOKE_AltEVV_Generic_TC30946_Create_Employee_Valid extends BaseTest {
    private com.globalMethods.core.GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"AltEVV_Generic_Employee", "Smoke"})
    public void SMOKE_AltEVV_Generic_TC30946_Create_Employee_Valid() throws InterruptedException,
            IOException, ParseException
    {
        state = "Indiana";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.staff_intake_json);

        CommonMethods.verifyPostResponse(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.altevv_emp),
                CommonMethods.propertyfileReader(globalVariables.altevv_emp_get));
    }
}
