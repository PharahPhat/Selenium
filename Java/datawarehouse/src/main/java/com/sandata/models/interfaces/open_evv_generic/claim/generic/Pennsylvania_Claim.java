package com.sandata.models.interfaces.open_evv_generic.claim.generic;

import com.google.gson.annotations.Expose;
import com.sandata.common.Constant;
import com.sandata.common.resource.Claim;
import com.sandata.models.GenericModel;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class Pennsylvania_Claim extends GenericModel {

    public String BusinessEntityMedicaidIdentifier;
    public String ProviderID;
    public String RequestType;
    public String BatchID;
    public String TransactionID;
    public String Payer;
    public String ICN;
    public String DLN;
    public String ProviderQualifier;
    public String PatientQualifier;
    public String PatientID;
    public String ServiceStartDate;
    public String ServiceEndDate;
    public String ProcedureCode;
    public String Units;
    public String UnitsRule;
    public String Modifier1;
    public String Modifier2;
    public String Modifier3;
    public String Modifier4;
    public String MatchingRule;

    @Expose
    public transient List<String> ICNs;

    public List<String> getICNs() {
        ICNs = new ArrayList<>();
        for (int i = 0; i <= pennsylvania_claims.size() - 1; i++) {
            ICNs.add(pennsylvania_claims.get(i).ICN);
        }
        return ICNs;
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() { return false; }

    @Expose
    public transient List<Pennsylvania_Claim> pennsylvania_claims;

    @Expose
    public transient Pennsylvania_Claim pennsylvania_claim;

    public String getBusinessEntityMedicaidIdentifier() {
        return BusinessEntityMedicaidIdentifier;
    }

    public void setBusinessEntityMedicaidIdentifier(String businessEntityMedicaidIdentifier) {
        BusinessEntityMedicaidIdentifier = businessEntityMedicaidIdentifier;
    }

    public String getProviderID() {
        return ProviderID;
    }

    public void setProviderID(String providerID) {
        ProviderID = providerID;
    }

    public String getRequestType() {
        return RequestType;
    }

    public void setRequestType(String requestType) {
        RequestType = requestType;
    }

    public String getBatchID() {
        return BatchID;
    }

    public void setBatchID(String batchID) {
        BatchID = batchID;
    }

    public String getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(String transactionID) {
        TransactionID = transactionID;
    }

    public String getPayer() {
        return Payer;
    }

    public void setPayer(String payer) {
        Payer = payer;
    }

    public String getICN() {
        return ICN;
    }

    public void setICN(String ICN) {
        this.ICN = ICN;
    }

    public String getDLN() {
        return DLN;
    }

    public void setDLN(String DLN) {
        this.DLN = DLN;
    }

    public String getProviderQualifier() {
        return ProviderQualifier;
    }

    public void setProviderQualifier(String providerQualifier) {
        ProviderQualifier = providerQualifier;
    }

    public String getPatientQualifier() {
        return PatientQualifier;
    }

    public void setPatientQualifier(String patientQualifier) {
        PatientQualifier = patientQualifier;
    }

    public String getPatientID() {
        return PatientID;
    }

    public void setPatientID(String patientID) {
        PatientID = patientID;
    }

    public String getServiceStartDate() {
        return ServiceStartDate;
    }

    public void setServiceStartDate(String serviceStartDate) {
        ServiceStartDate = serviceStartDate;
    }

    public String getServiceEndDate() {
        return ServiceEndDate;
    }

    public void setServiceEndDate(String serviceEndDate) {
        ServiceEndDate = serviceEndDate;
    }

    public String getProcedureCode() {
        return ProcedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        ProcedureCode = procedureCode;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public String getUnitsRule() {
        return UnitsRule;
    }

    public void setUnitsRule(String unitsRule) {
        UnitsRule = unitsRule;
    }

    public String getModifier1() {
        return Modifier1;
    }

    public void setModifier1(String modifier1) {
        Modifier1 = modifier1;
    }

    public String getModifier2() {
        return Modifier2;
    }

    public void setModifier2(String modifier2) {
        Modifier2 = modifier2;
    }

    public String getModifier3() {
        return Modifier3;
    }

    public void setModifier3(String modifier3) {
        Modifier3 = modifier3;
    }

    public String getModifier4() {
        return Modifier4;
    }

    public void setModifier4(String modifier4) {
        Modifier4 = modifier4;
    }

    public String getMatchingRule() {
        return MatchingRule;
    }

    public void setMatchingRule(String matchingRule) {
        MatchingRule = matchingRule;
    }

    public void initData(int count) {
        if (count < 1) {
            return;
        }
        pennsylvania_claims = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            Pennsylvania_Claim pennsylvania_Claim = initPAClaimFile();
            pennsylvania_claims.add(pennsylvania_Claim);
        }
    }
    public Pennsylvania_Claim initPAClaimFile() {
        super.initData();
        Pennsylvania_Claim pennsylvania_claim = new Pennsylvania_Claim();
        pennsylvania_claim.BusinessEntityMedicaidIdentifier = claimDbService.generateBusinessEntityMedicaidIdentifierNew();
        pennsylvania_claim.ProviderID = provider_id; //"9876543";
        pennsylvania_claim.RequestType = "Model3"; //TODO: how to get a RequestType input?
        pennsylvania_claim.BatchID = RandomStringUtils.randomNumeric(11);
        pennsylvania_claim.TransactionID = RandomStringUtils.randomNumeric(11);
        pennsylvania_claim.Payer = "PADHS";
        pennsylvania_claim.ICN = RandomStringUtils.randomNumeric(12);
        pennsylvania_claim.DLN = "04";
        pennsylvania_claim.ProviderQualifier = "MedicaidID";
        pennsylvania_claim.PatientQualifier = "MedicaidID";
        pennsylvania_claim.PatientID = "0432019091153";//TODO: how to get a PatientID input?
        pennsylvania_claim.ServiceStartDate = "2019-03-03";
        pennsylvania_claim.ServiceEndDate = null;
        pennsylvania_claim.ProcedureCode = "T1000";
        pennsylvania_claim.Units = "4.0";
        pennsylvania_claim.UnitsRule = "AddUnits";
        pennsylvania_claim.Modifier1 = "U1";
        pennsylvania_claim.Modifier2 = "U2";
        pennsylvania_claim.Modifier3 = "U3";
        pennsylvania_claim.Modifier4 = "U4";
        pennsylvania_claim.MatchingRule = "ExcludeUnits";
        return pennsylvania_claim;
    }

    public boolean post() {
        request_url = getTestEnvironment().get("intake_endpoint") + Claim.INTAKE_CLAIM_VALIDATION_V2;
        boolean result = post(pennsylvania_claims, request_url);
        return result;
    }

    public boolean getFinalStatus() {
        boolean result = getFinalStatus(Claim.NTAKE_CLAIM_VALIDATION_CLAIM_STATUS);
        return result;
    }

    public boolean validateResponseStatus(boolean isResponseSuccess, boolean finalStatus, boolean expected) {

        if (isResponseSuccess == expected
                && finalStatus == expected) {
            logInfo(String.format("Request to create claim successfully"));
            logPass(String.format("Passed. Response status is '%s' matched with Expected Result is '%s'", isResponseSuccess, expected));
            return true;
        } else {
            logInfo(String.format("Failed to create claim"));
        }
        return false;
    }

    /***
     * Validate basic claim information record is inserted into iodata.intf_rsp_txn_claim_stack or not
     * @param expected
     * @return
     */
    public boolean validateClaimRecordsExistInDatabase(boolean expected) {
        List<String> icns = getICNs();

        boolean result = claimDbService.areClaimExistedInDb( icns, expected);

        if (result) {
            if (expected) {
                logPass("PASSED. Record(s) inserted into DB because expected is " + expected);
            } else {
                logPass("PASSED. Record(s) not inserted into DB because expected is " + expected);
            }
        } else {
            if (expected) {
                logError("FAILED. Record(s) not inserted into DB when expected is " + expected);
            } else {
                logError("FAILED. Record(s) inserted into DB when expected is " + expected);
            }
        }
        return result;
    }

    public boolean CheckDataAsExpectedResult(boolean expected)
    {
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, expected);

        boolean result2 = validateClaimRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean BusinessEntityMedicaidIdentifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).BusinessEntityMedicaidIdentifier = value;
        logInfo(String.format("Request to create claim with BusinessEntityMedicaidIdentifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ProviderID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).ProviderID = value;
        logInfo(String.format("Request to create claim with ProviderID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean RequestType(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).RequestType = value;
        logInfo(String.format("Request to create claim with RequestType with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean BatchID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).RequestType = value;
        logInfo(String.format("Request to create claim with BatchID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean TransactionID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).RequestType = value;
        logInfo(String.format("Request to create claim with TransactionID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean Payer(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).Payer = value;
        logInfo(String.format("Request to create claim with Payer with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ICN(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).ICN = value;
        logInfo(String.format("Request to create claim with ICN with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean DLN(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).DLN = value;
        logInfo(String.format("Request to create claim with DLN with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ProviderQualifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).ProviderQualifier = value;
        logInfo(String.format("Request to create claim with ProviderQualifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean PatientQualifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).PatientQualifier = value;
        logInfo(String.format("Request to create claim with PatientQualifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean PatientID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).PatientID = value;
        logInfo(String.format("Request to create claim with PatientID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ServiceStartDate(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).ServiceStartDate = value;
        logInfo(String.format("Request to create claim with ServiceStartDate with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ServiceEndDate(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).ServiceEndDate = value;
        logInfo(String.format("Request to create claim with ServiceEndDate with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ProcedureCode(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).ProcedureCode = value;
        logInfo(String.format("Request to create claim with ProcedureCode with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean Units(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).Units = value;
        logInfo(String.format("Request to create claim with Units with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean UnitsRule(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).UnitsRule = value;
        logInfo(String.format("Request to create claim with UnitsRule with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean Modifier1(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).Modifier1 = value;
        logInfo(String.format("Request to create claim with Modifier1 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean Modifier2(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).Modifier2 = value;
        logInfo(String.format("Request to create claim with Modifier2 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean Modifier3(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).Modifier3 = value;
        logInfo(String.format("Request to create claim with Modifier3 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean Modifier4(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).Modifier4 = value;
        logInfo(String.format("Request to create claim with Modifier4 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean MatchingRule(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_claims.get(0).MatchingRule = value;
        logInfo(String.format("Request to create claim with MatchingRule with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

}
