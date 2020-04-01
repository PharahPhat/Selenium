package com.interop.common;

import com.google.gson.Gson;
import com.interop.common.dataprovider.DataPayerProgramCombination;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.data.claim.ClaimDataRecord;
import com.interop.models.db.stx.STXPayorID;
import com.sandata.core.config.TestContext;
import com.sandata.utilities.CSVReader;
import com.sandata.utilities.ColumnAnnotationMapper;
import com.sandata.utilities.DbUtilsCon;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;

import static com.interop.common.constants.queries.InterOpOracle.GET_AUTHORIZATION_SERVICES_COMBINATION_FOR_PAYER;
import static com.sandata.utilities.CSVReader.readCSVFile;

public class TestDataHelper {
    private static final Logger LOGGER = Logger.getLogger(TestDataHelper.class);
    private static Connection oraConnection;
    private static Connection mysqlConnection;
    private static Connection sqlConnection;
    private static final String BASE_FOLDER = System.getProperty("user.dir") + File.separator +
            "TestData" + File.separator;
    private Map<String, Object> data = new HashMap<>();

    public static Connection getOraConnection() {
        if (oraConnection == null) {
            oraConnection = DbUtilsCon.initDBConnection(DbUtilsCon.ConnectionType.ORACLE);
        }
        return oraConnection;
    }

    public static Connection getMySQLConnection() {
        if (mysqlConnection == null) {
            mysqlConnection = DbUtilsCon.initDBConnection(DbUtilsCon.ConnectionType.MYSQL);
        }
        return mysqlConnection;
    }

    public static Connection getSQLConnection() {
        if (sqlConnection == null) {
            sqlConnection = DbUtilsCon.initDBConnection(DbUtilsCon.ConnectionType.SQL);
        }
        return sqlConnection;
    }

    public static synchronized void closeDBConnections() throws SQLException {
        if (oraConnection != null) {
            oraConnection.close();
        }
        if (mysqlConnection != null) {
            mysqlConnection.close();
        }
        if (sqlConnection != null) {
            sqlConnection.close();
        }
    }

    /**
     * This method to init data driven being loaded from the CSV files which is inputted in the test class
     *
     * @param state state name
     * @return validation data from CSV
     */
    public static Object[][] getFieldValidationDataRows(String state, String fileName, String dataFilter) {
        String filePath = getTestDateFilePath(state, fileName);
        CSVReader csvReader = readCSVFile(filePath);
        List<Object[]> dataRows = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < csvReader.getDataRows().size(); rowIndex++) {
            String propertyName = csvReader.getValue(rowIndex, 0).toString();
            if (isDataRowIgnoredOnCurrentState(csvReader, rowIndex)
                    || (!dataFilter.isEmpty() && !propertyName.contains(dataFilter)))
                continue; // This generic case is ignored on the current state.

            DataValidationModel data = new DataValidationModel();
            data.setPropertyName(propertyName);

            String isRequire = csvReader.getValue(rowIndex, 1).toString();
            data.setPropertyType(csvReader.getValue(rowIndex, 2).toString());
            data.setDescription(csvReader.getValue(rowIndex, 3).toString());
            data.setPropertyValue(csvReader.getValue(rowIndex, 5).toString());
            data.setPostStatus(csvReader.getValue(rowIndex, 6).toString());
            data.setExpectedMessage(csvReader.getValue(rowIndex, 7).toString());
            data.setUuidStatus(csvReader.getValue(rowIndex, 8).toString());
            data.setUuidExpectedError(csvReader.getValue(rowIndex, 9).toString());
            data.setIsVerifyExistingDatabase(csvReader.getValue(rowIndex, 10).toString());

            if (isRequire.equalsIgnoreCase("yes")) {
                addRequireCase(dataRows, data);
            } else {
                String propertyType = data.getPropertyType();
                if (propertyType.contains("[")) {
                    addMinMaxLengthCases(dataRows, data, propertyType);
                } else {
                    addListValueCases(dataRows, data);
                }
            }
        }
        return dataRows.toArray(new Object[dataRows.size()][]);
    }

    private static boolean isDataRowIgnoredOnCurrentState(CSVReader csvReader, int rowIndex) {
        try {
            List<String> excludeStates = Arrays.asList(
                    csvReader.getValue(rowIndex, 4).toString().split(";"));
            if (excludeStates.contains(StateAccount.loadStateAccount().getStateEnum().getStringKey())) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException exp) {
            LOGGER.info("No State Exclusion List Column defined in generic csv files");
        }
        return false;
    }

    private static void addListValueCases(List<Object[]> dataRows, DataValidationModel data) {
        String propertyValue = data.getPropertyValue();
        if (propertyValue.contains("[")) {
            String[] values = StringUtils.split(propertyValue.substring(1, propertyValue.length() - 1), ";");
            for (String value : values) {
                data.setDescription(String.format("%s has value is %s", data.getPropertyName(), value));
                data.setPropertyValue(value);
                dataRows.add(new Object[]{data});
            }

        } else {
            dataRows.add(new Object[]{data});
        }
    }

    private static void addMinMaxLengthCases(List<Object[]> dataRows, DataValidationModel data, String propertyType) {
        String[] minMaxLength = getMinMaxLength(propertyType);
        propertyType = minMaxLength[0].trim();
        int minLength = Integer.parseInt(minMaxLength[1]);
        if (minLength > 1) {
            String minValue = RandomStringUtils.randomAlphabetic(minLength - 1);
            if (propertyType.toLowerCase().contains("int")) {
                minValue = RandomStringUtils.randomNumeric(minLength - 1);
            }
            data.setDescription(String.format("%s length is less than %s", data.getPropertyName(), minLength));
            data.setPropertyValue(minValue);
            dataRows.add(new Object[]{data});
        }

        int maxLength = Integer.parseInt(minMaxLength[2]);
        String maxValue = RandomStringUtils.randomAlphabetic(maxLength + 1);
        if (propertyType.toLowerCase().contains("int")) {
            maxValue = RandomStringUtils.randomNumeric(maxLength + 1);
        }
        data.setDescription(String.format("%s length is greater than %s", data.getPropertyName(), maxLength));
        data.setPropertyValue(maxValue);
        dataRows.add(new Object[]{data});
    }

    private static void addRequireCase(List<Object[]> dataRows, DataValidationModel data) {
        data.setIsVerifyExistingDatabase("");
        data.setDescription(String.format("%s is null", data.getPropertyName()));
        data.setPropertyValue(null);
        dataRows.add(new Object[]{data});
        Gson gson = new Gson();
        DataValidationModel data1 = gson.fromJson(gson.toJson(data), DataValidationModel.class);
        data1.setDescription(String.format("%s is empty", data.getPropertyName()));
        data1.setPropertyValue("");
        dataRows.add(new Object[]{data1});
    }

    public static List<String> getClientGroupList(String state, String fileName) {
        String filePath = state + File.separator + fileName;
        CSVReader csvReader = readCSVFile(filePath);
        List<String> clientGroup = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < csvReader.getDataRows().size(); rowIndex++) {
            String client = csvReader.getValue(rowIndex, 0).toString().trim();
            clientGroup.add(client);
        }
        return new ArrayList<>(new HashSet<>(clientGroup));
    }

    public static Object[][] getProviderDataRowsClaim(boolean isPrepareData, String fileName) {
        CSVReader csvReader = readCSVFile(fileName);
        List<Object[]> dataRows = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < csvReader.getDataRows().size(); rowIndex++) {
            String duration = csvReader.getValue(rowIndex, 9).toString().trim();
            String clientMedicaidId = csvReader.getValue(rowIndex, 0).toString().trim();

            ClaimDataRecord claimDataRecord = new ClaimDataRecord();

            if ((isPrepareData && duration.isEmpty() && !clientMedicaidId.contains("#")) // verified visit record
                    || (!isPrepareData && !duration.isEmpty())) { // claim record
                claimDataRecord.setClientMedicaidId(clientMedicaidId);
                claimDataRecord.setEmployeeCustomId(csvReader.getValue(rowIndex, 1).toString().trim());
                claimDataRecord.setServiceStartDate(csvReader.getValue(rowIndex, 2).toString().trim());
                claimDataRecord.setServiceEndDate(csvReader.getValue(rowIndex, 3).toString().trim());
                claimDataRecord.setInTime(csvReader.getValue(rowIndex, 4).toString().trim());
                claimDataRecord.setOutTime(csvReader.getValue(rowIndex, 5).toString().trim());
                claimDataRecord.setProcedureCode(csvReader.getValue(rowIndex, 6).toString().trim());
                claimDataRecord.setUnitsRule(csvReader.getValue(rowIndex, 7).toString().trim());
                claimDataRecord.setMatchingRule(csvReader.getValue(rowIndex, 8).toString().trim());
                claimDataRecord.setUnits(csvReader.getValue(rowIndex, 10).toString().trim());
                claimDataRecord.setSucceedCount(csvReader.getValue(rowIndex, 11).toString().trim());
                claimDataRecord.setDuration(duration);
                try {
                    claimDataRecord.setTestDescription(csvReader.getValue(rowIndex, 14).toString().trim());
                    claimDataRecord.setProgram(csvReader.getValue(rowIndex, 12).toString().trim());
                    claimDataRecord.setPayer(csvReader.getValue(rowIndex, 13).toString().trim());
                } catch (ArrayIndexOutOfBoundsException exp) {
                    // No Specify the Program, Payer for the visit, Using the default one
                    claimDataRecord.setProgram(TestContext.get().getEnvironment("defaultPayerProgram"));
                    claimDataRecord.setPayer(TestContext.get().getEnvironment("defaultPayerID"));
                    claimDataRecord.setTestDescription(csvReader.getValue(rowIndex, 12).toString().trim());
                }
                dataRows.add(new Object[]{claimDataRecord});
            }
        }
        return dataRows.toArray(new Object[dataRows.size()][]);
    }

    public static Object[][] getFieldValidationDataRows(String state, String fileName) {
        return getFieldValidationDataRows(state, fileName, "");
    }

    public static List<STXPayorID> getListPayerIDCombinationDataRows(String state, String fileName) {
        List<STXPayorID> payerIds = new ArrayList<>();
        String filePath = getTestDateFilePath(state, fileName);
        CSVReader csvReader = readCSVFile(filePath);
        for (int rowIndex = 0; rowIndex < csvReader.getDataRows().size(); rowIndex++) {
            STXPayorID currentPayer = new STXPayorID();
            currentPayer.PAYOR_ID = csvReader.getValue(rowIndex, 0).toString().trim();
            currentPayer.PROGRAM = csvReader.getValue(rowIndex, 1).toString().trim();
            currentPayer.PROC_CODE = csvReader.getValue(rowIndex, 2).toString().trim();
            currentPayer.MODIFIER1 = csvReader.getValue(rowIndex, 3).toString().trim();
            currentPayer.MODIFIER2 = csvReader.getValue(rowIndex, 4).toString().trim();
            currentPayer.MODIFIER3 = csvReader.getValue(rowIndex, 5).toString().trim();
            currentPayer.MODIFIER4 = csvReader.getValue(rowIndex, 6).toString().trim();
            payerIds.add(currentPayer);
        }
        return payerIds;
    }

    public static Object[][] getCombinationDataRows(String state, String fileName) {
        String filePath = getTestDateFilePath(state, fileName);
        CSVReader csvReader = readCSVFile(filePath);
        List<Object[]> dataRows = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < csvReader.getDataRows().size(); rowIndex++) {
            DataPayerProgramCombination data = new DataPayerProgramCombination();
            data.setPayer(csvReader.getValue(rowIndex, 1).toString().trim());
            String[] listPayer = data.getPayer().split(Pattern.quote("|"));
            for (String payer : listPayer) {
                data = new DataPayerProgramCombination();
                data.setAccount(csvReader.getValue(rowIndex, 0).toString().trim());
                data.setProgram(csvReader.getValue(rowIndex, 2).toString().trim());
                data.setService(csvReader.getValue(rowIndex, 3).toString().trim());
                data.setRevCode(csvReader.getValue(rowIndex, 4).toString().trim());
                data.setModifier1(csvReader.getValue(rowIndex, 5).toString().trim());
                data.setModifier2(csvReader.getValue(rowIndex, 6).toString().trim());
                data.setModifier3(csvReader.getValue(rowIndex, 7).toString().trim());
                data.setModifier4(csvReader.getValue(rowIndex, 8).toString().trim());
                data.setDescription(csvReader.getValue(rowIndex, 9).toString().trim());
                data.setExpectedStatus(csvReader.getValue(rowIndex, 10).toString().trim());
                data.setExpectedGetStatus(csvReader.getValue(rowIndex, 11).toString().trim());
                data.setExpectedMessage(csvReader.getValue(rowIndex, 12).toString().trim());
                data.setIsCheckedDatabase(csvReader.getValue(rowIndex, 13).toString().trim());
                data.setPayer(payer);
                dataRows.add(new Object[]{data});
            }
        }
        return dataRows.toArray(new Object[dataRows.size()][]);
    }

    private static String getTestDateFilePath(String state, String fileName) {
        return BASE_FOLDER + state + File.separator + fileName;
    }

    private static String[] getMinMaxLength(String stringLength) {
        return StringUtils.split(stringLength, "[:]");
    }

    public static List<STXPayorID> getListAuthorizationServicesIDCombination() {
        ColumnAnnotationMapper<STXPayorID> mapper = new ColumnAnnotationMapper<>(STXPayorID.class);
        String query = String.format(GET_AUTHORIZATION_SERVICES_COMBINATION_FOR_PAYER,StateAccount.loadStateAccount().getAccountID());
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), query);
        return mapper.DataTableMapper(rs);
    }

    public Object get(String key) {
        if (data != null) {
            return data.get(key);
        }
        return null;
    }

    public Object set(String key, Object object) {
        if (data != null) {
            return data.put(key, object);
        }
        return null;
    }
}
