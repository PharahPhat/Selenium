package generic.rest.interfaces.validation.open_evv_generic.client.client_phone;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102143_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientPhone_Validation_For_ClientPhone extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_102143_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientPhone_Validation_For_ClientPhone(){
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientPhone' field is 11 [fixed length = 10] ");

        boolean result1 = openEVVMemberModel.ClientPhone(Constant.DataType.numeric, 11, "", false);

        logStepInfo("Step 2: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientPhone' field is 9 [fixed length = 10] ");

        boolean result2 = openEVVMemberModel.ClientPhone(Constant.DataType.numeric, 9, "", false);

        logStepInfo("Step 3: Validate response status FAILED, " +
                "StagingClient Records are not inserted into STX " +
                "when enter in-correct format value into 'ClientPhone' field");

        boolean result3 = openEVVMemberModel.ClientPhone(Constant.DataType.userInput, 0, "123abc4561", false);

        logStepInfo("Step 4: Validate response status SUCCESS, " +
                "StagingClient Records are inserted into STX " +
                "when enter correct format value into 'ClientPhone' field");

        boolean result4 = openEVVMemberModel.ClientPhone(Constant.DataType.userInput, 0, "1234567891", true);

        logStepInfo("Step 5: Validate response status FAILED, " +
                "StagingClient Records are inserted into STX " +
                "when enter null or empty value into 'ClientPhone' field");

        boolean result5 = openEVVMemberModel.ClientPhone(Constant.DataType.userInput, 0, "", false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5, "Failed to validation for ClientPhone of a single open evv generic client");
    }
}