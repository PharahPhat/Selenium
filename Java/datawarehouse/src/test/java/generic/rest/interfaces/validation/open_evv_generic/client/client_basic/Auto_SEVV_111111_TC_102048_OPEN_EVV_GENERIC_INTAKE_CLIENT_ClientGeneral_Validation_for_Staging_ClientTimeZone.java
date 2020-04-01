package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102048_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_Staging_ClientTimeZone extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_102048_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientTimeZone() {
        logStepInfo("Step 1: Validate " +
                "response status PASSED, " +
                "StagingClient Records are inserted into STX when value of 'ClientTimeZone' field is empty [max length = any]");
        boolean result1 = openEVVMemberModel.ClientTimeZone(Constant.DataType.userInput, 2, null, true);

        logStepInfo("Step 2: Validate " +
                "response status FAILED, " +
                "StagingClient Records are inserted into STX when value of 'ClientTimeZone' field is not support [max length = any]");
        boolean result2 = openEVVMemberModel.ClientTimeZone(Constant.DataType.userInput, 02, "US/Alaskaa", false);

        logStepInfo("Step 3: Validate " +
                "response status PASSED, " +
                "StagingClient Records are inserted into STX when value of 'ClientTimeZone' field is support [max length = any]");
        boolean result3 = openEVVMemberModel.ClientTimeZone(Constant.DataType.userInput, 02, "US/Alaska", true);

        Assert.assertTrue(result1 && result2 && result3, "Failed to validation for ClientTimeZone of a single open evv generic client");
    }
}
