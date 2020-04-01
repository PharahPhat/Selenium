package dwh.wisconsin;

import generic.ClientAddressGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_60008_CLIENT_ADDR_Validate_Data_Exported_As_Expected_Results extends ClientAddressGenericTest {
    @Test
    public void Auto_SEVV_TC_38674_CLIENT_ADDR_Validate_Data_Exported_As_Expected_Results() {
        initStateInfo();
        GetPreconditionData("TC_0013");
        fileName = preconditionData.get("CLIENTADDR");
        validateHeaderAsExpectedResults("headerClientAddr");
    }
}
