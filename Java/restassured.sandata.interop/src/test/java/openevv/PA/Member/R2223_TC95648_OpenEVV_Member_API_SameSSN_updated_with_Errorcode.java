package openevv.PA.Member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;

import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import Utills_ExtentReport_Log4j.BaseTest;

public class R2223_TC95648_OpenEVV_Member_API_SameSSN_updated_with_Errorcode extends BaseTest { GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam(); Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	
	public static String SSN;

	@Test(groups = {"All"})
	public void R2223_TC95648_OpenEVV_Member_API_SameSSN_updated_with_Errorcodes() throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException 
	{
		// logger = extent.startTest("R2223_TC95648_OpenEVV_Member_API_SameSSN_updated_with_Errorcodes");

		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);

		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		jsonObject.put(globalVariables.ClientSSN,CommonMethods.generateRandomNumberOfFixLength(9));
		SSN= jsonObject.get("ClientSSN").toString();
		CommonMethods.validateResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));
		
		JSONArray jsonArrayRe = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);

		JSONObject jsonObjectRe = (JSONObject) jsonArrayRe.get(0);

		jsonObjectRe.put(globalVariables.ClientSSN, SSN);
		jsonObjectRe.put(globalVariables.ClientID, CommonMethods.generateRandomNumberOfFixLength(10));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

	}

}
