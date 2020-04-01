package generic.rest.interfaces.validation.Pennylvania_generic.client;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Auto_SEVV_111111_TC_4782_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_clientfirstname extends InterfacesGenericTest {

    @Test
    public void Auto_SEVV_111111_TC_4782_EVV_GENERIC_PENNSYLVANIA_CLIENT_Validation_for_clientfirstname() {

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "Verify success message is returned \n" +
                "Load StagingClient Json with correct data:\n" +
                "- Length of ClientFirstName <= 30\n" +
                "- ClientFirstName value type is String");
        boolean result1 =  altEVV_Generic_Pennsylvania_client.ClientFirstName(Constant.DataType.alphabetic, 30,"", true);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Verify that ClientFirstName should be trim \n" +
                "Load StagingClient Json with correct data and existing spaces in ClientFirstName");
        String clientFNameTrim = " " + RandomStringUtils.randomAlphabetic(28) + " ";
        boolean result2 =  altEVV_Generic_Pennsylvania_client.ClientFirstName(Constant.DataType.userInput, 0,clientFNameTrim, true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "Verify error message is returned \n" +
                "Load Visit Json with incorrect data:\n" +
                "- Length of ClientFirstName > 30");
        boolean result3 =  altEVV_Generic_Pennsylvania_client.ClientFirstName(Constant.DataType.alphabetic, 31,"", false);

        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "Verify error message is returned \n" +
                "Load Visit Json with incorrect data:\n" +
                "- Length of ClientFirstName = null");
        boolean result4 =  altEVV_Generic_Pennsylvania_client.ClientFirstName(Constant.DataType.userInput, 0,null, false);

        Assert.assertTrue(result1 &&result2 && result3 &&result4 , "Failed to validation for 'client first name' of a single alt evv generic client");
    }
}
