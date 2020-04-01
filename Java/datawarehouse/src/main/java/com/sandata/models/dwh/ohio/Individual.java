package com.sandata.models.dwh.ohio;

import java.util.List;

public class Individual {
    private String PatientID;
    private String PatientOtherID;
    private String SequenceID;
    private String BusinessEntityID;
    private String PatientVisitVerificationID;
    private String PatientMedicaidID;
    private boolean isPatientNewborn;
    private String PatientAlternateID;
    private String PatientLastName;
    private String PatientFirstName;
    private String PatientTimezone;
    private String PatientRecordDateTime;
    private List<PatientPayerInformation> PatientPayerInformation;
    private List<Address> Address;
    private List<Phone> Phone;
    List<ResponsibleParty> ResponsibleParty;

    public boolean getDataIsNotNull(){
        return (PatientID != null && PatientLastName  != null
                && PatientFirstName  != null &&Address.size() > 0);
    }

    public List<Phone> getPhone(){
        return Phone;
    }

    public List<Address> getAddress() { return Address;}

}
