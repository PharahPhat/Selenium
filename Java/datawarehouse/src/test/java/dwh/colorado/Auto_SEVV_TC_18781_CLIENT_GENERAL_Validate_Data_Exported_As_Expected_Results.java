package dwh.colorado;

import com.sandata.qtest.QTest;
import generic.ClientGeneralGenericTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18781_CLIENT_GENERAL_Validate_Data_Exported_As_Expected_Results extends ClientGeneralGenericTest {

    @BeforeMethod
    public void precondition(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("CLIENTGENERAL");
    }

    @Test
    @QTest(keys = {"TC-18724"})
    public void Auto_SEVV_TC_18781_CLIENT_GENERAL_Validate_Data_Exported_As_Expected_Header_Results(){
        validateHeaderAsExpectedResults("headerClientGeneral");
    }
}
