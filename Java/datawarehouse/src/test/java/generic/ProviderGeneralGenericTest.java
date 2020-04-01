package generic;

import com.sandata.core.report.ExtentTestManager;
import com.sandata.models.dwh.ohio.DwhExtract;
import com.sandata.models.molina.employee.EmployeeDisciplineModel;
import com.sandata.models.molina.visit.VisitGeneralModel;
import com.sandata.models.provider.ProviderAccountModel;
import com.sandata.models.provider.ProviderGeneralModel;
import com.sandata.models.provider.ProviderLocModel;
import com.sandata.utilities.DbUtilsCon;
import com.sandata.ws.ProviderWebService;
import org.testng.Assert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.interop.sql.ProviderSQL.SQL_GET_PROVIDER_BY_PROVIDER_ID;
import static com.interop.sql.ProviderSQL.SQL_GET_PROVIDER_GENERAL_BY_PROVIDER_ID;
import static com.interop.sql.Sql.*;
public class ProviderGeneralGenericTest extends V8VisitGenericTest{

    public ProviderWebService providerServices = new ProviderWebService();
    /**
     * Author: Liem.chau (Tony)
     * Des: Map data from database to the model
     * @param providerId: list input of provider item
     * @return The provider General Model list
     */
    public List<ProviderGeneralModel> mapProviderGeneralModel(String providerId) {
        String sql = String.format(SQL_GET_PROVIDER_GENERAL, providerId);
        return mapDBTableToModel(sql, ProviderGeneralModel.class);
    }

    public List<ProviderGeneralModel> mapProviderGeneralModelBy(String providerId, String account) {
        String sql = String.format(SQL_GET_PROVIDER_GENERAL_BY_PROVIDER_ID, account, providerId);
        return mapDBTableToModel(sql, ProviderGeneralModel.class);
    }

    public String getTheAccountFromDb(String providerId){
        return String.format(SQL_GET_ACCOUNT, providerId);
    }

    public String getTheDataProviderLoc(String payerId, String providerId)
    {
        String sql = String.format(SQL_GET_PROVIDER_GENERAL_FOR_MOLINA,providerId, providerId,payerId);
        return String.format(SQL_GET_PROVIDER_GENERAL_FOR_MOLINA,providerId, providerId,payerId);
    }

    public List<EmployeeDisciplineModel> filterDisciplineBy() {
        return mapDataFileToModel(fileExtension,
                DOWNLOAD_FOLDER + "/" + fileName, EmployeeDisciplineModel.class);
    }

    /**
     * Author: liem.chau (Tony)
     * Des: Get the provider General list model from the file in the input folder
     * @return the provider General model list
     */
    public List<ProviderGeneralModel> filterProviderGeneralBy() {
        return mapDataFileToModel(fileExtension,
                DOWNLOAD_FOLDER + "/" + fileName, ProviderGeneralModel.class);
    }

    public List<ProviderLocModel> filterProviderLocBy(){
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                DOWNLOAD_FOLDER + "/" + fileName, ProviderLocModel.class);
    }

    public List<ProviderLocModel> filterProviderLocBy(String fileExtension){
        return mapDataFileToModel(fileExtension,
                DOWNLOAD_FOLDER + "/" + fileName, ProviderLocModel.class);
    }


    /**
     * Author: liem.chau (Tony)
     * Des: Verify provider General data from export files with data's database
     */
    public void verifyProviderGeneralFileDataMatchWithDatabase() {
        List<ProviderGeneralModel> providerGeneralModelList = mapProviderGeneralModel(providerId);
        boolean result = areProviderGeneralRecordsExistedInDatabase(filterProviderGeneralBy(),providerGeneralModelList);
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "ProviderGeneral file data is not matched with database");
    }

    public void validateProviderGeneralIsGeneratedAsExpectedResults(){
        List<ProviderGeneralModel> providerGeneralFile = filterProviderGeneralBy();
        Assert.assertTrue(providerGeneralFile.size() > 0, "ProviderGeneral file data is not generated");
    }

    public void validateProviderGeneralIsGeneratedAsExpectedFormat(){
        List<ProviderGeneralModel> providerGeneralFile = filterProviderGeneralBy();
        Assert.assertTrue(providerGeneralFile.size() > 0, "ProviderGeneral file data is not generated");
    }

    /**
     * Des: Verify provider General data from export files with data's database based on client name
     */
    public void verifyProviderGeneralGenericFileDataMatchWithDatabase() {
        String providerId = baseObj.getEnvironment("connecticut_providerId");
        String account = baseObj.getEnvironment("connecticut_accountId");
        List<ProviderGeneralModel> providerGeneralModelList = mapProviderGeneralModelBy(providerId, account);
        List<ProviderGeneralModel> providerGeneralFile = filterProviderGeneralBy();
        for(ProviderGeneralModel providerGeneral: providerGeneralModelList) {
            if(providerGeneral.getAddressZip() != null) {
                providerGeneral.setAddressZip(providerGeneral.getAddressZip().replace("-", ""));
            }
        }
        boolean result = areProviderGeneralRecordsExistedInDatabase(providerGeneralFile,providerGeneralModelList);
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "ProviderGeneral file data is not matched with database");
    }

    public void verifyProviderGeneralMaineIsExistedInFile() {
        List<ProviderGeneralModel> providerGeneralFile = filterProviderGeneralBy();
        boolean result = false;
        if(providerGeneralFile.size() != 0)
            result = true;
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records are not existed in file"));
        }
        Assert.assertTrue(result, "Records are existed in file");
    }

    public void VerifyAccountIsMatchWithAccountInExportedFiles(String account){
        ResultSet result =  DbUtilsCon.getResultSetFromQuery(
                DbUtilsCon.createConnection(
                        baseObj.getTestEnvironment().getOracleUrl(),
                        baseObj.getTestEnvironment()), getTheAccountFromDb(providerId));
        String CurrAcc  = "";
        try {
            result.next();
            CurrAcc = result.getString(1);
        }catch (SQLException ex)
        {
            Assert.fail(String.format("Couldn't find the account in exported files, mess failed: %s",ex.getMessage()));
        }
        Assert.assertTrue(CurrAcc.equals(account), "Couldn't find the account in exported files");
    }

    /**
     * Author: liem.chau (Tony)
     * Des: Double check the provider records are existed in export files
     * @param fileRecord the record of provider common get from a export file
     * @param dbRecords the list of provider common get from db
     * @return true if exist and else is false
     */
    public boolean isProviderGeneralRecordExistedInExportFile(ProviderGeneralModel fileRecord,
                                                              List<ProviderGeneralModel> dbRecords) {
        for (ProviderGeneralModel record : dbRecords) {
            String fileDataInfo = fileRecord.toString();
            ExtentTestManager.logTestStep(String.format("fileDataInfo: %s", fileDataInfo));
            String currDataDbInfo = record.toString();
            ExtentTestManager.logTestStep(String.format("currDataDbInfo: %s", currDataDbInfo));
            if(fileDataInfo.equals(currDataDbInfo))
                return true;
        }
        return false;
    }

    /**
     * Author: liem.chau (Tony)
     * Des: Double check all data in db are existed in all data are exported.
     * @param fileRecords the list data from the file
     * @param dbRecords   the list data form db
     * @return true if existing and else is false
     */
    public boolean areProviderGeneralRecordsExistedInDatabase(List<ProviderGeneralModel> fileRecords,
                                                              List<ProviderGeneralModel> dbRecords) {
        boolean result = true;
        for (ProviderGeneralModel currData : dbRecords) {
            if (!isProviderGeneralRecordExistedInExportFile(currData, fileRecords)) {
                result = false;
                ExtentTestManager.logTestStep(String.format("File record not found in db"));
            } else {
                ExtentTestManager.logTestStep(String.format("File record found in db"));
            }
        }
        return result;
    }

    /**
     * Author: liem.chau
     * Des: Verify the time zone name should be look like time zone name input
     */
    public void verifyTimeZoneShouldAlwaysBeDefault()
    {
        boolean result = true;
        String timeZoneName = baseObj.readDataValue("TimeZoneName");
        List<ProviderGeneralModel> fileRecords = filterProviderGeneralBy();
        for(ProviderGeneralModel timeZoneCol: fileRecords){
            if(timeZoneCol.getProviderTimeZone().equals(timeZoneName)) {
                ExtentTestManager.logPass("The time zone name as expected result");
            } else {
                result = false;
                ExtentTestManager.logFailure(String.format("The time zone name should be %s", timeZoneName));
            }
        }
        Assert.assertTrue(result, "TimeZone is not as default");
    }

    /**
     * Author: Liem.chau
     * Des: Verify the header is not display as expected result for Molina
     */
    public void verifyNoHeaderRowInExportFiles()
    {
        boolean result = true;
        List<ProviderGeneralModel> fileRecords =filterProviderGeneralBy();
        ProviderGeneralModel firstRec = fileRecords.get(0);
        if(firstRec.getProviderName().contains("ProviderQualifier") || firstRec.getProviderID().contains("ProviderID")) {
            ExtentTestManager.logFailure(String.format("Header should not be displayed in export for Molina"));
        } else {
            result = false;
            ExtentTestManager.logPass("Header is not visible as expected result for Molina.");
        }
        Assert.assertTrue(!result, "NoHeaderRowInExportFiles:" + result);
    }

    private static String readLineByLineJava8(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    /**
     * Author: @liem.chau
     * Execute a api create a
     */
    public String CallProviderByApi()
    {
        String accountType = baseObj.readDataValue("AccountType");

        //TODO: if you want to change, will update these fields
        /*
        String providerQualifier = baseObj.readDataValue("ProviderQualifier");
        String providerId = baseObj.readDataValue("ProviderID");
        String providerName = baseObj.readDataValue("ProviderName");

        ProviderMolinaWithConfigurationModel employeeMolinaWithConfigurationModel = new ProviderMolinaWithConfigurationModel();
        employeeMolinaWithConfigurationModel.setProviderQualifier(providerQualifier);
        employeeMolinaWithConfigurationModel.setProviderID(providerId);
        employeeMolinaWithConfigurationModel.setProviderName(providerName);
        */

        String username = baseObj.readDataValue("Username28005");
        String password = baseObj.readDataValue("Password28005");
        String account = baseObj.readDataValue("Account28005");

        //TODO: If you want to update fields, provider_input will be replace by  employeeMolinaWithConfigurationModel
        return providerServices.callCreateProvider(accountType, username,
                password, account, null,
                baseObj.getTestEnvironment());
    }

    public List<ProviderAccountModel> mapProviderAccountModel(String providerId) {
        String sql = String.format(SQL_GET_PROVIDER_BY_PROVIDER_ID, providerId);
        return mapDataTableToModel(sql, ProviderAccountModel.class);
    }

    public boolean IsProviderIsCreatedInDbByProviderID() {
        String providerID = baseObj.readDataValue("ProviderID");
        List<ProviderAccountModel> providerAccountModelList = mapProviderAccountModel(providerID);
        if(providerAccountModelList.size() > 0) {
            return true;
        }
        return false;
    }

    public void VerifyProviderLocMatchOnDb()
    {
        ResultSet result =  DbUtilsCon.getResultSetFromQuery(
                DbUtilsCon.createConnection(
                        baseObj.getTestEnvironment().getOracleUrl(),
                        baseObj.getTestEnvironment()), getTheDataProviderLoc(baseObj.readDataValue("FilePrefix"),providerId));

        List<ProviderLocModel> providerLocModelList =  filterProviderLocBy();

        try {
            int i = 0;
            while(result.next())
            {
                ProviderLocModel currProviderLoc = providerLocModelList.get(i);
                Assert.assertTrue(currProviderLoc.getPayerID().equals((result.getString(1)==null)?"":result.getString(1)),"PayorId is not match");
                Assert.assertTrue(currProviderLoc.getProviderID().equals((result.getString(2)==null)?"":result.getString(2)),"Provider is not match");
                Assert.assertTrue(currProviderLoc.getLocationName().equals(result.getString(3).substring(0,20)),"Location name is not match");
                Assert.assertTrue(currProviderLoc.getLocationIdentifier().equals(result.getString(4)),"Location Identifier is not match");
                Assert.assertTrue(currProviderLoc.getLocationAddressLine1().equals((result.getString(5)==null)?"":result.getString(5)),"LocationAddressLine1 is not match");
                Assert.assertTrue(currProviderLoc.getLocationAddressLine2().equals((result.getString(6)==null)?"":result.getString(6)),"LocationAddressLine1 is not match");
                Assert.assertTrue(currProviderLoc.getLocationCity().equals((result.getString(7)==null)?"":result.getString(7)),"LocationCity is not match");
                Assert.assertTrue(currProviderLoc.getLocationState().equals((result.getString(8)==null)?"":result.getString(8)),"LocationState is not match");
                Assert.assertTrue(currProviderLoc.getLocationZip().equals((result.getString(9)==null)?"":result.getString(9)),"LocationZip is not match");
                Assert.assertTrue(currProviderLoc.getLocationContactLastName().equals((result.getString(10)==null)?"":result.getString(10)),"LocationContactLastName is not match");
                Assert.assertTrue(currProviderLoc.getLocationContactFirstName().equals((result.getString(11)==null)?"":result.getString(11)),"LocationContactFirstName is not match");
                Assert.assertTrue(currProviderLoc.getLocationPhone().equals((result.getString(12)==null)?"":result.getString(12)),"LocationPhone is not match");
            }

        }catch (SQLException ex)
        {
            Assert.fail(String.format("Couldn't find the provider loc in exported files, mess failed: %s",ex.getMessage()));
        }
    }

    public void VerifyProviderLocMatchOnDbBy(String providerId, String payerId)
    {
        ResultSet result =  DbUtilsCon.getResultSetFromQuery(
                DbUtilsCon.createConnection(
                        baseObj.getTestEnvironment().getOracleUrl(),
                        baseObj.getTestEnvironment()), getTheDataProviderLoc(payerId,providerId));

        List<ProviderLocModel> providerLocModelList = filterProviderLocBy(fileExtension)
                .stream()
                .filter(providerLocModel
                        -> providerLocModel.getPayerID().equalsIgnoreCase(payerId))
                .collect(Collectors.toList());

        try {
            int i = 0;
            while(result.next())
            {
                ProviderLocModel currProviderLoc = providerLocModelList.get(i);
                Assert.assertTrue(currProviderLoc.getPayerID().equals((result.getString(1)==null)?"":result.getString(1)),"PayorId is not match");
                Assert.assertTrue(currProviderLoc.getProviderID().equals((result.getString(2)==null)?"":result.getString(2)),"Provider is not match");
                Assert.assertTrue(currProviderLoc.getLocationName().equals(result.getString(3).substring(0,20)),"Location name is not match");
                Assert.assertTrue(currProviderLoc.getLocationIdentifier().equals(result.getString(4)),"Location Identifier is not match");
                Assert.assertTrue(currProviderLoc.getLocationAddressLine1().equals((result.getString(5)==null)?"":result.getString(5)),"LocationAddressLine1 is not match");
                Assert.assertTrue(currProviderLoc.getLocationAddressLine2().equals((result.getString(6)==null)?"":result.getString(6)),"LocationAddressLine1 is not match");
                Assert.assertTrue(currProviderLoc.getLocationCity().equals((result.getString(7)==null)?"":result.getString(7)),"LocationCity is not match");
                Assert.assertTrue(currProviderLoc.getLocationState().equals((result.getString(8)==null)?"":result.getString(8)),"LocationState is not match");
                Assert.assertTrue(currProviderLoc.getLocationZip().equals((result.getString(9)==null)?"":result.getString(9)),"LocationZip is not match");
                Assert.assertTrue(currProviderLoc.getLocationContactLastName().equals((result.getString(10)==null)?"":result.getString(10)),"LocationContactLastName is not match");
                Assert.assertTrue(currProviderLoc.getLocationContactFirstName().equals((result.getString(11)==null)?"":result.getString(11)),"LocationContactFirstName is not match");
                Assert.assertTrue(currProviderLoc.getLocationPhone().equals((result.getString(12)==null)?"":result.getString(12)),"LocationPhone is not match");
            }

        }catch (SQLException ex)
        {
            Assert.fail(String.format("Couldn't find the provider loc in exported files, mess failed: %s",ex.getMessage()));
        }
    }

    public boolean isProviderIdExistedInProviderLOC(String payerId, String providerId) {
        List<ProviderLocModel> providerLocModelList = filterProviderLocBy(fileExtension)
                .stream()
                .filter(providerLocModel
                        -> providerLocModel.getPayerID().equalsIgnoreCase(payerId))
                .collect(Collectors.toList());
        if(providerLocModelList.size() != 0) {
            return true;
        }
        return false;
    }

    public void verifyProviderIdExistedInProviderLOC(String providerId, String payerId) {
        boolean result = isProviderIdExistedInProviderLOC(payerId, providerId);
        if(result) {
            ExtentTestManager.logPass("Provider is existed in PROVIDER_LOC");
        } else {
            ExtentTestManager.logFailure("Provider is NOT existed in PROVIDER_LOC");
        }
        Assert.assertTrue(result, String.format("Provider %s and payerId %s " +
                "is NOT existed in PROVIDER_LOC", providerId, payerId));
    }

    public void VerifyOnlyPayerIdIsDisplayedInProviderLOC(ArrayList<String> payerIdInVisitGeneralFile,
                                                          ArrayList<String> payerIdInProviderLOCFile){
////        List<ProviderLocModel> providerLocModelList = filterProviderLocBy(fileExtension);
//        boolean result = false;
//        if(providerLocModelList.size() == 1) {
//            if(providerLocModelList.get(0).getPayerID().equals(payerId))
//            {
//                result = true;
//                ExtentTestManager.logPass(String.format("Only PayerId %s is existed in PROVIDER_LOC", payerId));
//            }
//        }
//        Assert.assertTrue(result, String.format("Not only PayerId %s " +
//                "is NOT existed in PROVIDER_LOC", payerId));

        ExtentTestManager.logTestStep(String.format("payerIdInVisitGeneralFile: %s", payerIdInVisitGeneralFile));
        ExtentTestManager.logTestStep(String.format("payerIdInProviderLOCFile: %s", payerIdInProviderLOCFile));

        boolean result = false;
        if(payerIdInVisitGeneralFile.equals(payerIdInProviderLOCFile)
                && payerIdInVisitGeneralFile.size() == payerIdInProviderLOCFile.size()) {
            result = true;
            ExtentTestManager.logPass("ProviderLOC contains only payers in visit files");
        }else {
            ExtentTestManager.logFailure("ProviderLOC contains other payers in visit files");
        }

        Assert.assertTrue(result, "ProviderLOC contains other payers in visit files");
    }

    public List<VisitGeneralModel> filterVisitGeneralBy(String fileExtension){
        return mapDataFileToModel(fileExtension,
                DOWNLOAD_FOLDER + "/" + fileName, VisitGeneralModel.class);
    }

    public ArrayList<String> getPayerIdInVisitGeneralFile() {
        List<VisitGeneralModel> visitGeneralModels = filterVisitGeneralBy(fileExtension);
        ArrayList<String> payerList = new ArrayList<>();
        for(VisitGeneralModel visitGeneralModel : visitGeneralModels) {
            if(!visitGeneralModel.getPayerID().trim().equals("") && visitGeneralModel.getPayerID() != null
                    && !visitGeneralModel.getPayerID().equals("999")) {
                if(!payerList.contains(visitGeneralModel.getPayerID()))
                    payerList.add(visitGeneralModel.getPayerID());
            }
        }
        Collections.sort(payerList);
        return payerList;
    }

    public ArrayList<String> getPayerIdInProviderLOCFile() {
        List<ProviderLocModel> providerLocModels = filterProviderLocBy(fileExtension);
        ArrayList<String> payerList = new ArrayList<>();
        for(ProviderLocModel providerLocModel : providerLocModels) {
            payerList.add(providerLocModel.getPayerID());
        }
        Collections.sort(payerList);
        return payerList;
    }

    public void validateOhioProviderHeaderFromJsonData()  {
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        String providerID =  exportedFile.getProviderID();
        String businessEntityID = exportedFile.getBusinessEntityID();
        String providerName = exportedFile.getProviderName();
        Assert.assertTrue(providerID != null && businessEntityID != null && providerName != null, "Staff Header is not expected result");
    }
}
