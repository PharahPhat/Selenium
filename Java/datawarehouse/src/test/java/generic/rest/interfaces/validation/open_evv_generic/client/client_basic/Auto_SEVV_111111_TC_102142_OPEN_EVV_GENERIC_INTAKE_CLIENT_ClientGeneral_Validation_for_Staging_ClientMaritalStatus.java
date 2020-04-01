package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102142_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_Staging_ClientMaritalStatus extends InterfacesGenericTest{
    @Test()
    public void Auto_SEVV_111111_TC_1021414_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientGender() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when 'ClientMaritalStatus' field <> O, S, M , W");

        boolean result1 = openEVVMemberModel.ClientMaritalStatus(Constant.DataType.userInput, 0, "C", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientMaritalStatus' field is one of these valueO, S, M , W");

        boolean result2 = openEVVMemberModel.ClientMaritalStatus(Constant.DataType.userInput, 0, "O", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientMaritalStatus' field is one of these value O, S, M , W ");

        boolean result3 = openEVVMemberModel.ClientMaritalStatus(Constant.DataType.userInput, 0, "S", true);

        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientMaritalStatus' field is one of these value O, S, M , W");

        boolean result4 = openEVVMemberModel.ClientMaritalStatus(Constant.DataType.userInput, 0, "M", true);


        logStepInfo("Step 5: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientMaritalStatus' field is one of these value O, F, M");

        boolean result5 = openEVVMemberModel.ClientMaritalStatus(Constant.DataType.userInput, 0, "W", true);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5, "Failed to validation for ClientMaritalStatus of a single open evv generic client");
    }
}
