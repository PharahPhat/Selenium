package dwh.vermont;

import com.sandata.qtest.QTest;
import generic.ProviderGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_38669_PROVIDER_GENERAL_Validate_Data_Exported_As_Expected_Results extends ProviderGeneralGenericTest {
    @Test
    @QTest(keys = {"TC-18725"})
    public void Auto_SEVV_TC_38669_PROVIDER_GENERAL_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0010");
        fileName  = preconditionData.get("PROVIDERGENERAL");
        validateHeaderAsExpectedResults("headerProviderGeneral");
    }
}
