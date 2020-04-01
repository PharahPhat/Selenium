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

import static io.restassured.RestAssured.given;

public class Auto_SEVV_20954_TC_22441_CompleteVisit_CheckStatus_Validation_NewFlow extends GenericTest {
    private String exportBegin = commons.getDateString(0, "yyyy-MM-dd 00:00:00");
    private String exportEnd = commons.getDateString(0, "yyyy-MM-dd 23:59:59");
    @DataProvider(name = "ValidationCheckStatus")
    public Object[][] getValidationCheckStatus(Method method) {
        return new Object[][]{
                {"76fe5877-dbbc-11e9-9485-005056b90830", true},
                {"", false},
                {"76fe5877-dbbc-11e9-9485-838771145", false}
        };
    }

    @Test(dataProvider = "ValidationCheckStatus")
    @QTest(keys = {"TC-22441"})
    public void Auto_TC_22441_CompleteVisit_CheckStatus_Validation_NewFlow(String entity, boolean positive) {
        CompleteVisit completeVisit = new CompleteVisit();
        completeVisit.setEntityGuid(true);

        RequestSpecification requestSpecTriggerExport = given().relaxedHTTPSValidation()
                .auth().preemptive()
                .basic(TestContext.get().getEnvironment("entityUser"), TestContext.get().getEnvironment("entityPass"))
                .header("EntityGuid", entity).param("start_date_time", exportBegin)
                .param("end_date_time", exportEnd)
                .param("export_mode", "2")
                .param("groupkey", "270");
        completeVisit.requestCompletedVisit(requestSpecTriggerExport);
        String response = completeVisit.getStatusCompletedVisit(given().relaxedHTTPSValidation()
                .auth().preemptive()
                .basic(TestContext.get().getEnvironment("entityUser"), TestContext.get().getEnvironment("entityPass"))
                .header("EntityGuid", entity));

        if (positive) {
            Assert.assertTrue(response.contains("SUCCESS"), "CHECK STATUS should be SUCCESS");
        }
        else {
            Assert.assertTrue(response.contains("Unauthorized"), "CHECK STATUS should be Unauthorized");
        }
    }
}
