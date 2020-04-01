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
//OpenEVV Member: Verify that Modifier1 field is accepting value with length 1

public class R570_TC95203_OpenEVV_Member_Modifier1_length_1 extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test(groups = {"All"})
	public void R570_TC95203_OpenEVV_Member_Modifier1_length_1_letter() throws InterruptedException, IOException, ParseException, java.text.ParseException
	{
		// logger = extent.startTest("R570_TC95203_OpenEVV_Member_Modifier1_length_1_letter");
		
		JSONArray jsonArray = GenerateUniqueParam.MemberParams_OpenEVV(globalVariables.openevv_member_json);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		JSONArray jsonArrayProg = (JSONArray) jsonObject.get("ClientEligibility");
		JSONObject jsonObjectProg = (JSONObject) jsonArrayProg.get(0);
		
		jsonObjectProg.put("Modifier1", CommonMethods.generateRandomStringOfFixLength(1));

		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.member_post_url));

	}

}