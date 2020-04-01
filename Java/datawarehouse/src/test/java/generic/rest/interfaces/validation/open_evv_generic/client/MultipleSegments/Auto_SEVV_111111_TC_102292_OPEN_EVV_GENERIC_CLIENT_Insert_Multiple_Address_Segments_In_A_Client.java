package generic.rest.interfaces.validation.open_evv_generic.client.MultipleSegments;

import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102292_OPEN_EVV_GENERIC_CLIENT_Insert_Multiple_Address_Segments_In_A_Client extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102292_OPEN_EVV_GENERIC_CLIENT_Insert_Multiple_Address_Segments_In_A_Client() {
        logStepInfo("Step 1: Post request to create multiple ClientAddress segments in a generic client");

        boolean result = openEVVMemberModel.createMultipleClients(1);

        Assert.assertTrue(result, "Failed to create multiple valid ClientAddress segments in a generic clients");
    }
}
