package generic.rest.interfaces.validation.Pennylvania_generic.auth;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_12223_TC_5144_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_AuthorizationMaximum extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_12223_TC_5144_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_AuthorizationMaximum() {
        /*Verify valid values - numberic*/
        boolean result1 =  openEVV_Pennsylvania_Auth.AuthorizationMaximum(Constant.DataType.userInput, 0,"4560", true);
        boolean result2 =  openEVV_Pennsylvania_Auth.AuthorizationMaximum(Constant.DataType.numeric, 10,"", true);

        /*Verify Invalid values (over max-length)*/
        boolean result3 =  openEVV_Pennsylvania_Auth.AuthorizationMaximum(Constant.DataType.alphabetic, 11,"", false);
        boolean result4 =  openEVV_Pennsylvania_Auth.AuthorizationMaximum(Constant.DataType.numeric, 11,"P", false);
        /*Verify value of field will be auto Trim spaces */
        String randomString = " " + RandomStringUtils.randomAlphabetic(8) + " ";
        boolean result5 =  openEVV_Pennsylvania_Auth.AuthorizationMaximum(Constant.DataType.userInput, 0,randomString, true);
        /*Verify with invalid values (leave empty) */
        boolean result6 =  openEVV_Pennsylvania_Auth.AuthorizationMaximum(Constant.DataType.userInput, 0,"", false);
        /*AuthorizationMaximum is Required - Verify with null value */
        boolean result7 =  openEVV_Pennsylvania_Auth.AuthorizationMaximum(Constant.DataType.userInput, 0,null, false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5 && result6 && result7, "Failed to validation for 'AuthorizationMaximum' of a single alt evv generic auth");
    }
}
