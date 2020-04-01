package com.interop.data.claim;

import com.sandata.core.annotation.CsvHeader;

public class ClaimDataRecord {
    private String clientMedicaidId;

    private String employeeCustomId;
    @CsvHeader("Service Start Date")
    private String serviceStartDate;
    @CsvHeader("Service End Date")
    private String serviceEndDate;
    @CsvHeader("In Time")
    private String inTime;
    @CsvHeader("Out Time")
    private String outTime;
    @CsvHeader("Proc Code")
    private String procedureCode;
    @CsvHeader("Payer")
    private String payer;
    @CsvHeader("Program")
    private String program;
    @CsvHeader("UnitsRule")
    private String unitsRule;
    @CsvHeader("Matching Rule")
    private String matchingRule;
    @CsvHeader("Duration")
    private String duration;
    private String units;
    @CsvHeader("SuceededCount")
    private String succeedCount;

    @CsvHeader("Client FirstName")
    private String clientFirstName;

    @CsvHeader("Employee FirstName")
    private String employeeFirstName;

    private String testDescription;

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }
    public String getClientMedicaidId() {
        return clientMedicaidId;
    }

    public void setClientMedicaidId(String clientMedicaidId) {
        this.clientMedicaidId = clientMedicaidId;
    }

    public String getEmployeeCustomId() {
        return employeeCustomId;
    }

    public void setEmployeeCustomId(String employeeCustomId) {
        this.employeeCustomId = employeeCustomId;
    }

    public String getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(String serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public String getServiceEndDate() {
        return serviceEndDate;
    }

    public void setServiceEndDate(String serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public String getUnitsRule() {
        return unitsRule;
    }

    public void setUnitsRule(String unitsRule) {
        this.unitsRule = unitsRule;
    }

    public String getMatchingRule() {
        return matchingRule;
    }

    public void setMatchingRule(String matchingRule) {
        this.matchingRule = matchingRule;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getSucceedCount() {
        return succeedCount;
    }

    public void setSucceedCount(String succeedCount) {
        this.succeedCount = succeedCount;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }
}
