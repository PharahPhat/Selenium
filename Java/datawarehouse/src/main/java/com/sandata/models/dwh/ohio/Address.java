package com.sandata.models.dwh.ohio;

public class Address {
    public String PatientVisitVerificationID;
    public String PatientID;
    public String BusinessEntityID;
    public String PatientAddressType;
    public boolean PatientAddressIsPrimary;
    public String PatientAddressLine1;
    public String PatientAddressLine2;
    public String PatientCity;
    public String PatientState;
    public String PatientZip;
    public double PatientAddressLongitude;
    public double PatientAddressLatitude;
    public String PatientTimezone;

    public boolean getDataIsNotNull(){
        return PatientID != null && BusinessEntityID != null;
    }
}
