package dwh.colorado;

import com.sandata.qtest.QTest;
import generic.ProviderGeneralGenericTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18782_PROVIDER_GENERAL_Validate_Data_Exported_As_Expected_Results extends ProviderGeneralGenericTest {

    @BeforeMethod
    public void precondition(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("PROVIDERGENERAL");
    }

    @Test
    @QTest(keys = {"TC-18725"})
    public void Auto_SEVV_TC_18781_PROVIDER_GENERAL_Validate_Data_Exported_As_Expected_Header_Results(){
        validateHeaderAsExpectedResults("headerProviderGeneral");
    }
}
