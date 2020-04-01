package generic.rest.interfaces.validation.Pennylvania_generic.provider;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103411_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_AddressLine1 extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_103411_OPEN_EVV_PENNSYLVANIA_INTAKE_PROVIDER_Validation_For_AddressLine1() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "Provider Records are not inserted into STX when max length of 'AddressLine1' field is 51 [max length = 50] ");

        boolean result1 = pennsylvania_provider.AddressLine1(Constant.DataType.alphabetic, 51, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Provider Records are inserted into STX when max length of 'AddressLine1' field < 50 [max length = 50] ");

        boolean result2 = pennsylvania_provider.AddressLine1(Constant.DataType.alphabetic, 40, "", true);

        Assert.assertTrue(result1 && result2, "Failed to validation for AddressLine1 of a single open evv pennsylvania provider");

    }
}
