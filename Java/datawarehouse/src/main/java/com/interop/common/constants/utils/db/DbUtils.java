package com.interop.common.constants.utils.db;

import com.aventstack.extentreports.ExtentTest;
import com.interop.common.Commons;
import com.interop.common.TestDataHelper;
import com.sandata.core.report.ExtentTestManager;
import com.sandata.utilities.ColumnAnnotationMapper;
import com.sandata.utilities.DbUtilsCon;

import java.sql.ResultSet;
import java.util.List;

public class DbUtils {
    private DbUtils() {
    }

    private static <T> List<T> getDataFromModel(Class<T> clazz, String querySQL) {
        ColumnAnnotationMapper<T> mapper = new ColumnAnnotationMapper<>(clazz);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), querySQL);
        return mapper.DataTableMapper(rs);
    }

    public static <T> List<T> getDataFromDatabase(Class<T> clazzDatabase, String querySQL) {
        Commons commons = new Commons();
        ExtentTest test = ExtentTestManager.getTest();
        List<T> returnedData = getDataFromModel(clazzDatabase, querySQL);
        int maxTries = 5;
        while (maxTries > 0 && returnedData.isEmpty()) {
            commons.wait(30);
            returnedData = getDataFromModel(clazzDatabase, querySQL);
            maxTries--;
        }
        if (returnedData.isEmpty()) {
            test.fail("There is no data returned from query: " + querySQL);
        }
        return returnedData;
    }
}
