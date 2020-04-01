package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;

public class STXPayorID {
    @DataTableColumn
    public String PAYOR_ID;
    @DataTableColumn
    public String PROGRAM;
    @DataTableColumn
    public String PROC_CODE;
    @DataTableColumn
    public String MODIFIER1;
    @DataTableColumn
    public String MODIFIER2;
    @DataTableColumn
    public String MODIFIER3;
    @DataTableColumn
    public String MODIFIER4;

    @Override
    public String toString() {
        return "STXPayorID{" +
                "PAYOR_ID='" + PAYOR_ID + '\'' +
                ", PROGRAM='" + PROGRAM + '\'' +
                ", PROC_CODE='" + PROC_CODE + '\'' +
                ", MODIFIER1='" + MODIFIER1 + '\'' +
                ", MODIFIER2='" + MODIFIER2 + '\'' +
                ", MODIFIER3='" + MODIFIER3 + '\'' +
                ", MODIFIER4='" + MODIFIER4 + '\'' +
                '}';
    }
}
