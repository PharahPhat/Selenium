package com.sandata.models.molina.visit;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class VisitCallsModel extends VisitGenericModel{
    @CsvHeader("VisitKey")
    @Column(value = "VISITKEY", index = 0)
    private String visitKey;

    @CsvHeader("CallKey")
    @Column(value = "CALLKEY", index = 1)
    private String callKey;

    @CsvHeader("CallDateTime")
    @Column(value = "CALLDATETIME", index = 2)
    private String callDateTime;

    @CsvHeader("CallAssignment")
    @Column(value = "CALLASSIGNMENT", index = 3)
    private String callAssignment;

    @CsvHeader("CallType")
    @Column(value = "CALLTYPE", index = 4)
    private String callType;

    @CsvHeader("ProcedureCode")
    @Column("PROCEDURECODE")
    private String procedureCode;

    @CsvHeader("ClientIdentifierOnCall")
    @Column("CLIENTIDENTIFIERONCALL")
    private String clientIdentifierOnCall;

    @CsvHeader("ServiceEnteredOnCall")
    @Column("SERVICEENTEREDONCALL")
    private String serviceEnteredOnCall;

    @CsvHeader("MobileLogin")
    @Column("MOBILELOGIN")
    private String mobileLogin;

    @CsvHeader("VisitLocation")
    @Column("VISITLOCATION")
    private String visitLocation;

    @CsvHeader("VisitNotes")
    @Column("VISITNOTES")
    private String visitNotes;

    @CsvHeader("CallLatitude")
    @Column("CALLLATITUDE")
    private String callLatitude;

    @CsvHeader("CallLongitude")
    @Column("CALLLONGITUDE")
    private String callLongitude;

    @CsvHeader("TelephonyPIN")
    @Column("TELEPHONYPIN")
    private String telephonyPIN;

    @CsvHeader("CallTimeZone")
    @Column("CALLTIMEZONE")
    private String callTimeZone;

    @CsvHeader("OriginatingPhoneNumber")
    @Column("ORIGINATINGPHONENUMBER")
    private String originatingPhoneNumber;

    @CsvHeader("RecordUpdatedBy")
    @Column("RECORDUPDATEDBY")
    private String recordUpdatedBy;

    @CsvHeader("RecordUpdateDateTime")
    @Column("RECORDUPDATEDATETIME")
    private String recordUpdateDateTime;

    public String getVisitKey() {
        return visitKey;
    }

    public void setVisitKey(String visitKey) {
        this.visitKey = visitKey;
    }

    public String getCallKey() {
        return callKey;
    }

    public void setCallKey(String callKey) {
        this.callKey = callKey;
    }

    public String getCallDateTime() {
        return callDateTime;
    }

    public void setCallDateTime(String callDateTime) {
        this.callDateTime = callDateTime;
    }

    public String getCallAssignment() {
        return callAssignment;
    }

    public void setCallAssignment(String callAssignment) {
        this.callAssignment = callAssignment;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public String getClientIdentifierOnCall() {
        return clientIdentifierOnCall;
    }

    public void setClientIdentifierOnCall(String clientIdentifierOnCall) {
        this.clientIdentifierOnCall = clientIdentifierOnCall;
    }

    public String getServiceEnteredOnCall() {
        return serviceEnteredOnCall;
    }

    public void setServiceEnteredOnCall(String serviceEnteredOnCall) {
        this.serviceEnteredOnCall = serviceEnteredOnCall;
    }

    public String getMobileLogin() {
        return mobileLogin;
    }

    public void setMobileLogin(String mobileLogin) {
        this.mobileLogin = mobileLogin;
    }

    public String getVisitLocation() {
        return visitLocation;
    }

    public void setVisitLocation(String visitLocation) {
        this.visitLocation = visitLocation;
    }

    public String getVisitNotes() {
        return visitNotes;
    }

    public void setVisitNotes(String visitNotes) {
        this.visitNotes = visitNotes;
    }

    public String getCallLatitude() {
        return callLatitude;
    }

    public void setCallLatitude(String callLatitude) {
        this.callLatitude = callLatitude;
    }

    public String getCallLongitude() {
        return callLongitude;
    }

    public void setCallLongitude(String callLongitude) {
        this.callLongitude = callLongitude;
    }

    public String getTelephonyPIN() {
        return telephonyPIN;
    }

    public void setTelephonyPIN(String telephonyPIN) {
        this.telephonyPIN = telephonyPIN;
    }

    public String getCallTimeZone() {
        return callTimeZone;
    }

    public void setCallTimeZone(String callTimeZone) {
        this.callTimeZone = callTimeZone;
    }

    public String getOriginatingPhoneNumber() {
        return originatingPhoneNumber;
    }

    public void setOriginatingPhoneNumber(String originatingPhoneNumber) {
        this.originatingPhoneNumber = originatingPhoneNumber;
    }

    public String getRecordUpdatedBy() {
        return recordUpdatedBy;
    }

    public void setRecordUpdatedBy(String recordUpdatedBy) {
        this.recordUpdatedBy = recordUpdatedBy;
    }

    public String getRecordUpdateDateTime() {
        return recordUpdateDateTime;
    }

    public void setRecordUpdateDateTime(String recordUpdateDateTime) {
        this.recordUpdateDateTime = recordUpdateDateTime;
    }

    @Override
    public String toString() {
        String toString = "VisitCallsModel{" +
                "visitKey='" + visitKey + '\'' +
                "callKey='" + callKey + '\'' +
                "callDateTime='" + callDateTime + '\'' +
                "callAssignment='" + callAssignment + '\'' +
                "callType='" + callType + '\'' +
                "procedureCode='" + procedureCode + '\'' +
                "clientIdentifierOnCall='" + clientIdentifierOnCall + '\'' +
                "serviceEnteredOnCall='" + serviceEnteredOnCall + '\'' +
                "mobileLogin='" + mobileLogin + '\'' +
                "visitLocation='" + visitLocation + '\'' +
                "visitNotes='" + visitNotes + '\'' +
                "callLatitude='" + callLatitude + '\'' +
                "callLongitude='" + callLongitude + '\'' +
                "telephonyPIN='" + telephonyPIN + '\'' +
                "callTimeZone='" + callTimeZone + '\'' +
                "originatingPhoneNumber='" + originatingPhoneNumber + '\'' +
                "recordUpdatedBy='" + recordUpdatedBy + '\'' +
                "recordUpdateDateTime='" + recordUpdateDateTime + '\'' +
                '}';
        return toString.replace("null", "");
    }

    public boolean equals(String fileValue, String dbValue) {
        return StringUtils.equalsIgnoreCase(fileValue, dbValue);
    }



    @Override
    public boolean verifyFieldValue(Object obj) {
        if (Objects.isNull(obj)) return false;
        VisitCallsModel modelObject = (VisitCallsModel) obj;


        return Arrays.asList("Call In", "Call Out", "Interim").indexOf(this.callAssignment) >= 0
                && equals(modelObject.visitKey, this.visitKey)
                && equals(modelObject.callKey, this.callKey);
    }

    private boolean verifyFormatField(String fieldValue, String regex) {
        boolean match = Objects.nonNull(fieldValue) && fieldValue.matches(regex);
        if (!match) {
            System.out.println("value " + fieldValue + " does not match " + regex);
        }
        return match;
    }

    public boolean verifyFormatFields() {
        return (this.verifyFormatField(this.visitKey, "^\\d{0,16}$")
                && this.verifyFormatField(this.callKey, "^\\d{0,16}$")
                && this.verifyFormatField(this.callDateTime, "^\\d{4}-\\d{2}-\\d{2}(.)\\d{2}:\\d{2}:\\d{2}(.?)$")
                && this.verifyFormatField(this.callAssignment, "^.{0,10}$")
                && this.verifyFormatField(this.callType, "^.{0,20}$")
                && this.verifyFormatField(this.procedureCode, "^\\w{0,15}$")
                && this.verifyFormatField(this.clientIdentifierOnCall, "^\\w{0,10}$")
                && this.verifyFormatField(this.mobileLogin, "^.{0,64}$")
                && this.verifyFormatField(this.callLatitude, "^.\\d{1,3}.\\d{1,15}$")
                && this.verifyFormatField(this.callLongitude, "^.\\d{1,3}.\\d{1,15}$")
                && this.verifyFormatField(this.telephonyPIN, "^\\d+$")
                && this.verifyFormatField(this.originatingPhoneNumber, "^\\w{0,10}$")
                && this.verifyFormatField(this.recordUpdatedBy, "^.{0,100}$")
                && ("".equals(this.getRecordUpdateDateTime())
                || this.verifyFormatField(this.recordUpdateDateTime, "^\\d{4}-\\d{2}-\\d{2}(.)\\d{2}:\\d{2}:\\d{2}(.?)$")));
    }

    public static boolean verifyDataInDbAndCsvCorrectly(List<VisitCallsModel> modelList){
        for (VisitCallsModel model: modelList){
            if(!model.verifyFormatFields()) {
                System.out.println("model.toString() = " + model.toString());
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        if (Objects.isNull(visitKey)) {
            return false;
        }
        if (Objects.isNull(callKey)) {
            return false;
        }
        if (Objects.isNull(callDateTime)) {
            return false;
        }
        if (Objects.isNull(callAssignment)) {
            return false;
        }
        if (Objects.isNull(callType)) {
            return false;
        }
        return true;
    }
}
