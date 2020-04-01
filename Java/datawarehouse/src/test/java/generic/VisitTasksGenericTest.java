package generic;

import com.sandata.common.Constant;
import com.sandata.models.molina.visit.VisitTasksModel;
import com.sandata.core.report.ExtentTestManager;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.interop.sql.VisitSQL.SQL_GET_VISIT_TASK;

public class VisitTasksGenericTest extends V8VisitGenericTest {
    public List<VisitTasksModel> mapVisitTasksTableToModel(String visitKey) {
        String updateId = getUpdateIdBy(visitKey);
        String sql = String.format(SQL_GET_VISIT_TASK, updateId, visitKey);
        return mapDataTableToModel(sql, VisitTasksModel.class);
    }

    public List<VisitTasksModel> filterVisitTaskBy(String visitKey) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitTasksModel.class, true)
                .stream().filter(visitGeneral -> visitGeneral.getVisitKey().equalsIgnoreCase(visitKey)).collect(Collectors.toList());
    }

    public void verifyVisitTaskFileDataMatchWithDatabase(String clientFName, String clientLName) {
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));

        boolean result =
                areRecordsExistedInDatabase(
                        filterVisitTaskBy(visitKey),
                        mapVisitTasksTableToModel(visitKey));
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result);
    }

    public void verifyClientAddressExportedWithCorrectFormat(String clientFName, String clientLName) {
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));
        List<VisitTasksModel> exportResult = filterVisitTaskBy(visitKey);

        boolean result = VisitTasksModel.verifyDataInDbAndCsvCorrectly(exportResult);
        if(result) {
            ExtentTestManager.logPass("Field Format is correct");
        } else {
            ExtentTestManager.logFailure(String.format("Field Format is incorrect"));
        }
        Assert.assertTrue(result, "Field Format is incorrect");
    }

    public void validateVisitTasksAsExpectedResults(){
        List<VisitTasksModel> datas = filterVisitTaskBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public void validateVisitTasksAsExpectedFormat(){
        List<VisitTasksModel> datas = filterVisitTaskBy();
        Assert.assertTrue(datas.size() > 0, "File data is incorrect format");
    }

    public List<VisitTasksModel> filterVisitTaskBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, VisitTasksModel.class);
    }
}
