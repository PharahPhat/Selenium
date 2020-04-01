package com.sandata.models.interfaces.alt_evv_generic.visit;

import com.interop.common.State;
import com.interop.common.StateAccount;
import com.sandata.core.config.TestContext;
import com.sandata.db.ClientDbService;
import com.sandata.db.EmployeeDbService;
import com.sandata.models.GenericModel;
import com.sandata.models.generic.client.ProviderIdentification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.interop.common.State.CONNECTICUT;
import static com.interop.common.State.VERMONT;
import static com.interop.sql.ClientSQL.SQL_CLIENT_ALT_EVV_GENERIC;
import static com.interop.sql.ClientSQL.SQL_CLIENT_ALT_EVV_GENERIC_COLORADO;
import static com.interop.sql.EmployeeSQL.SQL_EMPLOYEE_ALT_EVV_GENERIC;
import static com.interop.sql.EmployeeSQL.SQL_EMPLOYEE_ALT_EVV_GENERIC_PA;

/**
 * Author: NhonT.Nguyen 10/11/2019
 */
public class AltEVVGenericVisitModel extends GenericModel {
    private com.sandata.models.generic.client.ProviderIdentification ProviderIdentification;
    private String VisitOtherID;
    private String SequenceID;
    private String EmployeeIdentifier;
    private String EmployeeQualifier;
    private String ClientID;
    private String ClientIDQualifier;
    private String VisitCancelledIndicator;
    private String PayerID;
    private String PayerProgram;
    private String ProcedureCode;
    private String VisitTimeZone;
    private String ScheduleStartTime;
    private String ScheduleEndTime;
    private String BillVisit;
    private String HoursToBill;
    private String HoursToPay;
    private String Memo;
    private String ClientVerifiedTimes;
    private String ClientVerifiedTasks;
    private String ClientVerifiedService;
    private String ClientSignatureAvailable;
    private String ClientVoiceRecording;
    private String Modifier1;
    private String Modifier2;
    private String Modifier3;
    private String Modifier4;
    // add field ClientMedicaidId from db to get data and use for test case completed visit download
    private String clientIDForVisitDownload;
    // add field EmployeeIdentifer from db to get data and use for test case completed visit download
    private String employeePINForVisitDownload;
    // add field VisitKey from db to get data and use for test case completed visit download
    private String VisitKey;
    private List<Calls> Calls = new ArrayList<>();
    private List<VisitChanges> VisitChanges = new ArrayList<>();
    private List<VisitExceptionAcknowledgement> VisitExceptionAcknowledgement = new ArrayList<>();
    private List<Tasks> Tasks = new ArrayList<>();


    public String getModifier1() {
        return Modifier1;
    }

    public void setModifier1(String modifier1) {
        if(modifier1.equals("null"))
            Modifier1 = null;
        else
        Modifier1 = modifier1;
    }

    public String getModifier2() {
        return Modifier2;
    }

    public void setModifier2(String modifier2) {
        if(modifier2.equals("null"))
            Modifier2 = null;
        else
        Modifier2 = modifier2;
    }

    public String getModifier3() {
        return Modifier3;
    }

    public void setModifier3(String modifier3) {

        if(modifier3.equals("null"))
            Modifier3 = null;
        else
        Modifier3 = modifier3;
    }

    public String getModifier4() {
        return Modifier4;
    }

    public void setModifier4(String modifier4) {

        if(modifier4.equals("null"))
            Modifier4 = null;
        else
        Modifier4 = modifier4;
    }

    public String getVisitOtherID() {
        return VisitOtherID;
    }

    public void setVisitOtherID(String visitOtherID) {
        VisitOtherID = visitOtherID;
    }

    public String getSequenceID() {
        return SequenceID;
    }

    public void setSequenceID(String sequenceID) {
        SequenceID = sequenceID;
    }

    public String getEmployeeIdentifier() {
        return EmployeeIdentifier;
    }

    public void setEmployeeIdentifier(String employeeIdentifier) {
        EmployeeIdentifier = employeeIdentifier;
    }

    public String getEmployeeQualifier() {
        return EmployeeQualifier;
    }

    public void setEmployeeQualifier(String employeeQualifier) {
        EmployeeQualifier = employeeQualifier;
    }

    public String getClientID() {
        return ClientID;
    }

    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public String getClientIDQualifier() {
        return ClientIDQualifier;
    }

    public void setClientIDQualifier(String clientIDQualifier) {
        ClientIDQualifier = clientIDQualifier;
    }

    public String getVisitCancelledIndicator() {
        return VisitCancelledIndicator;
    }

    public void setVisitCancelledIndicator(String visitCancelledIndicator) {
        VisitCancelledIndicator = visitCancelledIndicator;
    }

    public String getPayerID() {
        return PayerID;
    }

    public void setPayerID(String payerID) {
        PayerID = payerID;
    }

    public String getPayerProgram() {
        return PayerProgram;
    }

    public void setPayerProgram(String payerProgram) {
        PayerProgram = payerProgram;
    }

    public String getProcedureCode() {
        return ProcedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        ProcedureCode = procedureCode;
    }

    public String getVisitTimeZone() {
        return VisitTimeZone;
    }

    public void setVisitTimeZone(String visitTimeZone) {
        VisitTimeZone = visitTimeZone;
    }

    public String getScheduleStartTime() {
        return ScheduleStartTime;
    }

    public void setScheduleStartTime(String scheduleStartTime) {
        ScheduleStartTime = scheduleStartTime;
    }

    public String getScheduleEndTime() {
        return ScheduleEndTime;
    }

    public void setScheduleEndTime(String scheduleEndTime) {
        ScheduleEndTime = scheduleEndTime;
    }

    public String getBillVisit() {
        return BillVisit;
    }

    public void setBillVisit(String billVisit) {
        BillVisit = billVisit;
    }

    public String getHoursToBill() {
        return HoursToBill;
    }

    public void setHoursToBill(String hoursToBill) {
        HoursToBill = hoursToBill;
    }

    public String getHoursToPay() {
        return HoursToPay;
    }

    public void setHoursToPay(String hoursToPay) {
        HoursToPay = hoursToPay;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }

    public String getClientVerifiedTimes() {
        return ClientVerifiedTimes;
    }

    public void setClientVerifiedTimes(String clientVerifiedTimes) {
        ClientVerifiedTimes = clientVerifiedTimes;
    }

    public String getClientVerifiedTasks() {
        return ClientVerifiedTasks;
    }

    public void setClientVerifiedTasks(String clientVerifiedTasks) {
        ClientVerifiedTasks = clientVerifiedTasks;
    }

    public String getClientVerifiedService() {
        return ClientVerifiedService;
    }

    public void setClientVerifiedService(String clientVerifiedService) {
        ClientVerifiedService = clientVerifiedService;
    }

    public String getClientSignatureAvailable() {
        return ClientSignatureAvailable;
    }

    public void setClientSignatureAvailable(String clientSignatureAvailable) {
        ClientSignatureAvailable = clientSignatureAvailable;
    }

    public String getClientVoiceRecording() {
        return ClientVoiceRecording;
    }

    public void setClientVoiceRecording(String clientVoiceRecording) {
        ClientVoiceRecording = clientVoiceRecording;
    }

    public List<com.sandata.models.interfaces.alt_evv_generic.visit.Calls> getCalls() {
        return Calls;
    }

    public void setCalls(List<com.sandata.models.interfaces.alt_evv_generic.visit.Calls> calls) {
        Calls = calls;
    }

    public List<com.sandata.models.interfaces.alt_evv_generic.visit.VisitChanges> getVisitChanges() {
        return VisitChanges;
    }

    public void setVisitChanges(List<com.sandata.models.interfaces.alt_evv_generic.visit.VisitChanges> visitChanges) {
        VisitChanges = visitChanges;
    }

    public List<com.sandata.models.interfaces.alt_evv_generic.visit.VisitExceptionAcknowledgement> getVisitExceptionAcknowledgement() {
        return VisitExceptionAcknowledgement;
    }

    public void setVisitExceptionAcknowledgement(List<com.sandata.models.interfaces.alt_evv_generic.visit.VisitExceptionAcknowledgement> visitExceptionAcknowledgement) {
        VisitExceptionAcknowledgement = visitExceptionAcknowledgement;
    }

    public com.sandata.models.generic.client.ProviderIdentification getProviderIdentification() {
        return ProviderIdentification;
    }

    public void setProviderIdentification(com.sandata.models.generic.client.ProviderIdentification providerIdentification) {
        ProviderIdentification = providerIdentification;
    }

    public List<com.sandata.models.interfaces.alt_evv_generic.visit.Tasks> getTasks() {
        return Tasks;
    }

    public void setTasks(List<com.sandata.models.interfaces.alt_evv_generic.visit.Tasks> tasks) {
        Tasks = tasks;
    }

    private static void getRandomClientEmployee(AltEVVGenericVisitModel model, StateAccount state) {
        ClientDbService clientDbService = new ClientDbService();
        EmployeeDbService employeeDbService = new EmployeeDbService();
        Map<String, Object> client;
        Map<String, Object> employee;
        switch (state.getStateName()) {
            case "Pennsylvania":
                client = clientDbService.getRandomClient(SQL_CLIENT_ALT_EVV_GENERIC, state.getAccountID());
                employee = employeeDbService.getRandomEmployee(SQL_EMPLOYEE_ALT_EVV_GENERIC_PA, state.getAccountID());
                model.setClientID(client.get("CLIENT_ID_CUSTOM1").toString());
                model.setEmployeeIdentifier(employee.get("WORKER_ID_CUSTOM1").toString());
                model.setClientIDForVisitDownload(client.get("CLIENT_ID").toString());
                model.setEmployeePINForVisitDownload(employee.get("EMPLOYEEIDENTIFIER").toString());
                break;
            case "Colorado":
                client = clientDbService.getRandomClient(SQL_CLIENT_ALT_EVV_GENERIC_COLORADO, state.getAccountID());
                employee = employeeDbService.getRandomEmployee(SQL_EMPLOYEE_ALT_EVV_GENERIC, state.getAccountID());
                model.setClientIDQualifier("ClientOtherID");
                model.setEmployeeQualifier("EmployeeCustomID");
                model.setClientID(client.get("CLIENT_ID_CUSTOM2").toString());
                model.setEmployeeIdentifier(employee.get("WORKER_ID_CUSTOM1").toString());
                break;
            case "Connecticut":
                client = clientDbService.getRandomClient(SQL_CLIENT_ALT_EVV_GENERIC, state.getAccountID());
                employee = employeeDbService.getRandomEmployee(SQL_EMPLOYEE_ALT_EVV_GENERIC, state.getAccountID());
                model.setClientID(client.get("CLIENT_ID").toString());
                model.setEmployeeIdentifier(employee.get("EMPLOYEEIDENTIFIER").toString());
                model.setClientIDForVisitDownload(client.get("CLIENT_ID").toString());
                model.setEmployeePINForVisitDownload(employee.get("EMPLOYEEIDENTIFIER").toString());
                break;
            case "RhodeIsland":
                client = clientDbService.getRandomClient(SQL_CLIENT_ALT_EVV_GENERIC, state.getAccountID());
                employee = employeeDbService.getRandomEmployee(SQL_EMPLOYEE_ALT_EVV_GENERIC, state.getAccountID());
                model.setClientID(client.get("CLIENT_ID_CUSTOM2").toString());
                model.setEmployeeIdentifier(employee.get("EMPLOYEEIDENTIFIER").toString());
                model.setClientIDForVisitDownload(client.get("CLIENT_ID").toString());
                model.setEmployeePINForVisitDownload(employee.get("EMPLOYEEIDENTIFIER").toString());
                break;
            default:
                client = clientDbService.getRandomClient(SQL_CLIENT_ALT_EVV_GENERIC, state.getAccountID());
                employee = employeeDbService.getRandomEmployee(SQL_EMPLOYEE_ALT_EVV_GENERIC, state.getAccountID());
                model.setClientID(client.get("CLIENT_ID_CUSTOM1").toString());
                model.setEmployeeIdentifier(employee.get("WORKER_ID_CUSTOM1").toString());
                model.setClientIDForVisitDownload(client.get("CLIENT_ID").toString());
                model.setEmployeePINForVisitDownload(employee.get("EMPLOYEEIDENTIFIER").toString());
        }
    }

    public String getClientIDForVisitDownload() {
        return clientIDForVisitDownload;
    }

    public void setClientIDForVisitDownload(String clientMedicaidId) {
        clientIDForVisitDownload = clientMedicaidId;
    }

    public String getEmployeePINForVisitDownload() {
        return employeePINForVisitDownload;
    }

    public String getVisitKey() {
        return VisitKey;
    }

    public void setVisitKey(String visitKey) {
        VisitKey = visitKey;
    }

    public void setEmployeePINForVisitDownload(String employeePIN) {
        this.employeePINForVisitDownload = employeePIN;
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }

    /**
     * Create Visit Data Standard
     */
    private AltEVVGenericVisitModel initAltEVVGenericVisitData() {
        String sequenceId = commons.generateUniqueNumber();
        String visitOtherID = commons.generateRandomAlphaNumeric(50);
        String startTime = commons.getPastTime(60);
        String endTime = commons.getPastTime(40);
        AltEVVGenericVisitModel altEVVGenericVisitModel = new AltEVVGenericVisitModel();
        altEVVGenericVisitModel.setSequenceID(sequenceId);
        altEVVGenericVisitModel.setVisitOtherID(visitOtherID);
        altEVVGenericVisitModel.setScheduleStartTime(startTime);
        altEVVGenericVisitModel.setScheduleEndTime(endTime);
        altEVVGenericVisitModel.setCalls(createCallsInVisit());
        altEVVGenericVisitModel.setVisitChanges(createVisitChange(1));
        List<VisitExceptionAcknowledgement> visitExceptionAcknowledgements = new ArrayList<>();
        visitExceptionAcknowledgements.add(createVisitExceptionAcknowledgement());
        altEVVGenericVisitModel.setVisitExceptionAcknowledgement(visitExceptionAcknowledgements);

        altEVVGenericVisitModel.setVisitCancelledIndicator("false");
        altEVVGenericVisitModel.setEmployeeIdentifier("316250");
        altEVVGenericVisitModel.setEmployeeQualifier("EmployeeCustomID");
        altEVVGenericVisitModel.setClientID("15000");
        altEVVGenericVisitModel.setClientIDQualifier("ClientOtherID");
        altEVVGenericVisitModel.setVisitTimeZone("US/Eastern");
        altEVVGenericVisitModel.setBillVisit("true");
        altEVVGenericVisitModel.setHoursToBill("10");
        altEVVGenericVisitModel.setHoursToPay("10");
        altEVVGenericVisitModel.setMemo("Auto" + commons.generateRandomNumberOfFixLength(64));
        altEVVGenericVisitModel.setClientSignatureAvailable("true");
        altEVVGenericVisitModel.setClientVerifiedService("true");
        altEVVGenericVisitModel.setClientVerifiedTasks("true");
        altEVVGenericVisitModel.setClientVoiceRecording("true");
        altEVVGenericVisitModel.setClientVerifiedTimes("true");

        return altEVVGenericVisitModel;
    }

    public AltEVVGenericVisitModel initAltEVVGenericVisitData(String memo) {
        String sequenceId = commons.generateUniqueNumber();
        String visitOtherID = commons.generateRandomAlphaNumeric(50);
        String startTime = commons.getPastTime(60);
        String endTime = commons.getPastTime(40);
        AltEVVGenericVisitModel altEVVGenericVisitModel = new AltEVVGenericVisitModel();
        altEVVGenericVisitModel.setSequenceID(sequenceId);
        altEVVGenericVisitModel.setVisitOtherID(visitOtherID);
        altEVVGenericVisitModel.setScheduleStartTime(startTime);
        altEVVGenericVisitModel.setScheduleEndTime(endTime);
        altEVVGenericVisitModel.setCalls(createCallsInVisit());
        List<VisitChanges> visitChanges = createVisitChange(1, "10");
        altEVVGenericVisitModel.setVisitChanges(visitChanges);
        List<VisitExceptionAcknowledgement> visitExceptionAcknowledgements = new ArrayList<>();
        visitExceptionAcknowledgements.add(createVisitExceptionAcknowledgement());
        altEVVGenericVisitModel.setVisitExceptionAcknowledgement(visitExceptionAcknowledgements);

        altEVVGenericVisitModel.setVisitCancelledIndicator("false");
        altEVVGenericVisitModel.setEmployeeIdentifier("316250");
        altEVVGenericVisitModel.setEmployeeQualifier("EmployeeCustomID");
        altEVVGenericVisitModel.setClientID("15000");
        altEVVGenericVisitModel.setClientIDQualifier("ClientOtherID");
        altEVVGenericVisitModel.setVisitTimeZone("US/Eastern");
        altEVVGenericVisitModel.setBillVisit("false");
        altEVVGenericVisitModel.setHoursToBill("10");
        altEVVGenericVisitModel.setHoursToPay("10");
        altEVVGenericVisitModel.setMemo("This is a memo!");
        altEVVGenericVisitModel.setClientSignatureAvailable("true");
        altEVVGenericVisitModel.setClientVerifiedService("true");
        altEVVGenericVisitModel.setClientVerifiedTasks("true");
        altEVVGenericVisitModel.setClientVoiceRecording("true");
        altEVVGenericVisitModel.setClientVerifiedTimes("true");
        altEVVGenericVisitModel.setMemo(memo);

        return altEVVGenericVisitModel;
    }

    private List<Calls> createCallsInVisit(){
        List<Calls> callsList = new ArrayList<>();
        Calls callIn = new Calls();
        String callInDateTime = commons.getPastTime(60);
        callIn.setCallDateTime(callInDateTime);
        callIn.setCallExternalID(commons.generateRandomNumberOfFixLength(8));
        callIn.setCallAssignment("Time In");
        callIn.setCallType("Other");
        callIn.setClientIdentifierOnCall("98733222");
        callIn.setLocation("123");
        callIn.setMobileLogin("98733222");
        callIn.setCallLatitude("40.34455");
        callIn.setCallLongitude("-21.99383");
        callIn.setOriginatingPhoneNumber("2125551212");
        callIn.setTelephonyPIN("9989999");

        Calls callOut = new Calls();
        callOut.setCallDateTime(commons.getPastTime(0));
        callOut.setCallExternalID(commons.generateRandomNumberOfFixLength(8));
        callOut.setCallAssignment("Time Out");
        callOut.setCallType("Other");
        callOut.setClientIdentifierOnCall("98733222");
        callOut.setLocation("123");
        callOut.setMobileLogin("98733222");
        callOut.setCallLatitude("40.34455");
        callOut.setCallLongitude("-21.99383");
        callOut.setOriginatingPhoneNumber("2125551212");
        callOut.setTelephonyPIN("9989999");
        callsList.add(callIn);
        callsList.add(callOut);
        return callsList;
    }

    private List<VisitChanges> createVisitChange(int count, String reasonCode) {
        List<VisitChanges> visitChangesList = new ArrayList<>();
        for (int i=0;i<count;i++) {
            String sequenceId = commons.generateUniqueNumber();
            VisitChanges visitChange = new VisitChanges();
            visitChange.setSequenceID(sequenceId);
            visitChange.setChangeDateTime(commons.getPastTime(5));
            visitChange.setChangeMadeBy("KMSTest@test.com");
            visitChange.setChangeReasonMemo("Change Reason Memo 9223");
            visitChange.setGroupCode("94567");
            visitChange.setReasonCode(reasonCode);
            visitChange.setResolutionCode("A");
            visitChangesList.add(visitChange);
        }
        return visitChangesList;
    }

    private List<VisitChanges> createVisitChange(int count) {
        StateAccount stateAccount = StateAccount.loadStateAccount();
        List<VisitChanges> visitChangesList = new ArrayList<>();
        for (int i=0;i<count;i++) {
            String sequenceId = commons.generateUniqueNumber();
            VisitChanges visitChange = new VisitChanges();
            visitChange.setSequenceID(sequenceId);
            visitChange.setChangeDateTime(commons.getPastTime(5));
            visitChange.setChangeMadeBy("KMSTest@test.com");
            visitChange.setChangeReasonMemo("Change Reason Memo 9223");
            visitChange.setGroupCode("94567");
            if (stateAccount.getStateName().equalsIgnoreCase("Pennsylvania")) {
                visitChange.setReasonCode("10");
            }
            else {
                visitChange.setReasonCode("06");
            }
            visitChange.setResolutionCode("A");
            visitChangesList.add(visitChange);
        }
        return visitChangesList;
    }

    private List<Tasks> createVisitTasks(int count) {
        String[] taskIDs = {"2000", "0540", "0210", "0370", "0390", "0520", "0702", "0300", "0310", "0320"};
        List<Tasks> visitTasks = new ArrayList<>();
        State state = StateAccount.loadStateAccount().getStateEnum();
        for (int i=0;i<count;i++) {
            Tasks task = new Tasks();
            if (state.equals(CONNECTICUT)) {
                task.setTaskID(taskIDs[i]);
            }
            else {
                task.setTaskID("0030");
            }
            task.setTaskReading("AAA");
            task.setTaskRefused("false");
            visitTasks.add(task);
        }
        return visitTasks;
    }

    private VisitExceptionAcknowledgement createVisitExceptionAcknowledgement() {
        VisitExceptionAcknowledgement visitExceptionAcknowledgement = new VisitExceptionAcknowledgement();
        visitExceptionAcknowledgement.setExceptionAcknowledged("false");
        visitExceptionAcknowledgement.setExceptionID("01");
        return visitExceptionAcknowledgement;
    }

    /**
     * Create Visit by State
     * @param state info of state
     * @return AltEVVGenericVisitModel
     */
    public static AltEVVGenericVisitModel initVisitModelByState(StateAccount state) {
        AltEVVGenericVisitModel model = new AltEVVGenericVisitModel();
        model = model.initAltEVVGenericVisitData();
        model.setPayerID(state.getDefaultPayerID());
        model.setPayerProgram(state.getDefaultPayerProgram());
        model.setProcedureCode(state.getDefaultProcedureCode());
        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.ProviderID = state.getProviderID();
        providerIdentification.ProviderQualifier = state.getProviderQualifier();
        model.setClientIDQualifier(state.getClientQualifier());
        model.setEmployeeQualifier(state.getEmployeeQualifier());
        model.setProviderIdentification(providerIdentification);
        model.getCalls().get(0).setProcedureCode(state.getDefaultProcedureCode());
        model.getCalls().get(1).setProcedureCode(state.getDefaultProcedureCode());
        getRandomClientEmployee(model, state);

        if (state.getStateEnum().equals(State.RHODEISLAND)) {
            model.getVisitChanges().get(0).setReasonCode("1");
            model.setModifier1("U1");
            model.setModifier2("U9");
            model.setModifier3("U9");
            model.setModifier4("D");
        }
        model.setTasks(model.createVisitTasks(3));
        if (stateAccount.getStateEnum().equals(VERMONT)) {
            model.getTasks().forEach(x -> x.setTaskRefused("01"));
        }
        return model;
    }

    public static AltEVVGenericVisitModel initVisitModelByState(StateAccount state, String memo, String ProcedureCode, String ClientCustom1, String employeeCustom1) {
        AltEVVGenericVisitModel model = new AltEVVGenericVisitModel();
        model = model.initAltEVVGenericVisitData(memo);
        model.setPayerID(state.getDefaultPayerID());
        model.setPayerProgram(state.getDefaultPayerProgram());
        model.setProcedureCode(ProcedureCode);
        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.ProviderID = state.getProviderID();
        providerIdentification.ProviderQualifier = state.getProviderQualifier();
        model.setClientIDQualifier(state.getClientQualifier());
        model.setEmployeeQualifier(state.getEmployeeQualifier());
        model.setProviderIdentification(providerIdentification);
        model.getCalls().get(0).setProcedureCode(ProcedureCode);
        model.getCalls().get(1).setProcedureCode(ProcedureCode);
        getRandomClientEmployeeClaim(model, state, ClientCustom1, employeeCustom1);
        return model;
    }

    public static AltEVVGenericVisitModel initVisitModelByState(StateAccount state, String memo) {
        AltEVVGenericVisitModel model = new AltEVVGenericVisitModel();
        model = model.initAltEVVGenericVisitData(memo);
        model.setPayerID("PAODP");
        model.setPayerProgram("ODP");
        //model.setProcedureCode("W1724");
        model.setProcedureCode("W7069");
        ProviderIdentification providerIdentification = new ProviderIdentification();
        providerIdentification.ProviderID = state.getProviderID();
        providerIdentification.ProviderQualifier = state.getProviderQualifier();
        model.setClientIDQualifier(state.getClientQualifier());
        model.setEmployeeQualifier(state.getEmployeeQualifier());
        model.setProviderIdentification(providerIdentification);
        model.getCalls().get(0).setProcedureCode("W7069");
        model.getCalls().get(1).setProcedureCode("W7069");
        getRandomClientEmployeePeformanceTesting(model, state);

        return model;
    }

    @Override
    public String toString() {
        return "AltEVVGenericVisitModel{" +
                "ProviderIdentification=" + ProviderIdentification +
                ", VisitOtherID='" + VisitOtherID + '\'' +
                ", SequenceID='" + SequenceID + '\'' +
                ", EmployeeIdentifier='" + EmployeeIdentifier + '\'' +
                ", EmployeeQualifier='" + EmployeeQualifier + '\'' +
                ", ClientID='" + ClientID + '\'' +
                ", ClientIDQualifier='" + ClientIDQualifier + '\'' +
                ", VisitCancelledIndicator='" + VisitCancelledIndicator + '\'' +
                ", PayerID='" + PayerID + '\'' +
                ", PayerProgram='" + PayerProgram + '\'' +
                ", ProcedureCode='" + ProcedureCode + '\'' +
                ", VisitTimeZone='" + VisitTimeZone + '\'' +
                ", ScheduleStartTime='" + ScheduleStartTime + '\'' +
                ", ScheduleEndTime='" + ScheduleEndTime + '\'' +
                ", BillVisit='" + BillVisit + '\'' +
                ", HoursToBill='" + HoursToBill + '\'' +
                ", HoursToPay='" + HoursToPay + '\'' +
                ", Memo='" + Memo + '\'' +
                ", ClientVerifiedTimes='" + ClientVerifiedTimes + '\'' +
                ", ClientVerifiedTasks='" + ClientVerifiedTasks + '\'' +
                ", ClientVerifiedService='" + ClientVerifiedService + '\'' +
                ", ClientSignatureAvailable='" + ClientSignatureAvailable + '\'' +
                ", ClientVoiceRecording='" + ClientVoiceRecording + '\'' +
                ", Modifier1='" + Modifier1 + '\'' +
                ", Modifier2='" + Modifier2 + '\'' +
                ", Modifier3='" + Modifier3 + '\'' +
                ", Modifier4='" + Modifier4 + '\'' +
                ", clientIDForVisitDownload='" + clientIDForVisitDownload + '\'' +
                ", employeePINForVisitDownload='" + employeePINForVisitDownload + '\'' +
                ", VisitKey='" + VisitKey + '\'' +
                ", Calls=" + Calls +
                ", VisitChanges=" + VisitChanges +
                ", VisitExceptionAcknowledgement=" + VisitExceptionAcknowledgement +
                ", Tasks=" + Tasks +
                '}';
    }

    private static void getRandomClientEmployeePeformanceTesting(AltEVVGenericVisitModel model, StateAccount state) {
        ClientDbService clientDbService = new ClientDbService();

        String clientID;
        String employeeIdentifier;
        clientID = clientDbService.getRandomClientID(TestContext.get().getEnvironment().get("client_id_custom1"));
        employeeIdentifier = clientDbService.getRandomEmployeeIdentifier(TestContext.get().getEnvironment().get("worker_id_custom1"));
        model.setClientID(clientID);
        model.setEmployeeIdentifier(employeeIdentifier);
    }

    private static void getRandomClientEmployeeClaim(AltEVVGenericVisitModel model, StateAccount state, String clientCustom1, String employeeCustom1)
    {
        model.setClientID(clientCustom1);
        model.setEmployeeIdentifier(employeeCustom1);
    }
}
