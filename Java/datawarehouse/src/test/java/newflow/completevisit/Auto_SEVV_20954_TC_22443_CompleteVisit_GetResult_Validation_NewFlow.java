package newflow.completevisit;

import com.interop.common.StateAccount;
import com.interop.common.constants.utils.db.VisitDbUtils;
import com.interop.models.ProviderIdentification;
import com.interop.models.altevv.visit.*;
import com.interop.models.db.stx.STXVisit;
import com.interop.models.openevv.completevisit.Visit;
import com.interop.services.CompleteVisit;
import com.interop.services.atlevv.AltEvvVisitService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

import static com.interop.sql.VisitSQL.SQL_STX_VISIT;

public class Auto_SEVV_20954_TC_22443_CompleteVisit_GetResult_Validation_NewFlow extends GenericTest {
    private String exportBegin = commons.getDateString(1, "yyyy-MM-dd 00:00:00");
    private String exportEnd = commons.getDateString(0, "yyyy-MM-dd 23:59:59");
    @DataProvider(name = "getData")
    public Object[][] getData(Method method) {
        String environment = System.getProperty("environment");
        if (environment.equalsIgnoreCase("QA"))
        {
            return new Object[][]{
                    {true, "62112", "112010523", "227"},
                    {false, "60207", "322112389", "69"}
            };
        }
        else {
            return new Object[][]{
                    {true, "60138", "999999888", "227"},
                    {false, "60201", "999960201", "69"}
            };
        }
    }

    @Test(dataProvider = "getData")
    @QTest(keys = {"TC-22443", "TC-22442", "TC-22439"})
    public void Auto_TC_22443_CompleteVisit_GetResult_Validation_NewFlow(boolean valid, String account, String providerId, String exportKey) {
        AltEvvVisitDataGenerator visitGenerator;
        StateAccount stateAccount = StateAccount.loadStateAccount();
        stateAccount.setAccountID(account);
        stateAccount.setProviderID(providerId);

        visitGenerator = new AltEvvVisitDataGenerator(stateAccount);

        baseObj.info("Send Visit with export key: " + exportKey);
        AltEvvVisitService visitService = new AltEvvVisitService();
        visitService.setEntityGuid(true);
        String startCallTime = commons.getDateString(-1, 3, 15,
                15, "yyyy-MM-dd'T'HH:mm:ss'Z'");
        String endCallTime = commons.getDateString(-1, 5, 30,
                15, "yyyy-MM-dd'T'HH:mm:ss'Z'");
        AltEvvVisit visitModel = AltEvvVisit.builder()
                .providerIdentification(ProviderIdentification.builder().withState(stateAccount).build())
                .call(Call.builder().enterDefaultCallInfo(60).setCallDateTime(startCallTime).setCallAssignment(CallAssignment.TIME_IN).build())
                .call(Call.builder().enterDefaultCallInfo(15).setCallDateTime(endCallTime).setCallAssignment(CallAssignment.TIME_OUT).build())
                .visitChange(VisitChange.builder().build())
                .visitException(VisitException.builder().build())
                .clientID(visitGenerator.assignRandomClient())
                .employeeIdentifier(visitGenerator.assignRandomEmployee())
                .build();
        visitService.addModel(visitModel);
        visitService.post();
        visitService.verifyPostStatus("SUCCESS");

        String querySQL = String.format(SQL_STX_VISIT, stateAccount.getAccountID(), visitModel.getSequenceID());
        STXVisit stxVisit = VisitDbUtils.getVisit(stateAccount.getAccountID(), visitModel.getSequenceID()).get(0);
        visitModel.setVisitKey(stxVisit.getVISITKEY().toString());

        baseObj.info("Run Completed Visit Download");
        CompleteVisit completeVisit = new CompleteVisit();
        List<Visit> visitExported = completeVisit.getResult(exportBegin, exportEnd, "2", "100", "1", "270");
        completeVisit.verifyExportedVisit(true, visitModel, visitExported);
    }
}
