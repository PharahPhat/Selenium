package openevv.PA.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorEmployee;
import com.globalMethods.core.GenerateUniqueParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.*;

public class SEVV18096_TC21429_OpenEVV_EmployeeEmailAddress_Validation extends BaseTest {
    private com.globalMethods.core.GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {{true, DataGeneratorEmployee.generateEmployeeEmail(50), ""},
                        {false, DataGeneratorEmployee.generateEmployeeEmail(51), EmployeeEmailAddressLengthError},
                        {false, DataGeneratorEmployee.generateEmployeeEmail(50) + "@", EmployeeEmailAddressFormatError},
                        {false, DataGeneratorEmployee.generateEmployeeEmail(50) + " ", EmployeeEmailAddressFormatError},
                        {true, null, ""},
                        {true, "", ""}
                };
    }

    @Test(dataProvider = "dataProvider")
    public void SEVV18096_TC21429_OpenEVV_EmployeeEmailAddress_Validation(boolean isValid, String value, String errorMessage) throws
            IOException, ParseException, InterruptedException, java.text.ParseException {
        JSONArray altEVVJsonArray = GenerateUniqueParam.EmpParams_OpenEVV(emp_openevv_Json);
        JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
        jsonobject.put(EmployeeEmailAddress, value);

        if (isValid) {
            CommonMethods.validateResponse(altEVVJsonArray, CommonMethods.propertyfileReader(openevv_emp_url));
        } else {
            String body = CommonMethods.capturePostResponse(altEVVJsonArray, CommonMethods.propertyfileReader(openevv_emp_url));
            CommonMethods.verifyjsonassertFailcase(body, errorMessage);
        }
    }
}
