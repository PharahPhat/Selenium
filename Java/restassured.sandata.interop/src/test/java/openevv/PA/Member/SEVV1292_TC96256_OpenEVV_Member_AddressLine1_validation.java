
package openevv.PA.Member;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV1292_TC96256_OpenEVV_Member_AddressLine1_validation extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	
	@Test(groups = {"All"})
	public void TC96256_OpenEVV_Member_AddressLine1_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC96256_OpenEVV_Member_AddressLine1_null");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);


		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("ClientAddressLine1", null);
		
		JSONObject jsonObjectsub = 	(JSONObject) jsonArrPay.get(1);
		jsonObjectsub.put("ClientAddressLine1", null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1NullError);
	}
	
	@Test(groups = {"All"})
	public void TC96256_OpenEVV_Member_AddressLine1_exceeds_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("TC96256_OpenEVV_Member_AddressLine1_exceeds_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);


		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("ClientAddressLine1", CommonMethods.generateRandomStringOfFixLength(51));
		
		JSONObject jsonObjectsub = 	(JSONObject) jsonArrPay.get(1);
		jsonObjectsub.put("ClientAddressLine1", CommonMethods.generateRandomStringOfFixLength(51));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1LengthError);
	}
	
	@Test(groups = {"All"})
	public void TC96256_OpenEVV_Member_AddressLine1_max_length() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("TC96256_OpenEVV_Member_AddressLine1_max_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);


		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("ClientAddressLine1", CommonMethods.generateRandomStringOfFixLength(50));

		JSONObject jsonObjectsub = 	(JSONObject) jsonArrPay.get(1);
		jsonObjectsub.put("ClientAddressLine1", CommonMethods.generateRandomStringOfFixLength(50));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientAddressLine1LengthError);
	}
}
