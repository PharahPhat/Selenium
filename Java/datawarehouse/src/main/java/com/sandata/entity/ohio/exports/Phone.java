package com.sandata.entity.ohio.exports;

public class Phone {
    public String PatientVisitVerificationID;
    public String PatientID;
    public String BusinessEntityID;
    public String PatientPhoneType;
    public String PatientPhoneNumber;

    public String getPatientVisitVerificationID() {
        return PatientVisitVerificationID;
    }

    public void setPatientVisitVerificationID(String patientVisitVerificationID) {
        PatientVisitVerificationID = patientVisitVerificationID;
    }

    public String getPatientID() {
        return PatientID;
    }

    public void setPatientID(String patientID) {
        PatientID = patientID;
    }

    public String getBusinessEntityID() {
        return BusinessEntityID;
    }

    public void setBusinessEntityID(String businessEntityID) {
        BusinessEntityID = businessEntityID;
    }

    public String getPatientPhoneType() {
        return PatientPhoneType;
    }

    public void setPatientPhoneType(String patientPhoneType) {
        PatientPhoneType = patientPhoneType;
    }

    public String getPatientPhoneNumber() {
        return PatientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        PatientPhoneNumber = patientPhoneNumber;
    }
}
