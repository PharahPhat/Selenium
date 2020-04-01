package generic;

import com.sandata.common.Constant;
import com.sandata.models.dwh.ohio.DwhExtract;
import com.sandata.models.dwh.ohio.Visit;
import com.sandata.models.molina.visit.VisitCallsModel;
import com.sandata.core.report.ExtentTestManager;
import org.testng.Assert;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.interop.sql.Sql.SQL_GET_VISIT_CALL;

public class VisitCallGenericTest extends VisitGenericTest {
    public List<VisitCallsModel> mapVisitGeneralTableToModel(String accountId, String visitKey) {
        String sql = String.format(SQL_GET_VISIT_CALL, accountId, visitKey);
        return mapDataTableToModel(sql, VisitCallsModel.class);
    }

    public List<VisitCallsModel> filterVisitCallBy(String visitKey) {
         return  filterVisitCallBy(mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitCallsModel.class,true),
                visitKey);
    }

    private List<VisitCallsModel> filterVisitCallBy(List<VisitCallsModel> list, String visitKey) {
        List<VisitCallsModel> visitCallsModels = list.
                stream().
                filter(visitGeneral -> visitGeneral.getVisitKey().equalsIgnoreCase(visitKey)).
                collect(Collectors.toList());
        return visitCallsModels;
    }

    public void validateVisitCallsIsGeneratedAsExpectedResults(){
        List<VisitCallsModel> datas = filterVisitCallsBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public void validateVisitCallsIsGeneratedAsExpectedFormat(){
        List<VisitCallsModel> datas = filterVisitCallsBy();
        Assert.assertTrue(datas.size() > 0 , "File data is not correct format");
    }

    public List<VisitCallsModel> filterVisitCallsBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, VisitCallsModel.class);
    }

    public void verifyVisitCallFileDataMatchWithDatabase() {
        String visitKey = getVisitKeyByUniqueMemo(account, visitGeneralEntity.getMemo());
        boolean result =
                areRecordsExistedInDatabase(
                        filterVisitCallBy(visitKey),
                        mapVisitGeneralTableToModel(account,
                                visitKey));
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result);
    }

    public void verifyVisitCallExportedWithCorrectFormat() {
        String visitKey = getVisitKeyByUniqueMemo(account ,visitGeneralEntity.getMemo());
        List<VisitCallsModel> exportResult = filterVisitCallBy(
                mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitCallsModel.class),
                visitKey);
        exportResult.sort(Comparator.comparing(VisitCallsModel::getVisitKey));
        boolean result = VisitCallsModel.verifyDataInDbAndCsvCorrectly(exportResult);
        if(result) {
            ExtentTestManager.logPass("Field Format is correct");
        } else {
            ExtentTestManager.logFailure(String.format("Field Format is incorrect"));
        }
        Assert.assertTrue(result);
    }

    public void validateOhioVisitCallFromJsonData()  {
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        List<Visit> listVisit =  exportedFile.getVisit();
        if(listVisit != null)
            Assert.assertTrue(listVisit.get(0).getCalls().size() > 0, "Staff Header is not expected result");
    }

}
