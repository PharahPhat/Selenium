package com.sandata.models.vm.visit.schedule;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class V8WebCreateSchedule {
    public String categoryId = "";
    public String clientFirstName = "";
    public String clientLastName = "";
    public String clientMedicaidID = "";
    public String contractId = "";
    public String employeeFirstName = "";
    public String employeeLastName = "";
    public String isActiveClientHidden = "";
    public String primarySearch = "False";
    public String radio_action_group = "on";
    public String radio_action_group_employee = "on";
    public com.sandata.models.molina.visit.Schedule Schedule;
    public String selectedClientId = "";
    public String selectedClientKey = "";
    public String selectedClientName = "";
    public String selectedEmployeeId = "";
    public String selectedWorkerKey = "";
    public String supervisorId = "";

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientMedicaidID() {
        return clientMedicaidID;
    }

    public void setClientMedicaidID(String clientMedicaidID) {
        this.clientMedicaidID = clientMedicaidID;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getIsActiveClientHidden() {
        return isActiveClientHidden;
    }

    public void setIsActiveClientHidden(String isActiveClientHidden) {
        this.isActiveClientHidden = isActiveClientHidden;
    }

    public String getPrimarySearch() {
        return primarySearch;
    }

    public void setPrimarySearch(String primarySearch) {
        this.primarySearch = primarySearch;
    }

    public String getRadio_action_group() {
        return radio_action_group;
    }

    public void setRadio_action_group(String radio_action_group) {
        this.radio_action_group = radio_action_group;
    }

    public String getRadio_action_group_employee() {
        return radio_action_group_employee;
    }

    public void setRadio_action_group_employee(String radio_action_group_employee) {
        this.radio_action_group_employee = radio_action_group_employee;
    }

    public com.sandata.models.molina.visit.Schedule getSchedule() {
        return Schedule;
    }

    public void setSchedule(com.sandata.models.molina.visit.Schedule schedule) {
        Schedule = schedule;
    }

    public String getSelectedClientId() {
        return selectedClientId;
    }

    public void setSelectedClientId(String selectedClientId) {
        this.selectedClientId = selectedClientId;
    }

    public String getSelectedClientKey() {
        return selectedClientKey;
    }

    public void setSelectedClientKey(String selectedClientKey) {
        this.selectedClientKey = selectedClientKey;
    }

    public String getSelectedClientName() {
        return selectedClientName;
    }

    public void setSelectedClientName(String selectedClientName) {
        this.selectedClientName = selectedClientName;
    }

    public String getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(String selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }

    public String getSelectedWorkerKey() {
        return selectedWorkerKey;
    }

    public void setSelectedWorkerKey(String selectedWorkerKey) {
        this.selectedWorkerKey = selectedWorkerKey;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        try {
            sb.append("clientFirstName=").append(clientFirstName).append('&');
            sb.append("clientLastName=").append(clientLastName).append('&');
            sb.append("clientMedicaidID=").append(clientMedicaidID).append('&');
            sb.append("primarySearch=").append(primarySearch).append('&');
            sb.append("isActiveClientHidden=").append(isActiveClientHidden).append('&');
            sb.append("categoryId=").append(categoryId).append('&');
            sb.append("supervisorId=").append(supervisorId).append('&');
            sb.append("contractId=").append(contractId).append('&');
            sb.append("radio_action_group=").append(radio_action_group).append('&');
            sb.append("selectedClientId=").append(selectedClientId).append('&');
            sb.append("selectedClientName=").append(URLEncoder.encode(selectedClientName,"UTF-8")).append('&');
            sb.append("selectedClientKey=").append(selectedClientKey).append('&');
            sb.append("employeeFirstName=").append(employeeFirstName).append('&');
            sb.append("employeeLastName=").append(employeeLastName).append('&');
            sb.append("radio_action_group_employee=").append(radio_action_group_employee).append('&');
            sb.append("selectedEmployeeId=").append(selectedEmployeeId).append('&');
            sb.append("selectedWorkerKey=").append(selectedWorkerKey).append('&');
            sb.append("Schedule.SchDate=").append(URLEncoder.encode(Schedule.SchDate,"UTF-8")).append('&');
            sb.append("Schedule.SchStart=").append(URLEncoder.encode(Schedule.SchStart,"UTF-8")).append('&');
            sb.append("Schedule.SschEnd=").append(URLEncoder.encode(Schedule.SschEnd,"UTF-8")).append('&');
            sb.append("Schedule.Service=").append(Schedule.Service).append('&');
            sb.append("Schedule.ArNumber=").append(Schedule.ArNumber).append('&');
            sb.append("Schedule.Contract=").append(Schedule.Contract).append('&');
            sb.append("Schedule.Memo=").append(Schedule.Memo).append('&');
            sb.append("Schedule.PayRate=").append(Schedule.PayRate).append('&');
            sb.append("Schedule.Branch=").append(Schedule.Branch).append('&');
            sb.append("Schedule.BillRate=").append(Schedule.BillRate).append('&');
            sb.append("Schedule.HcpcsCode=").append(Schedule.HcpcsCode).append('&');
            sb.append("Schedule.Discipline=").append(Schedule.Discipline).append('&');
            sb.append("Schedule.IsDutyFree=").append(Schedule.IsDutyFree).append('&');
            sb.append("Schedule.IsLiveIn=").append(Schedule.IsLiveIn).append('&');
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
