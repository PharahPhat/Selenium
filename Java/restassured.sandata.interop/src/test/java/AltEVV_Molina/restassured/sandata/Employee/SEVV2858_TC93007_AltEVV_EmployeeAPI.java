package AltEVV_Molina.restassured.sandata.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author MayankM
 */
//Test Case 91411: OpenEVV-altEVV- employee - EmployeeAPI validation field formats/values

public class SEVV2858_TC93007_AltEVV_EmployeeAPI extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the valid EmployeeAPI
	@Test(groups = {"All"})
	public void SEVV2858_TC93007_AltEVV_EmployeeAPI_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC93007_AltEVV_EmployeeAPI_valid");

		logger.log(LogStatus.INFO, "To validate the valid EmployeeAPI "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeAPI", CommonMethods.generateRandomNumberOfFixLength(5));


		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the invalid EmployeeAPI
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93007_AltEVV_EmployeeAPI_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC93007_AltEVV_EmployeeAPI_invalid");

		logger.log(LogStatus.INFO, "To validate the invalid EmployeeAPI "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeAPI", CommonMethods.generateRandomNumberOfFixLength(30));

		String bodyAsString = 
				CommonMethods.capturePostResponse(j,
						CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeAPI value is incorrect"));

	}

	//To validate the optional EmployeeAPI
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93007_AltEVV_EmployeeAPI_optional() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("SEVV2858_TC93007_AltEVV_EmployeeAPI_optional");

		logger.log(LogStatus.INFO, "To validate the optional EmployeeAPI "); 

		//Using Reusable method to load employee json
		JSONArray jsonArrayVisit = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) jsonArrayVisit.get(0);
		js.put("EmployeeAPI", "");


		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The EmployeeAPI value is incorrect");
	}

	//To validate the null EmployeeAPI
	@Test(groups = {"All"})
	public void SEVV2858_TC93007_AltEVV_EmployeeAPI_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC93007_AltEVV_EmployeeAPI_optional");

		logger.log(LogStatus.INFO, "To validate the optional EmployeeAPI "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeAPI", null);

		CommonMethods.validateResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

}