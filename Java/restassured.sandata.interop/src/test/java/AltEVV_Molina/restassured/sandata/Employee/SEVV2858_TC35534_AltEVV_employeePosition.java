package AltEVV_Molina.restassured.sandata.Employee;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.DataGeneratorEmployee;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
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

public class SEVV2858_TC35534_AltEVV_employeePosition extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Validate the valid employeePosition with correct set of value
	@Test(groups = {"All"})
	public void SEVV2858_TC35534_AltEVV_employeePosition_valid_correctvalue() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException

	{
		// logger = extent.startTest("SEVV2858_TC92974_AltEVV_employeePosition_valid_correctvalue");

		logger.log(LogStatus.INFO, "//Validate the valid employeePosition with correct set of value"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePosition", DataGeneratorEmployee.generateStaffPosition());

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}
	
	//Validate the invalid employeePosition with incorrect set of value
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC35534_AltEVV_invalid_employeePosition_incorrectValue() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92974_AltEVV_invalid_employeePosition_incorrectValue");

		logger.log(LogStatus.INFO, "//Validate the invalid employeePosition with incorrect set of value"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePosition", CommonMethods.getSaltString(3));

		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"The EmployeePosition format is incorrect.");


	}

	//Validate the invalid employeePosition with incorrect set of value
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC35534_AltEVV_invalid_employeePosition_incorrectValue_1char() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92974_AltEVV_invalid_employeePosition_incorrectValue_1char");

		logger.log(LogStatus.INFO, "//Validate the invalid employeePosition with incorrect set of value"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePosition", CommonMethods.getSaltString(1));
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"The EmployeePosition format is incorrect.");

	}

	//Validate the invalid employeePosition with incorrect set of special char value
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC35534_AltEVV_invalid_employeePosition_incorrectValue_specialchar() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92974_AltEVV_invalid_employeePosition_incorrectValue_specialchar");

		logger.log(LogStatus.INFO, "//Validate the invalid employeePosition with incorrect set of special char value"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePosition", CommonMethods.getSaltString(1) +CommonMethods.generateSpecialChar(2));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"The EmployeePosition format is incorrect.");

	}

	//Validate the invalid employeePosition with incorrect set of num only value
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC35534_AltEVV_invalid_employeePosition_incorrectValue_num() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92974_AltEVV_invalid_employeePosition_incorrectValue_num");

		logger.log(LogStatus.INFO, "//Validate the invalid employeePosition with incorrect set of num only value"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePosition", CommonMethods.generateRandomNumberOfFixLength(3));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"The EmployeePosition format is incorrect.");


	}

	//Validate the invalid employeePosition with incorrect set of alphnum value
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC35534_AltEVV_invalid_employeePosition_incorrectValue_alphnum() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC92974_AltEVV_invalid_employeePosition_incorrectValue_alphnum");

		logger.log(LogStatus.INFO, "//Validate the invalid employeePosition with incorrect set of alphnum value"); 

		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeePosition", CommonMethods.generateRandomAlphaNumeric(3));

		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		CommonMethods.verifyjsonassertFailcase(bodyAsString,"The EmployeePosition format is incorrect.");


	}

}