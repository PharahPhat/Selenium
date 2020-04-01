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

public class R2223_TC94703_OpenEVV_Member_ClientContactZip_Length extends BaseTest { 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();


	@Test(groups = {"All"})
	public void R2223_TC94703_OpenEVV_Member_ClientContactZip_MaxLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94703_OpenEVV_Member_ClientContactZip_MaxLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectProg=CommonMethods.subarrayAssertionVerifier(jsonObject, "ClientContact");

		jsonObjectProg.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(9));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}


	@Test(groups = {"All"})
	public void R2223_TC94703_OpenEVV_Member_ClientContactZip_validLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException
	{
		// logger = extent.startTest("R2223_TC94703_OpenEVV_Member_ClientContactZip_validLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObjectProg=CommonMethods.subarrayAssertionVerifier(jsonObject, "ClientContact");

		jsonObjectProg.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(1));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError);
	}


	@Test(groups = {"All"})
	public void R2223_TC94703_OpenEVV_Member_ClientContactZip_invalidLength() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R2223_TC94703_OpenEVV_Member_ClientContactZip_invalidLength");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
		JSONObject jsonObjectProg=CommonMethods.subarrayAssertionVerifier(jsonObject, "ClientContact");

		jsonObjectProg.put(globalVariables.ClientContactZip, CommonMethods.generateRandomNumberOfFixLength(10));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ClientContactZipFormatError);
	}

}
