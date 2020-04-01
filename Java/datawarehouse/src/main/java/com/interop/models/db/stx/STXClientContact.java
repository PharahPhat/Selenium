package com.interop.models.db.stx;

import com.sandata.core.annotation.DataTableColumn;

public class STXClientContact {
    @DataTableColumn
    private Object CLIENTKEY;
    @DataTableColumn
    private Object ACCOUNT;
    @DataTableColumn
    private Object LOC;
    @DataTableColumn
    private Object BEG_DATE;
    @DataTableColumn
    private Object END_DATE;
    @DataTableColumn
    private Object F_NAME;
    @DataTableColumn
    private Object L_NAME;
    @DataTableColumn
    private Object M_NAME;
    @DataTableColumn
    private Object ADDR1;
    @DataTableColumn
    private Object ADDR2;
    @DataTableColumn
    private Object CITY;
    @DataTableColumn
    private Object STATE;
    @DataTableColumn
    private Object ZIP_CODE;
    @DataTableColumn
    private Object PHONENUM_HOME;
    @DataTableColumn
    private Object PHONENUM_MOBILE;
    @DataTableColumn
    private Object PHONENUM_BUSINESS;
    @DataTableColumn
    private Object PHONENUM_OTHER;
    @DataTableColumn
    private Object E_MAIL;
    @DataTableColumn
    private Object CONTACT_RELATIONSHIP;
    @DataTableColumn
    private Object CLICONTACTKEY;
    @DataTableColumn
    private Object INSERT_TMSTP;
    @DataTableColumn
    private Object UPDATE_TMSTP;
    @DataTableColumn
    private Object UPDATE_ID;
    @DataTableColumn
    private Object CONTACT_TYPE_CODE;

    public Object getCLIENTKEY() {
        return CLIENTKEY;
    }

    public Object getACCOUNT() {
        return ACCOUNT;
    }

    public Object getLOC() {
        return LOC;
    }

    public Object getBEG_DATE() {
        return BEG_DATE;
    }

    public Object getEND_DATE() {
        return END_DATE;
    }

    public Object getF_NAME() {
        return F_NAME;
    }

    public Object getL_NAME() {
        return L_NAME;
    }

    public Object getM_NAME() {
        return M_NAME;
    }

    public Object getADDR1() {
        return ADDR1;
    }

    public Object getADDR2() {
        return ADDR2;
    }

    public Object getCITY() {
        return CITY;
    }

    public Object getSTATE() {
        return STATE;
    }

    public Object getZIP_CODE() {
        return ZIP_CODE;
    }

    public Object getPHONENUM_MOBILE() {
        return PHONENUM_MOBILE;
    }

    public Object getPHONENUM_BUSINESS() {
        return PHONENUM_BUSINESS;
    }

    public Object getPHONENUM_OTHER() {
        return PHONENUM_OTHER;
    }

    public Object getE_MAIL() {
        return E_MAIL;
    }

    public Object getCONTACT_RELATIONSHIP() {
        return CONTACT_RELATIONSHIP;
    }

    public Object getCLICONTACTKEY() {
        return CLICONTACTKEY;
    }

    public Object getINSERT_TMSTP() {
        return INSERT_TMSTP;
    }

    public Object getUPDATE_TMSTP() {
        return UPDATE_TMSTP;
    }

    public Object getUPDATE_ID() {
        return UPDATE_ID;
    }

    public Object getCONTACT_TYPE_CODE() {
        return CONTACT_TYPE_CODE;
    }

    public Object getPHONENUM_HOME() {
        return PHONENUM_HOME;
    }

    @Override
    public String toString() {
        return "STXClientContact{" +
                "CLIENTKEY=" + CLIENTKEY +
                ", ACCOUNT=" + ACCOUNT +
                ", LOC=" + LOC +
                ", BEG_DATE=" + BEG_DATE +
                ", END_DATE=" + END_DATE +
                ", F_NAME=" + F_NAME +
                ", L_NAME=" + L_NAME +
                ", M_NAME=" + M_NAME +
                ", ADDR1=" + ADDR1 +
                ", ADDR2=" + ADDR2 +
                ", CITY=" + CITY +
                ", STATE=" + STATE +
                ", ZIP_CODE=" + ZIP_CODE +
                ", PHONENUM_HOME=" + PHONENUM_HOME +
                ", PHONENUM_MOBILE=" + PHONENUM_MOBILE +
                ", PHONENUM_BUSSINESS=" + PHONENUM_BUSINESS +
                ", PHONENUM_OTHER=" + PHONENUM_OTHER +
                ", E_MAIL=" + E_MAIL +
                ", CONTACT_RELATIONSHIP=" + CONTACT_RELATIONSHIP +
                ", CLICONTACTKEY=" + CLICONTACTKEY +
                ", INSERT_TMSTP=" + INSERT_TMSTP +
                ", UPDATE_TMSTP=" + UPDATE_TMSTP +
                ", UPDATE_ID=" + UPDATE_ID +
                ", CONTACT_TYPE_CODE=" + CONTACT_TYPE_CODE +
                '}';
    }
}
