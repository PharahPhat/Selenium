/**
 * 
 */
package openevv.Connecticut.Employee;

import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author RRohiteshwar
 *
 */

//Test Case 89106: Inter-Op-Open EVV: Reactivate employee by sending status=1 (Shouldn't be able to reactivate)

public class Bug80982_TC89106_Emp_Sending_Status_1  extends BaseTest
{

	JSONArray jsonArray=null;
	static String bodygiven;

	//To validate the valid employee json with status as D
	@Test(groups = {"All", "fixing"})
	public void TC89106_OpenEVV_Emp_valid_json_with_Status_D() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException
	{

		// logger = extent.startTest("TC89106_OpenEVV_Emp_valid_json_with_Status_D");
	 
	logger.log(LogStatus.INFO, "To validate the valid employee json with status as D");// adding what you are verifing

	

	jsonArray=CommonMethods.LoadJSON_OpenEVV("employee");

		JSONObject js= (JSONObject)jsonArray.get(0);
		js.put("Status", "D");
		bodygiven=jsonArray.toJSONString();
		logger.log(LogStatus.INFO, "Passing Status as D ");
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		Thread.sleep(5000);
		js.put("Status", "1");

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_emp_url));

		logger.log(LogStatus.INFO, "Validating Json response ");
		//Using Assert to validate the expected result
		Assert.assertTrue(bodyAsString.contains("  \"status\": \"FAILED\","));
		Assert.assertTrue(bodyAsString.contains(" \"ErrorCode\": null,"));
		Assert.assertTrue(bodyAsString.contains("ERROR: The Status expected format is not correct. The record should satisfy this regular expression"));
			
	}


}
