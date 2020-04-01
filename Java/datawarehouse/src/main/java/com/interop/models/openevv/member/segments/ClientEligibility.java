package com.interop.models.openevv.member.segments;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
public class ClientEligibility {
    @Builder.Default
    @SerializedName("PayerID")
    String payerId = StateAccount.loadStateAccount().getDefaultPayerID();

    @Builder.Default
    @SerializedName("PayerProgram")
    String payerProgram = StateAccount.loadStateAccount().getDefaultPayerProgram();

    @Builder.Default
    @SerializedName("PayerService")
    String payerService = "W175";

    @SerializedName("PayerRegion")
    String payerRegion;

    @SerializedName("ClientEligibilityDateBegin")
    String clientEligibilityDateBegin;

    @SerializedName("ClientEligibilityDateEnd")
    String clientEligibilityDateEnd;

    @SerializedName("ClientStartOfCareDate")
    String clientStartOfCareDate;

    @SerializedName("ClientEndOfCareDate")
    String clientEndOfCareDate;

    @Builder.Default
    @SerializedName("ClientPrimaryDiagnosisCode")
    String clientPrimaryDiagnosisCode = "M54.2";

    @Builder.Default
    @SerializedName("ClientSecondaryDiagnosisCode")
    String clientSecondaryDiagnosisCode = "M54.2";

    @SerializedName("ClientStatus")
    String clientStatus;

    @SerializedName("ClientStatusDate")
    String clientStatusDate;

    @Builder.Default
    @SerializedName("Modifier1")
    String modifier1 = "HQ";

    @Builder.Default
    @SerializedName("Modifier2")
    String modifier2 = "HQ";

    @Builder.Default
    @SerializedName("Modifier3")
    String modifier3 = "HQ";

    @Builder.Default
    @SerializedName("Modifier4")
    String modifier4 = "HQ";
}
