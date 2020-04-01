package dwh.ohio;

import generic.VisitClaimstGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18775_VISIT_CLAIMST_Validate_Provider_Data_Exported_As_Expected_Results extends VisitClaimstGenericTest {

    @Test
    public void Auto_SEVV_TC_18758_VISIT_CLAIMST_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_99999");
        ohioExportedFileName  = preconditionData.get("exportFile");
        validateOhioVisitClaimFromJsonData();
    }
}
