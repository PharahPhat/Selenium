package generic.rest.interfaces.validation.Pennylvania_generic.auth;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_12223_TC_5476_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_AuthorizationStatus extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_12223_TC_5476_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_AuthorizationStatus() {
        /*Verify with 4 valid values (A, I, V, S) */
        boolean result1 =  openEVV_Pennsylvania_Auth.AuthorizationStatus(Constant.DataType.userInput, 0,"A", true);
        boolean result2 =  openEVV_Pennsylvania_Auth.AuthorizationStatus(Constant.DataType.userInput, 0,"I", true);
        boolean result3 =  openEVV_Pennsylvania_Auth.AuthorizationStatus(Constant.DataType.userInput, 0,"V", true);
        boolean result4 =  openEVV_Pennsylvania_Auth.AuthorizationStatus(Constant.DataType.userInput, 0,"S", true);
        /*Verify with invalid values (different values: A, I, V, S) */
        boolean result5 =  openEVV_Pennsylvania_Auth.AuthorizationStatus(Constant.DataType.userInput, 0,"T", false);
        boolean result6 =  openEVV_Pennsylvania_Auth.AuthorizationStatus(Constant.DataType.userInput, 0,"TA", false);

        /*Verify with invalid values (leave empty or spaces) */
        boolean result7 =  openEVV_Pennsylvania_Auth.AuthorizationStatus(Constant.DataType.userInput, 0," ", false);

        /*Verify with invalid values (Null) */
        boolean result8 =  openEVV_Pennsylvania_Auth.AuthorizationStatus(Constant.DataType.userInput, 0,null, false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5 && result6 && result7 && result8 , "Failed to validation for 'AuthorizationStatus' of a single alt evv generic auth");

    }
}
