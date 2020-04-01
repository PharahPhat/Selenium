package com.interop.common.constants.utils.db;

import com.interop.common.TestDataHelper;
import com.interop.models.db.inbox.InboxAuthorization;
import com.interop.models.db.staging.StagingAuth;
import com.interop.models.db.staging.StagingAuthLimit;
import com.interop.models.db.stx.STXAuthorization;
import com.sandata.core.Wrapper;
import com.sandata.utilities.ColumnAnnotationMapper;
import com.sandata.utilities.DbUtilsCon;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.interop.common.constants.queries.InterOpMySQL.*;
import static com.interop.common.constants.queries.InterOpOracle.*;

public class AuthDBUtils {
    private static final String EXECUTE_QUERY_STR = "Execute the query : ";
    private static final String CANNOT_ACCESS_DB_STR = "Cannot access to DB";
    private static final String AUTH_ID_STR = "AUTH_ID";
    private static Wrapper baseObj = new Wrapper();

    private AuthDBUtils() {
    }

    public static BidiMap<String, String> getListFilesProcessed() {
        BidiMap<String, String> data = new DualHashBidiMap<>();
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), MY_SQL_GET_FILE_TRANSFER)) {
            while (rs.next()) {
                String value = rs.getString("account_intf_trans_status_desc");
                String key = rs.getString("account_intf_trans_guid");
                data.put(key, value);
                baseObj.info(data.toString());
            }
        } catch (SQLException e) {
            baseObj.error(CANNOT_ACCESS_DB_STR, e);
        }
        return data;
    }

    /**
     * This value to get id of service EVV Import Auth
     *
     * @param accountNum account id
     * @return String
     */
    public static String getIDServiceEVVImportAuth(String accountNum) {
        String mySQLQuery = String.format(MY_SQL_GET_CONFIG_ID_EVV_IMPORT_AUTH, accountNum);
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), mySQLQuery)) {
            if (rs.next()) {
                return rs.getString("account_intf_conf_sk");
            }
        } catch (SQLException e) {
            baseObj.error(CANNOT_ACCESS_DB_STR, e);
        }
        return null;
    }

    /**
     * Get Matching service ID
     *
     * @param accountNum account id
     * @return String
     */
    public static String getIDMatchingService(String accountNum) {
        String mySQLQuery = null;
        if (accountNum.equalsIgnoreCase("28000")) {
            mySQLQuery = String.format(MY_SQL_GET_CONFIG_MATCHING_SERVICE_MOLINA, accountNum);
        } else {
            mySQLQuery = String.format(MY_SQL_GET_CONFIG_MATCHING_SERVICE, accountNum);
        }
        String servicesID = null;
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), mySQLQuery)) {
            while (rs.next()) {
                servicesID = rs.getString("account_intf_conf_sk");
            }
        } catch (SQLException e) {
            baseObj.error(CANNOT_ACCESS_DB_STR, e);
        }
        return servicesID;
    }

    public static void verifyAuthImportedSuccessWithoutErrorCode(String comment, int expectedRows) {
        int timeAttempt = 5;
        int rows;
        do {
            rows = getNumRecordInsertStagingByComment(comment);
            if (rows > 0)
                break;
            timeAttempt--;
            baseObj.info("Hold process in 1 minutes to wait data is stored to DB");
            baseObj.sleep(60000);
        } while (timeAttempt > 0);

        Assert.assertEquals(rows, expectedRows, "0 Operation success");

    }

    public static void verifyProviderImportedSuccessWithoutErrorCode(String authRefNumber) {
        int timeAttempt = 5;
        int totalRecord;
        do {
            List<InboxAuthorization> listDbRecord = getInboxAuthorization(authRefNumber);
            totalRecord = listDbRecord.size();

            if (totalRecord == 0) {
                timeAttempt--;
                baseObj.info("Hold process in 1 minutes to wait data is stored to DB");
                baseObj.sleep(60000);
            } else {
                InboxAuthorization record = listDbRecord.get(0);
                Assert.assertEquals(record.getERROR_CODE(), "0 Operation success");
            }
        } while (totalRecord == 0 && timeAttempt > 0);
    }

    public static String getAuthID(String authRefNumber) {
        String mySQLQuery = String.format(QUERY_GET_AUTH_INFO_IN_AUTH_TABLE, authRefNumber);
        String authID = null;
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), mySQLQuery)) {
            while (rs.next()) {
                authID = rs.getString(AUTH_ID_STR).trim();
            }
        } catch (SQLException e) {
            baseObj.error(CANNOT_ACCESS_DB_STR, e);
        }
        baseObj.info(String.format("The auth ID of the authorization having refNumber : %s is %s", authRefNumber, authID));
        return authID;
    }

    public static boolean isTheAuthorizationExistedInAuthLimitTable(String authID) {
        boolean isTheAuthExisted = false;
        String mySQLQuery = String.format(QUERY_GET_AUTH_LIMIT_INFO, authID);
        baseObj.info(EXECUTE_QUERY_STR + mySQLQuery);
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), mySQLQuery)) {
            if (rs.next())
                isTheAuthExisted = true;
        } catch (SQLException e) {
            baseObj.error(CANNOT_ACCESS_DB_STR, e);
        }
        return isTheAuthExisted;
    }

    public static List<InboxAuthorization> getInboxAuthorization(String authRefNum) {
        String getQuery = String.format(QUERY_GET_AUTHORIZATION_INFO_WITH_SPECIFIC_AUTH_REF_NUM, authRefNum);
        return DbUtils.getDataFromDatabase(InboxAuthorization.class, getQuery);
    }

    public static int getNumRecordInsertStagingByComment(String comment) {
        String query = String.format(COUNT_AUTH_IN_STAGING_BY_COMMENT, comment);
        String rows = "-1";
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), query)) {
            while (rs.next()) {
                rows = rs.getString("rows").trim();
            }
        } catch (SQLException e) {
            return -1;
        }
        return Integer.parseInt(rows);
    }

    public static List<StagingAuth> getStagingAuthorization(String authRefNum) {
        String getQuery = String.format(MY_SQL_GET_AUTHSTAGING, authRefNum);
        ColumnAnnotationMapper<StagingAuth> mapper = new ColumnAnnotationMapper<>(StagingAuth.class);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }

    public static List<StagingAuthLimit> getStagingAuthLimit(String transGUID) {
        String getQuery = String.format(MY_SQL_GET_AUTH_LIMIT_INFO_STAGING, transGUID);
        ColumnAnnotationMapper<StagingAuthLimit> mapper = new ColumnAnnotationMapper<>(StagingAuthLimit.class);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }

    public static List<STXAuthorization> getSTXAuthorization(String authRefNum) {
        String getQuery = String.format(GET_AUTHORIZATION_IN_STX_TABLE, authRefNum);
        return DbUtils.getDataFromDatabase(STXAuthorization.class, getQuery);
    }

    public static List<InboxAuthorization> getInboxAuthorizationFromQuery(String querySQL) {
        return DbUtils.getDataFromDatabase(InboxAuthorization.class, querySQL);
    }
}
