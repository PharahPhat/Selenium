package AltEVV_generic.restassured.sandata.Indiana.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.AdditionalInfo;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class R2267_TC91235_AltEVV_ClientAddressLongitude_Format extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Case-1 Testing with longitude more than -180
	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
		public void R2267_TC91235_AltEVV_ClientAddressLongitude_Format_minus180() throws InterruptedException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91235_AltEVV_ClientAddressLongitude_Format_MoreThan_100");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLongitude, "-181.99");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLongitude, "-181.99");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeMinError11);

	}
 
	@Test(groups = {"All"})
	public void R2267_TC91235_AltEVV_ClientAddressLongitude_Format_plus180() throws InterruptedException, IOException, ParseException  
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91235_AltEVV_ClientAddressLongitude_Format_MoreThan_100");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLongitude, "181.99");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLongitude, "181.99");

		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeMaxError11);

	}

	//Case-3 Testing with longitude less than -180 
	@Test(groups = {"All"})
	public void R2267_TC91235_AltEVV_ClientAddressLongitude_Format_LessThan180() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException {
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91235_AltEVV_ClientAddressLongitude_Format_lessthan180");


		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	

		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLongitude, "-79");

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLongitude, "-179");


		CommonMethods.validateResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}


	//Case-1 Testing with longitude more than 100 character
	@Test(groups = {"All"})
	public void R2267_TC91235_AltEVV_ClientAddressLongitude_Format_MaxLengthPlusOne() throws InterruptedException, IOException, ParseException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91235_AltEVV_ClientAddressLongitude_Format_MaxLengthplusone");


		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	

		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLongitude,CommonMethods.generateRandomNumberOfFixLength(101));

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLongitude,"181");


		String bodyAsString=CommonMethods.capturePostResponse(altEVVJsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevv_clients));

		CommonMethods.verifyjsonassertFailcase(bodyAsString, globalVariables.longitudeMaxError11);

	}
	
	@SuppressWarnings("unused")
	public void R2267_TC91238_AltEVV_ClientAddressLongitude_Format_special() throws InterruptedException, IOException, ParseException
	{   
		// adding method name info via logger
		// logger = extent.startTest("R2267_TC91238_AltEVV_ClientAddressLatitude_Format_MaxLengthplusone");

		//loading the Json dynamically with unique value set 
		JSONArray altEVVJsonArray = GenerateUniqueParam.ClientParams_AltEVV(globalVariables.client_intake); 
		JSONObject altEVVJsonObject = (JSONObject) altEVVJsonArray.get(0);
		JSONArray altEVVJsonArrayAddress = (JSONArray) altEVVJsonObject.get(globalVariables.addressArrayjson);	
		
		JSONObject altEVVJsonObjectAddress = (JSONObject) altEVVJsonArrayAddress.get(0);
		altEVVJsonObjectAddress.put(globalVariables.ClientAddressLongitude,CommonMethods.generateSpecialChar(10));

		JSONObject altEVVJsonObjectAddress_add = (JSONObject) altEVVJsonArrayAddress.get(1);
		altEVVJsonObjectAddress_add.put(globalVariables.ClientAddressLongitude,CommonMethods.generateSpecialChar(10));
		
		CommonMethods.capturePostResponse_400(altEVVJsonArray, CommonMethods.propertyfileReader(globalVariables.altevv_clients));
	}
}
