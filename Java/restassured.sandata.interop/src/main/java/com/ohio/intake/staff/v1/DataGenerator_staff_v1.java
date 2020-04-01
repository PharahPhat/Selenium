package com.ohio.intake.staff.v1;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataGenerator_staff_v1 extends BaseTest{

	UniqueJsonGen_staff_v1 uniqueJsonGenerator=new UniqueJsonGen_staff_v1();
	
	public static String[] StaffPosition = { "HHA", "HCA", "RN", "LPN", "PCA", "hha", "hca", "rn", "lpn", "pca", "Hha", "Hca", "Rn", "Lpn", "Pca" };

	public Map<String, JSONObject> processOhioStaffV1(Map<String, String> jsonField ) throws InterruptedException, IOException, ParseException
	{
		Map<String, JSONObject> returnObject=new HashMap<>();

		JSONArray jsonArray = uniqueJsonGenerator.staff_Ohio(GlobalVariable_staff_v1.Ohio_StaffJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioStaffV1(jsonArray));
		JSONObject bodyAsStringGet = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioStaffV1_Get(String.valueOf(bodyAsStringPost)));

		returnObject.put( "bodyAsStringPost", bodyAsStringPost);
		returnObject.put( "bodyAsStringGet", bodyAsStringGet);
		returnObject.put("jsonObject", jsonObject);	

		return  returnObject;

	}

	public void processPositiveOhioStaffV1(Map<String, String> jsonField ) throws InterruptedException, IOException, ParseException
	{
		JSONArray jsonArray = uniqueJsonGenerator.staff_Ohio(GlobalVariable_staff_v1.Ohio_StaffJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioStaffV1(jsonArray));
		JSONObject bodyAsStringGet = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioStaffV1_Get(String.valueOf(bodyAsStringPost)));

		CommonMethods.verifyJsonPassCase(bodyAsStringGet.toString());
	}

	public Map<String, JSONObject> processOhioStaffV1MaximumAllowedLength(Map<String, String> jsonField ) throws InterruptedException, IOException, ParseException
	{
		Map<String, JSONObject> returnObject=new HashMap<>();

		JSONArray jsonArray = uniqueJsonGenerator.staff_OhioV1maximumAllowedLength(GlobalVariable_staff_v1.Ohio_StaffJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioStaffV1(jsonArray));
		JSONObject bodyAsStringGet = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioStaffV1_Get(String.valueOf(bodyAsStringPost)));

		returnObject.put( "bodyAsStringPost", bodyAsStringPost);
		returnObject.put( "bodyAsStringGet", bodyAsStringGet);
		returnObject .put("jsonObject", jsonObject);	

		return  returnObject;

	}
	
	public Map<String, JSONObject> processOhioStaffV1RequiredWithRequiredSegment(Map<String, String> jsonField ) throws InterruptedException, IOException, ParseException
	{
		Map<String, JSONObject> returnObject=new HashMap<>();

		JSONArray jsonArray = uniqueJsonGenerator.staff_OhioV1Required(GlobalVariable_staff_v1.Ohio_StaffJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove(GlobalVariable_staff_v1.staffEmail);
		jsonObject.remove(GlobalVariable_staff_v1.staffPosition);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioStaffV1(jsonArray));
		JSONObject bodyAsStringGet = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioStaffV1_Get(String.valueOf(bodyAsStringPost)));
		
		returnObject.put( "bodyAsStringPost", bodyAsStringPost);
		returnObject.put( "bodyAsStringGet", bodyAsStringGet);
		returnObject .put("jsonObject", jsonObject);	

		return  returnObject;

	}
  
	public void processOhioStaffV1RequiredSegmentMissing(Map<String, String> jsonField ) throws InterruptedException, IOException, ParseException
	{
		JSONArray jsonArray = uniqueJsonGenerator.staff_OhioV1Required(GlobalVariable_staff_v1.Ohio_StaffJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove("BusinessEntityID");
		jsonObject.remove("BusinessEntityMedicaidIdentifier");
		jsonObject.remove("StaffOtherID");
		jsonObject.remove("SequenceID");
		jsonObject.remove("StaffID");
		jsonObject.remove("StaffSSN");
		jsonObject.remove("StaffLastName");
		jsonObject.remove("StaffFirstName");
		jsonObject.remove(GlobalVariable_staff_v1.staffEmail,  CommonMethods.generateEmailAddress_alpha(10));
		jsonObject.remove(GlobalVariable_staff_v1.staffPosition, DataGenerator_staff_v1.generateStaffPosition(1));
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();
		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioStaffV1(jsonArray));

		CommonMethods.verifyjsonassertFailcase_statusbadrequest(bodyAsStringPost.toString(),
				"StaffList validation failed with the following messages");

	}

	public void assertFailErrorMessage(String bodyAsString, String Errormesssage )
	{
		logger.log(LogStatus.INFO, "Validating JSON response failed case");

		Assert.assertTrue(bodyAsString.contains(Errormesssage));

	}

	//Min i value = 0, Max i value = 14
	public static String generateStaffPosition(int i) {
		String staffPos = StaffPosition[i];
		return staffPos;
	}
	
	@SuppressWarnings("unchecked")
	public static void objectCharTruncation(JSONObject jsonobject, String objectName, int i)
	{
		if (String.valueOf(jsonobject.get(objectName)).length() > i)
		{
			jsonobject.put(objectName, jsonobject.get(objectName).toString().substring(0,i));

		}
	}

}
