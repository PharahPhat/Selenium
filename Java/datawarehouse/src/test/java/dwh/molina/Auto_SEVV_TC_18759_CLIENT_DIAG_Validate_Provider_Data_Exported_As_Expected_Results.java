package dwh.molina;

import generic.ClientDiagGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18759_CLIENT_DIAG_Validate_Provider_Data_Exported_As_Expected_Results  extends ClientDiagGenericTest {
    @Test
    public void Auto_SEVV_TC_18759_CLIENT_DIAG_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0002");
        fileName  = preconditionData.get("CLIENT_DIAG");
        Assert.assertTrue(commons.getColDataOfFile(fileName) == 5, "Columns are not expected results");
    }
}
