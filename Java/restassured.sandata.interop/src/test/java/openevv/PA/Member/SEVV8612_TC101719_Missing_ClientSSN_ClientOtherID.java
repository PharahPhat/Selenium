
	package openevv.PA.Member;

	import java.io.IOException;
	import java.sql.SQLException;
	import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;
	import org.json.simple.parser.ParseException;
	import org.testng.annotations.Test;

//OpenEVV Member: Validate maximum length for ClientSSN (MemberSSN)(9)
import com.globalMethods.core.*;
	import Utills_ExtentReport_Log4j.BaseTest; 
	public class SEVV8612_TC101719_Missing_ClientSSN_ClientOtherID extends BaseTest { 
		GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
		Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();
	

		@Test(groups = {"All"})
		public void TC101719_Missing_ClientSSN_ClientOtherID() throws InterruptedException, java.text.ParseException,  IOException, ParseException, SQLException, ClassNotFoundException
		{
			// logger = extent.startTest("TC101719_Missing_ClientSSN_ClientOtherID");

			JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);

			jsonObject.remove(globalVariables.ClientSSN);
			jsonObject.remove(globalVariables.ClientOtherIDjson);

			String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

			CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.memberClientSSNNullError);
		}
}
