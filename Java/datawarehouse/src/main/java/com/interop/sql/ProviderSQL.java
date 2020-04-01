package com.interop.sql;

public class ProviderSQL {
    public static final String SQL_GET_PROVIDER_BY_PROVIDER_ID =
            "SELECT PROVIDER_ID ProviderID \n" +
                    "FROM INBOX.providers \n" +
                    "WHERE PROVIDER_ID  = '%s'";

    public static final String SQL_GET_PROVIDER_BY_PROVIDER_IDS =
            "SELECT PROVIDER_ID \n" +
                    "FROM INBOX.providers \n" +
                    "WHERE PROVIDER_ID in (%s)";
    public static final String SQL_GET_PROVIDER_GENERAL_BY_PROVIDER_ID = "SELECT accInterface.Provider_id_qlfr ProviderQualifier,\n" +
            "                    accInterface.provider_id ProviderID,\n" +
            "                    accs.compname ProviderName,\n" +
            "                    accInterface.provider_dba_name ProviderDoingBusinessAs,\n" +
            "                    accInfo.addr1 AddressLine1,\n" +
            "                    accInfo.addr2 AddressLine2,accInfo.city AddressCity,accInfo.state AddressState,\n" +
            "                    accInfo.zip_code AddressZip,accInfo.county County,accInfo.phone AgencyPhone,accInfo.e_mail AgencyEmail,\n" +
            "                    accInfo.contact_l_name PrimaryContactLastName,accInfo.contact_f_name PrimaryContactFirstName,accInfo.fax ProviderFax,\n" +
            "                    to_char(accInfo.npi) ProviderNPI,accInfo.api ProviderAPI, \n" +
            "                    null as ProviderMedicaidID,\n" +
            "                    null as SSN,\n" +
            "                    accInfo.federal_id TaxID,\n" +
            "                    null as ProviderTaxonomy,\n" +
            "                    accSet.auth_enabled ProviderRequireAuth, accSet.tzname ProviderTimeZone,\n" +
            "                    TO_CHAR(accInfo.effective_beg_date,'DD-MM-YY') ProviderDateBegin, TO_CHAR(accInfo.effective_end_date,'DD-MM-YY') ProviderDateEnd\n" +
            "            FROM stx.Accounts_Interfaces accInterface\n" +
            "                    LEFT JOIN STX.accounts_info accInfo ON accInterface.ACCOUNT = accInfo.ACCOUNT\n" +
            "                    LEFT JOIN STX.accounts_vendor_config venConf ON venConf.ACCOUNT = accInfo.ACCOUNT\n" +
            "                    LEFT JOIN STX.accounts_setup accSet ON accInterface.ACCOUNT = accSet.ACCOUNT\n" +
            "                    LEFT JOIN STX.accounts accs ON accs.account = '%s'\n" +
            "            WHERE accInterface.provider_id = '%s'";

    public static final String SQL_GET_COMPANY_NAME = "SELECT  acct.COMPNAME \n" +
            " FROM stx.Accounts acct\n" +
            " WHERE (acct.PROVIDER_NAME IS NULL OR acct.PROVIDER_ID IS NULL) AND acct.ACCOUNT = '%s' AND ROWNUM <= 1";
}
