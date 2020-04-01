package com.sandata.models.interfaces.open_evv_generic.provider.Generic;

import com.google.gson.annotations.Expose;
import com.sandata.common.Constant;
import com.sandata.common.resource.Provider;
import com.sandata.models.GenericModel;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class Pennsylvania_Provider extends GenericModel {
    public String ProviderID = "";
    public String ProviderName = "";
    public String ProviderQualifier = "";
    public String PayerID = "";
    public String AddressLine1 = "";
    public String AddressCity = "";
    public String AddressZip = "";
    public String County = "";
    public String AgencyPhone = "";
    public String AgencyEmail = "";
    public String ProviderNPI = "";
    public String ProviderAPI = "";
    public String ProviderMedicaidID = "";
    public String SSN = "";
    public String TaxID = "";
    public String ProviderTaxonomy = "";
    public String ProviderRequireAuth = "";
    public String SuspensionDate = "";
    public String TerminationDate = "";
    public String PrimaryContactLastName = "";
    public String PrimaryContactFirstName = "";
    public String AddressState = "";

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }

    @Expose
    public transient List<Pennsylvania_Provider> pennsylvania_providers;
    @Expose
    public transient Pennsylvania_Provider pennsylvania_provider;

    @Expose
    public transient List<String> providerIds;

    public List<String> getProviderIds() {
        providerIds = new ArrayList<>();
        for (int i = 0; i <= pennsylvania_providers.size() - 1; i++) {
            providerIds.add(pennsylvania_providers.get(i).ProviderID);
        }
        return providerIds;
    }

    /***
     * Init data for 1 provider with 1 segment
     * @return
     */
    public void initData(int count) {
        if (count < 1) {
            return;
        }
        pennsylvania_providers = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            Pennsylvania_Provider pennsylvania_provider = initPAProviderWithoutOmitFile();
            pennsylvania_providers.add(pennsylvania_provider);
        }
    }

    public Pennsylvania_Provider initPAProviderWithoutOmitFile() {
        super.initData();
        Pennsylvania_Provider pennsylvania_provider = new Pennsylvania_Provider();
        pennsylvania_provider.ProviderID = providerDbService.generateNewProviderId();
        pennsylvania_provider.ProviderName = RandomStringUtils.randomAlphabetic(20);
        pennsylvania_provider.ProviderQualifier = "MedicaidID";
        pennsylvania_provider.PayerID = "PADHS";
        pennsylvania_provider.AddressLine1 = RandomStringUtils.randomAlphabetic(50);
        pennsylvania_provider.AddressCity = RandomStringUtils.randomAlphabetic(20);
        pennsylvania_provider.AddressZip = "012321347";
        pennsylvania_provider.County = RandomStringUtils.randomAlphabetic(30);
        pennsylvania_provider.AgencyPhone = RandomStringUtils.randomNumeric(10);
        pennsylvania_provider.AgencyEmail = RandomStringUtils.randomAlphabetic(20) + "@gmail.com";
        pennsylvania_provider.ProviderNPI = RandomStringUtils.randomNumeric(9);
        pennsylvania_provider.ProviderAPI = RandomStringUtils.randomNumeric(9);
        pennsylvania_provider.ProviderMedicaidID = RandomStringUtils.randomNumeric(9);
        pennsylvania_provider.SSN = "";
        pennsylvania_provider.TaxID = "012321347";
        pennsylvania_provider.PrimaryContactLastName = RandomStringUtils.randomAlphabetic(20);
        pennsylvania_provider.PrimaryContactFirstName = RandomStringUtils.randomAlphabetic(20);
        pennsylvania_provider.AddressState = "NH";
        pennsylvania_provider.ProviderTaxonomy = RandomStringUtils.randomAlphabetic(9);
        pennsylvania_provider.ProviderRequireAuth = "0";
        pennsylvania_provider.SuspensionDate = "2019-02-02";
        pennsylvania_provider.TerminationDate = "2219-02-02";
        return pennsylvania_provider;
    }

    public boolean post() {
        request_url = getTestEnvironment().get("intake_endpoint") + Provider.INTAKE_OPEN_EVV_GENERIC_IMPORT_PROVIDER;
        boolean result = post(pennsylvania_providers, request_url);
        return result;
    }

    public boolean getFinalStatus() {
        boolean result = getFinalStatus(Provider.INTAKE_CHECK_STATUS);
        return result;
    }

    public boolean validateResponseStatus(boolean isResponseSuccess, boolean finalStatus, boolean expected) {

        if (isResponseSuccess == expected
                && finalStatus == expected) {
            logInfo(String.format("Request to create provider successfully"));
            logPass(String.format("Passed. Response status is '%s' matched with Expected Result is '%s'", isResponseSuccess, expected));
            return true;
        } else {
            logInfo(String.format("Failed to create provider"));
        }
        return false;
    }

    /***
     * Validate basic provider information record is inserted into INBOX.providers or not
     * @param expected
     * @return
     */
    public boolean validateProviderRecordsExistInDatabase(boolean expected) {
        List<String> ids = getProviderIds();

        boolean result = providerDbService.areProviderIdExistedInDb( ids, expected);

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

        boolean result2 = validateProviderRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AddressLine1(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).AddressLine1 = value;

        logInfo(String.format("Request to create provider with AddressLine1 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ProviderID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).ProviderID = value;
        logInfo(String.format("Request to create client with ProviderID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ProviderQualifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).ProviderQualifier = value;
        logInfo(String.format("Request to create client with ProviderQualifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean PayerID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).PayerID = value;
        logInfo(String.format("Request to create client with PayerID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean AddressZip(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).AddressZip = value;
        logInfo(String.format("Request to create client with AddressZip with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean County(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).County = value;
        logInfo(String.format("Request to create client with County with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean AgencyPhone(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).AgencyPhone  = value;
        logInfo(String.format("Request to create client with AgencyPhone with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean AgencyEmail(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).AgencyPhone  = value;
        logInfo(String.format("Request to create client with AgencyPhone with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ProviderNPI(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String  value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).ProviderNPI  = value;
        logInfo(String.format("Request to create client with ProviderNPI with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ProviderMedicaidID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).ProviderMedicaidID  = value;
        logInfo(String.format("Request to create client with ProviderMedicaidID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean SSN(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).SSN  = value;
        logInfo(String.format("Request to create client with SSN with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean TaxID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).TaxID  = value;
        logInfo(String.format("Request to create client with TaxID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ProviderTaxonomy(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).ProviderTaxonomy  = value;
        logInfo(String.format("Request to create client with ProviderTaxonomy with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean ProviderRequireAuth(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).ProviderRequireAuth  = value;
        logInfo(String.format("Request to create client with ProviderRequireAuth with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean TerminationDate(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).TerminationDate  = value;
        logInfo(String.format("Request to create client with TerminationDate with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

    public boolean SuspensionDate(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        pennsylvania_providers.get(0).SuspensionDate  = value;
        logInfo(String.format("Request to create client with SuspensionDate with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        return CheckDataAsExpectedResult(expected);
    }

}
