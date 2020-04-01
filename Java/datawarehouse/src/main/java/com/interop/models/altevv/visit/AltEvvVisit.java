package com.interop.models.altevv.visit;

import com.google.gson.annotations.SerializedName;
import com.interop.common.StateAccount;
import com.interop.models.ProviderIdentification;
import com.interop.models.altevv.AltBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class AltEvvVisit extends AltBaseModel {
    @SerializedName("VisitKey")
    String visitKey;
    @SerializedName("ProviderIdentification")
    @Builder.Default
    ProviderIdentification providerIdentification = ProviderIdentification.init();
    @SerializedName("VisitOtherID")
    @Builder.Default
    String visitOtherID = commons.generateRandomAlphaNumeric(50);
    @SerializedName("ClientOtherID")
    String clientOtherId;
    @SerializedName("SequenceID")
    @Builder.Default
    String sequenceID = commons.generateSequenceID();
    @SerializedName("EmployeeIdentifier")
    String employeeIdentifier;
    @SerializedName("EmployeeQualifier")
    @Builder.Default
    String employeeQualifier = StateAccount.loadStateAccount().getEmployeeQualifier();
    @SerializedName("ClientID")
    String clientID;
    @SerializedName("ClientIDQualifier")
    @Builder.Default
    String clientIDQualifier = StateAccount.loadStateAccount().getClientQualifier();
    @SerializedName("VisitCancelledIndicator")
    @Builder.Default
    String visitCancelledIndicator = "false";
    @SerializedName("PayerID")
    @Builder.Default
    String payerID = StateAccount.loadStateAccount().getDefaultPayerID();
    @SerializedName("PayerProgram")
    @Builder.Default
    String payerProgram = StateAccount.loadStateAccount().getDefaultPayerProgram();
    @SerializedName("ProcedureCode")
    @Builder.Default
    String procedureCode = StateAccount.loadStateAccount().getDefaultProcedureCode();
    @SerializedName("VisitTimeZone")
    @Builder.Default
    String visitTimeZone = "US/Eastern";
    @SerializedName("ScheduleStartTime")
    String scheduleStartTime;
    @SerializedName("ScheduleEndTime")
    String scheduleEndTime;
    @SerializedName("BillVisit")
    @Builder.Default
    String billVisit = "true";
    @SerializedName("HoursToBill")
    String hoursToBill;
    @SerializedName("HoursToPay")
    String hoursToPay;
    @SerializedName("Memo")
    String memo;
    @SerializedName("ClientVerifiedTimes")
    @Builder.Default
    String clientVerifiedTimes = "true";
    @SerializedName("ClientVerifiedTasks")
    @Builder.Default
    String clientVerifiedTasks = "true";
    @SerializedName("ClientVerifiedService")
    @Builder.Default
    String clientVerifiedService = "true";
    @SerializedName("ClientSignatureAvailable")
    @Builder.Default
    String clientSignatureAvailable = "true";
    @SerializedName("ClientVoiceRecording")
    @Builder.Default
    String clientVoiceRecording = "true";
    @SerializedName("Modifier1")
    String modifier1;
    @SerializedName("Modifier2")
    String modifier2;
    @SerializedName("Modifier3")
    String modifier3;
    @SerializedName("Modifier4")
    String modifier4;
    @SerializedName("Calls")
    @Singular("call")
    List<Call> calls;
    @SerializedName("VisitChanges")
    @Singular("visitChange")
    List<VisitChange> visitChanges;
    @SerializedName("VisitExceptionAcknowledgement")
    @Singular("visitException")
    List<VisitException> visitExceptionAcknowledgement;
    @SerializedName("Tasks")
    @Singular("task")
    List<Tasks> tasks;
    @SerializedName("ClientIDForVisitDownload")
    String clientIDForVisitDownload;
    @SerializedName("EmployeePINForVisitDownload")
    String employeePINForVisitDownload;
    @SerializedName("ContingencyPlan")
    @Builder.Default
    String contingencyPlan = "CP01";
    @SerializedName("Reschedule")
    @Builder.Default
    String reschedule = "No";
    @SerializedName("EmployeeOtherID")
    String employeeOtherID;
    @SerializedName("GroupCode")
    String groupCode;
    @SerializedName("AdjInDateTime")
    String adjInDateTime;
    @SerializedName("AdjOutDateTime")
    String adjOutDateTime;
}
