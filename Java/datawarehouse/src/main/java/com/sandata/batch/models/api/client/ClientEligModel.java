package com.sandata.batch.models.api.client;

import com.google.gson.annotations.SerializedName;

public class ClientEligModel {

    @SerializedName("PayerID")
    private String PayerID;

    @SerializedName("PayerProgram")
    private String PayerProgram;

    @SerializedName("ClientEligibilityDateBegin")
    private String ClientEligibilityDateBegin;

    @SerializedName("ClientEligibilityDateEnd")
    private String ClientEligibilityDateEnd;

    @SerializedName("ClientStartOfCareDate")
    private String ClientStartOfCareDate;

    @SerializedName("ClientEndOfCareDate")
    private String ClientEndOfCareDate;

    @SerializedName("ClientStatusDate")
    private String ClientStatusDate;

    @SerializedName("ClientStatus")
    private String ClientStatus;

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

    public String getClientEligibilityDateBegin() {
        return ClientEligibilityDateBegin;
    }

    public void setClientEligibilityDateBegin(String clientEligibilityDateBegin) {
        ClientEligibilityDateBegin = clientEligibilityDateBegin;
    }

    public String getClientEligibilityDateEnd() {
        return ClientEligibilityDateEnd;
    }

    public void setClientEligibilityDateEnd(String clientEligibilityDateEnd) {
        ClientEligibilityDateEnd = clientEligibilityDateEnd;
    }

    public String getClientStartOfCareDate() {
        return ClientStartOfCareDate;
    }

    public void setClientStartOfCareDate(String clientStartOfCareDate) {
        ClientStartOfCareDate = clientStartOfCareDate;
    }

    public String getClientEndOfCareDate() {
        return ClientEndOfCareDate;
    }

    public void setClientEndOfCareDate(String clientEndOfCareDate) {
        ClientEndOfCareDate = clientEndOfCareDate;
    }

    public String getClientStatusDate() {
        return ClientStatusDate;
    }

    public void setClientStatusDate(String clientStatusDate) {
        ClientStatusDate = clientStatusDate;
    }

    public String getClientStatus() {
        return ClientStatus;
    }

    public void setClientStatus(String clientStatus) {
        ClientStatus = clientStatus;
    }
}
