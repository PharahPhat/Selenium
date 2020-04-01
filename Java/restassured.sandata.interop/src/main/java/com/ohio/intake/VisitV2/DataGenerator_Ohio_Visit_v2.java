package com.ohio.intake.VisitV2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.globalMethods.core.CommonMethods;
import com.relevantcodes.extentreports.LogStatus;

import Utills_ExtentReport_Log4j.BaseTest;

/**
 * @author Anupam
 *
 */
public class DataGenerator_Ohio_Visit_v2 extends BaseTest{

	UniqueJsonGenerator_Ohio_Visit_v2 uniqueJsonGenerator=new UniqueJsonGenerator_Ohio_Visit_v2();

	public  JSONObject mainArrayCreation(String TestCaseName, JSONArray jsonArray, int indexofArray) throws FileNotFoundException, ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException
	{

		JSONObject jsonObject = (JSONObject) jsonArray.get(indexofArray);

		return jsonObject;
	}

	public void assertFailErrorMessage(String bodyAsString, String Errormesssage )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");

		Assert.assertTrue(bodyAsString.contains(Errormesssage));

	}

	public void assertFailErrorMessageList(String bodyAsString, List<String> errorMessage )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");

		for(String body : errorMessage)
		{
			Assert.assertFalse(bodyAsString.contains(body));

		}

	}
	
	public static List<String> getErrorMessageForMoreThanSpecifiedLength(){
		List<String> Errormessage = new ArrayList<String>();
		
		Errormessage.add("The VisitOtherID value is greater than 64 characters. The length should be between 1 and 64.");
		Errormessage.add("The VisitFirstName value will be truncated to 30 characters. The length should be between 1 and 30.");
		Errormessage.add("The SequenceID value exceeds the maximum length of 16 characters.");
		Errormessage.add("The VisitLastName value will be truncated to 30 characters. The length should be between 1 and 30.");
		Errormessage.add("The VisitID value will be truncated to 9 characters. The length should be between 1 and 9.");
		Errormessage.add("The VisitSSN value is incorrect.  It must be 9 digits.");
		Errormessage.add("The VisitEmail value will be truncated to 64 characters. The length should be between 1 and 64.");
		Errormessage.add("The VisitPosition must be one of the acceptable values specified. The value is being inserted into the database as null.");
		
		return Errormessage;
	}
	
	@SuppressWarnings("unchecked")
	public static void objectCharTruncation(JSONObject jsonobject, String objectName, int i)
	{
		if (String.valueOf(jsonobject.get(objectName)).length() > i)
		{
			jsonobject.put(objectName, jsonobject.get(objectName).toString().substring(0,i));

		}
	}

	public void patientZipScenario(JSONObject jsonObjectMap_Supp, JSONObject jsonObjectMap_Address) 
	{
		jsonObjectMap_Supp.put(GlobalVariable_Ohio_Visit_v2.PatientZip, String.valueOf(jsonObjectMap_Supp.get(GlobalVariable_Ohio_Visit_v2.PatientZip)).replace("-", ""));
		jsonObjectMap_Address.put(GlobalVariable_Ohio_Visit_v2.PatientZip, String.valueOf(jsonObjectMap_Address.get(GlobalVariable_Ohio_Visit_v2.PatientZip)).replace("-", ""));
		
		CommonMethods.ZipadditionfourZero(jsonObjectMap_Supp, GlobalVariable_Ohio_Visit_v2.PatientZip);
		CommonMethods.ZipadditionfourZero(jsonObjectMap_Address, GlobalVariable_Ohio_Visit_v2.PatientZip);

	}
	public JSONObject Ohiov2_PayerID_PayerLogic(JSONObject jsonObject_Map) 
	{
		//	Payer is mandatory field, Valid values: Aetna,Buckeye,CareSource,DODD,Molina,ODA,ODM,Paramount,UHC
		//	if Payer having any of above value then PayerID will be overwritten by Payer and PayerID become non mandate field
		//	if Payer having any of above value and PayerID is null then it will be overwritten by Payer value and PayerID become non mandate field

		if(String.valueOf(jsonObject_Map.get("PayerID")).equalsIgnoreCase("null") || String.valueOf(jsonObject_Map.get("PayerID")).isEmpty() || (jsonObject_Map.get("PayerID").toString().equals("Aetna")) ||(jsonObject_Map.get("PayerID").toString().equals("Buckeye")) || (jsonObject_Map.get("PayerID").toString().equals("CareSource")) || (jsonObject_Map.get("PayerID").toString().equals("DODD")) || (jsonObject_Map.get("PayerID").toString().equals("Molina")) || (jsonObject_Map.get("PayerID").toString().equals("ODM")) || (jsonObject_Map.get("PayerID").toString().equals("ODA")) || (jsonObject_Map.get("PayerID").toString().equals("Paramount")) || (jsonObject_Map.get("PayerID").toString().equals("UHC")));
		{
			jsonObject_Map.put("PayerID", jsonObject_Map.get("Payer").toString());
		}
		
		return jsonObject_Map;
	}
	} 
	

