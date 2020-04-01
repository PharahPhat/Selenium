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

/**
 * Author by NhonTNguyen
 * Run Scripts with State: PA, AZ
 * NOTES: Scripts could NOT run with CT, HI because these only export approved visit
 * (Could NOT create approved visit from API)
 */

public class Auto_SEVV_17060_TC_20785_CompleteVisit_Exported_ExportNewVisitUpdateVisit extends InterfacesGenericTest {
    private AltEvvVisitService altEvvVisitService = new AltEvvVisitService();
    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
//                        {"1"},
                        {"2"},
//                        {"3"},
//                        {"4"}
                };
    }

    @Test(dataProvider = "dataProvider", groups = {"completevisit"})
    @QTest(keys = {"TC-20785", "TC-20778", "TC-20779"})
    public void Auto_TC_20785_CompleteVisit_Exported_ExportNewVisitUpdateVisit(String exportMode) {
        baseObj.info("Verify Completed Visit with EXPORT MODE=" + exportMode);
        baseObj.info("Create Visit 1 with visit date = in the past and visit end date = in the past after visit " +
                "start date");
        AltEvvVisit visit1 = AltEvvVisitDataGenerator.initAltEvvVisitByState(stateAccount);
        visit1.setScheduleStartTime(commons.getDateString(-29));
        visit1.setScheduleEndTime(commons.getDateString(-5));
        visit1.getCalls().get(0).setCallDateTime(commons.getDateString(-15, 15, 15,
                15, "yyyy-MM-dd'T'HH:mm:ss'Z'"));
        visit1.getCalls().get(0).setLocation("1");
        visit1.getCalls().get(1).setCallDateTime(commons.getDateString(-15, 15, 30,
                15, "yyyy-MM-dd'T'HH:mm:ss'Z'"));
        visit1.getCalls().get(1).setLocation("1");

        altEvvVisitService.addModel(visit1);
        altEvvVisitService.post();
        altEvvVisitService.verifyPostStatus("SUCCESS");

        altEvvVisitService = new AltEvvVisitService();
        AltEvvVisit visit2 = AltEvvVisitDataGenerator.initAltEvvVisitByState(stateAccount);
        visit2.setScheduleStartTime(commons.getDateString(-25));
        visit2.setScheduleEndTime(commons.getDateString(-5));
        visit2.getCalls().get(0).setCallDateTime(commons.getDateString(-6, 15, 15,
                15, "yyyy-MM-dd'T'HH:mm:ss'Z'"));
        visit2.getCalls().get(0).setLocation("2");
        visit2.getCalls().get(1).setCallDateTime(commons.getDateString(-6, 15, 30,
                15, "yyyy-MM-dd'T'HH:mm:ss'Z'"));
        visit2.getCalls().get(1).setLocation("2");

        altEvvVisitService.addModel(visit2);
        altEvvVisitService.post();
        altEvvVisitService.verifyPostStatus("SUCCESS");

        STXVisit stxVisit1 = VisitDbUtils.getVerifiedVisit(stateAccount.getAccountID(), visit1.getSequenceID()).get(0);
        STXVisit stxVisit2 = VisitDbUtils.getVerifiedVisit(stateAccount.getAccountID(), visit2.getSequenceID()).get(0);
        visit1.setVisitKey(stxVisit1.getVISITKEY().toString());
        visit2.setVisitKey(stxVisit2.getVISITKEY().toString());

        CompleteVisit completeVisit = new CompleteVisit();
        String startDate = commons.getDateString(-30, "yyyy-MM-dd 00:00:00");
        String endDate = commons.getDateString(-4, "yyyy-MM-dd 23:59:59");

        List<Visit> visitExported = completeVisit.getResult(startDate, endDate, exportMode, "100", "1");

        completeVisit.verifyExportedVisit(true, visit1, visitExported);
        baseObj.pass("PASS TC 36964");

        // export updated visit
        baseObj.info("Begin Run TC 39565: Update visit2 in current date and export although exported start date " +
                "and end date in the PAST");
        visit2.setClientVerifiedTimes("false");
        visit2.setMemo("Update info to export complete visit");
        visit2.getCalls().get(0).setLocation("1");
        visit2.getCalls().get(1).setLocation("1");

        altEvvVisitService = new AltEvvVisitService();
        altEvvVisitService.addModel(visit2);
        altEvvVisitService.post();
        altEvvVisitService.verifyPostStatus("SUCCESS");

        completeVisit = new CompleteVisit();
        visitExported = completeVisit.getResult(startDate, endDate, exportMode, "100", "1");

        completeVisit.verifyExportedVisit(true, visit2, visitExported);
        baseObj.pass("PASS TC 39565");

        // Verify that should not export visit exported before in mode=2
        if (exportMode.equals("2")) {
            baseObj.info("Verify that should not export VisitKey " + visit1.getVisitKey() + " exported before");
            for (Visit visitActual : visitExported) {
                if (visitActual.getVisitId().equals(visit1.getVisitKey())) {
                    baseObj.fail("SHOULD NOT export VisitKey " + visit1.getVisitKey() + " exported before");
                }
            }

            baseObj.pass("PASS TC: Verify that should not export VisitKey " + visit1.getVisitKey() + " exported before");
        }
    }
}
