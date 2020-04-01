package com.sandata.models.interfaces.open_evv_generic.client;

public class ClientPhone {
    private String Account;
    private String ClientID;
    private String ClientPhone;
    private String ClientPhoneType;
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

    public String getClientPhone() {
        return ClientPhone;
    }

    public void setClientPhone(String clientPhone) {
        ClientPhone = clientPhone;
    }

    public String getClientPhoneType() {
        return ClientPhoneType;
    }

    public void setClientPhoneType(String clientPhoneType) {
        ClientPhoneType = clientPhoneType;
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
