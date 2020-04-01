package com.interop.models.db.inbox;

import com.sandata.core.annotation.DataTableColumn;
import org.apache.commons.lang.builder.ToStringBuilder;

public class InboxAuthLimits {
    @DataTableColumn
    private Object ERROR_CODE;
    @DataTableColumn
    private Object PROCEDURECODE;
    @DataTableColumn
    private Object PAYERPROGRAM;
    @DataTableColumn
    private Object MODIFIER1;
    @DataTableColumn
    private Object MODIFIER2;
    @DataTableColumn
    private Object MODIFIER3;
    @DataTableColumn
    private Object MODIFIER4;

    public Object getERROR_CODE() {
        return ERROR_CODE;
    }

    public void setERROR_CODE(Object ERROR_CODE) {
        this.ERROR_CODE = ERROR_CODE;
    }

    public Object getPROCEDURECODE() {
        return PROCEDURECODE;
    }

    public void setPROCEDURECODE(Object PROCEDURECODE) {
        this.PROCEDURECODE = PROCEDURECODE;
    }

    public Object getPAYERPROGRAM() {
        return PAYERPROGRAM;
    }

    public void setPAYERPROGRAM(Object PAYERPROGRAM) {
        this.PAYERPROGRAM = PAYERPROGRAM;
    }

    public Object getMODIFIER1() {
        return MODIFIER1;
    }

    public void setMODIFIER1(Object MODIFIER1) {
        this.MODIFIER1 = MODIFIER1;
    }

    public Object getMODIFIER2() {
        return MODIFIER2;
    }

    public void setMODIFIER2(Object MODIFIER2) {
        this.MODIFIER2 = MODIFIER2;
    }

    public Object getMODIFIER3() {
        return MODIFIER3;
    }

    public void setMODIFIER3(Object MODIFIER3) {
        this.MODIFIER3 = MODIFIER3;
    }

    public Object getMODIFIER4() {
        return MODIFIER4;
    }

    public void setMODIFIER4(Object MODIFIER4) {
        this.MODIFIER4 = MODIFIER4;
    }

    @Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this);
    }
}
