package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102137_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_CaseManager extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102137_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_CaseManager() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when 'CaseManager' field has over maximum characters [25]");

        boolean result1 = openEVVMemberModel.CaseManager(Constant.DataType.alphabetic, 26, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'CaseManager' field has maximum characters [25]");

        boolean result2 = openEVVMemberModel.CaseManager(Constant.DataType.alphabetic, 25, "", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'CaseManager' field has less than maximum characters [25]");

        boolean result3 = openEVVMemberModel.CaseManager(Constant.DataType.alphabetic, 24, "", true);

        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'CaseManager' field is null");

        boolean result4 = openEVVMemberModel.CaseManager(Constant.DataType.userInput, 0, "", true);

        Assert.assertTrue(result1 && result2, "Failed to validation for CaseManager of a single open evv generic client");
    }
}
