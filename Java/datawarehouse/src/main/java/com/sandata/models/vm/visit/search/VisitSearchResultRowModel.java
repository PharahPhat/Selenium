package com.sandata.models.vm.visit.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class VisitSearchResultRowModel {
    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getClientKey() {
        return ClientKey;
    }

    public void setClientKey(String clientKey) {
        ClientKey = clientKey;
    }

    public String getVisitKey() {
        return VisitKey;
    }

    public void setVisitKey(String visitKey) {
        VisitKey = visitKey;
    }

    public String getWorkerKey() {
        return WorkerKey;
    }

    public void setWorkerKey(String workerKey) {
        WorkerKey = workerKey;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }

    public String getUpdateId() {
        return UpdateId;
    }

    public void setUpdateId(String updateId) {
        UpdateId = updateId;
    }

    public String ClientName;
    public String EmployeeName;
    public String ClientKey;
    public String VisitKey;
    public String WorkerKey;
    public String Memo;
    public String UpdateId;
}
