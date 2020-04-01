package dwh.colorado;

import com.sandata.qtest.QTest;
import generic.ClientPhoneGenericTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18789_CLIENT_PHONE_Validate_Data_Exported_As_Expected_Results extends ClientPhoneGenericTest {

    @BeforeMethod
    public void precondition(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("CLIENTPHONE");
    }

    @Test
    @QTest(keys = {"TC-18736"})
    public void Auto_SEVV_TC_18789_CLIENT_PHONE_Validate_Data_Exported_As_Expected_Header_Results(){
        validateHeaderAsExpectedResults("headerClientPhone");
    }
}
