package com.ohio.intake.VisitV2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.globalMethods.core.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import Utills_ExtentReport_Log4j.BaseTest;

public class UniqueJsonGenerator_Patient_Staff extends BaseTest{
	
	DataBaseVerifier dataBaseVerifier=new DataBaseVerifier();
	Constant_SQL Constant_SQL=new Constant_SQL();
	
	
	@SuppressWarnings("unchecked")
	public JSONArray patient_Ohio(String jsonnameclient) throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {

		JSONArray j= CommonMethods.LoadJSON_Ohio(jsonnameclient);
		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

		System.out.println(DbMap.get("PROVIDER_ID"));
		System.out.println(DbMap.get("ACCOUNT"));

		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");

		JSONObject js = (JSONObject) j.get(0);

		js.put("BusinessEntityID", BusinessEntityID);
		js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);
		js.put("PatientOtherID", CommonMethods.generateRandomNumberOfFixLength(10));
		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(9));
		js.put("PatientMedicaidID", CommonMethods.generateRandomNumberOfFixLength(12)); 
		js.put("PatientLastName", CommonMethods.generateRandomStringOfFixLength(10));
		js.put("PatientFirstName",  CommonMethods.generateRandomStringOfFixLength(10));

		JSONArray jsAdd = (JSONArray) js.get("Address");
		JSONObject jsObj = (JSONObject) jsAdd.get(0);
		jsObj.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));

		JSONObject jsObj1 = (JSONObject) jsAdd.get(1);
		jsObj1.put("PatientAddressLine1", CommonMethods.generateRandomStringOfFixLength(9));
		jsObj1.put("PatientZip", CommonMethods.generateRandomNumberOfFixLength(9));


		JSONArray jsonarrayclientcontact = (JSONArray) js.get("ResponsibleParty");
		JSONObject jsonObjectClientContact = (JSONObject) jsonarrayclientcontact.get(0);
		jsonObjectClientContact.put("PatientResponsiblePartyLastName", CommonMethods.generateRandomStringOfFixLength(9));
		jsonObjectClientContact.put("PatientResponsiblePartyFirstName", CommonMethods.generateRandomStringOfFixLength(9));


		return j;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray Staff_Params_3p_v2(String jsonnameemp) throws InterruptedException, java.text.ParseException,  FileNotFoundException, IOException, ParseException, SQLException, ClassNotFoundException {

		JSONArray j=CommonMethods.LoadJSON_Ohio(jsonnameemp);

		Map<String,String> DbMap=new HashMap<String, String>();

		DbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccount,CommonMethods.propertyfileReader(globalVariables.ohio_accid)));

		System.out.println(DbMap.get("PROVIDER_ID"));
		System.out.println(DbMap.get("ACCOUNT"));

		String BusinessEntityMedicaidIdentifier= DbMap.get("PROVIDER_ID");
		String BusinessEntityID= DbMap.get("ACCOUNT");
		JSONObject js = (JSONObject) j.get(0);

		js.put("BusinessEntityID", BusinessEntityID);
		js.put("BusinessEntityMedicaidIdentifier", BusinessEntityMedicaidIdentifier);

		js.put("StaffOtherID", DataGeneratorEmployee.generateEmpPIN(9));

		js.put("SequenceID", CommonMethods.generateRandomNumberOfFixLength(10));

		js.put("StaffID", CommonMethods.generateRandomNumberOfFixLength(9));

		js.put("StaffSSN", CommonMethods.generateRandomNumberOfFixLength(9));

		js.put("StaffLastName", CommonMethods.generateRandomStringOfFixLength(5));

		js.put("StaffFirstName", CommonMethods.generateRandomStringOfFixLength(5));

		js.put("StaffEmail", DataGeneratorEmployee.generateEmpEmail(10));

		js.put("StaffPosition", DataGeneratorEmployee.generateStaffPosition());

		return j;

	}

}
