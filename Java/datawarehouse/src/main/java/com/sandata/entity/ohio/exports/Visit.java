package com.sandata.entity.ohio.exports;

import com.sandata.entity.ohio.visit.ClaimStackRequests;

import java.util.List;

public class Visit {
    public String BusinessEntityID;
    public String VisitOtherID;
    public String StaffID;
    public String StaffOtherID;
    public String PatientID;
    public String PatientOtherID;
    public String PatientMedicaidID;
    public String VisitKey;
    public String PatientVisitVerificationID;
    public boolean VisitCancelledIndicator;
    public boolean GroupVisitIndicator;
    public String GroupVisitCode;
    public String Payer;
    public String PayerProgram;
    public String ProcedureCode;
    public List<com.sandata.entity.ohio.visit.VisitException> VisitException;
    public List<ClaimStackRequests> ClaimStackRequests;
    public List<com.sandata.entity.ohio.exports.Call> Calls;

    public String getBusinessEntityID() {
        return BusinessEntityID;
    }

    public void setBusinessEntityID(String businessEntityID) {
        BusinessEntityID = businessEntityID;
    }

    public String getVisitOtherID() {
        return VisitOtherID;
    }

    public void setVisitOtherID(String visitOtherID) {
        VisitOtherID = visitOtherID;
    }

    public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String staffID) {
        StaffID = staffID;
    }

    public String getStaffOtherID() {
        return StaffOtherID;
    }

    public void setStaffOtherID(String staffOtherID) {
        StaffOtherID = staffOtherID;
    }

    public String getPatientID() {
        return PatientID;
    }

    public void setPatientID(String patientID) {
        PatientID = patientID;
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

    public String getPatientVisitVerificationID() {
        return PatientVisitVerificationID;
    }

    public void setPatientVisitVerificationID(String patientVisitVerificationID) {
        PatientVisitVerificationID = patientVisitVerificationID;
    }

    public String getVisitKey() {
        return VisitKey;
    }

    public void setVisitKey(String visitKey) {
        VisitKey = visitKey;
    }

    public boolean isVisitCancelledIndicator() {
        return VisitCancelledIndicator;
    }

    public void setVisitCancelledIndicator(boolean visitCancelledIndicator) {
        VisitCancelledIndicator = visitCancelledIndicator;
    }

    public boolean getIsGroupVisitIndicator() {
        return GroupVisitIndicator;
    }

    public void setGroupVisitIndicator(boolean groupVisitIndicator) {
        GroupVisitIndicator = groupVisitIndicator;
    }

    public String getGroupVisitCode() {
        return GroupVisitCode;
    }

    public void setGroupVisitCode(String groupVisitCode) {
        GroupVisitCode = groupVisitCode;
    }

    public String getPayer() {
        return Payer;
    }

    public void setPayer(String payer) {
        Payer = payer;
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

    public double getAdjDuration() {
        return AdjDuration;
    }

    public void setAdjDuration(double adjDuration) {
        AdjDuration = adjDuration;
    }

    public boolean isBillVisit() {
        return BillVisit;
    }

    public void setBillVisit(boolean billVisit) {
        BillVisit = billVisit;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public String getHoursToBill() {
        return HoursToBill;
    }

    public void setHoursToBill(String hoursToBill) {
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

    public String getVisitStatus() {
        return VisitStatus;
    }

    public void setVisitStatus(String visitStatus) {
        VisitStatus = visitStatus;
    }

    public List<com.sandata.entity.ohio.visit.VisitException> getVisitException() {
        return VisitException;
    }

    public void setVisitException(List<com.sandata.entity.ohio.visit.VisitException> visitException) {
        VisitException = visitException;
    }

    public boolean isGroupVisitIndicator() {
        return GroupVisitIndicator;
    }

    public List<com.sandata.entity.ohio.visit.ClaimStackRequests> getClaimStackRequests() {
        return ClaimStackRequests;
    }

    public void setClaimStackRequests(List<com.sandata.entity.ohio.visit.ClaimStackRequests> claimStackRequests) {
        ClaimStackRequests = claimStackRequests;
    }

    public List<Call> getCalls() {
        return Calls;
    }

    public void setCalls(List<Call> calls) {
        Calls = calls;
    }

    public String TimeZone;
    public String AdjInDateTime;
    public String AdjOutDateTime;
    public double AdjDuration;
    public boolean BillVisit;
    public String Units;
    public String HoursToBill;
    public String VisitMemo;
    public boolean MemberVerifiedTimes;
    public boolean MemberVerifiedService;
    public boolean MemberSignatureAvailable;
    public boolean MemberVoiceRecording;
    public String VisitStatus;



}
