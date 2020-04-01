package generic;

import com.sandata.common.Constant;
import com.sandata.models.molina.client.ClientProgModel;
import com.sandata.models.molina.client.ClientProgMolinaModel;
import com.sandata.core.report.ExtentTestManager;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.sandata.common.Constant.MOLINA;
import static com.interop.sql.Sql.SQL_GET_CLIENT_PROGRAM;

public class ClientProgGenericTest extends ClientGenericTest {
    public <T> List<T> mapClientProgTableToModel(Class<T> clazz, String clientFName, String clientLName, String account) {
        String sql = String.format(SQL_GET_CLIENT_PROGRAM, account, clientFName, clientLName);
        return mapDataTableToModel(sql, clazz);
    }

    public List<ClientProgModel> filterClientProgBy(String clientId) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, ClientProgModel.class)
                .stream().filter(clientPhone -> clientPhone.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public List<ClientProgMolinaModel> filterClientProgMolinaBy(String clientId) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, ClientProgMolinaModel.class)
                .stream().filter(clientPhone -> clientPhone.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public void verifyClientProgGeneralFileDataMatchWithDatabase(String clientId, String clientFName, String clientLName) {
        List<ClientProgModel> exportResult = filterClientProgBy(clientId);
        exportResult.sort(Comparator.comparing(ClientProgModel::getPayerID));

        List<ClientProgModel> dbResult = mapClientProgTableToModel(ClientProgModel.class,
                clientFName,
                clientLName,
                baseObj.readDataValue("AccountId"));
//        dbResult.sort(Comparator.comparing(ClientProgModel::getPayerID));

        boolean result =
                areRecordsExistedInDatabase(
                        exportResult, dbResult);

        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "Client prog common file data Is not match with database");
    }

    public void verifyClientProgMolinaFileDataMatchWithDatabase(String clientId, String clientFName, String clientLName) {
        List<ClientProgMolinaModel> exportResult = filterClientProgMolinaBy(clientId);
        exportResult.sort(Comparator.comparing(ClientProgMolinaModel::getPayerID));

        List<ClientProgMolinaModel> dbResult = mapClientProgTableToModel(ClientProgMolinaModel.class,
                clientFName,
                clientLName,
                baseObj.readDataValue("AccountId"));
        if(dbResult.get(0).getPayerID() != null)
            dbResult.sort(Comparator.comparing(ClientProgMolinaModel::getPayerID));

        boolean result =
                areRecordsExistedInDatabase(
                        exportResult, dbResult);

        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }

        String payerId = baseObj.readDataValue("FilePrefix");
        boolean payerResult = exportResult.get(0).getPayerID().equals(payerId);
        if(payerResult) {
            ExtentTestManager.logPass("PayerID is correct");
        } else {
            ExtentTestManager.logFailure(String.format("PayerID is incorrect"));
        }
        Assert.assertTrue( (result && payerResult), String.format("All records in file exist in database: %s\nPayerID is correct%s", result, payerResult));
    }

    public void verifyClientProgFileDataMatchWithDatabase(String clientFName, String clientLName) {
        String clientFirstName;
        String clientLastName;

        if(clientFName != null && !clientFName.isEmpty() && clientLName != null && !clientLName.isEmpty()){
            clientFirstName = clientFName;
            clientLastName = clientLName;
        }else {
            clientFirstName = baseObj.readDataValue("Client_FirstName");
            clientLastName = baseObj.readDataValue("Client_LastName");
        }

        String clientId = getClientId(clientFirstName, clientLastName);

        if(baseObj.readDataValue("AccountType").equals(MOLINA)){
            verifyClientProgMolinaFileDataMatchWithDatabase(clientId, clientFirstName, clientLastName);
        }else {
            verifyClientProgGeneralFileDataMatchWithDatabase(clientId, clientFirstName, clientLastName);
        }
    }

    public String getClientId(String clientFName, String clientLName) {
        return getClientIdBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName);
    }

    public void verifyClientProgGenericExportedWithCorrectFormat(String clientFName, String clientLName) {
        String clientId = getClientId(clientFName, clientLName);
        List<ClientProgModel> exportResult = filterClientProgBy(clientId);
        exportResult.sort(Comparator.comparing(ClientProgModel::getPayerProgram));

        boolean result = ClientProgModel.verifyFormatFieldOfData(exportResult);
        if(result) {
            ExtentTestManager.logPass("Field Format is correct");
        } else {
            ExtentTestManager.logFailure(String.format("Field Format is incorrect"));
        }
        Assert.assertTrue(result, "ClientProgGeneric exported with incorrect format");
    }

    public void validateClientProgAsExpectedResults(){
        List<ClientProgModel> datas = filterClientProBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public List<ClientProgModel> filterClientProBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientProgModel.class);
    }
}
