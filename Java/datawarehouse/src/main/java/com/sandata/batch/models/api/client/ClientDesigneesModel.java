package com.sandata.batch.models.api.client;

import com.google.gson.annotations.SerializedName;

public class ClientDesigneesModel {

    @SerializedName("ClientDesigneeFirstName")
    private String ClientDesigneeFirstName;

    @SerializedName("ClientDesigneeLastName")
    private String ClientDesigneeLastName;

    @SerializedName("ClientDesigneeEmail")
    private String ClientDesigneeEmail;

    @SerializedName("ClientDesigneeStatus")
    private String ClientDesigneeStatus;

    @SerializedName("ClientDesigneeStartDate")
    private String ClientDesigneeStartDate;

    @SerializedName("ClientDesigneeEndDate")
    private String ClientDesigneeEndDate;

    @SerializedName("ClientStatus")
    private String ClientStatus;

    @SerializedName("ClientDesigneeRelationship")
    private String ClientDesigneeRelationship;


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

    public String getClientStatus() {
        return ClientStatus;
    }

    public void setClientStatus(String clientStatus) {
        ClientStatus = clientStatus;
    }

    public String getClientDesigneeRelationship() {
        return ClientDesigneeRelationship;
    }

    public void setClientDesigneeRelationship(String clientDesigneeRelationship) {
        ClientDesigneeRelationship = clientDesigneeRelationship;
    }
}
