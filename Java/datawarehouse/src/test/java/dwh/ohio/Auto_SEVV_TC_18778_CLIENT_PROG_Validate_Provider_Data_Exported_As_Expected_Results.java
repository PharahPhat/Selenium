package dwh.ohio;

import generic.ClientProgGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18778_CLIENT_PROG_Validate_Provider_Data_Exported_As_Expected_Results extends ClientProgGenericTest {

    @Test
    public void Auto_SEVV_TC_18761_CLIENT_PROG_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_0009");
        fileName  = preconditionData.get("CLIENTPROG");
        //validateProviderGeneralIsGeneratedAsExpectedResults();
    }
}
