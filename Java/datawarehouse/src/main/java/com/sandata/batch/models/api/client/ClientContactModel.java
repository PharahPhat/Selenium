package com.sandata.batch.models.api.client;

import com.google.gson.annotations.SerializedName;

public class ClientContactModel {

    @SerializedName("ClientContactType")
    private String ClientContactType;

    @SerializedName("ClientContactFirstName")
    private String ClientContactFirstName;

    @SerializedName("ClientContactLastName")
    private String ClientContactLastName;

    @SerializedName("ClientContactPhoneType")
    private String ClientContactPhoneType;

    @SerializedName("ClientContactPhone")
    private String ClientContactPhone;

    @SerializedName("ClientContactEmailAddress")
    private String ClientContactEmailAddress;

    @SerializedName("ClientContactAddressLine1")
    private String ClientContactAddressLine1;

    @SerializedName("ClientContactAddressLine2")
    private String ClientContactAddressLine2;

    @SerializedName("ClientContactCity")
    private String ClientContactCity;

    @SerializedName("ClientContactState")
    private String ClientContactState;

    @SerializedName("ClientContactZip")
    private String ClientContactZip;

    public String getClientContactType() {
        return ClientContactType;
    }

    public void setClientContactType(String clientContactType) {
        ClientContactType = clientContactType;
    }

    public String getClientContactFirstName() {
        return ClientContactFirstName;
    }

    public void setClientContactFirstName(String clientContactFirstName) {
        ClientContactFirstName = clientContactFirstName;
    }

    public String getClientContactLastName() {
        return ClientContactLastName;
    }

    public void setClientContactLastName(String clientContactLastName) {
        ClientContactLastName = clientContactLastName;
    }

    public String getClientContactPhoneType() {
        return ClientContactPhoneType;
    }

    public void setClientContactPhoneType(String clientContactPhoneType) {
        ClientContactPhoneType = clientContactPhoneType;
    }

    public String getClientContactPhone() {
        return ClientContactPhone;
    }

    public void setClientContactPhone(String clientContactPhone) {
        ClientContactPhone = clientContactPhone;
    }

    public String getClientContactEmailAddress() {
        return ClientContactEmailAddress;
    }

    public void setClientContactEmailAddress(String clientContactEmailAddress) {
        ClientContactEmailAddress = clientContactEmailAddress;
    }

    public String getClientContactAddressLine1() {
        return ClientContactAddressLine1;
    }

    public void setClientContactAddressLine1(String clientContactAddressLine1) {
        ClientContactAddressLine1 = clientContactAddressLine1;
    }

    public String getClientContactAddressLine2() {
        return ClientContactAddressLine2;
    }

    public void setClientContactAddressLine2(String clientContactAddressLine2) {
        ClientContactAddressLine2 = clientContactAddressLine2;
    }

    public String getClientContactCity() {
        return ClientContactCity;
    }

    public void setClientContactCity(String clientContactCity) {
        ClientContactCity = clientContactCity;
    }

    public String getClientContactState() {
        return ClientContactState;
    }

    public void setClientContactState(String clientContactState) {
        ClientContactState = clientContactState;
    }

    public String getClientContactZip() {
        return ClientContactZip;
    }

    public void setClientContactZip(String clientContactZip) {
        ClientContactZip = clientContactZip;
    }
}
