package generic.rest.interfaces.validation.Pennylvania_generic.auth;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_12223_TC_5132_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_ClientQualifier extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_12223_TC_5132_OPEN_EVV_GENERIC_PENNSYLVANIA_AUTHORIZATION_Validation_for_ClientQualifier() {
        /*Verify with valid values ('ClientCustomID')*/
        boolean result1 =  openEVV_Pennsylvania_Auth.ClientQualifier(Constant.DataType.userInput, 0,"ClientCustomID", true);
        /*Verify with Invalid values (different 'ClientCustomID')*/
        boolean result2 =  openEVV_Pennsylvania_Auth.ClientQualifier(Constant.DataType.userInput, 0,"ClientOtherID", false);
        boolean result3 =  openEVV_Pennsylvania_Auth.ClientQualifier(Constant.DataType.userInput, 0,"ClientSSN", false);
        boolean result4 =  openEVV_Pennsylvania_Auth.ClientQualifier(Constant.DataType.alphabetic, 30,"", false);
        boolean result5 =  openEVV_Pennsylvania_Auth.ClientQualifier(Constant.DataType.alphaNumeric, 30,"", false);
        /*Verify value of field will be auto Trim spaces */
        String randomString = " " + RandomStringUtils.randomAlphabetic(28) + " ";
        boolean result6 =  openEVV_Pennsylvania_Auth.ClientQualifier(Constant.DataType.userInput, 0,randomString, false);
        /*Verify with invalid values (leave empty) */
        boolean result7 =  openEVV_Pennsylvania_Auth.ClientQualifier(Constant.DataType.userInput, 0," ", false);
        /*Verify with invalid values (Null) */
        boolean result8 =  openEVV_Pennsylvania_Auth.ClientQualifier(Constant.DataType.userInput, 0,null, false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5 && result6 && result7&& result8, "Failed to validation for 'ClientQualifier' of a single alt evv generic auth");
    }
}

