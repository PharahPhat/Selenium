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

//OpenEVV Member: Validate maximum length for ClientOtherID(24)


public class R2223_TC94485_OpenEVV_Member_ClientOtherID extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"Smoke"})
	public void R2223_TC94485_OpenEVV_Member_ClientOtherID_Length_max() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94485_OpenEVV_Member_ClientOtherID_Length_max");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.generateRandomNumberOfFixLength(24));	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}



	@Test(groups = {"All"})
	public void R2223_TC94485_OpenEVV_Member_ClientOtherID_Length_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94485_OpenEVV_Member_ClientOtherID_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", CommonMethods.generateRandomNumberOfFixLength(25));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientOtherIDLengthError);

	}

	@Test(groups = {"All"})
	public void R2223_TC94485_OpenEVV_Member_ClientOtherID_Length_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94485_OpenEVV_Member_ClientOtherID_Length_blank");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", "");	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientOtherIDFormatError);;

	}
	
	@Test(groups = {"All"})
	public void R2223_TC94485_OpenEVV_Member_ClientOtherID_null() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94485_OpenEVV_Member_ClientOtherID_null");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientOtherID", null);	

		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

}