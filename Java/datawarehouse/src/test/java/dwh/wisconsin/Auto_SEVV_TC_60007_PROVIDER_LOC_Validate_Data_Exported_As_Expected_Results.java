package dwh.wisconsin;

import generic.ProviderLocGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60007_PROVIDER_LOC_Validate_Data_Exported_As_Expected_Results extends ProviderLocGenericTest {
    @Test
    public void Auto_SEVV_TC_38673_PROVIDER_LOC_Validate_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("PROVIDERLOC");
        validateHeaderAsExpectedResults("headerProviderLoc");
    }
}
