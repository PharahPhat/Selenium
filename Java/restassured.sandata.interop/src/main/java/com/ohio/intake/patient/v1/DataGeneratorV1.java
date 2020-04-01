package com.ohio.intake.patient.v1;

import Utills_ExtentReport_Log4j.BaseTest;
import com.globalMethods.core.CommonMethods;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class DataGeneratorV1 extends BaseTest{

	private UniqueJsonGeneratorV1 uniqueJsonGenerator=new UniqueJsonGeneratorV1();

	public  JSONObject subArrayCreation(JSONObject jsonObject,  String subArrayname, int indexofSubArray) 
	{
		JSONArray jsonArrayAdd = 	(JSONArray) jsonObject.get(subArrayname);
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayAdd.get(indexofSubArray);

		return jsonObjectAdd;
	}

	public Map<String, JSONObject> processOhioPatientV1(Map<String, String> jsonField ) throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException
	{
		Map<String, JSONObject> retunObject=new HashMap<>();

		JSONArray jsonArray = uniqueJsonGenerator.patient_Ohio(GlobalVariable_V1.Ohio_patientJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Get(String.valueOf(bodyAsStringPost)));
		
		retunObject.put( "bodyAsStringPost", bodyAsStringPost);
		retunObject.put( "bodyAsStringGet", bodyAsStringget);
		retunObject .put("jsonObject", jsonObject);	

		return  retunObject;

	}

	public Map<String, JSONObject> processOhioPatientV1MaximumAllowedLength(Map<String, String> jsonField ) throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException
	{
		Map<String, JSONObject> retunObject=new HashMap<>();

		JSONArray jsonArray = uniqueJsonGenerator.patient_OhioV1maximumAllowedLength(GlobalVariable_V1.Ohio_patientJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Get(String.valueOf(bodyAsStringPost)));
		
		retunObject.put( "bodyAsStringPost", bodyAsStringPost);
		retunObject.put( "bodyAsStringGet", bodyAsStringget);
		retunObject .put("jsonObject", jsonObject);	

		return  retunObject;

	}

	public Map<String, JSONObject> processOhioPatientV1MoreThanAllowedLength(Map<String, String> jsonField ) throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException
	{
		Map<String, JSONObject> retunObject=new HashMap<>();

		JSONArray jsonArray = uniqueJsonGenerator.patient_OhioV1MoreThanAllowedLength(GlobalVariable_V1.Ohio_patientJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Get(String.valueOf(bodyAsStringPost)));
		
		retunObject.put( "bodyAsStringPost", bodyAsStringPost);
		retunObject.put( "bodyAsStringGet", bodyAsStringget);
		retunObject .put("jsonObject", jsonObject);	

		return  retunObject;

	}

	public Map<String, JSONObject> processOhioPatientV1RequiredWithRequiredSegment(Map<String, String> jsonField ) throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException
	{
		Map<String, JSONObject> retunObject=new HashMap<>();

		JSONArray jsonArray = uniqueJsonGenerator.patient_OhioV1Required("patient_v1_Required");
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Get(String.valueOf(bodyAsStringPost)));
		
		retunObject.put( "bodyAsStringPost", bodyAsStringPost);
		retunObject.put( "bodyAsStringGet", bodyAsStringget);
		retunObject .put("jsonObject", jsonObject);	

		return  retunObject;

	}

	public Map<String, JSONObject> processOhioPatientV1WithSubArray(Map<String, String> jsonField, String SubArrayField, int subArrayIndex ) throws ClassNotFoundException, InterruptedException, IOException,java.text.ParseException, ParseException, SQLException
	{
		Map<String, JSONObject> retunObject=new HashMap<>();
		JSONArray jsonArray = uniqueJsonGenerator.patient_Ohio(GlobalVariable_V1.Ohio_patientJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObject_Sub=subArrayCreation(jsonObject, SubArrayField, subArrayIndex);
		jsonObject_Sub.putAll(jsonField);
		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Get(String.valueOf(bodyAsStringPost)));
		
		retunObject.put( "bodyAsStringPost", bodyAsStringPost);
		retunObject.put( "bodyAsStringGet", bodyAsStringget);
			retunObject .put("jsonObject", jsonObject);	
		retunObject .put("jsonObject_Sub", jsonObject_Sub);	

		return  retunObject;

	}

	public Map<String, JSONObject> processOhioPatientV1WithSubArrayRemove(String jsonField, String SubArrayField, int subArrayIndex ) throws ClassNotFoundException, InterruptedException, IOException,java.text.ParseException, ParseException, SQLException
	{
		Map<String, JSONObject> retunObject=new HashMap<>();
		JSONArray jsonArray = uniqueJsonGenerator.patient_Ohio(GlobalVariable_V1.Ohio_patientJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObject_Sub=subArrayCreation(jsonObject, SubArrayField, subArrayIndex);
		jsonObject_Sub.remove(jsonField);
		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Get(String.valueOf(bodyAsStringPost)));
		
		retunObject.put( "bodyAsStringPost", bodyAsStringPost);
		retunObject.put( "bodyAsStringGet", bodyAsStringget);
		retunObject .put("jsonObject", jsonObject);	
		retunObject .put("jsonObject_Sub", jsonObject_Sub);	

		return  retunObject;

	}
	
	public Map<String, JSONObject> processOhioPatientV1RequiredFieldRemove(String jsonField) throws ClassNotFoundException, InterruptedException, IOException, ParseException, java.text.ParseException,SQLException
	{
		Map<String, JSONObject> retunObject=new HashMap<>();
		JSONArray jsonArray = uniqueJsonGenerator.patient_Ohio(GlobalVariable_V1.Ohio_patientJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.remove(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Get(String.valueOf(bodyAsStringPost)));
		
		retunObject.put( "bodyAsStringPost", bodyAsStringPost);
		retunObject.put( "bodyAsStringGet", bodyAsStringget);
		retunObject .put("jsonObject", jsonObject);	

		return  retunObject;

	}
	
	
	public Map<String, JSONObject> processOhioPatientV1RequiredFieldMissing(Map<String, String> jsonField) throws ClassNotFoundException, InterruptedException, IOException,java.text.ParseException, ParseException, SQLException
	{
		Map<String, JSONObject> retunObject=new HashMap<>();
		JSONArray jsonArray = uniqueJsonGenerator.patient_Ohio_RequiredFiledMissing(GlobalVariable_V1.Ohio_patientJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Get(String.valueOf(bodyAsStringPost)));
		
		retunObject.put( "bodyAsStringPost", bodyAsStringPost);
		retunObject.put( "bodyAsStringGet", bodyAsStringget);
		retunObject .put("jsonObject", jsonObject);	

		return  retunObject;

	}

	public Map<String, JSONObject> processOhioPatientV1SubArray_AddressSegment(Map<String, String> jsonField) throws ClassNotFoundException, InterruptedException, IOException,java.text.ParseException, ParseException, SQLException
	{
		Map<String, JSONObject> returnObject=new HashMap<>();
		JSONArray jsonArray = uniqueJsonGenerator.patient_Ohio(GlobalVariable_V1.Ohio_patientJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObject_Sub=subArrayCreation(jsonObject, GlobalVariable_V1.Address, 0);
		jsonObject_Sub.putAll(jsonField);
		JSONObject jsonObject_Add=subArrayCreation(jsonObject, GlobalVariable_V1.Address, 1);
		jsonObject_Add.putAll(jsonField);
		

		JSONParser parser = new JSONParser();
		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Get(String.valueOf(bodyAsStringPost)));

		returnObject.put( "bodyAsStringPost", bodyAsStringPost);
		returnObject.put( "bodyAsStringGet", bodyAsStringget);
		returnObject .put("jsonObject", jsonObject);
		returnObject .put("jsonObject_Sub", jsonObject_Sub);
		returnObject .put("jsonObject_Add", jsonObject_Add);


		return  returnObject;

	}
	
	public void processOhioPatientV1PositiveCase(Map<String, String> jsonField) throws ClassNotFoundException, InterruptedException, IOException,java.text.ParseException, ParseException, SQLException
	{
		JSONArray jsonArray = uniqueJsonGenerator.patient_Ohio(GlobalVariable_V1.Ohio_patientJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();
		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		JSONObject bodyAsStringGet = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Get(String.valueOf(bodyAsStringPost)));

		CommonMethods.verifyJsonPassCase(bodyAsStringGet.toString());
	}
	
	public Map<String, JSONObject> processOhioPatientV1FullyPopulated(Map<String, String> jsonField) throws ClassNotFoundException, java.text.ParseException,InterruptedException, IOException, ParseException, SQLException
	{
		Map<String, JSONObject> retunObject=new HashMap<>();
		JSONArray jsonArray = uniqueJsonGenerator.patient_OhioFullPopulated(GlobalVariable_V1.Ohio_patientJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();
		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Get(String.valueOf(bodyAsStringPost)));
		
		retunObject.put( "bodyAsStringPost", bodyAsStringPost);
		retunObject.put( "bodyAsStringGet", bodyAsStringget);
		retunObject .put("jsonObject", jsonObject);	

		return  retunObject;

	}

	public Map<String, JSONObject> processOhioPatientV1SubArray_RemoveAddressSegment(String jsonField) throws ClassNotFoundException, java.text.ParseException,InterruptedException, IOException, ParseException, SQLException
	{
		Map<String, JSONObject> retunObject=new HashMap<>();
		JSONArray jsonArray = uniqueJsonGenerator.patient_Ohio(GlobalVariable_V1.Ohio_patientJson_v1);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonArray.remove(GlobalVariable_V1.Address);
		JSONObject jsonObject_Sub=subArrayCreation(jsonObject, GlobalVariable_V1.Address, 0);
		jsonObject_Sub.remove(jsonField);
		JSONObject jsonObject_Add=subArrayCreation(jsonObject, GlobalVariable_V1.Address, 1);
		jsonObject_Sub.remove(jsonField);

		JSONParser parser = new JSONParser();
		JSONObject bodyAsStringPost = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Post(jsonArray));
		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV1_Get(String.valueOf(bodyAsStringPost)));
		
		retunObject.put( "bodyAsStringPost", bodyAsStringPost);
		retunObject.put( "bodyAsStringGet", bodyAsStringget);
		retunObject .put("jsonObject", jsonObject);	
		retunObject .put("jsonObject_Sub", jsonObject_Sub);	
		retunObject .put("jsonObject_Add", jsonObject_Add);	


		return  retunObject;

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
			Assert.assertTrue(bodyAsString.contains(body));
		}

	}

	public  int generateRandomIntegerInRange(int i, int j) {
		int randomInt = ThreadLocalRandom.current().nextInt(i, j);
		System.out.println("Random number generated is : " + randomInt);
		return randomInt;
	}

	public static List<String> getErrorMessageRequiredFieldMissing(){
		List<String> Errormessage = new ArrayList<>();
		Errormessage.add(GlobalVariable_V1.PatientOtherIDNullError);
		Errormessage.add(GlobalVariable_V1.SequenceIDNullError);
		Errormessage.add(GlobalVariable_V1.PatientLastNameNullError);
		Errormessage.add(GlobalVariable_V1.PatientFirstNameNullError);
		Errormessage.add(GlobalVariable_V1.PatientResponsiblePartyFirstNameNullError);
		Errormessage.add(GlobalVariable_V1.PatientResponsiblePartyLastNameNullError);
		Errormessage.add(GlobalVariable_V1.PatientAddressLine1NullError);
		Errormessage.add(GlobalVariable_V1.PatientCityNullError);
		Errormessage.add(GlobalVariable_V1.PatientStateNullError);
		Errormessage.add(GlobalVariable_V1.PatientZipNullError);
		Errormessage.add(GlobalVariable_V1.nullErrorMessagePatientPhoneType);
		Errormessage.add(GlobalVariable_V1.nullErrorMessagePatientPhoneNumber);


		return Errormessage;
	}

	public static List<String> getErrorMessageForMoreThanSpecifiedLength(){
		List<String> Errormessage = new ArrayList<>();
		Errormessage.add("The PatientPhoneNumber format is incorrect. It must be provided as 10 digits.");
		Errormessage.add("The PatientResponsiblePartyFirstName value will be truncated to 30 characters. The length should be between 1 and 30.");
		Errormessage.add("The SequenceID value exceeds the maximum length of 16 characters. The record is being rejected. The length should be between 1 and 16.");
		Errormessage.add("The PatientOtherID value exceeds the maximum length of 64 characters. The record is being rejected. The length should be between 1 and 64.");
		Errormessage.add("The PatientFirstName value will be truncated to 30 characters. The length should be between 1 and 30.");
		Errormessage.add("The SequenceID format is incorrect. It should be between 1 and 16 characters. The record is being rejected.");
		Errormessage.add("The PatientMedicaidID format is incorrect. The record is being rejected. It should be 12 digits (with leading zeros)");
		Errormessage.add("The PatientLastName value will be truncated to 30 characters. The length should be between 1 and 30.");
		Errormessage.add("The PatientAddressLine2 value will be truncated to 30 characters. The length should be between 1 and 30.");
		Errormessage.add("The PatientAddressLine1 format is incorrect. It should be between 1 and 30 characters.");
		Errormessage.add("The PatientCity value will be truncated to 30 characters. The length should be between 1 and 30.");

		return Errormessage;
	}
}
