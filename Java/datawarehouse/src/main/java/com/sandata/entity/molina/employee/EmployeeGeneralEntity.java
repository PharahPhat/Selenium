package com.sandata.entity.molina.employee;

import com.sandata.entity.exportDWH.ProviderIdentification;
import com.sandata.entity.generic.EmployeeGenericEntity;

public class EmployeeGeneralEntity extends EmployeeGenericEntity {
    public com.sandata.entity.exportDWH.ProviderIdentification ProviderIdentification;
    public String EmployeeIdentifier;
    public String EmployeeOtherID;
    public String SequenceID;
    public String EmployeeQualifier;
    public String EmployeeSSN;
    public String EmployeeLastName;
    public String EmployeeFirstName;
    public String EmployeeEmail;
    public String EmployeeManagerEmail;
    public String EmployeePosition;
    public String EmployeeAPI;

    public ProviderIdentification getProviderIdentification() {
        return ProviderIdentification;
    }

    public void setProviderIdentification(ProviderIdentification providerIdentification) {
        this.ProviderIdentification = providerIdentification;
    }

    public String getEmployeeIdentifier() {
        return EmployeeIdentifier;
    }

    public void setEmployeeIdentifier(String employeeIdentifier) {
        EmployeeIdentifier = employeeIdentifier;
    }

    public String getEmployeeOtherID() {
        return EmployeeOtherID;
    }

    public void setEmployeeOtherID(String employeeOtherID) {
        EmployeeOtherID = employeeOtherID;
    }

    public String getSequenceID() {
        return SequenceID;
    }

    public void setSequenceID(String sequenceID) {
        SequenceID = sequenceID;
    }

    public String getEmployeeQualifier() {
        return EmployeeQualifier;
    }

    public void setEmployeeQualifier(String employeeQualifier) {
        EmployeeQualifier = employeeQualifier;
    }

    public String getEmployeeSSN() {
        return EmployeeSSN;
    }

    public void setEmployeeSSN(String employeeSSN) {
        EmployeeSSN = employeeSSN;
    }

    public String getEmployeeLastName() {
        return EmployeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        EmployeeLastName = employeeLastName;
    }

    public String getEmployeeFirstName() {
        return EmployeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        if(employeeFirstName != null)
            EmployeeFirstName = employeeFirstName;
    }

    public String getEmployeeEmail() {
        return EmployeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        EmployeeEmail = employeeEmail;
    }

    public String getEmployeeManagerEmail() {
        return EmployeeManagerEmail;
    }

    public void setEmployeeManagerEmail(String employeeManagerEmail) {
        EmployeeManagerEmail = employeeManagerEmail;
    }

    public String getEmployeePosition() {
        return EmployeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        EmployeePosition = employeePosition;
    }

    public String getEmployeeAPI() {
        return EmployeeAPI;
    }

    public void setEmployeeAPI(String employeeAPI) {
        EmployeeAPI = employeeAPI;
    }
}
