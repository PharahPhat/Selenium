package com.sandata.entity.molina.client;

import com.sandata.entity.exportDWH.*;
import com.sandata.entity.generic.ClientGenericEntity;

import java.util.List;

public class ClientGeneralEntity extends ClientGenericEntity {
    public com.sandata.entity.exportDWH.ProviderIdentification ProviderIdentification;
    public String ClientID;
    public String ClientFirstName;
    public String ClientMiddleInitial;
    public String ClientLastName;
    public String PayerName;
    public String ClientQualifier;
    public String ClientIdentifier;
    public String ClientCustomID;
    public String ClientMedicaidID;
    public String SequenceID;
    public String ClientOtherID;
    public String ClientSSN;
    public String ClientTimezone;

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public List<com.sandata.entity.exportDWH.ClientAddress> getClientAddress() {
        return ClientAddress;
    }

    public List<com.sandata.entity.exportDWH.ClientResponsibleParty> getClientResponsibleParty() {
        return ClientResponsibleParty;
    }

    public void setClientAddress(List<com.sandata.entity.exportDWH.ClientAddress> clientAddress) {
        ClientAddress = clientAddress;
    }

    public List<com.sandata.entity.exportDWH.ClientPhone> getClientPhone() {
        return ClientPhone;
    }

    public void setClientPhone(List<com.sandata.entity.exportDWH.ClientPhone> clientPhone) {
        ClientPhone = clientPhone;
    }

    public List<com.sandata.entity.exportDWH.ClientPayerInformation> getClientPayerInformation() {
        return ClientPayerInformation;
    }

    public void setClientPayerInformation(List<com.sandata.entity.exportDWH.ClientPayerInformation> clientPayerInformation) {
        ClientPayerInformation = clientPayerInformation;
    }

    public void setClientResponsibleParty(List<com.sandata.entity.exportDWH.ClientResponsibleParty> clientResponsibleParty) {
        ClientResponsibleParty = clientResponsibleParty;
    }

    public List<com.sandata.entity.exportDWH.ClientAddress> ClientAddress;
    public List<com.sandata.entity.exportDWH.ClientPhone> ClientPhone;
    public List<com.sandata.entity.exportDWH.ClientPayerInformation> ClientPayerInformation;
    public List<com.sandata.entity.exportDWH.ClientResponsibleParty> ClientResponsibleParty;

    public String getClientMiddleInitial() {
        return ClientMiddleInitial;
    }

    public void setClientMiddleInitial(String clientMiddleInitial) {
        ClientMiddleInitial = clientMiddleInitial;
    }

    public ProviderIdentification getProviderIdentification() {
        return ProviderIdentification;
    }

    public void setProviderIdentification(ProviderIdentification providerIdentification) {
        if(providerIdentification != null)
            this.ProviderIdentification = providerIdentification;
    }

    public String getClientFirstName() {
        return ClientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        if(clientFirstName != null)
            ClientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return ClientLastName;
    }

    public void setClientLastName(String clientLastName) {
        if(clientLastName != null)
            ClientLastName = clientLastName;
    }

    public String getClientQualifier() {
        return ClientQualifier;
    }

    public void setClientQualifier(String clientQualifier) {
        if(clientQualifier != null)
            ClientQualifier = clientQualifier;
    }

    public String getClientMedicaidID() {
        return ClientMedicaidID;
    }

    public void setClientMedicaidID(String clientMedicaidID) {
        if(clientMedicaidID != null)
            ClientMedicaidID = clientMedicaidID;
    }

    public String getClientIdentifier() {
        return ClientIdentifier;
    }

    public void setClientIdentifier(String clientIdentifier) {
        ClientIdentifier = clientIdentifier;
    }

    public String getSequenceID() {
        return SequenceID;
    }

    public void setSequenceID(String sequenceID) {
        if(sequenceID != null)
            SequenceID = sequenceID;
    }

    public String getClientTimezone() {
        return ClientTimezone;
    }

    public void setClientTimezone(String clientTimezone) {
        ClientTimezone = clientTimezone;
    }

    public String getPayerName() {
        return PayerName;
    }

    public void setPayerName(String payerName) {
        PayerName = payerName;
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

    public String getClientSSN() {
        return ClientSSN;
    }

    public void setClientSSN(String clientSSN) {
        ClientSSN = clientSSN;
    }
}