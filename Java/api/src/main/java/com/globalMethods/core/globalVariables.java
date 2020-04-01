package com.globalMethods.core;

import java.io.File;

public class globalVariables {

	//################################# Client Table Config File  #######################################

	public static final String ClientSuffix = "ClientSuffix";
	public static final String RecipientIDCustom2 = "RecipientIDCustom2";
	public static final String RecipientIDCustom1 = "RecipientIDCustom1";
	public static final String PatientZip="PatientZip";
	public static final String Address="Address";

	//-------------------config properties-------------------------------
	public static final String altevv_clients="altevv_clients";
	public static final String altevv_emp="altevv_emp";
	public static final String altevv_provider = "altevv_provider";
	public static final String altevv_molina_provider = "altevv_molina_provider";
	public static final String openevv_client_url="clients";
	public static final String openevv_client_get="Client_get";
	public static final String openevv_xref_url="Xref";
	public static final String openevv_xref_get="Xref_get";
	public static final String openevv_xref_json="xref";
	public static final String visit_intake="visit_intake";
	public static final String member_post_url= "openevv_member";
	public static final String member_get_url= "openevv_member_get";
	public static final String openevv_schedule = "openevv_schedule";
	public static final String openevv_schedule_get = "openevv_schedule_get";
	public static final String openEVV_auth = "openEVV_auth";
	public static final String openEVV_auth_get = "openEVV_auth_get";
	public static final String provider_post_url= "openevv_provider";
	public static final String provider_get_url= "openevv_provider_Get";
	public static final String openevv_emp_url= "create_employee";
	public static final String ohio_visit_v2= "ohio_visit_v2";
	public static final String ohio_visit_get_v2 = "ohio_visit_get_v2";
	public static final String ohio_patient_v2= "ohio_patient_v2";
	public static final String ohio_patient_get_v2= "ohio_patient_get_v2";
	public static final String ohio_patient_v1 = "ohio_patient_v1";
	public static final String ohio_patient_get_v1 = "ohio_patient_get_v1";
	public static final String ohio_staff_v1="ohio_staff_v1";
	public static final String ohio_staff_get_v1="ohio_staff_get_v1";
	public static final String ohio_visit_v1="ohio_visit_v1";
	public static final String ohio_visit_get_v1="ohio_visit_get_v1";
	public static final String altevv_Molina_emp = "altevv_Molina_emp";
	public static final String altevv_Molina_emp_get = "altevv_Molina_emp_get";
	public static final String altevv_Molina_visit = "altevv_Molina_visit";
	public static final String altevv_Molina_visit_get = "altevv_Molina_visit_get";

	public static final String visit="visit";
	public static final String EmployeeIdentifier= "EmployeeIdentifier";
	public static final String EmployeeBirthDate="EmployeeBirthDate";
	public static final String ClientBirthDate="ClientBirthDate";

	public static final String ExceptionIDjson="ExceptionID";
	public static final String ExpID="ExpID";
	public static final String EmpAPI = "EmployeeAPI";



	public static final String ClientMedicaidID = "ClientMedicaidID";
	public static final String ClientIDQualifier= "ClientIDQualifier";
	public static final String PayerIDValue= "MEDHHS";



	//------------------JSON File name Reading----------
	public static final String client_intake_Molina="client_intake_Molina";
	public static final String Staff_intake_Molina="Staff_intake_Molina";
	public static final String visit_intake_Molina="visit_intake_Molina";


	public static final String client_intake="client_intake";
	public static final String clientDesignee_intake = "clientDesignee_intake";
	public static final String client_openevv="client";
	public static final String client_intake_req_blank = "client_intake_req_fields_blank";
	public static final String client_intake_req_missing = "client_intake_req_fields_missing";
	public static final String Staff_intake="Staff_intake";
	public static final String openevv_member_json="Member";
	public static final String openevv_provider_json="Provider";
	public static final String PA_provider_json="PAprovider";
	public static final String visitjson= "visit_intake";
	public static final String openevv_emp_json= "employee";
	public static final String client_3p_json="client_3p";
	public static final String worker_3P_json="worker";
	public static final String xref_json="xref";
	public static final String openevv_emp_req_json= "employee_RequiredField";
	public static final String worker_v1_json= "worker_v1";
	public static final String visits_v1= "visits_v1";
	public static final String indiana_Etl = "ETL_Config_QA";


	// -------------------JSON Object name identification ----------------------------------------
	public static final String ClientDesignee ="ClientDesignees";
	public static final String clientDesigneeEmail ="ClientDesigneeEmail";
	public static final String clientEmailAddress ="ClientEmailAddress";
	public static final String ClientTimezone="ClientTimezone";
	public static final String ProcedureCode="ProcedureCode";
	public static final String procedurecodeValue ="S5125";
	public static final String MemberVerifiedService="MemberVerifiedService";
	public static final String AdjInDateTime="AdjInDateTime";
	public static final String AdjOutDateTime="AdjOutDateTime";
	public static final String ChangeDateTime="ChangeDateTime";
	public static final String Action="Action";
	public static final String ClientTimeZone="ClientTimeZone";
	public static final String ClientPhone="ClientPhone";
	public static final String ClientSecondaryDiagnosisCode="ClientSecondaryDiagnosisCode";
	public static final String ClientPrimaryDiagnosisCode="ClientPrimaryDiagnosisCode";
	public static final String diagnosis_code="diagnosis_code";
	public static final String description="description";
	public static final String ClientFirstName="ClientFirstName";
	public static final String visitDateOutOfRange_Error="ERROR: Visit Date out of range";
	public static final String getError="[4] Records uploaded failed, please check errors/warning and try again.";

	public static final String ClientState = "ClientState";
	public static final String callEnddatePast="The call date and time must be in the past. The record is being rejected.";
	public static final String Client_Payer_Information1="Client_Payer_Information";
	public static final String ClientEligibilityDateBegin1="ClientEligibilityDateBegin";
	public static final String ClientEligibilityDateEnd="END_TIME";
	public static final String EffectiveStartDate="EffectiveStartDate";
	public static final String EffectiveEndDate="EffectiveEndDate";
	public static final String ClientStatus1="ClientStatus";
	public static final String ClientOtherID="ClientOtherID";
	public static final String EmployeeQualifier="EmployeeQualifier";
	public static final String EmployeeOtherID="EmployeeOtherID";
	public static final String VisitOtherID="VisitOtherID";
	public static final String DBVerify="DBVerify";
	//ClientResponsibleparty subsection
	public static final String ClientResponsibleParty = "ClientResponsibleParty";
	public static final String ClientContactType = "ClientContactType";
	public static final String ClientContactPhone = "ClientContactPhone";
	public static final String ClientContactPhoneType = "ClientContactPhoneType";
	public static final String ClientContactState = "ClientContactState";
	public static final String clientContactFirstName = "ClientContactFirstName";
	public static final String clientContactLastName = "ClientContactLastName";
	public static final String ClientContactZip = "ClientContactZip";
	public static final String ClientIdentifier = "ClientIdentifier";
	public static final String AuthorizationEndDate = "AuthorizationEndDate";
	public static final String AuthorizationStartDate = "AuthorizationStartDate";
	public static final String ClientDiagnosisCodeBeginDate = "ClientDiagnosisCodeBeginDate";
	public static final String ClientDiagnosisCodeEndDate = "ClientDiagnosisCodeEndDate";
	public static final String DiagnosisCode = "DiagnosisCode";


	public static final String AddressZip = "AddressZip";
	public static final String AddressState = "AddressState";
	public static final String AddressCity = "AddressCity";
	public static final String AddressLine2 = "AddressLine2";
	public static final String providerCounty = "providerCounty";
	public static final String County = "County";

	//Claim JSON object name identification
	public static final String payerjson ="Payer";
	public static final String matchingRulejson ="MatchingRule";

	//Claim JSON error message identification
	public static final String PayerLengthError ="Payer ID has incorrect size. Payer ID length";

	//Provider identification
	public static final String ProviderQualifier = "ProviderQualifier";
	public static final String AgencyEmail="AgencyEmail";
	public static final String AgencyPhone="AgencyPhone";
	public static final String PrimaryContactLastName="PrimaryContactLastName";
	public static final String ProviderIdentification = "ProviderIdentification";
	public static final String ClientEligibilityDateBegin="ClientEligibilityDateBegin";
	public static final String ClientStatus="ClientStatus";
	public static final String addressArrayjson ="ClientAddress";
	public static final String Addressjson= "Address";
	public static final String ClientAddressType="ClientAddressType";
	public static final String ClientCounty="ClientCounty";
	public static final String ClientAddressLongitude ="ClientAddressLongitude";
	public static final String ClientAddressLatitude ="ClientAddressLatitude";

	public static final String ProviderRequireAuth="ProviderRequireAuth";
	public static final String jsonProcedureCode1   ="ProcedureCode";
	public static final String ProviderID   ="ProviderID";
	public static final String AddressLine1 ="AddressLine1";

	public static final String ClientContactCity ="ClientContactCity";
	public static final String ClientContact ="ClientContact";


	public static final String Account="Account";
	public static final String ClientDesignees = "ClientDesignees";
	public static final String ClientDesigneeFirstName="ClientDesigneeFirstName";
	public static final String ClientDesigneeLastName="ClientDesigneeLastName";
	public static final String ClientDesigneeStartDate="ClientDesigneeStartDate";
	public static final String authorizationStartDate ="authorizationStartDate";
	public static final String authorizationEndDate ="authorizationEndDate";
	public static final String ClientDesigneeEndDate="ClientDesigneeEndDate";
	public static final String ClientID="ClientID";
	public static final String XRefStartDate="XRefStartDate";
	public static final String XRefEndDate="XRefEndDate";
	public static final String account_status="account_status";
	public static final String ClientSSN="ClientSSN";
	public static final String clientSSN="ClientSSN";
	public static final String PayerID="PayerID";
	public static final String Payer="Payer";
	public static final String Client_Payer_Information="ClientPayerInformation";
	public static final String IndividualPayerInformation = "IndividualPayerInformation";
	public static final String PayerProgram="PayerProgram";
	public static final String PayerService="PayerService";
	public static final String AuthorizationServiceID="AuthorizationServiceID";
	public static final String AuthorizationLimit="AuthorizationLimit";
	public static final String ClientEligibility = "ClientEligibility";
	public static final String ClientZip="ClientZip";
	public static final String addressType="ClientAddressType";
	public static final String PayRate="PayRate";
	public static final String Arnumber="ARNumber";
	public static final String ClientPhoneType="ClientPhoneType";
	public static final String DesigneeEmail="ClientDesigneeEmail";
	public static final String dischargeDate ="DischargeDate";
	public static final String jsonStatus ="Status";
	public static final String ContactAddressLine1 ="ContactAddressLine1";
	public static final String ContactCity="ContactCity";
	public static final String ClientQualifier="ClientQualifier";
	public static final String clientQualifierAuth ="clientQualifier";
	public static final String dbClientAddressType="addr_type_qlfr";
	public static final String ClientAddressLine1="ClientAddressLine1";
	public static final String ClientCity="ClientCity";
	public static final String ClientAddressLine2 = "ClientAddressLine2";
	public static final String ClientAddressLine2_MaxLength_Error = "The ClientAddressLine2 value is incorrect. The length should be between 1 and 30.";
	public static final String ClientLastName="ClientLastName";
	public static final String EmpFName = "EmployeeFirstName";
	public static final String EmpLName = "EmployeeLastName";
	public static final String EmpSSN = "EmployeeSSN";
	public static final String EmployeePIN= "EmployeePIN";
	public static final String EmployeeHireDate="EmployeeHireDate";
	public static final String EmployeeEndDate="EmployeeEndDate";
	public static final String SuspensionDate="SuspensionDate";
	public static final String TerminationDate="TerminationDate";

	// schedule json//

	public static final String Billcode="BillCode";

	// -------------------JSON error message identification ----------------------------------------

	public static final String ClientTimezonesizeError="The ClientTimezone value is incorrect. The length should be between 1 and 64.";
	public static final String ClientTimezonenullerror="The ClientTimezone cannot be null";
	public static final String AdjInOutDateTime_Error="The AdjInDateTime cannot be greater than AdjOutDateTime.";
	public static final String EmployeePINlengtherror="The EmployeePIN value is incorrect. The length should be between 4 and 9.";
	public static final String EmployeePINNullerror="ERROR: The EmployeePIN cannot be null.";
	public static final String EmployeePINformaterror="The EmployeePIN format is incorrect.";
	public static final String aDjtimeformaterror="The AdjOutDateTime cannot be less than the Call In. The record is being rejected.";
	public static final String EmployeePINnullerror="The EmployeePIN cannot be null.";
	public static final String EmployeeHireDateformaterror="The EmployeeHireDate expected format is not correct.";
	public static final String AdjInOutDateTime_format="ERROR: The AdjOutDateTime cannot be less than the Call In. The record is being rejected.";
	public static final String MobileLoginFormatError = "The MobileLogin value is incorrect";
	public static final String XRefStartDateformaterror= "The XRefStartDate format is incorrect.";
	public static final String XRefStartDateGreaterThanXrefEndDate= "The XRefStartDate cannot be greater than XRefEndDate";
	public static final String ClientContactFirstName_error="The ClientContactFirstName length is invalid. The length should be between 0 and 30.";
	public static final String ClientCity_error="The ClientCity value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static final String ClientCity_nullerror="The ClientCity cannot be null.";
	public static final String ClientCityLengthError="The ClientCity value is incorrect. The length should be between 1 and 30.";
	public static final String ClientCityformatError="";
	public static final String ContactZipLengthError="";
	public static final String ClientAreaLengthError = "The Area length is invalid";
	public static final String ClientAreaFormatError = "The Area format is incorrect";
	public static final String ClientCityRegularExpressionError = "The ClientCity format is incorrect.";
	public static final String WeekendErrorformat= "The Weekend format is incorrect.";
	public static final String ClientDesigneeStartDateformaterror="The ClientDesigneeStartDate format is incorrect.";
	public static final String ClientZipnullError="The ClientZip cannot be null.";
	public static final String ContactZipformatError="The ContactZip format is incorrect.";
	public static final String ClientZipformatError="The ClientZip format is incorrect.";
	public static final String ClientZiplengthError="The ClientZip length is invalid. The length should be between 1 and 10.";
	public static final String ClientContactPhoneTypeformat="The ClientContactPhoneType format is incorrect.";
	public static final String ClientContactPhoneTypelength="The ClientContactPhoneType length is invalid. The length should be between 0 and 12.";
	public static final String ClientPhoneTypenullerror="";
	public static final String PatientPhoneNumberformaterror="The PatientPhoneNumber format is incorrect.";
	public static final String PatientPhoneNumbernullerror="The PatientPhoneNumber cannot be null.";
	public static final String PatientResponsiblePartyFirstNamelengtherror="The PatientResponsiblePartyFirstName value will be truncated to 30 characters.";
	public static final String PatientResponsiblePartyFirstNamenullerror="The PatientResponsiblePartyFirstName cannot be null.";
	public static final String PatientResponsiblePartyLastNamelengtherror="The PatientResponsiblePartyLastName value will be truncated to 30 characters.";
	public static final String PatientResponsiblePartyLastNamenullerror="The PatientResponsiblePartyLastName cannot be null.";
	public static final String EmployeePINQualifiererror="The EmployeePINQualifier format is incorrect.";
	public static final String ClientDesigneeEndDateformaterror="The ClientDesigneeEndDate format is incorrect.";
	public static final String ClientCity_error_message="The ClientCity format is incorrect.";
	public static final String ClientCity_error_size="The ClientCity value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static final String ClientContactFirstNamelength="The ClientContactFirstName length is invalid. The length should be between 0 and 30.";
	public static final String longitudeMinError11            ="The ClientAddressLongitude value cannot be less than -180.";
	public static final String longitudeMaxError11            ="The ClientAddressLongitude value cannot be greater than 180.";
	public static final String longitudeMaxErrorLength       ="The CallLongitude value cannot be greater than 180.";
	public static final String longitudeMinErrorLength       ="The CallLongitude value cannot be less than -180.";
	public static final String longitudeNull11            ="The ClientAddressLongitude cannot be null.";
	public static final String longitudeNullvisit            ="The CallLongitude cannot be null. The record is being rejected.";
	public static final String ClientSecondaryDiagnosisCode_format_error="The ClientSecondaryDiagnosisCode format is incorrect.";
	public static final String ClientSecondaryDiagnosisCode_length_error="The ClientSecondaryDiagnosisCode length is invalid. The length should be between 1 and 10.";
	public static final String ClientPrimaryDiagnosisCode_format="The ClientPrimaryDiagnosisCode format is incorrect.";
	public static final String ClientPrimaryDiagnosisCode_length="The ClientPrimaryDiagnosisCode length is invalid. The length should be between 0 and 10.";
	public static final String PayerProgramError = "The PayerProgram value is incorrect. The length should be between 1 and 9.";
	public static final String latitudeMinError11            ="The ClientAddressLatitude value cannot be less than -90.";
	public static final String latitudeMaxError11            ="The ClientAddressLatitude value cannot be greater than 90.";
	public static final String latitudeNull11            ="The ClientAddressLatitude cannot be null.";
	public static final String XRefEndDateformat = "The XRefEndDate cannot be less than XRefStartDate.";
	public static final String longitudeMinError            ="The ClientAddressLongitude value cannot be less than -180.";
	public static final String longitudeMaxError            ="The ClientAddressLongitude value cannot be greater than 180.";
	public static final String longitudeNull            ="The ClientAddressLongitude cannot be null.";
	public static final String PatientPhoneTypeerror= "The PatientPhoneType is invalid.  Value must be Fax, Home, Mobile, Work or Other.";
	public static final String PatientPhoneTypenullerror="The PatientPhoneType cannot be null.";
	public static final String ClientAddressincorrect= "The ClientAddress value is incorrect.";
	public static final String latitudeMinError            ="The ClientAddressLatitude value cannot be less than -90.";
	public static final String latitudeMaxError            ="The ClientAddressLatitude value cannot be greater than 90.";
	public static final String latitudeNull            ="The ClientAddressLatitude cannot be null.";
	public static final String Payeridnullerror="The PayerID cannot be null.";
	public static final String payerprogramerror="The PayerProgram can not be null or empty.";
	public static final String payerserviceerror="The PayerService can not be null or empty.";
	public static final String payerprogramerror_altevv="The PayerProgram cannot be null nor empty.";
	public static final String  AuthorizationEndDateError ="The AuthorizationEndDate format is incorrect. The record should satisfy this format ['yyyy-MM-dd']";
	public static final String  AuthorizationStartDateError ="The AuthorizationStartDate format is incorrect. The record should satisfy this format ['yyyy-MM-dd']";
	public static final String  AuthorizationLimitTypeError="The AuthorizationLimitType format is incorrect. The record should satisfy this regular expression ['N|S|D|W|M|Y']";
	public static final String authPayerProgram ="payerProgram";

	public static final String clientContactFirstNameSizeerror    ="The ClientContactFirstName (Responsible Party) value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static final String clientContacLastNameError    ="The ClientContactLastName (Responsible Party) value is incorrect.";
	public static final String clientContacLastNameSizeError    ="The ClientContactLastName (Responsible Party) value is incorrect. The length should be between 1 and 30.";
	public static final String clientContacLastNameFormaterror="The ClientContactLastName (Responsible Party) format is incorrect. The record should satisfy this regular expression";
	public static final String clientContacFirstNameFormaterror="The ClientContactFirstName (Responsible Party) format is incorrect. The record should satisfy this regular expression";
	public static final String clientContacFirstNameMaxLengthError="The ClientContactFirstName (Responsible Party) value is incorrect. The length should be between 1 and 30.";
	public static final String clientContacFirstNameFormat= "The ClientContactFirstName format is incorrect.";
	public static final String ClientMedicaidIDformaterror= "The ClientMedicaidID format is incorrect.";
	public static final String ClientMedicaidIDLengtherror= "The ClientMedicaidID value is incorrect";
	public static final String ClientQualifierLengthError = "The ClientQualifier value is incorrect";
	public static final String ClientQualifierFormatError = "The ClientQualifier format is incorrect.";
	public static final String EmployeeQualifierFormatError = "The EmployeeQualifier format is incorrect.";
	public static final String EmployeeQualifierNullError = "The EmployeeQualifier cannot be NULL. The record is being rejected.";
	public static final String EmployeeQualifier_Error="The EmployeeQualifier cannot be NULL. The record is being rejected.";
	public static final String ClientQualifierNullError = "The ClientQualifier cannot be null nor empty.";
	public static final String ClientQualifierFormatErrorAuth="The ClientQualifier format is incorrect. The record should satisfy this regular expression ['ClientSSN|ClientOtherID|ClientCustomID']";
	public static final String ClientQualifierNullError_genreic = "The ClientQualifier cannot be null.";
	public static final String ClientQualifierNullError_Molina = "The ClientQualifier cannot be null.";

	public static final String ClientID_Error= "The ClientID cannot be null. The record is being rejected.";
	public static final String ClientIdentifier_Error="The ClientIdentifier cannot be null. The record is being rejected.";
	public static final String PayRatelengthError="The PayRate length is invalid";
	public static final String MissingMedicaidIDLengthError = "The MissingMedicaidID value is incorrect. The length should be between 1 and 5.";
	public static final String MissingMedicaidIDFormatError = "The MissingMedicaidID format is incorrect.";
	public static final String MissingMedicaidIDLengthError1 = "The MissingMedicaidID length is invalid. The length should be between 0 and 5";
	public static final String MissingMedicaidIDFormatRegularExpressionError = "The MissingMedicaidID format is incorrect. The record should satisfy this regular expression";

	public static final String ClientStatus_error_format = "The ClientStatus format is incorrect.";
	public static final String XRefClientStatuslengtherror= "The ClientStatus value is incorrect. The length should be between 2 and 2.";
	public static final String clientAddressTypeFormaterror1="The ClientAddressType format is incorrect.";
	public static final String clientAddressTypeFormat="The ClientAddressType format is incorrect.";

	public static final String ClientAddress= "ClientAddress";
	public static final String ClientLongitude ="ClientLongitude";
	public static final String ClientLatitude ="ClientLatitude";
	public static final String ClientStateNullError="The ClientState cannot be null.";
	public static final String ClientStateFormatError="The ClientState format is incorrect.";
	public static final String ClientStateFormatError_alt="The ClientContactState (Responsible Party) format is incorrect. The record should satisfy this regular expression";
	public static final String ClientStateLengthError="The ClientState length is invalid. The length should be between 2 and 2.";
	public static final String ClientStateLengthError_alt="The ClientContactState (Responsible Party) value is incorrect. The length should be between 2 and 2.";
	public static final String ClientContactStateLengthError= "The ClientContactState format is incorrect. The record should satisfy this regular expression";
	public static final String provider_ID_Error_length="The ProviderID (Client) value will be truncated to 50 characters. The length should be between 1 and 50.";
	public static final String provider_ID_Error_format="The ProviderID (Client) cannot be null.";
	public static final String ProviderIDInvalid="Request Failed With An Exception";
	public static final String provideridvalueerror="The ProviderID value is incorrect.";
	public static final String provideridformaterror="The ProviderID format is incorrect.";
	public static final String provideridformatnullerror="The ProviderID cannot be null nor empty.";
	public static final String provideridlengtherror= "The ProviderID length is invalid. The length should be between 1 and 64.";
	public static final String provideridlengtherror_QA= "The ProviderID length is invalid. The length should be between 1 and 50.";
	public static final String provideridlengtherror1= "The ProviderID value is greater than the 50 characters";
	public static final String ProviderIDNullerror="The ProviderID cannot be NULL.";
	public static final String ProviderQualifierNullerror="The ProviderQualifier cannot be NULL.";
	public static final String ClientZipFormatError1= "The ClientZip format is incorrect. The record should satisfy this regular expression";
	public static final String ClientPhoneType_Error_length="The ClientPhoneType format is incorrect.";
	public static final String ClientPhoneType_Error="The ClientPhoneType format is incorrect.";
	public static final String ClientPhoneType_Error_member="ERROR: The ClientPhone format is incorrect.";
	public static final String ClientID_Error_member="ERROR: The ClientID value is incorrect. The length should be between 0 and 10.";
	public static final String payerIdSpecialChar="ERROR: The PayerID (Eligibility OR PayerProgramService segment) format is incorrect.";
	public static final String ClientIDCunstomIDcannotBenull="ERROR: The ClientCustomId is required if ClientId is empty,";
	public static final String payerIdFormatError="The PayerID is missing in MemberEligibility OR PayerProgramService segment.";
	public static final String payerProgram_openevverror="The PayerProgram cannot be null or empty.";

	public static final String payerIdFormatError_OpenEVV="The PayerID (Eligibility segment) length is invalid. The length should be between 1 and 64.";
	public static final String providerMedicadIDError ="The ProviderMedicaidID length is invalid. The length should be between 0 and 9.";
	public static final String ProvideQualifier_generic ="Invalid Provider Qualifier";
	public static final String ProvideQualifier_null ="ProviderQualifier not Provided";


	public static final String payerIdSizeError="The PayerID value is incorrect. The length should be between 1 and 64.";
	public static final String payerProgramFormatError="The PayerProgram format is incorrect. ";
	public static final String payerProgramValueError="The PayerProgram value is incorrect. The value length must be in range 1 - 9.";
	public static final String payerProgramSizeError="The PayerProgram value is incorrect. The value length must be in range 1 - 9.";
	public static final String ClientQualifierError="The ClientIDQualifier cannot be null. The record is being rejected.";
	public static final String EmployeeIdentifier_Error="The EmployeeIdentifier cannot be null. The record is being rejected.";
	public static final String ClientIdentifierQualifier_Error="The ClientIDQualifier cannot be null. The record is being rejected.";
	public static final String ClientPhoneTypeerror="The ClientContactPhoneType format is incorrect.";
	public static final String PayRateError = "The PayRate value exceeds the maximum length of 5 characters.  The record is being rejected. The length should be between 1 and 5.";
	public static final String ClientContactCityLengthError="The ClientContactCity value is incorrect. The length should be between 1 and 30.";
	public static final String ClientContactCityFormatError= "The ClientContactCity format is incorrect.";

	public static final String ClientContactCityLengthError_alt="The ClientContactCity (Responsible Party) value is incorrect. The length should be between 1 and 30.";
	public static final String ClientContactCityFormatError_alt= "The ClientContactCity (Responsible Party) format is incorrect.";

	public static final String ClientContactCityFormatError_mem= "The ClientContactCity format is incorrect.";
	public static final String ClientEligibilityDateBeginerror= "The ClientEligibilityDateBegin format is incorrect.";

	public static final String ClientEligibilityDateBeginformaterror="The ClientEligibilityDateEnd must be after ClientEligibilityDateBegin";
	public static final String ClientEligibilityDateEnderror1= "The ClientEligibilityDateEnd format is incorrect.";
    public static final String EffectiveStartDateFormatError = "The EffectiveStartDate format is incorrect. The record should satisfy the date format ['yyyy-MM-dd'].";
    public static final String EffectiveEndDateFormatError = "The EffectiveEndDate format is incorrect. The record should satisfy the date format ['yyyy-MM-dd'].";
	public static final String EffectiveStartDateError= "The EffectiveStartDate format is incorrect.";
	public static final String EffectiveEndDateError= "The EffectiveEndDate must be after EffectiveStartDate.";
	public static final String ClientCountyLengthError = "The ClientCounty value will be truncated to 25 characters. The length should be between 1 and 25.";
	public static final String ClientCountyFormatError = "The ClientCounty format is incorrect.";
	public static final String ClientCountyLengthError1 = "The ClientCounty value is incorrect. The length should be between 1 and 25.";
	public static final String ClientCountyRegularExpressionError = "The ClientCounty format is incorrect. The record should satisfy this regular expression";
	public static final String ClientCountyLength = "The ClientCounty length is invalid. The length should be between 0 and 25.";
	public static final String ClientAddressLine2LengthError = "The ClientAddressLine2 length is invalid. The length should be between 0 and 30.";
	public static final String ClientAddressLine2FormatError = "The ClientAddressLine2 format is incorrect.";
	public static final String ClientAddressLine2RegularExpressionError = "The ClientAddressLine2 format is incorrect. The record should satisfy this regular expression";
	public static final String ContactAddressLine1LengthError   ="The ContactAddressLine1 length is invalid. The length should be between 0 and 30.";
	public static final String ContactAddressLine1FormatError ="The ContactAddressLine1 format is incorrect.";
	public static final String clientAddressTypeFormaterror="The ClientAddressType format is incorrect. The record should satisfy this regular expression";
	public static final String ClientZipFormatError= "The ClientZip format is incorrect. The record should satisfy this regular expression";
	public static final String ClientIDFormatError =	"The ClientID format is incorrect.";
	public static final String AdjOutCallInDateTime_Error="";
	public static final String EmployeeDetails_Error="The EmployeeQualifier cannot be NULL. The record is being rejected.";

	public static final String MaxExceedlength_error="The record is being rejected.";
	public static final String ClientIdentifierlength_Error="The ClientIdentifier cannot be null. The record is being rejected.";
	public static final String XRefEndDateFormatError="The XRefEndDate format is incorrect.";
	public static final String XRefClientStatusformaterror= "The ClientStatus format is incorrect.";


	public static final String ClientContactZipFormatError="The ClientContactZip format is incorrect.";
	public static final String ClientContactZipFormatError_alt="The ClientContactZip (Responsible Party) format is incorrect.";

	public static final String ClientContactZipLengthError="The ClientContactZip length is invalid. The length should be between 1 and 9.";

	public static final String ClientContactZipNullError="The ClientContactZip cannot be null.";
	public static final String ClientContactZipLengthError_alt="The ClientContactZip (Responsible Party) value is incorrect. The length should be between 1 and 9";
	public static final String ClientContactZipNullError_alt="The ClientContactZip cannot be null.";


	public static final String ClientIDNullError = "The ClientID cannot be null.";
	public static final String ClientIdentifiernullerror= "The ClientIdentifier cannot be null.";
	public static final String ClientIdentifierformat="The ClientIdentifier format is incorrect";
	public static final String ClientIdentifiervalueError= "The ClientIdentifier value is incorrect.";

	public static final String ClientZipSizeError="The ClientZip length is invalid. The length should be between 0 and 9.";
	public static final String ClientZipNullError="The ClientZip cannot be null.";

	public static final String ClientContactTypeFormatError= "The ClientContactType (Responsible Party) format is not correct.";
	public static final String EmployeeBirthDateformatError="ERROR: The EmployeeBirthDate expected format is not correct.";
	public static final String ClientSSNFormatError = "The ClientSSN format is incorrect.";
	public static final String EmployeeBirthDatefuture="The EmployeeBirthDate expected value is not correct. The record should be in the past. The record is being rejected.";
	public static final String EmpFNameLengthError="The EmployeeFirstName the length should be between 1 and 30.";
	public static final String EmpLNameLengthError="The EmployeeLastName the length should be between 1 and 30.";
	public static final String EmpFNameNullError="The EmployeeFirstName cannot be NULL.";
	public static final String EmpFNameFormatError = "The EmployeeFirstName format is incorrect.";
	public static final String ClientdesigneeLastNameerror= "The ClientDesigneeLastName format is incorrect.";
	public static final String ClientdesigneeFirstNameerror= "The ClientDesigneeFirstName format is incorrect.";
	public static final String Clientcustomiderror="The ClientCustomID length is invalid. The length should be between 1 and 24.";
	public static final String clientcontactZiperror="The ClientContactZip format is incorrect.";
	public static final String ClientcontactZiperror1="The ClientContactZip length is invalid.";
	public static final String ClientContactTypeerror="The ClientContactType format is incorrect.";
	public static final String ClientContactStateerror="The ClientContactState format is incorrect.";
	public static final String ClientContactStateerror1="The ClientContactState length is invalid.";
	public static final String ClientContactPhoneTypeFormatError="The ClientContactPhoneType (Responsible Party) format is incorrect.";
	public static final String ClientContactPhoneTypeFormatError_mem="The ClientContactPhoneType format is incorrect.";
	public static final String ClientContactPhoneerror="The ClientContactPhone format is incorrect.";
	public static final String ClientContactLastNameerror="The ClientContactLastName format is incorrect";
	public static final String AuthorizationServiceIDerror="The AuthorizationServiceID cannot be null nor empty.";
	public static final String AuthorizationServiceIDvalueeerror="The AuthorizationServiceID value is incorrect. The length should be between 1 and 5.";
	public static final String ClientContactLastNamelengtherror="The ClientContactLastName length is invalid.";
	public static final String AuthorizationServiceIDformateerror="The AuthorizationServiceID value is incorrect. The value length must be in range 1 - 5.";
	public static final String Authorizationrequirederror="The AuthorizationLimit cannot be null nor empty if this Authorization Limits section is provided.";
	public static final String ClientContactFirstNameerror="The ClientContactFirstName format is incorrect.";
	public static final String ClientDiagnosisCodeformaterror="The ClientDiagnosisCode value is incorrect. The max length should be 10.";
	public static final String Authorizationweekstarterror="The AuthorizationWeekStart format is incorrect.";
	public static final String Authorizationweekstartnullerror="AuthorizationLimitDayOfWeek must be values: Mon, Tue, Wed, Thu, Fri, Sat, Sun if AuthorizationLimitType is S or D.";
	public static final String AuthorizationweekstartnullerrorW="ERROR: AuthorizationWeekStart must be values: Mon, Tue, Wed, Thu, Fri, Sat, Sun if AuthorizationLimitType is W.";
	public static final String AuthorizationLimitEndTimeerror="The AuthorizationLimitEndTime format is incorrect.";

	public static final String AuthorizationLimitStartTimeerror="The AuthorizationLimitStartTime format is incorrect";
	public static final String AuthorizationLimitDayOfWeekerror="The AuthorizationLimitDayOfWeek format is incorrect.";
	public static final String AuthorizationLimitDayOfWeekrequirederror="AuthorizationLimitDayOfWeek must be values: Mon, Tue, Wed, Thu, Fri, Sat, Sun if AuthorizationLimitType is S or D.";
	public static final String Authorizationweekstartinvaliderror="The AuthorizationWeekStart is required if AuthorizationLimitType is W.";
	public static final String Authorizationweekstartinvaliderror_OpenEVV="AuthorizationWeekStart must be values: Mon, Tue, Wed, Thu, Fri, Sat, Sun if AuthorizationLimitType is W.";
	public static final String ClientContactFirstNamelengtherror="The ClientContactFirstName length is invalid.";
	public static final String ClientContactCityerror="The ClientContactCity length is invalid. The length should be between 0 and 30.";
	public static final String ClientContactCitylengtherror="The ClientContactCity length is invalid.";
	public static final String Actionerror="The Action format is incorrect.";
	public static final String AuthorizationReferenceNumbenullrerror="The AuthorizationReferenceNumber cannot be null nor empty.";
	public static final String AuthorizationReferenceNumberformateerror="The AuthorizationReferenceNumber format is incorrect.";
	public static final String AuthorizationReferenceNumberLength="The AuthorizationReferenceNumber value is incorrect. The value length must be in range 1 - 30.";
	public static final String Actionelengthrror="The Action length is invalid.";
	public static final String ClientContactPhonelengtherror="The ClientContactPhone format is incorrect.";
	public static final String ClientContactPhonelengtherror1="The ClientContactPhone (Responsible Party) format is incorrect. The record should satisfy this regular expression";
	public static final String ClientdesigneeFirstNamelengtherror= "The ClientDesigneeFirstName length is invalid.";
	public static final String ClientdesigneeLastNamelengtherror= "The ClientDesigneeLastName length is invalid.";
	public static final String ClientDesigneeEmaillengtherror= "The ClientDesigneeEmail length is invalid.";
	public static final String ClientDesigneeStatuslengtherror= "The ClientDesigneeStatus length is invalid.";
	public static final String ClientDesigneeStartDate_futuredateerror= "The ClientDesigneeStartDate must be equals or less than current date";
	public static final String ClientDesigneeEndDate_futuredateerror= "The ClientDesigneeEndDate must be today";
	public static final String AuthorizationStatusformateerror="The AuthorizationStatus format is incorrect.";
	public static final String Authorizationlimittypeerror="The AuthorizationLimitType format is incorrect.";
	public static final String AuthorizationlimittypeerrorNull="The AuthorizationLimitType cannot be null nor empty.";
	public static final String AuthorizationStatusnullerror="The AuthorizationStatus cannot be null";
	public static final String AddressCityNullError= "The AddressCity cannot be null nor empty.";
	public static final String ProvidermultiplesegmentError= "Provider could not be duplicated in list.";
	public static final String AddressStateNullError= "The AddressState cannot be null nor empty.";
	public static final String AddressStateformaterror ="The AddressState format is incorrect.";
	public static final String AddressStateLengtherror ="The AddressState length is invalid. The length should be between 1 and 2.";
	public static final String AgencyPhoneNullError= "The AgencyPhone cannot be null nor empty.";
	public static final String AgencyPhonelengthError= "";
	public static final String AgencyPhoneformatError ="The AgencyPhone format is incorrect.";
	public static final String PrimaryContactLastNameNullError= "The PrimaryContactLastName cannot be null nor empty.";
	public static final String PrimaryContactLastNameLengthError= "The PrimaryContactLastName length is invalid. The length should be between 1 and 30.";
	public static final String PrimaryContactFirstNameNullError= "The PrimaryContactFirstName cannot be null nor empty.";
	public static final String PrimaryContactFirstNameLengthError= "The PrimaryContactFirstName length is invalid. The length should be between 1 and 30.";
	public static final String ClientMiddleInitialLengthError = "The ClientMiddleInitial length is invalid. The length should be between 0 and 1.";
	public static final String AddressLine2lengthError= "The AddressLine2 length is invalid. The length should be between 0 and 50.";
	public static final String CountylengthError= "The County length is invalid. The length should be between 0 and 30.";
	public static final String ProviderFaxformatError= "The ProviderFax format is incorrect.";
	public static final String ProviderAPIFormat= "The ProviderAPI format is incorrect.";
	public static final String ProviderNPIformatError= "The ProviderNPI format is incorrect.";
	public static final String TaxIDFormaterror= "The TaxID format is incorrect. The record should satisfy this regular expression [\\u0027^(\\\\d{9})?$\\u0027].";

	public static final String suspensionDateError = "The suspension date should be prior to the termination date.";

	//---------------------------------------------Authorization Table-------------------------------------//

	public static final String ProviderRequireAuthFormatError= "The ProviderRequireAuth format is incorrect.";
	public static final String SuspendionDateformat_Error= "The SuspensionDate format is incorrect.";
	public static final String TerminationDateformat_Error= "The TerminationDate format is incorrect.";






//---------------------------------------------Authorization Table-------------------------------------//

	public static final String Auth_ref_number ="AuthorizationReferenceNumber" ;
	public static final String Authrefnumber ="authorizationReferenceNumber" ;
	public static final String AuthorizationMaximum ="AuthorizationMaximum";
	public static final String memo ="AuthorizationComments";

	public static final String Clientidentifier ="ClientIdentifier";
	public static final String clientid ="ClientIdentifier";
	public static final String payor_id ="PayerID";
	public static final String provider_id ="ProviderID";
	public static final String provider_id_quelifier="ProviderQualifier";




	// ----------------------------------DB Fields -----------------------------------------------------------------//

	public static final String dbLongitude ="longitude" ;
	public static final String dbLatitude ="latitude" ;
	public static final String dbClientFirstName ="f_name";
	public static final String dbClientLastName ="l_name";

	public static final String dbpayerid ="PAYOR_ID";
	public static final String dbclientid ="LOC";
	public static final String dbpayerProgram ="program";
	public static final String dbClientSSN ="client_ssn";
	public static final String dbClientZip="zip_code";
	public static final String ClientFirstName_stxuser ="USER_F_NAME";
	public static final String ClientlasTName_stxuser="USER_L_NAME";
	public static final String appUser_Delete ="deleted";

	public static final String dbAdressType ="addr_type_qlfr";

	public static final String dbProviderid    ="provider_id";
	public static final String dbClientEligibilityDateBegin    ="beg_date";
	public static final String dbPayerID   ="payor_id";
	public static final String dbClientStatus    ="delete_flag";
	public static final String dbClientEligibilityDateEnd ="end_date";
	public static final String dbClientPhoneType ="description";

	public static final String dbClientPhone ="ani";
	public static final String dbclientEmail ="E_MAIL";
	public static final String dbMobileLogin="call_username";


	public static final String dbClientID ="LOC";
	public static final String dbPayerProgram ="program";
	public static final String dbDeletestatus ="delete_flag";
	public static final String dbDischargeDate ="dis_date";

	public static final String dbClientContactCity = "city";
	public static final String dbClientContactState = "state";
	public static final String dbClientContactZip="zip_code";
	public static final String dbClientContactFirstName="f_name";

	public static final String dbClienttimezone ="TZNAME";

	public static final String payerProgram_db ="program";
	public static final String dbContactCity="city";
	public static final String dbCityContacttype="contact_relationship";
	public static final String dbClientContactPhone="phonenum_home";
	public static final String dbClientContactPhone2="phonenum_Business";
	public static final String dbClientContactPhone3="phonenum_Other";
	public static final String dbClientContactPhone4="phonenum_Mobile";

	public static final String payerid_DB ="payor_id";
	public static final String jsonProcedureCode ="ProcedureCode";
	public static final String dbPROVIDERIDQLFR = "PROVIDER_ID_QLFR";

	public static final String dbClientAddressLine2="addr2";
	public static final String dbClientAddressLine1="addr1";
	public static final String dbClientCity ="city";
	public static final String dbClientCounty ="county";

	// --###########################---Employee Details -########################################

	//-------------------config properties-------------------------------
	public static final String create_employee_URL="create_employee";
	public static final String altevv_emp_url="altevv_emp";
	public static final String Emp_get_url ="Emp_get";
	public static final String altevv_emp_get="altevv_emp_get";

	//------------------JSON File name Reading----------
	public static final String staff_intake_json ="Staff_intake";

	//------------------JSON File name Reading----------
	public static final String emp_openevv_Json="employee";
	public static final String emp_max_openevv_Json="employee_Max_Values";
	public static final String emp_min_openevv_Json="employee_Min_Values";


	// -------------------JSON Object name identification ----------------------------------------
	public static final String SequenceID = "SequenceID";
	public static final String EmployeeAddress1 = "EmployeeAddress1";
	public static final String EmployeeAddress2 = "EmployeeAddress2";
	public static final String EmployeeCity = "EmployeeCity";
	public static final String EmployeeSocialSecurity = "EmployeeSocialSecurity";
	public static final String EmployeeID="EmployeeID";
	public static final String StaffOtherID = "StaffOtherID";
	public static final String EmployeeIDCustom1 = "EmployeeIDCustom1";
	// -------------------JSON error message identification ----------------------------------------
    public static final String EmpSSNMaxLengthError = "ERROR: The EmployeeSocialSecurity value exceeds the maximum length of 9 characters.";
    public static final String EmpSSNFormatError = "The EmployeeSocialSecurity expected format is not correct.";

	public static final String EmpIDFormatError = "The EmployeeID expected format is not correct.";
	public static final String EmployeeIDerror="The EmployeeID value is incorrect.";
	public static final String EmployeeIDformaterror= "The EmployeeID format is incorrect.";
	public static final String EmpAccountFormatError  = "The Account for input record(s) does not match with given Account 14420. Please check and try again.";
	public static final String EmpAdd1FormatError = "The EmployeeAddress1 expected format is not correct.";
	public static final String EmpAdd2FormatError = "The EmployeeAddress2 expected format is not correct.";
	public static final String EmpCityFormatError = "The EmployeeCity expected format is not correct.";
	public static final String ClientAddressLine1FormatError1="The ClientAddressLine1 format is incorrect. The record should satisfy this regular expression";
	public static final String EmployeeEndDateformaterror="The EmployeeEndDate expected format is not correct.";
	public static final String EmployeeMaxEndDateerror="The EmployeeEndDate value exceeds the maximum length of 8 characters. The record is being rejected. The length should be between 0 and 8.";
	public static final String EmployeeHireMaxDateerror="The EmployeeBirthDate value exceeds the maximum length of 8 characters.";
	public static final String billcodelengtherror="The BillCode value is incorrect";
	public static final String billcodeformaterror="The BillCode format is incorrect.";
	public static final String otabcodelengtherror="The OTABCode value is incorrect";
	public static final String otabcodeformaterror="The OTABCode format is incorrect.";
	public static final String OTABHourslengtherror="The OTABHours value is incorrect";
	public static final String CaseSequencelengtherror="The CaseNumber value is incorrect";
	public static final String CaseSequencelengtherror_Schedule="The CaseSequence value is incorrect";
	public static final String CaseSequenceformaterror="The CaseNumber format is incorrect.";
	public static final String ClientIDlengtherror="ERROR: The ClientID value is incorrect";
	public static final String CaseSequenceformaterror_Schedule="The CaseSequence format is incorrect. The record should satisfy this regular expression";
	public static final String EMPTYPE="The EmployeeType expected format is not correct";
	public static final String SequenceLengthError = "The SequenceID value is greater than the 16 characters";
	public static final String SequenceIDMaxLengthError = "The SequenceID value cannot be greater than 9999999999999999";
	public static final String SequenceLengthNullError = "The SequenceID cannot be null.";
	public static final String SequenceLengthFormatError = "The SequenceID format is incorrect";
	public static final String EmpTypeFormatError = "The EmployeeType expected format is not correct";

	// -------------------DB Fields ----------------------------------------

	public static final String dbEmpAddressLine1 = "addr1";
	public static final String dbEmpAddressLine2 = "addr2";
	public static final String dbEmpCity = "city";
	public static final String dbEmpSSN ="worker_ssn";
	public static final String dbEmpId ="att_id";
	public static final String dbSequenceID = "worker_version_number";
	public static final String dbWorkerID ="WORKER_ID";
	public static final String dbAccount ="Account";



	// --###########################---Employee Details -########################################

	//-------------------config properties-------------------------------
	public static final String visit_intake_json="visit_intake";

	public static final String altevv_visit_get="altevv_visit_get";
	public static final String altevv_visit="altevv_visit";
	public static final String altevv_client_get="altevv_clients_get";
	public static final String altevv_accId="altevv_accId";
	public static final String OpenEvv_AccId="OpenEvv_AccId";
	public static final String ohio_AccId_v1="ohio_AccId_v1";
	public static final String ohio_accid="ohio_accid";
	public static final String ohio_user_v1="ohio_user_v1";
	public static final String ohio_pass_v1="ohio_pass_v1";


	//------------------Visit JSON File name Reading----------
	public static final String  SequenceIDjson ="SequenceID";
	public static final String  VisitOtherIDjson ="VisitOtherID";
	public static final String  VisitEmployeeOtherID="EmployeeOtherID";
	public static final String  ClientOtherIDjson  ="ClientOtherID";
	public static final String  ReasonCodejson  ="ReasonCode";
	public static final String  ResolutionCodejson  ="ResolutionCode";
	public static final String  ChangeReasonMemojson  ="ChangeReasonMemo";
	public static final String  ClientVerifiedTasksjson = "ClientVerifiedTasks";
	public static final String ClientVoiceRecordingjson ="ClientVoiceRecording";
	public static final String CallExternalIDjson = "CallExternalID" ;
	public static final String  AdjInDateTimejson ="AdjInDateTime";
	public static final String  AdjOutDateTimejson ="AdjOutDateTime";
	public static final String employeequalifier= "EmployeeQualifier";
	public static final String VisitChanges= "VisitChanges";

	public static final String ScheduleStartTime="ScheduleStartTime";
	public static final String ScheduleEndTime="ScheduleEndTime";

	public static final String VisitEmployeeIdentifier = "EmployeeIdentifier";
	public static final String VisitClientIdentifier = "ClientIdentifier";

	public static final String CallAssignmentjson ="CallAssignment";
	public static final String CallTypejson = "CallType";
	public static final String CallProcedureCode = "ProcedureCode";
	public static final String  VisitEmployeeIdentifierjson = "EmployeeIdentifier";
	public static final String  VisitClientIdentifierjson = "ClientIdentifier";
	public static final String  VisitGroupCodejson = "GroupCode";
	public static final String  EmployeeIdentifierjson = "EmployeeIdentifier";
	public static final String  ClientIdentifierjson = "ClientIdentifier";
	public static final String  VisitCancelledIndicatorjson = "VisitCancelledIndicator";
	public static final String  PayerIDjson = "PayerID";
	public static final String  PayerProgramjson = "PayerProgram";
	public static final String  ProcedureCodejson = "ProcedureCode";
	public static final String  Memojson = "Memo";
	public static final String  VisitTimeZonejson = "VisitTimeZone";
//	public static final String visitTimeZonejson ="VisitTimeZone";
	public static final String  CallDateTimejson = "CallDateTime";
	public static final String  ClientVerifiedTimesjson="ClientVerifiedTimes";
	public static final String  ExceptionAcknowledgedjson   ="ExceptionAcknowledged";
	public static final String  BillVisitjson ="BillVisit";

	public static final String ClientIdentifierOnCalljson= "ClientIdentifierOnCall";
	public static final String MobileLoginjson= "MobileLogin";
	public static final String CallLatitudejson= "CallLatitude";
	public static final String CallLongitudejson= "CallLongitude";
	public static final String Locationjson= "Location";
	public static final String TelephonyPINjson= "TelephonyPIN";
	public static final String OriginatingPhoneNumberjson= "OriginatingPhoneNumber";
	public static final String ChangeMadeByjson= "ChangeMadeBy";
	public static final String ChangeDateTimejson= "ChangeDateTime";
	public static final String ScheduleStartTimejson = "ScheduleStartTime";
	public static final String ScheduleEndTimejson = "ScheduleEndTime";
	public static final String ClientSignatureAvailablejson="ClientSignatureAvailable";
	public static final String ClientVerifiedServicejson="ClientVerifiedService";
	public static final String HoursToBilljson="HoursToBill";
	public static final String HoursToPayjson="HoursToPay";

	public static final String TelephonyPinjson= "TelephonyPIN";

	public static final String  Changemadebyemailjson= "ChangeMadeByEmail";



	// -------------------JSON error message identification ----------------------------------------

	public static final String ReasonCodeLengthError= "The ReasonCode value is incorrect";
	public static final String ResolutionCodeLengthError= "The ResolutionCode value is incorrect";
	public static final String ClientVerifiedTasksError= "The ClientVerifiedTasks format is incorrect.";
	public static final String ClientVerifiedTasksNullError= "The ClientVerifiedTasks cannot be null";
	public static final String ClientVerifiedTimesError= "The ClientVerifiedTimes format is incorrect.";
	public static final String ClientVerifiedServiceError= "The ClientVerifiedService format is incorrect.";
	public static final String ClientVerifiedServiceNullError= "The ClientVerifiedService cannot be null.";
	public static final String ClientSignatureAvailableError=  "The ClientSignatureAvailable format is incorrect.";
	public static final String ClientSignatureAvailableNullError=  "The ClientSignatureAvailable cannot be null";
	public static final String ClientVoiceRecordingError = "The ClientVoiceRecording format is incorrect.";
	public static final String ClientVoiceRecordingNullError = "The ClientVoiceRecording cannot be null";
	public static final String errorVisitOtherIdLength  = "The VisitOtherID value is greater than the 50 characters. The length should be between 1 and 50.";
	public static final String errorVisitOtherIdFormat ="The VisitOtherID format is incorrect.";
	public static final String errorVisitOtherIDNull ="The VisitOtherID cannot be null";
	public static final String errorSequenceIdNull = "The SequenceID cannot be null";
	public static final String errorEmployeeOtherIDlength ="The EmployeeOtherID value length exceeds the field size";
	public static final String EmployeeOtherIDFormatError ="The EmployeeOtherID expected format is not correct.";
	public static final String errorEmployeeOtherIDMaxLengthValidation = "The EmployeeOtherID value is greater than 64 characters. The length should be between 0 and 64";
	public static final String errorEmployeeOtherIDFormat ="The EmployeeOtherID format is incorrect. The record should satisfy this regular expression";
	public static final String EmployeeOtherIDRegularExpressionError = "The EmployeeOtherID expected format is not correct. The record should satisfy this regular expression";
	public static final String ChangeReasonMemoLengthError = "The ChangeReasonMemo";
	public static final String ChangeReasonMemoNullError = "The ChangeReasonMemo";
	public static final String CallExternalIDLengthError = "The CallExternalID value should be between 1 and 16.";
	public static final String CallExternalIDFormatError = "The CallExternalID format is incorrect.";
	public static final String CallExternalIDNullError = "The CallExternalID cannot be null.";
	public static final String CallAssignmentError = "The CallAssignment format is incorrect.";
	public static final String CallTypeError =  "The CallType format is incorrect.";

	public static final String CallExternalIDLength_Error= "The CallExternalID value should be between 1 and 16. The record is being rejected.";
	public static final String SequenceidError = "VersionNumber is either duplicated or older than current.";
	public static final String EmployeeIDformateerror="The EmployeeID format is incorrect";
	public static final String providerID_formaterror= "The ProviderID (Client) format is incorrect.";
	public static final String ProviderIDFormatClientError= "The ProviderID format is incorrect. The record should satisfy this regular expression";
	public static final String ProviderID_length_client= "The ProviderID (Client) value is incorrect. The length should be between 1 and 50.";
	public static final String errorEmployeeIdentifierlength = "The EmployeeIdentifier value length exceeds the field size and should be between 1 and 9. The record is being rejected.";
	public static final String ProviderIDlengtherror_Emp= "The ProviderID value exceeds the maximum length of 50 characters. The length should be between 1 and 50.";
	public static final String ProviderIDFormaterror= "The ProviderID expected format is not correct.";
	public static final String errorEmployeeIdentifierNull             ="The EmployeeIdentifier cannot be null.";
	public static final String errorEmployeeIdentifierFormat           ="The EmployeeIdentifier format is incorrect. The record should satisfy this regular expression";
	public static final String ClientPhone_format= "The ClientPhone format is incorrect.";
	public static final String ClientPhone_length= "The ClientPhone length is invalid. The length should be between 1 and 10.";
	public static final String GroupCodeLengthError                    = "The GroupCode value is incorrect. The length should be between 0 and 6.";
	public static final String GroupCodeFormatError = "The GroupCode format is incorrect.";

	public static  String errorClientOtherIdLength               ="The ClientOtherID value exceeds 24 characters. The length should be between 1 and 24. The record is being rejected.";
	public static final String  errorClientOtherIdFormat               ="The ClientOtherID format is incorrect.";
	public static final String errorClientIdentifierNull              ="The ClientIdentifier cannot be null.";
	public static final String errorClientIdentifierFormat             ="The ClientIdentifier format is incorrect. The record should satisfy this regular expression";
	public static final String errorPayorIdLength                     = "The PayerID length should be between 1 and 64.";
	public static final String errorPayorIdLength1  =     "The PayerID value is incorrect. The length should be between 1 and 64.";

	public static final String errorPayorIDNull_OpenEVV                      = "The PayerID cannot be null nor empty.";
	public static final String errorPayorIDFormat_OpenEVV ="The PayerID value is incorrect. The value length must be in range 1 - 64";

	public static final String errorPayorIDNull_AltEVV       = "The PayerID cannot be null.";
	public static final String errorPayorIDFormat_AltEVV  ="The PayerID format is incorrect.";
	public static final String errorPayoraltevvGeneric ="The PayerID cannot be null. The record is being rejected.";

	public static final String EmployeeIdentifierlength = "The EmployeeIdentifier value exceeds the maximum length of 9 characters. The length should be between 1 and 9.";
	public static final String errorPayorProgramFormat="The PayerProgram value must be one of the valid values. The record is being rejected.";
	public static final String errorPayorProgramNull="The PayerProgram cannot be null. The record is being rejected.";
	public static final String PayorProgramNullerror= "The PayerProgram cannot be null nor empty.";
	public static final String payorProgLengthError ="The PayerProgram value is incorrect. The value length must be in range 1 - 64";
	public static final String errorPayorProgramSpecialcharFormat ="The PayerProgram format is incorrect. The record should satisfy this regular expression";
	public static final String VisitTimeZoneNullError="The VisitTimeZone cannot be null. The record is being rejected.";
	public static final String VisitCancelledIndicatorNullError="The VisitCancelledIndicator cannot be null. The record is being rejected.";
	public static final String VisitCancelledIndicatorformatError="The VisitCancelledIndicator format is incorrect. The record should satisfy this regular expression";
	public static final String PayerProgramNullError="The PayerProgram cannot be null";
	public static final String BillVisitNull= "The BillVisit cannot be null. The record is being rejected.";
	public static final String PayerIDNullError="The PayerID cannot be null.";
	public static final String PayerIDNullError_OpenEVV="The PayerID (Eligibility segment) cannot be null.";
	public static final String ProcedureCodeNullError="The ProcedureCode cannot be null.";
	public static final String VisitOtherIDNullError="The VisitOtherID cannot be null. The record is being rejected.";
	public static final String SequenceIDNullError="The SequenceID cannot be NULL";
	public static final String AuthorizationAmountTypeformaterror= "The AuthorizationAmountType format is incorrect.";
	public static final String AuthorizationAmountTypenullerror=  "The AuthorizationAmountType cannot be null";
	public static final String StaffSequenceIDNullError="The SequenceID cannot be NULL.";
	public static final String EmployeeIdentifierNullError="The EmployeeIdentifier cannot be null. The record is being rejected.";
	public static final String EmployeeAPIError = "The EmployeeAPI value exceeds the maximum length of null characters";
	public static final String ChangeDateTimeNullError ="The ChangeDateTime cannot be null. The record is being rejected.";
	public static final String ChangeMadeByNullError ="The ChangeMadeBy cannot be null. The record is being rejected.";
	public static final String OriginatingPhoneNumberNullError ="TelephonyPIN and OriginatingPhoneNumber will be required";
	public static final String TelephonyPINNullError ="The TelephonyPIN cannot be null. The record is being rejected.";
	public static final String LocationNullError ="The Location cannot be null. The record is being rejected.";
	public static final String CallLongitudeNullError ="The CallLongitude cannot be null. The record is being rejected.";
	public static final String CallLatitudeNullError ="The CallLatitude cannot be null. The record is being rejected.";
	public static final String CallLatitudeMaxLengthError = "The CallLatitude value cannot be greater than 90";
	public static final String CallLatitudeMinLengthError = "The CallLatitude value cannot be less than -90.";
	public static final String CallMobileError = "MobileLogin, CallLatitude and CallLongitude will be required";
	public static final String CallTelephonenyError = "TelephonyPIN and OriginatingPhoneNumber will be required";

	public static final String MobileLoginNullError1 = "The MobileLogin value is incorrect. The length should be between 1 and 64. The record is being rejected.";
	public static final String ClientIdentifierOnCallNullError = "The ClientIdentifierOnCall cannot be null. The record is being rejected.";
	public static final String ClientIdentifierOnCallFormatError = "The ClientIdentifierOnCall format is incorrect.";
	public static final String CallTypeNullError = "The CallType cannot be null.";
	public static final String CallAssignmentNullError = "The CallAssignment cannot be null. The record is being rejected.";
	public static final String ProcedureCodeError = "The ProcedureCode cannot be null.";
	public static final String HoursToBillValueError = "The HoursToBill value cannot be greater than 99.999.";
	public static final String HoursToBillValueError_Molina = "The HoursToBill value cannot be greater than 99.999";
	public static final String HoursToPayValueError = "The HoursToPay value cannot be greater than 99.999.";
	public static final String errorMemolength = "The Memo value is incorrect";

	public static final String Modifier1LengthError = "The Modifier1 value is incorrect";
	public static final String Modifier2LengthError = "The Modifier2 value is incorrect";
	public static final String Modifier3LengthError = "The Modifier3 value is incorrect";
	public static final String Modifier4LengthError = "The Modifier3 value is incorrect";
	public static final String Modifier1LengthError_OpenEVV = "The Modifier1 value is incorrect";
	public static final String Modifier2LengthError_OpenEVV ="The Modifier2 value is incorrect";
	public static final String Modifier3LengthError_OpenEVV ="The Modifier3 value is incorrect";
	public static final String Modifier4LengthError_OpenEVV ="The Modifier4 value is incorrect";
	public static final String Modifier3LengthErrorgneric ="The Modifier3 length is invalid";
	public static final String Modifier1Length ="The Modifier1 length is invalid.";
	public static final String Modifier2Length ="The Modifier2 length is invalid.";
	public static final String Modifier3Length ="The Modifier3 length is invalid.";
	public static final String Modifier4Length ="The Modifier4 length is invalid.";
	public static final String ClientIDQualifierformaterror ="The ClientIDQualifier format is incorrect.";
    public static final String errorProcedureCodelength = "The ProcedureCode length is invalid.";
	public static final String ProcedureCodeLengthError= "The ProcedureCode value is incorrect.";
	public static final String ProcedureCodeFormatError= "The ProcedureCode format is incorrect";
	public static final String DischargeDateError= "The DischargeDate is incorrect. The record should be in the past.";
	public static final String DischargeDateFormatError= "The DischargeDate format is incorrect.";
	public static final String AssessmentDateFormatError= "The AssessmentDate format is incorrect.";
	public static final String ServiceAuthorizedDateFormatError= "The ServiceAuthorizedDate format is incorrect.";
	public static final String errorProcedureCodeVisit="must be one of the valid values: [G0156|G0299|G0300|HPC|S5125|T1000|T1001|T1002|T1003|T1019].";
	public static final String errorProcedureCodeClient="must be one of the valid values: [G0156|G0299|G0300|HPC|S5125|T1000|T1001|T1002|T1003|T1019]. The record is being rejected.";
	public static final String errorPayerClient="must be one of the valid values: [Aetna|Buckeye|CareSource|DODD|Molina|ODA|ODM|Paramount|UHC]. The record is being rejected.";
	public static final String errorPayerprogramClient="must be one of the valid values: [DD|MyC|OHC|PP|SP|SPHH]. The record is being rejected.";

	public static final String errorProcedureCodeNull ="The ProcedureCode cannot be null.  The record is being rejected.";
	public static final String errorPayerID = "Error during retrieving service service_id entered";
	public static final String errorVisitTiemZoneFormat="The VisitTimeZone format is incorrect.";
	public static final String errorVisitTimeZonelength= "The VisitTimeZone value is invalid.";
	public static final String errorVisitTimeZoneNull="The VisitTimeZone cannot be null. The record is being rejected.";
	public static final String errorSequenseIDminLength="The SequenceID format is incorrect.";
	public static final String SequenceIDLengthError = "The SequenceID value cannot be greater than 9999999999999999.";
	public static final String ClientIdentifierOnCallnullerror="The ClientIdentifierOnCall cannot be null.";
	public static final String ClientIdentifierOnCallformaterror="The ClientIdentifierOnCall format is incorrect.";
	public static final String CallDateTimeNullError= "The CallDateTime cannot be null.";
	public static final String ExceptionIDError= "The ExceptionID value should be between 1 and 2. The record is being rejected.";
	public static final String ExceptionIDformaterror="The ExceptionID format is incorrect.";

	public static final String ClientContactPhone_error="The ClientContactPhone format is incorrect.";
	public static final String ProviderIDNullError= "The ProviderID cannot be null nor empty.";
	public static final String PayerIdIncorrectFormatError= "The PayerID format is incorrect.";
	public static final String PayerIDnullError= "The PayerID cannot be null nor empty.";
	public static final String PayerIDlengthError= "The PayerID length is invalid. The length should be between 1 and 64.";
	public static final String ProviderQualifierNull_Error= "The ProviderQualifier cannot be null nor empty.";
	public static final String ProviderQualifierNullError= "The ProviderQualifier (Client) cannot be null";
	public static final String ProviderQualifier_Format= "The ProviderQualifier format is incorrect.";
	public static final String ProvidernameNull_Error= "The ProviderName cannot be null nor empty.";
	public static final String ProviderNamelength_Error= "The ProviderName length is invalid. The length should be between 1 and 30.";
	public static final String ProviderDoingBusinesslengthError= "The ProviderDoingBusinessAs length is invalid. The length should be between 0 and 50.";

	public static final String EmployeeQualifierformaterror1="The EmployeeQualifier format is incorrect";
	public static final String AgencyEmailNull_Error= "The AgencyEmail cannot be null nor empty.";
	public static final String AgencyEmaillength_Error= "The AgencyEmail length is invalid. The length should be between 1 and 64.";
	public static final String AgencyEmailformat_Error= "The AgencyEmail format is incorrect.";

	public static final String EmployeeBirthDateYearformat= "The EmployeeBirthDate value exceeds the maximum length of 8 characters. The record is being rejected. The length should be between 0 and 8.";


	public static final String EmployeeQualifierformaterror="The EmployeeQualifier value is incorrect";
	public static final String EmployeeQualifierformat="The EmployeeQualifier format is incorrect.";
	public static final String providerTaxonomyOpenevverror= "The ProviderTaxonomy format is incorrect.";
	public static final String ProviderDateBeginOpenevverror="The ProviderDateBegin format is incorrect.";
	public static final String TerminationDateOpenevverror="The TerminationDate format is incorrect.";
	public static final String SuspensionDateOpenevverror="The SuspensionDate format is incorrect.";

	public static final String CallInOutDateTime_Error= "The Call In cannot be greater than the Call Out. The record is being rejected.";
	public static final String AdjInCallOutDateTime_Error="The AdjInDateTime cannot be greater than the Call out. The record is being rejected.";
	public static final String EmpIDFormat= "The EmployeeID value exceeds the maximum length of 5 characters.  The record is being rejected. The length should be between 0 and 5.";
	public static final String Errormesssage= "Could not read JSON: java.lang.NumberFormatException; nested exception is com.google.gson.JsonSyntaxException: java.lang.NumberFormatException";
	public static final String ClientIdentifierOnCallLengthError= "The ClientIdentifierOnCall value is incorrect. The length should be between 1 and 10.";
	public static final String ClientIdentifierOnCallformatError="The ClientIdentifierOnCall format is incorrect.";
	public static final String LocationLengthError= "The Location value is incorrect";
	public static final String LocationFormatError= "The Location format is incorrect.";
	public static final String OriginatingPhoneNumberLengthError= "The OriginatingPhoneNumber value is incorrect.";
	public static final String OriginatingPhoneNumberFormatError= "The OriginatingPhoneNumber format is incorrect.";

	public static final String errorChangedMadeby="The ChangeMadeBy value is incorrect. The length should be between 1 and 64";
	public static final String errorChangeMadeByNull="The ChangeMadeBy cannot be null. The record is being rejected.";

	public static final String errorClientNotFound="Client does not exist";
	public static final String errorWorkerNotFound="Worker not found";

	public static final String TelephonyPinLengthError= "The ReasonCode value is incorrect. The length should be between 4 and 9.";
	public static final String TelephonyPinLength="The TelephonyPIN value cannot be greater than 999999999.";
	public static final String TelephonyPinNullError= "The TelephonyPIN cannot be null.";
	public static final String TelephonyPINFormatError ="The TelephonyPIN value cannot be greater than 999999999.";
	public static final String TelephonyPINFormatError1 ="java.lang.NumberFormatException";
	public static final String TelephonyPINNegativeError= "The TelephonyPIN value cannot be less than 0.";
	public static final String ClientAddressEmptyError = "The ClientAddress should not be empty.";
	public static final String ClientAddressTypeNullError="The ClientAddressType cannot be null.";
	public static final String Providerqualifiererror="The ProviderQualifier format is incorrect";
	public static final String Providerqualifiernullerror="The ProviderQualifier cannot be null nor empty.";

	public static final String ClientLanguageerror="The ClientLanguage length is invalid. The length should be between 0 and 32.";

	public static final String Providernullerror= "The Provider cannot be null.";
	public static final String ClientTimeZoneError="The ClientTimeZone value is invalid.";
	public static final String ClientCitylength_error = "The ClientCity length is invalid.";
	public static final String AddresscitylengthError = "The AddressCity length is invalid. The length should be between 1 and 30.";
	public static final String AddressLine1null_error = "The AddressLine1 cannot be null nor empty.";
	public static final String ClientidQualifierFormatError1= "The ClientIDQualifier format is incorrect.";
	public static final String EmployeeidQualifierFormatError1= "The EmployeeQualifier format is incorrect.";
	public static final String DeleteStatusFormatError1="The ClientStatus format is incorrect. The record should satisfy this regular expression";
	public static final String AddressLine1LengthError= "The AddressLine1 length is invalid. The length should be between 1 and 50.";
	public static final String ClientAddressLine1NullError= "The ClientAddressLine1 cannot be null.";
	public static final String ClientAddressLine2NullError= "The ClientAddressLine2 cannot be null.";

	public static final String ClientAddressLine1FormatError= "The ClientAddressLine1 format is incorrect.";
	public static final String ClientAddressLine1LengthValueError= "The ClientAddressLine1 value is incorrect. The length should be between 1 and 30.";
	public static final String ClientAddressLine1LengthError= "The ClientAddressLine1 length is invalid. The length should be between 1 and 30.";

	public static final String ClientidQualifierFormatError11= "The ClientIDQualifier format is incorrect.";
	public static final String EmployeeidQualifierFormatError11= "The EmployeeQualifier format is incorrect.";
	public static final String DeleteStatusFormatError11="The ClientStatus format is incorrect. The record should satisfy this regular expression";
	public static final String EmployeeHireDateYearformat="The EmployeeHireDate's year is not correct";
	public static final String Modifier1FormatError = "The Modifier1 format is incorrect.";
	public static final String Modifier1lengthError= "The Modifier1 length is invalid";
	public static final String Modifier2FormatError = "The Modifier2 format is incorrect.";
	public static final String Modifier2FormatvalueError ="Modifier2 value is incorrect.";
	public static final String Modifier3FormatvalueError ="Modifier3 value is incorrect.";
	public static final String Modifier4FormatvalueError ="The Modifier4 value is incorrect.";
	public static final String AuthorizationBillingTypevalueerror="The AuthorizationBillingType value is incorrect.";
	public static final String AuthorizationBillingTypeerror="The AuthorizationBillingType format is incorrect.";
	public static final String Modifier3FormatError = "The Modifier3 format is incorrect.";
	public static final String Modifier4FormatError = "The Modifier4 format is incorrect";
	public static final String ClientIDformaterror= "The ClientID format is incorrect.";
	public static final String EmployeeEndDateerror="The EmployeeEndDate cannot be less than EmployeeHireDate.";

	public static final String EmpIdentifierLengthError= "The EmployeeIdentifier value length exceeds the field size and should be between 1 and 9. The record is being rejected.";
	public static final String EmpIdentifierFormatError= "The EmployeeIdentifier format is incorrect.";
	public static final String Empidentifierformat= "The EmployeeIdentifier expected format is not correct. The record should satisfy this regular expression";
	public static final String EmpIdentifierNullError= "The EmployeeIdentifier cannot be NULL.";
	public static final String EmployeeAPIFormatError="The EmployeeAPI expected format is not correct";
	public static final String EmployeeAPILengthError="The EmployeeAPI value exceeds the maximum length of 25 characters. The length should be between";
	public static final String ClientIDLengthError= "The ClientID value is incorrect. The length should be between 5 and 5.";
	public static final String ClientOtherIDLengthError= "The ClientOtherID length is invalid. The length should be between 1 and 24.";
	public static final String ClientOtherIDLengthError1= "The ClientOtherID value is incorrect. The length should be between 1 and 24.";
	public static final String EmployeePositionLengthError="The EmployeePosition value is incorrect. The length should be between";
	public static final String EmployeePositionFormatError="The EmployeePosition expected format is not correct";
	public static final String EmployeePositionformaterrorMolina="The EmployeePosition format is incorrect.";
	public static final String CaseMangererror="The CaseManager format is incorrect.";

	public static final String Accounterror="The Account format is incorrect.";

	public static final String Accountformat="The Account for input record(s) does not match with given Account 14420. Please check and try again.";
	public static final String AccountLengtherror="The Account format is incorrect.";

	public static final String ClientAddressLine1error= "The ClientAddressLine1 format is incorrect.";
	public static final String ClientAddressLine2error= "The ClientAddressLine2 format is incorrect.";
	public static final String AddressZipformaterror = "The AddressZip format is incorrect.";
	public static final String AddressZipNullError = "The AddressZip cannot be null nor empty.";
	public static final String ProviderIDlengthError= "The ProviderID length is invalid. The length should be between 1 and 50.";
	// -------------------DB Fields ----------------------------------------

	public static final String dbEmployeeOtherID="worker_id";
	public static final String dbvisitotherid = "visit_id";
	public static final String dbvisitKey = "viskey";
	public static final String dbReasonCode ="REASON_CODE";
	public static final String dbChangeReasonMemo = "reason_code_memo";
	public static final String dbvisitSequenceId="visit_version_number";
	public static final String dbResolutionCode = "RESOLUTION_CODE";
	public static final String dbClientVerifiedTasks = "client_verify_tasks_ind";
	public static final String dbClientVerifiedService ="client_verify_service_ind";
	public static final String dbClientSignatureAvailable= "client_signature_ind" ;
	public static final String dbClientVoiceRecording = "client_voice_recording_ind";
	public static final String dbCallExternalID = "call_id";
	public static final String dbCallAssignment = "call_assignment_qlfr";
	public static final String dbEmployeeIdentifier ="worker_id_qlfr";
	public static final String dbClientIdentifier ="client_id_qlfr";
	public static final String dbvisitsexceptions_SequenceId = "SID";
	public static final String dbPayerIDVisit   ="payor_id";
	public static final String dbPayerProgramVisit="payor_program";
	public static final String dbVisitCancelledIndicator="visit_cancel_ind";
	public static final String dbScheduleStartTime ="b_dtime" ;
	public static final String dbScheduleEndTime ="e_dtime" ;
	public static final String dbCallType ="call_type_qlfr";
	public static final String dbHoursToBill= "bill_hours";
	public static final String dbHoursToPay= "pay_hours";
	public static final String dbAdjustinDate="beg_adj_dtime_utc";
	public static final String dbAdjustoutDate="end_adj_dtime_utc";
	public static final String dbChangeDateTime="visit_change_dtime_utc";
	public static final String dbVisitTimeZone="tzname";
	public static final String dbClientVerifiedTimes= "client_verify_time_ind";
	public static final String dbCallDateTime="call_dtime_utc";
	public static final String dbemployeeotherid="worker_id_custom1";

	public static final String dbExceptionID = "exception_id";
	public static final String dbExceptionAcknowledged = "exception_ack_ind";

	public static final String dbClientIdentifierOnCall = "client_id";
	public static final String dbLocation="call_location";
	public static final String dbOriginatingPhoneNumber ="ani";
	public static final String dbChangeMadeByVisit= "ChangeMadeBy";
	public static final String dbcallusername= "call_username";
	public static final String dblatitude= "latitude";
	public static final String dblongitude= "longitude";
	public static final String dbClientStartOfCareDate="";
	public static final String dbClientState="state";
	public static final String dbbeg_date="beg_date";
	public static final String dbend_date="end_date";
	public static final String dbTelephonyPin="stx_id";


	public static final String dbClientOtherid="client_id_custom2";
	public static final String dbClientCustomid="client_id_custom1";
	public static final String coordinator= "Coordinator";

	public static final String getOhioClaimFilePick= System.getProperty("user.dir")+ File.separator +"src" + File.separator + "test"+File.separator+ "resources"+File.separator+"Claim"+File.separator+"Pickup"+File.separator;
	public static final String getOhioClaimFileDrop= System.getProperty("user.dir")+ File.separator +"src" + File.separator + "test"+File.separator+ "resources"+File.separator+"Claim"+File.separator+"Drop"+File.separator;
	public static final String ohioClaimFtpLocation= CommonMethods.propertyfileReader("ohioClaimFtpLocation");
	public static final String ohioClaimFtpLocationload=CommonMethods.propertyfileReader("ohioClaimFtpLocationload");





	public static final String dbTelephonyPin1="stx_id";



	public static final String ClientStatusDateerror= "The ClientStatusDate format is incorrect.";
	public static final String ClientBirthDateerror="The ClientBirthDate format is incorrect.";
	public static final String ClientBirthDateformaterror= "The ClientBirthDate is incorrect. The record should be in the past or current.";
	public static final String ClientStatuserror="The ClientStatus format is incorrect";






	public static final String ClientidQualifierFormatError= "The ClientIDQualifier format is incorrect.";
	public static final String EmployeeidQualifierFormatError= "The EmployeeQualifier format is incorrect.";
	public static final String DeleteStatusFormatError= "The ClientStatus format is incorrect. The record should satisfy this regular expression";
	public static final String dbEmpFName= "F_name";
	public static final String dbEmpLName= "L_name";




	public static final String ClientEligibilityDateEnderror="The ClientEligibilityDateEnd format is incorrect.";
	public static final String ClientStartOfCareDateerror="The ClientStartOfCareDate format is incorrect.";


	public static final String dbEmpFName1= "F_name";
	public static final String dbEmpLName1= "L_name";

	public static final String ClientEndOfCareDateerror="The ClientEndOfCareDate format is incorrect.";








	public static final String dbTelephonyPin11="stx_id";




	public static final String dbModifier1="Modifier1";
	public static final String dbModifier2="Modifier2";
	public static final String dbModifier3="Modifier3";
	public static final String dbModifier4="Modifier4";
	public static final String dbPayerService="Service";

	public static final String dbClientAddLine1="addr1";
	public static final String dbClientAddLine2="addr2";

	public static final String ClientFirstNameLengthError="The ClientFirstName length is invalid.";
	public static final String ClientFirstNameLengthError_AltEVV="The ClientFirstName value is incorrect. The length should be between 1 and 30.";
	public static final String dbClientMiddleInitial="m_name";
	public static final String ClientLastNameLengthError="The ClientLastName length is invalid. The length should be between 0 and 30.";
	public static final String ClientSSNLengthError= "The ClientSSN length is invalid. The length should be between 0 and 9.";
	public static final String ClientSSNLengthError_AltEVV = "The ClientSSN length is invalid";
	public static final String ClientContactEmailAddresserror="The ClientContactEmailAddress format is incorrect.";
	public static final String ClientContactEmailAddress_MaxLength_Error = "The ClientContactEmailAddress (Responsible Party) value is incorrect. The length should be between 0 and 64.";
	public static final String ClientContactEmailAddress_Format_Error = "The ClientContactEmailAddress (Responsible Party) format is incorrect";
	public static final String ClientLastNameError = "The ClientLastName value is incorrect. The length should be between 1 and 30";
	public static final String ClientLastNameSpecialCharError = "The ClientLastName format is incorrect. The record should satisfy this regular expression";

	public static final String dbDeleteFlag ="delete_flag";

	public static final String dbClientEligibilityDateEnd1= "ClientEligibilityDateEnd";

	public static final String dbClientSuffix="name_suffix";
	public static final String ClientSuffixLengthError="The ClientSuffix length is invalid. The length should be between 0 and 4.";
	public static final String dbAction="delete_flag";
	public static final String ActionLengthError="The Action length is invalid. The length should be between 1 and 1.";
	public static final String PayerIDLengthError="The PayerID (Eligibility OR PayerProgramService segment) length is invalid.";
	public static final String PayerIDLengthError_OpenEvv="The PayerID (Eligibility segment) length is invalid. The length should be between 1 and 64.";

	public static final String PayerIDLengthError_payerprogramService="The PayerID (PayerProgramService segment) length is invalid. The length should be between 1 and 64.";

	public static final String PayerIDLengthError_Eligibility="The PayerID (Eligibility segment) length is invalid. The length should be between 1 and 64.\"";

	public static final String PayerProgramLengthError="The PayerProgram value is incorrect. The length should be between 0 and 9.";
	public static final String PayerProgramLengthError_ALTGeneric="The PayerProgram value is incorrect. The length should be between 1 and 9.";

	public static final String ClientMedicalRecordNumber="ClientMedicalRecordNumber";
	public static final String MissingMedicaidID="MissingMedicaidID";
	public static final String ClientCustomID="ClientCustomID";

	public static final String PayerServiceLengthError="The PayerService (Eligibility segment) value is incorrect. The length should be between 0 and 5.";
	public static final String PayerRegionLengthError="The PayerRegion value is incorrect. The length should be between 1 and 2.";
	public static final String CaseManagerLengthError= "The CaseManager length is invalid. The length should be between 0 and 25.";
	public static final String ClientCaseManagerEmailLengthError= "The ClientCaseManagerEmail length is invalid. The length should be between 0 and 64.";
	public static final String ClientCoordinatorEmailLengthError= "The ClientCoordinatorEmail length is invalid. The length should be between 0 and 50.";
	public static final String ClientGenderLengthError= "The ClientGender length is invalid. The length should be between 0 and 1.";
	public static final String ClientMaritalStatusLengthError= "The ClientMaritalStatus length is invalid. The length should be between 0 and 1.";
	public static final String ClientOtherIDFormatError="The ClientOtherID length is invalid. The length should be between 1 and 24.";
	public static final String PayerServiceFormatError="The PayerService format is incorrect.";
	public static final String PayerErrorNew= "The value for Ohio payer is \\u0027ODM\\u0027 only.";
	public static final String PayerErrorVisit="The Payer format is incorrect. It must be one of the valid values: [Aetna|Buckeye|CareSource|DODD|Molina|ODA|ODM|Paramount|UHC].";
	public static final String payerProgramErrorNew= "The PayerProgram format is incorrect. It should be between 1 and 64 characters and must be one of the valid values.";
	public static final String payerProgramErrorVisit="The PayerProgram format is incorrect. It must be one of the valid values: [DD|MyC|OHC|PP|SP|SPHH]";
	public static final String PayerServiceNullError="The PayerService can not be null or empty.";
	public static final String ClientCaseManagerEmailFormatError ="The ClientCaseManagerEmail format is incorrect.";
	public static final String ClientCoordinatorEmailFormatError ="The ClientCoordinatorEmail format is incorrect.";
	public static final String ClientGenderFormatError ="The ClientGender format is incorrect.";
	public static final String ClientMaritalStatusFormatError ="The ClientMaritalStatus format is incorrect.";
	public static final String ClientPriorityLengthError = "The ClientPriority length is invalid. The length should be between 0 and 2.";
	public static final String ClientContactAddressLine1LengthError="The ClientContactAddressLine1 length is invalid. The length should be between 0 and 30.";
	public static final String ClientContactAddressLine1LengthIncorrectError="The ClientContactAddressLine1 (Responsible Party) value is incorrect. The length should be between 1 and 30.";
	public static final String ClientContactAddressLine1FormatRegularExpressionError="The ClientContactAddressLine1 (Responsible Party) format is incorrect. The record should satisfy this regular expression";
	public static final String ClientContactAddressLine1FormatError= "The ClientContactAddressLine1 format is incorrect.";
	public static final String ClientContactAddressLine2LengthError="The ClientContactAddressLine2 length is invalid. The length should be between 0 and 30.";
	public static final String ClientContactAddressLine2LengthIncorrectError="The ClientContactAddressLine2 (Responsible Party) value is incorrect. The length should be between 1 and 30.";
	public static final String ClientContactAddressLine2FormatRegularExpressionError="The ClientContactAddressLine2 (Responsible Party) format is incorrect. The record should satisfy this regular expression";
	public static final String ClientContactAddressLine2FormatError= "The ClientContactAddressLine2 format is incorrect.";
	public static final String ClientMedicalRecordNumberLengthError ="The ClientMedicalRecordNumber length is invalid. The length should be between 0 and 12.";
	public static final String TotalVisitTimerror="ERROR: Total visit time cannot exceed 25 hours.";
	public static final String CallInCallOutError="ERROR: The Call In cannot be greater than the Call Out. The record is being rejected.";
	public static final String ClientContactFirstName="ClientContactFirstName";
	public static final String ClientContactLastName="ClientContactLastName";
	public static final String ClientContactEmailAddress="ClientContactEmailAddress";
	public static final String ClientContactAddressLine1="ClientContactAddressLine1";
	public static final String ClientContactAddressLine2="ClientContactAddressLine2";
	public static final String ClientEmaillenghtherror="The ClientEmail length is invalid.";

	public static final String filenamewithoutfull="filenamewithoutfull";

	public static final String EmployeeLastName="EmployeeLastName";
	public static final String EmployeeFirstName="EmployeeFirstName";
	public static final String EmployeeMiddleInitial="EmployeeMiddleInitial";
	public static final String Department="Department";
	public static final String EmployeeAPI="EmployeeAPI";
	public static final String EmployeeType="EmployeeType";
	public static final String Discipline="Discipline";
	public static final String EmployeeManagerEmail="EmployeeManagerEmail";
	public static final String ClientMiddleInitial="ClientMiddleInitial";
	public static final String CaseManager="CaseManager";
	public static final String ClientEmail="ClientEmail";
	public static final String ClientCaseManagerEmail="ClientCaseManagerEmail";
	public static final String ClientGender="ClientGender";
	public static final String ClientMaritalStatus="ClientMaritalStatus";
	public static final String ClientPriority="ClientPriority";
	public static final String PayerRegion="PayerRegion";
	public static final String EmployeeSSN="EmployeeSSN";
	public static final String EmployeeRegID="EmployeeRegID";
	public static final String EmployeeEmail="EmployeeEmail";
	public static final String EmployeeEmailAddress="EmployeeEmailAddress";
	public static final String EmployeePosition="EmployeePosition";
	public static final String StaffPosition="StaffPosition";
	public static final String dbProgram="PROGRAM";
	public static final String dbService="SERVICE";
	public static final String ClientCoordinatorEmail="ClientCoordinatorEmail";
	public static final String ClientContactCitylengthError_mem="The ClientContactCity length is invalid.";


	//Variables for molina pipe deliminated files

	public static final String batFileCreation=System.getProperty("user.dir")+"\\lib\\bat1.bat";
	public static final String genericfile=System.getProperty("user.dir")+ File.separator +"src" + File.separator + "test"+File.separator+ "resources"+File.separator;
	public static final String genericfileProvider=System.getProperty("user.dir")+ File.separator +"src" + File.separator + "test"+File.separator+ "resources"+File.separator+"ProviderFiles" +File.separator;
	public static final String Encryptfile =System.getProperty("user.dir")+ File.separator +"src" + File.separator + "test"+File.separator+ "resources"+File.separator+"Auth_member_setup" +File.separator + "to_encrypt"+ File.separator;
	public static final String EncryptedfileResult=System.getProperty("user.dir")+ File.separator +"src" + File.separator + "test"+File.separator+ "resources"+File.separator+"Auth_member_setup" +File.separator +"to_encrypt_result"+ File.separator;
	public static final String decryptedfileResult=System.getProperty("user.dir")+ File.separator +"src" + File.separator + "test"+File.separator+ "resources"+File.separator+"Auth_member_setup" +File.separator +"to_decrypt" +File.separator;
	public static final String decryptedfileResultTo=System.getProperty("user.dir")+ File.separator +"src" + File.separator + "test"+File.separator+ "resources"+File.separator+"Auth_member_setup" +File.separator +"to_decrypt_result" +File.separator;

	public static final String batcommandwrite="cd /d " + System.getProperty("user.dir")+"\\lib\\Auth_member_setup" + " & java -jar pgp-generate-tool-1.0.1-SNAPSHOT.jar";
	public static final String memberFtpLocation =CommonMethods.propertyfileReader("SFTPLocation_control");
	public static final String memberFtpLocationErrorControlFile =CommonMethods.propertyfileReader("SFTPLocation_inbound");
	public static final String memberGenericFileName ="MEDHHS_EVV_";
	public static final String memberGenericFileNameControlFile ="MEDHHS_EVV_";

	public static final String molinaGenericFileName ="MEDHHS_EVV_Member_20181112.csv";
	public static final String molinaGenericFile =globalVariables.genericfile+globalVariables.molinaGenericFileName;
	public static final String molinaAuthFileName ="MEDHHS_EVV_PriorAuth_20181610.csv";
	public static final String molinaAuthGenericFile =globalVariables.genericfile+globalVariables.molinaAuthFileName;
	public static final String memberAuthFileName ="MEDHHS_EVV_";
	public static final String memberProviderFileName ="MEDHHS_EVV_";
	public static final String molinaProviderFileName= "MEDHHS_EVV_Provider_20181023_154900.000_Full.csv";
	public static final String ohioproductionFileName= "ODM_Req_EVVBatch_";
	public static final String ohiosampleFileName="ODM_Req_EVVBatch_20190404_124705.451_575680063287.dsv";
	public static final String ohioouteFileName="ODM_Outbound_575680063287_Controlfile_20190404_124705.451.dsv";
	public static final String ohioproductionFileNamegenerated= "ODM_Resp_EVVBatch_";
	public static final String ohioproductionerrorfilegenerated="ODM_Error_EVVBatch";

	public static final String ohiooutboundFileNamegenerated="ODM_Outbound_";

	public static final String ohiInboundFileNamegenerated="ODM_Inbound_";

	public static final String molinaProviderGenericFile =globalVariables.genericfile+globalVariables.molinaProviderFileName;
	public static final String OhioGenericFile =globalVariables.genericfile+globalVariables.ohiosampleFileName;
	public static final String OhiooutGenericFile =globalVariables.genericfile+globalVariables.ohioouteFileName;



	//Variables for Indiana pipe deliminated files
	public static final String getOhioproviderlocation= System.getProperty("user.dir")+ File.separator +"src" + File.separator + "test"+File.separator+ "resources"+File.separator+"Ohioprovider"+File.separator;
	public static final String OhioProviderFtpLocationfull =CommonMethods.propertyfileReader("SFTPLocation_control_Ohio_full");
	public static final String OhioProviderFtpLocationSUPPLEMENTAL =CommonMethods.propertyfileReader("SFTPLocation_control_Ohio_SUPPLEMENTAL");
	public static final String OhioProviderFtpLocationcontract =CommonMethods.propertyfileReader("SFTPLocation_control_Ohio_contract");


	public static final String PAProviderFileName= "PADHS_EVV_Provider_Full.csv";
	public static final String PAProviderGenericFile =globalVariables.genericfile+globalVariables.PAProviderFileName;
	public static final String PAGenericFileFormat ="PADHS_EVV_";

	public static final String pensolvaniaFtpControlLocation =CommonMethods.propertyfileReader("SFTPPA_Control_Location");
	public static final String pensolvaniaFtpInboundLocation =CommonMethods.propertyfileReader("SFTPPA_Inbound_Location");
	public static final String OhioProviderFtpLocationspec =CommonMethods.propertyfileReader("SFTPLocation_control_Ohio_spec");
	public static final String indianaMemberFtpLocation =CommonMethods.propertyfileReader("SFTPLocation_control");
	public static final String indianaMemberFtpLocationErrorControlFile =CommonMethods.propertyfileReader("SFTPLocation_inbound");

	public static final String indianaGenericFileFormat ="Indiana_EVV_";
	public static final String indianaGenericMemberFileFormat ="Indiana_EVV_Member_";
	public static final String indianaMemberFileName ="Indiana_EVV_Member_Full.csv";
	public static final String indianaMemberGenericFile =globalVariables.genericfile+globalVariables.indianaMemberFileName;

	public static final String indianaGenericProviderFileName ="Indiana_EVV_Provider_";
	public static final String indianaProviderFileName= "Indiana_EVV_Provider_Full.csv";
	public static final String indianaProviderGenericFile =globalVariables.genericfile+globalVariables.indianaProviderFileName;

	public static final String indianaFtpControlLocation =CommonMethods.propertyfileReader("SFTPIndiana_Control_Location");
	public static final String indianaFtpInboundLocation =CommonMethods.propertyfileReader("SFTPIndiana_Inbound_Location");

	public static final String indianaReports=System.getProperty("user.dir")+ File.separator +"src" + File.separator + "test"+File.separator+ "resources"+File.separator+ "Indiana_Reports"+File.separator;
	public static final String indianaDownloadLocation =CommonMethods.propertyfileReader("Indiana_Download_Location");
	public static final String indianaUploadLocation =CommonMethods.propertyfileReader("Indiana_Upload_Location");

	public static final String scheduleUTCTime = "accountInterfaceConfigurationSchedule";
	public static final String member="Member";
	public static final String auth ="PriorAuth";
	public static final String provider ="Provider";
	public static final String ProviderDateBegin="ProviderDateBegin";
	public static final String ProviderDateEnd="ProviderDateEnd";
	public static final String ProviderDoingBusinessAs="ProviderDoingBusinessAs";
	public static final String PorviderFax="ProviderFax";




	//ErrorMessage
	public static final String memberActionNullError ="The Action cannot be null.";
	public static final String memberClientCityNullError ="The ClientCity cannot be null.";
	public static final String memberClientEligibilityDateBeginNullError ="The ClientEligibilityDateBegin cannot be null.";
	public static final String memberClientStateNullError ="The ClientState cannot be null.";
	public static final String memberClientZipNullError ="The ClientZip cannot be null.";
	public static final String memberClientCustomIDNullError ="The ClientCustomID cannot be null";
	public static final String memberAddressTypeNullError="The ClientAddressType format is incorrect. The record should satisfy this regular expression ['Business|Home|Other']";
	public static final String memberClientOtherIDNullError ="The ClientOtherID cannot be null";
	public static final String memberClientSSNNullError ="If the ClientSSN is empty then ClientOtherID must be populated";
	public static final String memberClientFirstNameNullError ="The ClientFirstName cannot be null.";
	public static final String memberMolinaMedicaid_IDNullError= "The ClientCustomID cannot be null";
	public static final String memberMolinaMedicaid_ID= "length is invalid";
	public static final String memberClientLastNameNullError ="The ClientLastName cannot be null.";

	public static final String openevvClientDatebeginerror="The ClientEligibilityDateBegin format is incorrect.";

	public static final String memberClientEligibilityDateBeginFormatError ="The ClientEligibilityDateBegin format is incorrect. The record should satisfy the date format ['yyyy-MM-dd']";

	public static final String providerSSNError ="The SSN format is incorrect.";


	/////////////////////molina globalvariables /////////////////////////////
	public static final String altevvMolinaClients = "altevv_Molina_clients";
	public static final String altevvMolinaClientsGet = "altevv_Molina_clients_get";
	public static final String altevv_accId_molina = "altevv_accId_molina";
	public static final String molinaClientId="ClientID";
	public static final String molinaClientSSN="ClientSSN";
	public static final String molinaClientFirstName="ClientFirstName";
	public static final String molinaMiddleInitial ="clientMiddleInitial";
	public static final String MolinaMedicaid_ID="ClientCustomID";

	public static final String molinaClientLastName="ClientLastName";
	public static final String molinaClientCustomID="ClientCustomID";
	public static final String molinaClientOtherID="ClientOtherID";
	public static final String molinaClientMedicalRecordNum="ClientMedicalRecordNum";
	public static final String molinaClientEmail="ClientEmail";
	public static final String ProviderAPI="ProviderAPI";
	public static final String ProviderNPI="ProviderNPI";
	public static final String ProviderFax="ProviderFax";
	public static final String SSN="SSN";
	public static final String TaxID="TaxID";
	public static final String molinaAction="Action";
	public static final String molinaclientAddressType="clientAddressType";
	public static final String molinaclientAddressLine1="clientAddressLine1";
	public static final String molinaclientCity="clientCity";
	public static final String molinaclientState="clientState";
	public static final String molinaclientZip="clientZip";
	public static final String molinaclientEligibilityDateBegin="clientEligibilityDateBegin";
	public static final String molinaProviderQualifier="providerQualifier";
	public static final String memberClientLastNameLengthError="The ClientLastName length is invalid. The length should be between 0 and 30.";

	public static final String memberClientLastNameNotNull ="The PrimaryContactLastName cannot be null nor empty";
	public static final String memberClientLastNameNotNull1 ="The ClientLastName cannot be null";
	public static final String memberAddressCityNotNull ="ERROR: The AddressCity cannot be null.";
	public static final String memberAgencyPhone = "ERROR: The AgencyPhone format is incorrect.";
	public static final String memberAgencyphoneNull ="ERROR: The AgencyPhone cannot be null";
	public static final String exactMathcRuleError="It must be one of these three values (ExactMatch EqualOrGreaterThan ExcludeUnits).";
	public static final String noVisitError="No Visit Found";
	public static final String truResponse="true";
	public static final String providerTaxonomyerror="Failed import to EVV";
	public static final String invalidunit="It must be a decimal value less than 100000.";
	public static final String dateformateerror="It must be in yyyy-mm-dd format.";



	public static final String clientaddresssegment="The ClientAddressLongitude cannot be null.|The ClientCity cannot be null.|The ClientZip cannot be null.|The ClientAddressLine1 cannot be null.|The ClientAddressIsPrimary cannot be null.|The ClientAddressType cannot be null.|The ClientState cannot be null.|The ClientAddressLatitude cannot be null.";
	public static final String ClientAddressIsPrimaryError = "The ClientAddressIsPrimary format is incorrect. The record should satisfy this regular expression";
	public static final String ClientAddressIsPrimaryLengthError = "The ClientAddressIsPrimary format is incorrect.";
	public static final String ClientAddressIsPrimaryNullError = "The ClientAddressIsPrimary cannot be null.";
	public static final String ClientPhoneNumber= "ClientPhoneNumber";
	public static final String Service="PayerService";
	public static final String Program="PayerProgram";
	public static final String Modifier1="Modifier1";
	public static final String Modifier2="Modifier2";
	public static final String Modifier3="Modifier3";
	public static final String Modifier4="Modifier4";
	public static final String AssessmentDate="AssessmentDate";
	public static final String ServiceAuthorizedDate="ServiceAuthorizedDate";
	public static final String businnesmedicaidid="BusinessEntityMedicaidIdentifier";
	public static final String RequestType="RequestType";
	public static final String batchid= "BatchID";
	public static final String provideridohio="providerid";
	public static final String icnnumber="ICN";
	public static final String processFileName="FileName";
	public static final String RecordCount="RecordCount";
	public static final String StartDateTime="StartDateTime";
	public static final String EndDateTime="EndDateTime";
	public static final String Hash="Hash";
	public static final String dlnnumber="DLN";
	public static final String transactionid="TransactionID";
	public static final String payer="Payer";
	public static final String Units="Units";
	public static final String UnitsRule="UnitsRule";
	public static final String MatchingRule="MatchingRule";
	public static final String PatientQualifier="PatientQualifier";
	public static final String PatientID="PatientID";
	public static final String ServiceStartDate="ServiceStartDate";
	public static final String ServiceEndDate="ServiceEndDate";
	public static final String providertaxonomy="ProviderTaxonomy";
	public static final String PrimaryContactFirstName="PrimaryContactFirstName";
	public static final String ProviderMedicaidID="ProviderMedicaidID";
	public static final String providerID="ProviderID";
	public static final String molinaproviderId="providerId";
	public static final String molinaprovider1FirstName="PrimaryContactFirstName";
	public static final String molinaprovider1LastName="PrimaryContactLastName";
	public static final String molinaproviderEmail="AgencyEmail";
	public static final String ClientSuffixFormatError= "The ClientSuffix format is incorrect.";
	public static final String ClientEmailAddress="ClientEmailAddress";
	public static final String ClientEmailAddressLengthError="The ClientEmailAddress length is invalid.";
	public static final String ClientEmailAddressFormatError="The ClientEmailAddress format is incorrect.";
	public static final String ClientIDLengthError_mem= "The ClientID value is incorrect. The length should be between 0 and 10";
	public static final String ThreeP_patientJson ="patient";
	public static final String Ohio_patientJson_v1 = "patient_v1";
	public static final String patientIntake_v2 = "patientIntake_v2";
	public static final String Auth_json ="auth";
	public static final String AuthorizationEndDateformateerror = "The AuthorizationEndDate format is incorrect";
	public static final String AuthorizationStartDateformateerror = "The AuthorizationStartDate format is incorrect";
	public static final String AuthorizationStartDateformateerrornull ="ERROR: The AuthorizationStartDate format is incorrect";
	public static final String AuthorizationSharedeformaterror="The AuthorizationShared format is incorrect.";

	public static final String ThreeP_patientJson_withoutphone ="patient_without_phone";
	public static final String ProviderName="ProviderName";
	public static final String ProviderNamenew="ProviderName";

	public static final String ThreeP_Staff_Json="worker";
	public static final String Ohio_employee_Json= "worker_v2";
	public static final String ThreeP_visit_Json="visits";
	public static final String Ohio_visit_v2_json="visits_v2";

	public static final String ohio_visit_v2_get= "ohio_visit_get_v2";
	public static final String restclaim="restclaim_v2";

	public static final String staffotherid_visit= "The StaffOtherID cannot be null.  Record is being inserted into the database with an unknown staff";
	public static final String StaffSSNFormatError = "The EmployeeSSN format is incorrect.";
	public static final String StaffSSNnullError = "The EmployeeSSN cannot be NULL.";
	public static final String StaffFirstNameFormatError="The EmployeeFirstName format is incorrect.";
	public static final String StaffLastNameFormatError="The EmployeeLastName format is incorrect.";
	public static final String StaffFirstNameNullError="The EmployeeFirstName cannot be NULL.";
	public static final String StaffLastNameNullError="The EmployeeLastName cannot be NULL.";
	public static final String StaffOtherIDFormatError="The EmployeeOtherID value is greater than 64 characters.";
	public static final String StaffOtherIDLengthError="The EmployeeOtherID value is greater than 64 characters. The length should be between 1 and 64. The record is being rejected.";
	public static final String SequenceIDFormatError="The SequenceID format is incorrect.";
	public static final String EmployeeIdentifierFormatError="The EmployeeIdentifier expected format is not correct.";
	public static final String StaffIDFormatErrorMolina="The EmployeeIdentifier format is incorrect.";
	public static final String StaffIDNullError="The EmployeeIdentifier cannot be NULL.";
	public static final String StaffEmailNullError="The EmployeeEmail cannot be NULL.";
	public static final String StaffEmailFormatError="The EmployeeEmail expected format is not correct";
	public static final String StaffEmailLengthError= "The EmployeeEmail value exceeds the maximum length";
    public static final String EmployeeEmailAddressFormatError = "The EmployeeEmailAddress expected format is not correct.";
    public static final String EmployeeEmailAddressLengthError = "The EmployeeEmailAddress value exceeds the maximum length of 50 characters.";
	public static final String EmployeeManagerEmailFormatError="The EmployeeManagerEmail expected format is not correct.";
	public static final String EmployeeManagerEmailLengthError="The EmployeeManagerEmail value is incorrect. The length should be";
	public static final String client_intake_v1 = "client_intake_v1";
	public static final String clientphone_formaterror= "The ClientPhoneNumber format is incorrect. The record should satisfy this regular expression";
	public static final String ClientPayerID= "ClientPayerID";
	public static final String Client_Payer_Informationemptyerror = "The ClientPayerInformation cannot not be empty.";
	public static final String ClientPayerID_MaxLength_Error = "The ClientPayerID value is incorrect. The length should be between 1 and 20";


	public static CharSequence businessentitybadrequesterror ="fddgrdtre";
	public static CharSequence businessentityformaterror="The account ID (BusinessEntityID) for some of input records is invalid.";
	public static CharSequence businessentitymedicatedformaterror="The BusinessEntityMedicaidID does not match with provider ID. Please check and try again";
	public static CharSequence businessentitynullerror= "The account ID (BusinessEntityID) for some of input records is invalid. Please check and try again.";
	public static CharSequence businessmedicatednullerror="The BusinessEntityMedicaidID does not match with provider ID. Please check and try again.";

	public static final String patientotherlengtherror="The PatientOtherID format is incorrect. It should be between 1 and 64 characters.";
	public static final String patientotherformaterror="The PatientOtherID value exceeds the maximum length of 64 characters. The record is being rejected. The length should be between 1 and 64.";
	public static final String patientothernullerror="The PatientOtherID is null. The record is being rejected.";

	public static final String patientmedicatiderror="Client not found";
	public static final String patientmedicatidlengtherror="The PatientMedicaidID format is incorrect. The record is being rejected. It should be 12 digits";
	public static final String patientmedicatidlengtherror_Generic = "A valid 12-digit PatientMedicaidID is required when the patient is not a new born";
	public static final String patientmedicaidIDerror= "The PatientMedicaidID  cannot be null. The record is being rejected.";
	public static final String patientmedicatiderrorcode_incaseless_more_than12= "-782";
	public static final String patientmedicatiderrormessage_incaseless_more_than12= "The value does not meet the validation pattern. The value is truncated if it exceeds max length, and the truncated value or the original value (less than minimum required length) is inserted into database.";
	public static final String patientAddressTypeerror= "The PatientAddressType is not one of the valid values (Business, Home, School, Other).";

	public static final String patientalternateidlengtherror="The PatientAlternateID format is incorrect. It should be 7 digits only.";
	public static final String PatientLastNamenullerror="The PatientLastName cannot be null";
	public static final String PatientLastNameformaterror="The PatientLastName format is incorrect.";
	public static final String PatientLastNamelengtherror="The PatientLastName value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static final String PatientAddressLine1error="The PatientAddressLine1 value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static final String PatientFirstNamenullerror="The PatientFirstName cannot be null";

	public static final String PatientFirstNameformaterror="The PatientFirstName format is incorrect.";
	public static final String PatientFirstNamelengtherror = "The PatientFirstName value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static final String PatientTimeZonenullerror = "The PatientTimezone cannot be null.";
	public static final String PatientTimeZonelengtherror = "The PatientTimezone format is incorrect. It should be one of the valid values.";
	public static final String PatientTimeZoneformaterror = "The PatientTimezone format is incorrect.";
	public static final String PatientZiperror = "The PatientZip format is incorrect.";
	public static final String PatientZipnullerror = "The PatientZip cannot be null.";
	public static final String Patientstatecodeerror = "The patient State Code";
	public static final String Patientstatecodeenullrror = "The PatientState cannot be null.";
	public static final String Patientcitynullrror = "The PatientCity cannot be null.";
	public static final String truncatedrecorderror = "Truncated record inserted into the database.";
	public static final String PatientAddressLine1nullrror = "The PatientAddressLine1 cannot be null.";
	public static final String PatientAddressLine1lengthrror = "The PatientAddressLine1 value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static final String PatientAddressline1formaterror = "The PatientAddressLine1 format is incorrect.";
	public static final String PatientAddressLine1formaterror = "The PatientAddressLine1 format is incorrect.";
	public static final String PatientAddressLine2lengtherror = "The PatientAddressLine2 value will be truncated to 30 characters. The length should be between 1 and 30.";
	public static final String EmployeePinformat = "The EmployeePIN expected format is not correct. The record should satisfy this regular expression";
	public static final String PatientAddressLine2formaterror = "The PatientAddressLine2 format is incorrect. It should be between 1 and 30 characters.";
	public static final String SequenceIDDuplicateError = "Version number is duplicated or older than current";
	public static final String VisitOtherIDDuplicatedError = "The VisitOtherID cannot be duplicated in list.";
	public static final String AuthAuthorizationAmountTypeNullOrEmptyError = "The AuthorizationAmountType cannot be null nor empty";
	public static final String AuthAuthorizationAmountTypeNullError = "The AuthorizationAmountType cannot be null nor empty";
	public static final String AuthauthorizationWeekStartNullError = "The AuthorizationWeekStart format is incorrect. The record should satisfy this regular expression";

	public static final String AuthorizationLimitDayOfWeekNullError = "The AuthorizationLimitDayOfWeek format is incorrect. The record should satisfy this regular expression";
	public static final String AuthorizationLimitEndTimeError = "AuthorizationLimitEndTime optional if AuthorizationLimitType is S or D";


	public static final String EmployeeCustomID = "EmployeeCustomID";
	public static final String CLIENTCUSTOMIDERROR = "The ClientCustomID value is incorrect";
	public static final String BranchlengthError = "The Branch value is incorrect";
	public static final String ContractlengthError = "The Contract value is incorrect";
	public static final String ProcCodeQualifierlengthError = "The ProcCodeQualifier value is incorrect.";
	public static final String ProcCodeQualifiernullError = "The ProcCodeQualifier cannot be empty.";
	public static final String ProcedureCodevalueError = "The ProcedureCode value is incorrect.";
	public static final String ServicelengthError = "The Service value is incorrect";
	public static final String Disciplineerror = "The Discipline value is incorrect.";
	public static final String Weekendformateerror = "The Weekend format is incorrect.";
	public static final String ARNumberformaterror = "The ARNumber format is incorrect.";
	public static final String Modifier2lengtherror = "The Modifier2 length is invalid";
	public static final String ARNumberlengtherror = "The ARNumber value is incorrect";
	public static final String BillRatelengtherror = "The BillRate value is incorrect";
	public static final String PayRatelengtherror="The PayRate value is incorrect";
	public static final String schedule_json="Schedule";
	public static final String DutyFreeformaterror="The DutyFree value is incorrect.";
	public static final String DutyFreenullerror="The DutyFree cannot be empty.";
	public static final String ScheduleFlagformaterror="The ScheduleFlag format is incorrect.";
	public static final String ScheduleIDformaterror="The ScheduleID value is incorrect.";
	public static final String ScheduleIDlengtherror="The length should be between 1 and 40.";
	public static final String ScheduleIDemptyerror="The ScheduleID cannot be empty.";
	public static final String ScheduleIDerror="The ScheduleID format is incorrect.";

	public static final String ClientTimeZoneformaterror="The ClientTimeZone format is incorrect.";
	public static final String Scheduleendtimeerror="The ScheduleEndTime format is incorrect.";
	public static final String Schedulestarttimeerror="The ScheduleStartTime format is incorrect.";
	public static final String Scheduleendstarterror="The ScheduleStartTime must always be less than the ScheduleEndTime.";
	public static final String Accountnullerror="The Account cannot be null.";
	public static final String Accountformaterror="The Account value is incorrect";
	public static final String LiveInCaseFormatError ="The LiveInCase format is incorrect.";
	public static final String StatusFormatError ="The Status format is incorrect.";
	public static final String VisitTypelengthError ="The VisitType value is incorrect";
	public static final String EmployeePINQualifierformaterror="The EmployeePINQualifier format is incorrect.";
	public static final String EmployeePINQualifierformaterrorNull = "ERROR: The EmployeePINQualifier cannot be null.";
	public static final String PayerID2="PayerID2";
	public static final String invalidrecord= "Incorrectly formatted record.";
	public static final String falseVisit = "false";
	public static final String recordFound = "\"RecordsFound\":\"1\",";
	public static final String nullservicestartdate = "\"ServiceStartDate\": null";
	public static final String nullserviceenddate = "\"ServiceEndDate\": null";
	public static final String recordFoundblank = "\"RecordsFound\": \"1\",";
	public static final String noVisitFound = "\"Details\": \"No Visit Found\"";
	public static final String InvlaidRequesttypeerror = "It must be one of these three values (Model1 Model2 Model3).";
	public static final String invalidunits = "It must be a decimal value less than 100000.";
	public static final String invalidbatchrecord = "Incorrectly formatted batch";
	public static final String invalidMaxlengthBatchID = "It must be less than 50 characters.";
	public static final String invalidmatchingrulerecord = "It must be one of these three values (ExactMatch EqualOrGreaterThan ExcludeUnits).";
	public static final String nullmatchingrulerecord = "MatchingRule is NULL";
	public static final String nullunitrulerecord = "UnitsRule is NULL";
	public static final String modifierinvalid = "It must be a alphanumeric value with length of two.";
	public static final String invalidEnddate = "Incorrectly formatted record. ServiceEndDate";
	public static final String invalidgapdate = "is greater than 31 days.";
	public static final String invalidunitrulerecord = "It must be one of these two values (AddUnits AddTime).";
	public static final String Dlnerrorrecord = "It must be a positive number up to 99.";
	public static final String ICNerrorrecord = "It must be a string with a maximum length of 13, which will be increased to 25 in 8.1.14 release.";
	public static final String EmployeeIDCustom2MaxLengthError = "";
	public static final String EmployeeIDCustom2 = "EmployeeIDCustom2";

	public static final String AuthorizationPayerRegion = "ERROR: The PayerRegion value is incorrect. The value length must be in range 0 - 2.";
	public static final String Auth_ClientDiagnosisCodeIsPrimary = "The ClientDiagnosisCodeIsPrimary format is incorrect.";
	public static final String Auth_ClientDiagnosisCode = "The ClientDiagnosisCode value is incorrect. The max length should be 10.";

	public static final String molinaAuthFileNameSegment = "MEDDHS_EVV_PriorAuth_Segment.csv";
	public static final String molinaAuthGenericFileSegment = globalVariables.genericfile + globalVariables.molinaAuthFileNameSegment;
	public static final String memberFtpLocationSegment = CommonMethods.propertyfileReader("SFTPPA_Control_Location");
	public static final String memberFtpLocationErrorControlFileSegment = CommonMethods.propertyfileReader("SFTPPA_Inbound_Location");
	public static final String PayerRegionAuth = "payerRegion";
	public static final String AuthorizationMaximum_Length = "The AuthorizationMaximum format is incorrect. The record should satisfy this regular expression ";
	public static final String AuthorizationMaximumAuth = "authorizationMaximum";
	public static final String ClientIdentifierAuthError = "The ClientIdentifier value is incorrect. The value length must be in range 0 - 64.";
	public static final String EmployeeIDCustom1MaxLengthError = "The EmployeeIDCustom1 value exceeds the maximum length of 64 characters";
	public static final String EmployeeIDCustom1FormatError = "The EmployeeIDCustom1 expected format is not correct.";
	public static final String EmployeeIDCustom2FormatError = "The EmployeeIDCustom2 expected format is not correct";

	public static final String status_evv_client = "evv_client_status";
	public static final String status_evv_xref = "evv_xref_status";
	public static final String status_evv_provider = "evv_provider_status";
	public static final String status_evv_members="evv_members_status";
	public static final String status_evv_employees_evv="evv_employees_evv";
	public static final String status_rest_employees="rest_employees_status";
	public static final String status_rest_clients="rest_clients_status";
	public static final String status_rest_visits="rest_visits_status";
	public static final String status_rest_auths="rest_auths_status";
	public static final String status_rest_employees_v1="rest_employees_status_v1";
	public static final String status_rest_clients_v1="rest_clients_status_v1";
	public static final String status_rest_visits_v1="rest_visits_status_v1";

	public static final String user = "user";
	public static final String pass = "pass";
	public static final String entityUser = "entityUser";
	public static final String entityPass = "entityPass";

    public static final String userClaim = "claimUser";
    public static final String passClaim = "claimPass";
    public static final String EntityGuid = "entityGuid";

    public static final String ACCID = "accId";
    public static final String ENTITYGUID = "EntityGuid";
    public static final String ID = "id";
    public static final String CONTENTTYPE = "Content-Type";
    public static final String APPLICATIONJSON = "application/json";

    /////////////////////Ohio_Claim_Validation_V2_ErrorMessage /////////////////////////////
    public static final String ClaimValidationBusinessMedicaidIdentifierError = "Incorrectly formatted record";

    public static final String[] CLIENTSTATE = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN",
            "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
            "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
}
