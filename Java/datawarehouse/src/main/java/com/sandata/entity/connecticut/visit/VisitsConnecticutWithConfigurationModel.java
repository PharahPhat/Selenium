package com.sandata.entity.connecticut.visit;

import java.util.List;
import com.sandata.entity.exportDWH.ProviderIdentification;

public class VisitsConnecticutWithConfigurationModel {
    public ProviderIdentification ProviderIdentification;
    public String VisitOtherID;
    public String SequenceID;
    public String EmployeeIdentifier;
    public String EmployeeQualifier;
    public String ClientID;
    public String ClientIDQualifier;
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
    public String ClientVerifiedTimes;
    public String ClientVerifiedTasks;
    public String ClientVerifiedService;
    public String ClientSignatureAvailable;
    public String ClientVoiceRecording;
    public List<Calls> Calls;
    public List<VisitExceptionAcknowledgement> VisitExceptionAcknowledgement;
    public List<VisitChanges> VisitChanges;
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

    public String getEmployeeIdentifier() {
        return EmployeeIdentifier;
    }

    public void setEmployeeIdentifier(String employeeIdentifier) {
        EmployeeIdentifier = employeeIdentifier;
    }

    public String getEmployeeQualifier() {
        return EmployeeQualifier;
    }

    public void setEmployeeQualifier(String employeeQualifier) {
        EmployeeQualifier = employeeQualifier;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getClientIDQualifier() {
        return ClientIDQualifier;
    }

    public void setClientIDQualifier(String clientIDQualifier) {
        ClientIDQualifier = clientIDQualifier;
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

    public String getClientVerifiedTimes() {
        return ClientVerifiedTimes;
    }

    public void setClientVerifiedTimes(String clientVerifiedTimes) {
        ClientVerifiedTimes = clientVerifiedTimes;
    }

    public String getClientVerifiedTasks() {
        return ClientVerifiedTasks;
    }

    public void setClientVerifiedTasks(String clientVerifiedTasks) {
        ClientVerifiedTasks = clientVerifiedTasks;
    }

    public String getClientVerifiedService() {
        return ClientVerifiedService;
    }

    public void setClientVerifiedService(String clientVerifiedService) {
        ClientVerifiedService = clientVerifiedService;
    }

    public String getClientSignatureAvailable() {
        return ClientSignatureAvailable;
    }

    public void setClientSignatureAvailable(String clientSignatureAvailable) {
        ClientSignatureAvailable = clientSignatureAvailable;
    }

    public String getClientVoiceRecording() {
        return ClientVoiceRecording;
    }

    public void setClientVoiceRecording(String clientVoiceRecording) {
        ClientVoiceRecording = clientVoiceRecording;
    }

    public List<com.sandata.entity.connecticut.visit.Calls> getCalls() {
        return Calls;
    }

    public void setCalls(List<com.sandata.entity.connecticut.visit.Calls> calls) {
        Calls = calls;
    }

    public List<com.sandata.entity.connecticut.visit.VisitExceptionAcknowledgement> getVisitExceptionAcknowledgement() {
        return VisitExceptionAcknowledgement;
    }

    public void setVisitExceptionAcknowledgement(List<com.sandata.entity.connecticut.visit.VisitExceptionAcknowledgement> visitExceptionAcknowledgement) {
        VisitExceptionAcknowledgement = visitExceptionAcknowledgement;
    }

    public List<com.sandata.entity.connecticut.visit.VisitChanges> getVisitChanges() {
        return VisitChanges;
    }

    public void setVisitChanges(List<com.sandata.entity.connecticut.visit.VisitChanges> visitChanges) {
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
