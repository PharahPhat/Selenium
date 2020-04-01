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
 * TC-19505: OpenEVV-Member-Intake-ClientDesignee: Verify update client with/out Designee
 */

public class Auto_SEVV_7310_TC_37329_OpenEVVClient_VerifyUpdateClientWithoutDesignee extends GenericTest {
    @Test(groups = {"arizona", "member"})
    @QTest(keys = {"TC-37329"})
    public void SEVV_7310_TC_37329_OpenEVVClient_VerifyUpdateClientWithoutDesignee() {
        baseObj.info("Step 1: Prepare to create Client without Client Designee");
        OpenEvvClientService openEvvClientService = new OpenEvvClientService();
        OpenEvvClient openEvvClient = OpenEvvClientDataGenerator.getOpenEvvClientByState
                (stateAccount, 1, 1, 0);
        openEvvClientService.addModel(openEvvClient);
        openEvvClientService.loadPayload(openEvvClientService.getModels());
        openEvvClientService.post();

        baseObj.info("Step 2: Verify Post create client without client designee successfully");
        baseObj.validateActualAndExpectedText(openEvvClientService.getStatusModel().status, "SUCCESS");

        baseObj.info("Step 3: Sending API to update client with one designee");
        openEvvClientService.getModels().get(0).setClientDesignees(OpenEvvClientDataGenerator.addMultiClientDesignees(1));
        String clientDesigneeEmail = openEvvClientService.getModels().get(0).getClientDesignees().get(0).getClientDesigneeEmail();
        openEvvClientService.loadPayload(openEvvClientService.getModels());
        openEvvClientService.post();

        baseObj.info("Step 4: Verify Post Update client with one designee successfully");
        baseObj.validateActualAndExpectedText(openEvvClientService.getStatusModel().status, "SUCCESS");

        baseObj.info("Step 5: Verify Updated client designee will be displayed in STX.APP_USERS");
        openEvvClientService.verifyDisplayClientDesigneeInDB(clientDesigneeEmail);

        baseObj.info("Step 6: Sending API to update client with multi designee");
        openEvvClientService.getModels().get(0).setClientDesignees(OpenEvvClientDataGenerator.addMultiClientDesignees(3));
        String clientDesigneeEmail1 = openEvvClientService.getModels().get(0).getClientDesignees().get(0).getClientDesigneeEmail();
        String clientDesigneeEmail2 = openEvvClientService.getModels().get(0).getClientDesignees().get(1).getClientDesigneeEmail();
        String clientDesigneeEmail3 = openEvvClientService.getModels().get(0).getClientDesignees().get(2).getClientDesigneeEmail();
        openEvvClientService.loadPayload(openEvvClientService.getModels());
        openEvvClientService.post();

        baseObj.info("Step 7: Verify Post Update client with multi designees successfully");
        baseObj.validateActualAndExpectedText(openEvvClientService.getStatusModel().status, "SUCCESS");

        baseObj.info("Step 8: Verify Updated multi client designees will be displayed in STX.APP_USERS");
        openEvvClientService.verifyDisplayClientDesigneeInDB(clientDesigneeEmail1);
        openEvvClientService.verifyDisplayClientDesigneeInDB(clientDesigneeEmail2);
        openEvvClientService.verifyDisplayClientDesigneeInDB(clientDesigneeEmail3);
    }
}
