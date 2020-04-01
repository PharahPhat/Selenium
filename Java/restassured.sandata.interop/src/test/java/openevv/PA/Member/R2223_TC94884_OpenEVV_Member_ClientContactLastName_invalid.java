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

public class R2223_TC94884_OpenEVV_Member_ClientContactLastName_invalid extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void TC94884_OpenEVV_Member_Validate_invalid_value_for_ClientContactLastName_with_special_character() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC94884_OpenEVV_Member_Validate_invalid_value_for_ClientContactLastName_with_special_character");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayClientContact = (JSONArray) jsonObject.get("ClientContact");
		JSONObject jsonObjectClientContact = (JSONObject) jsonArrayClientContact.get(0);
		jsonObjectClientContact.put("ClientContactLastName", CommonMethods.generateSpecialChar(7));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
		CommonMethods.verifyjsonassertFailcase(bodyAsString, "The ClientContactLastName format is incorrect.");
	}
	
	@Test(groups = {"All"})
	public void TC94884_OpenEVV_Member_Validate_invalid_value_for_ClientContactLastName_with_morethan_max_length() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("TC94884_OpenEVV_Member_Validate_invalid_value_for_ClientContactLastName_with_morethan_max_length");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayClientContact = (JSONArray) jsonObject.get("ClientContact");
		JSONObject jsonObjectClientContact = (JSONObject) jsonArrayClientContact.get(0);
		jsonObjectClientContact.put("ClientContactLastName", CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactLastNamelengtherror);
	}
	

}
