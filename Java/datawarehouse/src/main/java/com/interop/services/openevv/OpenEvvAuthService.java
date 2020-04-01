package com.interop.services.openevv;

import com.google.gson.Gson;
import com.interop.common.constants.utils.db.AppUserDBUtils;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.db.inbox.InboxAuthorization;
import com.interop.models.db.stx.STXAuthorization;
import com.interop.models.db.stx.STXClientAuth;
import com.interop.models.openevv.authorization.OpenEvvAuthorization;
import com.interop.models.openevv.authorization.OpenEvvAuthorizationDataGenerator;
import com.interop.services.base.RestfulService;
import com.sandata.batch.models.api.authorization.AuthorizationModel;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.utils.db.AuthDBUtils.getInboxAuthorization;
import static com.interop.common.constants.utils.db.AuthDBUtils.getSTXAuthorization;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;

public class OpenEvvAuthService extends RestfulService {
    private List<OpenEvvAuthorization> models = new ArrayList<>();

    public static OpenEvvAuthService init(STXClientAuth clientInfo) {
        OpenEvvAuthService openEvvAuth = new OpenEvvAuthService();
        OpenEvvAuthorization auth = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization(clientInfo,
                openEvvAuth.getStateAccount());
        openEvvAuth.addModel(auth);
        return openEvvAuth;
    }

    public static OpenEvvAuthService init(){
        OpenEvvAuthService openEvvAuth = new OpenEvvAuthService();
        OpenEvvAuthorization authorization = OpenEvvAuthorizationDataGenerator.getDefaultOpenEvvAuthorization();
        openEvvAuth.addModel(authorization);
        return openEvvAuth;
    }


    @Override
    public String getURI() {
        return "interfaces/intake/auths/rest/api/v1/evv";
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void setModels(List model) {
        this.models = model;
        this.loadPayload(this.getModels());
    }

    private void addModel(OpenEvvAuthorization model) {
        this.getModels().add(model);
        this.loadPayload(this.getModels());
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void loadPayload(List client) {
        this.payload = new Gson().toJsonTree(client);
    }

    @SuppressWarnings("rawtypes")
    public void validateCaseManager(DataValidationModel dataTest) {
        STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(this.getStateAccount(), 10).get(0);
        this.baseObj.info("Step 1: Prepare data for state:" + this.getStateAccount().getStateName());
        OpenEvvAuthService openEVVAuth = init(clientInfo);
        openEVVAuth.modifyPropertyValue(dataTest.getPropertyName(), dataTest.getPropertyType(), dataTest.getPropertyValue());
        this.baseObj.info("Step 2: Post Request");
        openEVVAuth.post();
        openEVVAuth.setModels(openEVVAuth.getPayLoad(AuthorizationModel.class));
        openEVVAuth.verifyPostStatus(dataTest.getPostStatus());
        if (!StringUtils.isBlank(dataTest.getExpectedMessage())) {
            openEVVAuth.verifyMDWFailedWithMessageSummary(
                    "[1] Records uploaded, please check errors/warnings and try again.", dataTest.getExpectedMessage());
        }
        if (!StringUtils.isBlank(dataTest.getUuidStatus())) {
            openEVVAuth.requestUUIDStatus();
            openEVVAuth.verifyUUIDStatus(dataTest.getUuidStatus());
            if (!StringUtils.isBlank(dataTest.getUuidExpectedError())) {
                openEVVAuth.verifyUUIDFailedWithErrorMessage("", dataTest.getUuidExpectedError());
            }
        }

        if (dataTest.getIsVerifyExistingDatabase().equalsIgnoreCase("yes")) {
            this.baseObj.info("Verify data storing in database");
            this.baseObj.sleep(10000);
            for (int i = 0; i < openEVVAuth.getModels().size(); i++) {
                Object objectAuth = openEVVAuth.getModels().get(i);
                AuthorizationModel currentAuth = (AuthorizationModel) objectAuth;
                String authRefNum = currentAuth.getAuthorizationReferenceNumber();
                String fNameCaseManager = currentAuth.getCaseManagerFirstName();
                String lNameCaseManager = currentAuth.getCaseManagerLastName();
                String emailCaseManager = currentAuth.getCaseManagerEmail();

                this.baseObj.info("Step 3: Verify ERROR CODE in INBOX EVV");
                InboxAuthorization inboxAuthorization = getInboxAuthorization(authRefNum).get(0);
                this.baseObj.validateActualAndExpectedText(inboxAuthorization.getERROR_CODE().toString(), "0 Operation success");

                this.baseObj.info("Step 4: Verify ERROR CODE in STX EVV");
                STXAuthorization stxAuthorization = getSTXAuthorization(authRefNum).get(0);
                this.baseObj.info("Verify field CaseManagerFirstName");
                this.baseObj.validateActualAndExpectedText(stxAuthorization.getCASE_MANAGER_F_NAME().toString(), fNameCaseManager);
                this.baseObj.info("Verify field CaseManagerLastName");
                this.baseObj.validateActualAndExpectedText(stxAuthorization.getCASE_MANAGER_L_NAME().toString(), lNameCaseManager);
                this.baseObj.info("Verify field CaseManagerEmail");
                this.baseObj.validateActualAndExpectedText(stxAuthorization.getCASE_MANAGER_E_MAIL().toString(), emailCaseManager);

                if (this.getStateAccount().getStateName().equalsIgnoreCase("PA_68611")) {
                    this.baseObj.info("Step 5: Verify Case Manager Existing in STX.APP_USER");
                    this.baseObj.info(AppUserDBUtils.getAppUser("9999", emailCaseManager).toString());
                }
            }
            this.baseObj.info("Data is stored in database successfully");
        }
    }

    public List<OpenEvvAuthorization> getModels() {
        return this.models;
    }
}
