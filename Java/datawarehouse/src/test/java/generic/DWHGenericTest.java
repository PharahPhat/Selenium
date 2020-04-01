package generic;

import com.sandata.common.Constant;
import com.sandata.core.report.ExtentTestManager;
import com.sandata.db.PreconditionDbService;
import com.sandata.entity.claim.ClaimValidationV2;
import com.sandata.entity.claim.EVV_Request;
import com.sandata.entity.connecticut.authorization.AuthorizationEntity;
import com.sandata.entity.molina.client.ClientGeneralEntity;
import com.sandata.entity.molina.employee.EmployeeGeneralEntity;
import com.sandata.entity.molina.visit.VisitGeneralEntity;
import com.sandata.entity.ohio.client.PatientGeneralEntity;
import com.sandata.entity.ohio.employee.WorkerGeneralEntity;
import com.sandata.entity.ohio.exports.JsonOhioExportEntity;
import com.sandata.models.GenericModel;
import com.sandata.models.molina.client.ClientGeneralModel;
import com.sandata.models.molina.employee.EmployeeGeneralModel;
import com.sandata.utilities.*;
import com.sandata.utilities.sftp.utils.SftpUtils;
import io.restassured.response.Response;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.*;
import static com.sandata.common.Constant.EXTENSION.dat;
import static com.sandata.common.Constant.VERSION.v1;
import static com.interop.sql.Sql.*;
import static com.sandata.utilities.sftp.utils.SftpUtils.DEVSWARMEXPORTDWH;

public class DWHGenericTest extends GenericTest {

    public String fileName;
    public String ohioExportedFileName;

    public List<Map<String, Object>> dataTable;

    public String state;
    public String account;
    public String providerId;
    public String groupkey;
    public String filePrefix;
    public String fileExtension;
    public SPEC_VERSION specVersion;
    public String specNumber;

    public String providerMode;
    public String payerMode;
    public String clientMode;
    public String scheduleMode;
    public String employeeMode;

    public String contract;
    public String spv;

    public String authUserName;
    public String authPassword;
    public String app_userName;
    public String app_Password;

    public String dwh_startDate;
    public String dwh_endDate;

    public String visitStartDateTime;
    public String visitEndDateTime;
    public String dateOfService;
    public String visitKeyClaim;

    public String dwh_startDate_sevv_18186;
    public String dwh_endDate_sevv_18186;

    public String dwh_startDate_sevv_17155;
    public String dwh_endDate_sevv_17155;

    public String caseManager_17155;

    public String call_location;
    public boolean vault;

    public Map<String, String> preconditionData = new HashMap<String, String>();

    public ClientGeneralEntity clientGeneralEntity;
    public EmployeeGeneralEntity employeeGeneralEntity;
    public VisitGeneralEntity visitGeneralEntity;

    public PatientGeneralEntity ohioClientEntity = new PatientGeneralEntity();
    public WorkerGeneralEntity ohioWorkerEntity = new WorkerGeneralEntity();
    public com.sandata.entity.ohio.visit.VisitGeneralEntity ohioVisitEntity = new com.sandata.entity.ohio.visit.VisitGeneralEntity();


    public String dwhResponse = "";

    public String serviceDate = commons.getDateString(-1, "yyyy-MM-dd");
    public String adjustedIn = commons.getDateString(-1, "MM/dd/yyyy") + " 00:00 AM";
    public String adjustedOut = commons.getDateString(-1, "MM/dd/yyyy") + " 00:10 AM";

    public JsonOhioExportEntity[] jsonOhioExportEntities;

    public String employeeHireDate, employeeTermDate;


    public void initStateInfo() {
        state = baseObj.readDataValue("AccountType");
        switch (state) {
            case "MOLINA":
                account = baseObj.getEnvironment("molina_accountId");
                groupkey = baseObj.getEnvironment("molina_groupkey");
                providerId = baseObj.getEnvironment("molina_providerId");
                authUserName = baseObj.getEnvironment("molina_UserName");
                authPassword = baseObj.getEnvironment("molina_Password");
                app_userName = baseObj.getEnvironment("vm_molina_username");
                app_Password = baseObj.getEnvironment("vm_molina_password");
                dwh_startDate = baseObj.getEnvironment("dwh_molina_startDate");
                dwh_endDate = baseObj.getEnvironment("dwh_molina_endDate");
                fileExtension = ".txt";
                specNumber = null;
                break;
            case "OHIO":
                account = baseObj.getEnvironment("ohio_accountId");
                groupkey = "93";
                providerId = baseObj.getEnvironment("ohio_providerId");
                authUserName = baseObj.getEnvironment("ohio_UserName");
                authPassword = baseObj.getEnvironment("ohio_Password");
                app_userName = baseObj.getEnvironment("vm_ohio_username");
                app_Password = baseObj.getEnvironment("vm_ohio_password");
                break;
            case "CONNECTICUT":
                account = baseObj.getEnvironment("connecticut_accountId");
                groupkey = baseObj.getEnvironment("connecticut_groupkey");
                providerId = baseObj.getEnvironment("connecticut_providerId");
                authUserName = baseObj.getEnvironment("connecticut_UserName");
                authPassword = baseObj.getEnvironment("connecticut_Password");
                app_userName = baseObj.getEnvironment("vm_connecticut_username");
                app_Password = baseObj.getEnvironment("vm_connecticut_password");
                dwh_startDate = baseObj.getEnvironment("dwh_molina_startDate");
                dwh_endDate = baseObj.getEnvironment("dwh_molina_endDate");
                fileExtension = ".csv";
                specNumber = "6.0";
                dwh_startDate = baseObj.getEnvironment("dwh_connecticut_startDate");
                dwh_endDate = baseObj.getEnvironment("dwh_connecticut_endDate");
                break;
            case "INDIANA":
                account = baseObj.getEnvironment("indiana_accountId");
                groupkey = baseObj.getEnvironment("indiana_groupkey");
                providerId = baseObj.getEnvironment("indiana_providerId");
                authUserName = baseObj.getEnvironment("indiana_UserName");
                authPassword = baseObj.getEnvironment("indiana_Password");
                app_userName = baseObj.getEnvironment("vm_indiana_username");
                app_Password = baseObj.getEnvironment("vm_indiana_password");
                fileExtension = ".csv";
                specNumber = "5.2";
                dwh_startDate = baseObj.getEnvironment("dwh_indiana_startDate");
                dwh_endDate = baseObj.getEnvironment("dwh_indiana_endDate");
                break;
            case "COLORADO":
                account = baseObj.getEnvironment("colorado_accountId");
                groupkey = baseObj.getEnvironment("colorado_groupkey");
                dwh_startDate = baseObj.getEnvironment("dwh_colorado_startDate");
                dwh_endDate = baseObj.getEnvironment("dwh_colorado_endDate");
                clientMode = baseObj.readDataValue("ClientMode");
                fileExtension = ".dsv";
                specNumber = "6.0";
                break;
            case "VERMONT":
                account = baseObj.getEnvironment("vermont_accountId");
                groupkey = baseObj.getEnvironment("vermont_groupkey");
                dwh_startDate = baseObj.getEnvironment("dwh_vermont_startDate");
                dwh_endDate = baseObj.getEnvironment("dwh_vermont_endDate");
                clientMode = baseObj.readDataValue("ClientMode");
                dwh_startDate_sevv_18186 = baseObj.getEnvironment("dwh_vermont_startDate_SEVV_18186");
                dwh_endDate_sevv_18186 = baseObj.getEnvironment("dwh_vermont_endDate_SEVV_18186");
                dwh_startDate_sevv_17155 = baseObj.getEnvironment("dwh_vermont_startDate_SEVV_17155");
                dwh_endDate_sevv_17155 = baseObj.getEnvironment("dwh_vermont_endDate_SEVV_17155");
                call_location = baseObj.getEnvironment("call_location");
                fileExtension = ".dsv";
                specNumber = "7.3";
                break;
            case "ARIZONA":
                account = baseObj.getEnvironment("arizona_accountId");
                groupkey = baseObj.getEnvironment("arizona_groupkey");
                dwh_startDate = baseObj.getEnvironment("dwh_arizona_startDate");
                dwh_endDate = baseObj.getEnvironment("dwh_arizona_endDate");
                fileExtension = ".dsv";
                specNumber = "7.3";
                break;
            case "HAWAII":
                account = baseObj.getEnvironment("hawaii_accountId");
                groupkey = baseObj.getEnvironment("hawaii_groupkey");
                dwh_startDate = baseObj.getEnvironment("dwh_hawaii_startDate");
                dwh_endDate = baseObj.getEnvironment("dwh_hawaii_endDate");
                fileExtension = ".dsv";
                specNumber = "7.3";
                break;
            case "VERMONT_AUTH":
                account = baseObj.getEnvironment("vermont_accountId_17155");
                groupkey = baseObj.getEnvironment("vermont_groupkey");
                dwh_startDate = baseObj.getEnvironment("dwh_vermont_startDate");
                dwh_endDate = baseObj.getEnvironment("dwh_vermont_endDate");
                clientMode = baseObj.readDataValue("ClientMode");
                dwh_startDate_sevv_17155 = baseObj.getEnvironment("dwh_vermont_startDate_SEVV_17155");
                dwh_endDate_sevv_17155 = baseObj.getEnvironment("dwh_vermont_endDate_SEVV_17155");
                call_location = baseObj.getEnvironment("call_location");
                fileExtension = ".dsv";
                specNumber = "7.3";
                caseManager_17155 = baseObj.getEnvironment("caseManager_17155");

                break;
            case "PENNSYLVANIA":
                account = baseObj.getEnvironment("pennsylvania_accountId");
                groupkey = baseObj.getEnvironment("pennsylvania_groupkey");
                dwh_startDate = baseObj.getEnvironment("dwh_pennsylvania_startDate");
                dwh_endDate = baseObj.getEnvironment("dwh_pennsylvania_endDate");
                clientMode = baseObj.readDataValue("ClientMode");
                fileExtension = ".dsv";
                specNumber = "7.0";
                employeeHireDate = baseObj.readDataValue("employeeHireDate");
                employeeTermDate = baseObj.readDataValue("employeeTermDate");
                break;
            case "OHIO_PROVIDER":
                //get account have provider name is null, should get the company name instead null
                account = baseObj.getEnvironment("ohio_accountId_provider");
                groupkey = "93";
                providerId = baseObj.getEnvironment("ohio_providerId");
                authUserName = baseObj.getEnvironment("ohio_UserName");
                authPassword = baseObj.getEnvironment("ohio_Password");
                app_userName = baseObj.getEnvironment("vm_ohio_username");
                app_Password = baseObj.getEnvironment("vm_ohio_password");
                dwh_startDate = baseObj.getEnvironment("dwh_ohio_startDate_TC_41497");
                dwh_endDate = baseObj.getEnvironment("dwh_ohio_endDate_TC_41497");
                break;
            case "OHIO_CLAIM":
                //get account have provider name is null, should get the company name instead null
                account = baseObj.getEnvironment("ohio_accountId_claim");
                groupkey = "93";
                providerId = baseObj.getEnvironment("ohio_providerId");
                authUserName = baseObj.getEnvironment("ohio_UserName");
                authPassword = baseObj.getEnvironment("ohio_Password");
                app_userName = baseObj.getEnvironment("vm_ohio_username");
                app_Password = baseObj.getEnvironment("vm_ohio_password");
                dwh_startDate = baseObj.getEnvironment("dwh_ohio_startDate_TC_41529");
                dwh_endDate = baseObj.getEnvironment("dwh_ohio_endDate_TC_41529");
                visitStartDateTime = baseObj.getEnvironment("visitStartDateTime");
                visitEndDateTime = baseObj.getEnvironment("visitEndDateTime");
                dateOfService = baseObj.getEnvironment("dateOfService");
                visitKeyClaim = baseObj.getEnvironment("visitKeyClaim");
                break;
        }

        if (baseObj.readDataValue("specVersion") != null) {
            String specVs = baseObj.readDataValue("specVersion");
            if (specVs.equalsIgnoreCase("maine")) {
                specVersion = SPEC_VERSION.maine;
            } else {
                specVersion = SPEC_VERSION.generic;
            }
        } else {
            specVersion = SPEC_VERSION.maine;
        }

        providerMode = baseObj.readDataValue("providerMode") != null ? baseObj.readDataValue("providerMode") : "V";
        if (baseObj.readDataValue("providerMode") != null)
            if (baseObj.readDataValue("providerMode").equals("null")) providerMode = null;

        payerMode = baseObj.readDataValue("payerMode") != null ? baseObj.readDataValue("payerMode") : "V";
        if (baseObj.readDataValue("payerMode") != null)
            if (baseObj.readDataValue("payerMode").equals("null")) payerMode = null;

        clientMode = baseObj.readDataValue("clientMode") != null ? baseObj.readDataValue("clientMode") : "V";
        scheduleMode = baseObj.readDataValue("scheduleMode") != null ? baseObj.readDataValue("scheduleMode") : "V";
        if (baseObj.readDataValue("scheduleMode") != null)
            if (baseObj.readDataValue("scheduleMode").equals("null")) scheduleMode = null;

        employeeMode = baseObj.readDataValue("employeeMode") != null ? baseObj.readDataValue("employeeMode") : "V";
        if (baseObj.readDataValue("employeeMode") != null)
            if (baseObj.readDataValue("employeeMode").equals("null")) employeeMode = null;
        contract = baseObj.readDataValue("contract") != null ? baseObj.readDataValue("contract") : "_ALL";
        spv = baseObj.readDataValue("spv") != null ? baseObj.readDataValue("spv") : "_ALL";
    }

    public void initStateInfo(String accountState) {
        state = accountState;
        switch (state) {
            case "MOLINA":
                account = baseObj.getEnvironment("molina_accountId");
                groupkey = baseObj.getEnvironment("molina_groupkey");
                providerId = baseObj.getEnvironment("molina_providerId");
                authUserName = baseObj.getEnvironment("molina_UserName");
                authPassword = baseObj.getEnvironment("molina_Password");
                app_userName = baseObj.getEnvironment("vm_molina_username");
                app_Password = baseObj.getEnvironment("vm_molina_password");
                specVersion = SPEC_VERSION.maine;
                fileExtension = ".txt";
                break;
            case "OHIO":
                account = baseObj.getEnvironment("ohio_accountId");
                groupkey = baseObj.getEnvironment("ohio_groupkey");
                providerId = baseObj.getEnvironment("ohio_providerId");
                authUserName = baseObj.getEnvironment("ohio_UserName");
                authPassword = baseObj.getEnvironment("ohio_Password");
                app_userName = baseObj.getEnvironment("vm_ohio_username");
                app_Password = baseObj.getEnvironment("vm_ohio_password");
                specVersion = SPEC_VERSION.generic;
                break;
            case "CONNECTICUT":
                account = baseObj.getEnvironment("connecticut_accountId");
                groupkey = baseObj.getEnvironment("connecticut_groupkey");
                providerId = baseObj.getEnvironment("connecticut_providerId");
                authUserName = baseObj.getEnvironment("connecticut_UserName");
                authPassword = baseObj.getEnvironment("connecticut_Password");
                app_userName = baseObj.getEnvironment("vm_connecticut_username");
                app_Password = baseObj.getEnvironment("vm_connecticut_password");
                specVersion = SPEC_VERSION.generic;
                fileExtension = ".csv";
                break;

            case "COLORADO":
                account = baseObj.getEnvironment("colorado_accountId");
                groupkey = baseObj.getEnvironment("colorado_groupkey");
                fileExtension = ".dsv";
                specNumber = "7.1";
                break;
        }
    }

    public List<String> DWHExport() {
        String exportVersion = System.getProperty("dwhExportVersion");
        String exportOhioVersion = System.getProperty("DdwhOhioExportVersion");

        if (exportVersion == null) {
            exportVersion = v1.toString();
        }

        if (exportOhioVersion == null) {
            exportOhioVersion = v1.toString();
        }

        String startDate = commons.getDateString(-2, "yyyy-MM-dd") + "T00:00:00Z";
        String endDate = commons.getDateString(-1, "yyyy-MM-dd") + "T23:59:59Z";

        String response = dwhServices.callDWHExport(
                exportVersion,
                exportOhioVersion,
                baseObj.getTestEnvironment(),
                state,
                null,
                dat,
                specVersion,
                specNumber,
                null,
                null,
                "",
                startDate,
                endDate,
                null,
                null,
                groupkey,
                providerMode,
                payerMode,
                clientMode,
                scheduleMode,
                employeeMode,
                contract,
                spv,
                account
        );

        dwhResponse = response;
        if (state.equalsIgnoreCase(OHIO)) {
            ohioExportedFileName = dwhServices.getOhioExportedFileName(
                    "ODM", "json", response);
        } else {
            exportedFileNames = dwhServices.getFileNamesInExportEVV(
                    response,
                    baseObj.readDataValue("FilePrefix"),
                    baseObj.readDataValue("Extension"),
                    exportVersion, state);
        }
        return exportedFileNames;

    }

    public List<String> DWHExportByState(String startDate, String endDate, PAYER_ID payerId) {
        String exportVersion = System.getProperty("dwhExportVersion");
        String exportOhioVersion = System.getProperty("DdwhOhioExportVersion");

        if (exportVersion == null) {
            exportVersion = v1.toString();
        }

        if (exportOhioVersion == null) {
            exportOhioVersion = v1.toString();
        }

        String response = dwhServices.callDWHExport(
                exportVersion,
                exportOhioVersion,
                baseObj.getTestEnvironment(),
                state,
                payerId,
                dat,
                specVersion,
                specNumber,
                null,
                null,
                "",
                startDate,
                endDate,
                null,
                null,
                groupkey,
                providerMode,
                payerMode,
                clientMode,
                scheduleMode,
                employeeMode,
                contract,
                spv,
                account
        );

        if (state.equalsIgnoreCase(OHIO)) {
            ohioExportedFileName = dwhServices.getOhioExportedFileName(
                    "ODM", "json", response);
        } else {
            switch (state) {
                case "MOLINA":
                    filePrefix = "MEDHHS";
                    fileExtension = ".txt";
                    break;
                case "CONNECTICUT":
                    filePrefix = "CTDSS";
                    fileExtension = ".csv";
                    break;
            }

            exportedFileNames = dwhServices.getFileNamesInExportEVV(
                    response,
                    filePrefix,
                    fileExtension,
                    exportVersion, state);
        }
        return exportedFileNames;
    }

    public List<String> DWHExport(String startDate, String endDate) {
        String exportVersion = System.getProperty("dwhExportVersion");
        String exportOhioVersion = System.getProperty("DdwhOhioExportVersion");

        if (exportVersion == null) {
            exportVersion = v1.toString();
        }

        if (exportOhioVersion == null) {
            exportOhioVersion = v1.toString();
        }

        String response = dwhServices.callDWHExport(
                exportVersion,
                exportOhioVersion,
                baseObj.getTestEnvironment(),
                state,
                null,
                dat,
                specVersion,
                specNumber,
                null,
                null,
                "",
                startDate,
                endDate,
                null,
                null,
                groupkey,
                providerMode,
                payerMode,
                clientMode,
                scheduleMode,
                employeeMode,
                contract,
                spv,
                account
        );

        dwhResponse = response;

        if (state.contains(OHIO)) {
            ohioExportedFileName = dwhServices.getOhioExportedFileName(
                    "ODM", "json", response);
        } else {
            switch (state) {
                case "MOLINA":
                    filePrefix = "MEDHHS";
                    fileExtension = ".txt";
                    break;
                case "CONNECTICUT":
                    filePrefix = "CTDSS";
                    fileExtension = ".csv";
                    break;
            }

            exportedFileNames = dwhServices.getFileNamesInExportEVV(
                    response,
                    filePrefix,
                    fileExtension,
                    exportVersion, state);
        }
        return exportedFileNames;
    }

    public List<String> DWHExport(int backDays, String dayRange) {

        String exportVersion = System.getProperty("dwhExportVersion");
        String exportOhioVersion = System.getProperty("DdwhOhioExportVersion");


        if (exportVersion == null) {
            exportVersion = v1.toString();
        }

        if (exportOhioVersion == null) {
            exportOhioVersion = v1.toString();
        }

        String response = dwhServices.callDWHExport(
                exportVersion,
                exportOhioVersion,
                baseObj.getTestEnvironment(),
                state,
                null,
                dat,
                specVersion,
                specNumber,
                null,
                null,
                "",
                null,
                null,
                String.valueOf(backDays),
                dayRange,
                groupkey,
                providerMode,
                payerMode,
                clientMode,
                scheduleMode,
                employeeMode,
                contract,
                spv,
                account
        );

        dwhResponse = response;

        if (state.equalsIgnoreCase(OHIO)) {
            ohioExportedFileName = dwhServices.getOhioExportedFileName(
                    "ODM", "json", response);
        } else {
            switch (state) {
                case "MOLINA":
                    filePrefix = "MEDHHS";
                    fileExtension = ".txt";
                    break;
                case "CONNECTICUT":
                    filePrefix = "CTDSS";
                    fileExtension = ".csv";
                    break;
            }

            exportedFileNames = dwhServices.getFileNamesInExportEVV(
                    response,
                    filePrefix,
                    fileExtension,
                    exportVersion, state);
        }
        return exportedFileNames;
    }

    public List<String> DWHExport(String payerId, String startDate, String endDate) {
        String exportVersion = System.getProperty("dwhExportVersion");
        String exportOhioVersion = System.getProperty("DdwhOhioExportVersion");

        if (exportVersion == null) {
            exportVersion = v1.toString();
        }

        if (exportOhioVersion == null) {
            exportOhioVersion = v1.toString();
        }

        String response = dwhServices.callDWHExport(
                exportVersion,
                exportOhioVersion,
                baseObj.getTestEnvironment(),
                state,
                payerId,
                dat,
                specVersion,
                null,
                null,
                startDate,
                endDate,
                "",
                groupkey,
                providerMode,
                payerMode,
                clientMode,
                scheduleMode,
                employeeMode,
                contract,
                spv,
                account
        );

        if (state.equalsIgnoreCase(OHIO)) {
            ohioExportedFileName = dwhServices.getOhioExportedFileName(
                    "ODM", "json", response);
        } else {
            switch (state) {
                case "MOLINA":
                    filePrefix = "MEDHHS";
                    fileExtension = ".txt";
                    break;
                case "CONNECTICUT":
                    filePrefix = "CTDSS";
                    fileExtension = ".csv";
                    break;
            }

            exportedFileNames = dwhServices.getFileNamesInExportEVV(
                    response,
                    filePrefix,
                    fileExtension,
                    exportVersion, state);
        }
        return exportedFileNames;
    }


    /**
     * Summary: download exported file from SFTP by dataType
     *
     * @param dataType is declared in com.constant.Constant
     *                 PROVIDER_GENERAL
     *                 CLIENT_GENERAL
     *                 CLIENT_PROG
     *                 CLIENT_ELIG
     *                 CLIENT_DIAG
     *                 CLIENT_ADDR
     *                 CLIENT_PHONE
     *                 CLIENT_SCHEDULE
     *                 EMP_GENERAL
     *                 EMP_DISC
     *                 VISIT_GENERAL
     *                 VISIT_CALLS
     *                 VISIT_TASKS
     *                 VISIT_EXCP
     *                 VISIT_CHANGES
     *                 VISIT_CLAIMST
     * @return file object of exported file
     */
    public File downloadExportedFile(String dataType) {
        fileName = commons.getFileNameContain(exportedFileNames, dataType);
        File file = SftpUtils.getFile(DEVSWARMEXPORTDWH, DOWNLOAD_FOLDER, fileName);
        if (file != null) {
            logPass(String.format("file '%s' is downloaded successfully in '%s'", fileName, DOWNLOAD_FOLDER));
        } else {
            logError(String.format("Unable to download file '%s' from '%s'", fileName, Constant.SFTP_FOLDER));
        }
        return file;
    }

    public boolean compare2files(String fullPathFile1, String fullPathFile2) throws IOException {
        File file1 = new File(fullPathFile1);
        File file2 = new File(fullPathFile2);
        return FileUtils.contentEquals(file1, file2);
    }

    public boolean downloadExportedFileOhio() {

        fileName = ohioExportedFileName;
        int count = 8;

        while (count > 0) {
            try {
                File file = SftpUtils.getFile(DEVSWARMEXPORTDWH, DOWNLOAD_FOLDER, fileName);

                if (file != null) {
                    logPass(String.format("file '%s' is downloaded successfully in '%s'", fileName, DOWNLOAD_FOLDER));
                    return true;
                } else {
                    count--;
                    continue;
                }

            } catch (Exception ex) {
                count--;
            }
        }
        return false;
    }

    /**
     * Read content of file then parse to list of model objects
     *
     * @param fileType  csv or txt
     * @param filePath  path of file
     * @param className class name of model to be mapped
     * @return list of model objects
     */
    public <T> List<T> mapDataFileToModel(String fileType, String filePath, Class<T> className) {
        System.out.println("fileType" + fileType);
        System.out.println("filePath" + filePath);
        List<T> modelList = null;
        if (fileType.equalsIgnoreCase("csv") || fileType.equalsIgnoreCase(".csv")) {
            try {
                CSVParser clientParser = CsvUtil.readCSVRecords(new File(filePath), ',', false);
                CsvAnnotationMapper<T> clientMapper = new CsvAnnotationMapper<>(className);
                modelList = clientMapper.map(clientParser);
                clientParser.close();
            } catch (Exception ex) {
                ExtentTestManager.logFailure(String.format("Unable to map '%s' records to model", fileType));
            }

        } else if (fileType.equalsIgnoreCase("txt") || fileType.equalsIgnoreCase(".txt") ||
                fileType.equalsIgnoreCase("generic/dsv") || fileType.equalsIgnoreCase(".dsv")) {
            List<String> records = TextUtil.readTextFileRecords(filePath);
            TextUtil<T> txtUtil = new TextUtil<>(className);
            try {
                modelList = txtUtil.mapTxtToModel(records);
            } catch (Exception ex) {
                ExtentTestManager.logFailure(String.format("Unable to map '%s' records to model", fileType));
            }
        }
        return modelList;
    }

    /**
     * Read content of file then parse to list of model objects
     *
     * @param fileType      csv or txt
     * @param filePath      path of file
     * @param className     class name of model to be mapped
     * @param byColumnIndex
     * @param <T>
     * @return
     */
    public <T> List<T> mapDataFileToModel(String fileType, String filePath, Class<T> className, boolean byColumnIndex) {
        if (!byColumnIndex) {
            return mapDataFileToModel(fileType, filePath, className);
        }
        List<T> modelList = null;
        if (fileType.equalsIgnoreCase("csv") || fileType.equalsIgnoreCase(".csv")) {
            try {
                CSVParser clientParser = CsvUtil.readCSVRecords(new File(filePath), ',', false);
                CsvAnnotationMapper<T> clientMapper = new CsvAnnotationMapper<>(className);
                modelList = clientMapper.map(clientParser);
                clientParser.close();
            } catch (Exception ex) {
                ExtentTestManager.logFailure(String.format("Unable to map '%s' records to model", fileType));
            }

        } else if (fileType.equalsIgnoreCase("txt") || fileType.equalsIgnoreCase(".txt")) {
            List<String> records = TextUtil.readTextFileRecords(filePath);
            TextUtil<T> txtUtil = new TextUtil<>(className);
            try {
                modelList = txtUtil.mapTxtToModelByColumnIndex(records);
            } catch (Exception ex) {
                ExtentTestManager.logFailure(String.format("Unable to map '%s' records to model", fileType));
            }
        }
        return modelList;
    }

    /**
     * Read content of data table then parse to list of model objects
     *
     * @param sql       query to select records in database
     * @param className class name of model to be mapped
     * @return list of model objects
     */
    public <T> List<T> mapDataTableToModel(String sql, Class<T> className) {
        List<T> records = null;
        try {
            ColumnAnnotationMapper<T> mapper = new ColumnAnnotationMapper<>(className);
            records = mapper.map(DbUtilsCon.getResultSetFromQuery(
                    DbUtilsCon.createConnection(
                            baseObj.getTestEnvironment().getOracleUrl(),
                            baseObj.getTestEnvironment()), sql));
        } catch (Exception ex) {
            ExtentTestManager.logFailure(ex.getMessage());
        }
        return records;
    }

    /**
     * Read content of data table then parse to list of model objects
     *
     * @param sql       query to select records in database
     * @param className class name of model to be mapped
     * @return list of model objects
     */
    public <T> List<T> mapDBTableToModel(String sql, Class<T> className) {
        List<T> records = null;
        try {
            ColumnAnnotationMapper<T> mapper = new ColumnAnnotationMapper<>(className);
            records = mapper.DataTableMapper(DbUtilsCon.getResultSetFromQuery(
                    DbUtilsCon.createConnection(
                            baseObj.getTestEnvironment().getOracleUrl(),
                            baseObj.getTestEnvironment()), sql));
        } catch (Exception ex) {
            ExtentTestManager.logFailure(String.format("Unable to connect to DB"));
        }
        return records;
    }

    /**
     * Summary: Verify all exported files exists in SFTP server by type
     *
     * @param numberFilesExpected is declared in com.constant.Constant
     *                            PROVIDER_GENERAL
     *                            CLIENT_GENERAL
     *                            CLIENT_PROG
     *                            CLIENT_ELIG
     *                            CLIENT_DIAG
     *                            CLIENT_ADDR
     *                            CLIENT_PHONE
     *                            CLIENT_SCHEDULE
     *                            EMP_GENERAL
     *                            EMP_DISC
     *                            VISIT_GENERAL
     *                            VISIT_CALLS
     *                            VISIT_TASKS
     *                            VISIT_EXCP
     *                            VISIT_CHANGES
     *                            VISIT_CLAIMST
     * @return boolean true/false
     */
    public boolean verifyAllExportedFilesExistInSFTP(int numberFilesExpected) {
        boolean result = false;
        int numberFiles = exportedFileNames.size();
        if (numberFiles == numberFilesExpected)
            logPass(String.format("Count the files is correct as expected result: %s files", numberFilesExpected));
        else
            logError(String.format("Count the files is unexpected result: %s files ", numberFilesExpected));

        try {
            for (String fileName : exportedFileNames) {
                if (fileName.contains(CLIENT_AUTH))
                    continue;
                result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + fileName);
                if (!result)
                    break;
            }

        } catch (Exception ex) {
            logError(String.format("Problem when Checking '%s' file in %s: %s", fileName, Constant.SFTP_FOLDER, ex.getMessage()));
        }
        if (result) {
            logPass(String.format("Check '%s' file exists in %s", fileName, Constant.SFTP_FOLDER));
        } else {
            logError(String.format("'%s' file does not exist in SFTP %s", fileName, Constant.SFTP_FOLDER));
        }
        Assert.assertTrue(result, String.format("Some of %s exported files are not exported in sftp server.", numberFilesExpected));
        return result;
    }

    /**
     * Summary: Verify exported files exists in SFTP server by type
     *
     * @param type is declared in com.constant.Constant
     *             PROVIDER_GENERAL
     *             CLIENT_GENERAL
     *             CLIENT_PROG
     *             CLIENT_ELIG
     *             CLIENT_DIAG
     *             CLIENT_ADDR
     *             CLIENT_PHONE
     *             CLIENT_SCHEDULE
     *             EMP_GENERAL
     *             EMP_DISC
     *             VISIT_GENERAL
     *             VISIT_CALLS
     *             VISIT_TASKS
     *             VISIT_EXCP
     *             VISIT_CHANGES
     *             VISIT_CLAIMST
     * @return boolean true/false
     */
    public void verifyExportedFileExistInSFTP(String type) {
        boolean result = false;
        fileName = commons.getFileNameContain(exportedFileNames, type);

        logStepInfo(String.format("Check '%s' file exists in %s", fileName, Constant.SFTP_FOLDER));
        try {
            SftpUtils.SFTP_CONFIG.setHost(baseObj.getEnvironment("sftpHost"));
            SftpUtils.SFTP_CONFIG.setPort(Integer.parseInt(baseObj.getEnvironment("sftpPort")));
            SftpUtils.SFTP_CONFIG.setUsername(baseObj.getEnvironment("sftpUserName"));
            SftpUtils.SFTP_CONFIG.setPassword(baseObj.getEnvironment("sftpPassword"));
            result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + fileName);
        } catch (Exception ex) {
            logError(String.format("Problem when Checking '%s' file in %s: %s", fileName, Constant.SFTP_FOLDER, ex.getMessage()));
        }
        if (result) {
            logPass(String.format("Check '%s' file exists in %s", fileName, Constant.SFTP_FOLDER));
        } else {
            logError(String.format("'%s' file does not exist in SFTP %s", fileName, Constant.SFTP_FOLDER));
        }
        Assert.assertTrue(result, String.format("%s file is not exported in sftp server.", type));
    }

    public void verifyExportedFileIsNotExistInSFTP(String type) {
        boolean result = false;
        fileName = commons.getFileNameContain(exportedFileNames, type);
        logStepInfo(String.format("Check '%s' file exists in %s", fileName, Constant.SFTP_FOLDER));
        try {
            SftpUtils.SFTP_CONFIG.setHost(baseObj.getEnvironment("sftpHost"));
            SftpUtils.SFTP_CONFIG.setPort(Integer.parseInt(baseObj.getEnvironment("sftpPort")));
            SftpUtils.SFTP_CONFIG.setUsername(baseObj.getEnvironment("sftpUserName"));
            SftpUtils.SFTP_CONFIG.setPassword(baseObj.getEnvironment("sftpPassword"));
            result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + fileName,1);
        } catch (Exception ex) {}

        Assert.assertTrue(!result, String.format("%s file should be not exported in sftp server.", type));
    }


    public void verifyExportedFileExistInSFTPOhio(String type) {
        boolean result = false;
        fileName = ohioExportedFileName;
        logStepInfo(String.format("Check '%s' file exists in %s", fileName, Constant.SFTP_FOLDER));
        try {
            int timeout = 50;
            while (timeout > 0) {
                result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + fileName);
                if (result)
                    break;
                timeout--;
            }
        } catch (Exception ex) {
            logError(String.format("Problem when Checking '%s' file in %s: %s", fileName, Constant.SFTP_FOLDER, ex.getMessage()));
        }
        if (result) {
            logPass(String.format("Check '%s' file exists in %s", fileName, Constant.SFTP_FOLDER));
        } else {
            logError(String.format("'%s' file does not exist in SFTP %s", fileName, Constant.SFTP_FOLDER));
        }
        Assert.assertTrue(result, String.format("%s file is not exported in sftp server.", type));
    }

    /**
     * Verify a model object (that is mapped from a file record) exist in a data table
     *
     * @param fileRecord
     * @param dbRecords
     * @param <T>
     * @return true/false
     */
    public <T> boolean isRecordExistedInDatabase(GenericModel<T> fileRecord, List<T> dbRecords) {
        for (T record : dbRecords) {
            if (fileRecord.verifyFieldValue(record)) {
                return true;
            }
        }
        return false;
    }

    public <T extends GenericModel> boolean areRecordsExistedInDatabase(List<T> fileRecords,
                                                                        List<T> dbRecords) {
        boolean result = true;
        for (T fileRecord : fileRecords) {
            if (isRecordExistedInDatabase(fileRecord, dbRecords)) {
                logStepInfo(String.format("File record found in db: \n %s", fileRecord.toString()));
            } else {
                logStepInfo(String.format("File record not found in db: \n %s", fileRecord.toString()));
                result = false;
                break;
            }
        }
        Assert.assertTrue(result, String.format("file records: %s\nDatabase records: %s", fileRecords, dbRecords));
        return result;
    }

    /**
     * Get control file is generated
     *
     * @param fileNames: list file name are generated
     * @return the file name dwh info
     */
    public String GetControlFileIsGenerated(List<String> fileNames) {
        return dwhServices.getFileNameContain(fileNames, Constant.CLIENT_GENERAL)
                .replace(Constant.CLIENT_GENERAL, "Control").replace(".csv", ".dat").replace(".txt", ".dat");
    }

    /**
     * Verify "Control.dat" files is exist in FTP
     *
     * @return true if exist and else
     */
    public boolean verifyExportedDATFileExistInSFTP() {
        boolean result = false;
        fileName = GetControlFileIsGenerated(exportedFileNames);
        ExtentTestManager.logTestStep(String.format("Check '%s' file exists in %s", fileName, Constant.SFTP_FOLDER));
        try {
            result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + fileName);
        } catch (Exception ex) {
            logError(String.format("Problem when Checking '%s' file in %s: %s", fileName, Constant.SFTP_FOLDER, ex.getMessage()));
        }
        if (result) {
            logPass(String.format("Check '%s' file exists in %s", fileName, Constant.SFTP_FOLDER));
        } else {
            logError(String.format("'%s' file does not exist in SFTP %s", fileName, Constant.SFTP_FOLDER));
        }
        Assert.assertTrue(result, String.format("%s is not exported to sftp server", fileName));
        return result;
    }

    /**
     * Query to DB then get clientId by accountId & clientFirstName & clientLastName
     *
     * @param accountId
     * @param clientFName
     * @param clientLName
     * @return {String} clientId
     */
    public String getClientIdBy(String accountId, String clientFName, String clientLName) {
        String sql = String.format(SQL_GET_CLIENT_ID_BY_NAME, clientFName, clientLName, accountId);
        Object clientId = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("LOC");
        return String.valueOf(clientId);
    }

    public String getClientIdBy(String accountId, String clientLName) {
        String sql = String.format(SQL_GET_CLIENT_ID_BY_LAST_NAME, clientLName, accountId);
        List<Map<String, Object>> dataTable = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql);
        if (dataTable.size() < 1) {
            logError(String.format("Client with last name '%s', account '%s' not found in database", clientLName, account));
            return "";
        } else {
            logStepInfo(String.format("Client with last name '%s', account '%s' found in database", clientLName, account));
        }
        Object clientId = dataTable.get(0).get("LOC");
        return String.valueOf(clientId);
    }

    public String getClientKeyBy(String accountId, String clientLName) {
        String sql = String.format(SQL_GET_CLIENT_KEY_BY_ACCOUNT_AND_LASTNAME, accountId, clientLName);
        List<Map<String, Object>> dataTable = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql);
        if (dataTable.size() < 1) {
            logError(String.format("Client with last name '%s', account '%s' not found in database", clientLName, account));
            return "";
        } else {
            logStepInfo(String.format("Client with last name '%s', account '%s' found in database", clientLName, account));
        }
        Object clientKey = dataTable.get(0).get("CLIENTKEY");
        return String.valueOf(clientKey);
    }

    /**
     * Query to DB then get clientKey by clientId
     *
     * @param clientId
     * @return {String} clientKey
     */
    public String getClientKeyBy(String clientId) {
        String sql = String.format(SQL_GET_CLIENT_KEY, clientId);
        Object payerId = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("CLIENTKEY");
        return String.valueOf(payerId);
    }

    /**
     * Verify client exist in DWH file
     *
     * @param firstName
     * @param lastName
     * @param loc       (ClientId)
     * @return {String} true if exist, false if not
     */
    public boolean isClientExist(String firstName, String lastName, String loc) {
        return !mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, ClientGeneralModel.class)
                .stream()
                .filter(clientGen -> clientGen.getClientFirstName().equalsIgnoreCase(firstName))
                .filter(clientGen -> clientGen.getClientLastName().equalsIgnoreCase(lastName))
                .filter(clientGen -> clientGen.getClientID().equalsIgnoreCase(loc))
                .collect(Collectors.toList()).isEmpty();
    }

    public <T> void verifyFieldsNotNull(Class<T> type) {
        boolean result = false;
        List<T> fileRecords = mapDataFileToModel(baseObj.readDataValue("Extension"),
                DOWNLOAD_FOLDER + "/" + fileName,
                type, true);
        if (fileRecords.size() < 1) {
            result = false;
            logError("Number of records in exported file is 0");
        } else {
            result = ((GenericModel) fileRecords.get(0)).verifyFieldsNotNull();
            if (result) {
                logPass("All the fields are not null");
            } else {
                logError("Failed to verify field not null");
            }
        }
        Assert.assertTrue(result, "Some of fields in export file " + fileName + " are not null");
    }

    public List<EmployeeGeneralModel> getEmployee(String accountId, String employeeFName, String employeeLName) {
        String sql = String.format(SQL_GET_EMPLOYEE_GENERAL_BY, employeeFName, employeeLName, accountId);
        return mapDataTableToModel(sql, EmployeeGeneralModel.class);
    }

    public boolean isClientExistInDb(String accountId, String clientFName, String clientLName) {
        String sql = String.format(SQL_GET_CLIENT, accountId, clientFName, clientLName);
        if (DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).size() != 0) return true;
        return false;
    }

    public boolean isVisitExistForClient(String accountId, String clientFName, String clientLName, String memo) {
        String sql = String.format(SQL_GET_VISIT_KEY_BY_MEMO, accountId, clientFName, clientLName, memo);
        if (DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).size() != 0) return true;
        return false;
    }

    public void GenerateClientData(String accountId, String clientFName, String clientLName) {
        GenerateJsonData generateJsonData = new GenerateJsonData();
        generateJsonData.setBaseObj(baseObj);
        boolean clientExistInDb = isClientExistInDb(accountId, clientFName, clientLName);

        if (!clientExistInDb) {
            generateJsonData.generateRandomConnecticutClientByApi(clientFName, clientLName);
        }
    }

    public void GenerateMolinaClientData(String accountId, String clientFName, String clientLName) {
        GenerateJsonData generateJsonData = new GenerateJsonData();
        generateJsonData.setBaseObj(baseObj);
        boolean clientExistInDb = isClientExistInDb(accountId, clientFName, clientLName);

        if (!clientExistInDb) {
            generateJsonData.generateRandomMolinaClientByApi(clientFName, clientLName);
        }
    }

    public void GenerateFullVisitFlow(String accountId, String clientFName, String clientLName,
                                      String employeeFName, String employeeLName, String memo) {
        generateJsonData.setBaseObj(baseObj);
        boolean clientExistInDb = isClientExistInDb(accountId, clientFName, clientLName);
        boolean visitExistInDb = isVisitExistForClient(accountId, clientFName, clientLName, memo);

        List<EmployeeGeneralModel> employeeGeneralModels = getEmployee(accountId, employeeFName, employeeLName);

        if (!clientExistInDb || employeeGeneralModels.size() == 0 || !visitExistInDb) {
            generateJsonData.generateRandomVisitFlow(accountId, clientFName, clientLName, employeeFName, employeeLName, memo);
        }
    }

    public void GenerateDataWithoutVisit(String accountId, String clientFName, String clientLName,
                                         String employeeFName, String employeeLName) {
        generateJsonData.setBaseObj(baseObj);
        boolean clientExistInDb = isClientExistInDb(accountId, clientFName, clientLName);

        List<EmployeeGeneralModel> employeeGeneralModels = getEmployee(accountId, employeeFName, employeeLName);

        if (!clientExistInDb || employeeGeneralModels.size() == 0) {
            generateJsonData.generateRandomDataWithoutVisit(clientFName, clientLName, employeeFName, employeeLName);
        }
    }

    public void GenerateFullMolinaVisitFlow(String accountId, String clientFName, String clientLName,
                                            String employeeFName, String employeeLName, String memo) {
        generateJsonData.setBaseObj(baseObj);
        boolean clientExistInDb = isClientExistInDb(accountId, clientFName, clientLName);
        boolean visitExistInDb = isVisitExistForClient(accountId, clientFName, clientLName, memo);

        List<EmployeeGeneralModel> employeeGeneralModels = getEmployee(accountId, employeeFName, employeeLName);

        if (!clientExistInDb || employeeGeneralModels.size() == 0 || !visitExistInDb) {
            generateJsonData.generateRandomMolinaVisitFlow(accountId, clientFName, clientLName, employeeFName, employeeLName, memo);
        }
    }

    public void GenerateMolinaDataWithoutVisitFlow(String accountId, String clientFName, String clientLName,
                                                   String employeeFName, String employeeLName) {
        generateJsonData.setBaseObj(baseObj);
        boolean clientExistInDb = isClientExistInDb(accountId, clientFName, clientLName);

        List<EmployeeGeneralModel> employeeGeneralModels = getEmployee(accountId, employeeFName, employeeLName);

        if (!clientExistInDb || employeeGeneralModels.size() == 0) {
            generateJsonData.generateRandomMolinaWithoutVisitFlow(accountId, clientFName, clientLName, employeeFName, employeeLName);
        }
    }

    public void DownloadLoadAllExportFiles() {
        for (String exportFileName : exportedFileNames) {
            File file = SftpUtils.getFile(DEVSWARMEXPORTDWH, DOWNLOAD_FOLDER, exportFileName);
            if (file != null) {
                logPass(String.format("file '%s' is downloaded successfully in '%s'", fileName, DOWNLOAD_FOLDER));
            } else {
                logError(String.format("Unable to download file '%s' from '%s'", fileName, Constant.SFTP_FOLDER));
            }
            Assert.assertTrue(file != null, String.format("Unable to download file '%s' from '%s'", fileName, Constant.SFTP_FOLDER));

        }
    }

    public void VerifySIDGeneratedInResponse() {
        Assert.assertTrue(dwhResponse.contains("Returned SID"), String.format("Could not found the SID in response."));
    }

    public Response claimVisit(String serviceStartDate, String clientMedicaidId, String procedureCode) {
        String unique = commons.generateUniqueNumber();
        ClaimValidationV2 claimValidationV2 = new ClaimValidationV2();
        List<EVV_Request> evv_requests = new ArrayList<>();
        EVV_Request evv_request = new EVV_Request();
        evv_request.BusinessEntityMedicaidIdentifier = providerId;
        evv_request.ProviderID = providerId;
        evv_request.RequestType = "Model3";
        evv_request.BatchID = unique;
        evv_request.TransactionID = RandomStringUtils.randomNumeric(9);
        evv_request.Payer = PAYER_ID.MEDHHS.toString();
        evv_request.ICN = "999973482423";
        evv_request.DLN = "04";
        evv_request.ProviderQualifier = "MedicaidID";
        evv_request.PatientQualifier = "MedicaidID";
        evv_request.PatientID = clientMedicaidId;
        evv_request.ServiceStartDate = serviceStartDate;
        evv_request.ServiceEndDate = null;
        evv_request.ProcedureCode = procedureCode;
        evv_request.Units = "4.0";
        evv_request.UnitsRule = "AddUnits";
        evv_request.Modifier1 = "U1";
        evv_request.Modifier2 = "U2";
        evv_request.Modifier3 = "U3";
        evv_request.Modifier4 = "U4";
        evv_request.MatchingRule = "ExcludeUnits";
        evv_requests.add(evv_request);
        claimValidationV2.EVV_Request = evv_requests;

        return claimService.claimVisit(claimValidationV2);
    }

    public boolean CreateTableData(String testcaseId) {
        try {
            PreconditionDbService.createTableData(testcaseId);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean IsTableDataIsExist(String testcaseId) {
        try {
            return PreconditionDbService.isExistTable(testcaseId);
        } catch (Exception ex) {
            return false;
        }
    }

    public void SaveExportedFiles(String testcaseId, List<String> exportedFiles) {
        exportedFiles.toString();
    }


    public boolean SavePreconditionData(String testcaseId, String field, String value) {
        try {
            PreconditionDbService.insertDataRows(testcaseId, field, value);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean GetPreconditionData(String testcaseId) {
        try {
            preconditionData = PreconditionDbService.getResult(testcaseId);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean LoadExportJsonDataFile(String filename) {
        try {
            jsonOhioExportEntities = webServicesBase
                    .toJsonModel(String.format("download/%s", filename), JsonOhioExportEntity[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void VerifyFileIsAJsonFileAndCorrectFormat(String fileName) {
        Assert.assertTrue(fileName.contains("ODM_EVV_DWExtract_"), "The Ohio export file is not expected result");
    }

    // have to use with create client and employee data
    public AuthorizationEntity GenerateAuthorizationForConnecticut(String accountId, String clientFName, String clientLName) {
        return generateJsonData.CreateAuthorizationForConnecticut(accountId, clientFName, clientLName);
    }

    public void SavePreconditionDataToDatabase(String testCaseId, PatientGeneralEntity ohioClientEntity,
                                               WorkerGeneralEntity ohioWorkerEntity,
                                               com.sandata.entity.ohio.visit.VisitGeneralEntity ohioVisitEntity) {
        String patientFName = ohioClientEntity.getPatientFirstName();
        String patientLName = ohioClientEntity.getPatientLastName();
        String patientOtherID = ohioClientEntity.getPatientOtherID();
        String patientAlternateID = ohioClientEntity.getPatientAlternateID();

        Assert.assertTrue(CreateTableData(testCaseId), "Create table don't successfully");
        Assert.assertTrue(SavePreconditionData(testCaseId, "patientFName", patientFName));
        Assert.assertTrue(SavePreconditionData(testCaseId, "patientLName", patientLName));
        Assert.assertTrue(SavePreconditionData(testCaseId, "patientOtherID", patientOtherID));
        Assert.assertTrue(SavePreconditionData(testCaseId, "patientAlternateID", patientAlternateID));

        logStepInfo("**** patientFName = " + patientFName);
        logStepInfo("**** patientLName = " + patientLName);
        logStepInfo("**** patientOtherID = " + patientOtherID);
        logStepInfo("**** patientAlternateID = " + patientAlternateID);

        Assert.assertTrue(SavePreconditionData(testCaseId, "visitMemo", ohioVisitEntity.getVisitMemo()));
    }

    public Response claimVisit(ClaimValidationV2 claimValidationV2) {
        return claimService.claimVisit(claimValidationV2);
    }

    /**
     * Summary: Verify all exported files exists in SFTP server by type
     *
     * @param numberFilesExpected is declared in com.constant.Constant
     *                            PROVIDER_GENERAL
     *                            CLIENT_GENERAL
     *                            CLIENT_PROG
     *                            CLIENT_ELIG
     *                            CLIENT_DIAG
     *                            CLIENT_ADDR
     *                            CLIENT_PHONE
     *                            CLIENT_SCHEDULE
     *                            EMP_GENERAL
     *                            EMP_DISC
     *                            VISIT_GENERAL
     *                            VISIT_CALLS
     *                            VISIT_TASKS
     *                            VISIT_EXCP
     *                            VISIT_CHANGES
     *                            VISIT_CLAIMST
     * @return boolean true/false
     */
    public boolean verifyAllExportedFilesExistInSFTP(String payerId, int numberFilesExpected) {
        boolean result = false;
        for (String fileName : exportedFileNames) {
            if (fileName.contains(CLIENT_AUTH))
                continue;
            if (fileName.contains(CLIENT_GENERAL)) {
                String controlFile = fileName.replace(CLIENT_GENERAL, "Control");
                controlFile = controlFile.replace("txt", "dat");
                exportedFileNames.add(controlFile);
                break;
            }
        }

        int numberFiles = exportedFileNames.size();
        if (numberFiles == numberFilesExpected)
            logPass(String.format("Count the files is correct as expected result: %s files", numberFilesExpected));
        else
            logError(String.format("Count the files is unexpected result: %s files ", numberFilesExpected));

        try {
            for (String fileName : exportedFileNames) {
                if (fileName.contains(CLIENT_AUTH))
                    continue;
                result = SftpUtils.isSftpFileExisted(DEVSWARMEXPORTDWH + fileName);
                if (!result)
                    break;
            }

        } catch (Exception ex) {
            logError(String.format("Problem when Checking '%s' file in %s: %s", fileName, Constant.SFTP_FOLDER, ex.getMessage()));
        }
        if (result) {
            logPass(String.format("File exists in %s", Constant.SFTP_FOLDER));
        } else {
            logError(String.format("File %s does not exist in SFTP %s", fileName, Constant.SFTP_FOLDER));
        }
        Assert.assertTrue(result, String.format("Some of %s exported files are not exported in sftp server.", numberFilesExpected));
        return result;
    }

    public void validateCaseManagerDataAsExpectedResult(){
        List<String> records = TextUtil.readTextFileRecords(DOWNLOAD_FOLDER + "/" + fileName);
        boolean existCaseManagerExported = false;
        for(int i  = 1; i < records.size(); i++){
            String currentLine  = records.get(i).replace("\"","");
            currentLine = currentLine.replace("|","");
            if(currentLine.contains(caseManager_17155)){
                existCaseManagerExported = true;
                break;
            }
        }
        Assert.assertTrue(existCaseManagerExported,"Case manager data don't export data");
    }

    public void validateVisitLocationTypeDataExpectedResult(){
        List<String> records = TextUtil.readTextFileRecords(DOWNLOAD_FOLDER + "/" + fileName);
        boolean found = false;
        for(int i  = 1; i < records.size(); i++){
            String currentLine  = records.get(i);
            String[] list = currentLine.split(Pattern.quote("|"));
            String currentValue = list[list.length-1].replace("\"","");
            if(currentValue.equals(call_location)){
                found = true;
                break;
            }
        }
        Assert.assertTrue(found,"Call location is not expected result");
    }

    public void validateHeaderAsExpectedResults(String hearderName) {
        List<String> records = TextUtil.readTextFileRecords(DOWNLOAD_FOLDER + "/" + fileName);
        String headerExpected = baseObj.readDataValue(hearderName);
        headerExpected = headerExpected.replace("\"", "");
        headerExpected = headerExpected.replace("|", "");
        headerExpected = headerExpected.replace(",", "");
        String header = records.get(0).replace("\"", "");
        header = header.replace("|", "");
        header = header.replace(",", "");
        LOGGER.info("-----headerExpected: " + headerExpected);
        LOGGER.info("-----headerActual: " + header);
        Assert.assertTrue(header.equalsIgnoreCase(headerExpected), "Client header is not expected results");
    }

    public void validatePayerIDasExpectedResult(String value) {
        List<String> records = TextUtil.readTextFileRecords(DOWNLOAD_FOLDER + "/" + fileName);
        for (int i = 0; i < records.size(); i++) {
            String[] items = records.get(i).split("|");
            String payerID = items[0];
            Assert.assertTrue(payerID.equalsIgnoreCase(value), "payerID should be as expected results");
        }
    }

    public void validateClientIDasExpectedResult() {
        List<String> records = TextUtil.readTextFileRecords(DOWNLOAD_FOLDER + "/" + fileName);
        for (int i = 0; i < records.size(); i++) {
            String[] items = records.get(i).split("|");
            String clientId = items[2];
            Assert.assertTrue(!clientId.isEmpty(), "clientID should be as expected results");
        }
    }

    //ClientMedicaidID = 1-9 digits (NO padded zeros)
    public void validateClientMedicaidIDAsExpectedResult(){
        List<String> records = TextUtil.readTextFileRecords(DOWNLOAD_FOLDER + "/" + fileName);
        for (int i = 0; i < records.size(); i++) {
            String[] items = records.get(i).split("|");
            String clientMedicaidID = items[10];
            Assert.assertTrue(commons.data1To9DigitsAndNoPaddedZero(clientMedicaidID), "clientID should be as expected results");
        }
    }

    public void validateClientFieldAsExpectedResult(char pre, int length, int index){
        List<String> records = TextUtil.readTextFileRecords(DOWNLOAD_FOLDER + "/" + fileName);
        for (int i = 0; i < records.size(); i++) {
            String[] items = records.get(i).split("|");
            String clientCustomID = items[index];
            Assert.assertTrue(commons.dataCorrectFormat(pre, clientCustomID, length), "clientID should be as expected results");
        }
    }

    //ClientCustomID = 7 char "P" + 6 numeric P######
    public void validateClientCustomIDAsExpectedResult(char pre, int length){
        validateClientFieldAsExpectedResult(pre, length, 11);
    }

    //ClientOtherID = 7 char "E" + 6 numeric E######
    public void validateClientOtherIDAsExpectedResult(char pre, int length){
        validateClientFieldAsExpectedResult(pre, length, 12);
    }

    //EmployeeID = 7 char "D" + 6 numeric D######
    public void validateEmployeeIDAsExpectedResult(char pre, int length){
        validateClientFieldAsExpectedResult(pre, length, 1);
    }

    public void validateProviderQualifierAsExpectedResult(String value)
    {
        List<String> records = TextUtil.readTextFileRecords(DOWNLOAD_FOLDER + "/" + fileName);
        String current;
        for(int i =1; i< records.size(); i++)
        {
            current = records.get(i);
            String[] items = current.split("|");
            String providerQualifier = items[1];
            Assert.assertTrue(!providerQualifier.isEmpty(),
                    "Provider Qualifier should be not emmpty");
            Assert.assertTrue(providerQualifier.equalsIgnoreCase(value),
                        "Provider Qualifier is not match as expected 'MedicaidID'");
        }
    }

}
