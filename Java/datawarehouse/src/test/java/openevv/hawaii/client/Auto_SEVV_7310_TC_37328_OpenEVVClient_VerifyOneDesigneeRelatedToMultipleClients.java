package openevv.hawaii.client;

import com.interop.common.constants.utils.db.ClientDBUtils;
import com.interop.models.db.stx.STXClientContact;
import com.interop.models.openevv.client.OpenEvvClient;
import com.interop.models.openevv.client.OpenEvvClientDataGenerator;
import com.interop.models.openevv.member.OpenEvvMember;
import com.interop.models.openevv.member.OpenEvvMemberDataGenerator;
import com.interop.services.openevv.OpenEvvClientService;
import com.interop.services.openevv.OpenEvvMemberService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by: NhonNguyen
 * Run script for HI,AZ,VT
 * TC-19504: OpenEVV-Member-Intake-ClientDesignee: Verify one designee may be related to multiple clients
 */

public class Auto_SEVV_7310_TC_37328_OpenEVVClient_VerifyOneDesigneeRelatedToMultipleClients extends GenericTest {
    @Test(groups = {"arizona", "member"})
    @QTest(keys = {"TC-37328"})
    public void SEVV_7310_TC_37328_OpenEVVClient_VerifyOneDesigneeRelatedToMultipleClients() {
        baseObj.info("Step 1: Prepare to create Client with multi Client Designees having same email");
        OpenEvvClientService openEvvClientService = new OpenEvvClientService();
        OpenEvvClient openEvvClient = OpenEvvClientDataGenerator.getOpenEvvClientByState
                (stateAccount, 1, 1, 2);
        String sameEmailExpected = openEvvClient.getClientDesignees().get(0).getClientDesigneeEmail();
        openEvvClientService.addModel(openEvvClient);
        openEvvClientService.post();

        baseObj.info("Step 2: Verify Post successfully");
        baseObj.validateActualAndExpectedText(openEvvClientService.getStatusModel().status, "SUCCESS");

        baseObj.info("Step 3: Sending API to create a new client with same designee email");
        openEvvClientService.getModels().remove(openEvvClient);
        openEvvClient = OpenEvvClientDataGenerator.getOpenEvvClientByState
                (stateAccount, 1, 1, 2);
        openEvvClient.getClientDesignees().get(0).setClientDesigneeEmail(sameEmailExpected);
        openEvvClientService.addModel(openEvvClient);
        openEvvClientService.post();

        baseObj.info("Step 4: Verify Post Update Multi Client Designees successfully");
        baseObj.validateActualAndExpectedText(openEvvClientService.getStatusModel().status, "SUCCESS");

        baseObj.info("Step 5: Verify Same Client Designee Email will be displayed 2 records in STX.CLIENTS_CONTACT");
        openEvvClientService.verifyDisplayClientDesigneeInDB(sameEmailExpected);
        List<STXClientContact> clientContacts = ClientDBUtils.getClientContactByEmail(stateAccount.getAccountID(),
                sameEmailExpected);
        baseObj.validateActualAndExpectedText(String.valueOf(clientContacts.size()), "2");
    }
}
