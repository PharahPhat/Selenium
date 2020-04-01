package generic;

import com.sandata.models.molina.visit.VisitGeneralModel;
import com.sandata.core.report.ExtentTestManager;
import com.sandata.ws.VisitWebService;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.sandata.common.Constant.DOWNLOAD_FOLDER;
import static com.interop.sql.Sql.SQL_GET_VISIT_GENERAL;

public class VisitGeneralGenericTest extends VisitGenericTest {

    public VisitWebService visitServices = new VisitWebService();

    public List<VisitGeneralModel> mapVisitGeneralTableToModel(String groupKey, String accountId,
                                                               String providerId, String startDate,
                                                               String endDate, String visitKey) {
        String sql = String.format(SQL_GET_VISIT_GENERAL, providerId, accountId, groupKey, startDate, endDate, visitKey);
        return mapDBTableToModel(sql, VisitGeneralModel.class);
    }

    public List<VisitGeneralModel> filterVisitGeneralBy(String visitKey) {
        return mapDataFileToModel(baseObj.readDataValue("Extension"), DOWNLOAD_FOLDER + "/" + fileName, VisitGeneralModel.class, true)
                .stream().filter(visitGeneral -> visitGeneral.getVisitKey().equalsIgnoreCase(visitKey)).collect(Collectors.toList());
    }

    public void verifyVisitGeneralFileDataMatchWithDatabase() {
        String visitKey = getVisitKeyByUniqueMemo(account, visitGeneralEntity.getMemo());

        String visitStartDate = commons.getDateString(-2, "yyyy-MM-dd");
        String visitEndDate = commons.getDateString(0, "yyyy-MM-dd");

        List<VisitGeneralModel> visitGeneralModelFromExFiles = filterVisitGeneralBy(visitKey);
        List<VisitGeneralModel> visitGeneralModelFromDbs =mapVisitGeneralTableToModel( groupkey, account, providerId,
                visitStartDate, visitEndDate , visitKey);

        VisitGeneralModel visitGeneralModelFromExFile = visitGeneralModelFromExFiles.get(0);
        VisitGeneralModel visitGeneralModelFromDb = visitGeneralModelFromDbs.get(0);

        boolean result = visitGeneralModelFromExFile.getPayerID().equals(visitGeneralModelFromDb.getPayerID()) &&
                visitGeneralModelFromExFile.getProviderID().equals(visitGeneralModelFromDb.getProviderID()) &&
                visitGeneralModelFromExFile.getClientID().equals(visitGeneralModelFromDb.getClientID()) &&
                visitGeneralModelFromExFile.getEmployeeID().equals(visitGeneralModelFromDb.getEmployeeID());


        if(result) {
            ExtentTestManager.logPass("All records in file exist in database");
        } else {
            ExtentTestManager.logFailure(String.format("Records in file are not matched with database"));
        }
        Assert.assertTrue(result);
    }

    public void verifyActDurationInExportedFile(String clientFName, String clientLName) {
        boolean result = true;
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));

        List<VisitGeneralModel> visitGeneralFile = filterVisitGeneralBy(visitKey);
        String callInTime = visitGeneralFile.get(0).getCallInDateTime();
        ExtentTestManager.logTestStep("callIn: " + callInTime);
        String callOutTime = visitGeneralFile.get(0).getCallOutDateTime();
        ExtentTestManager.logTestStep("callOut: " + callOutTime);
        String actualActDuration = visitGeneralFile.get(0).getActDuration();
        ExtentTestManager.logTestStep("ActDuration: " + actualActDuration);

        String expectedActDuration = getMinuteTimeDuration(callInTime, callOutTime, "yyyy-MM-dd'T'HH:mm:ssX");
        if(expectedActDuration.equals(actualActDuration)) {
            ExtentTestManager.logPass("ActDuration is calculated correctly");
        } else {
            result = false;
            ExtentTestManager.logFailure(String.format("ActDuration is calculated incorrectly"));
        }
        Assert.assertTrue(result);
    }

    public void verifyAdjDurationInExportedFile(String clientFName, String clientLName) {
        boolean result = true;
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Second_Memo"));

        List<VisitGeneralModel> visitGeneralFile = filterVisitGeneralBy(visitKey);
        String adjBeginningTime = visitGeneralFile.get(0).getAdjBeginningDateTime();
        ExtentTestManager.logTestStep("adjBeginningTime: " + adjBeginningTime);
        String adjEndTime = visitGeneralFile.get(0).getAdjEndDateTime();
        ExtentTestManager.logTestStep("adjEndTime: " + adjEndTime);
        String actualAdjDuration = visitGeneralFile.get(0).getAdjDuration();
        ExtentTestManager.logTestStep("AdjDuration: " + actualAdjDuration);

        String expectedActDuration = getMinuteTimeDuration(adjBeginningTime, adjEndTime, "yyyy-MM-dd'T'HH:mm:ssX");
        if(expectedActDuration.equals(actualAdjDuration)) {
            ExtentTestManager.logPass("AdjDuration is calculated correctly");
        } else {
            result = false;
            ExtentTestManager.logFailure(String.format("AdjDuration is calculated incorrectly"));
        }
        Assert.assertTrue(result);
    }

    public String getMinuteTimeDuration(String startTime, String endTime, String formatDate) {
        SimpleDateFormat format = new SimpleDateFormat(formatDate);
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(startTime);
            d2 = format.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long diff = d2.getTime() - d1.getTime();
        long diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diff);
        ExtentTestManager.logTestStep("Time in minutes: " + diffMinutes + " minutes.");
        return String.valueOf(diffMinutes);
    }

    public void checkVisitWithOmitStatus(String clientFName, String clientLName) {
        String visitKey = getVisitKeyBy(
                baseObj.readDataValue("AccountId"),
                clientFName,
                clientLName,
                baseObj.readDataValue("Memo"));

        List<VisitGeneralModel> visitGeneralFile = filterVisitGeneralBy(visitKey);
        String actualVisitStatus = visitGeneralFile.get(0).getVisitStatus();
        if(actualVisitStatus.equalsIgnoreCase(baseObj.readDataValue("VisitStatus"))){
            ExtentTestManager.logPass("visit status is Omit");
        }else{
            ExtentTestManager.logFailure(String.format("visit status is %s", actualVisitStatus));
        }
    }
}
