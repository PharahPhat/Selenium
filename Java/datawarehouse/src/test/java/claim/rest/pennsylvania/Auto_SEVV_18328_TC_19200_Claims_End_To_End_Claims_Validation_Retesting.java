package claim.rest.pennsylvania;

import com.interop.common.TestDataHelper;
import com.interop.models.openevv.employee.OpenEvvEmployee;
import com.interop.models.openevv.employee.OpenEvvEmployeeDataGenerator;
import com.interop.services.atlevv.AltEvvVisitService;
import com.interop.services.openevv.OpenEvvClientService;
import com.interop.services.openevv.OpenEvvEmployeeService;
import com.sandata.utilities.DbUtilsCon;
import generic.GenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.interop.sql.ClientSQL.sql_getClientCustom1ByFirstName;
import static com.interop.sql.ClientSQL.sql_getEmployeeCustom1ByFirstName;


public class Auto_SEVV_18328_TC_19200_Claims_End_To_End_Claims_Validation_Retesting extends GenericTest {

    private AltEvvVisitService visitAPI;
    private static List<String> listClientData;
    private static List<String> listEmployeeData;

    private static Map<String, String> clientExisting;
    private static Map<String, String> employeeExisting;

    private Map<String, String> createEmployees(String employeeName) {
        String account;
        Map<String, String> employeeInfo = new HashMap<>();
        String fName = "EmpClaim" + RandomStringUtils.randomAlphabetic(10);
        OpenEvvEmployeeService employeeAPI = new OpenEvvEmployeeService();
        OpenEvvEmployee openEvvEmployee = OpenEvvEmployeeDataGenerator.getOpenEvvEmployeeByState(employeeAPI.getStateAccount().getStateEnum());
        openEvvEmployee.setEmployeeFirstName(fName);
        employeeAPI.getModels().add(openEvvEmployee);
        employeeAPI.loadPayload(employeeAPI.getModels());
        account = employeeAPI.getStateAccount().getAccountID();
        employeeAPI.post();
        employeeAPI.verifyPostStatus("SUCCESS");
        commons.wait(2);
        String sqlQuery = String.format(sql_getEmployeeCustom1ByFirstName, account, fName);

        try {
            ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery);
            while (rs.next()) {
                String workerIdCustom1 = rs.getString("WORKER_ID_CUSTOM1");
                String workerId = rs.getString("STX_ID");
                employeeInfo.put(employeeName, workerId);
                employeeInfo.put(employeeName + "custom", workerIdCustom1);
            }
        } catch (SQLException e) {
        }

        return employeeInfo;
    }

    private Map<String, String> createClients(String clientName){
        String account;
        Map<String, String> clientInfo = new HashMap<>();
        String fName = "ClClaim" + RandomStringUtils.randomAlphabetic(19);
        OpenEvvClientService clientAPI = OpenEvvClientService.init(1, fName);
        account = clientAPI.getStateAccount().getAccountID();
        clientAPI.post();
        clientAPI.verifyPostStatus("SUCCESS");
        commons.wait(2);
        String sqlQuery = String.format(sql_getClientCustom1ByFirstName,account,fName);

        try{
            ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery);
            while (rs.next()) {
                String clientIdCustom1 = rs.getString("CLIENT_ID_CUSTOM1");
                String clientId = rs.getString("LOC");
                clientInfo.put(clientName, clientId);
                clientInfo.put(clientName + "custom", clientIdCustom1);
            }
        } catch (SQLException e) {
        }

        return clientInfo;
    }


    @DataProvider(name = "createVisitsForClaim")
    public Object[][] getDataVisits() {
        String fileName = "CSV_ClaimValidation_FirstDraft.csv";
        listClientData = new ArrayList<>();
        listEmployeeData = new ArrayList<>();
        return TestDataHelper.getProviderDataRowsClaim(false, fileName);
    }

    @Test(priority = 2, dataProvider = "createVisitsForClaim", groups = {"onlyDev"})
    public void Auto_SEVV_18328_TC_19200_Precondition_For_Claim_Validation(String client, String employee,
                                                       String serviceStartDate, String serviceEndDate,
                                                       String inTime, String outTime,
                                                       String procedureCode, String unitsRule, String matchingRule,
                                                       String overlapDuration, String vp, String succeedCount) throws IOException {


        boolean itemClientExists = false;
        boolean itemEmployeeExists = false;
        boolean isFirstRun = true;
        String clientCustom1;
        String clientId;
        String employeeCustom1;
        Map<String,String> clientInfo = new HashMap<>();
        Map<String, String> employeeInfo = new HashMap<>();


        if(!listEmployeeData.isEmpty()) {
            itemEmployeeExists = listEmployeeData.stream().anyMatch(c -> c.equals(employee.toLowerCase()));
            isFirstRun = false;
        }
        listEmployeeData.add(employee.toLowerCase());
        if(!itemEmployeeExists) {
            employeeInfo = createEmployees(employee.toLowerCase());
            employeeExisting = employeeInfo;
        }

        if(!listClientData.isEmpty()) {
            itemClientExists = listClientData.stream().anyMatch(c -> c.equals(client.toLowerCase()));
            isFirstRun = false;
        }
        listClientData.add(client.toLowerCase());
        if(!itemClientExists)
        {
            clientInfo = createClients(client.toLowerCase());
            clientExisting = clientInfo;
        }

        String memo = "ViClaim" + commons.generateRandomAlphaNumeric(40);
        String callIn = serviceStartDate + "T" + inTime + "Z";
        String callOut = serviceEndDate + "T" + outTime + "Z";

        clientCustom1 = clientExisting.get(client.toLowerCase() + "custom");
        clientId = clientExisting.get(client.toLowerCase());

        employeeCustom1 = employeeExisting.get(employee.toLowerCase() + "custom");
        //employeeId = employeeExisting.get(employee.toLowerCase());

        visitAPI = AltEvvVisitService.init(callIn, callOut, procedureCode, clientCustom1, employeeCustom1, memo);
        visitAPI.post();
        visitAPI.verifyPostStatus("SUCCESS");
//        commons.generateClaimValidationFile(state ,client, clientId,
//                "CSV_ClaimValidation_FirstDraft.csv", isFirstRun);
    }
}
