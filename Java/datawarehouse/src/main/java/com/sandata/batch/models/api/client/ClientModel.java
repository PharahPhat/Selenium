package com.sandata.batch.models.api.client;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ClientModel {

    @SerializedName("ClientID")
    private String ClientID;

    @SerializedName("ClientFirstName")
    private String ClientFirstName;

    @SerializedName("ClientMiddleInitial")
    private String ClientMiddleInitial;

    @SerializedName("ClientLastName")
    private String ClientLastName;

    @SerializedName("ClientSSN")
    private String ClientSSN;

    @SerializedName("ClientCustomID")
    private String ClientCustomID;

    @SerializedName("ClientOtherID")
    private String ClientOtherID;

    @SerializedName("ClientSuffix")
    private String ClientSuffix;

    @SerializedName("Action")
    private String Action;

    @SerializedName("ClientLanguage")
    private String ClientLanguage;

    @SerializedName("ClientGender")
    private String ClientGender;

    @SerializedName("ClientMaritalStatus")
    private String ClientMaritalStatus;

    @SerializedName("ClientBirthDate")
    private String ClientBirthDate;

    @SerializedName("ClientEmail")
    private String ClientEmail;

    @SerializedName("ClientTimeZone")
    private String ClientTimeZone;

    @SerializedName("MemberEnrollmentDate")
    private String MemberEnrollmentDate;

    @SerializedName("ClientAddress")
    private List<ClientAddressModel> clientAddress = new ArrayList<>();

    @SerializedName("ClientPhone")
    private List<ClientPhoneModel> clientPhones = new ArrayList<>();

    @SerializedName("ClientContact")
    private List<ClientContactModel> clientContact = new ArrayList<>();

    @SerializedName("ClientEligibility")
    private List<ClientEligModel> clientElig = new ArrayList<>();

    @SerializedName("ClientDesignee")
    private List<ClientDesigneesModel> clientDesignees = new ArrayList<>();

    @SerializedName("ClientMedicaidID")
    private String clientMedicaidID;

    public String getClientMedicaidID() {
        return clientMedicaidID;
    }

    public void setClientMedicaidID(String clientMedicaidID) {
        this.clientMedicaidID = clientMedicaidID;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getClientFirstName() {
        return ClientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        ClientFirstName = clientFirstName;
    }

    public String getClientMiddleInitial() {
        return ClientMiddleInitial;
    }

    public void setClientMiddleInitial(String clientMiddleInitial) {
        ClientMiddleInitial = clientMiddleInitial;
    }

    public String getClientLastName() {
        return ClientLastName;
    }

    public void setClientLastName(String clientLastName) {
        ClientLastName = clientLastName;
    }

    public String getClientSSN() {
        return ClientSSN;
    }

    public void setClientSSN(String clientSSN) {
        ClientSSN = clientSSN;
    }

    public String getClientCustomID() {
        return ClientCustomID;
    }

    public void setClientCustomID(String clientCustomID) {
        ClientCustomID = clientCustomID;
    }

    public String getClientOtherID() {
        return ClientOtherID;
    }

    public void setClientOtherID(String clientOtherID) {
        ClientOtherID = clientOtherID;
    }

    public String getClientSuffix() {
        return ClientSuffix;
    }

    public void setClientSuffix(String clientSuffix) {
        ClientSuffix = clientSuffix;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getClientLanguage() {
        return ClientLanguage;
    }

    public void setClientLanguage(String clientLanguage) {
        ClientLanguage = clientLanguage;
    }

    public String getClientGender() {
        return ClientGender;
    }

    public void setClientGender(String clientGender) {
        ClientGender = clientGender;
    }

    public String getClientMaritalStatus() {
        return ClientMaritalStatus;
    }

    public void setClientMaritalStatus(String clientMaritalStatus) {
        ClientMaritalStatus = clientMaritalStatus;
    }

    public String getClientBirthDate() {
        return ClientBirthDate;
    }

    public void setClientBirthDate(String clientBirthDate) {
        ClientBirthDate = clientBirthDate;
    }

    public String getClientEmail() {
        return ClientEmail;
    }

    public void setClientEmail(String clientEmail) {
        ClientEmail = clientEmail;
    }

    public String getClientTimeZone() {
        return ClientTimeZone;
    }

    public void setClientTimeZone(String clientTimeZone) {
        ClientTimeZone = clientTimeZone;
    }

    public String getMemberEnrollmentDate() {
        return MemberEnrollmentDate;
    }

    public void setMemberEnrollmentDate(String memberEnrollmentDate) {
        MemberEnrollmentDate = memberEnrollmentDate;
    }

    public List<ClientAddressModel> getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(List<ClientAddressModel> clientAddress) {
        this.clientAddress = clientAddress;
    }

    public List<ClientPhoneModel> getClientPhones() {
        return clientPhones;
    }

    public void setClientPhones(List<ClientPhoneModel> clientPhones) {
        this.clientPhones = clientPhones;
    }

    public List<ClientEligModel> getClientElig() {
        return clientElig;
    }

    public void setClientElig(List<ClientEligModel> clientElig) {
        this.clientElig = clientElig;
    }

    public List<ClientDesigneesModel> getClientDesignees() {
        return clientDesignees;
    }

    public void setClientDesignees(List<ClientDesigneesModel> clientDesignees) {
        this.clientDesignees = clientDesignees;
    }

    public List<ClientContactModel> getClientContact() {
        return clientContact;
    }

    public void setClientContact(List<ClientContactModel> clientContact) {
        this.clientContact = clientContact;
    }
}
