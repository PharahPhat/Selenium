package com.sandata.models.molina.client;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;

public class ClientEligibilityModel extends ClientGenericModel {
    @CsvHeader("PayerID")
    @Column("PayerID")
    private String payerID;

    @CsvHeader("ProviderID")
    @Column("ProviderID")
    private String providerID;

    @CsvHeader("ClientID")
    @Column("ClientID")
    private String clientID;

    @CsvHeader("PayerProgram")
    @Column("PayerProgram")
    private String payerProgram;

    @CsvHeader("ClientEligibilityDateBegin")
    @Column("ClientEligibilityDateBegin")
    private String clientEligibilityDateBegin;

    @CsvHeader("ClientEligibilityDateEnd")
    @Column("ClientEligibilityDateEnd")
    private String clientEligibilityDateEnd;

    @CsvHeader("ClientStartOfCareDate")
    @Column("ClientStartOfCareDate")
    private String clientStartOfCareDate;

    @CsvHeader("ClientEndOfCareDate")
    @Column("ClientEndOfCareDate")
    private String clientEndOfCareDate;

    @CsvHeader("ClientStatus")
    private String clientStatus;

    @CsvHeader("ClientStatusDate")
    private String clientStatusDate;

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

    @Override
    public String toString() {
        String toString = "ClientEligibilityModel{" +
                "payerID='" + payerID + '\'' +
                "providerID='" + providerID + '\'' +
                "clientID='" + clientID + '\'' +
                "payerProgram='" + payerProgram + '\'' +
                "clientEligibilityDateBegin='" + clientEligibilityDateBegin + '\'' +
                "clientEligibilityDateEnd='" + clientEligibilityDateEnd + '\'' +
                "clientStartOfCareDate='" + clientStartOfCareDate + '\'' +
                "clientEndOfCareDate='" + clientEndOfCareDate + '\'' +
                "clientStatus='" + clientStatus + '\'' +
                "clientStatusDate='" + clientStatusDate + '\'' +
                '}';
        return toString.replace("null", "");
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        ClientEligibilityModel modelObject = (ClientEligibilityModel) obj;

        if (this.getPayerID() != null && !this.getPayerID().isEmpty())
            if (!this.getPayerID().equalsIgnoreCase(modelObject.getPayerID())) {
                return false;
            }

        if (!this.getProviderID().equalsIgnoreCase(modelObject.getProviderID())) {
            return false;
        }

        if (!this.getClientID().equalsIgnoreCase(modelObject.getClientID())) {
            return false;
        }

        if (this.getPayerProgram() != null && !this.getPayerProgram().isEmpty())
            if (!this.getPayerProgram().equalsIgnoreCase(modelObject.getPayerProgram())) {
                return false;
            }

        if (this.getClientEligibilityDateBegin() != null && !this.getClientEligibilityDateBegin().isEmpty())
            if (!this.getClientEligibilityDateBegin().equalsIgnoreCase(modelObject.getClientEligibilityDateBegin())) {
                return false;
            }

        if (this.getClientEligibilityDateEnd() != null && !this.getClientEligibilityDateEnd().isEmpty())
            if (!this.getClientEligibilityDateEnd().equalsIgnoreCase(modelObject.getClientEligibilityDateEnd())) {
                return false;
            }

        if (this.getClientEligibilityDateEnd() != null && !this.getClientEligibilityDateEnd().isEmpty())
            if (!this.getClientEligibilityDateEnd().equalsIgnoreCase(modelObject.getClientEligibilityDateEnd())) {
                return false;
            }

        if (this.getClientEndOfCareDate() != null && !this.getClientEndOfCareDate().isEmpty())
            if (!this.getClientEndOfCareDate().equalsIgnoreCase(modelObject.getClientEndOfCareDate())) {
                return false;
            }
        return true;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }
}
