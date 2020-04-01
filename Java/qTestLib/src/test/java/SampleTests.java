import Entity.TestCaseQTestModel;
import api.QTestAPI;
import api.QTest;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Map;

public class SampleTests {
    private QTestAPI opsAPI;
    @BeforeClass
    public void beforeClass() {
        String userQTest = System.getProperty("userQTest");
        String passQTest = System.getProperty("passQTest");
        String url = System.getProperty("url");
        String projectName = System.getProperty("projectName");
        String testCycle = System.getProperty("testCycle");
        String parentModuleId = System.getProperty("parentModuleId");
        String moduleName = System.getProperty("moduleName");
        if (userQTest == null || passQTest == null || url == null || projectName == null ||testCycle == null
                || parentModuleId == null || moduleName == null) {
            Assert.fail(String.format("Environment variable(s) for QTest is NULL, please check again " +
                            "userQTest=%spassQTest=%surl=%sprojectName=%stestCycle=%sparentModuleId=%smoduleName=%s",
                    userQTest, passQTest, url, projectName, testCycle, parentModuleId, moduleName));
        }
    }

    @Test
    public void verifyUpdateTestCase() {
        opsAPI.getAllTestCasesInfoByOldIds("TC no");
        TestCaseQTestModel testCaseInfo = opsAPI.createTestRun(opsAPI.getTestCasesInfo().get("6720"));
        ZoneOffset zoneOffset = ZoneId.systemDefault().getRules().getOffset(LocalDateTime.now());
        String startDateTime = OffsetDateTime.now(zoneOffset).minusMinutes(5).toString();
        String endDateTime = OffsetDateTime.now(zoneOffset).toString();
        opsAPI.addTestLog(testCaseInfo, QTestAPI.STATUS.PASS.toString(), startDateTime, endDateTime);
    }
}
