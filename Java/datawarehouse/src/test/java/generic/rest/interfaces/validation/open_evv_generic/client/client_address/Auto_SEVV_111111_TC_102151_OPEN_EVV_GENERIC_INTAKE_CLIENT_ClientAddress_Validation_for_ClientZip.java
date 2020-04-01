package generic.rest.interfaces.validation.open_evv_generic.client.client_address;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102151_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientAddress_Validation_for_ClientZip extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102151_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientAddress_Validation_for_ClientZip(){
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientZip' field is 10 [max length = 9] ");

        boolean result1 = openEVVMemberModel.ClientZip(Constant.DataType.alphabetic, 10, "", false);

        logStepInfo("Step 2: Validate response status FAILED, " +
                "StagingClient Records are not inserted into STX " +
                "when enter 'ClientZip' field with value null or empty");

        boolean result2 = openEVVMemberModel.ClientZip(Constant.DataType.userInput, 0, "", false);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records are inserted into STX when max length of 'ClientZip' field is 9 [max length = 9] ");

        boolean result3 = openEVVMemberModel.ClientZip(Constant.DataType.numeric, 9, "", true);

        logStepInfo("Step 4: Validate response status FAILED, " +
                "StagingClient Records are not inserted into STX " +
                "when enter in-correct format value into 'ClientZip' field");

        boolean result4 = openEVVMemberModel.ClientZip(Constant.DataType.userInput, 0, "12345a", false);

        Assert.assertTrue(result1 && result2 && result3 && result4, "Failed to validation for ClientZip of a single open evv generic client");
    }
}