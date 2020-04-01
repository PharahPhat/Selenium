package com.interop.models.openevv.batch;

import com.interop.models.openevv.OpenEvvBaseModel;
import com.sandata.batch.OracleColumn;
import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MemberCSVModel extends OpenEvvBaseModel {
    @CsvHeader("ClientID")
    @Column
    public String clientID;

    @CsvHeader("ClientFirstName")
    @OracleColumn("entFirstName")
    @Column
    public String clientFirstName;

    @CsvHeader("ClientMiddleInitial")
    @OracleColumn("entMiddleInitial")
    @Column
    public String clientMiddleInitial;

    @CsvHeader("ClientLastName")
    @OracleColumn("entLastName")
    @Column
    public String clientLastName;

    @CsvHeader("ClientCustomID")
    @OracleColumn("clientCustomID")
    @Column
    public String clientCustomID;

    @CsvHeader("ClientOtherID")
    @OracleColumn("clientOtherID")
    @Column
    public String clientOtherID;

    @CsvHeader("Action")
    @OracleColumn("action")
    @Column
    public String action;

    @CsvHeader("ClientLanguage")
    @OracleColumn("entLanguage")
    @Column
    public String clientLanguage;

    @CsvHeader("ClientGender")
    @OracleColumn("entSex")
    @Column
    public String clientGender;

    @CsvHeader("ClientTimeZone")
    @OracleColumn()
    @Column
    public String clientTimeZone;

    @CsvHeader("ClientAddressType")
    @OracleColumn("adrName")
    @Column
    public String clientAddressType;

    @CsvHeader("ClientAddressLine1")
    @OracleColumn("adrAddress")
    @Column
    public String clientAddressLine1;

    @CsvHeader("ClientAddressLine2")
    @OracleColumn("adrAddress2")
    @Column
    public String clientAddressLine2;

    @CsvHeader("ClientCity")
    @OracleColumn("adrCity")
    @Column
    public String clientCity;

    @CsvHeader("ClientState")
    @OracleColumn("adrState")
    @Column
    public String clientState;

    @CsvHeader("ClientZip")
    @OracleColumn("adrZip")
    @Column
    public String clientZip;

    @CsvHeader("ClientPhoneType")
    @Column
    public String clientPhoneType;

    @CsvHeader("ClientPhone")
    @Column
    public String clientPhone;

    @CsvHeader("ClientContactType")
    @Column
    public String clientContactType;

    @CsvHeader("ClientContactFirstName")
    @Column
    public String clientContactFirstName;

    @CsvHeader("ClientContactLastName")
    @Column
    public String clientContactLastName;

    @CsvHeader("ClientContactPhoneType")
    @Column
    public String clientContactPhoneType;

    @CsvHeader("ClientContactPhone")
    @Column
    public String clientContactPhone;

    @CsvHeader("ClientContactEmailAddress")
    @Column
    public String clientContactEmailAddress;

    @CsvHeader("ClientContactAddressLine1")
    @Column
    public String clientContactAddressLine1;

    @CsvHeader("ClientContactAddressLine2")
    @Column
    public String clientContactAddressLine2;

    @CsvHeader("ClientContactCity")
    @Column
    public String clientContactCity;

    @CsvHeader("ClientContactState")
    @Column
    public String clientContactState;

    @CsvHeader("ClientContactZip")
    @Column
    public String clientContactZip;

    @CsvHeader("ClientDesigneeFirstName")
    @Column
    public String clientDesigneeFirstName;

    @CsvHeader("ClientDesigneeLastName")
    @Column
    public String clientDesigneeLastName;

    @CsvHeader("ClientDesigneeEmail")
    @Column
    public String clientDesigneeEmail;

    @CsvHeader("ClientDesigneeStatus")
    @Column
    public String clientDesigneeStatus;

    @CsvHeader("ClientDesigneeStartDate")
    @Column
    public String clientDesigneeStartDate;

    @CsvHeader("ClientDesigneeEndDate")
    @Column
    public String clientDesigneeEndDate;

    @CsvHeader("PayerID")
    @Column
    public String payerID;

    @CsvHeader("PayerProgram")
    @Column
    public String payerProgram;

    @CsvHeader("PayerService")
    @Column
    public String payerService;

    @CsvHeader("PayerRegion")
    @Column
    public String payerRegion;

    @CsvHeader("ClientEligibilityDateBegin")
    @Column
    public String clientEligibilityDateBegin;

    @CsvHeader("ClientEligibilityDateEnd")
    @Column
    public String clientEligibilityDateEnd;

    @CsvHeader("ClientStartofCareDate")
    @Column
    public String clientStartofCareDate;

    @CsvHeader("ClientEndofCareDate")
    @Column
    public String clientEndofCareDate;

    @CsvHeader("SegmentName")
    @Column
    public String segmentName;

    @CsvHeader("ClientSSN")
    @Column
    public String clientSSN;

    @CsvHeader("ClientSuffix")
    @Column
    public String clientSuffix;

    @CsvHeader("ClientMaritalStatus")
    @Column
    public String clientMaritalStatus;

    @CsvHeader("ClientBirthDate")
    @Column
    public String clientBirthDate;

    @CsvHeader("ClientEmail")
    @Column
    public String clientEmail;

    @CsvHeader("ClientEnrollmentDate")
    @Column
    public String clientEnrollmentDate;

    @CsvHeader("ClientCounty")
    @Column
    public String clientCounty;

    @CsvHeader("ClientPrimaryDiagnosisCode")
    @Column
    public String clientPrimaryDiagnosisCode;

    @CsvHeader("ClientSecondaryDiagnosisCode")
    @Column
    public String clientSecondaryDiagnosisCode;

    @CsvHeader("ClientStatus")
    @Column
    public String clientStatus;

    @CsvHeader("ClientStatusDate")
    @Column
    public String clientStatusDate;

    @CsvHeader("Modifier1")
    @Column
    public String modifier1;

    @CsvHeader("Modifier2")
    @Column
    public String modifier2;

    @CsvHeader("Modifier3")
    @Column
    public String modifier3;

    @CsvHeader("Modifier4")
    @Column
    public String modifier4;

    @CsvHeader("ClientMedicaidID")
    public String clientMedicaidID;

    @CsvHeader("ClientMedicalRecordNum")
    public String clientMedicalRecordNum;

    @CsvHeader("MissingMedicaidID")
    public String missingMedicaidId;

    @CsvHeader("ProviderQualifier")
    public String providerQualifier;

    @CsvHeader("ProviderID")
    public String providerID;

    @CsvHeader("PayerID2")
    public String payer2;

    @CsvHeader("PayerProgram2")
    public String payerProgram2;
}
