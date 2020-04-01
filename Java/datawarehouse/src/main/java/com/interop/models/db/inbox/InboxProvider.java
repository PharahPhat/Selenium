package com.interop.models.db.inbox;

import com.sandata.core.annotation.DataTableColumn;

public class InboxProvider {
    @DataTableColumn
    private Object PROVKEY;

    @DataTableColumn
    private Object SID;

    @DataTableColumn
    private Object ACCOUNT;

    @DataTableColumn
    private Object PROVIDER_ID;

    @DataTableColumn
    private Object PROVIDER_ID_QLFR;

    @DataTableColumn
    private Object ERROR_CODE;

    @DataTableColumn
    private Object COMPNAME;

    @DataTableColumn
    private Object E_MAIL;

    @DataTableColumn
    private Object PAYOR_ID;

    @DataTableColumn
    private Object PHONE;

    @DataTableColumn
    private Object ADDR1;

    @DataTableColumn
    private Object CITY;

    @DataTableColumn
    private Object STATE;

    @DataTableColumn
    private Object PROVIDER_BEG_DATE;

    public void setPROVKEY(Object PROVKEY) {
        this.PROVKEY = PROVKEY;
    }

    public void setSID(Object SID) {
        this.SID = SID;
    }

    public void setACCOUNT(Object ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }

    public void setPROVIDER_ID(Object PROVIDER_ID) {
        this.PROVIDER_ID = PROVIDER_ID;
    }

    public void setPROVIDER_ID_QLFR(Object PROVIDER_ID_QLFR) {
        this.PROVIDER_ID_QLFR = PROVIDER_ID_QLFR;
    }

    public void setERROR_CODE(Object ERROR_CODE) {
        this.ERROR_CODE = ERROR_CODE;
    }

    public void setCOMPNAME(Object COMPNAME) {
        this.COMPNAME = COMPNAME;
    }

    public void setE_MAIL(Object e_MAIL) {
        E_MAIL = e_MAIL;
    }

    public void setPAYOR_ID(Object PAYOR_ID) {
        this.PAYOR_ID = PAYOR_ID;
    }

    public void setPHONE(Object PHONE) {
        this.PHONE = PHONE;
    }

    public void setADDR1(Object ADDR1) {
        this.ADDR1 = ADDR1;
    }

    public void setCITY(Object CITY) {
        this.CITY = CITY;
    }

    public void setSTATE(Object STATE) {
        this.STATE = STATE;
    }

    public Object getPROVIDER_BEG_DATE() {
        return PROVIDER_BEG_DATE;
    }

    public void setPROVIDER_BEG_DATE(Object PROVIDER_BEG_DATE) {
        this.PROVIDER_BEG_DATE = PROVIDER_BEG_DATE;
    }

    public Object getPROVKEY() {
        return PROVKEY;
    }

    public Object getSID() {
        return SID;
    }

    public Object getACCOUNT() {
        return ACCOUNT;
    }

    public Object getPROVIDER_ID() {
        return PROVIDER_ID;
    }

    public Object getPROVIDER_ID_QLFR() {
        return PROVIDER_ID_QLFR;
    }

    public Object getERROR_CODE() {
        return ERROR_CODE;
    }

    public Object getCOMPNAME() {
        return COMPNAME;
    }

    public Object getE_MAIL() {
        return E_MAIL;
    }

    public Object getPAYOR_ID() {
        return PAYOR_ID;
    }

    public Object getPHONE() {
        return PHONE;
    }

    public Object getADDR1() {
        return ADDR1;
    }

    public Object getCITY() {
        return CITY;
    }

    public Object getSTATE() {
        return STATE;
    }
}
