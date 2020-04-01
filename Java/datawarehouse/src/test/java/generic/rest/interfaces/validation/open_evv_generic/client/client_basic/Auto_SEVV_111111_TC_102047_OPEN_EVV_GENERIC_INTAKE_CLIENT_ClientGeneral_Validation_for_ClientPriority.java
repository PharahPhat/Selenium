package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102047_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientPriority extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_102047_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientPriority() {
        logStepInfo("Step 1: Validate " +
                "response status PASSED, " +
                "StagingClient Records are inserted into STX when value of 'ClientPriority' field is 2 [max length = 2]");
        boolean result1 = openEVVMemberModel.ClientPriority(Constant.DataType.userInput, 02, "ab", true);

        logStepInfo("Step 2: Validate " +
                "response status PASSED, " +
                "StagingClient Records are inserted into STX when value of 'ClientPriority' field is 1 [max length = 2]");
        boolean result2 = openEVVMemberModel.ClientPriority(Constant.DataType.userInput, 02, "a", true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "StagingClient Records are inserted into STX when value of 'ClientPriority' field is 3 [max length = 2]");
        boolean result3 = openEVVMemberModel.ClientPriority(Constant.DataType.userInput, 02, "ab2", false);

        logStepInfo("Step 4: Validate " +
                "response status PASSED, " +
                "StagingClient Records are inserted into STX when value of 'ClientPriority' field is null [max length = 2]");
        boolean result4 = openEVVMemberModel.ClientPriority(Constant.DataType.userInput, 02, null, true);

        Assert.assertTrue(result1 && result2 && result3 && result4, "Failed to validation for ClientPriority of a single open evv generic client");

    }
}
