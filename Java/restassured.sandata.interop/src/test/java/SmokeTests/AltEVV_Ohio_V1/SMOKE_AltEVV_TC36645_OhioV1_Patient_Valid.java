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
import java.sql.SQLException;

public class SMOKE_AltEVV_TC36645_OhioV1_Patient_Valid extends BaseTest {
    private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"AltEVV_Ohio_V1_Patient", "Smoke"})
    public void SMOKE_AltEVV_TC36645_OhioV1_Patient_Valid() throws java.text.ParseException, IOException,
            ParseException, SQLException, InterruptedException, ClassNotFoundException
    {
        state = "Ohio";
        stateInfo = GetStateConfig.getStateInfo(environment, state);
        JSONArray jsonArray = GenerateUniqueParam.patient_Ohio(globalVariables.Ohio_patientJson_v1);

        CommonMethods.verifyPostResponseOhio(jsonArray,
                CommonMethods.propertyfileReader(globalVariables.ohio_patient_v1),
                CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));
    }
}
