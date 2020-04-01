package dwh.molina;

import com.sandata.qtest.QTest;
import generic.VisitExceptionGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18757_VISIT_EXCP_Validate_Provider_Data_Exported_As_Expected_Results extends VisitExceptionGenericTest {

    @Test
    @QTest(keys = {"TC-18739"})
    public void Auto_SEVV_TC_18739_VISIT_EXCP_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("VISIT_EXCP");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 3, "Columns are not expected results");
    }

}