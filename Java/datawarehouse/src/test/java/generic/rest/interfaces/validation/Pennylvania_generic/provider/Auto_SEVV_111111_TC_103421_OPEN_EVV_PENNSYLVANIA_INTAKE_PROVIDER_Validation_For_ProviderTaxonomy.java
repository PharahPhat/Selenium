package generic.rest.interfaces.validation.Pennylvania_generic.provider;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103421_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_ProviderTaxonomy extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_103421_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_ProviderTaxonomy() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "Provider Records are not inserted into STX when max length of 'ProviderTaxonomy' field is 10 [max length = 9] ");

        boolean result1 = pennsylvania_provider.ProviderTaxonomy(Constant.DataType.alphabetic, 10, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Provider Records are not inserted into STX when max length of 'ProviderTaxonomy' field <= 9 [max length = 9] ");

        boolean result2 = pennsylvania_provider.ProviderTaxonomy(Constant.DataType.alphabetic, 5, "", true);
        boolean result3 = pennsylvania_provider.ProviderTaxonomy(Constant.DataType.alphabetic, 9, "", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "When enter ProviderTaxonomy = null ");

        boolean result4 = pennsylvania_provider.ProviderTaxonomy(Constant.DataType.userInput, 0, null, true);

        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "When enter ProviderTaxonomy with field trim space ");

        boolean result5 = pennsylvania_provider.ProviderTaxonomy(Constant.DataType.userInput, 0, "   ", true);

        logStepInfo("Step 5: Validate " +
                "response status FAILED, " +
                "When enter invalid value ProviderTaxonomy contains alphabet");

        boolean result6 = pennsylvania_provider.ProviderTaxonomy(Constant.DataType.userInput, 0, "123abc", false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5 && result6, "Failed to validation for ProviderTaxonomy of a single open evv pennsylvania provider");

    }
}
