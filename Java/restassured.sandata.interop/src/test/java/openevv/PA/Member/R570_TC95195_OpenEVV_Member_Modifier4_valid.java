package openevv.PA.Member;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.*;
import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author MayankM
 *
 */

//OpenEVV Member: (Positive case)Verify that Modifier4 field value is populating correctly in DB

import com.globalMethods.core.Assertion_DbVerifier; 

public class R570_TC95195_OpenEVV_Member_Modifier4_valid extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(enabled = false, groups = {"All"})
	public void R570_TC95195_OpenEVV_Member_Modifier4_numeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R570_TC95195_OpenEVV_Member_Modifier4_numeric");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier4", CommonMethods.generateRandomNumberOfFixLength(2));	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));


	}

	@Test(groups = {"All"})
	public void R570_TC95195_OpenEVV_Member_Modifier4_letter() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R570_TC95195_OpenEVV_Member_Modifier4_letter");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier4", CommonMethods.generateRandomStringOfFixLength(2));	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));


	}

	@Test(groups = {"All"})
	public void R570_TC95195_OpenEVV_Member_Modifier4_alphanumeric() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R570_TC95195_OpenEVV_Member_Modifier4_alphanumeric");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

		jsonObjectProg.put("Modifier4", "A1");	

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));


	}

	
}