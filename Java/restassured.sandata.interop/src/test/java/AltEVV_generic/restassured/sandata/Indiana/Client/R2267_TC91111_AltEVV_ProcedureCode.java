package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

/*
Obsolete
 */

public class R2267_TC91111_AltEVV_ProcedureCode extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

////  Validating with valid ProcedureCode with invalid length
@Test(enabled = false, groups = {"All"})
public void R2267_TC91111_AltEVV_ProcedureCode_invalid_Length() throws InterruptedException,  IOException, ParseException
{   
	// adding method name info via logger
	// logger = extent.startTest("R2267_TC91105_AltEVV_ProcedureCode_invalid_Length");

	//loading the Json dynamically with unique value set 
	JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
	JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
	JSONArray altEVVJsonArraypayer = (JSONArray) altEVVJsonObject.get("ClientPayerInformation");

	JSONObject altEVVJsonObjectpayer = (JSONObject) altEVVJsonArraypayer.get(0);
	altEVVJsonObjectpayer.put(globalVariables.jsonProcedureCode,CommonMethods.generateRandomNumberOfFixLength(6));

	String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,
			CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProcedureCodeLengthError);
}

//// Validating with valid ProcedureCode with special char
@Test(enabled = false, groups = {"All"})
public void R2267_TC91111_AltEVV_ProcedureCode_with_SpecialChar() throws InterruptedException, IOException, ParseException
{   
	// adding method name info via logger
	// logger = extent.startTest("R2267_TC91105_AltEVV_ProcedureCode_with_SpecialChar");

	//loading the Json dynamically with unique value set 
	JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
	JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);

	JSONArray altEVVJsonArraypayer = (JSONArray) altEVVJsonObject.get("ClientPayerInformation");
	JSONObject altEVVJsonObjectpayer = (JSONObject) altEVVJsonArraypayer.get(0);

	altEVVJsonObjectpayer.put(globalVariables.jsonProcedureCode,"a@sb");

	String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,
			CommonMethods.propertyfileReader(globalVariables.altevv_clients));

	CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.ProcedureCodeFormatError);


}


}

