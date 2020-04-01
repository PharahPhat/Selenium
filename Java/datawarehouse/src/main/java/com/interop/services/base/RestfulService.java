package com.interop.services.base;

import com.google.gson.*;
import com.interop.common.Commons;
import com.interop.common.StateAccount;
import com.interop.common.dataprovider.DataValidationModel;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider;
import com.sandata.core.Wrapper;
import com.sandata.core.config.TestConfiguration;
import com.sandata.core.config.TestContext;
import com.sandata.models.GenericModel;
import com.sandata.models.response.ResponseStatusModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@SuppressWarnings("rawtypes")
public abstract class RestfulService {
    public static final String SUCCESS = "SUCCESS";
    protected static Commons commons = new Commons();
    protected JsonElement payload;
    protected Response response;
    protected ResponseStatusModel statusModel;
    protected String uuid;
    protected TestConfiguration config = TestContext.get();
    protected Wrapper baseObj = new Wrapper();
    protected boolean entityGuid = false;
    protected boolean isAMPAccount = false;
    protected boolean isModifyAccount = false;
    protected ResponseStatusModel uuidModel; //?? Currently uuid is using the same model with status Response.
    protected String hostName = this.config.getConfiguration().getHostName();
    protected ContentType contentType = JSON;
    protected List<GenericModel> genericModels;
    protected String customAccount;

    public abstract String getURI();

    public void setModels(List model) {
        this.genericModels = model;
        this.loadPayload(this.genericModels);
    }

    public void loadPayload(List client) {
        this.payload = new Gson().toJsonTree(client);
    }

    protected String getURL() {
        return this.hostName + "/" + this.getURI();
    }

    public StateAccount getStateAccount() {
        return StateAccount.loadStateAccount();
    }

    public RequestSpecification getRequestSpecification() {
        RequestSpecification requestSpecification = given().relaxedHTTPSValidation()
                .auth().preemptive()
                .basic(this.getBasicUserName(), this.getBasicPassword());
        if (!this.entityGuid) {
            if (this.isModifyAccount) {
                requestSpecification.header("account", customAccount);
            } else requestSpecification.header("account", this.getStateAccount().getAccountID());
        } else requestSpecification.header("EntityGuid", this.getEntityGuid());

        if (this.isAMPAccount) {
            requestSpecification.header("InterfaceSystem", "AMP");
        }
        return requestSpecification;
    }

    protected String getBasicPassword() {
        if (!this.entityGuid) {
            return this.getStateAccount().getWsPassword();
        } else
            return this.config.getEnvironment().get("entityPass");

    }

    protected String getBasicUserName() {
        if (!this.entityGuid) {
            return this.getStateAccount().getWsUserName();
        } else
            return this.config.getEnvironment().get("entityUser");
    }

    protected String getEntityGuid() {
        return this.config.getEnvironment().get("entityGuid");
    }

    public void setEntityGuid(boolean entityGuid) {
        this.entityGuid = entityGuid;
    }

    public void isModifyAccount(boolean modifyAccount) {
        this.isModifyAccount = modifyAccount;
    }

    public void setAMPAccount(boolean AMPAccount) {
        isAMPAccount = AMPAccount;
    }
        public String generateJsonData () {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(this.payload);
        }

        public Response post () {
            this.baseObj.info(String.format("Calling post on api %s ", this.getURL()));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            this.baseObj.info("Request Body:");
            this.baseObj.infoInJson(gson.toJson(this.payload));
            commons.loggerConsole(String.format("Request Body:%n %s", gson.toJson(this.payload)));
            RequestSpecification requestSpecification = this.getRequestSpecification().contentType(this.contentType);
            requestSpecification.body(this.payload.toString());
            int maxRetry = 3;
            for (int i = 0; i < maxRetry; i++) {
                this.response = requestSpecification
                        .when().log().headers()
                        .post(this.getURL());
                if (this.response.getStatusCode() == 404) {
                    this.baseObj.sleep(10000);
                } else {
                    break;
                }
            }
            this.baseObj.info("Response - Status Code: " + this.getResponse().getStatusCode());
            this.baseObj.infoInJson(this.getResponse().prettyPrint());
            JsonObject jsonObject = new JsonParser().parse(this.getResponse().body().prettyPrint()).getAsJsonObject();

            this.setStatusModel(gson.fromJson(jsonObject, ResponseStatusModel.class));
            this.getStatusModel().data = jsonObject.get("data");
            return this.getResponse();
        }

        public void postUntilRecordUpdated () {
            boolean allRecordsUpdatedSuccessfully = false;
            int maxTry = 3;
            while (!allRecordsUpdatedSuccessfully && maxTry > 0) {
                this.response = this.post();
                commons.wait(3);
                this.requestUUIDStatus();
                allRecordsUpdatedSuccessfully = this.uuidModel.messageSummary.equalsIgnoreCase("All records updated successfully.");
                maxTry--;
            }
        }

        protected Response requestUUIDStatus (String uuid){
            String url = String.format("%s/status?uuid=%s", this.getURL(), uuid);
            this.baseObj.info(String.format("Calling get on api %s ", url));
            RequestSpecification requestSpecification = this.getRequestSpecification().contentType(this.contentType);
            Response uuidResponse;
            int maxRetry = 3;
            int i=0;
            do {
                commons.wait(10);
                uuidResponse = requestSpecification
                        .when()
                        .log()
                        .headers()
                        .get(url);
                i++;
            }
            while (uuidResponse.getStatusCode() == 404 && i <= maxRetry);
            JsonObject jsonObject = new JsonParser().parse(uuidResponse.body().prettyPrint()).getAsJsonObject();
            this.uuidModel = new Gson().fromJson(jsonObject, ResponseStatusModel.class);
            this.uuidModel.setData(jsonObject.get("data"));
            this.baseObj.info(String.format("Response - Status Code: %s", uuidResponse.getStatusCode()));
            this.baseObj.infoInJson(uuidResponse.prettyPrint());
            return uuidResponse;
        }

        public Response requestUUIDStatus () {
            return this.requestUUIDStatus(this.getRequestUID());
        }

        private void setPropertyToJsonObject (JsonObject object, String propertyName, String valueType, String
        propertyValue){
            if (propertyValue.trim().equalsIgnoreCase("null")) {
                object.add(propertyName, null);
            } else {
                if (object.has(propertyName)) {
                    switch (valueType.toLowerCase()) {
                        case "int":
                            object.addProperty(propertyName, Integer.parseInt(propertyValue));
                            break;
                        case "float":
                            object.addProperty(propertyName, Float.parseFloat(propertyValue));
                            break;
                        case "boolean":
                            object.addProperty(propertyName, Boolean.valueOf(propertyValue));
                            break;
                        default:
                            object.addProperty(propertyName, propertyValue);
                            break;
                    }
                } else {
                    this.baseObj.fail(String.format("Json Object doesn't has property name %s", propertyName));
                }
            }
        }

        protected JsonObject getJsonObject (Response response){
            return new Gson().fromJson(response.getBody().asString(), JsonObject.class);
        }

        @Step("{properName} - Invalid value: {propertyValue} / Type: {propertyType}")
        public JsonElement modifyPropertyValue (String propertyName, String propertyType, String propertyValue){
            JsonObject root = this.payload.isJsonArray() ? this.payload.getAsJsonArray().get(0).getAsJsonObject()
                    : this.payload.getAsJsonObject();
            if (propertyName.indexOf('$') != 0) {
                this.setPropertyToJsonObject(root.getAsJsonObject(), propertyName, propertyType, propertyValue);
            } else {
                Configuration configuration = Configuration.builder().options(Option.DEFAULT_PATH_LEAF_TO_NULL)
                        .jsonProvider(new GsonJsonProvider())
                        .mappingProvider(new GsonMappingProvider())
                        .build();
                DocumentContext context;
                switch (propertyType.toLowerCase()) {
                    case "int":
                        context = JsonPath.parse(root, configuration).set(propertyName, Integer.parseInt(propertyValue));
                        break;
                    case "float":
                        context = JsonPath.parse(root, configuration).set(propertyName, Float.parseFloat(propertyValue));
                        break;
                    case "boolean":
                        context = JsonPath.parse(root, configuration).set(propertyName, Boolean.valueOf(propertyValue));
                        break;
                    case "null":
                        context = JsonPath.parse(root, configuration).set(propertyName, null);
                        break;
                    default:
                        context = JsonPath.parse(root, configuration).set(JsonPath.compile(propertyName), propertyValue);
                }
                JsonObject updatedObject = context.json();
                JsonArray updatedPayload = new JsonArray();
                updatedPayload.add(updatedObject);
                this.payload = updatedPayload;
            }
            return this.payload;
        }

        @Step("Verify expected error message must be {errorMessage}")
        public void verifyMDWFailedWithMessageSummary (String messageSummary, String errorMessage){
            if (this.getResponse().statusCode() == 200) {
                if (this.getStatusModel().status.equalsIgnoreCase("FAILED")
                        && this.getStatusModel().messageSummary.contains(messageSummary)) {
                    if (!errorMessage.isEmpty()) { //Ignore errorMessage verification
                        String actualErrorMessage = this.getStatusModel().data.getAsJsonArray().get(0).getAsJsonObject().toString();
                        this.verifyFailedMessageShouldBe(actualErrorMessage, errorMessage);
                    }
                } else {
                    Assert.fail(String.format("The message %s is not exist in the message summary", errorMessage));
                }
            } else if (this.getResponse().statusCode() == 500 && !errorMessage.isEmpty()) {
                this.verifyFailedMessageShouldBe(this.getStatusModel().messageDetail, errorMessage);
            }
        }

        private void verifyFailedMessageShouldBe (String actualErrorMessage, String errorMessage){
            if (actualErrorMessage.contains(errorMessage)) {
                this.baseObj.pass(String.format("Matching Expected Error Message: %s", errorMessage));
            } else {
                this.baseObj.info(String.format("Expect Error Message is %s", errorMessage));
                this.baseObj.fail(String.format("Actual Error Message is %s", actualErrorMessage));
            }
        }

        public void verifyUUIDFailedWithErrorMessage (String messageSummary, String errorMessage){
            if (this.uuidModel.status.equalsIgnoreCase("FAILED")
                    && this.uuidModel.messageSummary.contains(messageSummary)) {
                if (!errorMessage.isEmpty()) { //Ignore errorMessage verification
                    String actualErrorMessage = this.uuidModel.getData().getAsJsonArray().get(0).getAsJsonObject().toString();
                    this.verifyFailedMessageShouldBe(actualErrorMessage, errorMessage);
                }
            } else {
                Assert.fail(String.format("The message %s is not exist in the message summary", this.uuidModel.messageSummary));
            }
        }

        public void verifyMDWPass () {
            if (this.getStatusModel().status.equalsIgnoreCase(SUCCESS)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("The status of the request %s are not the SUCCESS");
            }
        }

        public void verifyPostStatus (String expectedStatus){
            String actualStatus = this.getStatusModel().status;
            this.baseObj.info("Verify Post Status");
            this.baseObj.validateActualAndExpectedText(actualStatus, expectedStatus.toUpperCase());
        }

        public void verifyUUIDStatus (String expectedStatus){
            String actualStatus = this.uuidModel.status;
            this.baseObj.info("Verify Get Status");
            this.baseObj.validateActualAndExpectedText(actualStatus, expectedStatus.toUpperCase());
        }

        private String getRequestUID () { // Only check UUID on Success Post
            return this.getStatusModel().id;
        }

        public void verifyErrorCode (String errorCode){
            String data = this.uuidModel.getData().toString();
            if (!errorCode.equalsIgnoreCase("-553")) {
                if (!data.contains("-553")) {
                    this.baseObj.pass("Expected: Not display error_code = -553");
                } else {
                    this.baseObj.fail("Unexpected: Display error_code = -553");
                }
            }
            else {
                if (data.contains("-553")) {
                    this.baseObj.pass("Expected: Display error_code = -553");
                } else {
                    this.baseObj.fail("Unexpected: Not Display error_code = -553");
                }
            }
        }

        public void verifyErrorMessage (String expectErrorMsg){
            if (StringUtils.isBlank(expectErrorMsg) && this.uuidModel.getData().toString()
                    .contains("All records updated successfully")) {
                this.baseObj.pass("Not display error_code in response");
            } else {
                if (!StringUtils.isBlank(expectErrorMsg) && this.uuidModel.getData().toString().contains(expectErrorMsg)) {
                    this.baseObj.pass(String.format("Matching expected error message: %s", expectErrorMsg));
                } else {
                    this.baseObj.fail("Error message is not matching");
                }
            }
        }

        public void validateUuidResponse () {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonObject jsonObject = new JsonParser().parse(this.requestUUIDStatus().getBody().prettyPrint()).getAsJsonObject();
            this.uuidModel = gson.fromJson(jsonObject, ResponseStatusModel.class);

            if (this.uuidModel.status.equalsIgnoreCase(SUCCESS)) {
                if (this.uuidModel.messageSummary.contains("All records updated successfully.")) {
                    this.baseObj.pass("UUID message: All records updated successfully.");
                } else {
                    Assert.assertTrue(this.uuidModel.messageSummary.contains("The result for the input UUID is not ready yet. Please try again."));
                    this.baseObj.pass("UUID message: The result for the input UUID is not ready yet. Please try again.");
                }
            } else {
                this.baseObj.fail("The uuid status was FAILED");
            }
        }

        @SuppressWarnings({"unchecked", "rawtypes"})
        public List getPayLoad (Class < ? > clazz){
            List list = new ArrayList<>();
            JsonArray jsonArray = this.payload.getAsJsonArray();
            for (JsonElement jsonObject : jsonArray) {
                list.add(new Gson().fromJson(jsonObject, clazz));
            }
            return list;
        }

        public void verifyOracleDb (DataValidationModel data){
            //On every service support this verification, this method must be implementation.
            throw new UnsupportedOperationException();
        }

        public void verifyOracleDbByUpdate (DataValidationModel data, String serviceName){
            //On every service support this verification, this method must be implementation.
            throw new UnsupportedOperationException();
        }

        public Response getResponse () {
            return this.response;
        }

        public ResponseStatusModel getStatusModel () {
            return this.statusModel;
        }

        public void setStatusModel (ResponseStatusModel statusModel){
            this.statusModel = statusModel;
        }

        public void setAccount (String customAccount){
            this.customAccount = customAccount;
        }
}
