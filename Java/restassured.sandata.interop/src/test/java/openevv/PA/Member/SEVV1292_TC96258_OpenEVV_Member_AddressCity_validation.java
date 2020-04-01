
package openevv.PA.Member;

import java.io.IOException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV1292_TC96258_OpenEVV_Member_AddressCity_validation extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	@Test(groups = {"All"})
	public void TC96258_OpenEVV_Member_AddressCity_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96258_OpenEVV_Member_AddressCity_null");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("ClientCity", null);
		
		JSONObject jsonObjectsub = 	(JSONObject) jsonArrPay.get(0);
		
		jsonObjectsub.put("ClientCity", null);

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.memberClientCityNullError);
	}

	@Test(groups = {"All"})
	public void TC96258_OpenEVV_Member_AddressCity_length_exceeds() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("TC96258_OpenEVV_Member_AddressCity_length_exceeds");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(31));
		
		JSONObject jsonObjectsub = 	(JSONObject) jsonArrPay.get(0);
		
		jsonObjectsub.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCitylength_error);
	}
	
	@Test(groups = {"All"})
	public void TC96258_OpenEVV_Member_AddressCity_length_valid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC96258_OpenEVV_Member_AddressCity_length_valid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(30));
		
		JSONObject jsonObjectsub = 	(JSONObject) jsonArrPay.get(0);
		
		jsonObjectsub.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(30));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

}
	
	@Test(groups = {"All"})
	public void TC96258_OpenEVV_Member_AddressCity_length_less_than_30char() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC96258_OpenEVV_Member_AddressCity_length_less_than_30char_valid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArrPay = (JSONArray) jsonObject.get("ClientAddress");
		
		JSONObject jsonObjectPay = 	(JSONObject) jsonArrPay.get(0);

		jsonObjectPay.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(29));
		
		JSONObject jsonObjectsub = 	(JSONObject) jsonArrPay.get(0);
		
		jsonObjectsub.put("ClientCity", CommonMethods.generateRandomStringOfFixLength(29));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
}
}
