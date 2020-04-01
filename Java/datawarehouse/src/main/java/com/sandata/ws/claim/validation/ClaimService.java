package com.sandata.ws.claim.validation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sandata.common.resource.Claim;
import com.sandata.entity.claim.ClaimValidationV2;
import com.sandata.models.response.claim.ClaimStatus;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

import static com.sandata.common.Constant.CONTENT_TYPE.ApplicationJson;
import static com.sandata.common.Constant.HEADER.ContentType;

public class ClaimService extends ClaimGenericService {

    public Response claimVisit(ClaimValidationV2 claimValidationV2) {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        String json = gson.toJson(claimValidationV2);

        String requestUrl = getTestEnvironment().get("intake_endpoint") + Claim.INTAKE_CLAIM_VALIDATION_V2;
        String auth_username = getTestEnvironment().get("claim_username");
        String auth_password = getTestEnvironment().get("claim_password");

        Map<String, String> header = new HashMap<>();
        header.put(ContentType.toString(), ApplicationJson.toString());

        Response response =  webServicesBase.sendPOSTRequest(requestUrl, header, json, auth_username, auth_password);
        ClaimStatus status = gson.fromJson(response.body().asString(), ClaimStatus.class);
        if (response.getStatusCode() == 200) {
            logInfo(String.format("Run claim validation successfully. \n - Status: %s, \n - id: %s \n - Visit found: %s",
                    status.status, status.id, status.data.EVV_Response.get(0).VisitFound));
        } else {
            logInfo(String.format("Run claim validation unsuccessfully. Status code: %s", response.getStatusCode()));
        }
        return response;
    }
}
