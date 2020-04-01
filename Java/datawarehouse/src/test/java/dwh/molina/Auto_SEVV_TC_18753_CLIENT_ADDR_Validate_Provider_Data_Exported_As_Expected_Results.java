package dwh.molina;

import com.sandata.qtest.QTest;
import generic.ClientAddressGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18753_CLIENT_ADDR_Validate_Provider_Data_Exported_As_Expected_Results extends ClientAddressGenericTest {
    @Test
    @QTest(keys = {"TC-18734"})
    public void Auto_SEVV_TC_18753_CLIENT_ADDR_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("CLIENTADDR");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 10, "Columns are not expected results");
    }

}
