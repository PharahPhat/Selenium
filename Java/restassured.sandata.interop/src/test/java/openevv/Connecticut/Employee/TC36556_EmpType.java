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

public class TC36556_EmpType extends BaseTest {
    private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

    @Test(groups = {"All" , "Regression"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91573_OpenEVV_EmployeeType_valid() throws InterruptedException, IOException, ParseException, java.text.ParseException
    {
        JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeType", "N");

        CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
    }

    @Test(groups = {"All" , "Regression"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91573_OpenEVV_EmployeeType_Empty() throws InterruptedException, IOException, ParseException, java.text.ParseException {
        JSONArray j = GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeType", "");

        logger.log(LogStatus.INFO, "Validating Json response ");
        CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
    }

    @Test(groups = {"All" , "Smoke"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91573_OpenEVV_EmployeeType_InvalidLength() throws InterruptedException, IOException, ParseException, java.text.ParseException
    {
        JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeType", "NA");

        String bodyAsString = CommonMethods.capturePostResponse(j,
                CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
        logger.log(LogStatus.INFO, "Validating Json response ");

        CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EMPTYPE);
    }

    @Test(groups = {"All" , "Regression"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91573_OpenEVV_EmployeeType_SpecialChar() throws InterruptedException, IOException, ParseException, java.text.ParseException
    {
        JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeType", "@");

        String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

        logger.log(LogStatus.INFO, "Validating Json response ");
        CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpTypeFormatError);
    }

    @Test(groups = {"All" , "Regression"})
    @AdditionalInfo(module = "OpenEVV")
    public void TC91573_OpenEVV_EmployeeType_Space() throws InterruptedException, IOException, ParseException, java.text.ParseException
    {
        JSONArray j=GenerateUniqueParam.EmpParams_OpenEVV(globalVariables.emp_openevv_Json);
        JSONObject js = (JSONObject) j.get(0);
        js.put("EmployeeType", " ");

        String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));
        
        logger.log(LogStatus.INFO, "Validating Json response ");
        CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.EmpTypeFormatError);
    }
}
