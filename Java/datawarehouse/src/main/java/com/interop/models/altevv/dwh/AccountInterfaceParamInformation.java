package com.interop.models.altevv.dwh;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.altevv.AltBaseModel;

import lombok.Builder;

@Builder

public class AccountInterfaceParamInformation extends AltBaseModel {

    @SerializedName("StartDate")
    public String startDate;

    @SerializedName("StartDate")
    public String endDate;

    @SerializedName("ExportMode")
    @Builder.Default
    public String exportMode = "3";

    @SerializedName("BackDays")
    @Builder.Default
    public String backDays = null;

    @SerializedName("GroupKey")
    public String groupKey;

    @SerializedName("Account")
    public String account;

    @SerializedName("ProviderMode")
    @Builder.Default
    public String providerMode = "V";

    @SerializedName("PayerMode")
    @Builder.Default
    public String payerMode = "V";

    @SerializedName("ClientMode")
    @Builder.Default
    public String clientMode = "V";

    @SerializedName("ScheduleMode")
    @Builder.Default
    public String scheduleMode = "V";

    @SerializedName("EmployeeMode")
    @Builder.Default
    public String employeeMode = "V";

    @SerializedName("Contract")
    @Builder.Default
    public String contract = "_ALL";

    @SerializedName("Username")
    @Builder.Default
    public String username = "";

    @SerializedName("Username")
    @Builder.Default
    public String spv = "_ALL";

    public static AccountInterfaceParamInformation init() {
        StateAccount stateAccount = StateAccount.loadStateDwhAccount();
        return AccountInterfaceParamInformation.builder()
                .startDate(stateAccount.getStartDate())
                .endDate(stateAccount.getEndDate())
                .exportMode(stateAccount.getExportMode())
                .backDays(stateAccount.getBackDays())
                .groupKey(stateAccount.getGroupKey())
                .account(stateAccount.getAccount())
                .providerMode(stateAccount.getProviderMode())
                .payerMode(stateAccount.getPayerMode())
                .clientMode(stateAccount.getClientMode())
                .scheduleMode(stateAccount.getScheduleMode())
                .employeeMode(stateAccount.getEmployeeMode())
                .build();
    }

}
