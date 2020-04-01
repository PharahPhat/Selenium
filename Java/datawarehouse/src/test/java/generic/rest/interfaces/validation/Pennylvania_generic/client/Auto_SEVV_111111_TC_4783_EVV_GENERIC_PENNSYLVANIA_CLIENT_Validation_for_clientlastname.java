package generic.rest.interfaces.validation.Pennylvania_generic.client;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_4783_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_clientlastname extends InterfacesGenericTest {

    @Test
    public void Auto_SEVV_111111_TC_4783_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_clientlastname() {

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "Use API above to create new client with client parameter = 30 digits");
        boolean result1 =  altEVV_Generic_Pennsylvania_client.ClientLastName(Constant.DataType.alphabetic, 30,"", true);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Use API above to create new client with client parameter > 30 digits");
        boolean result2 =  altEVV_Generic_Pennsylvania_client.ClientLastName(Constant.DataType.alphabetic, 31,"", false);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "Use API above to create new client with client parameter = null");

        boolean result3 =  altEVV_Generic_Pennsylvania_client.ClientLastName(Constant.DataType.userInput, 0,null, false);

        Assert.assertTrue(result1 && result2 && result3, "Failed to validation for 'client last name' of a single alt evv generic client");
    }
}
