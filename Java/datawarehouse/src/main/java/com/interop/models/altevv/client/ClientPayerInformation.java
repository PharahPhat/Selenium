package com.interop.models.altevv.client;

import com.google.gson.annotations.SerializedName;
import com.interop.models.altevv.AltBaseModel;
import com.interop.common.StateAccount;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.RandomStringUtils;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class ClientPayerInformation extends AltBaseModel {
    @SerializedName("PayerID")
    @Builder.Default
    String payerID = StateAccount.loadStateAccount().getDefaultPayerID();
    @SerializedName("PayerProgram")
    @Builder.Default
    String payerProgram = StateAccount.loadStateAccount().getDefaultPayerProgram();
    @SerializedName("ProcedureCode")
    @Builder.Default
    String procedureCode = StateAccount.loadStateAccount().getDefaultProcedureCode();
    @SerializedName("ClientPayerID")
    @Builder.Default
    String clientPayerID = commons.generateUniqueNumber();
    @SerializedName("ClientEligibilityDateBegin")
    @Builder.Default
    String clientEligibilityDateBegin = "2018-01-30";
    @SerializedName("ClientEligibilityDateEnd")
    @Builder.Default
    String clientEligibilityDateEnd = "2030-01-30";
    @SerializedName("ClientStatus")
    @Builder.Default
    String clientStatus = "02";
    @SerializedName("Modifier1")
    String modifier1;
    @SerializedName("Modifier2")
    String modifier2;
    @SerializedName("Modifier3")
    String modifier3;
    @SerializedName("Modifier4")
    String modifier4;
    @SerializedName("EffectiveStartDate")
    @Builder.Default
    String effectiveStartDate = "2018-01-30";
    @SerializedName("EffectiveEndDate")
    @Builder.Default
    String effectiveEndDate = "2030-01-30";

}


