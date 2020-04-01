package com.sandata.models.interfaces.open_evv_generic.client;

public class ClientAddress {
    private String Account;
    private String ClientID;
    private String AddressType;
    private String ClientAddressLine1;
    private String ClientAddressLine2;
    private String ClientCounty;
    private String ClientCity;
    private String ClientState;
    private String ClientZip;
    private String ErrorCode;
    private String ErrorMessage;

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getAddressType() {
        return AddressType;
    }

    public void setAddressType(String clientAddressType) {
        AddressType = clientAddressType;
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

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }
}
