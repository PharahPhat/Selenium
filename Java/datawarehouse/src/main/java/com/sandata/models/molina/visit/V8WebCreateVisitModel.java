package com.sandata.models.molina.visit;

import com.sandata.utilities.DateTimeUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class V8WebCreateVisitModel {
    public String clientFirstName = "";
    public String clientLastName = "";
    public String clientMedicaidID = "";
    public String primarySearch = "False";
    public String isActiveClientHidden = "";
    public String categoryId = "";
    public String supervisorId = "";
    public String contractId = "";
    public String radio_action_group = "on";
    public String selectedClientId = "253915";
    public String selectedClientName = "";
    public String selectedClientKey = "46425876";
    public String employeeFirstName = "";
    public String employeeLastName = "";
    public String radio_action_group_employee="on";
    public String selectedEmployeeId = "000031625";
    public String selectedWorkerKey = "23438576";
    public String CallDate;
    public String CallTime = new SimpleDateFormat("hh:mm a").format(new Date());
    public String timeZone = "US%2FEastern";
    public String Service = "G0151_40";
    public String ClientServices = "";

    public V8WebCreateVisitModel() {
        try {
            CallDate = DateTimeUtil.addDays(new SimpleDateFormat("MM/dd/yyyy").format(new Date()), -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public String getPrimarySearch() {
        return primarySearch;
    }

    public void setPrimarySearch(String primarySearch) {
        this.primarySearch = primarySearch;
    }

    public String getIsActiveClientHidden() {
        return isActiveClientHidden;
    }

    public void setIsActiveClientHidden(String isActiveClientHidden) {
        this.isActiveClientHidden = isActiveClientHidden;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getRadio_action_group() {
        return radio_action_group;
    }

    public void setRadio_action_group(String radio_action_group) {
        this.radio_action_group = radio_action_group;
    }

    public String getSelectedClientId() {
        return selectedClientId;
    }

    public void setSelectedClientId(String selectedClientId) {
        this.selectedClientId = selectedClientId;
    }

    public String getSelectedClientName() {
        return selectedClientName;
    }

    public void setSelectedClientName(String selectedClientName) {
        this.selectedClientName = selectedClientName;
    }

    public String getSelectedClientKey() {
        return selectedClientKey;
    }

    public void setSelectedClientKey(String selectedClientKey) {
        this.selectedClientKey = selectedClientKey;
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

    public String getRadio_action_group_employee() {
        return radio_action_group_employee;
    }

    public void setRadio_action_group_employee(String radio_action_group_employee) {
        this.radio_action_group_employee = radio_action_group_employee;
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

    public String getCallDate() {
        return CallDate;
    }

    public void setCallDate(String callDate) {
        CallDate = callDate;
    }

    public String getCallTime() {
        return CallTime;
    }

    public void setCallTime(String callTime) {
        CallTime = callTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public String getClientServices() {
        return ClientServices;
    }

    public void setClientServices(String clientServices) {
        ClientServices = clientServices;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        try {
            sb.append("clientFirstName=").append(clientFirstName).append('&');
            sb.append("clientLastName=").append(clientLastName).append('&');
            sb.append("clientMedicaidID=").append(clientMedicaidID).append('&');
            sb.append("ClientServices=").append(ClientServices).append('&');
            sb.append("primarySearch=").append(primarySearch).append('&');
            sb.append("isActiveClientHidden=").append(isActiveClientHidden).append('&');
            sb.append("categoryId=").append(categoryId).append('&');
            sb.append("supervisorId=").append(supervisorId).append('&');
            sb.append("contractId=").append(contractId).append('&');
            sb.append("radio_action_group=").append(radio_action_group).append('&');
            sb.append("selectedClientId=").append(selectedClientId).append('&');
            sb.append("selectedClientName=").append(URLEncoder.encode(selectedClientName,"UTF-8")).append('&');
            sb.append("selectedClientKey=").append(selectedClientKey).append('&');
            sb.append("employeeFirstName=").append(URLEncoder.encode(employeeFirstName,"UTF-8")).append('&');
            sb.append("employeeLastName=").append(URLEncoder.encode(employeeLastName,"UTF-8")).append('&');
            sb.append("radio_action_group_employee=").append(radio_action_group_employee).append('&');
            sb.append("selectedEmployeeId=").append(selectedEmployeeId).append('&');
            sb.append("selectedWorkerKey=").append(selectedWorkerKey).append('&');
            sb.append("CallDate=").append(URLEncoder.encode(CallDate,"UTF-8")).append('&');
            sb.append("CallTime=").append(URLEncoder.encode(CallTime,"UTF-8")).append('&');
            sb.append("timeZone=").append(timeZone).append('&');
            sb.append("Service=").append(Service);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
