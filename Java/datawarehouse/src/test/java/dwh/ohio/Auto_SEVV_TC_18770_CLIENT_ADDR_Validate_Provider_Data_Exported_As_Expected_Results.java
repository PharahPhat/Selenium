package dwh.ohio;

import generic.ClientAddressGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18770_CLIENT_ADDR_Validate_Provider_Data_Exported_As_Expected_Results extends ClientAddressGenericTest {
    @Test
    public void Auto_SEVV_TC_18753_CLIENT_ADDR_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_99999");
        ohioExportedFileName  = preconditionData.get("exportFile");
        validateOhioClientAdressFromJsonData();
    }

}
