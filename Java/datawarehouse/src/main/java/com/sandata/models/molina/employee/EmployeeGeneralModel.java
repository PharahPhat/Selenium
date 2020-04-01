package com.sandata.models.molina.employee;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import com.sandata.utilities.DateTimeUtil;
import org.testng.Assert;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

public class EmployeeGeneralModel extends EmployeeGenericModel {
    @CsvHeader("ProviderID")
    @Column(value = "ProviderID",index = 0)
    private String providerID;

    @CsvHeader("EmployeeID")
    @Column(value = "EmployeeID",index = 1)
    private String employeeID;

    @CsvHeader("EmployeeLastName")
    @Column(value = "EmployeeLastName", index = 2)
    private String employeeLastName;

    @CsvHeader("EmployeeFirstName")
    @Column(value = "EmployeeFirstName", index = 3)
    private String employeeFirstName;

    @CsvHeader("Department")
    @Column(value = "Department", index = 4)
    private String department;

    @CsvHeader("EmployeeType")
    @Column(value = "EmployeeType", index = 5)
    private String employeeType;

    @CsvHeader("EmployeeEmail")
    @Column(value = "EmployeeEmail", index = 6)
    private String employeeEmail;

    @CsvHeader("EmployeeAddress1")
    @Column(value = "EmployeeAddress1", index = 7)
    private String employeeAddress1;

    @CsvHeader("EmployeeAddress2")
    @Column(value = "EmployeeAddress2", index = 8)
    private String employeeAddress2;

    @CsvHeader("EmployeeCity")
    @Column(value = "EmployeeCity", index = 9)
    private String employeeCity;

    @CsvHeader("EmployeeState")
    @Column(value = "EmployeeState", index = 10)
    private String employeeState;

    @CsvHeader("EmployeeZipCode")
    @Column(value = "EmployeeZipCode", index = 11)
    private String employeeZipCode;

    @CsvHeader("EmployeePhone")
    @Column(value = "EmployeePhone", index = 12)
    private String employeePhone;

    @CsvHeader("PayRate")
    @Column(value = "PayRate", index = 13)
    private String payRate;

    @CsvHeader("EmployeeIDCustom1")
    @Column(value = "EmployeeIDCustom1", index = 14)
    private String employeeIDCustom1;

    @CsvHeader("EmployeeIDCustom2")
    @Column(value = "EmployeeIDCustom2", index = 15)
    private String employeeIDCustom2;

    @CsvHeader("SocialSecurity")
    @Column(value = "SocialSecurity", index = 16)
    private String socialSecurity;

    @CsvHeader("EmployeeAPI")
    @Column(value = "EmployeeAPI", index = 17)
    private String employeeAPI;

    @CsvHeader("EmployeePosition")
    @Column(value = "EmployeePosition", index = 17)
    private String employeePosition;

    @CsvHeader("EmployeeHireDate")
    @Column(value = "EmployeeHireDate", index = 18)
    private String employeeHireDate;

    @CsvHeader("EmployeeBirthDate")
    @Column(value = "EmployeeBirthDate", index = 19)
    private String employeeBirthDate;

    @CsvHeader("EmployeeLocationName")
    @Column(value = "EmployeeLocationName", index = 20)
    private String employeeLocationName;

//    @CsvHeader("EmployeeTermDate")
//    @Column(value = "EmployeeTermDate", index = 21)
//    private String employeeTermDate;

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

//    public String getEmployeeTermDate() {
//        return employeeTermDate;
//    }
//
//    public void setEmployeeTermDate(String employeeTermDate) {
//        this.employeeTermDate = employeeTermDate;
//    }


    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress1() {
        return employeeAddress1;
    }

    public void setEmployeeAddress1(String employeeAddress1) {
        this.employeeAddress1 = employeeAddress1;
    }

    public String getEmployeeAddress2() {
        return employeeAddress2;
    }

    public void setEmployeeAddress2(String employeeAddress2) {
        this.employeeAddress2 = employeeAddress2;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public String getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState;
    }

    public String getEmployeeZipCode() {
        return employeeZipCode;
    }

    public void setEmployeeZipCode(String employeeZipCode) {
        this.employeeZipCode = employeeZipCode;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getPayRate() {
        return payRate;
    }

    public void setPayRate(String payRate) {
        this.payRate = payRate;
    }

    public String getEmployeeIDCustom1() {
        return employeeIDCustom1;
    }

    public void setEmployeeIDCustom1(String employeeIDCustom1) {
        this.employeeIDCustom1 = employeeIDCustom1;
    }

    public String getEmployeeIDCustom2() {
        return employeeIDCustom2;
    }

    public void setEmployeeIDCustom2(String employeeIDCustom2) {
        this.employeeIDCustom2 = employeeIDCustom2;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public String getEmployeeAPI() {
        return employeeAPI;
    }

    public void setEmployeeAPI(String employeeAPI) {
        this.employeeAPI = employeeAPI;
    }

    public String getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(String employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    public String getEmployeeBirthDate() {
        return employeeBirthDate;
    }

    public void setEmployeeBirthDate(String employeeBirthDate) {
        this.employeeBirthDate = employeeBirthDate;
    }

    public String getEmployeeLocationName() {
        return employeeLocationName;
    }

    public void setEmployeeLocationName(String employeeLocationName) {
        this.employeeLocationName = employeeLocationName;
    }

    public static void formatDataInDb(List<EmployeeGeneralModel> employeeGeneralModels) {
        DateTimeUtil dateTimeUtil = new DateTimeUtil();
        for(EmployeeGeneralModel employeeGeneralModel : employeeGeneralModels) {
            try {
                employeeGeneralModel.setEmployeeBirthDate
                        (dateTimeUtil.formatStringDate(employeeGeneralModel.getEmployeeBirthDate(),
                                "MMddyyyy", "yyyy-MM-dd"));
                employeeGeneralModel.setEmployeeHireDate
                        (dateTimeUtil.formatStringDate(employeeGeneralModel.getEmployeeHireDate(),
                                "dd-MMM-yy", "yyyy-MM-dd"));
                employeeGeneralModel.setEmployeeZipCode(employeeGeneralModel.getEmployeeZipCode().replace("-", ""));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        String toString = "EmployeeGeneralModel{" +
                "providerID='" + providerID + '\'' +
                "employeeID='" + employeeID + '\'' +
                "employeeLastName='" + employeeLastName + '\'' +
                "employeeFirstName='" + employeeFirstName + '\'' +
                "department='" + department + '\'' +
                "employeeType='" + employeeType + '\'' +
                "employeeEmail='" + employeeEmail + '\'' +
                "employeeAddress1='" + employeeAddress1 + '\'' +
                "employeeAddress2='" + employeeAddress2 + '\'' +
                "employeeCity='" + employeeCity + '\'' +
                "employeeState='" + employeeState + '\'' +
                //"employeeZipCode='" + employeeZipCode.replace("-","") + '\'' +
                "employeePhone='" + employeePhone + '\'' +
                "payRate='" + payRate + '\'' +
                "employeeIDCustom1='" + employeeIDCustom1 + '\'' +
                "employeeIDCustom2='" + employeeIDCustom2 + '\'' +
                "socialSecurity='" + socialSecurity + '\'' +
                "employeeAPI='" + employeeAPI + '\'' +
//TODO: this is the parameters have some issues for convert date-time, will investigate for these case later.
//                "employeeHireDate='" + employeeHireDate + '\'' +
//                "employeeBirthDate='" + employeeBirthDate + '\'' +
//                "employeeLocationName='" + employeeLocationName + '\'' +
                '}';
        return toString.replace("null", "");
    }

    public void verifyFormatField(String fieldValue, String regex, String errorMessage) {
        if(!fieldValue.equals(null))
            Assert.assertTrue(fieldValue.matches(regex), errorMessage);
    }

    public void verifyFormatFields() {
        String errorMessage1 = "Length of field %s is not correctly, value is %s";
        String errorMessage2 = "Format of field %s is not correctly yyyy-MM-dd";
        String regexDateTime = "(^$)|(^[0-9]{4}-[0-9]{2}-[0-9]{2}$)";

        this.verifyFormatField(this.providerID, "^\\w{0,50}$", String.format(errorMessage1, "providerID", providerID));
        this.verifyFormatField(this.employeeID, "^\\w{0,9}$", String.format(errorMessage1, "employeeID", employeeID));
        this.verifyFormatField(this.employeeLastName, "^.{0,30}$", String.format(errorMessage1, "employeeLastName", employeeLastName));
        this.verifyFormatField(this.employeeFirstName, "^.{0,30}$", String.format(errorMessage1, "employeeFirstName", employeeFirstName));
        this.verifyFormatField(this.department, "^.{0,3}$", String.format(errorMessage1, "department", department));
        this.verifyFormatField(this.employeeType, "^\\w{0,1}$", String.format(errorMessage1, "employeeType", employeeType));
        this.verifyFormatField(this.employeeEmail, "^.{0,64}$", String.format(errorMessage1, "employeeEmail", employeeEmail));
        this.verifyFormatField(this.employeeAddress1, "^.{0,30}$", String.format(errorMessage1, "employeeAddress1", employeeAddress1));
        this.verifyFormatField(this.employeeAddress2, "^.{0,30}$", String.format(errorMessage1, "employeeAddress2", employeeAddress2));
        this.verifyFormatField(this.employeeCity, "^.{0,30}$", String.format(errorMessage1, "employeeCity", employeeCity));
        this.verifyFormatField(this.employeeState, "^\\w{0,2}$", String.format(errorMessage1, "employeeState", employeeState));
        this.verifyFormatField(this.employeeZipCode, "^\\d{9}$", String.format(errorMessage1, "employeeZipCode", employeeZipCode));
        this.verifyFormatField(this.employeePhone, "^[0-9]{10}$", String.format(errorMessage1, "employeePhone", employeePhone));
        this.verifyFormatField(this.payRate, "^[0-9]*\\.?[0-9]*$", String.format(errorMessage1, "payRate", payRate));
        this.verifyFormatField(this.employeeIDCustom1, "^\\w{0,64}$", String.format(errorMessage1, "employeeIDCustom1", employeeIDCustom1));
        this.verifyFormatField(this.employeeIDCustom2, "^\\w{0,64}$", String.format(errorMessage1, "employeeIDCustom2", employeeIDCustom2));
        this.verifyFormatField(this.socialSecurity, "^\\w{0,9}$", String.format(errorMessage1, "socialSecurity", socialSecurity));
        this.verifyFormatField(this.employeeAPI, "^\\w{0,25}$", String.format(errorMessage1, "employeeAPI", employeeAPI));
        this.verifyFormatField(this.employeeHireDate, regexDateTime, String.format(errorMessage2, "employeeHireDate", employeeHireDate));
        this.verifyFormatField(this.employeeBirthDate, regexDateTime, String.format(errorMessage2, "employeeBirthDate", employeeBirthDate));
        this.verifyFormatField(this.employeeLocationName, "^.{0,20}$", String.format(errorMessage1, "employeeLocationName", employeeLocationName));
    }

    public static void verifyFormatFieldOfData(List<EmployeeGeneralModel> employeeGeneralList) {
        for (EmployeeGeneralModel recordCsv: employeeGeneralList){
            recordCsv.verifyFormatFields();
        }
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        if (Objects.isNull(providerID)) {
            return false;
        }
        if (Objects.isNull(employeeID)) {
            return false;
        }
        if (Objects.isNull(employeeLastName)) {
            return false;
        }
        if (Objects.isNull(employeeFirstName)) {
            return false;
        }
        return true;
    }
}
