package com.sandata.models.generic.client;

import com.sandata.models.GenericModel;

public class ClientDesignees_B extends GenericModel {

    private String ClientID;
    private String ClientDesigneeFirstName;
    private String ClientDesigneeLastName;
    private String ClientDesigneeEmail;
    private String ClientDesigneeStatus;
    private String ClientDesigneeStartDate;
    private String ClientDesigneeEndDate;
    private String ClientDesigneeRelationship;


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

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }
}
