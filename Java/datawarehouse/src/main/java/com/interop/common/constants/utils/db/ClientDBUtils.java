package com.interop.common.constants.utils.db;

import com.interop.common.Commons;
import com.interop.common.State;
import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.models.db.inbox.InboxClientContact;
import com.interop.models.db.stx.STXAni;
import com.interop.models.db.stx.STXClient;
import com.interop.models.db.stx.STXClientAuth;
import com.interop.models.db.stx.STXClientContact;
import com.sandata.utilities.DbUtilsCon;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.interop.common.constants.FieldConstants.MEDICAID_ID;
import static com.interop.common.constants.FieldConstants.PROVIDER_ID;
import static com.interop.common.constants.queries.InterOpMySQL.*;
import static com.interop.common.constants.queries.InterOpOracle.*;
import static com.interop.sql.ClientSQL.SQL_STX_CLIENT;
import static com.interop.sql.ClientSQL.SQL_STX_CLIENT_CONTACT_BY_EMAIL;

public class ClientDBUtils {
    private static final Logger LOGGER = Logger.getLogger(ClientDBUtils.class);

    private ClientDBUtils() {
    }

    public static List<STXClientAuth> getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(StateAccount account, int lengthMedicaidID) {
        String sqlQuery;
        State stateName = StateAccount.loadStateAccount().getStateEnum();
        String accountType = StateAccount.loadStateAccount().getAccountType();

        switch (stateName) {
            case PENNSYLVANIA:
                sqlQuery = String.format(QUERY_GET_CLIENT_HAVING_SPECIFIC_MEDICAID_ID, account.getAccountID(), lengthMedicaidID);
                break;
            case ARIZONA:
                if (accountType.equals(Commons.AccountType.AMP_WS.toString()))
                    sqlQuery = String.format(QUERY_GET_CLIENT_CLIENT_CUSTOM_ID_REG, account.getAccountID(), "^[A-Z]\\d(8)");
                else
                    sqlQuery = String.format(QUERY_GET_CLIENT_CLIENT_CUSTOM_ID, account.getAccountID());
                break;
            case HAWAII:
                sqlQuery = String.format(QUERY_GET_CLIENT_CLIENT_CUSTOM_ID_REG, account.getAccountID(), "^\\d{10}");
                break;
            default:
                sqlQuery = String.format(QUERY_GET_CLIENT_HAVING_SPECIFIC_CLIENT_CUSTOM_ID, account.getAccountID());
                break;
        }
        return DbUtils.getDataFromDatabase(STXClientAuth.class, sqlQuery);
    }

    public static List<STXClient> getClient(String accountID, String lName, String fName) {
        String querySQL = String.format(SQL_STX_CLIENT, accountID, lName, fName);
        return DbUtils.getDataFromDatabase(STXClient.class, querySQL);
    }

    public static List<STXClientContact> getClientContact(String accountID, String clientID) {
        String querySQL = String.format(SQL_STX_CLIENT_CONTACT_BY_CLIENTID, accountID, clientID);
        return DbUtils.getDataFromDatabase(STXClientContact.class, querySQL);
    }

    public static List<STXClientContact> getClientContactByEmail(String accountID, String email) {
        String querySQL = String.format(SQL_STX_CLIENT_CONTACT_BY_EMAIL, accountID, email);
        return DbUtils.getDataFromDatabase(STXClientContact.class, querySQL);
    }

    public static List<InboxClientContact> getClientContactInbox(String accountID, String fName) {
        String querySQL = String.format(GET_CLIENT_CONTACT_BY_CLIENT_FNAME, fName, accountID);
        return DbUtils.getDataFromDatabase(InboxClientContact.class, querySQL);
    }

    public static List<STXAni> getClientPhone(String accountID, String loc) {
        String querySQL = String.format(GET_CLIENT_ANI, loc, accountID);
        return DbUtils.getDataFromDatabase(STXAni.class, querySQL);
    }


    public static List<STXClient> getClientInSTX(String clientFName, String clientLName) {
        String account = StateAccount.loadStateAccount().getAccountID();
        String querySQL = String.format(SQL_STX_CLIENT, account, clientLName,
                clientFName);
        return DbUtils.getDataFromDatabase(STXClient.class, querySQL);
    }

    public static String getIDServiceEVVImportMember(String accountID) {
        String mySQLQuery = String.format(MY_SQL_GET_CONFIG_ID_EVV_IMPORT_MEMBER, accountID);
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), mySQLQuery)) {
            if (rs.next()) {
                return rs.getString("account_intf_conf_sk");
            }
        } catch (SQLException e) {
            LOGGER.info("Cannot get record", e);
        }
        return null;
    }

    public static List<Map<String, String>> getMedicaidID(StateAccount account) {
        String sqlQuery;
        State stateName = StateAccount.loadStateAccount().getStateEnum();
        switch (stateName){
            case HAWAII:
                sqlQuery = String.format(GET_CLIENT_MEDICAID_ID, account.getAccountID(), "^\\d{10}");
                break;
            case ARIZONA:
                sqlQuery = String.format(GET_CLIENT_MEDICAID_ID, account.getAccountID(),"^[A-Z]\\d(8)");
                break;
            default:
                 sqlQuery = String.format(GET_CLIENT_MEDICAID_ID, account.getAccountID(),"^.");
                 break;
        }

        List<Map<String, String>> clientInfos = new ArrayList<>();
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery)) {
            while (rs.next()) {
                Map<String, String> clientInfo = new HashMap<>();
                clientInfo.put(MEDICAID_ID, rs.getString("MEDICAID_ID"));
                clientInfo.put(PROVIDER_ID, rs.getString("PROVIDER_ID"));
                clientInfos.add(clientInfo);
            }
        } catch (SQLException e) {
            LOGGER.error("Cannot access to DB", e);
        }
        return clientInfos;
    }
}
