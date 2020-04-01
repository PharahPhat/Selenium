package com.interop.models.db.inbox;

import com.sandata.core.annotation.DataTableColumn;

import java.time.LocalDateTime;

public class InboxClient extends InboxModel {
    @DataTableColumn
    Object CKEY;
    @DataTableColumn
    Object SID;
    @DataTableColumn
    Object INSERT_TMSTP;
    @DataTableColumn
    Object DELETE_FLAG;
    @DataTableColumn
    Object ERROR_CODE;
    @DataTableColumn
    String WEEK_END;
    @DataTableColumn
    String ACCOUNT;
    @DataTableColumn
    String LOC;
    @DataTableColumn
    String F_NAME;
    @DataTableColumn
    String L_NAME;
    @DataTableColumn
    String M_NAME;
    @DataTableColumn
    String SPV;
    @DataTableColumn
    String TTX_FLAG;
    @DataTableColumn
    Object DIS_DATE;
    @DataTableColumn
    String ADDR1;
    @DataTableColumn
    String ADDR2;
    @DataTableColumn
    String CITY;
    @DataTableColumn
    String STATE;
    @DataTableColumn
    String ZIP_CODE;
    @DataTableColumn
    String FAX;
    @DataTableColumn
    String FAX_TIME;
    @DataTableColumn
    String CLIENT_SSN;
    @DataTableColumn
    String CONTRACT;
    @DataTableColumn
    String BILLRATE;
    @DataTableColumn
    String SERVICE;
    @DataTableColumn
    String CASENUM;
    @DataTableColumn
    String CASESEQ;
    @DataTableColumn
    String MRN;
    @DataTableColumn
    String AR_NO;
    @DataTableColumn
    String TEAM;
    @DataTableColumn
    String BRANCH;
    @DataTableColumn
    String BOROUGH;
    @DataTableColumn
    String CLIENT_PRIORITY;
    @DataTableColumn
    String AREA;
    @DataTableColumn
    String COMPANYNUM;
    @DataTableColumn
    String NURSING_PROGRAM;
    @DataTableColumn
    String SEX;
    @DataTableColumn
    Object DOB;
    @DataTableColumn
    String MANAGED_CARE;
    @DataTableColumn
    String TZNAME;
    @DataTableColumn
    String CLIENT_ID_CUSTOM1;
    @DataTableColumn
    String CLIENT_ID_CUSTOM2;
    @DataTableColumn
    String MEDICAID_ID;
    @DataTableColumn
    String REGION;
    @DataTableColumn
    LocalDateTime ELIGIBILITY_BEG_DATE;
    @DataTableColumn
    Object ELIGIBILITY_END_DATE;
    @DataTableColumn
    Object CLIENT_VERSION_NUMBER;
    @DataTableColumn
    String LANGUAGE;
    @DataTableColumn
    Object LATITUDE;
    @DataTableColumn
    Object LONGITUDE;
    @DataTableColumn
    String ADDR_TYPE_QLFR;
    @DataTableColumn
    String NAME_SUFFIX;
    @DataTableColumn
    String CASE_MANAGER;
    @DataTableColumn
    String MARITAL_STATUS_CODE;
    @DataTableColumn
    String ADMISSION_TYPE;
    @DataTableColumn
    String DIAGNOSIS_CODE;
    @DataTableColumn
    String COUNTY;
    @DataTableColumn
    String E_MAIL;
    @DataTableColumn
    String SPV_E_MAIL;
    @DataTableColumn
    String CASE_MANAGER_E_MAIL;
    @DataTableColumn
    String MEDICAID_ID_UNAVAIL_IND;
    @DataTableColumn
    String MEDICAID_ID_OTHER;
    @DataTableColumn
    String CLIENT_NEWBORN_IND;
    @DataTableColumn
    Object MEDICAID_ENROLLMENT_DATE;
}
