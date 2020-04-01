package openevv.Connecticut.Employee;

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

public class TC23430_EmployeeIDCustom2 extends BaseTest {

    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {true, CommonMethods.generateRandomAlphaNumeric(64), ""},
                        {true, null, ""},
                        {true, "", ""},
                        {false, " ", "The EmployeeIDCustom2 expected format is not correct"}, // current behavior visit will be rejected when sending SPACE => need to confirm from PO
                        {true, "111222333595111111111111111111111111111111111111111111111111111A", ""},
                        {false, CommonMethods.generateRandomAlphaNumeric(65), EmployeeIDCustom2MaxLengthError},

                };
    }

    @Test(dataProvider = "dataProvider")
    public void TC36561_EmployeeIDCustom2 (boolean isValid, String value, String errorMessage) throws
            IOException, ParseException, InterruptedException, java.text.ParseException {
        JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_OpenEVV(emp_openevv_Json);
        JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
        jsonobject.put(EmployeeIDCustom2,value);


        if (isValid) {
            CommonMethods.validateResponse(altEVVJsonArray, CommonMethods.propertyfileReader(openevv_emp_url));
        }
        else {
            String body = CommonMethods.capturePostResponse(altEVVJsonArray, CommonMethods.propertyfileReader(openevv_emp_url));
            CommonMethods.verifyjsonassertFailcase(body, errorMessage);
        }
    }

}
