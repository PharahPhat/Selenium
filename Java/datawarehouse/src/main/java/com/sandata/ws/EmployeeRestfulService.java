package com.sandata.ws;

import com.interop.services.base.RestfulService;
import com.interop.common.dataprovider.DataValidationModel;

public class EmployeeRestfulService extends RestfulService {
/*
    public EmployeeRestfulService() {
        this.initCredentialAndObject();
    }

    @Override
    protected void initCredentialAndObject() {
        baseObj = new Wrapper();
        loadDefaultPayload();
        loadCredentialAndTemplateACC();
        RequestSpecification requestPost = given().relaxedHTTPSValidation()
                .contentType(JSON)
                .auth()
                .basic(getAuth_username(), getAuth_password())
                .header("account", getAccountTemplate());
        RequestSpecification requestGet = given()
                .relaxedHTTPSValidation()
                .auth()
                .basic(getAuth_username(), getAuth_password())
                .header("account", getAccountTemplate());
        request = new HashMap<>();
        request.put("PostRequest", requestPost);
        request.put("GetRequest", requestGet);
    }
*/
    @Override
    public String getURI() {
        return "interfaces/intake/employees/rest/api/v1/evv";
    }

    @Override
    public void verifyOracleDb(DataValidationModel data) {

    }
/*
    @Override
    public String loadPayloadTemplatePath() {
        return "TestData/templateModel/intake_ALT_EVV_Member.json";
    }

    @Override
    public JsonElement modifyPropertyValue(String[] fieldNameAndValue) {
        JsonObject object = payload.getAsJsonArray().get(0).getAsJsonObject();
        for (int x = 0; x < fieldNameAndValue.length; x++) {
            String fieldName = fieldNameAndValue[x].substring(0, fieldNameAndValue[x].indexOf("="));
            String value = fieldNameAndValue[x].substring(fieldNameAndValue[x].indexOf("=") + 1);
            if (value.trim().equalsIgnoreCase("null")) {
                object.add(fieldName, null);
            } else {
                object.addProperty(fieldName, value);
            }
        }
        return payload;
    }

    *//**
     * Modify specific field
     *
     * @param fieldName
     * @param fieldValue
     * @return
     *//*
    public JsonElement modifyPropertyValue(String fieldName, String fieldValue) {
        JsonObject object = payload.getAsJsonArray().get(0).getAsJsonObject();
        object.addProperty(fieldName, fieldValue);
        return payload;
    }

    public String getProviderIDInPageLoad() {
        JsonObject object = payload.getAsJsonArray().get(0).getAsJsonObject();
        return object.get("ProviderID").getAsString();
    }

    @Override
    public void verifyMDWValidationPass() {
        if (getResponseStatus().equalsIgnoreCase("SUCCESS")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail(String.format("The status of the request %s are not the SUCCESS"));
        }
    }

    @Override
    public void verifyMDWValidationFail(String expectMessageDetail) {
        if (getResponseStatus().equalsIgnoreCase("FAILED") & getMessageDetail().contains(expectMessageDetail)) {
            Assert.assertTrue(true, "The message %s is not exist in the message detail" + getMessageDetail());
        }
    }

    public JsonArray getResponseData() {
        JsonObject jsonResponse = getJsonObject(response);
        return jsonResponse.get("data").getAsJsonArray();
    }

    private JsonObject getJsonObject(Response response) {
        return new Gson().fromJson(response.asString(), JsonObject.class);
    }

    public String getResponseStatus() {
        JsonObject jsonResponse = getJsonObject(response);
        return jsonResponse.get("status").getAsString();
    }

    private String getMessageDetail() {
        JsonObject messageObject = getResponseData().get(0).getAsJsonObject();
        if (messageObject.has("messageDetail")) {
            return messageObject.get("messageDetail").getAsString();
        } else {
            return null;
        }
    }

    private String getValueInDataResponse(JsonArray data, String messageDetail) {
        return data.get(0).getAsJsonObject().get(messageDetail).getAsString();
    }

    @Override
    public void verifyDBValidationPass(Response response) {
        JsonObject jsonResponse = getJsonObject(response);
        String statusGet = jsonResponse.get("status").getAsString();
        if (!statusGet.equalsIgnoreCase("SUCCESS")) {
            boolean isErrorCodeExisted = jsonResponse.get("data").getAsJsonObject().get("ErrorCode").isJsonNull();
            if (!isErrorCodeExisted) {
                String detailError = getValueInDataResponse(jsonResponse.get("data").getAsJsonArray(), "ErrorMessage");
                Assert.fail(String.format("Data is not stored to DB due to Error %s" + detailError));
            }
        }
    }

    @Override
    public Response sendGetUIStatus() {
        JsonObject jsonResponse = getJsonObject(response);
        String uuid = jsonResponse.get("id").getAsString();
        response = getStatus(uuid);
        return response;
    }*/
}
