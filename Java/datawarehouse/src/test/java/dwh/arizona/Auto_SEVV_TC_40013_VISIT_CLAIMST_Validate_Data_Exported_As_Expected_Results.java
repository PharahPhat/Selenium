package dwh.arizona;

import com.sandata.qtest.QTest;
import generic.VisitClaimstGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40013_VISIT_CLAIMST_Validate_Data_Exported_As_Expected_Results extends VisitClaimstGenericTest {

    @Test
    @QTest(keys = {"TC-18740"})
    public void Auto_SEVV_TC_38679_VISIT_CLAIMST_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0011");
        fileName  = preconditionData.get("VISIT_CLAIMST");
        validateHeaderAsExpectedResults("headerVisitClaimst");
    }
}
