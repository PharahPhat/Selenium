package com.sandata.entity.ohio.exports;

import java.util.List;

public class JsonOhioExportEntity {
    public String BusinessEntityID;
    public String VendorID;
    public String BusinessEntityMedicaidIdentifier;
    public String ProviderID;
    public String ProviderName;
    public String AccountCreateDateTime;
    public String ExportDateTime;
    public List<Individual> Individual;
    public List<Staff> Staff;
    public List<Visit> Visit;

    public List<Visit> getVisits() {
        return Visit;
    }

    public void setVisits(List<Visit> visits) {
        Visit = visits;
    }
    public String getBusinessEntityID() {
        return BusinessEntityID;
    }

    public void setBusinessEntityID(String businessEntityID) {
        BusinessEntityID = businessEntityID;
    }

    public String getVendorID() {
        return VendorID;
    }

    public void setVendorID(String vendorID) {
        VendorID = vendorID;
    }

    public String getBusinessEntityMedicaidIdentifier() {
        return BusinessEntityMedicaidIdentifier;
    }

    public void setBusinessEntityMedicaidIdentifier(String businessEntityMedicaidIdentifier) {
        BusinessEntityMedicaidIdentifier = businessEntityMedicaidIdentifier;
    }

    public String getProviderID() {
        return ProviderID;
    }

    public void setProviderID(String providerID) {
        ProviderID = providerID;
    }

    public String getProviderName() {
        return ProviderName;
    }

    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }

    public String getAccountCreateDateTime() {
        return AccountCreateDateTime;
    }

    public void setAccountCreateDateTime(String accountCreateDateTime) {
        AccountCreateDateTime = accountCreateDateTime;
    }

    public String getExportDateTime() {
        return ExportDateTime;
    }

    public void setExportDateTime(String exportDateTime) {
        ExportDateTime = exportDateTime;
    }

    public List<com.sandata.entity.ohio.exports.Individual> getIndividual() {
        return Individual;
    }

    public void setIndividual(List<com.sandata.entity.ohio.exports.Individual> individual) {
        Individual = individual;
    }

    public List<com.sandata.entity.ohio.exports.Staff> getStaff() {
        return Staff;
    }

    public void setStaff(List<com.sandata.entity.ohio.exports.Staff> staff) {
        Staff = staff;
    }

    public List<com.sandata.entity.ohio.exports.Visit> getVisit() {
        return Visit;
    }

    public void setVisit(List<com.sandata.entity.ohio.exports.Visit> visit) {
        Visit = visit;
    }
}
