package generic;

import com.sandata.common.Constant;
import com.sandata.core.report.ExtentTestManager;
import com.sandata.entity.connecticut.authorization.AuthorizationEntity;
import com.sandata.models.molina.client.*;
import com.sandata.utilities.DbUtilsCon;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.interop.common.constants.FieldConstants.CLIENT_DESIGNEE_LAST_NAME;
import static com.interop.sql.ClientSQL.SQL_GET_CLIENT_AUTH;
import static com.interop.sql.ClientSQL.SQL_GET_CLIENT_SCHEDULE;
import static com.interop.sql.Sql.*;
import static com.sandata.common.Constant.*;

public class ClientV8GenericTest extends V8VisitGenericTest {

    public String getClientPayerIdBy(String clientKey) {
        String sql = String.format(SQL_GET_CLIENT_PAYER_ID, clientKey);
        Object payerId = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("CLIENTPAYERID");
        return String.valueOf(payerId);
    }

    public List<ClientGeneralModel> mapClientGeneralTableToModel(String clientFName, String clientLName, String account) {
        String sql;
        if(!baseObj.readDataValue("AccountType").equals(MOLINA))
            sql = String.format(SQL_GET_CLIENT_GENERAL, account, clientFName, clientLName);
        else sql = String.format(SQL_GET_CLIENT_GENERAL_MOLINA, account, clientFName, clientLName);
        return mapDataTableToModel(sql, ClientGeneralModel.class);
    }

    public List<ClientGeneralModel> filterClientGeneralBy(String clientId) {
        return mapDataFileToModel(fileExtension, DOWNLOAD_FOLDER + "/" + fileName, ClientGeneralModel.class)
                .stream().filter(clientGeneral -> clientGeneral.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public boolean isClientGeneralRecordExistedInExportFile(ClientGeneralModel fileRecord,
                                                            List<ClientGeneralModel> dbRecords) {
        for (ClientGeneralModel record : dbRecords) {
            String fileDataInfo = fileRecord.toString();
            String currDataDbInfo = record.toString();
            System.out.println("fileDataInfo " + fileDataInfo);
            System.out.println("currDataDbInfo " + currDataDbInfo);

            if(fileDataInfo.equals(currDataDbInfo))
                return true;
        }
        return false;
    }

    public boolean areClientGeneralRecordsExistedInDatabase(List<ClientGeneralModel> fileRecords,
                                                            List<ClientGeneralModel> dbRecords) {
        boolean result = true;
        for (ClientGeneralModel currData : dbRecords) {
            if (!isClientGeneralRecordExistedInExportFile(currData, fileRecords)) {
                result = false;
                ExtentTestManager.logTestStep(String.format("File record not found in db"));
            } else {
                ExtentTestManager.logTestStep(String.format("File record found in db"));
            }
        }
        return result;
    }

    public void verifyClientGeneralFileDataMatchWithDatabase(String clientFName, String clientLName) {
        String clientFirstName;
        String clientLastName;
        if(clientFName != null || !clientFName.isEmpty()){
            clientFirstName = clientFName;
            clientLastName = clientLName;
        } else {
            clientFirstName = baseObj.readDataValue("Client_FirstName");
            clientLastName = baseObj.readDataValue("Client_LastName");
        }
        String clientId = getClientId(clientFirstName, clientLastName);

        if(baseObj.readDataValue("AccountType").equals(MOLINA)){
            verifyClientGeneralMolinaFileDataMatchWithDatabase(clientId, clientFirstName, clientLastName);
        }else {
            verifyClientGeneralGenericFileDataMatchWithDatabase(clientId, clientFirstName, clientLastName);
        }
    }

    public String getClientId(String clientFName, String clientLName) {
        return getClientIdBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName);
    }

    public void verifyClientGeneralMolinaFileDataMatchWithDatabase(String clientId, String clientFName, String clientLName) {
        List<ClientGeneralModel> exportResult = filterClientGeneralBy(clientId);
        exportResult.sort(Comparator.comparing(ClientGeneralModel::getPayerID));

        List<ClientGeneralModel> dbResult = mapClientGeneralTableToModel(
                clientFName,
                clientLName,
                baseObj.readDataValue("AccountId"));

        List<ClientGeneralModel> dbResult1 = new ArrayList<>();
        dbResult1.add(dbResult.get(0));
        dbResult1.get(0).setPayerID(baseObj.readDataValue("FilePrefix"));

        boolean result = areClientGeneralRecordsExistedInDatabase(exportResult,dbResult1);
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "Client common records are not existed in database");
    }

    public void verifyClientGeneralGenericFileDataMatchWithDatabase(String clientId, String clientFName, String clientLName) {
        List<ClientGeneralModel> exportResult = filterClientGeneralBy(clientId);

        List<ClientGeneralModel> dbResult = mapClientGeneralTableToModel(
                clientFName,
                clientLName,
                baseObj.readDataValue("AccountId"));

        String clientKey = getClientKeyBy(clientId);
        String payerId = getClientPayerIdBy(clientKey);
        for(ClientGeneralModel clientGeneral : dbResult){
            clientGeneral.setClientPayerID(payerId);
        }

        String clientDesigneeFName = baseObj.readDataValue("ClientDesigneeFirstName");
        String clientDesigneeLName = baseObj.readDataValue(CLIENT_DESIGNEE_LAST_NAME);
        String clientDesigneeEmail = baseObj.readDataValue("ClientDesigneeEmail");
        String clientDesigneeStatus = baseObj.readDataValue("ClientDesigneeStatus");
        Assert.assertEquals(exportResult.get(0).getClientDesigneeFirstName(), clientDesigneeFName);
        Assert.assertEquals(exportResult.get(0).getClientDesigneeLastName(), clientDesigneeLName);
        Assert.assertEquals(exportResult.get(0).getClientDesigneeEmail(), clientDesigneeEmail);
        Assert.assertEquals(exportResult.get(0).getClientDesigneeStatus(), clientDesigneeStatus);

        boolean result = areClientGeneralExistedInDb(exportResult,dbResult);
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "Client General Generic File Data is not matched with database");
    }

    public boolean areClientGeneralExistedInDb(List<ClientGeneralModel> clientGeneralFile, List<ClientGeneralModel> clientGeneralDb) {
        for(ClientGeneralModel clientGeneral : clientGeneralFile) {
            if(!isClientGeneralRecordExistedInExportFile(clientGeneral, clientGeneralDb))
                return false;
        }
        return true;
    }

    //-------------------------- CLIENT_ADDR ------------------------------------
    public List<ClientAddressModel> mapClientAddressTableToModel(String clientFName, String clientLName, String account) {
        String sql = String.format(SQL_GET_CLIENT_ADDRESS, account, clientFName, clientLName,
                account, clientFName, clientLName);
        return mapDataTableToModel(sql, ClientAddressModel.class);
    }

    public List<ClientAddressModel> filterClientAddressBy(String clientId) {
        return mapDataFileToModel(fileExtension, Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientAddressModel.class)
                .stream().filter(clientAddress -> clientAddress.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public void verifyClientAddressFileDataMatchWithDatabase(String clientFName, String clientLName) {
        String clientFirstName;
        String clientLastName;
        if(clientFName != null && !clientFName.isEmpty()) {
            clientFirstName = clientFName;
            clientLastName = clientLName;
        }else {
            clientFirstName =  baseObj.readDataValue("Client_FirstName");
            clientLastName = baseObj.readDataValue("Client_LastName");
        }
        String clientId = getClientId(clientFirstName, clientLastName);

        if(baseObj.readDataValue("AccountType").equalsIgnoreCase(CONNECTICUT)) {
            verifyClientAddressOhioFileDataMatchWithDatabase(clientId, clientFirstName, clientLastName);
        }
        if(baseObj.readDataValue("AccountType").equalsIgnoreCase(MOLINA)) {
            verifyClientAddressMolinaFileDataMatchWithDatabase(clientId, clientFirstName, clientLastName);
        }
    }

    public void verifyClientAddressOhioFileDataMatchWithDatabase(String clientId, String clientFName, String clientLName) {
        List<ClientAddressModel> exportResult = filterClientAddressBy(clientId);
        exportResult.sort(Comparator.comparing(ClientAddressModel::getClientZip));

        List<ClientAddressModel> dbResult = mapClientAddressTableToModel(
                clientFName,
                clientLName,
                baseObj.readDataValue("AccountId"));

        List<ClientAddressModel> dbResultBk = new ArrayList<>();
        for(ClientAddressModel db : dbResult) {
            if(db.getClientAddressType() != null) {
                dbResultBk.add(db);
                if(dbResultBk.get(dbResultBk.size()-1).getClientZip().contains("-"))
                    dbResultBk.get(dbResultBk.size()-1).setClientZip(dbResultBk.get(dbResultBk.size()-1)
                            .getClientZip().replace("-", ""));
            }
        }
        dbResultBk.sort(Comparator.comparing(ClientAddressModel::getClientZip));

        boolean result = areRecordsExistedInDatabase(exportResult, dbResultBk);

        if (result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }

        Assert.assertTrue(result, String.format("areRecordsExistedInDatabase: %s", result));
    }

    public void verifyClientAddressMolinaFileDataMatchWithDatabase(String clientId, String clientFirstName, String clientLastName) {
        List<ClientAddressModel> exportResult = filterClientAddressBy(clientId);
        exportResult.sort(Comparator.comparing(ClientAddressModel::getClientZip));

        List<ClientAddressModel> dbResult = mapClientAddressTableToModel(
                clientFirstName,
                clientLastName,
                baseObj.readDataValue("AccountId"));

        String payerId = baseObj.readDataValue("FilePrefix");
        boolean payerResult = exportResult.get(0).getPayerID().equals(payerId);
        if(payerResult) {
            ExtentTestManager.logPass("PayerID is correct");
        } else {
            ExtentTestManager.logFailure(String.format("PayerID is incorrect"));
        }
        dbResult.remove(0);
        dbResult.get(0).setPayerID(payerId);

        boolean result = areRecordsExistedInDatabase(exportResult, dbResult);

        if (result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
    }

    public List<ClientPhoneModel> mapClientPhoneTableToModel(String clientFName, String clientLName, String account) {
        String sql = String.format(SQL_GET_CLIENT_PHONE, clientFName, clientLName, account);
        return mapDataTableToModel(sql, ClientPhoneModel.class);
    }

    public List<ClientPhoneModel> filterClientPhoneBy(String clientId) {
        return mapDataFileToModel(fileExtension, Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientPhoneModel.class)
                .stream().filter(clientPhone -> clientPhone.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public void verifyClientPhoneFileDataMatchWithDatabase(String clientFName, String clientLName) {
        String clientFirstName;
        String clientLastName;
        if(clientFName != null && !clientFName.isEmpty()){
            clientFirstName = clientFName;
            clientLastName = clientLName;
        } else {
            clientFirstName = baseObj.readDataValue("Client_FirstName");
            clientLastName = baseObj.readDataValue("Client_LastName");
        }
        String clientId = getClientIdBy(
                baseObj.readDataValue("AccountId"),
                clientFirstName,
                clientLastName);

        List<ClientPhoneModel> dbResults = mapClientPhoneTableToModel(clientFirstName,
                clientLastName,
                baseObj.readDataValue("AccountId"));

        if(baseObj.readDataValue("Extension").equalsIgnoreCase(".txt")
                || baseObj.readDataValue("Extension").equalsIgnoreCase("txt")) {
            for(ClientPhoneModel db:dbResults)
                db.setPayerID(baseObj.readDataValue("FilePrefix"));
        }

        boolean result =
                areClientPhoneRecordsExistedInDatabase(
                        filterClientPhoneBy(clientId),
                        dbResults);

        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }

        List<ClientPhoneModel> exportResult = filterClientPhoneBy(clientId);
        if(baseObj.readDataValue("Extension").equalsIgnoreCase(".txt")
                || baseObj.readDataValue("Extension").equalsIgnoreCase("txt")) {
            String payerId = baseObj.readDataValue("FilePrefix");
            boolean payerResult = exportResult.get(0).getPayerID().equals(payerId);
            if (payerResult) {
                ExtentTestManager.logPass("PayerID is correct");
            } else {
                ExtentTestManager.logFailure(String.format("PayerID is incorrect"));
            }
        }
    }

    public boolean isClientPhoneRecordExistedInExportFile(ClientPhoneModel fileRecord,
                                                          List<ClientPhoneModel> dbRecords) {
        for (ClientPhoneModel record : dbRecords) {
            String fileDataInfo = fileRecord.toString();
            String currDataDbInfo = record.toString();
            System.out.println("fileDataInfo " + fileDataInfo);
            System.out.println("currDataDbInfo " + currDataDbInfo);

            if(fileDataInfo.equals(currDataDbInfo))
                return true;
        }
        return false;
    }

    public boolean areClientPhoneRecordsExistedInDatabase(List<ClientPhoneModel> fileRecords,
                                                          List<ClientPhoneModel> dbRecords) {
        boolean result = true;
        for (ClientPhoneModel currData : fileRecords) {
            if (!isClientPhoneRecordExistedInExportFile(currData, dbRecords)) {
                result = false;
                ExtentTestManager.logTestStep(String.format("File record not found in db"));
            } else {
                ExtentTestManager.logTestStep(String.format("File record found in db"));
            }
        }
        return result;
    }

    public List<ClientSchedule> mapClientScheduleTableToModel(String clientFName, String clientLName, String account) {
        String sql = String.format(SQL_GET_CLIENT_SCHEDULE, account, clientFName, clientLName);
        return mapDBTableToModel(sql, ClientSchedule.class);
    }

    public List<ClientSchedule> filterClientScheduleBy(String clientId) {
        return mapDataFileToModel(fileExtension, Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientSchedule.class)
                .stream().filter(clientSchedule -> clientSchedule.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public List<ClientEligibilityModel> filterClientEligibilityBy(String clientId) {
        return mapDataFileToModel(fileExtension, Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientEligibilityModel.class)
                .stream().filter(clientElig -> clientElig.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public String getClientId(String accountId, String clientFName, String clientLName) {
        return getClientIdBy(
                accountId,
                clientFName,
                clientLName);
    }

    public boolean isClientScheduleExistedInDb(ClientSchedule clientScheduleFile, List<ClientSchedule> clientScheduleDb) {
        for(ClientSchedule clientSchedule : clientScheduleDb) {
            String fileDataInfo = clientScheduleFile.toString();
            ExtentTestManager.logTestStep("fileDataInfo " + fileDataInfo);
            String currDataDbInfo = clientSchedule.toString();
            ExtentTestManager.logTestStep("currDataDbInfo " + currDataDbInfo);

            if(fileDataInfo.equals(currDataDbInfo))
                return true;
        }
        return false;
    }

    public boolean areClientScheduleExistedInDb(List<ClientSchedule> clientScheduleFile, List<ClientSchedule> clientScheduleDb) {
        for(ClientSchedule clientSchedule : clientScheduleFile) {
            if(!isClientScheduleExistedInDb(clientSchedule, clientScheduleDb))
                return false;
        }
        return true;
    }

    public void verifyClientScheduleFileDataMatchWithDatabase(String clientFName, String clientLName) {
        String accountId = baseObj.readDataValue("AccountId");
        String clientId = getClientId(accountId, clientFName, clientLName);
        Assert.assertNotNull(clientId, "Client Id is not displayed in exported file");

        List<ClientSchedule> exportResult = filterClientScheduleBy(clientId);

        List<ClientSchedule> dbResult = mapClientScheduleTableToModel(
                clientFName,
                clientLName,
                baseObj.readDataValue("AccountId"));

        boolean result = areClientScheduleExistedInDb(exportResult, dbResult);

        if (result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "Records in file are not matched with database");
    }

    public List<ClientAuthModel> mapClientAuthTableToModel(String clientFName, String clientLName, String account) {
        String sql = String.format(SQL_GET_CLIENT_AUTH, account, clientFName, clientLName);
        return mapDataTableToModel(sql, ClientAuthModel.class);
    }

    public List<ClientAuthModel> filterClientAuthBy(String clientId) {
        return mapDataFileToModel(fileExtension, Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientAuthModel.class)
                .stream().filter(clientAuth -> clientAuth.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public List<ClientAuthModel> filterClientAuthBy(String clientId, String payerId) {
        return mapDataFileToModel(fileExtension, Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientAuthModel.class)
                .stream().filter(clientAuth -> clientAuth.getClientID().equalsIgnoreCase(clientId)).filter(clientAuth -> clientAuth.getPayerID().equalsIgnoreCase(payerId)).collect(Collectors.toList());
    }

    public void verifyClientAuthFileDataMatchWithDatabase(String clientFName, String clientLName) {
        String accountId = baseObj.readDataValue("AccountId");
        String clientId = getClientId(accountId, clientFName, clientLName);
        Assert.assertNotNull(clientId, "Client Id is not displayed in exported file");

        List<ClientAuthModel> exportResult = filterClientAuthBy(clientId);

        List<ClientAuthModel> dbResult = mapClientAuthTableToModel(
                clientFName,
                clientLName,
                baseObj.readDataValue("AccountId"));

        boolean result = areClientAuthExistedInDb(exportResult, dbResult);

        if (result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "Records in file are not matched with database");
        Assert.assertEquals(exportResult.get(0).getClientStatus(), "04");
    }

    public boolean isClientAuthExistedInDb(ClientAuthModel clientScheduleFile, List<ClientAuthModel> clientScheduleDb) {
        for(ClientAuthModel clientSchedule : clientScheduleDb) {
            String fileDataInfo = clientScheduleFile.toString();
            ExtentTestManager.logTestStep("fileDataInfo " + fileDataInfo);
            String currDataDbInfo = clientSchedule.toString();
            ExtentTestManager.logTestStep("currDataDbInfo " + currDataDbInfo);

            if(fileDataInfo.equals(currDataDbInfo))
                return true;
        }
        return false;
    }

    public boolean areClientAuthExistedInDb(List<ClientAuthModel> clientScheduleFile, List<ClientAuthModel> clientScheduleDb) {
        for (ClientAuthModel clientSchedule : clientScheduleFile) {
            if (!isClientAuthExistedInDb(clientSchedule, clientScheduleDb))
                return false;
        }
        return true;
    }

    public List<ClientProgMolinaModel> filterClientProgMolinaBy(String clientId) {
        return mapDataFileToModel(fileExtension, Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientProgMolinaModel.class)
                .stream().filter(clientPhone -> clientPhone.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public List<ClientDiagnosisModel> filterClientDiagnosisBy(String clientId) {
        return mapDataFileToModel(fileExtension, Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientDiagnosisModel.class)
                .stream().filter(clientElig -> clientElig.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public boolean isClientExitedInClientProgFile(String accountId, String clientFName, String clientLName) {
        String clientId = getClientId(accountId, clientFName, clientLName);
        ExtentTestManager.logTestStep(String.format("Client Id is %s", clientId));
        List<ClientProgMolinaModel> clientGeneralModelList = filterClientProgMolinaBy(clientId);
        if(clientGeneralModelList.size() != 0)
            return true;
        return false;
    }

    public void VerifyClientIdIsExistedInClientProg(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientProgFile(accountId, clientFName, clientLName);
        if(result) {
            ExtentTestManager.logPass("Client Id is existed in Client Prog file");
        } else {
            ExtentTestManager.logFailure("Client Id should be existed in Client Prog file");
        }
        Assert.assertTrue(result, "Client Id should be existed in Client Prog file");
    }

    public void VerifyClientIdIsNotExistedInClientProg(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientProgFile(accountId, clientFName, clientLName);
        if(!result) {
            ExtentTestManager.logPass("Client Id is NOT existed in Client Prog file");
        } else {
            ExtentTestManager.logFailure("Client Id should NOT existed in Client Prog file");
        }
        Assert.assertFalse(result, "Client Id should NOT existed in Client Prog file");
    }

    public boolean isClientExitedInClientGeneralFile(String accountId, String clientFName, String clientLName) {
        String clientId = getClientId(accountId, clientFName, clientLName);
        ExtentTestManager.logTestStep(String.format("Client Id is %s", clientId));
        List<ClientGeneralModel> clientGeneralModelList = filterClientGeneralBy(clientId);
        if(clientGeneralModelList.size() != 0)
            return true;
        return false;
    }

    public void VerifyClientIdIsExistedInClientGeneral(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientGeneralFile(accountId, clientFName, clientLName);
        if(result) {
            ExtentTestManager.logPass("Client Id is existed in Client General file");
        } else {
            ExtentTestManager.logFailure("Client Id should be existed in Client General file");
        }
        Assert.assertTrue(result, "Client Id should be existed in Client General file");
    }

    public void VerifyClientIdIsNotExistedInClientGeneral(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientGeneralFile(accountId, clientFName, clientLName);
        if(!result) {
            ExtentTestManager.logPass("Client Id is NOT existed in Client General file");
        } else {
            ExtentTestManager.logFailure("Client Id should NOT existed in Client General file");
        }
        Assert.assertFalse(result, "Client Id should NOT existed in Client General file");
    }

    public boolean isClientExitedInClientPhoneFile(String accountId, String clientFName, String clientLName) {
        String clientId = getClientId(accountId, clientFName, clientLName);
        ExtentTestManager.logTestStep(String.format("Client Id is %s", clientId));
        List<ClientPhoneModel> clientPhoneModelList = filterClientPhoneBy(clientId);
        if(clientPhoneModelList.size() != 0)
            return true;
        return false;
    }

    public void VerifyClientIdIsExistedInClientPhone(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientPhoneFile(accountId, clientFName, clientLName);
        if(result) {
            ExtentTestManager.logPass("Client Id is existed in Client Phone file");
        } else {
            ExtentTestManager.logFailure("Client Id should be existed in Client Phone file");
        }
        Assert.assertTrue(result, "Client Id should be existed in Client Phone file");
    }

    public void VerifyClientIdIsNotExistedInClientPhone(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientPhoneFile(accountId, clientFName, clientLName);
        if(!result) {
            ExtentTestManager.logPass("Client Id is NOT existed in Client Phone file");
        } else {
            ExtentTestManager.logFailure("Client Id should NOT existed in Client Phone file");
        }
        Assert.assertFalse(result, "Client Id should NOT existed in Client Phone file");
    }

    public boolean isClientExitedInClientAddressFile(String accountId, String clientFName, String clientLName) {
        String clientId = getClientId(accountId, clientFName, clientLName);
        ExtentTestManager.logTestStep(String.format("Client Id is %s", clientId));
        List<ClientAddressModel> clientAddressModelList = filterClientAddressBy(clientId);
        if(clientAddressModelList.size() != 0)
            return true;
        return false;
    }

    public void VerifyClientIdIsExistedInClientAddress(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientAddressFile(accountId, clientFName, clientLName);
        if(result) {
            ExtentTestManager.logPass("Client Id is existed in Client Address file");
        } else {
            ExtentTestManager.logFailure("Client Id should be existed in Client Address file");
        }
        Assert.assertTrue(result, "Client Id should be existed in Client Address file");
    }

    public void VerifyClientIdIsNotExistedInClientAddress(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientAddressFile(accountId, clientFName, clientLName);
        if(!result) {
            ExtentTestManager.logPass("Client Id is NOT existed in Client Address file");
        } else {
            ExtentTestManager.logFailure("Client Id should NOT existed in Client Address file");
        }
        Assert.assertFalse(result, "Client Id should NOT existed in Client Address file");
    }

    public boolean isClientExitedInClientScheduleFile(String accountId, String clientFName, String clientLName) {
        String clientId = getClientId(accountId, clientFName, clientLName);
        ExtentTestManager.logTestStep(String.format("Client Id is %s", clientId));
        List<ClientSchedule> clientScheduleList = filterClientScheduleBy(clientId);
        if(clientScheduleList.size() != 0)
            return true;
        return false;
    }

    public void VerifyClientIdIsExistedInClientSchedule(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientScheduleFile(accountId, clientFName, clientLName);
        if(result) {
            ExtentTestManager.logPass("Client Id is existed in Client Schedule file");
        } else {
            ExtentTestManager.logFailure("Client Id should be existed in Client Schedule file");
        }
        Assert.assertTrue(result, "Client Id should be existed in Client Schedule file");
    }

    public void VerifyClientIdIsNotExistedInClientSchedule(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientScheduleFile(accountId, clientFName, clientLName);
        if(!result) {
            ExtentTestManager.logPass("Client Id is NOT existed in Client Schedule file");
        } else {
            ExtentTestManager.logFailure("Client Id should NOT existed in Client Schedule file");
        }
        Assert.assertFalse(result, "Client Id should NOT existed in Client Schedule file");
    }

    public boolean isClientExitedInClientAuthFile(String accountId, String clientFName, String clientLName) {
        String clientId = getClientId(accountId, clientFName, clientLName);
        ExtentTestManager.logTestStep(String.format("Client Id is %s", clientId));
        List<ClientAuthModel> clientAuthModelList = filterClientAuthBy(clientId);
        if(clientAuthModelList.size() != 0)
            return true;
        return false;
    }

    public void VerifyClientIdIsExistedInClientAuth(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientAuthFile(accountId, clientFName, clientLName);
        if(result) {
            ExtentTestManager.logPass("Client Id is existed in Client Auth file");
        } else {
            ExtentTestManager.logFailure("Client Id should be existed in Client Auth file");
        }
        Assert.assertTrue(result, "Client Id should be existed in Client Auth file");
    }

    public void VerifyClientIdIsNotExistedInClientAuth(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientAuthFile(accountId, clientFName, clientLName);
        if(!result) {
            ExtentTestManager.logPass("Client Id is NOT existed in Client Auth file");
        } else {
            ExtentTestManager.logFailure("Client Id should NOT existed in Client Auth file");
        }
        Assert.assertFalse(result, "Client Id should NOT existed in Client Auth file");
    }

    public boolean isClientExitedInClientEligFile(String accountId, String clientFName, String clientLName) {
        String clientId = getClientId(accountId, clientFName, clientLName);
        ExtentTestManager.logTestStep(String.format("Client Id is %s", clientId));
        List<ClientEligibilityModel> clientEligibilityModelList = filterClientEligibilityBy(clientId);
        if(clientEligibilityModelList.size() != 0)
            return true;
        return false;
    }

    public void VerifyClientIdIsExistedInClientElig(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientEligFile(accountId, clientFName, clientLName);
        if(result) {
            ExtentTestManager.logPass("Client Id is existed in Client Elig file");
        } else {
            ExtentTestManager.logFailure("Client Id should be existed in Client Elig file");
        }
        Assert.assertTrue(result, "Client Id should be existed in Client Elig file");
    }

    public void VerifyClientIdIsNotExistedInClientElig(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientEligFile(accountId, clientFName, clientLName);
        if(!result) {
            ExtentTestManager.logPass("Client Id is NOT existed in Client Elig file");
        } else {
            ExtentTestManager.logFailure("Client Id should NOT existed in Client Elig file");
        }
        Assert.assertFalse(result, "Client Id should NOT existed in Client Elig file");
    }

    public boolean isClientExitedInClientDiagFile(String accountId, String clientFName, String clientLName) {
        String clientId = getClientId(accountId, clientFName, clientLName);
        ExtentTestManager.logTestStep(String.format("Client Id is %s", clientId));
        List<ClientDiagnosisModel> clientDiagnosisModelList = filterClientDiagnosisBy(clientId);
        if(clientDiagnosisModelList.size() != 0)
            return true;
        return false;
    }

    public void VerifyClientIdIsExistedInClientDiag(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientDiagFile(accountId, clientFName, clientLName);
        if(result) {
            ExtentTestManager.logPass("Client Id is existed in Client Diag file");
        } else {
            ExtentTestManager.logFailure("Client Id should be existed in Client Diag file");
        }
        Assert.assertTrue(result, "Client Id should be existed in Client Diag file");
    }

    public void VerifyClientIdIsNotExistedInClientDiag(String accountId, String clientFName, String clientLName) {
        boolean result = isClientExitedInClientDiagFile(accountId, clientFName, clientLName);
        if(!result) {
            ExtentTestManager.logPass("Client Id is NOT existed in Client Diag file");
        } else {
            ExtentTestManager.logFailure("Client Id should NOT existed in Client Diag file");
        }
        Assert.assertFalse(result, "Client Id should NOT existed in Client Diag file");
    }

    public void VerifyValueOfModifierFieldsInClientAuth(AuthorizationEntity authExpected){
        ClientAuthModel authFromFile = filterClientAuthBy(authExpected.getClientIdentifier(),authExpected.getPayerID()).get(0);
        Assert.assertEquals(authFromFile.getModifier1(),authExpected.getModifier1(),"Modifier1 does not match in file Client_Auth");
        Assert.assertEquals(authFromFile.getModifier2(),authExpected.getModifier2(),"Modifier1 does not match in file Client_Auth");
        Assert.assertEquals(authFromFile.getModifier3(),authExpected.getModifier3(),"Modifier1 does not match in file Client_Auth");
        Assert.assertEquals(authFromFile.getModifier4(),authExpected.getModifier4(),"Modifier1 does not match in file Client_Auth");
    }

    public void VerifyValueOfModifierFieldsInClientSchedule(AuthorizationEntity authExpected){
        ClientSchedule scheduleFromFile = filterClientScheduleBy(authExpected.getClientIdentifier()).get(0);
        Assert.assertEquals(scheduleFromFile.getModifier1(),authExpected.getModifier1(),"Modifier1 does not match in file Client_Schedule");
        Assert.assertEquals(scheduleFromFile.getModifier2(),authExpected.getModifier2(),"Modifier2 does not match in file Client_Schedule");
        Assert.assertEquals(scheduleFromFile.getModifier3(),authExpected.getModifier3(),"Modifier3 does not match in file Client_Schedule");
        Assert.assertEquals(scheduleFromFile.getModifier4(),authExpected.getModifier4(),"Modifier4 does not match in file Client_Schedule");
    }
}
