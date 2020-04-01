package com.interop.models.db.stx;

import com.interop.common.TestDataHelper;
import com.sandata.core.annotation.DataTableColumn;
import com.sandata.utilities.ColumnAnnotationMapper;
import com.sandata.utilities.DbUtilsCon;
import lombok.Data;

import java.sql.ResultSet;
import java.util.List;

import static com.interop.sql.ClientSQL.SQL_STX_APP_USERS;

@Data
public class STXAppUser {

    @DataTableColumn
    public Object ACCOUNT;

    @DataTableColumn
    public Object USERNAME;

    @DataTableColumn
    public Object PASSWORD;

    @DataTableColumn
    public Object DATA_SCOPE_ID;

    @DataTableColumn
    public Object ACCOUNT_STATUS;

    @DataTableColumn
    public Object USER_TYPE_ID;

    @DataTableColumn
    public Object USER_ID;

    @DataTableColumn
    public Object DELETED;

    @DataTableColumn
    private Object USER_F_NAME;

    @DataTableColumn
    private Object USER_L_NAME;

    public Object getDELETED() {
        return DELETED;
    }

    public void setDELETED(Object DELETED) {
        this.DELETED = DELETED;
    }

    public Object getACCOUNT() {
        return ACCOUNT;
    }

    public Object getUSERNAME() {
        return USERNAME;
    }

    public Object getPASSWORD() {
        return PASSWORD;
    }

    public Object getDATA_SCOPE_ID() {
        return DATA_SCOPE_ID;
    }

    public Object getACCOUNT_STATUS() {
        return ACCOUNT_STATUS;
    }

    public Object getUSER_TYPE_ID() {
        return USER_TYPE_ID;
    }

    public Object getUSER_ID() {
        return USER_ID;
    }

    public Object getUSER_F_NAME() {
        return USER_F_NAME;
    }

    public void setUSER_F_NAME(Object USER_F_NAME) {
        this.USER_F_NAME = USER_F_NAME;
    }

    public Object getUSER_L_NAME() {
        return USER_L_NAME;
    }

    public void setUSER_L_NAME(Object USER_L_NAME) {
        this.USER_L_NAME = USER_L_NAME;
    }

    @Override
    public String toString() {
        return "STXAppUser{" +
                "ACCOUNT=" + ACCOUNT +
                ", USERNAME=" + USERNAME +
                ", PASSWORD=" + PASSWORD +
                ", DATA_SCOPE_ID=" + DATA_SCOPE_ID +
                ", ACCOUNT_STATUS=" + ACCOUNT_STATUS +
                ", USER_TYPE_ID=" + USER_TYPE_ID +
                ", USER_ID=" + USER_ID +
                ", DELETED=" + DELETED +
                '}';
    }

    public static List<STXAppUser> getSTXAppUser(String account, String username) {
        ColumnAnnotationMapper<STXAppUser> mapper = new ColumnAnnotationMapper<>(STXAppUser.class);
        String getQuery = String.format(SQL_STX_APP_USERS, account, username);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }
}
