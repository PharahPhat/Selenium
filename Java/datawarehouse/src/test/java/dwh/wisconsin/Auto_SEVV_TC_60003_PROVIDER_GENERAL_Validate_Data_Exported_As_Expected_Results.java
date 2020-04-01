package dwh.wisconsin;

import generic.ProviderGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60003_PROVIDER_GENERAL_Validate_Data_Exported_As_Expected_Results extends ProviderGeneralGenericTest {
    @Test
    public void Auto_SEVV_TC_38669_PROVIDER_GENERAL_Validate_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("PROVIDERGENERAL");
        validateHeaderAsExpectedResults("headerProviderGeneral");
    }
}
