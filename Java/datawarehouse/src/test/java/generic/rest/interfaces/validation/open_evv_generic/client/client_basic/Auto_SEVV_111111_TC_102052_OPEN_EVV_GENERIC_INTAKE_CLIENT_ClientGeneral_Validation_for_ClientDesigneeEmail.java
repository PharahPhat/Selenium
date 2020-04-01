package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102052_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientDesigneeEmail extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_102052_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientDesigneeEmail() {
        logStepInfo("Step 1: Validate " +
                "response status PASSED, " +
                "StagingClient Records are inserted into STX when value of 'ClientDesigneeEmail' field is empty [max length = 50]");
        boolean result1 = openEVVMemberModel.ClientDesigneeEmail(Constant.DataType.userInput, 50, null, true);

        logStepInfo("Step 2: Validate " +
                "response status FAILED, " +
                "StagingClient Records are inserted into STX when value of 'ClientDesigneeEmail' field is 50 [max length = 50]");
        boolean result2 = openEVVMemberModel.ClientDesigneeEmail(Constant.DataType.userInput, 51, "testemai0000000000000000000000000000000l@email.com", true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "StagingClient Records are inserted into STX when value of 'ClientDesigneeEmail' field is 51 [max length = 50]");
        boolean result3 = openEVVMemberModel.ClientDesigneeEmail(Constant.DataType.userInput, 51, "testemai00000000000000000000000000000000l@email.com", false);

        logStepInfo("Step 4: Validate " +
                "response status PASSED, " +
                "StagingClient Records are inserted into STX when value of 'ClientDesigneeEmail' field is 49 [max length = 50]");
        boolean result4 = openEVVMemberModel.ClientDesigneeEmail(Constant.DataType.userInput, 51, "testemai00000000000000000000000000000l@email.com", true);

        logStepInfo("Step 5: Validate " +
                "response status FAILED, " +
                "StagingClient Records are inserted into STX when value of 'ClientDesigneeEmail' field is invalid [max length = 50]");
        boolean result5 = openEVVMemberModel.ClientDesigneeEmail(Constant.DataType.userInput, 50, "testemai00000000000000000000000000000email.com", false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5, "Failed to validation for ClientDesigneeEmail of a single open evv generic client");
    }
}
