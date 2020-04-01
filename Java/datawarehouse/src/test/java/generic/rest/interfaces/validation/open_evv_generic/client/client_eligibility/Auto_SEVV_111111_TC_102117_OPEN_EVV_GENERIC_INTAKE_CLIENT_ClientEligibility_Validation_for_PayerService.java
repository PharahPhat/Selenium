package generic.rest.interfaces.validation.open_evv_generic.client.client_eligibility;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102117_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientEligibility_Validation_for_PayerService extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102117_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientEligibility_Validation_for_PayerServices() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'PayerService' field is 6 [max length = 5] ");

        boolean result1 = openEVVMemberModel.PayerService(Constant.DataType.alphabetic, 6, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "when enter valid value of 'PayerService' ");

        boolean result2 = openEVVMemberModel.PayerService(Constant.DataType.userInput, 0, "T1000", true);

        Assert.assertTrue(result1 && result2, "Failed to validation for PayerService of a single open evv generic client");

    }
}
