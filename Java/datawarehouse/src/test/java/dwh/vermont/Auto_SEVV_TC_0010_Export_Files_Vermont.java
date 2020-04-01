package dwh.vermont;

import com.sandata.common.Constant;
import generic.V8VisitGenericTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.sandata.common.Constant.*;

public class Auto_SEVV_TC_0010_Export_Files_Vermont extends V8VisitGenericTest{
    String testCaseId = "TC_0010";

    @Test
    public void Auto_SEVV_DWH_TC_0010_Export_Files_Vermont() {
        initStateInfo();
        String visitDate = getVisitDate();
        dwh_startDate = commons.convertDateTimeFormatFrom2FormatTo(visitDate, commons.getDateFormatNow(), commons.getDateFormat24h(),-1);
        dwh_endDate = commons.convertDateTimeFormatFrom2FormatTo(visitDate, commons.getDateFormatNow(), commons.getDateFormat24h(),1);

        Assert.assertTrue(CreateTableData(testCaseId), "Create table not successfully");

        logStepInfo("**** Prepare payload and call request DWH export");
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
        verifyExportedFileIsNotExistInSFTP(VISIT_TASKS);

        logStepInfo("Step 10: Download VISIT_TASKS from SFTP to local machine");
        verifyExportedFileExistInSFTP(VISIT_EXCP);

        Assert.assertTrue(SavePreconditionData(testCaseId, "VISIT_EXCP", fileName));

        logStepInfo("Step 11: Download VISIT_EXCP from SFTP to local machine");
        downloadExportedFile(VISIT_EXCP);

        logStepInfo("Step 12: Download VISIT_CLAIMST from SFTP to local machine");
        verifyExportedFileIsNotExistInSFTP(VISIT_CLAIMST);

        logStepInfo("Step 20: Download CLIENT_PROG from SFTP to local machine");
        verifyExportedFileIsNotExistInSFTP(CLIENT_SCHEDULE);

        logStepInfo("Step 22: Download CLIENT_DESIGNEE from SFTP to local machine");
        verifyExportedFileExistInSFTP(CLIENT_DESIGNEE);
        downloadExportedFile(CLIENT_DESIGNEE);
        Assert.assertTrue(SavePreconditionData(testCaseId, "CLIENTDESIGNEE", fileName));

        //Save all exported files
        Assert.assertTrue(SavePreconditionData(testCaseId, "exportedFileNames", exportedFileNames.toString()));
        //Save Start Date
        Assert.assertTrue(SavePreconditionData(testCaseId, "startDate", dwh_startDate));
        //Save End Date
        Assert.assertTrue(SavePreconditionData(testCaseId, "endDate", dwh_endDate));
        //Save response of dwh export
        Assert.assertTrue(SavePreconditionData(testCaseId, "dwhResponse", dwhResponse));

    }

}
