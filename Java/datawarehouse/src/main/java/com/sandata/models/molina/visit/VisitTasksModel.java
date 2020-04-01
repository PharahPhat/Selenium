package com.sandata.models.molina.visit;

import com.sandata.core.annotation.Column;
import com.sandata.core.annotation.CsvHeader;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

public class VisitTasksModel extends VisitGenericModel {
    @CsvHeader("VisitKey")
    @Column(value = "VisitKey", index = 0)
    private String visitKey;

    @CsvHeader("TaskID")
    @Column(value = "TaskID", index = 1)
    private String taskID;

    @CsvHeader("TaskReading")
    @Column("TaskReading")
    private String taskReading;

    @CsvHeader("TaskRefused")
    @Column("TaskRefused")
    private String taskRefused;

    @CsvHeader("TaskUnit")
    @Column("TaskUnit")
    private String taskUnit;

    @CsvHeader("CallKey")
    @Column("CallKey")
    private String callKey;

    @CsvHeader("RecordUpdatedBy")
    @Column("RecordUpdatedBy")
    private String recordUpdatedBy;

    @CsvHeader("RecordUpdateDateTime")
    @Column("RecordUpdateDateTime")
    private String recordUpdateDateTime;

    public String getVisitKey() {
        return visitKey;
    }

    public void setVisitKey(String visitKey) {
        this.visitKey = visitKey;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskReading() {
        return taskReading;
    }

    public void setTaskReading(String taskReading) {
        this.taskReading = taskReading;
    }

    public String getTaskRefused() {
        return taskRefused;
    }

    public void setTaskRefused(String taskRefused) {
        this.taskRefused = taskRefused;
    }

    public String getTaskUnit() {
        return taskUnit;
    }

    public void setTaskUnit(String taskUnit) {
        this.taskUnit = taskUnit;
    }

    public String getCallKey() {
        return callKey;
    }

    public void setCallKey(String callKey) {
        this.callKey = callKey;
    }

    public String getRecordUpdatedBy() {
        return recordUpdatedBy;
    }

    public void setRecordUpdatedBy(String recordUpdatedBy) {
        this.recordUpdatedBy = recordUpdatedBy;
    }

    public String getRecordUpdateDateTime() {
        return recordUpdateDateTime;
    }

    public void setRecordUpdateDateTime(String recordUpdateDateTime) {
        this.recordUpdateDateTime = recordUpdateDateTime;
    }

    @Override
    public String toString() {
        String toString = "VisitTasksModel{" +
                "visitKey='" + visitKey + '\'' +
                "taskID='" + taskID + '\'' +
                "taskReading='" + taskReading + '\'' +
                "taskRefused='" + taskRefused + '\'' +
                "taskUnit='" + taskUnit + '\'' +
                "callKey='" + callKey + '\'' +
                "recordUpdatedBy='" + recordUpdatedBy + '\'' +
                "recordUpdateDateTime='" + recordUpdateDateTime + '\'' +
                '}';
        return toString.replace("null", "");
    }

    @Override
    public boolean equals(String fileValue, String dbValue) {
        return StringUtils.equalsIgnoreCase(fileValue, dbValue);
    }

    @Override
    public boolean verifyFieldValue(Object obj) {
        VisitTasksModel modelObj = (VisitTasksModel)obj;

        if(!this.getVisitKey().equalsIgnoreCase(modelObj.getVisitKey())) {
            return false;
        }

        if(Integer.parseInt(this.getTaskID()) != Integer.parseInt(modelObj.getTaskID())) {
            return false;
        }

        if(Integer.parseInt(this.getTaskReading()) != Integer.parseInt(modelObj.getTaskReading())) {
            return false;
        }

        if(!this.getTaskRefused().equalsIgnoreCase(modelObj.getTaskRefused())) {
            return false;
        }

        if(this.getTaskUnit() != null && !this.getTaskUnit().isEmpty())
            if(!this.getTaskUnit().equalsIgnoreCase(modelObj.getTaskUnit())) {
                return false;
            }

        if(!this.getCallKey().equalsIgnoreCase(modelObj.getCallKey())) {
            return false;
        }

        if(!this.getRecordUpdatedBy().equalsIgnoreCase(modelObj.getRecordUpdatedBy())) {
            return false;
        }

        if(!this.getRecordUpdateDateTime().equalsIgnoreCase(modelObj.getRecordUpdateDateTime())) {
            return false;
        }

        return true;
    }

    public boolean verifyFormatField(String fieldValue, String regex) {
        if(!fieldValue.equals(null) && !fieldValue.equals(""))
            if(!fieldValue.matches(regex))
                return false;
        return true;
    }

    public boolean verifyFormatFields() {
        if(!this.verifyFormatField(this.visitKey, "^\\w{0,50}$")) return false;
        if(!this.verifyFormatField(this.taskID, "^\\w{0,4}$")) return false;
        if(!this.verifyFormatField(this.taskReading, "^\\w{0,10}$")) return false;
        if(!this.verifyFormatField(this.taskRefused, "^(?:true|false)$")) return false;
        if(!this.verifyFormatField(this.taskUnit, "^.{0,8}$")) return false;
        if(!this.verifyFormatField(this.callKey, "^\\w{0,50}$")) return false;
        if(!this.verifyFormatField(this.recordUpdatedBy, "^\\w{0,100}$")) return false;
        if(!this.verifyFormatField(this.recordUpdateDateTime, "^.{0,20}$")) return false;
        return true;
    }

    public static boolean verifyDataInDbAndCsvCorrectly(List<VisitTasksModel> recordsCsv){
        for (VisitTasksModel recordCsv: recordsCsv){
            if(!recordCsv.verifyFormatFields()) return false;
        }
        return true;
    }

    @Override
    public boolean verifyFieldsNotNull() {
        if (Objects.isNull(visitKey)) {
            return false;
        }
        if (Objects.isNull(taskID)) {
            return false;
        }
        return true;
    }
}
