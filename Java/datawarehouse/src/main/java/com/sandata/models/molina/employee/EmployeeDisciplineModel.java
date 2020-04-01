package com.sandata.models.molina.employee;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class EmployeeDisciplineModel extends EmployeeGenericModel{
    @CsvHeader("ProviderID")
    @Column(value = "ProviderID", index = 0)
    private String providerID;

    @CsvHeader("EmployeeID")
    @Column(value = "EmployeeID", index = 1)
    private String employeeID;

    @CsvHeader("EmployeeDiscipline")
    @Column("EmployeeDiscipline")
    private String employeeDiscipline;

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

    public String getEmployeeDiscipline() {
        return employeeDiscipline;
    }

    public void setEmployeeDiscipline(String employeeDiscipline) {
        this.employeeDiscipline = employeeDiscipline;
    }

    @Override
    public String toString() {
        String toString = "EmployeeDisciplineModel{" +
                "providerID='" + providerID + '\'' +
                "employeeID='" + employeeID + '\'' +
                "employeeDiscipline='" + employeeDiscipline + '\'' +
                '}';
        return toString.replace("null", "");
    }

    public void verifyFormatField(String fieldValue, String regex, String errorMessage) {
        if(!fieldValue.equals(null))
            Assert.assertTrue(fieldValue.matches(regex), errorMessage);
    }

    public void verifyFormatFields() {
        String errorMessage1 = "Length of field %s is not correctly, value is %s";

        this.verifyFormatField(this.providerID, "^\\w{0,50}$", String.format(errorMessage1, "providerID", providerID));
        this.verifyFormatField(this.employeeID, "^\\w{0,9}$", String.format(errorMessage1, "employeeID", employeeID));
        this.verifyFormatField(this.employeeDiscipline, "^HHA|RN|LPN|PT$|^{0,6}$", String.format(errorMessage1, "employeeDiscipline", employeeDiscipline));
    }

    public static void verifyFormatFieldOfData(List<EmployeeDisciplineModel> employeeDisciplineList) {
        for (EmployeeDisciplineModel recordCsv: employeeDisciplineList){
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
        return true;
    }
}
