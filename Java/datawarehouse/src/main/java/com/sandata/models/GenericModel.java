package com.sandata.models;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gson.annotations.Expose;
import com.interop.common.Commons;
import com.sandata.common.Constant;
import com.interop.common.StateAccount;
import com.sandata.core.config.Environment;
import com.sandata.core.config.TestConfiguration;
import com.sandata.core.config.TestContext;
import com.sandata.core.report.ExtentTestManager;
import com.sandata.core.ws.WebServicesBase;
import com.sandata.db.*;
import com.sandata.models.response.ResponseStatusAltModel;
import com.sandata.models.response.ResponseStatusFailedModel;
import com.sandata.models.response.ResponseStatusModel;
import com.sandata.utils.JsonUtils;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import static com.sandata.common.Constant.CONTENT_TYPE.ApplicationJson;
import static com.sandata.common.Constant.HEADER.ContentType;

public abstract class GenericModel<T> {
    public static final StateAccount stateAccount = StateAccount.loadStateAccount();
    @Expose
    public transient EmployeeDbService employeeDbService = new EmployeeDbService();

    @Expose
    public transient ClientDbService clientDbService = new ClientDbService();

    @Expose
    public transient AuthDbService authDbService = new AuthDbService();

    @Expose
    public transient VisitDbService visitDbService = new VisitDbService();

    @Expose
    public transient ProviderDbService providerDbService = new ProviderDbService();

    @Expose
    public transient ClaimDbService claimDbService = new ClaimDbService();

    @Expose
    public transient static final Logger LOGGER = Logger.getLogger(GenericModel.class);

    @Expose
    public transient JsonUtils jsonUtils = new JsonUtils();

    @Expose
    public transient Commons commons = new Commons();

    @Expose
    public transient WebServicesBase webServicesBase = new WebServicesBase();

    @Expose
    public transient String json = "";

    @Expose
    public transient String state = "";

    @Expose
    public transient String account_id = "";

    @Expose
    public transient String provider_id = "";

    @Expose
    public transient String request_url = "";

    @Expose
    public transient String request_status_url = "";

    @Expose
    public transient String uuid = "";

    @Expose
    public transient Response response1;

    @Expose
    public transient Response response2;

    @Expose
    public transient ResponseStatusModel responseStatus1;

    @Expose
    public transient ResponseStatusAltModel responseStatusAlt1;

    @Expose
    public transient ResponseStatusModel responseStatus2;

    @Expose
    public transient ResponseStatusFailedModel responseStatusFailed;

    @Expose
    public transient String auth_username;

    @Expose
    public transient String auth_password;

    @Expose
    public transient String mysql_url;

    @Expose
    public transient String mysql_username;

    @Expose
    public transient String mysql_pass;


    public void initData() {
        state = readDataValue("AccountType");
        switch (state) {
            case "MOLINA":
                account_id = getTestEnvironment().get("molina_accountId");
                provider_id = getTestEnvironment().get("molina_providerId");
                auth_username = getTestEnvironment().get("molina_UserName");
                auth_password = getTestEnvironment().get("molina_Password");
                break;
            case "INDIANA":
                account_id = getTestEnvironment().get("indiana_accountId");
                provider_id = getTestEnvironment().get("indiana_providerId");
                auth_username = getTestEnvironment().get("indiana_UserName");
                auth_password = getTestEnvironment().get("indiana_Password");
                break;
            case "PENNSYLVANIA":
                account_id = getTestEnvironment().get("pennsylvania_accountId");
                provider_id = getTestEnvironment().get("pennsylvania_providerId");
                auth_username = getTestEnvironment().get("pennsylvania_UserName");
                auth_password = getTestEnvironment().get("pennsylvania_Password");
                mysql_url = getTestEnvironment().get("mySqlUrl");
                mysql_username = getTestEnvironment().get("mysql_user");
                mysql_pass = getTestEnvironment().get("mysql_pass");
                break;
            case "VERMONT":
                account_id = getTestEnvironment().get("vermont_accountId");
                provider_id = getTestEnvironment().get("vermont_providerId");
                auth_username = getTestEnvironment().get("vermont_UserName");
                auth_password = getTestEnvironment().get("vermont_Password");
                mysql_url = getTestEnvironment().get("mySqlUrl");
                mysql_username = getTestEnvironment().get("mysql_user");
                mysql_pass = getTestEnvironment().get("mysql_pass");
                break;
        }
    }

    public abstract boolean verifyFieldValue(T obj);
    public abstract boolean verifyFieldsNotNull();

    public String getEnvironment(String envName) {
        return getTestEnvironment().get(envName);
    }

    public Environment getTestEnvironment() {
        return getTestConfig().getEnvironment();
    }

    public ExtentTest getExtentTest() {
        return ExtentTestManager.getTest();
    }

    public void logInfo(String message) {
        getExtentTest().info(message);
        LOGGER.info(message);
    }

    public synchronized void logFail(String message) {
        getExtentTest().fail("<b style='color:red;'>" + message + "");
        LOGGER.error(message);
    }

    public synchronized void logPass(String message) {
        getExtentTest().pass("<b style='color:green;'>" + message + "");
        LOGGER.info(message);
    }

    public synchronized void logError(String message) {
        getExtentTest().log(Status.ERROR, message);
        LOGGER.error(message);
    }

    public TestConfiguration getTestConfig() {
        return TestContext.get();
    }

    public String readDataValue(String variableName) {
        try {
            return getTestConfig().getTestData().getValue(variableName);
        } catch (NullPointerException exp) {
            return null;
        }
    }

    public String toJson(boolean includeNullValue, boolean setPrettyPrinting, Object objec) {
        String json = jsonUtils.toJson(includeNullValue, setPrettyPrinting, objec);
        return json;
    }

    public String toJson() {
        String json = jsonUtils.toJson(true, true, this);
        return json;
    }

    public String toJson(boolean includeNullValue, boolean setPrettyPrinting) {
        String json = jsonUtils.toJson(includeNullValue, setPrettyPrinting, this);
        return json;
    }

    public <T>Object toObject(String json, Type typeOfT) {
        T object = (T) jsonUtils.toObject(json, typeOfT);
        return object;
    }

    public boolean post_alt_evv(Object object, String request_url) {
        boolean result = false;
        json = toJson(true, true, object);

        Map<String, String> header = new HashMap<>();
        header.put(ContentType.toString(), ApplicationJson.toString());
        header.put(Constant.HEADER.Account.toString(), account_id);
        response1 =  webServicesBase.sendPOSTRequest(request_url, header, json, auth_username, auth_password);

        String responseJson = response1.body().prettyPrint();

        responseStatusAlt1 = (ResponseStatusAltModel)toObject(responseJson, ResponseStatusAltModel.class);

        if (response1.getStatusCode() == 200) {
            logInfo(String.format("Request successfully. Status Code: %s, account: %s, provider Id: %s",
                    response1.getStatusCode(), account_id, provider_id));
        } else {
            logInfo(String.format("Failed request. Status Code: %s, account: %s, provider Id: %s",
                    response1.getStatusCode(), account_id, provider_id));
        }

        if(responseStatusAlt1.status.equalsIgnoreCase("FAILED")) {
            logInfo(String.format("uuid: '%s', Status: '%s'", responseStatusAlt1.id, responseStatusAlt1.status));
            return false;
        } else if (responseStatusAlt1.status.equalsIgnoreCase("SUCCESS")) {
            return true;
        }
        return result;
    }

    public boolean post(Object object, String request_url) {
        boolean result = false;
        json = toJson(true, true, object);

        Map<String, String> header = new HashMap<>();
        header.put(ContentType.toString(), ApplicationJson.toString());
        header.put(Constant.HEADER.Account.toString(), account_id);
        response1 =  webServicesBase.sendPOSTRequest(request_url, header, json, auth_username, auth_password);

        String responseJson = response1.body().prettyPrint();

        responseStatus1 = (ResponseStatusModel)toObject(responseJson, ResponseStatusModel.class);

        if (response1.getStatusCode() == 200) {
            logInfo(String.format("Request successfully. Status Code: %s, account: %s, provider Id: %s",
                    response1.getStatusCode(), account_id, provider_id));
        } else {
            logInfo(String.format("Failed request. Status Code: %s, account: %s, provider Id: %s",
                    response1.getStatusCode(), account_id, provider_id));
        }

        if(responseStatus1.status.equalsIgnoreCase("FAILED")) {
            logInfo(String.format("uuid: '%s', Status: '%s'", responseStatus1.id, responseStatus1.status));
            return false;
        } else if (responseStatus1.status.equalsIgnoreCase("SUCCESS")) {
            return true;
        }
        return result;
    }

    public boolean getFinalStatusAlt(String segment) {
        boolean result = false;
        if (responseStatusAlt1 != null && responseStatusAlt1.status.equalsIgnoreCase("SUCCESS")) {
            request_status_url = request_url + segment + responseStatusAlt1.id;
            Map<String, String> header = new HashMap<>();
            header.put(ContentType.toString(), ApplicationJson.toString());
            header.put(Constant.HEADER.Account.toString(), account_id);
                response2 = webServicesBase.sendGETRequest(request_status_url, header, auth_username, auth_password);

            String responseJson = response2.body().prettyPrint();

            ResponseStatusModel responseJsonModel = (ResponseStatusModel)toObject(responseJson, ResponseStatusModel.class);

            if(responseJsonModel.status.equalsIgnoreCase("FAILED")) {
                return false;
            } else if (responseStatusAlt1.status.equalsIgnoreCase("SUCCESS")) {
                return true;
            }

            if (response2.getStatusCode() == 200) {
                return true;
            } else{
                logInfo(String.format("uuid: '%s', Status: '%s'", responseStatusFailed.id, responseStatusFailed.status));
                return false;
            }
        }
        return result;
    }

    public boolean getFinalStatus(String segment) {
        boolean result = false;
        if (responseStatus1 != null && responseStatus1.status.equalsIgnoreCase("SUCCESS")) {
            request_status_url = request_url + segment + responseStatus1.id;
            Map<String, String> header = new HashMap<>();
            header.put(ContentType.toString(), ApplicationJson.toString());
            header.put(Constant.HEADER.Account.toString(), account_id);
            response2 = webServicesBase.sendGETRequest(request_status_url, header, auth_username, auth_password);

            if (response2.getStatusCode() == 200) {
                return true;
            } else{
                logInfo(String.format("uuid: '%s', Status: '%s'", responseStatusFailed.id, responseStatusFailed.status));
                return false;
            }
        }
        return result;
    }

    public String generateFieldValue(Constant.DataType dataType, int maxLength, String input) {
        String value = "";
        if (dataType == Constant.DataType.alphabetic) {
            value = RandomStringUtils.randomAlphabetic(maxLength);
        } else if (dataType == Constant.DataType.numeric) {
            value = RandomStringUtils.randomNumeric(maxLength);
        } else if (dataType == Constant.DataType.userInput) {
            value = input;
        } else if(dataType == Constant.DataType.randomString){
            value = RandomStringUtils.randomAlphabetic(maxLength);
        } else if(dataType == Constant.DataType.NULL)
            return null;
        return value;
    }
}
