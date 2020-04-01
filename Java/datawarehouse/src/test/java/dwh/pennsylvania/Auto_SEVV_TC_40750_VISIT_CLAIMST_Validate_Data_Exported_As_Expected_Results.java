package dwh.pennsylvania;

import com.sandata.qtest.QTest;
import generic.VisitClaimstGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_40750_VISIT_CLAIMST_Validate_Data_Exported_As_Expected_Results extends VisitClaimstGenericTest {

    @Test
    @QTest(keys = {"TC-18740"})
    public void Auto_SEVV_TC_18792_VISIT_CLAIMST_Validate_Data_Exported_As_Expected_Header_Results() {
        initStateInfo();
        GetPreconditionData("TC_0006");
        fileName = preconditionData.get("VISIT_CLAIMST");
        validateHeaderAsExpectedResults("headerVisitClaimst");
    }
}
