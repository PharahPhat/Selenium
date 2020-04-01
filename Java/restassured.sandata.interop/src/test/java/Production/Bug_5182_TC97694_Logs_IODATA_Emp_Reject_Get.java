package Production;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class Bug_5182_TC97694_Logs_IODATA_Emp_Reject_Get extends BaseTest {
	
GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test
	public void Bug_5182_TC97694_Logs_IODATA_Emp_Reject_Get_validation() throws IOException, ParseException, SQLException, java.text.ParseException, ClassNotFoundException, InterruptedException
	{
		// logger = extent.startTest("Bug_5182_TC97694_Logs_IODATA_Emp_Reject_Get_validation");

		JSONArray jsonarray=GenerateUniqueParam.EmpParams_Ohio_V1(globalVariables.worker_3P_json);

		JSONObject jsonobject = (JSONObject) jsonarray.get(0);

		jsonobject.put("StaffPosition",CommonMethods.generateRandomStringOfFixLength(4));
		
		String bodyAsString = CommonMethods.capturePostResponse(jsonarray, CommonMethods.propertyfileReader(globalVariables.ohio_staff_v1));
	
		Assert.assertTrue(bodyAsString.contains("\"messageSummary\": \"Transaction Received.\""));
		
		String bodyAsStringget=CommonMethods.captureGetResponseOhioGetWithUID_v1(bodyAsString, CommonMethods.propertyfileReader(globalVariables.ohio_patient_get_v1));

		assertionDbVerifier.jsonAssert_InboxWorker_Ohio(bodyAsStringget, jsonobject);
		

		assertionDbVerifier.jsonAssert_iodata(bodyAsStringget, CommonMethods.capturegetIDonly(bodyAsStringget));
	
	}
	
}
