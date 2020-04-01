package generic.rest.interfaces.validation.Pennylvania_generic.client;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_4859_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_clientContactType extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_4859_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_clientContactType() {

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "Use API above to create new client with - Length of ClientIdentifier <= 64\n" +
                "- ClientIdentifier value is String (such as MedicaidID)");
        boolean result1 =  altEVV_Generic_Pennsylvania_client.ClientContactType(Constant.DataType.userInput,0 ,"Friend", true);

        boolean result2 =  altEVV_Generic_Pennsylvania_client.ClientContactType(Constant.DataType.userInput,0 ,"Sandata", false);

        boolean result3 =  altEVV_Generic_Pennsylvania_client.ClientContactType(Constant.DataType.userInput,0 ,null, true);

        Assert.assertTrue( result1 && result2 && result3, "Failed to validation for 'client first name' of a single alt evv generic client");

    }
}
