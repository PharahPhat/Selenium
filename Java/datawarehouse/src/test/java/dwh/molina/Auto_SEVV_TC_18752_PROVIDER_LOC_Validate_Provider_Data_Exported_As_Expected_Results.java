package dwh.molina;

import com.sandata.qtest.QTest;
import generic.ProviderLocGenericTest;
import generic.VisitCallGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18752_PROVIDER_LOC_Validate_Provider_Data_Exported_As_Expected_Results extends ProviderLocGenericTest {
    @Test
    @QTest(keys = {"TC-18733"})
    public void Auto_SEVV_TC_18752_PROVIDER_LOC_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("PROVIDERLOC");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 12, "Columns are not expected results");
    }
}
