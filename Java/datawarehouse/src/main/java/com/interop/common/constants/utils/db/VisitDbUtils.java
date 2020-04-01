package com.interop.common.constants.utils.db;

import com.interop.models.db.inbox.InboxVisitsTasks;
import com.interop.models.db.stx.STXVisit;

import java.util.List;

import static com.interop.sql.VisitSQL.*;

public class VisitDbUtils {
    private VisitDbUtils() {
    }

    public static List<STXVisit> getVisit(String accountID, String sequenceID) {
        String querySQL = String.format(SQL_STX_VISIT, accountID, sequenceID);
        return DbUtils.getDataFromDatabase(STXVisit.class, querySQL);
    }

    public static List<STXVisit> getVerifiedVisit(String accountID, String sequenceID) {
        String querySQL = String.format(SQL_STX_VISIT_VERIFIED, accountID, sequenceID);
        return DbUtils.getDataFromDatabase(STXVisit.class, querySQL);
    }

    public static List<InboxVisitsTasks> getInboxTaskVisit(String visitID, String taskID) {
        String querySQL = String.format(SQL_GET_VISIT_TASKS, visitID, taskID);
        return DbUtils.getDataFromDatabase(InboxVisitsTasks.class, querySQL);
    }
}
