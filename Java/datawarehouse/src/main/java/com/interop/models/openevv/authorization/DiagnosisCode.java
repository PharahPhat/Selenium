package com.interop.models.openevv.authorization;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DiagnosisCode {
    @SerializedName("ClientDiagnosisCodeIsPrimary")
    @Builder.Default
    private String clientDiagnosisCodeIsPrimary = "N";
    @SerializedName("ClientDiagnosisCode")
    @Builder.Default
    private String clientDiagnosisCode = "G44.311";
    @SerializedName("ClientDiagnosisCodeBeginDate")
    @Builder.Default
    private String clientDiagnosisCodeBeginDate = "2018-01-01";
    @SerializedName("ClientDiagnosisCodeEndDate")
    @Builder.Default
    private String clientDiagnosisCodeEndDate = "2099-01-01";

    @Override
    public boolean equals(Object object2) {
        return clientDiagnosisCodeIsPrimary.equals(((DiagnosisCode) object2).clientDiagnosisCodeIsPrimary)
                && clientDiagnosisCode.equals(((DiagnosisCode) object2).clientDiagnosisCode)
                && clientDiagnosisCodeBeginDate.equals(((DiagnosisCode) object2).clientDiagnosisCodeBeginDate)
                && clientDiagnosisCodeEndDate.equals(((DiagnosisCode) object2).clientDiagnosisCodeEndDate);
    }
}
