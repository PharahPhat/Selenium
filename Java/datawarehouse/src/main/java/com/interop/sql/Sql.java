package com.interop.sql;

public class Sql {
    public static final String SQL_GET_VISIT_EXCEPTION = "SELECT v.visitkey, ex.excpkey, ex.description\n" +
            "       ,(CASE WHEN eab.column_value IS NOT NULL THEN '1' ELSE '0' END) AS AckInd\n" +
            " FROM stx.visits v\n" +
            "   JOIN exceptions_setup es ON es.account = v.account\n" +
            "   JOIN stx.exceptions ex ON ex.excpkey= es.excpkey\n" +
            "   JOIN TABLE(repgen.jlib.ExtractExplainBits(v.excp_explain)) eb ON eb.column_value = ex.excpkey \n" +
            "   LEFT JOIN TABLE(repgen.jlib.ExtractExplainBits(v.excp_ack_explain)) eab ON eb.column_value = eab.column_value\n" +
            " WHERE\n" +
            "   v.account IN\n" +
            "   (\n" +
            "     SELECT account\n" +
            "     FROM stx.accounts_groups_setup\n" +
            "     WHERE groupkey = %1$s\n" +
            "   ) and visitkey = '%2$s'\n" +
            "UNION ALL\n" +
            " SELECT v.visitkey, ex.excpkey, ex.description\n" +
            "       ,(CASE WHEN eab.column_value IS NOT NULL THEN '1' ELSE '0' END) AS AckInd\n" +
            " FROM stx.visits v\n" +
            "   JOIN stx.exceptions_setup es ON es.account = v.account\n" +
            "   JOIN stx.exceptions ex ON ex.excpkey= es.excpkey\n" +
            "   JOIN TABLE(repgen.jlib.ExtractExplainBits(v.excp1_explain)) eb ON eb.column_value = (ex.excpkey - 31)\n" +
            "   LEFT JOIN TABLE(repgen.jlib.ExtractExplainBits(v.excp1_ack_explain)) eab ON eb.column_value = eab.column_value\n" +
            " WHERE\n" +
            "   v.account IN\n" +
            "   (\n" +
            "     SELECT account\n" +
            "     FROM stx.accounts_groups_setup\n" +
            "     WHERE groupkey = %1$s\n" +
            "   ) and visitkey = '%2$s'";

    public static final String SQL_GET_VISIT_KEY_BY_FIRST_NAME = "SELECT VISITKEY\n" +
            " FROM VISITS\n" +
            " WHERE CLIENTKEY IN (SELECT CLIENTKEY FROM STX.CLIENTS WHERE ACCOUNT = '%1$s' AND F_NAME = '%2$s') AND ROWNUM <=10";

    public static final String SQL_GET_VISIT_KEY_BY_CLIENT_WORKER = "SELECT VISITKEY FROM STX.VISITS \n" +
            "WHERE ACCOUNT = '%1$s'\n" +
            "  and CLIENTKEY IN (SELECT CLIENTKEY FROM STX.CLIENTS c WHERE c.F_NAME = '%2$s')\n" +
            "  and WORKERKEY in (select WORKERKEY from stx.WORKERS w where w.F_NAME = '%3$s')\n" +
            "  and VISIT_DATE between to_date('%4$s','yyyy-mm-dd') and to_date('%5$s','yyyy-mm-dd')";

    public static final String SQL_GET_CALL_KEY_BY = "select * from calls\n" +
            "where visitkey = '%1$s' ";

    public static final String SQL_GET_VISIT_KEY_FROM_VISIT_LOGS = "SELECT VISITKEY FROM STX.VISITS_LOG \n" +
            "WHERE ACCOUNT = '%1$s'\n" +
            "  and CLIENTKEY IN (SELECT CLIENTKEY FROM STX.CLIENTS c WHERE c.F_NAME = '%2$s')\n" +
            "  and WORKERKEY in (select WORKERKEY from STX.WORKERS w where w.F_NAME = '%3$s')\n" +
            "  and VISIT_DATE between to_date('%4$s','yyyy-mm-dd') and to_date('%5$s','yyyy-mm-dd')";

    public static final String SQL_GET_EMPLOYEE_DISC_FROM_DATE_RANGE =
            "SELECT distinct accinf.provider_id as ProviderID, workers.stx_id as EmployeeID, workers_supp.discipline as EmployeeDiscipline \n" +
                    "FROM stx.workers workers \n" +
                    "LEFT JOIN STX.Accounts_Interfaces accinf ON accinf.ACCOUNT = workers.ACCOUNT \n" +
                    "LEFT JOIN STX.workers_supp workers_supp ON workers_supp.WORKERKEY = workers.WORKERKEY \n" +
                    "WHERE workers.provider_id is not null \n" +
                    "AND workers.F_Name is not null \n" +
                    "AND workers.L_Name is not null \n" +
                    "AND accinf.provider_id is not null\n" +
                    "AND workers_supp.discipline is not null\n" +
                    "AND accinf.provider_id = '%s'";

    public static final String SQL_GET_VISIT_GENERAL = "SELECT   v.payor_id,\n" +
            "         ai.provider_id,\n" +
            "         c.loc,\n" +
            "         w.stx_id, \n" +
            "         v.visitkey,\n" +
            "         ca.tzname, \n" +
            "         TO_CHAR(v.beg_call_dtime,'YYYY-MM-DD') as call_in_date_time,\n" +
            "         v.visit_date,\n" +
            "         v.end_call_dtime,\n" +
            "         v.end_adj_dtime,\n" +
            "         stx.lib.GetVisitStatus_custom(v.visitkey) as visit_status,\n" +
            "         c.l_name as client_last_name,\n" +
            "         c.f_name as client_first_name,\n" +
            "         c.clientkey,\n" +
            "         cs.medicaid_id,\n" +
            "         w.stx_id,\n" +
            "         w.l_name as worker_last_name,\n" +
            "         w.f_name as worker_first_name\n" +
            "FROM     stx.visits v\n" +
            "         join stx.clients c on c.clientkey = v.clientkey\n" +
            "         join stx.clients_supp cs on cs.clientkey = c.clientkey\n" +
            "         join stx.workers w on w.workerkey = v.workerkey\n" +
            "         join stx.Accounts_Interfaces ai on ai.provider_id = '%1$s'\n" +
            "         join stx.calls ca on ca.visitkey = v.visitkey\n" +
            "WHERE    (v.account = '%2$s'\n" +
            "     OR  v.account in (select account from stx.accounts_groups_setup where groupkey = '%3$s'))\n" +
            "AND      v.visit_date between to_date('%4$s','YYYY-MM-DD') and to_date('%5$s','YYYY-MM-DD')\n" +
            "AND      stx.lib.GetVisitStatus_custom(v.visitkey) in ('Approved','In Process','Incomplete','Omit','Processed','Verified') " +
            "AND     v.visitkey = '%6$s'";

    public static final String SQL_GET_VISIT_BY_DATE_AND_CLIENT_FIRST_NAME = "SELECT   v.payor_id,\n" +
            "         ai.provider_id,\n" +
            "         c.loc,\n" +
            "         v.visitkey,\n" +
            "         ca.tzname, \n" +
            "         TO_CHAR(v.beg_call_dtime,'YYYY-MM-DD') as call_in_date_time,\n" +
            "         v.visit_date,\n" +
            "         v.end_call_dtime,\n" +
            "         v.end_adj_dtime,\n" +
            "         stx.lib.GetVisitStatus_custom(v.visitkey) as visit_status,\n" +
            "         c.l_name as client_last_name,\n" +
            "         c.f_name as client_first_name,\n" +
            "         c.clientkey,\n" +
            "         cs.medicaid_id,\n" +
            "         w.stx_id,\n" +
            "         w.l_name as worker_last_name,\n" +
            "         w.f_name as worker_first_name\n" +
            "FROM     stx.visits v\n" +
            "         join stx.clients c on c.clientkey = v.clientkey\n" +
            "         join stx.clients_supp cs on cs.clientkey = c.clientkey\n" +
            "         join stx.workers w on w.workerkey = v.workerkey\n" +
            "         join stx.Accounts_Interfaces ai on ai.provider_id = '%1$s'\n" +
            "         join stx.calls ca on ca.visitkey = v.visitkey\n" +
            "WHERE    (v.account = '%2$s'\n" +
            "     OR  v.account in (select account from stx.accounts_groups_setup where groupkey = '%3$s'))\n" +
            "AND      v.visit_date between to_date('%4$s','YYYY-MM-DD') and to_date('%5$s','YYYY-MM-DD')\n" +
            "AND      stx.lib.GetVisitStatus_custom(v.visitkey) in ('Approved','In Process','Incomplete','Omit','Processed','Verified') " +
            "AND     c.f_name = '%6$s'";

    public static final String SQL_GET_VISIT_BY_DATE_AND_MEMO = "SELECT   v.payor_id,\n" +
            "         ai.provider_id,\n" +
            "         c.loc,\n" +
            "         v.visitkey,\n" +
            "         ca.tzname, \n" +
            "         TO_CHAR(v.beg_call_dtime,'YYYY-MM-DD') as call_in_date_time,\n" +
            "         v.visit_date,\n" +
            "         v.end_call_dtime,\n" +
            "         v.end_adj_dtime,\n" +
            "         stx.lib.GetVisitStatus_custom(v.visitkey) as visit_status,\n" +
            "         c.l_name as client_last_name,\n" +
            "         c.f_name as client_first_name,\n" +
            "         c.clientkey,\n" +
            "         cs.medicaid_id,\n" +
            "         w.stx_id,\n" +
            "         w.l_name as worker_last_name,\n" +
            "         w.f_name as worker_first_name\n" +
            "FROM     stx.visits v\n" +
            "         join stx.clients c on c.clientkey = v.clientkey\n" +
            "         join stx.clients_supp cs on cs.clientkey = c.clientkey\n" +
            "         join stx.workers w on w.workerkey = v.workerkey\n" +
            "         join stx.Accounts_Interfaces ai on ai.provider_id = '%1$s'\n" +
            "         join stx.calls ca on ca.visitkey = v.visitkey\n" +
            "WHERE    (v.account = '%2$s'\n" +
            "     OR  v.account in (select account from stx.accounts_groups_setup where groupkey = '%3$s'))\n" +
            "AND      v.visit_date between to_date('%4$s','YYYY-MM-DD') and to_date('%5$s','YYYY-MM-DD')\n" +
            "AND      stx.lib.GetVisitStatus_custom(v.visitkey) in ('Approved','In Process','Incomplete','Omit','Processed','Verified') " +
            "AND     v.memo = '%6$s'";

    public static final String SQL_GET_CLIENT_PHONE = "select cls.CONTRACT,\n" +
            "        cl.LOC,\n" +
            "        ani.DESCRIPTION,\n" +
            "        ani.ANI,\n" +
            "        \n" +
            "        (\n" +
            "          select ai.PROVIDER_ID \n" +
            "          from\n" +
            "          STX.ACCOUNTS_INTERFACES ai\n" +
            "          where ani.ACCOUNT = ai.ACCOUNT\n" +
            "        ) AS PROVIDER_ID \n" +
            "from STX.CLIENTS_SUPP cls JOIN STX.ANI ani ON cls.CLIENTKEY = ani.CLIENTKEY\n" +
            "JOIN STX.CLIENTS cl ON cls.CLIENTKEY = cl.CLIENTKEY\n" +
            "where cl.F_NAME LIKE '%s' AND cl.L_NAME LIKE '%s' AND cl.ACCOUNT LIKE '%s'";

    public static final String SQL_GET_CLIENT_ID_BY_NAME = "select LOC\n" +
            "from STX.CLIENTS\n" +
            "where F_NAME LIKE '%s' AND L_NAME LIKE '%s' AND ACCOUNT LIKE '%s'";

    public static final String SQL_GET_CLIENT_ID_BY_LAST_NAME = "select LOC\n" +
            "from STX.CLIENTS\n" +
            "where L_NAME = '%s' AND ACCOUNT = '%s'";

    public static final String SQL_GET_CLIENT_PROGRAM = "SELECT author.payor_id as PayerID, accinf.provider_id as ProviderID,\n" +
            "client.loc as ClientID, authlimit.program as PayerProgram, authlimit.service as PayerService,\n" +
            "authlimit.modifier1 as Modifier1, authlimit.modifier2 as Modifier2,\n" +
            "authlimit.modifier3 as Modifier3, authlimit.modifier4 as Modifier4,\n" +
            "clisupp.region as PayerRegion\n" +
            "FROM STX.CLIENTS client\n" +
            "LEFT JOIN STX.authorizations author ON author.LOC = client.LOC\n" +
            "LEFT JOIN STX.auth_limits authlimit ON authlimit.AUTH_ID = author.AUTH_ID\n" +
            "LEFT JOIN STX.accounts_interfaces accinf ON accinf.ACCOUNT = client.ACCOUNT\n" +
            "LEFT JOIN STX.clients_supp clisupp ON clisupp.CLIENTKEY = client.CLIENTKEY\n" +
            "WHERE client.ACCOUNT LIKE '%s'\n" +
            "AND client.F_NAME LIKE '%s' and client.L_NAME LIKE '%s'";

    public static final String SQL_GET_EMPLOYEE_GENERAL =
            "SELECT distinct workers.provider_id as ProviderID, workers.stx_id as EmployeeID, workers.l_name as EmployeeLastName,\n" +
                "workers.f_name as EmployeeFirstName, workers.dept as Department, workers.w_type as EmployeeType,\n" +
                "workers_supp.e_mail as EmployeeEmail, workers_supp.addr1 as EmployeeAddress1, workers_supp.addr2 as EmployeeAddress2,\n" +
                "workers_supp.city as EmployeeCity, workers_supp.state as EmployeeState, workers_supp.zip_code as EmployeeZipCode, \n" +
                "workers_supp.phone as EmployeePhone, workers_supp.payrate as PayRate, workers_supp.worker_id_custom1 as EmployeeIDCustom1,\n" +
                "workers_supp.worker_id_custom2 as EmployeeIDCustom2, workers_supp.worker_ssn as SocialSecurity, workers_supp.worker_api as EmployeeAPI,\n" +
                "cast(workers_supp.worker_beg_date as varchar(10)) as EmployeeHireDate, workers_supp.worker_dob as EmployeeBirthDate, workers_supp.worker_primary_location as EmployeeLocationName \n" +
            "FROM STX.workers workers \n" +
                "LEFT JOIN STX.Accounts_Interfaces accinf ON accinf.ACCOUNT = workers.ACCOUNT \n" +
                "LEFT JOIN STX.workers_supp workers_supp ON workers_supp.WORKERKEY = workers.WORKERKEY \n" +
            "WHERE workers.provider_id = '%s' \n" +
                "AND workers_supp.e_mail is not null \n" +
                    "AND workers.f_name = '%s'";


    public static final String SQL_GET_CLIENT_ADDRESS = "select clisupp.CONTRACT as PayerID, accinf.provider_id as ProviderID, client.loc as ClientID,\n" +
            "addr.addr_type_qlfr as ClientAddressType, addr.addr1 as ClientAddressLine1,\n" +
            "addr.addr2 as ClientAddressLine2, addr.county as ClientCounty, addr.city as ClientCity,\n" +
            "addr.state as ClientState, addr.zip_code as ClientZip\n" +
            "From STX.CLIENTS client\n" +
            "LEFT JOIN STX.clients_supp clisupp ON clisupp.CLIENTKEY = client.CLIENTKEY\n" +
            "LEFT JOIN STX.accounts_interfaces accinf ON accinf.ACCOUNT = client.ACCOUNT\n" +
            "LEFT JOIN STX.clients_address addr ON addr.loc = client.loc\n" +
            "where client.ACCOUNT LIKE '%s' AND client.F_NAME LIKE '%s' AND client.L_NAME LIKE '%s'\n" +
            "union all\n" +
            "select clisupp.CONTRACT as PayerID, accinf.provider_id as ProviderID, client.loc as ClientID,\n" +
            "clisupp.addr_type_qlfr as ClientAddressType, clisupp.addr1 as ClientAddressLine1,\n" +
            "clisupp.addr2 as ClientAddressLine2, clisupp.county as ClientCounty, clisupp.city as ClientCity,\n" +
            "clisupp.state as ClientState, clisupp.zip_code as ClientZip\n" +
            "From STX.CLIENTS client\n" +
            "LEFT JOIN STX.clients_supp clisupp ON clisupp.CLIENTKEY = client.CLIENTKEY\n" +
            "LEFT JOIN STX.accounts_interfaces accinf ON accinf.ACCOUNT = client.ACCOUNT\n" +
            "LEFT JOIN STX.clients_address addr ON addr.loc = client.loc\n" +
            "where client.ACCOUNT LIKE '%s' AND client.F_NAME LIKE '%s' AND client.L_NAME LIKE '%s'";

    public static String SQL_GET_PROVIDER_GENERAL =
            "SELECT accInterface.Provider_id_qlfr ProviderQualifier,\n" +
                    "accInterface.provider_id ProviderID,\n" +
                    "accInterface.provider_name ProviderName,\n" +
                    "accInfo.compname ProviderDoingBusinessAs,\n" +
                    "accInfo.addr1 AddressLine1,\n" +
                    "accInfo.addr2 AddressLine2,accInfo.city AddressCity,accInfo.state AddressState,\n" +
                    "accInfo.zip_code AddressZip,accInfo.county County,accInfo.phone AgencyPhone,accInfo.e_mail AgencyEmail,\n" +
                    "accInfo.contact_l_name PrimaryContactLastName,accInfo.contact_f_name PrimaryContactFirstName,accInfo.fax ProviderFax,\n" +
                    "accInfo.npi ProviderNPI,accInfo.api ProviderAPI, \n" +
                    "null as ProviderMedicaidID,\n" +
                    "null as SSN,\n" +
                    "accInfo.federal_id TaxID,\n" +
                    "null as ProviderTaxonomy,\n" +
                    "accSet.auth_enabled ProviderRequireAuth, accSet.tzname ProviderTimeZone,\n" +
                    "TO_CHAR(accInfo.effective_beg_date,'DD-MM-YY') ProviderDateBegin, TO_CHAR(accInfo.effective_end_date,'DD-MM-YY') ProviderDateEnd\n" +
            "FROM stx.Accounts_Interfaces accInterface\n" +
                    "LEFT JOIN STX.accounts_info accInfo ON accInterface.ACCOUNT = accInfo.ACCOUNT\n" +
                    "LEFT JOIN STX.accounts_vendor_config venConf ON venConf.ACCOUNT = accInfo.ACCOUNT\n" +
                    "LEFT JOIN STX.accounts_setup accSet ON accInterface.ACCOUNT = accSet.ACCOUNT\n" +
            "WHERE accInterface.provider_id = '%s'";

    public static final String SQL_GET_CLIENT_GENERAL = "SELECT supp.CONTRACT, accinterface.PROVIDER_ID, client.LOC, supp.client_id_custom1 as ClientPayerID,\n" +
            "client.F_NAME, client.M_NAME, client.L_NAME,\n" +
            "supp.CLIENT_SSN, supp.AR_NO, supp.MEDICAID_ID as MEDICAID_ID, supp.CLIENT_ID_CUSTOM1 as ClientCustomID,\n" +
            "supp.CLIENT_ID_CUSTOM2 as ClientOtherID, client.name_suffix, supp.case_manager, supp.case_manager_e_mail,\n" +
            "client.spv, client.spv_e_mail, supp.language, supp.sex, supp.marital_status_code, to_char(supp.dob, 'yyyy-MM-dd') as DOB,\n" +
            "supp.e_mail, supp.client_priority, client.tzname, appuser.user_f_name, appuser.user_l_name,\n" +
            "appuser.username, \n" +
            "case when appuser.account_status is not null and account_status = 'OPEN' then '2' END as ACCOUNT_STATUS,\n" +
            "appuser.created, \n" +
            "case when appuser.lock_date < appuser.expire_date and appuser.lock_date < appuser.deleted then appuser.lock_date\n" +
            "when appuser.expire_date < appuser.lock_date and appuser.expire_date < appuser.deleted then appuser.expire_date\n" +
            "else appuser.expire_date end as ClientDesigneeEndDate, \n" +
            "contact.contact_relationship, contact.f_name as ClientContactFirstName,\n" +
            "contact.l_name as ClientContactLastName, \n" +
            "case when contact.PHONENUM_BUSINESS is not null then 'Business'\n" +
            "when contact.PHONENUM_HOME is not null then 'Home'\n" +
            "when contact.PHONENUM_MOBILE is not null then 'Mobile'\n" +
            "when contact.PHONENUM_OTHER is not null then 'Other'\n" +
            "END as ClientContactPhoneType,\n" +
            "case when contact.PHONENUM_BUSINESS is not null then contact.PHONENUM_BUSINESS\n" +
            "when contact.PHONENUM_HOME is not null then contact.PHONENUM_HOME\n" +
            "when contact.PHONENUM_MOBILE is not null then contact.PHONENUM_MOBILE\n" +
            "when contact.PHONENUM_OTHER is not null then contact.PHONENUM_OTHER\n" +
            "END as ClientContactPhone,\n" +
            "contact.e_mail as ClientContactEmailAddress, contact.addr1 as ClientContactAddressLine1,\n" +
            "contact.addr2 as ClientContactAddressLine2, contact.city, contact.state, contact.zip_code\n" +
            "FROM STX.CLIENTS client\n" +
            "JOIN STX.ACCOUNTS_INTERFACES accinterface ON accinterface.ACCOUNT = client.ACCOUNT\n" +
            "JOIN STX.CLIENTS_SUPP supp ON supp.CLIENTKEY = client.CLIENTKEY\n" +
            "JOIN STX.CLIENTS_CONTACT contact ON contact.CLIENTKEY = client.CLIENTKEY\n" +
            "LEFT JOIN STX.app_users appuser ON appuser.USRSVKEY = client.CLIENTKEY\n" +
            "LEFT JOIN STX.authorizations author ON author.LOC = client.LOC\n" +
            "WHERE client.ACCOUNT LIKE '%s'\n" +
            "AND client.F_NAME LIKE '%s' and client.L_NAME LIKE '%s'";

    public static final String SQL_GET_CLIENT_GENERAL_MOLINA = "SELECT supp.CONTRACT, accinterface.PROVIDER_ID, client.LOC, author.client_id_custom as ClientPayerID,\n" +
            "client.F_NAME, client.M_NAME, client.L_NAME,\n" +
            "client.cli_explain as MissingMedicaidID, \n" +
            "supp.CLIENT_SSN, supp.AR_NO, supp.MEDICAID_ID as MEDICAID_ID, supp.medicaid_id as ClientCustomID,\n" +
            "supp.client_id_custom1 as ClientOtherID, client.name_suffix, supp.case_manager, supp.case_manager_e_mail,\n" +
            "client.spv, client.spv_e_mail, supp.language, supp.sex, supp.marital_status_code, to_char(supp.dob, 'yyyy-MM-dd') as DOB,\n" +
            "supp.e_mail, supp.client_priority, client.tzname, appuser.user_f_name, appuser.user_l_name,\n" +
            "appuser.username, \n" +
            "case when appuser.account_status is not null and account_status = 'OPEN' then '2' END as ACCOUNT_STATUS,\n" +
            "appuser.created, appuser.expire_date as ClientDesigneeEndDate, contact.contact_relationship, \n" +
            "contact.f_name as ClientContactFirstName, contact.l_name as ClientContactLastName, \n" +
            "case when contact.PHONENUM_BUSINESS is not null then 'Business'\n" +
            "when contact.PHONENUM_HOME is not null then 'Home'\n" +
            "when contact.PHONENUM_MOBILE is not null then 'Mobile'\n" +
            "when contact.PHONENUM_OTHER is not null then 'Other'\n" +
            "END as ClientContactPhoneType,\n" +
            "case when contact.PHONENUM_BUSINESS is not null then contact.PHONENUM_BUSINESS\n" +
            "when contact.PHONENUM_HOME is not null then contact.PHONENUM_HOME\n" +
            "when contact.PHONENUM_MOBILE is not null then contact.PHONENUM_MOBILE\n" +
            "when contact.PHONENUM_OTHER is not null then contact.PHONENUM_OTHER\n" +
            "END as ClientContactPhone,\n" +
            "contact.e_mail as ClientContactEmailAddress, contact.addr1 as ClientContactAddressLine1,\n" +
            "contact.addr2 as ClientContactAddressLine2, contact.city, contact.state, contact.zip_code\n" +
            "FROM STX.CLIENTS client\n" +
            "LEFT JOIN STX.ACCOUNTS_INTERFACES accinterface ON accinterface.ACCOUNT = client.ACCOUNT\n" +
            "LEFT JOIN STX.CLIENTS_SUPP supp ON supp.CLIENTKEY = client.CLIENTKEY\n" +
            "LEFT JOIN STX.CLIENTS_CONTACT contact ON contact.CLIENTKEY = client.CLIENTKEY\n" +
            "LEFT JOIN STX.app_users appuser ON appuser.USRSVKEY = client.CLIENTKEY\n" +
            "LEFT JOIN STX.authorizations author ON author.LOC = client.LOC\n" +
            "WHERE client.ACCOUNT LIKE '%s'\n" +
            "AND client.F_NAME LIKE '%s' and client.L_NAME LIKE '%s'";

    public static final String SQL_GET_CLIENT_PAYER_ID = "select supp.client_id_custom1 as ClientPayerID\n" +
            "from STX.CLIENTS_SUPP supp\n" +
            "where supp.CLIENTKEY = '%s'";

    public static final String SQL_GET_CLIENT_KEY = "select CLIENTKEY\n" +
            "  from ( select a.*, max(CLIENTKEY) over () as MAXCLIENTKEY\n" +
            "           from STX.CLIENTS a where LOC = '%s'\n" +
            "                )\n" +
            " where CLIENTKEY = MAXCLIENTKEY";

    public static final String SQL_GET_CLIENT_KEY_BY_ACCOUNT_AND_LASTNAME = "SELECT CLIENTKEY FROM STX.CLIENTS WHERE ACCOUNT='%s' AND L_NAME = '%s'";

    public static final String SQL_GET_VISIT_KEY_BY_MEMO = "SELECT VISITKEY\n" +
            "FROM STX.VISITS\n" +
            "WHERE CLIENTKEY IN (SELECT CLIENTKEY FROM STX.CLIENTS WHERE ACCOUNT = '%s' AND F_NAME = '%s' AND L_NAME = '%s') AND MEMO='%s' AND ROWNUM <=10 ";

    public static final String GET_SQL_GET_VISIT_KEY_BY_UNIQUE_MEMO = "SELECT v.visitkey\n" +
            "FROM stx.VISITS v\n" +
            "JOIN stx.clients c on v.CLIENTKEY = c.clientkey \n" +
            "WHERE V.MEMO like '%%"+
            "%s"+
            "%%' AND ROWNUM <=10";

    public static final String SQL_GET_VISIT_CALL = "select TO_CHAR (ca.visitkey) as visitkey,\n" +
            "       TO_CHAR (ca.callkey) as callkey,\n" +
            "       TO_CHAR (ca.call_dtime, 'YYYY-MM-DD\"T\"HH24:MI:SS\"Z\"') as calldatetime,\n" +
            "       '' as callassignment,\n" +
            "       '' as calltype,\n" +
            "       '' as procedurecode,\n" +
            "       ca.client_id as clientidentifieroncall,\n" +
            "       ca.service as serviceenteredoncall,\n" +
            "       ca.call_username as mobilelogin,\n" +
            "       '' as visitnotes,\n" +
            "       '' as visitlocation,\n" +
            "       TO_CHAR (ca.latitude) as calllatitude,\n" +
            "       TO_CHAR (ca.latitude) as calllatitude,\n" +
            "       TO_CHAR (ca.longitude) as calllongitude,\n" +
            "       ca.stx_id as telephonypin,\n" +
            "       ca.ani as originatingphonenumber,\n" +
            "       ca.call_username as recordupdatedby,\n" +
            "       TO_CHAR (ca.update_tmstp, 'YYYY-MM-DD') as recordupdatedatetime,\n" +
            "       ca.tzname as calltimezone\n" +
            " from  stx.calls ca\n" +
            "where ca.account = '%1$s'\n" +
            "and ca.visitkey = '%2$s'";

    public static final String SQL_GET_VISIT_LOG = "select TO_CHAR(vl.visitkey) as visitkey,\n" +
            "       TO_CHAR(vl.privkey) as changeid,\n" +
            "       '' as changetype,\n" +
            "       vl.VISIT_GROUP_CODE as groupcode,\n" +
            "       TO_CHAR(vl.visit_version_number) as sequenceid,\n" +
            "       vl.visit_change_id as visitchangeexternalid,\n" +
            "       vl.VISIT_USERNAME as changemadebyemail,\n" +
            "       TO_CHAR(vl.visit_change_dtime, 'YYYY-MM-DD\"T\"HH24:MI:SS\"Z\"') as changedatetime,\n" +
            "       TO_CHAR(vl.timestamp, 'YYYY-MM-DD\"T\"HH24:MI:SS\"Z\"') as recordupdatetime,\n" +
            "       vl.reason_code as reasoncode,\n" +
            "       vl.reason_code_memo as changereasonmemo,\n" +
            "       vl.resolution_code as resolutioncode,\n" +
            "       '' as visitchangelogdetails \n" +
            "from STX.visits_log vl\n" +
            "where vl.VISITKEY = '%1$s'";
    public static final String SQL_GET_EMPLOYEE_GENERAL_BY = "SELECT accinf.provider_id as ProviderID, workers.stx_id as EmployeeID, workers.l_name as EmployeeLastName,\n" +
            "workers.f_name as EmployeeFirstName, workers.dept as Department, workers.w_type as EmployeeType,\n" +
            "workers_supp.e_mail as EmployeeEmail, workers_supp.addr1 as EmployeeAddress1, workers_supp.addr2 as EmployeeAddress2,\n" +
            "workers_supp.city as EmployeeCity, workers_supp.state as EmployeeState, workers_supp.zip_code as EmployeeZipCode, \n" +
            "workers_supp.phone as EmployeePhone, workers_supp.payrate as PayRate, workers_supp.worker_id_custom1 as EmployeeIDCustom1,\n" +
            "workers_supp.worker_id_custom2 as EmployeeIDCustom2, workers_supp.worker_ssn as SocialSecurity, workers_supp.worker_api as EmployeeAPI,\n" +
            "cast(workers_supp.worker_beg_date as varchar(10)) as EmployeeHireDate, workers_supp.worker_dob as EmployeeBirthDate, workers_supp.worker_primary_location as EmployeeLocationName\n" +
            "FROM STX.workers workers\n" +
            "LEFT JOIN STX.Accounts_Interfaces accinf ON accinf.ACCOUNT = workers.ACCOUNT\n" +
            "LEFT JOIN STX.workers_supp workers_supp ON workers_supp.WORKERKEY = workers.WORKERKEY\n" +
            "WHERE workers.f_name = '%s' AND workers.l_name = '%s' AND workers.ACCOUNT = '%s'";

    public static final String SQL_GET_CLIENT = "select * from STX.clients client\n" +
            "WHERE client.ACCOUNT LIKE '%s'\n" +
            "AND client.F_NAME LIKE '%s' and client.L_NAME LIKE '%s' AND CLI_EXPLAIN = 0\n";

    public static final String SQL_GET_EMPLOYEE = "SELECT * \n" +
            "FROM STX.workers workers\n" +
            "WHERE workers.f_name = '%s' AND workers.l_name = '%s' AND workers.ACCOUNT = '%s'";

    public static final String SQL_GET_ACCOUNT = "SELECT account FROM stx.accounts WHERE provider_id = '%s'";

    public static final String SQL_GET_PROVIDER_GENERAL_FOR_MOLINA = "select payor_ID, '%s', payor_name, '%s',addr1, addr2, city, state,zip_code,contact_f_name, contact_l_name, phone  from stx.payor where payor_id = '%s'";

    public static final String SQL_GET_LIST_ACCOUNT_NOT_IN_GROUP = "select account from stx.exports_setup where exportkey = '210' and Account in (select account from stx.accounts_groups_setup where groupkey != '%s')";

}

