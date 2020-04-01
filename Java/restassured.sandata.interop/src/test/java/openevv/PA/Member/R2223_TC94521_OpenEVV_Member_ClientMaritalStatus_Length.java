package openevv.PA.Member;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
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
//OpenEVV Member: Validate maximum length for ClientMaritalStatus(1) 

public class R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_Length extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_M() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_M");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", "M");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_S() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_M");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", "S");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_W() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_M");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", "W");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_O() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_M");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", "O");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_invalid_length() throws InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
		// logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_M");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", CommonMethods.generateRandomStringOfFixLength(2));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientMaritalStatusLengthError);;
	}


	@Test(groups = {"All"})
	public void R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_null() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94521_OpenEVV_Member_ClientMaritalStatus_null");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientMaritalStatus", null);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}
}

