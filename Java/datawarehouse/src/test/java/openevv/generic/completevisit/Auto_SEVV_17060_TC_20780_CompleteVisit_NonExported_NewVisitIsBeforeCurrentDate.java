package openevv.generic.completevisit;

import com.interop.common.constants.utils.db.VisitDbUtils;
import com.interop.models.altevv.visit.AltEvvVisit;
import com.interop.models.altevv.visit.AltEvvVisitDataGenerator;
import com.interop.models.db.stx.STXVisit;
import com.interop.models.openevv.completevisit.Visit;
import com.interop.services.CompleteVisit;
import com.interop.services.atlevv.AltEvvVisitService;
import com.sandata.qtest.QTest;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.interop.sql.VisitSQL.SQL_GET_VISIT_IN_THE_PAST;

/**
 * Author by NhonTNguyen
 * Run Scripts with State: PA, AZ
 * NOTES: Scripts could NOT run with CT, HI because these only export approved visit
 * (Could NOT create approved visit from API)
 */

public class Auto_SEVV_17060_TC_20780_CompleteVisit_NonExported_NewVisitIsBeforeCurrentDate extends InterfacesGenericTest {
    private AltEvvVisitService visitService = new AltEvvVisitService();
    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
//                        {false, "Verifying Visit=CurrentDate, Export BeginDate and EndDate=CurrentDate", 0, 0, 0, 0},
                        {true, "Verifying Visit is before current date", -1, -1, -2, 0}
                };
    }

    @Test(dataProvider = "dataProvider", groups = {"completevisit"})
    @QTest(keys = {"TC-22725", "TC-22818", "TC-22728", "TC-22726"})
    public void TC_39572_CompleteVisit_NonExported_NewVisitIsBeforeCurrentDate(boolean isVisitExported, String description,
                                                                               int startVisit, int endVisit,
                                                                               int exportBegin, int exportEnd) {
        baseObj.info("Verify Completed Visit with EXPORT MODE=2");
        baseObj.info(description);
        AltEvvVisit visit = AltEvvVisitDataGenerator.initAltEvvVisitByState(stateAccount);
        visitService.addModel(visit);
        String startCallTime = commons.getDateString(startVisit, -2, 0,
                0, "yyyy-MM-dd'T'HH:mm:ss'Z'");
        String endCallTime = commons.getDateString(endVisit, -1, 30,
                15, "yyyy-MM-dd'T'HH:mm:ss'Z'");
        visit.setScheduleStartTime(commons.getDateString(-3));
        visit.setScheduleEndTime(commons.getDateString(-1));
        visit.getCalls().get(0).setCallDateTime(startCallTime);
        visit.getCalls().get(0).setLocation("1");
        visit.getCalls().get(1).setCallDateTime(endCallTime);
        visit.getCalls().get(1).setLocation("1");

        visitService.loadPayload(visitService.getModels());
        visitService.post();
        visitService.verifyPostStatus("SUCCESS");

        STXVisit stxVisit = VisitDbUtils.getVerifiedVisit(stateAccount.getAccountID(), visit.getSequenceID()).get(0);
        visit.setVisitKey(stxVisit.getVISITKEY().toString());

        CompleteVisit completeVisit = new CompleteVisit();

        String startDate = commons.getDateString(exportBegin, "yyyy-MM-dd 00:00:00");
        String endDate = commons.getDateString(exportEnd, "yyyy-MM-dd 23:59:59");

        List<Visit> visitExported = completeVisit.getResult(startDate, endDate, "2", "100", "1");

        if (isVisitExported) {
            completeVisit.verifyExportedVisit(true, visit, visitExported);
        }
        else {
            for (Visit visitActual : visitExported) {
                if (visitActual.getVisitId().equals(visit.getVisitKey())) {
                    baseObj.fail("Should not export visit with visit date = export visit date " + visit.getVisitKey());
                }
            }
        }
    }

    @Test(groups = {"completevisit"})
    @QTest(keys = {"TC-22534"})
    public void TC_39572_CompleteVisit_NonExported_NewVisitStartDateIsYesterday() {
        baseObj.info("Verify Completed Visit with EXPORT MODE=2");
        baseObj.info("Verifying Visit StartDate=Yesterday, Visit EndDate=CurrentDate");
        AltEvvVisit visit = AltEvvVisitDataGenerator.initAltEvvVisitByState(stateAccount);
        visitService.addModel(visit);
        visit.setScheduleStartTime(commons.getDateString(-3));
        visit.setScheduleEndTime(commons.getDateString(-1));
        String startCallTime = commons.getDateString(-2, 15, 0,
                0, "yyyy-MM-dd'T'HH:mm:ss'Z'");
        String endCallTime = commons.getDateString(-1, 11, 0,
                15, "yyyy-MM-dd'T'HH:mm:ss'Z'");
        visit.getCalls().get(0).setCallDateTime(startCallTime);
        visit.getCalls().get(0).setLocation("2");
        visit.getCalls().get(1).setCallDateTime(endCallTime);
        visit.getCalls().get(1).setLocation("2");
        visit.setTasks(null);

        visitService.loadPayload(visitService.getModels());
        visitService.post();
        visitService.verifyPostStatus("SUCCESS");

        STXVisit stxVisit1 = VisitDbUtils.getVisit(stateAccount.getAccountID(), visit.getSequenceID()).get(0);
        visit.setVisitKey(stxVisit1.getVISITKEY().toString());

        CompleteVisit completeVisit = new CompleteVisit();

        String startDate = commons.getDateString(0, "yyyy-MM-dd 00:00:00");
        String endDate = commons.getDateString(0, "yyyy-MM-dd 23:59:59");

        List<Visit> visitExported = completeVisit.getResult(startDate, endDate, "2", "100", "1");

        completeVisit.verifyExportedVisit(false, visit, visitExported);
    }
}
