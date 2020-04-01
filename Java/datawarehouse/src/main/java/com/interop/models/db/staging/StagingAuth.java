package com.interop.models.db.staging;

import com.sandata.core.annotation.DataTableColumn;

public class StagingAuth {
    @DataTableColumn
    private Object auth_sk;
    @DataTableColumn
    private Object status_code;
    @DataTableColumn
    private Object status_memo;
    @DataTableColumn
    private Object auth_status;
    @DataTableColumn
    private Object account;
    @DataTableColumn
    private Object payor_id;
    @DataTableColumn
    private Object program;
    @DataTableColumn
    private Object client_id;
    @DataTableColumn
    private Object client_id_qlfr;
    @DataTableColumn
    private Object worker_id;
    @DataTableColumn
    private Object worker_id_qlfr;
    @DataTableColumn
    private Object provider_id;
    @DataTableColumn
    private Object provider_id_qlfr;
    @DataTableColumn
    private Object auth_ref_num;
    @DataTableColumn
    private Object service;
    @DataTableColumn
    private Object auth_billing_typ;
    @DataTableColumn
    private Object modifier1;
    @DataTableColumn
    private Object modifier2;
    @DataTableColumn
    private Object modifier3;
    @DataTableColumn
    private Object modifier4;
    @DataTableColumn
    private Object auth_lmt_typ;
    @DataTableColumn
    private Object client_assessment_date;
    @DataTableColumn
    private Object dx_code;
    @DataTableColumn
    private Object dx_code_prmy_ind;
    @DataTableColumn
    private Object account_intf_trans_guid;
    @DataTableColumn
    private Object case_manager_f_name;
    @DataTableColumn
    private Object case_manager_l_name;
    @DataTableColumn
    private Object case_manager_e_mail;

    public Object getAccount_intf_trans_guid() {
        return account_intf_trans_guid;
    }

    public Object getAuth_sk() {
        return auth_sk;
    }

    public Object getStatus_code() {
        return status_code;
    }

    public Object getStatus_memo() {
        return status_memo;
    }

    public Object getAuth_status() {
        return auth_status;
    }

    public Object getAccount() {
        return account;
    }

    public Object getPayor_id() {
        return payor_id;
    }

    public Object getProgram() {
        return program;
    }

    public Object getClient_id() {
        return client_id;
    }

    public Object getClient_id_qlfr() {
        return client_id_qlfr;
    }

    public Object getWorker_id() {
        return worker_id;
    }

    public Object getWorker_id_qlfr() {
        return worker_id_qlfr;
    }

    public Object getProvider_id() {
        return provider_id;
    }

    public Object getProvider_id_qlfr() {
        return provider_id_qlfr;
    }

    public Object getAuth_ref_num() {
        return auth_ref_num;
    }

    public Object getService() {
        return service;
    }

    public Object getAuth_billing_typ() {
        return auth_billing_typ;
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

    public Object getAuth_lmt_typ() {
        return auth_lmt_typ;
    }

    public Object getClient_assessment_date() {
        return client_assessment_date;
    }

    public Object getDx_code() {
        return dx_code;
    }

    public Object getDx_code_prmy_ind() {
        return dx_code_prmy_ind;
    }

    public Object getCase_manager_f_name() {
        return case_manager_f_name;
    }

    public Object getCase_manager_l_name() {
        return case_manager_l_name;
    }

    public Object getCase_manager_e_mail() {
        return case_manager_e_mail;
    }

    @Override
    public String toString() {
        return "StagingAuth{" +
                "auth_sk=" + auth_sk +
                ", status_code=" + status_code +
                ", status_memo=" + status_memo +
                ", auth_status=" + auth_status +
                ", account=" + account +
                ", payor_id=" + payor_id +
                ", program=" + program +
                ", client_id=" + client_id +
                ", client_id_qlfr=" + client_id_qlfr +
                ", worker_id=" + worker_id +
                ", worker_id_qlfr=" + worker_id_qlfr +
                ", provider_id=" + provider_id +
                ", provider_id_qlfr=" + provider_id_qlfr +
                ", auth_ref_num=" + auth_ref_num +
                ", service=" + service +
                ", auth_billing_typ=" + auth_billing_typ +
                ", modifier1=" + modifier1 +
                ", modifier2=" + modifier2 +
                ", modifier3=" + modifier3 +
                ", modifier4=" + modifier4 +
                ", auth_lmt_typ=" + auth_lmt_typ +
                ", client_assessment_date=" + client_assessment_date +
                ", dx_code=" + dx_code +
                ", dx_code_prmy_ind=" + dx_code_prmy_ind +
                ", account_intf_trans_guid=" + account_intf_trans_guid +
                ", case_manager_f_name=" + case_manager_f_name +
                ", case_manager_l_name=" + case_manager_l_name +
                ", case_manager_e_mail=" + case_manager_e_mail +
                '}';
    }
}
