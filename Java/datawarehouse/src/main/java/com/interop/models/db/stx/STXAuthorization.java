package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;

public class STXAuthorization {
    @DataTableColumn
    private Object AUTH_ID;
    @DataTableColumn
    private Object AUTH_TYPE_ID;
    @DataTableColumn
    private Object AUTH_LIMIT_TYPE_ID;
    @DataTableColumn
    private Object BEG_DATE;
    @DataTableColumn
    private Object END_DATE;
    @DataTableColumn
    private Object ACCOUNT;
    @DataTableColumn
    private Object LOC;
    @DataTableColumn
    private Object CLIENT_ID_CUSTOM;
    @DataTableColumn
    private Object PAYOR_ID;
    @DataTableColumn
    private Object CONTRACT;
    @DataTableColumn
    private Object PROVIDER;
    @DataTableColumn
    private Object AUTH_REF_NUMBER;
    @DataTableColumn
    private Object AUTH_LIMIT_MAX;
    @DataTableColumn
    private Object MEMO;
    @DataTableColumn
    private Object DIAGNOSIS_CODE;

    @DataTableColumn
    private Object CASE_MANAGER_F_NAME;
    @DataTableColumn
    private Object CASE_MANAGER_L_NAME;
    @DataTableColumn
    private Object CASE_MANAGER_E_MAIL;

    public Object getAUTH_ID() {
        return AUTH_ID;
    }

    public void setAUTH_ID(Object AUTH_ID) {
        this.AUTH_ID = AUTH_ID;
    }

    public Object getAUTH_TYPE_ID() {
        return AUTH_TYPE_ID;
    }

    public void setAUTH_TYPE_ID(Object AUTH_TYPE_ID) {
        this.AUTH_TYPE_ID = AUTH_TYPE_ID;
    }

    public Object getAUTH_LIMIT_TYPE_ID() {
        return AUTH_LIMIT_TYPE_ID;
    }

    public void setAUTH_LIMIT_TYPE_ID(Object AUTH_LIMIT_TYPE_ID) {
        this.AUTH_LIMIT_TYPE_ID = AUTH_LIMIT_TYPE_ID;
    }

    public Object getBEG_DATE() {
        return BEG_DATE;
    }

    public void setBEG_DATE(Object BEG_DATE) {
        this.BEG_DATE = BEG_DATE;
    }

    public Object getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(Object END_DATE) {
        this.END_DATE = END_DATE;
    }

    public Object getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(Object ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }

    public Object getLOC() {
        return LOC;
    }

    public void setLOC(Object LOC) {
        this.LOC = LOC;
    }

    public Object getCLIENT_ID_CUSTOM() {
        return CLIENT_ID_CUSTOM;
    }

    public void setCLIENT_ID_CUSTOM(Object CLIENT_ID_CUSTOM) {
        this.CLIENT_ID_CUSTOM = CLIENT_ID_CUSTOM;
    }

    public Object getPAYOR_ID() {
        return PAYOR_ID;
    }

    public void setPAYOR_ID(Object PAYOR_ID) {
        this.PAYOR_ID = PAYOR_ID;
    }

    public Object getCONTRACT() {
        return CONTRACT;
    }

    public void setCONTRACT(Object CONTRACT) {
        this.CONTRACT = CONTRACT;
    }

    public Object getPROVIDER() {
        return PROVIDER;
    }

    public void setPROVIDER(Object PROVIDER) {
        this.PROVIDER = PROVIDER;
    }

    public Object getAUTH_REF_NUMBER() {
        return AUTH_REF_NUMBER;
    }

    public void setAUTH_REF_NUMBER(Object AUTH_REF_NUMBER) {
        this.AUTH_REF_NUMBER = AUTH_REF_NUMBER;
    }

    public Object getAUTH_LIMIT_MAX() {
        return AUTH_LIMIT_MAX;
    }

    public void setAUTH_LIMIT_MAX(Object AUTH_LIMIT_MAX) {
        this.AUTH_LIMIT_MAX = AUTH_LIMIT_MAX;
    }

    public Object getMEMO() {
        return MEMO;
    }

    public void setMEMO(Object MEMO) {
        this.MEMO = MEMO;
    }

    public Object getDIAGNOSIS_CODE() {
        return DIAGNOSIS_CODE;
    }

    public void setDIAGNOSIS_CODE(Object DIAGNOSIS_CODE) {
        this.DIAGNOSIS_CODE = DIAGNOSIS_CODE;
    }

    public Object getCASE_MANAGER_F_NAME() {
        return CASE_MANAGER_F_NAME;
    }

    public Object getCASE_MANAGER_L_NAME() {
        return CASE_MANAGER_L_NAME;
    }

    public Object getCASE_MANAGER_E_MAIL() {
        return CASE_MANAGER_E_MAIL;
    }

    @Override
    public String toString() {
        return "STXAuthorization{" +
                "AUTH_ID=" + AUTH_ID +
                ", AUTH_TYPE_ID=" + AUTH_TYPE_ID +
                ", AUTH_LIMIT_TYPE_ID=" + AUTH_LIMIT_TYPE_ID +
                ", BEG_DATE=" + BEG_DATE +
                ", END_DATE=" + END_DATE +
                ", ACCOUNT=" + ACCOUNT +
                ", LOC=" + LOC +
                ", CLIENT_ID_CUSTOM=" + CLIENT_ID_CUSTOM +
                ", PAYOR_ID=" + PAYOR_ID +
                ", CONTRACT=" + CONTRACT +
                ", PROVIDER=" + PROVIDER +
                ", AUTH_REF_NUMBER=" + AUTH_REF_NUMBER +
                ", AUTH_LIMIT_MAX=" + AUTH_LIMIT_MAX +
                ", MEMO=" + MEMO +
                ", DIAGNOSIS_CODE=" + DIAGNOSIS_CODE +
                ", CASE_MANAGER_F_NAME=" + CASE_MANAGER_F_NAME +
                ", CASE_MANAGER_L_NAME=" + CASE_MANAGER_L_NAME +
                ", CASE_MANAGER_E_MAIL=" + CASE_MANAGER_E_MAIL +
                '}';
    }
}
