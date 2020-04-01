package SmokeTests.AltEVV_Ohio_V2;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.GetStateConfig;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class SMOKE_AltEVV_TC29636_OhioV2_Create_Patient_Valid extends BaseTest {
    private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"AltEVV_Ohio_V2_Patient", "Smoke"})
    public void SMOKE_AltEVV_TC29636_OhioV2_Create_Patient_Valid() throws SQLException, InterruptedException,
            ParseException, IOException, org.json.simple.parser.ParseException, ClassNotFoundException {
        state = "Ohio";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.patientIntake_v2);
        CommonMethods.verifyPostResponseOhio(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.ohio_patient_v2),
                CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v2));
    }
}
