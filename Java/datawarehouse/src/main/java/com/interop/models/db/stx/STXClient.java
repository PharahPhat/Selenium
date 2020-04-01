package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;
import lombok.Data;
import lombok.Getter;

@Getter
public class STXClient {
    @DataTableColumn public Object ACCOUNT;
    @DataTableColumn public Object CLIENTKEY;
    @DataTableColumn public Object BEG_DATE;
    @DataTableColumn public Object END_DATE;
    @DataTableColumn public Object LOC;
    @DataTableColumn public String F_NAME;
    @DataTableColumn public String L_NAME;
    @DataTableColumn public String SPV;
    @DataTableColumn public String TTX_FLAG;
    @DataTableColumn public Object DIS_DATE;
    @DataTableColumn public Object CLI_EXPLAIN;
    @DataTableColumn public Object UPDATE_ID;
    @DataTableColumn public String M_NAME;
    @DataTableColumn public String DESCRIPTION;
    @DataTableColumn public String TZNAME;
    @DataTableColumn public Object CLIENT_VERSION_NUMBER;
    @DataTableColumn public String NAME_SUFFIX;
    @DataTableColumn public String SPV_E_MAIL;
    @DataTableColumn public String CLIENT_ID_CUSTOM1;
    @DataTableColumn public String CONTGY_PLAN_ASSENT_IND;

    @Override
    public String toString() {
        return "STXClient{" +
                "ACCOUNT=" + ACCOUNT +
                ", CLIENTKEY=" + CLIENTKEY +
                ", BEG_DATE=" + BEG_DATE +
                ", END_DATE=" + END_DATE +
                ", LOC=" + LOC +
                ", F_NAME='" + F_NAME + '\'' +
                ", L_NAME='" + L_NAME + '\'' +
                ", SPV='" + SPV + '\'' +
                ", TTX_FLAG='" + TTX_FLAG + '\'' +
                ", DIS_DATE=" + DIS_DATE +
                ", CLI_EXPLAIN=" + CLI_EXPLAIN +
                ", UPDATE_ID=" + UPDATE_ID +
                ", M_NAME='" + M_NAME + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", TZNAME='" + TZNAME + '\'' +
                ", CLIENT_VERSION_NUMBER=" + CLIENT_VERSION_NUMBER +
                ", NAME_SUFFIX='" + NAME_SUFFIX + '\'' +
                ", SPV_E_MAIL='" + SPV_E_MAIL + '\'' +
                ", CLIENT_ID_CUSTOM1='" + CLIENT_ID_CUSTOM1 + '\'' +
                '}';
    }
}
