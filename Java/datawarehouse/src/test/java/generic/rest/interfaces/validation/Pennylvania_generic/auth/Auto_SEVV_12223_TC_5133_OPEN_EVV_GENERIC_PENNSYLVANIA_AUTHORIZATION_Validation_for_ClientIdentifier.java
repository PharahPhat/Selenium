package generic.rest.interfaces.validation.Pennylvania_generic.auth;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_12223_TC_5133_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_ClientIdentifier extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_12223_TC_5133_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_ClientIdentifier() {
        /*Verify with valid values */
        boolean result1 = openEVV_Pennsylvania_Auth.ClientIdentifier(Constant.DataType.numeric, 64, "", true);
        /*Verify with Invalid values (over max-length)*/
        boolean result2 = openEVV_Pennsylvania_Auth.ClientIdentifier(Constant.DataType.numeric, 65, "", false);
        /*Verify value of field will be auto Trim spaces */
        String randomString = " " + RandomStringUtils.randomAlphabetic(62) + " ";
        boolean result3 = openEVV_Pennsylvania_Auth.ClientIdentifier(Constant.DataType.userInput, 0, randomString, true);
        /*Verify with invalid values (leave empty) */
        boolean result4 = openEVV_Pennsylvania_Auth.ClientIdentifier(Constant.DataType.userInput, 0, " ", true);
        /*Verify with Null */
        boolean result5 = openEVV_Pennsylvania_Auth.ClientIdentifier(Constant.DataType.userInput, 0, null, true);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5 , "Failed to validation for 'ClientIdentifier' of a single alt evv generic auth");
    }
}