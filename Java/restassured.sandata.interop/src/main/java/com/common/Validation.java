package com.common;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Validation {
    public static void validationProviderIdentificationField(JSONArray jsonArray, String field, boolean isValid, String value,
                                                 String errorMessage, String url, int statusCodeExpected) throws InterruptedException {
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        JSONObject jsonProvider =  (JSONObject) jsonObject.get(globalVariables.ProviderIdentification);
        jsonProvider.put(field, value);

        if (isValid) {
            CommonMethods.validateResponse(jsonArray, url);
        }
        else {
            String body = "";
            if (statusCodeExpected == 200) {
                body = CommonMethods.capturePostResponse(jsonArray, url);
            }
            if (statusCodeExpected == 500) {
                body = CommonMethods.capturePostResponse_500(jsonArray, url);
            }
            CommonMethods.verifyjsonassertFailcase(body, errorMessage);
        }
    }

    public static void validationField(JSONArray jsonArray, String field, boolean isValid, String value,
                                       String errorMessage, String url) {
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        jsonObject.put(field, value);

        if (isValid) {
            CommonMethods.validateResponse(jsonArray, url);
        }
        else {
            String body = CommonMethods.capturePostResponse(jsonArray, url);
            CommonMethods.verifyjsonassertFailcase(body, errorMessage);
        }
    }

    public static void validationField(JSONArray jsonArray, String segmentField, String field, boolean isValid,
                                              String value, String errorMessage, String url) {
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        JSONArray jsonSegment = (JSONArray) jsonObject.get(segmentField);
        for (int i=0;i<jsonSegment.size();i++) {
            JSONObject jsonObjectSegment = (JSONObject) jsonSegment.get(i);
            jsonObjectSegment.put(field, value);
        }

        if (isValid) {
            CommonMethods.validateResponse(jsonArray, url);
        }
        else {
            String body = CommonMethods.capturePostResponse(jsonArray, url);
            CommonMethods.verifyjsonassertFailcase(body, errorMessage);
        }
    }
}
