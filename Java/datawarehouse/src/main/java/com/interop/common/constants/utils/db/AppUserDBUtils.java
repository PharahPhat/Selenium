package com.interop.common.constants.utils.db;

import com.interop.models.db.inbox.InboxAppUser;
import com.interop.models.db.stx.STXAppUser;
import com.interop.models.db.stx.STXAppUserCLI;

import java.util.List;

import static com.interop.sql.AppUserSQL.*;
import static com.interop.sql.ClientSQL.SQL_STX_APP_USERS;

public class AppUserDBUtils {
    private AppUserDBUtils() {
    }

    public static List<STXAppUser> getAppUser(String accountID, String emailCaseManager) {
        String sqlQuery = String.format(SQL_STX_APP_USERS, accountID, emailCaseManager);
        return DbUtils.getDataFromDatabase(STXAppUser.class, sqlQuery);
    }

    public static List<InboxAppUser> getInboxAppUser(String casemanagerEmail) {
        String getQuery = String.format(GET_INBOX_APP_USERS, casemanagerEmail);
        return DbUtils.getDataFromDatabase(InboxAppUser.class, getQuery);
    }

    public static List<STXAppUser> getSTXAppUserByUserID(String userID) {
        String getQuery = String.format(GET_STX_APP_USER_BY_USERID, userID);
        return DbUtils.getDataFromDatabase(STXAppUser.class, getQuery);
    }

    public static List<STXAppUser> getSTXAppUserCM(String account) {
        String getQuery = String.format(GET_APP_USERS_CM, account);
        return DbUtils.getDataFromDatabase(STXAppUser.class, getQuery);
    }


    public static List<STXAppUser> getSTXAppUserActive(String casemanagerEmail) {
        String getQuery = String.format(GET_STX_APP_USER_ACTIVE, casemanagerEmail);
        return DbUtils.getDataFromDatabase(STXAppUser.class, getQuery);

    }

    public static List<STXAppUserCLI> getSTXAppUserCLI(String casemanagerEmail){
        String getQuery = String.format(GET_STX_APP_USERS_CLI, casemanagerEmail);
        return DbUtils.getDataFromDatabase(STXAppUserCLI.class, getQuery);

    }

    public static List<STXAppUser> getDateletedCM(){
        String getQuery = String.format(GET_DELETED_CM);
        return DbUtils.getDataFromDatabase(STXAppUser.class, getQuery);

    }

    public static List<STXAppUser> getRegAggregatorAcc(){
        String getQuery = String.format(GET_USERNAME_IS_NOT_CM);
        return DbUtils.getDataFromDatabase(STXAppUser.class, getQuery);
    }

    public static List<STXAppUser> getCaseManager(String casemanagerEmail){
        String getQuery = String.format(GET_STX_APP_USER, casemanagerEmail);
        return DbUtils.getDataFromDatabase(STXAppUser.class, getQuery);
    }
}
