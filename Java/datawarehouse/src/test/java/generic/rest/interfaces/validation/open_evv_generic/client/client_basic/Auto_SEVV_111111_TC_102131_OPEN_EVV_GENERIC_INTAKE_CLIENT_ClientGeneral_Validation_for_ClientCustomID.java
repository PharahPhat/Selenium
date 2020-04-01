package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;



import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102131_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientCustomID extends InterfacesGenericTest{
    @Test()
    public void Auto_SEVV_111111_TC_102131_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientCustomID() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientCustomID' field is 25 [max length = 24] ");

        boolean result1 = openEVVMemberModel.ClientCustomID(Constant.DataType.alphabetic, 25, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when max length of 'ClientCustomID' field is 23 [max length = 24] ");

        boolean result2 = openEVVMemberModel.ClientCustomID(Constant.DataType.alphabetic, 23, "", true);


        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when max length of 'ClientCustomID' field is 24 [max length = 24] ");

        boolean result3 = openEVVMemberModel.ClientCustomID(Constant.DataType.alphabetic, 24, "", true);


        logStepInfo("Step 4: Validate " +
                "response status FAILED, " +
                "StagingClient Records is inserted into STX when 'ClientCustomID' field is null [max length = 24] ");

        boolean result4 = openEVVMemberModel.ClientCustomID(Constant.DataType.userInput, 0, "", true);


        Assert.assertTrue(result1 && result2 && result3 && result4, "Failed to validation for ClientMedicalRecordNumber of a single open evv generic client");
    }
}
