package generic.rest.interfaces.validation.Pennylvania_generic.provider;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103410_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_provider_id extends InterfacesGenericTest {

    @Test
    public void Auto_SEVV_111111_TC_103410_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_provider_id() {

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "Use API above to create new provider with ProviderID parameter = 13 digits");
        boolean result1 =  pennsylvania_provider.ProviderID(Constant.DataType.numeric, 13, "", true);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Use API above to create new provider with trim spaces in ProviderID parameter");
        String providerTrimSpace  = " " + RandomStringUtils.randomNumeric(11) + " ";
        boolean result2 =  pennsylvania_provider.ProviderID(Constant.DataType.userInput , 0, providerTrimSpace, true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "Use API above to create new provider with ProviderID parameter = null");
        boolean result3 =  pennsylvania_provider.ProviderID(Constant.DataType.userInput , 0, "", false);

        logStepInfo("Step 4: Validate " +
                "response status FAILED, " +
                "Use API above to create new provider with ProviderID parameter invalid digits (<13 digits or > 13 digits)");
        boolean result4 =  pennsylvania_provider.ProviderID(Constant.DataType.numeric, 14, "", false);

        logStepInfo("Step 5: Validate " +
                "response status FAILED, " +
                "Use API above to create new provider with ProviderID parameter has any character");
        boolean result5 =  pennsylvania_provider.ProviderID(Constant.DataType.alphabetic, 13, "", false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5, "Failed to validation for provider_id of a single open evv generic provider");
    }
}
