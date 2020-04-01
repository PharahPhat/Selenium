package generic;

import com.interop.models.altevv.client.ClientAddress;
import com.sandata.common.Constant;
import com.sandata.models.dwh.ohio.Address;
import com.sandata.models.dwh.ohio.DwhExtract;
import com.sandata.models.dwh.ohio.Individual;
import com.sandata.models.molina.client.ClientAddressModel;
import com.sandata.core.report.ExtentTestManager;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.sandata.common.Constant.CONNECTICUT;
import static com.sandata.common.Constant.MOLINA;
import static com.interop.sql.Sql.SQL_GET_CLIENT_ADDRESS;

public class ClientAddressGenericTest extends ClientGenericTest {
    private String clientFirstName;
    private String clientLastName;

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public List<ClientAddressModel> mapClientAddressTableToModel(String clientFName, String clientLName, String account) {
        String sql = String.format(SQL_GET_CLIENT_ADDRESS, account, clientFName, clientLName,
                account, clientFName, clientLName);
        return mapDataTableToModel(sql, ClientAddressModel.class);
    }

    public List<ClientAddressModel> filterClientAddressBy(String clientId) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, ClientAddressModel.class)
                .stream().filter(clientAddress -> clientAddress.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public String getClientId(String clientFName, String clientLName) {
        return getClientIdBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName);
    }

//    public void verifyClientAddressFileDataMatchWithDatabase(String clientFName, String clientLName) {
//        String clientId = getClientId();
//
//        if(baseObj.readDataValue("AccountType").equalsIgnoreCase(OHIO)) {
//            verifyClientAddressOhioFileDataMatchWithDatabase(clientId);
//        }
//        if(baseObj.readDataValue("AccountType").equalsIgnoreCase(MOLINA)) {
//            verifyClientPhoneMolinaFileDataMatchWithDatabase(clientId, clientFName, clientLName);
//        }
//    }

    public void verifyClientAddressFileDataMatchWithDatabase(String clientFName, String clientLName) {

        String clientId = getClientId(clientFName, clientLName);

        if(baseObj.readDataValue("AccountType").equalsIgnoreCase(CONNECTICUT)) {
            verifyClientAddressOhioFileDataMatchWithDatabase(clientId, clientFName, clientLName);
        }
        if(baseObj.readDataValue("AccountType").equalsIgnoreCase(MOLINA)) {
            verifyClientPhoneMolinaFileDataMatchWithDatabase(clientId, clientFName, clientLName);
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
//        if(dbResult.get(0).getClientZip().contains("-"))
//            dbResult.get(0).setClientZip(dbResult.get(0).getClientZip().replace("-", ""));
        dbResultBk.sort(Comparator.comparing(ClientAddressModel::getClientZip));

        boolean result = areRecordsExistedInDatabase(exportResult, dbResultBk);

        if (result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }

//        boolean payerResult = exportResult.get(0).getPayerID().equals("");
//        if(payerResult) {
//            ExtentTestManager.logPass("PayerID is correct");
//        } else {
//            ExtentTestManager.logFailure(String.format("PayerID is incorrect"));
//        }

        Assert.assertTrue(result, String.format("areRecordsExistedInDatabase: %s", result));
    }

    public void verifyClientPhoneMolinaFileDataMatchWithDatabase(String clientId, String clientFirstName, String clientLastName) {
//        public void verifyClientPhoneMolinaFileDataMatchWithDatabase(String clientId, String clientFName, String clientLName) {
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

//        List<ClientAddressModel> dbResult = mapClientAddressTableToModel(clientFName, clientLName,
//                baseObj.readDataValue("AccountId"));

//        if(baseObj.readDataValue("AccountType").equalsIgnoreCase(OHIO)){
//            dbResult.remove(0);
//            if(dbResult.get(0).getClientZip().contains("-"))
//                dbResult.get(0).setClientZip(dbResult.get(0).getClientZip().replace("-", ""));
//        }
//        dbResult.sort(Comparator.comparing(ClientAddressModel::getClientZip));
        dbResult.remove(0);
        dbResult.get(0).setPayerID(payerId);

        boolean result = areRecordsExistedInDatabase(exportResult, dbResult);

        if (result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
//        Assert.assertTrue((result && payerResult), String.format("areRecordsExistedInDatabase: %s, payerResult: %s", result, payerResult));
    }

    public void verifyClientAddressExportedWithCorrectFormat(String clientFName, String clientLName) {
        String clientId = getClientId(clientFName, clientLName);
        List<ClientAddressModel> exportResult = filterClientAddressBy(clientId);
        exportResult.sort(Comparator.comparing(ClientAddressModel::getClientZip));

        boolean result = ClientAddressModel.verifyDataInDbAndCsvCorrectly(exportResult);
        if(result) {
            ExtentTestManager.logPass("Field Format is correct");
        } else {
            ExtentTestManager.logFailure(String.format("Field Format is incorrect"));
        }
        Assert.assertTrue(result, String.format("Client Address Exported With Correct Format, payerResult: %s", result));
    }

    public void validateClientAddrAsExpectedResults(){
        List<ClientAddressModel> datas = filterClientAddrBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public void validateClientAddrAsExpectedFormat(){
        List<ClientAddressModel> datas = filterClientAddrBy();
        Assert.assertTrue(datas.size() > 0, "File data is incorrect format");
    }

    public List<ClientAddressModel> filterClientAddrBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientAddressModel.class);
    }

    public void validateOhioClientAdressFromJsonData()  {
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        List<Individual> listIndividual =  exportedFile.getIndividual();
        if(listIndividual != null) {
            List<Address> listAddress =  listIndividual.get(0).getAddress();
            if(listAddress != null && listAddress.size() > 0)
                Assert.assertTrue(listAddress.get(0).getDataIsNotNull(), "Staff Header is not expected result");
        }
    }

}
