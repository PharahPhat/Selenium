package com.sandata.db;

import com.interop.common.StateAccount;
import com.interop.sql.EmployeeSQL;
import com.sandata.utilities.DbUtilsCon;
import org.apache.commons.lang.RandomStringUtils;

import java.util.*;

import static com.interop.common.State.PENNSYLVANIA;
import static com.interop.sql.EmployeeSQL.*;

public class EmployeeDbService extends BaseDbService{
    private static final String EXIST_IN_DB_MSG = " is existing already in database.";
    private List<Map<String, Object>> employeesInDB = new ArrayList<>();
    private static Map<String, List<Map<String, Object>>> empPerf = new HashMap<>();
    private String sqlEmployeeQuery;
    private StateAccount account;

    public EmployeeDbService(){}
    public EmployeeDbService(StateAccount account){
        this.account = account;
        switch (account.getStateEnum()) {
            case PENNSYLVANIA:
                sqlEmployeeQuery = SQL_EMPLOYEE_ALT_EVV_GENERIC_PA;
                break;
            case ARIZONA:
                sqlEmployeeQuery = SQL_EMPLOYEE_ALT_EVV_ARIZONA;
                break;
            case COLORADO:
                sqlEmployeeQuery = SQL_EMPLOYEE_ALT_EVV_COLORADO;
                break;
            default:
                sqlEmployeeQuery = SQL_EMPLOYEE_ALT_EVV_GENERIC;
                break;
        }
    }

    public boolean isEmployeeSequenceNumberExistingInDB(String account, String workerSequenceNumber) {
        String sql = String.format(EmployeeSQL.SQL_GET_WORKER_BY_SEQUENCE_NUMBER,account, workerSequenceNumber);
        int count = DbUtilsCon.getDataTable(  getTestEnvironment().getOracleUrl(), getTestEnvironment(), sql).size();
        return ( count > 0 );
    }

    public boolean isEmployeeSsnExistingInDB(String accountId, String ssn) {
        String sql = String.format(SQL_GET_WORKER_BY_SSN, accountId, ssn);
        int count = DbUtilsCon.getDataTable(  getTestEnvironment().getOracleUrl(), getTestEnvironment(), sql).size();
        if(count>0){
            logInfo("Social Security Number " + ssn + EXIST_IN_DB_MSG);
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmployeeCustomId1ExistingInDB(String accountId, String customId1) {
        String sql = String.format(SQL_GET_WORKER_BY_ID_CUSTOM_1, accountId, customId1);
        int count = DbUtilsCon.getDataTable(  getTestEnvironment().getOracleUrl(), getTestEnvironment(), sql).size();
        return ( count > 0 );
    }

    public boolean isEmployeeStxIdExistingInDB(String accountId, String stxId) {
        String sql = String.format(SQL_GET_WORKER_KEY_BY_STXID, accountId, stxId);
        int count = DbUtilsCon.getDataTable(  getTestEnvironment().getOracleUrl(), getTestEnvironment(), sql).size();
        return ( count > 0 );
    }

    public boolean isEmployeeFNameExistingInDB(String accountId, String fName) {
        String sql = String.format(SQL_GET_WORKERKEY_BY_FIRST_NAME, accountId, fName);
        int count = DbUtilsCon.getDataTable(  getTestEnvironment().getOracleUrl(), getTestEnvironment(), sql).size();
        return ( count > 0 ) ? true : false;
    }

    public boolean isEmployeeLNameExistingInDB(String account, String lName) {
        String sql = String.format(SQL_GET_WORKERKEY_BY_LAST_NAME, account, lName);
        int count = DbUtilsCon.getDataTable(  getTestEnvironment().getOracleUrl(), getTestEnvironment(), sql).size();
        return ( count > 0 ) ? true : false;
    }

    public String getEmployeeFieldValue(String accountId, String employeeLastName, String columnName) {
        String sql = String.format(EmployeeSQL.SQL_GET_EMPLOYEE_GENERAL, accountId, employeeLastName);
        List<Map<String, Object>> dataTable = DbUtilsCon.getDataTable(  getTestEnvironment().getOracleUrl(),
                getTestEnvironment(), sql);
        if ( dataTable.size() < 1 ) {
            logError(String.format("employee with last name '%s', account '%s' not found in database", employeeLastName, accountId));
            return "";
        } else {
            logInfo(String.format("employee with last name '%s', account '%s' found in database", employeeLastName, accountId));
        }
        Object value = dataTable.get(0).get(columnName);
        return String.valueOf(value);
    }

    public Map<String, Object> getEmployeeFieldValues(String accountId, String employeeLastName) {
        String sql = String.format(EmployeeSQL.SQL_GET_EMPLOYEE_GENERAL, accountId, employeeLastName);
        List<Map<String, Object>> dataTable = DbUtilsCon.getDataTable(  getTestEnvironment().getOracleUrl(),
                getTestEnvironment(), sql);
        if ( dataTable.size() < 1 ) {
            logError(String.format("employee with last name '%s', account '%s' not found in database", employeeLastName, accountId));
            return null;
        } else {
            logInfo(String.format("employee with last name '%s', account '%s' found in database", employeeLastName, accountId));
        }
        return dataTable.get(0);
    }

    /***
     * SequenceID = stx.workers.worker_version_number
     * @return
     */
    public String generateNewEmployeeSequenceNumber(String account) {
        String sequenceNUmber = RandomStringUtils.randomNumeric(16);
        while ( isEmployeeSequenceNumberExistingInDB(account, sequenceNUmber) ) {
            logInfo("Worker sequence number " + sequenceNUmber + EXIST_IN_DB_MSG);
            sequenceNUmber = RandomStringUtils.randomNumeric(16);
        }
        return sequenceNUmber;
    }

    /***
     * worker_id_custom1 = StaffOtherID
     * @param account
     * @return
     */
    public String generateNewEmployeeIdCustom1(String account) {
        String workerCustomId1 = RandomStringUtils.randomAlphanumeric(64);
        while ( isEmployeeCustomId1ExistingInDB(account, workerCustomId1) ) {
            logInfo("Worker ID customer 1 " + workerCustomId1 + EXIST_IN_DB_MSG);
            workerCustomId1 = RandomStringUtils.randomAlphanumeric(64);
        }
        return workerCustomId1;
    }

    /***
     * StaffSSN
     * @param accountId
     * @return
     */
    public String generateNewEmployeeSsn(String accountId) {
        String ssn = RandomStringUtils.randomNumeric(9);
        while ( isEmployeeSsnExistingInDB(accountId, ssn) ) {
            ssn = RandomStringUtils.randomNumeric(9);
        }
        return ssn;
    }

    private static final String RI_HEAD_EMPLOYEE_SSN_STR = "00000";
    private static final int RI_USED_SSN_TAIL_STR_LEN = 4;
    private static final int EMPLOYEE_SSN_MAX_CHECKING_TIME = 9999;

    /***
     * StaffSSN
     * @param accountId
     * @return
     */
    public String generateNewRIEmployeeSsn(String accountId) {
        String ssn = RI_HEAD_EMPLOYEE_SSN_STR + RandomStringUtils.randomNumeric(RI_USED_SSN_TAIL_STR_LEN);

        int count = 0;

        do {
            if (!isEmployeeSsnExistingInDB(accountId, ssn)) {
                return ssn;
            }
            ssn = RI_HEAD_EMPLOYEE_SSN_STR + RandomStringUtils.randomNumeric(RI_USED_SSN_TAIL_STR_LEN);

            count++;
        } while (count < EMPLOYEE_SSN_MAX_CHECKING_TIME);

        return null;
    }

    public Map<String, Object> getRandomEmployee(String query, String accountId) {
        if (empPerf.get(accountId) == null) {
            String sql = String.format(query, accountId);
            commons.loggerConsole("------------- SQL: \n" + sql);
            employeesInDB = getDataTable(sql);
            empPerf.put(accountId, employeesInDB);
        }
        if (empPerf.get(accountId) == null) {
            System.out.println(String.format("Employee with account '%s' not found in database", accountId));
            logFail(String.format("Employee with account '%s' not found in database", accountId));
        }

        int randomIndex = new Random().nextInt(empPerf.get(accountId).size());

        return empPerf.get(accountId).get(randomIndex);
    }

    public Map<String, Object> getRandomEmployee() {
        return getRandomEmployee(sqlEmployeeQuery, account.getAccountID());
    }

    public String generateNewEmployeeCustomId(String accountId) {
        String customId1 = commons.generateRandomSsn();
        while ( isEmployeeCustomId1ExistingInDB(accountId, customId1) ) {
            logInfo("Worker ID customer 1 " + customId1 + EXIST_IN_DB_MSG);
            customId1 = commons.generateRandomSsn();
        }
        return customId1;
    }

    /***
     * StaffID
     * @return
     */
    public String generateNewEmployeeStxId(String accountId) {
        String stxId = RandomStringUtils.randomNumeric(9);
        while ( isEmployeeStxIdExistingInDB(accountId, stxId) ) {
            logInfo("Worker stxId " + stxId + EXIST_IN_DB_MSG);
            stxId = RandomStringUtils.randomNumeric(9);
        }
        return stxId;
    }

    public String generateNewEmployeeFName(String accountId) {
        String fName = RandomStringUtils.randomAlphabetic(30);
        while ( isEmployeeFNameExistingInDB(accountId, fName) ) {
            logInfo("Worker first name " + fName + EXIST_IN_DB_MSG);
            fName = RandomStringUtils.randomAlphabetic(30);
        }
        return fName;
    }

    public String generateNewEmployeeLName(String account) {
        String lName = RandomStringUtils.randomAlphabetic(30);
        while ( isEmployeeLNameExistingInDB(account, lName) ) {
            logInfo("Worker last name " + lName + EXIST_IN_DB_MSG);
            lName = RandomStringUtils.randomAlphabetic(30);
        }
        return lName;
    }

    public boolean isEmployeeExistInDatabase(String accountId, String uniqueLastName) {
        String sql = String.format(SQL_GET_WORKERKEY_BY_LAST_NAME, accountId, uniqueLastName);
        return waitDataExistInDb(sql);
    }

    public String generateNewEmployeeSsnMixNumbericAlphabetic(String accountId) {
        String ssn  = RandomStringUtils.randomNumeric(4) + RandomStringUtils.randomAlphabetic(4);
        while ( isEmployeeSsnExistingInDB(accountId, ssn) ) {
            logInfo("Social Security Number " + ssn + EXIST_IN_DB_MSG);
            ssn = RandomStringUtils.randomNumeric(9);
        }
        return ssn;
    }

    public boolean isEmployeesExistInDatabase(String accountId, List<String> lastNames) {
        boolean finalResult = true;
        int limit = 1000;
        if (lastNames.size() <= 1000) {
            finalResult = checkEmployeesExistInDatabase(accountId, lastNames);
        } else {
            int count =  lastNames.size() / limit;
            int surplus = lastNames.size() % limit;
            for ( int i = 1; i <= count; i++ ) {
                List<String> list = lastNames.subList(0, limit);
                boolean result = checkEmployeesExistInDatabase(accountId, list);

                if (result == false) {
                    logInfo("Workers are not added in EVV DB. Waiting 10s to query again.");
                    commons.wait(20);
                    result = checkEmployeesExistInDatabase(accountId, list);
                    if (!result) {
                        finalResult = false;
                    }
                } else {
                    logInfo("Workers are added in EVV DB.");
                }

                lastNames.subList(0, limit).clear();
            }
            List<String> list = lastNames.subList(0, surplus);

            boolean result = checkEmployeesExistInDatabase(accountId, list);
            if (!result) {
                finalResult = false;
            }
            lastNames.subList(0, surplus).clear();
        }

        return finalResult;
    }

    public boolean checkEmployeesExistInDatabase(String accountId, List<String> lastNames) {

        String _lastNames = "";

        for ( int i = 0; i <= lastNames.size() - 1; i++) {
            if (i == lastNames.size() - 1) {
                _lastNames+= "'" + lastNames.get(i) + "'";
            } else {
                _lastNames+= "'" + lastNames.get(i) + "',";
            }
        }

        String sql = String.format(SQL_GET_WORKERS_BY_LAST_NAMES, accountId, _lastNames);
        List<Map<String, Object>> dataTable = getDataTable(sql, lastNames.size());

        for ( int i = 0; i <= lastNames.size() - 1; i++) {
            boolean found = false;
            String lastName = lastNames.get(i);
            for ( int j = 0; j <= dataTable.size() - 1; j++) {

                String LName = dataTable.get(j).get("L_NAME").toString();
                if (lastName.equalsIgnoreCase(LName)) {
                    found = true;
                    break;
                }
            }
            if ( !found ) {
                logInfo(String.format("Employee with last name '%s' is not added in EVV DB.", lastName));
            }
        }

        if (dataTable.size() == lastNames.size()) {
            logInfo(String.format("All '%s' employees are added in EVV DB.", lastNames.size()));
            return true;
        }
        return false;
    }

    public List<String> areWorkerStxIdsExistInDatabase (String accountId, List<String> stxIds) {
        List<String> stxIdsNotExistInDb = new ArrayList<>();


        int limit = 1000;
        if (stxIds.size() <= 1000) {
            stxIdsNotExistInDb = checkWorkersExistInDatabase(accountId, stxIds);
        } else {
            int count = stxIds.size() / limit;
            int surplus = stxIds.size() % limit;
            for ( int i = 1; i <= count; i++ ) {
                List<String> list = stxIds.subList(0, limit);
                List<String> _stxIdsNotInDb = checkWorkersExistInDatabase(accountId, list);

                if (_stxIdsNotInDb.size() > 0) {
                    logInfo("Some Clients are not added in EVV DB.");
                    stxIdsNotExistInDb = commons.plusStringArray(stxIdsNotExistInDb, _stxIdsNotInDb);
                } else {
                    logInfo("1000 Clients are added in EVV DB.");
                }

                stxIds.subList(0, limit).clear();
            }
            List<String> list = stxIds.subList(0, surplus);

            List<String> _stxIdsNotInDb = checkWorkersExistInDatabase(accountId, list);
            if (_stxIdsNotInDb.size() > 0) {
                stxIdsNotExistInDb = commons.plusStringArray(stxIdsNotExistInDb, _stxIdsNotInDb);
            }
            stxIds.subList(0, surplus).clear();
        }

        return stxIdsNotExistInDb;
    }

    public List<String> checkWorkersExistInDatabase(String accountId, List<String> stxIds) {

        List<String> stxIdsNotExistInDd = new ArrayList<>();
        String _stxIds = "";

        for (int i = 0; i <= stxIds.size() - 1; i++) {
            if (i == stxIds.size() - 1) {
                _stxIds += "'" + stxIds.get(i) + "'";
            } else {
                _stxIds += "'" + stxIds.get(i) + "',";
            }
        }

        String sql = String.format(SQL_GET_WORKERS_BY_STXID, accountId, _stxIds);
        List<Map<String, Object>> dataTable = getDataTable(sql, stxIds.size());

        for (int i = 0; i <= stxIds.size() - 1; i++) {
            boolean found = false;
            String _stxid = stxIds.get(i);
            for (int j = 0; j <= dataTable.size() - 1; j++) {

                String stxidInDB = dataTable.get(j).get("STX_ID").toString();
                if (_stxid.equalsIgnoreCase(stxidInDB)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                logInfo(String.format("Worker with STX ID '%s' is not added in EVV DB.", _stxid));
                stxIdsNotExistInDd.add(_stxid);
            }
        }

        if (dataTable.size() == stxIds.size()) {
            logInfo(String.format("All '%s' workers are added in EVV DB.", stxIds.size()));
        }
        return stxIdsNotExistInDd;
    }
}
