package dwh.molina;

import generic.ClientProgGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18761_CLIENT_PROG_Validate_Provider_Data_Exported_As_Expected_Results extends ClientProgGenericTest {

    @Test
    public void Auto_SEVV_TC_18761_CLIENT_PROG_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("CLIENT_PROG");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 6, "Columns are not expected results");
    }
}
