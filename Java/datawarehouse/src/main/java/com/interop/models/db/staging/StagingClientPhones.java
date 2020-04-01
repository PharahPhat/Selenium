package com.interop.models.db.staging;

import com.sandata.core.annotation.DataTableColumn;

public class StagingClientPhones {

    @DataTableColumn
    private Object CLIENT_ID;

    @DataTableColumn
    private Object ACCOUNT;

    @DataTableColumn
    private Object CLIENT_PHONE_TYP;

    @DataTableColumn
    private Object CLIENT_PHONE_NUM;

    public Object getCLIENT_ID() {
        return CLIENT_ID;
    }

    public void setCLIENT_ID(Object CLIENT_ID) {
        this.CLIENT_ID = CLIENT_ID;
    }

    public Object getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(Object ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }

    public Object getCLIENT_PHONE_TYP() {
        return CLIENT_PHONE_TYP;
    }

    public void setCLIENT_PHONE_TYP(Object CLIENT_PHONE_TYP) {
        this.CLIENT_PHONE_TYP = CLIENT_PHONE_TYP;
    }

    public Object getCLIENT_PHONE_NUM() {
        return CLIENT_PHONE_NUM;
    }

    public void setCLIENT_PHONE_NUM(Object CLIENT_PHONE_NUM) {
        this.CLIENT_PHONE_NUM = CLIENT_PHONE_NUM;
    }
}
