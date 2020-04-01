package generic.rest.interfaces.validation.open_evv_generic.client.client_worker_xref;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102149_OPEN_EVV_GENERIC_INTAKE_CLIENT_Staging_ClientWorkerXref_Validation_For_Service extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_102149_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientWorkerXref_Validation_For_Service(){
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'Service' field is 13 [max length = 12] ");

        boolean result1 = openEVVMemberModel.Service(Constant.DataType.alphabetic, 13, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records are inserted into STX when enter into 'Service' field with valid value");

        boolean result2 = openEVVMemberModel.Service(Constant.DataType.userInput, 0, "T1001", true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when enter into 'Service' field (required field) with value null or empty");

        boolean result3 = openEVVMemberModel.Service(Constant.DataType.userInput, 0, "", false);

        Assert.assertTrue(result1 && result2 && result3, "Failed to validation for Service of a single open evv generic client");
    }
}