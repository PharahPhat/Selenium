package generic.rest.interfaces.validation.Pennylvania_generic.auth;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_12223_TC_5141_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_AuthorizationAmountType extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_12223_TC_5141_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_AuthorizationAmountType() {
        /*Verify 3 valid values (Use 3 values: H, V and U)*/
        boolean result1 =  openEVV_Pennsylvania_Auth.AuthorizationAmountType(Constant.DataType.userInput, 0,"H", true);
        boolean result2 =  openEVV_Pennsylvania_Auth.AuthorizationAmountType(Constant.DataType.userInput, 0,"V", true);
        boolean result3 =  openEVV_Pennsylvania_Auth.AuthorizationAmountType(Constant.DataType.userInput, 0,"U", true);

        /*Verify Invalid values (different 3 values: H, V and U)*/
        boolean result4 =  openEVV_Pennsylvania_Auth.AuthorizationAmountType(Constant.DataType.alphabetic, 1,"", false);
        boolean result5 =  openEVV_Pennsylvania_Auth.AuthorizationAmountType(Constant.DataType.userInput, 0,"P", false);
        /*Verify value of field will be auto Trim spaces */
        String randomString = " ";
        boolean result6 =  openEVV_Pennsylvania_Auth.AuthorizationAmountType(Constant.DataType.userInput, 0,randomString, false);
        /*Verify with invalid values (leave empty) */
        boolean result7 =  openEVV_Pennsylvania_Auth.AuthorizationAmountType(Constant.DataType.userInput, 0,"", false);
        /*AuthorizationAmountType is Required - Verify with null value */
        boolean result8 =  openEVV_Pennsylvania_Auth.AuthorizationAmountType(Constant.DataType.userInput, 0,null, false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5 && result6 && result7&& result8, "Failed to validation for 'AuthorizationAmountType' of a single alt evv generic auth");
    }
}
