package com.interop.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.interop.common.State;
import com.interop.common.StateAccount;
import com.interop.models.altevv.visit.AltEvvVisit;
import com.interop.models.openevv.compeletevisit.CompleteVisitModel;
import com.interop.models.openevv.completevisit.Visit;
import com.interop.services.base.RestfulService;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.interop.common.constants.FieldConstants.*;

public class CompleteVisit extends RestfulService {
    protected List<CompleteVisitModel> models = new ArrayList<>();
    private Response responseRequest;
    private CompleteVisitModel completeVisitModel;

    @Override
    public String getURI() {
        return "interfaces/completed-visits-gateway/visits/completed/rest/api/v1";
    }

    public Response getResponseRequest() {
        return this.responseRequest;
    }

    private RequestSpecification setRequestSpecFromParam(String startDate, String endDate, String exportMode) {
        return this.getRequestSpecification()
                .param("start_date_time", startDate)
                .param("end_date_time", endDate)
                .param("export_mode", exportMode);
    }

    public RequestSpecification setRequestSpecFromParam(String startDate, String endDate, String exportMode, String groupKey) {
        this.setEntityGuid(true);
        return this.setRequestSpecFromParam(startDate, endDate, exportMode)
                .param("groupkey", groupKey);
    }

    public void requestCompletedVisit(RequestSpecification requestSpecification) {
        this.baseObj.info(String.format("Calling get on api %s: ", this.getURL()));
        this.responseRequest = requestSpecification
                .when()
                .log()
                .all()
                .get(this.getURL());
        JsonObject jsonObject = new JsonParser().parse(this.responseRequest.body().prettyPrint()).getAsJsonObject();
        this.completeVisitModel = new Gson().fromJson(jsonObject, CompleteVisitModel.class);
        this.baseObj.info("Request Complete Visit Response: ");
        this.baseObj.infoInJson(this.responseRequest.asString());
    }

    public String getStatusCompletedVisit(RequestSpecification requestSpecification) {
        String sessionId = this.completeVisitModel.getSessionId();
        String url = this.getURL() + "/status";
        this.baseObj.info(String.format("Calling get status on api %s: ", url));
        this.responseRequest = requestSpecification
                .param("session_id", sessionId)
                .when()
                .log()
                .all()
                .get(url);
        JsonObject jsonObject = new JsonParser().parse(this.responseRequest.body().prettyPrint()).getAsJsonObject();
        this.completeVisitModel = new Gson().fromJson(jsonObject, CompleteVisitModel.class);
        this.baseObj.info("Check Status of Complete Visit Response: ");
        this.baseObj.infoInJson(this.responseRequest.asString());
        return this.responseRequest.asString();
    }

    public List<Visit> getResultCompletedVisit(RequestSpecification requestSpecification, String pageSize, String pageNumber) {
        String url = this.getURL() + "/page";
        this.baseObj.info(String.format("Get Result Completed Visit by calling get on api %s: ", url));
        String sessionId = this.completeVisitModel.getSessionId();
        this.responseRequest = requestSpecification
                .param("session_id", sessionId)
                .param("page_size", pageSize)
                .param("page_number", pageNumber)
                .when()
                .log()
                .all()
                .get(url);
        JsonObject jsonObject = new JsonParser().parse(this.responseRequest.body().prettyPrint()).getAsJsonObject();
        this.completeVisitModel = new Gson().fromJson(jsonObject, CompleteVisitModel.class);
        this.baseObj.info("Exported Visit Result: ");
        this.baseObj.infoInJson(this.responseRequest.asString());
        this.baseObj.validateActualAndExpectedText(this.completeVisitModel.getStatus(), SUCCESS_STATUS);

        return this.completeVisitModel.getData();
    }

    public List<Visit> getResult(String startDate, String endDate, String exportMode, String pageSize, String pageNumber) {
        this.requestCompletedVisit(this.setRequestSpecFromParam(startDate, endDate, exportMode));
        this.baseObj.sleep(10000);
        for (int i = 0; i < 3; i++) {
            String body = this.getStatusCompletedVisit(this.getRequestSpecification());
            if (body.contains(SUCCESS_STATUS)) {
                break;
            }
            this.baseObj.warning("Retry Getting Status CompleteVisit time(s) " + i + 1);
            this.baseObj.sleep(10000);
        }
        return this.getResultCompletedVisit(this.getRequestSpecification(), pageSize, pageNumber);
    }

    public List<Visit> getResult(String startDate, String endDate, String exportMode, String pageSize, String pageNumber, String groupKey) {
        this.entityGuid = true;
        this.requestCompletedVisit(this.setRequestSpecFromParam(startDate, endDate, exportMode, groupKey));
        this.baseObj.sleep(10000);
        for (int i = 0; i < 3; i++) {
            String body = this.getStatusCompletedVisit(this.getRequestSpecification());
            if (body.contains(SUCCESS_STATUS)) {
                break;
            }
            this.baseObj.warning("Retry Getting Status CompleteVisit time(s) " + i + 1);
            this.baseObj.sleep(10000);
        }
        return this.getResultCompletedVisit(this.getRequestSpecification(), pageSize, pageNumber);
    }

    public void verifyExportedVisit(boolean isTasked, AltEvvVisit visit, List<Visit> visitExported) {
        State state = StateAccount.loadStateAccount().getStateEnum();
        boolean isFound = false;
        for (Visit visitActual : visitExported) {
            if (visitActual.getVisitId().equals(visit.getVisitKey())) {
                String startTimeExpected = commons.convertDateTimeToTime(visit.getCalls().get(0).getCallDateTime(),
                        "yyyy-MM-dd'T'HH:mm:ss'Z'", "HH:mm");
                String endTimeExpected = commons.convertDateTimeToTime(visit.getCalls().get(1).getCallDateTime(),
                        "yyyy-MM-dd'T'HH:mm:ss'Z'", "HH:mm");
                validateActualAndExpectedValueOnField(visitActual.getVisitId(), visit.getVisitKey(), VISITID);
                validateActualAndExpectedValueOnField(visitActual.getStartTime(), startTimeExpected, STARTTIME);
                validateActualAndExpectedValueOnField(visitActual.getEndTime(), endTimeExpected, ENDTIME);
                // because if adding task in visit, then visit will store service = null
                if (isTasked) {
                    switch (state) {
                        case CONNECTICUT:
                        case ARIZONA:
                        case HAWAII:
                            this.validateActualAndExpectedValueOnField(visitActual.getTasks().get(0).getTaskID(), visit.getTasks().get(0).getTaskID(), TASKID);
                            this.validateActualAndExpectedValueOnField(visitActual.getTasks().get(0).getVisitId(), visit.getVisitKey(), VISITID);
                            break;
                        default:
                            break;
                    }
                } else {
                    if (state.equals(State.CONNECTICUT)) {
                        this.validateActualAndExpectedValueOnField(visitActual.getService(), visit.getProcedureCode(), PROCEDURECODE);
                    } else {
                        this.validateActualAndExpectedValueOnField(visitActual.getProcedureCode(), visit.getProcedureCode(), PROCEDURECODE);
                    }
                }
                validateActualAndExpectedValueOnField(visitActual.getPayerProgram(), visit.getPayerProgram(), PAYERPROGRAM);
                validateActualAndExpectedValueOnField(visitActual.getStartType().toLowerCase(), visit.getCalls().get(0).getCallType().toLowerCase(), STARTTYPE);
                validateActualAndExpectedValueOnField(visitActual.getEndType().toLowerCase(), visit.getCalls().get(1).getCallType().toLowerCase(), ENDTYPE);
                validateActualAndExpectedValueOnField(visitActual.getVisitLocationType(), visit.getCalls().get(0).getLocation(), VISITLOCATIONTYPE);
                baseObj.info("Export Successfully VisitKey " + visit.getVisitKey());
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            this.baseObj.fail("VisitKey " + visit.getVisitKey() + " is not exported");
        }
    }

    private void validateActualAndExpectedValueOnField(String actual, String expected, String field) {
        this.baseObj.info("Verify value of field: " + field);
        if (actual == null || expected == null) {
            Assert.assertTrue(StringUtils.equals(actual, expected), "actual text: [" + actual + "]  " +
                    "AND  expected: [" + expected + "]");
            this.baseObj.pass("Text Validation Passed.  " + "actual text: [" + actual + "]  AND  expected: ["
                    + expected + "]");
        } else {
            this.baseObj.validateActualAndExpectedText(actual, expected);
        }
    }
}
