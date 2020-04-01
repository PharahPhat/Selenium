package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;
import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Auto_SEVV_111111_TC_102140_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientLanguage extends InterfacesGenericTest {

    @Test()
    public void Auto_SEVV_111111_TC_102139_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientLanguage() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when 'ClientLanguage' field has over maximum characters [32]");

        boolean result1 = openEVVMemberModel.ClientLanguage(Constant.DataType.alphabetic, 33, "", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientLanguage' field has maximum characters [32]");

        boolean result2 = openEVVMemberModel.ClientLanguage(Constant.DataType.alphabetic, 32, "", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientLanguage' field has less than maximum characters [32]");

        boolean result3 = openEVVMemberModel.ClientLanguage(Constant.DataType.alphabetic, 31, "", true);

        logStepInfo("Step 4: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ClientLanguage' field is null");

        boolean result4 = openEVVMemberModel.ClientLanguage(Constant.DataType.alphabetic, 0, "", true);

        Assert.assertTrue(result1 && result2 && result3  && result4 , "Failed to validation for ClientLanguage of a single open evv generic client");
    }
}
