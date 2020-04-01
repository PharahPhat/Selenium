package com.sandata.entity.exportDWH;

public class ClientPayerInformation {
    public String PayerID;
    public String PayerProgram;
    public String ProcedureCode;
    public String ClientStatus;
    public String ClientEligibilityDateBegin;
    public String ClientEligibilityDateEnd;
    public String ClientPayerID;

    public String getClientStatus() {
        return ClientStatus;
    }

    public void setClientStatus(String clientStatus) {
        ClientStatus = clientStatus;
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
}
