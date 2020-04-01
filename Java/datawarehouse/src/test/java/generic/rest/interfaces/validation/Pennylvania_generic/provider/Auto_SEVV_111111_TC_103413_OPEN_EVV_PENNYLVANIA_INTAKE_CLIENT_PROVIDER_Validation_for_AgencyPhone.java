package generic.rest.interfaces.validation.Pennylvania_generic.provider;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103413_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_AgencyPhone extends InterfacesGenericTest {

    @Test
    public void Auto_SEVV_111111_TC_103413_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_AgencyPhone() {

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "Upload the file to create new provider with AgencyPhone parameter = 10 digits");
        boolean result1 =  pennsylvania_provider.AgencyPhone(Constant.DataType.numeric, 10, "", true);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Upload the file to create new provider with trim spaces in AgencyPhone parameter");
        String AgencyPhoneTrimSpace = " " + RandomStringUtils.randomNumeric(8) + " ";
        boolean result2 =  pennsylvania_provider.AgencyPhone(Constant.DataType.userInput, 0, AgencyPhoneTrimSpace, true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "Upload the file to create new provider with AgencyPhone parameter = null");
        boolean result3 =  pennsylvania_provider.AgencyPhone(Constant.DataType.userInput, 0, "", false);

        logStepInfo("Step 4: Validate " +
                "response status FAILED, " +
                "Upload the file to create new provider with AgencyPhone invalid digits (<10 digits or > 10 digits)");
        boolean result4 =  pennsylvania_provider.AgencyPhone(Constant.DataType.numeric, 9, "", false);

        logStepInfo("Step 5: Validate " +
                "response status FAILED, " +
                "Upload the file to create new provider with AgencyPhone parameter has any character");
        boolean result5 =  pennsylvania_provider.AgencyPhone(Constant.DataType.alphaNumeric, 10, "", false);

        Assert.assertTrue(result1 && result2 && result3 & result4 && result5, "Failed to validation for AgencyPhone of a single open evv pennsylvania provider");
    }
}
