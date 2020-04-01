package generic.rest.interfaces.validation.Pennylvania_generic.provider;
import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Auto_SEVV_111111_TC_103417_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_ProviderQualifier extends InterfacesGenericTest {

    @Test
    public void Auto_SEVV_111111_TC_103417_OPEN_EVV_PENNYLVANIA_INTAKE_CLIENT_PROVIDER_Validation_for_ProviderQualifier() {

        logStepInfo("Step 1: Validate " +
                "response status SUCCESS, " +
                "Upload the file to create new provider with ProviderQualifier parameter is valid value (1 < ProviderQualifier <= 10) - existing in list (SandataID, NPI, API, MedicaidID, TaxID, Taxonomy, Legacy, Other. )");
        boolean result1 =  pennsylvania_provider.ProviderQualifier(Constant.DataType.userInput, 0, "Other", true);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "Upload the file to create new provider with trim spaces in ProviderQualifier parameter");
        String qualifierTrimSpace = " Other ";
        boolean result2 =  pennsylvania_provider.ProviderQualifier(Constant.DataType.userInput, 0, qualifierTrimSpace, true);

        logStepInfo("Step 3: Validate " +
                "response status FAILED, " +
                "Upload the file to create new provider with ProviderQualifier parameter is valid value (1 < ProviderQualifier <= 10) - not existing in list (SandataID, NPI, API, MedicaidID, TaxID, Taxonomy, Legacy, Other. )");
        boolean result3 =  pennsylvania_provider.ProviderQualifier(Constant.DataType.userInput, 0, "Sandata", false);

        logStepInfo("Step 4: Validate " +
                "response status FAILED, " +
                "Upload the file to create new provider with ProviderQualifier parameter is invalid length (> 10 chars)");
        boolean result4 =  pennsylvania_provider.ProviderQualifier(Constant.DataType.userInput, 0, "Medicaid_ID", false);

        logStepInfo("Step 5: Validate " +
                "response status FAILED, " +
                "Upload the file to create new provider with ProviderQualifier parameter is digits");
        boolean result5 =  pennsylvania_provider.ProviderQualifier(Constant.DataType.numeric, 10, "", false);

        logStepInfo("Step 6: Validate " +
                "response status FAILED, " +
                "Upload the file to create new provider with ProviderQualifier parameter = null");
        boolean result6 =  pennsylvania_provider.ProviderQualifier(Constant.DataType.userInput, 0, "", false);

        logStepInfo("Step 7: Validate " +
                "response status FAILED, " +
                "Use API above and send the request to create new provider with field ProviderQualifier > 10 digits");
        boolean result7 =  pennsylvania_provider.ProviderQualifier(Constant.DataType.numeric, 11, "", false);

        logStepInfo("Step 8: Validate " +
                "response status SUCCESS, " +
                "Use API above and send the request to create new provider with field trim space");

        qualifierTrimSpace = " Sandata ";
        boolean result8 =  pennsylvania_provider.ProviderQualifier(Constant.DataType.userInput, 0, qualifierTrimSpace, true);

        Assert.assertTrue(result1 && result2 && result3 & result4 && result5 && result6 && result7 && result8, "Failed to validation for ProviderQualifier of a single open evv pennsylvania provider");
    }
}