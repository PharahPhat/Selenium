package com.interop.models.db.inbox;

import com.interop.common.TestDataHelper;
import com.sandata.core.annotation.DataTableColumn;
import com.sandata.utilities.ColumnAnnotationMapper;
import com.sandata.utilities.DbUtilsCon;
import lombok.Data;

import java.sql.ResultSet;
import java.util.List;

import static com.interop.sql.ClientSQL.QUERY_INBOX_APP_USERS_BY_NAME;

@Data
public class InboxAppUser {
    @DataTableColumn
    Object ACCOUNT;
    @DataTableColumn
    Object ACCOUNT_STATUS;
    @DataTableColumn
    Object DATA_SCOPE_ID;
    @DataTableColumn
    Object DELETE_FLAG;
    @DataTableColumn
    Object DESCRIPTION;
    @DataTableColumn
    Object E_MAIL;
    @DataTableColumn
    Object ERROR_CODE;
    @DataTableColumn
    Object EXPIRE_DATE;
    @DataTableColumn
    Object INSERT_TMSTP;
    @DataTableColumn
    Object LOCK_DATE;
    @DataTableColumn
    Object PASSWORD;
    @DataTableColumn
    Object SID;
    @DataTableColumn
    Object USER_F_NAME;
    @DataTableColumn
    Object USER_ID;
    @DataTableColumn
    Object USER_L_NAME;
    @DataTableColumn
    Object USER_TYPE_ID;
    @DataTableColumn
    Object USERNAME;
    @DataTableColumn
    Object USRKEY;

    public static List<InboxAppUser> getINBOXAppUsers(String account, String fName) {
        ColumnAnnotationMapper<InboxAppUser> mapper = new ColumnAnnotationMapper<>(InboxAppUser.class);
        String getQuery = String.format(QUERY_INBOX_APP_USERS_BY_NAME, account, fName);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }
}
