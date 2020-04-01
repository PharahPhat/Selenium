package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102051_OPEN_EVV_GENERIC_INTAKE_CLIENT__ClientGeneral_Validation_for_ClientDesigneeLastName extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_102051_OPEN_EVV_GENERIC_INTAKE_CLIENT__ClientGeneral_Validation_for_ClientDesigneeLastName() {
        logStepInfo("Step 1: Validate " +
                "response status PASSED, " +
                "StagingClient Records are inserted into STX when value of 'ClientDesigneeLastName' field is 30 [max length = 30]");
        boolean result1 = openEVVMemberModel.ClientDesigneeLastName(Constant.DataType.alphabetic, 30, "", true);

        logStepInfo("Step 2: Validate " +
                "response status FAILED, " +
                "StagingClient Records are inserted into STX when value of 'ClientDesigneeLastName' field is 31 [max length = any]");
        boolean result2 = openEVVMemberModel.ClientDesigneeLastName(Constant.DataType.alphabetic, 31, "", false);

        logStepInfo("Step 3: Validate " +
                "response status PASSED, " +
                "StagingClient Records are inserted into STX when value of 'ClientDesigneeLastName' field is support [max length = any]");
        boolean result3 = openEVVMemberModel.ClientDesigneeLastName(Constant.DataType.userInput, 30, null, true);

        Assert.assertTrue(result1 && result2 && result3, "Failed to validation for ClientDesigneeLastName of a single open evv generic client");
    }
}
