package com.interop.services.openevv;

import com.google.gson.Gson;
import com.interop.common.constants.utils.db.ClientDBUtils;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.db.stx.STXClient;
import com.interop.models.openevv.client.OpenEvvClientDataGenerator;
import com.interop.models.openevv.client.OpenEvvClientV1;
import com.interop.services.base.RestfulService;

import java.util.ArrayList;
import java.util.List;


public class OpenEvvClientServiceV1 extends RestfulService{
    private List<OpenEvvClientV1> models = new ArrayList<>();


    @Override
    public String getURI() {
        return "interfaces/intake/clients/rest/api/v1.1/evv";
    }

    @Override
    public void setModels(List model) {
        this.models = model;
        this.loadPayload(this.getModels());
    }

    public void addModel(OpenEvvClientV1 model) {
        this.getModels().add(model);
        this.loadPayload(this.getModels());
    }

    @Override
    public void loadPayload(List client) {
        this.payload = new Gson().toJsonTree(client);
    }


    public static OpenEvvClientServiceV1 init() {
        OpenEvvClientServiceV1 openEVVClientV1 = new OpenEvvClientServiceV1();
        OpenEvvClientV1 client = OpenEvvClientDataGenerator.getOpenEvvClientByStateV1(openEVVClientV1.getStateAccount().getStateEnum());
        openEVVClientV1.addModel(client);
        return openEVVClientV1;
    }

    @Override
    public void verifyOracleDb(DataValidationModel dataTest) {
        if ("yes".equalsIgnoreCase(dataTest.getIsVerifyExistingDatabase())) {
            this.baseObj.info("Verify data storing in database");
            for (int i = 0; i < this.models.size(); i++) {
                List<STXClient> result = ClientDBUtils.getClient(this.getStateAccount().getAccountID(), this.getModels().get(i)
                        .getClientLastName(), this.getModels().get(i).getClientFirstName());

                STXClient stxClient = result.get(i);
                OpenEvvClientV1 modelOpenEVVClient = this.models.get(i);

                this.baseObj.validateActualAndExpectedText(stxClient.L_NAME, modelOpenEVVClient.getClientLastName());
                this.baseObj.validateActualAndExpectedText(stxClient.F_NAME, modelOpenEVVClient.getClientFirstName());
                this.baseObj.validateActualAndExpectedText(stxClient.M_NAME, modelOpenEVVClient.getClientMiddleName());
            }
            this.baseObj.info("Data is stored in database successfully");
        }
    }

    public List<OpenEvvClientV1> getModels() {
        return this.models;
    }
}
