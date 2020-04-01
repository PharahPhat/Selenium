package dwh.ohio;

import generic.VisitCallGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18769_PROVIDER_LOC_Validate_Provider_Data_Exported_As_Expected_Results extends VisitCallGenericTest {
    @Test
    public void Auto_SEVV_TC_18752_PROVIDER_LOC_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0009");
        fileName  = preconditionData.get("PROVIDERLOC");
        //validateProviderGeneralIsGeneratedAsExpectedResults();
    }
}
