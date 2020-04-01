package generic.rest.interfaces.business.open_evv_generic.client;

import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102179_OPEN_EVV_GENERIC_CLIENT_Insert_New_Multiple_Clients extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102179_OPEN_EVV_GENERIC_CLIENT_Insert_New_Multiple_Clients() {
        logStepInfo("Step 1: Post request to create new multiple valid open generic clients");

        boolean result = openEVVMemberModel.createMultipleClients(2);

        Assert.assertTrue(result, "Failed to create multiple valid open evv generic clients");
    }
}
