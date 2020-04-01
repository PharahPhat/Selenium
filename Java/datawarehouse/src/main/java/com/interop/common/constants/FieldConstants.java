package com.interop.common.constants;

public class FieldConstants {

    public static final int MAX_TIME_ATTEMPT = 50;

    public static final String SUCCESS_STATUS = "SUCCESS";
    /**
     * FIELDS_OF_MODELS_CLAIM_CSV_MODELS
     */
    public static final String BUSINESS_ENTITY_MEDICAID_IDENTIFIER = "BusinessEntityMedicaidIdentifier";
    public static final String REQUEST_TYPE = "RequestType";
    public static final String BATCH_ID = "BatchID";
    public static final String TRANSACTION_ID = "TransactionID";
    public static final String PAYER = "Payer";
    public static final String ICN = "ICN";
    public static final String DLN = "DLN";
    public static final String PROVIDER_QUALIFIER = "ProviderQualifier";
    public static final String PROVIDER_ID = "ProviderID";
    public static final String PATIENT_QUALIFIER = "PatientQualifier";
    public static final String PATIENT_ID = "PatientID";
    public static final String SERVICE_START_DATE = "ServiceStartDate";
    public static final String SERVICE_END_DATE = "ServiceEndDate";
    public static final String PROCEDURE_CODE = "ProcedureCode";
    public static final String UNITS = "Units";
    public static final String UNITS_RULE = "UnitsRule";
    public static final String MODIFIER_1 = "Modifier1";
    public static final String MODIFIER_2 = "Modifier2";
    public static final String MODIFIER_3 = "Modifier3";
    public static final String MODIFIER_4 = "Modifier4";
    public static final String MATCHING_RULE = "MatchingRule";
    public static final String EXPECTED_ERROR = "ExpectedError";


    /**
     * FIELDS_OF_CSV_AUTH_MODEL
     */
    public static final String PAYER_ID = "PayerID";
    public static final String PAYER_PROGRAM = "PayerProgram";
    public static final String AUTHORIZATION_SERVICE_ID = "authorizationServiceID";
    public static final String AUTHORIZATION_BILLING_TYPE = "authorizationBillingType";
    public static final String AUTHORIZATION_LIMIT = "authorizationLimit";
    public static final String AUTHORIZATION_WEEK_START = "authorizationWeekStart";
    public static final String AUTHORIZATION_LIMIT_DAY_OF_WEEK = "authorizationLimitDayOfWeek";
    public static final String AUTHORIZATION_LIMIT_START_TIME = "authorizationLimitStartTime";
    public static final String AUTHORIZATION_LIMIT_END_TIME = "authorizationLimitEndTime";
    public static final String AUTHORIZATION_LIMIT_TYPE = "authorizationLimitType";
    public static final String AUTHORIZATION_STATUS = "authorizationStatus";
    public static final String SEGMENT_NAME = "SegmentName";
    public static final String PAYER_REGION = "PayerRegion";
    public static final String CLIENT_QUALIFIER = "ClientQualifier";
    public static final String CLIENT_IDENTIFIER = "ClientIdentifier";
    public static final String AUTHORIZATION_REFERENCE_NUMBER = "AuthorizationReferenceNumber";
    public static final String AUTHORIZATION_AMOUNT_TYPE = "authorizationAmountType";
    public static final String AUTHORIZATION_MAXIMUM = "authorizationMaximum";
    public static final String AUTHORIZATION_START_DATE = "authorizationStartDate";
    public static final String AUTHORIZATION_END_DATE = "authorizationEndDate";
    public static final String AUTHORIZATION_SHARED = "authorizationShared";
    public static final String AUTHORIZATION_COMMENTS = "authorizationComments";
    public static final String CLIENT_DIAGNOSIS_CODE_IS_PRIMARY = "clientDiagnosisCodeIsPrimary";
    public static final String CLIENT_DIAGNOSIS_CODE = "clientDiagnosisCode";
    public static final String CLIENT_DIAGNOSIS_CODE_BEGIN_DATE = "clientDiagnosisCodeBeginDate";
    public static final String CLIENT_DIAGNOSIS_CODE_END_DATE = "clientDiagnosisCodeEndDate";
    public static final String ASSESSMENT_DATE = "AssessmentDate";
    public static final String SERVICE_AUTHORIZED_DATE = "ServiceAuthorizedDate";
    public static final String ERROR_DESCRIPTION = "ErrorDescription";

    /**
     * FIELDS_OF_CSV_MEMBER_MODELS
     */
    public static final String CLIENTID = "ClientID";
    public static final String CLIENT_FIRST_NAME = "ClientFirstName";
    public static final String CLIENT_MIDDLE_INITIAL = "ClientMiddleInitial";
    public static final String CLIENT_LAST_NAME = "ClientLastName";
    public static final String CLIENT_CUSTOM_ID = "ClientCustomID";
    public static final String CLIENT_OTHER_ID = "ClientOtherID";
    public static final String ACTION = "Action";
    public static final String CLIENT_LANGUAGE = "ClientLanguage";
    public static final String CLIENT_GENDER = "ClientGender";
    public static final String CLIENT_TIMEZONE = "ClientTimeZone";
    public static final String CLIENT_ADDRESS_TYPE = "ClientAddressType";
    public static final String CLIENT_ADDRESS_LINE_1 = "ClientAddressLine1";
    public static final String CLIENT_ADDRESS_LINE_2 = "ClientAddressLine2";
    public static final String CLIENT_CITY = "ClientCity";
    public static final String CLIENT_STATE = "ClientState";
    public static final String CLIENT_ZIP = "ClientZip";
    public static final String CLIENT_PHONE_TYPE = "ClientPhoneType";
    public static final String CLIENT_PHONE = "ClientPhone";
    public static final String CLIENT_CONTACT_TYPE = "ClientContactType";
    public static final String CLIENT_CONTACT_FIRST_NAME = "ClientContactFirstName";
    public static final String CLIENT_CONTACT_LAST_NAME = "ClientContactLastName";
    public static final String CLIENT_CONTACT_PHONE_TYPE = "ClientContactPhoneType";
    public static final String CLIENT_CONTACT_PHONE = "ClientContactPhone";
    public static final String CLIENT_CONTACT_EMAIL_ADDRESS = "ClientContactEmailAddress";
    public static final String CLIENT_CONTACT_ADDRESS_LINE_1 = "ClientContactAddressLine1";
    public static final String CLIENT_CONTACT_ADDRESS_LINE_2 = "ClientContactAddressLine2";
    public static final String CLIENT_CONTACT_CITY = "ClientContactCity";
    public static final String CLIENT_CONTACT_STATE = "ClientContactState";
    public static final String CLIENT_CONTACT_ZIP = "ClientContactZip";
    public static final String CLIENT_DESIGNEE_FIRST_NAME = "ClientDesigneeFirstName";
    public static final String CLIENT_DESIGNEE_LAST_NAME = "ClientDesigneeLastName";
    public static final String CLIENT_DESIGNEE_EMAIL = "ClientDesigneeEmail";
    public static final String CLIENT_DESIGNEE_STATUS = "ClientDesigneeStatus";
    public static final String CLIENT_DESIGNEE_START_DATE = "ClientDesigneeStartDate";
    public static final String CLIENT_DESIGNEE_END_DATE = "ClientDesigneeEndDate";
    public static final String PAYER_SERVICE = "PayerService";
    public static final String CLIENT_ELIGIBILITY_DATE_BEGIN = "ClientEligibilityDateBegin";
    public static final String CLIENT_ELIGIBILITY_DATE_END = "ClientEligibilityDateEnd";
    public static final String CLIENT_START_OF_CARE_DATE = "ClientStartofCareDate";
    public static final String CLIENT_END_OF_CARE_DATE = "ClientEndofCareDate";
    public static final String CLIENT_SSN = "ClientSSN";
    public static final String CLIENT_SUFFIX = "ClientSuffix";
    public static final String CLIENT_MARITAL_STATUS = "ClientMaritalStatus";
    public static final String CLIENT_BIRTH_DATE = "ClientBirthDate";
    public static final String CLIENT_EMAIL = "ClientEmail";
    public static final String MEMBER_ENROLLMENT_DATE = "MemberEnrollmentDate";
    public static final String CLIENT_COUNTY = "ClientCounty";
    public static final String CLIENT_PRIMARY_DIAGNOSIS_CODE = "ClientPrimaryDiagnosisCode";
    public static final String CLIENT_SECONDARY_DIAGNOSIS_CODE = "ClientSecondaryDiagnosisCode";
    public static final String CLIENT_STATUS = "ClientStatus";
    public static final String CLIENT_STATUS_DATE = "ClientStatusDate";
    public static final String MEDICAID_ID = "MedicaidID";

    /**
     * FIELDS NAME_CSV_PROVIDER_MODELS
     */
    public static final String PROVIDER_NAME = "ProviderName";
    public static final String PROVIDER_DOING_BUSINESS_AS = "ProviderDoingBusinessAs";
    public static final String ADDRESS_LINE_1 = "AddressLine1";
    public static final String ADDRESS_LINE_2 = "AddressLine2";
    public static final String ADDRESS_CITY = "AddressCity";
    public static final String ADDRESS_STATE = "AddressState";
    public static final String COUNTY = "County";
    public static final String ADDRESS_ZIP = "AddressZip";
    public static final String AGENCY_PHONE = "AgencyPhone";
    public static final String AGENCY_EMAIL = "AgencyEmail";
    public static final String PRIMARY_CONTACT_LAST_NAME = "PrimaryContactLastName";
    public static final String PRIMARY_CONTACT_FIRST_NAME = "PrimaryContactFirstName";
    public static final String PROVIDER_FAX = "ProviderFax";
    public static final String PROVIDER_NPI = "ProviderNPI";
    public static final String PROVIDER_API = "ProviderAPI";
    public static final String PROVIDER_MEDICAID_ID = "ProviderMedicaidID";
    public static final String SSN = "SSN";
    public static final String TAX_ID = "TaxID";
    public static final String PROVIDER_TAXONOMY = "ProviderTaxonomy";
    public static final String PROVIDER_REQUIRE_AUTH = "ProviderRequireAuth";
    public static final String PROVIDER_DATE_BEGIN = "ProviderDateBegin";
    public static final String PROVIDER_DATE_END = "ProviderDateEnd";
    public static final String SUSPENSION_DATE = "SuspensionDate";
    public static final String WEBUSERNAME_KEY = "WebUsername";
    public static final String WEBMK_KEY = "WebPassword";
    public static final String EMPTY_VALUE = "     ";
    public static final String LOC = "LOC";

    /**
     * FIELDS NAME VISIT DOWNLOAD MODELS
     */
    public static final String EMPLOYEEPIN = "EmployeePIN";
    public static final String STARTTIME = "StartTime";
    public static final String ENDTIME = "EndTime";
    public static final String PROCEDURECODE = "ProcedureCode";
    public static final String PAYERPROGRAM = "PayerProgram";
    public static final String STARTTYPE = "StartType";
    public static final String ENDTYPE = "EndType";
    public static final String VISITID = "VisitID";
    public static final String VISITLOCATIONTYPE = "VisitLocationType";
    public static final String ACTIVEDATE = "ActiveDate";
    public static final String ACTIVEENDDATE = "ActiveEndDate";
    public static final String TASKID = "TaskID";


    /**
     * FIELDS NAME DB
     */
    public static final String CLIENT_CUSTOM_ID1 = "CLIENT_ID_CUSTOM1";
    public static final String CLIENT_CUSTOM_ID2 = "CLIENT_ID_CUSTOM2";
    public static final String CLIENT_ID = "CLIENT_ID";
    public static final String EMPLOYEEIDENTIFIER = "EMPLOYEEIDENTIFIER";


    /**
     * FIELD NAME WORKER SERVICE
     */
    public static final String EMPLOYEE_CUSTOM_ID = "EmployeeCustomID";
    public static final String WORKER_CUSTOM_ID1 = "WORKER_ID_CUSTOM1";
    public static final String WORKER_SSN = "WORKER_SSN";

    public enum VisitStatus {
        PROCESSED("Processed"),
        INCOMPLETE("Incomplete"),
        VERIFIED("Verified");
        private String status;

        VisitStatus(String visitStatus) {
            this.status = visitStatus;
        }

        public String getStatus() {
            return this.status;
        }
    }

    public enum VisitFoundValue {
        TRUE("true"),
        FALSE("false");
        private String valueVisitFound;

        VisitFoundValue(String valueVisitFound) {
            this.valueVisitFound = valueVisitFound;
        }

        public String getValueVisitFound() {
            return this.valueVisitFound;
        }
    }

    public enum MatchingRule {
        EQUAL_OR_GREATER_THAN("EqualOrGreaterThan"),
        EXCLUDE_UNITS("ExcludeUnits"),
        EXACT_MATCH("ExactMatch");
        private String getMatchingRuleValue;

        MatchingRule(String getMatchingRuleValue) {
            this.getMatchingRuleValue = getMatchingRuleValue;
        }

        public String getGetMatchingRuleValue() {
            return this.getMatchingRuleValue;
        }
    }

    public enum ModelType {
        MODEL1("Model1"),
        MODEL2("Model2"),
        MODEL3("Model3");

        private String model;

        ModelType(String model) {
            this.model = model;
        }

        public String getModel() {
            return this.model;
        }
    }
}
