package dwh.hawaii;

import com.sandata.qtest.QTest;
import generic.ProviderGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_50003_PROVIDER_GENERAL_Validate_Data_Exported_As_Expected_Results extends ProviderGeneralGenericTest {
    @Test
    @QTest(keys = {"TC-18725"})
    public void Auto_SEVV_TC_50003_PROVIDER_GENERAL_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0012");
        fileName  = preconditionData.get("PROVIDERGENERAL");
        validateHeaderAsExpectedResults("headerProviderGeneral");
    }
}
