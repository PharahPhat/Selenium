package dwh.molina;

import com.sandata.qtest.QTest;
import generic.VisitClaimstGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18758_VISIT_CLAIMST_Validate_Provider_Data_Exported_As_Expected_Results  extends VisitClaimstGenericTest {

    @Test
    @QTest(keys = {"TC-18740"})
    public void Auto_SEVV_TC_18758_VISIT_CLAIMST_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("VISIT_CLAIMST");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 12, "Columns are not expected results");
    }
}
