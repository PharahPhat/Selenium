package openevv.PA.Member;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.ohio.intake.patient.v1.DataGeneratorV1;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//Test Case 94697: OpenEVV Member: Validate maximum length for ClientContactPhone (MemberContactPhone)(10)

public class R2223_TC94697_OpenEVV_Member_ClientContactPhone_length extends BaseTest {
	private DataGeneratorV1 dataGenerator=new DataGeneratorV1();
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); 
	

	//Case-1: Validate  ClientContactPhone with max length(10)

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void R2223_TC94697_OpenEVV_Member_ClientContactPhone_Max_length() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94697_OpenEVV_Member_ClientContactPhone_Max_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);
		jsonObjectClientContact.put(globalVariables.ClientContactPhone, CommonMethods.generateRandomNumberOfFixLength(10));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

	}

	//Case-2: Validate  ClientContactPhone with invalid length(<10)

	@Test(groups = {"All"})
	public void R2223_TC94697_OpenEVV_Member_ClientContactPhone_invalid_length() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException {
		// logger = extent.startTest("R2223_TC94697_OpenEVV_Member_ClientContactPhone_invalid_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);
		jsonObjectClientContact.put(globalVariables.ClientContactPhone, CommonMethods.generateRandomNumberOfFixLength(7));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhone_error);
	}

	//Case-3: Validate  ClientContactPhone Exceed Max length(12)

	@Test(groups = {"All"})
	public void R2223_TC94697_OpenEVV_Member_ClientContactPhone_exceed_Max_length() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException {
		// logger = extent.startTest("R2223_TC94697_OpenEVV_Member_ClientContactPhone_exceed_Max_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	
		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);
		jsonObjectClientContact.put(globalVariables.ClientContactPhone, CommonMethods.generateRandomNumberOfFixLength(12));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactPhone_error);
	}

	//Case-4: Validate  ClientContactPhone with null

	@Test(groups = {"All"})
	public void R2223_TC94697_OpenEVV_Member_ClientContactPhone_with_null() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94697_OpenEVV_Member_ClientContactPhone_with_null");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONObject jsonObjectClientContact=dataGenerator.subArrayCreation(jsonObject,"ClientContact", 0);
		jsonObjectClientContact.put(globalVariables.ClientContactPhone, null);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

}
