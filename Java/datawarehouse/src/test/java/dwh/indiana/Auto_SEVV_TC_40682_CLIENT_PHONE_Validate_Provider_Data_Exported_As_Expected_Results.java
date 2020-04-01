package dwh.indiana;

import com.sandata.qtest.QTest;
import generic.ClientPhoneGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40682_CLIENT_PHONE_Validate_Provider_Data_Exported_As_Expected_Results extends ClientPhoneGenericTest {

    @Test
    @QTest(keys = {"TC-18736"})
    public void Auto_SEVV_TC_40682_CLIENT_PHONE_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0007");
        fileName  = preconditionData.get("CLIENTPHONE");
        validateHeaderAsExpectedResults("headerClientPhone");

    }
}
