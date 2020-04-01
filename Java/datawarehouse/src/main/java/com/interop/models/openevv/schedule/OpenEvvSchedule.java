package com.interop.models.openevv.schedule;

import com.google.gson.annotations.SerializedName;
import com.interop.models.openevv.OpenEvvBaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class OpenEvvSchedule extends OpenEvvBaseModel {

    @SerializedName("Account")
    @Builder.Default
    String account = getStateAccount().getAccountID();

    @SerializedName("ClientID")
    String clientID ;

    @SerializedName("ClientMedicaidId")
    String clientMedicaidId;

    @SerializedName("ClientIDQualifier")
    @Builder.Default
    String clientIDQualifier =getStateAccount().getClientQualifier() ;

    @SerializedName("EmployeePINQualifier")
    @Builder.Default
    String employeePINQualifier =getStateAccount().getEmployeeQualifier() ;

    @SerializedName("EmployeePIN")
    String employeePIN;

    @SerializedName("ScheduleID")
    @Builder.Default
    String scheduleID = commons.generateUniqueNumber();

    @SerializedName("ScheduleStartTime")
    @Builder.Default
    String scheduleStartTime= commons.getPastTime(10);

    @SerializedName("ScheduleEndTime")
    @Builder.Default
    String scheduleEndTime =commons.getPastTime(5);

    @SerializedName("ScheduledDuration")
    @Builder.Default
    String scheduledDuration="60";

    @SerializedName("ARNumber")
    @Builder.Default
    String aRNumber= "ARNum";

    @SerializedName("PayRate")
    @Builder.Default
    String payRate="3.43";

    @SerializedName("BillRate")
    @Builder.Default
    String billRate="3.43";

    @SerializedName("ScheduleFlag")
    @Builder.Default
    String scheduleFlag="0";

    @SerializedName("DutyFree")
    @Builder.Default
    String dutyFree="R";

    @SerializedName("Weekend")
    @Builder.Default
    String weekend="2018-12-13T04:15:00Z";

    @SerializedName("Discipline")
    @Builder.Default
    String discipline="TSDisCipline";

    @SerializedName("Service")
    @Builder.Default
    String service;

    @SerializedName("ProcedureCode")
    @Builder.Default
    String procedureCode;

    @SerializedName("ProcCodeQualifier")
    @Builder.Default
    String procCodeQualifier="HC";

    @SerializedName("BillCode")
    @Builder.Default
    String billCode= getStateAccount().getDefaultProcedureCode();

    @SerializedName("Modifier1")
    String modifier1;

    @SerializedName("Modifier2")
    String modifier2;

    @SerializedName("Modifier3")
    String modifier3;

    @SerializedName("Modifier4")
    String modifier4;

    @SerializedName("Contract")
    @Builder.Default
    String contract;

    @SerializedName("Branch")
    @Builder.Default
    String branch="BR";

    @SerializedName("VisitType")
    @Builder.Default
    String visitType="V";

    @SerializedName("LiveInCase")
    @Builder.Default
    String liveInCase="Y";

    @SerializedName("OTABHours")
    @Builder.Default
    String oTABHours="123";

    @SerializedName("OTABCode")
    @Builder.Default
    String oTABCode = "12";

    @SerializedName("OTABApprover")
    @Builder.Default
    String oTABApprover="TOA";

    @SerializedName("CaseNumber")
    @Builder.Default
    String caseNumber="CaNu01";

    @SerializedName("CaseSequence")
    @Builder.Default
    String caseSequence="CaS";

    @SerializedName("ClientTimeZone")
    @Builder.Default
    String clientTimeZone = "US/Eastern";

    @SerializedName("Status")
    @Builder.Default
    String status = "02";

    @SerializedName("PayerProgram")
    @Builder.Default
    String payerProgram;

    @SerializedName("ContingencyPlan")
    @Builder.Default
    String contingencyPlan = "CP01";

    @SerializedName("Reschedule")
    @Builder.Default
    String reschedule = "No";
}
