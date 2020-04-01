package com.sandata.models.interfaces.open_evv_generic.employee;

import com.google.gson.annotations.Expose;
import com.interop.common.StateAccount;
import com.sandata.models.GenericModel;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;


public class OpenEVV_Generic_Employee extends GenericModel {

    public String Account="";
    public String EmployeePIN="";
    public String EmployeeID="";
    public String Status = "";
    public String EmployeeEmailAddress="";
    public String EmployeeSocialSecurity="";
    public String EmployeeIDCustom1="";
    public String EmployeeIDCustom2="";
    public String EmployeeHireDate="";
    public String EmployeeEndDate="";
    public String EmployeeLastName="";
    public String EmployeeFirstName="";
    public String EmployeeMiddleInitial="";
    public String Department="";
    public String EmployeeType="";
    public String Discipline="";
    public String EmployeeAddress1="";
    public String EmployeeAddress2="";
    public String EmployeeCity="";

    public String EmployeeState="";
    public String EmployeeZipCode="";
    public String EmployeePhone="";
    public String EmployeeAltPhone="";
    public String EmployeeAltPhone2="";
    public String EmployeeAPI="";


    public String PayRate="";


    public String EmployeeBirthDate="";
    public String EmployeeGender="";
    public String EmployeePrimaryLocation="";

    @Expose
    public transient List<OpenEVV_Generic_Employee> openevv_generic_employees;

    @Expose
    public transient List<String> clientIds;

    @Expose
    public transient List<String> fnames;

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getEmployeePIN() {
        return EmployeePIN;
    }

    public void setEmployeePIN(String employeePIN) {
        EmployeePIN = employeePIN;
    }

    public String getEmployeeLastName() {
        return EmployeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        EmployeeLastName = employeeLastName;
    }

    public String getEmployeeFirstName() {
        return EmployeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        EmployeeFirstName = employeeFirstName;
    }

    public String getEmployeeMiddleInitial() {
        return EmployeeMiddleInitial;
    }

    public void setEmployeeMiddleInitial(String employeeMiddleInitial) {
        EmployeeMiddleInitial = employeeMiddleInitial;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getEmployeeType() {
        return EmployeeType;
    }

    public void setEmployeeType(String employeeType) {
        EmployeeType = employeeType;
    }

    public String getDiscipline() {
        return Discipline;
    }

    public void setDiscipline(String discipline) {
        Discipline = discipline;
    }

    public String getEmployeeEmailAddress() {
        return EmployeeEmailAddress;
    }

    public void setEmployeeEmailAddress(String employeeEmailAddress) {
        EmployeeEmailAddress = employeeEmailAddress;
    }

    public String getEmployeeAddress1() {
        return EmployeeAddress1;
    }

    public void setEmployeeAddress1(String employeeAddress1) {
        EmployeeAddress1 = employeeAddress1;
    }

    public String getEmployeeAddress2() {
        return EmployeeAddress2;
    }

    public void setEmployeeAddress2(String employeeAddress2) {
        EmployeeAddress2 = employeeAddress2;
    }

    public String getEmployeeCity() {
        return EmployeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        EmployeeCity = employeeCity;
    }

    public String getEmployeeState() {
        return EmployeeState;
    }

    public void setEmployeeState(String employeeState) {
        EmployeeState = employeeState;
    }

    public String getEmployeeZipCode() {
        return EmployeeZipCode;
    }

    public void setEmployeeZipCode(String employeeZipCode) {
        EmployeeZipCode = employeeZipCode;
    }

    public String getEmployeePhone() {
        return EmployeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        EmployeePhone = employeePhone;
    }

    public String getEmployeeAltPhone() {
        return EmployeeAltPhone;
    }

    public void setEmployeeAltPhone(String employeeAltPhone) {
        EmployeeAltPhone = employeeAltPhone;
    }

    public String getEmployeeAltPhone2() {
        return EmployeeAltPhone2;
    }

    public void setEmployeeAltPhone2(String employeeAltPhone2) {
        EmployeeAltPhone2 = employeeAltPhone2;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeIDCustom1() {
        return EmployeeIDCustom1;
    }

    public void setEmployeeIDCustom1(String employeeIDCustom1) {
        EmployeeIDCustom1 = employeeIDCustom1;
    }

    public String getEmployeeIDCustom2() {
        return EmployeeIDCustom2;
    }

    public void setEmployeeIDCustom2(String employeeIDCustom2) {
        EmployeeIDCustom2 = employeeIDCustom2;
    }

    public String getEmployeeSocialSecurity() {
        return EmployeeSocialSecurity;
    }

    public void setEmployeeSocialSecurity(String employeeSocialSecurity) {
        EmployeeSocialSecurity = employeeSocialSecurity;
    }

    public String getPayRate() {
        return PayRate;
    }

    public void setPayRate(String payRate) {
        PayRate = payRate;
    }

    public String getEmployeeHireDate() {
        return EmployeeHireDate;
    }

    public void setEmployeeHireDate(String employeeHireDate) {
        EmployeeHireDate = employeeHireDate;
    }

    public String getEmployeeEndDate() {
        return EmployeeEndDate;
    }

    public void setEmployeeEndDate(String employeeEndDate) {
        EmployeeEndDate = employeeEndDate;
    }

    public String getEmployeeBirthDate() {
        return EmployeeBirthDate;
    }

    public void setEmployeeBirthDate(String employeeBirthDate) {
        EmployeeBirthDate = employeeBirthDate;
    }

    public String getEmployeeGender() {
        return EmployeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        EmployeeGender = employeeGender;
    }

    public String getEmployeePrimaryLocation() {
        return EmployeePrimaryLocation;
    }

    public void setEmployeePrimaryLocation(String employeePrimaryLocation) {
        EmployeePrimaryLocation = employeePrimaryLocation;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public static OpenEVV_Generic_Employee initModelByState(StateAccount state){
        OpenEVV_Generic_Employee model = new OpenEVV_Generic_Employee();
        model = model.initOpenEVVGenericEmployeeData();
        model.Account = state.getAccountID();
        System.out.println(state);
        switch (state.getStateName()) {
            case "Vermont":
                model.EmployeeID = "D"+RandomStringUtils.randomNumeric(6);
                break;
            default:
                model.EmployeeID = RandomStringUtils.randomNumeric(7);
                break;
        }

        return model;
    }

    //Init mode for performance test
    public static OpenEVV_Generic_Employee initModelByState(StateAccount state, String fName){
        OpenEVV_Generic_Employee model = new OpenEVV_Generic_Employee();
        model = model.initOpenEVVGenericEmployeeData(fName);
        model.Account = state.getAccountID();
        System.out.println(state);
        switch (state.getStateName()) {
            case "Vermont":
                model.EmployeeID = "D"+RandomStringUtils.randomNumeric(6);
                break;
            default:
                model.EmployeeID = RandomStringUtils.randomNumeric(7);
                break;
        }

        return model;
    }

    public void initData(int count) {
        if (count < 1) {
            return;
        }
        openevv_generic_employees = new ArrayList<>();
        for (int i = 1; i <= count ; i++ ) {
            OpenEVV_Generic_Employee openevv_generic_employee = initOpenEVVGenericEmployeeData();
            openevv_generic_employees.add(openevv_generic_employee);
        }
    }

    public OpenEVV_Generic_Employee initOpenEVVGenericEmployeeData() {
        super.initData();

        OpenEVV_Generic_Employee openEVV_generic_employee = new OpenEVV_Generic_Employee();

        openEVV_generic_employee.Account = "14420";
        openEVV_generic_employee.EmployeePIN = RandomStringUtils.randomNumeric(9);
        openEVV_generic_employee.EmployeeID = RandomStringUtils.randomNumeric(5);
        openEVV_generic_employee.Status = "";
        openEVV_generic_employee.EmployeeEmailAddress = RandomStringUtils.randomNumeric(10).concat("@mailinator.com");
        openEVV_generic_employee.EmployeeSocialSecurity = "";
        openEVV_generic_employee.EmployeeIDCustom1 = RandomStringUtils.randomNumeric(9);
        openEVV_generic_employee.EmployeeIDCustom2 = RandomStringUtils.randomNumeric(12);
        openEVV_generic_employee.EmployeeHireDate = "2019-12-12";
        openEVV_generic_employee.EmployeeEndDate = "2019-12-12";
        openEVV_generic_employee.EmployeeLastName = "Auto"+RandomStringUtils.randomAlphabetic(10);
        openEVV_generic_employee.EmployeeFirstName = "Auto"+RandomStringUtils.randomAlphabetic(8);
        openEVV_generic_employee.EmployeeMiddleInitial = "A";
        openEVV_generic_employee.Department = "ABC";
        openEVV_generic_employee.EmployeeType = "";
        openEVV_generic_employee.Discipline = "Value";
        openEVV_generic_employee.EmployeeAddress1 = "1 Road";
        openEVV_generic_employee.EmployeeAddress2 = "Apartment Two for Employee add";
        openEVV_generic_employee.EmployeeCity = "New York";
        openEVV_generic_employee.EmployeeState = "NY";
        openEVV_generic_employee.EmployeeZipCode = "11109-9888";
        openEVV_generic_employee.EmployeePhone = RandomStringUtils.randomNumeric(10);
        openEVV_generic_employee.EmployeeAltPhone = RandomStringUtils.randomNumeric(10);
        openEVV_generic_employee.EmployeeAltPhone2 = RandomStringUtils.randomNumeric(10);
        openEVV_generic_employee.EmployeeAPI = null;
        openEVV_generic_employee.PayRate = "23.76";


        openEVV_generic_employee.EmployeeBirthDate = "2010-12-12";
        openEVV_generic_employee.EmployeeGender = "M";
        openEVV_generic_employee.EmployeePrimaryLocation = "Location Queens";

        return openEVV_generic_employee;
    }


    //Init employee data for performance testing
    public OpenEVV_Generic_Employee initOpenEVVGenericEmployeeData(String fName) {
        super.initData();

        OpenEVV_Generic_Employee openEVV_generic_employee = new OpenEVV_Generic_Employee();

        openEVV_generic_employee.Account = "14420";
        openEVV_generic_employee.EmployeePIN = RandomStringUtils.randomNumeric(9);
        openEVV_generic_employee.EmployeeID = RandomStringUtils.randomNumeric(5);
        openEVV_generic_employee.Status = "";
        openEVV_generic_employee.EmployeeEmailAddress = RandomStringUtils.randomNumeric(10).concat("@mailinator.com");
        openEVV_generic_employee.EmployeeSocialSecurity = "";
        openEVV_generic_employee.EmployeeIDCustom1 = RandomStringUtils.randomAlphanumeric(6);
        openEVV_generic_employee.EmployeeIDCustom2 = RandomStringUtils.randomAlphanumeric(6);
        openEVV_generic_employee.EmployeeHireDate = "2019-12-12";
        openEVV_generic_employee.EmployeeEndDate = "2019-12-12";
        openEVV_generic_employee.EmployeeLastName = "Auto"+RandomStringUtils.randomAlphabetic(10);
        openEVV_generic_employee.EmployeeFirstName = fName;
        openEVV_generic_employee.EmployeeMiddleInitial = "A";
        openEVV_generic_employee.Department = "ABC";
        openEVV_generic_employee.EmployeeType = "";
        openEVV_generic_employee.Discipline = "Value";
        openEVV_generic_employee.EmployeeAddress1 = "1 Road";
        openEVV_generic_employee.EmployeeAddress2 = "Apartment Two for Employee add";
        openEVV_generic_employee.EmployeeCity = "New York";
        openEVV_generic_employee.EmployeeState = "NY";
        openEVV_generic_employee.EmployeeZipCode = "11109-9888";
        openEVV_generic_employee.EmployeePhone = RandomStringUtils.randomNumeric(10);
        openEVV_generic_employee.EmployeeAltPhone = RandomStringUtils.randomNumeric(10);
        openEVV_generic_employee.EmployeeAltPhone2 = RandomStringUtils.randomNumeric(10);
        openEVV_generic_employee.EmployeeAPI = null;
        openEVV_generic_employee.PayRate = "23.76";


        openEVV_generic_employee.EmployeeBirthDate = "2010-12-12";
        openEVV_generic_employee.EmployeeGender = "M";
        openEVV_generic_employee.EmployeePrimaryLocation = "Location Queens";

        return openEVV_generic_employee;
    }

}
