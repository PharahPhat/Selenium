package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;
import lombok.Data;

@Data
public class STXProvider {
    @DataTableColumn
    public Object ACCOUNT;

    @DataTableColumn
    public Object UPDATE_ID;

    @DataTableColumn
    public Object INSERT_TMSTP;

    @DataTableColumn
    public Object UPDATE_TMSTP;

    @DataTableColumn
    public Object INVOICE_ENABLED;

    @DataTableColumn
    public Object PROVIDER_NAME;

    @DataTableColumn
    public Object PROVIDER_DBA_NAME;

    @DataTableColumn
    public Object PROVIDER_ID;

    @DataTableColumn
    public Object PROVIDER_ID_QLFR;

    @DataTableColumn
    public Object PROVIDER_ID_OTHER;

    @DataTableColumn
    public Object PROVIDER_ID_OTHER_QLFR;

    @DataTableColumn
    public Object AR_PASSWORD;

    @DataTableColumn
    public Object AR_EXPORTKEY;

    @DataTableColumn
    public Object AR_IMPORTKEY;

    @DataTableColumn
    public Object AR_REJECTKEY;

    @DataTableColumn
    public Object AR_PAYMENT_CODE;

    @DataTableColumn
    public Object HCOPEN_CALLS_VERSION;

    @DataTableColumn
    public Object HCOPEN_CALLS_LAST;

    @DataTableColumn
    public Object HCOPEN_CALLS_DIR;

    @DataTableColumn
    public Object HCOPEN_CALLS_IP;

    @DataTableColumn
    public Object SHARP_CALLS_LAST;

    @DataTableColumn
    public Object VM_PASSWORD;

    @DataTableColumn
    public Object VM_OPTIONS_EXPLAIN;

    @DataTableColumn
    public Object VM_EXCP_CALC;

    @DataTableColumn
    public Object VM_EXCP_REJ;

    @DataTableColumn
    public Object VM_EXCP_NOTASK;

    @DataTableColumn
    public Object VM_REP_SPC;

    @DataTableColumn
    public Object VM_SCH_RESUBMISSION_ENABLED;

    @DataTableColumn
    public Object VM_PAY_HOURS_MAX_SEC;

    @DataTableColumn
    public Object POC_PASSWORD;

    @DataTableColumn
    public Object POC_OVER_SHOW;

    @DataTableColumn
    public Object POC_SHIFT_ENABLED;

    @DataTableColumn
    public Object OPTCODESET;

    @DataTableColumn
    public Object OPTCODE_EXPLAIN;

    @DataTableColumn
    public Object REASONCODEKEY;

    @DataTableColumn
    public Object REASON_CODE_OPTIONS_EXPLAIN;

    @DataTableColumn
    public Object CLNUM;

    @DataTableColumn
    public Object LOC_MRN;

    @DataTableColumn
    public Object LOC_AR_NO;

    @DataTableColumn
    public Object HOURS_FR;

    @DataTableColumn
    public Object DIFF_OPTION;

    @DataTableColumn
    public Object PRINTSCHED;

    @DataTableColumn
    public Object PRINTSTX_ID;

    @DataTableColumn
    public Object PRINTLABEL;

    @DataTableColumn
    public Object PRINTFEDERAL_ID;

    @DataTableColumn
    public Object PRINTDATESBT;

    @DataTableColumn
    public Object ODOMETER;

    @DataTableColumn
    public Object MILEAGE;

    @DataTableColumn
    public Object TRAVELTIME;

    @DataTableColumn
    public Object COUNT_TASKS;

    @DataTableColumn
    public Object WORKERS_TITLE;

    @DataTableColumn
    public Object PAY_OPTIONS;

    @DataTableColumn
    public Object VIS_OPTIONS;

    @DataTableColumn
    public Object CLI_OPTIONS;

    @DataTableColumn
    public Object WRK_OPTIONS;

    @DataTableColumn
    public Object VS_FILTER;

    @DataTableColumn
    public Object DISCIPLINE;

    @DataTableColumn
    public Object SERVICE;

    @DataTableColumn
    public Object PAYRATE;

    @DataTableColumn
    public Object BILLRATE;

    @DataTableColumn
    public Object EXPORT_OPTIONS;

    @DataTableColumn
    public Object EXPORT_OPTIONS1;

    @DataTableColumn
    public Object EXPORT_COMPNAME;

    @DataTableColumn
    public Object EXPORT_BACK_DAYS;

    @DataTableColumn
    public Object EXPORT_UPDATE_BACK_DAYS;

    @DataTableColumn
    public Object LI_CASE;

    @DataTableColumn
    public Object DSS_MEMO;

    @DataTableColumn
    public Object RANDOM_CALLS_PCT;

    @DataTableColumn
    public Object REPORT_OPTIONS_EXPLAIN;

    @DataTableColumn
    public Object FOB_RC_ID;

    @DataTableColumn
    public Object AUTH_BACK_DAYS;

    @DataTableColumn
    public Object DASHBOARD_BACK_DAYS;

    @DataTableColumn
    public Object VM_CLI_BACK_DAYS;

    @DataTableColumn
    public Object VM_WRK_BACK_DAYS;

    @DataTableColumn
    public Object LOC_MIN_VALUE;

    @DataTableColumn
    public Object LOC_MAX_VALUE;

    @DataTableColumn
    public Object STX_ID_MIN_VALUE;

    @DataTableColumn
    public Object STX_ID_MAX_VALUE;

    @DataTableColumn
    public Object CLIENT_OTHER_ID_QLFR;

    @DataTableColumn
    public Object WORKER_OTHER_ID_QLFR;

    @DataTableColumn
    public Object ACCOUNT_OTHER_ID_QLFR;

    @DataTableColumn
    public Object SSN_DISPLAY_LAST_DIGITS;

    @DataTableColumn
    public Object SSN_WRK_LAST_DIGITS_MIN;

    @DataTableColumn
    public Object SSN_CLI_LAST_DIGITS_MIN;

    @DataTableColumn
    public Object CLIENT_ALT_ID_QLFR;
}
