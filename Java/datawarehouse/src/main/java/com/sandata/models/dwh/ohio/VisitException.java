package com.sandata.models.dwh.ohio;

public class VisitException {
    public String VisitKey;
    public String ExceptionID;
    public String ExceptionName;
    public boolean ExceptionAcknowledged;

    public boolean getDataIsNotNull(){
        return VisitKey != null && ExceptionID != null && ExceptionName != null;
    }
}
