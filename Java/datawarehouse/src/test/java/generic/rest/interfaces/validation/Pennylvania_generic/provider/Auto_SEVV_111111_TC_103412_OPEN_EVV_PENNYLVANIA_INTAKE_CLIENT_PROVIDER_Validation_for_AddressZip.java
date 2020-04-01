package generic.rest.interfaces.validation.Pennylvania_generic.provider;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103412_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_AddressZip extends InterfacesGenericTest {

    @Test
    public void Auto_SEVV_111111_TC_103412_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_AddressZip() {

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "Using API to create new provider with AddressZip parameter is valid value (=9 digits OR =5 digits) - Leading different '0' chars");
        boolean result1 =  pennsylvania_provider.AddressZip(Constant.DataType.numeric, 9, "", true);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Using API to create new provider with trim spaces in AddressZip parameter");
        String addressZipTrimSpace = " " + RandomStringUtils.randomNumeric(7) + " ";
        boolean result2 =  pennsylvania_provider.AddressZip(Constant.DataType.userInput, 0, addressZipTrimSpace, true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "- Using API to create new provider with AddressZip parameter = null");
        boolean result3 =  pennsylvania_provider.AddressZip(Constant.DataType.userInput, 0, "", false);

        logStepInfo("Step 4: Validate " +
                "response status FAILED, " +
                "- Using API to create new provider with AddressZip parameter is chars");
        boolean result4 =  pennsylvania_provider.AddressZip(Constant.DataType.alphabetic, 9, "", false);

        logStepInfo("Step 5: Validate " +
                "response status FAILED, " +
                "- Using API to create new provider with AddressZip parameter is special chars");
        String addressZipSpecialChars = "_^*%$#@!~";
        boolean result5 =  pennsylvania_provider.AddressZip(Constant.DataType.userInput, 0, addressZipSpecialChars, false);
        Assert.assertTrue(result1 && result2 && result3 && result4 && result5, "Failed to validation for AddressZip of a single open evv generic provider");
    }
}
