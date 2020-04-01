package generic.rest.interfaces.validation.open_evv_generic.client.client_address;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102138_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientAddress_Validation_for_ClientCounty extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102138_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientAddress_Validation_for_ClientCounty() {
        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records are inserted into STX when max length of 'ClientCounty' field is 25 [max length = 25] ");

        boolean result1 = openEVVMemberModel.ClientCounty(Constant.DataType.alphabetic, 25, "", true);

        logStepInfo("Step 2: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientCounty' field is 26 [max length = 25] ");

        boolean result2 = openEVVMemberModel.ClientCounty(Constant.DataType.alphabetic, 26, "", false);

        logStepInfo("Step 3: Validate response status SUCCESS, " +
                "StagingClient Records are not inserted into STX " +
                "when enter into 'ClientCounty' field with value null or empty");

        boolean result3 = openEVVMemberModel.ClientCounty(Constant.DataType.userInput, 0, "", true);

        Assert.assertTrue(result1 && result2 && result3, "Failed to validation for ClientCounty of a single open evv generic client");
    }
}