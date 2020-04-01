package com.sandata.models.interfaces.alt_evv_generic.visit;

public class Tasks {
    private String TaskID;
    private String TaskReading;
    private String TaskRefused;

    public String getTaskID() {
        return TaskID;
    }

    public void setTaskID(String taskID) {
        TaskID = taskID;
    }

    public String getTaskReading() {
        return TaskReading;
    }

    public void setTaskReading(String taskReading) {
        TaskReading = taskReading;
    }

    public String getTaskRefused() {
        return TaskRefused;
    }

    public void setTaskRefused(String taskRefused) {
        TaskRefused = taskRefused;
    }
}
