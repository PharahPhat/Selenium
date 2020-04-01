package com.sandata.ws;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.interop.common.Commons;
import com.sandata.core.config.Environment;
import com.sandata.core.config.TestConfiguration;
import com.sandata.core.config.TestContext;
import com.sandata.core.report.ExtentTestManager;
import com.sandata.core.ws.WebServicesBase;
import com.sandata.utils.JsonUtils;
import com.sandata.ws.dwh.DWHServices;
import org.apache.log4j.Logger;

public class GenericWebService extends WebServicesBase {
    private static final Logger LOGGER = Logger.getLogger(DWHServices.class);
    JsonUtils jsonUtils = new JsonUtils();
    public WebServicesBase webServicesBase = new WebServicesBase();
    public Commons commons = new Commons();

    public String getEnvironment(String envName) {
        return getTestEnvironment().get(envName);
    }

    public Environment getTestEnvironment() {
        return getTestConfig().getEnvironment();
    }

    public ExtentTest getExtentTest() {
        return ExtentTestManager.getTest();
    }

    public void logInfo(String message) {
        getExtentTest().info(message);
        LOGGER.info(message);
    }

    public synchronized void logFail(String message) {
        getExtentTest().fail("<b style='color:red;'>" + message + "");
        LOGGER.error(message);
    }

    public synchronized void logPass(String message) {
        getExtentTest().pass("<b style='color:green;'>" + message + "");
        LOGGER.info(message);
    }

    public synchronized void logError(String message) {
        getExtentTest().log(Status.ERROR, message);
        LOGGER.error(message);
    }

    public TestConfiguration getTestConfig() {
        return TestContext.get();
    }

    public String readDataValue(String variableName) {
        try {
            return getTestConfig().getTestData().getValue(variableName);
        } catch (NullPointerException exp) {
            return null;
        }
    }
}
