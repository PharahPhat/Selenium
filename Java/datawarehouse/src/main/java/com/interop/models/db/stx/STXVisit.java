package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class STXVisit {
    @DataTableColumn
    private Object ACCOUNT;
    @DataTableColumn
    private Object VISIT_DATE;
    @DataTableColumn
    private Object VISIT_EDATE;
    @DataTableColumn
    private Object BEG_CALL_DTIME;
    @DataTableColumn
    private Object END_CALL_DTIME;
    @DataTableColumn
    private String ANI;
    @DataTableColumn
    private String STX_ID;
    @DataTableColumn
    private Object VISITKEY;
    @DataTableColumn
    private Object UPDATE_TMSTP;
    @DataTableColumn
    private String SERVICE;
    @DataTableColumn
    private String VISIT_ID;
    @DataTableColumn
    private Object VISIT_VERSION_NUMBER;
    @DataTableColumn
    private String PAYOR_ID;
    @DataTableColumn
    private String PROGRAM;
}
