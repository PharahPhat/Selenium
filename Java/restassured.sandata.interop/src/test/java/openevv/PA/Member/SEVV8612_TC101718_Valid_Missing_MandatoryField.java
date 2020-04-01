
	package openevv.PA.Member;

	import java.io.IOException;

    import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;
	import org.json.simple.parser.ParseException;
	import org.testng.annotations.Test;

//OpenEVV Member: Validate maximum length for ClientSSN (MemberSSN)(9)
import com.globalMethods.core.*;
	import Utills_ExtentReport_Log4j.BaseTest; 
	public class SEVV8612_TC101718_Valid_Missing_MandatoryField extends BaseTest {
		@Test(groups = {"All"})
		public void TC101718_Valid_Mandatory_NonMandatory() throws IOException, ParseException, InterruptedException {
			// logger = extent.startTest("TC101718_Valid_Mandatory_NonMandatory");

			JSONArray jsonArray= CommonMethods.LoadJSON_OpenEVV(globalVariables.openevv_member_json);
			JSONObject jsonObject = (JSONObject) jsonArray.get(0);
			jsonObject.remove("ClientID");
			jsonObject.remove("ClientSSN");
			jsonObject.remove("ClientFirstName");
			jsonObject.remove("ClientLastName");
			jsonObject.remove("ClientCustomID"); 
			jsonObject.remove("ClientOtherID"); 
			jsonObject.remove("ClientMedicalRecordNumber"); 
			jsonObject.remove("ClientEmail");


			
		
			JSONArray jsonArrayElig = (JSONArray) jsonObject.get("ClientEligibility");
			JSONObject jsonObjectElig = (JSONObject) jsonArrayElig.get(0);
			jsonObjectElig.remove("PayerID");	

			JSONArray jsAdd = (JSONArray) jsonObject.get("ClientAddress");
			JSONObject jsObj = (JSONObject) jsAdd.get(0);
			jsObj.remove("ClientZip");


			String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.member_post_url));

			CommonMethods.verifyjsonassertFailcaseList(bodyAsString, CommonMethods.getjsonMemberErrorMessageForMissingRequiredField());
		}
}
