package dwh.molina;

import com.sandata.qtest.QTest;
import generic.ProviderGeneralGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18748_PROVIDER_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results extends ProviderGeneralGenericTest {
    @Test
    @QTest(keys = {"TC-18725"})
    public void Auto_SEVV_TC_18748_PROVIDER_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("PROVIDERGENERAL");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 26, "Columns are not expected results");
    }

}
