package generic;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.JsonPath;
import com.interop.common.TestDataHelper;
import com.sandata.common.resource.Visit;
import com.sandata.core.report.ExtentTestManager;
import com.sandata.entity.claim.ClaimValidationV2;
import com.sandata.entity.claim.EVV_Request;
import com.sandata.entity.connecticut.authorization.AuthorizationEntity;
import com.sandata.entity.molina.visit.VisitException;
import com.sandata.entity.ohio.client.PatientGeneralEntity;
import com.sandata.entity.ohio.employee.WorkerGeneralEntity;
import com.sandata.entity.ohio.exports.Individual;
import com.sandata.entity.ohio.exports.PatientPayerInformation;
import com.sandata.entity.ohio.visit.ClaimStackRequests;
import com.sandata.models.molina.employee.CreateEmployee;
import com.sandata.models.molina.visit.*;
import com.sandata.models.vm.UpdateInformation;
import com.sandata.models.vm.visit.schedule.V8WebCreateSchedule;
import com.sandata.models.vm.visit.search.VisitSearchResultModel;
import com.sandata.utilities.DbUtilsCon;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.sandata.common.Constant.*;
import static com.interop.sql.EmployeeSQL.*;
import static com.interop.sql.Sql.SQL_GET_VISIT_KEY_BY_MEMO;
import static com.interop.sql.VisitLogSQL.*;
import com.interop.sql.VisitSQL;

public class V8VisitGenericTest extends VisitGenericTest {

    /**
     * Login V8 UI
     * @param accountType
     */
    public void loginV8(String accountType) {
        Response response = null;
        String requestUrl = baseObj.getEnvironment("v8_login_post");
        String accountId = "";
        String username = "";
        String password = "";

        if(accountType.equalsIgnoreCase(MOLINA)) {
            accountId = baseObj.getEnvironment("molina_accountId");
            username = baseObj.getEnvironment("vm_molina_username");
            password = baseObj.getEnvironment("vm_molina_password");
        } else if (accountType.equalsIgnoreCase(OHIO)) {

            accountId = baseObj.getEnvironment("ohio_accountId");
            username = baseObj.getEnvironment("vm_ohio_username");
            password = baseObj.getEnvironment("vm_ohio_password");

        } else if(accountType.equalsIgnoreCase(CONNECTICUT)) {
            accountId = baseObj.getEnvironment("connecticut_accountId");
            username = baseObj.getEnvironment("vm_connecticut_username");
            password = baseObj.getEnvironment("vm_connecticut_password");
        }

        loginResponse = v8WebService.login(requestUrl, accountId, username, password);

        if (loginResponse.getStatusCode() == 200) {
            logPass(String.format("Login successfully.\nurl:%s\n%s accountId:%s\nusername:%s\npassword:\n", requestUrl,
                    accountType, accountId, username, password));
        } else {
            logError(String.format("Login failed.\nurl:%s\nmolina_accountId:%s\nusername:%s\npassword:\n", requestUrl,
                    accountType, accountId, username, password));
        }
    }

    /**
     * Search visit with credentials
     * @param searchVisit
     * @return
     */
    public Response searchVisit(SearchVisit searchVisit) {
        searchResponse = v8WebService.searchVisit(baseObj.getEnvironment("v8_search_post"), searchVisit);
        if (searchResponse.getStatusCode() == 200) {
            logPass(String.format("Search successfully.\n Search Credential: %s",
                    searchVisit.toString()));
        } else {
            logError(String.format("Failed Searching.\n Search Credential: %s. Status: %s",
                    searchVisit.toString(), searchResponse.getStatusCode()));
        }
        return searchResponse;
    }

    /**
     * Search visit with credentials
     * @return
     */
    public Response searchVisit() {
        SearchVisit searchVisit = new SearchVisit();
        searchVisit.setVisitsFromDate(baseObj.readDataValue("VisitStartDate"));
        searchVisit.setVisitsToDate(baseObj.readDataValue("VisitEndDate"));

        searchResponse = v8WebService.searchVisit(baseObj.getEnvironment("v8_search_post"), searchVisit);
        if (searchResponse.getStatusCode() == 200) {
            logPass(String.format("Search successfully.\n Search Credential: %s",
                    searchVisit.toString()));
        } else {
            logError(String.format("Searching failed.\n Search Credential: %s. Status: %s",
                    searchVisit.toString(), searchResponse.getStatusCode()));
        }
        return searchResponse;
    }

    public Response searchVisitUI() {
        SearchVisit searchVisit = new SearchVisit();
        String visitStartDate = commons.getDateString(-15, "M/dd/yyyy");
        String visitEndDate = commons.getDateString(0, "M/dd/yyyy");
        searchVisit.setVisitsFromDate(visitStartDate);
        searchVisit.setVisitsToDate(visitEndDate);
        searchVisit.setClient(clientGeneralEntity.ClientLastName + ", " + clientGeneralEntity.ClientFirstName);

        searchResponse = v8WebService.searchVisit(baseObj.getEnvironment("v8_search_post"), searchVisit);
        if (searchResponse.getStatusCode() == 200) {
            logPass(String.format("Search successfully.\n Search Credential: %s", searchVisit.toString()));
        } else {
            logError(String.format("Searching failed.\n Search Credential: %s. Status: %s", searchVisit.toString(), searchResponse.getStatusCode()));
        }
        return searchResponse;
    }

    protected Response searchVisitWithClientMedicalIdAndEmployeeLastName() {
        SearchVisit searchVisit = new SearchVisit();
        searchVisit.setVisitsFromDate(baseObj.readDataValue("VisitStartDate"));
        searchVisit.setVisitsToDate(baseObj.readDataValue("VisitEndDate"));
        searchVisit.setMedicaidId(baseObj.readDataValue("ClientMedicalId"));
        searchVisit.setEmployee(baseObj.readDataValue("EmployeeLastName"));
        return searchVisit(searchVisit);
    }

    /**
     * Get Update Id of a visit
     * @param visitKey
     * @return
     */
    public String getUpdateId(String visitKey) {
        String path = "$.rows[?(@.VisitKey=='" + visitKey + "')].UpdateId";
        logStepInfo("Using json path " + path + "to extract update Id from Json:\n" + searchResponse.body().asString());
        List<String> updateId = JsonPath.read(searchResponse.body().asString(), path);
        return updateId.size() > 0 ? String.valueOf(updateId.get(0)) : null;
    }

    public String getVisitKeyByUniqueEmployeeFirstName(String uniqueFirstName) {
        VisitSearchResultModel visitSearchResultModel = new Gson().fromJson(searchResponse.body().asString(), VisitSearchResultModel.class);
        return visitSearchResultModel.getVisitKeyByFirstName(uniqueFirstName);
    }

    public String getWorkerKeyByUniqueEmployeeFirstName(String uniqueFirstName) {
        VisitSearchResultModel visitSearchResultModel = new Gson().fromJson(searchResponse.body().asString(), VisitSearchResultModel.class);
        return visitSearchResultModel.getWorkerKeyByFirstName(uniqueFirstName);
    }

    public String getUpdateIdByUniqueEmployeeFirstName(String uniqueFirstName) {
        VisitSearchResultModel visitSearchResultModel = new Gson().fromJson(searchResponse.body().asString(), VisitSearchResultModel.class);
        return visitSearchResultModel.getUpdateIdByFirstName(uniqueFirstName);
    }

    /**
     * Get Update Row Id of a visit
     * @param visitKey
     * @return
     */
    public String getUpdateRowId(String visitKey) {
        JsonParser jsonObject = new JsonParser();
        JsonObject jsonResponse = (JsonObject) jsonObject.parse(searchResponse.body().asString());
        JsonArray searchResults = jsonResponse.getAsJsonArray("rows");
        for(int i = 0; i < searchResults.size(); i++){
            JsonObject searchResult = searchResults.get(i).getAsJsonObject();
            String searchVisitKey = searchResult.get("VisitKey").getAsString();
            if(searchVisitKey.equalsIgnoreCase(visitKey)){
                return String.valueOf(i);
            }
        }
        return null;
    }

    /**
     * Update memo of a visit
     * @param visitKey
     * @param updateId
     * @param memo
     * @return
     */
    public Response updateMemo(String visitKey, String updateId, String memo) {
        Response response = v8WebService.updateMemo(baseObj.getEnvironment("v8_update_memo"), visitKey,
                updateId, memo);
        if (response.getStatusCode() == 200) {
            logPass("request to update memo "+ memo +" successfully");
        } else {
            logError("Failed running request update memo." + memo + " ." +response.getStatusCode());
        }
        return response;
    }

    public Response updateEmployee(String workerKey, String visitKey, String updateId) {
        updateEmployeeResponse = v8WebService.updateEmployee(baseObj.getEnvironment("v8_endpoint") + "/VM/VisitMaintenance/UpdateEmployee",
                workerKey, visitKey, updateId);
        if (updateEmployeeResponse.getStatusCode() == 200) {
            logPass("request to update employee successfully");
        } else {
            logError("Failed running request update employee." + updateEmployeeResponse.getStatusCode());
        }
        return updateEmployeeResponse;
    }

    public Response updateVisitException(VisitException visitException) {
        Response response = v8WebService.updateVisitException(baseObj.getEnvironment("v8_endpoint") +
                Visit.EVV_UPDATE_VISIT_EXCEPTION, visitException);
        if (response.getStatusCode() == 200) {
            logPass("request to update visit exception successfully");
        } else {
            logError("Failed update visit exception." + response.getStatusCode());
        }
        return response;
    }

    public void updateVisitException(VISIT_EXCEPTION visitExceptionType, int acknowledged) {
        visitKey = getVisitKeyBy(account, clientGeneralEntity.ClientFirstName);
        updateId = getUpdateIdByVisitKey(visitKey);

        VisitException visitException = new VisitException();
        visitException.Ackknowledged = acknowledged;
        visitException.ExceptionKeys = Arrays.asList(visitExceptionType.getValue());
        visitException.ReasonCode = "40";
        visitException.ReasonNote = "Test data";
        visitException.ResolutionCode = "";
        visitException.UpdateId = updateId;
        visitException.VisitKey = visitKey;

        updateVisitException(visitException);
    }

    private boolean isEmployeeSsnExistingInDB(String accountId, String ssn) {
        String sql = String.format(SQL_GET_WORKER_BY_SSN, accountId, ssn);
        int count = DbUtilsCon.getDataTable(  baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).size();
        return ( count > 0 ) ? true : false;
    }

    private String generateNewEmployeeSsn() {
        String accountId = baseObj.readDataValue("AccountId");
        String ssn = commons.generateRandomSsn();
        while ( isEmployeeSsnExistingInDB(accountId, ssn) ) {
            logStepInfo("Social Security Number " + ssn + " is existing already in database.");
            ssn = commons.generateRandomSsn();
        }
        return ssn;
    }

    public String createEmployee() {
        employeeFirstName = baseObj.readDataValue("EmployeeFirstNamePrefix") + commons.generateUniqueNumber();
        String lastName = baseObj.readDataValue("EmployeeLastNamePrefix") + commons.generateUniqueNumber();
        CreateEmployee createEmployee = new CreateEmployee();
        createEmployee.CdsUser = "False";
        createEmployee.CdsEnabled = "True";
        createEmployee.VersionNumber = "0";
        createEmployee.IsWorkerUpdate = "false";
        createEmployee.IsUpdate = "False";
        createEmployee.FirstName = employeeFirstName;
        createEmployee.LastName = lastName;
        createEmployee.MidName = "t";
        createEmployee.EmployeeId = "";
        createEmployee.OtherId = "";
        createEmployee.Ssn = generateNewEmployeeSsn();
        createEmployee.StxId = "";
        createEmployee.employee_stxId_formatted = "";
        createEmployee.Email = employeeFirstName + "@sandata.com";
        createEmployee.EmailConfirm = lastName + "@sandata.com";
        createEmployee.Street = "601/9 CMT8";
        createEmployee.Apt = "601/18 CMT8";
        createEmployee.City = "Ho Chi Minhh";
        createEmployee.State = "NY";
        createEmployee.ZipCode = "12345-1256";
        createEmployee.Phone = "(123) 456-7891";
        createEmployee.Dept = "ABC";
        createEmployee.CustomId = "";
        createEmployee.Payrate = "";
        createEmployee.Discipline = "";
        createEmployee.IsMVVUser = "false";

        createEmployeeResponse = v8WebService.createEmployee(baseObj.getEnvironment("v8_endpoint") + "/VM/DataEntry/SaveDataEntryEmployee",
                createEmployee);
        if (createEmployeeResponse.getStatusCode() == 200) {
            this.stxId = getStxIdFromResponse();
            logPass(String.format("request to create employee successfully. New Stx id: %s. New SSN: %s. employee name: %s",  this.stxId, createEmployee.Ssn, createEmployee.getFirstName()));
        } else {
            logError("Failed running request create employee." + createEmployee.toString() + " ." + createEmployeeResponse.getStatusCode());
        }
        return employeeFirstName;
    }

    public String getStxIdFromResponse() {
        if ( createEmployeeResponse != null ) {
            logStepInfo("Using json path " + "$.stxId"  + "to extract stxId from Json:\n" + createEmployeeResponse.body().asString());
            String stxId = JsonPath.read(createEmployeeResponse.body().asString(), "$.stxId");
            return stxId;
        }
        return "";
    }

    public String getWorkerKey(String firstName) {
        String sql = String.format(SQL_GET_WORKERKEY_BY_FIRST_NAME, firstName);
        Object workerKey = DbUtilsCon.getDataTable(  baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("WORKERKEY");
        return String.valueOf(workerKey);
    }

    /**
     * Author: Trang PM
     * Des: Get employee id
     */

    public String getEmployeeIdBy(String accountId, String employeeFName, String employeeLName) {
        String sql = String.format(SQL_GET_EMPLOYEE_ID, employeeFName, employeeLName, accountId);
        Object clientId = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("EMPLOYEEID");
        return String.valueOf(clientId);
    }

    public String getVisitLogKey(String visitKey, String employeeFirstName) {
        String sql = String.format(SQL_GET_VISIT_LOG_KEY_BY_VISIT_KEY_AND_EMPLOYEE_FIRST_NAME, visitKey, employeeFirstName);
        Object visitLogKey = DbUtilsCon.getDataTable(  baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("VISLOGKEY");
        return String.valueOf(visitLogKey);
    }

    public String getVisitLogKeyByVisitKeyAndClientLastName(String visitKey, String clientLastName) {
        String sql = String.format(SQL_SELECT_VISLOGKEY_CLIENT_LNAME, visitKey, clientLastName);
        List<Map<String, Object>> dataTable = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql);
        if ( dataTable.size() < 1 ) {
            logError(String.format("visit log with visit key '%s', Client last name '%s' not found in database", visitKey, clientLastName));
            return "";
        } else {
            logStepInfo(String.format("visit log with visit key '%s', Client last name '%s' found in database", visitKey, clientLastName));
        }
        Object vislogkey = dataTable.get(0).get("VISLOGKEY");
        return String.valueOf(vislogkey);
    }

    public String getVisitLogKeyByVisitKey(String visitKey) {
        String sql = String.format(SQL_SELECT_VISITLOG_FROM_VISITKEY, visitKey);
        List<Map<String, Object>> dataTable = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql);
        if ( dataTable.size() < 1 ) {
            logError(String.format("visit log with visit key '%s' not found in database", visitKey));
            return "";
        } else {
            logStepInfo(String.format("visit log with visit key '%s' found in database", visitKey));
        }
        Object vislogkey = dataTable.get(0).get("VISLOGKEY");
        return String.valueOf(vislogkey);
    }

    public String waitToGetWorkerKey(String employeeFirstName) {
        String workerKey = "";
        int count = 30;
        try {
            while ((workerKey.isEmpty() || workerKey == null) && count > 0) {
                workerKey = getWorkerKey(employeeFirstName);
                baseObj.sleep(3);
                count--;
            }
        } catch (Exception e) {
            logStepInfo("Error in getting workerKey. Error:" + e.getMessage());
        }
        return workerKey;
    }

    /**
     * Update Adjust Hours of a visit
     * @param visitKey
     * @param updateId
     * @param adjustedIn
     * @param adjustedOut
     * @return
     */
    public Response updateAdjustedHour(String visitKey, String updateId, String adjustedIn, String adjustedOut,
                                       String reasonCode, String reasonNote) {
        Response response = v8WebService.updateAdjustedHour(
                baseObj.getEnvironment("v8_update_general"), visitKey, updateId, adjustedIn, adjustedOut,
                reasonCode, reasonNote);
        if (response.getStatusCode() == 200) {
            logPass("request to update Adjust Hours successfully");
        } else {
            logError("Failed running request update Adjust Hours." + response.getStatusCode());
        }
        return response;
    }

    /**
     * Update Service of a visit
     * @param visitKey
     * @param updateId
     * @param serviceName
     * @return
     */
    public Response updateService(String visitKey, String updateId, String serviceName,
                                       String reasonCode, String reasonNote) {
        Response response = v8WebService.updateService(
                baseObj.getEnvironment("v8_update_general"), visitKey, updateId, serviceName,
                reasonCode, reasonNote);
        if (response.getStatusCode() == 200) {
            logPass("request to update Adjust Hours successfully");
        } else {
            logError("Failed running request update Adjust Hours." + response.getStatusCode());
        }
        return response;
    }

    public Response updateBillHoursAndReasonCode(String uniqueMemo) {
        visitKey = getVisitKeyByUniqueMemo(account, uniqueMemo);
        updateId = getUpdateIdBy(visitKey);
        Response response = v8WebService.updateBillHoursAndReasonCode(
                baseObj.getEnvironment("v8_update_general"), visitKey, updateId,
                baseObj.readDataValue("ReasonCode"),
                baseObj.readDataValue("ReasonNote"),
                baseObj.readDataValue("PayHours"));
        if (response.getStatusCode() == 200) {
            logPass("request to update Adjust Hours successfully");
        } else {
            logError("Failed running request update Adjust Hours." + response.getStatusCode());
        }
        return response;
    }

    public Response updateBillHours() {
        visitKey = getVisitKeyByUniqueMemo(account, this.memo);
        updateId = getUpdateIdBy(visitKey);
        Response response = v8WebService.updateBillHours(
                baseObj.getEnvironment("v8_update_general"), visitKey, updateId,
                baseObj.readDataValue("AdjustedIn"),
                baseObj.readDataValue("AdjustedOut"),
                baseObj.readDataValue("GeneralBillHours"));
        if (response.getStatusCode() == 200) {
            logPass("request to update Adjust Hours successfully");
        } else {
            logError("Failed running request update Adjust Hours." + response.getStatusCode());
        }
        return response;
    }

    public Response updatePayHoursBySingleClick(String uniqueMemo) {
        visitKey = getVisitKeyByUniqueMemo(account, uniqueMemo);
        updateId = getUpdateIdBy(visitKey);
        Response response = v8WebService.updatePayHoursBySingleClick(
                baseObj.getEnvironment("v8_update_payHours"), visitKey, updateId,
                baseObj.readDataValue("PayHours"));
        if (response.getStatusCode() == 200) {
            logPass("request to update PayHours successfully");
        } else {
            logError("Failed running request update PayHours." + response.getStatusCode());
        }
        return response;
    }

    public Response addManualCalls(String callDTime) {
        visitKey = getVisitKeyByUniqueMemo(account, visitGeneralEntity.getMemo());

        updateId = getUpdateIdBy(visitKey);
        Response response = v8WebService.addManualCalls(
                baseObj.getEnvironment("v8_add_calls"), visitKey, updateId,
                clientGeneralEntity.ClientID, getStxIdFromResponse(),
                callDTime,
                visitGeneralEntity.Memo);
        if (response.getStatusCode() == 200) {
            logPass("request to add manual calls successfully");
        } else {
            logError("Failed running request add manual calls." + response.getStatusCode());
        }
        return response;
    }

    public Response addManualCalls(String accountId, String callDTime, String memo, String clientId) {
        visitKey = getVisitKeyByUniqueMemo(accountId, memo);

        updateId = getUpdateIdBy(visitKey);
        Response response = v8WebService.addManualCalls(
                baseObj.getEnvironment("v8_add_calls"), visitKey, updateId,
                clientId, getStxIdFromResponse(),
                callDTime,
                memo);
        if (response.getStatusCode() == 200) {
            logPass("request to add manual calls successfully");
        } else {
            logError("Failed running request add manual calls." + response.getStatusCode());
        }
        return response;
    }


    public Response searchFilterCalls(String clientFirstName, String employeeFirstName, String visitStartDate, String visitEndDate) {
        visitKey = getVisitKeyBy(account, clientFirstName, employeeFirstName, visitStartDate, visitEndDate);
        Response response = v8WebService.searchFilterCalls(
                baseObj.getEnvironment("v8_search_filter_calls"), visitKey);
        if (response.getStatusCode() == 200) {
            logPass("request to add manual calls successfully");
        } else {
            logError("Failed running request add manual calls." + response.getStatusCode());
        }
        return response;
    }

    public Response mergeVisits(String callKey, String clientFirstName, String employeeFirstName, String visitDate, String reasonCodeMemo) {
        visitKey = getVisitKeyBy(account, clientFirstName, employeeFirstName, visitDate, visitDate);
        updateId = getUpdateIdBy(visitKey);
        Response response = v8WebService.mergeVisits(
                baseObj.getEnvironment("v8_merge_visits"), visitKey, updateId,
                callKey, reasonCodeMemo);
        if (response.getStatusCode() == 200) {
            logPass("request to add manual calls successfully");
        } else {
            logError("Failed running request add manual calls." + response.getStatusCode());
        }
        return response;
    }

    /**
     * Update DoNotBill of a visit
     * @param visitKey
     * @param updateId
     * @param doNotBill
     * @return
     */
    public Response updateDoNotBill(String visitKey, String updateId, boolean doNotBill, String reasonCode,
                                    String reasonNote, String updateRowId) {
        Response response = v8WebService.updateDoNotBill(baseObj.getEnvironment("v8_update_doNotBill"), visitKey,
                updateId, doNotBill, reasonCode, reasonNote, updateRowId);
        if (response.getStatusCode() == 200) {
            logPass("request to update DoNotBill successfully");
        } else {
            logError("Failed running request update DoNotBill." + response.getStatusCode());
        }
        return response;
    }

    /**
     * Add Task of a visit
     * @param visitKey
     * @param updateId
     * @param taskId
     * @param taskName
     * @param reasonCode
     * @param reasonNote
     * @return
     */
    public Response saveVisitTask(String visitKey, String updateId, String taskId, String taskName,
                                  String reasonCode, String reasonNote, boolean isDeleted) {
        Response response = v8WebService.saveVisitTask(baseObj.getEnvironment("v8_save_vm_visit_tasks"), visitKey,
                updateId, taskId, taskName, reasonCode, reasonNote, isDeleted);
        if (response.getStatusCode() == 200) {
            logPass("request to update visit task successfully");
        } else {
            logError("Failed running request update visit task." + response.getStatusCode());
        }
        return response;
    }

    /**
     * Update memo of a visit
     * Each time update visit, should get new update from search
     * @param oldMemo
     * @param newMemo
     */
    public void updateMemo(String oldMemo, String newMemo) {
        this.memo = newMemo;
        visitKey = getVisitKeyByUniqueMemo( account, oldMemo);
        updateId = getUpdateIdByVisitKey(visitKey);
        updateMemo(visitKey, updateId, newMemo);
    }

    /**
     * Update employee of a visit
     * Each time update visit, should get new update from search
     */
    public void updateEmployee(String employeeFirstName) {
        visitKey = getVisitKeyByUniqueMemo(account, visitGeneralEntity.getMemo());
        workerKey = waitToGetWorkerKey(employeeFirstName);
        updateId = getUpdateIdByVisitKey(visitKey);
        updateEmployee(workerKey, visitKey, updateId);
    }

    /**
     * Update client of a visit
     * @param clientId
     * @param clientKey
     * @param visitKey
     * @param updateId
     * @param reasonCode
     * @param reasonNote
     * @return
     */
    public Response updateClient(String clientId, String clientKey, String visitKey,
                                 String updateId, String reasonCode, String reasonNote) {
        Response response = v8WebService.updateClientOfVisit(baseObj.getEnvironment("v8_update_client"),
                clientId, clientKey, visitKey, updateId, reasonCode, reasonNote);
        if (response.getStatusCode() == 200) {
            logPass("request to update Client successfully");
        } else {
            logError("Failed running request update Client." + response.getStatusCode());
        }
        return response;
    }

    public Response createSchedule(String accountId, String clientFName, String clientLName,
                                   String employeeFName, String employeeLName,
                                   String scheduleContract, String scheduleDate){
        String clientId = getClientIdBy(accountId,
                clientFName, clientLName);
        String clientKey = getClientKeyBy(clientId);
        String employeeId = getEmployeeIdBy(accountId,
                employeeFName, employeeLName);
        String workerKey = getWorkerKey(employeeFName);
        V8WebCreateSchedule schedule = new V8WebCreateSchedule();
        schedule.Schedule = new Schedule();
        schedule.clientFirstName = clientFName;
        schedule.selectedClientId = clientId;
        schedule.selectedClientName = clientLName + ", " + clientFName;
        schedule.selectedClientKey = clientKey;
        schedule.employeeFirstName = employeeFName;
        schedule.selectedEmployeeId = employeeId;
        schedule.selectedWorkerKey = workerKey;
        schedule.Schedule.SchDate = scheduleDate;
        schedule.Schedule.ArNumber = commons.generateRandomNumberOfFixLength(10);
        schedule.Schedule.Contract = scheduleContract;

        Response response = v8WebService.createSchedule(baseObj.getEnvironment("v8_create_schedule"),
                schedule);
        if (response.getStatusCode() == 200) {
            logPass("request to update Client successfully");
        } else {
            logError("Failed running request update Client." + response.getStatusCode());
        }
        return response;
    }

    public V8WebCreateSchedule prepareSchedule(String clientFName, String clientLName,
                                               String employeeFName, String employeeLName,
                                               String scheduleContract, String scheduleDate,
                                               String liveInCase, String memo) {
        String clientId = getClientIdBy(baseObj.readDataValue("AccountId"),
                clientFName, clientLName);
        String clientKey = getClientKeyBy(clientId);
        String employeeId = getEmployeeIdBy(baseObj.readDataValue("AccountId"),
                employeeFName, employeeLName);
        String workerKey = getWorkerKey(employeeFName);
        V8WebCreateSchedule schedule = new V8WebCreateSchedule();
        schedule.Schedule = new Schedule();
        schedule.clientFirstName = clientFName;
        schedule.selectedClientId = clientId;
        schedule.selectedClientName = clientLName + ", " + clientFName;
        schedule.selectedClientKey = clientKey;
        schedule.employeeFirstName = employeeFName;
        schedule.selectedEmployeeId = employeeId;
        schedule.selectedWorkerKey = workerKey;
        schedule.Schedule.SchDate = scheduleDate;
        schedule.Schedule.ArNumber = commons.generateRandomNumberOfFixLength(10);
        schedule.Schedule.Contract = scheduleContract;
        schedule.Schedule.IsLiveIn = liveInCase;
        if(memo != null) schedule.Schedule.Memo = memo;
        return schedule;
    }

    public Response createScheduleWithLiveInCase(String clientFName, String clientLName,
                                   String employeeFName, String employeeLName,
                                   String scheduleContract, String scheduleDate, String liveInCase){

        V8WebCreateSchedule schedule = prepareSchedule(clientFName, clientLName, employeeFName, employeeLName,
                scheduleContract, scheduleDate, liveInCase, null);
        Response response = v8WebService.createSchedule(baseObj.getEnvironment("v8_create_schedule"),
                schedule);
        if (response.getStatusCode() == 200) {
            logPass("request to update Client successfully");
        } else {
            logError("Failed running request update Client." + response.getStatusCode());
        }
        return response;
    }

    public V8WebCreateSchedule prepareSchedule(String accountId, String clientFName, String clientLName,
                                               String employeeFName, String employeeLName,
                                               String scheduleContract, String scheduleDate,
                                               String liveInCase, String memo) {
        String clientId = getClientIdBy(accountId,
                clientFName, clientLName);
        String clientKey = getClientKeyBy(clientId);
        String employeeId = getEmployeeIdBy(accountId,
                employeeFName, employeeLName);
        String workerKey = getWorkerKey(employeeFName);
        V8WebCreateSchedule schedule = new V8WebCreateSchedule();
        schedule.Schedule = new Schedule();
        schedule.clientFirstName = clientFName;
        schedule.selectedClientId = clientId;
        schedule.selectedClientName = clientLName + ", " + clientFName;
        schedule.selectedClientKey = clientKey;
        schedule.employeeFirstName = employeeFName;
        schedule.selectedEmployeeId = employeeId;
        schedule.selectedWorkerKey = workerKey;
        schedule.Schedule.SchDate = scheduleDate;
        schedule.Schedule.ArNumber = commons.generateRandomNumberOfFixLength(10);
        schedule.Schedule.Contract = scheduleContract;
        schedule.Schedule.IsLiveIn = liveInCase;
        if(memo != null) schedule.Schedule.Memo = memo;
        return schedule;
    }

    public Response createSchedule(String accountId, String clientFName, String clientLName,
                                   String employeeFName, String employeeLName,
                                   String scheduleContract, String scheduleDate, String memo) {
        V8WebCreateSchedule schedule = prepareSchedule(accountId, clientFName, clientLName, employeeFName, employeeLName,
                scheduleContract, scheduleDate, "false", memo);
        Response response = v8WebService.createSchedule(baseObj.getEnvironment("v8_create_schedule"),
                schedule);
        if (response.getStatusCode() == 200) {
            logPass("request to update Client successfully");
        } else {
            logError("Failed running request update Client." + response.getStatusCode());
        }
        return response;
    }

    public Response createMergedVisit(String callKey, String updateId, String visitKey) {
        Response response = v8WebService.mergeVist(baseObj.getEnvironment("v8_merge_visit"), callKey,
                updateId, visitKey);
        if (response.getStatusCode() == 200) {
            logPass("Request to merge visit successfully");
        } else {
            logError("Failed running request merge visit." + response.getStatusCode());
        }
        return response;
    }

    public void updateDoNotBill(String clientFName, String clientLName, boolean doNotBill, String reasonNote) {
        visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));
        updateId = getUpdateId(visitKey);
        String updateRowId = getUpdateRowId(visitKey);
        String reasonUpdateDoNotBill = reasonNote;
        if(reasonNote.equals("") || reasonNote.equals(null)) reasonUpdateDoNotBill = baseObj.readDataValue("ReasonNote");

        updateDoNotBill(visitKey, updateId, doNotBill, baseObj.readDataValue("ReasonCode"),
                reasonUpdateDoNotBill, updateRowId);
    }

    public void updateAdjustHour(String clientFName, String clientLName, String timeIn, String timeOut) {
        visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));
        updateId = getUpdateId(visitKey);
        updateAdjustedHour(visitKey, updateId,
                timeIn,
                timeOut,
                baseObj.readDataValue("ReasonCode"),
                baseObj.readDataValue("ReasonNote"));
    }

    public void updateService(String clientFName, String clientLName, String reasonNote) {
        visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));
        updateId = getUpdateId(visitKey);
        String serviceName = baseObj.readDataValue("ServiceName");
        updateService(visitKey, updateId,
                serviceName,
                baseObj.readDataValue("ReasonCode"),
                reasonNote);
    }

    public void saveVisitTask(String clientFName, String clientLName, boolean isDeleted, String reasonNote) {
        visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));
        updateId = getUpdateId(visitKey);
        if(reasonNote.equals("") || reasonNote.equals(null)) reasonNote = baseObj.readDataValue("ReasonNote");
        saveVisitTask(visitKey, updateId, baseObj.readDataValue("TaskId"),
                baseObj.readDataValue("TaskName"),
                baseObj.readDataValue("ReasonCode"),
                reasonNote, isDeleted);
    }

    public boolean validateUpdateEmployeeSuccessfully() {
        boolean result = true;
        String path = "$.updateInfo.EmployeeName";
        logStepInfo("Using json path " + path + "to extract EmployeeName from Json:\n" + updateEmployeeResponse.body().asString());
        String employeeName = JsonPath.read(updateEmployeeResponse.body().asString(), path);

        if (employeeName.contains(employeeFirstName)) {
            logPass("employee is updated successfully");
        } else {
            result = false;
            logError("employee is not updated");
        }
        Assert.assertTrue(result, "Update employee Unsuccessfully");
        return result;
    }

    public void validateUpdateClientSuccessfully(String clientLastName) {
        boolean result = true;

        UpdateInformation updateInformation = new Gson().fromJson(updateClientResponse.body().asString(), UpdateInformation.class);

        if (updateInformation.updateInfo.ClientName.contains(clientLastName)) {
            logPass(String.format("Client with last name '%s' is updated successfully", clientLastName));
        } else {
            result = false;
            logError(String.format("Client with last name '%s' is not updated successfully", clientLastName));
        }
        Assert.assertTrue(result, "Update Client Unsuccessfully");
    }

    public void updateClient(String clientLastName) {
        visitKey = getVisitKeyByUniqueMemo(account, visitGeneralEntity.getMemo());
        updateId = getUpdateIdByVisitKey(visitKey);
        String clientId = getClientIdBy(account, clientLastName);
        String clientKey = getClientKeyBy(account, clientLastName);
        updateClientResponse = updateClient(clientId, clientKey, visitKey, updateId, "70", "Revert Client data");
    }

    public void updateClient(String firstClientFName, String firstClientLName,
                             String secondClientFName, String secondClientLName, String reasonNote) {
        visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                firstClientFName,
                firstClientLName,
                baseObj.readDataValue("Memo"));
        updateId = getUpdateId(visitKey);
        String clientId = getClientIdBy(baseObj.readDataValue("AccountId"),
                secondClientFName,
                secondClientLName);
        String clientKey = getClientKeyBy(clientId);
        updateClient(clientId, clientKey, visitKey, updateId, baseObj.readDataValue("ReasonCode"),
                reasonNote);
    }

    public void revertClient(String firstClientFName, String firstClientLName,
                             String secondClientFName, String secondClientLName) {
        visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                secondClientFName,
                secondClientLName,
                baseObj.readDataValue("Memo"));
        updateId = getUpdateId(visitKey);
        String clientId = getClientIdBy(baseObj.readDataValue("AccountId"),
                firstClientFName,
                firstClientLName);
        String clientKey = getClientKeyBy(clientId);
        updateClient(clientId, clientKey, visitKey, updateId, baseObj.readDataValue("ReasonCode"),
                baseObj.readDataValue("ReasonNote"));
    }

    public void validateUpdateMemoSuccessfully(String visitKey, String updateId, String memo) {
        boolean result = true;
        Response response = v8WebService.getMemo(baseObj.getEnvironment("v8_endpoint"), visitKey);
        if (response.body().asString().contains(memo)) {
            logPass("memo is updated successfully");
        } else {
            result = false;
            logError("memo is not updated");
        }
        Assert.assertTrue(result, "Update Memo unsuccessfully");
    }

    public void validateUpdateMemoSuccessfully(String memo) {
        validateUpdateMemoSuccessfully(visitKey, updateId, memo);
    }

    public void validateChangeIdOfUpdateMemo(String changeId, String memo) {
        boolean result = false;
        List<VisitChangesModel> records = filterVisitChangeByMemo(memo);
        result = verifyChangeId(changeId, records);
        Assert.assertTrue(result, "Failed changeId Of UpdateMemo");
    }

    public void validateChangeIdOfUpdateVisitEmployee(String changeId, String previousEmployeeFirstName) {
        boolean result = false;
        String visitLogKey = getVisitLogKey(visitKey, previousEmployeeFirstName);
        List<VisitChangesModel> records = filterVisitChangeByVisitLogKey(visitLogKey);
        result = verifyChangeId(changeId, records);
        Assert.assertTrue(result, "Failed changeId Of visit employee");
    }

    public void validateChangeIdOfUpdateVisitClient(String changeId, String previousClientLastName) {
        boolean result = false;
        String visitLogKey = getVisitLogKeyByVisitKeyAndClientLastName(visitKey, previousClientLastName);
        List<VisitChangesModel> records = filterVisitChangeByVisitLogKey(visitLogKey);
        result = verifyChangeId(changeId, records);
        Assert.assertTrue(result, "Failed changeId Of visit employee");
    }

    public void validateChangeIdOfUpdateVisitVerificationException(String changeId) {
        boolean result = false;

        String visitLogKey = getVisitLogKeyByVisitKey(visitKey);
        List<VisitChangesModel> records = filterVisitChangeByVisitLogKey(visitLogKey);
        result = verifyChangeId(changeId, records);
        Assert.assertTrue(result, "Failed changeId Of visit verification exception");
    }

    public void validateChangeIdOfAdjustHours() {
        System.out.println("visitKey = " + visitKey);
    }
    public void validateChangeIdOfConnecticut() {
        visitKey = getVisitKeyByUniqueMemo(account, this.memo);
        List<VisitChangesModel> records = filterVisitChangeBy(visitKey);
        Assert.assertTrue(verifyChangeId(baseObj.readDataValue("ChangeId"), records),
                "Failed changeId Of adjusting hour. Actual ChangeId: " + records.get(0).getChangeID());
    }

    public void validateChangeIdOfMolina() {
        visitKey = getVisitKeyByUniqueMemo(account, visitGeneralEntity.getMemo());
        List<VisitChangesModel> records = filterVisitChangeBy(visitKey);
        Assert.assertTrue(verifyChangeId(baseObj.readDataValue("ChangeId"), records),
                "Failed changeId Of adjusting hour. Actual ChangeId: " + records.get(0).getChangeID());
    }

    public void validateChangeIdOfMergeCall(String visitKey) {
        List<VisitChangesModel> records = filterVisitChangeBy(visitKey);
        Assert.assertTrue(verifyChangeId(baseObj.readDataValue("ChangeId"), records),
                "Failed changeId Of adjusting hour. Actual ChangeId: " + records.get(0).getChangeID());
    }

    private boolean verifyChangeId(String changeId, List<VisitChangesModel> records) {
        boolean result = false;
        if (records.size() < 1) {
            logError(String.format(String.format("No records of model: " + records.getClass())));
        } else {
            result = records.get(0).getChangeID().trim().equalsIgnoreCase(changeId);
            if (result) {
                logPass("Change Id" + changeId + " is correct in exported file.");
            } else {
                logError(String.format(String.format("actual change id: %s\nexpected change id:%s", records.get(0).getChangeID().trim(), changeId)));
            }
        }
        return result;
    }

    /**
     * Create a new visit on V8 page
     * @param model V8WebCreateVisitModel model
     */
    public void createVisitV8(V8WebCreateVisitModel model){
        Response r = v8WebService.createVisit(baseObj.getEnvironment("v8_create_post"), model);
        if(r.getStatusCode()==200) {
            logPass("Create visit Successfully");
        } else {
            logError("Create visit Error, Model: "+model.toString());
        }
    }

    protected void createVisit(){
        V8WebCreateVisitModel model = new V8WebCreateVisitModel();
        model.setSelectedClientName(baseObj.readDataValue("ClientFullName"));
        model.setCallDate(baseObj.readDataValue("CreateCallDate"));
        model.setCallTime(baseObj.readDataValue("CreateCallInTime"));
        createVisitV8(model);
    }

    public void createNewVisitCall() {
        clientGeneralEntity = createClient();
        employeeGeneralEntity = intake_createEmployee();

        createNewVisitCall(clientGeneralEntity.ClientLastName, employeeGeneralEntity.EmployeeLastName);
    }

    public void createNewVisitCall(String clientLastName, String employeeLastName) {
        V8WebCreateVisitModel call = new V8WebCreateVisitModel();
        Map<String, Object> client =  clientDbService.getClientFieldValues(account, clientLastName);
        Map<String, Object> employee =  employeeDbService.getEmployeeFieldValues(account, employeeLastName);
        call.clientMedicaidID = String.valueOf(client.get("MEDICAID_ID"));
        call.selectedClientId = String.valueOf(client.get("LOC"));
        call.selectedClientName = String.format("%s, %s", clientLastName, client.get("F_NAME"));
        call.selectedClientKey = String.valueOf(client.get("CLIENTKEY"));

        call.employeeLastName = String.valueOf(employee.get("L_NAME"));
        call.selectedEmployeeId = String.valueOf(employee.get("STX_ID"));
        call.selectedWorkerKey = String.valueOf(employee.get("WORKERKEY"));
        call.CallDate = commons.getDateString(-1, "MM/dd/yyyy");
        createVisitV8(call);
    }

    public void areVisitGeneralRecordsExistInExportedFile(List<String> visitKey){
        visitKey.forEach(v->
                Assert.assertTrue(!filterVisitGeneralBy(v).isEmpty(),String.format("Record with VisitKey = %s does not exist on Exported File",v)));
    }

    public void verify(V8WebCreateVisitModel model){
        Response r = v8WebService.createVisit(baseObj.getEnvironment("v8_create_post"),model);
        if(r.getStatusCode()==200)logPass("Create visit Successfully");
        else logError("Create visit Error, Model: "+model.toString());
    }

    public void validateFormatFieldOfVisitException(String visitKey){
        List<VisitExceptionsModel> lst = filterVisitExceptionBy(visitKey);
        logStepInfo("visitKey = " + visitKey);
        Assert.assertTrue(!lst.isEmpty(),"There is no record in Visit_Exception file with VisitKey = " + visitKey);
        lst.forEach(VisitExceptionsModel::verifyFormatFields);
    }


    protected V8WebCreateVisitModel createVisitForMergeCall(String callDate, String callTime, String visitSearchDate) {
        V8WebCreateVisitModel v8WebCreateVisitModel = new V8WebCreateVisitModel();
        v8WebCreateVisitModel.setSelectedClientName(clientGeneralEntity.getClientLastName() + ", " + clientGeneralEntity.getClientFirstName());
        v8WebCreateVisitModel.setSelectedClientId(clientGeneralEntity.getClientID());
        v8WebCreateVisitModel.setSelectedClientKey(getClientKeyBy(clientGeneralEntity.getClientID()));
        v8WebCreateVisitModel.setSelectedEmployeeId(employeeGeneralEntity.getEmployeeIdentifier());
        v8WebCreateVisitModel.setEmployeeFirstName(employeeGeneralEntity.getEmployeeFirstName());
        v8WebCreateVisitModel.setSelectedWorkerKey(getWorkerKey(employeeGeneralEntity.getEmployeeFirstName()));
                v8WebCreateVisitModel.setCallDate(callDate);
        v8WebCreateVisitModel.setCallTime(callTime);
        createVisitV8(v8WebCreateVisitModel);

        int retry = 3;
        do {
            retry --;
            try {
                System.out.println("trying to get new visit created. retry = " + retry);
                visitKey = getVisitKeyBy(account, clientGeneralEntity.getClientFirstName(), employeeGeneralEntity.getEmployeeFirstName(), visitSearchDate, visitSearchDate);
                break;
            } catch (Exception ex) {
                baseObj.sleep(5);
            }
        } while (retry > 0);

        return v8WebCreateVisitModel;
    }

    public void updateVisitException(String updateId, String visitKey,
                                     List<Integer> exceptionKeys, int acknowledged) {
        VisitException visitException = new VisitException();
        visitException.Ackknowledged = acknowledged;
        visitException.ExceptionKeys = exceptionKeys;
        visitException.ReasonCode = "99";
        visitException.ReasonNote = "Test data";
        visitException.ResolutionCode = "WDM";
        visitException.UpdateId = updateId;
        visitException.VisitKey = visitKey;

        updateVisitException(visitException);
    }

    /**
     * Generate visit code of a visit
     * @param visitKey
     * @param updateId
     * @param visitGroupCode
     * @return
     */
    public Response generateVisitCode(String visitKey, String updateId, String visitGroupCode) {
        Response response = v8WebService.generateVisitCode(
                baseObj.getEnvironment("v8_update_general"), visitKey, updateId, visitGroupCode);
        if (response.getStatusCode() == 200) {
            logPass("request to update Visit Code successfully");
        } else {
            logError("Failed running request update Visit Code." + response.getStatusCode());
        }
        return response;
    }

    /**
     * Update Payer And Program
     * @param visitKey
     * @param updateId
     * @param payerId
     * @param program
     * @return
     */
    public Response updatePayerProgram(String visitKey, String updateId, String payerId,
                                       String serviceName, String program) {
        Response response = v8WebService.updatePayerService(visitKey, updateId, payerId, serviceName, program);
        if (response.getStatusCode() == 200) {
            logPass("request to update Payer Service Program successfully");
        } else {
            logError("Failed running request update Payer Service Program." + response.getStatusCode());
        }
        return response;
    }

    public V8WebCreateVisitModel initiateVisitModel(String accountId, String callTime,
                                                     PatientGeneralEntity patient,
                                                     WorkerGeneralEntity employee) {
        String clientId = getClientIdBy(accountId, patient.PatientFirstName, patient.PatientLastName);
        String clientKey = getClientKeyBy(clientId);
        String employeeId = getEmployeeIdBy(accountId, employee.StaffFirstName, employee.StaffLastName);
        String employeeKey = getWorkerKey(employee.StaffFirstName);

        V8WebCreateVisitModel v8WebCreateVisitModel = new V8WebCreateVisitModel();
        v8WebCreateVisitModel.setCallDate(commons.getDateUTCFormat(-1, "MM/dd/yyyy"));
        v8WebCreateVisitModel.setCallTime(callTime);
        v8WebCreateVisitModel.setClientFirstName(patient.getPatientFirstName());
        v8WebCreateVisitModel.setEmployeeFirstName(employee.getStaffFirstName());
        v8WebCreateVisitModel.setPrimarySearch("false");
        v8WebCreateVisitModel.setSelectedClientId(clientId);
        v8WebCreateVisitModel.setSelectedClientKey(clientKey);
        v8WebCreateVisitModel.setSelectedClientName(patient.PatientLastName + ", " + patient.PatientFirstName);

        v8WebCreateVisitModel.setSelectedEmployeeId(employeeId);
        v8WebCreateVisitModel.setSelectedWorkerKey(employeeKey);
        v8WebCreateVisitModel.setService("");
        v8WebCreateVisitModel.setClientServices("S5125");
        return v8WebCreateVisitModel;
    }

    public void UpdateVisitException(String visitKey, List<Integer> exceptionKeys) {
        updateId = getUpdateIdBy(visitKey);
        System.out.println("UpdateId: " + updateId);
        updateVisitException(updateId, visitKey, exceptionKeys, 1);
    }

    public boolean waitForUpdateIdUpdated(String oldUpdatedId, String visitKey) {
        int retryCount = 3;
        boolean isUpdateId = false;
        while(retryCount > 0 && !isUpdateId) {
            System.out.println("retryCount = " + retryCount);
            String updateId = getUpdateIdBy(visitKey);
            System.out.println("UpdateId: " + updateId);
            if(!updateId.equals(oldUpdatedId)) {
                isUpdateId = true;
            }else isUpdateId = false;
                baseObj.sleep(5000);
                retryCount--;
            }
        return isUpdateId;
    }

    public ClaimValidationV2 CreateClaimVisit(String providerId, String requestType, PatientGeneralEntity patient,
                                               String serviceStartDate, String procedureCode, String unit) {
        String unique = "1" + commons.generateUniqueNumber();
        ClaimValidationV2 claimValidationV2 = new ClaimValidationV2();
        List<EVV_Request> evv_requests = new ArrayList<>();
        EVV_Request evv_request = new EVV_Request();
        evv_request.BusinessEntityMedicaidIdentifier = providerId;
        evv_request.ProviderID = providerId;
        evv_request.RequestType = requestType;
        evv_request.BatchID = unique;
        evv_request.TransactionID = RandomStringUtils.randomNumeric(9);
        evv_request.Payer = "ODM";
        evv_request.ICN = "9999973482423";
        evv_request.DLN = "04";
        evv_request.ProviderQualifier = "MedicaidID";
        evv_request.PatientQualifier = "MedicaidID";
        evv_request.PatientID = patient.PatientMedicaidID;
        evv_request.ServiceStartDate = serviceStartDate;
        evv_request.ServiceEndDate = null;
        evv_request.ProcedureCode = procedureCode;
        evv_request.Units = unit;
        evv_request.UnitsRule = "AddUnits";
        evv_request.Modifier1 = "U1";
        evv_request.Modifier2 = "U2";
        evv_request.Modifier3 = "U3";
        evv_request.Modifier4 = "U4";
        evv_request.MatchingRule = "ExcludeUnits";
        evv_requests.add(evv_request);
        claimValidationV2.EVV_Request = evv_requests;

        claimVisit(claimValidationV2);
        return claimValidationV2;
    }

    public String CreateGroupVisitCode(String accountId, String clientFName) {
        String visitKey = getVisitKeyBy(accountId, clientFName);
        updateId = getUpdateIdBy(visitKey);
        String groupCode = commons.generateRandomNumberOfFixLength(6);
//        String groupCode = "703780";
        generateVisitCode(visitKey, updateId, groupCode);
        return groupCode;
    }

    public void UpdatePayerProgram(String accountId, String clientFName,
                                     String payerId, String serviceName, String program) {
        String visitKey = getVisitKeyBy(accountId, clientFName);
        updateId = getUpdateIdBy(visitKey);
        updatePayerProgram(visitKey, updateId, payerId, serviceName, program);
    }

    //------------------OHIO verification method------------------------------
    public void verifyTheVisitExceptionWithoutOutCall(String visitMemo){
        List<com.sandata.entity.ohio.exports.Visit> visits = jsonOhioExportEntities[0].getVisits();
        System.out.println("Visit.getVisitMemo() " + visitMemo);
        com.sandata.entity.ohio.exports.Visit visit = visits.stream().
                filter(Visit -> visitMemo.equals(Visit.getVisitMemo())).findFirst().orElse(null);
        String visitKey = getVisitKeyByUniqueMemo(visitMemo);

        boolean result = false;
        List<com.sandata.entity.ohio.visit.VisitException> visitExceptionList = visit.getVisitException();
        for(com.sandata.entity.ohio.visit.VisitException visitException : visitExceptionList) {
            if(visitException.getExceptionID().equals("4")){
                Assert.assertTrue(visitException.getExceptionName().equals("Visits Without Out-Calls"),
                        "Visit Exception Name should be Visits Without Out-Calls");
                Assert.assertTrue(visitException.getExceptionAcknowledged().equals("false"),
                        "ExceptionAcknowledged should be false");
                Assert.assertTrue(visitException.getVisitKey().equals(visitKey),
                        String.format("VisitKey %s is incorrect", visitKey));
                result = true;
            }
        }
        Assert.assertTrue(result, "Visit Exception Without Out Call is NOT displayed");
    }

    public void verifyTheVisitException(String visitMemo, String exceptionId,
                                        String exceptionName, String exceptionKnowledge){
        List<com.sandata.entity.ohio.exports.Visit> visits = jsonOhioExportEntities[0].getVisits();
        System.out.println("Visit.getVisitMemo() " + visitMemo);
        com.sandata.entity.ohio.exports.Visit visit = visits.stream().
                filter(Visit -> visitMemo.equals(Visit.getVisitMemo())).findFirst().orElse(null);
        String visitKey = getVisitKeyByUniqueMemo(visitMemo);

        boolean result = false;
        List<com.sandata.entity.ohio.visit.VisitException> visitExceptionList = visit.getVisitException();
        for(com.sandata.entity.ohio.visit.VisitException visitException : visitExceptionList) {
            if(visitException.getExceptionID().equals(exceptionId)){
                Assert.assertTrue(visitException.getExceptionName().equals(exceptionName),
                        String.format("Visit Exception Name should be %s", exceptionName));
                ExtentTestManager.logTestStep(String.format("Visit Exception Name is %s", exceptionName));
                Assert.assertTrue(visitException.getExceptionAcknowledged().equals(exceptionKnowledge),
                        String.format("ExceptionAcknowledged should be %s", exceptionKnowledge));
                ExtentTestManager.logTestStep(String.format("ExceptionAcknowledged is %s", exceptionKnowledge));
                Assert.assertTrue(visitException.getVisitKey().equals(visitKey),
                        String.format("VisitKey %s is incorrect", visitKey));
                ExtentTestManager.logTestStep(String.format("VisitKey %s is correct", visitKey));

                result = true;
            }
        }
        if(!result)
            ExtentTestManager.logFailure(String.format("%s is NOT displayed", exceptionName));
        else ExtentTestManager.logPass(String.format("%s is displayed with correct information", exceptionName));
        Assert.assertTrue(result, String.format("%s is NOT displayed", exceptionName));
    }

    public void VerifyVisitIsNotDisplayed(String visitMemo) {
        List<com.sandata.entity.ohio.exports.Visit> visits = jsonOhioExportEntities[0].getVisits();
        System.out.println("Visit.getVisitMemo() " + visitMemo);
        String accountId = baseObj.getEnvironment("ohio_accountId");
        String visitKey = getVisitKeyByUniqueMemo(accountId, visitMemo);

        com.sandata.entity.ohio.exports.Visit visit = visits.stream().
                filter(Visit -> visitMemo.equals(Visit.getVisitMemo())).findFirst().orElse(null);
        if(visit == null) {
            ExtentTestManager.logPass(String.format("Visit information %s is not be in exported file", visitKey));
        }else {
            ExtentTestManager.logFailure(String.format("Visit information %s should not be in exported file", visitKey));
        }
        Assert.assertNull(visit, "Visit information should not be in exported file");
    }

    public void VerifyVisitExceptionIdIsNotExisted(String visitMemo, List<String> exceptionIds) {
        List<com.sandata.entity.ohio.exports.Visit> visits = jsonOhioExportEntities[0].getVisits();
        System.out.println("Visit.getVisitMemo() " + visitMemo);
        com.sandata.entity.ohio.exports.Visit visit = visits.stream().
                filter(Visit -> visitMemo.equals(Visit.getVisitMemo())).findFirst().orElse(null);

        boolean result = true;
        List<com.sandata.entity.ohio.visit.VisitException> visitExceptionList = visit.getVisitException();
        List<String> actualVisitExceptionIds = new ArrayList<>();
        for(com.sandata.entity.ohio.visit.VisitException visitException : visitExceptionList) {
            actualVisitExceptionIds.add(visitException.getExceptionID());
        }

        for(String actualExceptionId : actualVisitExceptionIds) {
            if(exceptionIds.contains(actualExceptionId)){
                ExtentTestManager.logPass(String.format("Exception Id %s is in exported file as expectation", actualExceptionId));
            } else {
                ExtentTestManager.logFailure(String.format("Exception Id %s should NOT be in exported file", actualExceptionId));
                result = false;
            }
        }
        Assert.assertTrue(result, "Existed exception Id should not be in exported file");
    }

    public void VerifyVisitIsDisplayed(String visitMemo) {
        List<com.sandata.entity.ohio.exports.Visit> visits = jsonOhioExportEntities[0].getVisits();
        System.out.println("Visit.getVisitMemo() " + visitMemo);
        String visitKey = getVisitKeyByUniqueMemo(visitMemo);
        com.sandata.entity.ohio.exports.Visit visit = visits.stream().
                filter(Visit -> visitMemo.equals(Visit.getVisitMemo())).findFirst().orElse(null);
        if(visit != null) {
            Assert.assertEquals(visit.getVisitKey(), visitKey, "Visit Key is correct");
            ExtentTestManager.logPass(String.format("Visit information %s is in exported file", visitKey));
        }else {
            ExtentTestManager.logFailure(String.format("Visit information %s should be in exported file", visitKey));
        }
        Assert.assertNotNull(visit, "Visit information should be in exported file");
    }

    public void VerifyValueOfModifierFieldsInVisitGeneral(AuthorizationEntity authExpected, String accountId, String clientFName, String clientLName, String memo){
        String sql = String.format(SQL_GET_VISIT_KEY_BY_MEMO, accountId, clientFName, clientLName, memo);
        String visitKey = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("VISITKEY").toString();
        VisitGeneralModel scheduleFromFile = filterVisitGeneralBy(visitKey).get(0);
        Assert.assertEquals(scheduleFromFile.getModifier1(),authExpected.getModifier1(),"Modifier1 does not match in file Visit_General");
        Assert.assertEquals(scheduleFromFile.getModifier2(),authExpected.getModifier2(),"Modifier2 does not match in file Visit_General");
        Assert.assertEquals(scheduleFromFile.getModifier3(),authExpected.getModifier3(),"Modifier3 does not match in file Visit_General");
        Assert.assertEquals(scheduleFromFile.getModifier4(),authExpected.getModifier4(),"Modifier4 does not match in file Visit_General");
    }

    public void VerifyDeletedVisitStatus(String visitKey) {
        List<com.sandata.entity.ohio.exports.Visit> visits = jsonOhioExportEntities[0].getVisits();
        System.out.println("visitKey " + visitKey);
        com.sandata.entity.ohio.exports.Visit visit = visits.stream().
                filter(Visit -> visitKey.equals(Visit.getVisitKey())).findFirst().orElse(null);
        boolean result = false;
        if(visit != null) {
            if(visit.getVisitStatus().equalsIgnoreCase("Deleted")) {
                result = true;
                ExtentTestManager.logPass(String.format("Deleted Visit %s is in exported file", visitKey));
            }else {
                ExtentTestManager.logFailure(String.format("Visit Status %s is incorrect", visit.getVisitStatus()));
            }
        }else {
            ExtentTestManager.logFailure(String.format("Deleted Visit %s should be in exported file", visitKey));
        }
        Assert.assertNotNull(visit, "Visit information should be in exported file");
        Assert.assertTrue(result, "Visit Status should be Deleted");
    }

    public void VerifyRequestType(String accountId, String visitMemo, String batchId, String requestType) {
        List<com.sandata.entity.ohio.exports.Visit> visits = jsonOhioExportEntities[0].getVisits();
        String visitKey = getVisitKeyByUniqueMemo(accountId, visitMemo);
        com.sandata.entity.ohio.exports.Visit visit = visits.stream().
                filter(Visit -> visitKey.equals(Visit.getVisitKey())).findFirst().orElse(null);

        boolean result = false;
        if(visit != null) {
            ClaimStackRequests claims = visit.getClaimStackRequests().stream()
                    .filter(claim -> claim.getBatchID().equals(batchId)).findFirst().orElse(null);
            if(claims != null) {
                ExtentTestManager.logTestStep(String.format("Request Type is %s", claims.getRequestType()));
                if(claims.getRequestType().equals(requestType)){
                    result = true;
                    ExtentTestManager.logPass("Request Type is correct");
                }
                Assert.assertEquals(claims.getRequestType(), requestType,
                        String.format("RequestType should be %s", requestType));
            }else {
                ExtentTestManager.logFailure(String.format("Claim for %s batchId is not exported", batchId));
            }
        }
        Assert.assertNotNull(visit, "Visit information should be in exported file");
        Assert.assertTrue(result, "Request Type is incorrect");
    }

    public void VerifyPayerProgramAndProcedureCodeInClientGeneral(String clientFName,
                                                                  String payerProgram, String procedureCode) {
        List<Individual> individuals = jsonOhioExportEntities[0].getIndividual();
        Individual patient = individuals.stream()
                .filter(individual -> individual.getPatientFirstName().equals(clientFName))
                .findFirst().orElse(null);
        boolean result = false;
        if(patient != null) {
            PatientPayerInformation payerInformation = patient.getPatientPayerInformation()
                    .stream()
                    .filter(patientPayerInformation
                            -> patientPayerInformation.getPayerProgram().equals(payerProgram))
                    .findFirst().orElse(null);
            if(payerInformation != null) {
                if(payerInformation.getProcedureCode().equals(procedureCode))
                {
                    result = true;
                    ExtentTestManager.logPass(String.format("Procedure code %s is correct", payerInformation.getProcedureCode()));
                }else {
                    ExtentTestManager.logFailure(String.format("Procedure code %s is not correct", payerInformation.getProcedureCode()));
                }
            }else {
                ExtentTestManager.logFailure(String.format("Payer Program %s & procedure code %s are not exported", payerProgram, procedureCode));
            }

        }
        Assert.assertNotNull(patient, String.format("Patient %s should be in exported file", clientFName));
        Assert.assertTrue(result,
                String.format("Payer Program %s and Procedure Code %s should be in exported file", payerProgram, procedureCode));
    }

    public void VerifyDataUnderClaimSegment(String accountId, String visitMemo, String batchId,
                                            String icn, String dln, String modifier, String procedureCode,
                                            String dateOfService, String payer, String groupCode) {
        List<com.sandata.entity.ohio.exports.Visit> visits = jsonOhioExportEntities[0].getVisits();
        String visitKey = getVisitKeyByUniqueMemo(accountId, visitMemo);
        com.sandata.entity.ohio.exports.Visit visit = visits.stream().
                filter(Visit -> visitKey.equals(Visit.getVisitKey())).findFirst().orElse(null);

        boolean result = false;
        if(visit != null) {
            ClaimStackRequests claims = visit.getClaimStackRequests().stream()
                    .filter(claim -> claim.getBatchID().equals(batchId)).findFirst().orElse(null);
            if(claims != null) {
                ExtentTestManager.logTestStep(String.format("ICN is %s", claims.getICN()));
                ExtentTestManager.logTestStep(String.format("DLN is %s", claims.getDLN()));
                ExtentTestManager.logTestStep(String.format("Modifier is %s", claims.getModifier()));
                ExtentTestManager.logTestStep(String.format("ProcedureCode is %s", claims.getProcedureCode()));
                ExtentTestManager.logTestStep(String.format("DateOfService is %s", claims.getDateOfService()));
                ExtentTestManager.logTestStep(String.format("Payer is %s", claims.getPayer()));
                ExtentTestManager.logTestStep(String.format("GroupCode is %s", claims.getGroupCode()));
                if(claims.getICN().equals(icn) && claims.getDLN().equals(dln)
                        && claims.getModifier().equals(modifier) && claims.getProcedureCode().equals(procedureCode)
                        && claims.getDateOfService().equals(dateOfService) && claims.getPayer().equals(payer)
// TODO: should uncomment verify GroupCode after this is implemented
//                        && claims.getGroupCode().equals(groupCode)
                        && claims.getGroupCode() == null
                ){
                    result = true;
                    ExtentTestManager.logPass(String.format("Claim %s information is correct", batchId));
                } else {
                    ExtentTestManager.logFailure(String.format("Claim %s information is incorrect", batchId));
                }
            }else {
                ExtentTestManager.logFailure(String.format("Claim for %s batchId is not exported", batchId));
            }
        }
        Assert.assertNotNull(visit, "Visit information should be in exported file");
        Assert.assertTrue(result, "Request claim information is incorrect");
    }

    public void VerifyAccount(String accountId) {
        List<com.sandata.entity.ohio.exports.Visit> visits = jsonOhioExportEntities[0].getVisits();
        for(int i = 0; i<visits.size(); i++){
            Assert.assertTrue(visits.get(i).BusinessEntityID.equalsIgnoreCase(accountId)) ;
        }
    }

    public String getVisitDate(){
        String sqlQuery = String.format(VisitSQL.SQL_GET_VISIT_DATE,account);
        String visitDate = "";
        try{
            ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery);
            while (rs.next()) {
                visitDate = rs.getString("VISIT_DATE");
            }
        } catch (SQLException e) {
        }
        return visitDate;
    }

    public String getVisitDateWithNewestVisit(){
        String sqlQuery = String.format(VisitSQL.SQL_GET_VISIT_DATE_BY_NEWEST_VISIT_KEY,account);
        String visitDate = "";
        try{
            ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery);
            while (rs.next()) {
                visitDate = rs.getString("VISIT_DATE");
                break;
            }
        } catch (SQLException e) {
        }
        return visitDate;
    }

}
