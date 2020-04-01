package openevv.Connecticut.Client;

import java.io.IOException;
import java.sql.SQLException;

import com.globalMethods.core.*;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Utills_ExtentReport_Log4j.BaseTest;

public class SEVV3068_TC94594_OpenEVV_Clientupdation_with_sameID_validation extends BaseTest
{ 
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();
	private Assertion_DbVerifier assertionDbVerifier =new Assertion_DbVerifier();

	@Test(groups = {"All", "Regression"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC94594_OpenEVV_Clientupdation_with_sameID_validation() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		String ClientLname= CommonMethods.generateRandomStringOfFixLength(10);
		String ClientFname= CommonMethods.generateRandomStringOfFixLength(10);
		String ClientEmailid= CommonMethods.generateEmailAddress_string(10);
		
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);	
		
		jsonObject.put("ClientFirstName", ClientLname);
		
		jsonObject.put("ClientLastName", ClientFname);
		
		jsonObject.put("ClientEmailAddress", ClientEmailid);

		String bodyAsString = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);
		
		jsonObject.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(9));
		
		jsonObject.put("ClientLastName", CommonMethods.generateRandomStringOfFixLength(9));
		
		jsonObject.put("ClientEmailAddress", ClientEmailid);

		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString1, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));
		
		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsStringGet, jsonObject1);
	}

	//Case2: Updated only Last Name /First Name along with other fields 
	@Test(groups = {"All", "Regression", "fixing"})
	@AdditionalInfo(module = "OpenEVV")
	public void TC94594_OpenEVV_Clientupdation_with_existingID_otherfields() throws InterruptedException, IOException, ParseException, SQLException, ClassNotFoundException, java.text.ParseException
	{
		JSONArray jsonArray=GenerateUniqueParam.ClientParams_OpenEVV("client");

		JSONObject jsobject = (JSONObject) jsonArray.get(0);
		
		jsobject.put("ClientFirstName", CommonMethods.generateRandomStringOfFixLength(9));
		
		jsobject.put("ClientLastName", CommonMethods.generateRandomStringOfFixLength(9));
		
		String bodyAsString1 = CommonMethods.captureResponseOPENEVV(jsonArray, CommonMethods.propertyfileReader(globalVariables.openevv_client_url), CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		String bodyAsStringGet=CommonMethods.captureResponseOpenEVVGetWithUID(bodyAsString1, CommonMethods.propertyfileReader(globalVariables.openevv_client_get));

		assertionDbVerifier.stxClientSql_OpenEvv(bodyAsStringGet, jsobject);
	}

}
