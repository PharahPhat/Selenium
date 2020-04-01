package com.sandata.db;

import com.interop.sql.AuthSQL;

import java.util.List;
import java.util.Map;

public class AuthDbService extends BaseDbMySqlService {

    public String mysqlUrl = "";
    public String mysqlUser = "";
    public String mysqlPass = "";

    public int getStatusCodeOfDB(List<String> guids)
    {
        String _guid = "";
        for (int i = 0; i <= guids.size() - 1; i++) {
            if (i == guids.size() - 1) {
                _guid += "'" + guids.get(i) + "'";
            } else {
                _guid += "'" + guids.get(i) + "',";
            }
        }

        String sql = String.format(AuthSQL.SQL_GET_AUTH_BY_GUID, _guid);
        List<Map<String, Object>>  datatable = DbUtilsMySqlCon.getDataTable(mysqlUrl, mysqlUser, mysqlPass, sql);

        String status_code = String.valueOf(datatable.get(0).get("status_code"));
        return Integer.parseInt(status_code);
    }

    public boolean areAuthsExistingInDB(List<String> guids) {

        String _guid = "";

        for (int i = 0; i <= guids.size() - 1; i++) {
            if (i == guids.size() - 1) {
                _guid += "'" + guids.get(i) + "'";
            } else {
                _guid += "'" + guids.get(i) + "',";
            }
        }
        String sql = String.format(AuthSQL.SQL_GET_AUTH_BY_GUID, _guid);
        int count = DbUtilsMySqlCon.getDataTable(mysqlUrl, mysqlUser, mysqlPass, sql).size();

        return count == guids.size();
    }
}
