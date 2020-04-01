package generic;

import com.sandata.common.Constant;
import com.sandata.models.dwh.ohio.DwhExtract;
import com.sandata.models.dwh.ohio.HistoricalVisitChanges;
import com.sandata.models.dwh.ohio.Visit;
import com.sandata.models.molina.visit.VisitChange;
import com.sandata.models.molina.visit.VisitChangesModel;
import com.sandata.core.report.ExtentTestManager;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.interop.sql.Sql.SQL_GET_VISIT_LOG;

public class VisitChangesGenericTest extends VisitGenericTest{
    public List<VisitChangesModel> mapVisitGeneralTableToModel(String visitKey) {
        String sql = String.format(SQL_GET_VISIT_LOG, visitKey);
        return mapDataTableToModel(sql, VisitChangesModel.class);
    }

    public List<VisitChangesModel> filterVisitCallBy(String visitKey) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitChangesModel.class, true)
                .stream().filter(visitGeneral -> visitGeneral.getVisitKey().equalsIgnoreCase(visitKey)).collect(Collectors.toList());
    }

    public void verifyVisitChangesFileDataMatchWithDatabase() {
        String visitKey = getVisitKeyByUniqueMemo(account, visitGeneralEntity.Memo);
        boolean result =
                areRecordsExistedInDatabase(
                        filterVisitCallBy(visitKey),
                        mapVisitGeneralTableToModel(visitKey));
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result);
    }

    public void verifyVisitChangesExportedWithCorrectFormat() {
        String visitKey = getVisitKeyByUniqueMemo(account, visitGeneralEntity.getMemo());
        List<VisitChangesModel> exportResult = filterVisitChangeBy(visitKey);
        exportResult.sort(Comparator.comparing(VisitChangesModel::getVisitKey));
        boolean result = VisitChangesModel.verifyDataInCsvCorrectly(exportResult);
        if(result) {
            ExtentTestManager.logPass("Field Format is correct");
        } else {
            ExtentTestManager.logFailure(String.format("Field Format is incorrect"));
        }
        Assert.assertTrue(result);
    }

    public void validateVisitChangesIsGeneratedAsExpectedResults(){
        List<VisitChangesModel> datas = filterEligibilityBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public void validateVisitChangesIsGeneratedAsExpectedFormat(){
        List<VisitChangesModel> datas = filterEligibilityBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public List<VisitChangesModel> filterEligibilityBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, VisitChangesModel.class);
    }

    public void validateOhioVisitHistoricalChangeFromJsonData(){
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        List<Visit> visits =  exportedFile.getVisit();
        if(visits != null){
            List<HistoricalVisitChanges> changes = visits.get(0).getHistoricalVisitChanges();
            if(changes != null && changes.size() > 0)
            Assert.assertTrue(changes.get(0).getDataIsNotNull(), "Staff Header is not expected result");
        }
    }
}
