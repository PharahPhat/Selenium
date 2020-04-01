package com.interop.models.altevv.visit;

import com.interop.common.StateAccount;
import com.interop.models.ProviderIdentification;
import com.sandata.db.ClientDbService;
import com.sandata.db.EmployeeDbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.interop.common.constants.FieldConstants.*;

public class AltEvvVisitDataGenerator {
    StateAccount account;
    ClientDbService clientDbService;
    EmployeeDbService employeeDbService;

    public AltEvvVisitDataGenerator(StateAccount account) {
        this.account = account;
        clientDbService = new ClientDbService(account);
        employeeDbService = new EmployeeDbService(account);
    }

    public static AltEvvVisit initAltEvvVisitByState(StateAccount currentAccount) {
        AltEvvVisitDataGenerator visitDataGenerator = new AltEvvVisitDataGenerator(currentAccount);
        AltEvvVisit altEvvVisit = AltEvvVisit.builder()
                .providerIdentification(ProviderIdentification.builder().withState(currentAccount).build())
                .call(Call.builder().enterDefaultCallInfo(60).setCallAssignment(CallAssignment.TIME_IN).build())
                .call(Call.builder().enterDefaultCallInfo(0).setCallAssignment(CallAssignment.TIME_OUT).build())
                .clientID(visitDataGenerator.assignRandomClient())
                .employeeIdentifier(visitDataGenerator.assignRandomEmployee())
                .build();
        //Having issue in here when creating visit with task- procedure code will not be stored on the OpenEvv account
        List<Tasks> tasks = visitDataGenerator.createTasks(1);
        altEvvVisit.setContingencyPlan(visitDataGenerator.addContingencyPlan());
        altEvvVisit.setVisitChanges(visitDataGenerator.createVisitChanges(1));
        altEvvVisit.setVisitExceptionAcknowledgement(visitDataGenerator.createVisitException(1));
        altEvvVisit.setReschedule(visitDataGenerator.addReschedule());
        altEvvVisit.setScheduleStartTime(altEvvVisit.getCalls().get(0).getCallDateTime());
        altEvvVisit.setScheduleEndTime(altEvvVisit.getCalls().get(1).getCallDateTime());
        altEvvVisit.setClientOtherId(altEvvVisit.getClientID());

        switch (currentAccount.getStateEnum()) {
            case ARIZONA:
            case HAWAII:
            case WISCONSIN:
                altEvvVisit.setTasks(tasks);
                break;
            case COLORADO:
                altEvvVisit.setVisitTimeZone("US/Mountain");
                break;
            default:
                break;
        }

        return altEvvVisit;
    }

    public String getClientDBHeaderName() {
        switch (account.getStateEnum()) {
            case RHODEISLAND:
            case COLORADO:
                return CLIENT_CUSTOM_ID2;
            case CONNECTICUT:
                return CLIENT_ID;
            case PENNSYLVANIA:
            default:
                return CLIENT_CUSTOM_ID1;
        }
    }

    public String getEmployeeDBHeaderName() {
        switch (account.getStateEnum()) {
            case CONNECTICUT:
            case RHODEISLAND:
                return EMPLOYEEIDENTIFIER;
            case ARIZONA:
            case HAWAII:
                return WORKER_SSN;
            default:
                return WORKER_CUSTOM_ID1;
        }
    }

    public String assignRandomClient() {
        return clientDbService.getRandomClient().get(getClientDBHeaderName()).toString();
    }

    public String assignRandomEmployee() {
        return employeeDbService.getRandomEmployee().get(getEmployeeDBHeaderName()).toString();
    }

    private List<Tasks> createTasks(int count) {
        List<Tasks> listTasks = new ArrayList<>();
        String[] taskIDs;
        String[] taskReadings;
        for (int i = 0; i < count; i++) {
            Tasks tasks = Tasks.builder().build();
            switch (account.getStateEnum()) {
                case CONNECTICUT:
                    if (System.getProperty("environment").equalsIgnoreCase("QA")) {
                        taskIDs = new String[]{"0460", "0540", "0210", "0350", "0370"};
                    } else {
                        taskIDs = new String[]{"2000", "0540", "0210", "0350", "0370"};
                    }
                    tasks.taskID = taskIDs[i];
                    break;
                case RHODEISLAND:
                    taskIDs = new String[]{"10", "11", "12", "13", "14"};
                    tasks.taskID = taskIDs[new Random().nextInt(taskIDs.length)];
                    tasks.taskRefused = "01";
                    break;
                case HAWAII:
                    taskIDs = new String[]{"0200"};
                    tasks.taskID = taskIDs[new Random().nextInt(taskIDs.length)];
                    break;
                case ARIZONA:
                    taskIDs = new String[]{"0110", "0150"};
                    taskReadings = new String[]{"12.99", null};
                    int index = new Random().nextInt(taskIDs.length);
                    tasks.taskID = taskIDs[index];
                    tasks.taskReading = taskReadings[index];
                    break;
                case WISCONSIN:
                    taskIDs = new String[]{"0115", "0130", "0120", "0125", "0135", "0310"};
                    tasks.taskID = taskIDs[new Random().nextInt(taskIDs.length)];
                    break;
                default:
                    return listTasks;
            }
            listTasks.add(tasks);
        }
        return listTasks;
    }

    private String addContingencyPlan() {
        String[] value;
        switch (account.getStateEnum()) {
            case HAWAII:
            case ARIZONA:
                value = new String[]{"CP01", "CP02", "CP03", "CP04", "CP05"};
                return value[new Random().nextInt(value.length)];
            default:
                return null;
        }
    }

    private String addReschedule(){
        switch (account.getStateEnum()){
            case ARIZONA:
            case HAWAII:
                return "No";
            default:
                return null;
        }
    }

    private List<VisitChange> createVisitChanges(int count) {
        List<VisitChange> changeList = new ArrayList<>();
        VisitChange visitChange = VisitChange.builder().build();
        String[] reasonCodes;
        String[] resolutionCodes;
        for (int i = 0; i < count; i++) {
            switch (StateAccount.loadStateAccount().getStateEnum()) {
                case VERMONT:
                    reasonCodes = new String[]{"01", "02", "03", "04", "05", "06", "99"};
                    visitChange.setReasonCode(reasonCodes[new Random().nextInt(reasonCodes.length)]);
                    break;
                case HAWAII:
                case ARIZONA:
                    resolutionCodes = new String[]{"1", "2", "3", "4", "5", "6"};
                    visitChange.setResolutionCode(resolutionCodes[new Random().nextInt(resolutionCodes.length)]);
                    break;
                case COLORADO:
                    reasonCodes = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                            "13", "14", "15", "16"};
                    visitChange.setReasonCode(reasonCodes[new Random().nextInt(reasonCodes.length)]);
                    break;
                case WISCONSIN:
                    reasonCodes = new String[]{"1", "2", "3", "4", "5", "7", "8"};
                    visitChange.setReasonCode(reasonCodes[new Random().nextInt(reasonCodes.length)]);
                    resolutionCodes = new String[]{"1"};
                    visitChange.setResolutionCode(resolutionCodes[0]);
                    break;
                default:
                    break;
            }
            changeList.add(visitChange);
        }
        return changeList;
    }

    private List<VisitException> createVisitException(int count) {
        List<VisitException> exceptionList = new ArrayList<>();
        VisitException visitException = VisitException.builder().build();
        String[] visitExceptionCodes;
        for (int i = 0; i < count; i++) {
            switch (StateAccount.loadStateAccount().getStateEnum()) {
                case HAWAII:
                case ARIZONA:
                    visitExceptionCodes = new String[]{"0", "1", "34", "23", "3"};
                    visitException.setExceptionID(visitExceptionCodes[new Random().nextInt(visitExceptionCodes.length)]);
                    break;
                case COLORADO:
                    visitExceptionCodes = new String[]{"0", "1", "23", "2", "15", "3", "21", "41", "4"};
                    visitException.setExceptionID(visitExceptionCodes[new Random().nextInt(visitExceptionCodes.length)]);
                    break;
                case WISCONSIN:
                    visitExceptionCodes = new String[]{"0", "1", "34", "23", "3", "4", "15", "39", "40", "28"};
                    visitException.setExceptionID(visitExceptionCodes[new Random().nextInt(visitExceptionCodes.length)]);
                    break;
                default:
                    break;
            }
            exceptionList.add(visitException);
        }
        return exceptionList;
    }
}
