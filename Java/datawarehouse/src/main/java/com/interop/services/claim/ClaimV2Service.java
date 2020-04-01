package com.interop.services.claim;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.interop.models.claim.ClaimModel;
import com.interop.services.base.RestfulService;
import com.sandata.core.config.TestContext;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ClaimV2Service extends RestfulService {
    protected List<ClaimModel> claims = new ArrayList<>();
    protected List<ClaimModel> responseClaims;

    @Override
    public String getURI() {
        return "interfaces/odm/claims/validation/v2";
    }

    @Override
    public void setModels(List model) {
        this.claims = model;
        loadPayload();
    }

    public void addModel(ClaimModel model) {
        this.claims.add(model);
        loadPayload();
    }

    @Override
    protected String getBasicUserName(){
        return TestContext.get().getConfiguration().get("claim_username");
    }

    @Override
    protected String getBasicPassword(){
        return TestContext.get().getConfiguration().get("claim_password");
    }

    @Override
    public Response post() {
        response = super.post();
        getClaimResponseModels();
        return getResponse();
    }

    private JsonElement generateClaimEVVRequest(){
        JsonArray claimsJson = new Gson().toJsonTree(claims).getAsJsonArray();
        JsonObject evvRequest = new JsonObject();
        evvRequest.add("EVV_Request",claimsJson);

        return evvRequest;
    }

    public void loadPayload() {
        payload = generateClaimEVVRequest();
    }

    public void getClaimResponseModels(){
        if (getResponse().getStatusCode() == 200 && getStatusModel().status.equalsIgnoreCase("SUCCESS")) {
            Type listType = new TypeToken<List<ClaimModel>>() {
            }.getType();
            responseClaims = new Gson().fromJson(getStatusModel().data.getAsJsonObject().get("EVV_Response").getAsJsonArray(),
                    listType);
        }
    }

    public List<ClaimModel> getClaims() {
        return claims;
    }

    public void setClaims(List<ClaimModel> claims) {
        this.claims = claims;
    }

    public List<ClaimModel> getResponseClaims() {
        return responseClaims;
    }

    public void setResponseClaims(List<ClaimModel> responseClaims) {
        this.responseClaims = responseClaims;
    }

}
