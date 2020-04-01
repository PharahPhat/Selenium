package com.interop.sql;

public class VisitLogSQL {
    public final static String SQL_GET_VISIT_LOG_KEY_BY_VISIT_KEY_AND_EMPLOYEE_FIRST_NAME = "select VISLOGKEY from stx.visits_log \n" +
            "where visitkey = '%s' \n" +
            "and workerkey in (select WORKERKEY \n" +
            "                  from stx.workers \n" +
            "                  where F_NAME = '%s')";

    public final static String SQL_SELECT_VISLOGKEY_CLIENT_LNAME = "select VISLOGKEY from stx.visits_log where visitkey = '%s' and CLIENTKEY IN (SELECT CLIENTKEY FROM STX.CLIENTS WHERE L_NAME='%s')";
    public final static String SQL_SELECT_VISITLOG_FROM_VISITKEY = "select VISLOGKEY from stx.visits_log where visitkey = '%s'";

}

