package com.interop.services.openevv;

import com.google.gson.Gson;
import com.interop.common.constants.utils.db.ScheduleDbUtils;
import com.interop.common.dataprovider.DataValidationModel;
import com.interop.models.db.stx.STXSchedule;
import com.interop.models.openevv.schedule.OpenEVVScheduleDataGenerator;
import com.interop.models.openevv.schedule.OpenEvvSchedule;
import com.interop.services.base.RestfulService;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
public class OpenEvvScheduleService extends RestfulService {
    private List<OpenEvvSchedule> models = new ArrayList<>();

    public static OpenEvvScheduleService init() {
        OpenEvvScheduleService openEvvSchedule = new OpenEvvScheduleService();
        OpenEvvSchedule schedule = OpenEVVScheduleDataGenerator.initSchedule(openEvvSchedule.getStateAccount());
        openEvvSchedule.addModel(schedule);
        return openEvvSchedule;
    }

    public static OpenEvvScheduleService init(int count) {
        OpenEvvScheduleService openEvvSchedule = new OpenEvvScheduleService();
        return init(count, openEvvSchedule);
    }

    private static OpenEvvScheduleService init(int count, OpenEvvScheduleService openEvvSchedule) {
        for (int i = 0; i < count; i++) {
            OpenEvvSchedule client = OpenEVVScheduleDataGenerator.initSchedule(openEvvSchedule.getStateAccount());
            openEvvSchedule.addModel(client);
        }
        openEvvSchedule.loadPayload(openEvvSchedule.getModels());
        return openEvvSchedule;
    }

    public static OpenEvvScheduleService init(int count, String acc, String user, String pass, String employeePIN,
                                              String medicateID, String clientCustom1) {
        OpenEvvScheduleService openEvvSchedule = new OpenEvvScheduleService();
        if (acc != null && user != null && pass != null && employeePIN != null) {
            openEvvSchedule.getStateAccount().setAccountID(acc);
            openEvvSchedule.getStateAccount().setWsUserName(user);
            openEvvSchedule.getStateAccount().setWsPassword(pass);
        }
        for (int i = 0; i < count; i++) {
            OpenEvvSchedule schedule = OpenEvvSchedule.builder()
                    .clientMedicaidId(medicateID)
                    .employeePIN(employeePIN)
                    .clientID(clientCustom1)
                    .account(acc)
                    .build();
            openEvvSchedule.addModel(schedule);
        }
        openEvvSchedule.loadPayload(openEvvSchedule.getModels());
        return openEvvSchedule;
    }

    @Override
    public String getURI() {
        return "interfaces/intake/schedules/rest/api/v1/evv";
    }

    @Override
    public void setModels(List model) {
        this.models = model;
        loadPayload(this.getModels());
    }

    private void addModel(OpenEvvSchedule model) {
        this.getModels().add(model);
        loadPayload(this.getModels());
    }

    @Override
    public void loadPayload(List client) {
        payload = new Gson().toJsonTree(client);
    }

    @Override
    public void verifyOracleDb(DataValidationModel dataTest) {
        if ("yes".equalsIgnoreCase(dataTest.getIsVerifyExistingDatabase())) {
            baseObj.info("Verify data storing in database");
            for (int i = 0; i < this.getModels().size(); i++) {
                OpenEvvSchedule modelSchedule = this.getModels().get(i);
                List<STXSchedule> stxSchedule = ScheduleDbUtils.getSchedule(getStateAccount().getAccountID(), modelSchedule.getScheduleID());
                baseObj.info(stxSchedule.toString());
                Assert.assertFalse(stxSchedule.isEmpty());
                baseObj.info("Verify Reschedule field");
                commons.validateActualAndExpectedText(stxSchedule.get(i).getSCH_EXPLAIN().toString(), modelSchedule.getReschedule(), "Reschedule");
                baseObj.info("Verify ContingencyPlan field");
                commons.validateActualAndExpectedText(stxSchedule.get(i).getCONTGY_PLAN_CODE().toString(), modelSchedule.getContingencyPlan(), "ContingencyPlan");
            }
            baseObj.info("Data is stored in database successfully");
        }
    }

    public List<OpenEvvSchedule> getModels() {
        return models;
    }
}
