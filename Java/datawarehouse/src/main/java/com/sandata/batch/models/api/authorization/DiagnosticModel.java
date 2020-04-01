package com.sandata.batch.models.api.authorization;

import com.google.gson.annotations.SerializedName;

public class DiagnosticModel {
    @SerializedName("ClientDiagnosisCodeIsPrimary")
    private String clientDiagnosisCodeIsPrimary;

    @SerializedName("ClientDiagnosisCode")
    private String clientDiagnosisCode;

    @SerializedName("ClientDiagnosisCodeBeginDate")
    private String clientDiagnosisCodeBeginDate;

    @SerializedName("ClientDiagnosisCodeEndDate")
    private String clientDiagnosisCodeEndDate;

    public void setClientDiagnosisCodeIsPrimary(String clientDiagnosisCodeIsPrimary) {
        this.clientDiagnosisCodeIsPrimary = clientDiagnosisCodeIsPrimary;
    }

    public void setClientDiagnosisCode(String clientDiagnosisCode) {
        this.clientDiagnosisCode = clientDiagnosisCode;
    }

    public void setClientDiagnosisCodeBeginDate(String clientDiagnosisCodeBeginDate) {
        this.clientDiagnosisCodeBeginDate = clientDiagnosisCodeBeginDate;
    }

    public void setClientDiagnosisCodeEndDate(String clientDiagnosisCodeEndDate) {
        this.clientDiagnosisCodeEndDate = clientDiagnosisCodeEndDate;
    }

    public String getClientDiagnosisCodeIsPrimary() {
        return clientDiagnosisCodeIsPrimary;
    }

    public String getClientDiagnosisCode() {
        return clientDiagnosisCode;
    }

    public String getClientDiagnosisCodeBeginDate() {
        return clientDiagnosisCodeBeginDate;
    }

    public String getClientDiagnosisCodeEndDate() {
        return clientDiagnosisCodeEndDate;
    }

    public boolean equals(Object object2) {
        return clientDiagnosisCodeIsPrimary.equals(((DiagnosticModel) object2).clientDiagnosisCodeIsPrimary)
                && clientDiagnosisCode.equals(((DiagnosticModel) object2).clientDiagnosisCode)
                && clientDiagnosisCodeBeginDate.equals(((DiagnosticModel) object2).clientDiagnosisCodeBeginDate)
                && clientDiagnosisCodeEndDate.equals(((DiagnosticModel) object2).clientDiagnosisCodeEndDate);
    }
}
