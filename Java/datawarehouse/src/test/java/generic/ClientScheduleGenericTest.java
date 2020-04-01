package generic;

import com.sandata.common.Constant;
import com.sandata.models.molina.client.ClientSchedule;
import com.sandata.core.report.ExtentTestManager;
import org.testng.Assert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.interop.sql.ClientSQL.SQL_GET_CLIENT_SCHEDULE;
import static com.interop.sql.ClientSQL.SQL_GET_CLIENT_SCHEDULE_BY_ACC_AND_COLUMN_VALUE;

public class ClientScheduleGenericTest extends V8VisitGenericTest {
    public List<ClientSchedule> mapClientScheduleTableToModel(String clientFName, String clientLName, String account) {
        String sql = String.format(SQL_GET_CLIENT_SCHEDULE, account, clientFName, clientLName);
        return mapDBTableToModel(sql, ClientSchedule.class);
    }

    public List<ClientSchedule> filterClientScheduleBy(String clientId) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, ClientSchedule.class)
                .stream().filter(clientSchedule -> clientSchedule.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public List<ClientSchedule> filterClientScheduleBy(String clientId, String fileExtension) {
        return mapDataFileToModel(fileExtension, DOWNLOAD_FOLDER + "/" + fileName, ClientSchedule.class)
                .stream().filter(clientSchedule -> clientSchedule.getClientID().equalsIgnoreCase(clientId)).collect(Collectors.toList());
    }

    public String getClientId(String accountId, String clientFName, String clientLName) {
        return getClientIdBy(
                accountId,
                clientFName,
                clientLName);
    }

    public boolean isClientScheduleExistedInDb(ClientSchedule clientScheduleFile, List<ClientSchedule> clientScheduleDb) {
        for(ClientSchedule clientSchedule : clientScheduleDb) {
            String fileDataInfo = clientScheduleFile.toString();
            ExtentTestManager.logTestStep("fileDataInfo " + fileDataInfo);
            String currDataDbInfo = clientSchedule.toString();
            ExtentTestManager.logTestStep("currDataDbInfo " + currDataDbInfo);

            if(fileDataInfo.equals(currDataDbInfo))
                return true;
        }
        return false;
    }

    public boolean areClientScheduleExistedInDb(List<ClientSchedule> clientScheduleFile, List<ClientSchedule> clientScheduleDb) {
        for(ClientSchedule clientSchedule : clientScheduleFile) {
            if(!isClientScheduleExistedInDb(clientSchedule, clientScheduleDb))
                return false;
        }
        return true;
    }

    public void verifyClientScheduleFileDataMatchWithDatabase(String clientFName, String clientLName) {
        String accountId = baseObj.readDataValue("AccountId");
        String clientId = getClientId(accountId, clientFName, clientLName);
        Assert.assertNotNull(clientId, "Client Id is not displayed in exported file");

        List<ClientSchedule> exportResult = filterClientScheduleBy(clientId);

        List<ClientSchedule> dbResult = mapClientScheduleTableToModel(
                clientFName,
                clientLName,
                baseObj.readDataValue("AccountId"));

        boolean result = areClientScheduleExistedInDb(exportResult, dbResult);

        if (result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result, "Records in file are not matched with database");
    }

    public void verifyValueOfFieldExistInDb(String fieldName){
        List<ClientSchedule> fileRecords = mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, ClientSchedule.class, true);
        List<String> lstValueFromFile = new ArrayList<>();
        fileRecords.forEach(r-> {
            try {
                Field f = r.getClass().getDeclaredField(fieldName);
                f.setAccessible(true);
                String value = (String) f.get(r);
                lstValueFromFile.add(value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.getMessage();
            }
        });

        String strValue = String.join("','",lstValueFromFile);
        strValue= "'" + strValue + "'";
        String account = baseObj.getTestEnvironment().get("molina_accountId");
        String columnName = "";
        switch (fieldName){
            case "employeeID" : columnName = "stx_id";break;
            case "scheduleID" : columnName = "schkey";break;
        }
        String sql = String.format(SQL_GET_CLIENT_SCHEDULE_BY_ACC_AND_COLUMN_VALUE,account,columnName,strValue);
        List<ClientSchedule> dbRecords = mapDBTableToModel(sql, ClientSchedule.class);
        List<String> lstValueFromDB = new ArrayList<>();
        dbRecords.forEach(r-> {
            try {
                Field f = r.getClass().getDeclaredField(fieldName);
                f.setAccessible(true);
                String value = (String) f.get(r);
                lstValueFromDB.add(value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        lstValueFromFile.forEach(r-> Assert.assertTrue(lstValueFromDB.contains(r),r +"does not exist in stx.schedule"));
    }

    public void verifyClusterCaseFlagInExportedFile(String clientFName, String clientLName) {
        boolean result = true;
        String accountId = baseObj.readDataValue("AccountId");
        String clientId = getClientId(accountId, clientFName, clientLName);

        List<ClientSchedule> clientScheduleFile = filterClientScheduleBy(clientId);

        String clusterCaseFlag = clientScheduleFile.get(0).getClusterCaseFlag();

        if(clusterCaseFlag.equals("") || clusterCaseFlag.equals("true") || clusterCaseFlag.equals("false")) {
            ExtentTestManager.logPass("ClusterCaseFlag is correctly");
        } else {
            result = false;
            ExtentTestManager.logFailure(String.format("ClusterCaseFlag is incorrectly"));
        }
        Assert.assertTrue(result, String.format("ClusterCaseFlag value is 'false' or 'true', actual result is '%s'",clusterCaseFlag));
    }

    public void verifyScheduleDurationInExportedFile(String clientFName, String clientLName) {
        boolean result = true;
        String accountId = baseObj.readDataValue("AccountId");
        String clientId = getClientId(accountId, clientFName, clientLName);

        List<ClientSchedule> clientScheduleFile = filterClientScheduleBy(clientId);
        String scheduleEndTime = clientScheduleFile.get(0).getScheduleEndTime();
        ExtentTestManager.logTestStep("getScheduleEndTime: " + scheduleEndTime);
        String scheduleStartTime = clientScheduleFile.get(0).getScheduleStartTime();
        ExtentTestManager.logTestStep("getScheduleStartTime: " + scheduleStartTime);
        String scheduleDuration = clientScheduleFile.get(0).getScheduleDuration();
        ExtentTestManager.logTestStep("getScheduleDuration: " + scheduleDuration);

        String expectedScheduleDuration = commons.getMinuteTimeDuration(scheduleStartTime, scheduleEndTime, "yyyy-MM-dd'T'HH:mm:ssX");
        if(scheduleDuration.equals(expectedScheduleDuration)) {
            ExtentTestManager.logPass("ScheduleDuration is calculated correctly");
        } else {
            result = false;
            ExtentTestManager.logFailure(String.format("ScheduleDuration is calculated incorrectly"));
        }
        Assert.assertTrue(result);
    }

    public void verifyPayRateAndBillRateInExportedFile(String clientFName, String clientLName) {
        boolean result = true;
        String accountId = baseObj.readDataValue("AccountId");
        String clientId = getClientId(accountId, clientFName, clientLName);
        List<ClientSchedule> dbResult = mapClientScheduleTableToModel(
                clientFName,
                clientLName,
                baseObj.readDataValue("AccountId"));
        String expectedScheduleBillRate = dbResult.get(0).getBillRate();
        ExtentTestManager.logTestStep("expectedScheduleBillRate: " + expectedScheduleBillRate);
        String expectedSchedulePayRate = dbResult.get(0).getPayRate();
        ExtentTestManager.logTestStep("expectedSchedulePayRate: " + expectedSchedulePayRate);

        List<ClientSchedule> clientScheduleFile = filterClientScheduleBy(clientId);
        String actualScheduleBillRate = clientScheduleFile.get(0).getBillRate();
        ExtentTestManager.logTestStep("actualScheduleBillRate: " + actualScheduleBillRate);
        String actualSchedulePayRate = clientScheduleFile.get(0).getPayRate();
        ExtentTestManager.logTestStep("actualSchedulePayRate: " + actualSchedulePayRate);


        if(actualScheduleBillRate.equals(expectedScheduleBillRate)) {
            ExtentTestManager.logPass("ScheduleBillRate is exported correctly");
        } else {
            result = false;
            ExtentTestManager.logFailure(String.format("ScheduleBillRate is exported incorrectly"));
        }

        if(actualSchedulePayRate.equals(expectedSchedulePayRate)) {
            ExtentTestManager.logPass("SchedulePayRate is exported correctly");
        } else {
            result = false;
            ExtentTestManager.logFailure(String.format("SchedulePayRate is exported incorrectly"));
        }
        Assert.assertTrue(result);
    }

    public void verifyLiveInCaseInExportedFile(String clientFName, String clientLName, String expectedLiveInCase) {
        boolean result = true;
        String accountId = baseObj.readDataValue("AccountId");
        String clientId = getClientId(accountId, clientFName, clientLName);
        List<ClientSchedule> clientScheduleFile = filterClientScheduleBy(clientId);
        String actualLiveInCase = clientScheduleFile.get(clientScheduleFile.size() - 1).getLiveInCase();
        ExtentTestManager.logTestStep("actualLiveInCase: " + actualLiveInCase);

        if(actualLiveInCase.equals(expectedLiveInCase)) {
            ExtentTestManager.logPass("LiveInCase is exported correctly");
        } else {
            result = false;
            ExtentTestManager.logFailure(String.format("LiveInCase is exported incorrectly"));
        }

        Assert.assertTrue(result);
    }

    public void verifyScheduleTimeZoneInExportedFile(String clientFName, String clientLName) {
        boolean result = true;
        String accountId = baseObj.readDataValue("AccountId");
        String clientId = getClientId(accountId, clientFName, clientLName);
        List<ClientSchedule> dbResult = mapClientScheduleTableToModel(
                clientFName,
                clientLName,
                baseObj.readDataValue("AccountId"));
        String expectedScheduleTimeZone = dbResult.get(dbResult.size() - 1).getScheduleTimeZone();
        if(expectedScheduleTimeZone == null) expectedScheduleTimeZone = "";
        ExtentTestManager.logTestStep("expectedScheduleTimeZone: " + expectedScheduleTimeZone);

        List<ClientSchedule> clientScheduleFile = filterClientScheduleBy(clientId);
        String actualScheduleTimeZone = clientScheduleFile.get(0).getScheduleTimeZone();
        ExtentTestManager.logTestStep("actualScheduleTimeZone: " + actualScheduleTimeZone);

        if(actualScheduleTimeZone.equals(expectedScheduleTimeZone)) {
            ExtentTestManager.logPass("ScheduleTimeZone is exported correctly");
        } else {
            result = false;
            ExtentTestManager.logFailure(String.format("ScheduleTimeZone is exported incorrectly"));
        }

        Assert.assertTrue(result);
    }

    public boolean isClientScheduleExistedInScheduleFile(String accountId, String clientFName, String clientLName) {
        String clientId = getClientId(accountId, clientFName, clientLName);
        List<ClientSchedule> clientScheduleList = filterClientScheduleBy(clientId, fileExtension);
        ExtentTestManager.logTestStep("Client id is " + clientId);
        if(clientScheduleList.size() == 0){
            return false;
        } else return true;
    }

    public void verifyClientScheduleExistedInScheduleFile(String accountId, String clientFName, String clientLName) {
        boolean result = isClientScheduleExistedInScheduleFile(accountId, clientFName, clientLName);
        if(result){
            ExtentTestManager.logPass("Schedule is existed in CLIENT_SCHEDULE exported file");
        } else {
            ExtentTestManager.logFailure("Schedule is NOT existed in CLIENT_SCHEDULE exported file");
        }
        Assert.assertTrue(result, "Schedule is NOT existed in CLIENT_SCHEDULE exported file");
    }

    public void verifyClientScheduleNotExistedInScheduleFile(String accountId, String clientFName, String clientLName) {
        boolean result = isClientScheduleExistedInScheduleFile(accountId, clientFName, clientLName);
        if(!result){
            ExtentTestManager.logPass("Schedule is NOT existed in CLIENT_SCHEDULE exported file");
        } else {
            ExtentTestManager.logFailure("Schedule is existed in CLIENT_SCHEDULE exported file");
        }
        Assert.assertFalse(result, "Schedule is existed in CLIENT_SCHEDULE exported file");
    }

    public void validateClientScheduleAsExpectedResults(){
        List<ClientSchedule> datas = filterClientProBy();
        Assert.assertTrue(datas.size() > 0, "File data is not generated");
    }

    public void validateClientScheduleAsExpectedFormat(){
        List<ClientSchedule> datas = filterClientProBy();
        Assert.assertTrue(datas.size() > 0, "File data is incorrect format");
    }

    public List<ClientSchedule> filterClientProBy() {
        return mapDataFileToModel(baseObj.readDataValue("Extension"),
                Constant.DOWNLOAD_FOLDER + "/" + fileName, ClientSchedule.class);
    }

}
