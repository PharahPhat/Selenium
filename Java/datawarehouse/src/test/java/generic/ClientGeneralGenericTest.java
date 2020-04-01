package generic;

import com.sandata.common.Constant;
import com.sandata.core.report.ExtentTestManager;
import com.sandata.models.dwh.ohio.DwhExtract;
import com.sandata.models.dwh.ohio.Individual;
import com.sandata.models.generic.client.ClientGeneralModel;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.interop.common.constants.FieldConstants.CLIENT_DESIGNEE_LAST_NAME;
import static com.interop.sql.Sql.SQL_GET_CLIENT_GENERAL;
import static com.interop.sql.Sql.SQL_GET_CLIENT_GENERAL_MOLINA;
import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.sandata.common.Constant.MOLINA;

public class ClientGeneralGenericTest extends ClientGenericTest {

    public List<ClientGeneralModel> mapClientGeneralTableToModel(String clientFName, String clientLName, String account) {
        String sql;
        if (!baseObj.readDataValue("AccountType").equals(MOLINA))
            sql = String.format(SQL_GET_CLIENT_GENERAL, account, clientFName, clientLName);
        else sql = String.format(SQL_GET_CLIENT_GENERAL_MOLINA, account, clientFName, clientLName);
        return mapDataTableToModel(sql, ClientGeneralModel.class);
    }

    public List<ClientGeneralModel> filterClientGeneralBy(String clientId) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, ClientGeneralModel.class)
                .stream().filter(clientGeneral -> clientGeneral.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public boolean isClientGeneralRecordExistedInExportFile(ClientGeneralModel fileRecord,
                                                            List<ClientGeneralModel> dbRecords) {
        for (ClientGeneralModel record : dbRecords) {
            String fileDataInfo = fileRecord.toString();
            String currDataDbInfo = record.toString();
            System.out.println("fileDataInfo " + fileDataInfo);
            System.out.println("currDataDbInfo " + currDataDbInfo);

            if (fileDataInfo.equals(currDataDbInfo))
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
        String clientId = getClientId(clientFName, clientLName);

        if (baseObj.readDataValue("AccountType").equals(MOLINA)) {
            verifyClientGeneralMolinaFileDataMatchWithDatabase(clientId, clientFName, clientLName);
        } else {
            verifyClientGeneralGenericFileDataMatchWithDatabase(clientId, clientFName, clientLName);
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

        List<ClientGeneralModel> dbResult = mapClientGeneralTableToModel(
                clientFName,
                clientLName,
                baseObj.readDataValue("AccountId"));

        List<ClientGeneralModel> dbResult1 = new ArrayList<>();
        dbResult1.add(dbResult.get(0));

        boolean result = areClientGeneralRecordsExistedInDatabase(exportResult, dbResult1);
        if (result) {
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

        String clientDesigneeFName = baseObj.readDataValue("ClientDesigneeFirstName");
        String clientDesigneeLName = baseObj.readDataValue(CLIENT_DESIGNEE_LAST_NAME);
        String clientDesigneeEmail = baseObj.readDataValue("ClientDesigneeEmail");
        String clientDesigneeStatus = baseObj.readDataValue("ClientDesigneeStatus");

        boolean result = areClientGeneralExistedInDb(exportResult, dbResult);
        if (result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "Client General Generic File Data is not matched with database");
    }

    public void verifyClientAddressExportedWithCorrectFormat(String clientFName, String clientLName) {
        String clientFirstName;
        String clientLastName;
        if (clientFName != null || !clientFName.isEmpty()) {
            clientFirstName = clientFName;
            clientLastName = clientLName;
        } else {
            clientFirstName = baseObj.readDataValue("Client_FirstName");
            clientLastName = baseObj.readDataValue("Client_LastName");
        }
        String clientId = getClientId(clientFirstName, clientLastName);
        List<ClientGeneralModel> exportResult = filterClientGeneralBy(clientId);

        boolean result = ClientGeneralModel.verifyDataInDbAndCsvCorrectly(exportResult);
        if (result) {
            ExtentTestManager.logPass("Field Format is correct");
        } else {
            ExtentTestManager.logFailure(String.format("Field Format is incorrect"));
        }
        Assert.assertTrue(result, "Client Address Exported With Incorrect Format");
    }

    public void validateProviderGeneralIsGeneratedAsExpectedResults() {
        List<ClientGeneralModel> clientGeneralFile = filterClientGeneralBy();
        Assert.assertTrue(clientGeneralFile.size() > 0, "Client General File data is not generated");
    }

    public void validateProviderGeneralIsGeneratedAsExpectedFormat() {
        List<ClientGeneralModel> clientGeneralFile = filterClientGeneralBy();
        Assert.assertTrue(clientGeneralFile.size() > 0, "Client General File data is not generated");
    }

    /**
     * Author: liem.chau
     * Des: Verify the time zone name should be look like time zone name input
     */
    public void verifyTimeZoneShouldAlwaysBeDefault() {
        boolean result = true;
        String timeZoneName = baseObj.readDataValue("TimeZoneName");
        List<ClientGeneralModel> fileRecords = filterClientGeneralBy();
        for (ClientGeneralModel timeZoneCol : fileRecords) {
            if (timeZoneCol.getClientTimeZone().equals(timeZoneName)) {
                ExtentTestManager.logPass("The time zone name as expected result");
            } else {
                result = false;
                ExtentTestManager.logFailure(String.format("The time zone name should be %s", timeZoneName));
            }
        }
        Assert.assertTrue(result, "Time Zone is not as default");
    }

    public void verifyTimeZoneShouldAlwaysBeDefaultByTimeZone(String timeZoneName) {
        boolean result = false;
        List<ClientGeneralModel> fileRecords = filterClientGeneralBy();
        for (ClientGeneralModel timeZoneCol : fileRecords) {
            if (timeZoneCol.getClientTimeZone().equals(timeZoneName)) {
                ExtentTestManager.logPass("The time zone name as expected result");
            } else {
                result = false;
                ExtentTestManager.logFailure(String.format("The time zone name should be %s", timeZoneName));
            }
        }
        Assert.assertTrue(result, "Time Zone is not as default");
    }

    /**
     * Author: liem.chau (Tony)
     * Des: Get the provider General list model from the file in the input folder
     *
     * @return the provider General model list
     */
    public List<ClientGeneralModel> filterClientGeneralBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientGeneralModel.class);
    }

    public boolean isClientGeneralExistedInDb(ClientGeneralModel clientGeneralFile, List<ClientGeneralModel> clientGeneralDb) {
        for (ClientGeneralModel clientGeneral : clientGeneralDb) {
            if (clientGeneralFile.verifyFieldValue(clientGeneral))
                return true;
        }
        return false;
    }

    public boolean areClientGeneralExistedInDb(List<ClientGeneralModel> clientGeneralFile, List<ClientGeneralModel> clientGeneralDb) {
        for (ClientGeneralModel clientGeneral : clientGeneralFile) {
            if (!isClientGeneralRecordExistedInExportFile(clientGeneral, clientGeneralDb))
                return false;
        }
        return true;
    }

    public void validateOhioStaffHeaderFromJsonData()  {
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        List<Individual> individuals =  exportedFile.getIndividual();
        if(individuals.size() > 0)
            Assert.assertTrue(individuals.get(0).getDataIsNotNull(), "Staff Header is not expected result");
    }
}
