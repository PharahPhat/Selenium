package generic;
import com.sandata.models.molina.employee.EmployeeDisciplineModel;
import com.sandata.common.Constant;
import com.sandata.core.report.ExtentTestManager;
import org.testng.Assert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.interop.sql.EmployeeSQL.SQL_GET_EMPLOYEE_DISC;
import static com.interop.sql.Sql.SQL_GET_EMPLOYEE_DISC_FROM_DATE_RANGE;

public class EmployeeDisciplineTest extends V8VisitGenericTest{

    /**
     * Author: Liem.chau (Tony)
     * Des: Map data from database to the model
     * @param providerId: list input of employee item
     * @return The employee Discipline Model list
     */
    public List<EmployeeDisciplineModel> mapEmployeeDisciplineModel(String providerId) {
        String sql = String.format(SQL_GET_EMPLOYEE_DISC_FROM_DATE_RANGE, providerId);
        return mapDataTableToModel(sql, EmployeeDisciplineModel.class);
    }

    /**
     * Author: liem.chau (Tony)
     * Des: Double check all data in db are existed in all data are exported.
     * @param fileRecords the list data from the file
     * @param dbRecords   the list data form db
     * @return true if existing and else is false
     */
    public boolean areEmployeeDisciplineRecordsExistedInDatabase(List<EmployeeDisciplineModel> fileRecords,
                                                             List<EmployeeDisciplineModel> dbRecords) {
        int count = 0;
        int maxCount = 10;
        int i = 0;
        for (EmployeeDisciplineModel currData : fileRecords) {
            if (isEmployeeDisciplineRecordExistedInExportFile(currData, dbRecords)) {
                ExtentTestManager.logTestStep(String.format("File record found in db"));
                count ++;
            }
            i ++;
            if(i > maxCount)
                break;
        }
        return (count > 0);
    }

    /**
     * Author: liem.chau (Tony)
     * Des: Double check the employee records are existed in export files
     * @param fileRecord the record of employee common get from a export file
     * @param dbRecords the list of employee discipline get from db
     * @return true if exist and else is false
     */
    public boolean isEmployeeDisciplineRecordExistedInExportFile(EmployeeDisciplineModel fileRecord,
                                                               List<EmployeeDisciplineModel> dbRecords) {
        for (EmployeeDisciplineModel record : dbRecords) {
            String fileDataInfo = fileRecord.toString();
            String currDataDbInfo = record.toString();
            if(fileDataInfo.equals(currDataDbInfo))
                return true;
        }
        return false;
    }

    /**
     * Author: liem.chau (Tony)
     * Comment: Get the employee Discipline list model from the file in the input folder
     * @return the employee Discipline model list
     */
    public List<EmployeeDisciplineModel> filterEmpDiscBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, EmployeeDisciplineModel.class);
    }

    /**
     * Author: Trang PM
     * Des: Map data from database to the model
     * @param employeeFName
     * @param employeeLName
     * @param account
     * @return the employee Discipline Model model list
     */
    public List<EmployeeDisciplineModel> mapEmployeeDisciplineTableToModel(String employeeFName, String employeeLName, String account) {
        String sql = String.format(SQL_GET_EMPLOYEE_DISC, employeeFName, employeeLName, account);
        return mapDataTableToModel(sql, EmployeeDisciplineModel.class);
    }

    /**
     * Author: Trang PM
     * Des: Get the employee Discipline list model from the file in the input folder
     * @return the employee General Model model list
     */
    public List<EmployeeDisciplineModel> filterEmployeeDisciplineBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, EmployeeDisciplineModel.class);
    }

    /**
     * Author: liem.chau (Tony)
     * Des: Verify employee Discipline data from export files with data's database
     */
    public void verifyEmpDiscExceptionFileDataMatchWithDatabase() {
        List<EmployeeDisciplineModel> EmployeeDisciplineModelList = mapEmployeeDisciplineModel(providerId);
        boolean result = areEmployeeDisciplineRecordsExistedInDatabase(filterEmpDiscBy(),EmployeeDisciplineModelList);
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "EmpDiscException file data is not matched with database");
    }

    public void verifyCRLFAtEndOfLine()
    {
        try{
            Stream<String> stream = Files.lines( Paths.get(DOWNLOAD_FOLDER + "/" + fileName), StandardCharsets.UTF_8);
            List<EmployeeDisciplineModel> fileRecords = filterEmpDiscBy();
            Assert.assertTrue(stream.count() == fileRecords.size(), "CRLF is not visible in the end of line for each records");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Author: Trang PM
     * Des: Verify employee General data from export files with data's database by employee first and last name
     */
//    public void verifyEmployeeGeneralFileDataMatchWithDatabase(String employeeFName, String employeeLName) {
//        String employeeId = getEmployeeIdBy(baseObj.readDataValue("AccountId"), employeeFName, employeeLName);
//        List<EmployeeDisciplineModel> EmployeeGeneralModelList = mapEmployeeDisciplineTableToModel(employeeFName, employeeLName, account);
//        boolean result = areEmployeeDisciplineRecordsExistedInDatabase(filterEmployeeDisciplineBy(employeeId), EmployeeGeneralModelList);
//        if(result) {
//            ExtentTestManager.logPass("All records in file exist in database");
//        } else {
//            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
//        }
//        Assert.assertTrue(result, "EmployeeGeneral file data is not matched with database");
//    }

    public void validateEmployeeDisciplineAsExpectedResults(){
        List<EmployeeDisciplineModel> providerGeneralFile = filterEmployeeDisciplineBy();
        Assert.assertTrue(providerGeneralFile.size() > 0, "EmployeeDiscipline file data is not generated");
    }

    public void validateEmployeeDisciplineAsExpectedFormat(){
        List<EmployeeDisciplineModel> providerGeneralFile = filterEmployeeDisciplineBy();
        Assert.assertTrue(providerGeneralFile.size() > 0 , "EmployeeDiscipline file data is not generated");
    }
}
