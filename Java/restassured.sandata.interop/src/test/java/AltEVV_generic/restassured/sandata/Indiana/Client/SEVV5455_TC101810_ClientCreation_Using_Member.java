package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV5455_TC101810_ClientCreation_Using_Member extends BaseTest{
	private GenerateUniqueParam GenerateUniqueParam_member=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void TC101810_ClientCreation_Using_Member() throws InterruptedException,  IOException, ParseException
	{   
		// logger = extent.startTest("TC101810_ClientCreation_Using_Member");

		JSONArray jsonArray = GenerateUniqueParam_member.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put("ClientID", CommonMethods.generateRandomNumberOfFixLength(10));	

		CommonMethods.verifyPostAltEVVSuccessfully(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url),
				CommonMethods.propertyfileReader(globalVariables.member_get_url));
	}
}
