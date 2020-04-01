package com.interop.common.constants.queries;

@SuppressWarnings({"squid:S1192","squid:S1118"})
public class InterOpMySQL {
    public static final String MY_SQL_GET_FILE_TRANSFER =
            "select \n" +
                    "  account_intf_trans_guid, \n" +
                    "  account_intf_trans_status_desc \n" +
                    "from \n" +
                    "  metadataconfdb.account_intf_trans \n" +
                    "where \n" +
                    "  account_intf_trans_guid is not null \n" +
                    "order by \n" +
                    "  rec_update_tmstp desc \n" +
                    "limit \n" +
                    "  50";
    public static final String MY_SQL_GET_AUTH_INFO =
            "select \n" +
                    "  au.payor_id, \n" +
                    "  li.program, \n" +
                    "  au.client_id_qlfr, \n" +
                    "  au.client_id, \n" +
                    "  au.provider_id_qlfr, \n" +
                    "  au.provider_id, \n" +
                    "  au.auth_lmt_typ, \n" +
                    "  au.auth_ref_num, \n" +
                    "  li.service, \n" +
                    "  li.modifier1, \n" +
                    "  li.modifier2, \n" +
                    "  li.modifier3, \n" +
                    "  li.modifier4, \n" +
                    "  au.dx_code, \n" +
                    "  au.dx_code_prmy_ind, \n" +
                    "  au.auth_amt_typ, \n" +
                    "  cast(\n" +
                    "    li.auth_lmt as character(10)\n" +
                    "  ) as auth_lmt, \n" +
                    "  cast(\n" +
                    "    date_format(\n" +
                    "      au.auth_start_date, \"%%m/%%d/%%Y\"\n" +
                    "    ) as character(20)\n" +
                    "  ) as auth_start_date, \n" +
                    "  cast(\n" +
                    "    date_format(au.auth_end_date, \"%%m/%%d/%%Y\") as character(20)\n" +
                    "  ) as auth_end_date \n" +
                    "from \n" +
                    "  intfstagedb.auth au, \n" +
                    "  intfstagedb.auth_limit li \n" +
                    "where \n" +
                    "  au.auth_ref_num = '%s' \n" +
                    "  and au.auth_sk = li.auth_sk";

    public static final String MY_SQL_GET_AUTHSTAGING =
            "select\n" +
                    "au.auth_sk,\n" +
                    "au.status_code,\n" +
                    "au.status_memo,\n" +
                    "au.auth_status,\n" +
                    "au.account,\n" +
                    "au.payor_id,\n" +
                    "aul.program,\n" +
                    "au.client_id,\n" +
                    "au.client_id_qlfr,\n" +
                    "au.worker_id,\n" +
                    "au.worker_id_qlfr,\n" +
                    "au.provider_id,\n" +
                    "au.provider_id_qlfr,\n" +
                    "au.auth_ref_num,\n" +
                    "aul.service,\n" +
                    "au.auth_billing_typ,\n" +
                    "aul.modifier1,\n" +
                    "aul.modifier2,\n" +
                    "aul.modifier3,\n" +
                    "aul.modifier4,\n" +
                    "au.auth_lmt_typ,\n" +
                    "au.client_assessment_date,\n" +
                    "au.dx_code,\n" +
                    "au.account_intf_trans_guid,\n" +
                    "au.dx_code_prmy_ind\n" +
                    ",au.case_manager_f_name\n" +
                    ",au.case_manager_l_name\n" +
                    ",au.case_manager_e_mail\n" +
                    "from\n" +
                    "intfstagedb.auth au\n" +
                    "inner join intfstagedb.auth_limit aul on\n" +
                    "au.auth_sk = aul.auth_sk\n" +
                    "where\n" +
                    "au.auth_ref_num = '%s' " +
                    "order by au.rec_create_tmstp desc";

    public static final String MY_SQL_GET_CONFIG_ID_EVV_IMPORT_AUTH = "select \n" +
            "  account_intf_conf_sk \n" +
            "from \n" +
            "  metadataconfdb.account_intf_conf \n" +
            "where \n" +
            "  account = '%s' \n" +
            "  and account_intf_name = 'EVV_IMPORT_AUTHORIZATION' \n" +
            "  and account_intf_active_flag = 1 \n" +
            "  and account_intf_dir_info not like '%%_inbox'";

    public static final String MY_SQL_GET_CONFIG_CLAIM_FOR_ACCOUNT_INTERFACE = "select account_intf_conf_sk from metadataconfdb.account_intf_conf aic \n" +
            "where account = '%s'\n" +
            "and account_intf_name = '%s'\n" +
            "and account_intf_active_flag = 1";


    public static final String MY_SQL_GET_CONFIG_MATCHING_SERVICE = "select\n" +
            " account_intf_conf_sk\n" +
            "from\n" +
            " metadataconfdb.account_intf_conf\n" +
            "where\n" +
            " account = '%s'\n" +
            " and account_intf_name = 'EVV_AUTH_CLIENT_MATCHING_AUTH'\n" +
            " and account_intf_active_flag = 1\n" +
            " and account_intf_dir_info not like '%%_inbox'";

    public static final String MY_SQL_GET_CONFIG_MATCHING_SERVICE_MOLINA = "select\n" +
            " account_intf_conf_sk\n" +
            "from\n" +
            " metadataconfdb.account_intf_conf\n" +
            "where\n" +
            " account = '%s'\n" +
            " and account_intf_name LIKE 'EVV_AUTH_CLIENT_MATCHING%%'\n" +
            " and account_intf_active_flag = 1\n" +
            " and account_intf_dir_info not like '%%_inbox'";

    public static final String MY_SQL_GET_CONFIG_ID_EVV_IMPORT_PROVIDER = "select \n" +
            "  account_intf_conf_sk \n" +
            "from \n" +
            "  metadataconfdb.account_intf_conf \n" +
            "where \n" +
            "  account = '%s' \n" +
            "  and account_intf_name = 'EVV_IMPORT_PROVIDER' \n" +
            "  and account_intf_active_flag = 1 \n" +
            "  and account_intf_dir_info not like '%%_inbox'";

    public static final String MY_SQL_GET_CONFIG_ID_EVV_IMPORT_MEMBER = "select \n" +
            "  account_intf_conf_sk \n" +
            "from \n" +
            "  metadataconfdb.account_intf_conf \n" +
            "where \n" +
            "  account = '%s' \n" +
            "  and account_intf_name = 'EVV_IMPORT_CLIENT' \n" +
            "  and account_intf_active_flag = 1 \n" +
            "  and account_intf_dir_info not like '%%_inbox'";


    public static final String MYSQL_GET_CLIENT_ELIG_INFO = "SELECT PAYOR_ID, PROGRAM, CLIENT_ID, ACCOUNT \n" +
            "FROM INTFSTAGEDB.CLIENT_ELIG \n" +
            "WHERE CLIENT_ID = '%s' AND ACCOUNT='%s'";

    public static final String MYSQL_GET_CLIENT_ADDR_INFO = "SELECT ACCOUNT, CLIENT_ID, CLIENT_ADDR1, CLIENT_ADDR2, CLIENT_CITY, CLIENT_ZIP_CODE, CLIENT_STATE, CLIENT_COUNTY \n" +
            "FROM INTFSTAGEDB.CLIENT_ADDR \n" +
            "WHERE CLIENT_ID ='%s' AND ACCOUNT='%s'";

    public static final String MYSQL_GET_CLIENT_CONTACT_INFO = "SELECT ACCOUNT, CLIENT_ID, CONT_F_NAME, CONT_L_NAME, CONT_PHONE_NUM, CONT_E_MAIL, CONT_ADDR1, CONT_ADDR2, CONT_CITY, CONT_STATE, CONT_ZIP_CODE, CONT_TYP_CODE \n" +
            "FROM INTFSTAGEDB.CLIENT_CONT \n" +
            "WHERE CLIENT_ID ='%s' AND ACCOUNT='%s' AND CONT_TYP_CODE = '%s'";

    public static final String MYSQL_GET_CLIENT_PHONE_INFO = "SELECT ACCOUNT, CLIENT_ID, CLIENT_PHONE_TYP, CLIENT_PHONE_NUM\n" +
            "FROM INTFSTAGEDB.CLIENT_PHONE\n" +
            "WHERE CLIENT_ID ='%s' AND ACCOUNT='%s'";

    public static final String GET_EXCLUSION_PROVIDER_ID =
            "select be_guid as id, provider_id as providerId from metadataconfdb.be_provider_excl order by be_guid desc LIMIT 0,200";

    public static final String MY_SQL_GET_AUTH_LIMIT_INFO_STAGING =
            "select\n" +
                    " auth_limit_sk,\n" +
                    " action_code,\n" +
                    " account_intf_trans_guid,\n" +
                    " auth_lmt,\n" +
                    " auth_lmt_day_of_week,\n" +
                    " auth_lmt_end_time,\n" +
                    " auth_lmt_start_time,\n" +
                    " auth_sk,\n" +
                    " program,\n" +
                    " prmy_dx_code,\n" +
                    " modifier1,\n" +
                    " modifier2,\n" +
                    " modifier3,\n" +
                    " service,\n" +
                    " modifier4\n" +
                    "from\n" +
                    " intfstagedb.auth_limit\n" +
                    "where account_intf_trans_guid = '%s'";

    public static final String MY_SQL_GET_BASIC_INFO_BY_CLIENT_MEDICAID_ID =
            "select client_sk,client_f_name,client_l_name,client_medicaid_id,client_id_custom1,client_id_custom2,client_id,client_id_qlfr,account,status_code,status_memo from intfstagedb.client c\n" +
                    "where account = '%s' and client_medicaid_id = '%s'";

    public static final String MY_SQL_GET_BASIC_INFO_BY_CLIENT_ID =
            "select client_sk,client_f_name,client_l_name,client_medicaid_id,client_id_custom1,client_id_custom2,client_id,client_id_qlfr,account,status_code,status_memo from intfstagedb.client c\n" +
                    "where account = '%s' and client_id = '%s'";

    public static final String GET_CLIENT_CONTACT_BY_CLIENT_FNAME = "SELECT cc.ERROR_CODE, cc.F_NAME, cc.L_NAME, cc.ADDR1, cc.ADDR2, cc.E_MAIL, cc.DELETE_FLAG, cc.INSERT_TMSTP, cc.LOC FROM INBOX.CLIENTS_CONTACT cc INNER JOIN INBOX.CLIENTS c\n" +
            "ON c.LOC = cc.LOC\n" +
            "WHERE c.F_NAME = '%s' AND c.ACCOUNT = '%s' AND cc.CONTACT_TYPE_CODE = 'EC'" ;

    public static final String SQL_STX_CLIENT_CONTACT_BY_CLIENTID = "SELECT * FROM stx.CLIENTS_CONTACT WHERE ACCOUNT= '%s' " +
            "AND LOC='%s' AND CONTACT_TYPE_CODE = 'EC' ";

    public static final String GET_CLIENT_MEDICAID_ID = "SELECT DISTINCT ai.PROVIDER_ID, cs.MEDICAID_ID FROM STX.CLIENTS c INNER JOIN STX.CLIENTS_SUPP cs \n" +
            "ON c.CLIENTKEY = cs.CLIENTKEY\n" +
            "INNER JOIN stx.ACCOUNTS_INTERFACES ai \n" +
            "ON ai.ACCOUNT = c.ACCOUNT\n" +
            "WHERE cs.MEDICAID_ID IS NOT NULL AND c.ACCOUNT = '%1s' AND REGEXP_LIKE (cs.MEDICAID_ID, '%s')";

    public static final String GET_CLIENT_ANI = "SELECT * FROM STX.ANI WHERE LOC  = '%s' AND ACCOUNT = '%s'";
}