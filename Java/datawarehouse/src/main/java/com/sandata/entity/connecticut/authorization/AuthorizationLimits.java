package com.sandata.entity.connecticut.authorization;

public class AuthorizationLimits {
    public String AuthorizationLimit;
    public String AuthorizationWeekStart;
    public String AuthorizationLimitDayOfWeek;
    public String AuthorizationLimitStartTime;
    public String AuthorizationLimitEndTime;

    public String getAuthorizationLimit() {
        return AuthorizationLimit;
    }

    public void setAuthorizationLimit(String authorizationLimit) {
        AuthorizationLimit = authorizationLimit;
    }

    public String getAuthorizationWeekStart() {
        return AuthorizationWeekStart;
    }

    public void setAuthorizationWeekStart(String authorizationWeekStart) {
        AuthorizationWeekStart = authorizationWeekStart;
    }

    public String getAuthorizationLimitDayOfWeek() {
        return AuthorizationLimitDayOfWeek;
    }

    public void setAuthorizationLimitDayOfWeek(String authorizationLimitDayOfWeek) {
        AuthorizationLimitDayOfWeek = authorizationLimitDayOfWeek;
    }

    public String getAuthorizationLimitStartTime() {
        return AuthorizationLimitStartTime;
    }

    public void setAuthorizationLimitStartTime(String authorizationLimitStartTime) {
        AuthorizationLimitStartTime = authorizationLimitStartTime;
    }

    public String getAuthorizationLimitEndTime() {
        return AuthorizationLimitEndTime;
    }

    public void setAuthorizationLimitEndTime(String authorizationLimitEndTime) {
        AuthorizationLimitEndTime = authorizationLimitEndTime;
    }
}
