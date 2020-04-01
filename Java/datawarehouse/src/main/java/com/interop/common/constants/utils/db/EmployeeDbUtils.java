package com.interop.common.constants.utils.db;

import com.interop.models.db.stx.STXEmployee;

import java.util.List;

import static com.interop.sql.EmployeeSQL.*;

public class EmployeeDbUtils {
    private EmployeeDbUtils() {
    }

    public static List<STXEmployee> getEmployee(String accountId, String fName, String lName) {
        String querySQL = String.format(SQL_GET_EMPLOYEE_GENERAL_BY_NAME, fName, lName, accountId);
        return DbUtils.getDataFromDatabase(STXEmployee.class, querySQL);
    }

    public static List<STXEmployee> getEmployee(String accountId, String stxID) {
        String querySQL = String.format(SQL_GET_EMPLOYEE_BY_STX_ID, accountId, stxID);
        return DbUtils.getDataFromDatabase(STXEmployee.class, querySQL);
    }

    public static List<STXEmployee> getEmployeeByAttID(String accountId, String fName, String lName, String employeeID) {
        String querySQL = String.format(SQL_GET_EMPLOYEE_BY_ATT_ID, fName, lName, accountId, employeeID);
        return DbUtils.getDataFromDatabase(STXEmployee.class, querySQL);
    }
}
