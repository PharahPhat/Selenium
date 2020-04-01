package com.ohio.intake.patient.v2;

import Utills_ExtentReport_Log4j.BaseTest;

public class GlobalVariable_V2 extends BaseTest{

	
	public static String  PostGetLog = "Generating unique json and capturing the response for Post and get request as part of DB/Failure verification";
	public static String  DBVerify="Verify the comparision between Database value and JSON value";
	public static String  errorVerify="Verify the error meessage for invalid";
	public static String GeneratingUniquePatientv2="Generating Unique patient Ohio v2 json";
	public static String generateFieldValue= "Passing Random value in json for";
	public static String jsonObject = "jsonObject";
	public static String bodyAsStrinqagGet="bodyAsStringGet";
	public static String PatientZip="PatientZip";
	public static String PayerProgram= "PayerProgram";
	public static String ProcedureCode= "ProcedureCode";
	public static String PayerClientIdentifier="PayerClientIdentifier";
	public static String Payer="Payer";
	public static String IndividualPayerInformation="IndividualPayerInformation";

	
	// Json Variable names
	
	public static String ohio_visit_v2= "ohio_visit_v2";
	public static String ohio_visit_get_v2 = "ohio_visit_get_v2";
	public static String ohio_patient_get_v2= "ohio_patient_get_v2";
	public static String Ohio_patientJson_v2 = "patientIntake_v2";
	public static String PatientOtherID= "PatientOtherID";
	public static String IsPatientNewborn = "IsPatientNewborn";
	public static String PatientMedicaidID = "PatientMedicaidID";
	public static String PatientAlternateID = "PatientAlternateID";
	public static String payerjson = "Payer";
	public static String payerClientIdentifierjson = "PayerClientIdentifier";
	public static String individualPayerInformationjson = "IndividualPayerInformation";
	public static String IsPatientNewBornError_validation= "PatientMedID_IsPatientNewbornvalidation";
	
	
	// Error messages for Json fields
	
	public static String LengthErrorMessagePatientOtherID= "The PatientOtherID value exceeds the maximum length of 64 characters. The record is being rejected. The length should be between 1 and 64.";
	public static String formatErrorMessagePatientOtherID= "The PatientOtherID format is incorrect. It should be between 1 and 64 characters. The record is being rejected.";
	public static String NullErrorMessagePatientOtherID= "The PatientOtherID is null. The record is being rejected.";
	public static String NullErrorMessagePatientMedicaidID = "ERROR: A valid 12-digit PatientMedicaidID is required when the patient is not a new born or If the individual is being provided services by ODA only, the ClientMedicaidID can be optional and the 7-digit PIMS ID must be provided in the PayerClientIdentifier field.";

	public static String IsPatient_Otherthan_truefalse= "Client not found";
	public static String WarningPatientMedIDNull= "WARNING: The value does not meet the validation pattern. The value is truncated if it exceeds max length, and the truncated value or the original value (less than minimum required length) is inserted into database.";
	public static String payerClientIdentifierError ="PayerClientIdentifier is invalid.";

}
