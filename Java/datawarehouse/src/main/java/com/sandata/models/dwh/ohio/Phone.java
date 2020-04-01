package com.sandata.models.dwh.ohio;

public class Phone {
    public String PatientVisitVerificationID;
    public String PatientID;
    public String BusinessEntityID;
    public String PatientPhoneType;
    public String PatientPhoneNumber;

    public boolean getDataIsNotNull(){
        return PatientID != null && BusinessEntityID != null && PatientPhoneType != null;
    }
}
