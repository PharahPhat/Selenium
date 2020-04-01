package com.sandata.entity.ohio.client;

import com.sandata.entity.exportDWH.IndividualPayerInformationModel;
import com.sandata.entity.generic.ClientGenericEntity;

import java.util.List;

public class PatientGeneralEntity extends ClientGenericEntity {
    public String BusinessEntityID;
    public String BusinessEntityMedicaidIdentifier;
    public boolean IsPatientNewborn;
    public String PatientAlternateID;
    public String PatientFirstName;
    public String PatientLastName;
    public String PatientMedicaidID;
    public String PatientOtherID;
    public String PatientTimezone;
    public String SequenceID;
    public List<PatientAdressEntity> Address;
    public List<IndividualPayerInformationModel> IndividualPayerInformation;
    public List<PatientPhonesEntity> Phones;
    public List<ResponsiblePartyModel> ResponsibleParty;

    public String getBusinessEntityID() {
        return BusinessEntityID;
    }

    public void setBusinessEntityID(String businessEntityID) {
        BusinessEntityID = businessEntityID;
    }

    public String getBusinessEntityMedicaidIdentifier() {
        return BusinessEntityMedicaidIdentifier;
    }

    public void setBusinessEntityMedicaidIdentifier(String businessEntityMedicaidIdentifier) {
        BusinessEntityMedicaidIdentifier = businessEntityMedicaidIdentifier;
    }

    public void setPatientNewborn(boolean patientNewborn) {
        IsPatientNewborn = patientNewborn;
    }

    public String getPatientAlternateID() {
        return PatientAlternateID;
    }

    public void setPatientAlternateID(String patientAlternateID) {
        PatientAlternateID = patientAlternateID;
    }

    public String getPatientFirstName() {
        return PatientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        PatientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return PatientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        PatientLastName = patientLastName;
    }

    public String getPatientMedicaidID() {
        return PatientMedicaidID;
    }

    public void setPatientMedicaidID(String patientMedicaidID) {
        PatientMedicaidID = patientMedicaidID;
    }

    public String getPatientOtherID() {
        return PatientOtherID;
    }

    public void setPatientOtherID(String patientOtherID) {
        PatientOtherID = patientOtherID;
    }

    public String getPatientTimezone() {
        return PatientTimezone;
    }

    public void setPatientTimezone(String patientTimezone) {
        PatientTimezone = patientTimezone;
    }

    public String getSequenceID() {
        return SequenceID;
    }

    public void setSequenceID(String sequenceID) {
        SequenceID = sequenceID;
    }

    public List<PatientAdressEntity> getAddress() {
        return Address;
    }

    public void setAddress(List<PatientAdressEntity> address) {
        Address = address;
    }

    public List<IndividualPayerInformationModel> getIndividualPayerInformation() {
        return IndividualPayerInformation;
    }

    public void setIndividualPayerInformation(List<IndividualPayerInformationModel> individualPayerInformation) {
        IndividualPayerInformation = individualPayerInformation;
    }

    public List<PatientPhonesEntity> getPhones() {
        return Phones;
    }

    public void setPhones(List<PatientPhonesEntity> phones) {
        Phones = phones;
    }

    public List<ResponsiblePartyModel> getResponsibleParty() {
        return ResponsibleParty;
    }

    public void setResponsibleParty(List<ResponsiblePartyModel> responsibleParty) {
        ResponsibleParty = responsibleParty;
    }
}
