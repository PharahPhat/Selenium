package generic.rest.interfaces.validation.Pennylvania_generic.client;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_4799_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_clientAddressLongitude extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_4799_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_clientAddressLongitude() {

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "Use API above to create new client with - Length of ClientIdentifier <= 20\n" +
                "- ClientIdentifier value is String (such as MedicaidID)");
        //boolean result1 =  altEVV_Generic_Pennsylvania_client.ClientLongitude(Constant.data_type.userInput,0 ,"-73.4228741", true);

        logStepInfo("Step 2: length > 20");
        boolean result2 =  altEVV_Generic_Pennsylvania_client.ClientLongitude(Constant.DataType.userInput,0 ,"-73.4228741234567891223565675", false);

        Assert.assertTrue(result2 , "Failed to validation for 'client first name' of a single alt evv generic client");

    }
}
