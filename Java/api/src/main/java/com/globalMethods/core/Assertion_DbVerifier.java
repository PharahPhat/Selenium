package com.globalMethods.core;

import Utills_ExtentReport_Log4j.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.globalMethods.core.MYSQL_Database_Verifier.account;
import static com.globalMethods.core.globalVariables.*;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.fail;


public class Assertion_DbVerifier extends BaseTest {
    private DataBaseVerifier dataBaseVerifier = new DataBaseVerifier();
    private Constant_SQL Constant_SQL = new Constant_SQL();
    private FileContentReader FileContentReader = new FileContentReader();
    private ErrorCode_Verification ErrorCode_Verification = new ErrorCode_Verification();

    // ***********************mySQl (member & Auth) method mapping ****************************************//

    public static void verify_ImportFile_MySQlDataBase_Auth(Map<String, String> finalMapapdataByRow) throws java.text.ParseException, SQLException, InterruptedException {
        Thread.sleep(15000);
        System.out.println("------------Verifying Db Assertion----------------------");
        MYSQL_Database_Verifier.DataBaseVerificationClientAuth(finalMapapdataByRow.get("clientIdentifier"));

        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.payor_id_auth, finalMapapdataByRow.get("payerId"), globalVariables.PayerID);
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.program_auth, finalMapapdataByRow.get("payerProgram"), PayerProgram);
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_id_qlfr, finalMapapdataByRow.get("clientQualifier"), "clientQualifier");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_id_auth, finalMapapdataByRow.get("clientIdentifier"), "clientIdentifier");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.provider_id_qlfr_auth, finalMapapdataByRow.get("providerQualifier"), "providerQualifier");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.provider_id_auth, finalMapapdataByRow.get("providerId"), "providerId");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_ref_num, finalMapapdataByRow.get("authorizationReferenceNumber"), "authorizationReferenceNumber");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.service_auth, finalMapapdataByRow.get("authorizationServiceID"), "authorizationServiceID");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.Modifier1, finalMapapdataByRow.get("modifier1"), "modifier1");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.Modifier2, finalMapapdataByRow.get("modifier2"), "modifier2");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.Modifier3, finalMapapdataByRow.get("modifier3"), "modifier3");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.Modifier4, finalMapapdataByRow.get("modifier4"), "modifier4");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_amt_typ, finalMapapdataByRow.get("authorizationAmountType"), "authorizationAmountType");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_max, finalMapapdataByRow.get("authorizationMaximum"), "authorizationMaximum");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_start_date, finalMapapdataByRow.get("authorizationStartDate"), "authorizationStartDate");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_end_date, finalMapapdataByRow.get("authorizationEndDate"), "authorizationEndDate");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_shared_ind, finalMapapdataByRow.get("authorizationShared"), "authorizationShared");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_cmnt, finalMapapdataByRow.get("authorizationComments"), "authorizationComments");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_lmt_typ, finalMapapdataByRow.get("authorizationLimitType"), "authorizationLimitType");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.auth_status, finalMapapdataByRow.get("authorizationStatus"), "authorizationStatus");
    }

    public synchronized void verify_ImportFile_MySQlDataBase(Map<String, String> finalMapapdataByRow) throws java.text.ParseException, SQLException, InterruptedException {

        System.out.println("------------Verifying Db Assertion----------------------");
        MYSQL_Database_Verifier.DataBaseVerificationClient(finalMapapdataByRow.get("clientOtherID"));
        //CommonMethods.AssertEqualsAndPrintValuesString("0"+MYSQL_Database_Verifier.status_code,finalMapapdataByRow.get("clientStatus"),"clientStatus");
        CommonMethods.AssertEqualsAndPrintValuesString(account, "28000", "Account");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.clientFirstName, finalMapapdataByRow.get("clientFirstName").trim(), "clientFirstName");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.clientLastName, finalMapapdataByRow.get("clientLastName").trim(), "clientLastName");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_m_name, finalMapapdataByRow.get("clientMiddleInitial").trim(), "clientMiddleInitial");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_ssn, finalMapapdataByRow.get("clientSsn").trim(), "clientSsn");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_medicaid_id, finalMapapdataByRow.get("clientCustomID").trim(), "clientCustomID");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_id, finalMapapdataByRow.get("clientOtherID").trim(), globalVariables.ClientID);
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_name_suffix, finalMapapdataByRow.get("clientSuffix").trim(), "clientSuffix");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.Action_code, finalMapapdataByRow.get("action").trim(), "action");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_addr_typ_qlfr, finalMapapdataByRow.get("clientAddressType").trim(), "clientAddressType");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_addr1, finalMapapdataByRow.get("clientAddressLine1").trim(), "clientAddressLine1");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_addr2, finalMapapdataByRow.get("clientAddressLine2").trim(), "clientAddressLine2");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_country, finalMapapdataByRow.get("clientCounty").trim(), "clientCounty");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_city, finalMapapdataByRow.get("clientCity").trim(), "clientCity");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_state, finalMapapdataByRow.get("clientState").trim(), "clientState");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_zip_code, finalMapapdataByRow.get("clientZip").trim(), "clientZip");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.Action_code_elig, finalMapapdataByRow.get("action").trim(), "action Elig");

        if (finalMapapdataByRow.get("payerProgram").trim().length() > 9) {
            CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.program, String.format("%09d", Integer.parseInt(finalMapapdataByRow.get("payerProgram").trim())), PayerProgram);
        } else {
            CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.program, finalMapapdataByRow.get("payerProgram").trim(), PayerProgram);
        }
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_elig_beg_date, finalMapapdataByRow.get("clientEligibilityDateBegin").trim(), "clientEligibilityDateBegin");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_start_of_care_date, finalMapapdataByRow.get("clientStartOfCareDate").trim(), "clientStartOfCareDate");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_end_of_care_date, finalMapapdataByRow.get("clientEndOfCareDate").trim(), "clientEndOfCareDate");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_prmy_dx_code, finalMapapdataByRow.get("clientPrimaryDiagnosisCode").trim(), "clientPrimaryDiagnosisCode");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_scndry_dx_code, finalMapapdataByRow.get("clientSecondaryDiagnosisCode").trim(), "clientSecondaryDiagnosisCode");

        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.service, finalMapapdataByRow.get("payerService").trim(), "payerService");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.region, finalMapapdataByRow.get("payerRegion").trim(), "payerRegion");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_phone_typ, finalMapapdataByRow.get("clientPhoneType").trim(), "clientPhoneType");
        CommonMethods.AssertEqualsAndPrintValuesString(MYSQL_Database_Verifier.client_phone_num, finalMapapdataByRow.get("clientPhone").trim(), "clientPhone");

    }

    public synchronized void verify_ImportFile_Provider_STx_Account(Map<String, String> finalMapapdataByRow) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException {

        System.out.println("------------Verifying Db Assertion-------------------");
        logger.log(LogStatus.INFO, "Validating DB response ");

        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccounts_csv, finalMapapdataByRow.get("ProviderID")));

        dataBaseVerifier.compareMap(dbMap, finalMapapdataByRow);

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccountprovider, finalMapapdataByRow.get("ProviderID")));

        dataBaseVerifier.compareMap(dbMap, finalMapapdataByRow);
        String account = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.getAccountFromProvider, finalMapapdataByRow.get("ProviderID")));
//		CommonMethods.updateCsvFile(fileNameProvider,account);

    }

    public void ImportAssert_stx_Accounts_info(Map<String, String> finalMapapdataByRow) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException {
        System.out.println("------------Verifying Db Assertion-------------------");
        logger.log(LogStatus.INFO, "Validating DB response ");

        Map<String, String> dbMap;

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccounts_info, finalMapapdataByRow.get("ProviderName")));

        dataBaseVerifier.compareMap(dbMap, finalMapapdataByRow);
        //String account =dataBaseVerifier.executeQueryString(String.format(Constant_SQL.getAccountFromProvider,finalMapapdataByRow.get("ProviderID")));
//		CommonMethods.updateCsvFile(fileNameProvider,account);
    }

    public void ImportAssert_stx_stxAccouts_interfaces(Map<String, String> finalMapapdataByRow) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException {
        System.out.println("------------Verifying Db Assertion----------------------");
        logger.log(LogStatus.INFO, "Validating DB response ");

        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccouts_interfaces, finalMapapdataByRow.get("ProviderID")));

        dataBaseVerifier.compareMap(dbMap, finalMapapdataByRow);

    }

    public void ImportAssert_stxAccounts_TaxID(Map<String, String> finalMapapdataByRow) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException {

        System.out.println("------------Verifying Db Assertion----------------------");
        logger.log(LogStatus.INFO, "Validating DB response ");

        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccounts_TaxID, finalMapapdataByRow.get("ProviderName")));

        dataBaseVerifier.compareMap(dbMap, finalMapapdataByRow);

    }

    public synchronized void assertControlFileValidindiana(List<String> fileNames, String fileNameProcessedFile, Map<String, String> finalMapapdataByRow, String OutboundFile, String fileType, String timeStamp) throws Exception {
        try {
            int count = 0;
            if (fileType.equalsIgnoreCase("Member")) {

                verify_ImportFile_OracleDataBase_member(finalMapapdataByRow);
            } else if (fileType.equalsIgnoreCase("PriorAuth")) {
                verify_ImportFile_MySQlDataBase_Auth(finalMapapdataByRow);
            } else if (fileType.equalsIgnoreCase("Provider")) {
                verify_ImportFile_Provider_STx_Account(finalMapapdataByRow);
            }
            for (String filevalue : fileNames) {

                if ((filevalue).contains(fileNameProcessedFile)) {
                    System.out.println("Successfully imported");


                }
                if ((filevalue).contains(OutboundFile)) {
                    System.out.println("Successfully imported outbound file");

                }

                if ((filevalue).contains(CommonMethods.callgenerateInboundControlFile(timeStamp, globalVariables.indianaGenericFileFormat))) {
                    System.out.println("-------------Verifying Control File----------");

                    Map<String, String> controlFileData = new HashMap<>();
                    controlFileData = FileContentReader.readFileDataAddToMap(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));

                    CommonMethods.AssertEqualsAndPrintValuesString(fileNameProcessedFile + ".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");
                    count++;

                }

            }
            if (count == 0) {
                fail("Inbound control file not Found");
            }
        } finally {
            System.gc();
            for (String filevalue : fileNames) {
                FileContentReader.deleteFile(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.decryptedfileResult + filevalue);
                FileContentReader.deleteFile(globalVariables.Encryptfile + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.EncryptedfileResult + filevalue);

            }
        }
    }

    public synchronized void assertControlFileValidpensolvania(List<String> fileNames, String fileNameProcessedFile, Map<String, String> finalMapapdataByRow, String OutboundFile, String fileType, String timeStamp) throws Exception {
        try {
            int count = 0;
            if (fileType.equalsIgnoreCase("Member")) {

                verify_ImportFile_OracleDataBase_member(finalMapapdataByRow);
            } else if (fileType.equalsIgnoreCase("PriorAuth")) {
                verify_ImportFile_MySQlDataBase_Auth(finalMapapdataByRow);
            } else if (fileType.equalsIgnoreCase("Provider")) {
                verify_ImportFile_Provider_STx_Account(finalMapapdataByRow);
            }
            for (String filevalue : fileNames) {

                if ((filevalue).contains(fileNameProcessedFile)) {
                    System.out.println("Successfully imported");


                }
                if ((filevalue).contains(OutboundFile)) {
                    System.out.println("Successfully imported outbound file");

                }

                if ((filevalue).contains(CommonMethods.callgenerateInboundControlFile(timeStamp, globalVariables.PAGenericFileFormat))) {
                    System.out.println("-------------Verifying Control File----------");

                    Map<String, String> controlFileData = new HashMap<>();
                    controlFileData = FileContentReader.readFileDataAddToMap(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));

                    CommonMethods.AssertEqualsAndPrintValuesString(fileNameProcessedFile + ".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");
                    count++;

                }

            }
            if (count == 0) {
                fail("Inbound control file not Found");
            }
        } finally {
            System.gc();
            for (String filevalue : fileNames) {
                FileContentReader.deleteFile(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.decryptedfileResult + filevalue);
                FileContentReader.deleteFile(globalVariables.Encryptfile + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.EncryptedfileResult + filevalue);

            }
        }
    }

    public synchronized void assertControlFileValid(List<String> fileNames, String fileNameProcessedFile, Map<String, String> finalMapapdataByRow, String OutboundFile, String fileType, String timeStamp) throws Exception {
        try {
            int count = 0;
            if (fileType.equalsIgnoreCase("Member")) {
                verify_ImportFile_MySQlDataBase(finalMapapdataByRow);
            } else if (fileType.equalsIgnoreCase("PriorAuth")) {
                verify_ImportFile_MySQlDataBase_Auth(finalMapapdataByRow);
            } else if (fileType.equalsIgnoreCase("Provider")) {
                verify_ImportFile_Provider_STx_Account(finalMapapdataByRow);
            }
            for (String filevalue : fileNames) {

                if ((filevalue).contains(fileNameProcessedFile)) {
                    System.out.println("Successfully imported");


                }
                if ((filevalue).contains(OutboundFile)) {
                    System.out.println("Successfully imported outbound file");

                }

                if ((filevalue + ".gpg").contains(CommonMethods.callgenerateInboundControlFile(timeStamp, globalVariables.memberGenericFileNameControlFile))) {
                    System.out.println("-------------Varifying Control File----------");

                    Map<String, String> controlFileData = new HashMap<>();
                    controlFileData = FileContentReader.readFileDataAddToMap(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));

                    CommonMethods.AssertEqualsAndPrintValuesString(fileNameProcessedFile + ".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");
                    count++;

                }

            }
            if (count == 0) {
                fail("Inbound control file not Found");
            }
        } finally {
            System.gc();
            for (String filevalue : fileNames) {
                FileContentReader.deleteFile(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.decryptedfileResult + filevalue);
                FileContentReader.deleteFile(globalVariables.Encryptfile + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.EncryptedfileResult + filevalue);
            }
        }

    }

    public synchronized void assertControlFileValid_Auth(List<String> fileNames, String fileNameProcessedFile, Map<String, String> finalMapapdataByRow, String timeStamp) throws Exception {
        try {
            Assertion_DbVerifier.verify_ImportFile_MySQlDataBase_Auth(finalMapapdataByRow);
            for (String filevalue : fileNames) {

                if ((filevalue).equalsIgnoreCase(fileNameProcessedFile)) {
                    System.out.println("Successfully imported");
                    FileContentReader.deleteFile(filevalue + ".gpg");
                }

                if ((filevalue + ".gpg").equalsIgnoreCase(CommonMethods.callgenerateInboundControlFile(timeStamp, globalVariables.memberGenericFileNameControlFile))) {
                    System.out.println("-------------Verifying Control File----------");

                    Map<String, String> controlFileData = new HashMap<>();
                    controlFileData = FileContentReader.readFileDataAddToMap(globalVariables.decryptedfileResultTo + filevalue);

                    CommonMethods.AssertEqualsAndPrintValuesString(fileNameProcessedFile + ".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");


                }
            }
        } finally {
            System.gc();
        }
    }

    public synchronized void assertControlFileInValid(List<String> fileNames, String fileNameProcessedFile, List<String> ErroMessage, String errorFile, String timeStamp) throws Exception {
        try {
            for (String filevalue : fileNames) {

                if (filevalue.contains(fileNameProcessedFile)) {
                    System.out.println("Successfully imported");
                    FileContentReader.deleteFile(filevalue + ".gpg");
                }
                String[] tcname = Thread.currentThread().getStackTrace()[2].getMethodName().split("_");
                if ((filevalue).contains(globalVariables.memberGenericFileNameControlFile + tcname[2] + "_" + errorFile + "_" + "Error" + "_" + timeStamp + ".csv")) {

                    FileContentReader.verifyFileContainString(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""), ErroMessage, 2);

                }
                if ((filevalue).contains(CommonMethods.callgenerateInboundControlFile(timeStamp, globalVariables.memberGenericFileNameControlFile))) {

                    Map<String, String> controlFileData = new HashMap<>();
                    controlFileData = FileContentReader.readFileDataAddToMap(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));

                    CommonMethods.AssertEqualsAndPrintValuesString(fileNameProcessedFile + ".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");

                }

            }
        } finally {
            System.gc();
            for (String filevalue : fileNames) {
                FileContentReader.deleteFile(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.decryptedfileResult + filevalue);
                FileContentReader.deleteFile(globalVariables.Encryptfile + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.EncryptedfileResult + filevalue);

            }
        }
    }

    public void verify_ImportFile_OracleDataBase_member(Map<String, String> finalMapapdataByRow) throws ClassNotFoundException, InterruptedException, SQLException, java.text.ParseException {


        //finalMapapdataByRow.put(globalVariables.PayerID, "INFSSA");
        //finalMapapdataByRow.put(PayerProgram, "Indiana");

        Map<String, String> dbMap = new HashMap<String, String>();
        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.sql_memberImportSTX, finalMapapdataByRow.get("ClientSSN")));
		/*if(finalMapapdataByRow.get(globalVariables.ClientID).equalsIgnoreCase("")&&finalMapapdataByRow.get("ClientOtherID").equalsIgnoreCase("MedicaidID")){
			dbMap.remove("LOC");
		}
		else{

		}*/
        dbMap.put("PAYERSERVICE", dbMap.get("PAYERSERVICE").split("_")[0]);
        Assert.assertNotNull(dataBaseVerifier.executeQueryString(String.format(Constant_SQL.selectLOCInbox, finalMapapdataByRow.get("ClientSSN"))));
        dataBaseVerifier.compareMap(dbMap, finalMapapdataByRow);
    }

    public void verify_ImportFile_OracleDataBase_memberMolina(Map<String, String> finalMapapdataByRow) throws ClassNotFoundException, InterruptedException, SQLException, java.text.ParseException {


        Map<String, String> dbMap = new HashMap<String, String>();
        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.sql_memberImportSTXMemberMolina, finalMapapdataByRow.get("clientSsn")));

        dataBaseVerifier.compareMap(dbMap, finalMapapdataByRow);
        Assert.assertNotNull(dataBaseVerifier.executeQueryString(String.format(Constant_SQL.selectLOCInbox, finalMapapdataByRow.get("clientSsn"))));
    }


    // *********************** OpenEVV********************//
    // *********************** OpenEVV ********************//

    public void jsonAssert_InboxAni_OpenEVV(JSONObject jsonObject_Map, JSONObject jsonobjectsub_Map) throws SQLException,
            InterruptedException, ClassNotFoundException {
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxAniOpenevvSql);
        dbValue.put("DbColumnName1", jsonObject_Map.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonobjectsub_Map.get("ClientPhone").toString());

        jsonobjectsub_Map.put(globalVariables.ClientID, jsonObject_Map.get(globalVariables.ClientID));


        logger.log(LogStatus.INFO, "Validating DB response ");

        Map<String, String> dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxAniOpenevvSql,
                jsonObject_Map.get(globalVariables.ClientID).toString(),
                jsonobjectsub_Map.get(globalVariables.ClientPhone).toString()));

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobjectsub_Map, dbMap, dbValue);
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_InboxClient_OpenEVV(String bodyAsString, JSONObject jsonObject_Map) throws SQLException, ParseException, InterruptedException, ClassNotFoundException, java.text.ParseException {

        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientSql_OpenEvv);
        dbValue.put("DbColumnName1", jsonObject_Map.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObject_Map.get("ClientMedicaidID").toString());

        logger.log(LogStatus.INFO, "Validating JSON response ");
        //	Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        //	Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

        logger.log(LogStatus.INFO, "Validating DB response ");


        Map<String, String> dbMap;
        jsonObject_Map.put("ClientBirthDate", CommonMethods.dateToDateTimeFormat(jsonObject_Map.get("ClientBirthDate").toString()));


        if (jsonObject_Map.get("DischargeDate") != null) {
            jsonObject_Map.put("DischargeDate", CommonMethods.dateToDateTimeFormat(jsonObject_Map.get("DischargeDate").toString()));
        }

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientOpenevvSql,
                jsonObject_Map.get(globalVariables.ClientID).toString(),
                jsonObject_Map.get("ClientFirstName").toString(),
                jsonObject_Map.get("ClientMedicaidID").toString()));

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObject_Map, dbMap, dbValue);


    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_InboxClient_OpenEVV_statusD(String bodyAsString, JSONObject jsonObject_Map) throws SQLException, ParseException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientSql_OpenEvv);
        dbValue.put("DbColumnName1", jsonObject_Map.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObject_Map.get("ClientLastName").toString());

        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

        logger.log(LogStatus.INFO, "Validating DB response ");


        Map<String, String> dbMap = new HashMap<>();
        jsonObject_Map.put("Error_code", "0");

        jsonObject_Map.put("ClientBirthDate", CommonMethods.dateToDateTimeFormat(jsonObject_Map.get("ClientBirthDate").toString()));

        if (jsonObject_Map.get("DischargeDate") != null) {
            jsonObject_Map.put("DischargeDate", CommonMethods.dateToDateTimeFormat(jsonObject_Map.get("DischargeDate").toString()));
        }

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientOpenevvSql, jsonObject_Map.get(globalVariables.ClientID).toString(), jsonObject_Map.get("ClientFirstName").toString()));

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObject_Map, dbMap, dbValue);

    }

    public void stxClientSql_OpenEvv(String bodyAsString, JSONObject jsonObject_Map) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientSql_OpenEvv);
        dbValue.put("DbColumnName1", jsonObject_Map.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObject_Map.get("ClientMedicaidID").toString());

        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

        logger.log(LogStatus.INFO, "Validating DB response ");

        jsonObject_Map.put("ClientBirthDate", CommonMethods.dateToDateTimeFormat(jsonObject_Map.get("ClientBirthDate").toString()));

        Map<String, String> dbMap;

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientOpenevvSql,
                jsonObject_Map.get(globalVariables.ClientID).toString(),
                jsonObject_Map.get("ClientFirstName").toString(),
                jsonObject_Map.get("ClientMedicaidID").toString()));

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObject_Map, dbMap, dbValue);

    }

    @SuppressWarnings("unchecked")
    public void stxaccount_spvClientSql_OpenEvv(String bodyAsString, JSONObject jsonObject_Map) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {

        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));
        logger.log(LogStatus.INFO, "Validating DB response ");

        Map<String, String> dbMap = new HashMap<>();

        logger.log(LogStatus.INFO, "Validating DB response in stx.accounts_spv");

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxaccountsspvClientSql_OpenEvv, jsonObject_Map.get("Account").toString(), jsonObject_Map.get("Coordinator").toString()));
        Thread.sleep(2000);
//		dataBaseVerifier.compareMap(dbMap,jsonObject_Map);

    }

    public void jsonAssert_XrefService(String bodyAsString, JSONObject jsonObject_Map) throws SQLException, ParseException, java.text.ParseException, InterruptedException, ClassNotFoundException {
        Map<String, String> dbValue = new HashMap<>();
        Map<String, String> dbMap;

        dbValue.put("stxSqlQuery", Constant_SQL.stxXrefSql);
        dbValue.put("DbColumnName1", jsonObject_Map.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", String.format("%09d", Integer.parseInt(jsonObject_Map.get("EmployeePIN").toString())));


        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));


        ErrorCode_Verification.ClientStatusVerification(jsonObject_Map);
        ErrorCode_Verification.clientIDQualifier_NameMappingJsonToDB(jsonObject_Map);
        ErrorCode_Verification.EmployeeQualifier_NameMappingJsonToDB(jsonObject_Map);
        ErrorCode_Verification.XRefStartDate_EndDateDateFormatChange(jsonObject_Map);

        logger.log(LogStatus.INFO, "Validating DB response in inbox.xrefservice");
        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxXrefSql, jsonObject_Map.get(globalVariables.ClientID).toString(), jsonObject_Map.get("EmployeeID").toString()));


//		ErrorCode_Verification.errorCodeVerificationOtherThanZeroXrefSpecific(jsonObject_Map, dbMap, dbValue);


    }

    public void jsonAssertAuthorizations_OpenEVV(String bodyAsString, JSONObject jsonobject_Map) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {

        Map<String, String> dbValue = new HashMap<>();
        Map<String, String> dbMap;

        dbValue.put("stxSqlQuery", Constant_SQL.stxAuthLimit_OpenEVV);
        dbValue.put("DbColumnName1", jsonobject_Map.get(Auth_ref_number).toString());
        dbValue.put("DbColumnName2", jsonobject_Map.get(globalVariables.PayerID).toString());


        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

        logger.log(LogStatus.INFO, "Validating DB response ");

        DataGeneratorClient.objectCharTruncation(jsonobject_Map, "ProviderID", 50);
        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxAuthLimit_OpenEvv, jsonobject_Map.get("ClientIdentifier").toString(), jsonobject_Map.get(globalVariables.PayerID).toString()));

        JSONArray jsonArray = (JSONArray)jsonobject_Map.get(AuthorizationLimit);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObject, dbMap, dbValue);

    }

    @SuppressWarnings("unchecked")
    public void jsonAssertInboxWorker_OpenEVV(String bodyAsString, JSONObject jsonobject) throws SQLException, ParseException, java.text.ParseException, InterruptedException, ClassNotFoundException {
        Map<String, String> dbValue = new HashMap<>();
        Map<String, String> dbMap;

        dbValue.put("stxSqlQuery", Constant_SQL.StxWorker_OpenEvv);
        dbValue.put("DbColumnName1", jsonobject.get(globalVariables.EmployeePIN).toString());
        dbValue.put("DbColumnName2", jsonobject.get(globalVariables.EmployeeFirstName).toString());

        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

        logger.log(LogStatus.INFO, "Validating DB response ");
        jsonobject.put("error_code", "0");

        String EmployeeZipCode = jsonobject.get("EmployeeZipCode").toString();
        int zipCount = jsonobject.get("EmployeeZipCode").toString().length();

        if (zipCount == 5) {
            jsonobject.put("EmployeeZipCode", EmployeeZipCode + "-" + "0000");
        }


        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxWorker_OpenEvv, jsonobject.get(globalVariables.EmployeePIN).toString(),
                jsonobject.get(globalVariables.EmployeeFirstName).toString()));

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobject, dbMap, dbValue);

    }

    @SuppressWarnings("unchecked")
    public void jsonAssertAppUserEmp_OpenEvv(JSONObject jsonobject) throws SQLException, InterruptedException, ClassNotFoundException {
        Map<String, String> dbMap;

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.StxAppUserEmp, jsonobject.get("EmployeeEmailAddress").toString(),
                jsonobject.get(globalVariables.Account).toString()));

        dataBaseVerifier.compareMap(dbMap, jsonobject);
    }

    public void jsonAssert_InboxClientAddress_OpenEVV(String bodyAsString, JSONObject jsonObjectMainArray, JSONObject jsonObject_SubArray) throws SQLException, IOException, ParseException, InterruptedException, ClassNotFoundException, java.text.ParseException {

        Map<String, String> dbValue = new HashMap<>();
        Map<String, String> dbMap = new HashMap<>();

        dbValue.put("stxSqlQuery", Constant_SQL.StxclientAddressSql_OpenEVV);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObject_SubArray.get("ClientAddressLine1").toString());

        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

        logger.log(LogStatus.INFO, "Validating DB response ");
        CommonMethods.ZipadditionfourZero(jsonObject_SubArray, "ClientZip");

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.clientAddressSql_OpenEVV, jsonObjectMainArray.get(globalVariables.ClientID).toString(), jsonObject_SubArray.get("ClientAddressLine1").toString()));

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObject_SubArray, dbMap, dbValue);


    }


    // *********************** Member ********************//
    // *********************** Member ********************//

    @SuppressWarnings("unchecked")
    public void jsonAssertAuthorizations_Member(String bodyAsString, JSONObject jsonobject_Map) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {

        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

        JSONArray jsonArrayElig = (JSONArray) jsonobject_Map.get("ClientEligibility");
        JSONObject jsonObjectElig = (JSONObject) jsonArrayElig.get(0);

        Map<String, String> dbValue = new HashMap<>();
        Map<String, String> dbMap = new HashMap<>();

        dbValue.put("stxSqlQuery", Constant_SQL.stxAuthrization_Member);
        dbValue.put("DbColumnName1", jsonobject_Map.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObjectElig.get(globalVariables.PayerID).toString());

        logger.log(LogStatus.INFO, "Validating DB response ");
        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxAuthrization_Member, jsonobject_Map.get(globalVariables.ClientID).toString(), jsonObjectElig.get(globalVariables.PayerID).toString()));

        jsonobject_Map.put("PROVIDERID", dbMap.get("PROVIDERID"));
        jsonobject_Map.put(globalVariables.PayerID, dbMap.get("PAYERID"));

        DataGeneratorClient.ClienteligibilityDateScenario(jsonobject_Map);

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobject_Map, dbMap, dbValue);


    }


    public void jsonAssertAuthlimits_Member(String bodyAsString, JSONObject jsonobject_Map, JSONObject jsonobjectsub_Map) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        Map<String, String> dbValue = new HashMap<>();
        Map<String, String> dbMap = new HashMap<>();

        dbValue.put("stxSqlQuery", Constant_SQL.stxAuthLimit_OpenEVV);
        dbValue.put("DbColumnName1", jsonobject_Map.get(Auth_ref_number).toString());
        dbValue.put("DbColumnName2", jsonobjectsub_Map.get(globalVariables.PayerID).toString());

        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        //	Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

        logger.log(LogStatus.INFO, "Validating DB response ");

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxAuthLimit_member, jsonobject_Map.get(globalVariables.ClientID).toString(), jsonobjectsub_Map.get(globalVariables.PayerID).toString()));

//		dataBaseVerifier.compareMap(jsonobjectsub_Map, dbMap);


    }

    @SuppressWarnings("unchecked")
    public void stxClientSql_Member(String bodyAsString, JSONObject jsonObject_Map) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientSql_Member);
        dbValue.put("DbColumnName1", jsonObject_Map.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObject_Map.get("ClientLastName").toString());

        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        //	Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

        jsonObject_Map.put("ClientBirthDate", CommonMethods.dateToDateTimeFormatyyyy_mm_dd(jsonObject_Map.get("ClientBirthDate").toString()));

        System.out.println(CommonMethods.dateToDateTimeFormatyyyy_mm_dd(jsonObject_Map.get("ClientBirthDate").toString()));

        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxClientSql_Member, jsonObject_Map.get(globalVariables.ClientID).toString(), jsonObject_Map.get("ClientFirstName").toString()));

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObject_Map, dbMap, dbValue);


    }

    public void inboxClientSql_Member(String bodyAsString, JSONObject jsonObject_Map) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientSql_Member);
        dbValue.put("DbColumnName1", jsonObject_Map.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObject_Map.get("ClientLastName").toString());

        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        //	Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

        jsonObject_Map.put("ClientBirthDate", CommonMethods.dateToDateTimeFormatyyyy_mm_dd(jsonObject_Map.get("ClientBirthDate").toString()));

        System.out.println(CommonMethods.dateToDateTimeFormatyyyy_mm_dd(jsonObject_Map.get("ClientBirthDate").toString()));

        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientmember, jsonObject_Map.get(globalVariables.ClientID).toString(), jsonObject_Map.get("ClientFirstName").toString()));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObject_Map, dbMap, dbValue);


    }


    public void jsonAssert_InboxClientAddress_Member(String bodyAsString, JSONObject jsonObjectMainArray, JSONObject jsonObject_SubArray) throws SQLException, IOException, ParseException, InterruptedException, ClassNotFoundException, java.text.ParseException {

        stxClientSql_Member(bodyAsString, jsonObjectMainArray);

        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxclientAddressSql_Member);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObject_SubArray.get("ClientAddressLine1").toString());

        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        //	Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));
        logger.log(LogStatus.INFO, "Validating DB response ");

        Map<String, String> dbMap = new HashMap<>();

        CommonMethods.ZipadditionfourZero(jsonObject_SubArray, "ClientZip");

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.clientAddressSql_Member, jsonObjectMainArray.get(globalVariables.ClientID).toString(), jsonObject_SubArray.get("ClientAddressLine1").toString()));
//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObject_SubArray, dbMap, dbValue);

    }

    public void jsonAssert_InboxClientContact_Member(String bodyAsString, JSONObject jsonobject_map) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {

        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        Map<String, String> dbMap = new HashMap<>();

        JSONObject jsonObjectProg = CommonMethods.subarrayAssertionVerifier(jsonobject_map, "ClientContact");
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientContactSql_member);
        dbValue.put("DbColumnName1", jsonobject_map.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObjectProg.get(globalVariables.ClientContactFirstName).toString());

        CommonMethods.ZipadditionfourZero(jsonObjectProg, "ClientContactZip");

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientContactSql_member, jsonobject_map.get(globalVariables.ClientID).toString(),
                jsonObjectProg.get(globalVariables.ClientContactFirstName).toString()));

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObjectProg, dbMap, dbValue);


    }


    // *********************** AltEVVGeneric ********************//
    // *********************** AltEVVGeneric ********************//

    @SuppressWarnings("unchecked")
    public void jsonAssertInboxVisitAltevvGeneric(String bodyAsString, JSONObject jsonobject) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {

        logger.log(LogStatus.INFO, "Validating JSON response ");
        //Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));
        //Assert.assertTrue(bodyAsString.contains("\"messageSummary\": \"All records updated successfully.\","));

        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxVisitAltEvvGeneric);
        dbValue.put("DbColumnName1", jsonobject.get("VisitOtherID").toString());
        dbValue.put("DbColumnName2", jsonobject.get("SequenceID").toString());

        DataGeneratorClient.objectCharTruncation(jsonobject, globalVariables.ProcedureCodejson, 5);
        DataGeneratorClient.objectCharTruncation(jsonobject, globalVariables.VisitOtherIDjson, 50);
        DataGeneratorClient.objectCharTruncation(jsonobject, globalVariables.PayerProgramjson, 9);
        DataGeneratorClient.objectCharTruncation(jsonobject, globalVariables.Memojson, 512);
        DataGeneratorClient.objectCharTruncation(jsonobject, globalVariables.VisitGroupCodejson, 6);
        DataGeneratorClient.objectCharTruncation(jsonobject, globalVariables.EmployeeIdentifierjson, 9);

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitAltEvvGeneric, jsonobject.get("VisitOtherID").toString(),
                jsonobject.get("SequenceID").toString()));

        jsonobject.put("SID", dbMap.get("SID"));
        jsonobject.put("VISITKEY", dbMap.get("VISITKEY"));
        jsonobject.put("EMPLOYEEQUALIFIER", dbMap.get("EMPLOYEEQUALIFIER"));
        jsonobject.put("CLIENTIDQUALIFIER", dbMap.get("CLIENTIDQUALIFIER"));
        jsonobject.put("CLIENTIDENTIFIER", jsonobject.get(globalVariables.ClientID));

        if (dbMap.get("ERROR_CODE").equals("0")) {
            jsonobject.put("ERROR_CODE", "0");
            dataBaseVerifier.compareMap(dbMap, jsonobject);
            ErrorCode_Verification.StxVerification(dbValue.get("stxSqlQuery"), jsonobject, dbValue.get("DbColumnName1"),
                    dbValue.get("DbColumnName2"));

        } else {
            Assert.fail("Error Code Return from Db is " + dbMap.get("ERROR_CODE") + " which is not equal to 0.");
        }
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_inboxVisitChanges_Generic(String bodyAsString, JSONObject jsonObjectMainArray, JSONObject jsonobject_SubArray) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {

        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxVisitAltEvvGeneric);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get("VisitOtherID").toString());
        dbValue.put("DbColumnName2", jsonObjectMainArray.get("SequenceID").toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitAltEvvGeneric_Connecticut, jsonObjectMainArray.get("VisitOtherID").toString(),
                jsonObjectMainArray.get("SequenceID").toString()));

        jsonObjectMainArray.put("SID", dbMap.get("SID"));
        jsonObjectMainArray.put("VISITKEY", dbMap.get("VISITKEY"));
        jsonObjectMainArray.put("EMPLOYEEQUALIFIER", dbMap.get("EMPLOYEEQUALIFIER"));
        jsonObjectMainArray.put("CLIENTIDQUALIFIER", dbMap.get("CLIENTIDQUALIFIER"));
        jsonObjectMainArray.put("CLIENTIDENTIFIER", jsonObjectMainArray.get(globalVariables.ClientID));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObjectMainArray, dbMap, dbValue);

        //Verifiying error code validation in Visit Change DB
        dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxVisitChangeLogGeneric);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get("VisitOtherID").toString());
        dbValue.put("DbColumnName2", jsonObjectMainArray.get("SequenceID").toString());

        DataGeneratorClient.objectCharTruncation(jsonobject_SubArray, globalVariables.VisitGroupCodejson, 6);
        DataGeneratorClient.objectCharTruncation(jsonobject_SubArray, globalVariables.ReasonCodejson, 4);
        DataGeneratorClient.objectCharTruncation(jsonobject_SubArray, globalVariables.ChangeReasonMemojson, 256);
        DataGeneratorClient.objectCharTruncation(jsonobject_SubArray, globalVariables.ResolutionCodejson, 4);
        DataGeneratorClient.objectCharTruncation(jsonobject_SubArray, globalVariables.ChangeMadeByjson, 64);


        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitChangeGeneric, jsonObjectMainArray.get("VisitOtherID").toString(),
                jsonobject_SubArray.get("SequenceID").toString()));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobject_SubArray, dbMap, dbValue);
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_inboxVisitCallsGeneric(String bodyAsString, JSONObject jsonObjectMainArray, JSONObject jsonobject_SubArray) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxVisitAltEvvGeneric);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get("VisitOtherID").toString());
        dbValue.put("DbColumnName2", jsonObjectMainArray.get("SequenceID").toString());

        dbMap = dataBaseVerifier.executeQuery(3,
                String.format(Constant_SQL.inboxVisitAltEvvGeneric_Connecticut, jsonObjectMainArray.get("VisitOtherID").toString(),
                        jsonObjectMainArray.get("SequenceID").toString()), 3000);
        jsonObjectMainArray.put("SID", dbMap.get("SID"));
        jsonObjectMainArray.put("VISITKEY", dbMap.get("VISITKEY"));
        jsonObjectMainArray.put("EMPLOYEEQUALIFIER", dbMap.get("EMPLOYEEQUALIFIER"));
        jsonObjectMainArray.put("CLIENTIDQUALIFIER", dbMap.get("CLIENTIDQUALIFIER"));
        jsonObjectMainArray.put("CLIENTIDENTIFIER", jsonObjectMainArray.get(globalVariables.ClientID));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObjectMainArray, dbMap, dbValue);

        logger.log(LogStatus.INFO, "Validating INbox and Stx DB for for VisitCalls");
        dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxVisitCalls);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get("VisitOtherID").toString());
        dbValue.put("DbColumnName2", jsonobject_SubArray.get("CallExternalID").toString());
        DataGeneratorClient.objectCharTruncation(jsonobject_SubArray, globalVariables.CallExternalIDjson, 16);
        DataGeneratorClient.objectCharTruncation(jsonobject_SubArray, globalVariables.MobileLoginjson, 64);
        DataGeneratorClient.objectCharTruncation(jsonobject_SubArray, globalVariables.Locationjson, 25);
        DataGeneratorClient.objectCharTruncation(jsonobject_SubArray, globalVariables.ProcedureCodejson, 5);
        DataGeneratorClient.objectCharTruncation(jsonobject_SubArray, globalVariables.OriginatingPhoneNumberjson, 10);

        dbMap = dataBaseVerifier.executeQuery(3, String.format(Constant_SQL.inboxVisitCalls, jsonObjectMainArray.get("VisitOtherID").toString(),
                jsonobject_SubArray.get("CallAssignment").toString()), 3000);

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobject_SubArray, dbMap, dbValue);

    }

    @SuppressWarnings("unchecked")
    public void verifyInboxClient_AltEVVGenreic(JSONObject jsonObjectMainArray) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap;
		/*Map<String, String> dbValue=new HashMap<>();
		dbValue.put("stxSqlQuery", Constant_SQL.stxClientAltEVVGenericSql);
		dbValue.put("DbColumnName1",jsonObjectMainArray.get(globalVariables.ClientID).toString());
		dbValue.put("DbColumnName2",jsonObjectMainArray.get("ClientFirstName").toString());*/

        DataGeneratorClient.clientQualifierValueAssigned(jsonObjectMainArray);
        DataGeneratorClient.missingMedicatedIDValueasTrue(jsonObjectMainArray);
        DataGeneratorClient.objectCharTruncation(jsonObjectMainArray, "ClientFirstName", 30);
        DataGeneratorClient.objectCharTruncation(jsonObjectMainArray, "ClientLastName", 30);
        DataGeneratorClient.objectCharTruncation(jsonObjectMainArray, "ClientCustomID", 24);
        DataGeneratorClient.objectCharTruncation(jsonObjectMainArray, "ClientOtherID", 24);

        DataGeneratorClient.objectCharTruncation(jsonObjectMainArray, globalVariables.jsonProcedureCode, 5);

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientAltEVVGenericSql,
                jsonObjectMainArray.get("ClientID").toString(),
                jsonObjectMainArray.get("ClientFirstName").toString(),
                stateInfo.get(ACCID)));

        jsonObjectMainArray.put("ERROR_CODE", "0");
        dataBaseVerifier.compareMap(dbMap, jsonObjectMainArray);

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObjectMainArray, dbMap, dbValue);
    }

    public void verifyInboxClient_AltEVVGenreic_Without_ClientID(JSONObject jsonObjectMainArray) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap;
		/*Map<String, String> dbValue=new HashMap<>();
		dbValue.put("stxSqlQuery", Constant_SQL.stxClientAltEVVGenericSql);
		dbValue.put("DbColumnName1",jsonObjectMainArray.get(globalVariables.ClientID).toString());
		dbValue.put("DbColumnName2",jsonObjectMainArray.get("ClientFirstName").toString());*/

        DataGeneratorClient.clientQualifierValueAssigned(jsonObjectMainArray);
        DataGeneratorClient.missingMedicatedIDValueasTrue(jsonObjectMainArray);
        DataGeneratorClient.objectCharTruncation(jsonObjectMainArray, "ClientFirstName", 30);
        DataGeneratorClient.objectCharTruncation(jsonObjectMainArray, "ClientLastName", 30);
        DataGeneratorClient.objectCharTruncation(jsonObjectMainArray, "ClientCustomID", 24);
        DataGeneratorClient.objectCharTruncation(jsonObjectMainArray, "ClientOtherID", 24);

        DataGeneratorClient.objectCharTruncation(jsonObjectMainArray, globalVariables.jsonProcedureCode, 5);

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientAltEVVGenericSqlWithoutClientID,
                jsonObjectMainArray.get("ClientFirstName").toString(),
                jsonObjectMainArray.get("ClientLastName").toString(),
                stateInfo.get(ACCID)));

        jsonObjectMainArray.put("ERROR_CODE", "0");
        dataBaseVerifier.compareMap(dbMap, jsonObjectMainArray);

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObjectMainArray, dbMap, dbValue);
    }

    public void verifyErrorCodeInboxClientGeneric(String errorCodeExpected, JSONObject jsonObjectMainArray) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientAltEVVGenericSql,
                jsonObjectMainArray.get(globalVariables.ClientID).toString(),
                jsonObjectMainArray.get("ClientFirstName").toString(), stateInfo.get(ACCID)));

        Assert.assertEquals(dbMap.get("ERROR_CODE"), errorCodeExpected);
    }

    @SuppressWarnings("unchecked")
    public void verifyInboxClientAddress_ALtEVVGeneric(JSONObject jsonObjectMainArray, JSONObject jsonObject_SubArray) throws SQLException, IOException, ParseException, InterruptedException, ClassNotFoundException, java.text.ParseException {
        logger.log(LogStatus.INFO, "Validating DB response for Clientaddress for altevv generic");
        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientAddressSql_AltEVVGenric);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObject_SubArray.get("ClientAddressLine1").toString());

        DataGeneratorClient.objectCharTruncation(jsonObject_SubArray, "ClientAddressLine1", 30);
        DataGeneratorClient.objectCharTruncation(jsonObject_SubArray, "ClientAddressLine2", 30);
        DataGeneratorClient.objectCharTruncation(jsonObject_SubArray, "ClientCounty", 25);
        DataGeneratorClient.objectCharTruncation(jsonObject_SubArray, globalVariables.ClientCity, 30);
        DataGeneratorClient.objectCharTruncation(jsonObject_SubArray, globalVariables.ClientState, 2);

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.clientAddressSql_AltEVVGenric,
                jsonObjectMainArray.get(globalVariables.ClientID).toString(),
                jsonObject_SubArray.get("ClientAddressLine1").toString()));

        jsonObjectMainArray.put("ERROR_CODE", "0");
        dataBaseVerifier.compareMap(dbMap, jsonObjectMainArray);
    }

    @SuppressWarnings("unchecked")
    public void verifyInboxClientContactAltEVVGeneric(JSONObject jsonObjectMainArray,
                                                      JSONObject jsonObjectClientResponsibleParty)
            throws InterruptedException, SQLException, ClassNotFoundException {
        logger.log(LogStatus.INFO, "Validating JSON response ");
        jsonObjectClientResponsibleParty.put(globalVariables.ClientID, jsonObjectMainArray.get(globalVariables.ClientID));

        DataGeneratorClient.objectCharTruncation(jsonObjectClientResponsibleParty, globalVariables.clientContactFirstName, 30);
        DataGeneratorClient.objectCharTruncation(jsonObjectClientResponsibleParty, globalVariables.clientContactLastName, 30);
        DataGeneratorClient.objectCharTruncation(jsonObjectClientResponsibleParty, globalVariables.ClientContactAddressLine1, 30);
        DataGeneratorClient.objectCharTruncation(jsonObjectClientResponsibleParty, globalVariables.ClientContactAddressLine2, 30);
        DataGeneratorClient.objectCharTruncation(jsonObjectClientResponsibleParty, globalVariables.ClientContactCity, 30);
        DataGeneratorClient.objectCharTruncation(jsonObjectClientResponsibleParty, globalVariables.ClientContactState, 2);

        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientContactSql_AltEVVGenric);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObjectClientResponsibleParty.get(globalVariables.ClientContactFirstName).toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientContactSql_AltEVVGenric,
                jsonObjectMainArray.get(globalVariables.ClientID).toString(),
                jsonObjectClientResponsibleParty.get(globalVariables.clientContactFirstName).toString()));

        jsonObjectClientResponsibleParty.put("ERROR_CODE", "0");
        dataBaseVerifier.compareMap(dbMap, jsonObjectClientResponsibleParty);

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObjectMainArray, dbMap, dbValue);
    }

    @SuppressWarnings("unchecked")
    public void verifyAuthLimitsAltEVVGeneric(JSONObject jsonObjectMap, JSONObject jsonObjectSubMap)
            throws SQLException, InterruptedException, ClassNotFoundException {
        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxAuthLimit_AltevvGeneric);
        dbValue.put("DbColumnName1", jsonObjectMap.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObjectSubMap.get(globalVariables.PayerID).toString());

        DataGeneratorClient.objectCharTruncation(jsonObjectSubMap, PayerProgram, 9);
        DataGeneratorClient.objectCharTruncation(jsonObjectSubMap, ProcedureCode, 5);

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxAuthLimit_AltEvvGeneric,
                jsonObjectMap.get(globalVariables.ClientID).toString(),
                jsonObjectSubMap.get(globalVariables.PayerID).toString()));

        Map<String, String> authLimit = new HashMap<>();
        authLimit.put(PayerProgram, jsonObjectSubMap.get(PayerProgram).toString());
        authLimit.put("SERVICE_CODE", jsonObjectSubMap.get(ProcedureCode).toString());
        jsonObjectSubMap.put("ERROR_CODE", "0");
        dataBaseVerifier.compareMap(authLimit, dbMap);

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobjectsub_Map, dbMap, dbValue);
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_Authlimits_Ohio(String bodyAsString, JSONObject jsonobject_Map, JSONObject jsonobjectsub_Map) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, ParseException {
        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxAuthLimit_Ohio);
        dbValue.put("DbColumnName1", jsonobject_Map.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonobjectsub_Map.get("Payer").toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxAuthLimit_Ohio,
                jsonobject_Map.get(globalVariables.ClientID).toString(),
                jsonobjectsub_Map.get("Payer").toString()));

        Map<String, String> dbMapPayerValidation;

        dbMapPayerValidation = dataBaseVerifier.executeQuery(String.format(Constant_SQL.payerCodeValidation_Ohio,
                jsonobjectsub_Map.get(ProcedureCode).toString(), jsonobjectsub_Map.get(PayerProgram).toString(), jsonobjectsub_Map.get("Payer").toString()));
        dataBaseVerifier.compareMap(dbMapPayerValidation, dbMap);
        jsonobjectsub_Map.put(ProcedureCode, dbMapPayerValidation.get(ProcedureCode.toUpperCase()));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobjectsub_Map, dbMap, dbValue);

    }

    @SuppressWarnings("unchecked")
    public void verifyInboxWorker_AltEvvGenric(JSONObject jsonobject) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        Map<String, String> dbMap;
		/*Map<String, String> dbValue=new HashMap<>();
		dbValue.put("stxSqlQuery", Constant_SQL.stxWorker_AltEVVGeneric);
		dbValue.put("DbColumnName1",jsonobject.get("SequenceID").toString());
		dbValue.put("DbColumnName2",jsonobject.get("EmployeeLastName").toString());*/

        ErrorCode_Verification.employeeQualifierValue(jsonobject);
        ErrorCode_Verification.employeeQualifier_preadd(jsonobject);
        DataGeneratorEmployee.objectCharTruncation(jsonobject, EmployeeFirstName, 30);
        DataGeneratorEmployee.objectCharTruncation(jsonobject, EmployeeOtherID, 64);
        DataGeneratorEmployee.objectCharTruncation(jsonobject, EmployeeAPI, 25);
        DataGeneratorEmployee.objectCharTruncation(jsonobject, EmployeeLastName, 25);

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxWorker_AltEVVGeneric,
                jsonobject.get(SequenceID).toString(),
                jsonobject.get(EmployeeLastName).toString()));

        jsonobject.put("ERROR_CODE", "0");
        dataBaseVerifier.compareMap(dbMap, jsonobject);

//		ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobject, dbMap, dbValue);
    }

    @SuppressWarnings("unchecked")
    public void jsonAssertInboxWorker_AltEvvGenric(String bodyAsString, JSONObject jsonobject) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxWorker_AltEVVGeneric);
        dbValue.put("DbColumnName1", jsonobject.get("SequenceID").toString());
        dbValue.put("DbColumnName2", jsonobject.get("EmployeeLastName").toString());

        ErrorCode_Verification.employeeQualifierValue(jsonobject);
        ErrorCode_Verification.employeeQualifier_preadd(jsonobject);
        DataGeneratorEmployee.objectCharTruncation(jsonobject, "EmployeeFirstName", 30);
        DataGeneratorEmployee.objectCharTruncation(jsonobject, "EmployeeOtherID", 64);
        DataGeneratorEmployee.objectCharTruncation(jsonobject, "EmployeeAPI", 25);

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxWorker_AltEVVGeneric,
                jsonobject.get("SequenceID").toString(),
                jsonobject.get("EmployeeLastName").toString()));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobject, dbMap, dbValue);
    }

    public void jsonAssertInboxWorker_AltEvvGenric_Not_Existing_In_DB(String bodyAsString, JSONObject jsonobject) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

        ErrorCode_Verification.employeeQualifierValue(jsonobject);
        ErrorCode_Verification.employeeQualifier_preadd(jsonobject);
        DataGeneratorEmployee.objectCharTruncation(jsonobject, "EmployeeFirstName", 30);
        DataGeneratorEmployee.objectCharTruncation(jsonobject, "EmployeeOtherID", 64);
        DataGeneratorEmployee.objectCharTruncation(jsonobject, "EmployeeAPI", 25);

        String dbMap = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.inboxWorker_AltEVVGeneric,
                jsonobject.get("SequenceID").toString(),
                jsonobject.get("EmployeeLastName").toString()));

        Assert.assertNull(dbMap);
    }


    // *********************** AltEVVMolina ********************//
    // *********************** AltEVVMolina ********************//

    @SuppressWarnings("unchecked")
    public void jsonAssert_inboxVisit_altevv_Molina(String bodyAsString, JSONObject jsonobject) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {

        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));

        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxVisitAltEVVMolina);
        dbValue.put("DbColumnName1", jsonobject.get("VisitOtherID").toString());
        dbValue.put("DbColumnName2", jsonobject.get("SequenceID").toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitAltEvvMolina,
                jsonobject.get("VisitOtherID").toString(),
                jsonobject.get("SequenceID").toString()));
        jsonobject.put("VISITKEY", dbMap.get("VISITKEY"));
        jsonobject.put("EMPLOYEEQUALIFIER", dbMap.get("EMPLOYEEQUALIFIER"));
        jsonobject.put("CLIENTIDQUALIFIER", dbMap.get("CLIENTIDQUALIFIER"));
        jsonobject.put(ProcedureCode, dbMap.get(ProcedureCode));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobject, dbMap, dbValue);
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_inboxVisitChanges_Molina(String bodyAsString, JSONObject jsonObjectMainArray, JSONObject jsonobject_SubArray) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));
        Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));

        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxVisitAltEVVMolina);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get("VisitOtherID").toString());
        dbValue.put("DbColumnName2", jsonObjectMainArray.get("SequenceID").toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitAltEvvMolina,
                jsonObjectMainArray.get("VisitOtherID").toString(),
                jsonObjectMainArray.get("SequenceID").toString()));
        jsonObjectMainArray.put("VISITKEY", dbMap.get("VISITKEY"));
        jsonObjectMainArray.put("EMPLOYEEQUALIFIER", dbMap.get("EMPLOYEEQUALIFIER"));
        jsonObjectMainArray.put("CLIENTIDQUALIFIER", dbMap.get("CLIENTIDQUALIFIER"));
        jsonObjectMainArray.put(ProcedureCode, dbMap.get(ProcedureCode));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObjectMainArray, dbMap, dbValue);

        //Verifiying error code validation in Visit Change DB
        dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxVisitChangeLogMolina);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get("VisitOtherID").toString());
        dbValue.put("DbColumnName2", jsonObjectMainArray.get("SequenceID").toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitChangeMolina,
                jsonObjectMainArray.get("VisitOtherID").toString(),
                jsonobject_SubArray.get("SequenceID").toString()));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobject_SubArray, dbMap, dbValue);

    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_inboxVisitStatus(String bodyAsString, JSONObject jsonobject) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException {
        logger.log(LogStatus.INFO, "Validating DB response ");

        jsonobject.put("error_code", "0");

        Map<String, String> dbMap;

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitAltEvvMolina,
                jsonobject.get("VisitOtherID").toString(),
                jsonobject.get("SequenceID").toString()));
        jsonobject.put("VISITKEY", dbMap.get("VISITKEY"));
        jsonobject.put("EMPLOYEEQUALIFIER", dbMap.get("EMPLOYEEQUALIFIER"));
        jsonobject.put("CLIENTIDQUALIFIER", dbMap.get("CLIENTIDQUALIFIER"));
        jsonobject.put("CLIENTIDENTIFIER", jsonobject.get("ClientID"));

        dataBaseVerifier.compareMap(dbMap, jsonobject);
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_inboxVisitCallsMolina(String bodyAsString, JSONObject jsonObjectMainArray, JSONObject jsonobject_SubArray) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxVisitAltEVVMolina);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get("VisitOtherID").toString());
        dbValue.put("DbColumnName2", jsonObjectMainArray.get("SequenceID").toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitAltEvvMolina,
                jsonObjectMainArray.get("VisitOtherID").toString(),
                jsonObjectMainArray.get("SequenceID").toString()));
        jsonObjectMainArray.put("VISITKEY", dbMap.get("VISITKEY"));
        jsonObjectMainArray.put("EMPLOYEEQUALIFIER", dbMap.get("EMPLOYEEQUALIFIER"));
        jsonObjectMainArray.put("CLIENTIDQUALIFIER", dbMap.get("CLIENTIDQUALIFIER"));
        jsonObjectMainArray.put(ProcedureCode, dbMap.get(ProcedureCode));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObjectMainArray, dbMap, dbValue);

        logger.log(LogStatus.INFO, "Validating INbox and Stx DB for for VisitCalls");
        dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxVisitCalls);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get("VisitOtherID").toString());
        dbValue.put("DbColumnName2", jsonobject_SubArray.get("CallExternalID").toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitCalls,
                jsonObjectMainArray.get("VisitOtherID").toString(),
                jsonobject_SubArray.get("CallAssignment").toString()));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobject_SubArray, dbMap, dbValue);

    }


    public void jsonAssert_InboxClient_AltEVVMolina(String bodyAsString, JSONObject jsonObjectMainArray) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, ParseException {
        //	if ClientQualifier is "ClientSSN", ClientSSN will be overwritten by ClientIdentifier.
        //	if ClientQualifier is "ClientOtherID", ClientOtherID will be overwritten by ClientIdentifier.
        //	if ClientCustomID is "ClientCustomID", ClientCustomID will be overwritten by ClientIdentifier.

        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));

        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientAltEVVmolinaSql);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObjectMainArray.get("ClientFirstName").toString());

        DataGeneratorClient.clientQualifierValueAssigned(jsonObjectMainArray);

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientAltevvMolinaSql,
                jsonObjectMainArray.get(globalVariables.ClientID).toString(),
                jsonObjectMainArray.get("ClientFirstName").toString()));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObjectMainArray, dbMap, dbValue);

    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_InboxClientAddress_ALtEVVMolina(String bodyAsString, JSONObject jsonObjectMainArray, JSONObject jsonObject_SubArray) throws java.text.ParseException, SQLException, IOException, ParseException, InterruptedException, ClassNotFoundException {

//		jsonAssert_InboxClient_AltEVVMolina(bodyAsString, jsonObjectMainArray);

        logger.log(LogStatus.INFO, "Validating JSON response ");

        logger.log(LogStatus.INFO, "Validating DB response for Clientaddress for altevv generic");
        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientAddressSql_AltEVVGenric);
        dbValue.put("DbColumnName1", jsonObjectMainArray.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonObject_SubArray.get("ClientAddressLine1").toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.clientAddressSql_AltEVVMolina,
                jsonObjectMainArray.get(globalVariables.ClientID).toString(),
                jsonObject_SubArray.get("ClientAddressLine1").toString()));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObject_SubArray, dbMap, dbValue);

    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_InboxClientContact_Molina(String bodyAsString, JSONObject jsonobject_map, JSONObject jsonobject_SubArray) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, ParseException {
//		jsonAssert_InboxClient_AltEVVMolina(bodyAsString, jsonobject_map);

        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        jsonobject_SubArray.put(globalVariables.ClientID, jsonobject_map.get(globalVariables.ClientID));

        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientContactSql_AltEVVMolina);
        dbValue.put("DbColumnName1", jsonobject_map.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonobject_SubArray.get(globalVariables.ClientContactFirstName).toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientContactSql_AltEVVmolina,
                jsonobject_map.get(globalVariables.ClientID).toString(),
                jsonobject_SubArray.get(globalVariables.ClientContactFirstName).toString()));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobject_SubArray, dbMap, dbValue);
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_Authlimits_altevv_Molina(String bodyAsString, JSONObject jsonobject_Map, JSONObject jsonobjectsub_Map) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, ParseException {

        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));

        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxAuthLimit_AltevvMolina);
        dbValue.put("DbColumnName1", jsonobject_Map.get(globalVariables.ClientID).toString());
        dbValue.put("DbColumnName2", jsonobjectsub_Map.get(globalVariables.PayerID).toString());

        DataGeneratorClient.objectCharTruncation(jsonobjectsub_Map, PayerProgram, 9);
        DataGeneratorClient.objectCharTruncation(jsonobjectsub_Map, ProcedureCode, 9);

        logger.log(LogStatus.INFO, "Validating DB response ");

        Map<String, String> dbMap;

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxAuthLimit_AltEvvMolina,
                jsonobject_Map.get(globalVariables.ClientID).toString(),
                jsonobjectsub_Map.get(globalVariables.PayerID).toString()));

        Map<String, String> dbMapPayerValidation;
        dbMapPayerValidation = dataBaseVerifier.executeQuery(String.format(Constant_SQL.payerCodeValidation_Altevv,
                jsonobjectsub_Map.get(ProcedureCode).toString(), jsonobjectsub_Map.get(PayerProgram).toString(),
                jsonobjectsub_Map.get(globalVariables.PayerID).toString()));

        dataBaseVerifier.compareMap(dbMapPayerValidation, dbMap);
        jsonobjectsub_Map.put(ProcedureCode, dbMapPayerValidation.get(ProcedureCode));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobjectsub_Map, dbMap, dbValue);

    }


    @SuppressWarnings("unchecked")
    public void jsonAssert_InboxWorker_AltEVV_Molina(String bodyAsString, JSONObject jsonobject) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException {
        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        Assert.assertTrue(bodyAsString.contains("\"Reason\": \"Transaction Received.\""));

        logger.log(LogStatus.INFO, "Validating DB response ");

        jsonobject.put("error_code", "0");

        Map<String, String> dbMap;

        if (jsonobject.get("EmployeeQualifier").toString().equals("EmployeeRegID")) {
            jsonobject.put("EmployeeSSN", jsonobject.get("EmployeeSSN").toString());
        } else if (jsonobject.get("EmployeeQualifier").toString().equals("EmployeeSSN")) {
            jsonobject.put("EmployeeSSN", jsonobject.get("EmployeeIdentifier").toString());
        } else if (jsonobject.get("EmployeeQualifier").toString().equals("EmployeeCustomID")) {
            jsonobject.put("EmployeeOtherID", jsonobject.get("EmployeeIdentifier").toString());
        }

        if (String.valueOf(jsonobject.get("EmployeeIdentifier")).length() < 9) {

            jsonobject.put("EmployeeIdentifier", String.format("%09d", Integer.parseInt(jsonobject.get("EmployeeIdentifier").toString())));
        }


        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxWorker_AltEvvMolina,
                jsonobject.get("SequenceID").toString(),
                jsonobject.get("EmployeeLastName").toString()));

        dataBaseVerifier.compareMap(dbMap, jsonobject);

    }


    // *********************** Ohio ********************//
    // *********************** Ohio ********************//

    //--------------------------------------------------------non ----------------------------------------------------------

    public void assertControlFileValidOhio_fail(List<String> fileNames, Map<String, String> finalMapapdataByRow, String timeStamp, String batchId, List<String> status) throws Exception {
        try {

            int count = 0;

            for (String filevalue : fileNames) {


                if ((filevalue).contains(globalVariables.ohiInboundFileNamegenerated + batchId + "_Controlfile_" + timeStamp + ".dsv")) {

                    FileContentReader.verifyFileContainString(globalVariables.getOhioClaimFileDrop + filevalue, status, 2);

                }

                if ((filevalue).contains(globalVariables.ohiInboundFileNamegenerated + batchId + "_Controlfile_" + timeStamp + ".dsv")) {
                    System.out.println("-------------Varifying Control File----------");

                    Map<String, String> controlFileData = new HashMap<>();
                    controlFileData = FileContentReader.readFileDataAddToMap(globalVariables.getOhioClaimFileDrop + filevalue);

                    CommonMethods.AssertEqualsAndPrintValuesString(globalVariables.ohioproductionFileNamegenerated + "." + timeStamp + "." + batchId + ".txt", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");
                    count++;

                }

            }
            if (count == 0) {
                fail("Inbound control file not Found");
            }
        } finally {
            System.gc();

        }
    }

    public void assertControlFileValidOhio(List<String> fileNames, Map<String, String> finalMapapdataByRow, String timeStamp, String batchId, List<String> status) throws Exception {
        Map<String, String> finalMapapdataByResp = new HashMap<String, String>();
        Map<String, String> dbMap = new HashMap<>();
        String respFilename = globalVariables.ohioproductionFileNamegenerated + timeStamp + "_" + batchId + ".dsv";
        try {

            finalMapapdataByResp = FileContentReader.getFileDataOnMap(globalVariables.getOhioClaimFileDrop + respFilename);
            for (String key : finalMapapdataByResp.keySet()) {
                if (key.equalsIgnoreCase("VisitFound") && finalMapapdataByResp.get("VisitFound").equals("true")) {
                    finalMapapdataByResp.replace(key, "1");
                    break;
                }

            }
            dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.claimValidationSql, finalMapapdataByRow.get("TransactionID")));
            for (String key : dbMap.keySet()) {

                if (key.equalsIgnoreCase("UNITS")) {

                    if ((finalMapapdataByResp.get("Units").matches("[0-9.]*"))) {

                        dbMap.replace(key, dbMap.get("UNITS") + ".0");
                        break;
                    }
                }
            }
            dataBaseVerifier.compareMap(dbMap, finalMapapdataByResp);

            int count = 0;

            for (String filevalue : fileNames) {


                if ((filevalue).contains(respFilename)) {
                    FileContentReader.verifyFileContainString(globalVariables.getOhioClaimFileDrop + filevalue, status, 2);
                }

                if ((filevalue).contains(globalVariables.ohiInboundFileNamegenerated + batchId + "_Controlfile_" + timeStamp + ".dsv")) {
                    System.out.println("-------------Varifying Control File----------");

                    Map<String, String> controlFileData = new HashMap<>();
                    controlFileData = FileContentReader.readFileDataAddToMap(globalVariables.getOhioClaimFileDrop + filevalue);

                    CommonMethods.AssertEqualsAndPrintValuesString(respFilename, controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");
                    count++;
                }
            }
            if (count == 0) {
                fail("Inbound control file not Found");
            }
        } finally {
            System.gc();


        }
    }

    public void assertControlFileValidOhio_error(List<String> fileNames, Map<String, String> finalMapapdataByRow, String timeStamp, String batchId, List<String> status) throws Exception {

        String respFilename = globalVariables.ohioproductionFileNamegenerated + timeStamp + "_" + batchId + ".dsv";
        String errorFilename = globalVariables.ohioproductionerrorfilegenerated + timeStamp + "_" + batchId + ".dsv";
        try {
            int count = 0;
            for (String filevalue : fileNames) {


                if ((filevalue).contains(errorFilename)) {
                    FileContentReader.verifyFileContainString(globalVariables.getOhioClaimFileDrop + filevalue, status, 2);
                }
                if ((filevalue).contains(globalVariables.ohiInboundFileNamegenerated + batchId + "_Controlfile_" + timeStamp + ".dsv")) {
                    System.out.println("-------------Varifying Control File----------");

                    Map<String, String> controlFileData = new HashMap<>();
                    controlFileData = FileContentReader.readFileDataAddToMap(globalVariables.getOhioClaimFileDrop + filevalue);

                    CommonMethods.AssertEqualsAndPrintValuesString(respFilename, controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");
                    count++;
                }
            }
            if (count == 0) {
                fail("Inbound control file not Found");
            }


        } finally {
            System.gc();
        }
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_inboxVisit_Ohio(String bodyAsString, JSONObject jsonobject) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {

        logger.log(LogStatus.INFO, "Validating JSON response ");

        //Assert.assertTrue(bodyAsString.contains("\"data\": \"All records uploaded successfully.\""));
        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap;
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxVisitOhio);
        dbValue.put("DbColumnName1", jsonobject.get("VisitOtherID").toString());
        dbValue.put("DbColumnName2", jsonobject.get("SequenceID").toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitOhio, jsonobject.get("VisitOtherID").toString(),
                jsonobject.get("SequenceID").toString()));

        jsonobject.put("VISITKEY", dbMap.get("VISITKEY"));
        Assert.assertFalse(dbMap.isEmpty());//Make sure the visit is stored to DB

        //Don't neet compare PROCEDURE CODE code inside visit
//		Map<String,String> dbMapPayerValidation=new HashMap<>();
//		dbMapPayerValidation=dataBaseVerifier.executeQuery(String.format(Constant_SQL.payerCodeValidation_Ohio,
//				jsonobject.get(ProcedureCode).toString(),jsonobject.get(PayerProgram).toString(),jsonobject.get("Payer").toString(),jsonobject.get(ProcedureCode).toString()));
//		dataBaseVerifier.compareMap(dbMapPayerValidation, dbMap);
//		jsonobject.put(ProcedureCode.toUpperCase(), dbMapPayerValidation.get(ProcedureCode.toUpperCase()));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobject, dbMap, dbValue);

    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_InboxClient_3P(String bodyAsString, JSONObject jsonObject_Map) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException, ParseException {
        logger.log(LogStatus.INFO, "Validating JSON response ");

//		Assert.assertTrue(bodyAsString.contains("\"data\": \"All records uploaded successfully.\""));

        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap = new HashMap<>();
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientSql_Ohio);
        dbValue.put("DbColumnName1", jsonObject_Map.get("SequenceID").toString());
        dbValue.put("DbColumnName2", jsonObject_Map.get("BusinessEntityID").toString());

        JSONArray jsonArray_Sub = (JSONArray) jsonObject_Map.get("Address");
        JSONObject jsonObjectMap_Supp = (JSONObject) jsonArray_Sub.get(0);
        JSONObject jsonObjectMap_Address = (JSONObject) jsonArray_Sub.get(1);

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientsql_Ohio, jsonObject_Map.get("PatientFirstName").toString(),
                jsonObject_Map.get("SequenceID").toString()));

        jsonObject_Map.put(globalVariables.ClientID, dbMap.get("CLIENTID"));
        ErrorCode_Verification.errorCodeVerificationOtherThanZeroOhio(jsonObject_Map, dbMap, dbValue);

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxClientSql_Ohio, jsonObject_Map.get("SequenceID").toString(), jsonObject_Map.get("BusinessEntityID").toString()));

        jsonObject_Map.put("CLIENTKEY", dbMap.get("CLIENTKEY"));
        dataBaseVerifier.compareMap(dbMap, jsonObject_Map);
        String ClientKey = dbMap.get("CLIENTKEY");

        CommonMethods.ZipadditionfourZero(jsonObjectMap_Supp, "PatientZip");
        CommonMethods.ZipadditionfourZero(jsonObjectMap_Address, "PatientZip");

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxClientSuppSql_Ohio, ClientKey));
        dataBaseVerifier.compareMap(dbMap, jsonObjectMap_Supp);

        jsonObjectMap_Address.put("ERROR_CODE", "0"); // shoule be null

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.clientAddressSql_Ohio3P, jsonObjectMap_Address.get("PatientAddressLine2").toString(), jsonObjectMap_Address.get("PatientAddressLine1").toString()));
        dataBaseVerifier.compareMap(dbMap, jsonObjectMap_Address);

    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_InboxWorker_Ohio(String bodyAsString, JSONObject jsonobject) throws SQLException, ParseException, java.text.ParseException, InterruptedException, ClassNotFoundException {
        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap = new HashMap<>();
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.StxWorker_3P);
        dbValue.put("DbColumnName1", jsonobject.get("SequenceID").toString());
        dbValue.put("DbColumnName2", jsonobject.get("BusinessEntityID").toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxWorker_3P, jsonobject.get("StaffSSN").toString(),
                jsonobject.get("BusinessEntityID").toString()));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonobject, dbMap, dbValue);
    }


    // *********************** Common ********************//
    // ***********************Common ********************//

    // *********************** Common ********************//
    // *********************** Common ********************//

    @SuppressWarnings("unchecked")
    public void jsonAssert_inboxVisitSchedule(String bodyAsString, JSONObject jsonobject) throws InterruptedException, java.text.ParseException, SQLException, ClassNotFoundException {
        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));

        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMapInboxVisit;
        dbMapInboxVisit = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitAltEvvGeneric, jsonobject.get("VisitOtherID").toString(),
                jsonobject.get("SequenceID").toString()));

        jsonobject.put("SID", dbMapInboxVisit.get("SID"));
        jsonobject.put("ERROR_CODE", "0");

        System.out.println(dbMapInboxVisit.get("SID"));

        Map<String, String> dbMapInboxSchedule;
        dbMapInboxSchedule = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitSchedule, dbMapInboxVisit.get("SID")));

        DataGeneratorEmployee.employeeQualifierValueAssigned(jsonobject);
        DataGeneratorVisit.clientIDQualifierKeyAssigned(jsonobject);

        dataBaseVerifier.compareMap(dbMapInboxSchedule, jsonobject);

    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_inbox_Provider(String bodyAsString, JSONObject jsonobject) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException {
        Thread.sleep(10000);
        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));

        logger.log(LogStatus.INFO, "Validating DB response ");
        DataGeneratorClient.Provider_primarycontactlastname(jsonobject);
        jsonobject.put("ERROR_CODE", "0");
        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxprovider, jsonobject.get("ProviderID").toString(), jsonobject.get("ProviderName").toString()));

        dataBaseVerifier.compareMap(dbMap, jsonobject);

    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_stx_Accounts_info(String bodyAsString, JSONObject jsonobject) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException {

        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));

        logger.log(LogStatus.INFO, "Validating DB response ");
        DataGeneratorClient.Provider_primarycontactlastname(jsonobject);
        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccounts_info, jsonobject.get("ProviderName").toString()));

        dataBaseVerifier.compareMap(dbMap, jsonobject);
        //String account =dataBaseVerifier.executeQueryString(String.format(Constant_SQL.getAccountFromProvider,jsonobject.get("ProviderID").toString()));
        //CommonMethods.updateCsvFile(fileNameProvider,account);
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_stx_stxAccouts_interfaces(String bodyAsString, JSONObject jsonobject) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException {

        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));

        logger.log(LogStatus.INFO, "Validating DB response ");

        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccouts_interfaces, jsonobject.get("ProviderID").toString()));

        dataBaseVerifier.compareMap(dbMap, jsonobject);

    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_stxAccounts_TaxID(String bodyAsString, JSONObject jsonobject) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException {

        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));

        logger.log(LogStatus.INFO, "Validating DB response ");

        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccounts_TaxID, jsonobject.get("ProviderName").toString()));

        dataBaseVerifier.compareMap(dbMap, jsonobject);

    }

    public void jsonAssert_stx_Accounts_Web(String bodyAsString, String Account) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException {

        logger.log(LogStatus.INFO, "Validating JSON response ");
        Map<String, String> dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccountsWeb, Account));

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));
        Assert.assertTrue(bodyAsString.contains("\"WebUsername\":" + " " + dbMap.get("WEBUSER")));
        Assert.assertTrue(bodyAsString.contains("\"WebPassword\":"));

    }

    public void claim_assertion(String bodyAsString, Map<String, JSONObject> jsonobject) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException {

        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"VisitFound\": false,"));


        logger.log(LogStatus.INFO, "Validating DB response ");

        String vsistid = jsonobject.get("visit").get("VisitOtherID").toString();

        String status = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.visitclaimStatus, dataBaseVerifier.executeQueryString(String.format(Constant_SQL.inboxvisitkey, vsistid))));

        System.out.println(status);
        assertEquals(null, status);


    }

    public void claim_assertion_dual(String bodyAsString, Map<String, JSONObject> jsonobject) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException {

        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"VisitFound\": true,"));


        logger.log(LogStatus.INFO, "Validating DB response ");

        String vsistid = jsonobject.get("visit").get("VisitOtherID").toString();

        String status = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.visitclaimStatus, dataBaseVerifier.executeQueryString(String.format(Constant_SQL.inboxvisitkey, vsistid))));

        System.out.println(status);
        assertEquals(status, "Verified");


    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_inboxVisitException(String bodyAsString, JSONObject jsonObjectMainArray, JSONObject jsonobject_SubArray) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException {
        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

        Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

        logger.log(LogStatus.INFO, "Validating DB response");
        jsonObjectMainArray.put("error_code", "0");

        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitAltEvvMolina, jsonObjectMainArray.get("VisitOtherID").toString(),
                jsonObjectMainArray.get("SequenceID").toString()));

        jsonObjectMainArray.put("VISITKEY", dbMap.get("VISITKEY"));
        jsonObjectMainArray.put("EMPLOYEEQUALIFIER", dbMap.get("EMPLOYEEQUALIFIER"));
        jsonObjectMainArray.put("CLIENTIDQUALIFIER", dbMap.get("CLIENTIDQUALIFIER"));
        jsonObjectMainArray.put("CLIENTIDENTIFIER", jsonObjectMainArray.get(globalVariables.ClientID));

        dataBaseVerifier.compareMap(dbMap, jsonObjectMainArray);

        JSONArray jsonArrayVisitExceptionAcknowledgement = (JSONArray) jsonObjectMainArray.get("VisitExceptionAcknowledgement");
        JSONObject jsonObjectVisitVisitExceptionAcknowledgement = (JSONObject) jsonArrayVisitExceptionAcknowledgement.get(0);
        jsonObjectVisitVisitExceptionAcknowledgement.put(globalVariables.ExceptionAcknowledgedjson, true);

        if (jsonObjectVisitVisitExceptionAcknowledgement.get("ExceptionAcknowledged").toString() == "true") {
            jsonObjectVisitVisitExceptionAcknowledgement.put("ExceptionAcknowledged", "1");

        } else if (jsonObjectVisitVisitExceptionAcknowledgement.get("ExceptionAcknowledged").toString() == "false") {
            jsonObjectVisitVisitExceptionAcknowledgement.put("ExceptionAcknowledged", "0");
        }

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitException, jsonObjectMainArray.get("VisitOtherID").toString()));
        jsonObjectVisitVisitExceptionAcknowledgement.put("EXCEPTION_ID", dbMap.get("EXCEPTION_ID"));
        jsonObjectVisitVisitExceptionAcknowledgement.put("ERROR_CODE", null);

        dataBaseVerifier.compareMap(dbMap, jsonObjectVisitVisitExceptionAcknowledgement);


    }

    @SuppressWarnings("unchecked")
    public void stxClientSql_OhioV2_SEVV9533(String bodyAsString, JSONObject jsonObject_Map) throws SQLException, InterruptedException, ClassNotFoundException, ParseException, java.text.ParseException {
        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"messageSummary\": \"Transaction Received.\","));

        logger.log(LogStatus.INFO, "Validating DB response ");
        Map<String, String> dbMap = new HashMap<>();
        Map<String, String> dbValue = new HashMap<>();
        dbValue.put("stxSqlQuery", Constant_SQL.stxClientSql_OhioV2);
        dbValue.put("DbColumnName1", jsonObject_Map.get("SequenceID").toString());
        dbValue.put("DbColumnName2", jsonObject_Map.get("BusinessEntityID").toString());

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxClientsql_Ohio, jsonObject_Map.get("PatientFirstName").toString(), jsonObject_Map.get("SequenceID").toString()));

        jsonObject_Map.put(globalVariables.ClientID, dbMap.get("CLIENTID"));

        ErrorCode_Verification.errorCodeVerificationOtherThanZero(jsonObject_Map, dbMap, dbValue);

        JSONArray jsonArray_Sub = (JSONArray) jsonObject_Map.get("IndividualPayerInformation");
        JSONObject jsonObjectMap_Auth = (JSONObject) jsonArray_Sub.get(0);

        jsonAssert_Authlimits_Ohio(bodyAsString, jsonObject_Map, jsonObjectMap_Auth);

    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_STX_AppUser(String bodyAsString, JSONObject jsonObject_Map) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException {
        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));

        logger.log(LogStatus.INFO, "Validating DB response ");

        Map<String, String> dbMap = new HashMap<>();
        @SuppressWarnings("unused")
        String clientDesigneeEmail = jsonObject_Map.get("ClientDesigneeEmail").toString();
        @SuppressWarnings("unused")
        String ClientEmailAddress = jsonObject_Map.get("ClientEmailAddress").toString();


        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAppUsersSql, jsonObject_Map.get("ClientDesigneeEmail").toString(), jsonObject_Map.get("ClientEmailAddress").toString()));

        dataBaseVerifier.compareMap(dbMap, jsonObject_Map);

    }

    public void jsonAssert_iodata(String bodyAsString, String uuid) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException {

        logger.log(LogStatus.INFO, "Validating DB response ");

        @SuppressWarnings("unused")
        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.iodataOhioSql, uuid));
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_STXClientContact(String bodyAsString, JSONObject jsonobject_Map, JSONObject jsonobjectsub_Map) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException {
        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

        logger.log(LogStatus.INFO, "Validating DB response ");

        jsonobjectsub_Map.put("error_code", "0");
        jsonobjectsub_Map.put(globalVariables.ClientID, jsonobject_Map.get(globalVariables.ClientID));


        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxClientContactSql, jsonobject_Map.get(globalVariables.ClientID).toString(),
                jsonobjectsub_Map.get(globalVariables.ClientContactFirstName).toString()));

        dataBaseVerifier.compareMap(dbMap, jsonobjectsub_Map);

    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_stxWorker_supp(String bodyAsString, JSONObject jsonobject) throws SQLException, ParseException, java.text.ParseException, InterruptedException, ClassNotFoundException {
        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        //	Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\""));
        try {
            jsonobject.put("EmployeeHireDate", CommonMethods.dateToDateTimeFormat(jsonobject.get(globalVariables.EmployeeHireDate).toString()));
            jsonobject.put("EmployeeEndDate", CommonMethods.dateToDateTimeFormat(jsonobject.get(globalVariables.EmployeeEndDate).toString()));
        } catch (Exception e) {
            System.out.println("EmployeeHireDate is not present ");
        }
        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxWorkerSupp, jsonobject.get("EmployeeSocialSecurity").toString()));

        dataBaseVerifier.compareMap(dbMap, jsonobject);
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_stxWorker_supp_molina(String bodyAsString, JSONObject jsonobject) throws SQLException, ParseException, java.text.ParseException, InterruptedException, ClassNotFoundException {
        logger.log(LogStatus.INFO, "Validating JSON response ");
        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));

        Map<String, String> dbMap = new HashMap<>();
        jsonobject.put("ERROR_CODE", "0");

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxWorkerSupp_molina, jsonobject.get("EmployeeSSN").toString()));

        dataBaseVerifier.compareMap(dbMap, jsonobject);
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_STXSchedule(String bodyAsString, JSONObject jsonobject) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException {
        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\","));
        Assert.assertTrue(bodyAsString.contains("\"reason\": \"Transaction Received.\","));

        logger.log(LogStatus.INFO, "Validating DB response ");

        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxSchedule_OpenEvv, jsonobject.get("EmployeePIN").toString()));

        dataBaseVerifier.compareMap(dbMap, jsonobject);

    }

    ///method after parallel execution *****************************88//

    public synchronized void assertControlFileInValidindiana(List<String> fileNames, String fileNameProcessedFile, List<String> ErroMessage, String errorFile, String timeStamp) throws Exception {
        try {
            for (String filevalue : fileNames) {

                if (filevalue.contains(fileNameProcessedFile)) {
                    System.out.println("Successfully imported");
                    FileContentReader.deleteFile(filevalue + ".gpg");
                }
                String[] tcname = Thread.currentThread().getStackTrace()[2].getMethodName().split("_");
                if ((filevalue).contains(globalVariables.indianaGenericFileFormat + tcname[2] + "_" + errorFile + "_" + "Error" + "_" + timeStamp + ".csv.gpg")) {

                    FileContentReader.verifyFileContainString(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""), ErroMessage, 2);

                }
                if ((filevalue).contains(CommonMethods.callgenerateInboundControlFile(timeStamp, globalVariables.indianaGenericFileFormat))) {

                    Map<String, String> controlFileData = new HashMap<>();
                    controlFileData = FileContentReader.readFileDataAddToMap(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));

                    CommonMethods.AssertEqualsAndPrintValuesString(fileNameProcessedFile + ".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");

                }

            }
        } finally {
            System.gc();
            for (String filevalue : fileNames) {
                FileContentReader.deleteFile(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.decryptedfileResult + filevalue);
                FileContentReader.deleteFile(globalVariables.Encryptfile + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.EncryptedfileResult + filevalue);

            }

        }
    }

    public synchronized void assertControlFileInValidpenselvania(List<String> fileNames, String fileNameProcessedFile, List<String> ErroMessage, String errorFile, String timeStamp) throws Exception {
        try {
            for (String filevalue : fileNames) {

                if (filevalue.contains(fileNameProcessedFile)) {
                    System.out.println("Successfully imported");
                    FileContentReader.deleteFile(filevalue + ".gpg");
                }
                String[] tcname = Thread.currentThread().getStackTrace()[2].getMethodName().split("_");
                if ((filevalue).contains(globalVariables.PAGenericFileFormat + tcname[2] + "_" + errorFile + "_" + "Error" + "_" + timeStamp + ".csv.gpg")) {

                    FileContentReader.verifyFileContainString(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""), ErroMessage, 2);

                }
                if ((filevalue).contains(CommonMethods.callgenerateInboundControlFile(timeStamp, globalVariables.PAGenericFileFormat))) {

                    Map<String, String> controlFileData = new HashMap<>();
                    controlFileData = FileContentReader.readFileDataAddToMap(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));

                    CommonMethods.AssertEqualsAndPrintValuesString(fileNameProcessedFile + ".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");

                }

            }
        } finally {
            System.gc();
            for (String filevalue : fileNames) {
                FileContentReader.deleteFile(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.decryptedfileResult + filevalue);
                FileContentReader.deleteFile(globalVariables.Encryptfile + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.EncryptedfileResult + filevalue);

            }

        }
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_inbox_Provider_without_nonmandate(String bodyAsString, JSONObject jsonobject) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException {

        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));

        logger.log(LogStatus.INFO, "Validating DB response ");

        jsonobject.put("ERROR_CODE", "0");
        Map<String, String> dbMap = new HashMap<>();


        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxprovider_without_nonmandate, jsonobject.get("ProviderID").toString(), jsonobject.get("ProviderName").toString()));

        dataBaseVerifier.compareMap(dbMap, jsonobject);
        String account = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.getAccountFromProvider, jsonobject.get("ProviderID").toString()));

    }

    public void verifyInboundFile(List<String> fileNames, Map<String, String> fileNameProcessedFile, String timeStamp) throws Exception {
        int row;
        try {

            for (String filevalue : fileNames) {

                System.out.println();
                if ((filevalue).contains(CommonMethods.callgenerateInboundControlFile(timeStamp, globalVariables.memberGenericFileNameControlFile))) {
                    for (String fileName : fileNameProcessedFile.keySet()) {
                        System.out.println("-------------Verifying Control File----------");

                        Map<String, String> controlFileData;
                        row = FileContentReader.verifyFileContainStringInrow(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""), fileName.replace(".gpg", ""));
                        controlFileData = FileContentReader.readFileDataAddToMapWithRowNo(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""), row);

                        CommonMethods.AssertEqualsAndPrintValuesString(fileName + ".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
                        CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
                        CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
                        CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");

                    }
                }

            }
        } finally {
            System.gc();

        }
    }

    @SuppressWarnings({"null", "unused"})
    public Float jsonAssert_Hourstobill_AltEVV_Visit_claim(String bodyAsString, JSONObject jsonObjectMainArray) throws SQLException, InterruptedException, java.text.ParseException, ClassNotFoundException {

        JSONArray jsonArrayVisitCallIn = (JSONArray) jsonObjectMainArray.get("Calls");
        JSONObject jsonObjectVisitCallin = (JSONObject) jsonArrayVisitCallIn.get(0);
        JSONObject jsonObjectVisitCallOut = (JSONObject) jsonArrayVisitCallIn.get(1);

        float HoursToBill = (float) 0.0;
        logger.log(LogStatus.INFO, "Validating JSON response ");


        logger.log(LogStatus.INFO, "Validating DB response ");


        if (jsonObjectVisitCallin.get("CallDateTime").toString() == null && (jsonObjectVisitCallOut.get("CallDateTime").toString() == null)) {

            HoursToBill = CommonMethods.subDateTimeReturnMillisecond(jsonObjectMainArray.get("AdjOutDateTime").toString(), jsonObjectMainArray.get("AdjInDateTime").toString());

        } else if (jsonObjectMainArray.get("AdjOutDateTime").toString() == null && jsonObjectMainArray.get("AdjInDateTime").toString() == null) {
            HoursToBill = CommonMethods.subDateTimeReturnMillisecond(jsonObjectVisitCallin.get("CallDateTime").toString(), jsonObjectVisitCallOut.get("CallDateTime").toString());


        } else if (jsonObjectMainArray.get("AdjInDateTime").toString() == null && jsonObjectMainArray.get("AdjOutDateTime").toString() == null && jsonObjectVisitCallin.get("CallDateTime").toString() == null && jsonObjectVisitCallOut.get("CallDateTime").toString() == null) {
            HoursToBill = (Long) null;
        } else if (jsonObjectMainArray.get("AdjInDateTime").toString() == null && jsonObjectVisitCallOut.get("CallDateTime").toString() == null) {
            HoursToBill = CommonMethods.subDateTimeReturnMillisecond(jsonObjectMainArray.get("AdjOutDateTime").toString(), jsonObjectVisitCallin.get("CallDateTime").toString());
        } else if (jsonObjectMainArray.get("AdjOutDateTime").toString() == null && jsonObjectVisitCallin.get("CallDateTime").toString() == null) {
            HoursToBill = CommonMethods.subDateTimeReturnMillisecond(jsonObjectVisitCallOut.get("CallDateTime").toString(), jsonObjectMainArray.get("AdjInDateTime").toString());
        } else if (jsonObjectMainArray.get("AdjOutDateTime").toString() != null && jsonObjectMainArray.get("AdjInDateTime").toString() != null) {

            HoursToBill = CommonMethods.subDateTimeReturnMillisecond(jsonObjectMainArray.get("AdjOutDateTime").toString(), jsonObjectMainArray.get("AdjInDateTime").toString());
        } else if (jsonObjectVisitCallOut.get("CallDateTime").toString() != null && jsonObjectVisitCallin.get("CallDateTime").toString() != null) {
            HoursToBill = CommonMethods.subDateTimeReturnMillisecond(jsonObjectVisitCallOut.get("CallDateTime").toString(), jsonObjectVisitCallin.get("CallDateTime").toString());
        } else if (jsonObjectVisitCallOut.get("CallDateTime").toString() != null && jsonObjectVisitCallin.get("CallDateTime").toString() != null && jsonObjectMainArray.get("AdjOutDateTime").toString() != null && jsonObjectMainArray.get("AdjInDateTime").toString() != null) {

            HoursToBill = CommonMethods.subDateTimeReturnMillisecond(jsonObjectMainArray.get("AdjOutDateTime").toString(), jsonObjectMainArray.get("AdjInDateTime").toString());

        }

        System.out.println(HoursToBill);
        Map<String, String> dbMap = new HashMap<>();
        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxVisitAltEvvGeneric, jsonObjectMainArray.get("VisitOtherID").toString(),
                jsonObjectMainArray.get("SequenceID").toString()));


        Float unit = (((HoursToBill / (1000 * 60)) / 15));

        return unit;

    }

    public void assertControlFile(List<String> fileNames, Map<String, String> finalMapapdataByRow, String timeStamp, String batchId, List<String> status) throws Exception {
        try {


            for (String filevalue : fileNames) {


                if ((filevalue).contains(globalVariables.ohioproductionFileNamegenerated + "." + timeStamp + "." + batchId)) {

                    assertNotEquals((filevalue).contains(globalVariables.ohioproductionFileNamegenerated + "." + timeStamp + "." + batchId), (globalVariables.ohioproductionFileNamegenerated + "." + timeStamp + "." + batchId));

                }

                if ((filevalue).contains(globalVariables.ohiInboundFileNamegenerated + "." + timeStamp + "." + batchId)) {

                    assertNotEquals((filevalue).contains(globalVariables.ohiInboundFileNamegenerated + "." + timeStamp + "." + batchId), (globalVariables.ohiInboundFileNamegenerated + "." + timeStamp + "." + batchId));


                }

            }

        } finally {
            System.gc();

        }
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_inbox_ProviderSpec7(String bodyAsString, JSONObject jsonobject) throws SQLException, InterruptedException, ClassNotFoundException, IOException, ParseException, java.text.ParseException {
        Thread.sleep(10000);
        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));

        logger.log(LogStatus.INFO, "Validating DB response ");

        jsonobject.put("ERROR_CODE", "0");
        Map<String, String> dbMap = new HashMap<>();


        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxprovider, jsonobject.get("ProviderID").toString(), jsonobject.get("ProviderName").toString()));
        dataBaseVerifier.compareMap(dbMap, jsonobject);
        jsonobject.put("TerminationDate", CommonMethods.dateToDateTimeFormat_yyyy_mm_dd(jsonobject.get("TerminationDate").toString()));
        jsonobject.put("ProviderDateBegin", CommonMethods.dateToDateTimeFormat_yyyy_mm_dd(jsonobject.get("ProviderDateBegin").toString()));
        jsonobject.put("SuspensionDate", CommonMethods.dateToDateTimeFormat_yyyy_mm_dd(jsonobject.get("SuspensionDate").toString()));
        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxprovider, jsonobject.get("ProviderID").toString(), jsonobject.get("ProviderName").toString()));
        dataBaseVerifier.compareMap(dbMap, jsonobject);

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxproviderupdated, jsonobject.get("ProviderID").toString()));
        dataBaseVerifier.compareMap(dbMap, jsonobject);

        String account = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.getAccountFromProvider, jsonobject.get("ProviderID").toString()));
//		CommonMethods.updateCsvFile(fileNameProvider,account);
    }

    @SuppressWarnings("unchecked")
    public void jsonAssert_inbox_ProviderTaxonomy(String bodyAsString, JSONObject jsonobject) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException {
        Thread.sleep(10000);
        logger.log(LogStatus.INFO, "Validating JSON response ");

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));

        logger.log(LogStatus.INFO, "Validating DB response ");

        jsonobject.put("ERROR_CODE", "0");
        Map<String, String> dbMap = new HashMap<>();


        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxprovider, jsonobject.get("ProviderID").toString(), jsonobject.get("ProviderName").toString()));
        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.inboxproviderTaxonomy, jsonobject.get("ProviderID").toString()));

        dataBaseVerifier.compareMap(dbMap, jsonobject);
        String account = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.getAccountFromProvider, jsonobject.get("ProviderID").toString()));
    }

    public void jsonAssert_stx_Accounts_Webuser(String bodyAsString, JSONObject jsonobject) throws java.text.ParseException, SQLException, InterruptedException, ClassNotFoundException, IOException, ParseException {

        logger.log(LogStatus.INFO, "Validating JSON response ");
        JSONParser parser = new JSONParser();
        JSONObject jsonobj = (JSONObject) parser.parse(bodyAsString);
        JSONArray jsonArrayResponse = (JSONArray) jsonobj.get("data");
        JSONObject jsonObject = (JSONObject) jsonArrayResponse.get(0);

        Assert.assertTrue(bodyAsString.contains("\"status\": \"SUCCESS\""));

        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccountsWeb, jsonObject.get("WebUsername").toString()));

        Assert.assertEquals(dbMap.get("WEBUSERNAME"), jsonObject.get("WebUsername").toString());
    }

    public Map<String, String> accountdetails_Effectivedates() throws ClassNotFoundException, InterruptedException, java.text.ParseException, SQLException, IOException, ParseException {
        Map<String, String> dbMap = new HashMap<>();

        dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAccountinfo, CommonMethods.propertyfileReader("altevv_accId")));

        return dbMap;
    }

    public synchronized void assertControlFileValidSegment(List<String> fileNames, String fileNameProcessedFile, Map<String, String> finalMapapdataByRow, String OutboundFile, String timeStamp) throws Exception {
        Map<String, String> dbMap = new HashMap<>();
        try {

            int count = 0;
            finalMapapdataByRow.put("ERROR_CODE", "0");
            if (finalMapapdataByRow.get("segmentName").equalsIgnoreCase("clientDiagnosisCode")) {
                dbMap = dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAuthorization_ClientDiagnosis, finalMapapdataByRow.get("clientIdentifier")));
                dataBaseVerifier.compareMap(dbMap, finalMapapdataByRow);

            } else {

                ///Create the authorizationLimitStartTime for authorization files
                finalMapapdataByRow.put("authorizationLimitStartTime", finalMapapdataByRow.get("authorizationStartDate") + " " +
                        CommonMethods.dateToDateTimeForma_HHMM(finalMapapdataByRow.get("authorizationLimitStartTime")));

                ///Create the authorizationLimitEndTime for authorization files
                finalMapapdataByRow.put("authorizationLimitEndTime", finalMapapdataByRow.get("authorizationEndDate") + " " +
                        CommonMethods.dateToDateTimeForma_HHMM(finalMapapdataByRow.get("authorizationLimitEndTime")));
                CommonMethods.dayOfWeekNoFromDayOfWeek(finalMapapdataByRow, "authorizationLimitDayOfWeek");

                //dbMap=dataBaseVerifier.executeQuery(String.format(Constant_SQL.sql_SegmentAuthLimit,finalMapapdataByRow.get("clientIdentifier").toString()));

                //dataBaseVerifier.compareMap(dbMap,finalMapapdataByRow);
                verify_ImportFile_MySQlDataBase_Auth(finalMapapdataByRow);
            }


            for (String filevalue : fileNames) {

                if ((filevalue).contains(fileNameProcessedFile)) {
                    System.out.println("Successfully imported");


                }
                if ((filevalue).contains(OutboundFile)) {
                    System.out.println("Successfully imported outbound file");

                }

                if ((filevalue + ".gpg").contains(CommonMethods.callgenerateInboundControlFileSegment(timeStamp, globalVariables.memberGenericFileNameControlFile))) {
                    System.out.println("-------------Varifying Control File----------");

                    Map<String, String> controlFileData = new HashMap<>();
                    controlFileData = FileContentReader.readFileDataAddToMap(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));

                    CommonMethods.AssertEqualsAndPrintValuesString(fileNameProcessedFile + ".gpg", controlFileData.get("\"FileName\"").replace("\"", ""), "Processed File Name");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"RecordCount\"").replace("\"", ""), "Total Record Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("1", controlFileData.get("\"Success Count\"").replace("\"", ""), "Total Success Count");
                    CommonMethods.AssertEqualsAndPrintValuesString("0", controlFileData.get("\"Failed Count\"").replace("\"", ""), "Total Failed Count");
                    count++;

                }

            }
            if (count == 0) {
                fail("Inbound control file not Found");
            }
        } finally {
            System.gc();
            for (String filevalue : fileNames) {
                FileContentReader.deleteFile(globalVariables.decryptedfileResultTo + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.decryptedfileResult + filevalue);
                FileContentReader.deleteFile(globalVariables.Encryptfile + filevalue.replace(".gpg", ""));
                FileContentReader.deleteFile(globalVariables.EncryptedfileResult + filevalue);
            }
        }

    }

    public void verifyErrorCodeInboxVisit(String errorCode, JSONObject jsonobject) throws InterruptedException, SQLException, ClassNotFoundException {
        Thread.sleep(10000);
        Map<String, String> dbMap = dataBaseVerifier.executeQuery
                (String.format(Constant_SQL.inboxVisitAltEvvGeneric_Connecticut, jsonobject.get("VisitOtherID").toString(),
                        jsonobject.get("SequenceID").toString()));
        Assert.assertEquals(dbMap.get("ERROR_CODE"), errorCode);
    }

    public void verifyExistingDataIn_STX_App_User(String username) throws InterruptedException, SQLException,
            ClassNotFoundException {
        dataBaseVerifier.executeQuery(String.format(Constant_SQL.stxAppUsers,
                stateInfo.get(ACCID), username));
    }

    public void verifyNotExistingDataIn_STX_MVV_User(String username) throws InterruptedException, SQLException,
            ClassNotFoundException {
        Assert.assertNull(dataBaseVerifier.executeQueryString(String.format(Constant_SQL.stxMVVUsersREG,
                stateInfo.get(ACCID), username)));
    }

    public void verifyExistingDataIn_STX_MVV_User(String username) throws InterruptedException, SQLException,
            ClassNotFoundException {
        Assert.assertNotNull(dataBaseVerifier.executeQueryString(String.format(Constant_SQL.stxMVVUsersREG,
                stateInfo.get(ACCID), username)));
    }

    public void claim_assertion_DLN_ICN(String DLN, String ICN, String isVisitFound) throws SQLException, InterruptedException, ClassNotFoundException {

        logger.log(LogStatus.INFO, "Validating claims info is stored in DB");
        String visitFoundIdentifier = dataBaseVerifier.executeQueryString(String.format(Constant_SQL.ioData, DLN, ICN));

        System.out.println(visitFoundIdentifier);
        assertEquals(visitFoundIdentifier, isVisitFound);


    }


}