package com.interop.models.openevv.client;

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
    @SerializedName("ClientEligibilityDateBegin")
    @Builder.Default
    private String clientEligibilityDateBegin = "2019-01-02";
    @SerializedName("ClientEligibilityDateEnd")
    @Builder.Default
    private String clientEligibilityDateEnd = "2029-12-31";
    @SerializedName("EffectiveStartDate")
    @Builder.Default
    private String effectiveStartDate = "2019-01-02";
    @SerializedName("EffectiveEndDate")
    @Builder.Default
    private String effectiveEndDate = "2029-12-31";
    @SerializedName("ClientPayerID")
    @Builder.Default
    private String clientPayerID = commons.generateUniqueNumber();
    @SerializedName("ClientStatus")
    @Builder.Default
    private String clientStatus = "02";
    @SerializedName("PayerID")
    @Builder.Default
    private String payerID = StateAccount.loadStateAccount().getDefaultPayerID();
    @SerializedName("PayerProgram")
    @Builder.Default
    private String payerProgram = StateAccount.loadStateAccount().getDefaultPayerProgram();
    @SerializedName("ProcedureCode")
    @Builder.Default
    private String procedureCode = StateAccount.loadStateAccount().getDefaultProcedureCode();
    @SerializedName("Modifier1")
    private String modifier1;
    @SerializedName("Modifier2")
    private String modifier2;
    @SerializedName("Modifier3")
    private String modifier3;
    @SerializedName("Modifier4")
    private String modifier4;
}
