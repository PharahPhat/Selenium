package dwh.vermont;

import generic.ClientEligibilityGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_38681_CLIENT_ELIG_Validate_Data_Exported_As_Expected_Results extends ClientEligibilityGenericTest {

    @Test
    public void Auto_SEVV_TC_38681_CLIENT_ELIG_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0010");
        fileName  = preconditionData.get("CLIENTELIG");
        //TODO: no header
    }
}
