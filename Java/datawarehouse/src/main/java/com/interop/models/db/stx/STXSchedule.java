package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class STXSchedule {
    @DataTableColumn
    Object ACCOUNT;
    @DataTableColumn
    Object SCHKEY;
    @DataTableColumn
    Object LOC;
    @DataTableColumn
    Object STX_ID;
    @DataTableColumn
    Object B_DTIME;
    @DataTableColumn
    Object E_DTIME;
    @DataTableColumn
    Object FLAG;
    @DataTableColumn
    Object DUTY_FREE;
    @DataTableColumn
    Object CTRL_NUM;
    @DataTableColumn
    Object WEEK_END;
    @DataTableColumn
    Object PAYRATE;
    @DataTableColumn
    Object BILLRATE;
    @DataTableColumn
    Object DISCIPLINE;
    @DataTableColumn
    Object SERVICE;
    @DataTableColumn
    Object SCH_EXPLAIN;
    @DataTableColumn
    Object CONTRACT;
    @DataTableColumn
    Object AR_NO;
    @DataTableColumn
    Object BRANCH;
    @DataTableColumn
    Object VISIT_TYPE;
    @DataTableColumn
    Object LI_CASE;
    @DataTableColumn
    Object OT_AB_HOURS;
    @DataTableColumn
    Object OT_AB_CODE;
    @DataTableColumn
    Object OT_AB_INITIALS;
    @DataTableColumn
    Object PROC_CODE;
    @DataTableColumn
    Object CASENUM;
    @DataTableColumn
    Object CASESEQ;
    @DataTableColumn
    Object RESUBMISSION_INDICATOR;
    @DataTableColumn
    Object RESUBMISSION_CLAIM_NUMBER;
    @DataTableColumn
    Object TZNAME;
    @DataTableColumn
    Object BILLCODE;
    @DataTableColumn
    Object PROC_CODE_QUALIFIER;
    @DataTableColumn
    Object MODIFIER1;
    @DataTableColumn
    Object MODIFIER2;
    @DataTableColumn
    Object MODIFIER3;
    @DataTableColumn
    Object MODIFIER4;
    @DataTableColumn
    Object PROGRAM;
    @DataTableColumn
    Object SCHEDULE_GUID;
    @DataTableColumn
    Object CONTGY_PLAN_CODE;
}
