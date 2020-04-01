package config.influx.db;

import org.influxdb.dto.Point;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.globalVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ExecutionListener implements ITestListener {
	public synchronized void onTestStart(ITestResult iTestResult) {

	}

	public synchronized void onTestSuccess(ITestResult iTestResult) {

		this.sendTestStatusForCount(iTestResult, "PASS");
	}

	public synchronized void onTestFailure(ITestResult iTestResult) {

		this.sendTestStatusForCount(iTestResult, "FAIL");
	}

	public synchronized void onTestSkipped(ITestResult iTestResult) {

		this.sendTestStatusForCount(iTestResult, "SKIPPED");
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	public synchronized void onStart(ITestContext iTestContext) {

	}

	public synchronized void onFinish(ITestContext iTestContext) {
		Set<ITestResult> failedTests = iTestContext.getSkippedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (iTestContext.getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
			} else if (iTestContext.getPassedTests().getResults(method).size() > 0) {
				failedTests.remove(temp);
			} else if (iTestContext.getSkippedTests().getResults(method).size() > 0) {
				failedTests.remove(temp);
			}
		}
		for (int i = 0; i < iTestContext.getAllTestMethods().length; i++) {
			if (iTestContext.getAllTestMethods()[i].getCurrentInvocationCount() == 4) {
				if (iTestContext.getFailedTests().getResults(iTestContext.getAllTestMethods()[i]).size() == 4
						|| iTestContext.getPassedTests().getResults(iTestContext.getAllTestMethods()[i]).size() == 1) {

					iTestContext.getFailedTests().removeResult(iTestContext.getAllTestMethods()[i]);

				}
			}
		}
		this.sendTestClassStatus(iTestContext);
		this.sendAccountNumber();
	}

	private synchronized void sendTestClassStatus(ITestContext iTestContext) {
		Point point = Point.measurement("Results_interop").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
				.tag("client", System.getProperty("client")).tag("api", System.getProperty("api"))
				.tag("environment", System.getProperty("environment"))
				.addField("duration", (iTestContext.getEndDate().getTime() - iTestContext.getStartDate().getTime()))
				.addField("Total", iTestContext.getAllTestMethods().length)
				.addField("Pass", iTestContext.getPassedTests().size())
				.addField("Fail", iTestContext.getFailedTests().size())
				.addField("Skip", iTestContext.getSkippedTests().size()).build();
		ResultSender.send(point);
	}

	private synchronized void sendTestStatusForCount(ITestResult iTestResult, String status) {
		Point point = Point.measurement("getCount_interop").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
				.tag("name", iTestResult.getName()).tag("status", status).tag("client", System.getProperty("client"))
				.tag("api", System.getProperty("api")).tag("environment", System.getProperty("environment"))
				.addField("name", iTestResult.getName()).build();
		ResultSender.send(point);
	}
	private synchronized  void sendAccountNumber() {
		List<String> rowdata =  new ArrayList<String>();
		if (System.getProperty("api").equalsIgnoreCase("provider")) {
		rowdata =CommonMethods.readCSVFile(globalVariables.genericfileProvider+CommonMethods.getFileNameInFolder(globalVariables.genericfileProvider).get(0));
/*
		for (String account : rowdata){
			Point point = Point.measurement("account_Number_Provider").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)				
					.tag("environment", System.getProperty("environment"))
			         .addField("accountNo", account)
					.addField("environment", System.getProperty("environment"))
					.build();
			 ResultSender.send(point);
		}
*/
		}
	}
}
