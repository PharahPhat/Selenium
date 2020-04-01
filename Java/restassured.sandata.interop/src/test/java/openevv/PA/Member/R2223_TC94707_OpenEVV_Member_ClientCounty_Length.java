/**
 * 
 */
package openevv.PA.Member;

import Utills_ExtentReport_Log4j.BaseTest;
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

/**
 * @author Anupam
 *
 */

//Test Case 94707: OpenEVV Member: Validate maximum length for ClientCounty (MemberCounty)(25)


public class R2223_TC94707_OpenEVV_Member_ClientCounty_Length extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Case-1: Validate maximum length for ClientCounty (MemberCounty)(25)
	@Test(groups = {"All"})
	public void R2223_TC94707_OpenEVV_Member_ClientCounty_MaxLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94707_OpenEVV_Member_ClientCounty_MaxLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientCounty, CommonMethods.generateRandomStringOfFixLength(25));	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	//Case-2: Validate valid length(5) for ClientCounty (MemberCounty)(25)
	@Test(groups = {"All"})
	public void R2223_TC94707_OpenEVV_Member_ClientCounty_validLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94707_OpenEVV_Member_ClientCounty_validLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientCounty, CommonMethods.generateRandomStringOfFixLength(5));	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	//Case-3: Validate ClientCounty (MemberCounty)(25) exceed max length(27)
	@Test(groups = {"All"})
	public void R2223_TC94707_OpenEVV_Member_ClientCounty_invalidLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94707_OpenEVV_Member_ClientCounty_validLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientCounty, CommonMethods.generateRandomStringOfFixLength(28));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCountyLength);

		//Assert.assertEquals(DataBaseVerifier_Client.ncode, "0");
	}

	//Case-4: Validate ClientCounty (MemberCounty)(25) with null
	@Test(groups = {"All"})
	public void R2223_TC94707_OpenEVV_Member_ClientCounty_with_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94707_OpenEVV_Member_ClientCounty_with_null");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientCounty, null);	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

	}

	//Case-5: Validate ClientCounty (MemberCounty)(25) with Alphanumeric
	@Test(groups = {"All"})
	public void R2223_TC94707_OpenEVV_Member_ClientCounty_with_alphanumeric() throws InterruptedException, java.text.ParseException, IOException, ParseException, SQLException, ClassNotFoundException {
		// logger = extent.startTest("R2223_TC94707_OpenEVV_Member_ClientCounty_with_alphanumeric");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientCounty, CommonMethods.generateRandomAlphaNumeric(10));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCountyFormatError);
	}

	//Case-6: Validate ClientCounty (MemberCounty)(25) with special chars
	@Test(groups = {"All"})
	public void R2223_TC94707_OpenEVV_Member_ClientCounty_with_specialchars() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94707_OpenEVV_Member_ClientCounty_with_specialchars");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		jsonObjectProg.put(globalVariables.ClientCounty, CommonMethods.generateSpecialChar(8));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientCountyFormatError);
	}
}
