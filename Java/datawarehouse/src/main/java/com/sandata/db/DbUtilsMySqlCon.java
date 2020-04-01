package com.sandata.db;

import com.sandata.utilities.MultiResultSetStatementIterator;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtilsMySqlCon {
    private DbUtilsMySqlCon() {
        throw new IllegalStateException("Utility class");
    }

    private static final Logger LOGGER = Logger.getLogger(DbUtilsMySqlCon.class);

    private static Connection createConnection(String url, String username, String pass) {
        Connection con = null;

        try {
            String oracleDriverName = "com.mysql.jdbc.Driver";
            Class.forName(oracleDriverName);
            con = DriverManager.getConnection(url, username, pass);
        } catch (ClassNotFoundException | SQLException var5) {
            LOGGER.error(var5.getMessage());
        }

        return con;
    }

    public static ResultSet getResultSetFromQuery(Connection conn, String query) {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = conn.createStatement();
            LOGGER.info(query);
            statement.execute(query);
            MultiResultSetStatementIterator multiResultSetStatementIterator = new MultiResultSetStatementIterator(statement, conn);
            resultSet = multiResultSetStatementIterator.loadNextResultSet();
        } catch (Exception var4) {
            LOGGER.error(var4);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage());
                }
            }
        }

        return resultSet;
    }

    private static List<Map<String, Object>> resultSetToList(ResultSet rs) {
        ArrayList<Map<String, Object>> rows = new ArrayList<>();

        try {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            while(rs.next()) {
                Map<String, Object> row = new HashMap<>(columns);

                for(int i = 1; i <= columns; ++i) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }

                rows.add(row);
            }
        } catch (Exception var6) {
            LOGGER.error(var6.getMessage());
        }

        return rows;
    }

    public static List<Map<String, Object>> getDataTable(String url, String username, String pass, String sql) {
        List<Map<String, Object>> rows = new ArrayList<>();
        Statement statement = null;
        ResultSet rs;
        Connection connection = createConnection(url, username, pass);

        if (connection != null) {
            try {
                statement = connection.createStatement();
                LOGGER.info(sql);
                statement.execute(sql);
                MultiResultSetStatementIterator multiResultSetStatementIterator = new MultiResultSetStatementIterator(statement, connection);
                rs = multiResultSetStatementIterator.loadNextResultSet();
                rows = resultSetToList(rs);
            } catch (Exception var20) {
                LOGGER.error(var20);
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException var19) {
                        LOGGER.error(var19.getMessage());
                    }
                }

                try {
                    connection.close();
                } catch (SQLException var18) {
                    LOGGER.error(var18.getMessage());
                }
            }
        }

        return rows;
    }
}
