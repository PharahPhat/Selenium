package dwh.molina;

import generic.ClientEligibilityGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18760_CLIENT_ELIG_Validate_Provider_Data_Exported_As_Expected_Results extends ClientEligibilityGenericTest {

    @Test
    public void Auto_SEVV_TC_18760_CLIENT_ELIG_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("CLIENTELIG");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 10, "Columns are not expected results");
    }
}
