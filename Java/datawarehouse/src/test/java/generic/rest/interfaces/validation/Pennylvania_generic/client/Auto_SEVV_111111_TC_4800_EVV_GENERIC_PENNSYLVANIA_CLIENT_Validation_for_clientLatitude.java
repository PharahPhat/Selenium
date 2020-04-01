package generic.rest.interfaces.validation.Pennylvania_generic.client;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_4800_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_clientLatitude extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_4800_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_clientLatitude() {

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "Use API above to create new client with - Length of ClientIdentifier <= 64\n" +
                "- ClientIdentifier value is String (such as MedicaidID)");
        boolean result1 =  altEVV_Generic_Pennsylvania_client.ClientLatitude(Constant.DataType.userInput,0 ,"40.7431032", true);

        boolean result2 =  altEVV_Generic_Pennsylvania_client.ClientLatitude(Constant.DataType.userInput,0 ,"40.7431032545454545454545454545454", false);

        Assert.assertTrue(result1 && result2, "Failed to validation for 'client first name' of a single alt evv generic client");

    }
}
