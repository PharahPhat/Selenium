package dwh.ohio;

import generic.ClientGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18764_CLIENT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results extends ClientGeneralGenericTest {
    @Test
    public void Auto_SEVV_TC_18764_CLIENT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_99999");
        ohioExportedFileName  = preconditionData.get("exportFile");
        validateOhioStaffHeaderFromJsonData();
    }
}
