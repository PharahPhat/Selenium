package generic.rest.interfaces.validation.open_evv_generic.client.client_address;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102133_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientAddress_Validation_for_Staging_ClientAddressType extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_102133_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientAddress_Validation_for_ClientAddressType() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientAddressType' field is 13 [max length = 12] ");

        boolean result1 = openEVVMemberModel.ClientAddressType(Constant.DataType.alphabetic, 13, "", false);

        logStepInfo("Step 2: Validate response status FAILED, " +
                "StagingClient Records are not inserted into STX " +
                "when enter in-correct value of 'ClientAddressType' field [Values: Family, Other] ");

        boolean result2 = openEVVMemberModel.ClientAddressType(Constant.DataType.userInput, 0, "abc", false);

        logStepInfo("Step 3: Validate response status SUCCESS, " +
                "StagingClient Records are inserted into STX " +
                "when enter correct value of 'ClientAddressType' field [Values: Home, Business, Other] ");

        boolean result3 = openEVVMemberModel.ClientAddressType(Constant.DataType.userInput, 0, "Home", true);

        logStepInfo("Step 4: Validate response status SUCCESS, " +
                "StagingClient Records are inserted into STX " +
                "when enter correct value of 'ClientAddressType' field [Values: Home, Business, Other] ");

        boolean result4 = openEVVMemberModel.ClientAddressType(Constant.DataType.userInput, 0, "Business", true);

        logStepInfo("Step 5: Validate response status SUCCESS, " +
                "StagingClient Records are inserted into STX " +
                "when enter correct value of 'ClientAddressType' field [Values: Home, Business, Other] ");

        boolean result5 = openEVVMemberModel.ClientAddressType(Constant.DataType.userInput, 0, "Other", true);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5, "Failed to validation for ClientContactType of a single open evv generic client");
    }
}