package dwh.hawaii;

import com.sandata.qtest.QTest;
import generic.VisitClaimstGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_50015_CLIENT_DESIGNEE_Validate_Data_Exported_As_Expected_Results extends VisitClaimstGenericTest {

    @Test
    @QTest(keys = {"TC-18744"})
    public void Auto_SEVV_TC_50015_CLIENT_DESIGNEE_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0012");
        fileName  = preconditionData.get("CLIENT_DESIGNEE");
        validateHeaderAsExpectedResults("headerClientDesignee");
    }
}
