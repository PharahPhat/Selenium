package com.sandata.entity.exportDWH.OhioExportConfigurationV1;

public class AccountInterfaceParamInformation {
    public String exportMode;
    public String startDate;
    public String endDate;
    public String backDays;
    public String dayRange;
    public String groupKey;
    public String contract;
    public String username;
    public String spv;
    public String account;

    public String getExportMode() {
        return exportMode;
    }

    public void setExportMode(String exportMode) {
        this.exportMode = exportMode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBackDays() {
        return backDays;
    }

    public void setBackDays(String backDays) {
        this.backDays = backDays;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSpv() {
        return spv;
    }

    public void setSpv(String spv) {
        this.spv = spv;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
