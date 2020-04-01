package dwh.pennsylvania;

import com.sandata.qtest.QTest;
import generic.ProviderLocGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40744_PROVIDER_LOC_Validate_Data_Exported_As_Expected_Results extends ProviderLocGenericTest {

    @Test
    @QTest(keys = {"TC-18733"})
    public void Auto_SEVV_TC_18786_PROVIDER_LOC_Validate_Data_Exported_As_Expected_Header_Results(){
        initStateInfo();
        GetPreconditionData("TC_0006");
        fileName  = preconditionData.get("PROVIDERLOC");
        validateHeaderAsExpectedResults("headerProviderLoc");
    }
}
