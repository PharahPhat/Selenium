package openevv.hawaii.client;

import com.interop.common.constants.utils.db.AppUserDBUtils;
import com.interop.common.constants.utils.db.ClientDBUtils;
import com.interop.models.db.stx.STXAppUser;
import com.interop.models.db.stx.STXClientContact;
import com.interop.models.openevv.client.OpenEvvClient;
import com.interop.models.openevv.client.OpenEvvClientDataGenerator;
import com.interop.services.openevv.OpenEvvClientService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Author by: NhonNguyen
 * Run script for HI,VT
 * TC-19503: OpenEVV-Member-Intake-ClientDesignee: Verify multiple designees cannot have the same email address
 * Pre-conditions: disable User Training Enable in Account Manager
 */

public class Auto_SEVV_7310_TC_37327_OpenEvvClient_VerifyMultiDesigneesCanNotHaveSameEmailAddress extends GenericTest {
    @Test(groups = {"arizona", "member"})
    @QTest(keys = {"TC-37327"})
    public void SEVV_7310_TC_37327_OpenEVVClient_VerifyMultiDesigneesCanNotHaveSameEmailAddress() {
        baseObj.info("Step 1: Prepare to create Client with multi Client Designees having same email");
        OpenEvvClientService openEvvClientService = new OpenEvvClientService();
        OpenEvvClient openEvvClient = OpenEvvClientDataGenerator.getOpenEvvClientByState(stateAccount, 
                1, 1, 2);
        openEvvClientService.addModel(openEvvClient);
        String sameEmailExpected = openEvvClientService.getModels().get(0).getClientDesignees().get(0).getClientDesigneeEmail();
        openEvvClientService.getModels().get(0).getClientDesignees().get(1).setClientDesigneeEmail(sameEmailExpected);
        openEvvClientService.loadPayload(openEvvClientService.getModels());
        openEvvClientService.post();

        baseObj.info("Step 2: Verify Post successfully");
        baseObj.validateActualAndExpectedText(openEvvClientService.getStatusModel().status, "SUCCESS");

        baseObj.info("Step 3: Verify Only create one record in STX.APP_USERS");
        List<STXAppUser> stxAppUserList = AppUserDBUtils.getAppUser(stateAccount.getAccountID(), sameEmailExpected);
        Assert.assertEquals(stxAppUserList.size(), 1);

        baseObj.info("Step 4: Sending API to update mutiple Client Designees");
        openEvvClientService.getModels().get(0).setClientDesignees(OpenEvvClientDataGenerator.addMultiClientDesignees(2));
        openEvvClientService.loadPayload(openEvvClientService.getModels());
        openEvvClientService.post();

        baseObj.info("Step 5: Verify Post Update Multi Client Designees successfully");
        baseObj.validateActualAndExpectedText(openEvvClientService.getStatusModel().status, "SUCCESS");

        baseObj.info("Step 6: Verify Updated Client Designee will be displayed in DB with a new Client Designees in STX.CLIENTS_CONTACT");
        openEvvClientService.verifyDisplayClientDesigneeInDB(openEvvClientService.getModels().get(0).getClientDesignees().get(0).getClientDesigneeEmail());
        openEvvClientService.verifyDisplayClientDesigneeInDB(openEvvClientService.getModels().get(0).getClientDesignees().get(1).getClientDesigneeEmail());
        openEvvClientService.verifyNotDisplayClientDesigneeInDB(sameEmailExpected);
    }
}
