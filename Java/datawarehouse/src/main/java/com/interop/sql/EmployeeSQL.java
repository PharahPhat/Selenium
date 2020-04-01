package com.interop.sql;

public class EmployeeSQL {
    public static final String SQL_GET_WORKER_BY_SSN = "SELECT *\n" +
            "FROM workers w, workers_supp p\n" +
            "WHERE w.workerkey = p.workerkey(+)\n" +
            "  AND w.account = '%s'\n" +
            "  AND w.beg_date < w.end_date\n" +
            "  AND p.worker_ssn = '%s' ";
    public static final String SQL_GET_WORKER_BY_ID_CUSTOM_1 = "SELECT *\n" +
            "FROM workers w, workers_supp p\n" +
            "WHERE w.workerkey = p.workerkey(+)\n" +
            "AND w.account = '%s'\n" +
            "AND w.beg_date < w.end_date\n" +
            "AND p.worker_id_custom1 = '%s' \n";
    public static final String SQL_GET_WORKER_KEY_BY_STXID = "select workerkey from stx.workers where ACCOUNT='%s' AND stx_id = '%s'";
    public static final String SQL_GET_WORKERKEY_BY_FIRST_NAME = "select workerkey from stx.workers where ACCOUNT='%s' AND F_NAME = '%s'";
    public static final String SQL_GET_WORKERKEY_BY_LAST_NAME = "SELECT * FROM STX.WORKERS WHERE ACCOUNT='%s' AND L_NAME = '%s'";

    public static final String SQL_GET_WORKERS_ACCOUNT = "select * from stx.workers where F_name= '%s' and account = '%s'";
    public static final String SQL_GET_WORKERS_BY_LAST_NAMES = "SELECT L_NAME FROM STX.WORKERS WHERE ACCOUNT='%s' AND L_NAME in (%s)";

    public static final String SQL_GET_WORKER_BY_SEQUENCE_NUMBER = "SELECT * FROM STX.WORKERS WHERE ACCOUNT='%s' AND worker_version_number = '%s'";
    public static final String SQL_GET_WORKER_BY_STXID = "SELECT * FROM STX.WORKERS WHERE STX_ID = '%s'";
    public static final String SQL_GET_WORKERID_CUSTOM1 = "SELECT * FROM STX.WORKERS_SUPP WHERE worker_id_custom1 = '%s'";
    public static final String SQL_GET_WORKERS_BY_STXID = "SELECT STX_ID FROM STX.WORKERS WHERE ACCOUNT = '%s' AND STX_ID IN (%s)";


    public static final String SQL_GET_EMPLOYEE_GENERAL_BY_NAME = "SELECT accinf.provider_id as ProviderID, workers.stx_id as EmployeeID, workers.l_name as EmployeeLastName,\n" +
            "workers.f_name as EmployeeFirstName, workers.dept as Department, workers.w_type as EmployeeType,\n" +
            "workers_supp.e_mail as EmployeeEmail, workers_supp.addr1 as EmployeeAddress1, workers_supp.addr2 as EmployeeAddress2,\n" +
            "workers_supp.city as EmployeeCity, workers_supp.state as EmployeeState, workers_supp.zip_code as EmployeeZipCode, \n" +
            "workers_supp.phone as EmployeePhone, workers_supp.payrate as PayRate, workers_supp.worker_id_custom1 as EmployeeIDCustom1,\n" +
            "workers_supp.worker_id_custom2 as EmployeeIDCustom2, workers_supp.worker_ssn as SocialSecurity, workers_supp.worker_api as EmployeeAPI,\n" +
            "cast(workers_supp.worker_beg_date as varchar(10)) as EmployeeHireDate, workers_supp.worker_dob as EmployeeBirthDate, workers_supp.worker_primary_location as EmployeeLocationName \n" +
            "FROM STX.workers workers\n" +
            "LEFT JOIN STX.Accounts_Interfaces accinf ON accinf.ACCOUNT = workers.ACCOUNT\n" +
            "LEFT JOIN STX.workers_supp workers_supp ON workers_supp.WORKERKEY = workers.WORKERKEY\n" +
            "WHERE workers.f_name = '%s' AND workers.l_name = '%s' AND workers.ACCOUNT = '%s'";

    public static final String SQL_GET_EMPLOYEE_BY_STX_ID = "SELECT accinf.provider_id as ProviderID, workers.stx_id as EmployeeID, workers.l_name as EmployeeLastName,\n" +
            "workers.f_name as EmployeeFirstName, workers.dept as Department, workers.w_type as EmployeeType,\n" +
            "workers_supp.e_mail as EmployeeEmail, workers_supp.addr1 as EmployeeAddress1, workers_supp.addr2 as EmployeeAddress2,\n" +
            "workers_supp.city as EmployeeCity, workers_supp.state as EmployeeState, workers_supp.zip_code as EmployeeZipCode, \n" +
            "workers_supp.phone as EmployeePhone, workers_supp.payrate as PayRate, workers_supp.worker_id_custom1 as EmployeeIDCustom1,\n" +
            "workers_supp.worker_id_custom2 as EmployeeIDCustom2, workers_supp.worker_ssn as SocialSecurity, workers_supp.worker_api as EmployeeAPI,\n" +
            "cast(workers_supp.worker_beg_date as varchar(10)) as EmployeeHireDate, workers_supp.worker_dob as EmployeeBirthDate, workers_supp.worker_primary_location as EmployeeLocationName \n" +
            "FROM STX.workers workers\n" +
            "LEFT JOIN STX.Accounts_Interfaces accinf ON accinf.ACCOUNT = workers.ACCOUNT\n" +
            "LEFT JOIN STX.workers_supp workers_supp ON workers_supp.WORKERKEY = workers.WORKERKEY\n" +
            "WHERE workers.ACCOUNT = '%s' AND workers.STX_ID = '%s'";

    public static final String SQL_GET_EMPLOYEE_BY_ATT_ID = "SELECT accinf.provider_id as ProviderID, workers.stx_id as EmployeeID, workers.l_name as EmployeeLastName,\n" +
            "workers.f_name as EmployeeFirstName, workers.dept as Department, workers.w_type as EmployeeType,\n" +
            "workers_supp.e_mail as EmployeeEmail, workers_supp.addr1 as EmployeeAddress1, workers_supp.addr2 as EmployeeAddress2,\n" +
            "workers_supp.city as EmployeeCity, workers_supp.state as EmployeeState, workers_supp.zip_code as EmployeeZipCode, \n" +
            "workers_supp.phone as EmployeePhone, workers_supp.payrate as PayRate, workers_supp.worker_id_custom1 as EmployeeIDCustom1,\n" +
            "workers_supp.worker_id_custom2 as EmployeeIDCustom2, workers_supp.worker_ssn as SocialSecurity, workers_supp.worker_api as EmployeeAPI,\n" +
            "cast(workers_supp.worker_beg_date as varchar(10)) as EmployeeHireDate, workers_supp.worker_dob as EmployeeBirthDate, workers_supp.worker_primary_location as EmployeeLocationName \n" +
            "FROM STX.workers workers\n" +
            "LEFT JOIN STX.Accounts_Interfaces accinf ON accinf.ACCOUNT = workers.ACCOUNT\n" +
            "LEFT JOIN STX.workers_supp workers_supp ON workers_supp.WORKERKEY = workers.WORKERKEY\n" +
            "WHERE workers.f_name = '%s' AND workers.l_name = '%s' AND workers.ACCOUNT = '%s' AND workers.ATT_ID = '%s'";


    public static final String SQL_GET_EMPLOYEES_GENERAL_LIST_NAME = "SELECT accinf.provider_id as ProviderID, workers.stx_id as EmployeeID, workers.l_name as EmployeeLastName,\n" +
            "workers.f_name as EmployeeFirstName, workers.dept as Department, workers.w_type as EmployeeType,\n" +
            "workers_supp.e_mail as EmployeeEmail, workers_supp.addr1 as EmployeeAddress1, workers_supp.addr2 as EmployeeAddress2,\n" +
            "workers_supp.city as EmployeeCity, workers_supp.state as EmployeeState, workers_supp.zip_code as EmployeeZipCode, \n" +
            "workers_supp.phone as EmployeePhone, workers_supp.payrate as PayRate, workers_supp.worker_id_custom1 as EmployeeIDCustom1,\n" +
            "workers_supp.worker_id_custom2 as EmployeeIDCustom2, workers_supp.worker_ssn as SocialSecurity, workers_supp.worker_api as EmployeeAPI,\n" +
            "cast(workers_supp.worker_beg_date as varchar(10)) as EmployeeHireDate, workers_supp.worker_dob as EmployeeBirthDate, workers_supp.worker_primary_location as EmployeeLocationName\n" +
            "FROM STX.workers workers\n" +
            "LEFT JOIN STX.Accounts_Interfaces accinf ON accinf.ACCOUNT = workers.ACCOUNT\n" +
            "LEFT JOIN STX.workers_supp workers_supp ON workers_supp.WORKERKEY = workers.WORKERKEY\n" +
            "WHERE workers.f_name in (%s) AND workers.ACCOUNT = '%s'";

    public static final String SQL_GET_EMPLOYEE_ID = "SELECT workers.stx_id as EmployeeID \n" +
            "FROM STX.workers workers\n" +
            "WHERE workers.f_name = '%s' AND workers.l_name = '%s' AND workers.ACCOUNT = '%s'";

    public static final String SQL_GET_EMPLOYEE_DISC = "select accinf.provider_id as ProviderID, workers.stx_id as EmployeeID, workers_supp.discipline as EmployeeDiscipline\n" +
            "from STX.workers workers\n" +
            "LEFT JOIN STX.Accounts_Interfaces accinf ON accinf.ACCOUNT = workers.ACCOUNT\n" +
            "LEFT JOIN STX.workers_supp workers_supp ON workers_supp.WORKERKEY = workers.WORKERKEY\n" +
            "WHERE workers.f_name = '%s' AND workers.l_name = '%s' AND workers.ACCOUNT = '%s'";

    public static final String SQL_GET_EMPLOYEE_GENERAL = "SELECT * FROM STX.WORKERS W, STX.WORKERS_SUPP WS\n" +
            "WHERE ACCOUNT='%s' AND L_NAME = '%s'\n" +
            "AND W.WORKERKEY = WS.WORKERKEY";

    public static final String SQL_GET_STAFF_ACC_AND_LAST_NAME_AND_STAFF_SSN =
            "SELECT * from stx.workers w " +
                    "left join stx.workers_supp ws " +
                    "on w.workerkey = ws.workerkey " +
                    "where account = '%s' and L_Name = '%s' and worker_ssn = '%s' ";

    public static final String SQL_EMPLOYEE_WITH_ROW_NUM =
            "SELECT accinf.provider_id as ProviderID, workers.stx_id as EmployeeID, workers.l_name as EmployeeLastName,\n" +
                    "workers.f_name as EmployeeFirstName, workers.dept as Department, workers.w_type as EmployeeType,\n" +
                    "workers_supp.e_mail as EmployeeEmail, workers_supp.addr1 as EmployeeAddress1, workers_supp.addr2 as EmployeeAddress2,\n" +
                    "workers_supp.city as EmployeeCity, workers_supp.state as EmployeeState, workers_supp.zip_code as EmployeeZipCode, \n" +
                    "workers_supp.phone as EmployeePhone, workers_supp.payrate as PayRate, workers_supp.worker_id_custom1 as EmployeeIDCustom1,\n" +
                    "workers_supp.worker_id_custom2 as EmployeeIDCustom2, workers_supp.worker_ssn as SocialSecurity, workers_supp.worker_api as EmployeeAPI,\n" +
                    "cast(workers_supp.worker_beg_date as varchar(10)) as EmployeeHireDate, workers_supp.worker_dob as EmployeeBirthDate, workers_supp.worker_primary_location as EmployeeLocationName\n" +
                    "FROM STX.workers workers\n" +
                    "LEFT JOIN STX.Accounts_Interfaces accinf ON accinf.ACCOUNT = workers.ACCOUNT\n" +
                    "LEFT JOIN STX.workers_supp workers_supp ON workers_supp.WORKERKEY = workers.WORKERKEY\n" +
                    "WHERE workers.ACCOUNT = '%s'" +
                    "AND workers.end_date > sysdate   \n" +
                    "AND ROWNUM <= %s";

    public static final String SQL_EMPLOYEE_ALT_EVV_GENERIC =
            "select wo.STX_ID as EmployeeIdentifier, " +
                    "su.WORKER_ID_CUSTOM1, su.WORKER_SSN " +
                    "FROM STX.WORKERS wo, stx.WORKERS_SUPP su  " +
                    "WHERE wo.ACCOUNT = '%s' " +
                    "AND wo.end_date > sysdate  " +
                    "AND wo.WORKERKEY = su.WORKERKEY " +
                    "AND wo.STX_ID IS NOT NULL " +
                    "AND su.WORKER_ID_CUSTOM1 IS NOT NULL " +
                    "AND LENGTH(TRIM(TRANSLATE(wo.STX_ID , ' +-.0123456789',' '))) IS NULL " +
                    "AND ROWNUM <= 1";

    public static final String SQL_EMPLOYEE_ALT_EVV_COLORADO =
            "select wo.STX_ID as EmployeeIdentifier, " +
                    "su.WORKER_ID_CUSTOM1, su.WORKER_SSN " +
                    "FROM STX.WORKERS wo, stx.WORKERS_SUPP su  " +
                    "WHERE wo.ACCOUNT = '%s' " +
                    "AND wo.end_date > sysdate  " +
                    "AND wo.WORKERKEY = su.WORKERKEY " +
                    "AND wo.STX_ID IS NOT NULL " +
                    "AND su.WORKER_ID_CUSTOM1 IS NOT NULL " +
                    "AND LENGTH(TRIM(TRANSLATE(wo.STX_ID , ' +-.0123456789',' '))) IS NOT NULL " +
                    "AND ROWNUM <= 1";

    public static final String SQL_EMPLOYEE_ALT_EVV_ARIZONA =
            "select wo.STX_ID as EmployeeIdentifier, " +
                    "su.WORKER_ID_CUSTOM1, su.WORKER_SSN " +
                    "FROM STX.WORKERS wo, stx.WORKERS_SUPP su  " +
                    "WHERE wo.ACCOUNT = '%s' " +
                    "AND wo.end_date > sysdate  " +
                    "AND wo.WORKERKEY = su.WORKERKEY " +
                    "AND wo.STX_ID IS NOT NULL " +
                    "AND su.WORKER_SSN IS NOT NULL " +
                    "AND LENGTH(TRIM(TRANSLATE(su.WORKER_SSN , ' +-.0123456789',' '))) IS NULL " +
                    "AND ROWNUM <= 1";

    public static final String SQL_EMPLOYEE_ALT_EVV_VERMONT =
            "select wo.STX_ID as EmployeeIdentifier, " +
                    "su.WORKER_ID_CUSTOM1, su.WORKER_SSN " +
                    "FROM STX.WORKERS wo, stx.WORKERS_SUPP su  " +
                    "WHERE wo.ACCOUNT = '%s' " +
                    "AND wo.end_date > sysdate  " +
                    "AND wo.WORKERKEY = su.WORKERKEY " +
                    "AND wo.STX_ID IS NOT NULL " +
                    "AND su.WORKER_ID_CUSTOM1 IS NOT NULL " +
                    "AND LENGTH(su.WORKER_ID_CUSTOM1) < 10\n" +
                    "AND LENGTH(TRIM(TRANSLATE(su.WORKER_ID_CUSTOM1 , ' +-.0123456789',' '))) IS NULL " +
                    "AND ROWNUM <= 100";

    public static final String SQL_EMPLOYEE_ALT_EVV_GENERIC_PA =
            "select wo.STX_ID as EMPLOYEEIDENTIFIER, " +
                    "su.WORKER_ID_CUSTOM1 " +
                    "FROM STX.WORKERS wo, stx.WORKERS_SUPP su  " +
                    "WHERE wo.ACCOUNT = '%s' AND wo.WORKERKEY = su.WORKERKEY " +
                    "AND wo.STX_ID IS NOT NULL " +
                    "AND su.WORKER_ID_CUSTOM1 IS NOT NULL " +
                    "AND REGEXP_LIKE (su.WORKER_ID_CUSTOM1, '^(([a-zA-Z0-9]{6})|(0000\\\\d{5}))$') " +
                    "AND wo.end_date > sysdate  " +
                    "AND ROWNUM <= 100";
}
