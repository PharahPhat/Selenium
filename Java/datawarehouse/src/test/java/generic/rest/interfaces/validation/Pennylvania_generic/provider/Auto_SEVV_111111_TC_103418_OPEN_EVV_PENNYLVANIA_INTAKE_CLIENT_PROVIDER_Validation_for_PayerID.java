package generic.rest.interfaces.validation.Pennylvania_generic.provider;

import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_111111_TC_103418_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_PayerID extends InterfacesGenericTest {
    @Test
    public void Auto_SEVV_111111_TC_103418_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_PayerID() {

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "Upload the file to create new provider with PayerID parameter = 5 chars and existing in DB");
        boolean result1 =  pennsylvania_provider.PayerID(Constant.DataType.userInput, 0, "PADHS", true);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Upload the file to create new provider with trim spaces in PayerID parameter");

        boolean result2 =  pennsylvania_provider.PayerID(Constant.DataType.userInput, 0, " PADHS ", true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "Upload the file to create new provider with PayerID parameter = 5 chars and not existing in DB ");
        boolean result3 =  pennsylvania_provider.PayerID(Constant.DataType.userInput, 0, "ABCDE", false);

        logStepInfo("Step 4: Validate " +
                "response status FAILED, " +
                "Upload the file to create new provider with ProviderQualifier parameter is invalid length (> 10 chars)");
        boolean result4 =  pennsylvania_provider.PayerID(Constant.DataType.userInput, 0, "", false);

        logStepInfo("Step 5: Validate " +
                "response status ERROR, " +
                "Upload the file to create new provider with PayerID parameter is digits ");

        boolean result5 =  pennsylvania_provider.PayerID(Constant.DataType.numeric, 0, "", false);

        logStepInfo("Step 6: Validate " +
                "response status ERROR, " +
                "Upload the file to create new provider with PayerID parameter has any character");

        boolean result6 =  pennsylvania_provider.PayerID(Constant.DataType.alphaNumeric, 5, "", false);

        Assert.assertTrue(result1 && result2 && result3 && result4 && result5 && result6, "Failed to validation for PayerID of a single open evv generic provider");
    }
}
