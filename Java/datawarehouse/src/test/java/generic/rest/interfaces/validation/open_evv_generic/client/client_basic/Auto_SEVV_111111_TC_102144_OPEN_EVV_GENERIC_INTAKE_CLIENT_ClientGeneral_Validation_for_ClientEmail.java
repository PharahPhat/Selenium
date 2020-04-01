package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102144_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientEmail  extends InterfacesGenericTest{
    @Test()
    public void Auto_SEVV_111111_TC_102144_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientEmail() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when 'ClientEmail' field has over maximum characters [50]. Note that this TC will be failed due to the configuration for 7.x is not applied which ClientEmail has maximum characters is 50");

        boolean result1 = openEVVMemberModel.ClientEmail(Constant.DataType.userInput, 0, "testemai00000000000000000000000000000000l@email.com", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientEmail' field has maximum characters [50]");

        boolean result2 = openEVVMemberModel.ClientEmail(Constant.DataType.userInput, 0, "testemai0000000000000000000000000000000l@email.com", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientEmail' field has less than maximum characters [50]");

        boolean result3 = openEVVMemberModel.ClientEmail(Constant.DataType.userInput, 0, "testemai00000000000000000000000l@email.com", true);

        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientEmail' field is null");

        boolean result4 = openEVVMemberModel.ClientEmail(Constant.DataType.userInput, 0, "", true);


        logStepInfo("Step 5 Validate " +
                "response status FAILED, " +
                "StagingClient Records is inserted into STX when 'ClientEmail' field is invalid email format");

        boolean result5 = openEVVMemberModel.ClientEmail(Constant.DataType.userInput, 0, "sad111asdasdasd.com", false);

        Assert.assertTrue(result1 && result2 && result3  && result4  && result5 , "Failed to validation for ClientEmail of a single open evv generic client");
    }

}
