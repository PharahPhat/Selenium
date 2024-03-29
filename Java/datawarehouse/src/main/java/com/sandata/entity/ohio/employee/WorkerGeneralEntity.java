package com.sandata.entity.ohio.employee;

import com.sandata.entity.generic.EmployeeGenericEntity;

public class WorkerGeneralEntity extends EmployeeGenericEntity {
    public String BusinessEntityID;
    public String BusinessEntityMedicaidIdentifier;
    public String StaffOtherID;
    public String SequenceID;
    public String StaffID;
    public String StaffSSN;
    public String StaffLastName;
    public String StaffFirstName;
    public String StaffEmail;
    public String StaffPosition;

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

    public String getStaffOtherID() {
        return StaffOtherID;
    }

    public void setStaffOtherID(String staffOtherID) {
        StaffOtherID = staffOtherID;
    }

    public String getSequenceID() {
        return SequenceID;
    }

    public void setSequenceID(String sequenceID) {
        SequenceID = sequenceID;
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
}
