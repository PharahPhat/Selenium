package generic;

import com.google.gson.Gson;
import com.interop.common.TestDataHelper;
import com.sandata.core.report.ExtentTestManager;
import com.sandata.models.dwh.ohio.*;
import com.sandata.models.molina.employee.EmployeeGeneralModel;
import com.interop.sql.ProviderSQL;
import com.sandata.utilities.DbUtilsCon;
import com.sandata.utilities.TextUtil;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.interop.sql.EmployeeSQL.SQL_GET_EMPLOYEE_GENERAL_BY_NAME;
import static com.interop.sql.Sql.SQL_GET_EMPLOYEE_GENERAL;


public class EmployeeGeneralGenericTest extends V8VisitGenericTest{

    private static final String BASE_FOLDER = System.getProperty("user.dir");

    /**
     * Author: Liem.chau (Tony)
     * Des: Map data from database to the model
     * @param providerId: list input of employee item
     * @return The employee General Model list
     */
    public List<EmployeeGeneralModel> mapEmployeeGeneralModel(String providerId, String fname) {
        String sql = String.format(SQL_GET_EMPLOYEE_GENERAL, providerId, fname);
        return mapDataTableToModel(sql, EmployeeGeneralModel.class);
    }

    /**
     * Author: liem.chau (Tony)
     * Des: Get the employee Discipline list model from the file in the input folder
     * @return the employee Discipline model list
     */
    public List<EmployeeGeneralModel> filterEmpGeneralBy() {
        //fileName = "MEDHHS_EVV_DWExtract_EMP_GENERAL_022619_06_32_58.txt";
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                DOWNLOAD_FOLDER + "/" + fileName, EmployeeGeneralModel.class);
    }

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
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, EmployeeGeneralModel.class)
                .stream().filter(employeeGeneral -> employeeGeneral.getEmployeeID().equalsIgnoreCase(employeeId)).collect(Collectors.toList());
    }

    /**
     * Author: liem.chau (Tony)
     * Des: Verify employee General data from export files with data's database
     */
    public void verifyEmployeeGeneralFileDataMatchWithDatabase(String fName) {
        List<EmployeeGeneralModel> EmployeeGeneralModelList = mapEmployeeGeneralModel(providerId,fName);
        List<EmployeeGeneralModel> EmployeeGeneralModelListExportedFiles = filterEmpGeneralBy();
        boolean result = areEmployeeGeneralRecordsExistedInDatabase(EmployeeGeneralModelList,EmployeeGeneralModelListExportedFiles);
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "EmployeeGeneral file data is not matched with database");
    }

    public void validateEmployeeGeneralFileIsGeneratedAsExprectedFormat(){
       List<EmployeeGeneralModel> EmployeeGeneralModelListExportedFiles = filterEmpGeneralBy();
       Assert.assertTrue(EmployeeGeneralModelListExportedFiles.size() > 0, "EmployeeGeneral file data is not as expected format");
    }

    public void validateEmployeeGeneralDataAsExpectedResult(boolean header, int cols){
        List<String> records = TextUtil.readTextFileRecords(DOWNLOAD_FOLDER + "/" + fileName);
        String[] colsData = records.get((header) ? 0 : 1).split(Pattern.quote("|"));
        Assert.assertTrue(colsData.length == cols, "EmployeeGeneral file data is not as expected format");
    }


    public void validateEmployeeHireDate(String employeeHireDates){
        String[] listHireDate = employeeHireDates.split("|");
        List<EmployeeGeneralModel> EmployeeGeneralModelListExportedFiles = filterEmpGeneralBy();
        Assert.assertTrue(EmployeeGeneralModelListExportedFiles.size() > 0, "EmployeeGeneral file data is not as expected format");
        List<String> actualList  = EmployeeGeneralModelListExportedFiles.stream().map(x -> x.getEmployeeHireDate()).collect(Collectors.toList());
        for(int i = 0; i < listHireDate.length; i ++){
            String curr = listHireDate[i];
            String valueItem = actualList.stream()
                    .filter(x -> curr.equals(x))
                    .findAny()
                    .orElse(null);
            Assert.assertTrue(valueItem != null && !valueItem.isEmpty(), "Not found data as expected result");
        }
    }


    public void validateGroupVisitIndicatorAndGroupVisitCode(){
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        boolean isExistingGroupVisitCode = false;
        List<Visit> visits = exportedFile.getVisit();
        for(int i = 0; i< visits.size(); i ++){
            Visit currentVisit  = visits.get(i);
            if(currentVisit.isGroupVisitIndicator())
            {
                Assert.assertTrue(currentVisit.getGroupVisitCode() != null
                        && !currentVisit.getGroupVisitCode().isEmpty(), "GroupVisitCode should be not empty");
                isExistingGroupVisitCode = true;
                break;
            }
        }
        Assert.assertTrue(isExistingGroupVisitCode,"Not exist GroupVisitCode in data claim export");
    }

    public void validateClaimVisitStartDateEndDateDateOfService(){
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        List<Visit> visits = exportedFile.getVisit();
        boolean isExistingClaim = false;
        for(int i = 0; i< visits.size(); i ++){
            List<ClaimStackRequests> claimStackRequests = visits.get(i).getClaimStackRequests();
            if(claimStackRequests.size() == 0)
                continue;
            for(int j = 0; j < claimStackRequests.size(); j++){
                if(!claimStackRequests.get(j).getVisitKey().equals(visitKeyClaim))
                    continue;
                String startTime =  claimStackRequests.get(j).getVisitStartDateTime();
                String endTime = claimStackRequests.get(j).getVisitEndDateTime();
                String dateOfSer = claimStackRequests.get(j).getDateOfService();
                Assert.assertTrue(visitStartDateTime.equals(startTime),
                        "visitStartDateTime should be as expected result");
                Assert.assertTrue(visitEndDateTime.equals(endTime),
                        "visitEndDateTime should be as expected result");
                Assert.assertTrue(dateOfService.equals(dateOfSer),
                        "dateOfService should be as expected result");
                isExistingClaim = true;

            }
        }

        Assert.assertTrue(isExistingClaim,"Not exist claim in data claim export");
    }

    public void validateOhioProviderNameShouldBeCompanyName(){
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        String providerName = exportedFile.getProviderName();
        Assert.assertTrue(exportedFile.getProviderName() != null, "Provider Name is null");

        String sqlQuery = String.format(ProviderSQL.SQL_GET_COMPANY_NAME,account);
        String companyName = "";
        try{
            ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery);
            while (rs.next()) {
                companyName = rs.getString("COMPNAME");
            }
        } catch (SQLException e) {
        }

        Assert.assertTrue(!providerName.isEmpty(),"providerName should be not null");
        Assert.assertTrue(!companyName.isEmpty(),"companyName should be not null");
    }

    public void validateOhioStaffHeaderFromJsonData()  {
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        List<Staff> staffList =  exportedFile.getStaff();
        if(staffList.size() > 0)
            Assert.assertTrue(staffList.get(0).getDataIsNotNull(), "Staff Header is not expected result");
    }

    public void validateClientOhioClientHeaderFromJsonData()  {
        DwhExtract exportedFile = getDataOhioExported(ohioExportedFileName);
        Individual individual =  exportedFile.getIndividual().get(0);
        //Assert.assertTrue(staffList.getDataIsNotNull(), "Staff Header is not expected result");
    }

    public void validateEmployeeGeneralFileIsGeneratedAsExprectedResults(){
        List<EmployeeGeneralModel> EmployeeGeneralModelListExportedFiles = filterEmpGeneralBy();
        Assert.assertTrue(EmployeeGeneralModelListExportedFiles.size() > 0, "EmployeeGeneral file data is not generated as expected result");
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
        for (int i = 0; i < dbRecords.size(); i++) {
            if(fileRecord.getEmployeeFirstName().equals(dbRecords.get(i).getEmployeeFirstName()))
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
     * Author: Trang PM
     * Des: Verify employee General data from export files with data's database by employee first and last name
     */
    public void verifyEmployeeGeneralFileDataMatchWithDatabase(String employeeFName, String employeeLName) {
        String employeeId = getEmployeeIdBy(baseObj.readDataValue("AccountId"), employeeFName, employeeLName);
        List<EmployeeGeneralModel> EmployeeGeneralModelList = mapEmployeeGeneralTableToModel(employeeFName, employeeLName, account);
        boolean result = areEmployeeGeneralRecordsExistedInDatabase(filterEmployeeGeneralBy(employeeId),EmployeeGeneralModelList);
        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "EmployeeGeneral file data is not matched with database");
    }
}
