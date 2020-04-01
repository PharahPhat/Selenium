package com.sandata.models.interfaces.open_evv_generic.schedule;

import com.interop.common.StateAccount;
import com.sandata.db.ClientDbService;
import com.sandata.models.GenericModel;

import java.util.Map;

import static com.interop.sql.ClientSQL.SQL_CLIENT_OPEN_EVV;
import static com.interop.sql.EmployeeSQL.*;

public class OpenEVV_Generic_Schedule extends GenericModel {

    public String Account= "";
    public String ClientID = "";
    public String ClientIDQualifier="";
    public String EmployeePINQualifier="";
    public String EmployeePIN="";
    public String ScheduleID="";
    public String ScheduleStartTime="";
    public String ScheduleEndTime="";
    public String ScheduledDuration="";
    public String ARNumber="";
    public String PayRate="";
    public String BillRate="";
    public String ScheduleFlag="";
    public String DutyFree="";
    public String Weekend="";
    public String Discipline;
    public String PayerProgram;
    public String Service;
    public String ProcedureCode;
    public String ProcCodeQualifier;
    public String BillCode;
    public String Modifier1;
    public String Modifier2;
    public String Modifier3;
    public String Modifier4;
    public String Contract;
    public String Branch;
    public String VisitType;
    public String LiveInCase;
    public String OTABHours;
    public String OTABCode;
    public String OTABApprover;
    public String CaseNumber;
    public String CaseSequence;
    public String ClientTimeZone;
    public String Status;
    public String ClientMedicaidId;

    public void setPayerProgram(String payerProgram) {
        PayerProgram = payerProgram;
    }

    public String getClientMedicaidId() {
        return ClientMedicaidId;
    }

    public void setClientMedicaidId(String clientMedicaidId) {
        ClientMedicaidId = clientMedicaidId;
    }

    public String getAccount() {
        return Account;
    }
    public void setAccount(String account) {
        Account = account;
    }

    public String getClientID() {
        return ClientID;
    }
    public void setClientID(String clientID) {
        ClientID = clientID;
    }

    public void setClientIDQualifier (String clientIDQualifier){this.ClientIDQualifier = clientIDQualifier;}
    public String getClientIDQualifier(){return ClientIDQualifier;}

    public void setEmployeeQualifier(String employeeQualifier){this.EmployeePINQualifier = employeeQualifier;}
    public String getEmployeeQualifier(){return EmployeePINQualifier;}

    public String getEmployeePIN() {
        return EmployeePIN;
    }
    public void setEmployeePIN(String employeePIN) {
        this.EmployeePIN = employeePIN;
    }

    public String getScheduleID() {
        return ScheduleID;
    }
    public void setScheduleID(String scheduleID) {
        this.EmployeePIN = scheduleID;
    }

    public void setScheduleStartTime(String scheduleStartTime){this.ScheduleStartTime = scheduleStartTime;}
    public String getScheduleStartTime(){return ScheduleStartTime;}

    public void setScheduleEndTime(String scheduleEndTime){this.ScheduleEndTime = scheduleEndTime;}
    public String getScheduleEndTime(){return ScheduleEndTime;}

    public void setScheduledDuration(String scheduledDuration){this.ScheduledDuration = scheduledDuration;}
    public String getScheduledDuration(){return ScheduledDuration;}

    public void setARNumber(String aRNumber){this.ARNumber = aRNumber;}
    public String getARNumber(){return ARNumber;}

    public String getPayRate() {
        return PayRate;
    }
    public void setPayRate(String payRate) {
        PayRate = payRate;
    }

    public String getBillRate() {
        return BillRate;
    }
    public void setBillRate(String billRate) {
        this.BillRate = billRate;
    }

    public String getScheduleFlag() {
        return ScheduleFlag;
    }
    public void setScheduleFlag(String scheduleFlag) {
        this.ScheduleFlag = scheduleFlag;
    }

    public String getDutyFree() {
        return DutyFree;
    }
    public void setDutyFree(String dutyFree) {
        this.DutyFree = dutyFree;
    }

    public String getWeekend() {
        return Weekend;
    }
    public void setWeekend(String weekend) {
        this.Weekend = weekend;
    }


    public String getDiscipline() {
        return Discipline;
    }
    public void setDiscipline(String discipline) {
        this.Discipline = discipline;
    }

    public String getService() {
        return Service;
    }
    public void setService(String service) {
        this.Service = service;
    }

    public String getProcedureCode() {
        return ProcedureCode;
    }
    public void setProcedureCode(String procedureCode) {
        this.ProcedureCode = procedureCode;
    }

    public String getProcCodeQualifier() {
        return ProcCodeQualifier;
    }
    public void setProcCodeQualifier(String procCodeQualifier) {
        this.ProcCodeQualifier = procCodeQualifier;
    }

    public String getBillCode() {
        return BillCode;
    }
    public void setBillCode(String billCode) {
        this.BillCode = billCode;
    }

    public String getModifier1() {
        return Modifier1;
    }
    public void setModifier1(String modifier1) {
        this.Modifier1 = modifier1;
    }


    public String getModifier2() {
        return Modifier2;
    }
    public void setModifier2(String modifier2) {
        this.Modifier2 = modifier2;
    }


    public String getModifier3() {
        return Modifier3;
    }
    public void setModifier3(String modifier3) {
        this.Modifier3 = modifier3;
    }


    public String getModifier4() {
        return Modifier4;
    }
    public void setModifier4(String modifier4) {
        this.Modifier4 = modifier4;
    }


    public String getContract() {
        return Contract;
    }
    public void setContract(String contract) {
        this.Contract = contract;
    }

    public String getBranch() {
        return Branch;
    }
    public void setBranch(String branch) {
        this.Branch = branch;
    }


    public String getVisitType() {
        return VisitType;
    }
    public void setVisitType(String visitType) {
        this.VisitType = visitType;
    }


    public String getLiveInCase() {
        return LiveInCase;
    }
    public void setLiveInCase(String liveInCase) {
        this.LiveInCase = liveInCase;
    }


    public String getOTABHours() {
        return OTABHours;
    }
    public void setOTABHours(String oTABHours) {
        this.OTABHours = oTABHours;
    }


    public String getOTABCode() {
        return OTABCode;
    }
    public void setOTABCode(String OTABCode) {
        this.OTABCode = OTABCode;
    }

    public String getOTABApprover() {
        return OTABApprover;
    }
    public void setOTABApprover(String OTABApprover) {
        this.OTABApprover = OTABApprover;
    }

    public String getCaseNumber() {
        return CaseNumber;
    }
    public void setCaseNumber(String CaseNumber) {
        this.CaseNumber = CaseNumber;
    }


    public String getCaseSequence() {
        return CaseSequence;
    }
    public void setCaseSequence(String CaseSequence) {
        this.CaseSequence = CaseSequence;
    }

    public String getClientTimeZone() {
        return ClientTimeZone;
    }
    public void setClientTimeZone(String ClientTimeZone) {
        this.ClientTimeZone = ClientTimeZone;
    }

    public String getStatus() {
        return Status;
    }
    public void setStatus(String Status) {
        this.Status = Status;
    }


    public static OpenEVV_Generic_Schedule initModelByState(StateAccount state){
        OpenEVV_Generic_Schedule model = new OpenEVV_Generic_Schedule();
        model = model.initOpenEVVScheduleData();

        model.setAccount(state.getAccountID());
        model.setClientIDQualifier(state.getClientQualifier());
        model.setEmployeeQualifier(state.getEmployeeQualifier());
        getRandomClientEmployee(model, state);
        return model;
    }

    public static OpenEVV_Generic_Schedule initModelByState(StateAccount state,
                                                            String employeePin, String medicaId,
                                                            String clientCustom1){
        OpenEVV_Generic_Schedule model = new OpenEVV_Generic_Schedule();
        model = model.initOpenEVVScheduleDataEx();
        model.setAccount(state.getAccountID());
        model.setClientIDQualifier(state.getClientQualifier());
        model.setClientID(clientCustom1);
        model.setEmployeePIN(employeePin);
        model.setClientMedicaidId(medicaId);
        return model;
    }

    public OpenEVV_Generic_Schedule initOpenEVVScheduleDataEx() {
        super.initData();
        OpenEVV_Generic_Schedule openEVV_generic_schedule = new OpenEVV_Generic_Schedule();
        openEVV_generic_schedule.Account = "1111";
        openEVV_generic_schedule.EmployeePIN= "1111111";
        openEVV_generic_schedule.ARNumber= "ARNum";
        openEVV_generic_schedule.BillCode="W1793";
        openEVV_generic_schedule.BillRate="3.43";
        openEVV_generic_schedule.Branch="BR";
        openEVV_generic_schedule.CaseNumber="CaNu01";
        openEVV_generic_schedule.ClientID="";
        openEVV_generic_schedule.CaseSequence="CaS";
        openEVV_generic_schedule.ClientIDQualifier="ClientID";
        openEVV_generic_schedule.ClientTimeZone="US/Eastern";
        openEVV_generic_schedule.Contract="PAODP";
        openEVV_generic_schedule.Discipline="TSDisCipline";
        openEVV_generic_schedule.PayerProgram = "OLTL";

        openEVV_generic_schedule.DutyFree="R";
        openEVV_generic_schedule.EmployeePINQualifier="EmployeeRegID";
        openEVV_generic_schedule.LiveInCase="Y";
        openEVV_generic_schedule.Modifier1=null;
        openEVV_generic_schedule.Modifier2=null;
        openEVV_generic_schedule.Modifier3=null;
        openEVV_generic_schedule.Modifier4=null;
        openEVV_generic_schedule.OTABApprover="TOA";
        openEVV_generic_schedule.OTABHours="123";
        openEVV_generic_schedule.PayRate="3.43";
        openEVV_generic_schedule.ProcCodeQualifier="HC";
        openEVV_generic_schedule.ProcedureCode="W1793";
        openEVV_generic_schedule.ScheduledDuration="60";
        openEVV_generic_schedule.ScheduleEndTime=commons.getPastTime(5);
        openEVV_generic_schedule.ScheduleFlag="0";
        openEVV_generic_schedule.ScheduleStartTime=commons.getPastTime(10);
        openEVV_generic_schedule.Service="W1793";
        openEVV_generic_schedule.Status="01";
        openEVV_generic_schedule.VisitType="V";
        openEVV_generic_schedule.Weekend="2018-12-13T04:15:00Z";
        openEVV_generic_schedule.ScheduleID=commons.generateUniqueNumberEx();
        openEVV_generic_schedule.OTABCode="OC";

        return openEVV_generic_schedule;
    }

    public OpenEVV_Generic_Schedule initOpenEVVScheduleData() {
        super.initData();
        OpenEVV_Generic_Schedule openEVV_generic_schedule = new OpenEVV_Generic_Schedule();
        openEVV_generic_schedule.Account = "1111";
        openEVV_generic_schedule.EmployeePIN= "1111111";
        openEVV_generic_schedule.ARNumber= "ARNum";
        openEVV_generic_schedule.BillCode="W1793";
        openEVV_generic_schedule.BillRate="3.43";
        openEVV_generic_schedule.Branch="BR";
        openEVV_generic_schedule.CaseNumber="CaNu01";
        openEVV_generic_schedule.ClientID="";
        openEVV_generic_schedule.CaseSequence="CaS";
        openEVV_generic_schedule.ClientIDQualifier="ClientID";
        openEVV_generic_schedule.ClientTimeZone="US/Eastern";
        openEVV_generic_schedule.Contract="PAODP";
        openEVV_generic_schedule.Discipline="TSDisCipline";
        openEVV_generic_schedule.PayerProgram = "OLTL";

        openEVV_generic_schedule.DutyFree="R";
        openEVV_generic_schedule.EmployeePINQualifier="EmployeeRegID";
        openEVV_generic_schedule.LiveInCase="Y";
        openEVV_generic_schedule.Modifier1=null;
        openEVV_generic_schedule.Modifier2=null;
        openEVV_generic_schedule.Modifier3=null;
        openEVV_generic_schedule.Modifier4=null;
        openEVV_generic_schedule.OTABApprover="TOA";
        openEVV_generic_schedule.OTABHours="123";
        openEVV_generic_schedule.PayRate="3.43";
        openEVV_generic_schedule.ProcCodeQualifier="HC";
        openEVV_generic_schedule.ProcedureCode="W1793";
        openEVV_generic_schedule.ScheduledDuration="60";
        openEVV_generic_schedule.ScheduleEndTime=commons.getPastTime(5);
        openEVV_generic_schedule.ScheduleFlag="0";
        openEVV_generic_schedule.ScheduleStartTime=commons.getPastTime(10);
        openEVV_generic_schedule.Service="W1793";
        openEVV_generic_schedule.Status="01";
        openEVV_generic_schedule.VisitType="V";
        openEVV_generic_schedule.Weekend="2019-10-13T04:15:00Z";
        openEVV_generic_schedule.ScheduleID=commons.generateUniqueNumberEx();
        openEVV_generic_schedule.OTABCode="OC";

        return openEVV_generic_schedule;
    }

    private static void getRandomClientEmployee(OpenEVV_Generic_Schedule model, StateAccount state) {
        ClientDbService clientDbService = new ClientDbService();
        Map<String, Object> client;
        Map<String, Object> employee;

        switch (state.getStateName()) {
            case "Vermont":
                client = clientDbService.getRandomClient(SQL_CLIENT_OPEN_EVV, state.getAccountID());
                employee = clientDbService.getRandomClient(SQL_EMPLOYEE_ALT_EVV_VERMONT, state.getAccountID());
                model.setClientID(client.get("CLIENT_ID_CUSTOM1").toString());
                model.setEmployeePIN(employee.get("WORKER_ID_CUSTOM1").toString());
                model.setClientMedicaidId(client.get("MEDICAID_ID").toString());
                break;
            case "PA":
                client = clientDbService.getRandomClient(SQL_CLIENT_OPEN_EVV, state.getAccountID());
                employee = clientDbService.getRandomClient(SQL_EMPLOYEE_ALT_EVV_GENERIC_PA, state.getAccountID());
                model.setClientID(client.get("CLIENT_ID_CUSTOM1").toString());
                model.setEmployeePIN(employee.get("EMPLOYEEIDENTIFIER").toString());
                model.setClientMedicaidId(client.get("MEDICAID_ID").toString());
                break;
            case "Pennsylvania":
                client = clientDbService.getRandomClient(SQL_CLIENT_OPEN_EVV, state.getAccountID());
                employee = clientDbService.getRandomClient(SQL_EMPLOYEE_ALT_EVV_GENERIC_PA, state.getAccountID());
                model.setClientID(client.get("CLIENT_ID_CUSTOM1").toString());
                model.setEmployeePIN(employee.get("WORKER_ID_CUSTOM1").toString());
                model.setClientMedicaidId(client.get("MEDICAID_ID").toString());
                break;
            default:
                client = clientDbService.getRandomClient(SQL_CLIENT_OPEN_EVV, state.getAccountID());
                employee = clientDbService.getRandomClient(SQL_EMPLOYEE_ALT_EVV_GENERIC, state.getAccountID());
                model.setClientID(client.get("CLIENT_ID").toString());
                model.setEmployeePIN(employee.get("EMPLOYEEIDENTIFIER").toString());
                model.setClientMedicaidId(client.get("MEDICAID_ID").toString());
                break;
        }
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        return false;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        return false;
    }
}
