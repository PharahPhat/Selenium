package dwh.pennsylvania;

import com.sandata.qtest.QTest;
import generic.ProviderGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40740_PROVIDER_GENERAL_Validate_Data_Exported_As_Expected_Results extends ProviderGeneralGenericTest {

    @Test
    @QTest(keys = {"TC-18725"})
    public void Auto_SEVV_TC_18781_CLIENT_GENERAL_Validate_Data_Exported_As_Expected_Header_Results(){
        initStateInfo();
        GetPreconditionData("TC_0006");
        fileName  = preconditionData.get("PROVIDERGENERAL");
        validateHeaderAsExpectedResults("headerProviderGeneral");
    }

}
