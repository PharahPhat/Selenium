package com.interop.sql;

public class ClaimSQL {

    public static final String SQL_GET_CLAIM_BY_ICN =
            "SELECT * " +
            "FROM iodata.intf_rsp_txn_claim_stack " +
            "WHERE ICN = '%s'";

    public static final String SQL_GET_CLAIM_BY_IC_NS =
            "SELECT * " +
                    "FROM iodata.intf_rsp_txn_claim_stack " +
                    "WHERE ICN in (%s)";
}
