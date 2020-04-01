package generic.rest.interfaces.validation.Pennylvania_generic.auth;


import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_12223_TC_5135_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_ProviderID extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_12223_TC_5135_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_ProviderID() {
        /*Verify with existing providerID */
        boolean result1 = openEVV_Pennsylvania_Auth.ProviderID(Constant.DataType.userInput, 0, "612873652", true);
        /*Verify with unreal providerID*/
        boolean result2 = openEVV_Pennsylvania_Auth.ProviderID(Constant.DataType.numeric, 64, "", false);
        /*Verify with Invalid values (over max-length)*/
        boolean result3 = openEVV_Pennsylvania_Auth.ProviderID(Constant.DataType.numeric, 65, "", false);
        /*Verify with Invalid values (over max-length)*/
        boolean result4 = openEVV_Pennsylvania_Auth.ProviderID(Constant.DataType.alphaNumeric, 65, "", false);
        /*Verify value of field will be auto Trim spaces */
        String randomString = " " + RandomStringUtils.randomAlphabetic(62) + " ";
        boolean result5 = openEVV_Pennsylvania_Auth.ProviderID(Constant.DataType.userInput, 0, randomString, false);
        /*Verify with invalid values (leave empty) */
        boolean result6 = openEVV_Pennsylvania_Auth.ProviderID(Constant.DataType.userInput, 0, " ", false);
        /*Verify with Null */
        boolean result7 = openEVV_Pennsylvania_Auth.ProviderID(Constant.DataType.userInput, 0, null, false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5 , "Failed to validation for 'ProviderID' of a single alt evv generic auth");
    }
}