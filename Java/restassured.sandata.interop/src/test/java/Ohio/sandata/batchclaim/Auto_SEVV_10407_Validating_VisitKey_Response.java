package Ohio.sandata.batchclaim;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import Utills_ExtentReport_Log4j.BaseTest;

public class Auto_SEVV_10407_Validating_VisitKey_Response extends BaseTest{
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();

//	@Test(groups = {"All", "Regression"})
	public void SEVV_10407_Validating_VisitKey_Response() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
		
		// logger = extent.startTest("SEVV_10407_Validating_VisitKey_Response");
		
		JSONArray JsonArrayMultiple =new JSONArray();
		
		Map<String, JSONObject> MapjsonObjectFirstVisit=GenerateUniqueParam.ohioclaim_Rest();
		Map<String, JSONObject> MapjsonObjectSecondVisit=GenerateUniqueParam.ohioclaim_Rest();

		JsonArrayMultiple.add(MapjsonObjectFirstVisit.get("rest"));
		
		JSONArray claimSecondArray= (JSONArray) MapjsonObjectSecondVisit.get("rest").get("EVV_Request");
		JSONObject claimSecondobject =  (JSONObject) claimSecondArray.get(0);
		JsonArrayMultiple.add(claimSecondobject);
		
		JSONObject jsonObjMult = (JSONObject) JsonArrayMultiple.get(0);
		
		String bodyAsString= CommonMethods.captureResponseClaim(jsonObjMult, CommonMethods.propertyfileReader("Rest_claim"));

		Assertion_DbVerifier.claim_assertion(bodyAsString, jsonObjMult);	
	}

}
