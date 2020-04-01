package com.sandata.ws;

import com.google.gson.Gson;
import com.sandata.common.Constant;
import com.sandata.core.config.Environment;
import com.sandata.core.ws.WebServicesBase;
import com.sandata.entity.exportDWH.ProviderMolinaWithConfigurationModel;
import com.sandata.ws.dwh.DWHServices;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import java.io.IOException;

import static io.restassured.RestAssured.given;
@SuppressWarnings({"squid:S1192","squid:S2696"})
public class ProviderWebService extends GenericWebService {
    private static final Logger LOGGER = Logger.getLogger(DWHServices.class);

    enum Account {
        MOLINA, OHIO, CONNECTICUT
    }

    public ProviderWebService() {
        webServicesBase = new WebServicesBase();
    }

    /**
     * Call the api create a client
     *
     * @param accountType the name of account
     * @param environment the environment
     * @return the response data
     */
    public String callCreateProvider(String accountType, String username, String password, String account,
                                     ProviderMolinaWithConfigurationModel providerInput, Environment environment) {
        String response = null;
        try {
            if (accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.MOLINA))) {
                response = PreparePostRequestProviderData(providerInput, username, password, account, environment);
            } else if (accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.CONNECTICUT)) || accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.OHIO))) {
                //TODO: will implement when apply for another client
                response = "";
            }
            Constant.exported = 1; //NO SONAR
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
        return response;
    }

    public String PreparePostRequestProviderData(ProviderMolinaWithConfigurationModel providerInput,
                                                 String username, String password, String account,
                                                 Environment environment) throws InterruptedException, IOException {
        String url = environment.getDwh();
        Gson gson = new Gson();
        ProviderMolinaWithConfigurationModel[] providerMolinaWithConfigurationModels = webServicesBase
                .toJsonModel("json/Molina/ProvidersWithConfiguration.json", ProviderMolinaWithConfigurationModel[].class);
        ProviderMolinaWithConfigurationModel providerMolinaWithConfigurationModel = providerMolinaWithConfigurationModels[0];

        if (providerInput != null) {
            //Set provider providerIdentification
            providerMolinaWithConfigurationModel.setProviderQualifier(providerInput.getProviderQualifier());
            providerMolinaWithConfigurationModel.setProviderID(providerInput.getProviderID());
            providerMolinaWithConfigurationModel.setProviderName(providerInput.getProviderName());
        }

        return capturePostResponseEXPORTEVV(url, gson.toJson(providerMolinaWithConfigurationModel), username, password, account);
    }

    public String capturePostResponseEXPORTEVV(String url, String modifyJson, String username, String password, String account) {

        return sendProviderRequest(url,
                username,
                password,
                account,
                modifyJson).asString();
    }

    public Response sendProviderRequest(String baseUrl, String username, String password, String account, String modifyJson) {
        String postUrl = baseUrl + "/" + WebServicesConstants.CREATE_PROVIDER_MOLINA_URL;
        Response response = given().
                relaxedHTTPSValidation().
                body("[" + modifyJson + "]").header("Content-Type", "application/json").
                auth().preemptive().
                basic(username, password).
                header("Account", account).log().all().
                when().post(postUrl).
                then().assertThat().statusCode(200).and().extract().response();

        return response;
    }

}
