package com.interop.models.db.stx;

import com.interop.common.TestDataHelper;
import com.sandata.core.annotation.DataTableColumn;
import com.sandata.utilities.ColumnAnnotationMapper;
import com.sandata.utilities.DbUtilsCon;

import java.sql.ResultSet;
import java.util.List;

import static com.interop.sql.VisitSQL.SQLSTXVISITCLAIM;

public class STXVisit_Claim {
    @DataTableColumn
    private Object VISITKEY;
    @DataTableColumn
    private Object VISIT_STATUS;
    @DataTableColumn
    private Object VISIT_DATE;
    @DataTableColumn
    private Object VISIT_EDATE;
    @DataTableColumn
    private Object BEG_CALL_DTIME;
    @DataTableColumn
    private Object END_CALL_DTIME;
    @DataTableColumn
    private Object SERVICE;
    @DataTableColumn
    private Object PAYOR_ID;
    @DataTableColumn
    private Object BILL_HOURS;
    @DataTableColumn
    private Object ACCOUNT;
    @DataTableColumn
    private Object MEDICAID_ID;
    @DataTableColumn
    private Object BILL_UNITS;
    @DataTableColumn
    private Object VISIT_VERSION_NUMBER;

    public Object getVISITKEY() {
        return VISITKEY;
    }

    public void setVISITKEY(Object VISITKEY) {
        this.VISITKEY = VISITKEY;
    }

    public Object getVISIT_STATUS() {
        return VISIT_STATUS;
    }

    public void setVISIT_STATUS(Object VISIT_STATUS) {
        this.VISIT_STATUS = VISIT_STATUS;
    }

    public Object getVISIT_DATE() {
        return VISIT_DATE;
    }

    public void setVISIT_DATE(Object VISIT_DATE) {
        this.VISIT_DATE = VISIT_DATE;
    }

    public Object getVISIT_EDATE() {
        return VISIT_EDATE;
    }

    public void setVISIT_EDATE(Object VISIT_EDATE) {
        this.VISIT_EDATE = VISIT_EDATE;
    }

    public Object getBEG_CALL_DTIME() {
        return BEG_CALL_DTIME;
    }

    public void setBEG_CALL_DTIME(Object BEG_CALL_DTIME) {
        this.BEG_CALL_DTIME = BEG_CALL_DTIME;
    }

    public Object getEND_CALL_DTIME() {
        return END_CALL_DTIME;
    }

    public void setEND_CALL_DTIME(Object END_CALL_DTIME) {
        this.END_CALL_DTIME = END_CALL_DTIME;
    }

    public Object getSERVICE() {
        return SERVICE;
    }

    public void setSERVICE(Object SERVICE) {
        this.SERVICE = SERVICE;
    }

    public Object getPAYOR_ID() {
        return PAYOR_ID;
    }

    public void setPAYOR_ID(Object PAYOR_ID) {
        this.PAYOR_ID = PAYOR_ID;
    }

    public Object getBILL_HOURS() {
        return BILL_HOURS;
    }

    public void setBILL_HOURS(Object BILL_HOURS) {
        this.BILL_HOURS = BILL_HOURS;
    }

    public Object getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(Object ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }

    public Object getMEDICAID_ID() {
        return MEDICAID_ID;
    }

    public void setMEDICAID_ID(Object MEDICAID_ID) {
        this.MEDICAID_ID = MEDICAID_ID;
    }

    public Object getBILL_UNITS() {
        return BILL_UNITS;
    }

    public void setBILL_UNITS(Object BILL_UNITS) {
        this.BILL_UNITS = BILL_UNITS;
    }

    public static List<STXVisit_Claim> getSTXVisitClaim(String account, String service, String visitVersionNumber) {
        ColumnAnnotationMapper<STXVisit_Claim> mapper = new ColumnAnnotationMapper<>(STXVisit_Claim.class);
        String getQuery = String.format(SQLSTXVISITCLAIM, account, service, visitVersionNumber);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), getQuery);
        return mapper.DataTableMapper(rs);
    }

    public Object getVISIT_VERSION_NUMBER() {
        return VISIT_VERSION_NUMBER;
    }

    public void setVISIT_VERSION_NUMBER(Object VISIT_VERSION_NUMBER) {
        this.VISIT_VERSION_NUMBER = VISIT_VERSION_NUMBER;
    }

    @Override
    public String toString() {
        return "STXVisit_Claim{" +
                "VISITKEY=" + VISITKEY +
                ", VISIT_STATUS=" + VISIT_STATUS +
                ", VISIT_DATE=" + VISIT_DATE +
                ", VISIT_EDATE=" + VISIT_EDATE +
                ", BEG_CALL_DTIME=" + BEG_CALL_DTIME +
                ", END_CALL_DTIME=" + END_CALL_DTIME +
                ", SERVICE=" + SERVICE +
                ", PAYOR_ID=" + PAYOR_ID +
                ", BILL_HOURS=" + BILL_HOURS +
                ", ACCOUNT=" + ACCOUNT +
                ", MEDICAID_ID=" + MEDICAID_ID +
                ", BILL_UNITS=" + BILL_UNITS +
                ", VISIT_VERSION_NUMBER=" + VISIT_VERSION_NUMBER +
                '}';
    }
}
