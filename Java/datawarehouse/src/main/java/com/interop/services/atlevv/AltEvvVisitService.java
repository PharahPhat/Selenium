package com.interop.services.atlevv;

import com.google.gson.Gson;
import com.interop.common.StateAccount;
import com.interop.common.constants.utils.db.VisitDbUtils;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.altevv.visit.AltEvvVisit;
import com.interop.models.altevv.visit.AltEvvVisitDataGenerator;
import com.interop.models.db.inbox.InboxVisitsTasks;
import com.interop.models.db.stx.STXSchedule;
import com.interop.models.db.stx.STXVisit;
import com.interop.services.base.RestfulService;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AltEvvVisitService extends RestfulService {
    public static final Logger LOGGER = Logger.getLogger(AltEvvVisitService.class);
    protected List<AltEvvVisit> models = new ArrayList<>();

    //init visit for claim
    public static AltEvvVisitService init(String callIn, String callOut, String procedureCode, String clientCustom1, String employeeCustom1, String memo) {
        LOGGER.info("CustomerID" + clientCustom1);
        LOGGER.info("EmployeeID" + employeeCustom1);
        StateAccount stateAccount = StateAccount.loadStateAccount();

        AltEvvVisit visitModel = AltEvvVisitDataGenerator.initAltEvvVisitByState(stateAccount);
        visitModel.setScheduleStartTime(callIn);
        visitModel.setScheduleEndTime(callOut);
        visitModel.setProcedureCode(procedureCode);
        visitModel.setMemo(memo);

        AltEvvVisitService visitService = new AltEvvVisitService();
        visitService.addModel(visitModel);
        visitService.loadPayload(visitService.models);
        return visitService;
    }

    public static AltEvvVisitService init(int count, String memo) {
        AltEvvVisitService altEVVGenericVisit = new AltEvvVisitService();
        StateAccount stateAccount = StateAccount.loadStateAccount();
        for (int i = 1; i <= count; i++) {
            AltEvvVisit visitModel = AltEvvVisitDataGenerator.initAltEvvVisitByState(stateAccount);
            visitModel.getCalls().get(0).setCallDateTime(commons.getDateString(-1, -2, 30,
                    15, "yyyy-MM-dd'T'HH:mm:ss'Z'"));
            visitModel.getCalls().get(1).setCallDateTime(commons.getDateString(-1, -1, 30,
                    15, "yyyy-MM-dd'T'HH:mm:ss'Z'"));
            if (memo != null) {
                visitModel.setMemo(memo);
            }
            altEVVGenericVisit.addModel(visitModel);
        }
        altEVVGenericVisit.loadPayload(altEVVGenericVisit.models);
        return altEVVGenericVisit;
    }

    @Override
    public String getURI() {
        return "interfaces/intake/visits/rest/api/v1.1";
    }

    public void addModel(AltEvvVisit model) {
        this.models.add(model);
        loadPayload(this.models);
    }

    public AltEvvVisit getModel(int index) {
        return models.get(index);
    }

    @Override
    public void loadPayload(List visit) {
        payload = new Gson().toJsonTree(visit);
    }

    @Override
    public void verifyOracleDb(DataValidationModel data) {
        if ("Yes".equalsIgnoreCase(data.getIsVerifyExistingDatabase())) {
            baseObj.info("Verify Visit created in Database");
            String account = getStateAccount().getAccountID();
            for (int i = 0; i < this.getModels().size(); i++) {
                AltEvvVisit payload = this.getModels().get(i);
                List<STXVisit> result = VisitDbUtils.getVisit(account, payload.getSequenceID());
                Assert.assertTrue(!result.isEmpty(), "The records are not found in db");
                baseObj.info(result.toString());

               /* String schKey = ScheduleDbUtils.getSCHKEYFromInboxSchedule(account, payload.getSequenceID()).get(0)
                        .getSCHKEY().toString();
                STXSchedule stxSchedule = ScheduleDbUtils.getScheduleBySCHKEY(account, schKey).get(0);
                verifyRescheduleInDb(payload, stxSchedule);
                verifyContgyPlanCode(payload, stxSchedule);*/
            }
            baseObj.info("Data is stored in database successfully");
        }
    }

    private void verifyContgyPlanCode(AltEvvVisit payload, STXSchedule recordDb) {
        baseObj.info("Verify ContyPlanCode in Db");
        commons.validateActualAndExpectedText(recordDb.getCONTGY_PLAN_CODE().toString(), payload.getContingencyPlan(), "ContingencyPlan");
    }

    private void verifyRescheduleInDb(AltEvvVisit payload, STXSchedule recordDb) {
        baseObj.info("Verify Reschedule in Db");
        commons.validateActualAndExpectedText(recordDb.getSCH_EXPLAIN().toString(), payload.getContingencyPlan(), "Reschedule");
    }

    public void validateVisitTasksInInbox(DataValidationModel dataTest) {
        if ("Yes".equalsIgnoreCase(dataTest.getIsVerifyExistingDatabase())) {
            for (int i = 0; i < this.getModels().size(); i++) {
                List<InboxVisitsTasks> visitsTasks = VisitDbUtils.getInboxTaskVisit(
                        this.getModels().get(i).getVisitOtherID(), models.get(i).getTasks().get(0).getTaskID());
                visitsTasks.forEach(x -> Assert.assertEquals(String.valueOf(x.getERROR_CODE()), dataTest.getUuidExpectedError(), "ERROR_CODE should equal = " + dataTest.getUuidExpectedError()));
            }
        }
    }

    public List<AltEvvVisit> getModels() {
        return models;
    }

    @Override
    public void setModels(List model) {
        this.models = model;
        loadPayload(this.models);
    }
}
