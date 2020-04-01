package com.interop.common.constants.utils.db;

import com.interop.models.db.inbox.InboxProvider;
import com.interop.models.db.staging.ExclusionProviderId;
import com.interop.models.db.stx.STXAppUser;
import com.interop.models.db.stx.STXProvider;
import com.interop.models.db.stx.STXProviderCredential;
import com.interop.common.TestDataHelper;
import com.sandata.core.Wrapper;
import com.sandata.core.config.TestConfiguration;
import com.sandata.core.config.TestContext;
import com.sandata.utilities.ColumnAnnotationMapper;
import com.sandata.utilities.DbUtilsCon;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.interop.common.constants.queries.InterOpMySQL.GET_EXCLUSION_PROVIDER_ID;
import static com.interop.common.constants.queries.InterOpMySQL.MY_SQL_GET_CONFIG_ID_EVV_IMPORT_PROVIDER;
import static com.interop.common.constants.queries.InterOpOracle.*;
import static com.interop.common.constants.queries.InterOpSQL.*;

public class ProviderDBUtils {
    private static final Logger LOGGER = Logger.getLogger(ProviderDBUtils.class);

    private static final String CANNOT_ACCESS_DB_STR = "Cannot access to DB";
    private static final String DATA_SCOPE_ID_STR = "DATA_SCOPE_ID";
    private static Wrapper baseObj = new Wrapper();


    public static void isProviderStoredToINBOXWithoutError(String providerID) {
        baseObj.info("Starting get Data provider in EVV INBOX table to verify");
        int timeAttempt = 5;
        int totalRecord = 0;
        do {
            List<InboxProvider> listDbRecord = getRecordProviderInbox(providerID);
            totalRecord = listDbRecord.size();

            if (totalRecord == 0) {
                timeAttempt--;
                baseObj.info("Hold process in 1 minutes to wait data is stored to DB");
                baseObj.sleep(60000);
            } else {
                InboxProvider record = listDbRecord.get(0);
                Assert.assertEquals(record.getERROR_CODE(), "0 Operation success");
                baseObj.info("The provider is stored to inbox table with status is SUCCESS");
            }
        } while (totalRecord == 0 && timeAttempt > 0);

        if (totalRecord == 0 && timeAttempt == 0) {
            baseObj.fail(String.format("Provider Id %s is not inserted into inbox table", providerID));
        }
    }

    public static String getAgencyIDInAMPDB(String providerID) throws InterruptedException, SQLException {
        int retryCount = 10;
        String sqlQuery = String.format(SQL_CHECK_SANTRAX_AC_EXISTED, providerID);
        String agencyID = null;
        do {
            try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getSQLConnection(), sqlQuery)) {
                if (rs.next())
                    agencyID = rs.getString("jalParentID").trim();
            } finally {
                LOGGER.info("Cannot find the record in AMP DB JVAgency table");
                LOGGER.info("Sleeping 1 minute(s) ... ");
                Thread.sleep(60000);
                retryCount--;
            }
        } while (agencyID == null && retryCount > 0);

        if (agencyID == null) {
            baseObj.info("Data is not inserted in to AMP SQL");
            baseObj.fail("No data having jalAgencyID = " + providerID);
        }
        LOGGER.info("Data is stored to AMP DB with Agency ID = " + agencyID);
        return agencyID;
    }

    public static String getAgencyDBInAMPDB(String agencyID) {
        String sqlQuery = String.format(SQL_GET_AGENCY_DB, agencyID);
        String agencyDb = null;
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getSQLConnection(), sqlQuery)) {
            if (rs.next()) {
                agencyDb = rs.getString("agencyDB").trim();
            }
        } catch (SQLException e) {
            LOGGER.error(CANNOT_ACCESS_DB_STR, e);
        }
        if (agencyDb == null) {
            baseObj.fail("No agency DB is stored in AMP site");
        }
        baseObj.info("Data agency is created successfully");
        baseObj.info(String.format("Agency DB is stored in AMP DB with agency DB = %s", agencyDb));
        return agencyDb;
    }

    public static void verifyBasicAMPConfiguration(String agencyDB) {
        TestConfiguration config = TestContext.get();
        String sqlQuery = String.format(SQL_GET_AMP_BASIC_CONFIGURATION, agencyDB);
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getSQLConnection(), sqlQuery)) {
            while (rs.next()) {
                baseObj.info("Verify config Live in table agency");
                baseObj.validateActualAndExpectedText(rs.getString("iSLive").trim(), "1");
                baseObj.info("Verify config SantraxServiceName in table agency");
                baseObj.validateActualAndExpectedText(rs.getString("SantraxServiceName").trim(), config.getEnvironment("SANTRAX_Service_Name"));
                baseObj.info("Verify config EnableSantraxSupport in table agency");
                baseObj.validateActualAndExpectedText(rs.getString("EnableSantraxSupport").trim(), "1");
                baseObj.info("Verify config SantraxScheduleProcessingMethod in table agency, it must be S or B");
                String santraxSCValue = rs.getString("SantraxScheduleProcessingMethod").trim();
                baseObj.info("Value of SantraxScheduleProcessingMethod in table agency is " + santraxSCValue);
                Assert.assertTrue(santraxSCValue.equalsIgnoreCase("S")
                        || santraxSCValue.equalsIgnoreCase("B"));
            }
        } catch (SQLException e) {
            LOGGER.error(CANNOT_ACCESS_DB_STR, e);
        }
    }

    public static void verifyOpenAndSantraxConfiguration(String agencyDB) {
        String sqlQuery = String.format(SQL_GET_SANTRAX_AND_OPEN_EVV_CONFIGURATION, agencyDB, agencyDB, agencyDB);
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getSQLConnection(), sqlQuery)
        ) {
            while (rs.next()) {
                String configName = rs.getString("configName");
                String configValue = rs.getString("configValue");
                String accountNumber = agencyDB.substring(agencyDB.indexOf('_') + 1);
                if (configName.equalsIgnoreCase("Santrax")) {
                    baseObj.info("Verify is value SANTRAX was turned On");
                    baseObj.validateActualAndExpectedText(configValue.trim(), ("1"));
                }
                if (configName.equalsIgnoreCase("Santrax OPWD")) {
                    baseObj.info("Verify is value password must have value");
                    baseObj.info(String.format("Password is %s", configValue));
                    Assert.assertFalse(configValue.isEmpty());
                }
                if (configName.equalsIgnoreCase("Santrax WUID")) {
                    baseObj.info("Verify is value The account number must be correct");
                    baseObj.validateActualAndExpectedText(configValue, (accountNumber));
                }
                if (configName.equalsIgnoreCase("Use Open EVV")) {
                    baseObj.info("Verify is value Use Open EVV was turned OFF");
                    baseObj.validateActualAndExpectedText(configValue, ("0"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(CANNOT_ACCESS_DB_STR, e);
        }
    }

    public static void verifyTelephonyConfiguration(String agencyDB) {
        String sqlQuery = String.format(SQL_GET_TELEPHONY_CONFIGURATION, agencyDB);
        baseObj.info("Verify config telephone for the new provider in AMP db");
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getSQLConnection(), sqlQuery)) {
            while (rs.next()) {
                String telephoneValue = rs.getString("pyrTelephony");
                String stxAccountNo = rs.getString("pyrSantraxAcctNo");
                String accountNumber = agencyDB.substring(agencyDB.indexOf('_') + 1);
                baseObj.info("Verify the telephony is turned on new account, the value must be 1");
                baseObj.validateActualAndExpectedText(telephoneValue.trim(),"1");
                baseObj.info("Verify the the account number");
                baseObj.validateActualAndExpectedText(stxAccountNo.trim(),accountNumber);
            }
        } catch (SQLException e) {
            LOGGER.error(CANNOT_ACCESS_DB_STR, e);
        }
    }

    public static List<ExclusionProviderId> getExclusionProviderID() {
        ColumnAnnotationMapper<ExclusionProviderId> mapper = new ColumnAnnotationMapper<>(ExclusionProviderId.class);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), GET_EXCLUSION_PROVIDER_ID);
        return mapper.DataTableMapper(rs);
    }

    public static String getIDServiceEVVImportProvider(String accountNum) {
        String mySQLQuery = String.format(MY_SQL_GET_CONFIG_ID_EVV_IMPORT_PROVIDER, accountNum);
        try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), mySQLQuery)) {
            if (rs.next()) {
                return rs.getString("account_intf_conf_sk");
            } else {
                baseObj.fail("Could not find config import provider from database mysql");
            }
        } catch (SQLException e) {
            LOGGER.error(CANNOT_ACCESS_DB_STR, e);
        }
        return null;
    }

    public static List<InboxProvider> getRecordProviderInbox(String providerID) {
        String getQuery = String.format(QUERY_GET_PROVIDER_INBOX, providerID);
        return DbUtils.getDataFromDatabase(InboxProvider.class, getQuery);
    }

    public static List<STXProvider> getRecordProviderSTX(String providerID) {
        String getQuery = String.format(QUERY_TO_CHECK_PROVIDER_IN_STX_TABLE, providerID);
        return DbUtils.getDataFromDatabase(STXProvider.class, getQuery);
    }

    public static List<STXAppUser> getRecordJVAdminOfSpecificState(AccountTemplate accountTemplate) {
        String getQuery = String.format(QUERY_TO_GET_JV_ADMIN_OF_SPECIFIC_ACCOUNT, accountTemplate.getDataScopeID());
        return DbUtils.getDataFromDatabase(STXAppUser.class, getQuery);
    }

    public static List<STXAppUser> getSTXAppUser(String email, String account) {
        String getQuery = String.format(QUERY_TO_GET_APP_USER, email, account);
        return DbUtils.getDataFromDatabase(STXAppUser.class, getQuery);
    }

    public static List<STXProviderCredential> getProviderCredential(String account) {
        String getQuery = String.format(GET_PROVIDER_CREDENTIAL_BASED_ON_ACCOUNT, account);
        return DbUtils.getDataFromDatabase(STXProviderCredential.class, getQuery);
    }

    public enum AccountTemplate {
        MOLINA(28000, 231),
        PENNSYLVANIA(60130, 271),
        INDIANA(29000, 241),
        COLORADO(70001, 261);
        private int accountNumber;
        private int dataScopeID;
        private int groupKey;

        AccountTemplate(int accountNumber, int groupKey) {
            this.accountNumber = accountNumber;
            this.dataScopeID = getDataScopeIDBasedOnTemplate(getAccountNumber());
            this.groupKey = groupKey;
        }

        private static int getDataScopeIDBasedOnTemplate(int accountTemplate) {
            String sqlQuery = String.format(GET_DATA_SCOPE_ID, accountTemplate);
            try (ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery)) {
                while (rs.next()) {
                    return Integer.parseInt(rs.getString(DATA_SCOPE_ID_STR).trim());
                }
            } catch (SQLException e) {
                LOGGER.error(CANNOT_ACCESS_DB_STR, e);
            }
            return 0;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public int getDataScopeID() {
            return dataScopeID;
        }

        public int getGroupKey() {
            return groupKey;
        }
    }
}
