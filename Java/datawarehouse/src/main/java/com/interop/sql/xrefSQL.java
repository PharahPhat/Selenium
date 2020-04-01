package com.interop.sql;

public class xrefSQL {
    public static final String SQL_GET_XREF_INO =
            "SELECT \n" +
                    "  XREF_SVC_ID, \n" +
                    "  BEG_DATE, \n" +
                    "  END_DATE, \n" +
                    "  ACCOUNT, \n" +
                    "  LOC, \n" +
                    "  STX_ID, \n" +
                    "  SERVICE, \n" +
                    "  SERVICE_CODE, \n" +
                    "  AUTH_REF_NUMBER \n" +
                    "FROM \n" +
                    "  STX.XREF_SERVICES \n" +
                    "WHERE \n" +
                    "  ACCOUNT = '%s' \n" +
                    "AND LOC = '%s' \n" +
                    "AND SERVICE = '%s' \n";
}
