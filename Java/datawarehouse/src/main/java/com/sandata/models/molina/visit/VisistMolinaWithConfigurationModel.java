package com.sandata.models.molina.visit;

import com.sandata.entity.exportDWH.Call;

public class VisistMolinaWithConfigurationModel {

    public ProviderIdentification ProviderIdentification;
    public String VisitOtherID;
    public String SequenceID;
    public String EmployeeQualifier;
    public String EmployeeIdentifier;
    public String ClientIdentifier;
    public String ClientQualifier;
    public String VisitCancelledIndicator;
    public String PayerID;
    public String PayerProgram;
    public String ProcedureCode;
    public String VisitTimeZone;
    public String ScheduleStartTime;
    public String ScheduleEndTime;
    public String AdjInDateTime;
    public String AdjOutDateTime;
    public String BillVisit;
    public String HoursToBill;
    public String HoursToPay;
    public String Memo;
    public boolean ClientVerifiedTimes;
    public boolean ClientVerifiedTasks;
    public boolean ClientVerifiedService;
    public boolean ClientSignatureAvailable;
    public boolean ClientVoiceRecording;
    public Call[] Calls;
    public VisitExceptionAcknowledgement[] VisitExceptionAcknowledgements;
    public VisitChange[] VisitChanges;
    public String ErrorCode;
    public String ErrorMessage;

    public ProviderIdentification getProviderIdentification() {
        return ProviderIdentification;
    }

    public void setProviderIdentification(ProviderIdentification providerIdentification) {
        ProviderIdentification = providerIdentification;
    }

    public String getVisitOtherID() {
        return VisitOtherID;
    }

    public void setVisitOtherID(String visitOtherID) {
        VisitOtherID = visitOtherID;
    }

    public String getSequenceID() {
        return SequenceID;
    }

    public void setSequenceID(String sequenceID) {
        SequenceID = sequenceID;
    }

    public String getEmployeeQualifier() {
        return EmployeeQualifier;
    }

    public void setEmployeeQualifier(String employeeQualifier) {
        EmployeeQualifier = employeeQualifier;
    }

    public String getEmployeeIdentifier() {
        return EmployeeIdentifier;
    }

    public void setEmployeeIdentifier(String employeeIdentifier) {
        EmployeeIdentifier = employeeIdentifier;
    }

    public String getClientIdentifier() {
        return ClientIdentifier;
    }

    public void setClientIdentifier(String clientIdentifier) {
        ClientIdentifier = clientIdentifier;
    }

    public String getClientQualifier() {
        return ClientQualifier;
    }

    public void setClientQualifier(String clientQualifier) {
        ClientQualifier = clientQualifier;
    }

    public String getVisitCancelledIndicator() {
        return VisitCancelledIndicator;
    }

    public void setVisitCancelledIndicator(String visitCancelledIndicator) {
        VisitCancelledIndicator = visitCancelledIndicator;
    }

    public String getPayerID() {
        return PayerID;
    }

    public void setPayerID(String payerID) {
        PayerID = payerID;
    }

    public String getPayerProgram() {
        return PayerProgram;
    }

    public void setPayerProgram(String payerProgram) {
        PayerProgram = payerProgram;
    }

    public String getProcedureCode() {
        return ProcedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        ProcedureCode = procedureCode;
    }

    public String getVisitTimeZone() {
        return VisitTimeZone;
    }

    public void setVisitTimeZone(String visitTimeZone) {
        VisitTimeZone = visitTimeZone;
    }

    public String getScheduleStartTime() {
        return ScheduleStartTime;
    }

    public void setScheduleStartTime(String scheduleStartTime) {
        ScheduleStartTime = scheduleStartTime;
    }

    public String getScheduleEndTime() {
        return ScheduleEndTime;
    }

    public void setScheduleEndTime(String scheduleEndTime) {
        ScheduleEndTime = scheduleEndTime;
    }

    public String getAdjInDateTime() {
        return AdjInDateTime;
    }

    public void setAdjInDateTime(String adjInDateTime) {
        AdjInDateTime = adjInDateTime;
    }

    public String getAdjOutDateTime() {
        return AdjOutDateTime;
    }

    public void setAdjOutDateTime(String adjOutDateTime) {
        AdjOutDateTime = adjOutDateTime;
    }

    public String getBillVisit() {
        return BillVisit;
    }

    public void setBillVisit(String billVisit) {
        BillVisit = billVisit;
    }

    public String getHoursToBill() {
        return HoursToBill;
    }

    public void setHoursToBill(String hoursToBill) {
        HoursToBill = hoursToBill;
    }

    public String getHoursToPay() {
        return HoursToPay;
    }

    public void setHoursToPay(String hoursToPay) {
        HoursToPay = hoursToPay;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }

    public boolean isClientVerifiedTimes() {
        return ClientVerifiedTimes;
    }

    public void setClientVerifiedTimes(boolean clientVerifiedTimes) {
        ClientVerifiedTimes = clientVerifiedTimes;
    }

    public boolean isClientVerifiedTasks() {
        return ClientVerifiedTasks;
    }

    public void setClientVerifiedTasks(boolean clientVerifiedTasks) {
        ClientVerifiedTasks = clientVerifiedTasks;
    }

    public boolean isClientVerifiedService() {
        return ClientVerifiedService;
    }

    public void setClientVerifiedService(boolean clientVerifiedService) {
        ClientVerifiedService = clientVerifiedService;
    }

    public boolean isClientSignatureAvailable() {
        return ClientSignatureAvailable;
    }

    public void setClientSignatureAvailable(boolean clientSignatureAvailable) {
        ClientSignatureAvailable = clientSignatureAvailable;
    }

    public boolean isClientVoiceRecording() {
        return ClientVoiceRecording;
    }

    public void setClientVoiceRecording(boolean clientVoiceRecording) {
        ClientVoiceRecording = clientVoiceRecording;
    }

    public Call[] getCalls() {
        return Calls;
    }

    public void setCalls(Call[] calls) {
        Calls = calls;
    }

    public VisitExceptionAcknowledgement[] getVisitExceptionAcknowledgements() {
        return VisitExceptionAcknowledgements;
    }

    public void setVisitExceptionAcknowledgements(VisitExceptionAcknowledgement[] visitExceptionAcknowledgements) {
        VisitExceptionAcknowledgements = visitExceptionAcknowledgements;
    }

    public VisitChange[] getVisitChanges() {
        return VisitChanges;
    }

    public void setVisitChanges(VisitChange[] visitChanges) {
        VisitChanges = visitChanges;
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
