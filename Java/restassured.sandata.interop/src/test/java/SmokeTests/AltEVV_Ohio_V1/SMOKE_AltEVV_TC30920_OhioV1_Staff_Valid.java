package SmokeTests.AltEVV_Ohio_V1;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.GetStateConfig;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.staff.v1.DataGenerator_staff_v1;
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

public class SMOKE_AltEVV_TC30920_OhioV1_Staff_Valid extends BaseTest {
    private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"AltEVV_Ohio_V1_Staff", "Smoke"})
    public void SMOKE_AltEVV_TC30920_OhioV1_Staff_Valid() throws InterruptedException, IOException, ParseException {

        logger.log(LogStatus.INFO, GlobalVariable_staff_v1.generateFieldValue);
        state = "Ohio";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray = generateUniqueParam.staff_Ohio();

        CommonMethods.verifyPostResponseOhio(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1),
                CommonMethods.propertyfileReader(globalVariables.ohio_staff_get_v1));
        }
}