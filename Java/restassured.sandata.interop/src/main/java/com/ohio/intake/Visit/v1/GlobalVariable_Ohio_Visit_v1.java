package com.ohio.intake.Visit.v1;

import Utills_ExtentReport_Log4j.BaseTest;

public class GlobalVariable_Ohio_Visit_v1 extends BaseTest

{

	public static String AdjInDateTime = "AdjInDateTime";
	public static String AdjOutDateTime = "AdjOutDateTime";
	public static String ProcedureCode = "ProcedureCode";
	public static String  PostGetLog = "Generating unique json and capturing the response for Post and get request as part of DB/Failure verification";
	public static String  DBVerify="Verify the comparision between Database value and JSON value";
	public static String  errorVerify="Verify the error meessage for invalid";
	public static String generateFieldValue="Passing Random value in json for";
	public static String jsonObject = "jsonObject";
	public static String bodyAsStrinqgGet="bodyAsStringGet";
	public static String bodyAsStringPost="bodyAsStringPost";

	public static String PayerProgram="PayerProgram";
	public static String callTypejson = "CallType";
	public static String Payer="Payer";
	public static String PayerID="PayerID";
	public static String  payerProgramFormatError="The PayerProgram format is incorrect. It should be between 1 and 64 characters and must be one of the valid values.";
	public static String callsjson ="Calls";
	public static String Ohio_visitJson_v1 ="visits_v1";
	public static String PatientZip = "PatientZip";
	public static String jsonObject_callIn = "jsonObject_callIn";
	public static String jsonObject_callOut = "jsonObject_callOut";
	public static String PayerID_null_error="ERROR: The PayerID cannot be null. The record is being rejected.";
	public static String PayerID_nullString_Error="ERROR: The value for Ohio payer is \u0027ODM\u0027 only.";
}
