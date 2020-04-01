package dwh.indiana;

import com.sandata.qtest.QTest;
import generic.ClientGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40674_CLIENT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results extends ClientGeneralGenericTest {
    @Test
    @QTest(keys = {"TC-18724"})
    public void Auto_SEVV_TC_40674_CLIENT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0007");
        fileName  = preconditionData.get("CLIENTGENERAL");
        validateHeaderAsExpectedResults("headerClientGeneral");
    }
}
