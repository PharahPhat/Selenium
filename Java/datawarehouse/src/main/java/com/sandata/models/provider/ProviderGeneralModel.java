package com.sandata.models.provider;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import com.sandata.core.annotation.DataTableColumn;

import java.util.Objects;

public class ProviderGeneralModel extends ProviderGenericModel{
    @CsvHeader("ProviderQualifier")
    @Column("ProviderQualifier")
    @DataTableColumn
    private String providerQualifier;

    @CsvHeader("ProviderID")
    @Column(value = "ProviderID", index = 1)
    @DataTableColumn
    private String providerID;

    @Column(index = 2)
    public String payerId;

    @CsvHeader("ProviderName")
    @Column(value = "ProviderName", index = 4)
    @DataTableColumn
    private String providerName;

    @CsvHeader("ProviderDoingBusinessAs")
    @Column("ProviderDoingBusinessAs")
    @DataTableColumn
    private String providerDoingBusinessAs;

    @CsvHeader("AddressLine1")
    @Column("AddressLine1")
    @DataTableColumn
    private String addressLine1;

    @CsvHeader("AddressLine2")
    @Column("AddressLine2")
    @DataTableColumn
    private String addressLine2;

    @CsvHeader("AddressCity")
    @Column("AddressCity")
    @DataTableColumn
    private String addressCity;

    @CsvHeader("AddressState")
    @Column("AddressState")
    @DataTableColumn
    private String addressState;

    @CsvHeader("AddressZip")
    @Column("AddressZip")
    @DataTableColumn
    private String addressZip;

    @CsvHeader("County")
    @Column("County")
    @DataTableColumn
    private String county;

    @CsvHeader("AgencyPhone")
    @Column("AgencyPhone")
    @DataTableColumn
    private String agencyPhone;

    @CsvHeader("AgencyEmail")
    @Column("AgencyEmail")
    @DataTableColumn
    private String agencyEmail;

    @CsvHeader("PrimaryContactLastName")
    @Column("PrimaryContactLastName")
    @DataTableColumn
    private String primaryContactLastName;

    @CsvHeader("PrimaryContactFirstName")
    @Column("PrimaryContactFirstName")
    @DataTableColumn
    private String primaryContactFirstName;

    @CsvHeader("ProviderFax")
    @Column("ProviderFax")
    @DataTableColumn
    private String providerFax;

    @CsvHeader("ProviderNPI")
    @Column("ProviderNPI")
    @DataTableColumn
    private String providerNPI;

    @CsvHeader("ProviderAPI")
    @Column("ProviderAPI")
    @DataTableColumn
    private String providerAPI;

    @CsvHeader("ProviderMedicaidID")
    @Column("ProviderMedicaidID")
    @DataTableColumn
    private String providerMedicaidID;

    @CsvHeader("SSN")
    @Column("SSN")
    @DataTableColumn
    private String sSN;

    @CsvHeader("TaxID")
    @Column("TaxID")
    @DataTableColumn
    private String taxID;

    @CsvHeader("ProviderTaxonomy")
    @Column("ProviderTaxonomy")
    @DataTableColumn
    private String providerTaxonomy;

    @CsvHeader("ProviderRequireAuth")
    @Column("ProviderRequireAuth")
    @DataTableColumn
    private String providerRequireAuth;

    @CsvHeader("ProviderTimeZone")
    @Column("ProviderTimeZone")
    @DataTableColumn
    private String providerTimeZone;

    @Column("ProviderDateBegin")
    @CsvHeader("ProviderDateBegin")
    @DataTableColumn
    private String providerDateBegin;

    @CsvHeader("ProviderDateEnd")
    @Column("ProviderDateEnd")
    @DataTableColumn
    private String providerDateEnd;

    public String getProviderQualifier() {
        return providerQualifier;
    }

    public void setProviderQualifier(String providerQualifier) {
        this.providerQualifier = providerQualifier;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderDoingBusinessAs() {
        return providerDoingBusinessAs;
    }

    public void setProviderDoingBusinessAs(String providerDoingBusinessAs) {
        this.providerDoingBusinessAs = providerDoingBusinessAs;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(String addressZip) {
        this.addressZip = addressZip;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAgencyPhone() {
        return agencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        this.agencyPhone = agencyPhone;
    }

    public String getAgencyEmail() {
        return agencyEmail;
    }

    public void setAgencyEmail(String agencyEmail) {
        this.agencyEmail = agencyEmail;
    }

    public String getPrimaryContactLastName() {
        return primaryContactLastName;
    }

    public void setPrimaryContactLastName(String primaryContactLastName) {
        this.primaryContactLastName = primaryContactLastName;
    }

    public String getPrimaryContactFirstName() {
        return primaryContactFirstName;
    }

    public void setPrimaryContactFirstName(String primaryContactFirstName) {
        this.primaryContactFirstName = primaryContactFirstName;
    }

    public String getProviderFax() {
        return providerFax;
    }

    public void setProviderFax(String providerFax) {
        this.providerFax = providerFax;
    }

    public String getProviderNPI() {
        return providerNPI;
    }

    public void setProviderNPI(String providerNPI) {
        this.providerNPI = providerNPI;
    }

    public String getProviderAPI() {
        return providerAPI;
    }

    public void setProviderAPI(String providerAPI) {
        this.providerAPI = providerAPI;
    }

    public String getProviderMedicaidID() {
        return providerMedicaidID;
    }

    public void setProviderMedicaidID(String providerMedicaidID) {
        this.providerMedicaidID = providerMedicaidID;
    }

    public String getsSN() {
        return sSN;
    }

    public void setsSN(String sSN) {
        this.sSN = sSN;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public String getProviderTaxonomy() {
        return providerTaxonomy;
    }

    public void setProviderTaxonomy(String providerTaxonomy) {
        this.providerTaxonomy = providerTaxonomy;
    }

    public String getProviderRequireAuth() {
        return providerRequireAuth;
    }

    public void setProviderRequireAuth(String providerRequireAuth) {
        this.providerRequireAuth = providerRequireAuth;
    }

    public String getProviderTimeZone() {
        return providerTimeZone;
    }

    public void setProviderTimeZone(String providerTimeZone) {
        this.providerTimeZone = providerTimeZone;
    }

    public String getProviderDateBegin() {
        return providerDateBegin;
    }

    public void setProviderDateBegin(String providerDateBegin) {
        this.providerDateBegin = providerDateBegin;
    }

    public String getProviderDateEnd() {
        return providerDateEnd;
    }

    public void setProviderDateEnd(String providerDateEnd) {
        this.providerDateEnd = providerDateEnd;
    }

    @Override
    public String toString() {
        String toString  = "ProviderGeneralModel{" +
                "providerQualifier='" + providerQualifier + '\'' +
                ", providerID='" + providerID + '\'' +
                ", providerName='" + providerName + '\'' +
                ", providerDoingBusinessAs='" + providerDoingBusinessAs + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressState='" + addressState + '\'' +
                ", addressZip='" + addressZip + '\'' +
                ", county='" + county + '\'' +
                ", agencyPhone='" + agencyPhone + '\'' +
                ", agencyEmail='" + agencyEmail + '\'' +
                ", primaryContactLastName='" + primaryContactLastName + '\'' +
                ", primaryContactFirstName='" + primaryContactFirstName + '\'' +
                ", providerFax='" + providerFax + '\'' +
                ", providerNPI='" + providerNPI + '\'' +
                //TODO: will check providerAPI, now see it not match between file & db.
                //", providerAPI='" + providerAPI + '\'' +
                ", providerMedicaidID='" + providerMedicaidID + '\'' +
                ", sSN='" + sSN + '\'' +
                ", taxID='" + taxID + '\'' +
                ", providerTaxonomy='" + providerTaxonomy + '\'' +
                ", providerRequireAuth='" + providerRequireAuth + '\'' +
                ", providerTimeZone='" + providerTimeZone + '\'' +
//TODO: Currently 2 fields export with format diff on DBl.
//                ", providerDateBegin='" + providerDateBegin + '\'' +
//                ", providerDateEnd='" + providerDateEnd + '\'' +
                '}';
        return toString.replace("null", "");
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        if (Objects.isNull(providerID)) {
            return false;
        }
        if (Objects.isNull(payerId)) {
            return false;
        }
        if (Objects.isNull(providerName)) {
            return false;
        }
        return true;
    }
}
