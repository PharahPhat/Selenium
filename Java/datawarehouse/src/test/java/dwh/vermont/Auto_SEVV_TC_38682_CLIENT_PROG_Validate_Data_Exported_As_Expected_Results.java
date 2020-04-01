package dwh.vermont;

import generic.ClientProgGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_38682_CLIENT_PROG_Validate_Data_Exported_As_Expected_Results extends ClientProgGenericTest {

    @Test
    public void Auto_SEVV_TC_38682_CLIENT_PROG_Validate_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0010");
        fileName  = preconditionData.get("CLIENTPROG");
        //TODO: no header
        Assert.assertTrue(false);
    }
}
