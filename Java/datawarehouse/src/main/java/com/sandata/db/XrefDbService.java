package com.sandata.db;

import com.interop.common.constants.utils.db.DbUtils;
import com.interop.models.db.stx.STXXref;

import java.util.List;

import static com.interop.services.base.ImportBaseTest.stateAccount;
import static com.interop.sql.xrefSQL.SQL_GET_XREF_INO;

public class XrefDbService {

    public static List<STXXref> getXrefSTXRecords(String clientID, String service) {
        String getQuery = String.format(SQL_GET_XREF_INO, stateAccount.getAccountID(), clientID,
                service);
        return DbUtils.getDataFromDatabase(STXXref.class, getQuery);
    }
}
