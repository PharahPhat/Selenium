package generic.rest.interfaces.validation.open_evv_generic.client.client_eligibility;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102119_OPEN_EVV_GENERIC_INTAKE_CLIENT_Staging_ClientEligibility_Validation_for_PayerRegion extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102119_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientEligibility_Validation_for_PayerRegion() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'PayerRegion' field is 3 [max length = 2] ");

        boolean result1 = openEVVMemberModel.PayerRegion(Constant.DataType.alphabetic, 3, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "when enter valid value of 'PayerRegion' ");

        boolean result2 = openEVVMemberModel.PayerRegion(Constant.DataType.userInput, 0, "NA", true);

        Assert.assertTrue(result1 && result2, "Failed to validation for PayerRegion of a single open evv generic client");

    }
}
