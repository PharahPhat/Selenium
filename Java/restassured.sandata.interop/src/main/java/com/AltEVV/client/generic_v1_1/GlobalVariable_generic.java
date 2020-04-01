package com.AltEVV.client.generic_v1_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class GlobalVariable_generic extends BaseTest{

	
	public static String  PostGetLog = "Generating unique json and capturing the response for Post and get request as part of DB/Failure verification";
	public static String  DBVerify="Verify the comparision between Database value and JSON value";
	public static String  errorVerify="Verify the error meessage for invalid";
	
	public static String generateFieldValue="Passing Random value in json for";
	public static String jsonObject = "jsonObject";
	public static String bodyAsStrinqagGet="bodyAsStringget";
	public static String bodyAsStrinq="bodyAsString";
	public static String PatientZip="PatientZip";

	
	// Json Variable names
	
	public static String client_intakeJson_generic = "client_intake";
	public static String ClientMedicaidID= "ClientMedicaidID";
	public static String IsPatientNewborn = "IsPatientNewborn";
	public static String MissingMedicaidID = "MissingMedicaidID";
	public static String PatientAlternateID = "PatientAlternateID";
	public static String IsPatientNewBornError_validation= "PatientMedID_IsPatientNewbornvalidation";
	
	
	// Error messages for Json fields
	
	public static String LengthErrorClientMedicaidID= "The ClientMedicaidID value is incorrect.";
	public static String formatErrorMessageClientMedicaidID= "The ClientMedicaidID format is incorrect.";
	public static String IsPatient_Otherthan_truefalse= "Client not found";
	public static String formatErrorMessageMissingMedicaidID ="The MissingMedicaidID format is incorrect.";

}
