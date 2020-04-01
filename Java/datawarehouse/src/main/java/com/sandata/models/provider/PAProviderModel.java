package com.sandata.models.provider;

import com.google.gson.annotations.SerializedName;
import com.sandata.models.GenericModel;

public class PAProviderModel extends GenericModel {
    @SerializedName("ProviderQualifier")
    public String ProviderQualifier;

    @SerializedName("ProviderID")
    public String ProviderID;

    @SerializedName("ProviderName")
    public String ProviderName;

    @SerializedName("PayerID")
    public String PayerID;

    @SerializedName("AddressLine1")
    public String AddressLine1;

    @SerializedName("AddressCity")
    public String AddressCity;

    @SerializedName("AddressState")
    public String AddressState;

    @SerializedName("AddressZip")
    public String AddressZip;

    @SerializedName("County")
    public String County;

    @SerializedName("AgencyPhone")
    public String AgencyPhone;

    @SerializedName("AgencyEmail")
    public String AgencyEmail;

    @SerializedName("PrimaryContactLastName")
    public String PrimaryContactLastName;

    @SerializedName("PrimaryContactFirstName")
    public String PrimaryContactFirstName;

    @SerializedName("ProviderFax")
    public String ProviderFax;

    @SerializedName("ProviderNPI")
    public String ProviderNPI;

    @SerializedName("ProviderAPI")
    public String ProviderAPI;

    @SerializedName("TaxID")
    public String TaxID;

    @SerializedName("ProviderRequireAuth")
    public String ProviderRequireAuth;

    public String getProviderQualifier() {
        return ProviderQualifier;
    }

    public void setProviderQualifier(String providerQualifier) {
        ProviderQualifier = providerQualifier;
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

    public String getPayerID() {
        return PayerID;
    }

    public void setPayerID(String payerID) {
        PayerID = payerID;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
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

    public String getTaxID() {
        return TaxID;
    }

    public void setTaxID(String taxID) {
        TaxID = taxID;
    }

    public String getProviderRequireAuth() {
        return ProviderRequireAuth;
    }

    public void setProviderRequireAuth(String providerRequireAuth) {
        ProviderRequireAuth = providerRequireAuth;
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }
}
