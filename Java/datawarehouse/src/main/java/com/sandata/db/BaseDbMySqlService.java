package com.sandata.db;

import com.aventstack.extentreports.ExtentTest;
import com.interop.common.Commons;
import com.sandata.core.config.Environment;
import com.sandata.core.config.TestConfiguration;
import com.sandata.core.config.TestContext;
import com.sandata.core.report.ExtentTestManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseDbMySqlService {
    private static final Logger LOGGER = Logger.getLogger(DbUtilsMySqlCon.class);
    protected ExtentTest test = ExtentTestManager.getTest();
    Commons commons = new Commons();

    public TestConfiguration getTestConfig() {
        return TestContext.get();
    }

    public String readDataValue(String variableName) {
        try {
            return getTestConfig().getTestData().getValue(variableName);
        } catch (NullPointerException exp) {
            return null;
        }
    }

    public Environment getTestEnvironment() {
        return getTestConfig().getEnvironment();
    }

    public boolean waitDataExistInDb(String sql) {
        int retry = 2;
        while ( retry > 0 ) {
            if(DbUtilsMySqlCon.getDataTable(
                    getMySqlUrl(),
                    getMySQLUser(), getMySQLPassword(), sql).size() != 0) {
                logInfo("Found a record. SQL: " + sql);
                return true;
            }
            try {
                logInfo(String.format("Not found a record. Retry query DB from count down: %s. SQL: %s", retry, sql));
                commons.wait(5);
            } finally {
                retry--;
            }
        }
        logInfo(String.format("Not found a record. Retry query DB %s times. SQL: %s", retry, sql));
        return false;
    }

    private String getMySQLUser() {
        return getTestEnvironment().get("mysql_user");
    }

    public int getDataTableRowsCount(String sql) {
        int retry = 2;
        int i=1;

        while ( i <= retry ) {
            List<Map<String, Object>> dataTable = DbUtilsMySqlCon.getDataTable(getMySqlUrl(),
                    getMySQLUser(), getMySQLPassword(), sql);
            if(dataTable.size() > 0) {
                logInfo("Found record(s). SQL: " + sql);
                return dataTable.size();
            }

            logInfo(String.format("Not found a record. Retry query DB: %s time(s). SQL: %s", i, sql));
            commons.wait(5);
            i++;
        }
        logInfo(String.format("Not found a record. Retry query DB %s times. SQL: %s", retry, sql));
        return 0;
    }

    public List<Map<String, Object>> getDataTable(String sql, int expectedRows) {
        int retry = 5;

        if (expectedRows == 0) {
            retry = 2;
        }

        int i = 1;
        List<Map<String, Object>> dataTable = new ArrayList<>();
        while ( i <= retry ) {
            dataTable = DbUtilsMySqlCon.getDataTable(getMySqlUrl(),
                    getMySQLUser(), getMySQLPassword(), sql);
            int actualRows = dataTable.size();
            if (actualRows >= expectedRows) {
                logInfo(String.format("Actual rows '%s' is equal or greater than expected rows '%s'", actualRows, expectedRows ));
                return dataTable;
            } else {
                logInfo(String.format("Actual rows '%s' is less than expected rows '%s'. Perhaps data is processing persist", actualRows, expectedRows ));
            }
            commons.wait(5);
            i++;
        }
        if (dataTable.size() != expectedRows) {
            logInfo(String.format("Actual rows '%s' is not equal expected rows '%s'. Perhaps data is processing persist", dataTable.size(), expectedRows ));
        }
        return dataTable;
    }

    private String getMySQLPassword() {
        return getTestEnvironment().get("mysql_pass");
    }

    private String getMySqlUrl() {
        return getTestEnvironment().get("mySqlUrl");
    }

    public synchronized void logError(String message) {
        getExtentTest().error(message);
        LOGGER.error(message);
    }

    public synchronized void logPass(String message) {
        getExtentTest().pass(message);
        LOGGER.info(message);
    }

    public synchronized void logInfo(String info) {
        getExtentTest().info(info);
        LOGGER.info(info);
    }

    public ExtentTest getExtentTest() {
        return ExtentTestManager.getTest();
    }
}
