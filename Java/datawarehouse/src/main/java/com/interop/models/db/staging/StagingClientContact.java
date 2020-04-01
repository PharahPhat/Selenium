package com.interop.models.db.staging;
import com.sandata.core.annotation.DataTableColumn;

public class StagingClientContact {

    @DataTableColumn
    private Object CLIENT_ID;

    @DataTableColumn
    private Object CONT_F_NAME;

    @DataTableColumn
    private Object CONT_L_NAME;

    @DataTableColumn
    private Object CONT_PHONE_NUM;

    @DataTableColumn
    private Object CONT_E_MAIL;

    @DataTableColumn
    private Object CONT_ADDR1;

    @DataTableColumn
    private Object CONT_ADDR2;

    @DataTableColumn
    private Object CONT_CITY;

    @DataTableColumn
    private Object CONT_STATE;

    @DataTableColumn
    private Object CONT_ZIP_CODE;

    @DataTableColumn
    private Object ACCOUNT;

    @DataTableColumn
    private Object CONT_TYP_CODE;

    public Object getCLIENT_ID() {
        return CLIENT_ID;
    }

    public void setCLIENT_ID(Object CLIENT_ID) {
        this.CLIENT_ID = CLIENT_ID;
    }

    public Object getCONT_F_NAME() {
        return CONT_F_NAME;
    }

    public void setCONT_F_NAME(Object CONT_F_NAME) {
        this.CONT_F_NAME = CONT_F_NAME;
    }

    public Object getCONT_L_NAME() {
        return CONT_L_NAME;
    }

    public void setCONT_L_NAME(Object CONT_L_NAME) {
        this.CONT_L_NAME = CONT_L_NAME;
    }

    public Object getCONT_PHONE_NUM() {
        return CONT_PHONE_NUM;
    }

    public void setCONT_PHONE_NUM(Object CONT_PHONE_NUM) {
        this.CONT_PHONE_NUM = CONT_PHONE_NUM;
    }

    public Object getCONT_E_MAIL() {
        return CONT_E_MAIL;
    }

    public void setCONT_E_MAIL(Object CONT_E_MAIL) {
        this.CONT_E_MAIL = CONT_E_MAIL;
    }

    public Object getCONT_ADDR1() {
        return CONT_ADDR1;
    }

    public void setCONT_ADDR1(Object CONT_ADDR1) {
        this.CONT_ADDR1 = CONT_ADDR1;
    }

    public Object getCONT_ADDR2() {
        return CONT_ADDR2;
    }

    public void setCONT_ADDR2(Object CONT_ADDR2) {
        this.CONT_ADDR2 = CONT_ADDR2;
    }

    public Object getCONT_CITY() {
        return CONT_CITY;
    }

    public void setCONT_CITY(Object CONT_CITY) {
        this.CONT_CITY = CONT_CITY;
    }

    public Object getCONT_STATE() {
        return CONT_STATE;
    }

    public void setCONT_STATE(Object CONT_STATE) {
        this.CONT_STATE = CONT_STATE;
    }

    public Object getCONT_ZIP_CODE() {
        return CONT_ZIP_CODE;
    }

    public void setCONT_ZIP_CODE(Object CONT_ZIP_CODE) {
        this.CONT_ZIP_CODE = CONT_ZIP_CODE;
    }

    public Object getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(Object ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }

    public Object getCONT_TYP_CODE() {
        return CONT_TYP_CODE;
    }

    public void setCONT_TYP_CODE(Object CONT_TYP_CODE) {
        this.CONT_TYP_CODE = CONT_TYP_CODE;
    }
}
