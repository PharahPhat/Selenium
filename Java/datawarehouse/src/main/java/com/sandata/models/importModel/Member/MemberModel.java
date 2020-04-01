package com.sandata.models.importModel.Member;

public class MemberModel {
    public String ClientID = "";
    public String ClientFirstName = "";
    public String ClientMiddleInitial = "";
    public String ClientLastName = "";
    public String ClientSSN = "";
    public String ClientMedicalRecordNum = "";
    public String ClientCustomID = "";
    public String ClientOtherID = "";
    public String ClientSuffix = "";
    public String Action = "";
    public String PayerID2 = "";
    public String PayerProgram2 = "";
    public String PayerService = "";
    public String PayerRegion = "";
    public String ProviderQualifier = "";
    public String ProviderID = "";
    public String ClientAddressType = "";
    public String ClientAddressLine1 = "";
    public String ClientAddressLine2 = "";
    public String ClientCounty = "";
    public String ClientCity = "";
    public String ClientState = "";
    public String ClientZip = "";
    public String ClientPhoneType = "";
    public String ClientPhone = "";
    public String PayerID = "";
    public String PayerProgram = "";
    public String ClientEligibilityDateBegin = "";
    public String ClientEligibilityDateEnd = "";
    public String ClientStartOfCareDate = "";
    public String ClientEndOfCareDate = "";
    public String ClientPrimaryDiagnosisCode = "";
    public String ClientSecondaryDiagnosisCode = "";
    public String ClientStatus = "";
    public String ClientStatusDate = "";

    public String toLine() {

        return "\"" + ClientID + "\"" + "|" +
                "\"" + ClientFirstName + "\"" + "|" +
                "\"" + ClientMiddleInitial + "\"" + "|" +
                "\"" + ClientLastName + "\"" + "|" +
                "\"" + ClientSSN + "\"" + "|" +
                "\"" + ClientMedicalRecordNum + "\"" + "|" +
                "\"" + ClientCustomID + "\"" + "|" +
                "\"" + ClientOtherID + "\"" + "|" +
                "\"" + ClientSuffix + "\"" + "|" +
                "\"" + Action + "\"" + "|" +
                "\"" + PayerID2 + "\"" + "|" +
                "\"" + PayerProgram2 + "\"" + "|" +
                "\"" + PayerService + "\"" + "|" +
                "\"" + PayerRegion + "\"" + "|" +
                "\"" + ProviderQualifier + "\"" + "|" +
                "\"" + ProviderID + "\"" + "|" +
                "\"" + ClientAddressType + "\"" + "|" +
                "\"" + ClientAddressLine1 + "\"" + "|" +
                "\"" + ClientAddressLine2 + "\"" + "|" +
                "\"" + ClientCounty + "\"" + "|" +
                "\"" + ClientCity + "\"" + "|" +
                "\"" + ClientState + "\"" + "|" +
                "\"" + ClientZip + "\"" + "|" +
                "\"" + ClientPhoneType + "\"" + "|" +
                "\"" + ClientPhone + "\"" + "|" +
                "\"" + PayerID + "\"" + "|" +
                "\"" + PayerProgram + "\"" + "|" +
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
