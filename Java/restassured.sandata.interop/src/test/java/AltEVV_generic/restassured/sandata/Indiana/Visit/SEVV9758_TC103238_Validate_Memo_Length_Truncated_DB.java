package AltEVV_generic.restassured.sandata.Indiana.Visit;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SEVV9758_TC103238_Validate_Memo_Length_Truncated_DB extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	@Test
	public void TC103238_Validate_Memo_Length_Truncated_DB() throws IOException, ParseException {
		
		// logger = extent.startTest("TC103238_Validate_Memo_Length_Truncated_DB");

		JSONArray jsonArrayVisit=GenerateUniqueParam.VisitParams_AltEVV();
		JSONObject jsonObjectVisit = (JSONObject) jsonArrayVisit.get(0);

		jsonObjectVisit.put(globalVariables.Memojson, CommonMethods.generateRandomNumberOfFixLength(513));

		String bodyAsString = CommonMethods.capturePostResponse(jsonArrayVisit,
				CommonMethods.propertyfileReader(globalVariables.altevv_visit));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.errorMemolength);
	}

}
