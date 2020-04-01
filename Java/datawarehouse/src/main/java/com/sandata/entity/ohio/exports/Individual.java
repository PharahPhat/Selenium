package com.sandata.entity.ohio.exports;

import java.util.List;

public class Individual {
    public String PatientID;
    public String PatientOtherID;
    public String SequenceID;
    public String BusinessEntityID;
    public String PatientVisitVerificationID;
    public String PatientMedicaidID;
    public String isPatientNewborn;
    public String PatientAlternateID;
    public String PatientLastName;
    public String PatientFirstName;
    public String PatientTimezone;
    public String PatientRecordDateTime;

    List<PatientPayerInformation> PatientPayerInformation;
    List<Address> Address;
    List<Phone> Phone;
    List<ResponsibleParty> ResponsibleParty;

    public String getPatientID() {
        return PatientID;
    }

    public void setPatientID(String patientID) {
        PatientID = patientID;
    }

    public String getPatientOtherID() {
        return PatientOtherID;
    }

    public void setPatientOtherID(String patientOtherID) {
        PatientOtherID = patientOtherID;
    }

    public String getSequenceID() {
        return SequenceID;
    }

    public void setSequenceID(String sequenceID) {
        SequenceID = sequenceID;
    }

    public String getBusinessEntityID() {
        return BusinessEntityID;
    }

    public void setBusinessEntityID(String businessEntityID) {
        BusinessEntityID = businessEntityID;
    }

    public String getPatientVisitVerificationID() {
        return PatientVisitVerificationID;
    }

    public void setPatientVisitVerificationID(String patientVisitVerificationID) {
        PatientVisitVerificationID = patientVisitVerificationID;
    }

    public String getPatientMedicaidID() {
        return PatientMedicaidID;
    }

    public void setPatientMedicaidID(String patientMedicaidID) {
        PatientMedicaidID = patientMedicaidID;
    }

    public String getIsPatientNewborn() {
        return isPatientNewborn;
    }

    public void setIsPatientNewborn(String isPatientNewborn) {
        this.isPatientNewborn = isPatientNewborn;
    }

    public String getPatientAlternateID() {
        return PatientAlternateID;
    }

    public void setPatientAlternateID(String patientAlternateID) {
        PatientAlternateID = patientAlternateID;
    }

    public String getPatientLastName() {
        return PatientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        PatientLastName = patientLastName;
    }

    public String getPatientFirstName() {
        return PatientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        PatientFirstName = patientFirstName;
    }

    public String getPatientTimezone() {
        return PatientTimezone;
    }

    public void setPatientTimezone(String patientTimezone) {
        PatientTimezone = patientTimezone;
    }

    public String getPatientRecordDateTime() {
        return PatientRecordDateTime;
    }

    public void setPatientRecordDateTime(String patientRecordDateTime) {
        PatientRecordDateTime = patientRecordDateTime;
    }

    public List<com.sandata.entity.ohio.exports.PatientPayerInformation> getPatientPayerInformation() {
        return PatientPayerInformation;
    }

    public void setPatientPayerInformation(List<com.sandata.entity.ohio.exports.PatientPayerInformation> patientPayerInformation) {
        PatientPayerInformation = patientPayerInformation;
    }

    public List<com.sandata.entity.ohio.exports.Address> getAddress() {
        return Address;
    }

    public void setAddress(List<com.sandata.entity.ohio.exports.Address> address) {
        Address = address;
    }

    public List<com.sandata.entity.ohio.exports.Phone> getPhone() {
        return Phone;
    }

    public void setPhone(List<com.sandata.entity.ohio.exports.Phone> phone) {
        Phone = phone;
    }

    public List<com.sandata.entity.ohio.exports.ResponsibleParty> getResponsibleParty() {
        return ResponsibleParty;
    }

    public void setResponsibleParty(List<com.sandata.entity.ohio.exports.ResponsibleParty> responsibleParty) {
        ResponsibleParty = responsibleParty;
    }
}
