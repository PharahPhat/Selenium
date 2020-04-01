package altevv.generic.client;

import com.interop.common.StateAccount;
import com.interop.models.altevv.client.AltEvvClient;
import com.interop.models.altevv.client.AltEvvClientDataGenerator;
import com.interop.models.altevv.client.ClientResponsibleParty;
import com.interop.services.atlevv.AltEvvClientService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_6445_TC_23326_AltEVVClient_Send_multi_value_segments extends GenericTest {

    @Test
    @QTest(keys = {"TC-23326", "TC-23332", "TC-23330"})
    void sendAltEvvClientWithMultiDataInSegments() {
        AltEvvClientService altEVVGenericClient = new AltEvvClientService();

        this.baseObj.info("generate multi data segments");
        StateAccount stateAccount = StateAccount.loadStateAccount();
        AltEvvClient model = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue().toBuilder()
                .party(ClientResponsibleParty.builder().build())
                .build();

        altEVVGenericClient.addModel(model);

        this.baseObj.info("Step 1: Send request");
        altEVVGenericClient.post();
        altEVVGenericClient.verifyPostStatus("SUCCESS");

        this.baseObj.info("Step 2: Send get request");
        altEVVGenericClient.requestUUIDStatus();

        this.baseObj.info("Step 3:");
        altEVVGenericClient.validateUuidResponse();

        this.baseObj.info("Step 4: Verify Db");
        altEVVGenericClient.getRecordClientDb();
    }
}
