package openevv.hawaii.client;

import com.interop.models.openevv.client.OpenEvvClient;
import com.interop.models.openevv.client.OpenEvvClientDataGenerator;
import com.interop.services.openevv.OpenEvvClientService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;

/**
 * Author by: NhonNguyen
 * * Run script for HI,AZ,VT
 * TC-19502: OpenEVV-Member-Intake-ClientDesignee: Verify Only one email address may be associated with one designee
 */

public class Auto_SEVV_7310_TC_37326_OpenEVVClient_VerifyOnlyEmailAssociatedOneDesignee extends GenericTest {
    @Test(groups = {"arizona", "member"})
    @QTest(keys = {"TC-37326"})
    public void SEVV_7310_TC_37326_OpenEVVClient_VerifyOnlyEmailAssociatedOneDesignee() {
        baseObj.info("Step 1: Prepare data");
        OpenEvvClient openEvvClient = OpenEvvClientDataGenerator.getOpenEvvClientByState(stateAccount);
        OpenEvvClientService openEvvClientService = new OpenEvvClientService();
        openEvvClientService.addModel(openEvvClient);
        openEvvClientService.loadPayload(openEvvClientService.getModels());
        String username = openEvvClientService.getModels().get(0).getClientDesignees().get(0).getClientDesigneeEmail();

        baseObj.info("Step 2: Post Member with Client Designee Email: " + username);
        openEvvClientService.post();
        baseObj.validateActualAndExpectedText(openEvvClientService.getStatusModel().status, "SUCCESS");

        String usernameDiff = RandomStringUtils.randomAlphanumeric(5) + "_" + commons.generateUniqueNumber()
                + "@mailinator.com";
        openEvvClientService.getModels().get(0).getClientDesignees().get(0).setClientDesigneeEmail(usernameDiff);
        openEvvClientService.loadPayload(openEvvClientService.getModels());
        baseObj.info("Step 3: Post Same Member but different Client Designee Email: " + usernameDiff);
        openEvvClientService.post();
        baseObj.validateActualAndExpectedText(openEvvClientService.getStatusModel().status, "SUCCESS");

        baseObj.info("Step 4: Verify Client Designee with different Client Designee Email in STX.APP_USERS");
        openEvvClientService.verifyDisplayClientDesigneeInDB(usernameDiff);
        baseObj.info("Step 5: Verify Client Designee with old Client Designee Email is deleted in STX.APP_USERS");
        openEvvClientService.verifyNotDisplayClientDesigneeInDB(username);
    }
}
