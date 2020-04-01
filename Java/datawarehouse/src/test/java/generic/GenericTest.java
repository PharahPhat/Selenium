package generic;

import com.google.gson.Gson;
import com.interop.common.Commons;
import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.models.openevv.client.OpenEvvClient;
import com.interop.models.openevv.employee.OpenEvvEmployee;
import com.sandata.core.BaseTest;
import com.sandata.core.ws.WebServicesBase;
import com.sandata.db.*;
import com.sandata.models.dwh.ohio.DwhExtract;
import com.sandata.ws.ClientWebService;
import com.sandata.ws.EmployeeWebService;
import com.sandata.ws.VisitWebService;
import com.sandata.ws.claim.validation.ClaimService;
import com.sandata.ws.dwh.DWHServices;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;

public class GenericTest extends BaseTest {

    public String getTestType() {
        return "api";
    }

    public List<String> exportedFileNames;
    public Commons commons = new Commons();

    public DWHServices dwhServices = new DWHServices();
    public WebServicesBase webServicesBase = new WebServicesBase();
    public GenerateJsonData generateJsonData = new GenerateJsonData();

    public EmployeeWebService employeeWebService = new EmployeeWebService();
    public ClientWebService clientWebService = new ClientWebService();
    public VisitWebService visitWebService = new VisitWebService();

    public VisitDbService visitDbService = new VisitDbService();
    public ClientDbService clientDbService = new ClientDbService();
    public EmployeeDbService employeeDbService = new EmployeeDbService();
    public ClaimService claimService = new ClaimService();
    public ProviderDbService providerDbService = new ProviderDbService();

    public Map<String, String> validateDataStore = new HashMap<>();

    public StateAccount stateAccount = StateAccount.loadStateAccount();
    public String state = stateAccount.getStateName();

    public void cleanUpExportedFile() {
        if ( exportedFileNames == null || exportedFileNames.size() == 0 ) {
            return;
        }
        commons.deleteSftpFiles(baseObj.getEnvironment("sftpHost"),
                Integer.parseInt(baseObj.getEnvironment("sftpPort")),
                baseObj.getEnvironment("sftpUserName"),
                baseObj.getEnvironment("sftpPassword"),
                baseObj.getEnvironment("swarm_export_dwh"),
                exportedFileNames, 100);
    }

    //@AfterMethod
    public void cleanUp() {
        cleanUpExportedFile();
    }

    @AfterSuite(alwaysRun = true)
    void closeDBConnection() throws SQLException {
        TestDataHelper.closeDBConnections();
    }

    public boolean InitDataForTestCase(String testcaseId) {
        try {
            PreconditionDbService.createTableData(testcaseId);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean SaveDataForTestCase(String testcaseId, String field, String value) {
        try {
            PreconditionDbService.insertDataRows(testcaseId, field, value);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public void StoreDataValidation(int no, String tcId, String firstName, String lastName, String dataTest, String account) {
        Assert.assertTrue(SaveDataForTestCase(tcId, "EmpFirstName_" + no, firstName));
        Assert.assertTrue(SaveDataForTestCase(tcId, "EmpLastName_" + no, lastName));
        Assert.assertTrue(SaveDataForTestCase(tcId, "DataTest_" + no, dataTest));
        Assert.assertTrue(SaveDataForTestCase(tcId, "Account_" + no, account));
    }

    public void StoreDataValidationForPerformanceClient(String tcId, List<OpenEvvClient> clients, String account){
        for(int i=1; i<= clients.size(); i++) {
            String fName = clients.get(i-1).getClientFirstName();
            Assert.assertTrue(SaveDataForTestCase(tcId, "ClientFirstName_" + i, fName));
        }
        Assert.assertTrue(SaveDataForTestCase(tcId, "Account_" + 1, account));
    }

    public void StoreDataValidationForPerformance(String tcId, List<OpenEvvEmployee> employees, String account) {
        for (int i = 1; i <= employees.size(); i++) {
            String fName = employees.get(i - 1).getEmployeeFirstName();
            Assert.assertTrue(SaveDataForTestCase(tcId, "EmpFirstName_" + i, fName));
        }

        Assert.assertTrue(SaveDataForTestCase(tcId, "Account_" + 1, account));
    }

    public int GetDataStore(String testcaseId) {
        try {
            validateDataStore = PreconditionDbService.getResult(testcaseId);
        } catch (Exception ex) {
            return -1;
        }
        return validateDataStore.size();
    }

    public DwhExtract getDataOhioExported(String fileName){
        String bodyString = commons.readLineByLineJava8(System.getProperty("user.dir") + "/" + DOWNLOAD_FOLDER + "/" + fileName);
        Gson gson = new Gson();
        DwhExtract[] exportedFiles = gson.fromJson(bodyString, DwhExtract[].class);
        return exportedFiles[0];
    }
}
