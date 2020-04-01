package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
public class TC36559_EmpAltPhone2 extends BaseTest{

    @Test(groups = {"All", "fixing"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91576_OpenEVV_valid_numeric_EmployeeAltPhone2() throws InterruptedException, IOException, ParseException
    {

        JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");


        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeAltPhone2", CommonMethods.generateRandomNumberOfFixLength(10));

        logger.log(LogStatus.INFO, "Validating Json response ");

        CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

    }

    @Test(groups = {"All", "fixing"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91576_OpenEVV_invalid_EmployeeAltPhone2_exceeding_length() throws InterruptedException, IOException, ParseException
    {
        //Using Reusable method to load client json
        JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

        //Making json values dynamic
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeAltPhone2", CommonMethods.generateRandomNumberOfFixLength(11));

        String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
        logger.log(LogStatus.INFO, "Validating Json response ");

        //Using Assert to validate the expected result
        Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
        Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeAltPhone2 expected format is not correct."));
    }

    @Test(groups = {"All", "fixing"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91576_OpenEVV_EmployeeAltPhone2_less_than_min_length() throws InterruptedException, IOException, ParseException
    {

        //Using Reusable method to load client json
        JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

        //Making json values dynamic
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeAltPhone2", CommonMethods.generateRandomNumberOfFixLength(8));

        String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
        logger.log(LogStatus.INFO, "Validating Json response ");

        //Using Assert to validate the expected result
        Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
        Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeAltPhone2 expected format is not correct."));
    }

    @Test(groups = {"All", "fixing"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91576_OpenEVV_alphanumeric_EmployeeAltPhone2() throws InterruptedException, IOException, ParseException
    {
        //Using Reusable method to load client json
        JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

        //Making json values dynamic
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeAltPhone2", CommonMethods.generateRandomAlphaNumeric(10));

        String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
        logger.log(LogStatus.INFO, "Validating Json response ");

        //Using Assert to validate the expected result
        Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
        Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeAltPhone2 expected format is not correct."));
    }


    @Test(groups = {"All", "fixing"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91576_OpenEVV_nonnumeric_EmployeeAltPhone2() throws InterruptedException, IOException, ParseException
    {

        //Using Reusable method to load client json
        JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

        //Making json values dynamic
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeAltPhone2", CommonMethods.generateRandomStringOfFixLength(10));

        String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
        logger.log(LogStatus.INFO, "Validating Json response ");

        //Using Assert to validate the expected result
        Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
        Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeAltPhone2 expected format is not correct."));
    }

    //To validate the EmployeePhone with leading space
    @Test(groups = {"All", "fixing"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91576_OpenEVV_leading_space_EmployeeAltPhone2() throws InterruptedException, IOException, ParseException
    {

        //Using Reusable method to load client json
        JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

        //Making json values dynamic
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeAltPhone2", " " + CommonMethods.generateRandomNumberOfFixLength(9));

        String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
        logger.log(LogStatus.INFO, "Validating Json response ");

        //Using Assert to validate the expected result
        Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
        Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeAltPhone2 expected format is not correct."));

    }

    //To validate the EmployeePhone with trailing space
    @Test(groups = {"All", "fixing"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91576_OpenEVV_trailing_space_EmployeeAltPhone2() throws InterruptedException, IOException, ParseException
    {

        //Using Reusable method to load client json
        JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

        //Making json values dynamic
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeAltPhone2", CommonMethods.generateRandomNumberOfFixLength(9) + " ");

        String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
        logger.log(LogStatus.INFO, "Validating Json response ");

        //Using Assert to validate the expected result
        Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
        Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeAltPhone2 expected format is not correct."));

    }

    //To validate the EmployeePhone with leading zero
    @Test(groups = {"All", "fixing"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91576_OpenEVV_leading_zero_EmployeeAltPhone2() throws InterruptedException, IOException, ParseException
    {

        //Using Reusable method to load employee json
        JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

        //Making json values dynamic
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeAltPhone2", "0" + CommonMethods.generateRandomNumberOfFixLength(9));
//        String bodyAsString = CommonMethods.captureResponseOPENEVV(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

        logger.log(LogStatus.INFO, "Validating Json response ");
//        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

    }

    //To validate the EmployeePhone with special character
    @Test(groups = {"All", "fixing"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91576_OpenEVV_specialCharacter_EmployeeAltPhone2() throws InterruptedException, IOException, ParseException
    {

        //Using Reusable method to load client json
        JSONArray j=CommonMethods.LoadJSON_OpenEVV("employee");

        //Making json values dynamic
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeAltPhone2", CommonMethods.generateSpecialChar(10));

        String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

        logger.log(LogStatus.INFO, "Validating Json response ");
        //Using Assert to validate the expected result
        Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
        Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeAltPhone2 expected format is not correct."));

    }
}
