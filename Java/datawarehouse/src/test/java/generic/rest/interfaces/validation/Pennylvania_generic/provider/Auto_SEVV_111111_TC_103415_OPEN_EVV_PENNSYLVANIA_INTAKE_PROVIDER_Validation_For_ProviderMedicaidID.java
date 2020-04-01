package generic.rest.interfaces.validation.Pennylvania_generic.provider;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103415_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_ProviderMedicaidID extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_103415_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_ProviderMedicaidID() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "Provider Records are not inserted into STX when max length of 'ProviderMedicaidID' field is 10 [max length = 9] ");

        boolean result1 = pennsylvania_provider.ProviderMedicaidID(Constant.DataType.numeric, 10, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Provider Records are inserted into STX when max length of 'ProviderMedicaidID' field is 9 [max length = 9] ");

        boolean result2 = pennsylvania_provider.ProviderMedicaidID(Constant.DataType.numeric, 9, "", true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "When ProviderMedicaidID parameter = null");

        boolean result3 = pennsylvania_provider.ProviderMedicaidID(Constant.DataType.userInput, 0, null, false);

        Assert.assertTrue(result1 && result2 && result3, "Failed to validation for ProviderMedicaidID of a single open evv pennsylvania provider");

    }
}
