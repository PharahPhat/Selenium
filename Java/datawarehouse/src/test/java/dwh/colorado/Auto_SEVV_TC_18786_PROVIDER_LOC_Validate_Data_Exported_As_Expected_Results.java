package dwh.colorado;

import com.sandata.qtest.QTest;
import generic.ProviderLocGenericTest;
import generic.VisitCallGenericTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18786_PROVIDER_LOC_Validate_Data_Exported_As_Expected_Results extends ProviderLocGenericTest {

    @BeforeMethod
    public void precondition(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("PROVIDERLOC");
    }

    @Test
    @QTest(keys = {"TC-18733"})
    public void Auto_SEVV_TC_18786_PROVIDER_LOC_Validate_Data_Exported_As_Expected_Header_Results(){
        validateHeaderAsExpectedResults("headerProviderLoc");
    }

    @Test
    public void Auto_SEVV_TC_18786_PROVIDER_LOC_Validate_Data_Exported_As_Expected_Format(){
        validateProviderLocAsExpectedFormat();
    }
}
