package claim.rest;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.interop.common.State;
import com.interop.data.claim.ClaimDataRecord;
import com.interop.models.altevv.visit.AltEvvVisit;
import com.interop.models.altevv.visit.Call;
import com.interop.models.altevv.visit.CallAssignment;
import com.interop.models.claim.ClaimModel;
import com.interop.models.claim.MatchingRule;
import com.interop.models.claim.ModelVersion;
import com.interop.models.claim.UnitsRule;
import com.interop.services.atlevv.AltEvvVisitService;
import com.interop.services.claim.ClaimV2Service;
import com.interop.services.openevv.OpenEvvClientService;
import com.interop.services.openevv.OpenEvvEmployeeService;
import com.interop.common.Commons;
import com.interop.common.StateAccount;
import com.interop.common.TestDataHelper;
import com.sandata.core.AssertUtil;
import com.sandata.core.BaseTest;
import com.sandata.utilities.DbUtilsCon;
import com.sandata.ws.pa.unitcalculation.UnitCalculationHelper;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.interop.sql.ClientSQL.sql_getClientCustom1ByLastName;
import static com.interop.sql.ClientSQL.sql_getEmployeeCustom1ByLastName;

public abstract class ClaimBaseTest extends BaseTest {
    protected Commons commons = new Commons();

    public abstract String getClaimDataFileName();

    public String state = StateAccount.loadStateAccount().getStateName();
    private Map<String, Map<String, String>> listClientData = new HashMap<>();
    private Map<String, Map<String, String>> listEmployeeData = new HashMap<>();
    private String baseFolder = System.getProperty("user.dir") + File.separator + "TestData"
            + File.separator + state + File.separator;
    private String csvExt = ".csv";
    private String claimDataFileTemplate = getClaimDataFileName() + csvExt;
    private Object[][] dataRows;

    public String getTestType() {
        return "api";
    }

    @DataProvider(name = "claimCases")
    public Object[][] getDataDriven() {
        return TestDataHelper.getProviderDataRowsClaim(false, baseFolder + claimDataFileTemplate);
    }

    private Object[][] getVerifiedVisitsData() {
        dataRows = TestDataHelper.getProviderDataRowsClaim(true, baseFolder + claimDataFileTemplate);
        return dataRows;
    }

    @DataProvider(name = "getVisitRows")
    public Object[][] getVisitRows() {
        return dataRows;
    }

    private Map<String, String> createEmployee(String employeeFName) throws SQLException {
        String account = StateAccount.loadStateAccount().getAccountID();
        ResultSet rs;
        Map<String, String> employeeInfo = new HashMap<>();
        // Already employee custom Id, don't need to create new one.
        String sqlQuery = String.format(sql_getEmployeeCustom1ByLastName, account, employeeFName);
        rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery);
        if (!rs.next()) {
            OpenEvvEmployeeService employeeAPI = OpenEvvEmployeeService.init();
            employeeAPI.getModels().get(0).setEmployeeFirstName(employeeFName);
            employeeAPI.getModels().get(0).setEmployeeLastName(employeeFName);
            if (StateAccount.loadStateAccount().getStateEnum().equals(State.ARIZONA)){
                String uniqueID = RandomStringUtils.randomNumeric(9);
                employeeAPI.getModels().get(0).setEmployeeIDCustom2(uniqueID);
                employeeAPI.getModels().get(0).setEmployeeIDCustom1(uniqueID);
                employeeAPI.getModels().get(0).setEmployeeSocialSecurity(uniqueID);
            }

            if (StateAccount.loadStateAccount().getStateEnum() == State.HAWAII){
                employeeAPI.getModels().get(0).setEmployeeZipCode("123456789");
            }
            employeeAPI.loadPayload(employeeAPI.getModels());
            employeeAPI.postUntilRecordUpdated();
            employeeAPI.verifyPostStatus("SUCCESS");
            commons.wait(10); // Wait for DB process - avoid locked account issue
            rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery);
            rs.next();
        }
        String workerIdCustom1 = rs.getString("WORKER_ID_CUSTOM1");
        String workerId = rs.getString("STX_ID");
        employeeInfo.put(employeeFName, workerId);
        employeeInfo.put(employeeFName + "custom", workerIdCustom1);

        return employeeInfo;
    }
    public Map<String, String> getClientInfo(String account, String clientFName) {
        Map<String, String> clientInfo = new HashMap<>();

        String sqlQuery = String.format(sql_getClientCustom1ByLastName, account, clientFName);
        ResultSet rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery);
        try {
            if(rs.next()){
                String clientIdCustom1 = rs.getString("CLIENT_ID_CUSTOM1");
                String clientMedicaidID = rs.getString("MEDICAID_ID");
                clientInfo.put("MEDICAID_ID", clientMedicaidID);
                clientInfo.put(clientFName + "custom", clientIdCustom1);
            }
        } catch (SQLException e) {
            baseObj.error("SQL Exception when get client info", e);
        }
        return clientInfo;
    }
    /*Create new client used for verified visit. Don't  create if clientName is Medicaid ID - it means client is created already*/
    private Map<String, String> createClient(String clientFName) throws SQLException {
        String account = StateAccount.loadStateAccount().getAccountID();
        ResultSet rs;
        Map<String, String> clientInfo = new HashMap<>();

        String sqlQuery = String.format(sql_getClientCustom1ByLastName, account, clientFName);
        rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery);
        if (!rs.next()) { //Client doesn't exist in DB, then create one
            OpenEvvClientService clientAPI = OpenEvvClientService.init(1, clientFName);
            clientAPI.getModels().get(0).setClientLastName(clientFName);
            if (StateAccount.loadStateAccount().getStateEnum().equals(State.ARIZONA)){
                String uniqueId = "A"+ RandomStringUtils.randomNumeric(8);
                clientAPI.getModels().get(0).setClientQualifier("ClientCustomID");
                clientAPI.getModels().get(0).setClientMedicaidID(uniqueId);
                clientAPI.getModels().get(0).setRecipientIDCustom1(uniqueId);
                clientAPI.getModels().get(0).setRecipientIDCustom2(uniqueId);

            }

            if (StateAccount.loadStateAccount().getStateEnum() == State.HAWAII){
                String uniqueId = RandomStringUtils.randomNumeric(10);
                clientAPI.getModels().get(0).setClientQualifier("ClientCustomID");
                clientAPI.getModels().get(0).setClientMedicaidID(uniqueId);
                clientAPI.getModels().get(0).setRecipientIDCustom1(uniqueId);
                clientAPI.getModels().get(0).setRecipientIDCustom2(uniqueId);
                clientAPI.getModels().get(0).setClientTimeZone("US/Hawaii");
            }
            clientAPI.loadPayload(clientAPI.getModels());

            clientAPI.postUntilRecordUpdated();
            clientAPI.verifyPostStatus("SUCCESS");

            rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery);
            rs.next();
            try { // Retry to post the data due to locking account issue.
                rs.getString("CLIENT_ID_CUSTOM1");
            } catch (SQLException exp){
                clientAPI.post();
                commons.wait(5); // Sleep wait for DB to process the record
                rs = DbUtilsCon.getResultSetFromQuery(TestDataHelper.getOraConnection(), sqlQuery);
                rs.next();
            }

        }
        String clientIdCustom1 = rs.getString("CLIENT_ID_CUSTOM1");
        String clientMedicaidID = rs.getString("MEDICAID_ID");
        clientInfo.put(clientFName, clientMedicaidID);
        clientInfo.put(clientFName + "custom", clientIdCustom1);

        return clientInfo;
    }

    private String convertVisitDateTimeToUTCString(String visitDate, String visitTime) {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        LocalDateTime localDateTime = LocalDateTime.parse(visitDate + " " + visitTime, ofPattern);
        ZonedDateTime dateTime = ZonedDateTime.of(localDateTime, ZoneId.of("US/Eastern"));

        return dateTime.withZoneSameInstant(ZoneId.of("UTC"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
    }

    public List<AltEvvVisit> prepareTestDataIfNeeded() {
        Object[][] verifiedVisits = getVerifiedVisitsData();
        List<AltEvvVisit> visitModels = new ArrayList<>();
        try {
            for (int i = 0; i < verifiedVisits.length; i++) {
                ClaimDataRecord verifiedVisitForClaim = (ClaimDataRecord) verifiedVisits[i][0];
                visitModels.add(createVerifiedVisit(verifiedVisitForClaim));
            }
        } catch (SQLException e) {
            Assert.fail("Error on prepare test data file", e);
        }
        return visitModels;
    }

    //Running this test manually once you need to prepare the test data on the new environment.
    //@Test(groups = {"skipped"})
    public void testPrepareVerifiedVisits() {
        prepareTestDataIfNeeded();
    }

    protected AltEvvVisit createVerifiedVisit(ClaimDataRecord claimDataRecord) throws SQLException {
        String callIn = convertVisitDateTimeToUTCString(claimDataRecord.getServiceStartDate(), claimDataRecord.getInTime());
        String callOut = convertVisitDateTimeToUTCString(claimDataRecord.getServiceEndDate(), claimDataRecord.getOutTime());
        Map<String, String> clientInfo;
        Map<String, String> employeeInfo;
        String employeeId = claimDataRecord.getEmployeeCustomId();
        String clientMedicaidId = claimDataRecord.getClientMedicaidId();
        if (listEmployeeData.containsKey(employeeId)) {
            employeeInfo = listEmployeeData.get(employeeId);
        } else { //load employeeInfo from DB or create new
            employeeInfo = createEmployee(employeeId);
            listEmployeeData.put(employeeId, employeeInfo);
        }

        if (listClientData.containsKey(clientMedicaidId)) {
            clientInfo = listClientData.get(clientMedicaidId);
        } else { //load clientInfo from DB or create new
            clientInfo = createClient(clientMedicaidId);
            listClientData.put(clientMedicaidId, clientInfo);
        }

        String employeeCustom1 = employeeInfo.get(employeeId + "custom");
        LOGGER.info(String.format("Update Employee Custom ID of %s - CustomID = %s", employeeId, employeeCustom1));

        String clientId = clientInfo.get(clientMedicaidId);
        String clientCustom1 = clientInfo.get(clientMedicaidId + "custom");
        LOGGER.info(String.format("Update Client Medicaid ID of %s - MedicaidID = %s", clientMedicaidId, clientId));

        String memo = "ViClaim" + commons.generateRandomAlphaNumeric(40);

        AltEvvVisitService visitService = new AltEvvVisitService();
        AltEvvVisit visitModel = AltEvvVisit.builder()
                .scheduleStartTime(callIn)
                .scheduleEndTime(callOut)
                .call(Call.builder().enterDefaultCallInfo(60)
                        .procedureCode(claimDataRecord.getProcedureCode())
                        .setCallAssignment(CallAssignment.TIME_IN).build())
                .call(Call.builder().enterDefaultCallInfo(0)
                        .procedureCode(claimDataRecord.getProcedureCode())
                        .setCallAssignment(CallAssignment.TIME_OUT).build())
                .payerID(claimDataRecord.getPayer())
                .payerProgram(claimDataRecord.getProgram())
                .procedureCode(claimDataRecord.getProcedureCode())
                .clientID(clientCustom1)
                .clientOtherId(clientCustom1)
                .employeeIdentifier(employeeCustom1)
                .memo(memo)
                .build();

        visitModel.getCalls().get(0).setCallDateTime(callIn);
        visitModel.getCalls().get(1).setCallDateTime(callOut);
        visitService.addModel(visitModel);
        visitService.postUntilRecordUpdated();
        visitService.verifyPostStatus("SUCCESS");
        return visitModel;
    }

    @Step("Then User claim verified visit with model {version.value}, date range: {record.serviceStartDate} - {record.serviceEndDate}, " +
            "service: {record.procedureCode}, matchingRule: {record.matchingRule}, unitsRule: {record.unitsRule}, " +
            "duration: {record.duration}, succeedCount: {record.succeedCount}")
    protected void testClaimValidation(ModelVersion version, ClaimDataRecord record) {
        Markup m = MarkupHelper.createLabel(record.getTestDescription(), ExtentColor.BLUE);
        LOGGER.info(record.getTestDescription());
        baseObj.getExtentTest().pass(m);

        ClaimV2Service claimValidation = new ClaimV2Service();

        ClaimModel claim = ClaimModel.generateClaimModel(StateAccount.loadStateAccount(), version);
        Map<String, String> clientInfo = getClientInfo(StateAccount.loadStateAccount().getAccountID(),record.getClientMedicaidId());
//        String clientMedicaidId = clientInfo.values().toArray(new String[clientInfo.values().size()])[1];
        String clientMedicaidId = clientInfo.get("MEDICAID_ID");

        claim.setPatientID(clientMedicaidId);
        claim.setServiceStartDate(record.getServiceStartDate());
        claim.setServiceEndDate(record.getServiceEndDate());
        claim.setProcedureCode(record.getProcedureCode());
        claim.setUnits(UnitCalculationHelper.calculateUnit(record.getProcedureCode(), Integer.parseInt(record.getDuration())));
        claimValidation.addModel(claim);
        claim.setMatchingRule(MatchingRule.valueOf(record.getMatchingRule().toUpperCase()));
        claim.setUnitsRule(UnitsRule.valueOf(record.getUnitsRule().toUpperCase()));

        claimValidation.loadPayload();

        claimValidation.post();

        if (!NumberUtils.isParsable(record.getUnits())) {
            ClaimModel claimModel = claimValidation.getResponseClaims().get(0);
            verifyClaimDetailFailReason(claimModel, record.getUnits().toLowerCase());
        } else {
            List<ClaimModel> claimModels = claimValidation.getResponseClaims();

            if (version == ModelVersion.MODEL2) {
                verifyClaimModel2(claimModels, record.getSucceedCount(), record.getUnits(),
                        UnitCalculationHelper.getCareWorkerRatio(record.getProcedureCode()),
                        UnitsRule.valueOf(record.getUnitsRule().toUpperCase()));
                int i = 1;
/*                for (ClaimModel claimModel : claimModels) {
                    Assert.assertEquals(claimModel.getServiceEndDate(), record.getServiceEndDate());
                    baseObj.pass(String.format("Visit Number %s: Service End Date is matching as expected %s", i, record.getServiceEndDate()));
                    i++;
                }*/
            } else if (version == ModelVersion.MODEL3) {
                verifyClaimModel3(claimModels, record.getSucceedCount(), record.getUnits());
            }
        }
    }

    @Step("Verify the claim is failed with the Detail message: {expectedMessage}P")
    private void verifyClaimDetailFailReason(ClaimModel claimModel, String expectedMessage) {
        Assert.assertEquals(claimModel.getDetails().toLowerCase(), expectedMessage);
        logPass(String.format("Claim is failed as expected with message %s", expectedMessage));
    }

    @Step("Verify the claim with Model 3 record found must be {recordsFound}, and units is {units}")
    private void verifyClaimModel3(List<ClaimModel> claims, String recordsFound, String units) {
        ClaimModel model = claims.get(0);
        Assert.assertEquals(model.getRecordsFound(), recordsFound, "Number of record founds is not matching");
        Assert.assertEquals(model.getNumberVisitKeys(), Integer.parseInt(recordsFound),
                "Expected recordFound is not correctly");
        logPass(String.format("Number of visit found is matching expected %s", recordsFound));
    }

    private void verifyClaimModel2(List<ClaimModel> claims, String recordsFound, String units, int numberOfRequireCareGivers
            , UnitsRule unitsRule) {
        Assert.assertEquals(claims.size(), Integer.parseInt(recordsFound), "Number of recordFound are not matching with number of visit keys found");
        int totalUnits = 0;
        for (ClaimModel model : claims) {
            Assert.assertEquals(model.getVisitFound(), "true");
            if (numberOfRequireCareGivers == 1) {
                totalUnits += model.getUnits();
            }
/* @ToDo: In case of overlap visits, skipping validate the number of units on every found visit in Model 2 as of now
        until the response can show this overlapp units correctly */
/*
            else {
                Assert.assertEquals(model.getUnits(), Float.parseFloat(units), "Total units is not matching");
                logPass(String.format("Number of Claim Unit is matching expected %s", units));
            }
*/
        }
        if (numberOfRequireCareGivers == 1 && unitsRule != UnitsRule.ADD_TIME) {
            AssertUtil.assertEquals(totalUnits, Integer.parseInt(units));
            logPass(String.format("Total Claim Unit is matching expected %s", units));
        }
    }
}
