package com.interop.models.openevv.authorization;

import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.models.db.stx.STXClientAuth;
import com.interop.models.db.stx.STXPayorID;
import com.interop.models.openevv.OpenEvvBaseModel;
import com.sandata.db.ClientDbService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;

@EqualsAndHashCode(callSuper = true)
public class OpenEvvAuthorizationDataGenerator extends OpenEvvBaseModel {
    StateAccount account;
    ClientDbService clientDbService;

    public OpenEvvAuthorizationDataGenerator(StateAccount account) {
        this.account = account;
        this.clientDbService = new ClientDbService(account);
    }

    public static OpenEvvAuthorization getDefaultOpenEvvAuthorization(STXClientAuth clientInfo, StateAccount account) {
        STXPayorID combinationService = TestDataHelper.getListAuthorizationServicesIDCombination().get(0);
        OpenEvvAuthorization openEvvAuthorization = OpenEvvAuthorization.builder().
                payerId(combinationService.PAYOR_ID).
                providerId(clientInfo.getPROVIDER_ID()).
                limit(AuthorizationLimit.builder()
                        .authorizationServiceID(combinationService.PROC_CODE)
                        .payerProgram(combinationService.PROGRAM)
                        .build()).
                code(DiagnosisCode.builder().build()).build();
        if (account.getStateName().equalsIgnoreCase("Pennsylvania")) {
            openEvvAuthorization.setClientIdentifier(clientInfo.getMEDICAID_ID());
        } else {
            openEvvAuthorization.setClientIdentifier(clientInfo.getCLIENT_ID_CUSTOM1());
        }
        return openEvvAuthorization;
    }

    public static OpenEvvAuthorization getDefaultOpenEvvAuthorization() {
        STXPayorID combinationService = TestDataHelper.getListAuthorizationServicesIDCombination().get(0);
        StateAccount account = StateAccount.loadStateAccount();
        OpenEvvAuthorization model = OpenEvvAuthorization.builder()
                .payerId(combinationService.PAYOR_ID)
                .code(DiagnosisCode.builder().build())
                .limit(buildAuthorizationLimitModifiers()
                        .authorizationServiceID(combinationService.PROC_CODE)
                        .payerProgram(combinationService.PROGRAM)
                        .build())
                .build();
        switch (account.getStateEnum()) {
            case ARIZONA:
                model.setProviderId(StateAccount.loadStateAccount().getProviderID());
                String clientIdentifier = commons.generateRandomStringOfFixLength(1).toUpperCase() + commons.generateRandomNumberOfFixLength(8);
                model.setClientIdentifier(clientIdentifier);
                break;
            case PENNSYLVANIA:
            case HAWAII:
                STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(getStateAccount(), 9).get(0);
                model.setClientIdentifier(clientInfo.getCLIENT_ID_CUSTOM1());
                String assessmentDate = "2030-02-02";
                model.setHiAssessmentDate(assessmentDate);
                model.setPayerRegion("01");
                break;
            default:
                break;
        }

        return model;
    }

    private static AuthorizationLimit.AuthorizationLimitBuilder buildAuthorizationLimitModifiers() {
        AuthorizationLimit.AuthorizationLimitBuilder objectBuilder = AuthorizationLimit.builder();
        switch (getStateAccount().getStateEnum()) {
            case PENNSYLVANIA:
                objectBuilder.modifier1("UN");
                objectBuilder.modifier2("");
                objectBuilder.modifier3("");
                objectBuilder.modifier4("");
                break;
            case ARIZONA:
            case HAWAII:
                objectBuilder.modifier1("");
                objectBuilder.modifier2("");
                objectBuilder.modifier3("");
                objectBuilder.modifier4("");
                break;
            default:
                objectBuilder.modifier1("HQ");
                objectBuilder.modifier2("HQ");
                objectBuilder.modifier3("HQ");
                objectBuilder.modifier4("HQ");
                break;
        }
        return objectBuilder;
    }
}
