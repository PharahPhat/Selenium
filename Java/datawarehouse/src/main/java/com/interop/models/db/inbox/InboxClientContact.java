package com.interop.models.db.inbox;

import com.sandata.core.annotation.DataTableColumn;

public class InboxClientContact extends InboxModel {
    @DataTableColumn
    Object ERROR_CODE;
    @DataTableColumn
    Object F_NAME;
    @DataTableColumn
    Object L_NAME;
    @DataTableColumn
    Object ADDR1;
    @DataTableColumn
    Object ADDR2;
    @DataTableColumn
    Object E_MAIL;
    @DataTableColumn
    Object DELETE_FLAG;
    @DataTableColumn
    Object INSERT_TMSTP;
    @DataTableColumn
    Object LOC;

    public Object getERROR_CODE() {
        return ERROR_CODE;
    }

    public void setERROR_CODE(Object ERROR_CODE) {
        this.ERROR_CODE = ERROR_CODE;
    }

    public Object getF_NAME() {
        return F_NAME;
    }

    public void setF_NAME(Object f_NAME) {
        F_NAME = f_NAME;
    }

    public Object getL_NAME() {
        return L_NAME;
    }

    public void setL_NAME(Object l_NAME) {
        L_NAME = l_NAME;
    }

    public Object getADDR1() {
        return ADDR1;
    }

    public void setADDR1(Object ADDR1) {
        this.ADDR1 = ADDR1;
    }

    public Object getADDR2() {
        return ADDR2;
    }

    public void setADDR2(Object ADDR2) {
        this.ADDR2 = ADDR2;
    }

    public Object getEMAIL() {
        return E_MAIL;
    }

    public void setEMAIL(Object E_MAIL) {
        this.E_MAIL = E_MAIL;
    }

    public Object getDELETE_FLAG() {
        return DELETE_FLAG;
    }

    public void setDELETE_FLAG(Object DELETE_FLAG) {
        this.DELETE_FLAG = DELETE_FLAG;
    }

    public Object getINSERT_TMSTP() {
        return INSERT_TMSTP;
    }

    public void setINSERT_TMSTP(Object INSERT_TMSTP) {
        this.INSERT_TMSTP = INSERT_TMSTP;
    }

    public Object getLOC() {
        return LOC;
    }

    public void setLOC(Object LOC) {
        this.LOC = LOC;
    }

    @Override
    public String toString() {
        return "InboxClientContact{" +
                "ERROR_CODE=" + ERROR_CODE +
                "F_NAME=" + F_NAME +
                "L_NAME=" + L_NAME +
                "ADDR1=" + ADDR1 +
                "ADDR2=" + ADDR2 +
                "E_MAIL=" + E_MAIL +
                "DELETE_FLAG=" + DELETE_FLAG +
                "INSERT_TMSTP=" + INSERT_TMSTP +
                "LOC=" + LOC +
                '}';
    }
}
