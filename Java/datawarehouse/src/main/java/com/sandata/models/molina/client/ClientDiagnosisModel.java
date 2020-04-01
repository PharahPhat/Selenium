package com.sandata.models.molina.client;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;

public class ClientDiagnosisModel extends ClientGenericModel {
    @CsvHeader("PayerID")
    @Column("PayerID")
    private String payerID;

    @CsvHeader("ProviderID")
    @Column("ProviderID")
    private String providerID;

    @CsvHeader("ClientID")
    @Column("ClientID")
    private String clientID;

    @CsvHeader("IsPrimary")
    @Column("IsPrimary")
    private String isPrimary;

    @CsvHeader("DiagnosisCode")
    @Column("DiagnosisCode")
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
        String toString = "ClientDiagnosisModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "isPrimary='" + isPrimary + '\'' +
                "diagnosisCode='" + diagnosisCode + '\'' +
                '}';
        return toString.replace("null", "");
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        ClientDiagnosisModel modelObject = (ClientDiagnosisModel) obj;

        if(this.getPayerID() != null && !this.getPayerID().isEmpty())
            if (!this.getPayerID().equalsIgnoreCase(modelObject.getPayerID())) {
                return false;
            }

        if (!this.getProviderID().equalsIgnoreCase(modelObject.getProviderID())) {
            return false;
        }

        if (!this.getClientID().equalsIgnoreCase(modelObject.getClientID())) {
            return false;
        }

        if (!this.getIsPrimary().equalsIgnoreCase(modelObject.getIsPrimary())) {
            return false;
        }

        if(this.getDiagnosisCode() != null && !this.getDiagnosisCode().isEmpty())
            if (!this.getDiagnosisCode().equalsIgnoreCase(modelObject.getDiagnosisCode())) {
                return false;
            }
        return true;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }
}
