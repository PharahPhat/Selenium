package com.interop.services.openevv;

import com.google.gson.Gson;
import com.interop.common.constants.utils.db.AppUserDBUtils;
import com.interop.common.constants.utils.db.ClientDBUtils;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.db.stx.STXAppUser;
import com.interop.models.db.stx.STXClient;
import com.interop.models.openevv.client.OpenEvvClient;
import com.interop.models.openevv.client.OpenEvvClientDataGenerator;
import com.interop.services.base.RestfulService;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OpenEvvClientService extends RestfulService {
    private List<OpenEvvClient> models = new ArrayList<>();

    public static OpenEvvClientService init(int count, String fName) {
        OpenEvvClientService openEVVClient = new OpenEvvClientService();
        List<String> clientIdList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            OpenEvvClient client = OpenEvvClientDataGenerator.getOpenEvvClientByState(openEVVClient.getStateAccount());
            client.setClientFirstName(fName);
            String clientId = RandomStringUtils.randomNumeric(10);
            if (!clientIdList.isEmpty()) {
                while (clientIdList.contains(client.getClientID())) {
                    client.setClientID(clientId);
                    client.getClientPhone().get(0).setClientID(clientId);
                    client.getClientAddress().get(0).setClientID(clientId);
                }
            }
            clientIdList.add(clientId);
            openEVVClient.addModel(client);
        }
        openEVVClient.loadPayload(openEVVClient.getModels());
        return openEVVClient;
    }

    public static OpenEvvClientService init(int count, String acc, String username, String password, String providerId) {
        OpenEvvClientService openEVVClient = new OpenEvvClientService();
        if (acc != null && username != null && password != null && providerId != null) {
            openEVVClient.getStateAccount().setProviderID(providerId);
            openEVVClient.getStateAccount().setAccountID(acc);
            openEVVClient.getStateAccount().setWsUserName(username);
            openEVVClient.getStateAccount().setWsPassword(password);
        }
        List<String> clientIdList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            OpenEvvClient client = OpenEvvClientDataGenerator.getOpenEvvClientByState(openEVVClient.getStateAccount());
            String clientId = RandomStringUtils.randomNumeric(10);
            if (!clientIdList.isEmpty()) {
                while (clientIdList.contains(client.getClientID())) {
                    client.setClientID(clientId);
                    client.getClientPhone().get(0).setClientID(clientId);
                    client.getClientAddress().get(0).setClientID(clientId);
                }
            }
            clientIdList.add(clientId);
            openEVVClient.addModel(client);
        }
        openEVVClient.loadPayload(openEVVClient.getModels());
        return openEVVClient;
    }

    public static OpenEvvClientService init() {
        OpenEvvClientService openEVVClient = new OpenEvvClientService();
        OpenEvvClient client = OpenEvvClientDataGenerator.getOpenEvvClientByState(openEVVClient.getStateAccount());
        openEVVClient.addModel(client);
        return openEVVClient;
    }

    @Override
    public String getURI() {
        return "interfaces/intake/clients/rest/api/v1/evv";
    }

    @Override
    public void setModels(List model) {
        this.models = model;
        loadPayload(this.getModels());
    }

    public void addModel(OpenEvvClient model) {
        this.getModels().add(model);
        loadPayload(this.getModels());
    }

    @Override
    public void loadPayload(List client) {
        payload = new Gson().toJsonTree(client);
    }

    @Override
    public void verifyOracleDb(DataValidationModel data) {
        if ("Yes".equalsIgnoreCase(data.getIsVerifyExistingDatabase())) {
            verifyClientReqWithSTX(this);
        }
    }

    public void verifyClientReqWithSTX(OpenEvvClientService clientAPI) {
        baseObj.info("Verify data storing in database");
        for (int i = 0; i < clientAPI.getModels().size(); i++) {
            List<STXClient> result = ClientDBUtils.getClient(getStateAccount().getAccountID(), this.getModels().get(i)
                    .getClientLastName(), this.getModels().get(i).getClientFirstName());

            STXClient stxClient = result.get(i);
            OpenEvvClient modelOpenEVVClient = clientAPI.getModels().get(i);

            baseObj.validateActualAndExpectedText(stxClient.L_NAME, modelOpenEVVClient.getClientLastName());
            baseObj.validateActualAndExpectedText(stxClient.F_NAME, modelOpenEVVClient.getClientFirstName());
            baseObj.validateActualAndExpectedText(stxClient.M_NAME, modelOpenEVVClient.getClientMiddleName());
        }
        baseObj.info("Data is stored in database successfully");
    }

    public void verifyDisplayClientDesigneeInDB(String username) {
        STXAppUser stxAppUser = AppUserDBUtils.getAppUser(getStateAccount().getAccountID(), username).get(0);
        Assert.assertTrue(Objects.isNull(stxAppUser.getDELETED()));
        baseObj.info("Existing Client Designee " + username + " in STX APP USER");
    }

    public void verifyNotDisplayClientDesigneeInDB(String username) {
        STXAppUser stxAppUser = AppUserDBUtils.getAppUser(getStateAccount().getAccountID(), username).get(0);
        Assert.assertTrue(Objects.nonNull(stxAppUser.getDELETED()));
        baseObj.info("DELETED Client Designee " + username + " in STX APP USER");
    }

    public List<OpenEvvClient> getModels() {
        return models;
    }

}
