package AltEVV_Molina.restassured.sandata.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author RRohiteshwar
 */
//Test Case 91404:OpenEVV-altEVV- employee - EmployeeEmail validation field formats/values.

public class SEVV2858_TC35522_AltEVV_EmployeeEmail extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	//To validate the valid  EmployeeEmail by passing the String Value of 64char with correct format
	@Test(groups = {"All"})
	public void SEVV2858_TC35522_AltEVV_EmployeeEmail_validFormat_String_64char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC92962_AltEVV_EmployeeEmail_validFormat_String_64char");

		logger.log(LogStatus.INFO, "To validate the valid  EmployeeEmail by passing the String Value of 64char with correct format"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeEmail", DataGeneratorEmployee.generateEmpEmail(32));

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the invalid  EmployeeEmail by passing the String Value of morethan 64char
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC35522_AltEVV_EmployeeEmail_invalidFormat_String_Morethan_64char() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92962_AltEVV_EmployeeEmail_invalidFormat_String_Morethan_64char");

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeEmail by passing the String Value of morethan 64char"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeEmail", DataGeneratorEmployee.generateEmpEmail(33));

		String resp = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(resp,"ERROR: The EmployeeEmail value is incorrect");
	}

	//To validate the invalid  EmployeeEmail by passing the String Value of 64char with incorrect format
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC35522_AltEVV_EmployeeEmail_invalidFormat() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92962_AltEVV_EmployeeEmail_invalidFormat");

		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeEmail by passing the String Value of 64char with incorrect format"); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeEmail", DataGeneratorEmployee.generateEmpEmail(10) + ".test " + " @");

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The EmployeeEmail format is incorrect.");
	}

}