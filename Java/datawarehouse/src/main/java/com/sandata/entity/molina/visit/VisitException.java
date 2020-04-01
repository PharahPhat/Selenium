package com.sandata.entity.molina.visit;

import java.util.List;

public class VisitException {
    public String ReasonCode;
    public String ResolutionCode;
    public String ReasonNote;
    public List<Integer> ExceptionKeys;
    public String VisitKey;
    public String UpdateId;
    public int Ackknowledged;

    public String getReasonCode() {
        return ReasonCode;
    }

    public void setReasonCode(String reasonCode) {
        ReasonCode = reasonCode;
    }

    public String getResolutionCode() {
        return ResolutionCode;
    }

    public void setResolutionCode(String resolutionCode) {
        ResolutionCode = resolutionCode;
    }

    public String getReasonNote() {
        return ReasonNote;
    }

    public void setReasonNote(String reasonNote) {
        ReasonNote = reasonNote;
    }

    public List<Integer> getExceptionKeys() {
        return ExceptionKeys;
    }

    public void setExceptionKeys(List<Integer> exceptionKeys) {
        ExceptionKeys = exceptionKeys;
    }

    public String getVisitKey() {
        return VisitKey;
    }

    public void setVisitKey(String visitKey) {
        VisitKey = visitKey;
    }

    public String getUpdateId() {
        return UpdateId;
    }

    public void setUpdateId(String updateId) {
        UpdateId = updateId;
    }

    public int getAckknowledged() {
        return Ackknowledged;
    }

    public void setAckknowledged(int ackknowledged) {
        Ackknowledged = ackknowledged;
    }
}
