package com.sandata.batch.models.api.client;

import com.google.gson.annotations.SerializedName;

public class ClientAddressModel {

    @SerializedName("ClientAddressType")
    private String ClientAddressType;

    @SerializedName("ClientAddressLine1")
    private String ClientAddressLine1;

    @SerializedName("ClientAddressLine2")
    private String ClientAddressLine2;

    @SerializedName("ClientCounty")
    private String ClientCounty;

    @SerializedName("ClientCity")
    private String ClientCity;

    @SerializedName("ClientState")
    private String ClientState;

    @SerializedName("ClientZip")
    private String ClientZip;


    public String getClientAddressType() {
        return ClientAddressType;
    }

    public void setClientAddressType(String clientAddressType) {
        ClientAddressType = clientAddressType;
    }

    public String getClientAddressLine1() {
        return ClientAddressLine1;
    }

    public void setClientAddressLine1(String clientAddressLine1) {
        ClientAddressLine1 = clientAddressLine1;
    }

    public String getClientAddressLine2() {
        return ClientAddressLine2;
    }

    public void setClientAddressLine2(String clientAddressLine2) {
        ClientAddressLine2 = clientAddressLine2;
    }

    public String getClientCounty() {
        return ClientCounty;
    }

    public void setClientCounty(String clientCounty) {
        ClientCounty = clientCounty;
    }

    public String getClientCity() {
        return ClientCity;
    }

    public void setClientCity(String clientCity) {
        ClientCity = clientCity;
    }

    public String getClientState() {
        return ClientState;
    }

    public void setClientState(String clientState) {
        ClientState = clientState;
    }

    public String getClientZip() {
        return ClientZip;
    }

    public void setClientZip(String clientZip) {
        ClientZip = clientZip;
    }
}
