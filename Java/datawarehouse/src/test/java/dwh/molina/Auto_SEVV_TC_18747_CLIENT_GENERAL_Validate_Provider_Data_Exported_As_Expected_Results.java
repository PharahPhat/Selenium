package dwh.molina;

import com.sandata.qtest.QTest;
import generic.ClientGeneralGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18747_CLIENT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results extends ClientGeneralGenericTest {
    @Test
    @QTest(keys = {"TC-18724"})
    public void Auto_SEVV_TC_18747_CLIENT_GENERAL_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("CLIENTGENERAL");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 40, "Columns are not expected results");
    }
}
