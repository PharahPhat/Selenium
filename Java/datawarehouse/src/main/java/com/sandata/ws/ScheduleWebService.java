package com.sandata.ws;

import com.google.gson.Gson;
import com.sandata.core.config.Environment;
import com.sandata.core.ws.WebServicesBase;
import com.sandata.entity.connecticut.client.ClientConnecticutPhone;
import com.sandata.entity.connecticut.client.ClientConnecticutWithConfigurationModel;
import com.sandata.entity.connecticut.client.ConnecticutClientAddress;
import com.sandata.ws.dwh.DWHServices;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ScheduleWebService extends DWHServices {

    private Response response;

    enum Account{
        MOLINA, OHIO, CONNECTICUT
    }

    public ScheduleWebService(){
        webServicesBase =  new WebServicesBase();
    }


    public String PreparePostRequestConnecticutScheduleData(String accountType, ClientConnecticutWithConfigurationModel clientInput,
                                                          String username, String password, String account,
                                                          Environment environment) throws IOException {
        String url = environment.getDwh();
        Gson gson = new Gson();
        ClientConnecticutWithConfigurationModel[] clientWithConfigurationRequests = webServicesBase
                .toJsonModel("json/Connecticut/ClientWithConfiguration.json", ClientConnecticutWithConfigurationModel[].class);
        ClientConnecticutWithConfigurationModel clientRequest = clientWithConfigurationRequests[0];

        //Set provider providerIdentification
        if(clientInput != null) {
            clientRequest.setClientID(clientInput.getClientID());
            clientRequest.setClientLastName(clientInput.getClientLastName());
            clientRequest.setClientFirstName(clientInput.getClientFirstName());
            clientRequest.setClientSSN(clientInput.getClientSSN());
            clientRequest.setClientMedicaidID(clientInput.getClientMedicaidID());
            clientRequest.setClientEmailAddress(clientInput.getClientEmailAddress());

            List<ConnecticutClientAddress> clientAddresses = clientRequest.getClientAddress();
            clientAddresses.get(0).setClientID(clientInput.getClientAddress().get(0).getClientID());
            clientRequest.setClientAddress(clientAddresses);

            List<ClientConnecticutPhone> clientPhones = clientRequest.getClientPhone();
            clientPhones.get(0).setClientID(clientInput.getClientPhone().get(0).getClientID());
            clientRequest.setClientPhone(clientPhones);
        }

        return capturePostResponseEXPORTEVV(accountType, url, gson.toJson(clientRequest),username, password, account);
    }

    public String capturePostResponseEXPORTEVV(String accountType, String url, String modifyJson, String username, String password, String account){
        return sendScheduleRequest(accountType, url,
                username,
                password,
                account,
                modifyJson).asString();
    }

    public Response sendScheduleRequest(String accountType, String baseUrl, String username, String password, String account, String modifyJson){
        String postUrl = baseUrl + "/" + WebServicesConstants.CREATE_SCHEDULES;

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


