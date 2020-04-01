package com.interop.models.db.staging;

import com.sandata.core.annotation.DataTableColumn;

public class StagingClient {
    @DataTableColumn
    private Object client_sk;

    @DataTableColumn
    private Object client_f_name;

    @DataTableColumn
    private Object client_l_name;

    @DataTableColumn
    private Object client_medicaid_id;

    @DataTableColumn
    private Object client_id_custom1;

    @DataTableColumn
    private Object client_id_custom2;

    @DataTableColumn
    private Object client_id;

    @DataTableColumn
    private Object client_id_qlfr;

    @DataTableColumn
    private Object account;

    @DataTableColumn
    private Object status_code;

    @DataTableColumn
    private Object status_memo;


    public Object getClient_sk() {
        return client_sk;
    }

    public void setClient_sk(Object client_sk) {
        this.client_sk = client_sk;
    }

    public Object getClient_f_name() {
        return client_f_name;
    }

    public void setClient_f_name(Object client_f_name) {
        this.client_f_name = client_f_name;
    }

    public Object getClient_l_name() {
        return client_l_name;
    }

    public void setClient_l_name(Object client_l_name) {
        this.client_l_name = client_l_name;
    }

    public Object getClient_medicaid_id() {
        return client_medicaid_id;
    }

    public void setClient_medicaid_id(Object client_medicaid_id) {
        this.client_medicaid_id = client_medicaid_id;
    }

    public Object getClient_id_custom1() {
        return client_id_custom1;
    }

    public void setClient_id_custom1(Object client_id_custom1) {
        this.client_id_custom1 = client_id_custom1;
    }

    public Object getClient_id_custom2() {
        return client_id_custom2;
    }

    public void setClient_id_custom2(Object client_id_custom2) {
        this.client_id_custom2 = client_id_custom2;
    }

    public Object getClient_id() {
        return client_id;
    }

    public void setClient_id(Object client_id) {
        this.client_id = client_id;
    }

    public Object getClient_id_qlfr() {
        return client_id_qlfr;
    }

    public void setClient_id_qlfr(Object client_id_qlfr) {
        this.client_id_qlfr = client_id_qlfr;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public Object getStatus_code() {
        return status_code;
    }

    public void setStatus_code(Object status_code) {
        this.status_code = status_code;
    }

    public Object getStatus_memo() {
        return status_memo;
    }

    public void setStatus_memo(Object status_memo) {
        this.status_memo = status_memo;
    }
}
