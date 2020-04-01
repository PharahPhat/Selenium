package altevv.generic.visit;
import com.interop.models.altevv.visit.AltEvvVisit;
import com.interop.models.altevv.visit.AltEvvVisitDataGenerator;
import com.interop.services.atlevv.AltEvvVisitService;
import com.interop.common.StateAccount;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
public class Auto_SEVV_TC_20741_AltEVV_Visit_new_flow extends GenericTest{

    @Test()
    @QTest()
    public void Auto_SEVV_TC_20741_AltEVV_new_flow() {
        AltEvvVisitService altEVVGenericVisit = new AltEvvVisitService();

        baseObj.info("generate multi records");
        List<AltEvvVisit> altEvvVisits = new ArrayList<>();

        for (int i = 0; i<10; i++){
            AltEvvVisit altEvvVisit = AltEvvVisitDataGenerator.initAltEvvVisitByState(StateAccount.loadStateAccount());
            altEvvVisits.add(altEvvVisit);
        }
        altEVVGenericVisit.loadPayload(altEvvVisits);

        baseObj.info("Step 1: Send request");
        altEVVGenericVisit.post();

        baseObj.info("Step 2: Send get request");
        altEVVGenericVisit.requestUUIDStatus();
    }
}
