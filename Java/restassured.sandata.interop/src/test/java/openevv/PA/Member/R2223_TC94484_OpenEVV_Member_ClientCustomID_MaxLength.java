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

/**
 * @author MayankM
 */
//OpenEVV Member: Validate maximum length for ClientCustomID(24)

public class R2223_TC94484_OpenEVV_Member_ClientCustomID_MaxLength extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R2223_TC94484_OpenEVV_Member_ClientCustomID_MaxLength_Valid() throws InterruptedException,  IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R2223_TC94484_OpenEVV_Member_ClientCustomID_MaxLength_Valid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ClientCustomID, CommonMethods.generateRandomNumberOfFixLength(24));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));
	}

	@Test(groups = {"All"})
	public void R2223_TC94484_OpenEVV_Member_ClientCustomID_MaxLength_invalid() throws InterruptedException, java.text.ParseException,  IOException, ParseException
	{
		// logger = extent.startTest("R2223_TC94484_OpenEVV_Member_ClientCustomID_MaxLength_Valid");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ClientCustomID, CommonMethods.generateRandomNumberOfFixLength(25));	

		String bodyAsString = CommonMethods.capturePostResponse(jsonArray,
						CommonMethods.propertyfileReader(globalVariables.member_post_url));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.Clientcustomiderror);
	}

}