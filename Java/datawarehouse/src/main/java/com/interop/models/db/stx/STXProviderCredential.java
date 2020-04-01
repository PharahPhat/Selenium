package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;

public class STXProviderCredential {
    @DataTableColumn
    private Object WS_AUTHENTICATION_USERNAME;
    @DataTableColumn
    private Object WS_AUTHENTICATION_PWD_HASH;
    @DataTableColumn
    private Object ACCOUNT;
    @DataTableColumn
    private Object PROVIDER_ID;

    public Object getWS_AUTHENTICATION_USERNAME() {
        return WS_AUTHENTICATION_USERNAME;
    }

    public void setWS_AUTHENTICATION_USERNAME(Object WS_AUTHENTICATION_USERNAME) {
        this.WS_AUTHENTICATION_USERNAME = WS_AUTHENTICATION_USERNAME;
    }

    public Object getWS_AUTHENTICATION_PWD_HASH() {
        return WS_AUTHENTICATION_PWD_HASH;
    }

    public void setWS_AUTHENTICATION_PWD_HASH(Object WS_AUTHENTICATION_PWD_HASH) {
        this.WS_AUTHENTICATION_PWD_HASH = WS_AUTHENTICATION_PWD_HASH;
    }

    public Object getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(Object ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }

    public Object getPROVIDER_ID() {
        return PROVIDER_ID;
    }

    public void setPROVIDER_ID(Object PROVIDER_ID) {
        this.PROVIDER_ID = PROVIDER_ID;
    }
}
