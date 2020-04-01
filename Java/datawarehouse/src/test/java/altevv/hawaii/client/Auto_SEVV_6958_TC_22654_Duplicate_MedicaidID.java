package altevv.hawaii.client;

import com.interop.common.StateAccount;
import com.interop.models.altevv.client.AltEvvClient;
import com.interop.models.altevv.client.AltEvvClientDataGenerator;
import com.interop.services.atlevv.AltEvvClientService;
import com.sandata.qtest.QTest;
import generic.GenericTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Auto_SEVV_6958_TC_22654_Duplicate_MedicaidID extends GenericTest {
    private AltEvvClientService altEVVGenericClient;

    @Test()
    @QTest(keys = "TC-22654")
    public void TC_22654_Duplicate_MedicaidID() {
        altEVVGenericClient = AltEvvClientService.init();
        AltEvvClient client2 = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        client2.setClientMedicaidID(altEVVGenericClient.getModels().get(0).getClientMedicaidID());
        client2.setClientIdentifier(altEVVGenericClient.getModels().get(0).getClientMedicaidID());
        client2.setClientCustomID(altEVVGenericClient.getModels().get(0).getClientMedicaidID());
        client2.setClientOtherID(altEVVGenericClient.getModels().get(0).getClientMedicaidID());
        altEVVGenericClient.addModel(client2);
        altEVVGenericClient.post();
        altEVVGenericClient.verifyPostStatus("FAILED");
    }

    @Test()
    @QTest(keys = "TC-22719")
    public void TC_22719_Send_With_PayerInformation() {
        AltEvvClient client2 = AltEvvClientDataGenerator.getDefaultAltEvvClientWithUniqueValue(StateAccount.loadStateAccount());
        List<AltEvvClient> payload = new ArrayList<>();
        payload.add(client2);
        altEVVGenericClient = AltEvvClientService.init();
        altEVVGenericClient.loadPayload(payload);
        altEVVGenericClient.post();
        baseObj.info("Verify the status with Expected status is Passed");
        altEVVGenericClient.verifyPostStatus("SUCCESS");
    }
}
