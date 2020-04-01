package com.ohio.intake.staff.v1;

import Utills_ExtentReport_Log4j.BaseTest;

public class GlobalVariable_staff_v1 extends BaseTest{

	public static String PostGetLog = "Generating unique json and capturing the response for Post and get request as part of DB/Failure verification";
	public static String DBVerify="Verify the comparision between Database value and JSON value";
	public static String errorVerify="Verify the error meessage for invalid";
	public static String generateFieldValue="Passing Random value in json for";
	
	public static String jsonObject = "jsonObject";
	public static String bodyAsStringGet = "bodyAsStringGet";
	public static String bodyAsStringPost = "bodyAsStringPost";
	
	public static String Ohio_StaffJson_v1 = "worker_v1";
	
	public static String staffBusinessEntityId = "BusinessEntityID";
	public static String staffBusinessEntityMedicaidIdentifier = "BusinessEntityMedicaidIdentifier";
	public static String staffEmail ="StaffEmail";
	public static String staffFName ="StaffFirstName";
	public static String staffLName ="StaffLastName";
	public static String staffSSN ="StaffSSN";
	public static String staffId ="StaffID";
	public static String staffOtherId ="StaffOtherID";
	public static String staffPosition ="StaffPosition";
	public static String sequenceId="SequenceID";

	public static String staffFirstNameLengthError= "The StaffFirstName value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static String staffFirstNameFormatError= "The StaffFirstName format is incorrect.";
	public static String staffFirstNameNull= "The StaffFirstName cannot be null.";
	
	public static String staffLastNameLengthError= "The StaffLastName value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static String staffLastNameFormatError= "The StaffLastName format is incorrect.";
	public static String staffLastNameNull= "The StaffLastName cannot be null.";
	
	public static String staffIdLengthError="The StaffID value will be truncated to 9 characters. The length should be between 1 and 9.";
	public static String staffIdFormatError="The StaffID format is incorrect.";
	public static String staffIdNull="The StaffID is null. It will be inserted as null.";
	
	public static String staffPositionFormatError = "The StaffPosition must be one of the acceptable values specified. The value is being inserted into the database as null.";
	public static String staffPositionlengthError = "The StaffPosition must be one of the acceptable values specified. The value is being inserted into the database as null. The staff position must be one of these words";
	public static String staffOtherIdFormatError="The StaffOtherID format is incorrect.";
	public static String staffOtherIdLengthError="The StaffOtherID value is greater than 64 characters. The length should be between 1 and 64.";
	public static String staffOtherIdNull="The StaffOtherID cannot be null.";
	
	public static String staffSSNLengthError="The StaffSSN value is incorrect.  It must be 9 digits.";
	public static String staffSSNFormatError="Staff SSN format is incorrect.";
	public static String staffSSNNull="The StaffSSN cannot be null.";
	
	public static String staffEmailLengthError= "The StaffEmail value will be truncated to 64 characters. The length should be between 1 and 64.";
	public static String staffEmailFormatError="The StaffEmail format is incorrect.";
	
	public static String sequenceIDDuplicateMessage = "Version number is duplicate or older than the current version";
	public static String sequenceIDNull = "The SequenceID  cannot be null.";
	public static String sequenceIDLengthError ="The SequenceID value exceeds the maximum length of 16 characters. The record is being rejected.";
	public static String sequenceIDFormatError ="The SequenceID format is incorrect.";
	public static String incrementalSequenceIdMessageProcessedbefore = "passing unique json with same sequence id that has been processed before";
	public static String sequenceIDDuplicateError="Version Number is older or duplicate.";
	
	public static String staffBusinessEntityIdBlankError = "The account ID (BusinessEntityID) for some of input records is invalid.";
	public static String staffBusinessEntityMedicaidIdentifierBlankError = "The BusinessEntityMedicaidID does not match with provider ID.";
	
	public static String requiredFieldsMissingError = "Internal Server Error";

}
