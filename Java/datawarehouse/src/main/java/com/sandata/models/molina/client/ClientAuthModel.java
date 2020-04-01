package com.sandata.models.molina.client;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;

public class ClientAuthModel extends ClientGenericModel {
    @CsvHeader("PayerID")
    @Column(value = "PayerID")
    private String payerID;

    @CsvHeader("ProviderID")
    @Column(value = "ProviderID")
    private String providerID;

    @CsvHeader("ClientID")
    @Column(value = "ClientID")
    private String clientID;

    @CsvHeader("PayerProgram")
    @Column(value = "PayerProgram")
    private String payerProgram;

    @CsvHeader("ClientPayerID")
    @Column(value = "ClientPayerID")
    private String clientPayerID;

    @CsvHeader("PayerRegion")
    @Column(value = "PayerRegion")
    private String payerRegion;

    @CsvHeader("PayerService")
    @Column(value = "PayerService")
    private String payerService;

    @CsvHeader("Modifier1")
    @Column(value = "Modifier1")
    private String modifier1;

    @CsvHeader("Modifier2")
    @Column(value = "Modifier2")
    private String modifier2;

    @CsvHeader("Modifier3")
    @Column(value = "Modifier3")
    private String modifier3;

    @CsvHeader("Modifier4")
    @Column(value = "Modifier4")
    private String modifier4;

    @CsvHeader("ClientEligibilityDateBegin")
    @Column(value = "ClientEligibilityDateBegin")
    private String clientEligibilityDateBegin;

    @CsvHeader("ClientEligibilityDateEnd")
    @Column(value = "ClientEligibilityDateEnd")
    private String clientEligibilityDateEnd;

    @CsvHeader("ClientStartOfCareDate")
    @Column(value = "ClientStartOfCareDate")
    private String clientStartOfCareDate;

    @CsvHeader("ClientEndOfCareDate")
    @Column(value = "ClientEndOfCareDate")
    private String clientEndOfCareDate;

    @CsvHeader("ClientStatus")
//    @Column(value = "ClientStatus")
    private String clientStatus;

    @CsvHeader("ClientStatusDate")
    @Column(value = "ClientStatusDate")
    private String clientStatusDate;

    @CsvHeader("IsPrimary")
    @Column(value = "IsPrimary")
    private String isPrimary;

    @CsvHeader("DiagnosisCode")
    @Column(value = "DiagnosisCode")
    private String diagnosisCode;

    public String getPayerID() {
        return payerID;
    }

    public void setPayerID(String payerID) {
        this.payerID = payerID;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getPayerProgram() {
        return payerProgram;
    }

    public void setPayerProgram(String payerProgram) {
        this.payerProgram = payerProgram;
    }

    public String getClientPayerID() {
        return clientPayerID;
    }

    public void setClientPayerID(String clientPayerID) {
        this.clientPayerID = clientPayerID;
    }

    public String getPayerRegion() {
        return payerRegion;
    }

    public void setPayerRegion(String payerRegion) {
        this.payerRegion = payerRegion;
    }

    public String getPayerService() {
        return payerService;
    }

    public void setPayerService(String payerService) {
        this.payerService = payerService;
    }

    public String getModifier1() {
        return modifier1;
    }

    public void setModifier1(String modifier1) {
        this.modifier1 = modifier1;
    }

    public String getModifier2() {
        return modifier2;
    }

    public void setModifier2(String modifier2) {
        this.modifier2 = modifier2;
    }

    public String getModifier3() {
        return modifier3;
    }

    public void setModifier3(String modifier3) {
        this.modifier3 = modifier3;
    }

    public String getModifier4() {
        return modifier4;
    }

    public void setModifier4(String modifier4) {
        this.modifier4 = modifier4;
    }

    public String getClientEligibilityDateBegin() {
        return clientEligibilityDateBegin;
    }

    public void setClientEligibilityDateBegin(String clientEligibilityDateBegin) {
        this.clientEligibilityDateBegin = clientEligibilityDateBegin;
    }

    public String getClientEligibilityDateEnd() {
        return clientEligibilityDateEnd;
    }

    public void setClientEligibilityDateEnd(String clientEligibilityDateEnd) {
        this.clientEligibilityDateEnd = clientEligibilityDateEnd;
    }

    public String getClientStartOfCareDate() {
        return clientStartOfCareDate;
    }

    public void setClientStartOfCareDate(String clientStartOfCareDate) {
        this.clientStartOfCareDate = clientStartOfCareDate;
    }

    public String getClientEndOfCareDate() {
        return clientEndOfCareDate;
    }

    public void setClientEndOfCareDate(String clientEndOfCareDate) {
        this.clientEndOfCareDate = clientEndOfCareDate;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getClientStatusDate() {
        return clientStatusDate;
    }

    public void setClientStatusDate(String clientStatusDate) {
        this.clientStatusDate = clientStatusDate;
    }

    public String getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    @Override
    public String toString() {
        String toString = "ClientAuthModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "payerProgram='" + payerProgram + '\'' +
                "clientPayerID='" + clientPayerID + '\'' +
                "payerRegion='" + payerRegion + '\'' +
                "payerService='" + payerService + '\'' +
                "modifier1='" + modifier1 + '\'' +
                "modifier2='" + modifier2 + '\'' +
                "modifier3='" + modifier3 + '\'' +
                "modifier4='" + modifier4 + '\'' +
                "clientEligibilityDateBegin='" + clientEligibilityDateBegin + '\'' +
                "clientEligibilityDateEnd='" + clientEligibilityDateEnd + '\'' +
                "clientStartOfCareDate='" + clientStartOfCareDate + '\'' +
                "clientEndOfCareDate='" + clientEndOfCareDate + '\'' +
//                "clientStatus='" + clientStatus + '\'' +
                "clientStatusDate='" + clientStatusDate + '\'' +
                "isPrimary='" + isPrimary + '\'' +
                "diagnosisCode='" + diagnosisCode + '\'' +
                '}';
        return toString.replace("null", "");
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        ClientAuthModel modelObject = (ClientAuthModel) obj;
        return true;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }
}
