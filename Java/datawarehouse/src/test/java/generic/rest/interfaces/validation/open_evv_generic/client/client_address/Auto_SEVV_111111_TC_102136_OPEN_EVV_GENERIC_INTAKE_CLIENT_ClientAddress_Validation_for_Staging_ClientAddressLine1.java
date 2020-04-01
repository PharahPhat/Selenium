package generic.rest.interfaces.validation.open_evv_generic.client.client_address;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102136_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientAddress_Validation_for_Staging_ClientAddressLine1 extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_102136_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientAddress_Validation_for_ClientAddressLine1(){
        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records are inserted into STX when max length of 'ClientAddressLine1' field is 30 [max length = 30] ");

        boolean result1 = openEVVMemberModel.ClientAddressLine1(Constant.DataType.alphabetic, 30, "", true);

        logStepInfo("Step 2: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientAddressLine1' field is 31 [max length = 30] ");

        boolean result2 = openEVVMemberModel.ClientAddressLine1(Constant.DataType.alphabetic, 31, "", false);


        logStepInfo("Step 3: Validate response status FAILED, " +
                "StagingClient Records are not inserted into STX " +
                "when enter in-correct value of 'ClientAddressLine1' field: null ");

        boolean result3 = openEVVMemberModel.ClientAddressLine1(Constant.DataType.userInput, 0, "", false);

        Assert.assertTrue(result1 && result2 && result3, "Failed to validation for ClientAddressLine1 of a single open evv generic client");
    }
}