package dwh.ohio;

import generic.ClientDiagGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18776_CLIENT_DIAG_Validate_Provider_Data_Exported_As_Expected_Results extends ClientDiagGenericTest {
    @Test
    public void Auto_SEVV_TC_18759_CLIENT_DIAG_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0009");
        fileName  = preconditionData.get("CLIENTDIAG");
        //validateProviderGeneralIsGeneratedAsExpectedResults();
    }
}
