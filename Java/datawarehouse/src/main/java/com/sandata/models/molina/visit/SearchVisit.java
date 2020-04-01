package com.sandata.models.molina.visit;

import java.util.HashMap;
import java.util.Map;

public class SearchVisit {

    public String getSearchPhrase() {
        return searchPhrase;
    }

    public void setSearchPhrase(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    public String getAutoSearch() {
        return autoSearch;
    }

    public void setAutoSearch(String autoSearch) {
        this.autoSearch = autoSearch;
    }

    public String getVisitsFromDate() {
        return visitsFromDate;
    }

    public void setVisitsFromDate(String visitsFromDate) {
        this.visitsFromDate = visitsFromDate;
    }

    public String getVisitsToDate() {
        return visitsToDate;
    }

    public void setVisitsToDate(String visitsToDate) {
        this.visitsToDate = visitsToDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getFilterByStatus() {
        return filterByStatus;
    }

    public void setFilterByStatus(String filterByStatus) {
        this.filterByStatus = filterByStatus;
    }

    public String getMedicaidId() {
        return medicaidId;
    }

    public void setMedicaidId(String medicaidId) {
        this.medicaidId = medicaidId;
    }

    public String getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> toMap() {
        Map<String, String> formData = new HashMap<>();
        formData.put("current", "1");
        formData.put("rowCount", "50");
        formData.put("searchPhrase", searchPhrase);
        formData.put("columns[]", "ClientName");
        formData.put("columns[]", "EmployeeName");
        formData.put("columns[]", "Service");
        formData.put("columns[]", "VisitDateString");
        formData.put("columns[]", "CallStartTime");
        formData.put("columns[]", "CallEndTime");
        formData.put("columns[]", "ActHours");
        formData.put("columns[]", "AdjIn");
        formData.put("columns[]", "AdjOut");
        formData.put("columns[]", "AdjustedHours");
        formData.put("columns[]", "BillHours");
        formData.put("columns[]", "VisitStatus");
        formData.put("columns[]", "DoNotBill");
        formData.put("columns[]", "Approved");
        formData.put("columns[]", "Actions");

        formData.put("AutoSearch", "False");
        formData.put("VisitsFromDate", visitsFromDate);
        formData.put("VisitsToDate", visitsToDate);
        formData.put("client", client);
        formData.put("employee", employee);
        formData.put("category", category);
        formData.put("contract", contract);
        formData.put("filterByStatus", filterByStatus);
        formData.put("medicaidId", medicaidId);
        formData.put("filterBy", filterBy);
        formData.put("visitType", visitType);
        formData.put("supervisor", supervisor);
        formData.put("department", department);
        return formData;
    }

    @Override
    public String toString() {
        String body = "current=1&rowCount=50" +
                "&searchPhrase=" +
                "&columns%5B%5D=ClientName" +
                "&columns%5B%5D=EmployeeName" +
                "&columns%5B%5D=Service"+
                "&columns%5B%5D=VisitDateString" +
                "&columns%5B%5D=CallStartTime" +
                "&columns%5B%5D=CallEndTime" +
                "&columns%5B%5D=ActHours" +
                "&columns%5B%5D=AdjIn" +
                "&columns%5B%5D=AdjOut" +
                "&columns%5B%5D=AdjustedHours" +
                "&columns%5B%5D=BillHours" +
                "&columns%5B%5D=VisitStatus" +
                "&columns%5B%5D=DoNotBill" +
                "&columns%5B%5D=Approved" +
                "&columns%5B%5D=Actions" +
                "&AutoSearch=False" +
                "&VisitsFromDate=" + visitsFromDate +
                "&VisitsToDate=" + visitsToDate+
                "&client=" + getClient() +
                "&employee=" + getEmployee() +
                "&category=" +
                "&contract=" +
                "&filterByStatus=" +
                "&medicaidId=" + getMedicaidId() +
                "&filterBy=0" +
                "&visitType=" +
                "&supervisor=" +
                "&department=" +
                "&programs=" +
                "&services=" +
                "&groupVisitCodeField=" +
                "&groupVisitCodeDropdown="
                ;
        return body;
    }

    public String searchPhrase;
    public String autoSearch;
    public String visitsFromDate;
    public String visitsToDate;
    public String client;
    public String employee = "";
    public String category;
    public String contract;
    public String filterByStatus;
    public String medicaidId = "";
    public String filterBy;
    public String visitType;
    public String supervisor;
    public String department;
}
