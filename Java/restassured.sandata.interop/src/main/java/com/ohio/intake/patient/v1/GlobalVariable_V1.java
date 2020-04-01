package com.ohio.intake.patient.v1;

import Utills_ExtentReport_Log4j.BaseTest;

public class GlobalVariable_V1 extends BaseTest{

	public static String PatientAddressSegment_RequiredFieldsMissing_68887 = "V8_TC_68887_Interface_Ohio_Patient_Validations_PatientAddressSegment_RequiredFieldsMissing";
	public static String  PostGetLog = "Generating unique json and capturing the response for Post and get request as part of DB/Failure verification";
	public static String  DBVerify="Verify the comparision between Database value and JSON value";
	public static String  errorVerify="Verify the error meessage for invalid";

	public static String generateFieldValue="Passing Random value in json for";
	public static String jsonObject = "jsonObject";
	public static String bodyAsStrinqagGet="bodyAsStringGet";
	public static String bodyAsStringPost="bodyAsStringPost";
	public static final String MessageSummaryRejected = "Records rejected, please review error and try again";

	public static String PatientPhoneNumber_positveCase_64929= "Auto_V8_TC_64929_OhioPatient_PatientPhoneNumberfield_Positve10Char";
	public static String PatientPhoneNumber_invalidGreaterCase_64929= "Auto_V8_TC_64929_OhioPatient_PatientPhoneNumberfield_Invalidgreater10Char";
	public static String PatientPhoneNumber_invalidLessCase_64929= "Auto_V8_TC_64929_OhioPatient_PatientPhoneNumberfield_InvalidLess10Char";
	public static String PatientPhoneNumber_invalidAlphanum_64929= "Auto_V8_TC_64929_OhioPatient_PatientPhoneNumberfield_InvalidAlphaNum";
	public static String formatErrorMessagePatientPhoneNumber= "The PatientPhoneNumber format is incorrect. It must be provided as 10 digits.";

	public static String PatientZip_positveCase_64932= "Auto_V8_TC_64932_Ohio_Patient_Validations_PatientZipfieldformats_valid9";
	public static String PatientZip_positveCaseSpace_64932 = "Auto_V8_TC_64932_Ohio_Patient_Validations_PatientZipfieldformats_valid10Space";
	public static String PatientZip_negativeCase_64932= "Auto_V8_TC_64932_Ohio_Patient_Validations_PatientZipfieldformats_invalid";
	public static String PatientZip_negativeCaseNum4_64932= "Auto_V8_TC_64932_Ohio_Patient_Validations_PatientZipfieldformats_invalidNum4";
	public static String PatientZip_negativeCaseAlphaNum8_64932= "Auto_V8_TC_64932_Ohio_Patient_Validations_PatientZipfieldformats_invalidAlphaNum8";
	public static String PatientZip_negativeCaseAlphaNum10_64932= "Auto_V8_TC_64932_Ohio_Patient_Validations_PatientZipfieldformats_invalidAlphaNum10";
	public static String formatErrorMessagePatientZip= "The PatientZip format is incorrect. It should be between 5 or 9 digits or in the format #####-####.";

	public static String PatientAddressType_positveCaseBusiness_64149="Auto_V8_TC_64149_Ohio_Patient_Validations__PatientAddressType_valid_Business";
	public static String PatientAddressType_positveCaseHome_64149="Auto_V8_TC_64149_Ohio_Patient_Validations__PatientAddressType_valid_Home";
	public static String PatientAddressType_positveCaseSchool_64149="Auto_V8_TC_64149_Ohio_Patient_Validations__PatientAddressType_valid_School";
	public static String PatientAddressType_positveCaseOther_64149="Auto_V8_TC_64149_Ohio_Patient_Validations__PatientAddressType_valid_Other";

	public static String PatientState_positveCase_69105="Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_valid";
	public static String PatientState_InvalidOtherThanCode_69105="Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_invalidotherthanCode";
	public static String PatientState_InvalidOtherThanCodeNum_69105="Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_invalidotherthanCodeNum";
	public static String PatientState_InvalidOtherThanCodeAlphaNum_69105="Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_invalidotherthanCodeAlphaNum";
	public static String PatientState_InvalidOtherThanCodeDot_69105="Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_invalidotherthanCodeDot";
	public static String PatientState_InvalidOtherThanCodeLessthan_69105="Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_invalidotherthanCodeLessthan";
	public static String PatientState_InvalidOtherThanCodeGreaterthan_69105="Auto_V8_TC_69105_Ohio_Patient_Validations_PatientStateFormat_invalidotherthanCodeGreaterthan";
	public static String formatErrorMessagePatientState="The record is being rejected.";
	public static String formatErrorMessagePatientAdd="At least one valid address is required. The record is being rejected.";

	public static String SchemaSTX_FullyPopulated_68777 = "Auto_V8_TC_68777_Interface_Ohio_PatientFieldMapping_SchemaSTX_FullyPopulated_Valid";

	public static String PatientState_positveCase_64296 = "Auto_V8_TC_64296_Interface_Ohio_Patient_Load_PositiveResponse_Valid";

	public static String PatientTimeZone_positveCase_64923 = "Auto_V8_TC_64923_Interface_Ohio_Patient_Validations_Patient_TimeZone_Valid";

	public static  String Staticlists_InvalidValues_Case1_6468 = "Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case1";
	public static  String Staticlists_InvalidValues_Case2_6468 = "Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case2";
	public static  String Staticlists_InvalidValues_Case3_6468 = "Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case3";
	public static  String Staticlists_InvalidValues_Case4_6468 = "Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case4";
	public static  String Staticlists_InvalidValues_Case5_6468 = "Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case5";
	public static  String Staticlists_InvalidValues_Case6_6468 = "Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case6";
	public static  String Staticlists_InvalidValues_Case7_6468 = "Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case7";
	public static  String Staticlists_InvalidValues_Case8_6468 = "Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case8";
	public static  String Staticlists_InvalidValues_Case9_6468 = "Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case9";
	public static  String Staticlists_InvalidValues_Case10_6468 = "Auto_V8_TC_64683_Interface_Ohio_Patient_Validations_Neg_Staticlists_InvalidValues_Case10";

	public static String Staticlists_PatientPhoneType_Valid_Home_64412="Auto_V8_TC_64412_Interface_Ohio_Patient_Validations_PatientPhoneType_Valid_Home";
	public static String Staticlists_PatientPhoneType_Valid_Mobile_64412="Auto_V8_TC_64412_Interface_Ohio_Patient_Validations_PatientPhoneType_Valid_Mobile";
	public static String Staticlists_PatientPhoneType_Valid_Fax_64412="Auto_V8_TC_64412_Interface_Ohio_Patient_Validations_PatientPhoneType_Valid_Fax";
	public static String Staticlists_PatientPhoneType_Valid_Other_64412="Auto_V8_TC_64412_Interface_Ohio_Patient_Validations_PatientPhoneType_Valid_Other";
	public static String Staticlists_PatientPhoneType_Valid_Work_64412="Auto_V8_TC_64412_Interface_Ohio_Patient_Validations_PatientPhoneType_Valid_Work";

	public static String nullErrorMessagePatientPhoneType="The PatientPhoneType cannot be null.";
	public static String nullErrorMessagePatientPhoneNumber="The PatientPhoneNumber cannot be null.";
	public static  String BusinessEntityIDNullError="The account ID (BusinessEntityID) for some of input records is invalid. Please check and try again.";
	public static  String BusinessEntityMedicaidIDNullError="The BusinessEntityMedicaidID does not match with provider ID. Please check and try again.";
	public static  String PatientOtherIDNullError="The PatientOtherID is null. The record is being rejected.";
	public static  String SequenceIDNullError="The SequenceID  cannot be null. The record is being rejected.";
	public static  String PatientMedicaidIDNullError="The PatientMedicaidID  cannot be null. The record is being rejected.";
    public static String PatientLastNameNullError = "The PatientLastName cannot be null.";
    public static String PatientFirstNameNullError = "The PatientFirstName cannot be null.";
    public static String PatientResponsiblePartyFirstNameNullError = "The PatientResponsiblePartyFirstName cannot be null.";
    public static String PatientResponsiblePartyLastNameNullError = "The PatientResponsiblePartyLastName cannot be null.";
    public static String PatientAddressLine1NullError = "The PatientAddressLine1 cannot be null.";
    public static String PatientCityNullError = "The PatientCity cannot be null.";
    public static String PatientStateNullError = "The PatientState cannot be null.";
    public static String PatientZipNullError = "The PatientZip cannot be null.";

    public static String PatientMedicaidIDLengthError = "The PatientMedicaidID value exceeds the maximum length of 12 characters. The record is being rejected. The length should be between 12 and 12.";
    public static String PatientMedicaidIDLengthError_Generic = "A valid 12-digit PatientMedicaidID is required when the patient is not a new born";
    public static String PatientMedicaidIDLengthShortError = "The PatientMedicaidID format is incorrect. The record is being rejected. It should be 12 digits";
    public static String BusinessEntityMedicaidIdentifierLengthError = "The BusinessEntityMedicaidID does not match with provider ID. Please check and try again.";
    public static String BusinessEntityMedicaidIdentifierLengthWarning = "The BusinessEntityMedicaidID does not match with provider ID. Please check and try again.";

    public static String patientLongitudeGreaterLengthError = "The PatientLongitude value cannot be greater than 180. Value 0.0 is being substituted. Please resend corrected value.";
    public static String patientLatitudeGreaterLengthError = "The PatientLatitude value cannot be greater than 90. Value 0.0 is being substituted. Please resend corrected value.";

    public static String patientLongitudeLowerLengthError = "The PatientLongitude value cannot be less than -180. Value 0.0 is being substituted. Please resend corrected value.";
    public static String patientLatitudeLowerLengthError = "The PatientLatitude value cannot be less than -90. Value 0.0 is being substituted. Please resend corrected value.";

	public static String patientFirstNameLengthError="The PatientFirstName format is incorrect.";
	public static String ValueNotMeetValidationPattern = "The value does not meet the validation pattern. The value is truncated if it exceeds max length, and the truncated value or the original value (less than minimum required length) is inserted into database.";

	public static String PatientLastNameLengthError="The PatientLastName format is incorrect.";

	public static  String sequenceIDErrorMessage = "Version number is duplicated or older than current";
	
	public static String incrementalSequenceIdMessage = "passing uninque json with same sewuence id that has not been processed before";
	public static String incrementalSequenceIdMessageProcessedbefore = "passing uninque json with same sewuence id that has been processed before";

	public static String PatientLongitude="PatientLongitude";
	public static String PatientLatitude="PatientLatitude";
	
	public static String Ohio_patientJson_v1 = "patient_v1";
	public static String PatientFirstName="PatientFirstName";
	public static String PatientLastName="PatientLastName";
	public static String PatientPhoneNumber="PatientPhoneNumber";
	public static String PatientZip="PatientZip";
	public static String PatientAddressType="PatientAddressType";
	public static String PatientAddressIsPrimary="PatientAddressIsPrimary";
	public static String PatientState = "PatientState";
	public static String PatientTimezone = "PatientTimezone";
	public static String PatientPhoneType = "PatientPhoneType";
	public static String BusinessEntityMedicaidIdentifier="BusinessEntityMedicaidIdentifier";
	public static String PatientMedicaidID = "PatientMedicaidID";


	public static String Address="Address";
	public static String Phones = "Phones";
	public static String Business="Business";
	public static String Home = "Home";
	public static String School = "School";
	public static String Other = "Other";
	public static String OTHER = "OTHER";
	public static String BUSINESS="BUSINESS";
	public static String HOME = "HOME";
	public static String SCHOOL = "SCHOOL";
	public static String Fax="Fax";
	public static String Mobile="Mobile";
	public static String Work = "Work";
	public static String FAX="FAX";
	public static String MOBILE="MOBILE";
	public static String WORK = "WORK";

	public static String NY = "NY";
	public static  String Eastern = "US/Eastern";
	
	
	//Get RequiredFiled Error Message

	

}
