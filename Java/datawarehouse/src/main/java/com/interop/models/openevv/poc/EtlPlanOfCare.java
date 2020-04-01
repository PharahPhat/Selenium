package com.interop.models.openevv.poc;

import com.interop.models.altevv.AltBaseModel;
import com.sandata.core.annotation.CsvHeader;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EtlPlanOfCare extends AltBaseModel {
    @CsvHeader("PlanId")
    String planId;

    @CsvHeader("ProviderQualifier")
    String providerQualifier = "MedicaidID";

    @CsvHeader("ProviderId")
    String providerId;

    @CsvHeader("ClientQualifier")
    String clientQualifier = "MedicaidID";

    @CsvHeader("ClientId")
    String clientId;

    @CsvHeader("AuthorizationReferenceNumber")
    String authorizationReferenceNumber;

    @CsvHeader("StartDate")
    String startDate;

    @CsvHeader("EndDate")
    String endDate;

    @CsvHeader("PayerId")
    String payerId;

    @CsvHeader("PayerProgram")
    String payerProgram;

    @CsvHeader("Service")
    String service;

    @CsvHeader("TypeOfService")
    String typeOfService;

    @CsvHeader("ClientFirstName")
    String clientFirstName;

    @CsvHeader("ClientLastName")
    String clientLastName;

    @CsvHeader("DaysPerWeek")
    String daysPerWeek;

    @CsvHeader("TimePerDay")
    String timePerDay;

    @CsvHeader("TotalTime")

    String totalTime;

    @CsvHeader("WeekDayBits")
    String weekDayBits;

    @CsvHeader("ShiftNumber")
    String shiftNumber;

    @CsvHeader("Comments")
    String comments;

    @CsvHeader("Status")
    String status;

    @CsvHeader("SegmentName")
    String segmentName;

    // PlanOfCareTask
    @CsvHeader("TaskId")
    String taskId;

    @CsvHeader("TaskLimit")
    String taskLimit;

    @CsvHeader("TaskLimitUnits")
    String taskLimitUnits;

    @CsvHeader("TaskLimitTime")
    String taskLimitTime;

    @CsvHeader("TaskDaysPerWeek")
    String taskDaysPerWeek;

    @CsvHeader("TaskWeekDayBits")
    String taskWeekDayBits;

    @CsvHeader("TaskComments")
    String taskComments;

    @CsvHeader("TaskShiftNumber")
    String taskShiftNumber;
}
