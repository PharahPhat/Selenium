package generic.rest.interfaces.validation.open_evv_generic.client.client_eligibility;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102118_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientEligibility_Validation_for_ClientStatus extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102118_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientEligibility_Validation_for_ClientStatus() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientStatus' field is 3 [max length = 2] ");

        boolean result1 = openEVVMemberModel.ClientStatus(Constant.DataType.alphabetic, 3, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "when enter valid value of 'ClientStatus' ");

        boolean result2 = openEVVMemberModel.ClientStatus(Constant.DataType.userInput, 0, "02", true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientStatus' field is 1 [max length = 2] ");

        boolean result3 = openEVVMemberModel.ClientStatus(Constant.DataType.alphabetic, 1, "", false);

        logStepInfo("Step 4: Validate " +
                "response status FAILED, " +
                "when enter invalid value of 'ClientStatus'");

        boolean result4 = openEVVMemberModel.ClientStatus(Constant.DataType.userInput, 0, "aa", false);

        Assert.assertTrue(result1 && result2 && result3 && result4, "Failed to validation for ClientStatus of a single open evv generic client");

    }
}
