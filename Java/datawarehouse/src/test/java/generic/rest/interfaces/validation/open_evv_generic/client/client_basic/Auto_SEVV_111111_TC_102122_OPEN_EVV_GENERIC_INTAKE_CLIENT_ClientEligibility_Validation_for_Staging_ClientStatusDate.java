package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102122_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientEligibility_Validation_for_Staging_ClientStatusDate extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102122_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientEligibility_Validation_for_ClientStatusDate() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when format 'ClientStatusDate' <> YYYY-MM-DD");

        boolean result1 = openEVVMemberModel.ClientStatusDate(Constant.DataType.userInput, 0, "2019-27-02", false);

        logStepInfo("Step 2: Validate " +
                    "response status SUCCESS, " +
                "StagingClient Records are not inserted into STX when format 'ClientStatusDate' = YYYY-MM-DD");

        boolean result2 = openEVVMemberModel.ClientStatusDate(Constant.DataType.userInput, 0, "2019-02-27", true);

        Assert.assertTrue(result1 && result2, "Failed to validation for ClientStatusDate of a single open evv generic client");
    }
}
