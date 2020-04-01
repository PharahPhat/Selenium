package openevv.Connecticut.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC36557_EmpDiscipline extends BaseTest {
    private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"All" , "Regression"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91574_OpenEVV_EmpDescipline_valid() throws InterruptedException, IOException, ParseException, java.text.ParseException
    {

        JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

        JSONObject js = (JSONObject) j.get(0);

        js.put("Discipline", "HHA");

        CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
    }

    @Test(groups = {"All" , "Regression"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91574_OpenEVV_EmpDescipline_Valid_maxLength() throws InterruptedException, IOException, ParseException, java.text.ParseException
    {

        JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

        JSONObject js = (JSONObject) j.get(0);

        js.put("Discipline", CommonMethods.generateRandomStringOfFixLength(17));

        CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
    }

    @Test(groups = {"All" , "Regression"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91574_OpenEVV_EmpDescipline_Valid_AlphaNumeric() throws InterruptedException, IOException, ParseException, java.text.ParseException
    {

        JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

        JSONObject js = (JSONObject) j.get(0);

        js.put("Discipline", CommonMethods.generateRandomAlphaNumeric(6));

        CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
    }

    @Test(groups = {"All" , "Regression"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91574_OpenEVV_EmpDescipline_Valid_Empty() throws InterruptedException, IOException, ParseException, java.text.ParseException
    {

        JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

        JSONObject js = (JSONObject) j.get(0);

        js.put("Discipline","");

        logger.log(LogStatus.INFO, "Validating Json response ");
        CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
    }

    @Test(groups = {"All" , "Regression"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91574_OpenEVV_EmpDescipline_InvalidLength() throws InterruptedException, IOException, ParseException, java.text.ParseException
    {

        JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

        JSONObject js = (JSONObject) j.get(0);

        js.put("Discipline", CommonMethods.generateRandomStringOfFixLength(18));

        String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

        CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Discipline expected format is not correct");
    }

    @Test(groups = {"All" , "Regression"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91574_OpenEVV_EmpDescipline_Invalid_SpecialChar() throws InterruptedException, IOException, ParseException, java.text.ParseException
    {

        JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

        JSONObject js = (JSONObject) j.get(0);

        js.put("Discipline", CommonMethods.generateSpecialChar(6));

        String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

        CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Discipline expected format is not correct");
    }

    @Test(groups = {"All" , "Regression"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91574_OpenEVV_EmpDescipline_Invalid_Space() throws InterruptedException, IOException, ParseException, java.text.ParseException
    {

        JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);

        JSONObject js = (JSONObject) j.get(0);

        js.put("Discipline", " ");

        String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
        
        CommonMethods.verifyjsonassertFailcase(bodyAsString, "The Discipline expected format is not correct");
    }

}
