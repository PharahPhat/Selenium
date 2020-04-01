package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;
import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102130_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientMedicalRecordNum extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102130_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientID() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientMedicalRecordNumber' field is 13 [max length = 12] ");

        boolean result1 = openEVVMemberModel.ClientMedicalRecordNumber(Constant.DataType.numeric, 13, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when max length of 'ClientMedicalRecordNumber' field is 11 [max length = 12] ");

        boolean result2 = openEVVMemberModel.ClientMedicalRecordNumber(Constant.DataType.numeric, 1, "", true);


        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when max length of 'ClientMedicalRecordNumber' field is 12 [max length = 12] ");

        boolean result3 = openEVVMemberModel.ClientMedicalRecordNumber(Constant.DataType.numeric, 1, "", true);


        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientMedicalRecordNumber' field is null [max length = 12] ");

        boolean result4 = openEVVMemberModel.ClientMedicalRecordNumber(Constant.DataType.userInput, 0, "", true);
//
        logStepInfo("Step 5: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientMedicalRecordNumber' field contains special chars [max length = 12] ");

        boolean result5 = openEVVMemberModel.ClientMedicalRecordNumber(Constant.DataType.userInput, 0, "12$$%*@456", true);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5, "Failed to validation for ClientMedicalRecordNumber of a single open evv generic client");
    }
}
