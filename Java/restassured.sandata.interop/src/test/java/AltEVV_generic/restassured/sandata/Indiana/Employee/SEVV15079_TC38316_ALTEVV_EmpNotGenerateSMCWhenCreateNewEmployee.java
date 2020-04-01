package AltEVV_generic.restassured.sandata.Indiana.Employee;

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

import static com.globalMethods.core.globalVariables.*;

public class SEVV15079_TC38316_ALTEVV_EmpNotGenerateSMCWhenCreateNewEmployee extends BaseTest {
    private GenerateUniqueParam generateUniqueParam=new GenerateUniqueParam();
    private Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();

    @Test(groups = "fixing")
    public void TC38316_ALTEVV_Indiana_EmpNotGenerateSMCWhenCreateNewEmployee() throws IOException, ParseException,
            InterruptedException, SQLException, ClassNotFoundException {
        JSONArray jsonArray = generateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
        JSONObject js = (JSONObject) jsonArray.get(0);

        CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(altevv_emp));

        assertionDbVerifier.verifyExistingDataIn_STX_App_User(js.get(EmployeeEmail).toString());
        assertionDbVerifier.verifyNotExistingDataIn_STX_MVV_User(js.get(EmployeeEmail).toString());
    }
}
