package com.sandata.models.interfaces.alt_evv_pennylvania.employee;

import com.google.gson.annotations.Expose;
import com.sandata.common.Constant;
import com.sandata.common.resource.Employee;
import com.sandata.models.GenericModel;
import com.sandata.models.interfaces.common.ProviderIdentification;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class AltEVV_Pennylvania_Employee extends GenericModel {
    public ProviderIdentification ProviderIdentification;
    public String EmployeeIdentifier;
    public String EmployeeOtherID;
    public String SequenceID;
    public String EmployeeQualifier;
    public String EmployeeSSN;
    public String EmployeeLastName;
    public String EmployeeFirstName;
    public String EmployeeEmail;
    public String EmployeeManagerEmail;
    public String EmployeePosition;
    public String EmployeeAPI;
    public String ErrorCode;
    public String ErrorMessage;

    @Expose
    public transient List<AltEVV_Pennylvania_Employee> altEVV_pennylvania_employees;
    @Expose
    public transient AltEVV_Pennylvania_Employee altEVV_pennylvania_employee;

    @Expose
    public transient List<String> lastNames;

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }

    public List<String> getLastNames() {
        lastNames = new ArrayList<>();
        for (int i = 0; i <= altEVV_pennylvania_employees.size() - 1; i++) {
            lastNames.add(altEVV_pennylvania_employees.get(i).EmployeeLastName);
        }
        return lastNames;
    }

    public void initData(int count) {
        if (count < 1) {
            return;
        }
        altEVV_pennylvania_employees = new ArrayList<>();
        for (int i = 1; i <= count ; i++ ) {
            AltEVV_Pennylvania_Employee altEVV_pennylvania_employee = initAltEVVPennylvaniaEmployeeData();
            altEVV_pennylvania_employees.add(altEVV_pennylvania_employee);
        }
    }

    public AltEVV_Pennylvania_Employee initAltEVVPennylvaniaEmployeeData() {
        super.initData();

        AltEVV_Pennylvania_Employee altEVV_pennylvania_employee = new AltEVV_Pennylvania_Employee();

        String ssn = employeeDbService.generateNewEmployeeSsn(account_id);
        String LName = "stxLN" + RandomStringUtils.randomAlphabetic(20);
        String FName = "stxFN" + RandomStringUtils.randomAlphabetic(20);
        String uniqueNum = commons.generateUniqueNumber();
        String email = "stx" + uniqueNum + "@com.dwh.sandata.com";
        String managerEmail = "stxmanager" + uniqueNum + "@com.dwh.sandata.com";
        String employeeOtherID = "stx" + commons.generateUniqueNumber();

        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.ProviderQualifier = Constant.ProviderQualifier.Other.toString();
        providerIdentification.ProviderID = provider_id;

        altEVV_pennylvania_employee.ProviderIdentification = providerIdentification;
        altEVV_pennylvania_employee.EmployeeQualifier = "EmployeeSSN";
        altEVV_pennylvania_employee.EmployeeIdentifier = ssn;
        altEVV_pennylvania_employee.EmployeeSSN = ssn;
        altEVV_pennylvania_employee.EmployeeOtherID = employeeOtherID;
        altEVV_pennylvania_employee.SequenceID = uniqueNum;
        altEVV_pennylvania_employee.EmployeeFirstName = FName;
        altEVV_pennylvania_employee.EmployeeLastName = LName;
        altEVV_pennylvania_employee.EmployeeEmail = email;
        altEVV_pennylvania_employee.EmployeeManagerEmail = managerEmail;
        altEVV_pennylvania_employee.EmployeePosition = "HHA";
        altEVV_pennylvania_employee.EmployeeAPI = uniqueNum;
        return altEVV_pennylvania_employee;
    }

    public boolean post() {
        request_url = getTestEnvironment().get("intake_endpoint") + Employee.INTAKE_ALT_EVV_IMPORT_MOLINA_EMPLOYEE;
        boolean result = post(altEVV_pennylvania_employees, request_url);
        return result;
    }

    public boolean getFinalStatus() {
        boolean result = getFinalStatus(Employee.INTAKE_CHECK_STATUS);
        return result;
    }

    public boolean ProviderQualifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).ProviderIdentification.ProviderQualifier = value;

        logInfo(String.format("Request to create Employee with ProviderQualifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        return (result1 && result2);
    }


    public boolean ProviderID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).ProviderIdentification.ProviderID = value;

        logInfo(String.format("Request to create ProviderID with ProviderID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean EmployeeIdentifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).EmployeeIdentifier = value;

        logInfo(String.format("Request to create ProviderID with EmployeeIdentifier with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        return (result1 && result2);
    }


    public boolean EmployeeOtherID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).EmployeeOtherID = value;

        logInfo(String.format("Request to create ProviderID with EmployeeOtherID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean SequenceID(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).SequenceID = value;

        logInfo(String.format("Request to create ProviderID with SequenceID with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean EmployeeQualifier(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).EmployeeQualifier = value;

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        boolean result = result1 && result2;

        logInfo(String.format("********** The result create EmployeeQualifier with data type: '%s', length '%s', user input: '%s'. is '%s' *********",
                dataType.toString(), maxLength, input, result));

        return (result1 && result2);
    }

    public boolean EmployeeLastName(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).EmployeeLastName = value;

        logInfo(String.format("Request to create ProviderID with EmployeeLastName with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean EmployeeFirstName(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).EmployeeFirstName = value;

        logInfo(String.format("Request to create ProviderID with EmployeeFirstName with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean EmployeeEmail(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).EmployeeEmail = value;

        logInfo(String.format("Request to create ProviderID with EmployeeEmail with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean EmployeeManagerEmail(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).EmployeeManagerEmail = value;

        logInfo(String.format("Request to create ProviderID with EmployeeManagerEmail with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean EmployeeSSN(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).EmployeeSSN = value;

        logInfo(String.format("Request to create Employee with EmployeeSSN with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean EmployeePosition(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).EmployeePosition = value;

        logInfo(String.format("Request to create Employee with EmployeeSSN with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean EmployeeAPI(Constant.DataType dataType, int maxLength, String input, boolean expected) {
        initData(1);
        String value = generateFieldValue(dataType, maxLength, input);
        altEVV_pennylvania_employees.get(0).EmployeeAPI = value;

        logInfo(String.format("Request to create Employee with EmployeeSSN with data type: '%s', length '%s', user input: '%s'.",
                dataType.toString(), maxLength, input));

        boolean isResponseSuccess = post();

        boolean finalStatus = getFinalStatus();

        boolean result1 = validateResponseStatus(isResponseSuccess, finalStatus, dataType, maxLength, value, expected);

        boolean result2 = validateEmployeeRecordsExistInDatabase(expected);

        return (result1 && result2);
    }

    public boolean validateResponseStatus(boolean isResponseSuccess, boolean finalStatus, Constant.DataType dataType,
                                          int maxLength, String input, boolean expected) {
        if (isResponseSuccess == true){
            if(finalStatus == expected) {
                logInfo(String.format("Request to create with data type: '%s', length '%s', user input: '%s' successfully",
                        dataType.toString(), maxLength, input));
                logPass(String.format("Passed. Response status is '%s' matched with Expected Result is '%s'", isResponseSuccess, expected));
                return true;
            }
            else{
                logInfo(String.format("Failed to create with data type: '%s', length '%s', user input: '%s'.",
                        dataType.toString(), maxLength, input));
                logError("FAILED. Record(s) as expected result " + expected);
            }
        }
        return false;
    }

    public boolean validateEmployeeRecordsExistInDatabase(boolean expected) {
        List<String> lastNames = getLastNames();

        boolean result = employeeDbService.isEmployeeExistInDatabase(account_id,lastNames.get(0));

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

}
