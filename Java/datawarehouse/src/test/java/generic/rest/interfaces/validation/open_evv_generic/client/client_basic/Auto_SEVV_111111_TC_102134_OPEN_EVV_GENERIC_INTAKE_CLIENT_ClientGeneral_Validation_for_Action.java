package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102134_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_Action extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102134_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_Action() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when  'ClientAction' field value <> A, C, D [max length = 1] ");

        boolean result1 = openEVVMemberModel.ClientAction(Constant.DataType.userInput, 0, "F", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when  'ClientAction' field value is one of these value : A, C, D [max length = 1] ");

        boolean result2 = openEVVMemberModel.ClientAction(Constant.DataType.userInput, 0, "A", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when  'ClientAction' field value is one of these value : A, C, D [max length = 1] ");

        boolean result3 = openEVVMemberModel.ClientAction(Constant.DataType.userInput, 0, "C", true);

        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when  'ClientAction' field value is one of these value : A, C, D [max length = 1] ");

        boolean result4 = openEVVMemberModel.ClientAction(Constant.DataType.userInput, 0, "D", true);

        logStepInfo("Step 5: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when max length of 'ClientAction' field is null [max length = 1] ");

        boolean result5 = openEVVMemberModel.ClientAction(Constant.DataType.userInput, 0, "", false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5, "Failed to validation for ClientAction of a single open evv generic client");
    }
}
