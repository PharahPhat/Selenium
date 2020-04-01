package com.sandata.models.dwh.ohio;

import java.util.ArrayList;
import java.util.List;

public class DwhExtract {
    private String BusinessEntityID;
    private String BusinessEntityMedicaidIdentifier;
    private String VendorID;
    private String ProviderID;
    private String ProviderName;
    private String AccountCreateDateTime;
    private String ExportDateTime;
    private List<Individual> Individual;
    private List<Staff> Staff;
    private List<Visit> Visit;

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

    public String getVendorID() {
        return VendorID;
    }

    public void setVendorID(String vendorID) {
        VendorID = vendorID;
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

    public List<com.sandata.models.dwh.ohio.Individual> getIndividual() {
        return Individual;
    }

    public void setIndividual(List<com.sandata.models.dwh.ohio.Individual> individual) {
        Individual = individual;
    }

    public List<com.sandata.models.dwh.ohio.Staff> getStaff() {
        return Staff;
    }

    public void setStaff(List<com.sandata.models.dwh.ohio.Staff> staff) {
        Staff = staff;
    }

    public List<com.sandata.models.dwh.ohio.Visit> getVisit() {
        return Visit;
    }

    public void setVisit(List<com.sandata.models.dwh.ohio.Visit> visit) {
        Visit = visit;
    }
}
