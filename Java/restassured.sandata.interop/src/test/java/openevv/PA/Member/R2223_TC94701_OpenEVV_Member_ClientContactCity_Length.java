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

/**
 * @author MayankM
 */
//OpenEVV Member: Validate maximum length for ClientContactCity(30)

public class R2223_TC94701_OpenEVV_Member_ClientContactCity_Length extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2223_TC94701_OpenEVV_Member_ClientContactCity_Length_max() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94701_OpenEVV_Member_ClientContactCity_Length_max");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray clientContactArray = (JSONArray) jsonObject.get(globalVariables.ClientContact);
		JSONObject clientContact = (JSONObject) clientContactArray.get(0);
		clientContact.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(30));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94701_OpenEVV_Member_ClientContactCity_Length_min() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94701_OpenEVV_Member_ClientContactCity_Length_min");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray clientContactArray = (JSONArray) jsonObject.get(globalVariables.ClientContact);
		JSONObject clientContact = (JSONObject) clientContactArray.get(0);
		clientContact.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(1));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94701_OpenEVV_Member_ClientContactCity_Length_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2223_TC94701_OpenEVV_Member_ClientContactCity_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray clientContactArray = (JSONArray) jsonObject.get(globalVariables.ClientContact);
		JSONObject clientContact = (JSONObject) clientContactArray.get(0);
		clientContact.put("ClientContactCity", CommonMethods.generateRandomStringOfFixLength(31));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactCitylengthError_mem);

	}

	@Test(groups = {"All"})
	public void R2223_TC94701_OpenEVV_Member_ClientContactCity_Length_blank() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2223_TC94701_OpenEVV_Member_ClientContactCity_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray clientContactArray = (JSONArray) jsonObject.get(globalVariables.ClientContact);
		JSONObject clientContact = (JSONObject) clientContactArray.get(0);
		clientContact.put("ClientContactCity", "");

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

	}
	
	@Test(groups = {"All"})
	public void R2223_TC94701_OpenEVV_Member_ClientContactCity_null() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94701_OpenEVV_Member_ClientContactCity_Length_invalid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray clientContactArray = (JSONArray) jsonObject.get(globalVariables.ClientContact);
		JSONObject clientContact = (JSONObject) clientContactArray.get(0);
		clientContact.put("ClientContactCity", null);

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

}