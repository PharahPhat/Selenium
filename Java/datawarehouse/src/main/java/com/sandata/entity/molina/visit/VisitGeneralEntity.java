package com.sandata.entity.molina.visit;

import com.sandata.entity.exportDWH.Call;
import com.sandata.entity.exportDWH.VisitChange;
import com.sandata.entity.exportDWH.VisitExceptionAcknowledgement;
import com.sandata.entity.generic.VisitGenericEntity;
import java.util.List;

public class VisitGeneralEntity extends VisitGenericEntity {
    public com.sandata.entity.exportDWH.ProviderIdentification ProviderIdentification;
    public String VisitOtherID;
    public String SequenceID;
    public String EmployeeQualifier;
    public String EmployeeIdentifier;
    public String ClientIdentifier;
    public String ClientQualifier;
    public boolean VisitCancelledIndicator;
    public String PayerID;
    public String PayerProgram;
    public String ProcedureCode;
    public String VisitTimeZone;
    public String ScheduleStartTime;
    public String ScheduleEndTime;
    public String AdjInDateTime;
    public String AdjOutDateTime;
    public boolean BillVisit;
    public int HoursToBill;
    public int HoursToPay;
    public String Memo;
    public boolean ClientVerifiedTimes;
    public boolean ClientVerifiedTasks;
    public boolean ClientVerifiedService;
    public boolean ClientSignatureAvailable;
    public boolean ClientVoiceRecording;
    public List<Call> Calls;
    public List<VisitExceptionAcknowledgement> VisitExceptionAcknowledgements;
    public List<VisitChange> VisitChanges;
    public String ErrorCode;
    public String ErrorMessage;

    public com.sandata.entity.exportDWH.ProviderIdentification getProviderIdentification() {
        return ProviderIdentification;
    }

    public void setProviderIdentification(com.sandata.entity.exportDWH.ProviderIdentification providerIdentification) {
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

    public boolean isVisitCancelledIndicator() {
        return VisitCancelledIndicator;
    }

    public void setVisitCancelledIndicator(boolean visitCancelledIndicator) {
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

    public boolean isBillVisit() {
        return BillVisit;
    }

    public void setBillVisit(boolean billVisit) {
        BillVisit = billVisit;
    }

    public int getHoursToBill() {
        return HoursToBill;
    }

    public void setHoursToBill(int hoursToBill) {
        HoursToBill = hoursToBill;
    }

    public int getHoursToPay() {
        return HoursToPay;
    }

    public void setHoursToPay(int hoursToPay) {
        HoursToPay = hoursToPay;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        if(memo != null)
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

    public List<Call> getCalls() {
        return Calls;
    }

    public void setCalls(List<Call> calls) {
        Calls = calls;
    }

    public List<VisitExceptionAcknowledgement> getVisitExceptionAcknowledgements() {
        return VisitExceptionAcknowledgements;
    }

    public void setVisitExceptionAcknowledgements(List<VisitExceptionAcknowledgement> visitExceptionAcknowledgements) {
        VisitExceptionAcknowledgements = visitExceptionAcknowledgements;
    }

    public List<VisitChange> getVisitChanges() {
        return VisitChanges;
    }

    public void setVisitChanges(List<VisitChange> visitChanges) {
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
