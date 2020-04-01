package api;

import Entity.TestCaseQTestModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QTestAPI extends Base {
    private String url;
    private String projectId;
    private String releaseId;
    private String testCycleId;
    private String moduleId;
    private Map<String, String> testSuiteId = new HashMap<>();
    private Map<String, TestCaseQTestModel> testCasesInfo;
    private static final String TESTCASE_VERSION_ID = "test_case_version_id";
    private static final String TESTCASE = "test_case";
    private static final String MESSAGE_TEST_RUN_ERROR = "Create/Get Test Run ERROR";

    /**
     * Case: test cases are in a parent module, then creating test cycle and test run if not have unless updating existing test runs in cycle
     * @param username username on qTest
     * @param password password to qTest
     * @param url URL points to server qTest
     */
    public QTestAPI(String username, String password, String url, String projectName,
                    String parentModule, String moduleName) {
        this.url = url;
        loginToqTest(username, password, this.url + PathAPI.getLOGINPATH());
        getProjectId(projectName);
        createTestCycle(moduleName + " Cycle");
        getModuleId(parentModule, moduleName);
    }

    /**
     *
     * @param username
     * @param password
     * @param url
     * @param projectName
     * @param releaseName
     * @param cycleName
     * @param parentModule
     * @param moduleName
     */
    public QTestAPI(String username, String password, String url, String projectName,
                    String cycleName, String parentModule, String moduleName) {
        this.url = url;
        loginToqTest(username, password, this.url + PathAPI.getLOGINPATH());
        getProjectId(projectName);
        createTestCycle(cycleName);
        getModuleId(parentModule, moduleName);
    }

    /**
     * Get Project ID from Project Name
     * @param projectName Project Name
     */
    private void getProjectId(String projectName) {
        String res = getResponse(url + PathAPI.getPROJECTSPATH());
        projectId = getId(res, projectName);
        Assert.assertNotNull(projectId, "Could not find Project: " + projectName);
    }

    /**
     * Get Release ID from Release Name
     * @param releaseName Release Name
     */
    private void getReleaseId(String releaseName) {
        String res = getResponse(url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getRELEASESPATH(), projectId));
        releaseId = getId(res, releaseName);
        Assert.assertNotNull(releaseId, "Could not find Release: " + releaseName);
    }

    /**
     * Get Module containing all test cases need to be automated
     * @param parentModuleId parent module containing module containing test cases
     * @param moduleName module name containing test cases
     */
    private void getModuleId(String parentModuleId, String moduleName) {
        String res = getResponse(url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getMODULESPATH(), projectId, parentModuleId));
        moduleId = getId(res, moduleName);
        Assert.assertNotNull(moduleId, "Could not find module: " + moduleName + "in parent module " + parentModuleId);
    }

    /**
     * Get Test Cycle ID from Cycle Name
     * @param cycleName Cycle Name
     */
    private void getTestCycleId(String cycleName) {
        String res = getResponseIgnoreStatus(this.url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getTESTCYCLESPATH(), projectId, releaseId));
        testCycleId = getId(res, cycleName);
        Assert.assertNotNull(testCycleId, "Could not find Test Cycle: " + cycleName);
    }

    /**
     * Create Test Cycle if not have
     * @param cycleName Cycle Name
     */
    public void createTestCycle(String cycleName) {
        String res = getResponseIgnoreStatus(this.url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getCREATETESTCYCLESPATH(), projectId));
        if (getId(res, cycleName) != null) {
            testCycleId = getId(res, cycleName);
        }
        else {
            String body = null;
            try {
                body = new JSONObject()
                        .put("name", cycleName)
                        .put("description", "Automation generated").toString();
            } catch (JSONException e) {
                Assert.fail("Failed when create Json data body for test cycle", e.fillInStackTrace());
            }
            res = postResponse(this.url + PathAPI.getPROJECTSPATH() +
                    String.format(PathAPI.getCREATETESTCYCLESPATH(), projectId), body);
            try {
                JSONObject jsonObject = new JSONObject(res);
                testCycleId = jsonObject.getString("id");
            } catch (JSONException e) {
                Assert.fail("Failed when get test cycle Id from response", e.fillInStackTrace());
            }
        }
        Assert.assertNotNull(testCycleId, "Could not find Test Cycle: " + cycleName);
    }


    /**
     * Create New Test Run from Test Case Id
     * @param testCaseInfo info include test case id on qTest, test case id on old system and test case version id
     * @return Test Run Id
     */
    private String createNewTestRun(TestCaseQTestModel testCaseInfo) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = new JSONObject()
                    .put("name", testCaseInfo.getTestCaseName())
                    .put(TESTCASE_VERSION_ID, testCaseInfo.getTestCaseVersionId())
                    .put(TESTCASE, new JSONObject().put("id", testCaseInfo.getId()));

        } catch (JSONException e) {
            Assert.fail("Failed when create json data body for new test run", e.fillInStackTrace());
        }
        String body = jsonObject.toString();
        String res = postResponse(this.url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getCREATETESTRUNPATH(), projectId, testCycleId), body);
        try {
            JSONObject json = new JSONObject(res);
            return json.getString("id");
        } catch (JSONException e) {
            Assert.fail("Failed when get test run Id from response", e.fillInStackTrace());
        }
        return null;
    }

    /**
     * Create New Test Run In Test Suite from Test Case Id
     * @param testCaseInfo info include test case id on qTest, test case id on old system and test case version id
     * @return Test Run Id
     */
    private String createNewTestRunInTestSuite(String suiteName, TestCaseQTestModel testCaseInfo) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = new JSONObject()
                    .put("name", testCaseInfo.getTestCaseName())
                    .put(TESTCASE_VERSION_ID, testCaseInfo.getTestCaseVersionId())
                    .put(TESTCASE, new JSONObject().put("id", testCaseInfo.getId()));

        } catch (JSONException e) {
            Assert.fail("Failed when create json data body for new test run", e.fillInStackTrace());
        }
        String body = jsonObject.toString();
        String res = postResponse(this.url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getTESTRUNFROMTESTSUITEPATH(), projectId, testSuiteId.get(suiteName)), body);
        try {
            JSONObject json = new JSONObject(res);
            return json.getString("id");
        } catch (JSONException e) {
            Assert.fail("Failed when get test run Id from response", e.fillInStackTrace());
        }
        return null;
    }

    /**
     * Get Test Run Id in a test cycle if not have, creating new test run for test case
     * @param testCaseInfo info include test case id on qTest, test case id on old system and test case version id
     * @return testCaseInfo above but added Test Run Id
     */
    public TestCaseQTestModel createTestRun(TestCaseQTestModel testCaseInfo) {
        if (testCaseInfo != null) {
            String res = getResponse(this.url + PathAPI.getPROJECTSPATH() +
                    String.format(PathAPI.getCREATETESTRUNPATH(), projectId, testCycleId));
            String testCaseId = testCaseInfo.getId();
            String id;
            try {
                JSONArray jsonArray = new JSONArray(res);
                for (int i=0;i<jsonArray.length();i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String tcId = jsonObject.getJSONObject(TESTCASE).getString("id");
                    if (testCaseId.equalsIgnoreCase(tcId)) {
                        id = jsonObject.getString("id");
                        testCaseInfo.setTestRunId(id);
                        return testCaseInfo;
                    }
                }
                id = createNewTestRun(testCaseInfo);
                testCaseInfo.setTestRunId(id);
                return testCaseInfo;

            } catch (JSONException e) {
                Assert.fail(MESSAGE_TEST_RUN_ERROR, e.fillInStackTrace());
            }
        }
        return null;
    }

    /**
     * Get Test Run Id in a test cycle if not have, creating new test run for test case
     * @param testCaseInfo info include test case id on qTest, test case id on old system and test case version id
     * @return testCaseInfo above but added Test Run Id
     */
    public TestCaseQTestModel createTestRunInTestSuite(String suiteName, TestCaseQTestModel testCaseInfo) {
        if (testSuiteId.isEmpty()) {
            Assert.fail("Could NOT get Test Suite, maybe you run single test case and set MARK_PASS = TRUE");
        }
        if (testCaseInfo != null) {
            String res = getResponse(this.url + PathAPI.getPROJECTSPATH() +
                    String.format(PathAPI.getTESTRUNFROMTESTSUITEPATH(), projectId, testSuiteId.get(suiteName)));
            String testCaseId = testCaseInfo.getId();
            String id;
            try {
                JSONArray jsonArray = new JSONArray(res);
                for (int i=0;i<jsonArray.length();i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String tcId = jsonObject.getJSONObject(TESTCASE).getString("id");
                    if (testCaseId.equalsIgnoreCase(tcId)) {
                        id = jsonObject.getString("id");
                        testCaseInfo.setTestRunId(id);
                        return testCaseInfo;
                    }
                }
                id = createNewTestRunInTestSuite(suiteName, testCaseInfo);
                testCaseInfo.setTestRunId(id);
                return testCaseInfo;

            } catch (JSONException e) {
                Assert.fail(MESSAGE_TEST_RUN_ERROR, e.fillInStackTrace());
            }
        }
        Assert.fail(MESSAGE_TEST_RUN_ERROR);
        return null;
    }

    /**
     * Get List of Test Suite Names from Test Cycle
     * @return List of Test Suite Names
     */
    private Map<String, String> getTestSuiteNamesFromCycle() {
        String res = getResponse(this.url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getTESTSUITESFROMCYCLEPATH(), projectId, testCycleId));
        JSONArray jsonArray;
        Map<String, String> map = new HashMap<>();
        try {
            jsonArray = new JSONArray(res);
            Assert.assertNotNull(jsonArray);
            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                map.put(jsonObject.getString("name"), jsonObject.getString("id"));
            }
        } catch (JSONException e) {
            Assert.fail("Get Test Suite Names ERROR" + res);
        }
        return map;
    }


    /**
     * Create Suite with parent test cycle
     * @param suiteName suite name need to be created
     */
    public void createTestSuiteFromCycle(String suiteName) {
        if (!isExistingTestSuite(suiteName)) {
            String body = null;
            try {
                body = new JSONObject().put("name", suiteName).toString();
            } catch (JSONException e) {
                Assert.fail("Create Test Suite From Cycle ERROR " + suiteName);
            }
            testSuiteId.put(suiteName, getId(postResponse(this.url + PathAPI.getPROJECTSPATH() +
                    String.format(PathAPI.getTESTSUITESFROMCYCLEPATH(), projectId, testCycleId), body)));
        }
        Assert.assertFalse(testSuiteId.isEmpty(), "Created test suite unsuccessfully");
    }

    /**
     * Check existing test suite
     * @param suiteName suite name
     * @return TRUE if existing test suite, otherwise FALSE
     */
    private boolean isExistingTestSuite(String suiteName) {
        Map<String, String> listName = getTestSuiteNamesFromCycle();
        if (listName.containsKey(suiteName)) {
            testSuiteId.put(suiteName, listName.get(suiteName));
            return true;
        }
        return false;
    }

    /**
     * List of Test Suite IDs from Release
     * @return List of Test Suite IDs
     */
    private List<String> getTestSuiteIdFromRelease() {
        String res = getResponse(this.url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getTESTSUITESFROMRELEASEPATH(), projectId, testCycleId));
        return getListId(res);
    }

    /**
     * Get Test Run ID by Test Run Name from Test Cycle
     * @param testRunName Test Run Name
     * @return Test Run ID
     */
    private String getTestRunIdFromCycle(String testRunName) {
        String res = getResponse(this.url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getTESTRUNFROMCYCLEPATH(), projectId, testCycleId));
        return getId(res, testRunName);
    }

    /**
     * Get Test Run ID by Test Run Name from List of Test Suite IDs
     * @param suiteIds List of Test Suite IDs
     * @param testRunName Test Run Name
     * @return Test Run ID
     */
    private String getTestRunIdFromTestSuite(List<String> suiteIds, String testRunName) {
        String testRunId;
        for (String id : suiteIds) {
            String res = getResponse(this.url + PathAPI.getPROJECTSPATH() +
                    String.format(PathAPI.getTESTRUNFROMTESTSUITEPATH(), projectId, id));
            testRunId = getId(res, testRunName);
            if (testRunId != null) {
                return testRunId;
            }
        }
        Assert.fail("Could NOT find test run by name: " + testRunName);
        return null;
    }

    /**
     * Add Test Log after executing
     * @param testCaseInfo info include test case id on qTest, test case id on old system, test run id created
     *                     and test case version id
     * @param status Status (PASS/FAIL/SKIP)
     * @param startDateTime start date time of execution, following format as ex. 2019-07-03T10:05:19.876+07:00
     * @param endDateTime end date time of execution, following format as ex. 2019-07-03T10:05:19.876+07:00
     */
    public void addTestLog(TestCaseQTestModel testCaseInfo, String status, String startDateTime, String endDateTime) {
        if (testCaseInfo != null) {
            // approve test case
            approveTestCase(testCaseInfo.getId());

            String testRunId = testCaseInfo.getTestRunId();
            String testRunRel = this.url + PathAPI.getPROJECTSPATH() +
                    String.format(PathAPI.getTESTRUNPATH(), projectId, testRunId);
            String versionTestCase = testCaseInfo.getTestCaseVersionId();

            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject
                        .put("exe_start_date", startDateTime)
                        .put("exe_end_date", endDateTime)
                        .put(TESTCASE_VERSION_ID, versionTestCase)
                        .put("status", new JSONObject().put("id", getStatusId(status))
                                .put("is_default", true).put("active", true));
            } catch (JSONException e) {
                Assert.fail("Failed when create json data for Add Test Log", e.fillInStackTrace());
            }
            Assert.assertNotNull(jsonObject, "Body of test log is null");
            postResponse(testRunRel + PathAPI.getTESTLOGPATH(), jsonObject.toString());
        }
        else {
            Assert.fail("Test Case Info is NULL when add test log");
        }
    }

    /**
     * Using when need to get all test case IDs in a module
     */
    public void getAllTestCasesInfoByOldIds(String fieldName) {
        String res1 = getResponse(url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getMODULESPATH(), projectId, moduleId));
        testCasesInfo = new HashMap<>();
        if (!res1.equals("[]")) {
            JSONArray array;
            try {
                array = new JSONArray(res1);
                for (int i=0;i<array.length();i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    String id = jsonObject.getString("id");
                    getAllTestCaseUnderSuite(id, fieldName);
                }
            } catch (JSONException e) {
                Assert.fail("Data is incorrect", e.fillInStackTrace());
            }
        }
        getAllTestCaseUnderSuite(moduleId, fieldName);
        Assert.assertFalse(testCasesInfo.isEmpty(), "Could NOT find any test case id");
    }

    private void getAllTestCaseUnderSuite(String moduleId, String fieldName) {
        String res = getResponse(this.url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getTESTCACESPATH(), projectId, moduleId));
        if (!res.equals("[]")) {
            JSONArray rootArray;
            try {
                rootArray = new JSONArray(res);
                for (int i=0;i<rootArray.length();i++) {
                    JSONObject jsonObject = rootArray.getJSONObject(i);
                    JSONArray properties = jsonObject.getJSONArray("properties");
                    for (int j=0;j<properties.length();j++) {
                        String field = properties.getJSONObject(j).getString("field_name");
                        if (field.equalsIgnoreCase(fieldName)) {
                            String testCaseId = jsonObject.getString("id");
                            String value = properties.getJSONObject(j).getString("field_value");
                            if (!value.equals("")) {
                                TestCaseQTestModel testCaseInfo = new TestCaseQTestModel();
                                testCaseInfo.setId(testCaseId);
                                testCaseInfo.setTestCaseName(jsonObject.getString("name"));
                                testCaseInfo.setTestCaseVersionId(jsonObject.getString(TESTCASE_VERSION_ID));
                                testCasesInfo.put(value, testCaseInfo);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                Assert.fail("Data is incorrect", e.fillInStackTrace());
            }
        }
    }


    /**
     * Update value for Automation Content field on qTest
     * @param value value need to update
     * @param testCaseId test case id
     */
    public void updateFieldAutomationContentOfTestCase(String value, String testCaseId) {
        String res = getResponse(this.url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getTESTCACEPATH(), projectId, testCaseId));
        JSONObject jsonObject;
        JSONObject updateJson = new JSONObject();
        try {
            jsonObject = new JSONObject(res);
            updateJson.put("id", jsonObject.getString("id"))
                    .put("properties", new JSONArray()
                            .put(new JSONObject()
                                    .put("field_id", getIdOfTestCaseFieldByName("Automation Content"))
                                    .put("field_value", value)));
            putResponse(this.url + PathAPI.getPROJECTSPATH() +
                    String.format(PathAPI.getTESTCACEPATH(), projectId, testCaseId), updateJson.toString());

        } catch (JSONException e) {
            Assert.fail("Failed when Updating Automation Content Field", e.fillInStackTrace());
        }
    }

    /**
     * Get Id of a field in test case
     * @param fieldName Field Name defined in Test Case Setting
     * @return Id
     */
    private int getIdOfTestCaseFieldByName(String fieldName) {
        String res = getResponse(this.url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getTESTCASEFIELD(), projectId));
        try {
            JSONArray jsonArray = new JSONArray(res);
            for (int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String label = jsonObject.getString("label");
                if (fieldName.equalsIgnoreCase(label)) {
                    return jsonObject.getInt("id");
                }
            }
        } catch (JSONException e) {
            Assert.fail("Failed when get Id Field of " + fieldName, e.fillInStackTrace());
        }
        Assert.fail("Could NOT find field name " + fieldName);
        return -1;
    }

    /**
     * Approve Test Case
     * @param testCaseId Test Case Id on QTest
     */
    private void approveTestCase(String testCaseId) {
        String res = getResponse(this.url + PathAPI.getPROJECTSPATH() +
                String.format(PathAPI.getTESTCACEPATH(), projectId, testCaseId));
        try {
            String body = new JSONObject(res).toString();
            putResponse(this.url + PathAPI.getPROJECTSPATH() +
                    String.format(PathAPI.getAPPROVETESTCACEPATH(), projectId, testCaseId), body);
        } catch (JSONException e) {
            Assert.fail("Approve Test Case Failed", e.fillInStackTrace());
        }
    }

    /**
     * Convert Status to ID
     * @param status Status
     * @return Status ID
     */
    private int getStatusId(String status) {
        switch (status) {
            case "PASS":
                return 601;
            case "FAIL":
                return 602;
            case "SKIP":
                return 605;
            default:
                Assert.fail("Value of status should be PASS/FAIL/SKIP");
                break;
        }
        return 603;
    }

    /**
     * Set ENUM of status
     */
    public enum STATUS {
        PASS,
        FAIL,
        SKIP
    }

    public Map<String, TestCaseQTestModel> getTestCasesInfo() {
        return testCasesInfo;
    }
}
