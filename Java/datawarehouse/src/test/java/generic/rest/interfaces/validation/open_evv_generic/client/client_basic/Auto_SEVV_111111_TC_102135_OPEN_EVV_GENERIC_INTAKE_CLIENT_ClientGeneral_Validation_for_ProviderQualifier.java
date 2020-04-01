package generic.rest.interfaces.validation.open_evv_generic.client.client_basic;
import com.sandata.common.Constant;
import generic.rest.interfaces.InterfacesGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Auto_SEVV_111111_TC_102135_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ProviderQualifier extends InterfacesGenericTest{
    @Test()
    public void Auto_SEVV_111111_TC_102135_OPEN_EVV_GENERIC_INTAKE_CLIENT_ClientGeneral_Validation_for_ProviderQualifier() {
        logStepInfo("Step 1: Validate " +
                "response status FAILED, " +
                "StagingClient Records are not inserted into STX when 'ProviderQualifier' field <> SandataID, NPI, API, MedicaidID, TaxID, Taxonomy, Legacy, Other ");

        boolean result1 = openEVVMemberModel.ProviderQualifier(Constant.DataType.userInput, 0, "ABC", false);

        logStepInfo("Step 2: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ProviderQualifier' field is one of these value SandataID, NPI, API, MedicaidID, TaxID, Taxonomy, Legacy, Other ");

        boolean result2 = openEVVMemberModel.ProviderQualifier(Constant.DataType.userInput, 0, "SandataID", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ProviderQualifier' field is one of these value SandataID, NPI, API, MedicaidID, TaxID, Taxonomy, Legacy, Other ");

        boolean result3 = openEVVMemberModel.ProviderQualifier(Constant.DataType.userInput, 0, "NPI", true);

        logStepInfo("Step 3: Validate " +
                "response status SUCCESS, " +
                "StagingClient Records is inserted into STX when 'ProviderQualifier' field is one of these value SandataID, NPI, API, MedicaidID, TaxID, Taxonomy, Legacy, Other ");

        boolean result4 = openEVVMemberModel.ProviderQualifier(Constant.DataType.userInput, 0, "TaxID", true);


        Assert.assertTrue(result1 && result2 && result3 && result4, "Failed to validation for ProviderQualifier of a single open evv generic client");
    }
}
