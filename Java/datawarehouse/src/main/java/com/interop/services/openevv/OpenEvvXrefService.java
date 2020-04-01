package com.interop.services.openevv;

import com.google.gson.Gson;
import com.interop.common.StateAccount;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.db.stx.STXXref;
import com.interop.models.openevv.xref.OpenEvvXref;
import com.interop.models.openevv.xref.OpenEvvXrefDataGenerator;
import com.interop.services.base.RestfulService;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.sandata.db.XrefDbService.getXrefSTXRecords;

@SuppressWarnings({"rawtypes", "unchecked"})
public class OpenEvvXrefService extends RestfulService {
    private List<OpenEvvXref> models = new ArrayList<>();

    public static OpenEvvXrefService init() {
        OpenEvvXrefService openEvvXrefService = new OpenEvvXrefService();
        OpenEvvXref xrefModel = OpenEvvXrefDataGenerator.getOpenEvvXrefByState(StateAccount.loadStateAccount());
        openEvvXrefService.addModel(xrefModel);
        return openEvvXrefService;
    }

    @Override
    public String getURI() {
        return "interfaces/intake/clients/rest/api/v1/evv/xref";
    }

    @Override
    public void setModels(List models) {
        this.models = models;
        loadPayload(this.models);
    }

    public void addModel(OpenEvvXref model) {
        this.models.add(model);
        loadPayload(this.models);
    }

    @Override
    public void loadPayload(List xrefRecords) {
        payload = new Gson().toJsonTree(xrefRecords);
    }

    @Override
    public void verifyOracleDb(DataValidationModel dataTest) {
        if ("yes".equalsIgnoreCase(dataTest.getIsVerifyExistingDatabase())) {
            for (int i = 0; i < this.getModels().size(); i++) {
                OpenEvvXref openEvvXref = this.getModels().get(i);
                STXXref dbRecords = getXrefSTXRecords(openEvvXref.getClientID(), openEvvXref.getService()).get(0);
                Assert.assertEquals(dbRecords.getACCOUNT(), models.get(i).getAccount());
                Assert.assertEquals(dbRecords.getSERVICE(), models.get(i).getService());
                Assert.assertEquals(dbRecords.getLOC(), models.get(i).getClientID());
            }
        }
    }

    public List<OpenEvvXref> getModels() {
        return models;
    }
}