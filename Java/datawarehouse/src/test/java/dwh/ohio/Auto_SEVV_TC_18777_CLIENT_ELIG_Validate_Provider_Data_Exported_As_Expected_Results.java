package dwh.ohio;

import generic.ClientEligibilityGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18777_CLIENT_ELIG_Validate_Provider_Data_Exported_As_Expected_Results extends ClientEligibilityGenericTest {

    @Test
    public void Auto_SEVV_TC_18760_CLIENT_ELIG_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0009");
        fileName  = preconditionData.get("CLIENTELIG");
        //validateProviderGeneralIsGeneratedAsExpectedResults();
    }
}
