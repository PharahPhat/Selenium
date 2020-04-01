package com.sandata.models.interfaces.open_evv_generic.provider.Generic;

import com.sandata.models.GenericModel;

public class GenericProvider extends GenericModel {
    public String getProviderID() {
        return ProviderID;
    }

    public void setProviderID(String providerID) {
        ProviderID = providerID;
    }

    public String getProviderQualifier() {
        return ProviderQualifier;
    }

    public void setProviderQualifier(String providerQualifier) {
        ProviderQualifier = providerQualifier;
    }

    public String getProviderName() {
        return ProviderName;
    }

    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }

    public String getPayerID() {
        return PayerID;
    }

    public void setPayerID(String payerID) {
        PayerID = payerID;
    }

    public String getProviderDoingBusinessAs() {
        return ProviderDoingBusinessAs;
    }

    public void setProviderDoingBusinessAs(String providerDoingBusinessAs) {
        ProviderDoingBusinessAs = providerDoingBusinessAs;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        AddressLine2 = addressLine2;
    }

    public String getAddressCity() {
        return AddressCity;
    }

    public void setAddressCity(String addressCity) {
        AddressCity = addressCity;
    }

    public String getAddressState() {
        return AddressState;
    }

    public void setAddressState(String addressState) {
        AddressState = addressState;
    }

    public String getAddressZip() {
        return AddressZip;
    }

    public void setAddressZip(String addressZip) {
        AddressZip = addressZip;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
    }

    public String getAgencyPhone() {
        return AgencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        AgencyPhone = agencyPhone;
    }

    public String getAgencyEmail() {
        return AgencyEmail;
    }

    public void setAgencyEmail(String agencyEmail) {
        AgencyEmail = agencyEmail;
    }

    public String getPrimaryContactLastName() {
        return PrimaryContactLastName;
    }

    public void setPrimaryContactLastName(String primaryContactLastName) {
        PrimaryContactLastName = primaryContactLastName;
    }

    public String getPrimaryContactFirstName() {
        return PrimaryContactFirstName;
    }

    public void setPrimaryContactFirstName(String primaryContactFirstName) {
        PrimaryContactFirstName = primaryContactFirstName;
    }

    public String getProviderFax() {
        return ProviderFax;
    }

    public void setProviderFax(String providerFax) {
        ProviderFax = providerFax;
    }

    public String getProviderNPI() {
        return ProviderNPI;
    }

    public void setProviderNPI(String providerNPI) {
        ProviderNPI = providerNPI;
    }

    public String getProviderAPI() {
        return ProviderAPI;
    }

    public void setProviderAPI(String providerAPI) {
        ProviderAPI = providerAPI;
    }

    public String getProviderMedicaidID() {
        return ProviderMedicaidID;
    }

    public void setProviderMedicaidID(String providerMedicaidID) {
        ProviderMedicaidID = providerMedicaidID;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getTaxID() {
        return TaxID;
    }

    public void setTaxID(String taxID) {
        TaxID = taxID;
    }

    public String getProviderTaxonomy() {
        return ProviderTaxonomy;
    }

    public void setProviderTaxonomy(String providerTaxonomy) {
        ProviderTaxonomy = providerTaxonomy;
    }

    public String getProviderRequireAuth() {
        return ProviderRequireAuth;
    }

    public void setProviderRequireAuth(String providerRequireAuth) {
        ProviderRequireAuth = providerRequireAuth;
    }

    public String getSuspensionDate() {
        return SuspensionDate;
    }

    public void setSuspensionDate(String suspensionDate) {
        SuspensionDate = suspensionDate;
    }

    public String getTerminationDate() {
        return TerminationDate;
    }

    public void setTerminationDate(String terminationDate) {
        TerminationDate = terminationDate;
    }

    public String ProviderID = "";
    public String ProviderQualifier = "";
    public String ProviderName = "";
    public String PayerID = "";
    public String ProviderDoingBusinessAs = "";
    public String AddressLine1 = "";
    public String AddressLine2 = "";
    public String AddressCity = "";
    public String AddressState = "";
    public String AddressZip = "";
    public String County = "";
    public String AgencyPhone = "";
    public String AgencyEmail = "";
    public String PrimaryContactLastName = "";
    public String PrimaryContactFirstName = "";
    public String ProviderFax = "";
    public String ProviderNPI = "";
    public String ProviderAPI = "";
    public String ProviderMedicaidID = "";
    public String SSN = "";
    public String TaxID = "";
    public String ProviderTaxonomy = "";
    public String ProviderRequireAuth = "";
    public String SuspensionDate = "";
    public String TerminationDate = "";

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }
}
