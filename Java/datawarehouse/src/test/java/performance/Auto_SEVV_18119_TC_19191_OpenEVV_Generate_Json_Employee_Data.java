package performance;

import com.interop.models.db.stx.STXEmployee;
import com.interop.services.openevv.OpenEvvEmployeeService;
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

import static com.interop.sql.EmployeeSQL.SQL_EMPLOYEE_WITH_ROW_NUM;
import static com.interop.sql.EmployeeSQL.SQL_GET_EMPLOYEES_GENERAL_LIST_NAME;

public class Auto_SEVV_18119_TC_19191_OpenEVV_Generate_Json_Employee_Data extends GenericTest {

    private static final int numberEmployee = 1000; //the count of employee want to import
    private static final int numberEmpGetList = 1000;
    private static final int numberGenerateFiles = 5;
    private static int no = 0;
    private static List<String> preFix = new ArrayList<>();
    private static List<String> fileNameList = new ArrayList<>();
    private static List<String> accountList = new ArrayList<>();
    private String testCaseId = "TC_19191";
    private OpenEvvEmployeeService employeeAPI = null;

    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {"60269", "Test@123456!", "Test@123456!", "LP1234567"},
                        {"60270", "Test@123456!", "Test@123456!", "8288564"},
                        {"60271", "Test@123456!", "Test@123456!", "LP1234506"},
                        {"60285", "Test@123456!", "Test@123456!", "110001138"},
                        {"60286", "Test@123456!", "Test@123456!", "110001139"},
                        {"60287", "Test@123456!", "Test@123456!", "110102124"},
                        {"60288", "Test@123456!", "Test@123456!", "110000936"},
                        {"60289", "Test@123456!", "Test@123456!", "110001038"},
                        {"60295", "Test@123456!", "Test@123456!", "110178924"},
                        {"60296", "Test@123456!", "Test@123456!", "110001389"},
                        {"60301", "Test@123456!", "Test@123456!", "LP007"},
                        {"60303", "Test@123456!", "Test@123456!", "201908290"},
                        {"60305", "Test@123456!", "Test@123456!", "201908297"},
                        {"60306", "Test@123456!", "Test@123456!", "201908299"},
                        {"60307", "Test@123456!", "Test@123456!", "201908295"},
                        {"60309", "Test@123456!", "Test@123456!", "201908298"},
                        {"end", "end", "end", "end"},

                };
    }

    @Test(dataProvider = "dataProvider")
    public void Auto_SEVV_18119_TC_19193_AltGeneric_Generate_Json_Employee_Data_Jmeter(String acc,
                                                                                       String user,
                                                                                       String pass,
                                                                                       String providerId) throws IOException {
        if (!acc.equals("end")) {
            String fName = "EmpPer" + RandomStringUtils.randomAlphabetic(10);
            LOGGER.info("fName -------------- " + fName);
            OpenEvvEmployeeService employeeAPI = OpenEvvEmployeeService.init(numberEmployee, fName, acc, user, pass, providerId);
            String body = employeeAPI.generateJsonData();
            //commons.generateJsonBody(body, fName + ".txt");
            String fileName = employeeAPI.getStateAccount().getAccountID() + "_EMP_" + fName + ".txt";
            commons.generateJsonBody(body, fileName);
            preFix.add(fName);
            fileNameList.add(fileName);
            accountList.add(employeeAPI.getStateAccount().getAccountID());
        } else {
            commons.generateToJmeterFilePerformanceTestingEmployee(preFix, fileNameList, accountList);
            preFix.clear();
            fileNameList.clear();
            accountList.clear();
        }
    }

    @Test(invocationCount = 1)
    public void Auto_SEVV_18119_TC_19191_OpenEVV_Generate_Json_Employee_Performance() throws IOException {

        String fName = "EmpPer" + RandomStringUtils.randomAlphabetic(10);
        LOGGER.info("fName -------------- " + fName);
        OpenEvvEmployeeService employeeAPI = OpenEvvEmployeeService.init(numberEmployee, fName, null, null, null, null);
        String body = employeeAPI.generateJsonData();
        Assert.assertTrue(body.contains("Account"), "Missing -DDefaultENVID parameter ");
        commons.generateJsonBody(body, fName + ".txt");
    }

    @Test()
    public void Auto_SEVV_18119_TC_19191_OpenEVV_Get_Employee_List() throws IOException {
        OpenEvvEmployeeService employeeAPI = OpenEvvEmployeeService.init();
        ColumnAnnotationMapper<STXEmployee> mapper = new ColumnAnnotationMapper<>(STXEmployee.class);
        String getQuery = String.format(SQL_EMPLOYEE_WITH_ROW_NUM, employeeAPI.getModels().get(0).getAccount(), numberEmpGetList);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), getQuery);
        List<STXEmployee> employees = mapper.DataTableMapper(rs);
        List<String> workerIdCustom1List = employees.stream().map(item -> item.EMPLOYEEIDCUSTOM1).collect(Collectors.toList());
        String workers = StringUtils.join(workerIdCustom1List, ",");
        commons.generateJsonBody(workers, "EmployeeCustom1.txt");
    }

    @Test(priority = 1)
    public void Auto_SEVV_18119_TC_19191_OpenEVV_Employee_Performance() {
        String postStatus = "SUCCESS";
        String expectedMessage = "";
        String uuidStatus = "";
        String uuidExpectedError = "";
        Assert.assertTrue(InitDataForTestCase(testCaseId), "Create table not successfully");
        String fNamePerformanceTesting = "Performance" + RandomStringUtils.randomAlphabetic(10);
        OpenEvvEmployeeService employeeAPI = OpenEvvEmployeeService.init(100, fNamePerformanceTesting, null, null, null, null);
        employeeAPI.post();
        employeeAPI.verifyPostStatus(postStatus);

        if (!StringUtils.isBlank(expectedMessage)) {

            if (employeeAPI.getResponse().statusCode() == 500) {
                Assert.assertTrue(false, "The status code is not 200");
            } else {
                employeeAPI.verifyMDWFailedWithMessageSummary("[1] Records uploaded, please check errors/warnings and try again.", expectedMessage);
            }
        }

        if (!StringUtils.isBlank(uuidStatus)) {
            employeeAPI.requestUUIDStatus();
            employeeAPI.verifyUUIDStatus(uuidStatus);
            if (!org.apache.commons.lang3.StringUtils.isBlank(uuidExpectedError)) {
                employeeAPI.verifyUUIDFailedWithErrorMessage("", uuidExpectedError);
            }
        }
        no++;
        StoreDataValidationForPerformance(testCaseId, employeeAPI.getModels(), employeeAPI.getModels().get(0).account);
    }

    @Test(enabled = false, priority = 2)
    public void Auto_SEVV_18119_TC_19191_OPEN_EVV_Validate_Data_From_DB() {
        int row = GetDataStore(testCaseId) - 1;
        String empFirstName = "";
        String empAccount = validateDataStore.get("Account_1");
        String empFirstNameList = "";
        //HashMap<String, String> listDataTest = new HashMap<String, String>();

        for (int i = 1; i <= row; i++) {
            //empDataTest = validateDataStore.get("DataTest_" + String.valueOf(i));
            //listDataTest.put("EmpFirstName_" + String.valueOf(i), empDataTest);
            empFirstName = validateDataStore.get("EmpFirstName_" + i);
            empFirstNameList += "'" + empFirstName + "'";
            if (i < row)
                empFirstNameList += ",";
        }

        ColumnAnnotationMapper<STXEmployee> mapper = new ColumnAnnotationMapper<>(STXEmployee.class);
        String getQuery = String.format(SQL_GET_EMPLOYEES_GENERAL_LIST_NAME, empFirstNameList, empAccount);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), getQuery);
        List<STXEmployee> employees = mapper.DataTableMapper(rs);
        List<String> listfname = employees.stream().map(item -> item.getEMPLOYEEFIRSTNAME()).collect(Collectors.toList());
        for (int i = 1; i <= row; i++) {
            empFirstName = validateDataStore.get("EmpFirstName_" + i);
            int j;
            for (j = 0; j < listfname.size(); j++) {
                if (empFirstName.equals(listfname.get(j))) {
                    LOGGER.info(empFirstName + " is inserted in db");
                    break;
                }
            }
            if (j == listfname.size())
                LOGGER.error(empFirstName + " is not inserted in db");
        }

        Assert.assertTrue(listfname.size() == 100, "Data are not inserted in db");
    }
}
