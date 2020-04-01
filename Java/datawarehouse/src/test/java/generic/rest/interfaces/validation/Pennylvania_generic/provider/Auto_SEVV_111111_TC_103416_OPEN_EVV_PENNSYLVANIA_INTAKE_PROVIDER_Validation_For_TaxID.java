package generic.rest.interfaces.validation.Pennylvania_generic.provider;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103416_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_TaxID extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_103416_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_TaxID() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "Provider Records are not inserted into STX when max length of 'TaxID' field is 10 [max length = 9] ");

        boolean result1 = pennsylvania_provider.TaxID(Constant.DataType.numeric, 10, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Provider Records are inserted into STX when max length of 'TaxID' field is 9 [max length = 9] ");

        boolean result2 = pennsylvania_provider.TaxID(Constant.DataType.numeric, 9, "", true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "When TaxID parameter = null");

        boolean result3 = pennsylvania_provider.TaxID(Constant.DataType.userInput, 0, null, false);

        logStepInfo("Step 4: Validate " +
                "response status FAILED, " +
                "When TaxID parameter has any character");

        boolean result4 = pennsylvania_provider.TaxID(Constant.DataType.userInput, 0, "abcTest", false);

        Assert.assertTrue(result1 && result2 && result3 && result4, "Failed to validation for TaxID of a single open evv pennsylvania provider");

    }
}
