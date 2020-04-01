package generic.rest.interfaces.validation.open_evv_generic.client.client_phone;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102141_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientPhone_Validation_For_Staging_ClientPhoneType extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_102141_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientPhone_Validation_For_ClientPhoneType(){
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientPhoneType' field is 13 [max length = 12] ");

        boolean result1 = openEVVMemberModel.ClientPhoneType(Constant.DataType.alphabetic, 13, "", false);

        logStepInfo("Step 2: Validate response status FAILED, " +
                "StagingClient Records are not inserted into STX " +
                "when enter in-correct value of 'ClientAddressType' field [Values: Home, Mobile, Business, Other] ");

        boolean result2 = openEVVMemberModel.ClientPhoneType(Constant.DataType.userInput, 0, "abc", false);

        logStepInfo("Step 3: Validate response status SUCCESS, " +
                "StagingClient Records are inserted into STX " +
                "when enter correct value of 'ClientPhoneType' field [Values: Home, Mobile, Business, Other] ");

        boolean result3 = openEVVMemberModel.ClientPhoneType(Constant.DataType.userInput, 0, "Home", true);
        boolean result4 = openEVVMemberModel.ClientPhoneType(Constant.DataType.userInput, 0, "Mobile", true);
        boolean result5 = openEVVMemberModel.ClientPhoneType(Constant.DataType.userInput, 0, "Business", true);
        boolean result6 = openEVVMemberModel.ClientPhoneType(Constant.DataType.userInput, 0, "Other", true);

        logStepInfo("Step 4: Validate response status SUCCESS, " +
                "StagingClient Records are inserted into STX " +
                "when enter into 'ClientPhoneType' field with value null or empty.");

        boolean result7 = openEVVMemberModel.ClientPhoneType(Constant.DataType.userInput, 0, "", true);
        Assert.assertTrue(result1 && result2 && result3 && result4 && result5 && result6 && result7, "Failed to validation for ClientPhoneType of a single open evv generic client");
    }
}