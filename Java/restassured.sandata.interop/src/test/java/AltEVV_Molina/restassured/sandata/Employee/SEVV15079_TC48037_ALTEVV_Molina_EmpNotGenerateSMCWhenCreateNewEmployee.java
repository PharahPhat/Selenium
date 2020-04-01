package AltEVV_Molina.restassured.sandata.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

import static com.globalMethods.core.globalVariables.EmployeeEmail;
import static com.globalMethods.core.globalVariables.altevv_Molina_emp;

public class SEVV15079_TC48037_ALTEVV_Molina_EmpNotGenerateSMCWhenCreateNewEmployee extends BaseTest {
    private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();
    private Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();

    @Test
    public void TC48037_ALTEVV_Molina_EmpNotGenerateSMCWhenCreateNewEmployee() throws IOException, ParseException,
            InterruptedException, SQLException, ClassNotFoundException, java.text.ParseException {
        JSONArray jsonArray = generateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
        JSONObject js = (JSONObject) jsonArray.get(0);

        CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(altevv_Molina_emp));

        assertionDbVerifier.verifyExistingDataIn_STX_App_User(js.get(EmployeeEmail).toString());
        assertionDbVerifier.verifyNotExistingDataIn_STX_MVV_User(js.get(EmployeeEmail).toString());
    }
}
