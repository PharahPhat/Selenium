package com.interop.models.openevv;


import com.interop.models.openevv.authorization.AuthorizationLimit;
import com.interop.models.openevv.authorization.DiagnosisCode;
import com.interop.models.openevv.authorization.OpenEvvAuthorization;
import com.interop.models.openevv.batch.AuthorizationCSVModel;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TransformerModelAuthorization {
    /**
     * Returns true if at least one of the parameters are not blank, else false
     *
     * @param fieldValues
     * @return
     */
    private static boolean atLeastOneFieldNotBlank(String... fieldValues) {
        return Arrays.stream(fieldValues).anyMatch(StringUtils::isNotBlank);
    }

    private List<DiagnosisCode> addDiagnostic(AuthorizationCSVModel inputModel) {
        List<DiagnosisCode> list = new ArrayList<>();
        if (atLeastOneFieldNotBlank(inputModel.getClientDiagnosisCodeIsPrimary(),
                inputModel.getClientDiagnosisCode(),
                inputModel.getClientDiagnosisCodeBeginDate(),
                inputModel.getClientDiagnosisCodeEndDate())) {
            DiagnosisCode diagnostic = DiagnosisCode.builder().build();
            diagnostic.setClientDiagnosisCodeIsPrimary(inputModel.getClientDiagnosisCodeIsPrimary());
            diagnostic.setClientDiagnosisCode(inputModel.getClientDiagnosisCode());
            diagnostic.setClientDiagnosisCodeBeginDate(inputModel.getClientDiagnosisCodeBeginDate());
            diagnostic.setClientDiagnosisCodeEndDate(inputModel.getClientDiagnosisCodeEndDate());
            list.add(diagnostic);
            return list;
        }
        return Collections.emptyList();
    }

    public OpenEvvAuthorization convertFromModelCSVToAPI(AuthorizationCSVModel inputModel) {
        OpenEvvAuthorization model = OpenEvvAuthorization.builder().build();
        model.setPayerId(inputModel.getPayerID());
        model.setPayerRegion(inputModel.getPayerRegion());
        model.setClientQualifier(inputModel.getClientQualifier());
        model.setClientIdentifier(inputModel.getClientIdentifier());
        model.setProviderQualifier(inputModel.getProviderQualifier());
        model.setProviderId(inputModel.getProviderID());
        model.setAuthorizationReferenceNumber(inputModel.getAuthorizationReferenceNumber());
        model.setAuthorizationAmountType(inputModel.getAuthorizationAmountType());
        model.setAuthorizationMaximum(null);
        model.setAuthorizationStartDate(inputModel.getAuthorizationStartDate());
        model.setAuthorizationEndDate(inputModel.getAuthorizationEndDate());
        model.setAuthorizationShared(inputModel.getAuthorizationShared());
        model.setAuthorizationComments(inputModel.getAuthorizationComments());
        model.setAuthorizationLimitType(inputModel.getAuthorizationLimitType());
        model.setAuthorizationStatus(inputModel.getAuthorizationStatus());
        model.setAuthorizationLimit(addAuthLimit(inputModel));
        model.setDiagnosisCode(addDiagnostic(inputModel));
        model.setErrorMessage("");
        return model;
    }

    private List<AuthorizationLimit> addAuthLimit(AuthorizationCSVModel inputModel) {
        List<AuthorizationLimit> list = new ArrayList<>();
        if (atLeastOneFieldNotBlank(
                inputModel.getAuthorizationLimit(),
                inputModel.getAuthorizationWeekStart(),
                inputModel.getAuthorizationLimitDayOfWeek(),
                inputModel.getAuthorizationLimitStartTime(),
                inputModel.getAuthorizationLimitEndTime(),
                inputModel.getPayerProgram(),
                inputModel.getAuthorizationServiceID(),
                inputModel.getAuthorizationBillingType(),
                inputModel.getModifier1(),
                inputModel.getModifier2(),
                inputModel.getModifier3(),
                inputModel.getModifier4()
        )) {
            AuthorizationLimit authLimit = AuthorizationLimit.builder().build();
            authLimit.setAuthorizationLimit(inputModel.getAuthorizationMaximum());
            authLimit.setAuthorizationWeekStart(inputModel.getAuthorizationWeekStart());
            authLimit.setAuthorizationLimitDayOfWeek(inputModel.getAuthorizationLimitDayOfWeek());
            authLimit.setAuthorizationLimitStartTime(inputModel.getAuthorizationLimitStartTime());
            authLimit.setAuthorizationLimitEndTime(inputModel.getAuthorizationLimitEndTime());
            authLimit.setPayerProgram(inputModel.getPayerProgram());
            authLimit.setAuthorizationServiceID(inputModel.getAuthorizationServiceID());
            authLimit.setAuthorizationBillingType(inputModel.getAuthorizationBillingType());
            authLimit.setModifier1(inputModel.getModifier1());
            authLimit.setModifier2(inputModel.getModifier2());
            authLimit.setModifier3(inputModel.getModifier3());
            authLimit.setModifier4(inputModel.getModifier4());
            list.add(authLimit);
            return list;
        }
        return Collections.emptyList();
    }
}