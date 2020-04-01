package generic.rest.interfaces.validation.Pennylvania_generic.provider;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103422_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_ProviderRequireAuth extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_103422_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_ProviderRequireAuth() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "Provider Records are not inserted into STX when max length of 'ProviderRequireAuth' field is 2 [max length = 1] ");

        boolean result1 = pennsylvania_provider.ProviderRequireAuth(Constant.DataType.numeric, 2, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Provider Records are inserted into STX when enter valid value of 'ProviderRequireAuth' ('0' or '1')");

        boolean result2 = pennsylvania_provider.ProviderRequireAuth(Constant.DataType.userInput, 0, "0", true);
        boolean result3 = pennsylvania_provider.ProviderRequireAuth(Constant.DataType.userInput, 0, "1", true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "Provider Records are not inserted into STX when enter invalid value of 'ProviderRequireAuth' <> '0'/'1' ");

        boolean result4 = pennsylvania_provider.ProviderRequireAuth(Constant.DataType.userInput, 0, "4", false);
        boolean result5 = pennsylvania_provider.ProviderRequireAuth(Constant.DataType.userInput, 0, "A", false);

        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "Provider Records are inserted into STX when enter trim space in 'ProviderRequireAuth'");

        boolean result6 = pennsylvania_provider.ProviderRequireAuth(Constant.DataType.userInput, 0, "  ", true);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5 && result6, "Failed to validation for ProviderRequireAuth of a single open evv pennsylvania provider");

    }
}
