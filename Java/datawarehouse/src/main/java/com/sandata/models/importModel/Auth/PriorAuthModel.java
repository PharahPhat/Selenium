package com.sandata.models.importModel.Auth;

public class PriorAuthModel {
    public String PayerID = "";
    public String PayerProgram = "";
    public String PayerRegion = "";
    public String ClientQualifier = "";
    public String ClientIdentifier = "";
    public String ProviderQualifier = "";
    public String ProviderID = "";
    public String AuthorizationReferenceNumber = "";
    public String AuthorizationServiceID = "";
    public String AuthorizationBillingType = "";
    public String Modifier1 = "";
    public String Modifier2 = "";
    public String Modifier3 = "";
    public String Modifier4 = "";
    public String AuthorizationAmountType = "";
    public String AuthorizationMaximum = "";
    public String AuthorizationStartDate = "";
    public String AuthorizationEndDate = "";
    public String AuthorizationShared = "";
    public String AuthorizationComments = "";
    public String AuthorizationLimitType = "";
    public String AuthorizationStatus = "";
    public String ClientDiagnosisCodeIsPrimary = "";
    public String ClientDiagnosisCode = "";
    public String ClientDiagnosisCodeBeginDate = "";

    public String toLine() {
        return "\"" + PayerID + "\"" + "|" +
                "\"" + PayerProgram + "\"" + "|" +
                "\"" + PayerRegion + "\"" + "|" +
                "\"" + ClientQualifier + "\"" + "|" +
                "\"" + ClientIdentifier + "\"" + "|" +
                "\"" + ProviderQualifier + "\"" + "|" +
                "\"" + ProviderID + "\"" + "|" +
                "\"" + AuthorizationReferenceNumber + "\"" + "|" +
                "\"" + AuthorizationServiceID + "\"" + "|" +
                "\"" + AuthorizationBillingType + "\"" + "|" +
                "\"" + Modifier1 + "\"" + "|" +
                "\"" + Modifier2 + "\"" + "|" +
                "\"" + Modifier3 + "\"" + "|" +
                "\"" + Modifier4 + "\"" + "|" +
                "\"" + AuthorizationAmountType + "\"" + "|" +
                "\"" + AuthorizationMaximum + "\"" + "|" +
                "\"" + AuthorizationStartDate + "\"" + "|" +
                "\"" + AuthorizationEndDate + "\"" + "|" +
                "\"" + AuthorizationShared + "\"" + "|" +
                "\"" + AuthorizationComments + "\"" + "|" +
                "\"" + AuthorizationLimitType + "\"" + "|" +
                "\"" + AuthorizationStatus + "\"" + "|" +
                "\"" + ClientDiagnosisCodeIsPrimary + "\"" + "|" +
                "\"" + ClientDiagnosisCode + "\"" + "|" +
                "\"" + ClientDiagnosisCodeBeginDate + "\"";
    }
}
