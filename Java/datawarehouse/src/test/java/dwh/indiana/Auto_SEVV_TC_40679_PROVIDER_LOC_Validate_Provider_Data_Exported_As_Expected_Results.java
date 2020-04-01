package dwh.indiana;

import com.sandata.qtest.QTest;
import generic.ProviderLocGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40679_PROVIDER_LOC_Validate_Provider_Data_Exported_As_Expected_Results extends ProviderLocGenericTest {
    @Test
    @QTest(keys = {"TC-18733"})
    public void Auto_SEVV_TC_40679_PROVIDER_LOC_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0007");
        fileName  = preconditionData.get("PROVIDERLOC");
        validateHeaderAsExpectedResults("headerProviderLoc");
    }
}
