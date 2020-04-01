package AltEVV_generic.restassured.sandata.PA.Employee;

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

public class R15762_TC15972_AltEVV_Employee_EmployeeEndDate_Validation extends BaseTest {
    private GenerateUniqueParam generateUniqueParam = new GenerateUniqueParam();


    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {true, "2019-12-31", ""},
                        {true, null, ""},
                        {true, "", ""},
                        {false,"31-12-2019", EmployeeEndDateformaterror},
                        {false,"2019-12--31", EmployeeEndDateformaterror},
                        {false,"2019-1@-31", EmployeeEndDateformaterror}
                };
    }

    @Test(dataProvider = "dataProvider")
    public void R15762_TC15972_AltEVV_Employee_EmployeeEndDate_Validation(boolean isValid, String value, String errorMessage) throws IOException, ParseException, InterruptedException{
        JSONArray altEVVJsonArray = generateUniqueParam.EmpParams_AltEVV(Staff_intake);
        JSONObject jsonobject = (JSONObject) altEVVJsonArray.get(0);
        jsonobject.put(EmployeeEndDate, value);

        if (isValid) {
            CommonMethods.validateResponse(altEVVJsonArray, CommonMethods.propertyfileReader(altevv_emp));
        }
        else {
            String body = CommonMethods.capturePostResponse(altEVVJsonArray, CommonMethods.propertyfileReader(altevv_emp));
            CommonMethods.verifyjsonassertFailcase(body, errorMessage);
        }
    }

}
