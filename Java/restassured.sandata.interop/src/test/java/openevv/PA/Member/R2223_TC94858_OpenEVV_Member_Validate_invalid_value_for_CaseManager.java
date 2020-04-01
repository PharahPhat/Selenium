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

public class R2223_TC94858_OpenEVV_Member_Validate_invalid_value_for_CaseManager extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();


@Test(groups = {"All"})
public void TC94858_OpenEVV_Member_Validate_invalid_value_for_CaseManager_with_special_character() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
{
	// logger = extent.startTest("TC94858_OpenEVV_Member_Validate_invalid_value_for_CaseManager_with_special_character");

	JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
	JSONObject jsonObject = (JSONObject) jsonArray.get(0);
	//JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientAddress");
	//JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);

	jsonObject.put("CaseManager", "abcdef6789@");

	CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

}

}
