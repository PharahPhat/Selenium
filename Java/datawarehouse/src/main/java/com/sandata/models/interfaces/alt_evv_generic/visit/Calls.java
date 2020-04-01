package com.sandata.models.interfaces.alt_evv_generic.visit;

import com.sandata.models.GenericModel;

public class Calls extends GenericModel {
    private String CallExternalID;
    private String CallDateTime;
    private String CallAssignment;
    private String CallType;
    private String ProcedureCode;
    private String ClientIdentifierOnCall;
    private String MobileLogin;
    private String CallLatitude;
    private String CallLongitude;
    private String Location;
    private String TelephonyPIN;
    private String OriginatingPhoneNumber;
    private String ErrorCode;
    private String ErrorMessage;

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

    public String getCallLatitude() {
        return CallLatitude;
    }

    public void setCallLatitude(String callLatitude) {
        CallLatitude = callLatitude;
    }

    public String getCallLongitude() {
        return CallLongitude;
    }

    public void setCallLongitude(String callLongitude) {
        CallLongitude = callLongitude;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getTelephonyPIN() {
        return TelephonyPIN;
    }

    public void setTelephonyPIN(String telephonyPIN) {
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

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }
}
