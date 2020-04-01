package generic.rest.interfaces.validation.Pennylvania_generic.provider;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103419_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_ProviderNPI extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_103419_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_ProviderNPI() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "Provider Records are not inserted into STX when max length of 'ProviderNPI' field is 11 [max length = 10] ");

        boolean result1 = pennsylvania_provider.ProviderNPI(Constant.DataType.numeric, 11, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Provider Records are inserted into STX when max length of 'ProviderNPI' field is 10 [max length = 10] ");

        boolean result2 = pennsylvania_provider.ProviderNPI(Constant.DataType.numeric, 10, "", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "When ProviderNPI parameter = null");

        boolean result3 = pennsylvania_provider.ProviderNPI(Constant.DataType.userInput, 0, null, true);

        logStepInfo("Step 4: Validate " +
                "response status FAILED, " +
                "When ProviderNPI parameter has any character");

        boolean result4 = pennsylvania_provider.ProviderNPI(Constant.DataType.userInput, 0, "abcTest", false);

        logStepInfo("Step 5: Validate " +
                "response status SUCCESS, " +
                "When ProviderNPI parameter with field trim space ");

        boolean result5 = pennsylvania_provider.ProviderNPI(Constant.DataType.userInput, 0, "   ", true);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5, "Failed to validation for ProviderNPI of a single open evv pennsylvania provider");

    }
}
