package com.sandata.batch.models.api.authorization;

import com.google.gson.annotations.SerializedName;

public class AuthLimitModel {

    @SerializedName("PayerProgram")
    private String payerProgram;

    @SerializedName("AuthorizationServiceID")
    private String authorizationServiceID;

    @SerializedName("AuthorizationBillingType")
    private String authorizationBillingType;

    @SerializedName("AuthorizationLimit")
    private String authorizationLimit;

    @SerializedName("AuthorizationWeekStart")
    private String authorizationWeekStart;

    @SerializedName("AuthorizationLimitDayOfWeek")
    private String authorizationLimitDayOfWeek;

    @SerializedName("AuthorizationLimitStartTime")
    private String authorizationLimitStartTime;

    @SerializedName("AuthorizationLimitEndTime")
    private String authorizationLimitEndTime;

    @SerializedName("Modifier1")
    private String modifier1;

    @SerializedName("Modifier2")
    private String modifier2;

    @SerializedName("Modifier3")
    private String modifier3;

    @SerializedName("Modifier4")
    private String modifier4;

    @SerializedName("ServiceAuthorizedDate")
    private String serviceAuthorizedDate;

    public String getPayerProgram() {
        return payerProgram;
    }

    public void setPayerProgram(String payerProgram) {
        this.payerProgram = payerProgram;
    }

    public String getAuthorizationServiceID() {
        return authorizationServiceID;
    }

    public void setAuthorizationServiceID(String authorizationServiceID) {
        this.authorizationServiceID = authorizationServiceID;
    }

    public String getAuthorizationBillingType() {
        return authorizationBillingType;
    }

    public void setAuthorizationBillingType(String authorizationBillingType) {
        this.authorizationBillingType = authorizationBillingType;
    }

    public String getAuthorizationLimit() {
        return authorizationLimit;
    }

    public void setAuthorizationLimit(String authorizationLimit) {
        this.authorizationLimit = authorizationLimit;
    }

    public String getAuthorizationWeekStart() {
        return authorizationWeekStart;
    }

    public void setAuthorizationWeekStart(String authorizationWeekStart) {
        this.authorizationWeekStart = authorizationWeekStart;
    }

    public String getAuthorizationLimitDayOfWeek() {
        return authorizationLimitDayOfWeek;
    }

    public void setAuthorizationLimitDayOfWeek(String authorizationLimitDayOfWeek) {
        this.authorizationLimitDayOfWeek = authorizationLimitDayOfWeek;
    }

    public String getAuthorizationLimitStartTime() {
        return authorizationLimitStartTime;
    }

    public void setAuthorizationLimitStartTime(String authorizationLimitStartTime) {
        this.authorizationLimitStartTime = authorizationLimitStartTime;
    }

    public String getAuthorizationLimitEndTime() {
        return authorizationLimitEndTime;
    }

    public void setAuthorizationLimitEndTime(String authorizationLimitEndTime) {
        this.authorizationLimitEndTime = authorizationLimitEndTime;
    }

    public String getModifier1() {
        return modifier1;
    }

    public void setModifier1(String modifier1) {
        this.modifier1 = modifier1;
    }

    public String getModifier2() {
        return modifier2;
    }

    public void setModifier2(String modifier2) {
        this.modifier2 = modifier2;
    }

    public String getModifier3() {
        return modifier3;
    }

    public void setModifier3(String modifier3) {
        this.modifier3 = modifier3;
    }

    public String getModifier4() {
        return modifier4;
    }

    public void setModifier4(String modifier4) {
        this.modifier4 = modifier4;
    }

    public String getServiceAuthorizedDate() {
        return serviceAuthorizedDate;
    }

    public void setServiceAuthorizedDate(String serviceAuthorizedDate) {
        this.serviceAuthorizedDate = serviceAuthorizedDate;
    }

    public boolean equals(Object object2) {
        return payerProgram.equals(((AuthLimitModel) object2).payerProgram)
                && authorizationServiceID.equals(((AuthLimitModel) object2).authorizationServiceID)
                && authorizationLimit.equals(((AuthLimitModel) object2).authorizationLimit)
                && modifier1.equals(((AuthLimitModel) object2).modifier1)
                && modifier2.equals(((AuthLimitModel) object2).modifier2)
                && modifier3.equals(((AuthLimitModel) object2).modifier3)
                && modifier4.equals(((AuthLimitModel) object2).modifier4);
    }
}
