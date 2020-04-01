package dwh.molina;

import com.sandata.qtest.QTest;
import generic.ClientPhoneGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18755_CLIENT_PHONE_Validate_Provider_Data_Exported_As_Expected_Results extends ClientPhoneGenericTest {

    @Test
    @QTest(keys = {"TC-18736"})
    public void Auto_SEVV_TC_18755_CLIENT_PHONE_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("CLIENTPHONE");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 5, "Columns are not expected results");
    }
}
