package com.sandata.ws;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.interop.services.base.RestfulService;
import com.interop.common.dataprovider.DataValidationModel;
import io.restassured.response.Response;
import org.testng.Assert;

public class ProviderRestfulService extends RestfulService {

    @Override
    public String getURI() {
        return "interfaces/intake/providers/rest/api/v1/evv";
    }

    /**
     * Modify specific field
     *
     * @param propertyName
     * @param fieldValue
     * @return
     */
    public JsonElement modifyPropertyValue(String propertyName, String fieldValue) {
        JsonObject object = payload.getAsJsonArray().get(0).getAsJsonObject();
        object.addProperty(propertyName, fieldValue);
        return payload;
    }

    public String getProviderIDInPageLoad() {
        JsonObject object = payload.getAsJsonArray().get(0).getAsJsonObject();
        return object.get("ProviderID").getAsString();
    }

    @Override
    public void verifyMDWPass() {
        if (getResponseStatus().equalsIgnoreCase("SUCCESS")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("The status of the request %s are not the SUCCESS");
        }
    }

    public void verifyMDWFailedWithMessageSummary(String messageSummary) {
        if (getResponseStatus().equalsIgnoreCase("FAILED") && getMessageDetail().contains(messageSummary)) {
            Assert.assertTrue(true, "The message %s is not exist in the message detail" + getMessageDetail());
        }
    }

    public JsonArray getResponseData() {
        JsonObject jsonResponse = getJsonObject(getResponse());
        return jsonResponse.get("data").getAsJsonArray();
    }


    public String getResponseStatus() {
        JsonObject jsonResponse = getJsonObject(getResponse());
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

    public void verifyDBValidationPass(Response response) {
        JsonObject jsonResponse = getJsonObject(response);
        String statusGet = jsonResponse.get("status").getAsString();
        if (!statusGet.equalsIgnoreCase("SUCCESS")) {
            boolean isErrorCodeExisted = jsonResponse.get("data").getAsJsonObject().get("ErrorCode").isJsonNull();
            if (!isErrorCodeExisted) {
                String detailError = getValueInDataResponse(jsonResponse.get("data").getAsJsonArray(), "ErrorMessage");
                Assert.fail(String.format("Data is not stored to DB due to Error %s", detailError));
            }
        }
    }

    @Override
    public void verifyOracleDb(DataValidationModel data) {

    }
}
