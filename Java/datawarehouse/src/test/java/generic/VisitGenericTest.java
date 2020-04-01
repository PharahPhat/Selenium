package generic;

import com.google.gson.Gson;
import com.sandata.entity.molina.client.ClientGeneralEntity;
import com.sandata.entity.molina.employee.EmployeeGeneralEntity;
import com.sandata.entity.molina.visit.VisitGeneralEntity;
import com.sandata.models.dwh.ohio.DwhExtract;
import com.sandata.models.dwh.ohio.Visit;
import com.sandata.models.molina.employee.CreateAuthorization;
import com.sandata.models.molina.visit.*;
import com.sandata.models.response.ResponseStatusModel;
import com.interop.common.Commons;
import com.sandata.common.Constant;
import com.sandata.core.report.ExtentTestManager;
import com.sandata.entity.ohio.client.PatientGeneralEntity;
import com.sandata.entity.ohio.employee.WorkerGeneralEntity;
import com.sandata.models.vm.visit.search.VisitSearchResultModel;
import com.sandata.utilities.DbUtilsCon;
import com.sandata.ws.V8WebService;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.sandata.common.Constant.ACCOUNT_TYPE.*;
import static com.sandata.common.Constant.ClientQualifier.ClientCustomID;
import static com.sandata.common.Constant.EmployeeQualifier.EmployeeSSN;
import static com.sandata.common.Constant.PROGRAM_SERVICE_CODE.T1000;
import static com.sandata.common.Constant.REQUEST_TYPE.INTAKE;
import static com.interop.sql.Sql.*;
import static com.interop.sql.Sql.SQL_GET_VISIT_GENERAL;
import static com.interop.sql.VisitSQL.*;

public class VisitGenericTest extends DWHGenericTest {
    V8WebService v8WebService = new V8WebService();
    public Response loginResponse = null;
    public Response searchResponse = null;
    public Response createEmployeeResponse = null;
    public Response updateEmployeeResponse = null;
    public Response updateClientResponse = null;
    public String stxId = "";
    public String visitKey = "";
    public String workerKey = "";
    public String employeeFirstName = "";
    public String updateId = "";

    public String memo;

    public Commons commons = new Commons();
//    Map<String, String> preconditionData = new HashMap<String, String>();

    public void loginV8() {
        Response response = null;
        String requestUrl = baseObj.getEnvironment("v8_login_post");
        loginResponse = v8WebService.login(requestUrl, account, app_userName, app_Password);

        if (loginResponse.getStatusCode() == 200) {
            logPass(String.format("Login successfully.\nurl:%s\n%s accountId:%s\nusername:%s\npassword:\n", requestUrl,
                    state, account, app_userName, app_Password));
        } else {
            logError(String.format("Login successfully.\nurl:%s\nmolina_accountId:%s\nusername:%s\npassword:\n", requestUrl,
                    state, account, app_userName, app_Password));
        }
    }

    public boolean isVisitExistedInDatabase(String accountId, String uniqueMemo) {
        String sql = String.format(SQL_GET_VISIT_BY_ACCOUNT_AND_UNIQUE_MEMO, accountId, uniqueMemo);
        return visitDbService.waitDataExistInDb(sql);
    }

    public void validateVisitCallRejectWithMemoOver512Chars (String memo) {
        boolean result = false;
        switch (state) {
            case "MOLINA":
                result = checkCreateVisitCallWithMemo(memo);
                break;
            case "OHIO":
                break;
            case "CONNECTICUT":
                break;
        }

        if (result == false) {
            logPass(String.format("visit call rejected memo that has max length greater than 512 chars. Memo '%s', memo length: %s", memo, memo.length()));
        } else {
            logError(String.format("visit call not rejected memo that has max length greater than 512 chars. Memo '%s', memo length: %s", memo, memo.length()));
        }
        Assert.assertFalse(result);
    }

    public boolean checkCreateVisitCallWithMemo(String memo) {
        List<VisitGeneralEntity> visitGeneralEntities = null;
        boolean result;

        clientGeneralEntity =
                (ClientGeneralEntity)clientWebService.createClient(MOLINA, INTAKE);

        employeeGeneralEntity =
                (EmployeeGeneralEntity)employeeWebService.createEmployee(MOLINA, INTAKE);

        visitGeneralEntities = visitWebService.initializeVisitMolinaData(account, providerId,
                EmployeeSSN, employeeGeneralEntity.EmployeeIdentifier,
                ClientCustomID, clientGeneralEntity.ClientMedicaidID, clientGeneralEntity.ClientID);
        visitGeneralEntities.get(0).Memo = memo;

        Response response = visitWebService.callRequestToCreateVisit(account, providerId, visitGeneralEntities);
        ResponseStatusModel responseStatusModel = new Gson().fromJson(response.body().asString(), ResponseStatusModel.class);
        if (responseStatusModel.status.equalsIgnoreCase("FAILED")) {
            return false;
        }
        return true;
    }

    public void initVisitCallWithMemo(String memo) {
        switch (state) {
            case "MOLINA":
                initMolinaVisitCallWithMemo(memo);
                break;
            case "OHIO":
                break;
            case "CONNECTICUT":
                break;
        }
    }

    public void initMolinaVisitCallWithMemo(String memo) {
        List<VisitGeneralEntity> visitGeneralEntities = null;

        clientGeneralEntity =
                (ClientGeneralEntity)clientWebService.createClient(MOLINA, INTAKE);

        employeeGeneralEntity =
                (EmployeeGeneralEntity)employeeWebService.createEmployee(MOLINA, INTAKE);

        visitGeneralEntities = visitWebService.initializeVisitMolinaData(account, providerId,
                EmployeeSSN, employeeGeneralEntity.EmployeeIdentifier,
                ClientCustomID, clientGeneralEntity.ClientMedicaidID, clientGeneralEntity.ClientID);
        visitGeneralEntities.get(0).Memo = memo;

        createVisitCallWithUserInput(MOLINA, visitGeneralEntities);
    }

    public void createVisitCallWithUserInput(Constant.ACCOUNT_TYPE accountType, List<VisitGeneralEntity> visitGeneralEntities) {
        switch (accountType) {
            case MOLINA:

                visitGeneralEntity =
                        (VisitGeneralEntity) visitWebService.createMolinaVisitWithUserInput(
                                EmployeeSSN, employeeGeneralEntity.EmployeeIdentifier,
                                ClientCustomID, clientGeneralEntity.ClientMedicaidID, clientGeneralEntity.ClientID,
                                visitGeneralEntities);
                break;
            case OHIO:
                break;
            case CONNECTICUT:
            default:
                break;
        }
    }

    public void createVisitCall(Constant.ACCOUNT_TYPE accountType) {
        switch (accountType) {
            case MOLINA:
                clientGeneralEntity =
                        (ClientGeneralEntity)clientWebService.createClient(MOLINA, INTAKE);

                employeeGeneralEntity =
                        (EmployeeGeneralEntity)employeeWebService.createEmployee(MOLINA, INTAKE);

                    visitGeneralEntity =
                            (VisitGeneralEntity) visitWebService.createVisit(accountType, INTAKE,
                                    EmployeeSSN, employeeGeneralEntity.EmployeeIdentifier,
                                    ClientCustomID, clientGeneralEntity.ClientMedicaidID, clientGeneralEntity.ClientID);
                break;
            case OHIO:
                ohioClientEntity = (PatientGeneralEntity)clientWebService.createClient(OHIO, INTAKE);
                ohioWorkerEntity = (WorkerGeneralEntity)employeeWebService.createEmployee(OHIO, INTAKE);
                ohioVisitEntity =
                        (com.sandata.entity.ohio.visit.VisitGeneralEntity) visitWebService.createOhioVisit(
                                ohioWorkerEntity.StaffOtherID,
                                ohioClientEntity.PatientOtherID,
                                ohioClientEntity.PatientMedicaidID );
                break;
            case CONNECTICUT:
            default:
                break;
        }
    }

    public void createVerifiedVisitCall(Constant.ACCOUNT_TYPE accountType) {
        switch (accountType) {
            case MOLINA:
                clientGeneralEntity =
                        (ClientGeneralEntity)clientWebService.createClient(MOLINA, INTAKE);

                employeeGeneralEntity =
                        (EmployeeGeneralEntity)employeeWebService.createEmployee(MOLINA, INTAKE);

                visitGeneralEntity =
                        (VisitGeneralEntity) visitWebService.createMolinaVerifiedVisit(
                                EmployeeSSN, employeeGeneralEntity.EmployeeIdentifier,
                                ClientCustomID, clientGeneralEntity.ClientMedicaidID, clientGeneralEntity.ClientID);
                break;
            case OHIO:
                //TODO: to be implemented
                break;
            case CONNECTICUT:
                //TODO: to be implemented
            default:
                break;
        }
    }

    public void createVisitCall() {
        switch (state) {
            case "MOLINA":
                createVisitCall(MOLINA);
                break;
            case "OHIO":
                createVisitCall(OHIO);
                break;
            case "CONNECTICUT":
                createVisitCall(CONNECTICUT);
                break;
        }
    }

    public void createVerifiedVisitCall() {
        switch (state) {
            case "MOLINA":
                createVerifiedVisitCall(MOLINA);
                loginV8();
                createMolinaClientAuthorization(T1000.toString());
                searchVisitUI(clientGeneralEntity.ClientLastName, clientGeneralEntity.ClientFirstName);
                updateService(Constant.PAYER_ID.MEDHHS, T1000.toString(), "19", adjustedIn, adjustedOut);
                break;
            case "OHIO":
                createVisitCall(OHIO);
                break;
            case "CONNECTICUT":
                createVisitCall(CONNECTICUT);
                break;
            default:
                break;
        }
    }

    public void createVisitClaim() {
        switch (state) {
            case "MOLINA":
                createVerifiedVisitCall();
                claimVisit(serviceDate, clientGeneralEntity.ClientMedicaidID, T1000.toString());
                break;
            case "OHIO":
                createVisitCall(OHIO);
                break;
            case "CONNECTICUT":
                createVisitCall(CONNECTICUT);
                break;
            default:
                break;
        }
    }

    public void updateService(Constant.PAYER_ID payerId,
                              String serviceCode, String programCode, String adjustedIn, String adjustedOut) {
        visitKey = getVisitKeyBy(account, clientGeneralEntity.ClientFirstName);
        updateId = getUpdateIdByVisitKey(visitKey);

        Response response = v8WebService.updateService(visitKey, updateId, payerId.toString(), serviceCode, programCode,
                adjustedIn, adjustedOut);
        if (response.getStatusCode() == 200) {
            logPass(String.format("request to update visit service code '%s' successfully", serviceCode));
        } else {
            logError(String.format("Failed update visit service code '%s'. esponse.getStatusCode: %s",serviceCode, response.getStatusCode()));
        }
    }

    public ClientGeneralEntity createClient(Constant.ACCOUNT_TYPE accountType) {
        ClientGeneralEntity clientGeneralEntity = null;
        switch (accountType) {
            case MOLINA:
                clientGeneralEntity = (ClientGeneralEntity)clientWebService.createClient(MOLINA, INTAKE);
                break;
            case OHIO:
                clientGeneralEntity = (ClientGeneralEntity)clientWebService.createClient(OHIO, INTAKE);
                break;
            case CONNECTICUT:
                clientGeneralEntity = (ClientGeneralEntity)clientWebService.createClient(CONNECTICUT, INTAKE);
                break;
            default:
                break;
        }
        return clientGeneralEntity;
    }

    public ClientGeneralEntity createClient() {
        ClientGeneralEntity clientGeneralEntity = null;
        switch (state) {
            case "MOLINA":
                clientGeneralEntity = createClient(MOLINA);
                break;
            case "OHIO":
                clientGeneralEntity = createClient(OHIO);
                break;
            case "CONNECTICUT":
                clientGeneralEntity = createClient(CONNECTICUT);
                break;
        }
        return clientGeneralEntity;
    }

    public EmployeeGeneralEntity createEmployee(Constant.ACCOUNT_TYPE accountType) {
        EmployeeGeneralEntity employeeGeneralEntity = null;
        switch (accountType) {
            case MOLINA:
                employeeGeneralEntity = (EmployeeGeneralEntity)employeeWebService.createEmployee(MOLINA, INTAKE);
                break;
            case OHIO:
                employeeGeneralEntity = (EmployeeGeneralEntity)employeeWebService.createEmployee(OHIO, INTAKE);
                break;
            case CONNECTICUT:
                employeeGeneralEntity = (EmployeeGeneralEntity)employeeWebService.createEmployee(CONNECTICUT, INTAKE);
                break;
            default:
                break;
        }
        return employeeGeneralEntity;
    }

    public EmployeeGeneralEntity intake_createEmployee() {
        EmployeeGeneralEntity employeeGeneralEntity = null;
        switch (state) {
            case "MOLINA":
                employeeGeneralEntity = createEmployee(MOLINA);
                break;
            case "OHIO":
                employeeGeneralEntity = createEmployee(OHIO);
                break;
            case "CONNECTICUT":
                employeeGeneralEntity = createEmployee(CONNECTICUT);
                break;
        }
        return employeeGeneralEntity;
    }

    /**
     * Query to DB then get visitKey by a unique memo
     * @param uniqueMemo
     * @return
     */
    public String getVisitKeyByUniqueMemo(String uniqueMemo) {
        String sql = String.format(GET_SQL_GET_VISIT_KEY_BY_UNIQUE_MEMO, uniqueMemo);
        Object visitKey = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("VISITKEY");
        return String.valueOf(visitKey);
    }

    public String getVisitKeyByUniqueMemo(String accountId, String uniqueMemo) {
        String sql = String.format(SQL_GET_VISIT_BY_ACCOUNT_AND_UNIQUE_MEMO, accountId, uniqueMemo);
        Object visitKey = null;
        dataTable = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql);
        if ( dataTable.size() < 1 ) {
            logError(String.format("No record found for sccount '%s' and unique memo '%s'", accountId, uniqueMemo));
        } else {
            logStepInfo(String.format("Record found for account '%s' and unique memo '%s'", accountId, uniqueMemo));
            visitKey = dataTable.get(0).get("VISITKEY");
        }
        return String.valueOf(visitKey);
    }

    /**
     * Query to DB then get visitKey by accountId & clientFirstName
     * @param accountId
     * @param clientFirstName
     * @return {String} visitKey
     */
    public String getVisitKeyBy(String accountId, String clientFirstName) {
        String sql = String.format(SQL_GET_VISIT_KEY_BY_FIRST_NAME, accountId, clientFirstName);
        return getStringOfVisitKey(sql);
    }

    /**
     * Query to DB then get visitKey by below params
     * @param groupKey
     * @param accountId
     * @param providerId
     * @param visitStartDate
     * @param visitEndDate
     * @param fieldValue clientFirstName|memo|...
     * @return
     */
    public String getVisitKeyBy(String groupKey, String accountId, String providerId, String visitStartDate, String visitEndDate, String fieldValue) {
        String sql = String.format(SQL_GET_VISIT_BY_DATE_AND_CLIENT_FIRST_NAME, providerId, accountId, groupKey, visitStartDate, visitEndDate, fieldValue);
        return getStringOfVisitKey(sql);
    }


    /**
     * Query to DB then get visitKey by accountId & clientFirstName & clientLastName & Memo
     * @param accountId
     * @param clientFirstName
     * @param clientLastName
     * @param memo
     * @return {String} visitKey
     */
    public String getVisitKeyBy(String accountId, String clientFirstName,
                                String clientLastName, String memo) {
        String sql = String.format(SQL_GET_VISIT_KEY_BY_MEMO, accountId, clientFirstName,
                clientLastName, memo);
        return getStringOfVisitKey(sql);
    }

    /**
     * Query to DB then get updateId by visitKey
     * @param visitKey
     * @return {String} updateId
     */
    public String getUpdateIdBy(String visitKey) {
        String sql = String.format(SQL_GET_VISIT_UPDATE_ID_BY_VISIT_KEY, visitKey);
        return getStringOfUpdateId(sql);
    }


    public String getVisitKeyBy(String accountId, String clientFirstName, String employeeFirstName, String visitFromDate, String visitToDate) {
        String sql = String.format(SQL_GET_VISIT_KEY_BY_CLIENT_WORKER, accountId, clientFirstName, employeeFirstName, visitFromDate, visitToDate);
        return getStringOfVisitKey(sql);
    }

    public String getCallKeyBy(String visitKey) {
        String sql = String.format(SQL_GET_CALL_KEY_BY, visitKey);
        return getStringOfCallKey(sql);
    }

    public String getProcedureBy(String visitKey) {
        String sql = String.format(SQL_GET_VISIT_PROCEDURE, visitKey);
        return getStringOfVisitProcedure(sql);
    }

    public String getVisitKeyFromVisitLog(String accountId, String clientFirstName, String employeeFirstName, String visitFromDate, String visitToDate) {
        String sql = String.format(SQL_GET_VISIT_KEY_FROM_VISIT_LOGS, accountId, clientFirstName, employeeFirstName, visitFromDate, visitToDate);
        return getStringOfVisitKey(sql);
    }

    private String getStringOfVisitProcedure(String sql) {
        Object procedure = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("SERVICE");
        return String.valueOf(procedure);
    }


    private String getStringOfVisitKey(String sql) {
        Object visitKey = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("VISITKEY");
        return String.valueOf(visitKey);
    }

    private String getStringOfCallKey(String sql) {
        Object visitKey = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("CALLKEY");
        return String.valueOf(visitKey);
    }

    private String getStringOfUpdateId(String sql) {
        Object visitKey = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("UPDATE_ID");
        return String.valueOf(visitKey);
    }

    public List<VisitGeneralModel> mapVisitGeneralTableToModel(String groupKey, String accountId,
                                                               String providerId, String startDate,
                                                               String endDate, String visitKey) {
        String sql = String.format(SQL_GET_VISIT_GENERAL, providerId, accountId, groupKey, startDate, endDate, visitKey);
        return mapDBTableToModel(sql, VisitGeneralModel.class);
    }

    public List<VisitGeneralModel> filterVisitGeneralBy(String visitKey) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitGeneralModel.class, true)
                .stream().filter(visitGeneral -> visitGeneral.getVisitKey().equalsIgnoreCase(visitKey)).collect(Collectors.toList());
    }

    public List<VisitChangesModel> filterVisitChangeBy(String visitKey) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitChangesModel.class, true)
                .stream().filter(visitGeneral -> visitGeneral.getVisitKey().equalsIgnoreCase(visitKey)).collect(Collectors.toList());
    }

    public List<VisitChangesModel> filterVisitChangeByMemo(String memo) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitChangesModel.class, true)
                .stream().filter(visitChangesModel -> visitChangesModel.getVisitChangeLogDetails().contains(memo)).collect(Collectors.toList());
    }

    public List<VisitChangesModel> filterVisitChangeByVisitLogKey(String visitLogKey) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitChangesModel.class, true)
                .stream().filter(visitChangesModel -> visitChangesModel.getSequenceID().contains(visitLogKey)).collect(Collectors.toList());
    }
    public List<VisitExceptionsModel> filterVisitExceptionBy(String visitKey) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitExceptionsModel.class, true)
                .stream().filter(visitExcp -> visitExcp.getVisitKey().equalsIgnoreCase(visitKey)).collect(Collectors.toList());
    }

    public void verifyVisitMemoTruncatedInExportedFile() {
        String visitKey = getVisitKeyBy(account, clientGeneralEntity.ClientFirstName);
        List<VisitGeneralModel> records = filterVisitGeneralBy(visitKey);
        boolean result = false;
        if (records.size() < 1 ) {
            Assert.assertTrue(result, String.format("visit Key %s not found in exported file.", visitKey));
        } else {
            if ( records.get(0).getMemo().length() == 512 ) {
                result = true;
            } else {
                result = false;
            }
            Assert.assertTrue(result, String.format("Memo '%s' has length '%s' in exported file.", records.get(0).getMemo(), records.get(0).getMemo().length()));
        }
    }

    public void verifyVisitMemoInExportedFileMatchWithDB() {
        String visitKey = getVisitKeyBy(account, clientGeneralEntity.ClientFirstName);
        List<VisitGeneralModel> records = filterVisitGeneralBy(visitKey);
        String memoInDB = visitDbService.getVisitFieldValue(visitKey, "MEMO");

        String memoInExportFile = "";
        boolean result = false;
        if (records.size() < 1 ) {
            result = false;
            Assert.assertTrue(result, String.format("visit Key %s not found in exported file.", visitKey));
        } else {
            memoInExportFile = records.get(0).getMemo();
        }

        result = memoInDB.equalsIgnoreCase(memoInExportFile);
        Assert.assertTrue(result, String.format("Memo in export file: %s, memo in DB: %s", memoInExportFile, memoInDB));
    }

    public void verifyVisitGeneralFileDataMatchWithDatabase() {
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("GroupKey"),
                baseObj.readDataValue("AccountId"),
                baseObj.readDataValue("ProviderId"),
                baseObj.readDataValue("VisitStartDate"),
                baseObj.readDataValue("VisitEndDate"),
                baseObj.readDataValue("Client_FirstName"));

        boolean result =
                areRecordsExistedInDatabase(
                        filterVisitGeneralBy(visitKey),
                        mapVisitGeneralTableToModel(baseObj.readDataValue("GroupKey"),
                                baseObj.readDataValue("AccountId"),
                                baseObj.readDataValue("ProviderId"),
                                baseObj.readDataValue("VisitStartDate"),
                                baseObj.readDataValue("VisitEndDate"),
                                visitKey));
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result);
    }

    public void verifyActDurationInExportedFile(String clientFName, String clientLName) {
        boolean result = true;
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));

        List<VisitGeneralModel> visitGeneralFile = filterVisitGeneralBy(visitKey);
        String callInTime = visitGeneralFile.get(0).getCallInDateTime();
        ExtentTestManager.logTestStep("callIn: " + callInTime);
        String callOutTime = visitGeneralFile.get(0).getCallOutDateTime();
        ExtentTestManager.logTestStep("callOut: " + callOutTime);
        String actualActDuration = visitGeneralFile.get(0).getActDuration();
        ExtentTestManager.logTestStep("ActDuration: " + actualActDuration);

        String expectedActDuration = commons.getMinuteTimeDuration(callInTime, callOutTime, "yyyy-MM-dd'T'HH:mm:ssX");
        if(expectedActDuration.equals(actualActDuration)) {
            ExtentTestManager.logPass("ActDuration is calculated correctly");
        } else {
            result = false;
            ExtentTestManager.logFailure(String.format("ActDuration is calculated incorrectly"));
        }
        Assert.assertTrue(result);
    }

    public void verifyAdjDurationInExportedFile(String clientFName, String clientLName) {
        boolean result = true;
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Second_Memo"));

        List<VisitGeneralModel> visitGeneralFile = filterVisitGeneralBy(visitKey);
        String adjBeginningTime = visitGeneralFile.get(0).getAdjBeginningDateTime();
        ExtentTestManager.logTestStep("adjBeginningTime: " + adjBeginningTime);
        String adjEndTime = visitGeneralFile.get(0).getAdjEndDateTime();
        ExtentTestManager.logTestStep("adjEndTime: " + adjEndTime);
        String actualAdjDuration = visitGeneralFile.get(0).getAdjDuration();
        ExtentTestManager.logTestStep("AdjDuration: " + actualAdjDuration);

        String expectedActDuration = commons.getMinuteTimeDuration(adjBeginningTime, adjEndTime, "yyyy-MM-dd'T'HH:mm:ssX");
        if(expectedActDuration.equals(actualAdjDuration)) {
            ExtentTestManager.logPass("AdjDuration is calculated correctly");
        } else {
            result = false;
            ExtentTestManager.logFailure(String.format("AdjDuration is calculated incorrectly"));
        }
        Assert.assertTrue(result);
    }

    public void checkVisitWithStatus(String clientFName, String clientLName, String status, String Memo) {
        boolean result = true;
        String visitKey;
        if(Memo != null) {
            visitKey = getVisitKeyBy(
                    baseObj.readDataValue("AccountId"),
                    clientFName,
                    clientLName,
                    baseObj.readDataValue("Memo"));
        }else{
            visitKey = getVisitKeyBy(account, clientGeneralEntity.ClientFirstName);
        }

        List<VisitGeneralModel> visitGeneralFile = filterVisitGeneralBy(visitKey);
        String actualVisitStatus = visitGeneralFile.get(0).getVisitStatus();
        if(actualVisitStatus.equalsIgnoreCase(status)){
            ExtentTestManager.logPass(String.format("visit status is %s",actualVisitStatus));
        }else{
            result = false;
            ExtentTestManager.logFailure(String.format("visit status is %s", actualVisitStatus));
        }
        Assert.assertTrue(result, "The visit have just created must be 'Incomplete'");
    }

    public void checkVisitWithOmitStatus(String clientFName, String clientLName) {
        boolean result = true;
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));

        List<VisitGeneralModel> visitGeneralFile = filterVisitGeneralBy(visitKey);
        String actualVisitStatus = visitGeneralFile.get(0).getVisitStatus();
        if(actualVisitStatus.equalsIgnoreCase(baseObj.readDataValue("VisitStatus"))){
            ExtentTestManager.logPass("visit status is Deleted");
        }else{
            result = false;
            ExtentTestManager.logFailure(String.format("visit status is %s", actualVisitStatus));
        }
        Assert.assertTrue(result);
    }

    public void verifyChangeIdOfUpdateAdjustedHours(String clientFName, String clientLName) {
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));

        List<VisitChangesModel> visitGeneralFile = filterVisitChangeBy(visitKey);
        String expectedChangeReasonMemo = baseObj.readDataValue("ChangeReasonMemo");
        String expectedChangeId = baseObj.readDataValue("ChangeId");

        boolean result = false;
        for(VisitChangesModel visitChangesModel : visitGeneralFile) {
            String actualChangeReasonMemo = visitChangesModel.getChangeReasonMemo();
            String actualChangeId = visitChangesModel.getChangeID();
            if(actualChangeReasonMemo.equalsIgnoreCase(expectedChangeReasonMemo)
                    && actualChangeId.equalsIgnoreCase(expectedChangeId))
                result = true;
        }

        if(result) {
            ExtentTestManager.logPass("Change ID is 10066 for the updated visit");
        } else {
            ExtentTestManager.logFailure(String.format("Change ID is NOT 10066 for the updated visit."));
        }
        Assert.assertTrue(result);
    }

    public void verifyChangeIdOfVisitTask(String clientFName, String clientLName, String reasonNote) {
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));

        List<VisitChangesModel> visitGeneralFile = filterVisitChangeBy(visitKey);
        String expectedChangeReasonMemo = reasonNote;
        String expectedChangeId = baseObj.readDataValue("ChangeId");

        boolean result = false;
        String actualChangeId = null;
        for(VisitChangesModel visitChangesModel : visitGeneralFile) {
            String actualChangeReasonMemo = visitChangesModel.getChangeReasonMemo();
            actualChangeId = visitChangesModel.getChangeID();
            if(actualChangeReasonMemo.equalsIgnoreCase(expectedChangeReasonMemo)
                    && actualChangeId.equalsIgnoreCase(expectedChangeId))
                result = true;
        }

        if(result) {
            ExtentTestManager.logPass(String.format("Change ID is %s for the updated visit", expectedChangeId));
        } else {
            ExtentTestManager.logFailure(String.format("Change ID is NOT %s for the updated visit, actual is %s", expectedChangeId, actualChangeId));
        }
        Assert.assertTrue(result);
    }

    public boolean isVisitExisted(String clientFName, String clientLName) {
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));

        List<VisitGeneralModel> visitGeneralFile = filterVisitGeneralBy(visitKey);
        if(visitGeneralFile.size() == 0){
            return false;
        }
        return true;
    }

    public void verifyVisitIsNotSentOut(String clientFName, String clientLName) {
        boolean result = isVisitExisted(clientFName,clientLName);
        if(!result){
            ExtentTestManager.logPass("visit is not sent out");
        }else{
            ExtentTestManager.logFailure(String.format("visit is sent out"));
        }
        Assert.assertFalse(result);
    }

    public void verifyVisitIsSentOut(String clientFName, String clientLName) {
        boolean result = isVisitExisted(clientFName,clientLName);
        if(result){
            ExtentTestManager.logPass("visit is sent out");
        }else{
            ExtentTestManager.logFailure(String.format("visit is NOT sent out"));
        }
        Assert.assertTrue(result);
    }

    public void checkProceduceCodeInVisitGeneralSegment(String clientFName, String clientLName) {
        boolean result = true;
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));

        List<VisitGeneralModel> visitGeneralFile = filterVisitGeneralBy(visitKey);

        String expectedVisitProcedureCode = getProcedureBy(visitKey);
        String actualVisitProcedureCode = visitGeneralFile.get(0).getProcedureCode();
        if(actualVisitProcedureCode.equalsIgnoreCase(expectedVisitProcedureCode)){
            ExtentTestManager.logPass("Visit Procedure Code is correctly");
        }else{
            result = false;
            ExtentTestManager.logFailure(String.format("Visit Procedure Code is ", actualVisitProcedureCode));
        }

        if(actualVisitProcedureCode.length() <= 5)
            ExtentTestManager.logPass(String.format("Procedure Code length is %s", actualVisitProcedureCode));
        else{
            result = false;
            ExtentTestManager.logFailure(String.format("Procedure Code length is incorrectly, actual is %s, expected is <= 5", actualVisitProcedureCode));
        }
        Assert.assertTrue(result);
    }

    public void createMolinaClientAuthorization(String serviceCode) {
        String beginDate = commons.getDateString(-10, "MM/dd/yyyy");
        String endDate = commons.getDateString(20, "MM/dd/yyyy");
        String randNum = RandomStringUtils.randomNumeric(16);
        CreateAuthorization createAuthorization = new CreateAuthorization();
        createAuthorization.accountId = account;
        createAuthorization.clientKey = clientDbService.getClientFieldValue(
                account, clientGeneralEntity.ClientLastName, "CLIENTKEY");
        createAuthorization.primarySearch = "false";
        createAuthorization.isActiveClientHidden = "true";
        createAuthorization.clientId = clientGeneralEntity.ClientID;
        createAuthorization.radio_action_group = "on";
        createAuthorization.selectedClientId = clientGeneralEntity.ClientID;
        createAuthorization.selectedClientName = clientGeneralEntity.ClientLastName + ", " + clientGeneralEntity.ClientFirstName;
        createAuthorization.selectedClientKey = createAuthorization.clientKey;
        createAuthorization.authorizationId = "";
        createAuthorization.contract = "MEDHHS";
        createAuthorization.referenceNumber = randNum;
        createAuthorization.authorizationTypeId = "3";
        createAuthorization.maxUnitsAlocated = "10";
        createAuthorization.beginDate = beginDate;
        createAuthorization.endDate = endDate;
        createAuthorization.comment = "create molina client auth";
        createAuthorization.authorizationLimitTypeId = "1";
        createAuthorization.limitationService = "";
        createAuthorization.Service = serviceCode;

        Response response = v8WebService.createAuthorization(createAuthorization);
        if (response.getStatusCode() == 200) {
            logPass("request to create authorization successfully. Program service code: " + createAuthorization.Service);
        } else {
            logError("Failed running request create authorization." + response.getStatusCode() + " Program service code: " + createAuthorization.Service);
        }
    }

    public void createMolinaClientAuthorization(String accountId, String serviceCode, String clientFName, String clientLName) {
        String clientId = getClientIdBy(accountId, clientFName, clientLName);
        String clientKey = getClientKeyBy(clientId);
        String beginDate = commons.getDateString(-1, "MM/dd/yyyy");
        String endDate = commons.getDateString(-1, "MM/dd/yyyy");
        String randNum = RandomStringUtils.randomNumeric(16);
        CreateAuthorization createAuthorization = new CreateAuthorization();
        createAuthorization.accountId = accountId;
        createAuthorization.clientKey = clientKey;
        createAuthorization.primarySearch = "false";
        createAuthorization.isActiveClientHidden = "true";
        createAuthorization.clientId = clientId;
        createAuthorization.radio_action_group = "on";
        createAuthorization.selectedClientId = clientId;
        createAuthorization.selectedClientName = clientLName + ", " + clientFName;
        createAuthorization.selectedClientKey = clientKey;
        createAuthorization.authorizationId = "";
        createAuthorization.contract = "MEDHHS";
        createAuthorization.referenceNumber = randNum;
        createAuthorization.authorizationTypeId = "3";
        createAuthorization.maxUnitsAlocated = "10";
        createAuthorization.beginDate = beginDate;
        createAuthorization.endDate = endDate;
        createAuthorization.comment = "create molina client auth";
        createAuthorization.authorizationLimitTypeId = "1";
        createAuthorization.limitationService = "";
        createAuthorization.Service = serviceCode;

        Response response = v8WebService.createAuthorization(createAuthorization);
        if (response.getStatusCode() == 200) {
            logPass("request to create authorization successfully. Program service code: " + createAuthorization.Service);
        } else {
            logError("Failed running request create authorization." + response.getStatusCode() + " Program service code: " + createAuthorization.Service);
        }
    }

    public Response searchVisitUI(String ClientLastName, String ClientFirstName) {
        SearchVisit searchVisit = new SearchVisit();
        String visitStartDate = commons.getDateString(-15, "M/dd/yyyy");
        String visitEndDate = commons.getDateString(0, "M/dd/yyyy");
        searchVisit.setVisitsFromDate(visitStartDate);
        searchVisit.setVisitsToDate(visitEndDate);
        searchVisit.setClient(ClientLastName + ", " + ClientFirstName);

        searchResponse = v8WebService.searchVisit(baseObj.getEnvironment("v8_search_post"), searchVisit);
        if (searchResponse.getStatusCode() == 200) {
            logPass(String.format("Search successfully.\n Search Credential: %s", searchVisit.toString()));
        } else {
            logError(String.format("Failed Searching.\n Search Credential: %s. Status: %s", searchVisit.toString(), searchResponse.getStatusCode()));
        }
        return searchResponse;
    }

    public String getUpdateIdByVisitKey(String visitKey) {
        VisitSearchResultModel visitSearchResultModel = new Gson().fromJson(searchResponse.body().asString(), VisitSearchResultModel.class);
        return visitSearchResultModel.getUpdateIdByVisitKey(visitKey);
    }

    public void VerifyVisitGeneralFileMatchDb(String accountId, String clientFName, String clientLName, String memo,
                                              String startDate, String endDate) {
        String visitKey = getVisitKeyBy(accountId, clientFName, clientLName, memo);
        List<VisitGeneralModel> visitGeneralFileList = filterVisitGeneralBy(visitKey);
        List<VisitGeneralModel> visitGeneralDbList = mapVisitGeneralTableToModel(
                groupkey, accountId, providerId, startDate, endDate, visitKey);
        boolean result = areRecordsExistedInDatabase(visitGeneralFileList, visitGeneralDbList);
        if(result) {
            ExtentTestManager.logPass(
                    String.format("Data of visitKey %s is displayed correctly in Visit General File", visitKey));
        }else {
            ExtentTestManager.logFailure(
                    String.format("Data of visitKey %s is NOT displayed correctly in Visit General File", visitKey));
        }
        Assert.assertTrue(result,
                String.format("Data of visitKey %s is NOT displayed correctly in Visit General File", visitKey));
    }

    public List<VisitTasksModel> filterVisitTaskBy(String visitKey) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitTasksModel.class, true)
                .stream().filter(visitGeneral -> visitGeneral.getVisitKey().equalsIgnoreCase(visitKey)).collect(Collectors.toList());
    }

    public List<VisitTasksModel> mapVisitTasksTableToModel(String visitKey) {
        String updateId = getUpdateIdBy(visitKey);
        String sql = String.format(SQL_GET_VISIT_TASK, updateId, visitKey);
        return mapDataTableToModel(sql, VisitTasksModel.class);
    }

    public void VerifyVisitTaskFileMatchDb(String accountId, String clientFName, String clientLName, String memo) {
        String visitKey = getVisitKeyBy(accountId, clientFName, clientLName, memo);
        List<VisitTasksModel> visitTaskFileList = filterVisitTaskBy(visitKey);
        List<VisitTasksModel> visitTaskDbList = mapVisitTasksTableToModel(visitKey);
        boolean result = areRecordsExistedInDatabase(visitTaskFileList, visitTaskDbList);
        if(result) {
            ExtentTestManager.logPass(
                    String.format("Data of visitKey %s is displayed correctly in Visit Task File", visitKey));
        }else {
            ExtentTestManager.logFailure(
                    String.format("Data of visitKey %s is NOT displayed correctly in Visit Task File", visitKey));
        }
        Assert.assertTrue(result,
                String.format("Data of visitKey %s is NOT displayed correctly in Visit Task File", visitKey));
    }

    public List<VisitChangesModel> mapVisitChangelTableToModel(String visitKey) {
        String sql = String.format(SQL_GET_VISIT_LOG, visitKey);
        return mapDataTableToModel(sql, VisitChangesModel.class);
    }

    public void VerifyVisitChangeFileMatchDb(String accountId, String clientFName, String clientLName, String memo) {
        String visitKey = getVisitKeyBy(accountId, clientFName, clientLName, memo);
        List<VisitChangesModel> visitChangesFileList = filterVisitChangeBy(visitKey);
        List<VisitChangesModel> visitChangeDbList = mapVisitChangelTableToModel(visitKey);
        boolean result = areRecordsExistedInDatabase(visitChangesFileList, visitChangeDbList);
        if(result) {
            ExtentTestManager.logPass(
                    String.format("Data of visitKey %s is displayed correctly in Visit Change File", visitKey));
        }else {
            ExtentTestManager.logFailure(
                    String.format("Data of visitKey %s is NOT displayed correctly in Visit Change File", visitKey));
        }
        Assert.assertTrue(result,
                String.format("Data of visitKey %s is NOT displayed correctly in Visit General File", visitKey));
    }

    public List<VisitExceptionsModel> mapVisitExceptionTableToModel(String groupKey, String visitKey) {
        String sql = String.format(SQL_GET_VISIT_EXCEPTION, groupKey, visitKey);
        return mapDBTableToModel(sql, VisitExceptionsModel.class);
    }

    public boolean areVisitExceptionRecordsExistedInDatabase(List<VisitExceptionsModel> fileRecords,
                                                             List<VisitExceptionsModel> dbRecords) {
        boolean result = true;
        for (VisitExceptionsModel fileRecord : fileRecords) {
            if (!isVisitExceptionRecordExistedInDatabase(fileRecord, dbRecords)) {
                result = false;
                ExtentTestManager.logTestStep(String.format("File record not found in db: [%s,%s]",
                        fileRecord.getVisitKey(), fileRecord.getExceptionID()));
            } else {
                ExtentTestManager.logTestStep(String.format("File record found in db: [%s, %s]",
                        fileRecord.getVisitKey(), fileRecord.getExceptionID()));
            }
        }
        return result;
    }

    public boolean isVisitExceptionRecordExistedInDatabase(VisitExceptionsModel fileRecord, List<VisitExceptionsModel> dbRecords) {
        for (VisitExceptionsModel record : dbRecords) {
            if (fileRecord.verifyFieldValue(record)) {
                return true;
            }
        }
        return false;
    }

    public void verifyVisitExceptionFileDataMatchWithDatabase(String accountId, String clientFName,
                                                              String clientLName, String memo) {
        String visitKey = getVisitKeyBy(account, clientFName, clientLName, memo);
        boolean result =
                areVisitExceptionRecordsExistedInDatabase(
                        filterVisitExceptionBy(visitKey),
                        mapVisitExceptionTableToModel(groupkey, visitKey));
        if(result) {
            ExtentTestManager.logPass(String.format("Data of visitKey %s is displayed correctly in Visit Exp File", visitKey));
        } else {
            ExtentTestManager.logFailure(String.format("Data of visitKey %s is NOT displayed correctly in Visit Exp File", visitKey));
        }
        Assert.assertTrue(result, String.format("Data of visitKey %s is NOT displayed correctly in Visit Exp File", visitKey));
    }

    public List<VisitCallsModel> mapVisitCallsTableToModel(String accountId, String visitKey) {
        String sql = String.format(SQL_GET_VISIT_CALL, accountId, visitKey);
        return mapDataTableToModel(sql, VisitCallsModel.class);
    }

    public List<VisitCallsModel> filterVisitCallsBy(String visitKey) {
        return  filterVisitCallsBy(mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitCallsModel.class,true),
                visitKey);
    }

    private List<VisitCallsModel> filterVisitCallsBy(List<VisitCallsModel> list, String visitKey) {
        List<VisitCallsModel> visitCallsModels = list.
                stream().
                filter(visitGeneral -> visitGeneral.getVisitKey().equalsIgnoreCase(visitKey)).
                collect(Collectors.toList());
        return visitCallsModels;
    }

    public void verifyVisitCallFileDataMatchWithDatabase(String accountId, String clientFName,
                                                         String clientLName, String memo) {
        String visitKey = getVisitKeyBy(accountId, clientFName, clientLName, memo);
        boolean result =
                areRecordsExistedInDatabase(
                        filterVisitCallsBy(visitKey),
                        mapVisitCallsTableToModel(accountId,
                                visitKey));
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result);
    }

    public List<VisitClaimstModel> filterVisitClaimsBy(String visitKey) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitClaimstModel.class)
                .stream().filter(visitClaimst -> visitClaimst.getVisitKey().equalsIgnoreCase(visitKey)).collect(Collectors.toList());
    }

    public void VerifyVisitClaimInFile(String accountId, String clientFName, String clientLName, String memo){
        String visitKey = getVisitKeyBy(accountId, clientFName, clientLName, memo);
        List<VisitClaimstModel> visitClaimstModels = filterVisitClaimsBy(visitKey);
        boolean result = false;
        if(visitClaimstModels.size() == 0)
        {
            result = true;
            ExtentTestManager.logPass(String.format("Visit Key %s is NOT displayed in VisitClaim " +
                    "because account %s does not support create visit claim", visitKey, accountId));
        }else {
            ExtentTestManager.logFailure(String.format("Visit Key %s should not be displayed in VisitClaim " +
                    "because account %s does not support create visit claim", visitKey, accountId));
        }
        Assert.assertTrue(result, String.format("Visit Key %s should not be displayed in VisitClaim " +
                "because account %s does not support create visit claim", visitKey, accountId));
    }

    public void verifySpecificAccountIsExported(){
        String firstName  = clientGeneralEntity.getClientFirstName();
        String lastName  =  clientGeneralEntity.getClientLastName();
        String clientId = clientGeneralEntity.getClientID();

        Assert.assertTrue(isClientExist(firstName,lastName,clientId),
                String.format("Client: FirstName = %s, LastName = %s, " +
                        "Loc = %s does not exist in export file",firstName,lastName,clientId));
    }

    public void validateVisitGeneralAsExpectedResults(){
        List<VisitGeneralModel> datas = filterVisitGeneralsBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public void validateVisitGeneralAsExpectedFormat(){
        List<VisitGeneralModel> datas = filterVisitGeneralsBy();
        Assert.assertTrue(datas.size() > 0, "File data is incorrect format");
    }

    public List<VisitGeneralModel> filterVisitGeneralsBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, VisitGeneralModel.class);
    }

    public void validateOhioVisitFromJsonData()  {
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        List<Visit> listVisit =  exportedFile.getVisit();

        Assert.assertTrue(listVisit.get(0).getDataIsNotNull(), "Staff Header is not expected result");
    }
}

