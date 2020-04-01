package com.interop.models.openevv.batch;

import com.interop.models.openevv.OpenEvvBaseModel;
import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorizationCSVModel extends OpenEvvBaseModel {

    @CsvHeader("PayerID")
    @Column("payor_id")
    public String payerID;

    @CsvHeader("PayerProgram")
    @Column("program")
    public String payerProgram;

    @CsvHeader("AuthorizationServiceID")
    @Column("service")
    public String authorizationServiceID;

    @CsvHeader("AuthorizationBillingType")
    public String authorizationBillingType;

    @CsvHeader("AuthorizationLimit")
    @Column("auth_lmt")
    public String authorizationLimit;

    @CsvHeader("AuthorizationWeekStart")
    public String authorizationWeekStart;

    @CsvHeader("AuthorizationLimitDayOfWeek")
    public String authorizationLimitDayOfWeek;

    @CsvHeader("AuthorizationLimitStartTime")
    public String authorizationLimitStartTime;

    @CsvHeader("AuthorizationLimitEndTime")
    public String authorizationLimitEndTime;

    @CsvHeader("AuthorizationLimitType")
    @Column("auth_lmt_typ")
    public String authorizationLimitType;

    @CsvHeader("AuthorizationStatus")
    public String authorizationStatus;

    @CsvHeader("Modifier1")
    @Column("modifier1")
    public String modifier1;

    @CsvHeader("Modifier2")
    @Column("modifier2")
    public String modifier2;

    @CsvHeader("Modifier3")
    @Column("modifier3")
    public String modifier3;

    @CsvHeader("Modifier4")
    @Column("modifier4")
    public String modifier4;

    @CsvHeader("SegmentName")
    public String segmentName;

    @CsvHeader("PayerRegion")
    public String payerRegion;

    @CsvHeader("ClientQualifier")
    @Column("client_id_qlfr")
    public String clientQualifier;

    @CsvHeader("ClientIdentifier")
    @Column("client_id")
    public String clientIdentifier;

    @CsvHeader("ProviderQualifier")
    @Column("provider_id_qlfr")
    public String providerQualifier;

    @CsvHeader("ProviderID")
    @Column("provider_id")
    public String providerID;

    @CsvHeader("AuthorizationReferenceNumber")
    @Column("auth_ref_num")
    public String authorizationReferenceNumber;

    @CsvHeader("AuthorizationAmountType")
    @Column("auth_amt_typ")
    public String authorizationAmountType;

    @CsvHeader("AuthorizationMaximum")
    public String authorizationMaximum;

    @CsvHeader("AuthorizationStartDate")
    @Column("auth_start_date")
    public String authorizationStartDate;

    @CsvHeader("AuthorizationEndDate")
    @Column("auth_end_date")
    public String authorizationEndDate;

    @CsvHeader("AuthorizationShared")
    public String authorizationShared;

    @CsvHeader("AuthorizationComments")
    public String authorizationComments;

    @CsvHeader("ClientDiagnosisCodeIsPrimary")
    @Column("dx_code_prmy_ind")
    public String clientDiagnosisCodeIsPrimary;

    @CsvHeader("ClientDiagnosisCode")
    @Column("dx_code")
    public String clientDiagnosisCode;

    @CsvHeader("ClientDiagnosisCodeBeginDate")
    public String clientDiagnosisCodeBeginDate;

    @CsvHeader("ClientDiagnosisCodeEndDate")
    public String clientDiagnosisCodeEndDate;

    @CsvHeader("AssessmentDate")
    public String assessmentDate;

    @CsvHeader("ServiceAuthorizedDate")
    public String serviceAuthorizedDate;

    @CsvHeader("CaseManagerFirstName")
    public String caseManagerFirstName;

    @CsvHeader("CaseManagerLastName")
    public String caseManagerLastName;

    @CsvHeader("CaseManagerEmail")
    public String caseManagerEmail;

    @CsvHeader("HFAAssessmentDate")
    public String hFAAssessmentDate;

    @CsvHeader("MedicalNecessityDeterminationDate")
    public String medicalNecessityDeterminationDate;
}
