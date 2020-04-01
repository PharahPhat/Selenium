package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;
import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Auto_SEVV_111111_TC_102136_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ProviderID extends InterfacesGenericTest{
    @Test()
    public void Auto_SEVV_111111_TC_102136_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ProviderID() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when 'ProviderID' field has over maximum characters [64]");

        boolean result1 = openEVVMemberModel.ProviderID(Constant.DataType.numeric, 65, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ProviderID' field has maximum characters [64]. Note that this TC will be failed due to the configuration for 7.x is not applied which ProviderID has maximum characters is 64  ");

        boolean result2 = openEVVMemberModel.ProviderID(Constant.DataType.numeric, 64, "", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ProviderID' field has less than maximum characters [64]");

        boolean result3 = openEVVMemberModel.ProviderID(Constant.DataType.numeric, 63, "", true);

        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ProviderID' field is null");

        boolean result4 = openEVVMemberModel.ProviderID(Constant.DataType.userInput, 0, "", true);

        Assert.assertTrue(result1 && result2, "Failed to validation for ProviderID of a single open evv generic client");
    }

}
