package com.interop.services.openevv;

import com.google.gson.Gson;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.db.staging.StagingAuth;
import com.interop.models.openevv.authorization.OpenEvvAuthorization;
import com.interop.models.openevv.authorization.OpenEvvAuthorizationDataGenerator;
import com.interop.services.base.RestfulService;

import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.utils.db.AuthDBUtils.getStagingAuthorization;

public class OpenEVVAuthStagingService extends RestfulService {
    protected List<OpenEvvAuthorization> models = new ArrayList<>();

    public static OpenEVVAuthStagingService init() {
        OpenEVVAuthStagingService openEvvAuth = new OpenEVVAuthStagingService();
        OpenEvvAuthorization authorization = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        openEvvAuth.addModel(authorization);
        return openEvvAuth;
    }

    public List<OpenEvvAuthorization> getModels() {
        return models;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void setModels(List model) {
        models = model;
        loadPayload(models);
    }

    @Override
    public String getURI() {
        return "interfaces/intake/auths/rest/api/staging/evv";
    }

    private void addModel(OpenEvvAuthorization model) {
        models.add(model);
        loadPayload(models);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void loadPayload(List auth) {
        payload = new Gson().toJsonTree(auth);
    }

    @Override
    public void verifyOracleDb(DataValidationModel data) {
        if ("Yes".equalsIgnoreCase(data.getIsVerifyExistingDatabase())) {
            verifyAuthInStagingDb();
        }
    }

    private void verifyAuthInStagingDb() {
        baseObj.info("Verify data storing in database");
        for (int i = 0; i < getModels().size(); i++) {
            OpenEvvAuthorization object = (OpenEvvAuthorization) getPayLoad(OpenEvvAuthorization.class).get(0);
            List<StagingAuth> stagingAuth = getStagingAuthorization(object.getAuthorizationReferenceNumber());
            baseObj.info("Verify Diagnosis Code btw model and staging Db");
            baseObj.validateActualAndExpectedTextContains(object.getDiagnosisCode().toString(), stagingAuth.get(0).getDx_code().toString());
            baseObj.info("Verify Auth Ref num btw model and staging Db");
            baseObj.validateActualAndExpectedTextContains(object.getAuthorizationReferenceNumber(), stagingAuth.get(0).getAuth_ref_num().toString());
            baseObj.info("Verify Auth Service btw model and staging Db");
            baseObj.validateActualAndExpectedTextContains(object.getAuthorizationLimit().get(0).getAuthorizationServiceID(), stagingAuth.get(0).getService().toString());
            baseObj.info("Verify Auth Program btw model and staging Db");
            baseObj.validateActualAndExpectedTextContains(object.getAuthorizationLimit().get(0).getPayerProgram(), stagingAuth.get(0).getProgram().toString());
            baseObj.info("Verify Auth Payer btw model and staging Db");
            baseObj.validateActualAndExpectedTextContains(stagingAuth.get(0).getPayor_id().toString(), object.getPayerId());
            verifyAssessmentDate(object, stagingAuth);
        }
    }

    private void verifyAssessmentDate(OpenEvvAuthorization object, List<StagingAuth> stagingAuth) {
        if (getStateAccount().getStateName().equalsIgnoreCase("Hawaii")) {
            baseObj.info("Verify Assessment btw model and staging Db");
            baseObj.validateActualAndExpectedTextContains(stagingAuth.get(0).getClient_assessment_date().toString(), object.getHiAssessmentDate());
        } else if (getStateAccount().getStateName().equalsIgnoreCase("Arizona")) {
            baseObj.info("Verify Assessment btw model and staging Db");
            baseObj.validateActualAndExpectedTextContains(stagingAuth.get(0).getClient_assessment_date().toString(), object.getMedicalNecessityDeterminationDate());
        }
    }
}
