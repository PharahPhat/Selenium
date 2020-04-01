package openevv.hawaii.client;

import com.interop.models.openevv.client.OpenEvvClient;
import com.interop.models.openevv.client.OpenEvvClientDataGenerator;
import com.interop.services.openevv.OpenEvvClientService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.annotations.Test;

/**
 * Author by: NhonNguyen
 * Run script for HI,AZ,VT
 * TC-19501: OpenEVV-Member-Intake-ClientDesignee: Verify maximum Designees number created
 */

public class Auto_SEVV_7310_TC_37325_OpenEVVClient_VerifyMaximumDesigneesCreated extends GenericTest {
    @Test(groups = {"arizona", "member"})
    @QTest(keys = {"TC-37325"})
    public void SEVV_7310_TC_37325_OpenEVVClient_VerifyMaximumDesigneesCreated() {
        baseObj.info("Step 1: Prepare to create Client with 20 Client Designees");
        OpenEvvClientService openEvvClientService = new OpenEvvClientService();
        OpenEvvClient model = OpenEvvClientDataGenerator.getOpenEvvClientByState(stateAccount,
                1, 1, 20);
        openEvvClientService.addModel(model);
        openEvvClientService.loadPayload(openEvvClientService.getModels());
        openEvvClientService.post();
        baseObj.info("Step 2: Verify Post successfully");
        baseObj.validateActualAndExpectedText(openEvvClientService.getStatusModel().status, "SUCCESS");
        baseObj.info("Step 3: Verify Client Designee in STX.APP_USERS");
        openEvvClientService.verifyDisplayClientDesigneeInDB(model.getClientDesignees().get(0).getClientDesigneeEmail());
    }
}
