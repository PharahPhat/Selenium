package generic.rest.interfaces.validation.open_evv_generic.client.client_contact;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102126_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientContact_Validation_for_ClientContactLastName extends InterfacesGenericTest{
    @Test()
    public void Auto_SEVV_111111_TC_102126_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientContact_Validation_for_ClientContactLastName() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientContactFirstName' field is 31 [max length = 30] ");

        boolean result1 = openEVVMemberModel.ClientContactLastName(Constant.DataType.alphabetic, 31, "", false);

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when max length of 'ClientContactFirstName' field is 30 [max length = 30] ");

        boolean result2 = openEVVMemberModel.ClientContactLastName(Constant.DataType.alphabetic, 30, "", true);

        Assert.assertTrue(result1 && result2, "Failed to validation for ClientContactFirstName of a single open evv generic client");
    }
}
