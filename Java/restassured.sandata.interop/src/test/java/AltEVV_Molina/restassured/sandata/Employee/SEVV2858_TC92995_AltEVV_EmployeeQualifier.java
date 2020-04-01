/**
 * 
 */
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
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV2858_TC92995_AltEVV_EmployeeQualifier extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the valid  EmployeeQualifier by passing the String Value as "EmployeeSSN"
	@Test(groups = {"All"})
	public void SEVV2858_TC92995_AltEVV_EmployeeQualifier_valid_String_as_EmployeeSSN() throws IOException, ParseException
	{
		logger.log(LogStatus.INFO, "To validate the valid  EmployeeQualifier by passing the String Value as EmployeeSSN");
		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		logger.log(LogStatus.INFO, "Loading JSON with unique value");
		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", DataGeneratorEmployee.EmployeeQualifiertype("EmployeeSSN"));
		CommonMethods.validateResponse(j,CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the valid  EmployeeQualifier by passing the String Value as "EmployeeRegID"
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92995_AltEVV_EmployeeQualifier_valid_String_as_EmployeeRegID() throws IOException, ParseException
	{
		logger.log(LogStatus.INFO, "To validate the valid  EmployeeQualifier by passing the String Value as EmployeeRegID");
		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		logger.log(LogStatus.INFO, "Loading JSON with unique value");
		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", DataGeneratorEmployee.EmployeeQualifiertype("EmployeeRegID"));
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the valid  EmployeeQualifier by passing the String Value as "EmployeeCustomID"
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92995_AltEVV_EmployeeQualifier_valid_String_as_EmployeeCustomID() throws IOException, ParseException
	{
		logger.log(LogStatus.INFO, "	//To validate the valid  EmployeeQualifier by passing the String Value as \"EmployeeCustomID\"");
		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		logger.log(LogStatus.INFO, "Loading JSON with unique value");
		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", DataGeneratorEmployee.EmployeeQualifiertype("EmployeeCustomID"));
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString());
		CommonMethods.validateResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
	}

	//To validate the invalid  EmployeeQualifier by passing the String Value as "null"
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92995_AltEVV_EmployeeQualifier_invalid_as_null_value() throws IOException, ParseException
	{
		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeQualifier by passing the String Value as \"null\"");
		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		logger.log(LogStatus.INFO, "Loading JSON with unique value");
		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", DataGeneratorEmployee.EmployeeQualifiertype("null"));
		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString());
		String bodyAsString = CommonMethods.capturePostResponse(j,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	}

	//To validate the invalid  EmployeeQualifier by passing the as null
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92995_AltEVV_EmployeeQualifier_invalid_as_null() throws IOException, ParseException
	{
		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeQualifier by passing the value as null");
		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		logger.log(LogStatus.INFO, "Loading JSON with unique value");
		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", null);
		String bodyAsString = CommonMethods.capturePostResponse(j,CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("\"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The EmployeeQualifier cannot be NULL"));
	}

	//To validate the invalid  EmployeeQualifier by passing the String Value as "EmployeeFirstName"
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92995_AltEVV_EmployeeQualifier_invalid_string_as_EmployeeFirstName() throws IOException, ParseException
	{
		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeQualifier by passing the String Value as \"EmployeeFirstName\"");
		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		logger.log(LogStatus.INFO, "Loading JSON with unique value");
		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", DataGeneratorEmployee.EmployeeQualifiertype("EmployeeFirstName"));
		String bodyAsString = CommonMethods.capturePostResponse(j,CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));
		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	}

	//To validate the invalid  EmployeeQualifier by passing the String Value as no-value
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC92995_AltEVV_EmployeeQualifier_invalid_string_as_novalue() throws IOException, ParseException
	{
		logger.log(LogStatus.INFO, "To validate the invalid  EmployeeQualifier by passing the String Value as novalue");
		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		logger.log(LogStatus.INFO, "Loading JSON with unique value");
		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("EmployeeQualifier", DataGeneratorEmployee.EmployeeQualifiertype(""));
		String bodyAsString = CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
	}
}
