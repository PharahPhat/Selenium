package com.sandata.ws;

import com.google.gson.Gson;
import com.sandata.common.Constant;
import com.sandata.common.resource.Client;
import com.sandata.core.config.Environment;
import com.sandata.core.ws.WebServicesBase;
import com.sandata.entity.connecticut.client.ClientConnecticutPhone;
import com.sandata.entity.connecticut.client.ClientConnecticutWithConfigurationModel;
import com.sandata.entity.connecticut.client.ConnecticutClientAddress;
import com.sandata.entity.exportDWH.*;
import com.sandata.entity.generic.ClientGenericEntity;
import com.sandata.entity.molina.client.ClientGeneralEntity;
import com.sandata.entity.ohio.client.PatientAdressEntity;
import com.sandata.entity.ohio.client.PatientGeneralEntity;
import com.sandata.entity.ohio.client.PatientPhonesEntity;
import com.sandata.entity.ohio.client.ResponsiblePartyModel;
import com.sandata.ws.dwh.DWHServices;
import io.restassured.response.Response;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sandata.common.Constant.CONTENT_TYPE.ApplicationJson;
import static com.sandata.common.Constant.HEADER.ContentType;
import static com.interop.sql.ClientSQL.SQL_GET_CLIENT_BY_LASTNAME;
import static com.interop.sql.ClientSQL.SQL_GET_CLIENT_ERROR_CODE_BY_LASTNAME;
import static io.restassured.RestAssured.given;

@SuppressWarnings({"squid:S1192","squid:S2696"})
public class ClientWebService extends DWHServices {
    private static final Logger LOGGER = Logger.getLogger(ClientWebService.class);
    private Response response;

    enum Account{
        MOLINA, OHIO, CONNECTICUT
    }

    public ClientWebService(){
        webServicesBase =  new WebServicesBase();
    }

    /**
     * Call the api create a client
     * @param accountType the name of account
     * @param environment the environment
     * @return the response data
     */
    public String callCreateClient(String accountType, String username, String password, String account, ClientMolinaModel clientInput, Environment environment) {
        String response = null;
        try {
            if(accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.MOLINA))){
                response = preparePostRequestClientData(accountType, clientInput, username, password, account, environment);
            } else if(accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.CONNECTICUT))){
                response = "";
            } else if(accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.OHIO))){

            }
            Constant.exported = 1; //NO SONAR
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
        return response;
    }

    public String preparePostRequestClientData(String accountType, ClientMolinaModel clientInput,
                                               String username, String password, String account,
                                               Environment environment) throws InterruptedException,  IOException {
        String url = environment.getDwh();
        Gson gson = new Gson();
        ClientMolinaModel[] clientWithConfigurationRequests = webServicesBase
                .toJsonModel("json/Molina/ClientWithConfiguration.json", ClientMolinaModel[].class);
        ClientMolinaModel clientWithConfigurationRequest = clientWithConfigurationRequests[0];

        //Set provider providerIdentification
        if(clientInput != null) {
            clientWithConfigurationRequest.setProviderIdentification(clientInput.getProviderIdentification());
            clientWithConfigurationRequest.setClientFirstName(clientInput.getClientFirstName());
            clientWithConfigurationRequest.setClientLastName(clientInput.getClientLastName());
            clientWithConfigurationRequest.setClientQualifier(clientInput.getClientQualifier());
            clientWithConfigurationRequest.setClientMedicaidID(clientInput.getClientMedicaidID());
            clientWithConfigurationRequest.setSequenceID(clientInput.getSequenceID());
            if(clientInput.getClientID() != null) clientWithConfigurationRequest.setClientID(clientInput.getClientID());
            if(clientInput.getClientSSN() != null) clientWithConfigurationRequest.setClientSSN(clientInput.getClientSSN());
            if(clientInput.getClientOtherID() != null) clientWithConfigurationRequest.setClientOtherID(clientInput.getClientOtherID());
            if(clientInput.getClientIdentifier() != null) clientWithConfigurationRequest.setClientIdentifier(clientInput.getClientIdentifier());
        }

        return capturePostResponseEXPORTEVV(accountType, url, gson.toJson(clientWithConfigurationRequest),username, password, account);
    }

    public String capturePostResponseEXPORTEVV(String accountType, String url, String modifyJson, String username, String password, String account){

        return sendClientRequest(accountType, url,
                username,
                password,
                account,
                modifyJson).asString();
    }

    public Response sendClientRequest(String accountType, String baseUrl, String username, String password, String account, String modifyJson){
        String postUrl = baseUrl + "/" + WebServicesConstants.CREATE_CLIENT_MOLINA_URL;
        if(accountType.equals(Constant.CONNECTICUT))
            postUrl = baseUrl + "/" + WebServicesConstants.CREATE_CLIENT_CONNECTICUT_URL;
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

    public ClientGenericEntity createClient(Constant.ACCOUNT_TYPE accountType, Constant.REQUEST_TYPE requestType) {
        ClientGenericEntity clientGenericEntity = null;

        switch (requestType) {
            case INTAKE:
                switch (accountType) {
                    case MOLINA:
                        clientGenericEntity = createMolinaClient();
                        break;
                    case OHIO:
                        clientGenericEntity = createOhioClient();
                        break;
                    case CONNECTICUT:
                        clientGenericEntity = createConnecticutClient();
                        break;
                    default:
                        break;
                }
                break;
            case HTTP_REQUEST:
                break;
            default:
                break;

        }
        return clientGenericEntity;
    }


    public ClientGenericEntity createClientByPatient(Constant.ACCOUNT_TYPE accountType,
                                                     Constant.REQUEST_TYPE requestType,
                                                     List<PatientGeneralEntity> patientList) {
        ClientGenericEntity clientGenericEntity = null;

        switch (requestType) {
            case INTAKE:
                switch (accountType) {
                    case MOLINA:
                        break;
                    case OHIO:
                        clientGenericEntity = createOhioClientByPatient(patientList);
                        break;
                    case CONNECTICUT:
                        break;
                    default:
                        break;
                }
                break;
            case HTTP_REQUEST:
                break;
            default:
                break;

        }
        return clientGenericEntity;
    }

    public ClientGenericEntity createClientByPatient(Constant.ACCOUNT_TYPE accountType,
                                                     Constant.REQUEST_TYPE requestType,
                                                     List<PatientGeneralEntity> patientList, int timeout1, int timeout2) {
        ClientGenericEntity clientGenericEntity = null;

        switch (requestType) {
            case INTAKE:
                switch (accountType) {
                    case MOLINA:
                        break;
                    case OHIO:
                        clientGenericEntity = createOhioClientByPatient(patientList,timeout1,timeout2);
                        break;
                    case CONNECTICUT:
                        break;
                    default:
                        break;
                }
                break;
            case HTTP_REQUEST:
                break;
            default:
                break;

        }
        return clientGenericEntity;
    }

    private List<ClientGeneralEntity> initializeClientMolinaData(String accountId, String providerId) {
        String clientId = clientDbService.generateNewClientId(accountId);
        String clientMedicaidID = commons.generateUniqueNumber();

        List<ClientGeneralEntity> clientGeneralEntities = new ArrayList<>();
        ClientGeneralEntity clientGeneralEntity = new ClientGeneralEntity();

        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.setProviderQualifier(Constant.ProviderQualifier.Other.toString());
        providerIdentification.setProviderID(providerId);

        clientGeneralEntity.ProviderIdentification = providerIdentification;
        clientGeneralEntity.ClientID = clientId;
        clientGeneralEntity.ClientFirstName = RandomStringUtils.randomAlphabetic(30);
        clientGeneralEntity.ClientMiddleInitial = "T";
        clientGeneralEntity.ClientLastName = RandomStringUtils.randomAlphabetic(30);
        clientGeneralEntity.PayerName = "ODM";
        clientGeneralEntity.ClientQualifier = Constant.ClientQualifier.ClientCustomID.toString();
        clientGeneralEntity.ClientIdentifier = clientMedicaidID;
        clientGeneralEntity.ClientCustomID = commons.generateUniqueNumber();
        clientGeneralEntity.ClientMedicaidID = clientMedicaidID;
        clientGeneralEntity.SequenceID = commons.generateUniqueNumber();
        clientGeneralEntity.ClientOtherID = commons.generateUniqueNumber();
        clientGeneralEntity.ClientSSN = clientDbService.generateNewClientSsn(accountId, clientId);
        clientGeneralEntity.ClientTimezone = commons.getDefaultTimezone();


        List<ClientAddress> clientAddresses = new ArrayList<>();
        ClientAddress clientAddress = new ClientAddress();
        clientAddress.ClientAddressType = "Home";
        clientAddress.ClientAddressIsPrimary = "true";
        clientAddress.ClientAddressLine1 = "36 West 5th Street";
        clientAddress.ClientAddressLine2 = "10th Floor";
        clientAddress.ClientCounty = "Kings";
        clientAddress.ClientCity = "Manhattan";
        clientAddress.ClientState = "NY";
        clientAddress.ClientZip = "10017";
        clientAddress.ClientAddressLongitude = "-73.4228741";
        clientAddress.ClientAddressLatitude = "40.7431032";
        clientAddresses.add(clientAddress);

        List<ClientPhone> clientPhones = new ArrayList<>();
        ClientPhone clientPhone1 = new ClientPhone();
        clientPhone1.ClientPhoneType = "Home";
        clientPhone1.ClientPhone = "2125551212";
        ClientPhone clientPhone2 = new ClientPhone();
        clientPhone2.ClientPhoneType = "Home";
        clientPhone2.ClientPhone = "2125551213";
        clientPhones.add(clientPhone1);
        clientPhones.add(clientPhone2);

        List<ClientPayerInformation> clientPayerInformations = new ArrayList<>();
        ClientPayerInformation clientPayerInformation = new ClientPayerInformation();
        String startTime = commons.getDateString(-10, "yyyy-MM-dd");
        String endTime = commons.getDateString(30, "yyyy-MM-dd");

        clientPayerInformation.PayerID = "MEDHHS";
        clientPayerInformation.PayerProgram = "29";
        clientPayerInformation.ProcedureCode = "29";
        clientPayerInformation.ClientEligibilityDateBegin = startTime;
        clientPayerInformation.ClientEligibilityDateEnd = endTime;
        clientPayerInformation.ClientStatus = "01";
        clientPayerInformations.add(clientPayerInformation);

        List<ClientResponsibleParty> clientResponsibleParties = new ArrayStack();
        ClientResponsibleParty clientResponsibleParty = new ClientResponsibleParty();
        clientResponsibleParty.ClientContactType = "Family";
        clientResponsibleParty.ClientContractFirstName = "David";
        clientResponsibleParty.ClientContactLastName = "Rutgos";
        clientResponsibleParty.ClientContactPhoneType = "Mobile";
        clientResponsibleParty.ClientContactPhone = "3478788467";
        clientResponsibleParty.ClientContactEmailAddress = "drutgos@com.dwh.sandata.com";
        clientResponsibleParty.ClientContactAddressLine1 = "2727 East 29th Street";
        clientResponsibleParty.ClientContactAddressLine2 = "Apt 8I";
        clientResponsibleParty.ClientContactCity = "Brooklyn";
        clientResponsibleParty.ClientContactState = "NY";
        clientResponsibleParty.ClientContactZip = "11229";
        clientResponsibleParties.add(clientResponsibleParty);

        clientGeneralEntity.ClientAddress = clientAddresses;
        clientGeneralEntity.ClientPhone = clientPhones;
        clientGeneralEntity.ClientPayerInformation = clientPayerInformations;
        clientGeneralEntity.ClientResponsibleParty = clientResponsibleParties;

        clientGeneralEntities.add(clientGeneralEntity);
        return clientGeneralEntities;
    }

    private List<PatientGeneralEntity> initializeClientOhioData(String accountId, String providerId) {
        List<PatientGeneralEntity> patientGeneralEntities = new ArrayList<>();
        PatientGeneralEntity patientGeneralEntity = new PatientGeneralEntity();

        patientGeneralEntity.BusinessEntityID = accountId;
        patientGeneralEntity.BusinessEntityMedicaidIdentifier = providerId;
        patientGeneralEntity.IsPatientNewborn = false;
        patientGeneralEntity.PatientAlternateID = "1114314";
        patientGeneralEntity.PatientFirstName = clientDbService.generateNewClientFName(accountId);
        patientGeneralEntity.PatientLastName = clientDbService.generateNewClientLName(accountId);
        patientGeneralEntity.PatientMedicaidID = clientDbService.generateNewPatientMedicaidID(accountId);
        patientGeneralEntity.PatientOtherID = clientDbService.generateNewPatientOtherID(accountId);
        patientGeneralEntity.PatientTimezone = commons.getDefaultTimezone();
        patientGeneralEntity.SequenceID = clientDbService.generateNewClientLSequenceNumber(accountId);

        List<ResponsiblePartyModel> responsibleParties = new ArrayList<>();
        ResponsiblePartyModel responsiblePartyModel = new ResponsiblePartyModel();
        responsiblePartyModel.PatientResponsiblePartyFirstName = "JStevee";
        responsiblePartyModel.PatientResponsiblePartyLastName = "KJobss";
        responsibleParties.add(responsiblePartyModel);
        patientGeneralEntity.ResponsibleParty = responsibleParties;

        List<IndividualPayerInformationModel> individualPayerInformationModels = new ArrayList<>();
        IndividualPayerInformationModel individualPayerInformationModel = new IndividualPayerInformationModel();
        individualPayerInformationModel.Payer = "DODD";
        individualPayerInformationModel.PayerProgram = "SPHH";
        individualPayerInformationModel.ProcedureCode = "T1000";
        individualPayerInformationModels.add(individualPayerInformationModel);
        patientGeneralEntity.IndividualPayerInformation = individualPayerInformationModels;

        List<PatientPhonesEntity> phones = new ArrayList<>();
        PatientPhonesEntity phone = new PatientPhonesEntity();
        phone.PatientPhoneNumber = "9431650001";
        phone.PatientPhoneType = "Home";
        phones.add(phone);
        patientGeneralEntity.Phones = phones;

        List<PatientAdressEntity> addresses = new ArrayList<>();
        PatientAdressEntity address1 = new PatientAdressEntity();
        address1.PatientAddressIsPrimary = false;
        address1.PatientAddressLine1 = "201 Harbour Drive Rd";
        address1.PatientAddressLine2 = "2nd Floor";
        address1.PatientAddressType = "School";
        address1.PatientCity = "Port Washington";
        address1.PatientLatitude = 88.1155122001;
        address1.PatientLongitude = 85.1155122001;
        address1.PatientState = "NY";
        address1.PatientTimezone = commons.getDefaultTimezone();
        address1.PatientZip = "55556";


        PatientAdressEntity address2 = new PatientAdressEntity();
        address2.PatientAddressIsPrimary = true;
        address2.PatientAddressLine1 = "36-20 Main Street";
        address2.PatientAddressLine2 = "1st Floor";
        address2.PatientAddressType = "Home";
        address2.PatientCity = "Flushing";
        address2.PatientLatitude = 88.1155122001;
        address2.PatientLongitude = 85.1155122001;
        address2.PatientState = "NY";
        address2.PatientTimezone = commons.getDefaultTimezone();
        address2.PatientZip = "55556";

        addresses.add(address1);
        addresses.add(address2);
        patientGeneralEntity.Address = addresses;

        patientGeneralEntities.add(patientGeneralEntity);
        return patientGeneralEntities;
    }

    private void RequestToCreateClientMessage(String accountId,
                                                    List<ClientGeneralEntity> clientGeneralEntities){
        String json = new Gson().toJson(clientGeneralEntities);
        ClientGeneralEntity clientGeneralEntity = clientGeneralEntities.get(0);

        String requestUrl = getTestEnvironment().get("intake_endpoint") + Client.INTAKE_CREATE_CLIENT;
        String auth_username = getTestEnvironment().get("molina_UserName");
        String auth_password = getTestEnvironment().get("molina_Password");

        Map<String, String> header = new HashMap<>();
        header.put(ContentType.toString(), ApplicationJson.toString());
        header.put(Constant.HEADER.Account.toString(), accountId);

        Response response =  webServicesBase.sendPOSTRequest(requestUrl, header, json, auth_username, auth_password);
        if (response.getStatusCode() == 200) {
            logInfo(String.format("Create Molina client successfully. Last name: %s, account: %s",
                    clientGeneralEntity.ClientLastName, accountId));
        } else {
            logInfo(String.format("Create Molina client unsuccessfully. Last name: %s, account: %s",
                    clientGeneralEntity.ClientLastName, accountId));
        }

    }

    private void callRequestToCreateClient(String accountId, String providerId,
                                             List<ClientGeneralEntity> clientGeneralEntities) {
        String json = new Gson().toJson(clientGeneralEntities);
        ClientGeneralEntity clientGeneralEntity = clientGeneralEntities.get(0);

        String requestUrl = getTestEnvironment().get("intake_endpoint") + Client.INTAKE_CREATE_CLIENT;
        String auth_username = getTestEnvironment().get("molina_UserName");
        String auth_password = getTestEnvironment().get("molina_Password");

        Map<String, String> header = new HashMap<>();
        header.put(ContentType.toString(), ApplicationJson.toString());
        header.put(Constant.HEADER.Account.toString(), accountId);

        Response response =  webServicesBase.sendPOSTRequest(requestUrl, header, json, auth_username, auth_password);

        if (response.getStatusCode() == 200) {
            logInfo(String.format("Create Molina client successfully. Last name: %s, account: %s, provider Id: %s",
                    clientGeneralEntity.ClientLastName, accountId, providerId));
        } else {
            logInfo(String.format("Create Molina client unsuccessfully. Last name: %s, account: %s, provider Id: %s",
                    clientGeneralEntity.ClientLastName, accountId, providerId));
        }
    }

    private ClientGenericEntity callRequestToCreateOhioClient(List<PatientGeneralEntity> patientGeneralEntities, int numberRetry) {
        int retry1 = 3;
        String accountId = getTestEnvironment().get("molina_accountId");
        String providerId = getTestEnvironment().get("molina_providerId");

        List<ClientGeneralEntity> clientGeneralEntities = null;
        ClientGeneralEntity clientGeneralEntity = null;

        while ( retry1 > 0 ) {
            int retry2 = 3;
            clientGeneralEntities = initializeClientMolinaData(accountId, providerId);
            clientGeneralEntity = clientGeneralEntities.get(0);

            while (retry2 > 0) {
                callRequestToCreateClient(accountId, providerId, clientGeneralEntities);
                if(isClientExistInDatabase(accountId, clientGeneralEntity.ClientLastName )) {
                    logInfo(String.format("Molina Client with L_NAME %s existed in DB", clientGeneralEntity.ClientLastName));
                    return clientGeneralEntity;
                }
                logInfo(String.format("Molina Client with L_NAME %s not existed in DB. Retry %s to call same json",
                        clientGeneralEntity.ClientLastName, retry2));
                logInfo(String.format("Send to create client:%n %s", new Gson().toJson(clientGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Molina Client with L_NAME %s not existed in DB even though request with same json in %s times", clientGeneralEntity.ClientLastName, retry2));
            logInfo(String.format("Molina Send request to create client with new Json:%n %s", new Gson().toJson(clientGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a new Molina client in %s time", retry1));
        return null;
    }

    private boolean callRequestToCreateOhioClient(String accountId, String providerId,
                                           List<PatientGeneralEntity> patientGeneralEntities) {
        String json = new Gson().toJson(patientGeneralEntities);
        PatientGeneralEntity patientGeneralEntity = patientGeneralEntities.get(0);

        String requestUrl = getTestEnvironment().get("intake_endpoint") + Client.INTAKE_CREATE_OHIO_CLIENT;
        String auth_username = getTestEnvironment().get("ohio_UserName");
        String auth_password = getTestEnvironment().get("ohio_Password");

        Map<String, String> header = new HashMap<>();
        header.put(ContentType.toString(), ApplicationJson.toString());
        header.put(Constant.HEADER.Account.toString(), accountId);

        response =  webServicesBase.sendPOSTRequest(requestUrl, header, json, auth_username, auth_password);
        if (response.getStatusCode() == 200) {
            logInfo(String.format("Create Ohio patient successfully. Last name: %s, account: %s, provider Id: %s",
                    patientGeneralEntity.PatientLastName, accountId, providerId));
            return true;
        } else {
            logInfo(String.format("Create Ohio patient unsuccessfully. Last name: %s, account: %s, provider Id: %s",
                    patientGeneralEntity.PatientLastName, accountId, providerId));
        }
        return false;
    }

    /***
     * summary: create new Molina client
     * @return
     */
    public ClientGenericEntity createMolinaClient() {
        int retry1 = 10;
        String accountId = getTestEnvironment().get("molina_accountId");
        String providerId = getTestEnvironment().get("molina_providerId");

        List<ClientGeneralEntity> clientGeneralEntities = null;
        ClientGeneralEntity clientGeneralEntity = null;

        while ( retry1 > 0 ) {
            int retry2 = 10;
            clientGeneralEntities = initializeClientMolinaData(accountId, providerId);
            clientGeneralEntity = clientGeneralEntities.get(0);

            while (retry2 > 0) {
                callRequestToCreateClient(accountId, providerId, clientGeneralEntities);
                if(isClientExistInDatabase(accountId, clientGeneralEntity.ClientLastName )) {
                    logInfo(String.format("Molina Client with L_NAME %s existed in DB", clientGeneralEntity.ClientLastName));
                    return clientGeneralEntity;
                }
                logInfo(String.format("Molina Client with L_NAME %s not existed in DB. Retry %s to call same json",
                        clientGeneralEntity.ClientLastName, retry2));
                logInfo(String.format("Send to create client:%n %s", new Gson().toJson(clientGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Molina Client with L_NAME %s not existed in DB even though request with same json in %s times", clientGeneralEntity.ClientLastName, retry2));
            logInfo(String.format("Molina Send request to create client with new Json:%n %s", new Gson().toJson(clientGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a new Molina client in %s time", retry1));
        return null;
    }

    public boolean CreateMolinaClientKeepClientList(List<ClientGeneralEntity> clientGeneralEntities) {
        String accountId = getTestEnvironment().get("molina_accountId");

        ClientGeneralEntity clientGeneralEntity = clientGeneralEntities.get(0);
        RequestToCreateClientMessage(accountId, clientGeneralEntities);

        // ErrorCode = -1053, that mean the same with "ErrorMessage": "Another client exists with the passed unique client identifier"
        if(isClientWithErrorCode1053(accountId, clientGeneralEntity.ClientLastName))
            return true;
        return false;
    }

    /***
     * summary: create new Ohio client
     * @return
     */
    public ClientGenericEntity createOhioClientByPatient(List<PatientGeneralEntity> patientGeneralEntities) {
        return createOhioClientByPatient(patientGeneralEntities,3,3);
    }

    public ClientGenericEntity createOhioClientByPatient(List<PatientGeneralEntity> patientGeneralEntities, int timeout1, int timeout2) {
        int retry1 = timeout1;
        String accountId = getTestEnvironment().get("ohio_accountId");
        String providerId = getTestEnvironment().get("ohio_providerId");

        PatientGeneralEntity patientGeneralEntity = patientGeneralEntities.get(0);

        while ( retry1 > 0 ) {
            int retry2 = timeout2;

            while (retry2 > 0) {
                callRequestToCreateOhioClient(accountId, providerId, patientGeneralEntities);
                if(isClientExistInDatabase(accountId, patientGeneralEntity.PatientLastName )) {
                    logInfo(String.format("Client with L_NAME %s existed in DB", patientGeneralEntity.PatientLastName));
                    return patientGeneralEntity;
                }
                logInfo(String.format("Client with L_NAME %s not existed in DB. Retry %s to call same json",
                        patientGeneralEntity.PatientLastName, retry2));
                logInfo(String.format("Send to create employee:%n %s", new Gson().toJson(patientGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Client with L_NAME not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create client with new Json:%n %s", new Gson().toJson(patientGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a new client in %s time", retry1));
        return null;
    }

    public List<PatientGeneralEntity> createOhioClients(List<PatientGeneralEntity> patientGeneralEntities, int timeout1, int timeout2) {
        int retry1 = timeout1;
        String accountId = getTestEnvironment().get("ohio_accountId");
        String providerId = getTestEnvironment().get("ohio_providerId");

        List<String> clientLastNames = new ArrayList<>();
        for (int i = 0; i <= patientGeneralEntities.size() - 1; i++) {
            clientLastNames.add(patientGeneralEntities.get(i).PatientLastName);
        }

        while ( retry1 > 0 ) {
            int retry2 = timeout2;

            while (retry2 > 0) {
                boolean result = callRequestToCreateOhioClient(accountId, providerId, patientGeneralEntities);
                if(clientDbService.areClientLastNameExistInDatabase(accountId, clientLastNames)) {
                    logInfo(String.format("All Clients existed in DB"));
                    return patientGeneralEntities;
                }
                logInfo(String.format("Clients not existed in DB. Retry %s to call same json", retry2));
                logInfo(String.format("Send to create client:%n %s", new Gson().toJson(patientGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Clients not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create client with new Json:%n %s", new Gson().toJson(patientGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a new client in %s time", retry1));
        return null;
    }

    public ClientGenericEntity createOhioClient() {
        int retry1 = 10;
        String accountId = getTestEnvironment().get("ohio_accountId");
        String providerId = getTestEnvironment().get("ohio_providerId");

        List<PatientGeneralEntity> patientGeneralEntities = null;
        PatientGeneralEntity patientGeneralEntity = null;

        while ( retry1 > 0 ) {
            int retry2 = 10;

            patientGeneralEntities = initializeClientOhioData(accountId, providerId);
            patientGeneralEntity = patientGeneralEntities.get(0);

            while (retry2 > 0) {
                callRequestToCreateOhioClient(accountId, providerId, patientGeneralEntities);
                if(isClientExistInDatabase(accountId, patientGeneralEntity.PatientLastName )) {
                    logInfo(String.format("Client with L_NAME %s existed in DB", patientGeneralEntity.PatientLastName));
                    return patientGeneralEntity;
                }
                logInfo(String.format("Client with L_NAME %s not existed in DB. Retry %s to call same json",
                        patientGeneralEntity.PatientLastName, retry2));
                logInfo(String.format("Send to create employee:%n %s", new Gson().toJson(patientGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Client with L_NAME not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create client with new Json:%n %s", new Gson().toJson(patientGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a new client in %s time", retry1));
        return null;
    }

    /***
     * summary: create new Connecticut client
     * @return
     */
    public ClientGenericEntity createConnecticutClient() {
        ClientGeneralEntity clientGeneralEntity = null;
        //TODO: to be implemented
        return clientGeneralEntity;
    }

    public String callCreateConnecticutClient(String accountType, String username, String password, String account, ClientConnecticutWithConfigurationModel clientInput, Environment environment) {
        String response = null;
        try {
            if(accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.CONNECTICUT))){
                response = preparePostRequestConnecticutClientData(accountType, clientInput, username, password, account, environment);
            }
            Constant.exported = 1; // NO SONAR
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public String preparePostRequestConnecticutClientData(String accountType, ClientConnecticutWithConfigurationModel clientInput,
                                                          String username, String password, String account,
                                                          Environment environment) throws IOException {
        String url = environment.getDwh();
        Gson gson = new Gson();
        ClientConnecticutWithConfigurationModel[] clientWithConfigurationRequests = webServicesBase
                .toJsonModel("json/Connecticut/ClientWithConfiguration.json", ClientConnecticutWithConfigurationModel[].class);
        ClientConnecticutWithConfigurationModel clientRequest = clientWithConfigurationRequests[0];

        //Set provider providerIdentification
        if(clientInput != null) {
            clientRequest.setClientID(clientInput.getClientID());
            clientRequest.setClientLastName(clientInput.getClientLastName());
            clientRequest.setClientFirstName(clientInput.getClientFirstName());
            clientRequest.setClientSSN(clientInput.getClientSSN());
            clientRequest.setClientMedicaidID(clientInput.getClientMedicaidID());
            clientRequest.setClientEmailAddress(clientInput.getClientEmailAddress());

            List<ConnecticutClientAddress> clientAddresses = clientRequest.getClientAddress();
            clientAddresses.get(0).setClientID(clientInput.getClientAddress().get(0).getClientID());
            clientRequest.setClientAddress(clientAddresses);

            List<ClientConnecticutPhone> clientPhones = clientRequest.getClientPhone();
            clientPhones.get(0).setClientID(clientInput.getClientPhone().get(0).getClientID());
            clientRequest.setClientPhone(clientPhones);
        }

        return capturePostResponseEXPORTEVV(accountType, url, gson.toJson(clientRequest),username, password, account);
    }

    public boolean isClientExistInDatabase(String accountId, String uniqueLastName) {
        String sql = String.format(SQL_GET_CLIENT_BY_LASTNAME, accountId, uniqueLastName);
        return clientDbService.waitDataExistInDb(sql);
    }

    public boolean isClientWithErrorCode1053(String accountId, String uniqueLastName) {
        String sql = String.format(SQL_GET_CLIENT_ERROR_CODE_BY_LASTNAME, accountId, uniqueLastName);
        return clientDbService.waitDataExistInDb(sql);
    }

    public Response getResponse() {
        return response;
    }
}
