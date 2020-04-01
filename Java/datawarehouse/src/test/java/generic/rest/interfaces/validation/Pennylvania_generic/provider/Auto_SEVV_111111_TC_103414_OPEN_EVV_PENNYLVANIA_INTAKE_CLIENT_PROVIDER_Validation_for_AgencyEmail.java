package generic.rest.interfaces.validation.Pennylvania_generic.provider;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103414_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_AgencyEmail extends InterfacesGenericTest {

    @Test
    public void Auto_SEVV_111111_TC_103414_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_AgencyEmail() {

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "Create new provider with AgencyEmail parameter is valid value (only 1 @ in email, existing dot char, a~z, A~Z, _,-, 0~9)");
        String validEmail = "test" + RandomStringUtils.randomAlphabetic(5) + "@test.com";
        boolean result1 =  pennsylvania_provider.AgencyEmail(Constant.DataType.userInput, 0, validEmail, true);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Create new provider with AgencyEmail parameter is valid value (1< AgencyEmail <=64 chars )");
        String validEmail64length = RandomStringUtils.randomAlphabetic(55) + "@test.com";
        boolean result2 =  pennsylvania_provider.AgencyEmail(Constant.DataType.userInput, 0, validEmail64length, true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "Create new provider with trim spaces in AgencyEmail parameter");
        String validEmailTrimSpace = "test" + RandomStringUtils.randomAlphabetic(5) + "@test.com";
        boolean result3 =  pennsylvania_provider.AgencyEmail(Constant.DataType.userInput, 0, validEmailTrimSpace, true);

        logStepInfo("Step 4: Validate " +
                "response status FAILED, " +
                "Create new provider with AgencyEmail parameter is over maxlength (email > 64 chars)");
        String validEmailMore64length = RandomStringUtils.randomAlphabetic(56) + "@test.com";
        boolean result4 =  pennsylvania_provider.AgencyEmail(Constant.DataType.userInput, 0, validEmailMore64length, false);

        logStepInfo("Step 5: Validate " +
                "response status FAILED, " +
                "Create new provider with AgencyEmail parameter is digits");
        boolean result5 =  pennsylvania_provider.AgencyEmail(Constant.DataType.numeric, 10, "", false);

        logStepInfo("Step 6: Validate " +
                "response status FAILED, " +
                "Create new provider with AgencyEmail parameter = null");
        boolean result6 =  pennsylvania_provider.AgencyEmail(Constant.DataType.userInput, 0, "", false);

        Assert.assertTrue(result1 && result2 && result3 & result4 && result5 && result6 , "Failed to validation for AgencyEmail of a single open evv pennsylvania provider");
    }
}
