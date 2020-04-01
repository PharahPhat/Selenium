package com.sql;

public class SQL {
    private SQL(){}

    public static final String sql_getClientGeneral = "SELECT supp.CONTRACT, accinterface.PROVIDER_ID, client.LOC, author.client_id_custom as ClientPayerID,\n" +
            "client.F_NAME, client.M_NAME, client.L_NAME,\n" +
            "supp.CLIENT_SSN, supp.AR_NO, supp.MEDICAID_ID as MEDICAID_ID, supp.CLIENT_ID_CUSTOM1 as ClientCustomID,\n" +
            "supp.CLIENT_ID_CUSTOM2 as ClientOtherID, client.name_suffix, supp.case_manager, supp.case_manager_e_mail,\n" +
            "client.spv, client.spv_e_mail, supp.language, supp.sex, supp.marital_status_code, supp.dob,\n" +
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

    public static final String sql_getClientPhone = "select cls.CONTRACT,\n" +
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

    public static final String sql_getClientProgram = "SELECT author.payor_id as PayerID, accinf.provider_id as ProviderID,\n" +
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

    public static final String sql_getClientAddress = "select clisupp.CONTRACT as PayerID, accinf.provider_id as ProviderID, client.loc as ClientID,\n" +
            "addr.addr_type_qlfr as ClientAddressType, addr.addr1 as ClientAddressLine1,\n" +
            "addr.addr2 as ClientAddressLine2, addr.county as ClientCounty, addr.city as ClientCity,\n" +
            "addr.state as ClientState, addr.zip_code as ClientZip\n" +
            "From STX.CLIENTS client\n" +
            "LEFT JOIN STX.clients_supp clisupp ON clisupp.CLIENTKEY = client.CLIENTKEY\n" +
            "LEFT JOIN STX.accounts_interfaces accinf ON accinf.ACCOUNT = client.ACCOUNT\n" +
            "LEFT JOIN STX.clients_address addr ON addr.loc = client.loc\n" +
            "where client.ACCOUNT LIKE '%s' AND client.F_NAME LIKE '%s' AND client.L_NAME LIKE '%s'";

    public static final String sql_getEmployeeGeneral = "SELECT accinf.provider_id as ProviderID, workers.stx_id as EmployeeID, workers.l_name as EmployeeLastName,\n" +
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

    public static final String sql_getEmployeeDisc = "select accinf.provider_id as ProviderID, workers.stx_id as EmployeeID, workers_supp.discipline as EmployeeDiscipline\n" +
            "from STX.workers workers\n" +
            "LEFT JOIN STX.Accounts_Interfaces accinf ON accinf.ACCOUNT = workers.ACCOUNT\n" +
            "LEFT JOIN STX.workers_supp workers_supp ON workers_supp.WORKERKEY = workers.WORKERKEY\n" +
            "WHERE workers.f_name = '%s' AND workers.l_name = '%s' AND workers.ACCOUNT = '%s'";

    public static final String sql_getClientGeneralMolina = "SELECT supp.CONTRACT, accinterface.PROVIDER_ID, client.LOC, author.client_id_custom as ClientPayerID,\n" +
            "client.F_NAME, client.M_NAME, client.L_NAME,\n" +
            "client.cli_explain as MissingMedicaidID, \n" +
            "supp.CLIENT_SSN, supp.AR_NO, supp.MEDICAID_ID as MEDICAID_ID, supp.medicaid_id as ClientCustomID,\n" +
            "supp.client_id_custom1 as ClientOtherID, client.name_suffix, supp.case_manager, supp.case_manager_e_mail,\n" +
            "client.spv, client.spv_e_mail, supp.language, supp.sex, supp.marital_status_code, supp.dob,\n" +
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

    public static final String sql_getClientSuppAddress = "select clisupp.CONTRACT as PayerID, accinf.provider_id as ProviderID, client.loc as ClientID,\n" +
            "clisupp.addr_type_qlfr as ClientAddressType, clisupp.addr1 as ClientAddressLine1,\n" +
            "clisupp.addr2 as ClientAddressLine2, clisupp.county as ClientCounty, clisupp.city as ClientCity,\n" +
            "clisupp.state as ClientState, clisupp.zip_code as ClientZip\n" +
            "From STX.CLIENTS client\n" +
            "LEFT JOIN STX.clients_supp clisupp ON clisupp.CLIENTKEY = client.CLIENTKEY\n" +
            "LEFT JOIN STX.accounts_interfaces accinf ON accinf.ACCOUNT = client.ACCOUNT\n" +
            "LEFT JOIN STX.clients_address addr ON addr.loc = client.loc\n" +
            "where client.ACCOUNT LIKE '%s' AND client.F_NAME LIKE '%s' AND client.L_NAME LIKE '%s'";

    public static final String sql_getEmployeeDisc_from_date_range =
            "SELECT accinf.provider_id as ProviderID, workers.stx_id as EmployeeID, workers_supp.discipline as EmployeeDiscipline \n" +
                    "FROM stx.workers workers \n" +
                    "LEFT JOIN STX.Accounts_Interfaces accinf ON accinf.ACCOUNT = workers.ACCOUNT \n" +
                    "LEFT JOIN STX.workers_supp workers_supp ON workers_supp.WORKERKEY = workers.WORKERKEY \n" +
                    "WHERE workers.provider_id is not null \n" +
                    "AND workers.F_Name is not null \n" +
                    "AND workers.L_Name is not null \n" +
                    "AND workers.beg_date <= '%s' \n" +
                    "AND workers.end_date >= '%s' \n" +
                    "AND workers.STX_ID in %s";
}
