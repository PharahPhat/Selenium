package com.interop.models.db.staging;

import com.sandata.core.annotation.DataTableColumn;

public class StagingAuthLimit {

    @DataTableColumn
    private Object auth_limit_sk;
    @DataTableColumn
    private Object action_code;
    @DataTableColumn
    private Object account_intf_trans_guid;
    @DataTableColumn
    private Object auth_lmt;
    @DataTableColumn
    private Object auth_lmt_day_of_week;
    @DataTableColumn
    private Object auth_lmt_end_time;
    @DataTableColumn
    private Object auth_lmt_start_time;
    @DataTableColumn
    private Object auth_sk;
    @DataTableColumn
    private Object program;
    @DataTableColumn
    private Object prmy_dx_code;
    @DataTableColumn
    private Object modifier1;
    @DataTableColumn
    private Object modifier2;
    @DataTableColumn
    private Object modifier3;
    @DataTableColumn
    private Object modifier4;
    @DataTableColumn
    private Object service;

    public Object getService() {
        return service;
    }

    public Object getAuth_limit_sk() {
        return auth_limit_sk;
    }

    public Object getAction_code() {
        return action_code;
    }

    public Object getAccount_intf_trans_guid() {
        return account_intf_trans_guid;
    }

    public Object getAuth_lmt() {
        return auth_lmt;
    }

    public Object getAuth_lmt_day_of_week() {
        return auth_lmt_day_of_week;
    }

    public Object getAuth_lmt_end_time() {
        return auth_lmt_end_time;
    }

    public Object getAuth_lmt_start_time() {
        return auth_lmt_start_time;
    }

    public Object getAuth_sk() {
        return auth_sk;
    }

    public Object getProgram() {
        return program;
    }

    public Object getPrmy_dx_code() {
        return prmy_dx_code;
    }

    public Object getModifier1() {
        return modifier1;
    }

    public Object getModifier2() {
        return modifier2;
    }

    public Object getModifier3() {
        return modifier3;
    }

    public Object getModifier4() {
        return modifier4;
    }
}
