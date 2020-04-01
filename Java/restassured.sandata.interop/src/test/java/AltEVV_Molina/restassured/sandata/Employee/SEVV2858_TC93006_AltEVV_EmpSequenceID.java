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

/**
 * @author MayankM
 */
//Test Case 91411: OpenEVV-altEVV- employee - SequenceID validation field formats/values

public class SEVV2858_TC93006_AltEVV_EmpSequenceID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//To validate the invalid SequenceID
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93006_AltEVV_SequenceID_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91406_AltEVV_SequenceID_invalid");

		logger.log(LogStatus.INFO, "To validate the invalid SequenceID "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(17));

		String bodyAsString = 
				CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The SequenceID format is incorrect."));

	}

	//To validate the invalid SequenceID format
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93006_AltEVV_SequenceID_invalid_format() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91406_AltEVV_SequenceID_invalid_format");

		logger.log(LogStatus.INFO, "To validate the invalid SequenceID format "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", "");

		logger.log(LogStatus.INFO, "request body generated is " +j.toJSONString()); 

		String bodyAsString = 
				CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The SequenceID format is incorrect."));
	}

	//To validate the null SequenceID 
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93006_AltEVV_SequenceID_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2267_TC91406_AltEVV_SequenceID_null");

		logger.log(LogStatus.INFO, "To validate the null SequenceID "); 

		//Using Reusable method to load employee json
		JSONArray j = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);

		logger.log(LogStatus.INFO, "Loading JSON with unique value");

		//Making json values dynamic
		JSONObject js = (JSONObject) j.get(0);
		js.put("SequenceID", null);

		String bodyAsString = 
				CommonMethods.capturePostResponse(j, CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));


		Assert.assertTrue(bodyAsString.contains("\"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains("The SequenceID cannot be NULL."));

	}

	//Validating valid employee SequenceID_json_DB_Positive_case lower sequence id and greater sequence id
	@Test(groups = {"All", "Regression"})
	public void SEVV2858_TC93006_AltEVV_Emp_SequenceID_DB_with_increament_decrement_case() throws InterruptedException, IOException, ParseException
	{
		// logger = extent.startTest("SEVV2858_TC93006_AltEVV_Emp_SequenceID_DB_with_increament_decrement_case");
		logger.log(LogStatus.INFO, "//Validating valid employee SequenceID_json_DB_Positive_case lower sequence id and greater sequence id"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV_molina(globalVariables.Staff_intake_Molina);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(5));
		String sequncid=jsonObject.get("SequenceID").toString();
		
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp));

		Thread.sleep(30000);

		String bodyAsString = CommonMethods.captureGetResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp),
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp_get));

		CommonMethods.verifyErrorMessage(bodyAsString, globalVariables.SequenceIDDuplicateError);
		
		logger.log(LogStatus.INFO, "Validating that Db does not get updated if sequence id is sent lowerthan the revious case"); 

		jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("SequenceID", String.valueOf((Integer.parseInt(sequncid)-1)));

		bodyAsString = CommonMethods.captureGetResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp),
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp_get));
	
		CommonMethods.verifyErrorMessage(bodyAsString, globalVariables.SequenceIDDuplicateError);

		logger.log(LogStatus.INFO, "Validating that Db does not get updated if sequence id is sent greater the previous case"); 
		
		jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.put("SequenceID", String.valueOf((Integer.parseInt(sequncid)+8)));

		CommonMethods.verifyPostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp),
				CommonMethods.propertyfileReader(globalVariables.altevv_Molina_emp_get));
	}
}