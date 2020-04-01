package com.sandata.ws;

import com.google.gson.Gson;
import com.sandata.common.Constant;
import com.sandata.common.resource.Employee;
import com.sandata.core.config.Environment;
import com.sandata.core.config.TestData;
import com.sandata.core.ws.WebServicesBase;
import com.sandata.entity.connecticut.employee.EmployeeConnecticutWithConfigurationModel;
import com.sandata.entity.molina.employee.EmployeeGeneralEntity;
import com.sandata.entity.exportDWH.ProviderIdentification;
import com.sandata.entity.generic.EmployeeGenericEntity;
import com.sandata.entity.ohio.employee.WorkerGeneralEntity;
import com.sandata.ws.dwh.DWHServices;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.sandata.common.Constant.CONTENT_TYPE.ApplicationJson;
import static com.sandata.common.Constant.HEADER.ContentType;
import static io.restassured.RestAssured.given;

@SuppressWarnings({"squid:S1192","squid:S2696"})
public class EmployeeWebService extends DWHServices {

    @SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(EmployeeWebService.class);

    enum Account{
        MOLINA, OHIO, CONNECTICUT
    }
    public EmployeeWebService(){
        webServicesBase =  new WebServicesBase();
    }

    public String callCreateEmployee(String accountType, String username, String password, String account,
                                     EmployeeGeneralEntity employeeInput, Environment environment) {
        String response = null;
        try {
            if(accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.MOLINA))){
                response = PreparePostRequestEmployeeData(accountType, employeeInput, username, password, account, environment);
            } else if(accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.CONNECTICUT)) || accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.OHIO))){
                //TODO: will implement when apply for another client
                response = "";
            }
            Constant.exported = 1; //NO SONAR
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
        return response;
    }

    public String PreparePostRequestEmployeeData(String accountType, EmployeeGeneralEntity employeeInput,
                                               String username, String password, String account,
                                               Environment environment) throws InterruptedException,  IOException {
        String url = environment.getDwh();
        Gson gson = new Gson();
        EmployeeGeneralEntity[] employeeWithConfigurationRequests = webServicesBase
                .toJsonModel("json/Molina/EmployeeWithConfiguration.json", EmployeeGeneralEntity[].class);
        EmployeeGeneralEntity employeeWithConfigurationRequest = employeeWithConfigurationRequests[0];

        if(employeeInput != null) {
            //Set provider providerIdentification
            employeeWithConfigurationRequest.setEmployeeFirstName(employeeInput.getEmployeeFirstName());
            employeeWithConfigurationRequest.setEmployeeLastName(employeeInput.getEmployeeLastName());
            if(employeeInput.getProviderIdentification() != null)
                employeeWithConfigurationRequest.setProviderIdentification(employeeInput.getProviderIdentification());
            if(employeeInput.getEmployeeIdentifier() != null)
                employeeWithConfigurationRequest.setEmployeeIdentifier(employeeInput.getEmployeeIdentifier());
            if(employeeInput.getEmployeeOtherID() != null)
                employeeWithConfigurationRequest.setEmployeeOtherID(employeeInput.getEmployeeOtherID());
            if(employeeInput.getSequenceID() != null)
                employeeWithConfigurationRequest.setSequenceID(employeeInput.getSequenceID());
            if(employeeInput.getEmployeeSSN() != null) employeeWithConfigurationRequest.setEmployeeSSN(employeeInput.getEmployeeSSN());
            if(employeeInput.getEmployeeQualifier() != null) employeeWithConfigurationRequest.setEmployeeQualifier(employeeInput.getEmployeeQualifier());
        }

        return capturePostResponseEXPORTEVV(accountType, url, gson.toJson(employeeWithConfigurationRequest),username, password, account);
    }

    public String capturePostResponseEXPORTEVV(String accountType, String url, String modifyJson, String username, String password, String account){

        return sendEmployeeRequest(accountType, url,
                username,
                password,
                account,
                modifyJson).asString();
    }

    public Response sendEmployeeRequest(String accountType, String baseUrl, String username, String password, String account, String modifyJson){
        String postUrl = baseUrl + "/" + WebServicesConstants.CREATE_EMPLOYEE_MOLINA_URL;
        if(accountType.equals(Constant.CONNECTICUT))
            postUrl = baseUrl + "/" + WebServicesConstants.CREATE_EMPLOYEE_CONNECTICUT_URL;
        Response response = given().
                relaxedHTTPSValidation().
                body("[" + modifyJson + "]").header("Content-Type","application/json").
                auth().preemptive().
                basic(username, password).
                header("Account", account).log().all().
                when().post(postUrl).
                then().assertThat().statusCode(200).and().extract().response();
        LOGGER.info("response request " + response.body().asString());

        return response;
    }


    public Response sendPOSTEmployeeEVV(String requestUrl, JSONArray altEVVJsonArray, Environment environment, TestData testData){
        String openEvvUser = environment.getMolina_UserName();
        String openEvvPass = environment.getMolina_Password();
        String acc = testData.getValue("Acc");
        String accountId = testData.getValue("AccId");
        Response response = given().
                relaxedHTTPSValidation().
                body(altEVVJsonArray.toJSONString()).header("Content-Type","application/json").
                auth().preemptive().
                basic(openEvvUser, openEvvPass).
                header(acc, accountId).log().all().
                when().post(requestUrl).
                then().assertThat().statusCode(200).and().extract().response();

        return response;
    }

    public Response sendPOSTEmployeeAtlEVV(String requestUrl, JSONArray altEVVJsonArray, Environment environment, TestData testData, String accountId){
        String altEvvUser = environment.getAlt_evv_user();
        String altEvvPass = environment.getAlt_evv_pass();
        String acc = testData.getValue("Acc");
        Response response = given().
                relaxedHTTPSValidation().
                body(altEVVJsonArray.toJSONString()).header("Content-Type","application/json").
                auth().preemptive().
                basic(altEvvUser, altEvvPass).
                header(acc, accountId).log().all().
                when().post(requestUrl).
                then().assertThat().statusCode(200).and().extract().response();
        return response;
    }

    public EmployeeGenericEntity createEmployee(Constant.ACCOUNT_TYPE accountType, Constant.REQUEST_TYPE requestType) {
        EmployeeGenericEntity employeeGenericEntity = null;

        switch (requestType) {
            case INTAKE:
                switch (accountType) {
                    case MOLINA:
                        employeeGenericEntity = createMolinaEmployee();
                        break;
                    case OHIO:
                        employeeGenericEntity = createOhioEmployee();
                        break;
                    case CONNECTICUT:
                        employeeGenericEntity = createConnecticutEmployee();
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
        return employeeGenericEntity;
    }

    public EmployeeGenericEntity createEmployeeByStaffInfo(Constant.ACCOUNT_TYPE accountType, Constant.REQUEST_TYPE requestType,
                                                           List<WorkerGeneralEntity> listStaff) {
        EmployeeGenericEntity employeeGenericEntity = null;

        switch (requestType) {
            case INTAKE:
                switch (accountType) {
                    case MOLINA:
                        break;
                    case OHIO:
                        employeeGenericEntity = createOhioEmployeeByStaffInfo(listStaff);
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
        return employeeGenericEntity;
    }


    public EmployeeGenericEntity createMolinaEmployee() {
        int retry1 = 10;
        String accountId = getTestEnvironment().get("molina_accountId");
        String providerId = getTestEnvironment().get("molina_providerId");

        List<EmployeeGeneralEntity> employeeGeneralEntities = null;
        EmployeeGeneralEntity employeeGeneralEntity = null;

        while ( retry1 > 0 ) {
            int retry2 = 10;
            employeeGeneralEntities = initializeEmployeeMolinaData(accountId, providerId);
            employeeGeneralEntity = employeeGeneralEntities.get(0);

            while (retry2 > 0) {
                callRequestToCreateEmployee(accountId, providerId, employeeGeneralEntities);
                if(employeeDbService.isEmployeeExistInDatabase(accountId, employeeGeneralEntity.EmployeeLastName )) {
                    logInfo(String.format("Worker/employee with L_NAME %s existed in DB", employeeGeneralEntity.EmployeeLastName));
                    return employeeGeneralEntity;
                }
                logInfo(String.format("Worker/employee with L_NAME %s not existed in DB. Retry %s to call same json",
                        employeeGeneralEntity.EmployeeLastName, retry2));
                logInfo(String.format("Send to create employee:%n %s", new Gson().toJson(employeeGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Worker/employee with L_NAME not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create employee with new Json:%n %s", new Gson().toJson(employeeGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a new employee in %s time", retry1));
        return null;
    }

    private List<EmployeeGeneralEntity> initializeEmployeeMolinaData(String accountId, String providerId) {

        String ssn = employeeDbService.generateNewEmployeeSsn(accountId);
        String lastname = "stxLN" + RandomStringUtils.randomAlphabetic(20);
        String firstname = "stxFN" + RandomStringUtils.randomAlphabetic(20);
        String uniqueNum = commons.generateUniqueNumber();
        String email = "stx" + uniqueNum + "@com.dwh.sandata.com";
        String managerEmail = "stxmanager" + uniqueNum + "@com.dwh.sandata.com";
        String employeeOtherID = "stx" + commons.generateUniqueNumber();

        List<EmployeeGeneralEntity> employeeGeneralEntities = new ArrayList<>();
        EmployeeGeneralEntity employeeGeneralEntity = new EmployeeGeneralEntity();

        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.setProviderQualifier(Constant.ProviderQualifier.Other.toString());
        providerIdentification.setProviderID(providerId);

        employeeGeneralEntity.setProviderIdentification(providerIdentification);
        employeeGeneralEntity.setEmployeeQualifier(Constant.EmployeeQualifier.EmployeeSSN.toString());
        employeeGeneralEntity.setEmployeeIdentifier(ssn);
        employeeGeneralEntity.setEmployeeSSN(ssn);
        employeeGeneralEntity.setEmployeeOtherID(employeeOtherID);
        employeeGeneralEntity.setSequenceID(uniqueNum);
        employeeGeneralEntity.setEmployeeFirstName(firstname);
        employeeGeneralEntity.setEmployeeLastName(lastname);
        employeeGeneralEntity.setEmployeeEmail(email);
        employeeGeneralEntity.setEmployeeManagerEmail(managerEmail);
        employeeGeneralEntity.setEmployeePosition("HHA");
        employeeGeneralEntity.setEmployeeAPI(uniqueNum);

        employeeGeneralEntities.add(employeeGeneralEntity);

        return employeeGeneralEntities;
    }

    private List<WorkerGeneralEntity> initializeEmployeeOhioData(String accountId, String providerId) {
        String uniqueNum = commons.generateUniqueNumber();
        String email = "stx" + uniqueNum + "@com.dwh.sandata.com";


        List<WorkerGeneralEntity> workerGeneralEntities = new ArrayList<>();
        WorkerGeneralEntity workerGeneralEntity = new WorkerGeneralEntity();
        workerGeneralEntity.BusinessEntityID = accountId;
        workerGeneralEntity.BusinessEntityMedicaidIdentifier = providerId;
        workerGeneralEntity.StaffOtherID = employeeDbService.generateNewEmployeeIdCustom1(accountId);
        workerGeneralEntity.SequenceID = employeeDbService.generateNewEmployeeSequenceNumber(accountId);
        workerGeneralEntity.StaffID = employeeDbService.generateNewEmployeeStxId(accountId);
        workerGeneralEntity.StaffSSN = employeeDbService.generateNewEmployeeSsn(accountId);
        workerGeneralEntity.StaffLastName = employeeDbService.generateNewEmployeeLName(accountId);
        workerGeneralEntity.StaffFirstName = employeeDbService.generateNewEmployeeFName(accountId);
        workerGeneralEntity.StaffEmail = email;
        workerGeneralEntity.StaffPosition = "LPN";

        workerGeneralEntities.add(workerGeneralEntity);
        return workerGeneralEntities;
    }

    private void callRequestToCreateEmployee(String accountId, String providerId,
                                             List<EmployeeGeneralEntity> employeeGeneralEntities) {
        String json = new Gson().toJson(employeeGeneralEntities);
        EmployeeGeneralEntity employeeGeneralEntity = employeeGeneralEntities.get(0);

        String requestUrl = getTestEnvironment().get("intake_endpoint") + Employee.INTAKE_CREATE_EMPLOYEE;
        String auth_username = getTestEnvironment().get("molina_UserName");
        String auth_password = getTestEnvironment().get("molina_Password");

        Map<String, String> header = new HashMap<>();
        header.put(ContentType.toString(), ApplicationJson.toString());
        header.put(Constant.HEADER.Account.toString(), accountId);

        Response response =  webServicesBase.sendPOSTRequest(requestUrl, header, json, auth_username, auth_password);
        if (response.getStatusCode() == 200) {
            logInfo(String.format("Create employee successfully. First name: %s, account: %s, provider Id: %s",
                    employeeGeneralEntity.getEmployeeFirstName(), accountId, providerId));
        } else {
            logInfo(String.format("Create employee unsuccessfully. First name: %s, account: %s, provider Id: %s",
                    employeeGeneralEntity.getEmployeeFirstName(), accountId, providerId));
        }
    }

    private boolean callRequestToCreateOhioEmployee(String accountId, String providerId,
                                             List<WorkerGeneralEntity> workerGeneralEntities) {
        String json = new Gson().toJson(workerGeneralEntities);
        WorkerGeneralEntity workerGeneralEntity = workerGeneralEntities.get(0);

        String requestUrl = getTestEnvironment().get("intake_endpoint") + Employee.INTAKE_CREATE_OHIO_EMPLOYEE;
        String auth_username = getTestEnvironment().get("ohio_UserName");
        String auth_password = getTestEnvironment().get("ohio_Password");

        Map<String, String> header = new HashMap<>();
        header.put(ContentType.toString(), ApplicationJson.toString());
        header.put(Constant.HEADER.Account.toString(), accountId);

        Response response =  webServicesBase.sendPOSTRequest(requestUrl, header, json, auth_username, auth_password);
        if (response.getStatusCode() == 200) {
            logInfo(String.format("Create ohio employee successfully. First name: %s, account: %s, provider Id: %s",
                    workerGeneralEntity.StaffFirstName, accountId, providerId));
            return true;
        } else {
            logInfo(String.format("Create ohio employee unsuccessfully. First name: %s, account: %s, provider Id: %s",
                    workerGeneralEntity.StaffFirstName, accountId, providerId));
        }
        return false;
    }

    public EmployeeGenericEntity createOhioEmployeeByStaffInfo(List<WorkerGeneralEntity> workerGeneralEntities) {
        int retry1 = 10;

        String accountId = getTestEnvironment().get("ohio_accountId");
        String providerId = getTestEnvironment().get("ohio_providerId");

        WorkerGeneralEntity workerGeneralEntity = null;
        String ssn = "";

        while ( retry1 > 0 ) {
            int retry2 = 10;
            if(retry1 == 10){
                workerGeneralEntity = workerGeneralEntities.get(0);
                ssn = workerGeneralEntity.getStaffSSN();
            }
            else{
                workerGeneralEntities = initializeEmployeeOhioData(accountId, providerId);
                workerGeneralEntity = workerGeneralEntities.get(0);
                workerGeneralEntity.setStaffSSN(ssn);
            }

            while (retry2 > 0) {
                callRequestToCreateOhioEmployee(accountId, providerId, workerGeneralEntities);
                if(employeeDbService.isEmployeeExistInDatabase(accountId, workerGeneralEntity.StaffLastName )) {
                    logInfo(String.format("Ohio Worker/employee with L_NAME %s existed in DB", workerGeneralEntity.StaffLastName));
                    return workerGeneralEntity;
                }
                logInfo(String.format("Ohio Worker/employee with L_NAME %s not existed in DB. Retry %s to call same json",
                        workerGeneralEntity.StaffLastName, retry2));
                logInfo(String.format("Send to create employee:%n %s", new Gson().toJson(workerGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Ohio Worker/employee with L_NAME not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create Ohio employee with new Json:%n %s", new Gson().toJson(workerGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a Ohio new employee in %s time", retry1));
        return null;
    }

    public List<WorkerGeneralEntity> createOhioWorkers(List<WorkerGeneralEntity> workerGeneralEntities) {
        int retry1 = 10;

        String accountId = getTestEnvironment().get("ohio_accountId");
        String providerId = getTestEnvironment().get("ohio_providerId");

        List<String> workerLastNames = new ArrayList<>();
        for (int i = 0; i <= workerGeneralEntities.size() - 1; i++) {
            workerLastNames.add(workerGeneralEntities.get(i).StaffLastName);
        }

        while ( retry1 > 0 ) {
            int retry2 = 10;

            while (retry2 > 0) {
                if(employeeDbService.isEmployeesExistInDatabase(accountId, workerLastNames)) {
                    logInfo("Ohio Workers/employees existed in DB");
                    return workerGeneralEntities;
                }
                logInfo(String.format("Ohio Workers/employees not existed in DB. Retry %s to call same json", retry2));
                logInfo(String.format("Send to create employee:%n %s", new Gson().toJson(workerGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Ohio Workers/employees with L_NAME not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create Ohio employees with new Json:%n %s", new Gson().toJson(workerGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a Ohio new employees in %s time", retry1));
        return null;
    }

    public EmployeeGenericEntity createOhioEmployee() {
        int retry1 = 10;

        String accountId = getTestEnvironment().get("ohio_accountId");
        String providerId = getTestEnvironment().get("ohio_providerId");

        List<WorkerGeneralEntity> workerGeneralEntities = null;
        WorkerGeneralEntity workerGeneralEntity = null;

        while ( retry1 > 0 ) {
            int retry2 = 10;
            workerGeneralEntities = initializeEmployeeOhioData(accountId, providerId);
            workerGeneralEntity = workerGeneralEntities.get(0);

            while (retry2 > 0) {
                callRequestToCreateOhioEmployee(accountId, providerId, workerGeneralEntities);
                if(employeeDbService.isEmployeeExistInDatabase(accountId, workerGeneralEntity.StaffLastName )) {
                    logInfo(String.format("Ohio Worker/employee with L_NAME %s existed in DB", workerGeneralEntity.StaffLastName));
                    return workerGeneralEntity;
                }
                logInfo(String.format("Ohio Worker/employee with L_NAME %s not existed in DB. Retry %s to call same json",
                        workerGeneralEntity.StaffLastName, retry2));
                logInfo(String.format("Send to create employee:%n %s", new Gson().toJson(workerGeneralEntities)));
                retry2--;
            }
            logInfo(String.format("Ohio Worker/employee with L_NAME not existed in DB even though request with same json in %s times", retry2));
            logInfo(String.format("Send to create Ohio employee with new Json:%n %s", new Gson().toJson(workerGeneralEntities)));
            retry1--;
        }
        logError(String.format("Cannot create a Ohio new employee in %s time", retry1));
        return null;
    }

    public EmployeeGenericEntity createConnecticutEmployee() {
        EmployeeGenericEntity employeeGenericEntity = null;
        return  employeeGenericEntity;
    }

    public String callCreateConnecticutEmployee(String accountType, String username, String password, String account,
                                                EmployeeConnecticutWithConfigurationModel employeeInput, Environment environment) {
        String response = null;
        try {
            if(accountType.equals(String.valueOf(Constant.ACCOUNT_TYPE.CONNECTICUT))){
                response = PreparePostRequestConnecticutEmployeeData(accountType, employeeInput, username, password, account, environment);
            }
            Constant.exported = 1; //NO SONAR
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public String PreparePostRequestConnecticutEmployeeData(String accountType, EmployeeConnecticutWithConfigurationModel employeeInput,
                                                            String username, String password, String account,
                                                            Environment environment) throws IOException {
        String url = environment.getDwh();
        Gson gson = new Gson();
        EmployeeConnecticutWithConfigurationModel[] employeeWithConfigurationRequests = webServicesBase
                .toJsonModel("json/Connecticut/EmployeeWithConfiguration.json", EmployeeConnecticutWithConfigurationModel[].class);
        EmployeeConnecticutWithConfigurationModel employeeWithConfigurationRequest = employeeWithConfigurationRequests[0];

        if(employeeInput != null) {
            //Set provider providerIdentification
            employeeWithConfigurationRequest.setEmployeeFirstName(employeeInput.getEmployeeFirstName());
            employeeWithConfigurationRequest.setEmployeeLastName(employeeInput.getEmployeeLastName());
            employeeWithConfigurationRequest.setEmployeePIN(employeeInput.getEmployeePIN());
            employeeWithConfigurationRequest.setEmployeeID(employeeInput.getEmployeeID());
            employeeWithConfigurationRequest.setEmployeeIDCustom1(employeeInput.getEmployeeIDCustom1());
            employeeWithConfigurationRequest.setEmployeeIDCustom2(employeeInput.getEmployeeIDCustom2());
            employeeWithConfigurationRequest.setEmployeeSocialSecurity(employeeInput.getEmployeeSocialSecurity());
            employeeWithConfigurationRequest.setEmployeeEmailAddress(employeeInput.getEmployeeEmailAddress());
        }

        return capturePostResponseEXPORTEVV(accountType, url, gson.toJson(employeeWithConfigurationRequest),username, password, account);
    }

    public void verifyCreateOhioEmployeeByStaffInfo(List<WorkerGeneralEntity> workerGeneralEntities) {
        String accountId = getTestEnvironment().get("ohio_accountId");
        String providerId = getTestEnvironment().get("ohio_providerId");

        WorkerGeneralEntity workerGeneralEntity = null;

        workerGeneralEntity = workerGeneralEntities.get(0);

        callRequestToCreateOhioEmployee(accountId, providerId, workerGeneralEntities);
        Assert.assertTrue(!employeeDbService.isEmployeeExistInDatabase(accountId, workerGeneralEntity.StaffLastName ),
                "Staff should not be inserted in db");
    }
}
