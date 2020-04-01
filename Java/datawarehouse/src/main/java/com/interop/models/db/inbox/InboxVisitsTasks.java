package com.interop.models.db.inbox;

import com.sandata.core.annotation.DataTableColumn;
import lombok.Data;

@Data
public class InboxVisitsTasks {
    @DataTableColumn
    Object VISTASKKEY;
    @DataTableColumn
    Object SID;
    @DataTableColumn
    Object INSERT_TMSTP;
    @DataTableColumn
    Object DELETE_FLAG;
    @DataTableColumn
    Object VISKEY;
    @DataTableColumn
    Object VISIT_ID;
    @DataTableColumn
    Object ERROR_CODE;
    @DataTableColumn
    Object TASK_ID;
    @DataTableColumn
    Object TASK_READING;
    @DataTableColumn
    Object TASK_REFUSED_IND;
}
