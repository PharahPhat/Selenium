package com.interop.models.openevv.authorization;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class OpenEvvAuthorization extends AltBaseModel {
    @SerializedName("PayerID")
    @Builder.Default
    private String payerId = StateAccount.loadStateAccount().getDefaultPayerID();
    @SerializedName("PayerRegion")
    @Builder.Default
    private String payerRegion = "01";
    @SerializedName("ClientQualifier")
    @Builder.Default
    private String clientQualifier = StateAccount.loadStateAccount().getClientQualifier();
    @SerializedName("ClientIdentifier")
    private String clientIdentifier;
    @SerializedName("ProviderQualifier")
    @Builder.Default
    private String providerQualifier ="MedicaidID";
    @SerializedName("ProviderID")
    @Builder.Default
    private String providerId = StateAccount.loadStateAccount().getProviderID();
    @SerializedName("AuthorizationReferenceNumber")
    @Builder.Default
    private String authorizationReferenceNumber = "AutoAuth" + (RandomStringUtils.randomNumeric(12));
    @SerializedName("AuthorizationAmountType")
    @Builder.Default
    private String authorizationAmountType ="U";
    @SerializedName("AuthorizationMaximum")
    private String authorizationMaximum;
    @SerializedName("AuthorizationStartDate")
    @Builder.Default
    private String authorizationStartDate = "2018-07-23";
    @SerializedName("AuthorizationEndDate")
    @Builder.Default
    private String authorizationEndDate = "2029-01-01";
    @SerializedName("AuthorizationShared")
    private String authorizationShared;
    @SerializedName("AuthorizationComments")
    private String authorizationComments;
    @SerializedName("AuthorizationLimitType")
    @Builder.Default
    private String authorizationLimitType = "N";
    @SerializedName("AuthorizationStatus")
    @Builder.Default
    private String authorizationStatus = "A";
    @SerializedName("AuthorizationLimit")
    @Singular("limit")
    private List<AuthorizationLimit> authorizationLimit;
    @SerializedName("DiagnosisCode")
    @Singular("code")
    private List<DiagnosisCode> diagnosisCode;
    @SerializedName("ErrorMessage")
    private String errorMessage;
    @SerializedName("AssessmentDate")
    private String assessmentDate;
    @SerializedName("MedicalNecessityDeterminationDate")
    private String medicalNecessityDeterminationDate;
    @SerializedName("CaseManagerFirstName")
    @Builder.Default
    private String caseManagerFirstName = "CMFName" + RandomStringUtils.randomAlphabetic(10);
    @SerializedName("CaseManagerLastName")
    @Builder.Default
    private String caseManagerLastName = "CMLName" + RandomStringUtils.randomAlphabetic(10);
    @SerializedName("CaseManagerEmail")
    @Builder.Default
    private String caseManagerEmail = commons.generateEmailAddress("CaseManager");
    @SerializedName("HFAAssessmentDate")
    @Builder.Default
    private String hiAssessmentDate = "2018-01-01";
    ;

    @Override
    public boolean equals(Object object2) {
        if (object2 == null) {
            return false;
        } else if (!(object2 instanceof OpenEvvAuthorization)) {
            return false;
        } else {
            OpenEvvAuthorization objectCompared = (OpenEvvAuthorization) object2;
            return this.providerId.equals(objectCompared.providerId)
                    && this.clientIdentifier.equals(objectCompared.clientIdentifier)
                    && this.authorizationLimit.equals(objectCompared.authorizationLimit)
                    && this.diagnosisCode.equals(objectCompared.diagnosisCode);
        }
    }
}
