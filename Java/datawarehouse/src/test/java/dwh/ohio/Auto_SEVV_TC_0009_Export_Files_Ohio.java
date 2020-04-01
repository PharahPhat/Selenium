package dwh.ohio;

import com.sandata.qtest.QTest;
import generic.V8VisitGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.sandata.common.Constant.ODM_EVV_DWExtract;
import static com.sandata.common.Constant.PROVIDER_LOC;

public class Auto_SEVV_TC_0009_Export_Files_Ohio extends V8VisitGenericTest {

    String testCaseId = "TC_99999";

    @Test
    @QTest(keys = {"TC-18722","TC-18722","TC-18725","TC-18722","TC-18726","TC-18727","TC-18732","TC-18733","TC-18734","TC-18735","TC-18736","TC-18738","TC-18739","TC-18740","TC-18743","TC-18744","TC-18745"})
    public void Auto_SEVV_TC_0009_Export_Files_Ohio() {
        initStateInfo();
        String visitDate = getVisitDateWithNewestVisit();
        dwh_startDate = commons.convertDateTimeFormatFrom2FormatTo(visitDate, commons.getDateFormatNow(), commons.getDateFormat24h(),-1);
        dwh_endDate = commons.convertDateTimeFormatFrom2FormatTo(visitDate, commons.getDateFormatNow(), commons.getDateFormat24h(),1);

        logStepInfo("Step 1: Prepare payload and call request DWH export");
        DWHExport(dwh_startDate, dwh_endDate);

        logStepInfo("Step 2: Check exported json file exists in SFTP folder");
        verifyExportedFileExistInSFTPOhio(ODM_EVV_DWExtract);

        Assert.assertTrue(CreateTableData(testCaseId), "Create table not successfully");
        Assert.assertTrue(SavePreconditionData(testCaseId, "exportFile", ohioExportedFileName));

        logStepInfo("Step 3: Download Json file from SFTP to local machine");
        Assert.assertTrue(downloadExportedFileOhio(), "Failed in downloading exported Json file.");

    }
}
