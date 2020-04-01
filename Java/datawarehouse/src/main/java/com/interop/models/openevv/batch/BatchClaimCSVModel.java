package com.interop.models.openevv.batch;

import com.interop.models.openevv.OpenEvvBaseModel;
import com.sandata.core.annotation.CsvHeader;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BatchClaimCSVModel extends OpenEvvBaseModel {
    @CsvHeader("BusinessEntityMedicaidIdentifier")
    public String businessEntityMedicaidIdentifier;

    @CsvHeader("RequestType")
    public String requestType;

    @CsvHeader("BatchID")
    public String batchID;

    @CsvHeader("TransactionID")
    public String transactionID;

    @CsvHeader("Payer")
    public String payer;

    @CsvHeader("ICN")
    public String iCN;

    @CsvHeader("DLN")
    public String dLN;

    @CsvHeader("ProviderQualifier")
    public String providerQualifier;

    @CsvHeader("ProviderID")
    public String providerID;

    @CsvHeader("PatientQualifier")
    public String patientQualifier;

    @CsvHeader("PatientID")
    public String patientID;

    @CsvHeader("ServiceStartDate")
    public String serviceStartDate;

    @CsvHeader("ServiceEndDate")
    public String serviceEndDate;

    @CsvHeader("ProcedureCode")
    public String procedureCode;

    @CsvHeader("Units")
    public String units;

    @CsvHeader("UnitsRule")
    public String unitsRule;

    @CsvHeader("Modifier1")
    public String modifier1;

    @CsvHeader("Modifier2")
    public String modifier2;

    @CsvHeader("Modifier3")
    public String modifier3;

    @CsvHeader("Modifier4")
    public String modifier4;

    @CsvHeader("MatchingRule")
    public String matchingRule;

    @CsvHeader("ExpectedError")
    public String expectedError;
}
