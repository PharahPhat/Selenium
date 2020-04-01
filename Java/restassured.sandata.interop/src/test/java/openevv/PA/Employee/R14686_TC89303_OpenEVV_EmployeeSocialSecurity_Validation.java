package openevv.PA.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;
import static com.globalMethods.core.globalVariables.openevv_emp_url;

public class R14686_TC89303_OpenEVV_EmployeeSocialSecurity_Validation extends BaseTest {
    private com.globalMethods.core.GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {false, CommonMethods.generateRandomAlphaNumeric(9), EmpSSNFormatError},
                        {false, CommonMethods.generateRandomNumberOfFixLength(10), EmpSSNMaxLengthError},
                        {true, CommonMethods.generateRandomNumberOfFixLength(9), ""},
                        {true, null, ""},
                        {true, "", ""}
                };
    }

    @Test(dataProvider = "dataProvider")
    public void R14686_TC89303_OpenEVV_EmployeeSocialSecurity_Validation (boolean isValid, String value, String errorMessage) throws
            IOException, ParseException, InterruptedException, java.text.ParseException {
        JSONArray altEVVJsonArray = GenerateUniqueParam.EmpParams_OpenEVV(emp_openevv_Json);
        JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
        jsonobject.put(EmployeeSocialSecurity,value);

        if (isValid) {
            CommonMethods.validateResponse(altEVVJsonArray, CommonMethods.propertyfileReader(openevv_emp_url));
        }
        else {
            String body = CommonMethods.capturePostResponse(altEVVJsonArray, CommonMethods.propertyfileReader(openevv_emp_url));
            CommonMethods.verifyjsonassertFailcase(body, errorMessage);
        }
    }
}
