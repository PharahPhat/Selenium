package com.sandata.ws;

import com.google.gson.Gson;
import com.sandata.core.config.Environment;
import com.sandata.core.ws.WebServicesBase;
import com.sandata.entity.connecticut.authorization.AuthorizationEntity;
import com.sandata.ws.dwh.DWHServices;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AuthorizationService extends DWHServices {
    public AuthorizationService(){
        webServicesBase =  new WebServicesBase();
    }

    /**
     * Call the api create an authorization
     * @return the response data
     */
    public String preparePostRequestClientData(AuthorizationEntity authorizationInput,
                                               String username, String password, String account,
                                               Environment environment) throws IOException {
        String url = environment.getDwh();
        Gson gson = new Gson();
        AuthorizationEntity[] authorizationEntities = webServicesBase
                .toJsonModel("json/Connecticut/Authorization.json", AuthorizationEntity[].class);
        AuthorizationEntity authorizationEntity = authorizationEntities[0];

        if(authorizationInput != null) {
            authorizationEntity.setPayerID(authorizationInput.getPayerID());
            authorizationEntity.setPayerProgram(authorizationInput.getPayerProgram());
            authorizationEntity.setClientQualifier(authorizationInput.getClientQualifier());
            authorizationEntity.setClientIdentifier(authorizationInput.getClientIdentifier());
            authorizationEntity.setEmployeeID(authorizationInput.getEmployeeID());
            authorizationEntity.setEmployeePINQualifier(authorizationInput.getEmployeePINQualifier());
            authorizationEntity.setProviderQualifier(authorizationInput.getProviderQualifier());
            authorizationEntity.setProviderID(authorizationInput.getProviderID());
            authorizationEntity.setAuthorizationReferenceNumber(authorizationInput.getAuthorizationReferenceNumber());
            authorizationEntity.setAuthorizationServiceID(authorizationInput.getAuthorizationServiceID());
            authorizationEntity.setAuthorizationBillingType(authorizationInput.getAuthorizationBillingType());
            authorizationEntity.setModifier1(authorizationInput.getModifier1());
            authorizationEntity.setModifier2(authorizationInput.getModifier2());
            authorizationEntity.setModifier3(authorizationInput.getModifier3());
            authorizationEntity.setModifier4(authorizationInput.getModifier4());
            authorizationEntity.setAuthorizationAmountType(authorizationInput.getAuthorizationAmountType());
            authorizationEntity.setAuthorizationMaximum(authorizationInput.getAuthorizationMaximum());
            authorizationEntity.setUnits(authorizationInput.getUnits());
            authorizationEntity.setAuthorizationStartDate(authorizationInput.getAuthorizationStartDate());
            authorizationEntity.setAuthorizationEndDate(authorizationInput.getAuthorizationEndDate());
            authorizationEntity.setAuthorizationShared(authorizationInput.getAuthorizationShared());
            authorizationEntity.setAuthorizationComments(authorizationInput.getAuthorizationComments());
            authorizationEntity.setAuthorizationLimitType(authorizationInput.getAuthorizationLimitType());
            authorizationEntity.setAuthorizationStatus(authorizationInput.getAuthorizationStatus());
            authorizationEntity.setClientDiagnosisCode(authorizationInput.getClientDiagnosisCode());
            if(authorizationInput.getAuthorizationLimits() != null)
                authorizationEntity.setAuthorizationLimits(authorizationInput.getAuthorizationLimits());
        }

        return capturePostResponseEXPORTEVV(url, gson.toJson(authorizationEntity),username, password, account);
    }

    public String capturePostResponseEXPORTEVV(String url, String modifyJson, String username, String password, String account){
        return sendCreateAuthorizationRequest(url, username, password, account, modifyJson).asString();
    }

    public Response sendCreateAuthorizationRequest(String baseUrl, String username, String password, String account, String modifyJson){
        String postUrl = baseUrl + "/" + WebServicesConstants.CREATE_CLIENT_AUTHORIZATION;
        Response response = given().
                relaxedHTTPSValidation().
                body("[" + modifyJson + "]").header("Content-Type","application/json").
                auth().preemptive().
                basic(username, password).
                header("Account", account).log().all().
                when().post(postUrl).
                then().assertThat().statusCode(200).and().extract().response();

        return response;
    }
}
