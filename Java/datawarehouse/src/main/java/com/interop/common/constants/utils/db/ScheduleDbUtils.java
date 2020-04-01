package com.interop.common.constants.utils.db;

import com.interop.models.db.inbox.InboxSchedule;
import com.interop.models.db.stx.STXSchedule;

import java.util.List;

import static com.interop.sql.ScheduleSQL.*;

public class ScheduleDbUtils {
    private ScheduleDbUtils() {
    }

    public static List<STXSchedule> getSchedule(String accountID, String ctrlNum) {
        String querySQL = String.format(SQL_STX_SCHEDULE, accountID, ctrlNum);
        return DbUtils.getDataFromDatabase(STXSchedule.class, querySQL);
    }

    public static List<STXSchedule> getScheduleBySCHKEY(String accountID, String schKey) {
        String querySQL = String.format(SQL_STX_SCHEDULE_BY_SCHKEY, accountID, schKey);
        return DbUtils.getDataFromDatabase(STXSchedule.class, querySQL);
    }

    public static List<InboxSchedule> getSCHKEYFromInboxSchedule(String accountID, String visitVersionNumber) {
        String querySQL = String.format(SQL_INBOX_SCHEDULE_SCHKEY, accountID, visitVersionNumber);
        return DbUtils.getDataFromDatabase(InboxSchedule.class, querySQL);
    }
}
