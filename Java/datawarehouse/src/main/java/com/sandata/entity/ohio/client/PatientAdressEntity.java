package com.sandata.entity.ohio.client;

public class PatientAdressEntity {
    public boolean PatientAddressIsPrimary;
    public String PatientAddressLine1;
    public String PatientAddressLine2;
    public String PatientAddressType;
    public String PatientCity;
    public double PatientLatitude;
    public double PatientLongitude;
    public String PatientState;
    public String PatientTimezone;
    public String PatientZip;

    public boolean isPatientAddressIsPrimary() {
        return PatientAddressIsPrimary;
    }

    public void setPatientAddressIsPrimary(boolean patientAddressIsPrimary) {
        PatientAddressIsPrimary = patientAddressIsPrimary;
    }

    public String getPatientAddressLine1() {
        return PatientAddressLine1;
    }

    public void setPatientAddressLine1(String patientAddressLine1) {
        PatientAddressLine1 = patientAddressLine1;
    }

    public String getPatientAddressLine2() {
        return PatientAddressLine2;
    }

    public void setPatientAddressLine2(String patientAddressLine2) {
        PatientAddressLine2 = patientAddressLine2;
    }

    public String getPatientAddressType() {
        return PatientAddressType;
    }

    public void setPatientAddressType(String patientAddressType) {
        PatientAddressType = patientAddressType;
    }

    public String getPatientCity() {
        return PatientCity;
    }

    public void setPatientCity(String patientCity) {
        PatientCity = patientCity;
    }

    public double getPatientLatitude() {
        return PatientLatitude;
    }

    public void setPatientLatitude(double patientLatitude) {
        PatientLatitude = patientLatitude;
    }

    public double getPatientLongitude() {
        return PatientLongitude;
    }

    public void setPatientLongitude(double patientLongitude) {
        PatientLongitude = patientLongitude;
    }

    public String getPatientState() {
        return PatientState;
    }

    public void setPatientState(String patientState) {
        PatientState = patientState;
    }

    public String getPatientTimezone() {
        return PatientTimezone;
    }

    public void setPatientTimezone(String patientTimezone) {
        PatientTimezone = patientTimezone;
    }

    public String getPatientZip() {
        return PatientZip;
    }

    public void setPatientZip(String patientZip) {
        PatientZip = patientZip;
    }
}
