package generic.rest.interfaces.business.open_evv_generic.client;

import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102180_OPEN_EVV_GENERIC_CLIENT_Insert_A_New_Single_Client extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102180_OPEN_EVV_GENERIC_CLIENT_Insert_A_New_Single_Client(){
        logStepInfo("Step 1: Post request to create a new single valid open generic client");

        boolean result = openEVVMemberModel.createMultipleClients(1);

        Assert.assertTrue(result, "Failed to create a single valid open evv generic client");
    }
}
