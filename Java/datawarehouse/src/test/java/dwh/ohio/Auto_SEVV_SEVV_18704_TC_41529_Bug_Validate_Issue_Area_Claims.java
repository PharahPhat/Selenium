package dwh.ohio;

import generic.EmployeeGeneralGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.sandata.common.Constant.ODM_EVV_DWExtract;

public class Auto_SEVV_SEVV_18704_TC_41529_Bug_Validate_Issue_Area_Claims extends EmployeeGeneralGenericTest {
    @Test
    public void Auto_SEVV_SEVV_18704_TC_41529_Bug_Validate_Issue_Area_Claims(){
        initStateInfo();
        DWHExport(dwh_startDate, dwh_endDate);
        verifyExportedFileExistInSFTPOhio(ODM_EVV_DWExtract);
        Assert.assertTrue(downloadExportedFileOhio(), "Failed in downloading exported Json file.");
        validateClaimVisitStartDateEndDateDateOfService();
        validateGroupVisitIndicatorAndGroupVisitCode();
    }
}
