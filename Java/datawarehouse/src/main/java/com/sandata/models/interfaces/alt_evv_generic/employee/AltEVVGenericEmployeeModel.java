package com.sandata.models.interfaces.alt_evv_generic.employee;

import com.sandata.common.Constant;
import com.interop.common.StateAccount;
import com.sandata.models.GenericModel;
import com.sandata.models.interfaces.common.ProviderIdentification;
import org.apache.commons.lang3.RandomStringUtils;

public class AltEVVGenericEmployeeModel extends GenericModel {
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
    public String EmployeeHireDate;
    public String EmployeeEndDate;
    public String ErrorCode;
    public String ErrorMessage;

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }

    private static final String RI_HEAD_EMPLOYEE_OTHER_ID_STR = "00000";
    private static final int RI_EMPLOYEE_OTHER_ID_STR_LEN = 9;
    private static final int RI_EMPLOYEE_NAME_STR_LEN = 19;

    public static String generateRIEmployeeOtherIDNum() {
        return RI_HEAD_EMPLOYEE_OTHER_ID_STR + RandomStringUtils.randomNumeric(
                RI_EMPLOYEE_OTHER_ID_STR_LEN - RI_HEAD_EMPLOYEE_OTHER_ID_STR.length());
    }

    public static String generateRIEmployeeIdentifierNum(StateAccount stateAccount) {
        return (new AltEVVGenericEmployeeModel()).employeeDbService.generateNewRIEmployeeSsn(stateAccount.getAccountID());
    }

    public static AltEVVGenericEmployeeModel initAltEVVRIEmployeeModelData(StateAccount stateAccount) {
        AltEVVGenericEmployeeModel altEVVGenericEmployeeModel = new AltEVVGenericEmployeeModel();

        String employeeIdentifierNum = generateRIEmployeeIdentifierNum(stateAccount);
        String uniqueNum = altEVVGenericEmployeeModel.commons.generateUniqueNumber();
        String email = "ri" + uniqueNum + "@com.dwh.sandata.com";
        String managerEmail = "rimanager" + uniqueNum + "@com.dwh.sandata.com";

        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.ProviderQualifier = stateAccount.getProviderQualifier();
        providerIdentification.ProviderID = stateAccount.getProviderID();

        altEVVGenericEmployeeModel.ProviderIdentification = providerIdentification;
        altEVVGenericEmployeeModel.EmployeeQualifier = stateAccount.getEmployeeQualifier();
        altEVVGenericEmployeeModel.EmployeeIdentifier = employeeIdentifierNum;
        altEVVGenericEmployeeModel.EmployeeSSN = employeeIdentifierNum;
        altEVVGenericEmployeeModel.EmployeeOtherID = generateRIEmployeeOtherIDNum();
        altEVVGenericEmployeeModel.SequenceID = uniqueNum;
        altEVVGenericEmployeeModel.EmployeeFirstName = "F" + RandomStringUtils.randomAlphabetic(RI_EMPLOYEE_NAME_STR_LEN);
        altEVVGenericEmployeeModel.EmployeeLastName = "L" + RandomStringUtils.randomAlphabetic(RI_EMPLOYEE_NAME_STR_LEN);
        altEVVGenericEmployeeModel.EmployeeEmail = email;
        altEVVGenericEmployeeModel.EmployeeManagerEmail = managerEmail;
        altEVVGenericEmployeeModel.EmployeePosition = Constant.RI_EMPLOYEE_POSITION.RN.toString();
        altEVVGenericEmployeeModel.EmployeeAPI = "UserEmployeeAPI";
        altEVVGenericEmployeeModel.EmployeeHireDate = "2019-01-11";
        altEVVGenericEmployeeModel.EmployeeEndDate = "2019-01-12";

        return altEVVGenericEmployeeModel;
    }
}
