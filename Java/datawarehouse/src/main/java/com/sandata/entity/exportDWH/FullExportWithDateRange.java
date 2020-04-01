package com.sandata.entity.exportDWH;

public class FullExportWithDateRange {
    private String startDate;
    private String endDate;
    private String account;
    private String groupKey;
    private String contract;
    private String spv;
    private String username;
    private int exportMode;

    public FullExportWithDateRange() {
        account = "";
        contract = "_ALL";
        spv = "_ALL";
        username = "";
        exportMode = 1;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getSpv() {
        return spv;
    }

    public void setSpv(String spv) {
        this.spv = spv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getExportMode() {
        return exportMode;
    }

    public void setExportMode(int exportMode) {
        this.exportMode = exportMode;
    }
}
