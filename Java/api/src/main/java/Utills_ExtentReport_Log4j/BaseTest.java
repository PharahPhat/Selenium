package Utills_ExtentReport_Log4j;

import Entity.TestCaseQTestModel;
import api.QTestAPI;
import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.GetStateConfig;
import com.globalMethods.core.globalVariables;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseTest
{
	private static final Logger LOGGER = Logger.getLogger(BaseTest.class);
	public static ExtentReports extent;
	public static ExtentTest logger ;
	private String timeStamp = CommonMethods.getTimeStamp();
	private static final String reportFolder = System.getProperty("user.dir") + File.separator +"TestResult";
	private static final String reportFileName = "Automation_API_Report";

	protected static Connection connection;
	private String testcaseID;
	private String testcaseIDQTest;
	protected static String fileNameProvider;
	private static QTestAPI qTestAPI;
	private static ZoneOffset zoneOffset = ZoneId.systemDefault().getRules().getOffset(LocalDateTime.now());
	private String startDateTime;
	private static String markPassedFlag = System.getProperty("update_QTest") != null ? System.getProperty("update_QTest") : "";
	private QTestAPI.STATUS flagToSetStatusTestCaseOnQTest = QTestAPI.STATUS.PASS;
	private TestCaseQTestModel testCaseQTestInfo;
	protected static String environment = System.getProperty("environment");
	protected static String state = System.getProperty("state");
	protected static Map<String, String> stateInfo = GetStateConfig.getStateInfo(environment, state);

	protected String openEVVUser = CommonMethods.propertyfileReader("OpenEvv_user");
	protected String openEVVPass = CommonMethods.propertyfileReader("OpenEvv_pass");
	protected String openEvvAcc =  globalVariables.Account;
	protected String openEVVAccId = CommonMethods.propertyfileReader("OpenEvv_AccId");

	protected String altEVVUser = CommonMethods.propertyfileReader("altevv_user");
	protected String altEVVPass = CommonMethods.propertyfileReader("altevv_pass");
	protected String altEvvAcc =  globalVariables.Account;
	protected String altEVVAccId = CommonMethods.propertyfileReader("altevv_accId");

	protected String altEVVUserV1 = CommonMethods.propertyfileReader("altevv_user_10010");
	protected String altEVVPassV1 = CommonMethods.propertyfileReader("altevv_pass_10010");
	protected String altEvvAccV1 =  globalVariables.Account;
	protected String altEVVAccIdV1 = CommonMethods.propertyfileReader("altevv_accId_10010");

	@BeforeSuite(alwaysRun = true)
	public synchronized void beforeSuite() throws ClassNotFoundException, InterruptedException, SQLException {
		// Access QTest and get all test cases if set update_QTest is TRUE
		LOGGER.info("Mark Passed On QTest = " + markPassedFlag);
		if (markPassedFlag.equals("TRUE")) {
			String userQTest = System.getProperty("userQTest");
			String passQTest = System.getProperty("passQTest");
			String url = System.getProperty("url");
			String projectName = System.getProperty("projectName");
			String parentModuleId = System.getProperty("parentModuleId");
			String moduleName = System.getProperty("moduleName");
			String testCycle = System.getProperty("testCycle");
			if (userQTest == null || passQTest == null || url == null || projectName == null
					|| parentModuleId == null || moduleName == null || testCycle == null) {
				Assert.fail(String.format("Environment variable(s) for QTest is NULL, please check again " +
						"userQTest=%spassQTest=%surl=%sprojectName=%sparentModuleId=%smoduleName=%s",
						userQTest, passQTest, url, projectName, parentModuleId, moduleName));
			}
			qTestAPI = new QTestAPI(userQTest, passQTest, url, projectName, testCycle, parentModuleId, moduleName);
			// get All Test Cases on qTest corresponding to value in TC no field
			qTestAPI.getAllTestCasesInfoByOldIds("TC no");
		}

		connection=CommonMethods.CreateConnection();
		CommonMethods.deleteAllFilesInDirectory(globalVariables.genericfileProvider); // failed when read this line
		fileNameProvider =globalVariables.genericfileProvider+"Provider_Account_"+environment+"_"+timeStamp+".csv";
        extent = new ExtentReports (getFileLocationBasedOnPlatform(), true);
        extent.addSystemInfo("Environment", environment)
                .addSystemInfo("User Name", "Automation KMS - InterOps Payer");
	}

	@BeforeTest(alwaysRun = true)
	public synchronized void beforeTest(ITestContext testContext) {
		String interFace = System.getProperty("Client");
		String api = System.getProperty("API");
		if (testContext.getCurrentXmlTest().getParallel().isParallel()) {
			System.out.println(System.getProperty("threadCount"));
			int threadCount = System.getProperty("threadCount") != null ?
					Integer.parseInt(System.getProperty("threadCount")) : testContext.getCurrentXmlTest().getThreadCount();
            testContext.getCurrentXmlTest().setThreadCount(threadCount);
        }

		if (interFace != null && api != null && !testContext.getCurrentXmlTest().getXmlPackages().isEmpty()
				&& markPassedFlag.equals("TRUE")) {
			for (XmlPackage xmlPackage : testContext.getCurrentXmlTest().getXmlPackages()) {
				String suiteName = xmlPackage.getName();
				qTestAPI.createTestSuiteFromCycle(suiteName);
				LOGGER.info(suiteName);
			}
		}
	}
	
	@BeforeMethod(alwaysRun = true)
	public synchronized void beforeMethod(Method method) {
		String testCaseName = method.getName();
		LOGGER.info("******************* START TEST CASE - " + testCaseName + " - *******************");
		Pattern p = Pattern.compile("TC\\d{1,6}");
		Matcher m = p.matcher(testCaseName);
		if (m.find()) {
			testcaseID = m.group(0);
		}
		logger = new ExtentTest(testcaseID, "");
	}

	/**
	 * Get Test Case ID of test script run
	 */
	@BeforeClass(alwaysRun = true)
	public synchronized void beforeClass() {
		startDateTime = OffsetDateTime.now(zoneOffset).toString();
		String testCaseName = this.getClass().getSimpleName();
		LOGGER.info("******************* START TEST CLASS - " + testCaseName + " - *******************");
		Pattern p = Pattern.compile("TC\\d{1,6}");
		Matcher m = p.matcher(testCaseName);
		if (m.find()) {
			p = Pattern.compile("\\d{1,6}");
			m = p.matcher(m.group(0));
			if (m.find()) {
				testcaseIDQTest = m.group(0);
			}
		} else {
			Assert.fail("Could NOT find test case id in class name: " + testCaseName);
		}

		// update test case on QTest if set update_QTest is TRUE
		if (markPassedFlag.equals("TRUE")) {
			boolean isExistingTestCaseIdOnQTest = qTestAPI.getTestCasesInfo().containsKey(testcaseIDQTest);
			// skip class if not find test case id on QTest
			if (!isExistingTestCaseIdOnQTest) {
				LOGGER.info("Could NOT find old test case id " + testcaseIDQTest + " on QTest. So skipping run tests in this class");
				throw new SkipException("Could NOT find old test case id on QTest");
			}
			// update automation content field with class name
			else {
				String packageName = this.getClass().getPackage().getName();
				// create test run
				testCaseQTestInfo = qTestAPI.getTestCasesInfo().get(testcaseIDQTest);
				qTestAPI.createTestRunInTestSuite(packageName, testCaseQTestInfo);
				qTestAPI.updateFieldAutomationContentOfTestCase(this.getClass().getName(), testCaseQTestInfo.getId());
			}
		}
	}

	@AfterClass(alwaysRun = true)
	public synchronized void afterClass() {
		// update Status of Test Case on QTest if set update_QTest is TRUE
		try {
			if (markPassedFlag.equals("TRUE")) {
				String endDateTime = OffsetDateTime.now(zoneOffset).toString();
				if (flagToSetStatusTestCaseOnQTest.equals(QTestAPI.STATUS.PASS)) {
					qTestAPI.addTestLog(testCaseQTestInfo, QTestAPI.STATUS.PASS.toString(), startDateTime, endDateTime);
				}
				else {
					if (flagToSetStatusTestCaseOnQTest.equals(QTestAPI.STATUS.FAIL)) {
						qTestAPI.addTestLog(testCaseQTestInfo, QTestAPI.STATUS.FAIL.toString(), startDateTime, endDateTime);
					}
					else {
						qTestAPI.addTestLog(testCaseQTestInfo, QTestAPI.STATUS.SKIP.toString(), startDateTime, endDateTime);
					}
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
			logger.log(LogStatus.INFO, "Test Failed but not marked in QTest - markPassedFlag variable probably NULL");
		}
		String testCaseName = this.getClass().getSimpleName();
		LOGGER.info("******************* END TEST CLASS - " + testCaseName + " - *******************");
	}

	/**
	 * Log the result after the method is run
	 */
	@AfterMethod (alwaysRun = true)
	public synchronized void afterMethod(ITestResult result, Method method){
		if (result.getStatus() == ITestResult.FAILURE) {
//			logger.log(LogStatus.FAIL, result.getThrowable());
			// set flag of test case status on qTest
			flagToSetStatusTestCaseOnQTest = QTestAPI.STATUS.FAIL;
		} else if (result.getStatus() == ITestResult.SKIP || result.getStatus() == -1) {
//			logger.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
			flagToSetStatusTestCaseOnQTest = QTestAPI.STATUS.SKIP;
		} /*else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, result.getMethod().getMethodName());
		} else {
			logger.log(LogStatus.WARNING, "Test threw a warning " + result.getThrowable());
		}
		extent.endTest(logger);
		extent.flush();*/
		LOGGER.info("******************* END TEST CASE - " + method.getName() + " - *******************");
	}

	@AfterSuite(alwaysRun = true)
	public synchronized void afterSuite() throws SQLException
	{
		LOGGER.info("------------------	@AfterSuite fired -----------------------");
		if (connection != null) {
			connection.close();
		}
		/*try {
			FileUtils.copyFile(new File(reportFilePath),
					new File(reportFolder + File.separator + reportFileName + ".html"));
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}*/
	}

	/**
	 * Create Result Folder if not yet
	 */
	private static void createReportPath() {
		File testDirectory = new File(reportFolder);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				LOGGER.info(String.format("Directory: %s is created.", reportFolder));
			}
		} else {
			LOGGER.info("Directory already exists");
		}
	}

	/**
	 * Create File Report
	 * @return Path of Report file
	 */
	private static String getFileLocationBasedOnPlatform() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yy-HH_mm_ss");
		String ts = sdf.format(new Date());
		String path = reportFolder + File.separator + reportFileName + "_" + ts +".html";
		createReportPath();
		return path;
	}
}