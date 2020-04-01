package Utills_ExtentReport_Log4j;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlSuite;

import com.globalMethods.core.CommonMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG  implements IReporter{
	private static final Logger LOGGER = Logger.getLogger(ExtentReporterNG.class);
	private ExtentReports extent;
	private static final String reportFolder = System.getProperty("user.dir") + File.separator +"TestResult";
	private static final String reportFileName = "Automation_API_Report";
	private static String reportFilePath;

	@BeforeTest(alwaysRun = true)
	public synchronized void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		extent = new ExtentReports(getFileLocationBasedOnPlatform(), true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		extent.flush();
		extent.close();

		try {
			FileUtils.copyFile(new File(reportFilePath),
					new File(reportFolder + File.separator + reportFileName + ".html"));
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	private synchronized void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		
		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}

				extent.endTest(test);
			}
		}
	}

	private synchronized Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
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
		reportFilePath = path;
		createReportPath();
		return path;
	}
}