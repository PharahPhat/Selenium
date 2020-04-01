package com.interop.models.db.staging;

import com.sandata.core.annotation.DataTableColumn;

public class StagingClientEligibilities {
    @DataTableColumn
    private Object CLIENT_ID;

    @DataTableColumn
    private Object ACCOUNT;

    @DataTableColumn
    private Object PAYOR_ID;

    @DataTableColumn
    private Object PROGRAM;

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

    public Object getPAYOR_ID() {
        return PAYOR_ID;
    }

    public void setPAYOR_ID(Object PAYOR_ID) {
        this.PAYOR_ID = PAYOR_ID;
    }

    public Object getPROGRAM() {
        return PROGRAM;
    }

    public void setPROGRAM(Object PROGRAM) {
        this.PROGRAM = PROGRAM;
    }
}
