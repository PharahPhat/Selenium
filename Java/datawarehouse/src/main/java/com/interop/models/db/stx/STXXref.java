package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;
import lombok.Data;

@Data
public class STXXref {

    @DataTableColumn
    Object XREF_SVC_ID;

    @DataTableColumn
    Object BEG_DATE;

    @DataTableColumn
    Object END_DATE;

    @DataTableColumn
    Object ACCOUNT;

    @DataTableColumn
    Object LOC;

    @DataTableColumn
    Object STX_ID;

    @DataTableColumn
    Object SERVICE;

    @DataTableColumn
    Object SERVICE_CODE;

    @DataTableColumn
    Object AUTH_REF_NUMBER;
}
