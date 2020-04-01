package com.sandata.ws;

import com.google.gson.Gson;
import com.sandata.common.Constant;
import com.sandata.common.resource.Visit;
import com.sandata.core.Wrapper;
import com.sandata.core.config.Environment;
import com.sandata.core.ws.WebServicesBase;
import com.sandata.entity.connecticut.visit.Calls;
import com.sandata.entity.connecticut.visit.VisitChanges;
import com.sandata.entity.connecticut.visit.VisitsConnecticutWithConfigurationModel;
import com.sandata.entity.exportDWH.Call;
import com.sandata.entity.exportDWH.ProviderIdentification;
import com.sandata.entity.exportDWH.VisitChange;
import com.sandata.entity.exportDWH.VisitExceptionAcknowledgement;
import com.sandata.entity.generic.VisitGenericEntity;
import com.sandata.entity.molina.visit.VisitGeneralEntity;
import com.sandata.models.molina.visit.VisistMolinaWithConfigurationModel;
import com.sandata.ws.dwh.DWHServices;
import com.sandata.ws.molina.account.AccountWebService;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.*;

import static com.sandata.common.Constant.CONTENT_TYPE.ApplicationJson;
import static com.sandata.common.Constant.HEADER.ContentType;
import static com.interop.sql.VisitSQL.SQL_GET_VISIT_BY_ACCOUNT_AND_UNIQUE_MEMO;
import static io.restassured.RestAssured.given;
@SuppressWarnings({"squid:S1192","squid:S2696"})
public class VisitWebService extends DWHServices {
    private static final Logger LOGGER = Logger.getLogger(VisitWebService.class);
    private AccountWebService accountWebService;
    protected Wrapper baseObj;

    enum Account{
        MOLINA, OHIO, CONNECTICUT
    }
    public VisitWebService() {
        accountWebService = new AccountWebService();
        webServicesBase =  new WebServicesBase();
    }


    public Response sendImportVisitRequest(Wrapper baseObj, String modifyJson, String accountId){
        LOGGER.info(modifyJson);
        return accountWebService.sendPOSTWithAccountInHeader(baseObj.getEnvironment("alt_evv_visit_v1"),
                modifyJson, baseObj.getEnvironment("molina_UserName"), baseObj.getEnvironment("molina_Password"), accountId);
    }

    public VisistMolinaWithConfigurationModel[] createVisit(String jsonFileName, Wrapper baseObj, String accountId) throws InterruptedException,  IOException {
        Gson gson = new Gson();
        VisistMolinaWithConfigurationModel[] visits = toJsonModel(jsonFileName, VisistMolinaWithConfigurationModel[].class);
        Response r = sendImportVisitRequest(baseObj, gson.toJson(visits), accountId);
        LOGGER.info(r.getBody().prettyPrint());
        return visits;
    }

    /**
     * Call the api create a visit
     * @param accountType the name of account
     * @param environment the environment
     * @return the response data
     */
    public String callCreateVisit(String accountType, String username, String password, String account,
                                  VisitGeneralEntity visitInput, Environment environment) {
        String response = null;
        try {
            if(accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.MOLINA))){
                response = preparePostRequestVisitData(accountType, visitInput, username, password, account, environment);
            } else if(accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.CONNECTICUT)) || accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.OHIO))){
                //TODO: will implement when apply for another client
                response = "";
            }
            Constant.exported = 1; //NO SONAR
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public String preparePostRequestVisitData(String accountType, VisitGeneralEntity visitInput,
                                              String username, String password, String account,
                                              Environment environment) throws InterruptedException,  IOException {
        String url = environment.getDwh();
        Gson gson = new Gson();
        VisitGeneralEntity[] visitsWithConfigurationRequests = webServicesBase
                .toJsonModel("json/Molina/VisitsWithConfiguration.json", VisitGeneralEntity[].class);
        VisitGeneralEntity visitsWithConfigurationRequest = visitsWithConfigurationRequests[0];

        if(visitInput != null) {
            //Set provider providerIdentification
            visitsWithConfigurationRequest.setMemo(visitInput.getMemo());
            Optional.ofNullable(visitInput.getProviderIdentification()).ifPresent(visitsWithConfigurationRequest::setProviderIdentification);
            Optional.ofNullable(visitInput.getClientQualifier()).ifPresent(visitsWithConfigurationRequest::setClientQualifier);
            Optional.ofNullable(visitInput.getClientIdentifier()).ifPresent(visitsWithConfigurationRequest::setClientIdentifier);
            Optional.ofNullable(visitInput.getEmployeeQualifier()).ifPresent(visitsWithConfigurationRequest::setEmployeeQualifier);
            Optional.ofNullable(visitInput.getEmployeeIdentifier()).ifPresent(visitsWithConfigurationRequest::setEmployeeIdentifier);
            Optional.ofNullable(visitInput.getSequenceID()).ifPresent(visitsWithConfigurationRequest::setSequenceID);
            Optional.ofNullable(visitInput.getVisitOtherID()).ifPresent(visitsWithConfigurationRequest::setVisitOtherID);
            Optional.ofNullable(visitInput.getScheduleStartTime()).ifPresent(visitsWithConfigurationRequest::setScheduleStartTime);
            Optional.ofNullable(visitInput.getScheduleEndTime()).ifPresent(visitsWithConfigurationRequest::setScheduleEndTime);
            Optional.ofNullable(visitInput.getAdjInDateTime()).ifPresent(visitsWithConfigurationRequest::setAdjInDateTime);
            Optional.ofNullable(visitInput.getAdjOutDateTime()).ifPresent(visitsWithConfigurationRequest::setAdjOutDateTime);
            Optional.ofNullable(visitInput.getCalls()).ifPresent(inputCalls ->{
                List<Call> calls = visitsWithConfigurationRequest.getCalls();
                calls.get(0).setCallDateTime(inputCalls.get(0).getCallDateTime());
                calls.get(1).setCallDateTime(inputCalls.get(1).getCallDateTime());
                visitsWithConfigurationRequest.setCalls(calls);
            });
            Optional.ofNullable(visitInput.getVisitChanges()).ifPresent( changes -> {
                List<VisitChange> visitChanges = visitsWithConfigurationRequest.getVisitChanges();
                visitChanges.get(0).setChangeDateTime(changes.get(0).getChangeDateTime());
                visitsWithConfigurationRequest.setVisitChanges(visitChanges);
            });
        }

        return capturePostResponseEXPORTEVV(accountType, url, gson.toJson(visitsWithConfigurationRequest),username, password, account);
    }

    public String capturePostResponseEXPORTEVV(String accountType, String url, String modifyJson, String username, String password, String account){

        return sendVisitRequest(accountType, url,
                username,
                password,
                account,
                modifyJson).asString();
    }

    public Response sendVisitRequest(String accountType, String baseUrl, String username, String password, String account, String modifyJson){
        String postUrl = baseUrl + "/" + WebServicesConstants.CREATE_VISIT_MOLINA_URL;
        if(accountType.equals(Constant.CONNECTICUT))
            postUrl = baseUrl + "/" + WebServicesConstants.CREATE_VISIT_GENERIC_URL;
        Response response = given().
                relaxedHTTPSValidation().
                body("[" + modifyJson + "]").header("Content-Type","application/json").
                auth().preemptive().
                basic(username, password).
                header("Account", account).log().all().
                when().post(postUrl).
                then().assertThat().statusCode(200).and().extract().response();

        return response;
    }

    public VisitGenericEntity createVisit(Constant.ACCOUNT_TYPE accountType, Constant.REQUEST_TYPE requestType,
                                          Constant.EmployeeQualifier employeeQualifier, String employeeIdentifier,
                                          Constant.ClientQualifier clientQualifier, String clientIdentifier, String loc) {
        VisitGenericEntity visitGenericEntity = null;

        switch (requestType) {
            case INTAKE:
                switch (accountType) {
                    case MOLINA:
                        visitGenericEntity = createMolinaVisit(employeeQualifier, employeeIdentifier,
                                clientQualifier, clientIdentifier, loc);
                        break;
                    case OHIO:
                        //TODO: to be implemented
                        break;
                    case CONNECTICUT:
                        visitGenericEntity = createConnecticutVisit(employeeQualifier, employeeIdentifier,
                                clientQualifier, clientIdentifier, loc);
                        break;
                    default:
                        break;
                }
                break;
            case HTTP_REQUEST:
                switch (accountType) {
                    case MOLINA:
                        break;
                    case OHIO:
                        break;
                    case CONNECTICUT:
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return visitGenericEntity;
    }

    public VisitGenericEntity createMolinaVisit(Constant.EmployeeQualifier employeeQualifier, String employeeIdentifier,
                                               Constant.ClientQualifier clientQualifier, String clientIdentifier, String loc) {
        int retry1 = 10;

        String accountId = getTestEnvironment().get("molina_accountId");
        String providerId = getTestEnvironment().get("molina_providerId");

        List<VisitGeneralEntity> visitGeneralEntities = null;
        VisitGeneralEntity visitGeneralEntity = null;

        while ( retry1 > 0 ) {
            int retry2 = 10;
            visitGeneralEntities = initializeVisitMolinaData(accountId, providerId, employeeQualifier, employeeIdentifier, clientQualifier, clientIdentifier, loc);
            visitGeneralEntity = visitGeneralEntities.get(0);

            while (retry2 > 0) {
                callRequestToCreateVisit(accountId, providerId, visitGeneralEntities);
                if(isVisitExistInDatabase(accountId, visitGeneralEntity.Memo )) {
                    logInfo(String.format("visit with unique memo '%s' existed in DB", visitGeneralEntity.Memo));
                    return visitGeneralEntity;
                }
                logInfo(String.format("Visit with unique memo '%s' existed in DB. Retry %s to call same json",
                        visitGeneralEntity.Memo, retry2));
                logInfo(String.format("Send to create visit:%n %s", new Gson().toJson(visitGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("visit with unique memo not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create visit with new Json:%n %s", new Gson().toJson(visitGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a new visit in %s time", retry1));
        return null;
    }

    public VisitGenericEntity createMolinaVerifiedVisit(Constant.EmployeeQualifier employeeQualifier, String employeeIdentifier,
                                                Constant.ClientQualifier clientQualifier, String clientIdentifier, String loc) {
        int retry1 = 10;

        String accountId = getTestEnvironment().get("molina_accountId");
        String providerId = getTestEnvironment().get("molina_providerId");

        List<VisitGeneralEntity> visitGeneralEntities = null;
        VisitGeneralEntity visitGeneralEntity = null;

        while ( retry1 > 0 ) {
            int retry2 = 10;
            visitGeneralEntities = initializeVerifiedVisitMolinaData(accountId, providerId, employeeQualifier, employeeIdentifier, clientQualifier, clientIdentifier, loc);
            visitGeneralEntity = visitGeneralEntities.get(0);

            while (retry2 > 0) {
                callRequestToCreateVisit(accountId, providerId, visitGeneralEntities);
                if(isVisitExistInDatabase(accountId, visitGeneralEntity.Memo )) {
                    logInfo(String.format("Verified visit with unique memo '%s' existed in DB", visitGeneralEntity.Memo));
                    return visitGeneralEntity;
                }
                logInfo(String.format("Verified visit with unique memo '%s' existed in DB. Retry %s to call same json",
                        visitGeneralEntity.Memo, retry2));
                logInfo(String.format("Send to create verified visit:%n %s", new Gson().toJson(visitGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Verified visit with unique memo not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create verified visit with new Json:%n %s", new Gson().toJson(visitGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a new verified visit in %s time", retry1));
        return null;
    }

    public VisitGenericEntity createOhioVisit( String StaffOtherID, String PatientOtherID, String PatientMedicaidID ) {
        return createOhioVisit(StaffOtherID,PatientOtherID,PatientMedicaidID,"ODM");
    }

    public VisitGenericEntity createOhioVisit( String StaffOtherID, String PatientOtherID, String PatientMedicaidID, String payorId) {
        int retry1 = 10;

        String accountId = getTestEnvironment().get("ohio_accountId");
        String providerId = getTestEnvironment().get("ohio_providerId");

        List<com.sandata.entity.ohio.visit.VisitGeneralEntity> visitGeneralEntities = null;
        com.sandata.entity.ohio.visit.VisitGeneralEntity visitGeneralEntity = null;

        while ( retry1 > 0 ) {
            int retry2 = 10;
            visitGeneralEntities =
                    initializeVisitOhioData(accountId, providerId,
                            StaffOtherID, PatientOtherID, PatientMedicaidID,payorId);
            visitGeneralEntity = visitGeneralEntities.get(0);

            while (retry2 > 0) {
                callRequestToCreateOhioVisit(accountId, providerId, visitGeneralEntities);
                if(isVisitExistInDatabase(accountId, visitGeneralEntity.VisitMemo )) {
                    logInfo(String.format("Visit Ohio with unique memo '%s' existed in DB", visitGeneralEntity.VisitMemo));
                    return visitGeneralEntity;
                }
                logInfo(String.format("Visit Ohio with unique memo '%s' existed in DB. Retry %s to call same json",
                        visitGeneralEntity.VisitMemo, retry2));
                logInfo(String.format("Send to create visit Ohio:%n %s", new Gson().toJson(visitGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Visit Ohio with unique memo not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create visit Ohio with new Json:%n %s", new Gson().toJson(visitGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a new visit Ohio in %s time", retry1));
        return null;
    }

    public VisitGenericEntity createConnecticutVisit(Constant.EmployeeQualifier employeeQualifier, String employeeIdentifier,
                                                     Constant.ClientQualifier clientQualifier, String clientIdentifier, String loc) {
        VisitGenericEntity visitGenericEntity = null;
        return visitGenericEntity;
    }

    public VisitGenericEntity createMolinaVisitWithUserInput(Constant.EmployeeQualifier employeeQualifier, String employeeIdentifier,
                                                Constant.ClientQualifier clientQualifier, String clientIdentifier, String loc,
                                                             List<VisitGeneralEntity> visitGeneralEntities) {
        int retry1 = 10;

        String accountId = getTestEnvironment().get("molina_accountId");
        String providerId = getTestEnvironment().get("molina_providerId");

        VisitGeneralEntity visitGeneralEntity = null;

        while ( retry1 > 0 ) {
            int retry2 = 10;
            visitGeneralEntity = visitGeneralEntities.get(0);

            while (retry2 > 0) {
                callRequestToCreateVisit(accountId, providerId, visitGeneralEntities);
                if(isVisitExistInDatabase(accountId, visitGeneralEntity.Memo )) {
                    logInfo(String.format("visit with unique memo '%s' existed in DB", visitGeneralEntity.Memo));
                    return visitGeneralEntity;
                }
                logInfo(String.format("visit with unique memo '%s' existed in DB. Retry %s to call same json",
                        visitGeneralEntity.Memo, retry2));
                logInfo(String.format("Send to create visit:%n %s", new Gson().toJson(visitGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("visit with unique memo not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create visit with new Json:%n %s", new Gson().toJson(visitGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a new visit in %s time", retry1));
        return null;
    }

    public List<VisitGeneralEntity> initializeVisitMolinaData(String accountId, String providerId,
                                                               Constant.EmployeeQualifier employeeQualifier, String employeeIdentifier,
                                                               Constant.ClientQualifier clientQualifier, String clientIdentifier, String loc) {
        String scheduleStartTime = commons.getDateString(-1, "yyyy-MM-dd") + "T00:00:00Z";
        String scheduleEndTime = commons.getDateString(-1, "yyyy-MM-dd") + "T00:05:00Z";
        String changeDateTime = commons.getDateString(-1, "yyyy-MM-dd") + "T00:00:00Z";
        String memo = "memodata" + commons.generateUniqueNumber();
        String sequenceId = commons.generateUniqueNumber() + RandomStringUtils.randomNumeric(2);;

        List<VisitGeneralEntity> visitGeneralEntities = new ArrayList<>();
        VisitGeneralEntity visitGeneralEntity = new VisitGeneralEntity();

        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.setProviderQualifier(Constant.ProviderQualifier.Other.toString());
        providerIdentification.setProviderID(providerId);
        visitGeneralEntity.ProviderIdentification = providerIdentification;

        visitGeneralEntity.VisitOtherID = RandomStringUtils.randomAlphanumeric(50);
        visitGeneralEntity.SequenceID = sequenceId;
        visitGeneralEntity.EmployeeQualifier = employeeQualifier.toString();
        visitGeneralEntity.EmployeeIdentifier = employeeIdentifier;
        visitGeneralEntity.ClientQualifier = clientQualifier.toString();
        visitGeneralEntity.ClientIdentifier = clientIdentifier;
        visitGeneralEntity.VisitCancelledIndicator = false;
        visitGeneralEntity.PayerID = "MEDHHS";
        visitGeneralEntity.PayerProgram = "40";
        visitGeneralEntity.ProcedureCode = "G0156";
        visitGeneralEntity.VisitTimeZone = "US/Eastern";
        visitGeneralEntity.ScheduleStartTime = scheduleStartTime;
        visitGeneralEntity.ScheduleEndTime = scheduleEndTime;
        visitGeneralEntity.AdjInDateTime = scheduleStartTime;
        visitGeneralEntity.AdjOutDateTime = scheduleEndTime;
        visitGeneralEntity.BillVisit = true;
        visitGeneralEntity.HoursToBill = 10;
        visitGeneralEntity.HoursToPay = 10;
        visitGeneralEntity.Memo = memo;
        visitGeneralEntity.ClientVerifiedTimes = true;
        visitGeneralEntity.ClientVerifiedTasks = true;
        visitGeneralEntity.ClientVerifiedService = true;
        visitGeneralEntity.ClientSignatureAvailable = true;
        visitGeneralEntity.ClientVoiceRecording = true;

        List<Call> calls = new ArrayList<>();
        Call call = new Call();
        call.CallExternalID =  commons.generateUniqueNumber();
        call.CallDateTime =  scheduleStartTime;
        call.CallAssignment = Constant.CallAssignment.TimeIn.toString();
        call.CallType = Constant.CallType.Other.toString();
        call.ProcedureCode = "T1000";
        call.ClientIdentifierOnCall = loc;
        call.MobileLogin = "98733222";
        call.CallLatitude = 40.34455;
        call.CallLongitude = -21.99383;
        call.Location = "123";
        call.TelephonyPIN = 9989999;
        call.OriginatingPhoneNumber = "2125551212";
        call.ErrorCode = "null";
        call.ErrorMessage = "null";
        calls.add(call);

        visitGeneralEntity.Calls = calls;

        List<VisitExceptionAcknowledgement> visitExceptionAcknowledgements = new ArrayList<>();
        VisitExceptionAcknowledgement visitExceptionAcknowledgement1 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement1.ExceptionID = "4";
        visitExceptionAcknowledgement1.ExceptionAcknowledged = true;

        VisitExceptionAcknowledgement visitExceptionAcknowledgement2 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement2.ExceptionID = "10";
        visitExceptionAcknowledgement2.ExceptionAcknowledged = false;

        VisitExceptionAcknowledgement visitExceptionAcknowledgement3 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement3.ExceptionID = "34";
        visitExceptionAcknowledgement3.ExceptionAcknowledged = false;

        VisitExceptionAcknowledgement visitExceptionAcknowledgement4 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement4.ExceptionID = "39";
        visitExceptionAcknowledgement4.ExceptionAcknowledged = false;

        VisitExceptionAcknowledgement visitExceptionAcknowledgement5 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement5.ExceptionID = "28";
        visitExceptionAcknowledgement5.ExceptionAcknowledged = true;

        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement1);
        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement2);
        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement3);
        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement4);
        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement5);

        visitGeneralEntity.VisitExceptionAcknowledgements = visitExceptionAcknowledgements;

        List<VisitChange> visitChanges = new ArrayList<>();
        VisitChange visitChange = new VisitChange();
        visitChange.SequenceID = sequenceId;
        visitChange.ChangeMadeBy = "yesterday2010@test.com";
        visitChange.ChangeDateTime = changeDateTime;
        visitChange.GroupCode = "02";
        visitChange.ReasonCode = "02";
        visitChange.ChangeReasonMemo = "Change Reason Memo " + memo;
        visitChange.ResolutionCode = "A";

        visitChanges.add(visitChange);
        visitGeneralEntity.VisitChanges = visitChanges;

        visitGeneralEntities.add(visitGeneralEntity);

        return visitGeneralEntities;
    }

    public List<VisitGeneralEntity> initializeVerifiedVisitMolinaData(String accountId, String providerId,
                                                              Constant.EmployeeQualifier employeeQualifier, String employeeIdentifier,
                                                              Constant.ClientQualifier clientQualifier, String clientIdentifier, String loc) {
        String scheduleStartTime = commons.getDateString(-1, "yyyy-MM-dd") + "T00:00:00Z";
        String scheduleEndTime = commons.getDateString(-1, "yyyy-MM-dd") + "T00:05:00Z";
        String changeDateTime = commons.getDateString(-1, "yyyy-MM-dd") + "T00:00:00Z";
        String memo = "memodata" + commons.generateUniqueNumber();
        String sequenceId = commons.generateUniqueNumber() + RandomStringUtils.randomNumeric(2);;

        List<VisitGeneralEntity> visitGeneralEntities = new ArrayList<>();
        VisitGeneralEntity visitGeneralEntity = new VisitGeneralEntity();

        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.setProviderQualifier(Constant.ProviderQualifier.Other.toString());
        providerIdentification.setProviderID(providerId);
        visitGeneralEntity.ProviderIdentification = providerIdentification;

        visitGeneralEntity.VisitOtherID = RandomStringUtils.randomAlphanumeric(50);
        visitGeneralEntity.SequenceID = sequenceId;
        visitGeneralEntity.EmployeeQualifier = employeeQualifier.toString();
        visitGeneralEntity.EmployeeIdentifier = employeeIdentifier;
        visitGeneralEntity.ClientQualifier = clientQualifier.toString();
        visitGeneralEntity.ClientIdentifier = clientIdentifier;
        visitGeneralEntity.VisitCancelledIndicator = false;
        visitGeneralEntity.PayerID = "MEDHHS";
        visitGeneralEntity.PayerProgram = "29";
        visitGeneralEntity.ProcedureCode = "T1000";
        visitGeneralEntity.VisitTimeZone = "US/Eastern";
        visitGeneralEntity.ScheduleStartTime = scheduleStartTime;
        visitGeneralEntity.ScheduleEndTime = scheduleEndTime;
        visitGeneralEntity.AdjInDateTime = scheduleStartTime;
        visitGeneralEntity.AdjOutDateTime = scheduleEndTime;
        visitGeneralEntity.BillVisit = true;
        visitGeneralEntity.HoursToBill = 10;
        visitGeneralEntity.HoursToPay = 10;
        visitGeneralEntity.Memo = memo;
        visitGeneralEntity.ClientVerifiedTimes = true;
        visitGeneralEntity.ClientVerifiedTasks = true;
        visitGeneralEntity.ClientVerifiedService = true;
        visitGeneralEntity.ClientSignatureAvailable = true;
        visitGeneralEntity.ClientVoiceRecording = true;

        List<Call> calls = new ArrayList<>();
        Call call = new Call();
        call.CallExternalID =  commons.generateUniqueNumber();
        call.CallDateTime =  scheduleStartTime;
        call.CallAssignment = Constant.CallAssignment.TimeIn.toString();
        call.CallType = Constant.CallType.Other.toString();
        call.ProcedureCode = "T1000";
        call.ClientIdentifierOnCall = loc;
        call.MobileLogin = "98733222";
        call.CallLatitude = 40.34455;
        call.CallLongitude = -21.99383;
        call.Location = "123";
        call.TelephonyPIN = 9989999;
        call.OriginatingPhoneNumber = "2125551212";
        call.ErrorCode = "null";
        call.ErrorMessage = "null";
        calls.add(call);

        visitGeneralEntity.Calls = calls;

        List<VisitExceptionAcknowledgement> visitExceptionAcknowledgements = new ArrayList<>();
        VisitExceptionAcknowledgement visitExceptionAcknowledgement1 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement1.ExceptionID = "4";
        visitExceptionAcknowledgement1.ExceptionAcknowledged = true;

        VisitExceptionAcknowledgement visitExceptionAcknowledgement2 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement2.ExceptionID = "10";
        visitExceptionAcknowledgement2.ExceptionAcknowledged = true;

        VisitExceptionAcknowledgement visitExceptionAcknowledgement3 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement3.ExceptionID = "34";
        visitExceptionAcknowledgement3.ExceptionAcknowledged = true;

        VisitExceptionAcknowledgement visitExceptionAcknowledgement4 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement4.ExceptionID = "39";
        visitExceptionAcknowledgement4.ExceptionAcknowledged = true;

        VisitExceptionAcknowledgement visitExceptionAcknowledgement5 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement5.ExceptionID = "28";
        visitExceptionAcknowledgement5.ExceptionAcknowledged = true;

        VisitExceptionAcknowledgement visitExceptionAcknowledgement6 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement5.ExceptionID = "34";
        visitExceptionAcknowledgement5.ExceptionAcknowledged = true;

        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement1);
        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement2);
        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement3);
        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement4);
        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement5);

        visitGeneralEntity.VisitExceptionAcknowledgements = visitExceptionAcknowledgements;

        List<VisitChange> visitChanges = new ArrayList<>();
        VisitChange visitChange = new VisitChange();
        visitChange.SequenceID = sequenceId;
        visitChange.ChangeMadeBy = "yesterday2010@test.com";
        visitChange.ChangeDateTime = changeDateTime;
        visitChange.GroupCode = "02";
        visitChange.ReasonCode = "02";
        visitChange.ChangeReasonMemo = "Change Reason Memo " + memo;
        visitChange.ResolutionCode = "A";

        visitChanges.add(visitChange);
        visitGeneralEntity.VisitChanges = visitChanges;

        visitGeneralEntities.add(visitGeneralEntity);

        return visitGeneralEntities;
    }

    public List<com.sandata.entity.ohio.visit.VisitGeneralEntity> initializeVisitOhioData( String accountId, String providerId,
                                                                                           String StaffOtherID, String PatientOtherID, String PatientMedicaidID, String payorId ) {
        String scheduleStartTime = commons.getDateString(+0, "yyyy-MM-dd") + "T00:00:00Z";
        String scheduleEndTime = commons.getDateString(+0, "yyyy-MM-dd") + "T00:05:00Z";
        String changeDateTime = commons.getDateString(+0, "yyyy-MM-dd") + "T00:00:00Z";

        String sequenceId = visitDbService.generateNewVisitSequenceNumber(accountId);
        String memo = visitDbService.generateNewVisitMemo(accountId);

        List<com.sandata.entity.ohio.visit.VisitGeneralEntity> visitGeneralEntities = new ArrayList<>();
        com.sandata.entity.ohio.visit.VisitGeneralEntity visitGeneralEntity = new com.sandata.entity.ohio.visit.VisitGeneralEntity();

        visitGeneralEntity.BusinessEntityID = accountId;
        visitGeneralEntity.BusinessEntityMedicaidIdentifier = providerId;
        visitGeneralEntity.VisitOtherID = visitDbService.generateNewVisitOtherId(accountId);
        visitGeneralEntity.SequenceID = visitDbService.generateNewVisitSequenceNumber(accountId);
        visitGeneralEntity.StaffOtherID = StaffOtherID;
        visitGeneralEntity.PatientOtherID = PatientOtherID;
        visitGeneralEntity.PatientMedicaidID = PatientMedicaidID;
        visitGeneralEntity.VisitCancelledIndicator = false;
        visitGeneralEntity.Payer = payorId;
        visitGeneralEntity.PayerID = "ODM";
        //TODO: {Payer: "ODM", PayerProgram: "OHC", ProcedureCode: "MR816"}, {Payer: "ODM", PayerProgram: "SP", ProcedureCode: "MR816"}
        visitGeneralEntity.PayerProgram = "SP";
        visitGeneralEntity.ProcedureCode = "T1000";
        visitGeneralEntity.GroupVisitIndicator = "true";
        visitGeneralEntity.GroupVisitCode = "123456";
        visitGeneralEntity.TimeZone = "US/Eastern";
        visitGeneralEntity.AdjInDateTime = scheduleStartTime;
        visitGeneralEntity.AdjOutDateTime = scheduleEndTime;
        visitGeneralEntity.BillVisit = true;
        visitGeneralEntity.HoursToBill = 120;
        visitGeneralEntity.VisitMemo = memo;
        visitGeneralEntity.MemberVerifiedTimes = true;
        visitGeneralEntity.MemberVerifiedService = true;
        visitGeneralEntity.MemberSignatureAvailable =true;
        visitGeneralEntity.MemberVoiceRecording = false;

        List<com.sandata.entity.ohio.visit.Call> calls = new ArrayList<>();
        com.sandata.entity.ohio.visit.Call call = new com.sandata.entity.ohio.visit.Call();
        call.CallExternalID =  commons.generateUniqueNumber();
        call.CallDateTime =  scheduleStartTime;
        call.CallAssignment = Constant.CallAssignment.CallIn.toString();
        call.CallType = Constant.CallType.Other.toString();
        call.GroupVisitCode = "12378";
        call.ProcedureCode = "G0300";
        call.PatientIdentifierOnCall = "02225";
        call.MobileLogin = "qweqewq";
        call.CallLatitude = "86.2";
        call.CallLongitude = "160.2";
        call.TelephonyPIN = 2252;
        call.OriginatingPhoneNumber = "1234567890";
        calls.add(call);
        visitGeneralEntity.Calls = calls;

        List<VisitExceptionAcknowledgement> visitExceptionAcknowledgements = new ArrayList<>();
        VisitExceptionAcknowledgement visitExceptionAcknowledgement1 = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement1.ExceptionID = "25";
        visitExceptionAcknowledgement1.ExceptionAcknowledged = true;
        visitExceptionAcknowledgements.add(visitExceptionAcknowledgement1);

        visitGeneralEntity.VisitException = visitExceptionAcknowledgements;

        List<com.sandata.entity.ohio.visit.VisitChange> visitChanges = new ArrayList<>();
        com.sandata.entity.ohio.visit.VisitChange visitChange = new com.sandata.entity.ohio.visit.VisitChange();
        visitChange.SequenceID = sequenceId;
        visitChange.ChangeMadeByEmail = "yesterday2010@test.com";
        visitChange.ChangeDateTime = changeDateTime;
        visitChange.ReasonCode = "02";
        visitChange.ChangeReasonMemo = "Change Reason Memo " + memo;
        visitChange.ResolutionCode = "A";

        visitChanges.add(visitChange);
        visitGeneralEntity.VisitChanges = visitChanges;

        visitGeneralEntities.add(visitGeneralEntity);

        return visitGeneralEntities;
    }

    public Response callRequestToCreateVisit(String accountId, String providerId,
                                             List<VisitGeneralEntity> visitGeneralEntities) {
        String json = new Gson().toJson(visitGeneralEntities);
        VisitGeneralEntity visitGeneralEntity = visitGeneralEntities.get(0);

        String requestUrl = getTestEnvironment().get("intake_endpoint") + Visit.INTAKE_CREATE_VISIT;
        String auth_username = getTestEnvironment().get("molina_UserName");
        String auth_password = getTestEnvironment().get("molina_Password");

        Map<String, String> header = new HashMap<>();
        header.put(ContentType.toString(), ApplicationJson.toString());
        header.put(Constant.HEADER.Account.toString(), accountId);

        Response response =  webServicesBase.sendPOSTRequest(requestUrl, header, json, auth_username, auth_password);
        if (response.getStatusCode() == 200) {
            logInfo(String.format("Create visit successfully. Memo: %s, account: %s, provider Id: %s",
                    visitGeneralEntity.Memo, accountId, providerId));
        } else {
            logInfo(String.format("Create visit unsuccessfully. First name: %s, account: %s, provider Id: %s",
                    visitGeneralEntity.Memo, accountId, providerId));
        }
        return response;
    }

    public Response callRequestToCreateOhioVisit(String accountId, String providerId,
                                             List<com.sandata.entity.ohio.visit.VisitGeneralEntity> visitGeneralEntities) {
        String json = new Gson().toJson(visitGeneralEntities);
        com.sandata.entity.ohio.visit.VisitGeneralEntity visitGeneralEntity = visitGeneralEntities.get(0);

        String requestUrl = getTestEnvironment().get("intake_endpoint") + Visit.INTAKE_CREATE_OHIO_VISIT;
        String auth_username = getTestEnvironment().get("ohio_UserName");
        String auth_password = getTestEnvironment().get("ohio_Password");

        Map<String, String> header = new HashMap<>();
        header.put(ContentType.toString(), ApplicationJson.toString());
        header.put(Constant.HEADER.Account.toString(), accountId);

        Response response =  webServicesBase.sendPOSTRequest(requestUrl, header, json, auth_username, auth_password);
        if (response.getStatusCode() == 200) {
            logInfo(String.format("Create visit successfully. Memo: %s, account: %s, provider Id: %s",
                    visitGeneralEntity.VisitMemo, accountId, providerId));
        } else {
            logInfo(String.format("Create visit unsuccessfully. First name: %s, account: %s, provider Id: %s",
                    visitGeneralEntity.VisitMemo, accountId, providerId));
        }
        return response;
    }

    public boolean isVisitExistInDatabase(String accountId, String uniqueMemo) {
        String sql = String.format(SQL_GET_VISIT_BY_ACCOUNT_AND_UNIQUE_MEMO, accountId, uniqueMemo);
        return visitDbService.waitDataExistInDb(sql);
    }

    public String callCreateGenericVisit(String accountType, String username, String password, String account,
                                         VisitsConnecticutWithConfigurationModel visitInput, Environment environment) {
        String response = null;
        try {
            if(accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.CONNECTICUT))){
                response = preparePostRequestGenericVisitData(accountType, visitInput, username, password, account, environment);
            }
            Constant.exported = 1; // NO SONAR
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public String preparePostRequestGenericVisitData(String accountType, VisitsConnecticutWithConfigurationModel visitInput,
                                                     String username, String password, String account,
                                                     Environment environment) throws IOException {
        String url = environment.getDwh();
        Gson gson = new Gson();
        VisitsConnecticutWithConfigurationModel[] visitsWithConfigurationRequests = webServicesBase
                .toJsonModel("json/Connecticut/VisitsWithConfiguration.json", VisitsConnecticutWithConfigurationModel[].class);
        VisitsConnecticutWithConfigurationModel visitsWithConfigurationRequest = visitsWithConfigurationRequests[0];

        if(visitInput != null) {
            //Set provider providerIdentification
            visitsWithConfigurationRequest.setProviderIdentification(visitInput.getProviderIdentification());
            visitsWithConfigurationRequest.setVisitOtherID(visitInput.getVisitOtherID());
            visitsWithConfigurationRequest.setSequenceID(visitInput.getSequenceID());
            visitsWithConfigurationRequest.setEmployeeIdentifier(visitInput.getEmployeeIdentifier());
            visitsWithConfigurationRequest.setClientID(visitInput.getClientID());
            visitsWithConfigurationRequest.setMemo(visitInput.getMemo());

            visitsWithConfigurationRequest.setScheduleStartTime(visitInput.getScheduleStartTime());
            visitsWithConfigurationRequest.setScheduleEndTime(visitInput.getScheduleEndTime());
            visitsWithConfigurationRequest.setAdjInDateTime(visitInput.getAdjInDateTime());
            visitsWithConfigurationRequest.setAdjOutDateTime(visitInput.getAdjOutDateTime());

            List<Calls> calls = visitsWithConfigurationRequest.getCalls();
            calls.get(0).setCallDateTime(visitInput.getCalls().get(0).getCallDateTime());
            calls.get(1).setCallDateTime(visitInput.getCalls().get(1).getCallDateTime());
            visitsWithConfigurationRequest.setCalls(calls);

            List<VisitChanges> visitChangesList = visitsWithConfigurationRequest.getVisitChanges();
            visitChangesList.get(0).setChangeDateTime(visitInput.getVisitChanges().get(0).getChangeDateTime());
            visitsWithConfigurationRequest.setVisitChanges(visitChangesList);
        }

        return capturePostResponseEXPORTEVV(accountType, url, gson.toJson(visitsWithConfigurationRequest),username, password, account);
    }

    public VisitGenericEntity createOhioVisit(List<com.sandata.entity.ohio.visit.VisitGeneralEntity> visitGeneralEntities) {
        int retry1 = 10;

        String accountId = getTestEnvironment().get("ohio_accountId");
        String providerId = getTestEnvironment().get("ohio_providerId");

        com.sandata.entity.ohio.visit.VisitGeneralEntity visitGeneralEntity = null;

        while ( retry1 > 0 ) {
            int retry2 = 10;
            visitGeneralEntity = visitGeneralEntities.get(0);

            while (retry2 > 0) {
                callRequestToCreateOhioVisit(accountId, providerId, visitGeneralEntities);
                if(isVisitExistInDatabase(accountId, visitGeneralEntity.VisitMemo )) {
                    logInfo(String.format("Visit Ohio with unique memo '%s' existed in DB", visitGeneralEntity.VisitMemo));
                    return visitGeneralEntity;
                }
                logInfo(String.format("Visit Ohio with unique memo '%s' existed in DB. Retry %s to call same json",
                        visitGeneralEntity.VisitMemo, retry2));
                logInfo(String.format("Send to create visit Ohio:%n %s", new Gson().toJson(visitGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Visit Ohio with unique memo not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create visit Ohio with new Json:%n %s", new Gson().toJson(visitGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a new visit Ohio in %s time", retry1));
        return null;
    }

    public List<com.sandata.entity.ohio.visit.VisitGeneralEntity> createOhioVisits(List<com.sandata.entity.ohio.visit.VisitGeneralEntity> visitGeneralEntities) {
        int retry1 = 10;

        String accountId = getTestEnvironment().get("ohio_accountId");
        String providerId = getTestEnvironment().get("ohio_providerId");

        List<String> memos = new ArrayList<>();
        for (int i = 0; i <= visitGeneralEntities.size() - 1; i++) {
            memos.add(visitGeneralEntities.get(i).VisitMemo);
        }

        while ( retry1 > 0 ) {
            int retry2 = 10;

            while (retry2 > 0) {
                Response response = callRequestToCreateOhioVisit(accountId, providerId, visitGeneralEntities);
                if(visitDbService.areVisitMemosExistingInDatabase(accountId, memos)) {
                    logInfo(String.format("Visit Ohio with unique memos existed in DB"));
                    return visitGeneralEntities;
                }
                logInfo(String.format("Visit Ohio with unique memos not existed in DB. Retry %s to call same json", retry2));
                logInfo(String.format("Send to create visit Ohio:%n %s", new Gson().toJson(visitGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Visit Ohio with unique memo not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create visit Ohio with new Json:%n %s", new Gson().toJson(visitGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a new visit Ohio in %s time", retry1));
        return null;
    }
}
