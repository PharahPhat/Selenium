package newflow.completevisit;

import com.interop.services.CompleteVisit;
import com.sandata.core.config.TestContext;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.interop.common.GroupKey.GROUPKEY270;
import static io.restassured.RestAssured.given;

public class Auto_SEVV_20954_TC_22440_CompleteVisit_TriggerExport_Validation_NewFlow extends GenericTest {
    private String exportBegin = commons.getDateString(0, "yyyy-MM-dd 00:00:00");
    private String exportEnd = commons.getDateString(0, "yyyy-MM-dd 23:59:59");
    @DataProvider(name = "ValidationGroupKey")
    public Object[][] getValidationGroupKey(Method method) {
        return new Object[][]{
                {"", "270"},
                {"76fe5877-dbbc-11e9-9485-838771145", "272"}
        };
    }

    @Test(dataProvider = "ValidationGroupKey")
    @QTest(keys = {"TC-22440"})
    public void Auto_TC_22440_CompleteVisit_TriggerExport_Validation_NewFlow(String entity, String groupKey) {
        CompleteVisit completeVisit = new CompleteVisit();
        completeVisit.setEntityGuid(true);
        RequestSpecification requestSpecification = completeVisit.setRequestSpecFromParam(exportBegin, exportEnd,
                "2", groupKey);
        completeVisit.requestCompletedVisit(requestSpecification);
        if (groupKey.equals(GROUPKEY270.toString())) {
            baseObj.info("Has Entity Valid and GroupKey = 270");
            Assert.assertTrue(completeVisit.getResponseRequest().asString().contains("Trigger is queued"),
                    "TRIGGER EXPORT Status should be SUCCESS");
        }
        else {
            baseObj.info("Has Entity Valid and GroupKey <> 270");
            Assert.assertTrue(completeVisit.getResponseRequest().asString().contains("FAILED"),
                    "TRIGGER EXPORT Status should be FAILED");
        }

        baseObj.info("Verify Entity Invalid");
        requestSpecification = given().relaxedHTTPSValidation()
                .auth().preemptive()
                .basic(TestContext.get().getEnvironment("entityUser"), TestContext.get().getEnvironment("entityPass"))
                .header("EntityGuid", entity)
                .param("start_date_time", exportBegin)
                .param("end_date_time", exportEnd)
                .param("export_mode", "2")
                .param("groupkey", groupKey);
        completeVisit.requestCompletedVisit(requestSpecification);
        Assert.assertTrue(completeVisit.getResponseRequest().asString().contains("Unauthorized"),
                "TRIGGER EXPORT Status should be Unauthorized");
    }
}
