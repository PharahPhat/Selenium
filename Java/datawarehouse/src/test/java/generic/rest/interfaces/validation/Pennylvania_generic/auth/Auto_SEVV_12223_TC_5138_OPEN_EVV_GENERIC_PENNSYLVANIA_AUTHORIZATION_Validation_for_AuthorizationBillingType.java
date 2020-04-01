package generic.rest.interfaces.validation.Pennylvania_generic.auth;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_12223_TC_5138_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_AuthorizationBillingType extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_12223_TC_5137_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_AuthorizationBillingType() {
        /*Verify with valid AuthorizationBillingType */
        boolean result1 = openEVV_Pennsylvania_Auth.AuthorizationBillingType(Constant.DataType.userInput, 0, "W1234", true);
        boolean result2 = openEVV_Pennsylvania_Auth.AuthorizationBillingType(Constant.DataType.numeric, 64, "", true);
        boolean result3 = openEVV_Pennsylvania_Auth.AuthorizationBillingType(Constant.DataType.alphaNumeric, 5, "", true);
        /*Verify with Invalid values (over max-length)*/
        boolean result4 = openEVV_Pennsylvania_Auth.AuthorizationBillingType(Constant.DataType.numeric, 65, "", false);
        /*Verify with Invalid values (over max-length)*/
        boolean result5 = openEVV_Pennsylvania_Auth.AuthorizationBillingType(Constant.DataType.alphaNumeric, 65, "", false);
        /*Verify value of field will be auto Trim spaces */
        String randomString = " " + RandomStringUtils.randomAlphabetic(62) + " ";
        boolean result6 = openEVV_Pennsylvania_Auth.AuthorizationBillingType(Constant.DataType.userInput, 0, randomString, false);
        /*Verify with leave empty in this field */
        boolean result7 = openEVV_Pennsylvania_Auth.AuthorizationBillingType(Constant.DataType.userInput, 0, " ", true);
        /*AuthorizationBillingType is non-required - Verify with Null */
        boolean result8 = openEVV_Pennsylvania_Auth.AuthorizationBillingType(Constant.DataType.userInput, 0, null, true);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5&& result6&& result7&& result8 , "Failed to validation for 'AuthorizationBillingType' of a single alt evv generic auth");
    }
}
