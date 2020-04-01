package generic;

import com.sandata.common.Constant;
import com.sandata.models.molina.client.ClientEligibilityModel;
import com.sandata.core.report.ExtentTestManager;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.interop.sql.ClientSQL.SQL_GET_CLIENT_ELIG;

public class ClientEligibilityGenericTest extends ClientGenericTest {
    public List<ClientEligibilityModel> mapClientEligibilityTableToModel(String clientFName, String clientLName, String account) {
        String sql = String.format(SQL_GET_CLIENT_ELIG, account, clientFName, clientLName);
        return mapDataTableToModel(sql, ClientEligibilityModel.class);
    }

    public List<ClientEligibilityModel> filterClientEligibilityBy(String clientId) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, ClientEligibilityModel.class)
                .stream().filter(clientElig -> clientElig.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public String getClientId(String clientFName, String clientLName) {
        return getClientIdBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName);
    }

    public boolean isClientEligExistedInDb(ClientEligibilityModel clientEligFile, List<ClientEligibilityModel> clientEligDb) {
        for(ClientEligibilityModel clientElig : clientEligDb) {
            if(clientEligFile.verifyFieldValue(clientElig))
                return true;
        }
        return false;
    }

    public boolean areClientEligExistedInDb(List<ClientEligibilityModel> clientEligFile, List<ClientEligibilityModel> clientEligDb) {
        for(ClientEligibilityModel clientElig : clientEligFile) {
            if(!isClientEligExistedInDb(clientElig, clientEligDb))
                return false;
        }
        return true;
    }

    public void verifyClientEligibilityFileDataMatchWithDatabase(String clientFName, String clientLName) {
        String clientId = getClientId(clientFName, clientLName);

        List<ClientEligibilityModel> exportResult = filterClientEligibilityBy(clientId);
        Assert.assertNotEquals(exportResult.size(), 0,
                String.format("Client %s is not existed in exported file", clientId));

        List<ClientEligibilityModel> dbResult = mapClientEligibilityTableToModel(
                clientFName,
                clientLName,
                baseObj.readDataValue("AccountId"));

        boolean result = areClientEligExistedInDb(exportResult, dbResult);

        if (result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "Records in file are not matched with database");
    }

    public void validateEligibilityIsGeneratedAsExpectedResults(){
        List<ClientEligibilityModel> providerGeneralFile = filterEligibilityBy();
        Assert.assertTrue(providerGeneralFile.size() > 0, "EmployeeDiscipline file data is not generated");
    }

    public List<ClientEligibilityModel> filterEligibilityBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientEligibilityModel.class);
    }

}
