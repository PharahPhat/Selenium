package dwh.connecticut;

import com.sandata.qtest.QTest;
import generic.ClientPhoneGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18736_CLIENT_PHONE_Validate_Provider_Data_Exported_As_Expected_Results extends ClientPhoneGenericTest {

    @Test
    @QTest(keys = {"TC-18736"})
    public void Auto_SEVV_TC_18735_CLIENT_PHONE_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0003");
        fileName  = preconditionData.get("CLIENTPHONE");
        validateHeaderAsExpectedResults("headerClientPhone");

    }
}
