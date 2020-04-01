package generic.rest.interfaces.validation.open_evv_generic.client.client_contact;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102131_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientContact_Validation_for_ClientContactEmailAddress extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102131_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientContact_Validation_for_ClientContactEmailAddress() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientContactEmailAddress' field is 65 [max length = 64] ");

        boolean result1 = openEVVMemberModel.ClientContactEmailAddress(Constant.DataType.alphabetic, 65, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records are inserted into STX when enter valid value 'ClientContactEmailAddress'");

        boolean result2 = openEVVMemberModel.ClientContactEmailAddress(Constant.DataType.userInput, 0, "ClientContactEmailAddressTest@gmail.com", true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when input in-correct format 'ClientContactEmailAddress' field is abc@.@.com");

        boolean result3 = openEVVMemberModel.ClientContactEmailAddress(Constant.DataType.userInput, 0, "abc@.@.com", false);

        Assert.assertTrue(result1 && result2 && result3, "Failed to validation for ClientContactEmailAddress of a single open evv generic client");
    }
}
