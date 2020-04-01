package generic.rest.interfaces.validation.Pennylvania_generic.auth;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_12223_TC_5140_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_Modifier2 extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_12223_TC_5140_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_Modifier2() {
        /*Verify with valid Modifier2 */
        boolean result1 = openEVV_Pennsylvania_Auth.Modifier2(Constant.DataType.userInput, 0, "W1", true);
        boolean result2 = openEVV_Pennsylvania_Auth.Modifier2(Constant.DataType.numeric, 2, "", true);
        boolean result3 = openEVV_Pennsylvania_Auth.Modifier2(Constant.DataType.alphaNumeric, 2, "", true);
        /*Verify with Invalid values (over max-length)*/
        boolean result4 = openEVV_Pennsylvania_Auth.Modifier2(Constant.DataType.numeric, 3, "", false);
        boolean result5 = openEVV_Pennsylvania_Auth.Modifier2(Constant.DataType.alphaNumeric, 3, "", false);
        /*Verify value of field will be auto Trim spaces */
        String randomString = " " + RandomStringUtils.randomAlphabetic(1) + " ";
        boolean result6 = openEVV_Pennsylvania_Auth.Modifier2(Constant.DataType.userInput, 0, randomString, false);
        /*Verify with leave empty in this field */
        boolean result7 = openEVV_Pennsylvania_Auth.Modifier2(Constant.DataType.userInput, 0, " ", true);
        /*Modifier2 is non-required - Verify with Null */
        boolean result8 = openEVV_Pennsylvania_Auth.Modifier2(Constant.DataType.userInput, 0, null, true);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5&& result6&& result7&& result8 , "Failed to validation for 'Modifier2' of a single alt evv generic auth");
    }
}
