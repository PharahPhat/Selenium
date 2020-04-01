package com.interop.models.claim;

import com.google.gson.annotations.SerializedName;
import com.interop.common.Commons;
import com.interop.common.StateAccount;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClaimModel {
    @SerializedName("BusinessEntityMedicaidIdentifier")
    String businessEntityMedicaidIdentifier;
    @SerializedName("RequestType")
    ModelVersion version;
    @SerializedName("BatchID")
    String batchID;
    @SerializedName("TransactionID")
    String transactionID;
    @SerializedName("Payer")
    String payer;
    @SerializedName("ICN")
    String icn;
    @SerializedName("DLN")
    String dln;
    @SerializedName("ProviderQualifier")
    String providerQualifier;
    @SerializedName("ProviderID")
    String providerID;
    @SerializedName("PatientQualifier")
    String patientQualifier;
    @SerializedName("PatientID")
    String patientID;
    @SerializedName("ServiceStartDate")
    String serviceStartDate;
    @SerializedName("ServiceEndDate")
    String serviceEndDate;
    @SerializedName("ProcedureCode")
    String procedureCode;
    @SerializedName("Units")
    float units;
    @SerializedName("UnitsRule")
    UnitsRule unitsRule;
    @SerializedName("Modifier1")
    String modifier1;
    @SerializedName("Modifier2")
    String modifier2;
    @SerializedName("Modifier3")
    String modifier3;
    @SerializedName("Modifier4")
    String modifier4;
    @SerializedName("MatchingRule")
    MatchingRule matchingRule;
    @SerializedName("VisitFound")
    String visitFound;
    @SerializedName("Details")
    String details;
    @SerializedName("DetailsReason")
    String detailsReason;
    @SerializedName("RecordsFound")
    String recordsFound;
    @SerializedName("VisitKey")
    String visitKey;

    public static ClaimModel generateClaimModel(StateAccount state, ModelVersion version) {
        Commons commons = new Commons();
        String batchId = commons.generateUniqueNumber17Digits();
        return ClaimModel.builder()
                .version(version)
                .businessEntityMedicaidIdentifier(state.getProviderID())
                .payer(state.getDefaultPayerID())
                .procedureCode(state.getDefaultProcedureCode())
                .providerQualifier(state.getProviderQualifier())
                .providerID(state.getProviderID())
                .batchID(batchId)
                .transactionID(batchId)
                .icn("99911219110")
                .dln("04")
                .patientQualifier("MedicaidID")
                .unitsRule(UnitsRule.ADD_TIME)
                .matchingRule(MatchingRule.EXCLUDE_UNITS)
                .units(1)
                .build();
    }

    public int getNumberVisitKeys() {
        return getVisitKey().split(",").length;
    }

}
