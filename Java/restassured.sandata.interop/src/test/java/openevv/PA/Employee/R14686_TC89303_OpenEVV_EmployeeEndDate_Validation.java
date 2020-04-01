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

public class R14686_TC89303_OpenEVV_EmployeeEndDate_Validation extends BaseTest {

    private com.globalMethods.core.GenerateUniqueParam GenerateUniqueParam = new GenerateUniqueParam();

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {true, "2018-12-31", ""},
                        {true, null, ""},
                        {true, "", ""},
                        {false, "12-31-1990", EmployeeEndDateformaterror},
                        {false, "12/31/1990", EmployeeEndDateformaterror},
                        {false, "19901213", EmployeeEndDateformaterror},
                        {false, "19903112", EmployeeEndDateformaterror},
                        {false, "31121990", EmployeeEndDateformaterror},

                };
    }

    @Test(dataProvider = "dataProvider")
    public void R14686_TCSEVV_16222_OpenEVV_EmployeeEndDate_Validation (boolean isValid, String value, String errorMessage) throws
            IOException, ParseException, InterruptedException, java.text.ParseException {
        JSONArray altEVVJsonArray = GenerateUniqueParam.EmpParams_OpenEVV(emp_openevv_Json);
        JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
        jsonobject.put(EmployeeEndDate,value);


        if (isValid) {
            CommonMethods.validateResponse(altEVVJsonArray, CommonMethods.propertyfileReader(openevv_emp_url));
        }
        else {
            String body = CommonMethods.capturePostResponse(altEVVJsonArray, CommonMethods.propertyfileReader(openevv_emp_url));
            CommonMethods.verifyjsonassertFailcase(body, errorMessage);
        }
    }
}
