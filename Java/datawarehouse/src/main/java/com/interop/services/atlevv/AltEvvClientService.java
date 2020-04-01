package com.interop.services.atlevv;

import com.google.gson.Gson;
import com.interop.common.StateAccount;
import com.interop.common.constants.utils.db.ClientDBUtils;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.altevv.client.AltEvvClient;
import com.interop.models.altevv.client.AltEvvClientDataGenerator;
import com.interop.models.db.stx.STXAni;
import com.interop.models.db.stx.STXClient;
import com.interop.services.base.RestfulService;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AltEvvClientService extends RestfulService {
    private List<AltEvvClient> models = new ArrayList<>();

    public static AltEvvClientService init() {
        AltEvvClientService altGenericClient = new AltEvvClientService();
        AltEvvClient client = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        altGenericClient.addModel(client);
        return altGenericClient;
    }

    public static AltEvvClientService init(int count, String fName) {
        AltEvvClientService altGenericClient = new AltEvvClientService();
        for (int i = 1; i <= count; i++) {
            AltEvvClient client = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
            client.setClientFirstName(fName);
            altGenericClient.addModel(client);
        }

        altGenericClient.loadPayload(altGenericClient.getModels());
        return altGenericClient;
    }

    @Override
    public String getURI() {
        return "interfaces/intake/clients/rest/api/v1.1";
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void loadPayload(List client) {
        this.payload = new Gson().toJsonTree(client);
    }

    @Override
    public void verifyOracleDb(DataValidationModel data) {
        if ("Yes".equalsIgnoreCase(data.getIsVerifyExistingDatabase())) {
            getRecordClientDb();
        }
    }

    public void getRecordClientDb() {
        for (int i = 0; i < this.getModels().size(); i++) {
            AltEvvClient altClient = this.getModels().get(i);
            STXClient stxClient = ClientDBUtils.getClient(this.getStateAccount().getAccountID(), altClient
                    .getClientLastName(), altClient.getClientFirstName()).get(i);
            this.baseObj.validateActualAndExpectedText(stxClient.L_NAME, altClient.getClientLastName());
            this.baseObj.validateActualAndExpectedText(stxClient.F_NAME, altClient.getClientFirstName());
            this.baseObj.validateActualAndExpectedText(stxClient.M_NAME, altClient.getClientMiddleInitial());
            this.verifyTimeZone(altClient, stxClient);
            this.verifyProviderContgyPlan(altClient, stxClient);
            this.verifyClientPhone(altClient, stxClient);
        }
    }

    private void verifyClientPhone(AltEvvClient altClient, STXClient stxClient) {
        this.baseObj.info("Verify Client Phone in Db");
        List<STXAni> contact = ClientDBUtils.getClientPhone( stxClient.getACCOUNT().toString(),stxClient.getLOC().toString());
        Assert.assertEquals(contact.size(), this.models.get(0).getClientPhone().size());
        for (int i = 0; i < altClient.getClientPhone().size(); i++) {
            this.baseObj.validateActualAndExpectedText(contact.get(i).getANI().toString(),altClient.getClientPhone().get(i).getClientPhone());
            this.baseObj.validateActualAndExpectedText(contact.get(i).getDESCRIPTION().toString(),altClient.getClientPhone().get(i).getClientPhoneType());
        }
    }

    private void verifyTimeZone(AltEvvClient altClient, STXClient stxClient) {
        String timeZone = altClient.getClientTimezone();
        if (this.getStateAccount().getStateName().equals("Wisconsin") && timeZone != null) {
            timeZone = timeZone.replaceAll("\\s", "");
        }
        Assert.assertNotNull(timeZone, "Time Zone value is null");
        this.baseObj.validateActualAndExpectedText(stxClient.TZNAME, timeZone);
    }

    private void verifyProviderContgyPlan(AltEvvClient payload, STXClient recordDb) {
        this.baseObj.info("Verify Reschedule in Db");
        if (payload.getProviderAssentContPlan().equalsIgnoreCase("Yes")) {
            this.baseObj.info("ContgyPlan is Yes so expectation in here is Y");
            this.baseObj.validateActualAndExpectedText(recordDb.getCONTGY_PLAN_ASSENT_IND(), "Y");
        } else {
            this.baseObj.info("ContgyPlan is No so expectation in here is N");
            this.baseObj.validateActualAndExpectedText(recordDb.getCONTGY_PLAN_ASSENT_IND(), "N");
        }
    }

    public void addModel(AltEvvClient model) {
        this.getModels().add(model);
        this.loadPayload(this.getModels());
    }

    public List<AltEvvClient> getModels() {
        return this.models;
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void setModels(List model) {
        this.models = model;
        this.loadPayload(this.getModels());
    }
}
