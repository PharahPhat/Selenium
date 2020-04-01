package generic.rest.interfaces.validation.open_evv_generic.client.client_contact;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102134_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientContact_Validation_for_ClientContactState extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102134_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientContact_Validation_for_ClientContactState() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientContactState' field is 3 [max length = 2] ");
        boolean result1 = openEVVMemberModel.ClientContactState(Constant.DataType.alphabetic, 3, "", false);

        logStepInfo("Step 2: Validate response status FAILED, " +
                "StagingClient Records are not inserted into STX " +
                "when enter in-correct value of 'ClientContactState'  ");
        boolean result2 = openEVVMemberModel.ClientContactState(Constant.DataType.userInput, 0, "OO", false);

        logStepInfo("Step 3: Validate response status SUCCESS, " +
                "StagingClient Records are inserted into STX " +
                "when enter correct value of 'ClientContactState' ");
        boolean result3 = openEVVMemberModel.ClientContactState(Constant.DataType.userInput, 0, "NY", true);

        Assert.assertTrue(result1 && result2 && result3, "Failed to validation for ClientContactState of a single open evv generic client");
    }
}
