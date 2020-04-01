package altevv.generic.client;

import com.interop.models.altevv.client.*;
import com.interop.services.atlevv.AltEvvClientService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Auto_SEVV_TC_20741_AltEVV_new_flow extends GenericTest {
    private String clientID;
    @Test()
    @QTest(keys = {"TC-20741"})
    public void Auto_SEVV_TC_20741_AltEVV_new_flow() {
        AltEvvClientService altEVVGenericClient = new AltEvvClientService();
        altEVVGenericClient.setEntityGuid(true);

        baseObj.info("generate multi records");
        List<AltEvvClient> altEvvClients = new ArrayList<>();
        for (int i = 0; i<1; i++){
            clientID = baseObj.generateRandomNumberObsolete(10);
            AltEvvClient altEvvClient = AltEvvClient.builder()
                    .clientID(clientID)
                    .clientIdentifier(clientID)
                    .address(ClientAddress.builder().build())
                    .phone(ClientPhone.builder().build())
                    .party(ClientResponsibleParty.builder().build())
                    .clientPayer(ClientPayerInformation.builder().build())
                    .build();
            altEvvClients.add(altEvvClient);
        }
        altEVVGenericClient.loadPayload(altEvvClients);

        baseObj.info("Step 1: Send request");
        altEVVGenericClient.post();

        baseObj.info("Step 2: Send get request");
        altEVVGenericClient.requestUUIDStatus();

        baseObj.info("Step 3:");
        altEVVGenericClient.validateUuidResponse();

    }
}
