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

/**
 * @author MayankM
 */
//OpenEVV Member: Validate maximum length for ClientPriority(2)

public class R2223_TC94523_OpenEVV_Member_ClientPriority_length extends BaseTest { 
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All"})
	public void R2223_TC94523_OpenEVV_Member_ClientPriority_max_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94523_OpenEVV_Member_ClientPriority_max_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientPriority", CommonMethods.generateRandomNumberOfFixLength(2));	

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94523_OpenEVV_Member_ClientPriority_min_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94523_OpenEVV_Member_ClientPriority_min_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientPriority", CommonMethods.generateRandomNumberOfFixLength(1));	

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94523_OpenEVV_Member_ClientPriority_invalid_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94523_OpenEVV_Member_ClientPriority_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientPriority", CommonMethods.generateRandomStringOfFixLength(3));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientPriorityLengthError);
	}

	@Test(groups = {"All"})
	public void R2223_TC94523_OpenEVV_Member_ClientPriority_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94523_OpenEVV_Member_ClientPriority_blank");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientPriority", "");	

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94523_OpenEVV_Member_ClientPriority_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94523_OpenEVV_Member_ClientPriority_null");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientPriority", null);	

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}



}

