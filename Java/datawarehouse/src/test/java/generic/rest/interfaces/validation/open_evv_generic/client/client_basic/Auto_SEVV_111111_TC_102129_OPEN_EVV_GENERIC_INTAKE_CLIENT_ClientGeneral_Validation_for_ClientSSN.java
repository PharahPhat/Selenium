package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102129_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientSSN extends InterfacesGenericTest {

    @Test()
    public void Auto_SEVV_111111_TC_102129_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientSSN() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientSSN' field is 10 [max length = 9] ");

        boolean result1 = openEVVMemberModel.ClientSSN(Constant.DataType.numeric, 10, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when max length of 'ClientID' field is 9 [max length = 9] ");

        boolean result2 = openEVVMemberModel.ClientSSN(Constant.DataType.numeric, 9, "", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when ClientSSN is null [max length = 9] ");

        boolean result3 = openEVVMemberModel.ClientSSN(Constant.DataType.numeric, 0, "", true);
//
        logStepInfo("Step 4: Validate " +
                "response status FAILED, " +
                "StagingClient Records is inserted into STX when ClientSSN contains dash [max length = 9] ");

        boolean result4 = openEVVMemberModel.ClientSSN(Constant.DataType.userInput, 0, "-12345678", false);

        logStepInfo("Step 5: Validate " +
                "response status FAILED, " +
                "StagingClient Records is inserted into STX when ClientSSN contains special characters [max length = 9] ");

        boolean result5 = openEVVMemberModel.ClientSSN(Constant.DataType.userInput, 0, "12@**12%", false);

        logStepInfo("Step 6: Validate " +
                "response status SUCCESSED, " +
                "StagingClient Records is inserted into STX when ClientSSN has < 9 characters [max length = 9] ");

        boolean result6 = openEVVMemberModel.ClientSSN(Constant.DataType.numeric, 8, "", true);


        Assert.assertTrue( result3  , "Failed to validation for ClientSSN of a single open evv generic client");
    }
}
