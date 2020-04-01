package com.ohio.intake.Visit.v1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.globalMethods.core.CommonMethods;
import com.relevantcodes.extentreports.LogStatus;
import Utills_ExtentReport_Log4j.BaseTest;

public class DataGenerator_Ohio_Visit_v1 extends BaseTest{

	UniqueJsonGenerator_Ohio_Visit_v1 uniqueJsonGenerator=new UniqueJsonGenerator_Ohio_Visit_v1();

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
		jsonObjectMap_Supp.put(GlobalVariable_Ohio_Visit_v1.PatientZip, String.valueOf(jsonObjectMap_Supp.get(GlobalVariable_Ohio_Visit_v1.PatientZip)).replace("-", ""));
		jsonObjectMap_Address.put(GlobalVariable_Ohio_Visit_v1.PatientZip, String.valueOf(jsonObjectMap_Address.get(GlobalVariable_Ohio_Visit_v1.PatientZip)).replace("-", ""));
		
		CommonMethods.ZipadditionfourZero(jsonObjectMap_Supp, GlobalVariable_Ohio_Visit_v1.PatientZip);
		CommonMethods.ZipadditionfourZero(jsonObjectMap_Address, GlobalVariable_Ohio_Visit_v1.PatientZip);

	}
	
}
