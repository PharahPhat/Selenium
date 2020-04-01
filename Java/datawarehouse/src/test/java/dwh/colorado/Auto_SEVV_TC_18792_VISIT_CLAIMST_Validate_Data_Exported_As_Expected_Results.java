package dwh.colorado;

import com.sandata.qtest.QTest;
import generic.VisitClaimstGenericTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18792_VISIT_CLAIMST_Validate_Data_Exported_As_Expected_Results extends VisitClaimstGenericTest {

    @BeforeMethod
    public void precondition(){
        initStateInfo();
        GetPreconditionData("TC_0004");
        fileName  = preconditionData.get("VISIT_CLAIMST");
    }

    @Test
    @QTest(keys = {"TC-18740"})
    public void Auto_SEVV_TC_18792_VISIT_CLAIMST_Validate_Data_Exported_As_Expected_Header_Results(){
        validateHeaderAsExpectedResults("headerVisitClaimst");
    }

    @Test
    public void Auto_SEVV_TC_18792_VISIT_CLAIMST_Validate_Data_Exported_As_Expected_Format(){
        validateVisitClaimstAsExpectedFormat();
    }
}
