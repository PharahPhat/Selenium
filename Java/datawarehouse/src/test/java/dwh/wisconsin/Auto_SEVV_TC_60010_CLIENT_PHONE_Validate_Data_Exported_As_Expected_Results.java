package dwh.wisconsin;

import generic.ClientPhoneGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60010_CLIENT_PHONE_Validate_Data_Exported_As_Expected_Results extends ClientPhoneGenericTest {

    @Test
    public void Auto_SEVV_TC_38676_CLIENT_PHONE_Validate_Provider_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("CLIENTPHONE");
        validateHeaderAsExpectedResults("headerClientPhone");

    }
}
