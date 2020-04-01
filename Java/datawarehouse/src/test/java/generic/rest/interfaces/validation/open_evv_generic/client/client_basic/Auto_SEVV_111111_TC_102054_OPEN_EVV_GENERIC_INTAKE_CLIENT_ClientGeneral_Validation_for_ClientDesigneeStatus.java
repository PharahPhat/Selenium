package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Auto_SEVV_111111_TC_102054_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientDesigneeStatus extends InterfacesGenericTest {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private LocalDate localDate = LocalDate.now();

    @Test
    public void Auto_SEVV_111111_TC_102054_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ClientDesigneeStatus() {
        logStepInfo("Step 1: Validate " +
                "response status PASSED, " +
                "StagingClient Records are inserted into STX when value of 'VerifyClientDesigneeStatus' field is empty ");
        boolean result1 = openEVVMemberModel.VerifyClientDesigneeStatus(Constant.DataType.userInput, 02, null, null, null
                , false);

        logStepInfo("Step 2: Validate " +
                "response status FAILED, " +
                "StagingClient Records are inserted into STX when value of 'VerifyClientDesigneeStatus' field is empty while end date = current date ");
        boolean result2 = openEVVMemberModel.VerifyClientDesigneeStatus(Constant.DataType.userInput, 02, null, null, dtf.format(localDate),
                false);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "StagingClient Records are inserted into STX when value of 'VerifyClientDesigneeStatus' field is empty while end date = current date ");
        boolean result3 = openEVVMemberModel.VerifyClientDesigneeStatus(Constant.DataType.userInput, 02, null, dtf.format(localDate), null,
                false);

        logStepInfo("Step 4: Validate " +
                "response status PASSED, " +
                "StagingClient Records are inserted into STX when value of 'VerifyClientDesigneeStatus' field is 02 while start and end date = null");
        boolean result4 = openEVVMemberModel.VerifyClientDesigneeStatus(Constant.DataType.userInput, 02, "02", null, null,
                true);
        Assert.assertTrue(result4);

        logStepInfo("Step 5: Validate " +
                "response status PASSED, " +
                "StagingClient Records are inserted into STX when value of 'VerifyClientDesigneeStatus' field is null but having start and end date = current date");
        boolean result5 = openEVVMemberModel.VerifyClientDesigneeStatus(Constant.DataType.userInput, 02, null, dtf.format(localDate), dtf.format(localDate),
                true);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5, "Failed to validation for VerifyClientDesigneeStatus of a single open evv generic client");
    }
}
