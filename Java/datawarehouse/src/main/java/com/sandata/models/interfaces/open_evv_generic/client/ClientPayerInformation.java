package com.sandata.models.interfaces.open_evv_generic.client;

public class ClientPayerInformation {
    private String ClientEligibilityDateBegin;
    private String ClientEligibilityDateEnd;
    private String EffectiveStartDate;
    private String EffectiveEndDate;
    private String ClientPayerID;
    private String ClientStatus ;
    private String PayerID;
    private String PayerProgram;
    private String ProcedureCode;
    private String Modifier1;
    private String Modifier2;
    private String Modifier3;
    private String Modifier4;

    public String getClientEligibilityDateBegin() {
        return ClientEligibilityDateBegin;
    }

    public void setClientEligibilityDateBegin(String clientEligibilityDateBegin) {
        ClientEligibilityDateBegin = clientEligibilityDateBegin;
    }

    public String getClientEligibilityDateEnd() {
        return ClientEligibilityDateEnd;
    }

    public void setClientEligibilityDateEnd(String clientEligibilityDateEnd) {
        ClientEligibilityDateEnd = clientEligibilityDateEnd;
    }
    public String getEffectiveStartDate() {
        return EffectiveStartDate;
    }

    public void setEffectiveStartDate(String effectiveStartDate) {
        EffectiveStartDate = effectiveStartDate;
    }

    public String getEffectiveEndDate() {
        return EffectiveEndDate;
    }

    public void setEffectiveEndDate(String effectiveEndDate) {
        EffectiveEndDate = effectiveEndDate;
    }



    public String getClientPayerID() {
        return ClientPayerID;
    }

    public void setClientPayerID(String clientPayerID) {
        ClientPayerID = clientPayerID;
    }

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

    public String getModifier1() {
        return Modifier1;
    }
    public void setModifier1(String modifier1) {
        Modifier1 = modifier1;
    }

    public void setModifier2(String modifier2) {
        Modifier2 = modifier2;
    }
    public String getModifier2() {
        return Modifier2;
    }

    public String getModifier3() {
        return Modifier3;
    }
    public void setModifier3(String modifier3) {
        Modifier3 = modifier3;
    }

    public String getModifier4() {
        return Modifier4;
    }
    public void setModifier4(String modifier4) {
        Modifier4 = modifier4;
    }

}
