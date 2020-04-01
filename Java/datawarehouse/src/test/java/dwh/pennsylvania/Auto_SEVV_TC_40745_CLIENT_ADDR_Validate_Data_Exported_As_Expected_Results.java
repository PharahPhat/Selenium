package dwh.pennsylvania;

import com.sandata.qtest.QTest;
import generic.ClientAddressGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40745_CLIENT_ADDR_Validate_Data_Exported_As_Expected_Results extends ClientAddressGenericTest {

    @Test
    @QTest(keys = {"TC-18734"})
    public void Auto_SEVV_TC_18787_CLIENT_ADDR_Validate_Data_Exported_As_Expected_Header_Results(){
        initStateInfo();
        GetPreconditionData("TC_0006");
        fileName  = preconditionData.get("CLIENTADDR");
        validateHeaderAsExpectedResults("headerClientAddr");
    }

}
