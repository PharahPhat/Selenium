package com.interop.models.db.staging;
import com.sandata.core.annotation.DataTableColumn;

public class StagingClientAddress {

    @DataTableColumn
    private Object CLIENT_ID;

    @DataTableColumn
    private Object CLIENT_ADDR1;

    @DataTableColumn
    private Object CLIENT_ADDR2;

    @DataTableColumn
    private Object CLIENT_COUNTY;

    @DataTableColumn
    private Object CLIENT_CITY;

    @DataTableColumn
    private Object CLIENT_STATE;

    @DataTableColumn
    private Object CLIENT_ZIP_CODE;

    @DataTableColumn
    private Object ACCOUNT;

    public Object getCLIENT_ID() {
        return CLIENT_ID;
    }

    public void setCLIENT_ID(Object CLIENT_ID) {
        this.CLIENT_ID = CLIENT_ID;
    }

    public Object getCLIENT_ADDR1() {
        return CLIENT_ADDR1;
    }

    public void setCLIENT_ADDR1(Object CLIENT_ADDR1) {
        this.CLIENT_ADDR1 = CLIENT_ADDR1;
    }

    public Object getCLIENT_ADDR2() {
        return CLIENT_ADDR2;
    }

    public void setCLIENT_ADDR2(Object CLIENT_ADDR2) {
        this.CLIENT_ADDR2 = CLIENT_ADDR2;
    }

    public Object getCLIENT_COUNTRY() {
        return CLIENT_COUNTY;
    }

    public void setCLIENT_COUNTRY(Object CLIENT_COUNTRY) {
        this.CLIENT_COUNTY = CLIENT_COUNTRY;
    }

    public Object getCLIENT_CITY() {
        return CLIENT_CITY;
    }

    public void setCLIENT_CITY(Object CLIENT_CITY) {
        this.CLIENT_CITY = CLIENT_CITY;
    }

    public Object getCLIENT_STATE() {
        return CLIENT_STATE;
    }

    public void setCLIENT_STATE(Object CLIENT_STATE) {
        this.CLIENT_STATE = CLIENT_STATE;
    }

    public Object getCLIENT_ZIP_CODE() {
        return CLIENT_ZIP_CODE;
    }

    public void setCLIENT_ZIP_CODE(Object CLIENT_ZIP_CODE) {
        this.CLIENT_ZIP_CODE = CLIENT_ZIP_CODE;
    }

    public Object getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(Object ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }
}
