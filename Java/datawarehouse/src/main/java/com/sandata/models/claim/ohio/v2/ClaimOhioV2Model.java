package com.sandata.models.claim.ohio.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sandata.models.GenericModel;

public class ClaimOhioV2Model extends GenericModel {

    @JsonProperty
    public String BusinessEntityMedicaidIdentifier;

    @JsonProperty
    public String RequestType;

    @JsonProperty
    public String BatchID;

    @JsonProperty
    public String TransactionID;

    @JsonProperty
    public String Payer;

    @JsonProperty
    public String ICN;

    @JsonProperty
    public String DLN;

    @JsonProperty
    public String ProviderQualifier;

    @JsonProperty
    public String ProviderID;

    @JsonProperty
    public String PatientQualifier;

    @JsonProperty
    public String PatientID;

    @JsonProperty
    public String ServiceStartDate;

    @JsonProperty
    public String ServiceEndDate;

    @JsonProperty
    public String ProcedureCode;

    @JsonProperty
    public String Units;

    @JsonProperty
    public String UnitsRule;

    @JsonProperty
    public String Modifier1;

    @JsonProperty
    public String Modifier2;

    @JsonProperty
    public String Modifier3;

    @JsonProperty
    public String Modifier4;

    @JsonProperty
    public String MatchingRule;

    public String getBusinessEntityMedicaidIdentifier() {
        return BusinessEntityMedicaidIdentifier;
    }

    public void setBusinessEntityMedicaidIdentifier(String businessEntityMedicaidIdentifier) {
        BusinessEntityMedicaidIdentifier = businessEntityMedicaidIdentifier;
    }

    public String getRequestType() {
        return RequestType;
    }

    public void setRequestType(String requestType) {
        RequestType = requestType;
    }

    public String getBatchID() {
        return BatchID;
    }

    public void setBatchID(String batchID) {
        BatchID = batchID;
    }

    public String getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(String transactionID) {
        TransactionID = transactionID;
    }

    public String getPayer() {
        return Payer;
    }

    public void setPayer(String payer) {
        Payer = payer;
    }

    public String getICN() {
        return ICN;
    }

    public void setICN(String ICN) {
        this.ICN = ICN;
    }

    public String getDLN() {
        return DLN;
    }

    public void setDLN(String DLN) {
        this.DLN = DLN;
    }

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

    public String getPatientQualifier() {
        return PatientQualifier;
    }

    public void setPatientQualifier(String patientQualifier) {
        PatientQualifier = patientQualifier;
    }

    public String getPatientID() {
        return PatientID;
    }

    public void setPatientID(String patientID) {
        PatientID = patientID;
    }

    public String getServiceStartDate() {
        return ServiceStartDate;
    }

    public void setServiceStartDate(String serviceStartDate) {
        ServiceStartDate = serviceStartDate;
    }

    public String getServiceEndDate() {
        return ServiceEndDate;
    }

    public void setServiceEndDate(String serviceEndDate) {
        ServiceEndDate = serviceEndDate;
    }

    public String getProcedureCode() {
        return ProcedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        ProcedureCode = procedureCode;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public String getUnitsRule() {
        return UnitsRule;
    }

    public void setUnitsRule(String unitsRule) {
        UnitsRule = unitsRule;
    }

    public String getModifier1() {
        return Modifier1;
    }

    public void setModifier1(String modifier1) {
        Modifier1 = modifier1;
    }

    public String getModifier2() {
        return Modifier2;
    }

    public void setModifier2(String modifier2) {
        Modifier2 = modifier2;
    }

    public String getModifier3() {
        return Modifier3;
    }

    public void setModifier3(String modifier3) {
        Modifier3 = modifier3;
    }

    public String getModifier4() {
        return Modifier4;
    }

    public void setModifier4(String modifier4) {
        Modifier4 = modifier4;
    }

    public String getMatchingRule() {
        return MatchingRule;
    }

    public void setMatchingRule(String matchingRule) {
        MatchingRule = matchingRule;
    }

    public String toLine() {
        return BusinessEntityMedicaidIdentifier + "|" +
                RequestType + "|" +
                BatchID + "|" +
                TransactionID + "|" +
                Payer + "|" +
                ICN + "|" +
                DLN + "|" +
                ProviderQualifier + "|" +
                ProviderID + "|" +
                PatientQualifier + "|" +
                PatientID + "|" +
                ServiceStartDate + "|" +
                ServiceEndDate + "|" +
                ProcedureCode + "|" +
                Units + "|" +
                UnitsRule + "|" +
                Modifier1 + "|" +
                Modifier2 + "|" +
                Modifier3 + "|" +
                Modifier4 + "|" +
                MatchingRule;
    }

    @Override
    public String toString() {
        return "ClaimOhioV2Model{" +
                "BusinessEntityMedicaidIdentifier='" + BusinessEntityMedicaidIdentifier + '\'' +
                ", RequestType='" + RequestType + '\'' +
                ", BatchID='" + BatchID + '\'' +
                ", TransactionID='" + TransactionID + '\'' +
                ", Payer='" + Payer + '\'' +
                ", ICN='" + ICN + '\'' +
                ", DLN='" + DLN + '\'' +
                ", ProviderQualifier='" + ProviderQualifier + '\'' +
                ", ProviderID='" + ProviderID + '\'' +
                ", PatientQualifier='" + PatientQualifier + '\'' +
                ", PatientID='" + PatientID + '\'' +
                ", ServiceStartDate='" + ServiceStartDate + '\'' +
                ", ServiceEndDate='" + ServiceEndDate + '\'' +
                ", ProcedureCode='" + ProcedureCode + '\'' +
                ", Units='" + Units + '\'' +
                ", UnitsRule='" + UnitsRule + '\'' +
                ", Modifier1='" + Modifier1 + '\'' +
                ", Modifier2='" + Modifier2 + '\'' +
                ", Modifier3='" + Modifier3 + '\'' +
                ", Modifier4='" + Modifier4 + '\'' +
                ", MatchingRule='" + MatchingRule + '\'' +
                '}';
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
