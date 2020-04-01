package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.Assertion_DbVerifier;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class R679_TC96601_AltEVV_with_ProcedureCode_max_null extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier = new Assertion_DbVerifier();

	@Test(groups = {"All", "fixing"})
	public void R679_TC96601_AltEVV_with_ProcedureCode_max() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException
	{
		// logger = extent.startTest("R679_TC96601_AltEVV_with_payerpro_max");
		logger.log(LogStatus.INFO, "R679_TC96601_AltEVV_with_payerpro_max");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		
		jsonObject1.put("ClientStatus", "02");
		jsonObject1.put("ProcedureCode", "G029999");
		
		
		JSONObject jsonObject2= (JSONObject) jsonArray1.get(1);
		
		jsonObject2.put("ClientStatus", "02");
		jsonObject2.put("ProcedureCode", "G029999");
		
				
		CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		assertionDbVerifier.verifyAuthLimitsAltEVVGeneric(jsonObject, jsonObject1);
	}
	
	@Test(groups = {"All"})
	public void R679_TC96601_AltEVV_with_ProcedureCode_null() throws IOException, ParseException
	{
		// logger = extent.startTest("R679_TC96601_AltEVV_with_payerpro_null");
		logger.log(LogStatus.INFO, "R679_TC96601_AltEVV_with_payerpro_null");  
		
		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONArray jsonArray1 = (JSONArray) jsonObject.get(globalVariables.Client_Payer_Information);
		JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
		
		jsonObject1.put("ClientStatus", "02");
		jsonObject1.put("ProcedureCode", null);
		
		
		JSONObject jsonObject2= (JSONObject) jsonArray1.get(1);
		
		jsonObject2.put("ClientStatus", "02");
		jsonObject2.put("ProcedureCode", null);
		
				
		String bodyAsString = CommonMethods.capturePostResponse(jsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	
		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProcedureCodeNullError);

	}
	
	
}