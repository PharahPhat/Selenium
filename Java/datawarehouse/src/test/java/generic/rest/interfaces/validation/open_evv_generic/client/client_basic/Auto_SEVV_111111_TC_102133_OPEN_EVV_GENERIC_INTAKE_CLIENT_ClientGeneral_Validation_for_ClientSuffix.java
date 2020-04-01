package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;
import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Auto_SEVV_111111_TC_102133_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientSuffix extends InterfacesGenericTest {

    @Test()
    public void Auto_SEVV_111111_TC_102133_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientSuffix() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientSuffix' field is 5 [max length = 4] ");

        boolean result1 = openEVVMemberModel.ClientSuffix(Constant.DataType.alphabetic, 5, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when max length of 'ClientSuffix' field is 4 [max length = 4] ");

        boolean result2 = openEVVMemberModel.ClientSuffix(Constant.DataType.alphabetic, 4, "", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when max length of 'ClientSuffix' field is 3 [max length = 4] ");

        boolean result3 = openEVVMemberModel.ClientSuffix(Constant.DataType.alphabetic, 3, "", true);


        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX 'ClientSuffix' field contains special chars [max length = 4] ");

        boolean result4 = openEVVMemberModel.ClientSuffix(Constant.DataType.userInput, 0, "S@*r", true);

        logStepInfo("Step 5: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when max length of 'ClientSuffix' field is null[max length = 4] ");

        boolean result5 = openEVVMemberModel.ClientSuffix(Constant.DataType.userInput, 0, "", true);


        Assert.assertTrue(result1 && result2 && result3 && result4 && result5, "Failed to validation for ClientSuffix of a single open evv generic client");
    }

}
