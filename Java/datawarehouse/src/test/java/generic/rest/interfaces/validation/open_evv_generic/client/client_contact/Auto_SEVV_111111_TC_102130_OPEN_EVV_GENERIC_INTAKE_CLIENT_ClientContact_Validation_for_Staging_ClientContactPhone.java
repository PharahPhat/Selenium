package generic.rest.interfaces.validation.open_evv_generic.client.client_contact;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102130_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientContact_Validation_for_Staging_ClientContactPhone extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102130_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientContact_Validation_for_ClientContactPhone() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientContactPhone' field is 11 [max length = 10] ");

        boolean result1 = openEVVMemberModel.ClientContactPhone(Constant.DataType.numeric, 11, "Home", "", false);

        logStepInfo("Step 2: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when length of 'ClientContactPhone' field is 9 [max length = 10] ");

        boolean result2 = openEVVMemberModel.ClientContactPhone(Constant.DataType.numeric, 9, "Home", "", false);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when input incorrect data , length of 'ClientContactPhone' field = 10");

        boolean result3 = openEVVMemberModel.ClientContactPhone(Constant.DataType.userInput, 0, "Home", "123abc4561", false);

        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records are inserted into STX when input correct data with length of 'ClientContactPhone' field = 10");
        boolean result4 = openEVVMemberModel.ClientContactPhone(Constant.DataType.userInput, 0, "Home", "1234567890", true);

        Assert.assertTrue(result1 && result2 && result3 && result4, "Failed to validation for ClientContactPhone of a single open evv generic client");
    }
}
