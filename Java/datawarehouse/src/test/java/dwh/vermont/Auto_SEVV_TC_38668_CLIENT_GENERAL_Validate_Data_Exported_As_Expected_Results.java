package dwh.vermont;

import com.sandata.qtest.QTest;
import generic.ClientGeneralGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_38668_CLIENT_GENERAL_Validate_Data_Exported_As_Expected_Results extends ClientGeneralGenericTest {
    @Test
    @QTest(keys = {"TC-18724"})
    public void Auto_SEVV_TC_38668_CLIENT_GENERAL_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0010");
        fileName  = preconditionData.get("CLIENTGENERAL");
        validateHeaderAsExpectedResults("headerClientGeneral");
    }

    @Test
    public void Auto_SEVV_TC_38668_CLIENT_GENERAL_Validate_ClientID_Is_Not_Empty(){
        initStateInfo();
        GetPreconditionData("TC_0010");
        fileName  = preconditionData.get("CLIENTGENERAL");
        validateClientIDasExpectedResult();
    }

}
