package com.interop.sql;

public class ClientSQL {
    public static final String SQL_GET_CLIENT_ELIG = "select case when author.payor_id is null then supp.contract\n" +
            "else author.payor_id end as PayerID, accinf.provider_id as ProviderID,\n" +
            "client.loc as ClientID, authlimit.program as PayerProgram,\n" +
            "to_char(from_tz(cast(authlimit.beg_time as timestamp), 'US/Eastern') at time zone 'UTC',\n" +
            "'YYYY-MM-dd') as ClientEligibilityDateBegin,\n" +
            "to_char(from_tz(cast(authlimit.end_time as timestamp), 'US/Eastern') at time zone 'UTC',\n" +
            "'YYYY-MM-dd') as ClientEligibilityDateEnd,\n" +
            "to_char(from_tz(cast(author.beg_date as timestamp), 'US/Eastern') at time zone 'UTC',\n" +
            "'YYYY-MM-dd') as ClientStartOfCareDate, \n" +
            "to_char(from_tz(cast(author.end_date as timestamp), 'US/Eastern') at time zone 'UTC',\n" +
            "'YYYY-MM-dd') as ClientEndOfCareDate \n" +
            "FROM STX.CLIENTS client\n" +
            "LEFT JOIN STX.authorizations author ON author.LOC = client.LOC\n" +
            "LEFT JOIN STX.accounts_interfaces accinf ON accinf.ACCOUNT = client.ACCOUNT\n" +
            "LEFT JOIN STX.auth_limits authlimit ON authlimit.AUTH_ID = author.AUTH_ID\n" +
            "JOIN STX.CLIENTS_SUPP supp ON supp.CLIENTKEY = client.CLIENTKEY\n" +
            "WHERE client.ACCOUNT LIKE '%s'\n" +
            "AND client.F_NAME LIKE '%s' and client.L_NAME LIKE '%s'";

    public static final String SQL_GET_CLIENT_DIAG = "SELECT author.payor_id as PayerID, accinf.provider_id as ProviderID,\n" +
            "author.loc as ClientID, \n" +
            "case when author.diagnosis_code = '1' then 'true'\n" +
            "else 'false'\n" +
            "end as IsPrimary,\n" +
            "author.diagnosis_code as DiagnosisCode\n" +
            "FROM STX.CLIENTS client\n" +
            "LEFT JOIN STX.authorizations author ON author.LOC = client.LOC\n" +
            "LEFT JOIN STX.accounts_interfaces accinf ON accinf.ACCOUNT = client.ACCOUNT\n" +
            "WHERE client.ACCOUNT LIKE '%s'\n" +
            "AND client.F_NAME LIKE '%s' and client.L_NAME LIKE '%s'";

    public static final String SQL_GET_CLIENT_ACCOUNT =
            "SELECT LOC, F_NAME, L_NAME " +
                    "FROM stx.clients " +
                    "WHERE F_NAME = '%s' and account='%s'";

    public static final String SQL_GET_CLIENTS_BY_CLIENTID = "SELECT LOC FROM STX.CLIENTS WHERE ACCOUNT = '%s' AND LOC in (%s)";
    public static final String SQL_GET_CLIENTS_BY_FIRSTNAMES = "SELECT LOC FROM STX.CLIENTS WHERE ACCOUNT = '%s' AND F_NAME in (%s)";
    public static final String SQL_GET_CLIENT_BY_MEDICAID_ID = "SELECT CL.CLIENTKEY AS CLIENTKEY FROM STX.CLIENTS CL JOIN STX.CLIENTS_SUPP CLS ON CL.CLIENTKEY = CLS.CLIENTKEY WHERE CL.ACCOUNT = '%s' AND CLS.MEDICAID_ID = '%s'";
    public static final String SQL_GET_CLIENT_ID_CUSTOMER1 = "SELECT CL.CLIENTKEY AS CLIENTKEY FROM STX.CLIENTS CL JOIN STX.CLIENTS_SUPP CLS ON CL.CLIENTKEY = CLS.CLIENTKEY WHERE CL.ACCOUNT = '%s' AND CLS.CLIENT_ID_CUSTOM1 = '%s'";
    public static final String SQL_GET_CLIENT_ID_CUSOTMER2 = "SELECT CLIENTKEY FROM STX.CLIENTS_SUPP WHERE CLIENT_ID_CUSTOM2 = '%s'";
    public static final String SQL_GET_CLIENT_BY_FNAME = "SELECT CLIENTKEY FROM STX.CLIENTS WHERE ACCOUNT = '%s' AND F_NAME = '%s'";
    public static final String SQL_GET_CLIENT_BY_LNAME = "SELECT CLIENTKEY FROM STX.CLIENTS WHERE ACCOUNT = '%s' AND L_NAME = '%s'";

    public static final String SQL_GET_CLIENT_BY_FNAMES = "SELECT F_NAME FROM STX.CLIENTS WHERE ACCOUNT = '%s' AND F_NAME in (%s)";
    public static final String SQL_GET_CLIENT_BY_LNAMES = "SELECT L_NAME FROM STX.CLIENTS WHERE ACCOUNT = '%s' AND L_NAME in (%s)";
    public static final String sql_getMedicaids = "SELECT CLS.MEDICAID_ID AS MEDICAID_ID FROM STX.CLIENTS CL JOIN STX.CLIENTS_SUPP CLS ON CL.CLIENTKEY = CLS.CLIENTKEY \n" +
            "WHERE CL.ACCOUNT = '%s' AND CLS.MEDICAID_ID IN (%s) GROUP BY CLS.MEDICAID_ID";

    public static final String SQL_GET_CLIENT_BY_SEQUENCE_NUMBER = "SELECT CLIENTKEY FROM STX.clients WHERE ACCOUNT = '%s' AND client_version_number = '%s'";

    public static final String SQL_GET_CLIENTS_BY_F_NAMES = "SELECT \tCL.F_NAME, CL.L_NAME, CL.LOC, \n" +
            "\t\tAU.PAYOR_ID, AU.CONTRACT, AU.PROVIDER, AU.AUTH_REF_NUMBER, \n" +
            "\t\tCLS.CLIENT_SSN, CLS.CLIENT_ID_CUSTOM1, CLS.CLIENT_ID_CUSTOM2, CLS.MEDICAID_ID FROM STX.CLIENTS CL \n" +
            "JOIN STX.AUTHORIZATIONS AU ON AU.LOC = CL.LOC\n" +
            "JOIN STX.CLIENTS_SUPP CLS ON CL.CLIENTKEY = CLS.CLIENTKEY\n" +
            "WHERE CL.ACCOUNT = '%s' \n" +
            "\tAND CL.F_NAME IN (%s)";

    public static final String SQL_GET_CLIENT_BY_LOC = "SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tSTX.CLIENTS CL\n" +
            "INNER JOIN STX.CLIENTS_CONTACT CLC  ON\n" +
            "\tCL.LOC = CLC.LOC\n" +
            "WHERE\n" +
            "\tCL.ACCOUNT = '%s'\n" +
            "\tAND CL.LOC = '%s'";
    public static final String SQL_GET_CLIENT_BY_SSN = "SELECT * FROM STX.CLIENTS_SUPP WHERE CLIENTKEY IN \n" +
            "(SELECT CLIENTKEY FROM STX.CLIENTS WHERE ACCOUNT = '%s' AND LOC <> '%s') AND CLIENT_SSN = '%s'";

    public static final String SQL_GET_CLIENT_BY_SSN_ONLY = "SELECT * FROM STX.CLIENTS_SUPP WHERE CLIENTKEY IN \n" +
            "(SELECT CLIENTKEY FROM STX.CLIENTS WHERE ACCOUNT = '%s') AND CLIENT_SSN = '%s'";

    public static final String SQL_GET_CLIENT_BY_LASTNAME = "SELECT * FROM STX.CLIENTS WHERE ACCOUNT='%s' AND L_NAME = '%s'";

    public static final String SQL_GET_CLIENT_ERROR_CODE_BY_LASTNAME = "SELECT * FROM INBOX.CLIENTS WHERE ACCOUNT='%s' AND L_NAME = '%s' AND ERROR_CODE = '-1053'";

    public static final String SQL_GET_CLIENT_SCHEDULE_BY_ACC_AND_COLUMN_VALUE = "select \n" +
            "sch.contract as \"PayerID\",\n" +
            "accinf.provider_id as \"ProviderID\",\n" +
            "cast(sch.loc as varchar(20)) as \"ClientID\",\n" +
            "cast(sch.stx_id as varchar(20)) as \"EmployeeID\",\n" +
            "cast(sch.schkey as varchar(20)) as \"ScheduleID\",\n" +
            "to_char(from_tz(cast(sch.b_dtime as timestamp), 'US/Eastern'), 'YYYY-MM-DD') as \"ScheduleStartDate\",\n" +
            "to_char(from_tz(cast(sch.b_dtime as timestamp), 'US/Eastern'), 'yyyy-MM-dd\"T\"HH24:MI:SS\"Z\"') as \"ScheduleStartTime\",\n" +
            "to_char(from_tz(cast(sch.e_dtime as timestamp), 'US/Eastern'), 'yyyy-MM-dd\"T\"HH24:MI:SS\"Z\"') as \"ScheduleEndTime\",\n" +
            "cast(sch.payrate as varchar(20)) as \"PayRate\",\n" +
            "cast(sch.billrate as varchar(20)) as \"BillRate\",\n" +
            "cast(sch.flag as varchar(20)) as \"ClusterCaseFlag\",\n" +
            "cast(sch.discipline as varchar(20)) as \"Discipline\",\n" +
            "cast(sch.PROGRAM as varchar(20)) as \"PayerProgram\",\n" +
            "cast(sch.service as varchar(20)) as \"PayerService\",\n" +
            "cast(sch.visit_type as varchar(20)) as \"VisitType\",\n" +
            "cast(sch.li_case as varchar(20)) as \"LiveInCase\",\n" +
            "cast(sch.tzname as varchar(20)) as \"ScheduleTimeZone\",\n" +
            "cast(sch.proc_code_qualifier as varchar(20)) as \"ProcCodeQualifier\",\n" +
            "cast(sch.modifier1 as varchar(20)) as \"Modifier1\",\n" +
            "cast(sch.modifier2 as varchar(20)) as \"Modifier2\",\n" +
            "cast(sch.modifier3 as varchar(20)) as \"Modifier3\",\n" +
            "cast(sch.modifier4 as varchar(20)) as \"Modifier4\",\n" +
            "'not yet implement script Query' as \"ScheduleDuration\"\n" +
            "from stx.schedule sch\n" +
            "LEFT JOIN STX.accounts_interfaces accinf ON accinf.ACCOUNT = sch.ACCOUNT\n" +
            "where sch.account = '%s' and sch.%s in (%s)";

    public static final String SQL_GET_CLIENT_SCHEDULE = "select schel.contract as PayerID, accinterface.provider_id as ProviderID,\n" +
            "schel.loc as ClientID, schel.stx_id as EmployeeID, to_char(schel.schkey) as ScheduleID,\n" +
            "to_char(from_tz(cast(schel.b_dtime as timestamp), 'EST') at time zone 'UTC', 'yyyy-MM-dd') as ScheduleStartDate,\n" +
            "to_char(from_tz(cast(schel.b_dtime as timestamp), 'EST') at time zone 'UTC', 'yyyy-MM-dd\"T\"HH24:MI:SS\"Z\"') as ScheduleStartTime,\n" +
            "to_char(from_tz(cast(schel.e_dtime as timestamp), 'EST') at time zone 'UTC', 'yyyy-MM-dd\"T\"HH24:MI:SS\"Z\"') as ScheduleEndTime,\n" +
            "schel.payrate as PayRate, schel.billrate as BillRate, \n" +
            "case when schel.flag is null then null else 'true'\n" +
            "end as ClusterCaseFlag,\n" +
            "schel.discipline as Discipline, schel.program as PayerProgram, \n" +
            "schel.service as PayerService, schel.visit_type as VisitType, \n" +
            "case when schel.li_case is null then null else 'true' end as LiveInCase,\n" +
            "case when schel.tzname is null then null else schel.tzname end as ScheduleTimeZone,\n" +
            "schel.proc_code_qualifier as ProcCodeQualifier, schel.modifier1 as Modifier1,\n" +
            "schel.modifier2 as Modifier2, schel.modifier3 as Modifier3, schel.modifier4 as Modifier4\n" +
            "from stx.clients client\n" +
            "left join stx.schedule schel on schel.loc = client.loc\n" +
            "left join stx.Accounts_Interfaces accinterface on accinterface.account = client.account\n" +
            "where client.account = '%s' and client.f_name = '%s' and client.l_name = '%s'\n";

    public static final String SQL_CLIENT_GENERAL = "SELECT * FROM STX.CLIENTS CL, STX.CLIENTS_SUPP CS \n" +
            "WHERE ACCOUNT='%s' AND L_NAME='%s' \n" +
            "AND CL.CLIENTKEY = CS.CLIENTKEY";

    public static final String SQL_GET_CLIENT_AUTH = "select author.payor_id as PayerID, accinf.provider_id as ProviderID,\n" +
            "author.loc as ClientID, authlimit.program as PayerProgram,\n" +
            "author.client_id_custom as ClientPayerID, supp.region as PayerRegion,\n" +
            "authlimit.service as PayerService, authlimit.modifier1 as Modifier1,\n" +
            "authlimit.modifier2 as Modifier2, authlimit.modifier3 as Modifier3,\n" +
            "authlimit.modifier4 as Modifier4, \n" +
            "to_char(from_tz(cast(authlimit.beg_time as timestamp), 'EST') at time zone 'UTC', 'yyyy-MM-dd') as ClientEligibilityDateBegin,\n" +
            "to_char(from_tz(cast(authlimit.end_time as timestamp), 'EST') at time zone 'UTC', 'yyyy-MM-dd') as ClientEligibilityDateEnd,\n" +
            "to_char(from_tz(cast(author.beg_date as timestamp), 'EST') at time zone 'UTC', 'yyyy-MM-dd') as ClientStartOfCareDate,\n" +
            "to_char(from_tz(cast(author.end_date as timestamp), 'EST') at time zone 'UTC', 'yyyy-MM-dd') as ClientEndOfCareDate,\n" +
            "to_char(from_tz(cast(author.end_date as timestamp), 'EST') at time zone 'UTC', 'yyyy-MM-dd') as ClientStatusDate,\n" +
            "case when (author.diagnosis_code <> supp.diagnosis_code) then 'false' else 'true' end as IsPrimary,\n" +
            "author.diagnosis_code as DiagnosisCode\n" +
            "from stx.clients client\n" +
            "LEFT JOIN stx.authorizations author ON author.LOC = client.LOC\n" +
            "LEFT JOIN STX.accounts_interfaces accinf ON accinf.ACCOUNT = client.ACCOUNT\n" +
            "LEFT JOIN STX.auth_limits authlimit ON authlimit.AUTH_ID = author.AUTH_ID\n" +
            "JOIN STX.CLIENTS_SUPP supp ON supp.CLIENTKEY = client.CLIENTKEY\n" +
            "where client.account = '%s' and client.f_name = '%s' and client.l_name = '%s'\n";

    public static final String SQL_SELECT_CLIENT_BASIC_INFO_AND_SUPP = "--1. SELECT BASIC CLIENT INFO\n" +
            "SELECT \t\n" +
            "-- BASIC CLIENT INFORMATION & CLIENTS_SUPP\n" +
            "CL.ACCOUNT AS CL_ACCOUNT, CL.LOC AS CL_LOC, CL.CLIENTKEY AS CL_CLIENTKEY, CL.F_NAME AS CL_F_NAME, \n" +
            "CL.M_NAME AS CL_M_NAME, CL.L_NAME AS CL_L_NAME, CL.NAME_SUFFIX AS CL_NAME_SUFFIX, \n" +
            "CL.SPV_E_MAIL AS CL_SPV_E_MAIL, CL.TZNAME AS CL_TZNAME,\n" +
            "-- CLIENTS_SUPP\n" +
            "CLS.ADDR1 AS CLS_ADDR1, CLS.ADDR2 AS CLS_ADDR2, CLS.CITY AS CLS_CITY, CLS.STATE AS CLS_STATE, CLS.ZIP_CODE AS CLS_ZIP_CODE, CLS.COUNTY AS CLS_COUNTY, CLS.ADDR_TYPE_QLFR AS CLS_ADDR_TYPE_QLFR," +
            "CLS.CLIENT_SSN AS CLS_CLIENT_SSN, CLS.CLIENT_ID_CUSTOM1 AS CLS_CLIENT_ID_CUSTOM1, CLS.CLIENT_ID_CUSTOM2 AS CLS_CLIENT_ID_CUSTOM2, \n" +
            "CLS.MEDICAID_ID AS CLS_MEDICAID_ID, CLS.MRN AS CLS_MRN, CLS.CONTRACT AS CLS_CONTRACT, CLS.REGION AS CLS_REGION, \n" +
            "CLS.CASE_MANAGER AS CLS_CASE_MANAGER, CLS.LANGUAGE AS CLS_LANGUAGE, \n" +
            "CLS.SEX AS CLS_SEX, CLS.marital_status_code AS CLS_MARITAL_STATUS_CODE, CLS.dob AS CLS_DOB, CLS.e_mail AS CLS_EMAIL, \n" +
            "CLS.client_priority AS CLS_CLIENT_PRIORITY\n" +
            "\n" +
            "FROM STX.CLIENTS CL \n" +
            "JOIN STX.CLIENTS_SUPP CLS ON CL.CLIENTKEY = CLS.CLIENTKEY\n" +
            "WHERE CL.ACCOUNT = '%s' AND CL.LOC in (%s)";
    public static final String SQL_SELECT_CLIENT_AUTH_AND_AUTH_LIMIT = "SELECT \t\n" +
            "-- AUTHORIZATION & AUTH_LIMITS\n" +
            "AU.PAYOR_ID AS AU_PAYOR_ID, AU.CONTRACT AS AU_CONTRACT, AU.PROVIDER AS AU_PROVIDER, AU.AUTH_REF_NUMBER AS AU_AUTH_REF_NUMBER, AU.BEG_DATE AS AU_BEG_DATE, \n" +
            "AU.END_DATE AS AU_END_DATE, AU.diagnosis_code AS AU_DIAGNOSIS_CODE,\n" +
            "-- AUTH_LIMITS\n" +
            "AL.PROGRAM AS AL_PROGRAM, AL.SERVICE AS AL_SERVICE, AL.MODIFIER1 AS AL_MODIFIER1, AL.MODIFIER2 AS AL_MODIFIER2, AL.MODIFIER3 AS AL_MODIFIER3, AL.MODIFIER4 AS AL_MODIFIER4, \n" +
            "AL.BEG_TIME AS AL_BEG_TIME, AL.END_TIME AS AL_END_TIME\n" +
            "\n" +
            "FROM STX.CLIENTS CL \n" +
            "JOIN STX.AUTHORIZATIONS AU ON AU.LOC = CL.LOC\n" +
            "JOIN STX.AUTH_LIMITS AL ON AU.AUTH_ID = AL.AUTH_ID\n" +
            "WHERE CL.ACCOUNT = '%s' AND CL.LOC in (%s)";
    public static final String SQL_SELECT_CLIENT_ADDRESSES = "SELECT \t\n" +
            "-- CLIENTS_ADDRESS\t\t\n" +
            "CLA.ADDR1 AS CLA_ADDR1, CLA.ADDR2 AS CLA_ADDR2, CLA.CITY AS CLA_CITY, CLA.COUNTY AS CLA_COUNTY, CLA.state AS CLA_STATE, \n" +
            "CLA.ZIP_CODE AS CLA_ZIP_CODE, CLA.LATITUDE AS CLA_LATITUDE, CLA.LONGITUDE AS CLA_LONGITUDE, CLA.ADDR_TYPE_QLFR AS CLA_ADDR_TYPE_QLFR\n" +
            "\n" +
            "FROM STX.CLIENTS CL \n" +
            "JOIN STX.CLIENTS_ADDRESS CLA ON CLA.CLIENTKEY = CL.CLIENTKEY\n" +
            "WHERE CL.ACCOUNT = '%s' AND CL.LOC in (%s)";
    public static final String SQL_SELECT_CLIENT_CONTACTS = "SELECT\n" +
            "-- CLIENTS_CONTACT\n" +
            "CLC.CLIENTKEY AS CLC_CLIENTKEY, CLC.contact_type_code AS CLC_CONTACT_TYPE_CODE, CLC.F_NAME AS CLC_F_NAME, \n" +
            "CLC.L_NAME AS CLC_L_NAME, CLC.ADDR1 AS CLC_ADDR1, CLC.ADDR2 AS CLC_ADDR2, CLC.LOC,\n" +
            "CLC.CITY AS CLC_CITY, CLC.STATE AS CLC_STATE, CLC.ZIP_CODE AS CLC_ZIPCODE, CLC.PHONENUM_HOME AS CLC_PHONENUM_HOME, \n" +
            "CLC.PHONENUM_BUSINESS AS CLC_PHONENUM_BUSINESS, \n" +
            "CLC.PHONENUM_MOBILE AS CLC_PHONENUM_MOBILE, CLC.PHONENUM_OTHER AS CLC_PHONENUM_OTHER, CLC.E_MAIL AS CLC_E_MAIL,\n" +
            "CASE\n" +
            "WHEN CLC.END_DATE>SYSDATE THEN '02'\n" +
            "ELSE '04'\n" +
            "END CLC_STATUS\n" +
            "FROM STX.CLIENTS CL \n" +
            "JOIN STX.CLIENTS_CONTACT CLC ON CLC.CLIENTKEY = CL.CLIENTKEY\n" +
            "WHERE CL.ACCOUNT = '%s' AND CL.LOC in (%s)";

    public static final String SQL_SELECT_CLIENT_DESIGNEE = "SELECT  auc.loc,\n" +
            "u.user_f_name\n" +
            ",u.user_l_name\n" +
            ",u.username\n" +
            ",CASE WHEN u.account_status='OPEN' THEN '02' ELSE '04' END as  designee_status\n" +
            ",u.created\n" +
            ",LEAST(nvl(u.lock_date,to_date('2099-12-31','YYYY-mm-dd')), \n" +
            "nvl(u.expire_date,to_date('2099-12-31','YYYY-mm-dd')),nvl(u.deleted,to_date('2099-12-31','YYYY-mm-dd'))) AS designee_end\n" +
            ",cc.contact_relationship\n" +
            "FROM\n" +
            "stx.app_users_cli auc\n" +
            "INNER JOIN\n" +
            "stx.app_users u ON u.user_id = auc.user_id\n" +
            "INNER JOIN\n" +
            "stx.clients_contact cc ON auc.account = cc.account AND auc.loc = cc.loc AND UPPER(u.user_f_name) = UPPER(cc.f_name) AND UPPER(u.user_l_name) = UPPER(cc.l_name)\n" +
            "WHERE\n" +
            "\n" +
            " cc.contact_type_code = 'CD'\n" +
            "AND auc.account = '%s'\n" +
            "AND auc.loc in (%s)";

    public static final String SQL_SELECT_CLIENT_ANI = "SELECT \t\n" +
            "-- ANI\n" +
            "CL.CLIENTKEY AS CL_CLIENTKEY, CL.LOC AS CL_LOC, AN.description AS AN_DESCRIPTION, AN.ANI AS ANI_ANI\n" +
            "FROM STX.CLIENTS CL \n" +
            "JOIN STX.ANI AN ON AN.CLIENTKEY = CL.CLIENTKEY\n" +
            "WHERE CL.ACCOUNT = '%s' AND CL.LOC in (%s)";
    public static final String SQL_SELECT_CLIENT_APP_USERS = "SELECT \t\n" +
            "-- APP_USERS\n" +
            "APP_U.user_f_name AS APP_U_USER_F_NAME, APP_U.user_l_name AS APP_U_USER_L_NAME, APP_U.username AS APP_U_USERNAME, \n" +
            "APP_U.account_status AS APP_U_ACCOUNT_STATUS, \n" +
            "APP_U.insert_tmstp AS APP_U_INSERT_TMSTP, \n" +
            "APP_U.DESCRIPTION AS APP_U_DESCRIPTION, APP_U.EXPIRE_DATE AS APP_U_EXPIRE_DATE, APP_U.LOCK_DATE AS APP_U_LOCK_DATE, APP_U.CREATED AS APP_U_CREATED, \n" +
            "APP_U.DELETED AS APP_U_DELETED, APP_U.USER_TYPE_ID AS APP_U_USER_TYPE_ID\n" +
            "\n" +
            "FROM STX.CLIENTS CL \n" +
            "JOIN STX.CLIENTS_SUPP CLS ON CL.CLIENTKEY = CLS.CLIENTKEY\n" +
            "JOIN STX.APP_USERS APP_U ON APP_U.ACCOUNT = CL.ACCOUNT AND APP_U.USERNAME = CLS.E_MAIL\n" +
            "WHERE CL.ACCOUNT = '%s' AND CL.LOC in (%s)";
    public static final String SQL_SELECT_CLIENT_XREF = "--7. XREF\n" +
            "select \tXREF.BEG_DATE AS XREF_BEG_DATE,  \n" +
            "\t\tXREF.END_DATE AS XREF_END_DATE, \n" +
            "\t\tXREF.ACCOUNT AS XREF_ACCOUNT, \n" +
            "\t\tXREF.LOC AS XREF_LOC, \n" +
            "\t\tXREF.STX_ID AS XREF_STX_ID,\n" +
            "\t\tXREF.SERVICE AS XREF_SERVICE\n" +
            "from stx.XREF_SERVICES XREF where ACCOUNT = '%s' AND LOC in (%s)";

    public static final String SQL_CLIENT_ALT_EVV_GENERIC = "select LOC as CLIENT_ID, su.MEDICAID_ID, " +
            "su.CLIENT_ID_CUSTOM1, su.CLIENT_ID_CUSTOM2 FROM STX.CLIENTS cl INNER JOIN STX.CLIENTS_SUPP su \n" +
            "on cl.CLIENTKEY = su.CLIENTKEY\n" +
            "AND cl.end_date > sysdate\n" +
            "AND cl.ACCOUNT = '%s'\n" +
            "AND su.CLIENT_ID_CUSTOM1 IS NOT NULL " +
            "AND LENGTH(TRIM(TRANSLATE(su.CLIENT_ID_CUSTOM1 , ' +-.0123456789',' '))) IS NULL " +
            "AND ROWNUM <= 100";

    public static final String SQL_CLIENT_ALT_EVV_WISCONSIN = "select LOC as CLIENT_ID, su.MEDICAID_ID, " +
            "su.CLIENT_ID_CUSTOM1, su.CLIENT_ID_CUSTOM2 FROM STX.CLIENTS cl INNER JOIN STX.CLIENTS_SUPP su \n" +
            "on cl.CLIENTKEY = su.CLIENTKEY\n" +
            "AND cl.end_date > sysdate\n" +
            "AND cl.ACCOUNT = '%s'\n" +
            "AND su.CLIENT_ID_CUSTOM1 IS NOT NULL " +
            "AND LENGTH(TRIM(TRANSLATE(su.CLIENT_ID_CUSTOM1 , ' +-.0123456789',' '))) IS NULL " +
            "AND ROWNUM <= 100";

    public static final String SQL_CLIENT_ALT_EVV_PENNSYLVANIA = "select LOC as CLIENT_ID, su.MEDICAID_ID, " +
            "su.CLIENT_ID_CUSTOM1, su.CLIENT_ID_CUSTOM2 FROM STX.CLIENTS cl INNER JOIN STX.CLIENTS_SUPP su \n" +
            "on cl.CLIENTKEY = su.CLIENTKEY\n" +
            "AND cl.end_date > sysdate\n" +
            "AND cl.ACCOUNT = '60138'\n" +
            "AND su.CLIENT_ID_CUSTOM1 IS NOT NULL " +
            "AND REGEXP_LIKE (su.CLIENT_ID_CUSTOM1, '^(([a-zA-Z0-9]{6})|(0000\\\\d{5}))$') " +
            "AND ROWNUM <= 100";

    public static final String SQL_CLIENT_OPEN_EVV_GENERIC = "select LOC as CLIENT_ID, su.MEDICAID_ID, " +
            "su.CLIENT_ID_CUSTOM1, su.CLIENT_ID_CUSTOM2 FROM STX.CLIENTS cl INNER JOIN STX.CLIENTS_SUPP su \n" +
            "on cl.CLIENTKEY = su.CLIENTKEY\n" +
            "AND cl.end_date > sysdate\n" +
            "AND cl.ACCOUNT = '%s'\n" +
            "AND LENGTH(LOC)=10 AND LENGTH(TRIM(TRANSLATE(LOC , ' +-.0123456789',' '))) IS NULL " +
            "AND ROWNUM <= 100";

    public static final String SQL_CLIENT_CUSTOM_ID = "select LOC as CLIENT_ID, su.MEDICAID_ID, su.CLIENT_ID_CUSTOM1, su.CLIENT_ID_CUSTOM2 FROM STX.CLIENTS cl INNER JOIN STX.CLIENTS_SUPP su \n" +
            "on cl.CLIENTKEY = su.CLIENTKEY\n" +
            "AND cl.end_date > sysdate\n" +
            "AND cl.ACCOUNT = '%s'\n" +
            "AND su.CLIENT_ID_CUSTOM1 IS NOT NULL AND REGEXP_LIKE (su.CLIENT_ID_CUSTOM1, '^[A-Z]\\d(8)') AND \n" +
            "LENGTH(su.CLIENT_ID_CUSTOM1) = 9\n" +
            "AND ROWNUM <= 100\n";

    public static final String SQL_CLIENT_CONNECTICUT_OPEN_EVV = "select LOC as Client_ID, " +
            "su.MEDICAID_ID, su.CLIENT_ID_CUSTOM1 " +
            "FROM STX.CLIENTS cl INNER JOIN STX.CLIENTS_SUPP su \n" +
            "on cl.CLIENTKEY = su.CLIENTKEY\n" +
            "AND cl.end_date > sysdate " +
            "AND cl.ACCOUNT = '%s' " +
            "AND su.CLIENT_ID_CUSTOM1 IS NOT NULL " +
            "AND LENGTH(TRIM(TRANSLATE(su.CLIENT_ID_CUSTOM1 , ' +-.0123456789',' '))) IS NULL " +
            "AND LENGTH(LOC) < 6 " +
            "AND ROWNUM <= 100";
    public static final String SQL_CLIENT_OPEN_EVV = "select LOC as Client_ID, " +
            "su.MEDICAID_ID, su.CLIENT_ID_CUSTOM1 " +
            "FROM STX.CLIENTS cl INNER JOIN STX.CLIENTS_SUPP su \n" +
            "on cl.CLIENTKEY = su.CLIENTKEY\n" +
            "AND cl.end_date > sysdate " +
            "AND cl.ACCOUNT = '%s' " +
            "AND su.CLIENT_ID_CUSTOM1 IS NOT NULL " +
            "AND LENGTH(TRIM(TRANSLATE(su.CLIENT_ID_CUSTOM1 , ' +-.0123456789',' '))) IS NULL " +
            "AND ROWNUM <= 100";

    public static final String SQL_CLIENT_ALT_EVV_GENERIC_COLORADO = "select LOC as CLIENT_ID, " +
            "su.MEDICAID_ID, su.CLIENT_ID_CUSTOM1, su.CLIENT_ID_CUSTOM2 " +
            "FROM STX.CLIENTS cl, STX.CLIENTS_SUPP su \n" +
            "WHERE cl.ACCOUNT = '%s' AND cl.CLIENTKEY = su.CLIENTKEY\n" +
            "AND su.CLIENT_ID_CUSTOM2 IS NOT NULL " +
            "AND cl.end_date > sysdate " +
            "AND ROWNUM <= 100 ";

    public static final String SQL_CLIENT_ALT_EVV_GENERIC_ARIZONA = "SELECT LOC as CLIENT_ID, su.MEDICAID_ID, " +
            "su.CLIENT_ID_CUSTOM1, su.CLIENT_ID_CUSTOM2, cl.ACCOUNT \n" +
            "FROM STX.CLIENTS cl\n" +
            "JOIN STX.CLIENTS_SUPP su ON cl.CLIENTKEY = su.CLIENTKEY \n" +
            "WHERE cl.ACCOUNT = '%s' AND REGEXP_LIKE (su.CLIENT_ID_CUSTOM1, '^[A-Z]\\d(8)')";

    public static final String SQL_STX_CLIENT = "Select * from stx.Clients cl, STX.CLIENTS_SUPP su " +
            "where cl.account = '%s' and cl.L_Name = '%s' and cl.F_Name = '%s' " +
            "AND cl.END_DATE >= TO_DATE('2999-12-31','YYYY-MM-DD') " +
            "AND cl.CLIENTKEY = su.CLIENTKEY";

    public static final String SQL_STX_CLIENT_COUNT = "Select count(*) AS rowCount from stx.Clients where account = '%s' and L_Name = '%s' " +
            "and F_Name = '%s' AND END_DATE >= TO_DATE('2999-12-31','YYYY-MM-DD')";

    public static final String sql_clientByFName = "Select * from stx.Clients where F_Name in (%s) and account = '%s'";

    public static final String SQL_CLIENT_WITH_ROW_NUM =
            "SELECT *  \n" +
                    "            FROM STX.CLIENTS cl, STX.CLIENTS_SUPP su  \n" +
                    "            WHERE cl.ACCOUNT = '%s'  AND cl.end_date > sysdate AND cl.CLIENTKEY = su.CLIENTKEY AND su.CLIENT_ID_CUSTOM1 IS NOT NULL\n" +
                    "            AND ROWNUM <= %s";

    public static final String SQL_STX_GET_LOC_CLIENT = "SELECT cl.LOC, su.MEDICAID_ID, su.CLIENT_ID_CUSTOM1 \n" +
            "            FROM STX.CLIENTS cl, STX.CLIENTS_SUPP su  \n" +
            "            WHERE cl.ACCOUNT = '%s'  AND cl.F_Name = '%s' AND cl.end_date > sysdate AND cl.CLIENTKEY = su.CLIENTKEY \n" +
            "            AND ROWNUM <= 1";

    public static final String SQL_SCHEDULE_WITH_ROW_NUM = "SELECT count(*) as COUNTNUM FROM STX.SCHEDULE WHERE STX_ID = '%s' AND ACCOUNT = '%s'";

    public static final String sql_getClientCustom1ByFirstName = "select su.CLIENT_ID_CUSTOM1, su.MEDICAID_ID FROM STX.CLIENTS cl INNER JOIN STX.CLIENTS_SUPP su \n" +
            "on cl.CLIENTKEY = su.CLIENTKEY\n" +
            "AND cl.end_date > sysdate AND cl.ACCOUNT = '%s' AND cl.F_NAME = '%s'";

    public static final String sql_getClientCustom1ByLastName = "select su.CLIENT_ID_CUSTOM1, su.MEDICAID_ID FROM STX.CLIENTS cl INNER JOIN STX.CLIENTS_SUPP su \n" +
            "on cl.CLIENTKEY = su.CLIENTKEY\n" +
            "AND cl.end_date > sysdate AND cl.ACCOUNT = '%s' AND cl.L_NAME = '%s'";


    public static final String sql_getClientCustom1ByMedicaidId = "select su.CLIENT_ID_CUSTOM1, su.MEDICAID_ID FROM STX.CLIENTS cl INNER JOIN STX.CLIENTS_SUPP su \n" +
            "on cl.CLIENTKEY = su.CLIENTKEY\n" +
            "AND cl.end_date > sysdate AND cl.ACCOUNT = '%s' AND su.MEDICAID_ID = '%s'";


    public static final String sql_getEmployeeCustom1ByFirstName = "SELECT su.WORKER_ID_CUSTOM1, cl.STX_ID  \n" +
            "            FROM STX.WORKERS cl  \n" +
            "            INNER JOIN STX.WORKERS_SUPP su on cl.WORKERKEY = su.WORKERKEY \n" +
            "            WHERE cl.ACCOUNT = '%s'  AND cl.end_date > sysdate AND cl.F_NAME = '%s'";

    public static final String sql_getEmployeeCustom1ByLastName = "SELECT su.WORKER_ID_CUSTOM1, cl.STX_ID  \n" +
            "            FROM STX.WORKERS cl  \n" +
            "            INNER JOIN STX.WORKERS_SUPP su on cl.WORKERKEY = su.WORKERKEY \n" +
            "            WHERE cl.ACCOUNT = '%s'  AND cl.end_date > sysdate AND cl.L_NAME = '%s'";


    public static final String SQL_GET_EMPLOYEE_CUSTOM_1_BY_CUSTOM_ID = "SELECT su.WORKER_ID_CUSTOM1, cl.STX_ID  \n" +
            "            FROM STX.WORKERS cl  \n" +
            "            INNER JOIN STX.WORKERS_SUPP su on cl.WORKERKEY = su.WORKERKEY \n" +
            "            WHERE cl.ACCOUNT = '%s'  AND cl.end_date > sysdate AND su.WORKER_ID_CUSTOM1 = '%s'";

    public static final String SQL_STX_APP_USERS = "SELECT ACCOUNT,USERNAME,PASSWORD,DATA_SCOPE_ID,ACCOUNT_STATUS," +
            "USER_TYPE_ID,USER_ID,DELETED,USER_F_NAME, USER_L_NAME FROM STX.APP_USERS WHERE ACCOUNT = '%s' AND username = '%s'";

    public static final String QUERY_INBOX_APP_USERS_BY_NAME = "SELECT * FROM INBOX.APP_USERS WHERE ACCOUNT = '%s' AND USER_F_NAME = '%s'";

    public static final String SQL_STX_CLIENT_CONTACT_BY_CLIENTID = "SELECT * FROM stx.CLIENTS_CONTACT WHERE ACCOUNT= '%s' " +
            "AND LOC='%s' AND CONTACT_TYPE_CODE = 'EC' ";

    public static final String SQL_STX_CLIENT_CONTACT_BY_EMAIL = "SELECT * FROM stx.CLIENTS_CONTACT WHERE ACCOUNT= '%s' " +
            "AND E_MAIL='%s'";
}
