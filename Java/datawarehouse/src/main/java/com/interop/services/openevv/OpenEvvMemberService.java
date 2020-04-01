package com.interop.services.openevv;

import com.google.gson.Gson;
import com.interop.common.constants.utils.db.ClientDBUtils;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.db.stx.STXClient;
import com.interop.models.openevv.member.OpenEvvMember;
import com.interop.services.base.RestfulService;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class OpenEvvMemberService extends RestfulService {
    private List<OpenEvvMember> models = new ArrayList<>();

    @Override
    public String getURI() {
        return "interfaces/intake/members/rest/api/v1/evv";
    }

    @Override
    public void setModels(List models) {
        this.models = models;
        this.loadPayload(this.getModels());
    }

    public void addModel(OpenEvvMember model) {
        this.getModels().add(model);
        this.loadPayload(this.getModels());
    }

    @Override
    public void loadPayload(List members) {
        this.payload = new Gson().toJsonTree(members);
    }

    @Override
    public void verifyOracleDb(DataValidationModel dataTest) {
        if ("Yes".equalsIgnoreCase(dataTest.getIsVerifyExistingDatabase())) {
            this.baseObj.info("Verify data storing in database");
            for (int i = 0; i < this.getModels().size(); i++) {
                OpenEvvMember modelClient = this.getModels().get(i);
                List<STXClient> result = ClientDBUtils.getClient(this.getStateAccount().getAccountID(),
                        modelClient.getClientLastName(), modelClient.getClientFirstName());

                STXClient stxClient = result.get(i);

                commons.validateActualAndExpectedText(stxClient.L_NAME, modelClient.getClientLastName(), dataTest.getPropertyName());
                commons.validateActualAndExpectedText(stxClient.F_NAME, modelClient.getClientFirstName(), dataTest.getPropertyName());
                commons.validateActualAndExpectedText(stxClient.M_NAME, modelClient.getClientMiddleInitial(), dataTest.getPropertyName());
            }
            this.baseObj.info("Data is stored in database successfully");
        }
    }

    public List<OpenEvvMember> getModels() {
        return this.models;
    }
}
