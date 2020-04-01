package generic.rest.interfaces.validation.Pennylvania_generic.auth;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_12223_TC_5136_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_AuthorizationReferenceNumber extends InterfacesGenericTest{
    @Test
    public void Auto_SEVV_12223_TC_5136_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_AuthorizationReferenceNumber() {
        /*Verify with valid AuthorizationReferenceNumber */
        boolean result1 = openEVV_Pennsylvania_Auth.AuthorizationReferenceNumber(Constant.DataType.userInput, 0, "612873652", true);
        boolean result2 = openEVV_Pennsylvania_Auth.AuthorizationReferenceNumber(Constant.DataType.numeric, 30, "", true);
        boolean result3 = openEVV_Pennsylvania_Auth.AuthorizationReferenceNumber(Constant.DataType.alphaNumeric, 30, "", true);
        /*Verify with Invalid values (over max-length)*/
        boolean result4 = openEVV_Pennsylvania_Auth.AuthorizationReferenceNumber(Constant.DataType.numeric, 30, "", false);
        /*Verify with Invalid values (over max-length)*/
        boolean result5 = openEVV_Pennsylvania_Auth.AuthorizationReferenceNumber(Constant.DataType.alphaNumeric, 30, "", false);
        /*Verify value of field will be auto Trim spaces */
        String randomString = " " + RandomStringUtils.randomAlphabetic(28) + " ";
        boolean result6 = openEVV_Pennsylvania_Auth.AuthorizationReferenceNumber(Constant.DataType.userInput, 0, randomString, false);
        /*Verify with invalid values (leave empty) */
        boolean result7 = openEVV_Pennsylvania_Auth.AuthorizationReferenceNumber(Constant.DataType.userInput, 0, " ", false);
        /*Verify with Null */
        boolean result8 = openEVV_Pennsylvania_Auth.AuthorizationReferenceNumber(Constant.DataType.userInput, 0, null, false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5&& result6&& result7&& result8 , "Failed to validation for 'AuthorizationReferenceNumber' of a single alt evv generic auth");
    }
}
