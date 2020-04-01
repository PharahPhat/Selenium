package generic.rest.interfaces.validation.Pennylvania_generic.client;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_4785_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_clientmedicaidId extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_4785_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_clientmedicaidId() {

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "Use API above to create new client with - Length of ClientMedicaidId <= 64\n" +
                "- ClientMedicaidId value type is String");
        boolean result1 =  altEVV_Generic_Pennsylvania_client.ClientMedicaidID(Constant.DataType.numeric,64 ,"", true);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Use API above to create new client with - Length of ClientMedicaidId > 64\n" +
                "- ClientMedicaidId value type is String");
        boolean result2 =  altEVV_Generic_Pennsylvania_client.ClientMedicaidID(Constant.DataType.numeric,65 ,"", false);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "Use API above to create new client with - Length of ClientMedicaidId = null \n" +
                "- ClientMedicaidId value type is String");
        boolean result3 =  altEVV_Generic_Pennsylvania_client.ClientMedicaidID(Constant.DataType.userInput,0 ,null, false);

        Assert.assertTrue(result1 && result2 && result3, "Failed to validation for  single alt evv generic client");

    }
}
