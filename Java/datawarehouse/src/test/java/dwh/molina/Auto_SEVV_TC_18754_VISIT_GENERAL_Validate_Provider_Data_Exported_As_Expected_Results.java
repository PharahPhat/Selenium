package dwh.molina;

import com.sandata.qtest.QTest;
import generic.VisitGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18754_VISIT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results extends VisitGenericTest {
    @Test
    @QTest(keys = {"TC-18735"})
    public void Auto_SEVV_TC_18754_VISIT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("VISITGENERAL");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 29, "Columns are not expected results");
    }
}