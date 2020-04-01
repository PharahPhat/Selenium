package com.sandata.entity.connecticut.authorization;

import java.util.List;

public class AuthorizationEntity {
    public String PayerID;
    public String PayerProgram;
    public String ClientQualifier;
    public String ClientIdentifier;
    public String EmployeeID;
    public String EmployeePINQualifier;
    public String ProviderQualifier;
    public String ProviderID;
    public String AuthorizationReferenceNumber;
    public String AuthorizationServiceID;
    public String AuthorizationBillingType;
    public String Modifier1;
    public String Modifier2;
    public String Modifier3;
    public String Modifier4;
    public String AuthorizationAmountType;
    public String AuthorizationMaximum;
    public String Units;
    public String AuthorizationStartDate;
    public String AuthorizationEndDate;
    public String AuthorizationShared;
    public String AuthorizationComments;
    public String AuthorizationLimitType;
    public String AuthorizationStatus;
    public String ClientDiagnosisCode;
    public List<AuthorizationLimits> AuthorizationLimits;

    public String getPayerID() {
        return PayerID;
    }

    public void setPayerID(String payerID) {
        PayerID = payerID;
    }

    public String getPayerProgram() {
        return PayerProgram;
    }

    public void setPayerProgram(String payerProgram) {
        PayerProgram = payerProgram;
    }

    public String getClientQualifier() {
        return ClientQualifier;
    }

    public void setClientQualifier(String clientQualifier) {
        ClientQualifier = clientQualifier;
    }

    public String getClientIdentifier() {
        return ClientIdentifier;
    }

    public void setClientIdentifier(String clientIdentifier) {
        ClientIdentifier = clientIdentifier;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeePINQualifier() {
        return EmployeePINQualifier;
    }

    public void setEmployeePINQualifier(String employeePINQualifier) {
        EmployeePINQualifier = employeePINQualifier;
    }

    public String getProviderQualifier() {
        return ProviderQualifier;
    }

    public void setProviderQualifier(String providerQualifier) {
        ProviderQualifier = providerQualifier;
    }

    public String getProviderID() {
        return ProviderID;
    }

    public void setProviderID(String providerID) {
        ProviderID = providerID;
    }

    public String getAuthorizationReferenceNumber() {
        return AuthorizationReferenceNumber;
    }

    public void setAuthorizationReferenceNumber(String authorizationReferenceNumber) {
        AuthorizationReferenceNumber = authorizationReferenceNumber;
    }

    public String getAuthorizationServiceID() {
        return AuthorizationServiceID;
    }

    public void setAuthorizationServiceID(String authorizationServiceID) {
        AuthorizationServiceID = authorizationServiceID;
    }

    public String getAuthorizationBillingType() {
        return AuthorizationBillingType;
    }

    public void setAuthorizationBillingType(String authorizationBillingType) {
        AuthorizationBillingType = authorizationBillingType;
    }

    public String getModifier1() {
        return Modifier1;
    }

    public void setModifier1(String modifier1) {
        Modifier1 = modifier1;
    }

    public String getModifier2() {
        return Modifier2;
    }

    public void setModifier2(String modifier2) {
        Modifier2 = modifier2;
    }

    public String getModifier3() {
        return Modifier3;
    }

    public void setModifier3(String modifier3) {
        Modifier3 = modifier3;
    }

    public String getModifier4() {
        return Modifier4;
    }

    public void setModifier4(String modifier4) {
        Modifier4 = modifier4;
    }

    public String getAuthorizationAmountType() {
        return AuthorizationAmountType;
    }

    public void setAuthorizationAmountType(String authorizationAmountType) {
        AuthorizationAmountType = authorizationAmountType;
    }

    public String getAuthorizationMaximum() {
        return AuthorizationMaximum;
    }

    public void setAuthorizationMaximum(String authorizationMaximum) {
        AuthorizationMaximum = authorizationMaximum;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public String getAuthorizationStartDate() {
        return AuthorizationStartDate;
    }

    public void setAuthorizationStartDate(String authorizationStartDate) {
        AuthorizationStartDate = authorizationStartDate;
    }

    public String getAuthorizationEndDate() {
        return AuthorizationEndDate;
    }

    public void setAuthorizationEndDate(String authorizationEndDate) {
        AuthorizationEndDate = authorizationEndDate;
    }

    public String getAuthorizationShared() {
        return AuthorizationShared;
    }

    public void setAuthorizationShared(String authorizationShared) {
        AuthorizationShared = authorizationShared;
    }

    public String getAuthorizationComments() {
        return AuthorizationComments;
    }

    public void setAuthorizationComments(String authorizationComments) {
        AuthorizationComments = authorizationComments;
    }

    public String getAuthorizationLimitType() {
        return AuthorizationLimitType;
    }

    public void setAuthorizationLimitType(String authorizationLimitType) {
        AuthorizationLimitType = authorizationLimitType;
    }

    public String getAuthorizationStatus() {
        return AuthorizationStatus;
    }

    public void setAuthorizationStatus(String authorizationStatus) {
        AuthorizationStatus = authorizationStatus;
    }

    public String getClientDiagnosisCode() {
        return ClientDiagnosisCode;
    }

    public void setClientDiagnosisCode(String clientDiagnosisCode) {
        ClientDiagnosisCode = clientDiagnosisCode;
    }

    public List<com.sandata.entity.connecticut.authorization.AuthorizationLimits> getAuthorizationLimits() {
        return AuthorizationLimits;
    }

    public void setAuthorizationLimits(List<com.sandata.entity.connecticut.authorization.AuthorizationLimits> authorizationLimits) {
        AuthorizationLimits = authorizationLimits;
    }
}
