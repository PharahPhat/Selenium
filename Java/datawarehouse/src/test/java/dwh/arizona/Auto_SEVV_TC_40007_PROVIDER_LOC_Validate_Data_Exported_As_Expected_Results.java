package dwh.arizona;

import com.sandata.qtest.QTest;
import generic.ProviderLocGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40007_PROVIDER_LOC_Validate_Data_Exported_As_Expected_Results extends ProviderLocGenericTest {
    @Test
    @QTest(keys = {"TC-18733"})
    public void Auto_SEVV_TC_38673_PROVIDER_LOC_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0011");
        fileName  = preconditionData.get("PROVIDERLOC");
        validateHeaderAsExpectedResults("headerProviderLoc");
    }
}
