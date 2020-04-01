package performance;

import com.interop.models.db.stx.STXClient;
import com.interop.services.openevv.OpenEvvClientService;
import com.interop.common.TestDataHelper;
import com.sandata.utilities.ColumnAnnotationMapper;
import com.sandata.utilities.DbUtilsCon;
import generic.GenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.interop.sql.ClientSQL.SQL_CLIENT_WITH_ROW_NUM;
import static com.interop.sql.ClientSQL.sql_clientByFName;

public class Auto_SEVV_18119_TC_19192_OpenEVV_Generate_Json_Client_Data extends GenericTest {

    private String testCaseId = "TC_19192";
    private static final int numberClient = 1000; //the count of client want to import
    private static final int numberClientGetList = 1000;
    private static List<String> preFix = new ArrayList<>();
    private static List<String> fileNameList = new ArrayList<>();
    private static List<String> accountList = new ArrayList<>();
    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {"60269","Test@123456!","Test@123456!","LP1234567"},
                        {"60270","Test@123456!","Test@123456!","8288564"},
                        {"60271","Test@123456!","Test@123456!","LP1234506"},
                        {"60285","Test@123456!","Test@123456!","110001138"},
                        {"60286","Test@123456!","Test@123456!","110001139"},
                        {"60287","Test@123456!","Test@123456!","110102124"},
                        {"60288","Test@123456!","Test@123456!","110000936"},
                        {"60289","Test@123456!","Test@123456!","110001038"},
                        {"60295","Test@123456!","Test@123456!","110178924"},
                        {"60296","Test@123456!","Test@123456!","110001389"},
                        {"60301","Test@123456!","Test@123456!","LP007"},
                        {"60303","Test@123456!","Test@123456!","201908290"},
                        {"60305","Test@123456!","Test@123456!","201908297"},
                        {"60306","Test@123456!","Test@123456!","201908299"},
                        {"60307","Test@123456!","Test@123456!","201908295"},
                        {"60309","Test@123456!","Test@123456!","201908298"},
                        {"end","end","end","end"},

                };
    }

    @Test(dataProvider = "dataProvider")
    public void Auto_SEVV_18119_TC_19192_AltGeneric_Generate_Json_Client_Data_Jmeter(String acc,
                                                                                     String user,
                                                                                     String pass,
                                                                                     String providerId) throws IOException {
        if(!acc.equals("end")){
            OpenEvvClientService clientAPI;
            String fName = "ClientPer" + RandomStringUtils.randomAlphabetic(10);
            LOGGER.info("fName -------------- " + fName);
            clientAPI = OpenEvvClientService.init(numberClient, acc, user, pass, providerId);
            String body = clientAPI.generateJsonData();
            String fileName = clientAPI.getStateAccount().getAccountID() + "_CLIENT_" + fName + ".txt";
            commons.generateJsonBody(body, fileName);
            preFix.add(fName);
            fileNameList.add(fileName);
            accountList.add(clientAPI.getStateAccount().getAccountID());
        }else {
            commons.generateToJmeterFilePerformanceTestingClient(preFix, fileNameList, accountList);
            preFix.clear();
            fileNameList.clear();
            accountList.clear();
        }
    }

    @Test()
    public void Auto_SEVV_18119_TC_19192_OpenEVV_Generate_Json_Client_Performance() throws IOException {
        String fName = "ClientPer" + RandomStringUtils.randomAlphabetic(10);
        LOGGER.info("fName -------------- " + fName);
        OpenEvvClientService clientAPI = OpenEvvClientService.init(numberClient, null, null, null, null);
        String body = clientAPI.generateJsonData();
        commons.generateJsonBody(body,"ClientPer" + RandomStringUtils.randomAlphabetic(5) + ".txt");
    }

    @Test()
    public void Auto_SEVV_18119_TC_19192_OpenEVV_Get_Client_List() throws IOException {
        OpenEvvClientService clientAPI = OpenEvvClientService.init(1, null, null, null, null);
        ColumnAnnotationMapper<STXClient> mapper = new ColumnAnnotationMapper<>(STXClient.class);
        String getQuery = String.format(SQL_CLIENT_WITH_ROW_NUM, clientAPI.getModels().get(0).getAccount(), numberClientGetList);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), getQuery);
        List<STXClient> employees = mapper.DataTableMapper(rs);
        List<String> workerIdCustom1List = employees.stream().map(item -> item.CLIENT_ID_CUSTOM1).collect(Collectors.toList());
        String workers = StringUtils.join(workerIdCustom1List, ",");
        commons.generateJsonBody(workers,"ClientIdCustom1.txt");
    }

    @Test(priority = 1)
    public void Auto_SEVV_18119_TC_19192_OpenEVV_Generate_Json_Client_Data_Full_Case() throws IOException {
        String expectedStatus = "SUCCESS";
        String expectedGetStatus = "SUCCESS";
        String expectedMessage = "0";
        Assert.assertTrue(InitDataForTestCase(testCaseId), "Create table not successfully");
        String fName = "ClientPer" + RandomStringUtils.randomAlphabetic(19);
        OpenEvvClientService clientAPI = OpenEvvClientService.init(100, null, null, null, null);
        String body = clientAPI.generateJsonData();
        commons.generateJsonBody(body,"PerformanceClient.txt");
        clientAPI.post();
        clientAPI.verifyPostStatus(expectedStatus);

        if(!StringUtils.isBlank(expectedMessage)) {
            if (clientAPI.getResponse().statusCode() == 500) {
                baseObj.fail( "The status code is not 200");
            } else {
                clientAPI.verifyMDWPass();
            }
        }

        if(!StringUtils.isBlank(expectedGetStatus)){
            clientAPI.requestUUIDStatus();
            clientAPI.verifyUUIDStatus(expectedGetStatus);
        }

        StoreDataValidationForPerformanceClient(testCaseId, clientAPI.getModels(), clientAPI.getModels().get(0).getAccount());
    }

    @Test(enabled = false, priority = 2)
    public void Auto_SEVV_6462_TC_19192_OPEN_EVV_Validate_Data_From_DB(){
        int row = GetDataStore(testCaseId)-1;
        String clientFirstName = "";
        String clientAccount = validateDataStore.get("Account_1");
        String clientFirstNameList = "";

        for(int i = 1; i <= row; i++){

            clientFirstName = validateDataStore.get("ClientFirstName_" + i);
            clientFirstNameList += "'" + clientFirstName + "'";
            if(i < row)
                clientFirstNameList += ",";
        }

        ColumnAnnotationMapper<STXClient> mapper = new ColumnAnnotationMapper<>(STXClient.class);
        String getQuery = String.format(sql_clientByFName, clientFirstNameList, clientAccount);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), getQuery);
        List<STXClient> clients = mapper.DataTableMapper(rs);
        List<String> listFName = clients.stream().map(item -> item.F_NAME).collect(Collectors.toList());
        for(int i = 1; i <= row; i++){
            clientFirstName = validateDataStore.get("ClientFirstName_" + i);
            int j;
            for(j = 0; j < listFName.size(); j++){
                if(clientFirstName.equals(listFName.get(j))){
                    LOGGER.info(clientFirstName + " is inserted in db");
                    break;
                }
            }
            if(j == listFName.size())
                LOGGER.error(clientFirstName + " is not inserted in db");
        }

        Assert.assertTrue(listFName.size() == 100, "Data are not inserted in db");
    }
}
