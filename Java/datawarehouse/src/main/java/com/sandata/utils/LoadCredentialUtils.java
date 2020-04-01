package com.sandata.utils;

import com.sandata.core.Wrapper;
import com.sandata.core.config.TestConfiguration;
import com.sandata.core.config.TestContext;

@SuppressWarnings("squid:S1192")
public class LoadCredentialUtils {
    private LoadCredentialUtils() {
    }
    private static Wrapper baseObj = new Wrapper();
    private static String accountTemplate;
    private static String provider_id;
    private static String auth_username;
    private static String auth_password;
    private static String mysql_url;
    private static String mysql_username;
    private static String mysql_pass;

    private static TestConfiguration config = TestContext.get();

    public static String getAccountTemplate() {
        return accountTemplate;
    }

    public static void setAccountTemplate(String accountTemplate) {
        LoadCredentialUtils.accountTemplate = accountTemplate;
    }

    public static String getProvider_id() {
        return provider_id;
    }

    public static void setProvider_id(String provider_id) {
        LoadCredentialUtils.provider_id = provider_id;
    }

    public static String getAuth_username() {
        return auth_username;
    }

    public static void setAuth_username(String auth_username) {
        LoadCredentialUtils.auth_username = auth_username;
    }

    public static String getAuth_password() {
        return auth_password;
    }

    public static void setAuth_password(String auth_password) {
        LoadCredentialUtils.auth_password = auth_password;
    }

    public static String getMysql_url() {
        return mysql_url;
    }

    public static void setMysql_url(String mysql_url) {
        LoadCredentialUtils.mysql_url = mysql_url;
    }

    public static String getMysql_username() {
        return mysql_username;
    }

    public static void setMysql_username(String mysql_username) {
        LoadCredentialUtils.mysql_username = mysql_username;
    }

    public static String getMysql_pass() {
        return mysql_pass;
    }

    public static void setMysql_pass(String mysql_pass) {
        LoadCredentialUtils.mysql_pass = mysql_pass;
    }

    public static void loadCredentialAndTemplateACC() {
        String accountType = config.getTestData().getValue("AccountType");
        switch (accountType) {
            case "OHIO":
                accountTemplate = config.getEnvironment("ohio_accountId");
                provider_id = config.getEnvironment("ohio_providerId");
                auth_username = config.getEnvironment("ohio_UserName");
                auth_password = config.getEnvironment("ohio_Password");
                mysql_url = config.getEnvironment("mySqlUrl");
                mysql_username = config.getEnvironment("mysql_user");
                mysql_pass = config.getEnvironment("mysql_pass");
                break;
            case "MOLINA":
                accountTemplate = config.getEnvironment("molina_accountId");
                provider_id = config.getEnvironment("molina_providerId");
                auth_username = config.getEnvironment("molina_UserName");
                auth_password = config.getEnvironment("molina_Password");
                break;
            case "INDIANA":
                accountTemplate = config.getEnvironment("indiana_accountId");
                provider_id = config.getEnvironment("indiana_providerId");
                auth_username = config.getEnvironment("indiana_UserName");
                auth_password = config.getEnvironment("indiana_Password");
                break;
            case "PENNSYLVANIA":
                accountTemplate = config.getEnvironment("pennsylvania_accountId");
                provider_id = config.getEnvironment("pennsylvania_providerId");
                auth_username = config.getEnvironment("pennsylvania_UserName");
                auth_password = config.getEnvironment("pennsylvania_Password");
                mysql_url = config.getEnvironment("mySqlUrl");
                mysql_username = config.getEnvironment("mysql_user");
                mysql_pass = config.getEnvironment("mysql_pass");
                break;
            case "COLORADO":
                accountTemplate = config.getEnvironment("colorado_accountId");
                provider_id = config.getEnvironment("colorado_providerId");
                auth_username = config.getEnvironment("colorado_UserName");
                auth_password = config.getEnvironment("colorado_Password");
                mysql_url = config.getEnvironment("mySqlUrl");
                mysql_username = config.getEnvironment("mysql_user");
                mysql_pass = config.getEnvironment("mysql_pass");
                break;
            case "CONNECTICUT":
                accountTemplate = config.getEnvironment("connecticut_accountId");
                provider_id = config.getEnvironment("connecticut_providerId");
                auth_username = config.getEnvironment("connecticut_UserName");
                auth_password = config.getEnvironment("connecticut_Password");
                break;
            default:
                baseObj.info(String.format("The account type %s is not existed in the list account type",accountType));
                break;
        }
    }
}
