package generic.rest.interfaces.validation.open_evv_generic.client.client_contact;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102135_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientContact_Validation_for_ClientContactZip extends InterfacesGenericTest{
    @Test()
    public void Auto_SEVV_111111_TC_102135_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientContact_Validation_for_ClientContactZip() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientContactZip' field is 10 [max length = 9] ");
        boolean result1 = openEVVMemberModel.ClientContactZip(Constant.DataType.numeric, 10, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records are inserted into STX when max length of 'ClientContactZip' field = 9 [max length = 9] ");
        boolean result2 = openEVVMemberModel.ClientContactZip(Constant.DataType.numeric, 9, "", true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientContactZip' field < 9 [max length = 9] ");

        boolean result3 = openEVVMemberModel.ClientContactZip(Constant.DataType.numeric, 6, "", false);

        Assert.assertTrue(result1 && result2 && result3, "Failed to validation for ClientContactZip of a single open evv generic client");
    }
}
