package com.interop.services.db;

import com.interop.models.db.staging.*;
import com.interop.common.TestDataHelper;
import com.sandata.utilities.ColumnAnnotationMapper;
import com.sandata.utilities.DbUtilsCon;

import java.sql.ResultSet;
import java.util.List;

import static com.interop.common.constants.queries.InterOpMySQL.*;

public class ClientMySqlDBServices {

    private ClientMySqlDBServices() {
    }

    public static List<StagingClientEligibilities> getClientEligRecords(String clientID, String account) {
        ColumnAnnotationMapper mapper = new ColumnAnnotationMapper(StagingClientEligibilities.class);
        String getQuery = String.format(MYSQL_GET_CLIENT_ELIG_INFO, clientID, account);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }

    public static List<StagingClientPhones> getClientPhoneRecords(String clientID, String account) {
        ColumnAnnotationMapper mapper = new ColumnAnnotationMapper(StagingClientPhones.class);
        String getQuery = String.format(MYSQL_GET_CLIENT_PHONE_INFO, clientID, account);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }

    public static List<StagingClientAddress> getClientAddrRecords(String clientID, String account) {
        ColumnAnnotationMapper mapper = new ColumnAnnotationMapper(StagingClientAddress.class);
        String getQuery = String.format(MYSQL_GET_CLIENT_ADDR_INFO, clientID, account);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }

    public static List<StagingClientContact> getClientContRecords(String clientID, String account, String type) {
        ColumnAnnotationMapper mapper = new ColumnAnnotationMapper(StagingClientContact.class);
        String getQuery = String.format(MYSQL_GET_CLIENT_CONTACT_INFO, clientID, account, type);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }

    public static List<StagingClient> getClientBasicInformation(String clientMedicaidID, String account) {
        ColumnAnnotationMapper mapper = new ColumnAnnotationMapper(StagingClient.class);
        String getQuery = String.format(MY_SQL_GET_BASIC_INFO_BY_CLIENT_MEDICAID_ID, account, clientMedicaidID);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }
    public static List<StagingClient> getClientBasicInformationByClientID(String clientCustomID, String account) {
        ColumnAnnotationMapper mapper = new ColumnAnnotationMapper(StagingClient.class);
        String getQuery = String.format(MY_SQL_GET_BASIC_INFO_BY_CLIENT_ID, account, clientCustomID);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getMySQLConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }
}
