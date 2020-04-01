package com.sandata.entity.ohio.visit;

public class Call {
    public String CallExternalID;
    public String CallDateTime;
    public String CallAssignment;
    public String CallType;
    public String GroupVisitCode;
    public String ProcedureCode;
    public String PatientIdentifierOnCall;
    public String MobileLogin;
    public String CallLatitude;
    public String CallLongitude;
    public int TelephonyPIN;
    public String OriginatingPhoneNumber;

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

    public String getGroupVisitCode() {
        return GroupVisitCode;
    }

    public void setGroupVisitCode(String groupVisitCode) {
        GroupVisitCode = groupVisitCode;
    }

    public String getProcedureCode() {
        return ProcedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        ProcedureCode = procedureCode;
    }

    public String getPatientIdentifierOnCall() {
        return PatientIdentifierOnCall;
    }

    public void setPatientIdentifierOnCall(String patientIdentifierOnCall) {
        PatientIdentifierOnCall = patientIdentifierOnCall;
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
}
