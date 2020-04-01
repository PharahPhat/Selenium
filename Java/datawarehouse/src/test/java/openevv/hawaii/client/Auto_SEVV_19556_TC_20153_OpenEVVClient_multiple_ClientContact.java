package openevv.hawaii.client;

import com.interop.common.constants.utils.db.ClientDBUtils;
import com.interop.models.db.inbox.InboxClientContact;
import com.interop.models.db.stx.STXClientContact;
import com.interop.models.openevv.client.OpenEvvClientDataGenerator;
import com.interop.models.openevv.client.OpenEvvClientV1;
import com.interop.services.openevv.OpenEvvClientServiceV1;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Auto_SEVV_19556_TC_20153_OpenEVVClient_multiple_ClientContact extends GenericTest {

    @Test(groups = {"openEVVMember"})
    @QTest(keys={"TC-22321"})
    public void Auto_SEVV_19556_TC_20153_OpenEVVClient_multiple_ClientContact(){

        List<OpenEvvClientV1> openEvvClients = new ArrayList<>();
        OpenEvvClientV1 evvMember = OpenEvvClientDataGenerator.getOpenEvvClientByStateV1(stateAccount.getStateEnum(), 3);
        openEvvClients.add(evvMember);
        OpenEvvClientServiceV1 openEvvClient = new OpenEvvClientServiceV1();
        openEvvClient.loadPayload(openEvvClients);

        baseObj.info("Step 1: Create new Client");
        openEvvClient.post();

        baseObj.info("Step 3: Verify Inbox EVV");
        baseObj.sleep(30000);
        String fName = openEvvClients.get(0).getClientFirstName();
        List<InboxClientContact> inboxClientContacts = ClientDBUtils.getClientContactInbox(stateAccount.getAccountID(), fName);
        baseObj.info("number records in inbox" + inboxClientContacts.size());
        Assert.assertEquals(inboxClientContacts.size(), openEvvClients.get(0).getClientContact().size(), "ClientContact size in Inbox is incorrect");

        for (InboxClientContact inboxClientContact : inboxClientContacts) {
            Assert.assertEquals(inboxClientContact.getERROR_CODE().toString(), "0", "ERROR CODE is not equal to 0");
        }

        baseObj.info("Step 4: Verify STX EVV");
        List<STXClientContact> stxClientContacts = ClientDBUtils.getClientContact(stateAccount.getAccountID(),
                inboxClientContacts.get(0).getLOC().toString());
        Assert.assertEquals(stxClientContacts.size(), openEvvClients.get(0).getClientContact().size(),  "ClientContact size in STX is incorrect");

    }
}
