package com.interop.models.openevv.provider;


import com.google.gson.annotations.SerializedName;
import com.interop.models.openevv.OpenEvvBaseModel;
import com.sandata.batch.OracleColumn;
import com.sandata.core.annotation.CsvHeader;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OpenEvvProviderModel extends OpenEvvBaseModel {

    @OracleColumn("ProviderID")
    @CsvHeader("ProviderID")
    @SerializedName("ProviderID")
    public String providerID;

    @OracleColumn("ProviderQualifier")
    @CsvHeader("ProviderQualifier")
    @SerializedName("ProviderQualifier")
    public String providerQualifier;

    @OracleColumn("ProviderName")
    @CsvHeader("ProviderName")
    @SerializedName("ProviderName")
    public String providerName;

    @OracleColumn("PayerID")
    @CsvHeader("PayerID")
    @SerializedName("PayerID")
    public String payerID;

    @OracleColumn("ProviderDoingBusinessAs")
    @CsvHeader("ProviderDoingBusinessAs")
    @SerializedName("ProviderDoingBusinessAs")
    public String providerDoingBusinessAs;


    @OracleColumn("AddressLine1")
    @CsvHeader("AddressLine1")
    @SerializedName("AddressLine1")
    public String addressLine1;

    @OracleColumn("AddressLine2")
    @CsvHeader("AddressLine2")
    @SerializedName("AddressLine2")
    public String addressLine2;

    @OracleColumn("AddressCity")
    @CsvHeader("AddressCity")
    @SerializedName("AddressCity")
    public String addressCity;

    @OracleColumn("AddressState")
    @CsvHeader("AddressState")
    @SerializedName("AddressState")
    public String addressState;

    @OracleColumn("County")
    @CsvHeader("County")
    @SerializedName("County")
    public String county;


    @OracleColumn("AddressZip")
    @CsvHeader("AddressZip")
    @SerializedName("AddressZip")
    public String addressZip;

    @OracleColumn("AgencyPhone")
    @CsvHeader("AgencyPhone")
    @SerializedName("AgencyPhone")
    public String agencyPhone;

    @OracleColumn("AgencyEmail")
    @CsvHeader("AgencyEmail")
    @SerializedName("AgencyEmail")
    public String agencyEmail;

    @OracleColumn("PrimaryContactLastName")
    @CsvHeader("PrimaryContactLastName")
    @SerializedName("PrimaryContactLastName")
    public String primaryContactLastName;

    @OracleColumn("PrimaryContactFirstName")
    @CsvHeader("PrimaryContactFirstName")
    @SerializedName("PrimaryContactFirstName")
    public String primaryContactFirstName;

    @OracleColumn("ProviderFax")
    @CsvHeader("ProviderFax")
    @SerializedName("ProviderFax")
    public String providerFax;

    @OracleColumn("ProviderNPI")
    @CsvHeader("ProviderNPI")
    @SerializedName("ProviderNPI")
    public String providerNPI;

    @OracleColumn("ProviderAPI")
    @CsvHeader("ProviderAPI")
    @SerializedName("ProviderAPI")
    public String providerAPI;

    @OracleColumn("ProviderMedicaidID")
    @CsvHeader("ProviderMedicaidID")
    @SerializedName("ProviderMedicaidID")
    public String providerMedicaidID;

    @OracleColumn("SSN")
    @CsvHeader("SSN")
    @SerializedName("SSN")
    public String ssn;

    @OracleColumn("TaxID")
    @CsvHeader("TaxID")
    @SerializedName("TaxID")
    public String taxID;

    @OracleColumn("ProviderTaxonomy")
    @CsvHeader("ProviderTaxonomy")
    @SerializedName("ProviderTaxonomy")
    public String providerTaxonomy;

    @OracleColumn("ProviderRequireAuth")
    @CsvHeader("ProviderRequireAuth")
    @SerializedName("ProviderRequireAuth")
    public String providerRequireAuth;

    @OracleColumn("ProviderDateBegin")
    @CsvHeader("ProviderDateBegin")
    @SerializedName("ProviderDateBegin")
    public String providerDateBegin;

    @OracleColumn("ProviderDateEnd")
    @CsvHeader("ProviderDateEnd")
    @SerializedName("ProviderDateEnd")
    public String providerDateEnd;

    @OracleColumn("SuspensionDate")
    @CsvHeader("SuspensionDate")
    @SerializedName("SuspensionDate")
    public String suspensionDate;

    @OracleColumn("TerminationDate")
    @CsvHeader("TerminationDate")
    @SerializedName("TerminationDate")
    public String terminationDate;

    public String webUsername;

    public String webPassword;
}
