package com.interop.common.constants.queries;

@SuppressWarnings({"squid:S1192","squid:S1118"})
public class InterOpOracle {
    public static final String QUERY_GET_CLIENT_HAVING_SPECIFIC_MEDICAID_ID =
            "SELECT \n" +
                    "  c.*, \n" +
                    "  cs.*, \n" +
                    "  ai.provider_id \n" +
                    "FROM \n" +
                    "  stx.accounts_groups_setup ags \n" +
                    "  INNER JOIN stx.accounts_interfaces ai ON ai.account = ags.account \n" +
                    "  INNER JOIN stx.clients c ON c.account = ai.account \n" +
                    "  LEFT JOIN stx.clients_supp cs ON cs.clientkey = c.clientkey \n" +
                    "WHERE \n" +
                    "  ags.groupkey = '271' \n" +
                    "  AND c.account = '%1s' \n" +
                    "  AND length(cs.MEDICAID_ID) >= %2s \n" +
                    "  AND c.clientkey = (\n" +
                    "    SELECT \n" +
                    "      MAX(c2.clientkey) \n" +
                    "    FROM \n" +
                    "      stx.clients c2 \n" +
                    "    WHERE \n" +
                    "      c2.account = c.account \n" +
                    "      AND c2.loc = c.loc \n" +
                    "      AND c2.beg_date < c2.end_date\n" +
                    "  ) \n" +
                    "  AND ROWNUM = 1";

    public static final String QUERY_GET_CLIENT_HAVING_SPECIFIC_CLIENT_CUSTOM_ID =
            "SELECT \n" +
                    "  c.*, \n" +
                    "  cs.*, \n" +
                    "  ai.provider_id \n" +
                    "FROM \n" +
                    "  stx.accounts_groups_setup ags \n" +
                    "  INNER JOIN stx.accounts_interfaces ai ON ai.account = ags.account \n" +
                    "  INNER JOIN stx.clients c ON c.account = ai.account \n" +
                    "  LEFT JOIN stx.clients_supp cs ON cs.clientkey = c.clientkey \n" +
                    "WHERE \n" +
                    "  c.account = '%1s' \n" +
                    " AND cs.CLIENT_ID_CUSTOM1 IS NOT NULL " +
                    "AND LENGTH(TRIM(TRANSLATE(cs.CLIENT_ID_CUSTOM1 , ' +-.0123456789',' '))) IS NULL " +
                    "  AND c.clientkey = (\n" +
                    "    SELECT \n" +
                    "      MAX(c2.clientkey) \n" +
                    "    FROM \n" +
                    "      stx.clients c2 \n" +
                    "    WHERE \n" +
                    "      c2.account = c.account \n" +
                    "      AND c2.loc = c.loc \n" +
                    "      AND c2.beg_date < c2.end_date\n" +
                    "  ) \n" +
                    "  AND ROWNUM = 1";

    public static final String QUERY_GET_CLIENT_CLIENT_CUSTOM_ID =
            "SELECT \n" +
                    "  c.*, \n" +
                    "  cs.*, \n" +
                    "  ai.provider_id \n" +
                    "FROM \n" +
                    "  stx.accounts_groups_setup ags \n" +
                    "  INNER JOIN stx.accounts_interfaces ai ON ai.account = ags.account \n" +
                    "  INNER JOIN stx.clients c ON c.account = ai.account \n" +
                    "  LEFT JOIN stx.clients_supp cs ON cs.clientkey = c.clientkey \n" +
                    "WHERE \n" +
                    "  c.account = '%1s' \n" +
                    " AND cs.CLIENT_ID_CUSTOM1 IS NOT NULL  " +
                    "  AND c.clientkey = (\n" +
                    "    SELECT \n" +
                    "      MAX(c2.clientkey) \n" +
                    "    FROM \n" +
                    "      stx.clients c2 \n" +
                    "    WHERE \n" +
                    "      c2.account = c.account \n" +
                    "      AND c2.loc = c.loc \n" +
                    "      AND c2.beg_date < c2.end_date\n" +
                    "  ) \n" +
                    "  AND ROWNUM = 1";

    public static final String QUERY_GET_CLIENT_CLIENT_CUSTOM_ID_REG =
            "SELECT \n" +
                    "  c.*, \n" +
                    "  cs.*, \n" +
                    "  ai.provider_id \n" +
                    "FROM \n" +
                    "  stx.accounts_groups_setup ags \n" +
                    "  INNER JOIN stx.accounts_interfaces ai ON ai.account = ags.account \n" +
                    "  INNER JOIN stx.clients c ON c.account = ai.account \n" +
                    "  LEFT JOIN stx.clients_supp cs ON cs.clientkey = c.clientkey \n" +
                    "WHERE \n" +
                    "  c.account = '%1s' \n" +
                    " AND cs.CLIENT_ID_CUSTOM1 IS NOT NULL  AND REGEXP_LIKE (cs.CLIENT_ID_CUSTOM1, '%s') " +
                    "  AND c.clientkey = (\n" +
                    "    SELECT \n" +
                    "      MAX(c2.clientkey) \n" +
                    "    FROM \n" +
                    "      stx.clients c2 \n" +
                    "    WHERE \n" +
                    "      c2.account = c.account \n" +
                    "      AND c2.loc = c.loc \n" +
                    "      AND c2.beg_date < c2.end_date\n" +
                    "  ) \n" +
                    "  AND ROWNUM = 1";

    public static final String QUERY_GET_AUTH_INFO_IN_AUTH_TABLE =
            "SELECT \n" +
                    "  AUTH_ID, \n" +
                    "  LOC, \n" +
                    "  ACCOUNT, \n" +
                    "  PAYOR_ID, \n" +
                    "  DIAGNOSIS_CODE \n" +
                    "FROM \n" +
                    "  STX.AUTHORIZATIONS \n" +
                    "WHERE \n" +
                    "  AUTH_REF_NUMBER = '%s'";

    public static final String QUERY_GET_AUTH_LIMIT_INFO =
            "SELECT \n" +
                    "  AUTH_ID, \n" +
                    "  AUTH_LIMIT_ID, \n" +
                    "  SERVICE, \n" +
                    "  PROGRAM \n" +
                    "FROM \n" +
                    "  stx.AUTH_LIMITS \n" +
                    "WHERE \n" +
                    "  AUTH_ID = '%s'";

    public static final String QUERY_TO_CHECK_THE_AUTH_IN_INBOX_TABLE =
            "SELECT \n" +
                    "\tstx.LIB.GETMESSAGE(ERROR_CODE)\n" +
                    "FROM \n" +
                    "  INBOX.AUTHORIZATIONS \n" +
                    "WHERE \n" +
                    "  AUTH_REF_NUMBER = '%s'";

    public static final String QUERY_TO_GET_APP_USER =
            "SELECT * " +
                    "FROM \n" +
                    "  STX.APP_USERS \n" +
                    "WHERE \n" +
                    "  USERNAME = '%s' \n" +
                    "  AND ACCOUNT = '%s'";

    public static final String QUERY_TO_CHECK_PROVIDER_IN_INOBX_TABLE =
            "SELECT stx.lib.getmessage(ERROR_CODE)\n" +
                    "FROM INBOX.PROVIDERS\n" +
                    "WHERE PROVIDER_ID = '%s'";

    public static final String QUERY_TO_CHECK_PROVIDER_IN_STX_TABLE =
            "SELECT * FROM stx.ACCOUNTS_INTERFACES\n" +
                    "WHERE PROVIDER_ID = '%s'";

    public static final String QUERY_GET_PROVIDER_INBOX =
            "SELECT \n" +
                    "  PROVKEY, \n" +
                    "  SID, \n" +
                    "  ACCOUNT, \n" +
                    "  PROVIDER_ID, \n" +
                    "  PROVIDER_ID_QLFR, \n" +
                    "  STX.LIB.GETMESSAGE(ERROR_CODE) AS ERROR_CODE, \n" +
                    "  COMPNAME, \n" +
                    "  E_MAIL, \n" +
                    "  PAYOR_ID, \n" +
                    "  PHONE, \n" +
                    "  ADDR1, \n" +
                    "  CITY, \n" +
                    "  STATE, \n" +
                    "  PROVIDER_BEG_DATE \n" +
                    "FROM \n" +
                    "  INBOX.PROVIDERS \n" +
                    "WHERE \n" +
                    "  PROVIDER_ID = '%s'";

    public static final String QUERY_TO_GET_JV_ADMIN_OF_SPECIFIC_ACCOUNT =
            "SELECT ACCOUNT,USERNAME,PASSWORD,DATA_SCOPE_ID,ACCOUNT_STATUS,USER_TYPE_ID,USER_ID,DELETED FROM STX.APP_USERS WHERE DATA_SCOPE_ID = '%s' AND USERNAME NOT LIKE 'JVADMIN%%'\n" +
                    "AND  ACCOUNT_STATUS = 'OPEN' AND ROWNUM = 1 AND EXPIRE_DATE > SYSDATE";

    public static final String QUERY_GET_AUTHORIZATION_INFO_WITH_SPECIFIC_AUTH_REF_NUM =
            "SELECT STX.LIB.GETMESSAGE(ERROR_CODE) as ERROR_CODE " +
                    "FROM INBOX.AUTHORIZATIONS\n" +
                    " WHERE AUTH_REF_NUMBER = '%s'";

    public static final String GET_AUTHORIZATION_IN_STX_TABLE =
            "SELECT \n" +
                    "  AUTH_ID, \n" +
                    "  AUTH_TYPE_ID, \n" +
                    "  AUTH_LIMIT_TYPE_ID, \n" +
                    "  BEG_DATE, \n" +
                    "  END_DATE, \n" +
                    "  ACCOUNT, \n" +
                    "  LOC, \n" +
                    "  CLIENT_ID_CUSTOM, \n" +
                    "  PAYOR_ID, \n" +
                    "  CONTRACT, \n" +
                    "  PROVIDER, \n" +
                    "  AUTH_REF_NUMBER, \n" +
                    "  AUTH_LIMIT_MAX, \n" +
                    "  MEMO, \n" +
                    "  DIAGNOSIS_CODE, \n" +
                    "  CASE_MANAGER_F_NAME, \n" +
                    "  CASE_MANAGER_L_NAME, \n" +
                    "  CASE_MANAGER_E_MAIL \n" +
                    "FROM \n" +
                    "  STX.AUTHORIZATIONS \n" +
                    "WHERE \n" +
                    "  AUTH_REF_NUMBER = '%s'\n";

    public static final String GET_DATA_SCOPE_ID =
            "SELECT DATA_SCOPE_ID FROM stx.ACCOUNTS_AUTO_PROVISION aapprovisi\n" +
                    "WHERE ACCOUNT_TEMPLATE = '%s'";

    public static final String GET_AUTHORIZATION_SERVICES_COMBINATION_FOR_PAYER =
            "SELECT DISTINCT PAYOR_ID, PROGRAM, PROC_CODE, MODIFIER1, MODIFIER2, MODIFIER3, MODIFIER4\n" +
                    "FROM stx.payor_data_validation pdv\n" +
                    "WHERE ACCOUNT = '%s' AND (SYSDATE BETWEEN beg_date AND end_date)";

    public static final String GET_UNIQUE_INDAY_VISIT_WITH_SPECIFIC_STATUS_ON_SPECIFIC_ACCOUNT =
            "SELECT v.VISITKEY, stx.lib.GetVisitStatus_custom(v.visitkey) AS VISIT_STATUS, TO_CHAR(v.VISIT_DATE, 'YYYY-MM-DD') AS VISIT_DATE, TO_CHAR(v.VISIT_EDATE, 'YYYY-MM-DD') AS VISIT_EDATE, TO_CHAR(v.BEG_CALL_DTIME, 'YYYY-MM-DD') AS BEG_CALL_DTIME, TO_CHAR(v.END_CALL_DTIME, 'YYYY-MM-DD') AS END_CALL_DTIME, v.SERVICE, v.PAYOR_ID, v.BILL_HOURS, v.ACCOUNT, cs.medicaid_id, stx.lib.getVisitBillUnits(v.visitkey) AS bill_units, v.VISIT_VERSION_NUMBER\n" +
                    "FROM stx.VISITS V, ( SELECT VISITKEY, VISIT_DATE, SERVICE, CLIENTKEY, VISIT_EDATE, WORKERKEY, BEG_ADJ_DTIME, BEG_CALL_DTIME, END_ADJ_DTIME, END_CALL_DTIME\n" +
                    "FROM stx.VISITS v\n" +
                    "WHERE rownum = 1\n" +
                    "AND ACCOUNT = '%s'\n" +
                    "AND lib.getvisitstatus_custom(VISITKEY) = '%s'\n" +
                    "AND BEG_ADJ_DTIME IS NOT NULL\n" +
                    "AND END_ADJ_DTIME IS NOT NULL\n" +
                    "AND v.BEG_CALL_DTIME IS NOT NULL\n" +
                    "AND v.END_CALL_DTIME IS NOT NULL\n" +
                    "GROUP BY VISITKEY, VISIT_DATE, SERVICE, CLIENTKEY, VISIT_EDATE, WORKERKEY, BEG_ADJ_DTIME, BEG_CALL_DTIME, END_ADJ_DTIME, END_CALL_DTIME\n" +
                    "HAVING COUNT (1) = 1\n" +
                    "ORDER BY VISIT_DATE DESC ) T1, stx.CLIENTS_SUPP cs\n" +
                    "WHERE V.CLIENTKEY = T1.CLIENTKEY\n" +
                    "AND V.VISIT_DATE = T1.VISIT_DATE\n" +
                    "AND V.VISITKEY = T1.VISITKEY\n" +
                    "AND cs.MEDICAID_ID IS NOT NULL\n" +
                    "AND cs.CLIENTKEY = T1.CLIENTKEY\n" +
                    "AND LENGTH (v.SERVICE) = 5";

    public static final String GET_VISIT_WITH_SPECIFIC_SERVICE =
            "SELECT v.VISITKEY, stx.lib.GetVisitStatus_custom(v.visitkey) AS VISIT_STATUS, \n" +
                    "  to_char(v.VISIT_DATE, 'YYYY-MM-DD') AS VISIT_DATE, \n" +
                    "  to_char(v.VISIT_EDATE, 'YYYY-MM-DD') AS VISIT_EDATE, \n" +
                    "  to_char(v.BEG_CALL_DTIME, 'YYYY-MM-DD') AS BEG_CALL_DTIME, \n" +
                    "  to_char(v.END_CALL_DTIME, 'YYYY-MM-DD') AS END_CALL_DTIME, \n" +
                    "  v.SERVICE, \n" +
                    "  v.PAYOR_ID, \n" +
                    "  v.BILL_HOURS, \n" +
                    "  v.ACCOUNT, \n" +
                    "  cs.medicaid_id, \n" +
                    "  stx.lib.getVisitBillUnits(v.visitkey) AS bill_units, v.VISIT_VERSION_NUMBER \n" +
                    "FROM stx.VISITS V, ( SELECT clientkey, VISIT_DATE, VISITKEY\n" +
                    "FROM stx.VISITS v\n" +
                    "WHERE rownum = 1\n" +
                    "AND PAYOR_ID = 'ODM'\n" +
                    "AND ACCOUNT = '%s'\n" +
                    "AND lib.getvisitstatus_custom(VISITKEY) = 'Processed'\n" +
                    "AND SERVICE = '%s'\n" +
                    "GROUP BY CLIENTKEY, VISIT_DATE, VISITKEY\n" +
                    "HAVING COUNT (1) = 1\n" +
                    "ORDER BY VISIT_DATE DESC ) T1, stx.CLIENTS_SUPP cs\n" +
                    "WHERE V.CLIENTKEY = T1.CLIENTKEY\n" +
                    "AND V.VISIT_DATE = T1.VISIT_DATE\n" +
                    "AND V.VISITKEY = T1.VISITKEY\n" +
                    "AND cs.MEDICAID_ID IS NOT NULL\n" +
                    "AND cs.CLIENTKEY = T1.CLIENTKEY\n" +
                    "AND v.BEG_CALL_DTIME IS NOT NULL\n" +
                    "AND v.END_CALL_DTIME IS NOT NULL";

    public static final String GET_PROVIDER_CREDENTIAL_BASED_ON_ACCOUNT =
            "SELECT\n" +
                    "avc.ws_authentication_username,\n" +
                    "avc.ws_authentication_pwd_hash,\n" +
                    "avc.account,\n" +
                    "ai.provider_id\n" +
                    "FROM\n" +
                    "stx.accounts_vendor_config avc\n" +
                    "JOIN\n" +
                    "stx.accounts_interfaces ai ON ai.account = avc.account\n" +
                    "WHERE ai.account = '%s' AND (end_date > sysdate OR end_date IS NULL)";

    public static final String GET_OMIT_OR_INCOMPLETE_VISITS =
            "SELECT v.VISITKEY,stx.lib.GetVisitStatus_custom(v.visitkey) AS VISIT_STATUS, TO_CHAR(v.VISIT_DATE, 'YYYY-MM-DD') AS VISIT_DATE, TO_CHAR(v.VISIT_EDATE, 'YYYY-MM-DD') AS VISIT_EDATE, TO_CHAR(v.BEG_CALL_DTIME, 'YYYY-MM-DD') AS BEG_CALL_DTIME, TO_CHAR(v.END_CALL_DTIME, 'YYYY-MM-DD') AS END_CALL_DTIME, v.SERVICE, v.PAYOR_ID, v.BILL_HOURS, v.ACCOUNT, cs.medicaid_id, stx.lib.getVisitBillUnits(v.visitkey) AS bill_units, v.VISIT_VERSION_NUMBER\n" +
                    "FROM stx.VISITS V, stx.CLIENTS_SUPP cs\n" +
                    "WHERE V.CLIENTKEY = CS.CLIENTKEY\n" +
                    "AND cs.MEDICAID_ID IS NOT NULL\n" +
                    "AND v.BEG_CALL_DTIME IS NOT NULL\n" +
                    "AND v.END_CALL_DTIME IS NOT NULL\n" +
                    "AND ACCOUNT = '%s'\n" +
                    "AND PAYOR_ID IS NOT NULL\n" +
                    "AND ROWNUM = 1" +
                    "AND stx.lib.getVisitBillUnits(v.visitkey) IS NOT NULL\n" +
                    "AND stx.lib.GetVisitStatus_custom(v.visitkey) IN ('Incomplete','Omit')\n";

    public static final String GET_VISIT_BASED_ON_VISIT_KEY =
            "SELECT v.VISITKEY, stx.lib.GetVisitStatus_custom(v.visitkey) AS VISIT_STATUS, TO_CHAR(v.VISIT_DATE, 'YYYY-MM-DD') AS VISIT_DATE, TO_CHAR(v.VISIT_EDATE, 'YYYY-MM-DD') AS VISIT_EDATE, TO_CHAR(v.BEG_CALL_DTIME, 'YYYY-MM-DD') AS BEG_CALL_DTIME, TO_CHAR(v.END_CALL_DTIME, 'YYYY-MM-DD') AS END_CALL_DTIME, v.SERVICE, v.PAYOR_ID, v.BILL_HOURS, v.ACCOUNT, cs.medicaid_id, stx.lib.getVisitBillUnits(v.visitkey) AS bill_units, v.VISIT_VERSION_NUMBER\n" +
                    "FROM stx.VISITS V\n" +
                    "INNER JOIN STX.CLIENTS_SUPP cs ON\n" +
                    "cs.CLIENTKEY = v.CLIENTKEY\n" +
                    "WHERE V.VISITKEY = '%s'";

    public static final String COUNT_AUTH_IN_STAGING_BY_COMMENT =
            "SELECT count(*) rows\n" +
                    "FROM intfstagedb.auth au\n" +
                    "WHERE au.auth_cmnt = '%s' and au.status_code in (1,2,3)";

    public static final String GET_ENTITY_GUID_BY_GROUPKEY = "SELECT BE_GUID, WS_AUTHENTICATION_USERNAME, WS_AUTHENTICATION_PWD_HASH FROM stx.BE_SETUP WHERE GROUPKEY = '%s'";
}
