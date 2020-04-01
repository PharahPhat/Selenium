package performance;

import com.interop.services.openevv.OpenEvvClientService;
import com.interop.services.openevv.OpenEvvScheduleService;
import com.interop.common.TestDataHelper;
import com.sandata.utilities.DbUtilsCon;
import generic.GenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.interop.sql.ClientSQL.SQL_STX_GET_LOC_CLIENT;

public class Auto_SEVV_18119_TC_18125_OpenEVV_Generate_Json_Schedule_Data extends GenericTest {
    private OpenEvvScheduleService scheduleAPI = null;

    private static List<String> accountList = new ArrayList<>();
    private static List<String> fileNameList = new ArrayList<>();
    private static List<String> clientIDs = new ArrayList<>();



    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {"60269","Test@123456!","Test@123456!","LP1234567","020977729"},
                        {"60270","Test@123456!","Test@123456!","8288564","022349410"},
                        {"60271","Test@123456!","Test@123456!","LP1234506","013429537"},
                        {"60285","Test@123456!","Test@123456!","110001138","000054889"},
                        {"60286","Test@123456!","Test@123456!","110001139","000913941"},
                        {"60287","Test@123456!","Test@123456!","110102124","017817783"},
                        {"60288","Test@123456!","Test@123456!","110000936","006653326"},
                        {"60289","Test@123456!","Test@123456!","110001038","002112096"},
                        {"60295","Test@123456!","Test@123456!","110178924","017252766"},
                        {"60296","Test@123456!","Test@123456!","110001389","013131763"},
                        {"60301","Test@123456!","Test@123456!","LP007","013218271"},
                        {"60303","Test@123456!","Test@123456!","201908290","007591519"},
                        {"60305","Test@123456!","Test@123456!","201908297","004927656"},
                        {"60306","Test@123456!","Test@123456!","201908299","012523770"},
                        {"60307","Test@123456!","Test@123456!","201908295","026042677"},
                        {"60309","Test@123456!","Test@123456!","201908298","016757202"},
                        {"end","","","",""}
                };
    }

    @Test(dataProvider = "dataProvider")
    public void Auto_SEVV_18119_TC_18125_OpenEVV_Generate_Json_Schedule_Data(String acc,
                                                                             String user,
                                                                             String pass,
                                                                             String providerId,
                                                                             String employeePIN) throws IOException {


        if(!acc.equals("end")) {
            String[] info = CreateAClient(acc,user,pass, providerId);
            String clientID = info[0];
            String medicateID = info[1];
            String clientCustom1 = info[2];
            scheduleAPI = OpenEvvScheduleService.init(1000, acc, user, pass, employeePIN, medicateID, clientCustom1);
            String body = scheduleAPI.generateJsonData();
            String fileName = acc + "_" + clientID + ".txt";
            commons.generateJsonBody(body, fileName);
            accountList.add(acc);
            fileNameList.add(fileName);
            clientIDs.add(clientID);
        }else{
            commons.generateToJmeterFilePerformanceTestingSchedule(clientIDs, fileNameList,accountList);
            accountList.clear();
            fileNameList.clear();
            clientIDs.clear();
        }
    }

    public String[] executeSqlGetClientID(String acc, String fName){
        String[] results = new String[3];
        String getQuery = String.format(SQL_STX_GET_LOC_CLIENT, acc, fName);
        Boolean done = false;
        int count = 10;
        while(done == false && count >= 0) {
            try {
                ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), getQuery);
                rs.next();
                results[0] = rs.getString("LOC");
                LOGGER.info("CLIENT_ID -------------- " + rs.getString("LOC"));
                LOGGER.info("results[0] -------------- " + results[0]);
                LOGGER.info("MEDICAID_ID -------------- " + rs.getString("MEDICAID_ID"));
                results[1] = rs.getString("MEDICAID_ID");
                LOGGER.info("results[1] -------------- " + results[1]);
                results[2] = rs.getString("CLIENT_ID_CUSTOM1");
                LOGGER.info("CLIENT_ID_CUSTOM1 -------------- " + rs.getString("CLIENT_ID_CUSTOM1"));
                LOGGER.info("results[2] -------------- " + results[2]);
                done = true;
            } catch (Exception ex) {
                LOGGER.info("-----------executeSqlGetClientID-----Failed---------");
                commons.wait(2);
            }
            count --;
        }
        return results;
    }

    public String[] CreateAClient(String acc, String user, String pass, String providerId){
        String expectedStatus = "SUCCESS";
        String expectedGetStatus = "SUCCESS";
        String expectedMessage = "0";
        String fName = "ClientPer" + RandomStringUtils.randomAlphabetic(19);
        OpenEvvClientService clientAPI = OpenEvvClientService.init(1, acc, user, pass, providerId);
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
        return executeSqlGetClientID(acc,fName);
    }


}
