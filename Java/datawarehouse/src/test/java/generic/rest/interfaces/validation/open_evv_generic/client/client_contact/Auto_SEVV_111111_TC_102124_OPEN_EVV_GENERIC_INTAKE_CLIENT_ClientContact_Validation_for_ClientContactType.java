package generic.rest.interfaces.validation.open_evv_generic.client.client_contact;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_102124_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientContact_Validation_for_ClientContactType extends InterfacesGenericTest {
    @Test()
    public void Auto_SEVV_111111_TC_102124_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientContact_Validation_for_ClientContactType(){
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when max length of 'ClientContactType' field is 13 [max length = 12] ");

        boolean result1 = openEVVMemberModel.ClientContactType(Constant.DataType.alphabetic, 13, "", false);

        logStepInfo("Step 2: Validate response status FAILED, " +
                "StagingClient Records are not inserted into STX " +
                "when enter in-correct value of 'ClientContactType' field [Values: Family, Other] ");

        boolean result2 = openEVVMemberModel.ClientContactType(Constant.DataType.userInput, 0, "abc", false);

        logStepInfo("Step 3: Validate response status SUCCESS, " +
                "StagingClient Records are inserted into STX " +
                "when enter correct value of 'ClientContactType' field [Values: Family, Other] ");

        boolean result3 = openEVVMemberModel.ClientContactType(Constant.DataType.userInput, 0, "Other", true);

        logStepInfo("Step 4: Validate response status SUCCESS, " +
                "StagingClient Records are inserted into STX " +
                "when enter correct value of 'ClientContactType' field [Values: Family, Other] ");

        boolean result4 = openEVVMemberModel.ClientContactType(Constant.DataType.userInput, 0, "Family", true);

        Assert.assertTrue(result1 && result2 && result3 & result4, "Failed to validation for ClientContactType of a single open evv generic client");
    }
}