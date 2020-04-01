package dwh.ohio;

import generic.VisitExceptionGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18774_VISIT_EXCP_Validate_Provider_Data_Exported_As_Expected_Results extends VisitExceptionGenericTest {

    @Test
    public void Auto_SEVV_TC_18757_VISIT_EXCP_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_99999");
        ohioExportedFileName  = preconditionData.get("exportFile");
        validateOhioVisitExceFromJsonData();
    }

}
