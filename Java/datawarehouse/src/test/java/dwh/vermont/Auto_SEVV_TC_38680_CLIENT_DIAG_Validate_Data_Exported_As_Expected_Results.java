package dwh.vermont;

import generic.ClientDiagGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_38680_CLIENT_DIAG_Validate_Data_Exported_As_Expected_Results extends ClientDiagGenericTest {
    @Test
    public void Auto_SEVV_TC_38680_CLIENT_DIAG_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0010");
        fileName  = preconditionData.get("CLIENTDIAG");
        //TODO: no header
        Assert.assertTrue(false);
    }
}
