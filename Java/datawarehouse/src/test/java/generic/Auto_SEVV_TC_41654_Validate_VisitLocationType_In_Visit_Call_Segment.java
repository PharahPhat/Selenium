package generic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.sandata.common.Constant.VISIT_CALLS;

public class Auto_SEVV_TC_41654_Validate_VisitLocationType_In_Visit_Call_Segment extends EmployeeGeneralGenericTest{

    /**
     * Precondition: specNumber = 7.x
     * Expected result: VISIT_CALL col header display VisitLocationType
     * Description = SEVV-18186 QA-Auto: Inter-Op - DWH - Populate Location with Home/Community
     */
    @Test
    public void Auto_SEVV_TC_41654_Validate_VisitLocationType_In_Visit_Call_Segment(){
        initStateInfo();
        DWHExport(dwh_startDate_sevv_18186, dwh_endDate_sevv_18186);
        verifyExportedFileExistInSFTP(VISIT_CALLS);
        downloadExportedFile(VISIT_CALLS);
        validateVisitLocationTypeDataExpectedResult();
    }

    /**
     * Precondition: SpecNumber: 6.x, SpecNumber: 5.x
     * Expected result: VISIT_CALL col header don't display VisitLocationType as spec6.x, spec6.x
     * Description: SEVV-18186 QA-Auto: Inter-Op - DWH - Populate Location with Home/Community
     */
    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {"6.0","headerVisitCall6.x"},
                        {"5.2","headerVisitCall5.x"}
                };
    }

    @Test(dataProvider = "dataProvider")
    public void Auto_SEVV_TC_41655_Validate_VisitLocationType_Not_In_Visit_Call_Segment(String specNum, String header){
        initStateInfo();
        specNumber = specNum;
        DWHExport(dwh_startDate_sevv_18186, dwh_endDate_sevv_18186);
        verifyExportedFileExistInSFTP(VISIT_CALLS);
        downloadExportedFile(VISIT_CALLS);
        validateHeaderAsExpectedResults(header);
    }

}
