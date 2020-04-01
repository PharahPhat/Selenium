package com.sandata.models.dwh.ohio;

public class Staff {
    private String BusinessEntityID;
    private String StaffOtherID;
    private String SequenceID;
    private String StaffID;
    private String StaffSSN;
    private String StaffLastName;
    private String StaffFirstName;
    private String StaffEmail;
    private String StaffPosition;
    private String StaffRecordDateTime;

    public boolean getDataIsNotNull(){
        return (BusinessEntityID != null && StaffOtherID != null && SequenceID != null && StaffID != null
                && StaffSSN != null &&  StaffLastName  != null && StaffFirstName  != null && StaffEmail  != null && StaffRecordDateTime  != null);
    }


    public String getBusinessEntityID() {
        return BusinessEntityID;
    }

    public void setBusinessEntityID(String businessEntityID) {
        BusinessEntityID = businessEntityID;
    }

    public String getStaffOtherID() {
        return StaffOtherID;
    }

    public void setStaffOtherID(String staffOtherID) {
        StaffOtherID = staffOtherID;
    }

    public String getEquenceID() {
        return SequenceID;
    }

    public void setEquenceID(String equenceID) {
        this.SequenceID = equenceID;
    }

    public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String staffID) {
        StaffID = staffID;
    }

    public String getStaffSSN() {
        return StaffSSN;
    }

    public void setStaffSSN(String staffSSN) {
        StaffSSN = staffSSN;
    }

    public String getStaffLastName() {
        return StaffLastName;
    }

    public void setStaffLastName(String staffLastName) {
        StaffLastName = staffLastName;
    }

    public String getStaffFirstName() {
        return StaffFirstName;
    }

    public void setStaffFirstName(String staffFirstName) {
        StaffFirstName = staffFirstName;
    }

    public String getStaffEmail() {
        return StaffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        StaffEmail = staffEmail;
    }

    public String getStaffPosition() {
        return StaffPosition;
    }

    public void setStaffPosition(String staffPosition) {
        StaffPosition = staffPosition;
    }

    public String getStaffRecordDateTime() {
        return StaffRecordDateTime;
    }

    public void setStaffRecordDateTime(String staffRecordDateTime) {
        StaffRecordDateTime = staffRecordDateTime;
    }
}
