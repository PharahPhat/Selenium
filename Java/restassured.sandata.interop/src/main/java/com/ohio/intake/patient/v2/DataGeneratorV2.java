package com.ohio.intake.patient.v2;

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

public class DataGeneratorV2 extends BaseTest {

	UniqueJsonGeneratorV2 uniqueJsonGenerator = new UniqueJsonGeneratorV2();

	public static List<String> getErrorMessageForMoreThanSpecifiedLength() {
		List<String> Errormessage = new ArrayList<String>();
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

	public static List<String> getErrorMessageAuthorizationLimitEndTimeerror() {
		List<String> Errormessage = new ArrayList<String>();
		Errormessage.add("ERROR: (AuthorizationEndDate + AuthorizationLimitEndTime) must be after (AuthorizationLimitStartDate + AuthorizationStartTime)");
		Errormessage.add("ERROR: AuthorizationLimitDayOfWeek must be values: Mon, Tue, Wed, Thu, Fri, Sat, Sun if AuthorizationLimitType is S or D.");
		Errormessage.add("ERROR: AuthorizationLimitEndTime optional if AuthorizationLimitType is S or D. Does not apply for other AuthorizationLimitTypes. The record should satisfy this format HHmm assuming a 24 hour clock.\"");
		return Errormessage;

	}

	public static JSONObject IsPatientNewbornJsonDB(JSONObject jsonObject_Map) {

		if (jsonObject_Map.get("IsPatientNewborn").equals(Boolean.toString(false))) {
			jsonObject_Map.put("IsPatientNewborn", "N");

		} else if (jsonObject_Map.get("IsPatientNewborn").equals(Boolean.toString(true))) {
			jsonObject_Map.put("IsPatientNewborn", "Y");
		} else if (jsonObject_Map.get("IsPatientNewborn").equals(null)) {
			jsonObject_Map.put("IsPatientNewborn", "N");
		}
		return jsonObject_Map;
	}

	public JSONObject subArrayCreation(JSONObject jsonObject, String subArrayname, int indexofSubArray) throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException {
		JSONArray jsonArrayAdd = (JSONArray) jsonObject.get(subArrayname);
		JSONObject jsonObjectAdd = (JSONObject) jsonArrayAdd.get(indexofSubArray);

		return jsonObjectAdd;
	}

	public JSONArray generateRandomJsonPatientV2() throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
		JSONArray jsonArray = uniqueJsonGenerator.patient_Ohio_V2(GlobalVariable_V2.Ohio_patientJson_v2);

		return jsonArray;
	}

	public Map<String, JSONObject> processOhioPatientV2(Map<String, String> jsonField) throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
		Map<String, JSONObject> retunObject = new HashMap<String, JSONObject>();

		JSONArray jsonArray = uniqueJsonGenerator.patient_Ohio_V2(GlobalVariable_V2.Ohio_patientJson_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);
		jsonObject.putAll(jsonField);

		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV2(jsonArray));

		retunObject.put("bodyAsStringGet", bodyAsStringget);
		retunObject.put("jsonObject", jsonObject);

		return retunObject;
	}

	public Map<String, JSONObject> processOhioPatientV2WithSubArray(Map<String, String> jsonField, String SubArrayField, int subArrayIndex) throws ClassNotFoundException, InterruptedException, IOException, ParseException, SQLException, java.text.ParseException {
		Map<String, JSONObject> retunObject = new HashMap<String, JSONObject>();
		JSONArray jsonArray = uniqueJsonGenerator.patient_Ohio_V2(GlobalVariable_V2.Ohio_patientJson_v2);
		JSONObject jsonObject = (JSONObject) jsonArray.get(0);

		JSONObject jsonObject_Sub = subArrayCreation(jsonObject, SubArrayField, subArrayIndex);
		jsonObject_Sub.putAll(jsonField);
		JSONParser parser = new JSONParser();

		JSONObject bodyAsStringget = (JSONObject) parser.parse(uniqueJsonGenerator.captureResponseOhioPatientV2(jsonArray));

		retunObject.put("bodyAsStringGet", bodyAsStringget);
		retunObject.put("jsonObject", jsonObject);
		retunObject.put("jsonObject_Sub", jsonObject_Sub);

		return retunObject;

	}

	public void assertFailErrorMessage(String bodyAsString, String Errormesssage) {
		logger.log(LogStatus.INFO, "Validating JSON response failed case");
		Assert.assertTrue(bodyAsString.contains(Errormesssage));
	}

	public void patientZipScenario(JSONObject jsonObjectMap_Supp, JSONObject jsonObjectMap_Address) {
		jsonObjectMap_Supp.put(GlobalVariable_V2.PatientZip, String.valueOf(jsonObjectMap_Supp.get(GlobalVariable_V2.PatientZip)).replace("-", ""));
		jsonObjectMap_Address.put(GlobalVariable_V2.PatientZip, String.valueOf(jsonObjectMap_Address.get(GlobalVariable_V2.PatientZip)).replace("-", ""));

		CommonMethods.ZipadditionfourZero(jsonObjectMap_Supp, GlobalVariable_V2.PatientZip);
		CommonMethods.ZipadditionfourZero(jsonObjectMap_Address, GlobalVariable_V2.PatientZip);

	}
}
