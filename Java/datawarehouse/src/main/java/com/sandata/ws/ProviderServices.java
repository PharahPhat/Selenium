package com.sandata.ws;

import com.sandata.entity.molina.provider.Providers;
import com.google.gson.Gson;
import com.sandata.core.config.Environment;
import com.sandata.ws.molina.account.AccountWebService;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ProviderServices extends GenericWebService {
    private static final Logger LOGGER = Logger.getLogger(ProviderServices.class);
    AccountWebService accountWebService;
    public ProviderServices() {
        accountWebService = new AccountWebService();
    }

    public Response sendImportProviderRequest(Environment environment, String modifyJson, String accountId){
        LOGGER.info(modifyJson);
        LOGGER.info(environment.getDwh() + WebServicesConstants.IMPORT_PROVIDER);
        return accountWebService.sendPOSTWithAccountInHeader(environment.getDwh() + WebServicesConstants.IMPORT_PROVIDER,
                modifyJson, environment.getMolina_UserName(), environment.getMolina_Password(), accountId);
    }

    public Providers[] createProvider(String jsonFileName, Environment environment,
                                      String qualifier, String providerId, String providerName,
                                      String payerId, String accountId) throws InterruptedException,  IOException {
        Gson gson = new Gson();
        Providers[] providers = toJsonModel(jsonFileName, Providers[].class);
        Providers providers1 = providers[0];
        providers1.setProviderQualifier(qualifier);
        providers1.setProviderID(providerId);
        providers1.setProviderName(providerName);
        providers1.setPayerID(payerId);

        sendImportProviderRequest(environment, gson.toJson(providers), accountId);

        return providers;
    }
}
