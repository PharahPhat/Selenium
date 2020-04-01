package com.sandata.models.interfaces.open_evv_generic.client;

public class ClientDesignees_A {
    private String ClientID;
    private String ClientDesigneeFirstName;
    private String ClientDesigneeLastName;
    private String ClientDesigneeEmail;
    private String ClientDesigneeStatus;
    private String ClientDesigneeStartDate;
    private String ClientDesigneeEndDate;
    private String ClientDesigneeRelationship;
    private String ErrorCode;
    private String ErrorMessage;

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getClientDesigneeFirstName() {
        return ClientDesigneeFirstName;
    }

    public void setClientDesigneeFirstName(String clientDesigneeFirstName) {
        ClientDesigneeFirstName = clientDesigneeFirstName;
    }

    public String getClientDesigneeLastName() {
        return ClientDesigneeLastName;
    }

    public void setClientDesigneeLastName(String clientDesigneeLastName) {
        ClientDesigneeLastName = clientDesigneeLastName;
    }

    public String getClientDesigneeEmail() {
        return ClientDesigneeEmail;
    }

    public void setClientDesigneeEmail(String clientDesigneeEmail) {
        ClientDesigneeEmail = clientDesigneeEmail;
    }

    public String getClientDesigneeStatus() {
        return ClientDesigneeStatus;
    }

    public void setClientDesigneeStatus(String clientDesigneeStatus) {
        ClientDesigneeStatus = clientDesigneeStatus;
    }

    public String getClientDesigneeStartDate() {
        return ClientDesigneeStartDate;
    }

    public void setClientDesigneeStartDate(String clientDesigneeStartDate) {
        ClientDesigneeStartDate = clientDesigneeStartDate;
    }

    public String getClientDesigneeEndDate() {
        return ClientDesigneeEndDate;
    }

    public void setClientDesigneeEndDate(String clientDesigneeEndDate) {
        ClientDesigneeEndDate = clientDesigneeEndDate;
    }

    public String getClientDesigneeRelationship() {
        return ClientDesigneeRelationship;
    }

    public void setClientDesigneeRelationship(String clientDesigneeRelationship) {
        ClientDesigneeRelationship = clientDesigneeRelationship;
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

    @Override
    public String toString() {
        return "ClientDesignees{" +
                "ClientID='" + ClientID + '\'' +
                ", ClientDesigneeFirstName='" + ClientDesigneeFirstName + '\'' +
                ", ClientDesigneeLastName='" + ClientDesigneeLastName + '\'' +
                ", ClientDesigneeEmail='" + ClientDesigneeEmail + '\'' +
                ", ClientDesigneeStatus='" + ClientDesigneeStatus + '\'' +
                ", ClientDesigneeStartDate='" + ClientDesigneeStartDate + '\'' +
                ", ClientDesigneeEndDate='" + ClientDesigneeEndDate + '\'' +
                ", ClientDesigneeRelationship='" + ClientDesigneeRelationship + '\'' +
                ", ErrorCode='" + ErrorCode + '\'' +
                ", ErrorMessage='" + ErrorMessage + '\'' +
                '}';
    }
}

