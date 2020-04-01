package dwh.connecticut;

import com.sandata.common.Constant;
import generic.V8VisitGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.sandata.common.Constant.*;
import static com.sandata.common.Constant.CLIENT_ADDR;

public class Auto_SEVV_DWH_TC_0003_Export_Files_Connecticut extends V8VisitGenericTest {

    String testCaseId = "TC_0003";

    @Test(enabled = true, groups = {"All"})
    public void Auto_SEVV_DWH_TC_0003_Export_Files_Connecticut() {
        initStateInfo();
        String visitDate = getVisitDate();
        dwh_startDate = commons.convertDateTimeFormatFrom2FormatTo(visitDate, commons.getDateFormatNow(), commons.getDateFormat24h(),-1);
        dwh_endDate = commons.convertDateTimeFormatFrom2FormatTo(visitDate, commons.getDateFormatNow(), commons.getDateFormat24h(),1);

        Assert.assertTrue(CreateTableData(testCaseId), "Create table not successfully");

        logStepInfo("Step 1: Prepare payload and call request DWH export");
        DWHExport(dwh_startDate, dwh_endDate);

        logStepInfo("**** Check exported json file exists in SFTP folder");
        verifyExportedFileExistInSFTP(EMP_GENERAL);

        //Save File Name EMP_GENERAL
        Assert.assertTrue(SavePreconditionData(testCaseId, "EMPGENERAL", fileName));

        logStepInfo("**** Download EMP_GENERAL from SFTP to local machine");
        downloadExportedFile(EMP_GENERAL);

        logStepInfo("**** Check CLIENT_GENERAL exported file exists in SFTP folder");
        verifyExportedFileExistInSFTP(CLIENT_GENERAL);

        //Save File Name CLIENT_GENERAL
        Assert.assertTrue(SavePreconditionData(testCaseId, "CLIENTGENERAL", fileName));

        logStepInfo("**** Download CLIENT_GENERAL from SFTP to local machine");
        downloadExportedFile(CLIENT_GENERAL);


        logStepInfo("**** Check PROVIDER_GENERAL exported file exists in SFTP folder");
        verifyExportedFileExistInSFTP(PROVIDER_GENERAL);

        //Save File Name PROVIDER_GENERAL
        Assert.assertTrue(SavePreconditionData(testCaseId, "PROVIDERGENERAL", fileName));

        logStepInfo("**** Download PROVIDER_GENERAL from SFTP to local machine");
        downloadExportedFile(PROVIDER_GENERAL);

        logStepInfo("**** Verify exported files exist in SFTP folder");
        verifyExportedFileExistInSFTP(Constant.EMP_DISC);

        //Save File Name EMP_DISC
        Assert.assertTrue(SavePreconditionData(testCaseId, "EMPDISC", fileName));

        logStepInfo("**** Download exported file from SFTP folder");
        downloadExportedFile(Constant.EMP_DISC);

        logStepInfo("Step 3: Check VISIT_CHANGES exported file exists in SFTP folder");
        verifyExportedFileExistInSFTP(VISIT_CHANGES);

        //Save File Name EMP_DISC
        Assert.assertTrue(SavePreconditionData(testCaseId, "VISITCHANGES", fileName));

        logStepInfo("**** Download exported file from SFTP folder");
        downloadExportedFile(Constant.VISIT_CHANGES);

        logStepInfo("**** Check VISIT_CALLS exported file exists in SFTP folder");
        verifyExportedFileExistInSFTP(VISIT_CALLS);

        //Save File Name VISIT_CALLS
        Assert.assertTrue(SavePreconditionData(testCaseId, "VISITCALLS", fileName));

        logStepInfo("**** Download VISIT_CALLS from SFTP to local machine");
        downloadExportedFile(VISIT_CALLS);

        logStepInfo("**** Check PROVIDER_GENERAL exported file exists in SFTP folder");
        verifyExportedFileExistInSFTP(PROVIDER_LOC);

        Assert.assertTrue(SavePreconditionData(testCaseId, "PROVIDERLOC", fileName));

        logStepInfo("**** Download PROVIDER_GENERAL from SFTP to local machine");
        downloadExportedFile(PROVIDER_LOC);

        logStepInfo("**** Check CLIENT_ADDR exported file exists in SFTP folder");
        verifyExportedFileExistInSFTP(CLIENT_ADDR);

        Assert.assertTrue(SavePreconditionData(testCaseId, "CLIENTADDR", fileName));

        logStepInfo("**** Download CLIENT_ADDR from SFTP to local machine");
        downloadExportedFile(CLIENT_ADDR);

        logStepInfo("Step 6: Check VISIT_GENERAL exported file exists in SFTP folder");
        verifyExportedFileExistInSFTP(VISIT_GENERAL);

        Assert.assertTrue(SavePreconditionData(testCaseId, "VISITGENERAL", fileName));

        logStepInfo("Step 7: Download VISIT_GENERAL from SFTP to local machine");
        downloadExportedFile(VISIT_GENERAL);

        logStepInfo("Step 6: Check CLIENT_PHONE exported file exists in SFTP folder");
        verifyExportedFileExistInSFTP(CLIENT_PHONE);

        Assert.assertTrue(SavePreconditionData(testCaseId, "CLIENTPHONE", fileName));

        logStepInfo("Step 7: Download CLIENT_PHONE from SFTP to local machine");
        downloadExportedFile(CLIENT_PHONE);

        logStepInfo("Step 8: Download VISIT_TASKS from SFTP to local machine");
        verifyExportedFileExistInSFTP(VISIT_TASKS);

        Assert.assertTrue(SavePreconditionData(testCaseId, "VISIT_TASKS", fileName));

        logStepInfo("Step 9: Download VISIT_TASKS from SFTP to local machine");
        downloadExportedFile(VISIT_TASKS);

        logStepInfo("Step 10: Download VISIT_TASKS from SFTP to local machine");
        verifyExportedFileExistInSFTP(VISIT_EXCP);

        Assert.assertTrue(SavePreconditionData(testCaseId, "VISIT_EXCP", fileName));

        logStepInfo("Step 11: Download VISIT_EXCP from SFTP to local machine");
        downloadExportedFile(VISIT_EXCP);

        logStepInfo("Step 12: Download VISIT_CLAIMST from SFTP to local machine");
        verifyExportedFileExistInSFTP(VISIT_CLAIMST);

        Assert.assertTrue(SavePreconditionData(testCaseId, "VISIT_CLAIMST", fileName));

        logStepInfo("Step 13: Download VISIT_CLAIMST from SFTP to local machine");
        downloadExportedFile(VISIT_CLAIMST);

        logStepInfo("Step 14: Download CLIENT_DIAG from SFTP to local machine");
        verifyExportedFileExistInSFTP(CLIENT_DIAG);

        Assert.assertTrue(SavePreconditionData(testCaseId, "CLIENT_DIAG", fileName));

        logStepInfo("Step 15: Download CLIENT_DIAG from SFTP to local machine");
        downloadExportedFile(CLIENT_DIAG);

        logStepInfo("Step 16: Download CLIENT_ELIG from SFTP to local machine");
        verifyExportedFileExistInSFTP(CLIENT_ELIG);

        Assert.assertTrue(SavePreconditionData(testCaseId, "CLIENT_ELIG", fileName));

        logStepInfo("Step 17: Download CLIENT_ELIG from SFTP to local machine");
        downloadExportedFile(CLIENT_ELIG);

        logStepInfo("Step 18: Download CLIENT_PROG from SFTP to local machine");
        verifyExportedFileExistInSFTP(CLIENT_PROG);

        Assert.assertTrue(SavePreconditionData(testCaseId, "CLIENT_PROG", fileName));

        logStepInfo("Step 19: Download CLIENT_PROG from SFTP to local machine");
        downloadExportedFile(CLIENT_PROG);

        logStepInfo("Step 20: Download CLIENT_PROG from SFTP to local machine");
        verifyExportedFileExistInSFTP(CLIENT_SCHEDULE);

        Assert.assertTrue(SavePreconditionData(testCaseId, "CLIENT_SCHEDULE", fileName));

        logStepInfo("Step 21: Download CLIENT_SCHEDULE from SFTP to local machine");
        downloadExportedFile(CLIENT_SCHEDULE);

        //Save all exported files
        Assert.assertTrue(SavePreconditionData(testCaseId, "exportedFileNames", exportedFileNames.toString()));
        //Save Start Date
        Assert.assertTrue(SavePreconditionData(testCaseId, "startDate", dwh_startDate));
        //Save End Date
        Assert.assertTrue(SavePreconditionData(testCaseId, "endDate", dwh_endDate));
        //Save File Name
        Assert.assertTrue(SavePreconditionData(testCaseId, "fileName", fileName));

    }
}
