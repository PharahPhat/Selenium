package com.sandata.models.importModel.Provider;

public class ProviderModel {
    public String ProviderID = "";
    public String ProviderQualifier = "";
    public String ProviderName = "";
    public String PayerID = "";
    public String ProviderDoingBusinessAs = "";
    public String AddressLine1  = "";
    public String AddressLine2 = "";
    public String AddressCity  = "";
    public String AddressState  = "";
    public String AddressZip = "";
    public String County = "";
    public String AgencyPhone = "";
    public String AgencyEmail  = "";
    public String PrimaryContactLastName = "";
    public String PrimaryContactFirstName = "";
    public String ProviderFax = "";
    public String ProviderNPI = "";
    public String ProviderAPI = "";
    public String ProviderMedicaidID = "";
    public String SSN	 = "";
    public String TaxID = "";
    public String ProviderTaxonomy = "";
    public String ProviderRequireAuth = "";
    public String ProviderDateBegin = "";
    public String ProviderDateEnd = "";

    public String toLine() {

        return "\"" + ProviderID + "\"" + "|" +
                "\"" +  ProviderQualifier + "\"" + "|" +
                "\"" +  ProviderName + "\"" + "|" +
                "\"" +  PayerID + "\"" + "|" +
                "\"" +  ProviderDoingBusinessAs + "\"" + "|" +
                "\"" +  AddressLine1  + "\"" + "|" +
                "\"" +  AddressLine2  + "\"" + "|" +
                "\"" +  AddressCity  + "\"" + "|" +
                "\"" +  AddressState  + "\"" + "|" +
                "\"" +  AddressZip + "\"" + "|" +
                "\"" +  County + "\"" + "|" +
                "\"" +  AgencyPhone + "\"" + "|" +
                "\"" +  AgencyEmail  + "\"" + "|" +
                "\"" +  PrimaryContactLastName + "\"" + "|" +
                "\"" +  PrimaryContactFirstName + "\"" + "|" +
                "\"" +  ProviderFax + "\"" + "|" +
                "\"" +  ProviderNPI + "\"" + "|" +
                "\"" +  ProviderAPI + "\"" + "|" +
                "\"" +  ProviderMedicaidID + "\"" + "|" +
                "\"" +  SSN + "\"" + "|" +
                "\"" +  TaxID + "\"" + "|" +
                "\"" +  ProviderTaxonomy + "\"" + "|" +
                "\"" +  ProviderRequireAuth + "\"" + "|" +
                "\"" +  ProviderDateBegin + "\"" + "|" +
                "\"" +  ProviderDateEnd + "\"" ;
    }
}
