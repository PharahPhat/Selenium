package Ohio.sandata.restclaim;

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
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class Auto_SEVV8523_TC103295_TC103298_EqualOrGreaterThan_PayerID_Max_Length extends BaseTest{
	
	GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	Assertion_DbVerifier Assertion_DbVerifier= new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression", "fixing"})
	public void TC103295_TC103298_EqualOrGreaterThan_PayerID_Max_Length() throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
		
		// logger = extent.startTest("TC103295_TC103298_EqualOrGreaterThan_PayerID_Max_Length");

		Map<String, JSONObject> MapjsonObject=GenerateUniqueParam.ohioclaim_Rest();

		JSONArray claimSubArray= (JSONArray) MapjsonObject.get("rest").get("EVV_Request");
		JSONObject claimSubobject =  (JSONObject) claimSubArray.get(0);
		claimSubobject.put(globalVariables.matchingRulejson, "EqualOrGreaterThan");
		claimSubobject.put(globalVariables.payerjson, CommonMethods.generateRandomStringOfFixLength(64));
		
		String bodyAsString= CommonMethods.captureResponseClaim(MapjsonObject.get("rest"), CommonMethods.propertyfileReader("Rest_claim"));

		logger.log(LogStatus.INFO,"Veirfying the error message");

		CommonMethods.CapterrestclaimResponse_invalid(bodyAsString,globalVariables.PayerLengthError);
		
	}

}
