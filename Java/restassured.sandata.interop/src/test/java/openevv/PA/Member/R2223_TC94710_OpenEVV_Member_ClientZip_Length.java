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
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

// Test Case 94710:OpenEVV Member: Validate maximum length for ClientZip (MemberZip)(9)


public class R2223_TC94710_OpenEVV_Member_ClientZip_Length extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Case-1: Validate maximum length for ClientZip (MemberZip) 9chars and type String
	@Test(groups = {"All"})
	public void R2223_TC94710_OpenEVV_Member_ClientZip_MaxLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94710_OpenEVV_Member_ClientZip_MaxLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientZip, CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	//Case-2: Validate maximum length for ClientZip (MemberZip) less than 9chars and type String
	@Test(groups = {"All"})
	public void R2223_TC94710_OpenEVV_Member_ClientZip_validLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94710_OpenEVV_Member_ClientZip_validLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientZip, CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	//Case-3: Validate maximum length for ClientZip (MemberZip) more than 9chars and type String			
	@Test(groups = {"All"})
	public void R2223_TC94710_OpenEVV_Member_ClientZip_invalidLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94710_OpenEVV_Member_ClientZip_invalidLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(1);
		jsonObjectProg.put(globalVariables.ClientZip, CommonMethods.generateRandomNumberOfFixLength(10));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientZipSizeError);
	}

}
