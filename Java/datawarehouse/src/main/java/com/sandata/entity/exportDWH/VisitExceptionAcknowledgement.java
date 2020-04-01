package com.sandata.entity.exportDWH;

public class VisitExceptionAcknowledgement {
    public String ExceptionID;
    public boolean ExceptionAcknowledged;

    public String getExceptionID() {
        return ExceptionID;
    }

    public void setExceptionID(String exceptionID) {
        ExceptionID = exceptionID;
    }

    public boolean isExceptionAcknowledged() {
        return ExceptionAcknowledged;
    }

    public void setExceptionAcknowledged(boolean exceptionAcknowledged) {
        ExceptionAcknowledged = exceptionAcknowledged;
    }
}
