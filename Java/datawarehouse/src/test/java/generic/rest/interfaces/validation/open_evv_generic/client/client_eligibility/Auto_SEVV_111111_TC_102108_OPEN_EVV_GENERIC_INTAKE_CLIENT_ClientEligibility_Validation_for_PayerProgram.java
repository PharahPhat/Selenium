package generic.rest.interfaces.validation.open_evv_generic.client.client_eligibility;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102108_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientEligibility_Validation_for_PayerProgram extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102108_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientEligibility_Validation_for_PayerProgram() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'PayerProgram' field is 10 [max length = 9] ");

        boolean result1 = openEVVMemberModel.PayerProgram(Constant.DataType.alphabetic, 10, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "When enter correct value of PayerProgram ");

        boolean result2 = openEVVMemberModel.PayerProgram(Constant.DataType.userInput, 0, "Indiana", true);

        Assert.assertTrue(result1 && result2, "Failed to validation for PayerProgram of a single open evv generic client");
    }
}
