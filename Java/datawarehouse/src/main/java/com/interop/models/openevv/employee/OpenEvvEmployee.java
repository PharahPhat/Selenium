package com.interop.models.openevv.employee;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;
import com.sandata.common.Constant;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class OpenEvvEmployee extends AltBaseModel {
    @SerializedName("Account")
    @Builder.Default
    public String account = StateAccount.loadStateAccount().getAccountID();
    @SerializedName("EmployeePIN")
    @Builder.Default
    public String employeePIN = RandomStringUtils.randomNumeric(9);
    @SerializedName("EmployeeID")
    @Builder.Default
    public String employeeID = RandomStringUtils.randomNumeric(5);
    @SerializedName("Status")
    @Builder.Default
    public String status = "";
    @SerializedName("EmployeeEmailAddress")
    @Builder.Default
    public String employeeEmailAddress = commons.generateUniqueNumber().concat("@mailinator.com");
    @SerializedName("EmployeeSocialSecurity")
    @Builder.Default
    public String employeeSocialSecurity = RandomStringUtils.randomNumeric(9);
    @SerializedName("EmployeeIDCustom1")
    @Builder.Default
    public String employeeIDCustom1 = RandomStringUtils.randomNumeric(9);
    @SerializedName("EmployeeIDCustom2")
    @Builder.Default
    public String employeeIDCustom2 = RandomStringUtils.randomNumeric(12);
    @SerializedName("EmployeeHireDate")
    @Builder.Default
    public String employeeHireDate = "2019-12-12";
    @SerializedName("EmployeeEndDate")
    @Builder.Default
    public String employeeEndDate = "2019-12-12";
    @SerializedName("EmployeeLastName")
    @Builder.Default
    public String employeeLastName = "EmpLName" + RandomStringUtils.randomAlphabetic(10);
    @SerializedName("EmployeeFirstName")
    @Builder.Default
    public String employeeFirstName = "EmpFName" + RandomStringUtils.randomAlphabetic(10);
    @SerializedName("EmployeeMiddleInitial")
    @Builder.Default
    public String employeeMiddleInitial = RandomStringUtils.randomAlphabetic(1);
    @SerializedName("Department")
    @Builder.Default
    public String department = "ABC";
    @SerializedName("EmployeeType")
    @Builder.Default
    public String employeeType = "";
    @SerializedName("Discipline")
    @Builder.Default
    public String discipline = "Value";
    @SerializedName("EmployeeAddress1")
    @Builder.Default
    public String employeeAddress1 = "1 Road";
    @SerializedName("EmployeeAddress2")
    @Builder.Default
    public String employeeAddress2 = "Apartment Two for Employee add";
    @SerializedName("EmployeeCity")
    @Builder.Default
    public String employeeCity = "New York";
    @SerializedName("EmployeeState")
    @Builder.Default
    public String employeeState = Constant.CLIENTSTATE[new Random().nextInt(Constant.CLIENTSTATE.length)];
    @SerializedName("EmployeeZipCode")
    @Builder.Default
    public String employeeZipCode = RandomStringUtils.randomNumeric(5);
    @SerializedName("EmployeePhone")
    @Builder.Default
    public String employeePhone = RandomStringUtils.randomNumeric(10);
    @SerializedName("EmployeeAltPhone")
    @Builder.Default
    public String employeeAltPhone = RandomStringUtils.randomNumeric(10);
    @SerializedName("EmployeeAltPhone2")
    @Builder.Default
    public String employeeAltPhone2 = RandomStringUtils.randomNumeric(10);
    @SerializedName("EmployeeAPI")
    public String employeeAPI;
    @SerializedName("PayRate")
    @Builder.Default
    public String payRate = "23.76";
    @SerializedName("EmployeeBirthDate")
    @Builder.Default
    public String employeeBirthDate = "2010-12-12";
    @SerializedName("EmployeeGender")
    @Builder.Default
    public String employeeGender = "M";
    @SerializedName("EmployeePrimaryLocation")
    @Builder.Default
    public String employeePrimaryLocation = "Location Queens";
}
