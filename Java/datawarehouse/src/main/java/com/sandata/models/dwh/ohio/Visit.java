package com.sandata.models.dwh.ohio;

import org.testng.Assert;

import java.util.List;

public class Visit {
    private String BusinessEntityID;
    private String VisitOtherID;
    private String StaffID;
    private String StaffOtherID;
    private String PatientID;
    private String PatientOtherID;
    private String PatientMedicaidID;
    private String PatientVisitVerificationID;
    private String VisitKey;
    private boolean VisitCancelledIndicator;
    private boolean GroupVisitIndicator;
    private String GroupVisitCode;
    private String Payer;
    private String PayerProgram;
    private String ProcedureCode;
    private String TimeZone;
    private String AdjInDateTime;
    private String AdjOutDateTime;
    private String AdjDuration;
    private String BillVisit;
    private String Units;
    private double HoursToBill;
    private String VisitMemo;
    private boolean MemberVerifiedTimes;
    private boolean MemberVerifiedService;
    private boolean MemberSignatureAvailable;
    private boolean MemberVoiceRecording;
    private String VisitStatus;
    private List<Calls> Calls;
    private List<VisitException> VisitException;
    private List<HistoricalVisitChanges> HistoricalVisitChanges;
    private List<ClaimStackRequests> ClaimStackRequests;

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

    public boolean isGroupVisitIndicator() {
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

    public String getAdjDuration() {
        return AdjDuration;
    }

    public void setAdjDuration(String adjDuration) {
        AdjDuration = adjDuration;
    }

    public String getBillVisit() {
        return BillVisit;
    }

    public void setBillVisit(String billVisit) {
        BillVisit = billVisit;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public double getHoursToBill() {
        return HoursToBill;
    }

    public void setHoursToBill(double hoursToBill) {
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

    public List<com.sandata.models.dwh.ohio.Calls> getCalls() {
        return Calls;
    }

    public void setCalls(List<com.sandata.models.dwh.ohio.Calls> calls) {
        Calls = calls;
    }

    public List<com.sandata.models.dwh.ohio.VisitException> getVisitException() {
        return VisitException;
    }

    public void setVisitException(List<com.sandata.models.dwh.ohio.VisitException> visitException) {
        VisitException = visitException;
    }

    public List<com.sandata.models.dwh.ohio.HistoricalVisitChanges> getHistoricalVisitChanges() {
        return HistoricalVisitChanges;
    }

    public void setHistoricalVisitChanges(List<com.sandata.models.dwh.ohio.HistoricalVisitChanges> historicalVisitChanges) {
        HistoricalVisitChanges = historicalVisitChanges;
    }

    public List<com.sandata.models.dwh.ohio.ClaimStackRequests> getClaimStackRequests() {
        return ClaimStackRequests;
    }

    public void setClaimStackRequests(List<com.sandata.models.dwh.ohio.ClaimStackRequests> claimStackRequests) {
        ClaimStackRequests = claimStackRequests;
    }

    public boolean getDataIsNotNull(){
        return VisitKey != null  && PatientID != null;
    }
}
