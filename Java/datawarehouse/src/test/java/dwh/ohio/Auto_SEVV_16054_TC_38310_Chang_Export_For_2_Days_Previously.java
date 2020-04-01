package dwh.ohio;

import generic.V8VisitGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sandata.common.Constant.ODM_EVV_DWExtract;

public class Auto_SEVV_16054_TC_38310_Chang_Export_For_2_Days_Previously extends V8VisitGenericTest {

    String testCaseId = "TC_38310";

    @Test(enabled = true, groups = {"All"})
    public void Auto_SEVV_16054_TC_38310_Chang_Export_For_2_Days_Previously() throws IOException {

        String ohioExportedFileNameFirst, ohioExportedFileNameSecond;

        initStateInfo();
        logStepInfo("Step 1: Prepare payload and call request DWH export");
        DWHExport(1,"1");

        logStepInfo("Step 2: Check exported json file exists in SFTP folder");
        verifyExportedFileExistInSFTPOhio(ODM_EVV_DWExtract);

        Assert.assertTrue(CreateTableData(testCaseId), "Create table not successfully");
        Assert.assertTrue(SavePreconditionData(testCaseId, "exportFile", ohioExportedFileName));
        ohioExportedFileNameFirst = ohioExportedFileName;

        logStepInfo("Step 3: Download Json file from SFTP to local machine");
        Assert.assertTrue(downloadExportedFileOhio(), "Failed in downloading exported Json file.");

        DWHExport(1,null);

        logStepInfo("Step 4: Check exported json file exists in SFTP folder");
        verifyExportedFileExistInSFTPOhio(ODM_EVV_DWExtract);

        ohioExportedFileNameSecond = ohioExportedFileName;
        logStepInfo("Step 5 Download Json file from SFTP to local machine");
        Assert.assertTrue(downloadExportedFileOhio(), "Failed in downloading exported Json file.");

        Assert.assertTrue(compare2files(ohioExportedFileNameFirst, ohioExportedFileNameSecond), "Failed in downloading exported Json file.");
    }
}
