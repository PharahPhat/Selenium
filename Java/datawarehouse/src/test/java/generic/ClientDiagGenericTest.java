package generic;

import com.sandata.common.Constant;
import com.sandata.models.molina.client.ClientDiagnosisModel;
import com.sandata.core.report.ExtentTestManager;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.interop.sql.ClientSQL.SQL_GET_CLIENT_DIAG;

public class ClientDiagGenericTest extends ClientGenericTest {
    public List<ClientDiagnosisModel> mapClientDiagnosisTableToModel(String clientFName, String clientLName, String account) {
        String sql = String.format(SQL_GET_CLIENT_DIAG, account, clientFName, clientLName);
        return mapDataTableToModel(sql, ClientDiagnosisModel.class);
    }

    public List<ClientDiagnosisModel> filterClientDiagnosisBy(String clientId) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, ClientDiagnosisModel.class)
                .stream().filter(clientElig -> clientElig.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public String getClientId(String clientFName, String clientLName) {
        return getClientIdBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName);
    }

    public boolean isClientEligExistedInDb(ClientDiagnosisModel clientDiagFile, List<ClientDiagnosisModel> clientDiagDb) {
        for(ClientDiagnosisModel clientDiag : clientDiagDb) {
            if(clientDiagFile.verifyFieldValue(clientDiag))
                return true;
        }
        return false;
    }

    public boolean areClientEligExistedInDb(List<ClientDiagnosisModel> clientDiagFile, List<ClientDiagnosisModel> clientDiagDb) {
        for(ClientDiagnosisModel clientDiag : clientDiagFile) {
            if(!isClientEligExistedInDb(clientDiag, clientDiagDb))
                return false;
        }
        return true;
    }

    public void verifyClientDiagnosisFileDataMatchWithDatabase(String clientFName, String clientLName) {
        String clientId = getClientId(clientFName, clientLName);

        List<ClientDiagnosisModel> exportResult = filterClientDiagnosisBy(clientId);

        List<ClientDiagnosisModel> dbResult = mapClientDiagnosisTableToModel(
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

    public void validateClientDiagAsExpectedResults(){
        List<ClientDiagnosisModel> datas = filterClientDiagBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public List<ClientDiagnosisModel> filterClientDiagBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientDiagnosisModel.class);
    }
}
