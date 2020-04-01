package openevv.generic.completevisit;

import com.interop.models.openevv.completevisit.Visit;
import com.interop.models.openevv.schedule.OpenEvvSchedule;
import com.interop.services.CompleteVisit;
import com.interop.services.openevv.OpenEvvScheduleService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by NhonTNguyen
 * Run Scripts with State: PA, AZ, HI, CT
 */

public class Auto_SEVV_17060_TC_22536_NotExportVisitWithStatusIncomplete extends GenericTest {
    @Test(groups = {"completevisit"})
    @QTest(keys = {"TC-22724"})
    public void Auto_NotExportVisitWithStatusDifferentProcessedVerified() {
        baseObj.info("Verify Completed Visit with EXPORT MODE=2");
        baseObj.info("Create Visit with status InComplete");
        List<OpenEvvSchedule> listVisit = new ArrayList<>();
        OpenEvvScheduleService openEvvSchedule1 = OpenEvvScheduleService.init();
        OpenEvvSchedule visit1 = openEvvSchedule1.getModels().get(0);
        openEvvSchedule1.post();
        openEvvSchedule1.verifyPostStatus("SUCCESS");

        baseObj.info("Create Visit with status In Process");
        OpenEvvScheduleService openEvvSchedule2 = OpenEvvScheduleService.init();
        OpenEvvSchedule visit2 = openEvvSchedule2.getModels().get(0);
        visit2.setScheduleStartTime(commons.getDateString(3));
        visit2.setScheduleEndTime(commons.getDateString(5));
        openEvvSchedule2.loadPayload(openEvvSchedule2.getModels());
        openEvvSchedule2.post();
        openEvvSchedule2.verifyPostStatus("SUCCESS");

        listVisit.add(visit1);
        listVisit.add(visit2);

        CompleteVisit completeVisit = new CompleteVisit();
        String startDate = commons.getDateString(-1, "yyyy-MM-dd 00:00:00");
        String endDate = commons.getDateString(0, "yyyy-MM-dd 23:59:59");
        List<Visit> visitExported = completeVisit.getResult(startDate, endDate, "2", "100", "1");

        for (OpenEvvSchedule visitExpected : listVisit) {
            for (Visit visitActual : visitExported) {
                if (StringUtils.equals(visitActual.getClientID(), visitExpected.getClientID())
                        && visitActual.getEmployeePIN().equals(visitExpected.getEmployeePIN())) {
                    baseObj.fail("Should not export visit with different status Processed/Verified: " + visitExpected.getClientMedicaidId());
                }
            }
        }
        baseObj.pass("Verify Visit should not export");
    }
}
