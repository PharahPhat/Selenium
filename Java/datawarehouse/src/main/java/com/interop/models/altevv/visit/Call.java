package com.interop.models.altevv.visit;

import com.google.gson.annotations.SerializedName;
import com.interop.models.AltBaseModelBuilder;
import com.interop.models.altevv.AltBaseModel;
import com.interop.common.StateAccount;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Call extends AltBaseModel {
    @SerializedName("CallExternalID")
    String callExternalID;
    @SerializedName("CallDateTime")
    String callDateTime;
    @SerializedName("CallAssignment")
    String callAssignment;
    @SerializedName("CallType")
    String callType;
    @SerializedName("ProcedureCode")
    @Builder.Default
    String procedureCode = StateAccount.loadStateAccount().getDefaultProcedureCode();
    @SerializedName("ClientIdentifierOnCall")
    String clientIdentifierOnCall;
    @SerializedName("MobileLogin")
    String mobileLogin;
    @SerializedName("CallLatitude")
    String callLatitude;
    @SerializedName("CallLongitude")
    String callLongitude;
    @SerializedName("Location")
    String location;
    @SerializedName("TelephonyPIN")
    String telephonyPIN;
    @SerializedName("OriginatingPhoneNumber")
    String originatingPhoneNumber;
    @SerializedName("GroupCode")
    String groupCode;

    public static class CallBuilder extends AltBaseModelBuilder {
        public CallBuilder setCallAssignment(CallAssignment callAssignment) {
            this.callAssignment = callAssignment.getValue();
            return this;
        }

        public CallBuilder setCallType(CallType inputCallType) {
            this.callType = inputCallType.getValue();
            return this;
        }

        public CallBuilder setCallDateTimeByPastMinutes(int minutes) {
            this.callDateTime = commons.getPastTime(minutes);
            return this;
        }

        public CallBuilder enterDefaultCallInfo(int pastMinutes) {
            this.callDateTime = commons.getPastTime(pastMinutes);
            this.callExternalID(commons.generateRandomNumberOfFixLength(8));
            this.callAssignment("Time In");
            this.callType("Other");
            this.clientIdentifierOnCall("98733222");
            this.location("123");
            this.mobileLogin("98733222");
            this.callLatitude("40.34455");
            this.callLongitude("-21.99383");
            this.originatingPhoneNumber("2125551212");
            this.telephonyPIN("9989999");
            return this;
        }

        public CallBuilder setCallDateTime(String callDate, String callTime) {
            this.callDateTime = convertVisitDateTimeToUTCString(callDate, callTime);
            return this;
        }

        public CallBuilder setCallDateTime(String callDateTime) {
            this.callDateTime = callDateTime;
            return this;
        }

        private String convertVisitDateTimeToUTCString(String visitDate, String visitTime) {
            DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
            LocalDateTime localDateTime = LocalDateTime.parse(visitDate + " " + visitTime, ofPattern);
            ZonedDateTime dateTime = ZonedDateTime.of(localDateTime, ZoneId.of("US/Eastern"));

            return dateTime.withZoneSameInstant(ZoneId.of("UTC"))
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));

        }
    }
}
