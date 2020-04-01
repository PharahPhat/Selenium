package com.sandata.models.molina.visit;

import com.sandata.core.annotation.CsvHeader;

public class VisitClaimstModel {
    @CsvHeader("VisitKey")
    private String visitKey;

    @CsvHeader("TransactionID")
    private String transactionID;

    @CsvHeader("BatchID")
    private String batchID;

    @CsvHeader("GroupCode")
    private String groupCode;

    @CsvHeader("DetailLineNumber")
    private String detailLineNumber;

    @CsvHeader("Modifiers")
    private String modifiers;

    @CsvHeader("Units")
    private String units;

    @CsvHeader("VisitStartDateTime")
    private String visitStartDateTime;

    @CsvHeader("VisitEndDateTime")
    private String visitEndDateTime;

    @CsvHeader("ResponseDateTime")
    private String responseDateTime;

    @CsvHeader("ICN")
    private String iCN;

    @CsvHeader("ClientMedicaidID")
    private String clientMedicaidID;

    public String getVisitKey() {
        return visitKey;
    }

    public void setVisitKey(String visitKey) {
        this.visitKey = visitKey;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getDetailLineNumber() {
        return detailLineNumber;
    }

    public void setDetailLineNumber(String detailLineNumber) {
        this.detailLineNumber = detailLineNumber;
    }

    public String getModifiers() {
        return modifiers;
    }

    public void setModifiers(String modifiers) {
        this.modifiers = modifiers;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getVisitStartDateTime() {
        return visitStartDateTime;
    }

    public void setVisitStartDateTime(String visitStartDateTime) {
        this.visitStartDateTime = visitStartDateTime;
    }

    public String getVisitEndDateTime() {
        return visitEndDateTime;
    }

    public void setVisitEndDateTime(String visitEndDateTime) {
        this.visitEndDateTime = visitEndDateTime;
    }

    public String getResponseDateTime() {
        return responseDateTime;
    }

    public void setResponseDateTime(String responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public String getiCN() {
        return iCN;
    }

    public void setiCN(String iCN) {
        this.iCN = iCN;
    }

    public String getClientMedicaidID() {
        return clientMedicaidID;
    }

    public void setClientMedicaidID(String clientMedicaidID) {
        this.clientMedicaidID = clientMedicaidID;
    }

    @Override
    public String toString() {
        String toString = "VisitClaimstModel{" +
                "visitKey='" + visitKey + '\'' +
                "transactionID='" + transactionID + '\'' +
                "batchID='" + batchID + '\'' +
                "groupCode='" + groupCode + '\'' +
                "detailLineNumber='" + detailLineNumber + '\'' +
                "modifiers='" + modifiers + '\'' +
                "units='" + units + '\'' +
                "visitStartDateTime='" + visitStartDateTime + '\'' +
                "visitEndDateTime='" + visitEndDateTime + '\'' +
                "responseDateTime='" + responseDateTime + '\'' +
                "iCN='" + iCN + '\'' +
                "clientMedicaidID='" + clientMedicaidID + '\'' +
                '}';
        return toString.replace("null", "");
    }
}
