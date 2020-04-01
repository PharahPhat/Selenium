/**
 * 
 */
package AltEVV_Molina.restassured.sandata.Client;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

//Test Case 92218: OpenEVV-altEVV- Client - Multiple Phone Numbers
/**
 * @author Anupam
 */

public class R2858_TC93131_AltEVV_Client_Multiple_Phone_type_Home_Mobile_Extended extends BaseTest {
	private GenerateUniqueParam GenerateUniqueParam=new GenerateUniqueParam();

	//Case1- Client json with multiple segments for PHONE: 2- Home, Mobile 
	@Test(groups = {"All"})
	public void R2858_TC93131_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Mobile() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		// logger = extent.startTest("R2858_TC93131_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Mobile");
		logger.log(LogStatus.INFO, "Validating ClientJson passed with Multiple_Phone_Numbers_Home_Mobile"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
        JSONArray jsonObject2 = (JSONArray) jsonObject.get("ClientPhone");	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
		
		jsonObject3.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject3.put(globalVariables.ClientPhoneType, "Home");
		
	   	CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}
	
	//Case2- Client json with multiple segments for PHONE: 3- Home, Mobile, Business
 
	@Test(groups = {"All"})
	public void R2858_TC93131_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Mobile_Business() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		 
		// logger = extent.startTest("R2858_TC93131_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Mobile_Business");
		logger.log(LogStatus.INFO, "Validating ClientJson passed with with_Multiple_Phone_Numbers_Home_Mobile_Business"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
        JSONArray jsonObject2 = (JSONArray) jsonObject.get("ClientPhone");	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
		
		jsonObject3.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject3.put(globalVariables.ClientPhoneType, "Mobile");
	
	    CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));

	}
	
	//Case3- Client json with multiple segments for PHONE: 4- Home, Mobile, Business, Other
	 
	@Test(groups = {"All"})
	public void R2858_TC93131_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Mobile_Business_Other() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
	{   
		 
		// logger = extent.startTest("R2858_TC93131_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Mobile_Business_Other");
		logger.log(LogStatus.INFO, "Validating ClientJson passed with with_Multiple_Phone_Numbers_Home_Mobile_Business_Other"); 

		JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		
        JSONArray jsonObject2 = (JSONArray) jsonObject.get("ClientPhone");	
		JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
		
		jsonObject3.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(10));
		jsonObject3.put(globalVariables.ClientPhoneType, "Business");
	
	    CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
	}
	
	//Case4- Client json with multiple segments for PHONE: 2- Home, Home
	 
		@Test(groups = {"All"})
		public void R2858_TC93131_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Home() throws InterruptedException, java.text.ParseException,  IOException, ParseException, ConfigurationException, SQLException, ClassNotFoundException
		{   
			 
			// logger = extent.startTest("R2858_TC93131_AltEVV_CreateClient_with_Multiple_Phone_Numbers_Home_Home");
			logger.log(LogStatus.INFO, "Validating ClientJson passed with with_Multiple_Phone_Numbers_Home_Home"); 

			JSONArray jsonArray = GenerateUniqueParam.ClientParams_AltEVV_Molina(globalVariables.client_intake_Molina);
	        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
			
	        JSONArray jsonObject2 = (JSONArray) jsonObject.get("ClientPhone");	
			JSONObject jsonObject3 = (JSONObject) jsonObject2.get(0);
			
			jsonObject3.put(globalVariables.ClientPhone, CommonMethods.generateRandomNumberOfFixLength(10));
			jsonObject3.put(globalVariables.ClientPhoneType, "Other");
		
		    CommonMethods.validateResponse(jsonArray,
				CommonMethods.propertyfileReader(globalVariables.altevvMolinaClients));
		}
}

