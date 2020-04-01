package com.sandata.batch.models.api.authorization;

import com.google.gson.annotations.SerializedName;
import com.interop.common.Commons;
import com.interop.common.StateAccount;
import com.interop.models.db.stx.STXClientAuth;
import com.interop.services.openevv.batch.ImportAuthService;
import com.sandata.models.GenericModel;
import org.apache.commons.lang.RandomStringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.FieldConstants.MEDICAID_ID;
import static com.interop.common.constants.utils.db.ClientDBUtils.getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID;

public class AuthorizationModel extends GenericModel {

    @SerializedName("PayerID")
    private String payerId;

    @SerializedName("PayerRegion")
    private String payerRegion;

    @SerializedName("ClientQualifier")
    private String clientQualifier;

    @SerializedName("ClientIdentifier")
    private String clientIdentifier;

    @SerializedName("ProviderQualifier")
    private String providerQualifier;

    @SerializedName("ProviderID")
    private String providerId;

    @SerializedName("AuthorizationReferenceNumber")
    private String authorizationReferenceNumber;

    @SerializedName("AuthorizationAmountType")
    private String authorizationAmountType;

    @SerializedName("AuthorizationMaximum")
    private String authorizationMaximum;

    @SerializedName("AuthorizationStartDate")
    private String authorizationStartDate;

    @SerializedName("AuthorizationEndDate")
    private String authorizationEndDate;

    @SerializedName("AuthorizationShared")
    private String authorizationShared;

    @SerializedName("AuthorizationComments")
    private String authorizationComments;

    @SerializedName("AuthorizationLimitType")
    private String authorizationLimitType;

    @SerializedName("AuthorizationStatus")
    private String authorizationStatus;

    @SerializedName("AuthorizationLimit")
    private List<AuthLimitModel> authorizationLimit = new ArrayList<>();

    @SerializedName("DiagnosisCode")
    private List<DiagnosticModel> diagnosisCode = new ArrayList<>();

    @SerializedName("ErrorMessage")
    private String errorMessage;

    @SerializedName("AssessmentDate")
    private String assessmentDate;

    @SerializedName("CaseManagerFirstName")
    private String caseManagerFirstName;

    @SerializedName("CaseManagerLastName")
    private String caseManagerLastName;

    @SerializedName("CaseManagerEmail")
    private String caseManagerEmail;

    public static AuthorizationModel initModelStagingByExistingClient(StateAccount account) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        STXClientAuth clientInfo = getIDAndMedicaidIDOfMemberHavingSpecificMedicaidID(account, 10).get(0);
        AuthorizationModel model = new AuthorizationModel();
        model.setPayerId(account.getDefaultPayerID());
        model.setProviderQualifier(MEDICAID_ID);
        model.setProviderId(clientInfo.getPROVIDER_ID());
        model.setClientQualifier(account.getClientQualifier());
        model.setAuthorizationReferenceNumber(new ImportAuthService().generateAuthRefNumber());
        model.setAuthorizationAmountType("U");
        if (account.getStateName().equalsIgnoreCase("Pennsylvania")) {
            model.setClientIdentifier(clientInfo.getMEDICAID_ID());
        } else {
            model.setClientIdentifier(clientInfo.getCLIENT_ID_CUSTOM1());
        }
        model.setAuthorizationLimitType("N");
        model.setAuthorizationStatus("A");
        model.setAuthorizationLimit(initAuthLimit(1, account));
        model.setDiagnosisCode(initDiagnosis(1, account));
        model.setAssessmentDate("2030-02-02");
        Commons commons = new Commons();
        model.setCaseManagerFirstName("CMFName" + RandomStringUtils.randomAlphabetic(10));
        model.setCaseManagerLastName("CMLName" + RandomStringUtils.randomAlphabetic(10));
        model.setCaseManagerEmail(commons.generateEmailAddress("CaseManager"));
        return model;
    }

    public static AuthorizationModel initModelByExistingClient(StateAccount account) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        AuthorizationModel model = initModelStagingByExistingClient(account);
        if (account.getStateName().equalsIgnoreCase("Pennsylvania") ||
                account.getStateName().equalsIgnoreCase("PA_68611")) {
            model.setAuthorizationStartDate("07/23/2018");
            model.setAuthorizationEndDate("07/23/2029");
        } else {
            model.setAuthorizationStartDate("2018-07-23");
            model.setAuthorizationEndDate("2029-07-23");
        }
        return model;
    }

    private static List<AuthLimitModel> initAuthLimit(int numObjectAuthLimit, StateAccount stateAccount) {
        List<AuthLimitModel> models = new ArrayList<>();
        for (int i = 1; i <= numObjectAuthLimit; i++) {
            AuthLimitModel authLimitModel = new AuthLimitModel();
            authLimitModel.setAuthorizationLimit("10");
            authLimitModel.setPayerProgram(stateAccount.getDefaultPayerProgram());
            authLimitModel.setAuthorizationServiceID(stateAccount.getDefaultProcedureCode());
            authLimitModel.setServiceAuthorizedDate("2030-02-02");
            models.add(authLimitModel);
        }
        return models;
    }

    private static List<DiagnosticModel> initDiagnosis(int numObjectDiagnosis, StateAccount account) {
        List<DiagnosticModel> models = new ArrayList<>();
        for (int i = 1; i <= numObjectDiagnosis; i++) {
            DiagnosticModel model = new DiagnosticModel();
            model.setClientDiagnosisCodeIsPrimary("N");
            model.setClientDiagnosisCode(RandomStringUtils.randomNumeric(3));
            if (account.getStateName().equalsIgnoreCase("Pennsylvania") ||
                    account.getStateName().equalsIgnoreCase("PA_68611")) {
                model.setClientDiagnosisCodeBeginDate("07/23/2018");
                model.setClientDiagnosisCodeEndDate("07/23/2099");
            } else {
                model.setClientDiagnosisCodeBeginDate("2018-07-23");
                model.setClientDiagnosisCodeEndDate("2099-07-23");
            }
            models.add(model);
        }
        return models;
    }

    public String getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(String assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getPayerRegion() {
        return payerRegion;
    }

    public void setPayerRegion(String payerRegion) {
        this.payerRegion = payerRegion;
    }

    public String getClientQualifier() {
        return clientQualifier;
    }

    public void setClientQualifier(String clientQualifier) {
        this.clientQualifier = clientQualifier;
    }

    public String getClientIdentifier() {
        return clientIdentifier;
    }

    public void setClientIdentifier(String clientIdentifier) {
        this.clientIdentifier = clientIdentifier;
    }

    public String getProviderQualifier() {
        return providerQualifier;
    }

    public void setProviderQualifier(String providerQualifier) {
        this.providerQualifier = providerQualifier;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getAuthorizationReferenceNumber() {
        return authorizationReferenceNumber;
    }

    public void setAuthorizationReferenceNumber(String authorizationReferenceNumber) {
        this.authorizationReferenceNumber = authorizationReferenceNumber;
    }

    public String getAuthorizationAmountType() {
        return authorizationAmountType;
    }

    public void setAuthorizationAmountType(String authorizationAmountType) {
        this.authorizationAmountType = authorizationAmountType;
    }

    public String getAuthorizationMaximum() {
        return authorizationMaximum;
    }

    public void setAuthorizationMaximum(String authorizationMaximum) {
        this.authorizationMaximum = authorizationMaximum;
    }

    public String getAuthorizationStartDate() {
        return authorizationStartDate;
    }

    public void setAuthorizationStartDate(String authorizationStartDate) {
        this.authorizationStartDate = authorizationStartDate;
    }

    public String getAuthorizationEndDate() {
        return authorizationEndDate;
    }

    public void setAuthorizationEndDate(String authorizationEndDate) {
        this.authorizationEndDate = authorizationEndDate;
    }

    public String getAuthorizationShared() {
        return authorizationShared;
    }

    public void setAuthorizationShared(String authorizationShared) {
        this.authorizationShared = authorizationShared;
    }

    public String getAuthorizationComments() {
        return authorizationComments;
    }

    public void setAuthorizationComments(String authorizationComments) {
        this.authorizationComments = authorizationComments;
    }

    public String getAuthorizationLimitType() {
        return authorizationLimitType;
    }

    public void setAuthorizationLimitType(String authorizationLimitType) {
        this.authorizationLimitType = authorizationLimitType;
    }

    public String getAuthorizationStatus() {
        return authorizationStatus;
    }

    public void setAuthorizationStatus(String authorizationStatus) {
        this.authorizationStatus = authorizationStatus;
    }

    public List<AuthLimitModel> getAuthorizationLimit() {
        return authorizationLimit;
    }

    public void setAuthorizationLimit(List<AuthLimitModel> authorizationLimit) {
        this.authorizationLimit = authorizationLimit;
    }

    public List<DiagnosticModel> getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(List<DiagnosticModel> diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getCaseManagerFirstName() {
        return caseManagerFirstName;
    }

    public void setCaseManagerFirstName(String caseManagerFirstName) {
        this.caseManagerFirstName = caseManagerFirstName;
    }

    public String getCaseManagerLastName() {
        return caseManagerLastName;
    }

    public void setCaseManagerLastName(String caseManagerLastName) {
        this.caseManagerLastName = caseManagerLastName;
    }

    public String getCaseManagerEmail() {
        return caseManagerEmail;
    }

    public void setCaseManagerEmail(String caseManagerEmail) {
        this.caseManagerEmail = caseManagerEmail;
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }

    @Override
    public String toString() {
        return "AuthorizationModel{" +
                "payerId='" + payerId + '\'' +
                ", payerRegion='" + payerRegion + '\'' +
                ", clientQualifier='" + clientQualifier + '\'' +
                ", clientIdentifier='" + clientIdentifier + '\'' +
                ", providerQualifier='" + providerQualifier + '\'' +
                ", providerId='" + providerId + '\'' +
                ", authorizationReferenceNumber='" + authorizationReferenceNumber + '\'' +
                ", authorizationAmountType='" + authorizationAmountType + '\'' +
                ", authorizationMaximum='" + authorizationMaximum + '\'' +
                ", authorizationStartDate='" + authorizationStartDate + '\'' +
                ", authorizationEndDate='" + authorizationEndDate + '\'' +
                ", authorizationShared='" + authorizationShared + '\'' +
                ", authorizationComments='" + authorizationComments + '\'' +
                ", authorizationLimitType='" + authorizationLimitType + '\'' +
                ", authorizationStatus='" + authorizationStatus + '\'' +
                ", authorizationLimit=" + authorizationLimit +
                ", diagnosisCode=" + diagnosisCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", assessmentDate='" + assessmentDate + '\'' +
                ", caseManagerFirstName='" + caseManagerFirstName + '\'' +
                ", caseManagerLastName='" + caseManagerLastName + '\'' +
                ", caseManagerEmail='" + caseManagerEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object2) {
        if (object2 == null) {
            return false;
        } else if (!(object2 instanceof AuthorizationModel)) {
            return false;
        } else {
            AuthorizationModel objectCompared = (AuthorizationModel) object2;
            return providerId.equals(objectCompared.providerId)
                    && clientIdentifier.equals(objectCompared.clientIdentifier)
                    && authorizationLimit.equals(objectCompared.authorizationLimit)
                    && diagnosisCode.equals(objectCompared.diagnosisCode);
        }
    }
}
