package com.interop.sql;

public class AuthSQL {
    public static final String SQL_GET_AUTH_BY_GUID =
            "SELECT * " +
                    "FROM intfstagedb.auth " +
                    "WHERE account_intf_trans_guid like %s";

    public static final String SQL_INBOX_AUTH_LIMIT = "select Error_code, PROGRAM as PAYERPROGRAM, SERVICE as PROCEDURECODE, MODIFIER1 as Modifier1, " +
            "MODIFIER2 as Modifier2, MODIFIER3 as Modifier3, MODIFIER4 as Modifier4 \n" +
            "from inbox.auth_limits where authkey in (select authkey from inbox.authorizations " +
            "where account='%s' and LOC ='%s' and payor_id ='%s')";
    public static final String SQL_INBOX_AUTHORIZATION = "select error_code from inbox.authorizations " +
            "where account='%s' and payor_id ='%s' AND CLIENT_ID_CUSTOM = '%s'";
}
