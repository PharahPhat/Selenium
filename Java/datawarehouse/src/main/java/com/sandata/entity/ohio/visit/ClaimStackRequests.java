package com.sandata.entity.ohio.visit;

public class ClaimStackRequests {
    public String VisitKey;
    public String Payer;
    public String RequestType;
    public String TransactionID;
    public String BatchID;
    public String ICN;
    public String DLN;
    public String Modifier;
    public String ProcedureCode;
    public String GroupCode;
    public String VisitStartDateTime;
    public String VisitEndDateTime;
    public String DateOfService;
    public String ResponseDateTime;

    public String getVisitKey() {
        return VisitKey;
    }

    public void setVisitKey(String visitKey) {
        VisitKey = visitKey;
    }

    public String getPayer() {
        return Payer;
    }

    public void setPayer(String payer) {
        Payer = payer;
    }

    public String getRequestType() {
        return RequestType;
    }

    public void setRequestType(String requestType) {
        RequestType = requestType;
    }

    public String getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(String transactionID) {
        TransactionID = transactionID;
    }

    public String getBatchID() {
        return BatchID;
    }

    public void setBatchID(String batchID) {
        BatchID = batchID;
    }

    public String getICN() {
        return ICN;
    }

    public void setICN(String ICN) {
        this.ICN = ICN;
    }

    public String getDLN() {
        return DLN;
    }

    public void setDLN(String DLN) {
        this.DLN = DLN;
    }

    public String getModifier() {
        return Modifier;
    }

    public void setModifier(String modifier) {
        Modifier = modifier;
    }

    public String getProcedureCode() {
        return ProcedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        ProcedureCode = procedureCode;
    }

    public String getGroupCode() {
        return GroupCode;
    }

    public void setGroupCode(String groupCode) {
        GroupCode = groupCode;
    }

    public String getVisitStartDateTime() {
        return VisitStartDateTime;
    }

    public void setVisitStartDateTime(String visitStartDateTime) {
        VisitStartDateTime = visitStartDateTime;
    }

    public String getVisitEndDateTime() {
        return VisitEndDateTime;
    }

    public void setVisitEndDateTime(String visitEndDateTime) {
        VisitEndDateTime = visitEndDateTime;
    }

    public String getDateOfService() {
        return DateOfService;
    }

    public void setDateOfService(String dateOfService) {
        DateOfService = dateOfService;
    }

    public String getResponseDateTime() {
        return ResponseDateTime;
    }

    public void setResponseDateTime(String responseDateTime) {
        ResponseDateTime = responseDateTime;
    }
}
