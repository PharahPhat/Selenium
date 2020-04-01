package altevv.generic.visit;

import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.interop.common.constants.utils.db.VisitDbUtils;
import com.interop.common.dataprovider.DataPayerProgramCombination;
import com.interop.models.altevv.visit.AltEvvVisit;
import com.interop.models.altevv.visit.AltEvvVisitDataGenerator;
import com.interop.services.atlevv.AltEvvVisitService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Author by NhonNguyen
 * Script could be run on VT, RI, HI, AZ, PA, WI
 */

public class Auto_SEVV_TC_39131_AltEVV_IntakeVisit_PayerProgramServiceCombination extends GenericTest {
    private static final String stringKey = StateAccount.loadStateAccount().getStateEnum().getStringKey();
    @DataProvider(name = "payerProgramServiceCombination")
    public Object[][] getDataDriven() {
        String fileName = "AltEVV/AltEVV_" + stringKey + "_PayerProgramServiceCombination.csv";
        return TestDataHelper.getCombinationDataRows(state, fileName);
    }

    @Test(dataProvider = "payerProgramServiceCombination", groups = {"altVisit"})
    @Description("PayerProgramServiceCombination Test for AltEVV Visit endpoint")
    @QTest(keys = {"TC-21295", "TC-22785"})
    public void AltEVV_IntakeVisit_PayerProgramServiceCombination(DataPayerProgramCombination dataTest) {
        AltEvvVisitService visitAPI = new AltEvvVisitService();
        AltEvvVisit altEvvVisit = AltEvvVisitDataGenerator.initAltEvvVisitByState(stateAccount);
        altEvvVisit.setSequenceID(commons.generateUniqueNumber());
        altEvvVisit.setPayerID(dataTest.getPayer());
        altEvvVisit.setPayerProgram(dataTest.getProgram());
        altEvvVisit.setProcedureCode(dataTest.getService());
        altEvvVisit.setModifier1(dataTest.getModifier1());
        altEvvVisit.setModifier2(dataTest.getModifier2());
        altEvvVisit.setModifier3(dataTest.getModifier3());
        altEvvVisit.setModifier4(dataTest.getModifier4());
        altEvvVisit.getCalls().get(0).setProcedureCode(dataTest.getService());
        altEvvVisit.getCalls().get(1).setProcedureCode(dataTest.getService());

        visitAPI.addModel(altEvvVisit);
        visitAPI.post();

        visitAPI.verifyPostStatus(dataTest.getExpectedStatus());

        if("yes".equalsIgnoreCase(dataTest.getIsCheckedDatabase())) {
            baseObj.info("Verify Visit storing in DB");
            List visit = VisitDbUtils.getVisit(stateAccount.getAccountID(), altEvvVisit.getSequenceID());
            Assert.assertFalse(visit.isEmpty());
        }
        else {
            visitAPI.requestUUIDStatus();
            visitAPI.verifyErrorCode(dataTest.getExpectedMessage());
        }
    }
}
