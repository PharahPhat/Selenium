package com.sandata.db;

import org.apache.log4j.Logger;
import org.h2.tools.DeleteDbFiles;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class PreconditionDbService {
    private static final Logger LOGGER = Logger.getLogger(PreconditionDbService.class);
    private static final String URL ="jdbc:h2:~/dwhExports/%s";

    private PreconditionDbService() {
        throw new IllegalStateException("Utility class");
    }

    private static ResultSet executeStatement(String testcaseId, String queryStr){
        Connection conn;
        Statement stat;
        ResultSet rs= null;
        try{
            conn = DriverManager.getConnection(String.format(URL, testcaseId));
            stat = conn.createStatement();
            rs = stat.executeQuery(queryStr);
        }catch (SQLException exp) {
            LOGGER.error("ExecuteStatement exception: ", exp);
        }
        return rs;
    }

    private static boolean execute(String testcaseId, String queryStr){
        Connection conn =null;
        Statement stat =null;
        boolean result =false;
        try{
            conn = DriverManager.getConnection(String.format(URL, testcaseId));
            stat = conn.createStatement() ;
            result =stat.execute(queryStr);
        }catch (Exception ex){
            LOGGER.error("Execute exception: ", ex);
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException exp) {
                    LOGGER.error("conn exception: ", exp);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException exp) {
                    LOGGER.error("stat exception: ", exp);
                }
            }
        }
        return result;
    }

    public static Map<String, String> getResult(String testcaseId) throws SQLException {
        Map<String, String> results = new HashMap<>();
        ResultSet rs = executeStatement(testcaseId, "select * from test");
        while (rs != null && rs.next()) {
            results.put(rs.getString("fieldname"), rs.getString("fieldvalue"));
            LOGGER.info("***** " + rs.getString("fieldname") + " = " + rs.getString("fieldvalue"));
        }
        return results;
    }

    static void executeSqlQuery(String testcaseId, String sql) {
        execute(testcaseId, sql);
    }

    public static boolean insertTestCaseData(String testCaseId, String fieldName, String value, Statement stat) {
        try {
            //Insert a data row of test case to db
            stat.execute(String.format("insert into test values('%s', '%s', '%s')", testCaseId, fieldName, value));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static void createTableData(String testcaseId) {
        //1. Insert data for tc_094412
        DeleteDbFiles.execute("~", String.format("dwhExports/%s", testcaseId), true);
        //2. Create table
        executeSqlQuery(testcaseId, "DROP TABLE IF EXISTS test");
        String sqlCreateTable = "create table test(fieldname varchar(1024), fieldvalue varchar(50000))";
        executeSqlQuery(testcaseId, sqlCreateTable);
    }

    public static void insertDataRows(String testcaseId, String fieldname, String value){
        String sql = String.format("insert into test values('%s', '%s')", fieldname, value);
        executeSqlQuery(testcaseId, sql);

    }

    public static void getPreconditionData(String testcaseId){
        String sql = "select * from test";
        executeSqlQuery(testcaseId, sql);
    }

    public static boolean isExistTable(String testcaseId) throws SQLException {
        boolean isExist = false;
        try (
            Connection conn = DriverManager.getConnection(String.format(URL, testcaseId))) {
            DatabaseMetaData dbm = conn.getMetaData();

            ResultSet rs = dbm.getTables(null, null, "test", null);
            if (rs.next()) {
                isExist = true;
            }
        }
        return isExist;
    }
}
