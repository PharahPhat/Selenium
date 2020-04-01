package com.sandata.models.interfaces.open_evv_generic.auth;

import com.google.gson.annotations.Expose;
import com.sandata.common.Constant;
import com.sandata.common.resource.ResourceGeneric;
import com.sandata.models.GenericModel;
import org.apache.commons.lang.RandomStringUtils;


import java.util.ArrayList;
import java.util.List;

public class OpenEVV_Pennsylvania_Auth extends GenericModel {

    public String PayerID;
    public String PayerProgram;
    public String ClientQualifier;
    public String ClientIdentifier;
    public String EmployeeID;
    public String EmployeePINQualifier;
    public String ProviderQualifier;
    public String ProviderID;
    public String AuthorizationReferenceNumber;
    public String AuthorizationServiceID;
    public String AuthorizationBillingType;
    public String Modifier1;
    public String Modifier2;
    public String Modifier3;
    public String Modifier4;
    public String AuthorizationAmountType;
    public String AuthorizationMaximum;
    public String Units;
    public String AuthorizationStartDate;
    public String AuthorizationEndDate;
    public String AuthorizationShared;
    public String AuthorizationComments;
    public String AuthorizationLimitType;
    public String AuthorizationStatus;
    public String ClientDiagnosisCode;
    public List<AuthorizationLimit> AuthorizationLimits = new ArrayList<AuthorizationLimit>();
    public String errorMessage = "";
    @Expose
    public transient List<OpenEVV_Pennsylvania_Auth> openevv_generic_auths;

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }

    @Expose
    public transient List<String> guids;

    public void setGuids(String guid) {
        guids = new ArrayList<>();
        guids.add(guid);
    }

    public void initData(int count) {
        if (count < 1) {
            return;
        }

        errorMessage = "";
        openevv_generic_auths = new ArrayList<OpenEVV_Pennsylvania_Auth>();
        for (int i = 1; i <= count; i++) {
            OpenEVV_Pennsylvania_Auth openevv_generic_auth = initOpenEVVGenericAuth();
            openevv_generic_auths.add(openevv_generic_auth);
        }
    }

    public OpenEVV_Pennsylvania_Auth initOpenEVVGenericAuth(){
        super.initData();

        //TODO: will fill correct the information
        OpenEVV_Pennsylvania_Auth openEVV_Generic_Auth = new OpenEVV_Pennsylvania_Auth();
        openEVV_Generic_Auth.PayerID = "PAOLTL";
        //If applicable, the program to which this client belongs. Potential use and list of values to be determined during implementation.
        openEVV_Generic_Auth.PayerProgram= "ODP";
        openEVV_Generic_Auth.ClientQualifier = "ClientCustomID";
        openEVV_Generic_Auth.ClientIdentifier = RandomStringUtils.randomNumeric(9);
        openEVV_Generic_Auth.EmployeeID = RandomStringUtils.randomNumeric(9) ;
        openEVV_Generic_Auth.EmployeePINQualifier =  "EmployeeSSN";
        openEVV_Generic_Auth.ProviderQualifier = "MedicaidID";
        openEVV_Generic_Auth.ProviderID = provider_id;
        openEVV_Generic_Auth.AuthorizationReferenceNumber = "8725";
        openEVV_Generic_Auth.AuthorizationServiceID = "1015";
        openEVV_Generic_Auth.AuthorizationBillingType = "sandataAutBillType";
        openEVV_Generic_Auth.Modifier1 = null;
        openEVV_Generic_Auth.Modifier2 = null;
        openEVV_Generic_Auth.Modifier3 = null;
        openEVV_Generic_Auth.Modifier4 = null;
        openEVV_Generic_Auth.AuthorizationAmountType = "H";
        openEVV_Generic_Auth.AuthorizationMaximum = "123";
        openEVV_Generic_Auth.Units = "12";
        openEVV_Generic_Auth.AuthorizationStartDate = "2018-09-10";
        openEVV_Generic_Auth.AuthorizationEndDate = "2018-09-22";
        openEVV_Generic_Auth.AuthorizationShared = "Y";
        openEVV_Generic_Auth.AuthorizationComments = null;
        openEVV_Generic_Auth.AuthorizationLimitType = "W";
        openEVV_Generic_Auth.AuthorizationStatus = "A";
        openEVV_Generic_Auth.ClientDiagnosisCode = "E10.45";
        openEVV_Generic_Auth.AuthorizationLimits = createAuthorizationLimit(1);
        return openEVV_Generic_Auth;
    }

    public List<AuthorizationLimit> createAuthorizationLimit(int count){
        List<AuthorizationLimit> authorizationLimits = new ArrayList<AuthorizationLimit>();
        AuthorizationLimit authLimit =  new AuthorizationLimit();
        for(int i = 0; i < count; i ++) {
            authLimit.AuthorizationLimit = "123";
            authLimit.AuthorizationWeekStart = "Sun";
            authLimit.AuthorizationLimitDayOfWeek = "1";
            authLimit.AuthorizationLimitStartTime = "0600";
            authLimit.AuthorizationLimitEndTime = "1100";
            authorizationLimits.add(authLimit);
        }
        return authorizationLimits;
    }

    public boolean post() {
        request_url = getTestEnvironment().get("intake_endpoint") + ResourceGeneric.INTAKE_OPEN_EVV_PENNSYLVANIA_IMPORT_AUTH;
        boolean result = post_alt_evv(openevv_generic_auths, request_url);
        return result;
    }

    public boolean getFinalStatus() {
        boolean result = getFinalStatusAlt(ResourceGeneric.INTAKE_CHECK_STATUS);
        return result;
    }

    public boolean validateResponseStatus(boolean isResponseSuccess, boolean finalStatus, Constant.DataType dataType,
                                          int maxLength, String input, boolean expected) {
        if (isResponseSuccess == true){
            if(finalStatus == expected) {
                logInfo(String.format("Request to create client with ClientContactType with data type: '%s', length '%s', user input: '%s' successfully",
                        dataType.toString(), maxLength, input));
                logPass(String.format("Passed. Response status is '%s' matched with Expected Result is '%s'", isResponseSuccess, expected));
                return true;
            }
            else{
                logInfo(String.format("Failed to create client with ClientContactType with data type: '%s', length '%s', user input: '%s'.",
                        dataType.toString(), maxLength, input));
                logError("FAILED. Record(s) as expected result " + expected);
            }
        }
        return false;
    }

    public boolean validateAuthRecordsExistInDatabaseByStatus(boolean expected) {

        guids = new ArrayList<String>();
        guids.add(responseStatusAlt1.id);
        authDbService.mysqlUrl = mysql_url;
        authDbService.mysqlUser = mysql_username;
        authDbService.mysqlPass = mysql_pass;
        boolean result = authDbService.areAuthsExistingInDB(guids);

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

    public boolean validateAuthRecordsExistInDatabase(boolean expected) {

        guids = new ArrayList<String>();
        guids.add(responseStatusAlt1.id);
        authDbService.mysqlUrl = mysql_url;
        authDbService.mysqlUser = mysql_username;
        authDbService.mysqlPass = mysql_pass;

        int istatusCode  = authDbService.getStatusCodeOfDB(guids);
        boolean result = true;
        if (istatusCode == 0) {
            if (expected) {
                logPass("PASSED. Record(s) inserted into DB because expected is " + expected);
            } else {
                logError("FAILED. Record(s) not inserted into DB when expected is " + expected);
                result = false;
            }
        } else {
            if (expected) {
                logError("FAILED. Record(s) not inserted into DB when expected is " + expected);
                result = false;
            } else {
                logPass("PASSED. Record(s) inserted into DB because expected is " + expected);
            }
        }
        return result;
    }


    public boolean PayerID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).PayerID = value;

        logInfo(String.format("Request to create auth with PayerID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        boolean result = result1 && result2;

        if(result == false){
            errorMessage = String.format("The result create PayerID with data type: '%s', length '%s', user input: '%s'. is '%s'",dataType.toString(), maxLength, input, result);
            logInfo(errorMessage);
        }
        return result;
    }

    public boolean PayerProgram(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).PayerProgram = value;

        logInfo(String.format("Request to create auth with PayerProgram with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean ClientQualifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).ClientQualifier = value;

        logInfo(String.format("Request to create auth with ClientQualifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean ClientIdentifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).ClientIdentifier = value;

        logInfo(String.format("Request to create auth with ClientIdentifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean EmployeeID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).EmployeeID = value;

        logInfo(String.format("Request to create auth with EmployeeID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean EmployeePINQualifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).EmployeePINQualifier = value;

        logInfo(String.format("Request to create auth with EmployeePINQualifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean ProviderQualifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).ProviderQualifier = value;

        logInfo(String.format("Request to create auth with ProviderQualifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean ProviderID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).ProviderID = value;

        logInfo(String.format("Request to create auth with ProviderID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationReferenceNumber(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationReferenceNumber = value;

        logInfo(String.format("Request to create auth with AuthorizationReferenceNumber with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationServiceID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationServiceID = value;

        logInfo(String.format("Request to create auth with AuthorizationServiceID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationBillingType(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationBillingType = value;

        logInfo(String.format("Request to create auth with AuthorizationBillingType with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean Modifier1(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).Modifier1 = value;

        logInfo(String.format("Request to create auth with Modifier1 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean Modifier2(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).Modifier2 = value;

        logInfo(String.format("Request to create auth with Modifier2 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean Modifier3(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).Modifier3 = value;

        logInfo(String.format("Request to create auth with Modifier3 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean Modifier4(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).Modifier4 = value;

        logInfo(String.format("Request to create auth with Modifier4 with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationAmountType(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationAmountType = value;

        logInfo(String.format("Request to create auth with AuthorizationAmountType with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationMaximum(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationMaximum = value;

        logInfo(String.format("Request to create auth with AuthorizationMaximum with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean Units(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).Units = value;

        logInfo(String.format("Request to create auth with Units with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationStartDate(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationStartDate = value;

        logInfo(String.format("Request to create auth with AuthorizationStartDate with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationEndDate(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationEndDate = value;

        logInfo(String.format("Request to create auth with AuthorizationEndDate with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationShared(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationShared = value;

        logInfo(String.format("Request to create auth with AuthorizationShared with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationComments(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationComments = value;

        logInfo(String.format("Request to create auth with AuthorizationComments with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationLimitType(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationLimitType = value;

        logInfo(String.format("Request to create auth with AuthorizationLimitType with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationStatus(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationStatus = value;

        logInfo(String.format("Request to create auth with AuthorizationStatus with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean ClientDiagnosisCode(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).ClientDiagnosisCode = value;

        logInfo(String.format("Request to create auth with ClientDiagnosisCode with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationLimit(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationLimits.get(0).AuthorizationLimit = value;

        logInfo(String.format("Request to create auth with AuthorizationLimit with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationWeekStart(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationLimits.get(0).AuthorizationWeekStart = value;

        logInfo(String.format("Request to create auth with AuthorizationWeekStart with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationLimitDayOfWeek(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationLimits.get(0).AuthorizationLimitDayOfWeek = value;

        logInfo(String.format("Request to create auth with AuthorizationLimitDayOfWeek with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationLimitStartTime(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationLimits.get(0).AuthorizationLimitStartTime = value;

        logInfo(String.format("Request to create auth with AuthorizationLimitStartTime with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean AuthorizationLimitEndTime(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        openevv_generic_auths.get(0).AuthorizationLimits.get(0).AuthorizationLimitEndTime = value;

        logInfo(String.format("Request to create auth with AuthorizationLimitEndTime with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));
        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateAuthRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

}
