package com.interop.sql;

public class ScheduleSQL {
    private ScheduleSQL() {
    }
    public static final String SQL_STX_SCHEDULE = "SELECT account," +
            "schkey," +
            "loc," +
            "stx_id," +
            "B_DTIME," +
            "E_DTIME," +
            "FLAG," +
            "DUTY_FREE," +
            "CTRL_NUM," +
            "WEEK_END," +
            "PAYRATE," +
            "BILLRATE," +
            "DISCIPLINE," +
            "SERVICE," +
            "CONTRACT," +
            "AR_NO," +
            "BRANCH," +
            "VISIT_TYPE," +
            "LI_CASE," +
            "OT_AB_HOURS," +
            "OT_AB_CODE," +
            "OT_AB_INITIALS," +
            "PROC_CODE," +
            "CASENUM," +
            "CASESEQ," +
            "RESUBMISSION_INDICATOR," +
            "RESUBMISSION_CLAIM_NUMBER," +
            "TZNAME," +
            "BILLCODE," +
            "PROC_CODE_QUALIFIER," +
            "MODIFIER1," +
            "MODIFIER2," +
            "MODIFIER3," +
            "MODIFIER4," +
            "PROGRAM," +
            "SCHEDULE_GUID," +
            "CONTGY_PLAN_CODE," +
            "CASE TO_CHAR(lib.getExplain(NVL(s.SCH_EXPLAIN ,0), 2))\n" +
            "\tWHEN '1' THEN 'yes'\n" +
            "\tWHEN  '0' THEN 'no' \n" +
            "ELSE null\n" +
            "END AS SCH_EXPLAIN " +
            "FROM stx.SCHEDULE s WHERE ACCOUNT = '%s' AND CTRL_NUM = '%s'";

    public static final String SQL_STX_SCHEDULE_BY_SCHKEY = "SELECT account," +
            "schkey," +
            "loc," +
            "stx_id," +
            "B_DTIME," +
            "E_DTIME," +
            "FLAG," +
            "DUTY_FREE," +
            "CTRL_NUM," +
            "WEEK_END," +
            "PAYRATE," +
            "BILLRATE," +
            "DISCIPLINE," +
            "SERVICE," +
            "CONTRACT," +
            "AR_NO," +
            "BRANCH," +
            "VISIT_TYPE," +
            "LI_CASE," +
            "OT_AB_HOURS," +
            "OT_AB_CODE," +
            "OT_AB_INITIALS," +
            "PROC_CODE," +
            "CASENUM," +
            "CASESEQ," +
            "RESUBMISSION_INDICATOR," +
            "RESUBMISSION_CLAIM_NUMBER," +
            "TZNAME," +
            "BILLCODE," +
            "PROC_CODE_QUALIFIER," +
            "MODIFIER1," +
            "MODIFIER2," +
            "MODIFIER3," +
            "MODIFIER4," +
            "PROGRAM," +
            "SCHEDULE_GUID," +
            "CONTGY_PLAN_CODE," +
            "CASE TO_CHAR(lib.getExplain(NVL(s.SCH_EXPLAIN ,0), 2))\n" +
            "\tWHEN '1' THEN 'yes'\n" +
            "\tWHEN  '0' THEN 'no' \n" +
            "ELSE null\n" +
            "END AS SCH_EXPLAIN " +
            "FROM stx.SCHEDULE s WHERE ACCOUNT = '%s' AND schkey = '%s'";

    public static final String SQL_INBOX_SCHEDULE_SCHKEY = "SELECT " +
            "SCHKEY," +
            "ERROR_CODE " +
            "FROM INBOX.SCHEDULE WHERE sid IN " +
            "(SELECT sid FROM INBOX.VISITS WHERE account ='%s' AND VISIT_VERSION_NUMBER = '%s');";
}
