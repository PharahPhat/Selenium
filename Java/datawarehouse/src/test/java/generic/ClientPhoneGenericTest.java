package generic;

import com.sandata.common.Constant;
import com.sandata.models.dwh.ohio.DwhExtract;
import com.sandata.models.dwh.ohio.Individual;
import com.sandata.models.dwh.ohio.Phone;
import com.sandata.models.generic.client.ClientPhone;
import com.sandata.models.generic.client.ClientPhoneModel;
import com.sandata.core.report.ExtentTestManager;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.interop.sql.Sql.SQL_GET_CLIENT_PHONE;

public class ClientPhoneGenericTest extends ClientGenericTest{
    public List<ClientPhoneModel> mapClientPhoneTableToModel(String clientFName, String clientLName, String account) {
        String sql = String.format(SQL_GET_CLIENT_PHONE, clientFName, clientLName, account);
        return mapDataTableToModel(sql, ClientPhoneModel.class);
    }

    public List<ClientPhoneModel> filterClientPhoneBy(String clientId) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, ClientPhoneModel.class)
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

    public void validateClientPhoneAsExpectedResults(){
        List<ClientPhoneModel> datas = filterClientPhoneBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public void validateClientPhoneAsExpectedFormat(){
        List<ClientPhoneModel> datas = filterClientPhoneBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public List<ClientPhoneModel> filterClientPhoneBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientPhoneModel.class);
    }

    public void validateOhioVisitClientPhoneFromJsonData()  {
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        List<Individual> listIndividual =  exportedFile.getIndividual();
        if(listIndividual != null){
            List<Phone> listPHone = listIndividual.get(0).getPhone();
            if(listPHone != null && listPHone.size() > 0)
                Assert.assertTrue(listPHone.get(0).getDataIsNotNull(), "Staff Header is not expected result");
        }

    }
}
