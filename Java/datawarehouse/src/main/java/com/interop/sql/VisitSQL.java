package com.interop.sql;

public class VisitSQL {
    public static final String SQL_GET_VISIT_TASK = "select to_char(visitInfo.visitkey) as VisitKey, visitInfo.task_id as TaskID,\n" +
            "visitInfo.task_info as TaskReading, \n" +
            "case when visitInfo.vi_explain <> 0 then 'FALSE'\n" +
            "when visitInfo.vi_explain = 0 then 'TRUE'\n" +
            "end as TaskRefused,\n" +
            "tasksetup.unit as TaskUnit, to_char(calls.callkey) as CallKey, to_char(inbox.user_id) as RecordUpdatedBy, \n" +
            "to_char(from_tz(cast(timestamp as timestamp), 'EST') at time zone 'UTC',\n" +
            "               'YYYY-MM-dd\"T\"HH24:MI:SS\"Z\"') as RecordUpdateDateTime\n" +
            "from STX.visits_info visitInfo\n" +
            "left join STX.tasks_setup tasksetup on tasksetup.update_id = '%s'\n" +
            "left join STX.calls calls on calls.visitkey = visitInfo.visitkey\n" +
            "left join STX.visits_log visitlog on visitlog.visitkey = visitInfo.visitkey\n" +
            "left join inbox.logins inbox on inbox.session_id = visitlog.session_id\n" +
            "where visitInfo.visitkey = '%s' and visitlog.reason_code is not null\n";

    public static final String SQL_GET_VISIT_UPDATE_ID_BY_VISIT_KEY = "SELECT update_id FROM VISITS WHERE visitkey = '%s'\n";

    public static final String SQL_GET_VISIST_ACCOUNT = "select * from stx.visits where memo = '%s' and account = '%s'";

    public static final String SQL_GET_VISIT_BY_ACCOUNT_AND_UNIQUE_MEMO = "SELECT * FROM VISITS vs where account='%1$s' and memo='%2$s'";

    public static final String SQL_GET_VISITS_BY_ACCOUNT_AND_UNIQUE_MEMOS = "SELECT * FROM VISITS vs where account='%1$s' and memo in (%2$s)";

    public static final String SQL_GET_VISIT_GENERAL = "SELECT * FROM VISITS WHERE VISITKEY = '%s'";

    public static final String SQL_GET_VISIT_BY_SEQUENCE_NUMBER = "SELECT ACCOUNT FROM STX.visits WHERE ACCOUNT='%s' AND visit_version_number = '%s'";

    public static final String SQL_GET_VISIT_BY_VISIT_OTHER_ID = "SELECT ACCOUNT FROM STX.VISITS WHERE ACCOUNT='%s' AND VISIT_ID = '%s'";

    public static final String SQL_GET_VISIT_BY_MEMO = "SELECT ACCOUNT FROM STX.VISITS WHERE ACCOUNT='%s' AND memo='%s'";

    public static final String SQL_GET_VISIT_BY_MEMOS = "SELECT memo FROM STX.VISITS WHERE ACCOUNT='%s' AND memo in (%s)";

    public static final String SQL_GET_VISIT_PROCEDURE = "SELECT SERVICE\n" +
            "FROM STX.VISITS\n" +
            "WHERE VISITKEY = '%s'\n";

    public static final String SQL_STX_VISIT = "SELECT vs.account,\n" +
            "       vs.VISIT_DATE,\n" +
            "       vs.VISIT_EDATE,\n" +
            "       vs.BEG_CALL_DTIME,\n" +
            "       vs.END_CALL_DTIME,\n" +
            "       vs.ANI,\n" +
            "       vs.STX_ID,\n" +
            "       vs.VISITKEY,\n" +
            "       vs.UPDATE_TMSTP,\n" +
            "       vs.SERVICE,\n" +
            "       vs.VISIT_ID,\n" +
            "       vs.VISIT_VERSION_NUMBER,\n" +
            "       vs.PAYOR_ID,\n" +
            "       vs.PROGRAM\n" +
            "FROM stx.VISITS vs\n" +
            "WHERE vs.account = '%s'\n" +
            "  AND vs.VISIT_VERSION_NUMBER = '%s'";

    public static final String SQL_STX_VISIT_VERIFIED = "SELECT account, VISIT_DATE, VISIT_EDATE, BEG_CALL_DTIME, " +
            "END_CALL_DTIME, ANI, STX_ID, VISITKEY, UPDATE_TMSTP, SERVICE, VISIT_ID, VISIT_VERSION_NUMBER, PAYOR_ID, " +
            "PROGRAM FROM stx.VISITS WHERE account = '%s' " +
            "AND VISIT_VERSION_NUMBER = '%s' " +
            "AND stx.lib.getVisitStatus_custom(visitkey) = 'Verified'";

    public static final String SQLSTXVISITCLAIM = "SELECT v.VISITKEY,stx.lib.GetVisitStatus_custom(v.visitkey) AS VISIT_STATUS" +
            ", v.VISIT_DATE, VISIT_EDATE, BEG_CALL_DTIME, END_CALL_DTIME, v.SERVICE, v.PAYOR_ID, v.BILL_HOURS" +
            ", v.ACCOUNT, cs.medicaid_id, stx.lib.getVisitBillUnits(v.visitkey) AS bill_units, v.VISIT_VERSION_NUMBER \n" +
            "FROM stx.VISITS v INNER JOIN stx.CLIENTS_SUPP cs ON v.CLIENTKEY = cs.CLIENTKEY\n" +
            "WHERE v.ACCOUNT = '%s' AND PAYOR_ID IN ('%s') " +
            "AND v.VISIT_VERSION_NUMBER = '%s'";

    public static final String SQL_GET_VISIT_DATE = "SELECT VISIT_DATE FROM stx.VISITS WHERE ACCOUNT= '%s' AND ROWNUM <= 1 order by VISIT_DATE DESC";

    public static final String SQL_GET_VISIT_DATE_BY_NEWEST_VISIT_KEY = "SELECT VISIT_DATE FROM stx.VISITS WHERE ACCOUNT= '%s' order by VISITKEY DESC";

    public static final String SQL_GET_VISIT_TASKS = "SELECT * FROM inbox.VISITS_TASKS WHERE Visit_ID = '%s' AND TASK_ID = '%s'";

    public static final String SQL_GET_VISIT_IN_THE_PAST = "SELECT * FROM stx.visits WHERE VISIT_DATE < TRUNC(SYSDATE) - %s AND ACCOUNT = '%s' AND VISIT_ID IS NOT NULL\n" +
            "AND stx.lib.getVisitStatus_custom(visitkey) = 'Verified'";
}
