package AltEVV_generic.restassured.sandata.Indiana.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;
import io.restassured.path.json.JsonPath;

/**
 * @author RRohiteshwar
 *
 */
//Test Case 92348:Open EVV - alt EVV-employee- Validate the Response json

import com.globalMethods.core.Assertion_DbVerifier; public class R2267_TC92348_AltEVV_Emp_validateResponseJSON extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	String Jsonstring, empssn, field = "worker_ssn",sequncid, field2="worker_version_number";

	
	//Validating valid Emp_ResponseJSON for few objects 
	@Test(groups = {"All"})
	public void R2267_TC92348_AltEVV_Emp_validateResponseJSON_5field() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2267_TC92348_AltEVV_Emp_validateResponseJSON_5field");
		logger.log(LogStatus.INFO, "Validating valid Emp_ResponseJSON for few objects"); 

		JSONArray jsonArray = GenerateUniqueParam.EmpParams_AltEVV(globalVariables.Staff_intake);
		JSONObject  jsonObject = (JSONObject) jsonArray.get(0);
		this.empssn=jsonObject.get("EmployeeSSN").toString();
		this.sequncid=jsonObject.get("SequenceID").toString();
		System.out.println(sequncid);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_emp_url));
	
		//CommonMethods.verifyjsonassertsuccess4value_inboxemp(bodyAsString, field, empssn, field2, sequncid );

		JsonPath jp = new JsonPath(bodyAsString);
		ArrayList<String> arraylist=new ArrayList<String>();
			
		CommonMethods.verifylistassertion(bodyAsString, arraylist );
		
	}
	
	
}