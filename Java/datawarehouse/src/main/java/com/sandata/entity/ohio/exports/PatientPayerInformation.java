package com.sandata.entity.ohio.exports;

public class PatientPayerInformation {
    public String Payer;
    public String PayerProgram;
    public String ProcedureCode;
    public String ClientPayerID;

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

    public String getClientPayerID() {
        return ClientPayerID;
    }

    public void setClientPayerID(String clientPayerID) {
        ClientPayerID = clientPayerID;
    }
}
