package com.sandata.models.importModel.Member;

public class MemberIndianaModel extends MemberModel {

    public String ClientID = "";
    public String ClientFirstName = "";
    public String ClientMiddleInitial = "";
    public String ClientLastName = "";
    public String ClientSSN = "";
    public String ClientMedicalRecordNum = "";
    public String MissingMedicaidID = "";
    public String ClientCustomID = "";
    public String ClientOtherID = "";
    public String ClientSuffix = "";
    public String Action = "";
    public String PayerID = "";
    public String PayerProgram = "";
    public String PayerService = "";
    public String PayerRegion = "";
    public String ProviderQualifier = "";
    public String ProviderID = "";
    public String CaseManager = "";
    public String ClientCaseManager = "";
    public String clientCoordinatorEmail = "";
    public String ClientLanguage = "";
    public String ClientGender = "";
    public String ClientMaritalStatus = "";
    public String ClientBirthDate = "";
    public String ClientEmail = "";
    public String ClientPriority = "";
    public String ClientTimeZone = "";
    public String ClientContactType = "";
    public String ClientAddressType = "";
    public String ClientAddressLine1 = "";
    public String ClientAddressLine2 = "";
    public String ClientCounty = "";
    public String ClientCity = "";
    public String ClientState = "";
    public String ClientZip = "";
    public String ClientPhoneType = "";
    public String ClientPhone = "";
    public String EligibilityPayerID = "";
    public String EligibilityPayerProgram = "";
    public String ClientEligibilityDateBegin = "";
    public String ClientEligibilityDateEnd = "";
    public String ClientStartOfCareDate = "";
    public String ClientEndOfCareDate = "";
    public String ClientPrimaryDiagnosisCode = "";
    public String ClientSecondaryDiagnosisCode = "";
    public String ClientStatus = "";
    public String ClientStatusDate = "";




    @Override
    public String toLine() {
        return "\"" + ClientID + "\"" + "|" +
                "\"" + ClientFirstName + "\"" + "|" +
                "\"" + ClientMiddleInitial + "\"" + "|" +
                "\"" + ClientLastName + "\"" + "|" +
                "\"" + ClientSSN + "\"" + "|" +
                "\"" + ClientMedicalRecordNum + "\"" + "|" +
                "\"" + MissingMedicaidID + "\"" + "|" +
                "\"" + ClientCustomID + "\"" + "|" +
                "\"" + ClientOtherID + "\"" + "|" +
                "\"" + ClientSuffix + "\"" + "|" +
                "\"" + Action + "\"" + "|" +
                "\"" + PayerID + "\"" + "|" +
                "\"" + PayerProgram + "\"" + "|" +
                "\"" + PayerService + "\"" + "|" +
                "\"" + PayerRegion + "\"" + "|" +
                "\"" + ProviderQualifier + "\"" + "|" +
                "\"" + ProviderID + "\"" + "|" +
                "\"" + CaseManager + "\"" + "|" +
                "\"" + ClientCaseManager + "\"" + "|" +
                "\"" + clientCoordinatorEmail + "\"" + "|" +
                "\"" + ClientLanguage + "\"" + "|" +
                "\"" + ClientGender + "\"" + "|" +
                "\"" + ClientMaritalStatus + "\"" + "|" +
                "\"" + ClientBirthDate + "\"" + "|" +
                "\"" + ClientEmail + "\"" + "|" +
                "\"" + ClientPriority + "\"" + "|" +
                "\"" + ClientTimeZone + "\"" + "|" +
                "\"" + ClientContactType + "\"" + "|" +
                "\"" + ClientAddressType + "\"" + "|" +
                "\"" + ClientAddressLine1 + "\"" + "|" +
                "\"" + ClientAddressLine2 + "\"" + "|" +
                "\"" + ClientCounty + "\"" + "|" +
                "\"" + ClientCity + "\"" + "|" +
                "\"" + ClientState + "\"" + "|" +
                "\"" + ClientZip + "\"" + "|" +
                "\"" + ClientPhoneType + "\"" + "|" +
                "\"" + ClientPhone + "\"" + "|" +
                "\"" + EligibilityPayerID + "\"" + "|" +
                "\"" + EligibilityPayerProgram + "\"" + "|" +
                "\"" + ClientEligibilityDateBegin + "\"" + "|" +
                "\"" + ClientEligibilityDateEnd + "\"" + "|" +
                "\"" + ClientStartOfCareDate + "\"" + "|" +
                "\"" + ClientEndOfCareDate + "\"" + "|" +
                "\"" + ClientPrimaryDiagnosisCode + "\"" + "|" +
                "\"" + ClientSecondaryDiagnosisCode + "\"" + "|" +
                "\"" + ClientStatus + "\"" + "|" +
                "\"" + ClientStatusDate + "\"";
    }
}
