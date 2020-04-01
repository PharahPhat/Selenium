package generic;

import com.sandata.common.Constant;
import com.sandata.models.dwh.ohio.DwhExtract;
import com.sandata.models.dwh.ohio.Visit;
import com.sandata.models.dwh.ohio.VisitException;
import com.sandata.models.molina.visit.VisitExceptionsModel;
import com.sandata.core.report.ExtentTestManager;
import org.testng.Assert;

import java.util.List;

import static com.interop.sql.Sql.SQL_GET_VISIT_EXCEPTION;

public class VisitExceptionGenericTest extends VisitGenericTest{

    public List<VisitExceptionsModel> mapVisitExceptionTableToModel(String groupKey, String visitKey) {
        String sql = String.format(SQL_GET_VISIT_EXCEPTION, groupKey, visitKey);
        return mapDBTableToModel(sql, VisitExceptionsModel.class);
    }

    public boolean isVisitExceptionRecordExistedInDatabase(VisitExceptionsModel fileRecord, List<VisitExceptionsModel> dbRecords) {
        for (VisitExceptionsModel record : dbRecords) {
            if (fileRecord.verifyFieldValue(record)) {
                return true;
            }
        }
        return false;
    }

    public boolean areVisitExceptionRecordsExistedInDatabase(List<VisitExceptionsModel> fileRecords,
                                                             List<VisitExceptionsModel> dbRecords) {
        boolean result = true;
        for (VisitExceptionsModel fileRecord : fileRecords) {
            if (!isVisitExceptionRecordExistedInDatabase(fileRecord, dbRecords)) {
                result = false;
                ExtentTestManager.logTestStep(String.format("File record not found in db: [%s,%s]",
                        fileRecord.getVisitKey(), fileRecord.getExceptionID()));
            } else {
                ExtentTestManager.logTestStep(String.format("File record found in db: [%s, %s]",
                        fileRecord.getVisitKey(), fileRecord.getExceptionID()));
            }
        }
        return result;
    }


    public void verifyVisitExceptionFileDataMatchWithDatabase() {
        String visitKey = getVisitKeyByUniqueMemo(account, visitGeneralEntity.getMemo());
        boolean result =
                areVisitExceptionRecordsExistedInDatabase(
                        filterVisitExceptionBy(visitKey),
                        mapVisitExceptionTableToModel(groupkey, visitKey));
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result);
    }

    public void validateVisitExceptionAsExpectedResults(){
        List<VisitExceptionsModel> datas = filterVisitExceptionBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public void validateVisitExceptionAsExpectedFormat(){
        List<VisitExceptionsModel> datas = filterVisitExceptionBy();
        Assert.assertTrue(datas.size() > 0, "File data is incorrect format");
    }

    public List<VisitExceptionsModel> filterVisitExceptionBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, VisitExceptionsModel.class);
    }

    public void validateOhioVisitExceFromJsonData()  {
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        List<Visit> listVisit =  exportedFile.getVisit();
        if(listVisit != null) {
            List<VisitException> ListVisitExe = listVisit.get(0).getVisitException();
            if(ListVisitExe != null && ListVisitExe.size() > 0)
                Assert.assertTrue(ListVisitExe.get(0).getDataIsNotNull(), "Visit exception is not correct");
        }
    }
}
