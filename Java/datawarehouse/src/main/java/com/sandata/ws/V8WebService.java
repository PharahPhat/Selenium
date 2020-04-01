package com.sandata.ws;

import com.google.gson.Gson;
import com.sandata.models.molina.employee.CreateAuthorization;
import com.sandata.models.molina.employee.CreateEmployee;
import com.sandata.models.molina.visit.V8WebCreateVisitModel;
import com.sandata.models.molina.visit.SearchVisit;
import com.sandata.models.vm.ProgramServices;
import com.sandata.models.vm.visit.schedule.V8WebCreateSchedule;
import com.sandata.entity.molina.visit.VisitException;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//This service will be replaced by AltEVV visit services to make verified visit
@SuppressWarnings({"squid:S1192"})
public class V8WebService extends GenericWebService {

    /**
     * POST login to V8
     * @param url
     * @param accountId
     * @param username
     * @param password
     * @return Response object
     */
    public Response login(String url, String accountId, String username, String password) {
        Map<String, String> formData = new HashMap<>();
        formData.put("username",username);
        formData.put("password",password);
        formData.put("account","STX" + accountId);
        formData.put("rememberMe","true");
        Response loginResponse = sendPOSTWithFormData(url, formData);
        initCookies(loginResponse);
        return loginResponse;
    }

    /**
     * Search visit by credential searchVisit object
     * @param url
     * @param searchVisit
     * @return Response object
     */
    public Response searchVisit(String url, SearchVisit searchVisit) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return sendPOSTRequestWithCookies(url, headers, cookies, searchVisit.toString(), true);
    }

    /**
     * Update a visit memo
     * @param url
     * @param visitKey
     * @param updateId
     * @param memo
     * @return
     */
    public Response updateMemo(String url, String visitKey, String updateId, String memo) {
        Map<String, String> formData = new HashMap<>();
        formData.put("visitKey", visitKey);
        formData.put("updateId", updateId);
        formData.put("memo", memo);

        return sendPOSTWithFormData(url, formData, cookies);
    }

    /**
     * Update a visit DoNotBill
     * @param url
     * @param visitKey
     * @param updateId
     * @param doNotBill
     * @return
     */
    public Response updateDoNotBill(String url, String visitKey, String updateId, boolean doNotBill,
                                    String reasonCode, String reasonNote, String updatedRowId) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("visitKey", visitKey);
        formData.put("updateId", updateId);
        formData.put("doNotBillIndicator", doNotBill);
        formData.put("reasonCode", reasonCode);
        formData.put("reasonNote", reasonNote);
        formData.put("resolutionCode", "");
        formData.put("updatedRowId", updatedRowId);

        return sendPOSTWithFormData(url, formData, cookies);
    }

    /**
     * Update a visit AdjustedHour
     * @param url
     * @param visitKey
     * @param updateId
     * @param adjustedIn
     * @param adjustedOut
     * @param reasonCode
     * @param reasonNote
     * @return
     */
    public Response updateAdjustedHour(String url, String visitKey, String updateId,
                                       String adjustedIn, String adjustedOut, String reasonCode,
                                       String reasonNote) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("AdjustedIn", adjustedIn);
        formData.put("AdjustedOut", adjustedOut);
        formData.put("GeneralBillHours", "01:00");
        formData.put("IsApprovedIndicator", false);
        formData.put("PayHours", "01:00");
        formData.put("ReasonCode", reasonCode);
        formData.put("ReasonNote", reasonNote);
        formData.put("ResolutionCode", "");
        formData.put("ServiceName", "G0299");
        formData.put("Units", "4");
        formData.put("UpdatedComponents", "AdjustedHours");
        formData.put("UpdateId", updateId);
        formData.put("VisitDoNotBillIndicator", false);
        formData.put("VisitKey", visitKey);

        return sendPOSTWithFormData(url, formData, cookies);
    }

    /**
     * Generate Visit Code
     * @param url
     * @param visitKey
     * @param updateId
     * @param visitGroupCode
     * @return
     */
    public Response generateVisitCode(String url, String visitKey, String updateId,
                                       String visitGroupCode) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("AdjustedIn", "");
        formData.put("AdjustedOut", "");
        formData.put("GeneralBillHours", "");
        formData.put("IsApprovedIndicator", false);
        formData.put("GroupVisitCode", visitGroupCode);
        formData.put("GroupVisitCodeId", commons.generateRandomStringOfFixLength(32));
        formData.put("PayHours", "");
        formData.put("ReasonCode", "99");
        formData.put("ReasonNote", "Generate Visit Group");
        formData.put("ResolutionCode", "WDM");
        formData.put("ServiceName", "");
        formData.put("Units", "");
        formData.put("UpdatedComponents", "GroupVisitCode");
        formData.put("UpdateId", updateId);
        formData.put("VisitDoNotBillIndicator", false);
        formData.put("VisitKey", visitKey);

        return sendPOSTWithFormData(url, formData, cookies);
    }

    public Response updateService(String visitKey, String updateId,
                                  String payerId, String serviceCode, String programCode, String adjustedIn, String adjustedOut) {
        String url = getEnvironment("v8_update_general");

        String body = "VisitKey=" + visitKey +
                "&UpdateId=" + updateId +
                "&VisitDoNotBillIndicator=false" +
                "&AdjustedIn=" + adjustedIn +
                "&AdjustedOut=" + adjustedOut +
                "&ServiceName=" + serviceCode +
                "&UpdatedComponents%5B%5D=AdjustedHours" +
                "&UpdatedComponents%5B%5D=Service" +
                "&UpdatedComponents%5B%5D=Program" +
                "&GeneralBillHours=24:00" +
                "&ReasonCode=10" +
                "&ResolutionCode=" +
                "&ReasonNote=123" +
                "&IsApprovedIndicator=false" +
                "&Program=" + programCode +
                "&PayerID=" + payerId +
                "&GroupVisitCodeId=";

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return sendPOSTRequestWithCookies(url, headers, cookies, body, true);
    }

    public Response updatePayerService(String visitKey, String updateId,
                                  String payerId, String serviceCode, String programCode) {
        String url = getEnvironment("v8_update_general");

        String body = "VisitKey=" + visitKey +
                "&UpdateId=" + updateId +
                "&VisitDoNotBillIndicator=false" +
                "&ServiceName=" + serviceCode +
                "&UpdatedComponents%5B%5D=PayerID" +
                "&UpdatedComponents%5B%5D=Service" +
                "&UpdatedComponents%5B%5D=Program" +
                "&GeneralBillHours=24:00" +
                "&ReasonCode=10" +
                "&ResolutionCode=" +
                "&ReasonNote=123" +
                "&IsApprovedIndicator=false" +
                "&Program=" + programCode +
                "&PayerID=" + payerId +
                "&GroupVisitCodeId=";

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return sendPOSTRequestWithCookies(url, headers, cookies, body, true);
    }

    /**
     * Update a service in visit
     * @param url
     * @param visitKey
     * @param updateId
     * @param serviceName
     * @param reasonCode
     * @param reasonNote
     * @return
     */
    public Response updateService(String url, String visitKey, String updateId,
                                  String serviceName,
                                  String reasonCode, String reasonNote) {
        Map<String, Object> formData = new HashMap<>();
//        formData.put("AdjustedIn", adjustedIn);
//        formData.put("AdjustedOut", adjustedOut);
        formData.put("GeneralBillHours", "01:00");
        formData.put("GroupVisitCodeId", null);
        formData.put("IsApprovedIndicator", false);
//        formData.put("PayerID", payerId);
        formData.put("PayHours", "01:00");
        formData.put("Program", "PP");
        formData.put("ReasonCode", reasonCode);
        formData.put("ReasonNote", reasonNote);
        formData.put("ResolutionCode", "");
        formData.put("ServiceName", serviceName);
        formData.put("Units", "None");
        formData.put("UpdatedComponents", "Service");
        formData.put("UpdateId", updateId);
        formData.put("VisitDoNotBillIndicator", false);
        formData.put("VisitKey", visitKey);

        return sendPOSTWithFormData(url, formData, cookies);
    }

    public Response updateBillHoursAndReasonCode(String url, String visitKey, String updateId, String reasonCode,
                                                 String reasonNote, String payHours) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("AdjustedIn", "");
        formData.put("AdjustedOut", "");
        formData.put("UpdateId", updateId);
        formData.put("VisitDoNotBillIndicator", false);
        formData.put("VisitKey", visitKey);
        formData.put("ServiceName", "G0299");
        formData.put("UpdatedComponents", "PayHours");

        formData.put("GeneralBillHours", "");
        formData.put("IsApprovedIndicator", false);
        formData.put("PayHours", payHours);
        formData.put("ReasonCode", reasonCode);
        formData.put("ReasonNote", reasonNote);
        formData.put("ResolutionCode", "");
        formData.put("Units", "None");

        return sendPOSTWithFormData(url, formData, cookies);
    }

    public Response updatePayHoursBySingleClick(String url, String visitKey, String updateId, String payHours) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("visitKey", visitKey);
        formData.put("updateId", updateId);
        formData.put("validate", false);
        formData.put("value", payHours);
        formData.put("isOneClickUpdate", true);

        return sendPOSTWithFormData(url, formData, cookies);
    }

    public Response updateBillHours(String url, String visitKey, String updateId,
                                       String adjustedIn, String adjustedOut, String generalBillHours) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("VisitKey", visitKey);
        formData.put("UpdateId", updateId);
        formData.put("VisitDoNotBillIndicator", false);
        formData.put("AdjustedIn", adjustedIn);
        formData.put("AdjustedOut", adjustedOut);
        formData.put("ServiceName", "G0299");
        formData.put("UpdatedComponents", "BillHours");
        formData.put("GeneralBillHours", generalBillHours);
        formData.put("IsApprovedIndicator", false);
        return sendPOSTWithFormData(url, formData, cookies);
    }

    public Response addManualCalls(String url, String visitKey, String updateId,
                                       String clientId, String stxId, String callDTime, String reasonCodeMemo) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("visitKey", visitKey);
        formData.put("updateId", updateId);
        formData.put("clientId", clientId);
        formData.put("stxId", stxId);
        formData.put("callDtime", callDTime);
        formData.put("timeZone", "US/Eastern");
        formData.put("service", "G0299");
        formData.put("reasonCode", "70");
        formData.put("reasonCodeMemo", reasonCodeMemo);
        return sendPOSTWithFormData(url, formData, cookies);
    }

    public Response mergeVisits(String url, String visitKey, String updateId,
                                       String callKey, String reasonCodeMemo) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("visitKey", visitKey);
        formData.put("callKey", callKey);
        formData.put("updateId", updateId);
        formData.put("reasonCode", "70");
        formData.put("reasonCodeMemo", reasonCodeMemo);
        return sendPOSTWithFormData(url, formData, cookies);
    }

    public Response searchFilterCalls(String url, String visitKey) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("visitKey", visitKey);
        formData.put("current", "1");
        formData.put("rowCount", "5");
        formData.put("columns[]", "Actions, Phone, CallTime, CallDate, ClientName, EmployeeName");
        return sendPOSTWithFormData(url, formData, cookies);
    }

    /**
     * Add visit task
     * @param url
     * @param visitKey
     * @param updateId
     * @param taskId
     * @param taskName
     * @param reasonCode
     * @param reasonNote
     * @return
     */
    public Response saveVisitTask(String url, String visitKey, String updateId,
                                  String taskId, String taskName, String reasonCode,
                                  String reasonNote, boolean isDeleted) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("reasonCode", reasonCode);
        formData.put("reasonCodeMemo", reasonNote);
        formData.put("tasks[0][ActionUI]", "1");
        formData.put("tasks[0][CallKey]", "");
        if(isDeleted){
            formData.put("tasks[0][ActionUI]", "2");
            formData.put("tasks[0][CallKey]", "0");
        }
        formData.put("tasks[0][Id]", taskId);
        formData.put("tasks[0][Info]", "0000000000");
        formData.put("tasks[0][Name]", taskName);
        formData.put("tasks[0][Unit]", "");
        formData.put("tasks[0][Value]", "");
        formData.put("updatedTasks", true);
        formData.put("updateId", updateId);
        formData.put("visitKey", visitKey);

        return sendPOSTWithFormData(url, formData, cookies);
    }

    /**
     * Update a visit updateClientOfVisit
     * @param url
     * @param clientId
     * @param clientKey
     * @param visitKey
     * @param updateId
     * @param reasonCode
     * @param reasonNote
     * @return
     */
    public Response updateClientOfVisit(String url, String clientId, String clientKey, String visitKey,
                                        String updateId, String reasonCode, String reasonNote) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("clientId", clientId);
        formData.put("clientKey", clientKey);
        formData.put("noCombineVisits", "");
        formData.put("reasonCode", reasonCode);
        formData.put("reasonCodeMemo", reasonNote);
        formData.put("resolutionCode", "");
        formData.put("updateId", updateId);
        formData.put("visitKey", visitKey);

        return sendPOSTWithFormData(url, formData, cookies);
    }

    public Response getMemo(String endpoint, String visitKey) {
        Map<String, String> params = new HashMap<>();
        params.put("visitKey", visitKey);
        return sendGETWithQueryParams(endpoint + "/VM/VisitMaintenance/Memo", params, cookies, true);
    }

    public Response updateMemoEmployee(String url, String employeeKey, String visitKey, String updateId,
                                   String reasonCode, String reasonCodeMemo, String resolutionCode, String noCombineVisits) {
        Map<String, String> formData = new HashMap<>();
        formData.put("employeeKey", employeeKey);
        formData.put("visitKey", visitKey);
        formData.put("updateId", updateId);
        formData.put("reasonCode", reasonCode);
        formData.put("reasonCodeMemo", reasonCodeMemo);
        formData.put("resolutionCode", resolutionCode);
        formData.put("noCombineVisits", noCombineVisits);

        return sendPOSTWithFormData(url, formData, cookies);
    }

    public Response createEmployee(String url, CreateEmployee createEmployee) {
        Map<String, String> formData = new HashMap<>();
        formData.put("CdsUser", "False");
        formData.put("CdsEnabled", "True");
        formData.put("employee.VersionNumber", "0");
        formData.put("employee.IsWorkerUpdate", "false");
        formData.put("employee.IsUpdate", "False");
        formData.put("employee.FirstName", createEmployee.getFirstName());
        formData.put("employee.LastName", createEmployee.getLastName());
        formData.put("employee.MidName", createEmployee.getMidName());
        formData.put("employee.EmployeeId", createEmployee.getEmployeeId());
        formData.put("employee.OtherId", createEmployee.getOtherId());
        formData.put("employee.Ssn", createEmployee.getSsn());
        formData.put("employee.StxId", createEmployee.getStxId());
        formData.put("employee_stxId_formatted", createEmployee.getEmployee_stxId_formatted());
        formData.put("employee.Email", createEmployee.getEmail());
        formData.put("employee.EmailConfirm", createEmployee.getEmailConfirm());
        formData.put("employee.Street", createEmployee.getStreet());
        formData.put("employee.Apt", createEmployee.getApt());
        formData.put("employee.City", createEmployee.getCity());
        formData.put("employee.State", createEmployee.getState());
        formData.put("employee.ZipCode", createEmployee.getZipCode());
        formData.put("employee.Phone", createEmployee.getPhone());
        formData.put("employee.Dept", createEmployee.getDept());
        formData.put("employee.Discipline", createEmployee.getDiscipline());
        formData.put("employee.CustomId", createEmployee.getCustomId());
        formData.put("employee.Payrate", createEmployee.getPayrate());
        formData.put("employee.IsMVVUser", "false");

        return sendPOSTWithFormData(url, formData, cookies, true);
    }

    public Response createAuthorization(CreateAuthorization createAuthorization) {
        String url = getEnvironment("v8_endpoint") + "/VM/Authorizations/Insert";
        Map<String, String> formData = new HashMap<>();
        formData.put("clientFirstName", "");
        formData.put("clientLastName", "");
        formData.put("clientMedicaidID", "");
        formData.put("primarySearch", "false");
        formData.put("isActiveClientHidden", "True");
        formData.put("clientId", createAuthorization.clientId);
        formData.put("radio_action_group", "on");
        formData.put("selectedClientId", createAuthorization.clientId);
        formData.put("selectedClientName", createAuthorization.clientLastName + " " + createAuthorization.clientFirstName);
        formData.put("selectedClientKey", createAuthorization.clientKey);
        formData.put("authorization.AuthorizationId", "");
        formData.put("authorization.Contract", createAuthorization.contract);
        formData.put("authorization.ReferenceNumber", createAuthorization.referenceNumber);
        formData.put("authorization.AuthorizationTypeId", createAuthorization.authorizationTypeId);
        formData.put("authorization.MaxUnitsAlocated", createAuthorization.maxUnitsAlocated);
        formData.put("authorization.BeginDate", createAuthorization.beginDate);
        formData.put("authorization.EndDate", createAuthorization.endDate);
        formData.put("authorization.Comment", createAuthorization.endDate);
        formData.put("authorization.AuthorizationLimitTypeId", createAuthorization.authorizationLimitTypeId);
        formData.put("limitationService", "");
        formData.put("Limitations[0].Service", createAuthorization.Service);

        return sendPOSTWithFormData(url, formData, cookies, true);
    }

    public ProgramServices getPayerProgramService() {
        String url = getEnvironment("v8_endpoint") + "/VM/VisitMaintenance/GetPayorDataValidation";
        Response response = sendGETRequest(url,cookies, true);
        ProgramServices programServices = new Gson().fromJson(response.body().asString(), ProgramServices.class);
        return programServices;
    }

    /**
     * Update employee
     * @param url
     * @param workerKey
     * @param visitKey
     * @param updateId
     * @return
     */
    public Response updateEmployee(String url, String workerKey, String visitKey, String updateId) {
        Map<String, String> formData = new HashMap<>();
        formData.put("employeeKey", workerKey);
        formData.put("visitKey", visitKey);
        formData.put("updateId", updateId);
        formData.put("reasonCode", "70");
        formData.put("reasonCodeMemo", "reason");
        formData.put("resolutionCode", "");
        formData.put("noCombineVisits", "");

        return sendPOSTWithFormData(url, formData, cookies, true);
    }

    /**
     * Merge visit
     * @param url
     * @param callKey
     * @param visitKey
     * @param updateId
     * @return
     */
    public Response mergeVist(String url, String callKey, String updateId, String visitKey) {
        Map<String, String> formData = new HashMap<>();
        formData.put("callKey", callKey);
        formData.put("scheduledVisitKey", "");
        formData.put("updateId", updateId);
        formData.put("updateId2", "");
        formData.put("visitKey", visitKey);
        formData.put("reasonCode", "99");
        formData.put("reasonCodeMemo", "reason");
        formData.put("resolutionCode", "WDM");

        return sendPOSTWithFormData(url, formData, cookies, true);
    }

    public Response updateVisitException(String url, VisitException visitException) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("Ackknowledged", visitException.Ackknowledged);
        formData.put("ExceptionKeys", visitException.ExceptionKeys);
        formData.put("ReasonCode", visitException.ReasonCode);
        formData.put("ReasonNote", visitException.ReasonNote);
        formData.put("ResolutionCode", visitException.ResolutionCode);
        formData.put("UpdateId", visitException.UpdateId);
        formData.put("VisitKey", visitException.VisitKey);

        return sendPOSTWithFormData(url, formData, cookies, true);
    }

    public void initCookies(Response loginResponse) {
        cookies = new HashMap<>();
        cookies.put(".ASPXAUTH", loginResponse.getCookie(".ASPXAUTH"));
        cookies.put("ASP.NET_SessionId", loginResponse.getCookie("ASP.NET_SessionId"));
        cookies.put("SantraxApplicationCookie", loginResponse.getCookie("SantraxApplicationCookie"));
    }

    private Map<String, String> cookies;

    public Response createVisit(String url, V8WebCreateVisitModel model){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return sendPOSTRequestWithCookies(url, headers, cookies, model.toString(), true);
    }

    public Response createSchedule(String url, V8WebCreateSchedule model){
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return sendPOSTRequestWithCookies(url, headers, cookies, model.toString(), true);
    }

    public List<JSONObject> getCreatedVisits(Response responseBeforeAction, Response responseAfterAction) throws InterruptedException,  ParseException {
        JSONParser parser = new JSONParser();
        JSONObject job1 = (JSONObject) parser.parse(responseBeforeAction.getBody().prettyPrint());
        JSONObject job2 = (JSONObject) parser.parse(responseAfterAction.getBody().prettyPrint());
        JSONArray ar1 = (JSONArray)job1.get("rows");
        JSONArray ar2 = (JSONArray)job2.get("rows");
        List<JSONObject> lstBeforeAction = new ArrayList<>();
        List<JSONObject> lstAfterAction = new ArrayList<>();
        ar1.forEach(o->lstBeforeAction.add((JSONObject)o));
        ar2.forEach(o->lstAfterAction.add((JSONObject)o));
        lstAfterAction.removeAll(lstBeforeAction);
        return lstAfterAction;
    }

    public List<String> getNewVisitKeys(Response responseBeforeAction, Response responseAfterAction) throws InterruptedException,  ParseException {
        List<String> visitKeys = new ArrayList<>();
        getCreatedVisits(responseBeforeAction,responseAfterAction).forEach(o->visitKeys.add(String.valueOf(o.get("VisitKey"))));
        return visitKeys;
    }
}
