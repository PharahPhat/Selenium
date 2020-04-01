package dwh.ohio;

import generic.ProviderGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18765_PROVIDER_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results extends ProviderGeneralGenericTest {
    @Test
    public void Auto_SEVV_TC_18765_PROVIDER_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_99999");
        ohioExportedFileName  = preconditionData.get("exportFile");
        validateOhioProviderHeaderFromJsonData();
    }

}
