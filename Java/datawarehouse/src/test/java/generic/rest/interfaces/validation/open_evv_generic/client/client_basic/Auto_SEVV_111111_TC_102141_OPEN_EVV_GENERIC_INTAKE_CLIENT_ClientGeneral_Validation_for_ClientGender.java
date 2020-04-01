package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;
import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Auto_SEVV_111111_TC_102141_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientGender extends InterfacesGenericTest{
    @Test()
    public void Auto_SEVV_111111_TC_1021414_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientGender() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when 'ClientGender' field <> O, F, M");

        boolean result1 = openEVVMemberModel.ClientGender(Constant.DataType.userInput, 0, "C", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientGender' field is one of these value O, F, M");

        boolean result2 = openEVVMemberModel.ClientGender(Constant.DataType.userInput, 0, "O", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientGender' field is one of these value ");

        boolean result3 = openEVVMemberModel.ClientGender(Constant.DataType.userInput, 0, "F", true);

        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientGender' field is one of these value O, F, M");

        boolean result4 = openEVVMemberModel.ClientGender(Constant.DataType.userInput, 0, "M", true);

        Assert.assertTrue(result1 && result2 && result3 && result4, "Failed to validation for ClientGender of a single open evv generic client");
    }

}
