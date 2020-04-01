package dwh.indiana;

import com.sandata.qtest.QTest;
import generic.ClientAddressGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40680_CLIENT_ADDR_Validate_Provider_Data_Exported_As_Expected_Results extends ClientAddressGenericTest {
    @Test
    @QTest(keys = {"TC-18734"})
    public void Auto_SEVV_TC_40680_CLIENT_ADDR_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0007");
        fileName  = preconditionData.get("CLIENTADDR");
        validateHeaderAsExpectedResults("headerClientAddr");
    }
}
