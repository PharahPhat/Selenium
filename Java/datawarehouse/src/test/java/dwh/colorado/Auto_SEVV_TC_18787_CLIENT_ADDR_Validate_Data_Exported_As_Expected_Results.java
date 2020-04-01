package dwh.colorado;

import com.sandata.qtest.QTest;
import generic.ClientAddressGenericTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18787_CLIENT_ADDR_Validate_Data_Exported_As_Expected_Results extends ClientAddressGenericTest {

    @BeforeMethod
    public void precondition(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("CLIENTADDR");
    }

    @Test
    @QTest(keys = {"TC-18734"})
    public void Auto_SEVV_TC_18787_CLIENT_ADDR_Validate_Data_Exported_As_Expected_Header_Results(){
        validateHeaderAsExpectedResults("headerClientAddr");
    }
}
