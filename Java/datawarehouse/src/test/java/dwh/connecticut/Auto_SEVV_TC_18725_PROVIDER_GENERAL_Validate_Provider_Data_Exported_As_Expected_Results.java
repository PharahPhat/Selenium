package dwh.connecticut;

import com.sandata.qtest.QTest;
import generic.ProviderGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18725_PROVIDER_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results extends ProviderGeneralGenericTest {
    @Test
    @QTest(keys = {"TC-18725"})
    public void Auto_SEVV_TC_18725_PROVIDER_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0003");
        fileName  = preconditionData.get("PROVIDERGENERAL");
        validateHeaderAsExpectedResults("headerProviderGeneral");
    }

}
