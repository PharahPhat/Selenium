package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;
import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Auto_SEVV_111111_TC_102143_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_Staging_ClientBirthDate extends InterfacesGenericTest {

@Test()
public void Auto_SEVV_111111_TC_1021414_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientBirthDate() {
    logStepInfo("Step 1: Validate " +
            "response status FAILED, " +
            "StagingClient Records are not inserted into STX when 'ClientBirthDate' field is valid datetime format");

    boolean result1 = openEVVMemberModel.ClientBirthDate(Constant.DataType.userInput, 0, "01-01-1990", false);

    logStepInfo("Step 2: Validate " +
            "response status FAILED, " +
            "StagingClient Records is inserted into STX when 'ClientBirthDate' field is LESS than 1990");

    boolean result2 = openEVVMemberModel.ClientBirthDate(Constant.DataType.userInput, 0, "1899-01-01", false);

    logStepInfo("Step 3: Validate " +
            "response status FAILED, " +
            "StagingClient Records is inserted into STX when 'ClientBirthDate' field is GREATER 2100");

    boolean result3 = openEVVMemberModel.ClientBirthDate(Constant.DataType.userInput, 0, "2100-01-01", false);

    logStepInfo("Step 4: Validate " +
            "response status SUCCESS, " +
            "StagingClient Records is inserted into STX when 'ClientBirthDate' field is VALID ");

    boolean result4 = openEVVMemberModel.ClientBirthDate(Constant.DataType.userInput, 0, "2000-01-01", true);


    logStepInfo("Step 5: Validate " +
            "response status SUCCESS, " +
            "StagingClient Records is inserted into STX when 'ClientBirthDate' field is NULL ");

    boolean result5 = openEVVMemberModel.ClientBirthDate(Constant.DataType.userInput, 0, "", true);


    logStepInfo("Step 6: Validate " +
            "response status FAILED, " +
            "StagingClient Records is inserted into STX when 'ClientBirthDate' field is incorrect format");

    boolean result6 = openEVVMemberModel.ClientBirthDate(Constant.DataType.userInput, 0, "0909-0909-00", false);

    logStepInfo("Step 7: Validate " +
            "response status FAILED, " +
            "StagingClient Records are not inserted into STX when 'ClientBirthDate' field incorrect days base on month ");

    boolean result7 = openEVVMemberModel.ClientBirthDate(Constant.DataType.userInput, 0, "2000-02-31", false);


    Assert.assertTrue(result1 && result2 && result3 && result4 && result5 && result6 && result7, "Failed to validation for ClientBirthDate of a single open evv generic client");
}
}