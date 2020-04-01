package com.sandata.ws.dwh;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sandata.common.Constant;
import com.sandata.common.PasswordUtils;
import com.sandata.core.config.Environment;
import com.sandata.core.ws.WebServicesBase;
import com.sandata.db.ClientDbService;
import com.sandata.db.EmployeeDbService;
import com.sandata.db.VisitDbService;
import com.sandata.entity.exportDWH.ExportConfigurationV1.AccountInterfaceEndpointInformationV1;
import com.sandata.entity.exportDWH.ExportConfigurationV2.AccountInterfaceEndpointInformation;
import com.sandata.entity.exportDWH.ExportConfigurationV2.AccountInterfaceParamInformationEntityV2;
import com.sandata.entity.exportDWH.ExportConfigurationV2.ExportWithConfigurationEntityV2;
import com.sandata.entity.exportDWH.ExportConfigurationV2.InterfaceDataExchangeInformationEntityV2;
import com.sandata.entity.exportDWH.FullExportWithDateRange;
import com.sandata.entity.exportDWH.OhioExportConfigurationV1.AccountInterfaceParamInformation;
import com.sandata.entity.exportDWH.OhioExportConfigurationV1.ExportWithConfigurationModel;
import com.sandata.entity.exportDWH.OhioExportConfigurationV1.InterfaceDataExchangeInformation;
import com.sandata.ws.GenericWebService;
import com.sandata.ws.WebServicesConstants;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sandata.common.Constant.VERSION.*;

public class DWHServices extends GenericWebService {
    private static final Logger LOGGER = Logger.getLogger(DWHServices.class);
    private static final String EXPORT_SUCCESSFULLY_MSG = "Trigger full export successfully";
    protected EmployeeDbService employeeDbService = new EmployeeDbService();
    protected ClientDbService clientDbService = new ClientDbService();
    protected VisitDbService visitDbService = new VisitDbService();

    enum Account{
        MOLINA, OHIO, CONNECTICUT, COLORADO, VERMONT, PENNSYLVANIA, INDIANA, ARIZONA, HAWAII
    }

    public DWHServices(){
        webServicesBase =  new WebServicesBase();
    }

    public Response sendExportDWHRequest(String baseUrl, String userName,
                                                String password, String modifyJson){
        LOGGER.info("Starting to send DWH export request...");
        LOGGER.info(modifyJson);
        LOGGER.info(baseUrl + WebServicesConstants.DWH_EXPORT_WITH_CONFIG_URL);
        return webServicesBase.sendPOSTRequestWithoutSSL(baseUrl + WebServicesConstants.DWH_EXPORT_WITH_CONFIG_URL,
                modifyJson, userName, password);
    }

    public Response sendExportOhioDWHRequest(String baseUrl, String userName,
                                         String password, String modifyJson){

        commons.loggerConsole("----------url--------");
        commons.loggerConsole(baseUrl + WebServicesConstants.DWH_EXPORT_WITH_OHIO_CONFIG_URL);
        commons.loggerConsole("----------url--------");

        commons.loggerConsole("----------Body--------");
        commons.loggerConsole(modifyJson);
        commons.loggerConsole("----------Body--------");


        LOGGER.info("Starting to send OHIO DWH export request...");
        LOGGER.info(modifyJson);
        LOGGER.info(baseUrl + WebServicesConstants.DWH_EXPORT_WITH_OHIO_CONFIG_URL);
        return webServicesBase.sendPOSTRequestWithoutSSL(baseUrl + WebServicesConstants.DWH_EXPORT_WITH_OHIO_CONFIG_URL,
                modifyJson, userName, password);
    }

    public Response sendExportDWHWithoutConfigRequest(String baseUrl, String userName,
                                                      String password, FullExportWithDateRange param){
        LOGGER.info(baseUrl + WebServicesConstants.DWH_EXPORT_ALL_URL);

        String url = baseUrl + WebServicesConstants.DWH_EXPORT_ALL_URL
                + "?startDate=" + param.getStartDate()
                + "&endDate=" + param.getEndDate()
                + "&account=" + param.getAccount()
                + "&groupKey=" + param.getGroupKey()
                + "&contract=" + param.getContract()
                + "&spv=" + param.getSpv()
                + "&username=" + param.getUsername()
                + "&exportMode=" + param.getExportMode();
        LOGGER.info("Get send export without config url: " + url);

        return webServicesBase.sendGETRequestWithourSSL(url, userName, password);
    }

    public List<String> getFileNamesInExportEVV(String body, String prefix, String format, String apiVersion, String state) {
        List<String> fileNameList = new ArrayList<>();
        String[] fileNames = body.replace(",", "").split("u0027");
        fileNames[0] = fileNames[0].replace("Trigger full export successfully! Please wait until the file", "");
        fileNames[fileNames.length - 1] = fileNames[fileNames.length - 1].replace("", " is completely written. Returned SID: 104818507. TraceId: ");
        for(String fileName : fileNames) {
            if (fileName.contains("EVV_DWExtract")) {
                fileName = getStandardExportFileName(prefix, format, apiVersion, fileName);
                fileNameList.add(fileName);
            }

            if(state.equals("CONNECTICUT") && fileName.contains("CLIENT_GENERAL"))
                fileNameList.add(fileName.replace("CLIENT_GENERAL", "CLIENT_AUTH"));
        }
        return fileNameList;
    }

    private String getStandardExportFileName(String prefix, String format, String apiVersion, String fileName) {
        fileName = fileName.replace("\\", "").trim();
        if (fileName.contains("_ALL")) {
            fileName = fileName.replace("_ALL", prefix);
        }
        if (format != null && format != "") {
            fileName = fileName.replace(".csv", format);
        }
        if (apiVersion.equals("v2")) {
            fileName = fileName.replace(".ext", format)
                    .replace("u003c", "")
                    .replace("u003e", "");

        }
        return fileName;
    }

    public String getOhioExportedFileName(String payerId, String extension, String body) {
        String filename = "";
        Pattern p = Pattern.compile(payerId + ".*." + extension);
        Matcher m = p.matcher(body);
        if (m.find()) {
            filename = m.group(0);
        } else {
            logError(String.format("Unable to extract exported file name in Ohio with pattern %s."
                    , payerId + ".*." + extension));
        }
        return filename;
    }

    public String getFileNameContain(List<String> fileNames, String containText) {
        for(String fileName : fileNames) {
            if (fileName.contains(containText))
                return fileName;
        }

        return null;
    }

    /**
     * Get method export EVV
     * @param url: the url api
     * @param param: the param with date range data
     * @return string response data when execute GET method
     */
    public String captureGetResponseEXPORTEVV(String url, FullExportWithDateRange param, Environment environment){
        return sendExportDWHWithoutConfigRequest(url,
                environment.getClaims_username(),
                environment.getClaims_pass(), param).asString();
    }

    /**
     * Post method export EVV
     * @param url: the url api
     * @param modifyJson: the json data
     * @return
     */
    public String capturePostResponseEXPORTEVV(String url, String modifyJson, Environment environment) {
        System.out.println("--------Body url -------------");
        System.out.println(url);
        System.out.println("--------Body url -------------");
        System.out.println("--------Body dwh -------------");
        System.out.println(modifyJson);
        System.out.println("--------Body dwh -------------");


        return sendExportDWHRequest(url,
                environment.getClaims_username(),
                environment.getClaims_pass(), modifyJson).asString();
    }

    public String capturePostResponseOhioEXPORT(String url, String modifyJson, Environment environment) {
        return sendExportOhioDWHRequest(url,
                environment.getClaims_username(),
                environment.getClaims_pass(), modifyJson).asString();
    }

    private String initExportConfigurationV2( Environment environment,
                                                                      Constant.PAYER_ID payerId,
                                                                      Constant.EXTENSION controlFileExtension,
                                                                      Constant.SPEC_VERSION specVersion,
                                                                      String specNumber,
                                                                      Constant.EXTENSION fileExtension,
                                                                      String delimiter,
                                                                      String exportMode,
                                                                      String startDate,
                                                                      String endDate,
                                                                      String backDays,
                                                                      String groupKey,
                                                                      String providerMode,
                                                                      String payerMode,
                                                                      String clientMode,
                                                                      String scheduleMode,
                                                                      String employeeMode,
                                                                      String contract,
                                                                      String spv,
                                                                      String account, boolean setHeader,
                                                                        boolean withLastFailedExport,
                                                                        boolean quoteNullValue,
                                                                        boolean multiDesignees,
                                                                        String state) {

        ExportWithConfigurationEntityV2 exportConfig = new ExportWithConfigurationEntityV2();

        InterfaceDataExchangeInformationEntityV2 interfaceDataExchangeInformation =
                new InterfaceDataExchangeInformationEntityV2();
        interfaceDataExchangeInformation.pgpPublicKeyPath = "";
        interfaceDataExchangeInformation.setHeader = setHeader;
        interfaceDataExchangeInformation.payerId = payerId.toString();
        interfaceDataExchangeInformation.controlFileExtension = "." + controlFileExtension.toString();
        interfaceDataExchangeInformation.specVersion = specVersion.toString();
        interfaceDataExchangeInformation.specNumber = specNumber;
        interfaceDataExchangeInformation.fileExtension = "." + fileExtension.toString();
        interfaceDataExchangeInformation.delimiter = delimiter;
        interfaceDataExchangeInformation.withLastFailedExport = withLastFailedExport;
        interfaceDataExchangeInformation.quoteNullValue = quoteNullValue;
        interfaceDataExchangeInformation.multiDesignees = multiDesignees;
        if(state.equals("VERMONT")) {
            interfaceDataExchangeInformation.exportClientSchedule = false;
            interfaceDataExchangeInformation.exportVisitTask = false;
            interfaceDataExchangeInformation.exportVisitClaimStack = false;
        }


        exportConfig.interfaceDataExchangeInformation = interfaceDataExchangeInformation;

        exportConfig.interfaceDataExchangeType = "SFTP";
        AccountInterfaceEndpointInformation accountInterfaceEndpointInformation = new AccountInterfaceEndpointInformation();
        accountInterfaceEndpointInformation.resolve_vault_path_maine_sftp = "sftp-kv/maine_exp_dwh";
        accountInterfaceEndpointInformation.folder_path = "/DevOhioInterfaces/DevSwarmExportDataWarehouse";
        accountInterfaceEndpointInformation.pgp_public_key = "";
        exportConfig.accountInterfaceEndpointInformation = accountInterfaceEndpointInformation;

        AccountInterfaceParamInformationEntityV2 accountInterfaceParamInformationEntityV2 = new AccountInterfaceParamInformationEntityV2();
        accountInterfaceParamInformationEntityV2.exportMode = exportMode;
        accountInterfaceParamInformationEntityV2.startDate = startDate;
        accountInterfaceParamInformationEntityV2.endDate = endDate;
        if(backDays != null)
            accountInterfaceParamInformationEntityV2.backDays = backDays;
        accountInterfaceParamInformationEntityV2.groupKey = groupKey;
        accountInterfaceParamInformationEntityV2.providerMode = providerMode;
        accountInterfaceParamInformationEntityV2.payerMode = payerMode;
        accountInterfaceParamInformationEntityV2.clientMode = clientMode;
        accountInterfaceParamInformationEntityV2.scheduleMode = scheduleMode;
        accountInterfaceParamInformationEntityV2.employeeMode = employeeMode;
        accountInterfaceParamInformationEntityV2.contract = contract;
        accountInterfaceParamInformationEntityV2.username = "";
        accountInterfaceParamInformationEntityV2.spv = spv;
        accountInterfaceParamInformationEntityV2.account = account;

        exportConfig.setAccountInterfaceParamInformation(accountInterfaceParamInformationEntityV2);

        //exportConfig.accountInterfaceParamInformation = accountInterfaceParamInformationEntityV2;

        return new GsonBuilder().setPrettyPrinting().create().toJson(exportConfig);

    }

    private String initOhioExportConfigurationV1(
                                                 Environment environment,
                                                 Constant.PAYER_ID payerId,
                                                 String exportMode,
                                                 String startDate,
                                                 String endDate,
                                                 String backDays,
                                                 String dayRange,
                                                 String groupKey,
                                                 String providerMode,
                                                 String payerMode,
                                                 String clientMode,
                                                 String scheduleMode,
                                                 String employeeMode,
                                                 String contract,
                                                 String spv,
                                                 String account) {

        ExportWithConfigurationModel exportConfig = new ExportWithConfigurationModel();

        InterfaceDataExchangeInformation interfaceDataExchangeInformation =
                new InterfaceDataExchangeInformation();
        if(payerId != null)
            interfaceDataExchangeInformation.payerId = payerId.toString();
        else
            interfaceDataExchangeInformation.payerId = Constant.PAYER_ID.ODM.toString();
        exportConfig.interfaceDataExchangeInformation = interfaceDataExchangeInformation;

        AccountInterfaceEndpointInformationV1 accountInterfaceEndpointInformation = new AccountInterfaceEndpointInformationV1();
        accountInterfaceEndpointInformation.port = "22";
        accountInterfaceEndpointInformation.host = "nhdevftp.sandata.com";
        accountInterfaceEndpointInformation.username = "talend";
        accountInterfaceEndpointInformation.password = PasswordUtils.getDecodedPassword("Rlo0Z2QtUWQ=");
        accountInterfaceEndpointInformation.folder = "/DevOhioInterfaces/DevSwarmExportDataWarehouse";
        exportConfig.accountInterfaceEndpointsInformation.add(accountInterfaceEndpointInformation);

        AccountInterfaceParamInformation accountInterfaceParamInformation = new AccountInterfaceParamInformation();
        accountInterfaceParamInformation.exportMode = exportMode;
        accountInterfaceParamInformation.startDate = startDate;
        accountInterfaceParamInformation.endDate = endDate;
        if(startDate == null){
            accountInterfaceParamInformation.dayRange = "1";
            accountInterfaceParamInformation.backDays = "1";
        }
        accountInterfaceParamInformation.groupKey = groupKey;

        accountInterfaceParamInformation.contract = contract;
        accountInterfaceParamInformation.username = "";
        accountInterfaceParamInformation.spv = spv;
        accountInterfaceParamInformation.account = account;
        exportConfig.accountInterfaceParamInformation = accountInterfaceParamInformation;

        return new Gson().toJson(exportConfig);
    }

    private String initOhioExportConfigurationV2() {
        return "";
    }

    private String initOhioExportConfigurationV3() {
        return "";
    }

    public String initExportConfiguration(String version,
                                                  Environment environment,
                                                  String accountType,
                                                  Constant.PAYER_ID payerId,
                                                  Constant.EXTENSION controlFileExtension,
                                                  Constant.SPEC_VERSION specVersion,
                                                  String specNumber,
                                                  Constant.EXTENSION fileExtension,
                                                  String demimiter,
                                                  String exportMode,
                                                  String startDate,
                                                  String endDate,
                                                  String backDays,
                                                  String groupKey,
                                                  String providerMode,
                                                  String payerMode,
                                                  String clientMode,
                                                  String scheduleMode,
                                                  String employeeMode,
                                                  String contract,
                                                  String spv,
                                                  String account ) {

        String url = environment.getDwh();
        boolean setHeader = false;
        boolean withLastFailedExport  = false;
        boolean quoteNullValue = false;
        boolean multiDesignees  = false;

        if (accountType.equals(String.valueOf(Account.MOLINA))) {
            payerId = Constant.PAYER_ID.MEDHHS;
            fileExtension = Constant.EXTENSION.txt;
            demimiter = "|";
            setHeader = false;
        } else if (accountType.equals(String.valueOf(Account.OHIO))) {
            payerId = Constant.PAYER_ID.ODM;
            // Ohio to have another method
        } else if (accountType.equals(String.valueOf(Account.CONNECTICUT))) {
            payerId = Constant.PAYER_ID.CTDSS;
            fileExtension = Constant.EXTENSION.csv;
            demimiter = ",";
            setHeader = true;
            exportMode = "2";
        } else if (accountType.equals(String.valueOf(Account.INDIANA))){
            payerId = Constant.PAYER_ID.INFSSA;
            fileExtension = Constant.EXTENSION.csv;
            demimiter = ",";
            setHeader = true;
            exportMode = "2";
        }
        else if(accountType.equals(String.valueOf(Account.COLORADO))) {
            payerId = Constant.PAYER_ID.COHCPF;
            fileExtension = Constant.EXTENSION.dsv;
            controlFileExtension = Constant.EXTENSION.dsv;
            specVersion = Constant.SPEC_VERSION.generic;
            demimiter = "|";
            setHeader = true;
            withLastFailedExport = false;
            quoteNullValue = true;
            multiDesignees = true;
            exportMode = "3";
            groupKey = "260";
        } else if(accountType.contains(String.valueOf(Account.VERMONT))){
            payerId = Constant.PAYER_ID.DVHA;
            fileExtension = Constant.EXTENSION.dsv;
            controlFileExtension = Constant.EXTENSION.dsv;
            specVersion = Constant.SPEC_VERSION.generic;
            demimiter = "|";
            setHeader = true;
            withLastFailedExport = false;
            quoteNullValue = true;
            multiDesignees = true;
            exportMode = "3";
            groupKey = "320";
        }else if(accountType.contains(String.valueOf(Account.ARIZONA))){
            payerId = Constant.PAYER_ID.AHCCCS;
            fileExtension = Constant.EXTENSION.dsv;
            controlFileExtension = Constant.EXTENSION.dsv;
            specVersion = Constant.SPEC_VERSION.generic;
            demimiter = "|";
            setHeader = true;
            withLastFailedExport = false;
            quoteNullValue = true;
            multiDesignees = true;
            exportMode = "3";
            groupKey = "301";
            payerMode = "D";
            clientMode = "D";
            scheduleMode = "D";
            employeeMode = "D";
        } else if(accountType.contains(String.valueOf(Account.HAWAII))){
            payerId = Constant.PAYER_ID.HI_AC;
            fileExtension = Constant.EXTENSION.dsv;
            controlFileExtension = Constant.EXTENSION.dsv;
            specVersion = Constant.SPEC_VERSION.generic;
            demimiter = "|";
            setHeader = true;
            withLastFailedExport = false;
            quoteNullValue = true;
            multiDesignees = true;
            exportMode = "3";
            groupKey = "311";
            payerMode = "D";
            clientMode = "D";
            scheduleMode = "D";
            employeeMode = "D";
        }
        else if(accountType.equals(String.valueOf(Account.PENNSYLVANIA))){
            payerId = Constant.PAYER_ID.PADHS;
            fileExtension = Constant.EXTENSION.dsv;
            controlFileExtension = Constant.EXTENSION.dsv;
            specVersion = Constant.SPEC_VERSION.generic;
            demimiter = "|";
            setHeader = true;
            withLastFailedExport = false;
            quoteNullValue = true;
            multiDesignees = true;
            exportMode = "3";
            groupKey = "270";
        }
        else {
            fileExtension = Constant.EXTENSION.csv;
            demimiter = ",";
        }

        String json = "";

        if (version.equalsIgnoreCase(v1.toString())) {
            // TODO: to be updated
        } else if (version.equalsIgnoreCase(v2.toString())) {
            json = initExportConfigurationV2(environment, payerId, controlFileExtension, specVersion,specNumber,
                    fileExtension, demimiter, exportMode,
                    startDate, endDate, backDays, groupKey,
                    providerMode, payerMode, clientMode, scheduleMode, employeeMode,
                    contract, spv, account, setHeader, withLastFailedExport, quoteNullValue, multiDesignees, accountType);

        } else if (version.equalsIgnoreCase(v3.toString())) {
            // TODO: to be updated
        } else {
            // TODO: to be updated
        }

        return capturePostResponseEXPORTEVV(url, json, environment);
    }

    public String initOhioExportConfiguration(String version,
                                                  Environment environment,
                                                  Constant.PAYER_ID payerId,
                                                  String exportMode,
                                                  String startDate,
                                                  String endDate,
                                                  String backDays,
                                                  String dayRange,
                                                  String groupKey,
                                                  String providerMode,
                                                  String payerMode,
                                                  String clientMode,
                                                  String scheduleMode,
                                                  String employeeMode,
                                                  String contract,
                                                  String spv,
                                                  String account ) {

        String url = environment.getDwh();

        String json = "";

        if (version.equalsIgnoreCase(v1.toString())) {
            json = initOhioExportConfigurationV1(environment, payerId,
                    exportMode, startDate, endDate, backDays, dayRange, groupKey,
                    providerMode, payerMode, clientMode, scheduleMode, employeeMode,
                    contract, spv, account);
        } else if (version.equalsIgnoreCase(v2.toString())) {
            // TODO: to be updated

        } else if (version.equalsIgnoreCase(v3.toString())) {
            // TODO: to be updated
        } else {
            // TODO: to be updated
        }

        return capturePostResponseOhioEXPORT(url, json, environment);
    }

    public String callDWHExport(String version,
                                String ohioVersion,
                                Environment environment,
                                String accountType,
                                Constant.PAYER_ID payerId,
                                Constant.EXTENSION controlFileExtension,
                                Constant.SPEC_VERSION specVersion,
                                String specNumber,
                                Constant.EXTENSION fileExtension,
                                String demimiter,
                                String exportMode,
                                String startDate,
                                String endDate,
                                String backDays,
                                String dayRange,
                                String groupKey,
                                String providerMode,
                                String payerMode,
                                String clientMode,
                                String scheduleMode,
                                String employeeMode,
                                String contract,
                                String spv,
                                String account) {
            String response = null;
            int count = 5;
            int step = 1;
            try {
                if (accountType.contains(String.valueOf(Account.OHIO))) {
                    while ( step <= count ) {
                        response = initOhioExportConfiguration(ohioVersion, environment,
                                payerId, "3",
                                startDate, endDate, backDays, dayRange, groupKey,
                                providerMode, payerMode, clientMode, scheduleMode, employeeMode,
                                contract, spv, account);
                        if (response.contains(EXPORT_SUCCESSFULLY_MSG)) {
                            break;
                        }
                        logInfo(String.format("Error in trigger full export at time %s. Wait for 60s to continue another trigger.", step));
                        step++;
                        Thread.sleep(60000);
                    }
                } else {
                    while ( step <= count ) {
                        response = initExportConfiguration(version, environment,
                                accountType, payerId,
                                controlFileExtension, specVersion,specNumber,
                                fileExtension, demimiter,
                                "1", startDate, endDate, backDays, groupKey,
                                providerMode, payerMode, clientMode, scheduleMode, employeeMode,
                                contract, spv, account);

                        if (response.contains(EXPORT_SUCCESSFULLY_MSG)) {
                            break;
                        }
                        logInfo(String.format("Error in trigger full export at time %s. Wait for 10s to continue another trigger.", step));
                        step++;
                        Thread.sleep(60000);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return response;
    }

    private String initExportConfigurationV2( Environment environment,
                                              String payerId,
                                              Constant.EXTENSION controlFileExtension,
                                              Constant.SPEC_VERSION specVersion,
                                              Constant.EXTENSION fileExtension,
                                              String delimiter,
                                              String exportMode,
                                              String startDate,
                                              String endDate,
                                              String backDays,
                                              String groupKey,
                                              String providerMode,
                                              String payerMode,
                                              String clientMode,
                                              String scheduleMode,
                                              String employeeMode,
                                              String contract,
                                              String spv,
                                              String account, boolean setHeader) {
        ExportWithConfigurationEntityV2 exportConfig = new ExportWithConfigurationEntityV2();

        InterfaceDataExchangeInformationEntityV2 interfaceDataExchangeInformation =
                new InterfaceDataExchangeInformationEntityV2();
        interfaceDataExchangeInformation.pgpPublicKeyPath = "";
        interfaceDataExchangeInformation.setHeader = setHeader;
        interfaceDataExchangeInformation.payerId = payerId;
        interfaceDataExchangeInformation.controlFileExtension = "." + controlFileExtension.toString();
        interfaceDataExchangeInformation.specVersion = specVersion.toString();
        interfaceDataExchangeInformation.fileExtension = "." + fileExtension.toString();
        interfaceDataExchangeInformation.delimiter = delimiter;
        exportConfig.interfaceDataExchangeInformation = interfaceDataExchangeInformation;

        exportConfig.interfaceDataExchangeType = "SFTP";
        AccountInterfaceEndpointInformation accountInterfaceEndpointInformation = new AccountInterfaceEndpointInformation();
        accountInterfaceEndpointInformation.resolve_vault_path_maine_sftp = "sftp-kv/maine_exp_dwh";
        accountInterfaceEndpointInformation.folder_path = "/DevOhioInterfaces/DevSwarmExportDataWarehouse/Vermont";
        accountInterfaceEndpointInformation.pgp_public_key = null;
        exportConfig.accountInterfaceEndpointInformation = accountInterfaceEndpointInformation;

        AccountInterfaceParamInformationEntityV2 accountInterfaceParamInformationEntityV2 = new AccountInterfaceParamInformationEntityV2();
        accountInterfaceParamInformationEntityV2.exportMode = exportMode;
        accountInterfaceParamInformationEntityV2.startDate = startDate;
        accountInterfaceParamInformationEntityV2.endDate = endDate;
        accountInterfaceParamInformationEntityV2.backDays = backDays;
        accountInterfaceParamInformationEntityV2.groupKey = groupKey;
        accountInterfaceParamInformationEntityV2.providerMode = providerMode;
        accountInterfaceParamInformationEntityV2.payerMode = payerMode;
        accountInterfaceParamInformationEntityV2.clientMode = clientMode;
        accountInterfaceParamInformationEntityV2.scheduleMode = scheduleMode;
        accountInterfaceParamInformationEntityV2.employeeMode = employeeMode;
        accountInterfaceParamInformationEntityV2.contract = contract;
        accountInterfaceParamInformationEntityV2.username = "";
        accountInterfaceParamInformationEntityV2.spv = spv;
        accountInterfaceParamInformationEntityV2.account = account;
        exportConfig.accountInterfaceParamInformation = accountInterfaceParamInformationEntityV2;

        return new GsonBuilder().setPrettyPrinting().create().toJson(exportConfig);
    }

    public String initExportConfiguration(String version,
                                          Environment environment,
                                          String accountType,
                                          String payerId,
                                          Constant.EXTENSION controlFileExtension,
                                          Constant.SPEC_VERSION specVersion,
                                          Constant.EXTENSION fileExtension,
                                          String demimiter,
                                          String exportMode,
                                          String startDate,
                                          String endDate,
                                          String backDays,
                                          String groupKey,
                                          String providerMode,
                                          String payerMode,
                                          String clientMode,
                                          String scheduleMode,
                                          String employeeMode,
                                          String contract,
                                          String spv,
                                          String account ) {

        String url = environment.getDwh();
        boolean setHeader = false;

        if (accountType.equals(String.valueOf(Account.MOLINA))) {
            fileExtension = Constant.EXTENSION.txt;
            demimiter = "|";
            setHeader = false;
        } else if (accountType.equals(String.valueOf(Account.OHIO))) {
            // Ohio to have another method
        } else if (accountType.equals(String.valueOf(Account.CONNECTICUT))) {
            fileExtension = Constant.EXTENSION.csv;
            demimiter = ",";
            setHeader = true;
        } else {
            fileExtension = Constant.EXTENSION.csv;
            demimiter = ",";
        }

        String json = "";

        if (version.equalsIgnoreCase(v1.toString())) {
            // TODO: to be updated
        } else if (version.equalsIgnoreCase(v2.toString())) {
            json = initExportConfigurationV2(environment, payerId, controlFileExtension, specVersion,
                    fileExtension, demimiter, exportMode,
                    startDate, endDate, backDays, groupKey,
                    providerMode, payerMode, clientMode, scheduleMode, employeeMode,
                    contract, spv, account, setHeader);

        } else if (version.equalsIgnoreCase(v3.toString())) {
            // TODO: to be updated
        } else {
            // TODO: to be updated
            logInfo("version to call DWH export is " + version);
        }

        return capturePostResponseEXPORTEVV(url, json, environment);
    }

    public String callDWHExport(String version,
                                String ohioVersion,
                                Environment environment,
                                String accountType,
                                String payerId,
                                Constant.EXTENSION controlFileExtension,
                                Constant.SPEC_VERSION specVersion,
                                Constant.EXTENSION fileExtension,
                                String demimiter,
                                String startDate,
                                String endDate,
                                String backDays,
                                String groupKey,
                                String providerMode,
                                String payerMode,
                                String clientMode,
                                String scheduleMode,
                                String employeeMode,
                                String contract,
                                String spv,
                                String account) {
        String response = null;
        int count = 5;
        int step = 1;
        try {
            if (accountType.equals(String.valueOf(Account.OHIO))) {
                while ( step <= count ) {
                    response = initExportConfiguration(version, environment,
                            accountType, payerId,
                            controlFileExtension, specVersion,
                            fileExtension, demimiter,
                            "1", startDate, endDate, backDays, groupKey,
                            providerMode, payerMode, clientMode, scheduleMode, employeeMode,
                            contract, spv, account);

                    if (response.contains(EXPORT_SUCCESSFULLY_MSG)) {
                        break;
                    }
                    logInfo(String.format("Error in trigger full export at time %s. Wait for 10s to continue another trigger.", step));
                    step++;
                    Thread.sleep(60000);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
