package com.sandata.entity.ohio.visit;

import com.sandata.entity.exportDWH.VisitExceptionAcknowledgement;
import com.sandata.entity.generic.VisitGenericEntity;

import java.util.List;

public class VisitGeneralEntity extends VisitGenericEntity {

    public String getBusinessEntityID() {
        return BusinessEntityID;
    }

    public void setBusinessEntityID(String businessEntityID) {
        BusinessEntityID = businessEntityID;
    }

    public String getBusinessEntityMedicaidIdentifier() {
        return BusinessEntityMedicaidIdentifier;
    }

    public void setBusinessEntityMedicaidIdentifier(String businessEntityMedicaidIdentifier) {
        BusinessEntityMedicaidIdentifier = businessEntityMedicaidIdentifier;
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

    public String getStaffOtherID() {
        return StaffOtherID;
    }

    public void setStaffOtherID(String staffOtherID) {
        StaffOtherID = staffOtherID;
    }

    public String getPatientOtherID() {
        return PatientOtherID;
    }

    public void setPatientOtherID(String patientOtherID) {
        PatientOtherID = patientOtherID;
    }

    public String getPatientMedicaidID() {
        return PatientMedicaidID;
    }

    public void setPatientMedicaidID(String patientMedicaidID) {
        PatientMedicaidID = patientMedicaidID;
    }

    public boolean isVisitCancelledIndicator() {
        return VisitCancelledIndicator;
    }

    public void setVisitCancelledIndicator(boolean visitCancelledIndicator) {
        VisitCancelledIndicator = visitCancelledIndicator;
    }

    public String getPayer() {
        return Payer;
    }

    public void setPayer(String payer) {
        Payer = payer;
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

    public String getGroupVisitIndicator() {
        return GroupVisitIndicator;
    }

    public void setGroupVisitIndicator(String groupVisitIndicator) {
        GroupVisitIndicator = groupVisitIndicator;
    }

    public String getGroupVisitCode() {
        return GroupVisitCode;
    }

    public void setGroupVisitCode(String groupVisitCode) {
        GroupVisitCode = groupVisitCode;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(String timeZone) {
        TimeZone = timeZone;
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

    public String getVisitMemo() {
        return VisitMemo;
    }

    public void setVisitMemo(String visitMemo) {
        VisitMemo = visitMemo;
    }

    public boolean isMemberVerifiedTimes() {
        return MemberVerifiedTimes;
    }

    public void setMemberVerifiedTimes(boolean memberVerifiedTimes) {
        MemberVerifiedTimes = memberVerifiedTimes;
    }

    public boolean isMemberVerifiedService() {
        return MemberVerifiedService;
    }

    public void setMemberVerifiedService(boolean memberVerifiedService) {
        MemberVerifiedService = memberVerifiedService;
    }

    public boolean isMemberSignatureAvailable() {
        return MemberSignatureAvailable;
    }

    public void setMemberSignatureAvailable(boolean memberSignatureAvailable) {
        MemberSignatureAvailable = memberSignatureAvailable;
    }

    public boolean isMemberVoiceRecording() {
        return MemberVoiceRecording;
    }

    public void setMemberVoiceRecording(boolean memberVoiceRecording) {
        MemberVoiceRecording = memberVoiceRecording;
    }

    public List<Call> getCalls() {
        return Calls;
    }

    public void setCalls(List<Call> calls) {
        Calls = calls;
    }

    public List<VisitExceptionAcknowledgement> getVisitException() {
        return VisitException;
    }

    public void setVisitException(List<VisitExceptionAcknowledgement> visitException) {
        VisitException = visitException;
    }

    public List<VisitChange> getVisitChanges() {
        return VisitChanges;
    }

    public void setVisitChanges(List<VisitChange> visitChanges) {
        VisitChanges = visitChanges;
    }

    public String getVisitKey() {
        return VisitKey;
    }

    public void setVisitKey(String visitKey) {
        VisitKey = visitKey;
    }

    public String BusinessEntityID;
    public String BusinessEntityMedicaidIdentifier;
    public String VisitOtherID;
    public String SequenceID;
    public String VisitKey;
    public String StaffOtherID;
    public String PatientOtherID;
    public String PatientMedicaidID;
    public boolean VisitCancelledIndicator;
    public String Payer;
    public String PayerID;
    public String PayerProgram;
    public String ProcedureCode;
    public String GroupVisitIndicator;
    public String GroupVisitCode;
    public String TimeZone;
    public String AdjInDateTime;
    public String AdjOutDateTime;
    public boolean BillVisit;
    public int HoursToBill;
    public String VisitMemo;
    public boolean MemberVerifiedTimes;
    public boolean MemberVerifiedService;
    public boolean MemberSignatureAvailable;
    public boolean MemberVoiceRecording;
    public List<com.sandata.entity.ohio.visit.Call> Calls;
    public List<VisitExceptionAcknowledgement> VisitException;
    public List<com.sandata.entity.ohio.visit.VisitChange> VisitChanges;
}
