package dwh.hawaii;

import com.sandata.qtest.QTest;
import generic.ProviderLocGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_50007_PROVIDER_LOC_Validate_Data_Exported_As_Expected_Results extends ProviderLocGenericTest {
    @Test
    @QTest(keys = {"TC-18733"})
    public void Auto_SEVV_TC_50007_PROVIDER_LOC_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0012");
        fileName  = preconditionData.get("PROVIDERLOC");
        validateHeaderAsExpectedResults("headerProviderLoc");
    }
}
