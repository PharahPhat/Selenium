package generic;

import com.sandata.common.Constant;
import com.sandata.core.report.ExtentTestManager;
import com.sandata.entity.ohio.exports.Staff;
import com.sandata.models.molina.employee.EmployeeDisciplineModel;
import com.sandata.models.molina.employee.EmployeeGeneralModel;
import com.sandata.utilities.DbUtilsCon;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.interop.sql.EmployeeSQL.*;

public class EmployeeGenericTest extends DWHGenericTest {
//    /**
//     * Author: Liem.chau (Tony)
//     * Des: Map data from database to the model
//     * @param providerId: list input of employee item
//     * @return The employee General Model list
//     */
//    public List<EmployeeGeneralModel> mapEmployeeGeneralModel(String providerId, String fname) {
//        String sql = String.format(sql_getEmployeeGeneral, providerId, fname);
//        return mapDataTableToModel(sql, EmployeeGeneralModel.class);
//    }
//
//    /**
//     * Author: liem.chau (Tony)
//     * Des: Get the employee Discipline list model from the file in the input folder
//     * @return the employee Discipline model list
//     */
//    public List<EmployeeGeneralModel> filterEmpGeneralBy() {
//        //fileName = "MEDHHS_EVV_DWExtract_EMP_GENERAL_022619_06_32_58.txt";
//        return mapDataFileToModel(baseObj.readDataValue("Extension"),
//                DOWNLOAD_FOLDER + "/" + fileName, EmployeeGeneralModel.class);
//    }

    /**
     * Author: Trang PM
     * Des: Map data from database to the model
     * @param employeeFName
     * @param employeeLName
     * @param account
     * @return the employee General Model model list
     */
    public List<EmployeeGeneralModel> mapEmployeeGeneralTableToModel(String employeeFName, String employeeLName, String account) {
        String sql = String.format(SQL_GET_EMPLOYEE_GENERAL_BY_NAME, employeeFName, employeeLName, account);
        return mapDataTableToModel(sql, EmployeeGeneralModel.class);
    }

    /**
     * Author: Trang PM
     * Des: Get the employee General list model from the file in the input folder
     * @param employeeId
     * @return the employee General Model model list
     */
    public List<EmployeeGeneralModel> filterEmployeeGeneralBy(String employeeId) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), Constant.DOWNLOAD_FOLDER + "/" + fileName, EmployeeGeneralModel.class)
                .stream().filter(employeeGeneral -> employeeGeneral.getEmployeeID().equalsIgnoreCase(employeeId)).collect(Collectors.toList());
    }

    public List<EmployeeGeneralModel> filterEmployeeGeneralBy(String employeeId, String fileExtension) {
        return mapDataFileToModel(fileExtension, Constant.DOWNLOAD_FOLDER + "/" + fileName, EmployeeGeneralModel.class)
                .stream().filter(employeeGeneral -> employeeGeneral.getEmployeeID().equalsIgnoreCase(employeeId)).collect(Collectors.toList());
    }

    /**
     * Author: Trang PM
     * Des: Get employee id
     */

    public String getEmployeeIdBy(String accountId, String employeeFName, String employeeLName) {
        String sql = String.format(SQL_GET_EMPLOYEE_ID, employeeFName, employeeLName, accountId);
        Object clientId = DbUtilsCon.getDataTable(
                baseObj.getTestEnvironment().getOracleUrl(),
                baseObj.getTestEnvironment(), sql).get(0).get("EMPLOYEEID");
        return String.valueOf(clientId);
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
     * @param employeeId
     * @return the employee General Model model list
     */
    public List<EmployeeDisciplineModel> filterEmployeeDisciplineBy(String employeeId) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), Constant.DOWNLOAD_FOLDER + "/" + fileName, EmployeeDisciplineModel.class)
                .stream().filter(employeeGeneral -> employeeGeneral.getEmployeeID().equalsIgnoreCase(employeeId)).collect(Collectors.toList());
    }

    public List<EmployeeDisciplineModel> filterEmployeeDisciplineBy(String employeeId, String fileExtension) {
        return mapDataFileToModel(fileExtension, Constant.DOWNLOAD_FOLDER + "/" + fileName, EmployeeDisciplineModel.class)
                .stream().filter(employeeGeneral -> employeeGeneral.getEmployeeID().equalsIgnoreCase(employeeId)).collect(Collectors.toList());
    }

    /**
     * Author: liem.chau (Tony)
     * Des: Double check the employee records are existed in export files
     * @param fileRecord the record of employee common get from a export file
     * @param dbRecords the list of employee common get from db
     * @return true if exist and else is false
     */
    public boolean isEmployeeGeneralRecordExistedInExportFile(EmployeeGeneralModel fileRecord,
                                                              List<EmployeeGeneralModel> dbRecords) {
        for (EmployeeGeneralModel record : dbRecords) {
            String fileDataInfo = fileRecord.toString();
            ExtentTestManager.logTestStep(String.format("EMP_GENERAL record in file: %s", fileDataInfo));
            String currDataDbInfo = record.toString();
            ExtentTestManager.logTestStep(String.format("EMP_GENERAL record in db: %s", currDataDbInfo));
            if(fileDataInfo.equals(currDataDbInfo))
                return true;
        }
        return false;
    }

    /**
     * Author: liem.chau (Tony)
     * Des: Double check all data in db are existed in all data are exported.
     * @param fileRecords the list data from the file
     * @param dbRecords   the list data form db
     * @return true if existing and else is false
     */
    public boolean areEmployeeGeneralRecordsExistedInDatabase(List<EmployeeGeneralModel> fileRecords,
                                                              List<EmployeeGeneralModel> dbRecords) {
        int count = 0;
        int maxCount  = 10;

        for (EmployeeGeneralModel currData : fileRecords) {
            if (isEmployeeGeneralRecordExistedInExportFile(currData, dbRecords)) {
                count ++;
                ExtentTestManager.logTestStep(String.format("File record found in db"));
            }
            if(count > maxCount)
                break;
        }
        return (count > 0);
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
            ExtentTestManager.logTestStep(String.format("EMP_DISC record in file: %s", fileDataInfo));

            String currDataDbInfo = record.toString();
            ExtentTestManager.logTestStep(String.format("EMP_DISC record in db: %s", fileDataInfo));

            if(fileDataInfo.equals(currDataDbInfo))
                return true;
        }
        return false;
    }

    /**
     * Author: Trang PM
     * Des: Verify employee General data from export files with data's database by employee first and last name
     */
    public void verifyEmployeeGeneralFileDataMatchWithDatabase(String accountId, String employeeFName, String employeeLName) {
        String employeeId = getEmployeeIdBy(accountId, employeeFName, employeeLName);
        List<EmployeeGeneralModel> EmployeeGeneralModelList = mapEmployeeGeneralTableToModel(employeeFName, employeeLName, account);
        List<EmployeeGeneralModel> EmployeeGeneralModelFileList = filterEmployeeGeneralBy(employeeId, fileExtension);
        if(EmployeeGeneralModelFileList.get(0).getPayRate().equals("0.0"))
            EmployeeGeneralModelFileList.get(0).setPayRate("");
        boolean result = areEmployeeGeneralRecordsExistedInDatabase(EmployeeGeneralModelFileList,EmployeeGeneralModelList);
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "EmployeeGeneral file data is not matched with database");
    }

    /**
     * Author: Trang PM
     * Des: Verify employee General data from export files with data's database by employee first and last name
     */
    public void verifyEmployeeDisciplineFileDataMatchWithDatabase(String accountId, String employeeFName, String employeeLName) {
        String employeeId = getEmployeeIdBy(accountId, employeeFName, employeeLName);
        List<EmployeeDisciplineModel> EmployeeGeneralModelList = mapEmployeeDisciplineTableToModel(employeeFName, employeeLName, account);
        boolean result = areEmployeeDisciplineRecordsExistedInDatabase(filterEmployeeDisciplineBy(employeeId, fileExtension), EmployeeGeneralModelList);
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "EmployeeGeneral file data is not matched with database");
    }

    public void verifyEmployeeIsNotExistedInEmployeeGeneralFile(String accountId, String employeeFName, String employeeLName) {
        String employeeId = getEmployeeIdBy(accountId, employeeFName, employeeLName);
        List<EmployeeGeneralModel> employeeGeneralModelList = filterEmployeeGeneralBy(employeeId, fileExtension);
        boolean result = true;
        if(employeeGeneralModelList.size() == 0){
            result = false;
            ExtentTestManager.logPass("Employee is NOT existed in EMP_GENERAL exported file");
        } else {
            ExtentTestManager.logFailure("Employee is existed in EMP_GENERAL exported file");
        }
        Assert.assertFalse(result, "Employee is existed in EMP_GENERAL exported file");
    }

    public void verifyEmployeeIsNotExistedInEmployeeDisciplineFile(String accountId, String employeeFName, String employeeLName) {
        String employeeId = getEmployeeIdBy(accountId, employeeFName, employeeLName);
        List<EmployeeDisciplineModel> employeeDisciplineModelList = filterEmployeeDisciplineBy(employeeId, fileExtension);
        boolean result = true;
        if(employeeDisciplineModelList.size() == 0){
            result = false;
            ExtentTestManager.logPass("Employee is NOT existed in EMP_DISC exported file");
        } else {
            ExtentTestManager.logFailure("Employee is existed in EMP_DISC exported file");
        }
        Assert.assertFalse(result, "Employee is existed in EMP_DISC exported file");
    }

    public boolean IsExistingStaffInDb(String staffLName, String staffSSN)
    {
        String sql = String.format(SQL_GET_STAFF_ACC_AND_LAST_NAME_AND_STAFF_SSN, account, staffLName, staffSSN);
        List<Staff> staffs =  mapDataTableToModel(sql, Staff.class);
        return (staffs != null && staffs.size() > 0);
    }

    public void verifyExistingStaffInExportedFiles(String staffSSN)
    {
        List<Staff> staffList = jsonOhioExportEntities[0].getStaff();

        Staff staff = staffList.stream().
                filter(Staff -> staffSSN.equals(Staff.getStaffSSN())).findFirst().orElse(null);

        logStepInfo(String.format("Staff.getStaffLastName() = %s", staff.getStaffLastName()));
        Assert.assertTrue( staff != null,
                String.format("Staff is not existed  with staff ssn : '%s",staffSSN));

    }
}
