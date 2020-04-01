package generic.rest.interfaces.validation.open_evv_generic.client.client_address;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103305_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientAddress_Validation_for_ClientState extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_103305_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientAddress_Validation_for_ClientState() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientState' field is 3 [max length = 2] ");

        boolean result1 = openEVVMemberModel.ClientState(Constant.DataType.alphabetic, 3, "", false);

        logStepInfo("Step 2: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when value of 'ClientState' field is null or empty");

        boolean result2 = openEVVMemberModel.ClientState(Constant.DataType.userInput, 0, "", false);

        logStepInfo("Step 3: Validate response status SUCCESS, " +
                "StagingClient Records are inserted into STX " +
                "when enter correct value into 'ClientState' field");

        boolean result3 = openEVVMemberModel.ClientState(Constant.DataType.userInput, 0, "NY", true);

        logStepInfo("Step 4: Validate response status SUCCESS, " +
                "StagingClient Records are inserted into STX " +
                "when enter in-correct value into 'ClientState' field");

        boolean result4 = openEVVMemberModel.ClientState(Constant.DataType.userInput, 0, "00", true);

        Assert.assertTrue(result1 && result2 && result3 && result4, "Failed to validation for ClientState of a single open evv generic client");
    }
}