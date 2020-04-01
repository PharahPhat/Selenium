package com.sandata.entity.ohio.visit;

public class VisitException {
    public String VisitKey;
    public String ExceptionID;
    public String ExceptionName;
    public String ExceptionAcknowledged;

    public String getVisitKey() {
        return VisitKey;
    }

    public void setVisitKey(String visitKey) {
        VisitKey = visitKey;
    }

    public String getExceptionID() {
        return ExceptionID;
    }

    public void setExceptionID(String exceptionID) {
        ExceptionID = exceptionID;
    }

    public String getExceptionName() {
        return ExceptionName;
    }

    public void setExceptionName(String exceptionName) {
        ExceptionName = exceptionName;
    }

    public String getExceptionAcknowledged() {
        return ExceptionAcknowledged;
    }

    public void setExceptionAcknowledged(String exceptionAcknowledged) {
        ExceptionAcknowledged = exceptionAcknowledged;
    }
}
