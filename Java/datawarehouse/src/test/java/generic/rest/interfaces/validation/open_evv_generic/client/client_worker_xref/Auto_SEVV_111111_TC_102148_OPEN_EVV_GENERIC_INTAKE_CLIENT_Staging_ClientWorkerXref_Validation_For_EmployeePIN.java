package generic.rest.interfaces.validation.open_evv_generic.client.client_worker_xref;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102148_OPEN_EVV_GENERIC_INTAKE_CLIENT_Staging_ClientWorkerXref_Validation_For_EmployeePIN extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_102148_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientWorkerXref_Validation_For_EmployeePIN(){
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'EmployeePIN' field is 10 [max length = 9]");

        boolean result1 = openEVVMemberModel.EmployeePIN(Constant.DataType.numeric, 10, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records are inserted into STX when max length of 'EmployeePIN' field is 9 [max length = 9]");

        boolean result2 = openEVVMemberModel.EmployeePIN(Constant.DataType.alphabetic, 9, "", true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when enter into 'EmployeePIN' field (required field) with value null or empty");

        boolean result3 = openEVVMemberModel.EmployeePIN(Constant.DataType.userInput, 0, "", false);

        Assert.assertTrue(result1 && result2 && result3, "Failed to validation for EmployeePIN of a single open evv generic client");
    }
}