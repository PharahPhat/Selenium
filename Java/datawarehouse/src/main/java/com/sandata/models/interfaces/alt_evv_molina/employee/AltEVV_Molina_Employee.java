package com.sandata.models.interfaces.alt_evv_molina.employee;

import com.google.gson.annotations.Expose;
import com.sandata.common.Constant;
import com.sandata.common.resource.Employee;
import com.sandata.models.GenericModel;
import com.sandata.models.interfaces.common.ProviderIdentification;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class AltEVV_Molina_Employee extends GenericModel {
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
    public transient List<AltEVV_Molina_Employee> altEVV_molina_employees;
    @Expose
    public transient AltEVV_Molina_Employee altEVV_molina_employee;

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
        for (int i = 0; i <= altEVV_molina_employees.size() - 1; i++) {
            lastNames.add(altEVV_molina_employees.get(i).EmployeeLastName);
        }
        return lastNames;
    }

    public void initData(int count) {
        if (count < 1) {
            return;
        }
        altEVV_molina_employees = new ArrayList<>();
        for (int i = 1; i <= count ; i++ ) {
            AltEVV_Molina_Employee altEVV_molina_employee = initAltEVVMolinaEmployeeData();
            altEVV_molina_employees.add(altEVV_molina_employee);
        }
    }

    public AltEVV_Molina_Employee initAltEVVMolinaEmployeeData() {
        super.initData();

        AltEVV_Molina_Employee altEVV_molina_employee = new AltEVV_Molina_Employee();

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

        altEVV_molina_employee.ProviderIdentification = providerIdentification;
        altEVV_molina_employee.EmployeeQualifier = Constant.EmployeeQualifier.EmployeeSSN.toString();
        altEVV_molina_employee.EmployeeIdentifier = ssn;
        altEVV_molina_employee.EmployeeSSN = ssn;
        altEVV_molina_employee.EmployeeOtherID = employeeOtherID;
        altEVV_molina_employee.SequenceID = uniqueNum;
        altEVV_molina_employee.EmployeeFirstName = FName;
        altEVV_molina_employee.EmployeeLastName = LName;
        altEVV_molina_employee.EmployeeEmail = email;
        altEVV_molina_employee.EmployeeManagerEmail = managerEmail;
        altEVV_molina_employee.EmployeePosition = "HHA";
        altEVV_molina_employee.EmployeeAPI = uniqueNum;
        return altEVV_molina_employee;
    }

    public boolean post() {
        request_url = getTestEnvironment().get("intake_endpoint") + Employee.INTAKE_ALT_EVV_IMPORT_MOLINA_EMPLOYEE;
        boolean result = post(altEVV_molina_employees, request_url);
        return result;
    }

    public boolean createSingleEmployee() {
        int retry1 = 10;
        int retry2 = 3;
        int i = 1;
        int j = 1;

        while (i <= retry1) {
            initData(1);
            while (j <= retry2) {
                boolean output1 = post();
                if (output1) {
                    logInfo(String.format("SUCCESS: Post request to create employee"));
                    boolean output2 = getFinalStatus();
                    boolean isEmployeeExistInDatabase = employeeDbService.isEmployeeExistInDatabase(account_id, altEVV_molina_employees.get(0).EmployeeLastName);
                    if (output2 && isEmployeeExistInDatabase){
                        logPass(String.format("SUCCESS: Post request to create employee, Employee '%s' is added into EVV Database Successfully", altEVV_molina_employees.get(0).EmployeeLastName));
                        return true;
                    }
                } else {
                    logInfo(String.format("FAILED: Post request to create employee"));
                }
                j++;
            }
            i++;
        }
        return false;
    }

    public boolean createMulipleEmployees(int count) {
        int retry1 = 10;
        int retry2 = 3;
        int i = 1;
        int j = 1;

        while (i <= retry1) {
            initData(count);
            while (j <= retry2) {
                boolean output1 = post();
                if (output1) {
                    logInfo(String.format("SUCCESS: Post request to create employee"));
                    boolean output2 = getFinalStatus();

                    List<String> lastNames = getLastNames();
                    boolean isAllEmplExistInDB = employeeDbService.isEmployeesExistInDatabase(account_id, lastNames);

                    if (output2 && isAllEmplExistInDB){
                        for (int k = 0; k <= count - 1; k++) {
                            logPass(String.format("SUCCESS: Post request to create employee, Employee '%s' is added into EVV Database Successfully", altEVV_molina_employees.get(k).EmployeeLastName));
                        }
                        return true;
                    }
                } else {
                    logInfo(String.format("FAILED: Post request to create '%s' employees", count));
                }
                j++;
            }
            i++;
        }
        return false;
    }

    public boolean getFinalStatus() {
        boolean result = getFinalStatus(Employee.INTAKE_CHECK_STATUS);
//        boolean result = false;
//        if (responseStatus1 != null && responseStatus1.status.equalsIgnoreCase("SUCCESS")) {
//            request_status_url = request_url + Employee.INTAKE_CHECK_STATUS + responseStatus1.id;
//            Map<String, String> header = new HashMap<>();
//            header.put(ContentType.toString(), ApplicationJson.toString());
//            header.put(Constant.HEADER.Account.toString(), account_id);
//            response2 = webServicesBase.sendGET(request_status_url, header, auth_username, auth_password);
//
//            String responseJson = response2.body().prettyPrint();
//            responseStatus2 = (ResponseStatusModel)toObject(responseJson, ResponseStatusModel.class);
//
//            if(responseStatus2.status.equalsIgnoreCase("FAILED")) {
//                responseStatusFailed = (ResponseStatusFailed<AltEVV_Molina_Employee>)toObject(responseJson, ResponseStatusFailed.class);
//                logInfo(String.format("uuid: '%s', Status: '%s'", responseStatusFailed.id, responseStatusFailed.status));
//                return false;
//            } else if (responseStatus2.status.equalsIgnoreCase("SUCCESS")) {
//                return true;
//            }
//        }
        return result;
    }

    /***
     * VALIDATION: Test max length for EmployeeSSN
     * @param maxLength
     * @param expected
     * @return
     */
    public boolean EmployeeSSN(int maxLength, boolean expected) {
        initData(1);
        altEVV_molina_employees.get(0).EmployeeSSN = RandomStringUtils.randomNumeric(maxLength);
        boolean output = post();

        if (output) {
            logInfo(String.format("Request to create employee with EmployeeSSN with length '%s' successfully",maxLength ));
        } else {
            logInfo(String.format("Failed to request to create employee with EmployeeSSN with length '%s'",maxLength ));
        }

        if(output == expected) {
            logPass(String.format("EmployeeSSN with max length '%s' results in request '%s'", maxLength, expected));
            return true;
        } else {
            logError(String.format(String.format("EmployeeSSN with max length '%s' results in request '%s' even expected is '%s'", maxLength, output, expected)));
            return false;
        }
    }

    /***
     * VALIDATION: Test max length for EmployeeLastName
     * @param maxLength
     * @param expected
     * @return
     */
    public boolean EmployeeLastName(int maxLength, boolean expected) {
        initData(1);
        altEVV_molina_employees.get(0).EmployeeLastName = RandomStringUtils.randomAlphabetic(maxLength);
        boolean output = post();

        if (output) {
            logInfo(String.format("Request to create employee with EmployeeLastName with length '%s' successfully",maxLength ));
        } else {
            logInfo(String.format("Failed to request to create employee with EmployeeLastName with length '%s'",maxLength ));
        }

        if(output == expected) {
            logPass(String.format("EmployeeLastName with max length '%s' results in request '%s'", maxLength, expected));
            return true;
        } else {
            logError(String.format(String.format("EmployeeLastName with max length '%s' results in request '%s' even expected is '%s'", maxLength, output, expected)));
            return false;
        }
    }
}
