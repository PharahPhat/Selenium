package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;
import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102127_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientMidName extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102127_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientMidName() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientMiddleInitial' field is 2 [max length = 30] ");

        boolean result1 = openEVVMemberModel.ClientMiddleInitial(Constant.DataType.alphabetic, 2, "", false);

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when max length of 'ClientMiddleInitial' field is 1 [max length = 30] ");

        boolean result2 = openEVVMemberModel.ClientMiddleInitial(Constant.DataType.alphabetic, 1, "", true);

        Assert.assertTrue(result1 && result2, "Failed to validation for ClientMiddleInitial of a single open evv generic client");
    }
}
