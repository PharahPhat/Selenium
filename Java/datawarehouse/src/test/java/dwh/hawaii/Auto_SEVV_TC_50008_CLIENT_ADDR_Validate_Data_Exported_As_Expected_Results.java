package dwh.hawaii;

import com.sandata.qtest.QTest;
import generic.ClientAddressGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_50008_CLIENT_ADDR_Validate_Data_Exported_As_Expected_Results extends ClientAddressGenericTest {
    @Test
    @QTest(keys = {"TC-18734"})
    public void Auto_SEVV_TC_50008_CLIENT_ADDR_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0012");
        fileName  = preconditionData.get("CLIENTADDR");
        validateHeaderAsExpectedResults("headerClientAddr");
    }
}
