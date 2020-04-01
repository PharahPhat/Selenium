package openevv.PA.Member;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//Test Case 94526: OpenEVV Member: Validate maximum length for ClientContactFirstName (MemberContactFirstName)(30)

public class R2223_TC94526_OpenEVV_Member_ClientContactFirstName_Length extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
    
    //Case1: Validate maximum length for ClientContactFirstName (MemberContactFirstName)(30)
	@Test(groups = {"All"})
	public void R2223_TC94526_OpenEVV_Member_ClientContactFirstName_MaxLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94526_OpenEVV_Member_ClientContactFirstName_MaxLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactFirstName", CommonMethods.getSaltString(14));

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		
	}
	
	//Case2: Validate Min length for ClientContactFirstName (MemberContactFirstName)(1)
	@Test(groups = {"All"})
	public void R2223_TC94526_OpenEVV_Member_ClientContactFirstName_MinLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94526_OpenEVV_Member_ClientContactFirstName_MinLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientContactFirstName", CommonMethods.generateRandomStringOfFixLength(1));	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

	}
	
	//Case3: Validate maximum length exceeds for ClientContactFirstName (MemberContactFirstName)(31)
	
	@Test(groups = {"All"})
	public void R2223_TC94526_OpenEVV_Member_ClientContactFirstName_Length_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94526_OpenEVV_Member_ClientContactFirstName_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectProg=CommonMethods.subarrayAssertionVerifier(jsonObject, "ClientContact");
		jsonObjectProg.put("ClientContactFirstName", CommonMethods.generateRandomStringOfFixLength(31));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactFirstName_error);;

	}
	

}