package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.globalMethods.core.globalVariables.EmployeeIDCustom1MaxLengthError;

public class TC36560_EmpoyeeIDCustom1 extends BaseTest{

    @Test(groups = {"All", "fixing"})
        @AdditionalInfo(module = "OpenEVV")
        public void TC91577_OpenEVV_EmployeeIDCustom1_valid_maxlength() throws IOException, ParseException
        {
            JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
            JSONObject js = (JSONObject) j.get(0);
            js.put("EmpployeeIDCustom1", CommonMethods.generateRandomNumberOfFixLength(64));


            logger.log(LogStatus.INFO, "Validating Json response ");
            //Using Assert to validate the expected result
            CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
        }

    @Test(groups = {"All", "fixing"})
        @AdditionalInfo(module = "OpenEVV")
        public void TC91577_OpenEVV_EmployeeIDCustom1_InvalidLength() throws IOException, ParseException
        {
            JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
            JSONObject js = (JSONObject) j.get(0);
            js.put("EmployeeIDCustom1", CommonMethods.generateRandomNumberOfFixLength(65));


            logger.log(LogStatus.INFO, "Validating Json response ");
            //Using Assert to validate the expected result
            String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

            CommonMethods.verifyjsonassertFailcase(bodyAsString, EmployeeIDCustom1MaxLengthError);

        }

    @Test(groups = {"All", "fixing"})
        @AdditionalInfo(module = "OpenEVV")
        public void TC91577_OpenEVV_EmployeeIDCustom1_valid_Blank() throws IOException, ParseException
        {
            JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
            JSONObject js = (JSONObject) j.get(0);
            js.put("EmployeeIDCustom1", " ");


            logger.log(LogStatus.INFO, "Validating Json response ");
            //Using Assert to validate the expected result
            CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
        }
    @Test(groups = {"All", "fixing"})
        @AdditionalInfo(module = "OpenEVV")
        public void TC91577_OpenEVV_EmployeeIDCustom1_valid_Null() throws IOException, ParseException
        {
            JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");
            JSONObject js = (JSONObject) j.get(0);
            js.put("EmployeeIDCustom1", null);


            logger.log(LogStatus.INFO, "Validating Json response ");
            //Using Assert to validate the expected result
            CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
        }
}


