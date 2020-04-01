package com.sandata.db;

import com.interop.common.Commons;
import com.interop.common.StateAccount;
import com.interop.sql.ClientSQL;
import com.sandata.utilities.DbUtilsCon;
import org.apache.commons.lang.RandomStringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.interop.sql.ClientSQL.*;


public class ClientDbService extends BaseDbService {
    private static final String CLIENT_NOT_ADD_MSG = "Client with client id '%s' is not added in EVV DB.";
    private static final String CLIENT_ADD_MSG = "All '%s' clients are added in EVV DB.";
    private static final String EXIST_IN_DB_MSG = " is existing already in database.";
    private static Map<String, List<Map<String, Object>>> clientsPerf = new HashMap<>();
    private List<Map<String, Object>> clientsInDB = new ArrayList<>();
    private String sqlClientQuery;
    private StateAccount account;

    public ClientDbService() {
    }

    public ClientDbService(StateAccount account) {
        this.account = account;
        if (this.account.getAccountType() != null && this.account.getAccountType().equalsIgnoreCase(Commons.AccountType.AMP.toString()))
            this.sqlClientQuery = SQL_CLIENT_OPEN_EVV_GENERIC;
        else switch (this.account.getStateEnum()) {
            case COLORADO:
                this.sqlClientQuery = SQL_CLIENT_ALT_EVV_GENERIC_COLORADO;
                break;
            case ARIZONA:
                this.sqlClientQuery = SQL_CLIENT_ALT_EVV_GENERIC_ARIZONA;
                break;
            case WISCONSIN:
                this.sqlClientQuery = SQL_CLIENT_ALT_EVV_WISCONSIN;
                break;
            case PENNSYLVANIA:
                this.sqlClientQuery = SQL_CLIENT_ALT_EVV_PENNSYLVANIA;
                break;
            default:
                this.sqlClientQuery = SQL_CLIENT_ALT_EVV_GENERIC;
                break;
        }
    }

    private boolean isClientMedicaidIdExistingInDB(String accountId, String medicaidId) {
        String sql = String.format(ClientSQL.SQL_GET_CLIENT_BY_MEDICAID_ID, accountId, medicaidId);
        int count = DbUtilsCon.getDataTable(this.getTestEnvironment().getOracleUrl(), this.getTestEnvironment(), sql).size();
        return (count > 0);
    }

    private boolean isClientIDCustomer1ExistingInDB(String accountId, String clientIdCustomer1) {
        String sql = String.format(ClientSQL.SQL_GET_CLIENT_ID_CUSTOMER1, accountId, clientIdCustomer1);
        int count = DbUtilsCon.getDataTable(this.getTestEnvironment().getOracleUrl(), this.getTestEnvironment(), sql).size();
        return (count > 0);
    }

    private boolean isClientIDCustomer2ExistingInDB(String clientIdCustomer2) {
        String sql = String.format(ClientSQL.SQL_GET_CLIENT_ID_CUSOTMER2, clientIdCustomer2);
        int count = DbUtilsCon.getDataTable(this.getTestEnvironment().getOracleUrl(), this.getTestEnvironment(), sql).size();
        return (count > 0);
    }

    public boolean isClientFNameExistingInDB(String account, String fName) {
        String sql = String.format(ClientSQL.SQL_GET_CLIENT_BY_FNAME, account, fName);
        int count = DbUtilsCon.getDataTable(this.getTestEnvironment().getOracleUrl(), this.getTestEnvironment(), sql).size();
        return (count > 0);
    }

    public boolean areClientsExistingInDB(String account, List<String> fNames) {

        String _firstNames = "";

        for (int i = 0; i <= fNames.size() - 1; i++)
            if (i == fNames.size() - 1) _firstNames += "'" + fNames.get(i) + "'";
            else
                _firstNames += "'" + fNames.get(i) + "',";

        String sql = String.format(ClientSQL.SQL_GET_CLIENTS_BY_F_NAMES, account, _firstNames);
        int count = DbUtilsCon.getDataTable(this.getTestEnvironment().getOracleUrl(), this.getTestEnvironment(), sql).size();

        return (count == fNames.size());
    }

    public boolean areClientsExistInDatabaseByFName(String accountId, List<String> fNames) {

        String _fNames = "";

        for (int i = 0; i <= fNames.size() - 1; i++)
            if (i == fNames.size() - 1) _fNames += "'" + fNames.get(i) + "'";
            else
                _fNames += "'" + fNames.get(i) + "',";

        String sql = String.format(SQL_GET_CLIENTS_BY_FIRSTNAMES, accountId, _fNames);
        List<Map<String, Object>> dataTable = this.getDataTable(sql, fNames.size());

        for (int i = 0; i <= fNames.size() - 1; i++) {
            boolean found = false;
            String clientId = fNames.get(i);
            for (int j = 0; j <= dataTable.size() - 1; j++) {

                String loc = dataTable.get(j).get("LOC").toString();
                if (clientId.equalsIgnoreCase(loc)) {
                    found = true;
                    break;
                }
            }
            if (!found) this.logInfo(String.format(CLIENT_NOT_ADD_MSG, clientId));
        }

        if (dataTable.size() == fNames.size()) {
            this.logInfo(String.format(CLIENT_ADD_MSG, fNames.size()));
            return true;
        }
        return false;
    }

    public boolean areClientsExistInDatabase(String accountId, List<String> clientIDs) {

        String listOfClientIDsString = clientIDs.stream().collect(Collectors.joining("','", "'", "'"));
//        StringBuilder stringBuilderClientIDs = new StringBuilder();
        /*for (int i = 0; i <= clientIDs.size() - 1; i++) {
            if (i == clientIDs.size() - 1) {
                stringBuilderClientIDs.append("'").append(clientIDs.get(i)).append("'");
            } else {
                stringBuilderClientIDs.append("'").append(clientIDs.get(i)).append("',");
            }
        }*/

        String sql = String.format(SQL_GET_CLIENTS_BY_CLIENTID, accountId, listOfClientIDsString);
        List<Map<String, Object>> dataTable = this.getDataTable(sql, clientIDs.size());

        for (int i = 0; i <= clientIDs.size() - 1; i++) {
            boolean found = false;
            String clientId = clientIDs.get(i);
            for (int j = 0; j <= dataTable.size() - 1; j++) {

                String loc = dataTable.get(j).get("LOC").toString();
                if (clientId.equalsIgnoreCase(loc)) {
                    found = true;
                    break;
                }
            }
            if (!found) this.logInfo(String.format(CLIENT_NOT_ADD_MSG, clientId));
        }

        if (dataTable.size() == clientIDs.size()) {
            this.logInfo(String.format(CLIENT_ADD_MSG, clientIDs.size()));
            return true;
        }
        return false;
    }

    public boolean areClientLastNameExistInDatabase(String accountId, List<String> clientLastNames) {
        boolean finalResult = true;
        int limit = 1000;
        if (clientLastNames.size() <= 1000)
            finalResult = this.checkClientLastNameExistInDatabase(accountId, clientLastNames);
        else {
            int count = clientLastNames.size() / limit;
            int surplus = clientLastNames.size() % limit;
            for (int i = 1; i <= count; i++) {
                List<String> list = clientLastNames.subList(0, limit);
                boolean result = this.checkClientLastNameExistInDatabase(accountId, list);

                if (result == false) {
                    this.logInfo("Clients are not added in EVV DB. Waiting 10s to query again.");
                    this.commons.wait(10);
                    result = this.checkClientLastNameExistInDatabase(accountId, list);
                    if (result == false) finalResult = false;
                } else this.logInfo("Clients are added in EVV DB.");

                clientLastNames.subList(0, limit).clear();
            }
            List<String> list = clientLastNames.subList(0, surplus);

            boolean result = this.checkClientLastNameExistInDatabase(accountId, list);
            if (!result) finalResult = false;
            clientLastNames.subList(0, surplus).clear();
        }

        return finalResult;
    }

    private boolean checkClientLastNameExistInDatabase(String accountId, List<String> clientLastNames) {

        String _clientLastNames = "";

        for (int i = 0; i <= clientLastNames.size() - 1; i++)
            if (i == clientLastNames.size() - 1) _clientLastNames += "'" + clientLastNames.get(i) + "'";
            else
                _clientLastNames += "'" + clientLastNames.get(i) + "',";

        String sql = String.format(SQL_GET_CLIENT_BY_LNAMES, accountId, _clientLastNames);
        List<Map<String, Object>> dataTable = this.getDataTable(sql, clientLastNames.size());

        for (int i = 0; i <= clientLastNames.size() - 1; i++) {
            boolean found = false;
            String clientLastName = clientLastNames.get(i);
            for (int j = 0; j <= dataTable.size() - 1; j++) {

                String lastName = dataTable.get(j).get("L_NAME").toString();
                if (clientLastName.equalsIgnoreCase(lastName)) {
                    found = true;
                    break;
                }
            }
            if (!found)
                this.logInfo(String.format("Client with client last name '%s' is not added in EVV DB.", clientLastName));
        }

        if (dataTable.size() == clientLastNames.size()) {
            this.logInfo(String.format(CLIENT_ADD_MSG, clientLastNames.size()));
            return true;
        }
        return false;
    }

    public List<String> areClientMedicaidsExistInDatabase(String accountId, List<String> clientMedicaids) {
        List<String> medicaidsNotExistInDb = new ArrayList<>();


        int limit = 1000;
        if (clientMedicaids.size() <= 1000)
            medicaidsNotExistInDb = this.checkClientMedicaidsExistInDatabase(accountId, clientMedicaids);
        else {
            int count = clientMedicaids.size() / limit;
            int surplus = clientMedicaids.size() % limit;
            for (int i = 1; i <= count; i++) {
                List<String> list = clientMedicaids.subList(0, limit);
                List<String> _medicaidsNotInDb = this.checkClientMedicaidsExistInDatabase(accountId, list);

                if (_medicaidsNotInDb.size() > 0) {
                    this.logInfo("Some Clients are not added in EVV DB.");
                    medicaidsNotExistInDb = this.commons.plusStringArray(medicaidsNotExistInDb, _medicaidsNotInDb);
                } else this.logInfo("1000 Clients are added in EVV DB.");

                clientMedicaids.subList(0, limit).clear();
            }
            List<String> list = clientMedicaids.subList(0, surplus);

            List<String> _medicaidsNotInDb = this.checkClientMedicaidsExistInDatabase(accountId, list);
            if (_medicaidsNotInDb.size() > 0)
                medicaidsNotExistInDb = this.commons.plusStringArray(medicaidsNotExistInDb, _medicaidsNotInDb);
            clientMedicaids.subList(0, surplus).clear();
        }

        return medicaidsNotExistInDb;
    }

    private List<String> checkClientMedicaidsExistInDatabase(String accountId, List<String> medicaids) {

        List<String> medicaidsNotExistInDd = new ArrayList<>();
        String medicaidIDsStr = medicaids.stream().collect(Collectors.joining("','", "'", "'"));

        String sql = String.format(sql_getMedicaids, accountId, medicaidIDsStr);
        List<Map<String, Object>> dataTable = this.getDataTable(sql, medicaids.size());

        for (int i = 0; i <= medicaids.size() - 1; i++) {
            boolean found = false;
            String _medicaid = medicaids.get(i);
            for (int j = 0; j <= dataTable.size() - 1; j++) {

                String medicaidInDB = dataTable.get(j).get("MEDICAID_ID").toString();
                if (_medicaid.equalsIgnoreCase(medicaidInDB)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                this.logInfo(String.format("Client with medicaid '%s' is not added in EVV DB.", _medicaid));
                medicaidsNotExistInDd.add(_medicaid);
            }
        }

        if (dataTable.size() == medicaids.size()) this.logInfo(String.format(CLIENT_ADD_MSG, medicaids.size()));
        return medicaidsNotExistInDd;
    }

    public boolean areClientsExistInDatabase(String accountId, List<String> clientIDs, boolean expected) {
        boolean result;
        String aggClientIDs = clientIDs.stream().collect(Collectors.joining("','", "'", "'"));

        String sql = String.format(SQL_GET_CLIENTS_BY_CLIENTID, accountId, aggClientIDs);

        this.logInfo("Execute sql: " + sql);

        int expectedNoRows = expected ? clientIDs.size() : 0;
        List<Map<String, Object>> dataTable = this.getDataTable(sql, expectedNoRows);

        this.verifyClientIDReturnedFromDB(clientIDs, dataTable, expected);

        if (expected) if (dataTable.size() == clientIDs.size()) {
            this.logInfo(String.format(CLIENT_ADD_MSG, clientIDs.size()));
            result = true;
        } else {
            this.logInfo(String.format("All '%s' clients are not added in EVV DB.", clientIDs.size()));
            result = false;
        }
        else if (dataTable.size() == 0) {
            this.logInfo(String.format("All '%s' clients are not added in EVV DB as expected.", clientIDs.size()));
            result = true;
        } else {
            this.logInfo(String.format("All '%s' clients are added in EVV DB unexpected.", clientIDs.size()));
            result = false;
        }
        return result;
    }

    private boolean verifyClientIDReturnedFromDB(List<String> clientIDs, List<Map<String, Object>> dataTable, boolean expected) {
        for (int i = 0; i <= clientIDs.size() - 1; i++) {
            String currentClientID = clientIDs.get(i);
            boolean isClientIDFound = dataTable.stream()
                    .anyMatch(record -> record.get("LOC").toString().equalsIgnoreCase(currentClientID));
            if (!isClientIDFound) {
                this.logFail(String.format(CLIENT_NOT_ADD_MSG, currentClientID));
                return false;
            }
        }
        return true;
    }

    private boolean isClientLNameExistingInDB(String account, String lName) {
        String sql = String.format(ClientSQL.SQL_GET_CLIENT_BY_LNAME, account, lName);
        int count = DbUtilsCon.getDataTable(this.getTestEnvironment().getOracleUrl(), this.getTestEnvironment(), sql).size();
        return count > 0;
    }

    private boolean isClientSequenceNumberExistingInDB(String accountId, String clientSequenceNumber) {
        String sql = String.format(ClientSQL.SQL_GET_CLIENT_BY_SEQUENCE_NUMBER, accountId, clientSequenceNumber);
        int count = DbUtilsCon.getDataTable(this.getTestEnvironment().getOracleUrl(), this.getTestEnvironment(), sql).size();
        return count > 0;
    }

    private boolean isClientIdExistingInDB(String accountId, String loc) {
        String sql = String.format(ClientSQL.SQL_GET_CLIENT_BY_LOC, accountId, loc);
        int count = DbUtilsCon.getDataTable(this.getTestEnvironment().getOracleUrl(), this.getTestEnvironment(), sql).size();
        return count > 0;
    }

    public boolean isClientSsnExistingInDB(String accountId, String loc, String ssn) {
        String sql = String.format(ClientSQL.SQL_GET_CLIENT_BY_SSN, accountId, loc, ssn);
        int count = DbUtilsCon.getDataTable(this.getTestEnvironment().getOracleUrl(), this.getTestEnvironment(), sql).size();
        return count > 0;
    }

    private boolean isClientSsnExistingInDB(String accountId, String ssn) {
        String sql = String.format(ClientSQL.SQL_GET_CLIENT_BY_SSN_ONLY, accountId, ssn);
        int count = DbUtilsCon.getDataTable(this.getTestEnvironment().getOracleUrl(), this.getTestEnvironment(), sql).size();
        return count > 0;
    }

    public String getClientFieldValue(String accountId, String clientLastName, String columnName) {
        String sql = String.format(ClientSQL.SQL_CLIENT_GENERAL, accountId, clientLastName);
        List<Map<String, Object>> dataTable = DbUtilsCon.getDataTable(this.getTestEnvironment().getOracleUrl(),
                this.getTestEnvironment(), sql);
        if (dataTable.size() < 1) {
            this.logError(String.format("Client with last name '%s', account '%s' not found in database", clientLastName, accountId));
            return "";
        } else
            this.logInfo(String.format("Client with last name '%s', account '%s' found in database", clientLastName, accountId));
        Object value = dataTable.get(0).get(columnName);
        return String.valueOf(value);
    }

    public Map<String, Object> getClientFieldValues(String accountId, String clientLastName) {
        String sql = String.format(ClientSQL.SQL_CLIENT_GENERAL, accountId, clientLastName);
        List<Map<String, Object>> dataTable = DbUtilsCon.getDataTable(this.getTestEnvironment().getOracleUrl(),
                this.getTestEnvironment(), sql);
        if (dataTable.size() < 1) {
            this.logError(String.format("Client with last name '%s', account '%s' not found in database", clientLastName, accountId));
            return null;
        } else
            this.logInfo(String.format("Client with last name '%s', account '%s' found in database", clientLastName, accountId));
        return dataTable.get(0);
    }

    public Map<String, Object> getRandomClient(String query, String accountId) {
        if (clientsPerf.get(accountId) == null) {
            String sql = String.format(query, accountId);
            this.commons.loggerConsole("------------- SQL: \n" + sql);
            this.clientsInDB = this.getDataTable(sql);
            clientsPerf.put(accountId, this.clientsInDB);
        }
        if (clientsPerf.get(accountId) == null) {
            System.out.println(String.format("Client with account '%s' not found in database", accountId));
            this.logFail(String.format("Client with account '%s' not found in database", accountId));
        }

        int randomIndex = new Random().nextInt(clientsPerf.get(accountId).size());

        return clientsPerf.get(accountId).get(randomIndex);
    }

    public Map<String, Object> getRandomClient() {
        return this.getRandomClient(this.sqlClientQuery, this.account.getAccountID());
    }

    public List<Map<String, Object>> getClientBasicInformation(String accountId, List<String> locs, boolean expected) {
        List<Map<String, Object>> dataTable = this.getClientInformation(ClientSQL.SQL_SELECT_CLIENT_BASIC_INFO_AND_SUPP, accountId, locs, expected);
        return dataTable;
    }

    public List<Map<String, Object>> getClientAuthAndAuthLimit(String accountId, List<String> locs, boolean expected) {
        List<Map<String, Object>> dataTable = this.getClientInformation(ClientSQL.SQL_SELECT_CLIENT_AUTH_AND_AUTH_LIMIT, accountId, locs, expected);
        return dataTable;
    }

    public List<Map<String, Object>> getClientAddress(String accountId, List<String> locs, boolean expected) {
        return this.getClientBasicInformation(accountId, locs, expected);
    }

    public List<Map<String, Object>> getClientContact(String accountId, List<String> locs, boolean expected) {
        List<Map<String, Object>> dataTable = this.getClientInformation(SQL_SELECT_CLIENT_CONTACTS, accountId, locs, expected);
        return dataTable;
    }

    public List<Map<String, Object>> getClientAni(String accountId, List<String> locs, boolean expected) {
        List<Map<String, Object>> dataTable = this.getClientInformation(ClientSQL.SQL_SELECT_CLIENT_ANI, accountId, locs, expected);
        return dataTable;
    }

    public List<Map<String, Object>> getClientAppUser(String accountId, List<String> locs, boolean expected) {
        List<Map<String, Object>> dataTable = this.getClientInformation(ClientSQL.SQL_SELECT_CLIENT_APP_USERS, accountId, locs, expected);
        return dataTable;
    }

    public List<Map<String, Object>> getClientXref(String accountId, List<String> locs, boolean expected) {
        List<Map<String, Object>> dataTable = this.getClientInformation(ClientSQL.SQL_SELECT_CLIENT_XREF, accountId, locs, expected);
        return dataTable;
    }

    private List<Map<String, Object>> getClientInformation(String sql, String accountId, List<String> locs, boolean expected) {

        String _locs = "";

        for (int i = 0; i <= locs.size() - 1; i++)
            if (i == locs.size() - 1) _locs += "'" + locs.get(i) + "'";
            else _locs += "'" + locs.get(i) + "',";

        String _sql = String.format(sql, accountId, _locs);

        this.logInfo("Execute sql: " + _sql);

        List<Map<String, Object>> dataTable;

        if (expected) dataTable = this.getDataTable(_sql, locs.size());
        else dataTable = this.getDataTable(_sql, 0);
        return dataTable;
    }

    public String generateNewClientId(String accountId) {
        String clientId = RandomStringUtils.randomAlphanumeric(10);
        this.logInfo(String.format("Generating new client Id (LOC): %s", clientId));
        while (this.isClientIdExistingInDB(accountId, clientId)) {
            this.logInfo("But client id (loc) " + clientId + EXIST_IN_DB_MSG);
            clientId = RandomStringUtils.randomAlphanumeric(10);
            this.logInfo(String.format("Generating new client Id (LOC): %s", clientId));
        }
        this.logInfo(String.format("Use new client Id (LOC): %s", clientId));
        return clientId;
    }

    private String generateNewPatientMedicaidIDByLength(String accountId, int length) {
        String patientMedicaidID = RandomStringUtils.randomNumeric(length);
        while (this.isClientMedicaidIdExistingInDB(accountId, patientMedicaidID)) {
            this.logInfo("client medicaid Id " + patientMedicaidID + EXIST_IN_DB_MSG);
            patientMedicaidID = RandomStringUtils.randomNumeric(length);
        }
        return patientMedicaidID;
    }

    public String generateNewPatientMedicaidID(String accountId) {
        return this.generateNewPatientMedicaidIDByLength(accountId, 12);
    }

    public String generateNewClientIDCustomer1(String accountId, int length) {
        String clientIDCustomer1 = RandomStringUtils.randomNumeric(length);
        while (this.isClientIDCustomer1ExistingInDB(accountId, clientIDCustomer1)) {
            this.logInfo("client other Id " + clientIDCustomer1 + EXIST_IN_DB_MSG);
            clientIDCustomer1 = RandomStringUtils.randomNumeric(length);
        }
        return clientIDCustomer1;
    }

    public String generateNewClientIDCustomer2(int length) {
        String clientOtherId = RandomStringUtils.randomNumeric(length);
        while (this.isClientIDCustomer2ExistingInDB(clientOtherId)) {
            this.logInfo("client other Id " + clientOtherId + EXIST_IN_DB_MSG);
            clientOtherId = RandomStringUtils.randomNumeric(length);
        }
        return clientOtherId;
    }

    public String generateNewPatientOtherID(String accountId) {
        String patientOtherID = RandomStringUtils.randomAlphanumeric(64);
        while (this.isClientIDCustomer1ExistingInDB(accountId, patientOtherID)) {
            this.logInfo("client id custome 1 (patientOtherID in Ohio) " + patientOtherID + EXIST_IN_DB_MSG);
            patientOtherID = RandomStringUtils.randomAlphanumeric(64);
        }
        return patientOtherID;
    }

    public String generateNewClientFName(String account) {
        String fname = RandomStringUtils.randomAlphabetic(30);
        while (this.isClientFNameExistingInDB(account, fname)) {
            this.logInfo("client first name " + fname + " is existing already in database. Account: " + account);
            fname = RandomStringUtils.randomAlphabetic(30);
        }
        return fname;
    }

    public String generateNewClientLName(String account) {
        String lname = RandomStringUtils.randomAlphabetic(30);
        while (this.isClientLNameExistingInDB(account, lname)) {
            this.logInfo("client last name " + lname + " is existing already in database. Account: " + account);
            lname = RandomStringUtils.randomAlphabetic(30);
        }
        return lname;
    }

    public String generateNewClientLSequenceNumber(String accountId) {
        String sequenceNUmber = RandomStringUtils.randomNumeric(16);
        while (this.isClientSequenceNumberExistingInDB(accountId, sequenceNUmber)) {
            this.logInfo("client sequence number " + sequenceNUmber + EXIST_IN_DB_MSG);
            sequenceNUmber = RandomStringUtils.randomNumeric(16);
        }
        return sequenceNUmber;
    }

    /**
     * Generate new ssn for client, make sure this new ssn is not existed in database
     *
     * @param accountId
     * @param loc       client id
     * @return
     */
    public String generateNewClientSsn(String accountId, String loc) {
        String ssn = RandomStringUtils.randomNumeric(9);
        return ssn;
    }

    public String generateNewClientSsn(String accountId) {
        String ssn = RandomStringUtils.randomNumeric(9);
        while (this.isClientSsnExistingInDB(accountId, ssn)) {
            this.logInfo("client ssn " + ssn + EXIST_IN_DB_MSG);
            ssn = RandomStringUtils.randomAlphanumeric(10);
        }
        return ssn;
    }

    public boolean validateClientDesigneeInDatabase(String accountId, List<String> clientIDs) {
        String _clientIDs = this.getClientIdsDatabase(clientIDs);
        String sql = String.format(SQL_SELECT_CLIENT_DESIGNEE, accountId, _clientIDs);
        List<Map<String, Object>> dataTable;
        dataTable = this.getDataTable(sql, clientIDs.size());
        return dataTable.size() >= clientIDs.size();
    }

    private String getClientIdsDatabase(List<String> clientIDs) {
        String strClientIDs = "";

        for (int i = 0; i <= clientIDs.size() - 1; i++)
            if (i == clientIDs.size() - 1) strClientIDs += "'" + clientIDs.get(i) + "'";
            else
                strClientIDs += "'" + clientIDs.get(i) + "',";
        return strClientIDs;
    }

    public boolean areClientDesigneeExistInDatabase(String accountId, List<String> clientIDs, boolean expected) {
        boolean result;
        String _clientIDs = this.getClientIdsDatabase(clientIDs);
        String sql = String.format(SQL_SELECT_CLIENT_CONTACTS, accountId, _clientIDs);

        List<Map<String, Object>> dataTable;
        if (expected) dataTable = this.getDataTable(sql, clientIDs.size());
        else dataTable = this.getDataTable(sql, 0);

        this.verifyClientIDReturnedFromDB(clientIDs, dataTable, expected);

        if (expected) if (dataTable.size() == clientIDs.size()) {
            this.logInfo(String.format("All '%s' Client Designees are added in EVV DB.", clientIDs.size()));
            result = true;
        } else {
            this.logInfo(String.format("All '%s' Client Designees are not added in EVV DB.", clientIDs.size()));
            result = false;
        }
        else if (dataTable.size() == 0) {
            this.logInfo(String.format("All '%s' Client Designees are not added in EVV DB as expected.", clientIDs.size()));
            result = true;
        } else {
            this.logInfo(String.format("All '%s' Client Designees are added in EVV DB unexpected.", clientIDs.size()));
            result = false;
        }
        return result;
    }

    public String getRandomClientID(String clientIDs) {
        String[] listClientIDs = clientIDs.split(",");
        int n = listClientIDs.length - 1;
        int i = 0;
        if (n != 0)
            i = this.commons.getRandomNumberInRange(0, n);
        return listClientIDs[i];
    }

    public String getRandomEmployeeIdentifier(String employeeIdentifiers) {
        String[] listEmployeeIdentifiers = employeeIdentifiers.split(",");
        int n = listEmployeeIdentifiers.length - 1;
        int i = 0;
        if (n != 0)
            i = this.commons.getRandomNumberInRange(0, n);
        return listEmployeeIdentifiers[i];
    }

    public String getSqlClientQuery() {
        return this.sqlClientQuery;
    }

    public void setSqlClientQuery(String sqlClientQuery) {
        this.sqlClientQuery = sqlClientQuery;
    }
}
