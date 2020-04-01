package dwh.ohio;

import generic.VisitChangesGenericTest;
import org.testng.annotations.Test;

public class Auto_SEVV_TC_18767_VISIT_CHANGES_Validate_Provider_Data_Exported_As_Expected_Results extends VisitChangesGenericTest {
    @Test
    public void Auto_SEVV_TC_18750_VISIT_CHANGES_Validate_Provider_Data_Exported_As_Expected_Results(){
        initStateInfo();
        GetPreconditionData("TC_99999");
        ohioExportedFileName  = preconditionData.get("exportFile");
        validateOhioVisitHistoricalChangeFromJsonData();
    }
}
