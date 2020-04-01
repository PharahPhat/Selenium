package generic.rest.interfaces.validation.Pennylvania_generic.client;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_4931_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_Omit_fields extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_4931_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_Omit_fields() {

        boolean result1 =  altEVV_Generic_Pennsylvania_client.ClientID(Constant.DataType.userInput,0 ,null, true);

        boolean result2 =  altEVV_Generic_Pennsylvania_client.ClientMiddleInitial(Constant.DataType.userInput,0 ,null, true);

        boolean result3 =  altEVV_Generic_Pennsylvania_client.ClientSSN(Constant.DataType.userInput, 0 ,null, true);

        boolean result4 =  altEVV_Generic_Pennsylvania_client.ClientSSN(Constant.DataType.userInput, 0 ,null, true);

        boolean result5 =  altEVV_Generic_Pennsylvania_client.ClientPayerID(Constant.DataType.userInput, 0 ,null, true);

        //boolean result6 =  altEVV_Generic_Pennsylvania_client.ClientEligibilityDateBegin(Constant.data_type.userInput, 0 ,null, true);

        //boolean result7 =  altEVV_Generic_Pennsylvania_client.ClientEligibilityDateEnd(Constant.data_type.userInput, 0 ,null, true);

        boolean result8 =  altEVV_Generic_Pennsylvania_client.ClientStatus(Constant.DataType.userInput, 0 ,null, true);

        boolean result9 =  altEVV_Generic_Pennsylvania_client.ClientCounty(Constant.DataType.userInput, 0 ,null, true);

        boolean result10 =  altEVV_Generic_Pennsylvania_client.ClientPhoneType(Constant.DataType.userInput, 0 ,null, true);

        //boolean result11 =  altEVV_Generic_Pennsylvania_client.ClientPhoneNumber(Constant.data_type.userInput, 0 ,null, true);

        Assert.assertTrue(result1&& result10 && result9 && result2 && result3 && result4 && result5 && result8, "Failed to validation for 'client first name' of a single alt evv generic client");

    }
}
