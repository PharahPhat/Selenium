package com.sandata.entity.exportDWH;

public class Call {
    public String CallExternalID;
    public String CallDateTime;
    public String CallAssignment;
    public String CallType;
    public String ProcedureCode;
    public String ClientIdentifierOnCall;
    public String MobileLogin;
    public double CallLatitude;
    public double CallLongitude;
    public String Location;
    public int TelephonyPIN;
    public String OriginatingPhoneNumber;
    public String ErrorCode;
    public String ErrorMessage;

    public String getCallExternalID() {
        return CallExternalID;
    }

    public void setCallExternalID(String callExternalID) {
        CallExternalID = callExternalID;
    }

    public String getCallDateTime() {
        return CallDateTime;
    }

    public void setCallDateTime(String callDateTime) {
        CallDateTime = callDateTime;
    }

    public String getCallAssignment() {
        return CallAssignment;
    }

    public void setCallAssignment(String callAssignment) {
        CallAssignment = callAssignment;
    }

    public String getCallType() {
        return CallType;
    }

    public void setCallType(String callType) {
        CallType = callType;
    }

    public String getProcedureCode() {
        return ProcedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        ProcedureCode = procedureCode;
    }

    public String getClientIdentifierOnCall() {
        return ClientIdentifierOnCall;
    }

    public void setClientIdentifierOnCall(String clientIdentifierOnCall) {
        ClientIdentifierOnCall = clientIdentifierOnCall;
    }

    public String getMobileLogin() {
        return MobileLogin;
    }

    public void setMobileLogin(String mobileLogin) {
        MobileLogin = mobileLogin;
    }

    public double getCallLatitude() {
        return CallLatitude;
    }

    public void setCallLatitude(double callLatitude) {
        CallLatitude = callLatitude;
    }

    public double getCallLongitude() {
        return CallLongitude;
    }

    public void setCallLongitude(double callLongitude) {
        CallLongitude = callLongitude;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getTelephonyPIN() {
        return TelephonyPIN;
    }

    public void setTelephonyPIN(int telephonyPIN) {
        TelephonyPIN = telephonyPIN;
    }

    public String getOriginatingPhoneNumber() {
        return OriginatingPhoneNumber;
    }

    public void setOriginatingPhoneNumber(String originatingPhoneNumber) {
        OriginatingPhoneNumber = originatingPhoneNumber;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }
}
