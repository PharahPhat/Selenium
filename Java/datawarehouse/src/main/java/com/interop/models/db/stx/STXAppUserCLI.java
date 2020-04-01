package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;

public class STXAppUserCLI {
    @DataTableColumn
    private Object ACCOUNT;

    @DataTableColumn
    private Object USER_ID;

    @DataTableColumn
    private Object LOC;

    @DataTableColumn
    private Object USERNAME;

    @DataTableColumn
    private Object BEG_DATE;

    @DataTableColumn
    private Object END_DATE;

    public Object getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(Object ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }

    public Object getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Object USER_ID) {
        this.USER_ID = USER_ID;
    }

    public Object getLOC() {
        return LOC;
    }

    public void setLOC(Object LOC) {
        this.LOC = LOC;
    }

    public Object getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(Object USERNAME) {
        this.USERNAME = USERNAME;
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

    @Override
    public String toString() {
        return "STXAppUser{" +
                "ACCOUNT=" + ACCOUNT +
                ", USERNAME=" + USERNAME +
                ", LOC=" + LOC +
                ", USER_ID=" + USER_ID +
                ", END_DATE=" + END_DATE +
                ", BEG_DATE=" + BEG_DATE +
                '}';
    }
}
