package dwh.ohio;

import generic.ClientPhoneGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18772_CLIENT_PHONE_Validate_Provider_Data_Exported_As_Expected_Results extends ClientPhoneGenericTest {

    @Test
    public void Auto_SEVV_TC_18755_CLIENT_PHONE_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_99999");
        ohioExportedFileName  = preconditionData.get("exportFile");
        validateOhioVisitClientPhoneFromJsonData();
    }
}
