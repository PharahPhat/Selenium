package com.sandata.db;

import com.interop.sql.VisitSQL;
import com.sandata.utilities.DbUtilsCon;
import org.apache.commons.lang.RandomStringUtils;

import java.util.List;
import java.util.Map;

public class VisitDbService extends BaseDbService {
private static final String EXIST_IN_DB_MSG = " is existing already in database.";

    public boolean isVisitSequenceNumberExistingInDB(String account, String sequenceNumber) {
        String sql = String.format(VisitSQL.SQL_GET_VISIT_BY_SEQUENCE_NUMBER, account, sequenceNumber);
        int count = DbUtilsCon.getDataTable(  getTestEnvironment().getOracleUrl(), getTestEnvironment(), sql).size();
        return ( count > 0 ) ? true : false;
    }

    public boolean isVisitOtherIdExistingInDB(String account, String visitOtherId) {
        String sql = String.format(VisitSQL.SQL_GET_VISIT_BY_VISIT_OTHER_ID, account, visitOtherId);
        int count = DbUtilsCon.getDataTable(  getTestEnvironment().getOracleUrl(), getTestEnvironment(), sql).size();
        return ( count > 0 ) ? true : false;
    }

    public boolean isVisitMemoExistingInDB(String account, String memo) {
        String sql = String.format(VisitSQL.SQL_GET_VISIT_BY_MEMO, account, memo);
        int count = DbUtilsCon.getDataTable(  getTestEnvironment().getOracleUrl(), getTestEnvironment(), sql).size();
        return ( count > 0 ) ? true : false;
    }

    public boolean areVisitMemosExistingInDatabase(String accountId, List<String> memos) {

        String _memos = "";

        for ( int i =0; i <= memos.size() - 1; i++) {
            if (i == memos.size() - 1) {
                _memos+= "'" + memos.get(i) + "'";
            } else {
                _memos+= "'" + memos.get(i) + "',";
            }
        }

        String sql = String.format(VisitSQL.SQL_GET_VISIT_BY_MEMOS, accountId, _memos);
        List<Map<String, Object>> dataTable = getDataTable(sql, memos.size());

        for ( int i = 0; i <= memos.size() - 1; i++) {
            boolean found = false;
            String memo = memos.get(i);
            for ( int j = 0; j <= dataTable.size() - 1; j++) {

                String _memo = dataTable.get(j).get("MEMO").toString();
                if (memo.equalsIgnoreCase(_memo)) {
                    found = true;
                    break;
                }
            }
            if ( !found ) {
                logInfo(String.format("Visit with memo '%s' is not added in EVV DB.", memo));
            }
        }

        if (dataTable.size() == memos.size()) {
            logInfo(String.format("All '%s' memos are added in EVV DB.", memos.size()));
            return true;
        }
        return false;
    }

    public String getVisitFieldValue(String visitKey, String columnName) {
        String sql = String.format(VisitSQL.SQL_GET_VISIT_GENERAL, visitKey);
        List<Map<String, Object>> dataTable = DbUtilsCon.getDataTable(  getTestEnvironment().getOracleUrl(),
                getTestEnvironment(), sql);
        if ( dataTable.size() < 1 ) {
            logError(String.format("visit with visit key '%s' not found in database", visitKey));
            return "";
        } else {
            logInfo(String.format("visit with visit key '%s' found in database", visitKey));
        }
        Object value = dataTable.get(0).get(columnName);
        return String.valueOf(value);
    }

    public String generateNewVisitSequenceNumber(String account) {
        String sequenceNumber = RandomStringUtils.randomNumeric(16);
        while ( isVisitSequenceNumberExistingInDB(account, sequenceNumber) ) {
            logInfo("Visit sequence number " + sequenceNumber + EXIST_IN_DB_MSG);
            sequenceNumber = RandomStringUtils.randomNumeric(16);
        }
        return sequenceNumber;
    }

    public String generateNewVisitOtherId(String account) {
        String visitOtherId = RandomStringUtils.randomAlphanumeric(50);
        while ( isVisitOtherIdExistingInDB(account, visitOtherId) ) {
            logInfo("Visit other id: " + visitOtherId + EXIST_IN_DB_MSG);
            visitOtherId = RandomStringUtils.randomAlphanumeric(50);
        }
        return visitOtherId;
    }

    public String generateNewVisitMemo(String account) {
        String memo = RandomStringUtils.randomAlphanumeric(50);
        while ( isVisitMemoExistingInDB(account, memo) ) {
            logInfo("Visit memo: " + memo + EXIST_IN_DB_MSG);
            memo = RandomStringUtils.randomAlphanumeric(50);
        }
        return memo;
    }
}
